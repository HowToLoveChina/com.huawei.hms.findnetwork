package ae;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.p088ui.uiextend.FixedRatioImageView;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.messagecenter.bean.MessageCenterMsgObj;
import com.huawei.hicloud.messagecenter.bean.SnsAssistantMsg;
import com.huawei.hicloud.messagecenter.bean.SnsAssistantMsgListItem;
import com.huawei.hicloud.messagecenter.constant.MessageAllowListManager;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.messagecenter.manager.MessageCenterReportUtil;
import com.huawei.hicloud.messagecenter.manager.MessageNotificationManager;
import com.huawei.hicloud.messagecenter.richmessage.SnsNotice;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.bean.NotifyAgdParameters;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudMsgNoticeConfigManager;
import com.huawei.hicloud.notification.p106db.bean.MemberShareDetail;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import ge.C9908c;
import ge.C9913h;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p020ap.C1007b;
import p292fn.C9733f;
import p514o9.C11828b;
import p514o9.C11839m;
import p709vj.C13452e;
import sk.C12809f;

/* renamed from: ae.p1 */
/* loaded from: classes3.dex */
public class C0157p1 extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public List<MessageCenterMsgObj> f588d;

    /* renamed from: e */
    public Activity f589e;

    /* renamed from: ae.p1$a */
    public static class a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f590u;

        /* renamed from: v */
        public TextView f591v;

        /* renamed from: w */
        public TextView f592w;

        /* renamed from: x */
        public FixedRatioImageView f593x;

        public a(View view) {
            super(view);
            this.f590u = (TextView) C12809f.m76831d(view, R$id.time_stamp_text);
            this.f591v = (TextView) C12809f.m76831d(view, R$id.img_msg_title);
            this.f592w = (TextView) C12809f.m76831d(view, R$id.img_msg_main_text);
            this.f593x = (FixedRatioImageView) C12809f.m76831d(view, R$id.img_msg_img_view);
        }
    }

    /* renamed from: ae.p1$b */
    public static class b implements View.OnClickListener {

        /* renamed from: a */
        public final Intent f594a;

        /* renamed from: b */
        public final Activity f595b;

        /* renamed from: c */
        public final MessageCenterMsgObj f596c;

        public b(Intent intent, Activity activity, MessageCenterMsgObj messageCenterMsgObj) {
            this.f594a = intent;
            this.f595b = activity;
            this.f596c = messageCenterMsgObj;
        }

        /* renamed from: a */
        public final void m890a(MessageCenterMsgObj messageCenterMsgObj) {
            if (messageCenterMsgObj == null) {
                NotifyLogger.m29914e("MessageListAdapter", "checkAndCancelNotify messageObj is null");
                return;
            }
            int notifyId = messageCenterMsgObj.getNotifyId();
            if (notifyId == 0) {
                NotifyLogger.m29914e("MessageListAdapter", "checkAndCancelNotify notifyId is default 0");
                return;
            }
            NotifyLogger.m29915i("MessageListAdapter", "checkAndCancelNotify, try to clear notify, id: " + notifyId);
            new MessageNotificationManager(C0213f.m1377a()).cancelNotify(notifyId);
        }

        /* renamed from: b */
        public final void m891b(View view, Intent intent) {
            if (!MessageCenterManager.getInstance().checkIntentAvailable(intent)) {
                C0157p1.m880Q();
                NotifyLogger.m29914e("MessageListAdapter", "jumpToTarget error, resolve intent fail");
                return;
            }
            Activity activity = this.f595b;
            if (activity != null) {
                activity.startActivity(intent);
            } else {
                view.getContext().startActivity(intent);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent familyMemberNotifyIntent;
            try {
                if (C0209d.m1226Y0()) {
                    NotifyLogger.m29914e("MessageListAdapter", "click too fast");
                    return;
                }
                boolean zM80829M = C13452e.m80781L().m80829M();
                if (this.f596c.getCheckFamilyMember() == 1 && zM80829M) {
                    familyMemberNotifyIntent = CloudSpaceNotifyUtil.getInstance().getFamilyMemberNotifyIntent();
                    C0157p1.m879H(familyMemberNotifyIntent, this.f596c);
                } else {
                    familyMemberNotifyIntent = null;
                }
                if (MessageAllowListManager.getWebTypeAllowList().contains(this.f596c.getNotifyType())) {
                    this.f594a.putExtra("action_bar_color_hm_os_bg", true);
                    this.f594a.putExtra("is_support_dark_mode", true);
                }
                if (familyMemberNotifyIntent != null) {
                    m891b(view, familyMemberNotifyIntent);
                } else {
                    m891b(view, this.f594a);
                }
                m890a(this.f596c);
                MessageCenterReportUtil.reportMsgClicked(this.f596c);
            } catch (Exception e10) {
                NotifyLogger.m29914e("MessageListAdapter", "msg jump exception: " + e10.toString());
            }
        }
    }

    /* renamed from: ae.p1$c */
    public static class c implements View.OnClickListener {

        /* renamed from: a */
        public final Activity f597a;

        /* renamed from: b */
        public Handler.Callback f598b;

        public c(Activity activity) {
            this.f597a = activity;
        }

        /* renamed from: b */
        public final void m893b(String str) {
            NotifyLogger.m29915i("MessageListAdapter", "MsgIntroductionClickListener, click");
            String string = this.f597a.getString(R$string.backup_read_support);
            PackageManager packageManager = this.f597a.getPackageManager();
            Intent intent = new Intent();
            C0209d.m1302r2(intent, this.f597a.getPackageName());
            intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
            intent.putExtra("url", str);
            intent.putExtra("isEnableJs", true);
            intent.putExtra("title", string);
            intent.putExtra("is_support_orientation", true);
            intent.putExtra("is_support_dark_mode", true);
            if (intent.resolveActivity(packageManager) == null) {
                C11839m.m70688i("MessageListAdapter", "OpenBackupIntroTask, can not jump to findmyphone webview, jump to browser");
                intent = new HiCloudSafeIntent(new Intent());
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                if (intent.resolveActivity(packageManager) == null) {
                    C11839m.m70688i("MessageListAdapter", "OpenBackupIntroTask, can not jump to browser");
                    return;
                }
            }
            NotifyLogger.m29915i("MessageListAdapter", "MsgIntroductionClickListener, startActivity");
            this.f597a.startActivity(intent);
        }

        /* renamed from: c */
        public final /* synthetic */ boolean m894c(Message message) {
            if (message.what != 3215) {
                return false;
            }
            C1007b.m5980s().m6005Y(this.f598b);
            this.f598b = null;
            m893b((String) message.obj);
            return false;
        }

        /* renamed from: d */
        public final void m895d() {
            if (this.f598b == null) {
                this.f598b = new Handler.Callback() { // from class: ae.q1
                    @Override // android.os.Handler.Callback
                    public final boolean handleMessage(Message message) {
                        return this.f613a.m894c(message);
                    }
                };
                C1007b.m5980s().m5994N(this.f598b);
            }
            C1007b.m5980s().m6020k(3215);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f597a == null) {
                NotifyLogger.m29914e("MessageListAdapter", "MsgIntroductionClickListener, mActivity is null");
            } else if (C0209d.m1226Y0()) {
                NotifyLogger.m29914e("MessageListAdapter", "MsgIntroductionClickListener, click too fast");
            } else {
                m895d();
            }
        }
    }

    /* renamed from: ae.p1$d */
    public static class d extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f599u;

        /* renamed from: v */
        public LinearLayout f600v;

        /* renamed from: w */
        public View f601w;

        /* renamed from: x */
        public TextView f602x;

        /* renamed from: y */
        public boolean f603y;

        public d(View view) {
            super(view);
            this.f603y = false;
            this.f599u = (TextView) C12809f.m76831d(view, R$id.time_stamp_text);
            this.f600v = (LinearLayout) C12809f.m76831d(view, R$id.rich_msg_region);
            this.f601w = C12809f.m76831d(view, R$id.divider_line);
            this.f602x = (TextView) C12809f.m76831d(view, R$id.view_more_text);
        }
    }

    /* renamed from: ae.p1$e */
    public static class e extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f604u;

        /* renamed from: v */
        public TextView f605v;

        /* renamed from: w */
        public TextView f606w;

        /* renamed from: x */
        public View f607x;

        /* renamed from: y */
        public TextView f608y;

        public e(View view) {
            super(view);
            this.f604u = (TextView) C12809f.m76831d(view, R$id.time_stamp_text);
            this.f605v = (TextView) C12809f.m76831d(view, R$id.txt_msg_title);
            this.f606w = (TextView) C12809f.m76831d(view, R$id.txt_msg_main_text);
            this.f607x = C12809f.m76831d(view, R$id.divider_line);
            this.f608y = (TextView) C12809f.m76831d(view, R$id.view_more_text);
        }
    }

    public C0157p1(Activity activity, List<MessageCenterMsgObj> list) {
        this.f588d = list;
        this.f589e = activity;
    }

    /* renamed from: G */
    public static void m878G(Intent intent, String str) {
        NotifyAgdParameters notifyAgdParameters;
        if (intent == null) {
            NotifyLogger.m29914e("MessageListAdapter", "addAgdParameter, intent is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e("MessageListAdapter", "addAgdParameter, agdParameters is null");
            return;
        }
        try {
            notifyAgdParameters = (NotifyAgdParameters) new Gson().fromJson(str, NotifyAgdParameters.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e("MessageListAdapter", "addAgdParameter, json exception = " + e10.toString());
            notifyAgdParameters = null;
        }
        if (notifyAgdParameters == null) {
            NotifyLogger.m29914e("MessageListAdapter", "addAgdParameter, parameters is null");
            return;
        }
        intent.putExtra("agd_resource_enable", notifyAgdParameters.getEnabled());
        intent.putExtra("agd_resource_slot_id", notifyAgdParameters.getSlotId());
        intent.putExtra("pps_threshold", notifyAgdParameters.getThreshold());
    }

    /* renamed from: H */
    public static void m879H(Intent intent, MessageCenterMsgObj messageCenterMsgObj) {
        if (intent == null) {
            NotifyLogger.m29914e("MessageListAdapter", "addMemberShareDetail, intent is null");
            return;
        }
        if (messageCenterMsgObj == null) {
            NotifyLogger.m29914e("MessageListAdapter", "addMemberShareDetail, msgObj is null");
            return;
        }
        String memberShareDetail = messageCenterMsgObj.getMemberShareDetail();
        if (TextUtils.isEmpty(memberShareDetail)) {
            NotifyLogger.m29914e("MessageListAdapter", "addMemberShareDetail, memberShareDetailStr is null");
            return;
        }
        try {
            MemberShareDetail memberShareDetail2 = (MemberShareDetail) new Gson().fromJson(memberShareDetail, MemberShareDetail.class);
            if (memberShareDetail2 == null) {
                NotifyLogger.m29914e("MessageListAdapter", "addMemberShareDetail, memberShareDetail is null");
            } else {
                intent.putExtra(FamilyShareConstants.NOTIFY_MEMBER_SHARE_DETAIL, memberShareDetail2);
            }
        } catch (JsonSyntaxException e10) {
            NotifyLogger.m29914e("MessageListAdapter", "addMemberShareDetail, json exception is: " + e10.getMessage());
        }
    }

    /* renamed from: Q */
    public static void m880Q() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e("MessageListAdapter", "showAppNotInstallToast, context is null");
        } else {
            Toast.makeText(contextM1377a.getApplicationContext(), contextM1377a.getString(R$string.no_app_toast), 0).show();
        }
    }

    /* renamed from: I */
    public final void m881I(Intent intent, MessageCenterMsgObj messageCenterMsgObj) {
        if (intent == null) {
            NotifyLogger.m29914e("MessageListAdapter", "addRecommendData, intent is null");
            return;
        }
        if (messageCenterMsgObj == null) {
            NotifyLogger.m29914e("MessageListAdapter", "addRecommendData, msgObj is null");
            return;
        }
        String recommendNeedData = messageCenterMsgObj.getRecommendNeedData();
        if (TextUtils.isEmpty(recommendNeedData)) {
            NotifyLogger.m29914e("MessageListAdapter", "addRecommendData, recommendDataStr is null");
            return;
        }
        try {
            RecommendNeedData recommendNeedData2 = (RecommendNeedData) new Gson().fromJson(recommendNeedData, RecommendNeedData.class);
            if (recommendNeedData2 == null) {
                NotifyLogger.m29914e("MessageListAdapter", "addRecommendData, recommendNeedData is null");
            } else {
                intent.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData2);
            }
        } catch (JsonSyntaxException e10) {
            NotifyLogger.m29914e("MessageListAdapter", "addRecommendData, json exception is: " + e10.toString());
        }
    }

    /* renamed from: J */
    public final void m882J(a aVar, MessageCenterMsgObj messageCenterMsgObj) {
        m888P(aVar.f590u, messageCenterMsgObj.getNotifyTime());
        aVar.f591v.setText(messageCenterMsgObj.getTitleText());
        aVar.f592w.setText(messageCenterMsgObj.getMainText());
        aVar.f593x.setMode(1);
        new C11828b(HiCloudMsgNoticeConfigManager.getInstance().getPictureCacheFolder()).m70491g(messageCenterMsgObj.getPictureUrl(), null, aVar.f593x);
        String msgGotoType = messageCenterMsgObj.getMsgGotoType();
        String msgGotoUri = messageCenterMsgObj.getMsgGotoUri();
        if (NotifyConstants.HICLOUD_DLAPP.equals(msgGotoType)) {
            msgGotoUri = NoticeWithActivityUtil.addLanguageType(msgGotoUri);
        }
        Intent commonGotoIntent = GeneralRedirectUtil.getCommonGotoIntent(msgGotoType, msgGotoUri, false);
        String agdParameters = messageCenterMsgObj.getAgdParameters();
        if (NotifyConstants.HICLOUD_DLAPP.equals(msgGotoType)) {
            m878G(commonGotoIntent, agdParameters);
        }
        if (commonGotoIntent != null) {
            int iM887O = m887O(messageCenterMsgObj.getNotifyId());
            if (iM887O >= 0) {
                commonGotoIntent.putExtra("user_operation_text", messageCenterMsgObj.getTitleText());
                commonGotoIntent.putExtra("action_type", String.valueOf(iM887O));
                commonGotoIntent.putExtra("user_operation_type", "messageCenter");
            }
            aVar.f4327a.setOnClickListener(new b(commonGotoIntent, this.f589e, messageCenterMsgObj));
        }
    }

    /* renamed from: K */
    public final void m883K(d dVar, MessageCenterMsgObj messageCenterMsgObj) {
        List<SnsAssistantMsgListItem> message;
        SnsAssistantMsgListItem snsAssistantMsgListItem;
        if (dVar.f603y) {
            return;
        }
        try {
            SnsAssistantMsg snsAssistantMsg = (SnsAssistantMsg) new Gson().fromJson(messageCenterMsgObj.getRichMsgContent(), SnsAssistantMsg.class);
            if (snsAssistantMsg == null || (message = snsAssistantMsg.getMessage()) == null || message.isEmpty() || (snsAssistantMsgListItem = message.get(0)) == null) {
                return;
            }
            View view = new SnsNotice(snsAssistantMsgListItem.getContent()).getView(dVar.f4327a.getContext());
            if (view != null) {
                dVar.f600v.addView(view, new LinearLayout.LayoutParams(-1, -2));
            }
            m888P(dVar.f599u, messageCenterMsgObj.getNotifyTime());
            dVar.f603y = true;
            String url = snsAssistantMsgListItem.getUrl();
            if (TextUtils.isEmpty(url)) {
                dVar.f601w.setVisibility(8);
                dVar.f602x.setVisibility(8);
                return;
            }
            Intent commonGotoIntent = GeneralRedirectUtil.getCommonGotoIntent(NotifyConstants.TYPE_DEEPLINK, url, false);
            if (commonGotoIntent == null) {
                dVar.f601w.setVisibility(8);
                dVar.f602x.setVisibility(8);
                return;
            }
            int iM887O = m887O(messageCenterMsgObj.getNotifyId());
            if (iM887O >= 0) {
                commonGotoIntent.putExtra("user_operation_text", messageCenterMsgObj.getTitleText());
                commonGotoIntent.putExtra("action_type", String.valueOf(iM887O));
                commonGotoIntent.putExtra("user_operation_type", "messageCenter");
            }
            dVar.f601w.setVisibility(0);
            dVar.f602x.setVisibility(0);
            if (TextUtils.isEmpty(snsAssistantMsgListItem.getButton())) {
                dVar.f602x.setText(dVar.f4327a.getContext().getString(R$string.view_details));
            } else {
                dVar.f602x.setText(snsAssistantMsgListItem.getButton());
            }
            dVar.f4327a.setOnClickListener(new b(commonGotoIntent, this.f589e, messageCenterMsgObj));
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("MessageListAdapter", "buildTxtMsgViewHolder, json exception is: " + e10.toString());
        }
    }

    /* renamed from: L */
    public final void m884L(e eVar, MessageCenterMsgObj messageCenterMsgObj) {
        m888P(eVar.f604u, messageCenterMsgObj.getNotifyTime());
        eVar.f605v.setText(messageCenterMsgObj.getTitleText());
        eVar.f606w.setText(messageCenterMsgObj.getMainText());
        String category = messageCenterMsgObj.getCategory();
        if (!TextUtils.isEmpty(category) && "local_sync_backup".equals(category)) {
            if (TextUtils.isEmpty(messageCenterMsgObj.getIntroductionH5Url())) {
                C11839m.m70687e("MessageListAdapter", "buildTxtMsgViewHolder, introductionH5Url is null.");
                eVar.f607x.setVisibility(8);
                eVar.f608y.setVisibility(8);
                return;
            } else {
                eVar.f607x.setVisibility(0);
                eVar.f608y.setVisibility(0);
                eVar.f608y.setText(this.f589e.getString(R$string.backup_read_support));
                eVar.f4327a.setOnClickListener(new c(this.f589e));
                return;
            }
        }
        String msgGotoType = messageCenterMsgObj.getMsgGotoType();
        String msgGotoUri = messageCenterMsgObj.getMsgGotoUri();
        if (NotifyConstants.HICLOUD_DLAPP.equals(msgGotoType)) {
            msgGotoUri = NoticeWithActivityUtil.addLanguageType(msgGotoUri);
        }
        String agdParameters = messageCenterMsgObj.getAgdParameters();
        String gotoDeeplinkUri = messageCenterMsgObj.getGotoDeeplinkUri();
        Intent commonGotoIntent = !TextUtils.isEmpty(gotoDeeplinkUri) ? NotifyUtil.geteFinalDeepLinkIntent(gotoDeeplinkUri, messageCenterMsgObj.getTotalNeedSpace()) : GeneralRedirectUtil.getCommonGotoIntent(msgGotoType, msgGotoUri, false);
        if ("detail".equals(msgGotoType)) {
            m881I(commonGotoIntent, messageCenterMsgObj);
        }
        if (NotifyConstants.HICLOUD_DLAPP.equals(msgGotoType)) {
            m878G(commonGotoIntent, agdParameters);
        }
        if (commonGotoIntent == null) {
            eVar.f607x.setVisibility(8);
            eVar.f608y.setVisibility(8);
        } else {
            int iM887O = m887O(messageCenterMsgObj.getNotifyId());
            if (iM887O >= 0) {
                commonGotoIntent.putExtra("user_operation_text", messageCenterMsgObj.getTitleText());
                commonGotoIntent.putExtra("action_type", String.valueOf(iM887O));
                commonGotoIntent.putExtra("user_operation_type", "messageCenter");
            }
            eVar.f607x.setVisibility(0);
            eVar.f608y.setVisibility(0);
            eVar.f4327a.setOnClickListener(new b(commonGotoIntent, this.f589e, messageCenterMsgObj));
        }
        if (messageCenterMsgObj.getUniqueId().equals(C13452e.m80781L().m80818J())) {
            eVar.f608y.setVisibility(0);
            eVar.f607x.setVisibility(0);
            eVar.f4327a.setOnClickListener(new View.OnClickListener() { // from class: ae.o1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f567a.m886N(view);
                }
            });
        }
    }

    /* renamed from: M */
    public final int m885M() {
        return 68113;
    }

    /* renamed from: N */
    public final /* synthetic */ void m886N(View view) {
        C9913h.m61574q().m61600x(this.f589e);
        if (C0209d.m1269j1() && C9733f.m60705z().m60721P()) {
            C9908c.m61499D().m61522H(true);
        } else {
            C9913h.m61574q().m61589P(false);
        }
    }

    /* renamed from: O */
    public final int m887O(int i10) {
        C11839m.m70688i("MessageListAdapter", "notifyId " + i10);
        if (i10 == 776) {
            return 8;
        }
        switch (i10) {
            case 790:
                return 12;
            case 791:
                return 13;
            case 792:
                return 14;
            default:
                return -1;
        }
    }

    /* renamed from: P */
    public final void m888P(TextView textView, long j10) {
        textView.setText(DateUtils.formatDateTime(C0213f.m1377a(), j10, m885M()));
    }

    /* renamed from: R */
    public void m889R(List<MessageCenterMsgObj> list) {
        this.f588d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f588d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        String msgType = this.f588d.get(i10).getMsgType();
        if ("richMsg".equals(msgType)) {
            return 2;
        }
        return "imgMsg".equals(msgType) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        MessageCenterMsgObj messageCenterMsgObj = this.f588d.get(i10);
        if (messageCenterMsgObj == null) {
            NotifyLogger.m29914e("MessageListAdapter", "onBindViewHolder, msg obj is null");
            return;
        }
        if (abstractC0833c0 instanceof d) {
            m883K((d) abstractC0833c0, messageCenterMsgObj);
        } else if (abstractC0833c0 instanceof a) {
            m882J((a) abstractC0833c0, messageCenterMsgObj);
        } else if (abstractC0833c0 instanceof e) {
            m884L((e) abstractC0833c0, messageCenterMsgObj);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return i10 == 2 ? new d(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.rich_msg_item_layout, viewGroup, false)) : i10 == 1 ? new a(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.img_msg_item_layout, viewGroup, false)) : new e(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.txt_msg_item_layout, viewGroup, false));
    }
}
