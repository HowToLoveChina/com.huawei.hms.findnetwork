package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.ActionBar;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import be.C1170f;
import be.C1172h;
import ca.C1400c;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupNotificationV5Util;
import com.huawei.android.hicloud.cloudspace.bean.SpaceNoticeEntrance;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.GradePackageCardView;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.TipCommonView;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.android.hicloud.task.simple.C3024d2;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$menu;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.ReportVoucherInfo;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Manager;
import com.huawei.hicloud.notification.manager.ExtraNoticeConfigManager;
import com.huawei.hicloud.notification.manager.GuideH5ReportUtil;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetailGoto;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.RecommendTipData;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import dj.C9158a;
import id.C10469c;
import id.C10470d;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0234s;
import p054cj.C1442a;
import p222da.C9060d;
import p336he.C10152c;
import p341hj.C10221d1;
import p341hj.C10257p1;
import p364ib.C10465b;
import p450le.C11272a;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p550pb.C12126b;
import p616rk.C12515a;
import p664u0.C13108a;
import p674ub.C13149f;
import p684un.C13222a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudSpaceGuideActivity extends BuyPackageBaseActivity implements View.OnClickListener, GradePackageCardView.SendMessageCommunicator {

    /* renamed from: A1 */
    public BannerConfigReceiver f16762A1;

    /* renamed from: B1 */
    public ActionBar f16763B1;

    /* renamed from: C1 */
    public int f16764C1;

    /* renamed from: D1 */
    public int f16765D1;

    /* renamed from: F1 */
    public List<SpaceNoticeEntrance> f16767F1;

    /* renamed from: J1 */
    public String f16771J1;

    /* renamed from: K1 */
    public String f16772K1;

    /* renamed from: L1 */
    public TipCommonView f16773L1;

    /* renamed from: M1 */
    public View f16774M1;

    /* renamed from: N1 */
    public ImageView f16775N1;

    /* renamed from: h1 */
    public RecommendNeedData f16778h1;

    /* renamed from: i1 */
    public RecommendTipData f16779i1;

    /* renamed from: j1 */
    public NotchTopFitRelativeLayout f16780j1;

    /* renamed from: k1 */
    public RelativeLayout f16781k1;

    /* renamed from: l1 */
    public View f16782l1;

    /* renamed from: m1 */
    public View f16783m1;

    /* renamed from: n1 */
    public View f16784n1;

    /* renamed from: o1 */
    public View f16785o1;

    /* renamed from: p1 */
    public View f16786p1;

    /* renamed from: q1 */
    public AutoSizeButton f16787q1;

    /* renamed from: r1 */
    public TextView f16788r1;

    /* renamed from: s1 */
    public TextView f16789s1;

    /* renamed from: t1 */
    public RecyclerView f16790t1;

    /* renamed from: u1 */
    public C1170f f16791u1;

    /* renamed from: v1 */
    public HiCloudExceptionView f16792v1;

    /* renamed from: w1 */
    public LinearLayout f16793w1;

    /* renamed from: x1 */
    public RelativeLayout f16794x1;

    /* renamed from: y1 */
    public RecyclerView f16795y1;

    /* renamed from: z1 */
    public C1172h f16796z1;

    /* renamed from: E1 */
    public boolean f16766E1 = false;

    /* renamed from: G1 */
    public boolean f16768G1 = false;

    /* renamed from: H1 */
    public boolean f16769H1 = false;

    /* renamed from: I1 */
    public boolean f16770I1 = false;

    /* renamed from: O1 */
    public Handler f16776O1 = new HandlerC3604a();

    /* renamed from: P1 */
    public boolean f16777P1 = false;

    public class BannerConfigReceiver extends BroadcastReceiver {
        public BannerConfigReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = new HiCloudSafeIntent(intent).getAction();
            if (action != null) {
                if (!action.equals("com.huawei.android.hicloud.HICLOUDACTIVE_REFRESH_VIEW")) {
                    if (action.equals("com.huawei.android.hicloud.GUIDE_REMOVE_CAMPAIGNE_NTRANCE")) {
                        C1442a.m8290i("CloudSpaceGuideActivity", "receive GUIDE_REMOVE_CAMPAIGNE_NTRANCE");
                        CloudSpaceGuideActivity.this.m23201m6();
                        return;
                    }
                    return;
                }
                if (CloudSpaceGuideActivity.this.f16778h1 == null) {
                    C1442a.m8289e("CloudSpaceGuideActivity", "receive HICLOUDACTIVE_REFRESH_VIEW, recommendNeedData is null.");
                } else {
                    if ("family_share".equals(CloudSpaceGuideActivity.this.f16778h1.getRecommendType())) {
                        return;
                    }
                    C1442a.m8288d("CloudSpaceGuideActivity", "receive broadcast, not family share, check campaign");
                    CloudSpaceGuideActivity.this.m23165Q5();
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceGuideActivity$a */
    public class HandlerC3604a extends Handler {
        public HandlerC3604a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                C1442a.m8289e("CloudSpaceGuideActivity", "msg is null");
                return;
            }
            Object obj = message.obj;
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            int i10 = message.what;
            if (i10 == 7014) {
                CloudSpaceGuideActivity.this.m23176F6(iIntValue);
            } else if (i10 != 7015) {
                CloudSpaceGuideActivity.this.f16770I1 = false;
                CloudSpaceGuideActivity.this.m23200l6();
            } else {
                CloudSpaceGuideActivity.this.f16770I1 = true;
                CloudSpaceGuideActivity.this.m23200l6();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceGuideActivity$b */
    public class ViewTreeObserverOnPreDrawListenerC3605b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        public final /* synthetic */ TextView f16799a;

        public ViewTreeObserverOnPreDrawListenerC3605b(TextView textView) {
            this.f16799a = textView;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (C11842p.m70771U0() || C11842p.m70753O0(C0213f.m1377a()) || C11842p.m70747M0(C0213f.m1377a())) {
                this.f16799a.setGravity(17);
                return true;
            }
            this.f16799a.setGravity(8388611);
            return true;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceGuideActivity$c */
    public class ViewOnClickListenerC3606c implements View.OnClickListener {
        public ViewOnClickListenerC3606c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CloudSpaceGuideActivity.this.f16773L1 != null) {
                CloudSpaceGuideActivity.this.f16773L1.dismiss();
            }
            CloudSpaceGuideActivity cloudSpaceGuideActivity = CloudSpaceGuideActivity.this;
            cloudSpaceGuideActivity.f16501C0 = true;
            cloudSpaceGuideActivity.m22869r4("cloudbackup_space_unenough_detail_click_help");
            CloudSpaceGuideActivity.this.m23178H6();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceGuideActivity$d */
    public class C3607d extends RecyclerView.AbstractC0845o {

        /* renamed from: h0 */
        public int f16801h0;

        public C3607d(int i10) {
            this.f16801h0 = i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
            super.getItemOffsets(rect, view, recyclerView, c0856z);
            if (recyclerView == null || c0856z == null) {
                C1442a.m8291w("CloudSpaceGuideActivity", "parent or state is null.");
            } else if (recyclerView.getChildAdapterPosition(view) != c0856z.m5305b() - 1) {
                rect.bottom = this.f16801h0;
            }
        }
    }

    /* renamed from: A6 */
    private void m23155A6(String str) {
        if (str == null) {
            C1442a.m8291w("CloudSpaceGuideActivity", "showAgreement url is null.");
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        PackageManager packageManager = getPackageManager();
        if (packageManager == null || intent.resolveActivity(packageManager) == null) {
            return;
        }
        startActivity(intent);
    }

    /* renamed from: B6 */
    private void m23156B6() {
        this.f16786p1.setVisibility(0);
        this.f16784n1.setVisibility(8);
        this.f16785o1.setVisibility(8);
        this.f16783m1.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q5 */
    public void m23165Q5() {
        if (C11829c.m70530L0()) {
            m22750C3(3);
        } else {
            C11839m.m70689w("CloudSpaceGuideActivity", "not support activity");
        }
    }

    /* renamed from: a6 */
    private void m23166a6() {
        C1442a.m8290i("CloudSpaceGuideActivity", "initBroadcastReceiver");
        if (this.f16762A1 == null) {
            this.f16762A1 = new BannerConfigReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.HICLOUDACTIVE_REFRESH_VIEW");
            intentFilter.addAction("com.huawei.android.hicloud.GUIDE_REMOVE_CAMPAIGNE_NTRANCE");
            C13108a.m78878b(this).m78880c(this.f16762A1, intentFilter);
        }
    }

    /* renamed from: e6 */
    private void m23167e6() {
        this.f16780j1 = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f16781k1 = (RelativeLayout) C12809f.m76829b(this, R$id.cloud_space_guid_title_outer_frame);
        this.f16782l1 = C12809f.m76829b(this, R$id.notch_fit_load_view);
        this.f16783m1 = C12809f.m76829b(this, R$id.cloud_space_guide_main_layout);
        this.f16784n1 = C12809f.m76829b(this, R$id.layout_loading);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nodata);
        this.f16785o1 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        View viewM76829b2 = C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f16786p1 = viewM76829b2;
        viewM76829b2.setOnClickListener(this);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f16787q1 = autoSizeButton;
        C11842p.m70874v1(this, autoSizeButton);
        this.f16787q1.setOnClickListener(this);
        this.f16790t1 = (RecyclerView) C12809f.m76829b(this, R$id.recommend_card_recyclerview);
        this.f16788r1 = (TextView) C12809f.m76829b(this, R$id.cloud_space_guide_title);
        this.f16794x1 = (RelativeLayout) C12809f.m76829b(this, R$id.cloud_space_guide_title_frame);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.cloud_space_guide_main_text);
        this.f16789s1 = textView;
        m23171y6(textView);
        this.f16792v1 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.more_plan);
        this.f16793w1 = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f16795y1 = (RecyclerView) C12809f.m76829b(this, R$id.recommend_page_entrance);
        mo23770l1();
        m23170v6();
    }

    /* renamed from: g6 */
    private void m23168g6() throws JSONException {
        RecommendNeedData recommendNeedData = this.f16778h1;
        if (recommendNeedData == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "jumptoUpgradeActivity recommendNeedData is null.");
            finish();
            return;
        }
        if (NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT.equals(recommendNeedData.getRecommendType())) {
            JSONObject jSONObjectM79464f = C13222a.m79464f(this, "DYNAMIC_NOTIFY_CLICK", "1", C13452e.m80781L().m80971t0(), "4");
            try {
                jSONObjectM79464f.put("notify_id", this.f16778h1.getId());
                jSONObjectM79464f.put("notify_type", "1");
                jSONObjectM79464f.put("click_upgrade_cloudSpace", true);
            } catch (JSONException e10) {
                C1442a.m8289e("CloudSpaceGuideActivity", "ERROR OCCUR:" + e10.getMessage());
            }
            C13227f.m79492i1().m79602z(jSONObjectM79464f);
            UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_CLICK", "4", "9", jSONObjectM79464f);
            C12515a.m75110o().m75165a1(C10469c.m64350p(this));
            C12515a.m75110o().m75165a1(C10470d.m64355p(this));
            C10469c.m64350p(this).cancel();
            C10470d.m64355p(this).cancel();
            ScreenListener.m18023c(this).m18028g();
            try {
                startActivity(m23183S5());
            } catch (ActivityNotFoundException e11) {
                C1442a.m8289e("CloudSpaceGuideActivity", "jumptoUpgradeActivity error:" + e11.toString());
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("nav_source", this.f21455p);
            bundle.putInt("nav_trace_id", this.f21456q);
            bundle.putString("nav_operation_path", this.f21458s);
            if ("family_share".equals(this.f16778h1.getRecommendType())) {
                bundle.putBoolean("family_share", true);
                bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f16764C1);
                bundle.putInt(FamilyShareConstants.EXTRA_KEY, this.f16765D1);
                bundle.putString("channel_refer", "2");
                C11272a.m67645e(this, bundle);
            } else {
                C12126b.m72707c("2", bundle);
            }
        }
        C13227f.m79492i1().m79585f0("mecloud_cloudspacetips_upgrade", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_cloudspacetips_upgrade", "1", "30");
        finish();
    }

    /* renamed from: s6 */
    private void m23169s6() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Resources resources = getResources();
        if (resources != null) {
            int color = resources.getColor(R$color.pay_activity_harmony_bg);
            C0209d.m1306s2(this.f16763B1, this, color);
            Window window = getWindow();
            if (window != null) {
                window.setStatusBarColor(color);
            }
        }
    }

    /* renamed from: v6 */
    private void m23170v6() {
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_nonet_icon));
        C11842p.m70760Q1(this, this.f16784n1);
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_no_service_icon));
    }

    /* renamed from: y6 */
    public static void m23171y6(TextView textView) {
        if (textView == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "setTextViewGravity tv is null.");
        } else {
            textView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC3605b(textView));
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: B1 */
    public void mo19444B1() {
        m28577K1(540, this.f16781k1);
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: C */
    public void mo23172C() {
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: C1 */
    public void mo19445C1() {
        m28577K1(472, this.f16781k1);
    }

    /* renamed from: C6 */
    public final void m23173C6() {
        RecommendNeedData recommendNeedData = this.f16778h1;
        if (recommendNeedData == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "showRecommendEntranceList recommendNeedData is null.");
            return;
        }
        if (recommendNeedData.isV5BackupNotEnoughDialog()) {
            this.f16778h1.getDetailGotoBeanList();
            m23175E6(this.f16778h1.getDetailGotoBeanList());
        } else if (this.f16778h1.isFormWithActivity()) {
            m23199k6();
        } else {
            m23198j6();
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: D1 */
    public void mo19446D1() {
        Intent intent = new Intent();
        intent.setAction("android.settings.WIRELESS_SETTINGS");
        intent.putExtra("use_emui_ui", true);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            C1442a.m8289e("CloudSpaceGuideActivity", "startActivity: setNet failed");
        }
    }

    /* renamed from: D6 */
    public final void m23174D6(ChannelInfo channelInfo) {
        RecommendNeedData recommendNeedData = this.f16778h1;
        if (recommendNeedData == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "showRecommendEntranceList recommendNeedData is null.");
            return;
        }
        String recommendType = recommendNeedData.getRecommendType();
        List<NoticeDetailGoto> arrayList = new ArrayList<>();
        NoticeDetail noticeDetail = new NoticeDetail();
        int id2 = this.f16778h1.getId();
        List<ExtraNotificationBean> extraNotificationBeanList = UserSpaceUtil.getExtraNotificationBeanList();
        if (extraNotificationBeanList != null && extraNotificationBeanList.size() > 0) {
            for (ExtraNotificationBean extraNotificationBean : extraNotificationBeanList) {
                if (extraNotificationBean != null) {
                    int id3 = extraNotificationBean.getId();
                    if (recommendType.equals(extraNotificationBean.getNoticeType()) && id2 == id3) {
                        arrayList = extraNotificationBean.getDetailGoto();
                        noticeDetail = extraNotificationBean.getNoticeDetail();
                    }
                }
            }
        }
        m23212x6(noticeDetail, arrayList, channelInfo);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: E1 */
    public void mo19447E1() {
        m28577K1(ErrorCode.ERROR_SIGTOOL_FAIL, this.f16781k1);
    }

    /* renamed from: E6 */
    public final void m23175E6(List<NoticeDetailGoto> list) {
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("CloudSpaceGuideActivity", "detailGotoList is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (NoticeDetailGoto noticeDetailGoto : list) {
            SpaceNoticeEntrance spaceNoticeEntrance = new SpaceNoticeEntrance();
            spaceNoticeEntrance.setLinkConent(BackupSpaceInsuffNoticeV5Manager.getInstance().getStringFromDB(noticeDetailGoto.getName()));
            spaceNoticeEntrance.setType(noticeDetailGoto.getType());
            spaceNoticeEntrance.setUri(noticeDetailGoto.getUri());
            if (!NotifyConstants.HICLOUD_DLAPP.equals(noticeDetailGoto.getUri())) {
                arrayList.add(spaceNoticeEntrance);
            } else if (TextUtils.isEmpty(this.f16571r0)) {
                C1442a.m8289e("CloudSpaceGuideActivity", "showV5RecommendEntrance mH5JumpUrl is emtpy.");
            } else {
                spaceNoticeEntrance.setH5JumpUrl(this.f16571r0);
                arrayList.add(spaceNoticeEntrance);
            }
        }
        C1172h c1172h = new C1172h(this, "hidisk_recommend_type", arrayList);
        this.f16796z1 = c1172h;
        this.f16795y1.setAdapter(c1172h);
        this.f16795y1.setLayoutManager(new LinearLayoutManager(this));
        if (this.f16768G1 || this.f16769H1) {
            m23200l6();
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: F1 */
    public void mo19448F1() {
        m28577K1(466, this.f16781k1);
    }

    /* renamed from: F6 */
    public final void m23176F6(final int i10) {
        AdParametersExt adParametersExt = this.f16575v0;
        if (adParametersExt == null || !adParametersExt.isRequestAgdResource(0, null)) {
            this.f16770I1 = false;
            m23200l6();
        } else {
            C12515a.m75110o().m75175e(new C10221d1(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.m
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f17557a.m23195h6(i10, (List) obj);
                }
            }, this.f16575v0.getAgdAdid()), false);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: G1 */
    public void mo19449G1() {
        m28577K1(472, this.f16781k1);
    }

    /* renamed from: G6 */
    public void m23177G6() {
        if (this.f16762A1 != null) {
            C13108a.m78878b(this).m78883f(this.f16762A1);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: H1 */
    public void mo19450H1() {
        m28576J1(this.f16781k1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) throws JSONException {
        C1442a.m8290i("CloudSpaceGuideActivity", "getSpaceInfo");
        C9158a.m57503F().m57518P(this.f16524O, this.f21448i);
        C9158a.m57503F().m57505B(this.f16524O, this.f21448i, false);
        C9158a.m57503F().m57517O(this.f16524O, this.f21448i, false, true, "CloudSpaceGuideActivity");
        RecommendNeedData recommendNeedData = this.f16778h1;
        if (recommendNeedData == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "getSpaceInfo recommendNeedData is null.");
            m23190Z5();
        } else {
            if ("family_share".equals(recommendNeedData.getRecommendType())) {
                return;
            }
            m23186V5();
            C1442a.m8288d("CloudSpaceGuideActivity", "get space info, not family share, check campaign");
            m23165Q5();
            HiCloudAllOMConfigManager.getInstance().queryConfigAsync("HiCloudActives");
        }
    }

    /* renamed from: H6 */
    public final void m23178H6() {
        RecommendTipData recommendTipData = this.f16779i1;
        if (recommendTipData == null) {
            C11839m.m70687e("CloudSpaceGuideActivity", "recommendTipData is null help not display");
            return;
        }
        if (TextUtils.isEmpty(recommendTipData.getHelpUrl())) {
            C11839m.m70687e("CloudSpaceGuideActivity", "help url is null");
            return;
        }
        Intent intent = new Intent(this, (Class<?>) OperationWebViewActivity.class);
        intent.putExtra("srcChannel", true);
        intent.putExtra("is_activity_need_back_to_main", false);
        intent.putExtra("url", this.f16779i1.getHelpUrl());
        intent.putExtra("salChannel", true);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("launch_web_type", 5);
        RecommendNeedData recommendNeedData = this.f16778h1;
        if (recommendNeedData != null && recommendNeedData.getRecommendType().equals(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT)) {
            intent.putExtra("backUpTime", String.valueOf(C2783d.m16190y()));
            long backupNeedSpace = this.f16778h1.getBackupNeedSpace();
            long notUsedSpace = this.f16778h1.getNotUsedSpace();
            if (notUsedSpace < 0) {
                notUsedSpace = 0;
            }
            String strM1524g = C0223k.m1524g(this, backupNeedSpace);
            String strM1524g2 = C0223k.m1524g(this, notUsedSpace);
            intent.putExtra("needSpace", strM1524g);
            intent.putExtra("nowSpace", strM1524g2);
            intent.putExtra("drawCloudSpace", String.valueOf(this.f16770I1));
        }
        try {
            startActivity(intent);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceGuideActivity", "startActivity exception: " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: L2 */
    public void mo22779L2(int i10) throws JSONException {
        C1442a.m8289e("CloudSpaceGuideActivity", "dealCreateOrderErr code = " + i10);
        m22793Q4(null, null);
        if (i10 == 56 || i10 == 106 || i10 == 120) {
            super.mo22779L2(i10);
        } else {
            m23190Z5();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: O3 */
    public void mo19452O3(Message message) {
        m23192c6();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: O4 */
    public void mo19453O4(int i10, Intent intent) throws JSONException {
        super.mo19453O4(i10, intent);
        if (i10 == 10002) {
            RecommendNeedData recommendNeedData = this.f16778h1;
            if (recommendNeedData == null) {
                C1442a.m8289e("CloudSpaceGuideActivity", "handleErrorScene recommendNeedDacputa is null.");
                finish();
            } else {
                if (!"family_share".equals(recommendNeedData.getRecommendType())) {
                    m23168g6();
                    return;
                }
                C1442a.m8290i("CloudSpaceGuideActivity", "handleErrorScene family share finish.");
                setResult(103);
                m23189Y5();
                finish();
            }
        }
    }

    /* renamed from: O5 */
    public final List<SpaceNoticeEntrance> m23179O5(boolean z10) {
        ArrayList arrayList = new ArrayList();
        List<SpaceNoticeEntrance> list = this.f16767F1;
        if (list == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "removeCampaignEntrance mEntrances null");
            return arrayList;
        }
        for (SpaceNoticeEntrance spaceNoticeEntrance : list) {
            String uri = spaceNoticeEntrance.getUri();
            if (!TextUtils.isEmpty(uri)) {
                if (NotifyConstants.HICLOUD_DLAPP.equals(uri)) {
                    if (z10) {
                        spaceNoticeEntrance.setVisiable(true);
                        spaceNoticeEntrance.setH5JumpUrl(this.f16571r0);
                        spaceNoticeEntrance.setLinkConent(m23182R5(this.f16570q0));
                        m23202n6();
                    } else {
                        spaceNoticeEntrance.setVisiable(false);
                    }
                }
                if (spaceNoticeEntrance.isVisiable()) {
                    arrayList.add(spaceNoticeEntrance);
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: P */
    public void mo23180P(CloudPackage cloudPackage, PackageGrades packageGrades, List<Voucher> list, ReportVoucherInfo reportVoucherInfo, ConfirmRenewAgreementDialog.AgreementDlgCallback agreementDlgCallback) {
        m22820a5(m22848m2(cloudPackage, packageGrades, list, reportVoucherInfo, agreementDlgCallback));
    }

    /* renamed from: P5 */
    public final void m23181P5() throws JSONException {
        if (NotifyConstants.THRID_APP_SPACE_INSUFFICIENT.equals(this.f16778h1.getRecommendType())) {
            finish();
        } else {
            m23190Z5();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: Q2 */
    public void mo19455Q2(int i10) throws JSONException {
        C1442a.m8289e("CloudSpaceGuideActivity", "errCode = " + i10);
        if (NotifyConstants.THRID_APP_SPACE_INSUFFICIENT.equals(this.f16778h1.getRecommendType())) {
            finish();
        } else {
            m23190Z5();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: Q3 */
    public void mo22792Q3(String str) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("CloudSpaceGuideActivity", "handleMouthAgreement host is null");
            return;
        }
        m23155A6(str + "/payagreement?lang=" + C0234s.m1627e());
        m23203o6();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: R2 */
    public void mo19456R2(Object obj) throws JSONException, Resources.NotFoundException {
        if (!(obj instanceof GetAvailableGradePackagesResp)) {
            C1442a.m8289e("CloudSpaceGuideActivity", "dealGetAvailableGradePackagesSuccess obj is invalid");
            m23190Z5();
            return;
        }
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleRespBuildSpaceRuleResp = BackupNotificationV5Util.buildSpaceRuleResp((GetAvailableGradePackagesResp) obj);
        if (getPackagesBySpaceRuleRespBuildSpaceRuleResp == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "getPackagesBySpaceRuleResp is null.");
            m23190Z5();
            return;
        }
        ArrayList<FilterAvailabalGradePackage> arrayListM67829n = C11296s.m67829n(getPackagesBySpaceRuleRespBuildSpaceRuleResp.getPackageGrades(), getPackagesBySpaceRuleRespBuildSpaceRuleResp.getSpacePackages());
        this.f16548a0 = arrayListM67829n;
        m22876t5(arrayListM67829n);
        if (this.f16548a0 == null) {
            this.f16548a0 = new ArrayList<>();
        }
        mo19479s5();
    }

    /* renamed from: R5 */
    public final String m23182R5(String str) {
        if (!TextUtils.isEmpty(str)) {
            return HicloudH5ConfigManager.getInstance().getNoticeTextFromConfig(str, "recommend_detail_link1");
        }
        C11839m.m70687e("CloudSpaceGuideActivity", "getDetailPpsCampText fail, resourceId is null");
        return "";
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        if (this.f16792v1 == null) {
            return false;
        }
        if (C11296s.m67786J(this)) {
            this.f16792v1.m23914a();
            return false;
        }
        this.f16792v1.m23919i();
        return true;
    }

    /* renamed from: S5 */
    public final Intent m23183S5() {
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.BackupNotificationActivity");
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
        C0209d.m1302r2(intent, getPackageName());
        C13230i.m79525e1(intent, "4", "8");
        m28580X0(intent);
        return intent;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() throws JSONException, IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f16792v1.getVisibility() == 0) {
            this.f16792v1.m23914a();
        }
        m23184T5();
        if (!C11296s.m67786J(this)) {
            m23156B6();
            m23206q6("");
            return;
        }
        this.f16538V = null;
        this.f21452m = null;
        this.f16548a0 = null;
        this.f16546Z = null;
        this.f16535T0 = null;
        mo19474g5();
        m28588o1("06008");
        C13612b.m81829B().m81848K(this.f16524O);
    }

    /* renamed from: T5 */
    public final void m23184T5() throws JSONException, IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        try {
            this.f16778h1 = (RecommendNeedData) hiCloudSafeIntent.getSerializableExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY);
            this.f16779i1 = (RecommendTipData) hiCloudSafeIntent.getSerializableExtra("recommend_tip_info_key");
        } catch (Exception e10) {
            C11839m.m70687e("CloudSpaceGuideActivity", "getIntentDataAndSetBarTitle get extra " + e10.getMessage());
        }
        this.f16764C1 = hiCloudSafeIntent.getIntExtra(FamilyShareConstants.ENTRY_TYPE, -1);
        this.f16765D1 = hiCloudSafeIntent.getIntExtra(FamilyShareConstants.EXTRA_KEY, -1);
        RecommendTipData recommendTipData = this.f16779i1;
        if (recommendTipData != null) {
            this.f16772K1 = recommendTipData.getDialogPopTimesThreshold();
            C1442a.m8288d("CloudSpaceGuideActivity", "dialogPopTimesThreshold:" + this.f16772K1);
        }
        if (this.f16778h1 == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "getIntentDataAndSetBarTitle data is null.");
            m23206q6("");
            finish();
            return;
        }
        C1442a.m8288d("CloudSpaceGuideActivity", "recommendNeedData : " + this.f16778h1.toString());
        m23206q6(this.f16778h1.getRecommendType());
        m23197i6(hiCloudSafeIntent.getStringExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE));
        m23209t6();
    }

    /* renamed from: U5 */
    public final String m23185U5(String str) {
        if (str != null) {
            return ExtraNoticeConfigManager.getInstance().getExtraNoticeLanguage(str);
        }
        C11839m.m70686d("CloudSpaceGuideActivity", "noticeKey is null");
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
    /* renamed from: V5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m23186V5() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceGuideActivity.m23186V5():void");
    }

    /* renamed from: W5 */
    public final List<SpaceNoticeEntrance> m23187W5(NoticeContent noticeContent, NoticeDetail noticeDetail, int i10) {
        LinkedHashMap<String, String> detailLink;
        LinkedHashMap<String, String> detailLink2;
        ArrayList arrayList = new ArrayList();
        if (noticeDetail != null && (detailLink2 = noticeDetail.getDetailLink()) != null) {
            for (Map.Entry<String, String> entry : detailLink2.entrySet()) {
                String key = entry.getKey();
                String strM63228l = C10152c.m63228l(entry.getValue(), i10);
                SpaceNoticeEntrance spaceNoticeEntrance = new SpaceNoticeEntrance();
                spaceNoticeEntrance.setLinkKey(key);
                spaceNoticeEntrance.setLinkConent(strM63228l);
                arrayList.add(spaceNoticeEntrance);
            }
        }
        if (noticeContent != null && (detailLink = noticeContent.getDetailLink()) != null) {
            for (Map.Entry<String, String> entry2 : detailLink.entrySet()) {
                String key2 = entry2.getKey();
                String strM63228l2 = C10152c.m63228l(entry2.getValue(), i10);
                SpaceNoticeEntrance spaceNoticeEntrance2 = new SpaceNoticeEntrance();
                spaceNoticeEntrance2.setLinkKey(key2);
                spaceNoticeEntrance2.setLinkConent(strM63228l2);
                arrayList.add(spaceNoticeEntrance2);
            }
        }
        return arrayList;
    }

    /* renamed from: X5 */
    public final List<SpaceNoticeEntrance> m23188X5(NoticeDetail noticeDetail) {
        LinkedHashMap<String, String> detailLink;
        ArrayList arrayList = new ArrayList();
        if (noticeDetail != null && (detailLink = noticeDetail.getDetailLink()) != null) {
            for (Map.Entry<String, String> entry : detailLink.entrySet()) {
                String key = entry.getKey();
                String strM23185U5 = m23185U5(entry.getValue());
                SpaceNoticeEntrance spaceNoticeEntrance = new SpaceNoticeEntrance();
                spaceNoticeEntrance.setLinkKey(key);
                spaceNoticeEntrance.setLinkConent(strM23185U5);
                arrayList.add(spaceNoticeEntrance);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: Y2 */
    public void mo19466Y2() throws JSONException {
        if (NotifyConstants.THRID_APP_SPACE_INSUFFICIENT.equals(this.f16778h1.getRecommendType())) {
            finish();
        } else {
            m23190Z5();
        }
    }

    /* renamed from: Y5 */
    public final void m23189Y5() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f16764C1);
        bundle.putInt(FamilyShareConstants.EXTRA_KEY, this.f16765D1);
        intent.putExtras(bundle);
        intent.setClass(this, CloudSpaceShareActivity.class);
        startActivity(intent);
    }

    /* renamed from: Z5 */
    public void m23190Z5() throws JSONException {
        m23168g6();
    }

    /* renamed from: b6 */
    public final void m23191b6(View view) throws Resources.NotFoundException {
        RecommendTipData recommendTipData = this.f16779i1;
        if (recommendTipData == null) {
            C11839m.m70687e("CloudSpaceGuideActivity", "initHelp recommendTipData is null help not display");
            return;
        }
        if (!TextUtils.isEmpty(recommendTipData.getDisplayHelp()) && C10152c.m63233q(this.f16779i1.getDisplayHelp()) && C10152c.m63232p(this.f16779i1.getDialogViewDetailsNum(), this.f16779i1.getDialogPopTimesThreshold())) {
            String strM63228l = C10152c.m63228l(this.f16779i1.getTipId(), this.f16779i1.getNotificationId());
            if (TextUtils.isEmpty(strM63228l)) {
                return;
            }
            this.f16501C0 = true;
            TipCommonView tipCommonView = new TipCommonView(this);
            this.f16773L1 = tipCommonView;
            tipCommonView.showLeftTip(view, strM63228l);
        }
    }

    /* renamed from: c6 */
    public final void m23192c6() {
        C12515a.m75110o().m75175e(new C9060d(this.f16570q0, this.f16572s0, this.f16573t0, this.f16574u0, this.f16776O1, 1001, false), false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: d5 */
    public void mo19541d5() {
        if (!this.f16777P1) {
            C11839m.m70688i("CloudSpaceGuideActivity", "showGuidH5  isShowViewOk: false");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudSpaceGuideActivity_isShowViewOk_return");
            onBackPressed();
        } else if (!C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PAGETYPE, "").equals("recommend")) {
            C11839m.m70688i("CloudSpaceGuideActivity", "showGuidH5  !pageType.equals(QueryGuideH5Task.CAMPAIGNSOURCE_RECOMMEND)");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudSpaceGuideActivity_pageType_return");
            onBackPressed();
        } else {
            if (C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_SCENETYPE, "").equals("exit")) {
                super.mo19541d5();
                return;
            }
            C11839m.m70688i("CloudSpaceGuideActivity", "showGuidH5  !sceneType.equals(QueryGuideH5Task.OPER_EXIT)");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "CloudSpaceGuideActivity_sceneType_return");
            onBackPressed();
        }
    }

    /* renamed from: d6 */
    public final void m23193d6(UserPackage userPackage) {
        MemGradeRights gradeRights = userPackage.getGradeRights();
        if (gradeRights != null) {
            this.f16771J1 = gradeRights.getGradeCode();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: e4 */
    public void mo19472e4(long j10) {
        if (HicloudH5ConfigManager.getInstance().getClientVersion() >= j10) {
            C11839m.m70688i("CloudSpaceGuideActivity", "preGetPpsAdsNum H5Config ClientVersion not updated ");
            m23192c6();
            return;
        }
        C11839m.m70688i("CloudSpaceGuideActivity", "preGetPpsAdsNum H5Config ClientVersion updated " + j10);
        C12515a.m75110o().m75175e(new C10257p1(this.f16524O, j10, 1001), false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: f3 */
    public void mo19473f3(Object obj) throws JSONException, Resources.NotFoundException {
        if (obj == null || !(obj instanceof UserPackage)) {
            C1442a.m8289e("CloudSpaceGuideActivity", "dealGetUserPackageSuccess obj is not UserPackage.");
            mo19477k5();
            return;
        }
        this.f21452m = (UserPackage) obj;
        RecommendNeedData recommendNeedData = this.f16778h1;
        if (recommendNeedData == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "dealGetUserPackageSuccess recommendNeedData is null.");
            m23190Z5();
            return;
        }
        if (!"family_share".equals(recommendNeedData.getRecommendType())) {
            mo19479s5();
            return;
        }
        if (C11293p.m67757a(this.f21452m) == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "dealGetUserPackageSuccess effectivePackage is null.");
            m23190Z5();
            return;
        }
        long jM67762f = C11293p.m67762f(this.f21452m);
        long used = this.f21452m.getUsed();
        if (jM67762f > used) {
            this.f16778h1.setTotalNeedSpace(jM67762f);
        } else {
            this.f16778h1.setTotalNeedSpace(used);
        }
        m23186V5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: f4 */
    public void mo22832f4(Message message) {
        super.mo22832f4(message);
    }

    /* renamed from: f6 */
    public boolean m23194f6(String str) {
        return !TextUtils.isEmpty(m23182R5(str)) && this.f16770I1;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g4 */
    public boolean mo22835g4(Message message) {
        return super.mo22835g4(message);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        this.f16784n1.setVisibility(0);
        this.f16785o1.setVisibility(8);
        this.f16783m1.setVisibility(8);
        this.f16786p1.setVisibility(8);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16780j1);
        arrayList.add(this.f16783m1);
        arrayList.add(this.f16782l1);
        arrayList.add(this.f16792v1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() {
        this.f16783m1.setVisibility(0);
        this.f16784n1.setVisibility(8);
        this.f16785o1.setVisibility(8);
        this.f16786p1.setVisibility(8);
    }

    /* renamed from: h6 */
    public final /* synthetic */ void m23195h6(int i10, List list) {
        this.f16770I1 = (this.f16573t0 + i10) + list.size() >= this.f16572s0;
        m23200l6();
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: i0 */
    public void mo23196i0(boolean z10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("way_of_purchase", "recommend_purchase");
        m22842j4(z10 ? "UNIFORM_CLOUDPAY_UPGRADE_CLICK_USER_AGREEMENT" : "UNIFORM_CLOUDPAY_UPGRADE_CLICK_AUTO_PAY_AGREEMENT", linkedHashMapM79497A);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: i1 */
    public String mo23018i1() {
        return "CloudSpaceGuideActivity";
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: i4 */
    public void mo22839i4() throws JSONException, IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f16563j0.size() > 0) {
            C1442a.m8290i("CloudSpaceGuideActivity", "refresh vouchers");
            mo19460T3();
        }
    }

    /* renamed from: i6 */
    public final void m23197i6(String str) throws JSONException {
        if (str == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "notifyType is null");
            return;
        }
        if (this.f16778h1 == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "notificationClickReport recommendNeedData is null.");
            return;
        }
        if ("3".equals(str)) {
            JSONObject jSONObjectM79464f = C13222a.m79464f(this, "DYNAMIC_NOTIFY_CLICK", "1", C13452e.m80781L().m80971t0(), "4");
            try {
                jSONObjectM79464f.put("notify_id", this.f16778h1.getId());
                jSONObjectM79464f.put("notify_type", "1");
            } catch (JSONException e10) {
                C1442a.m8289e("CloudSpaceGuideActivity", "ERROR OCCUR:" + e10.getMessage());
            }
            C13227f.m79492i1().m79602z(jSONObjectM79464f);
            UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_CLICK", "4", "9", jSONObjectM79464f);
        }
    }

    /* renamed from: j6 */
    public final void m23198j6() {
        String recommendType = this.f16778h1.getRecommendType();
        List<NoticeDetailGoto> arrayList = new ArrayList<>();
        NoticeContent noticeContent = new NoticeContent();
        NoticeDetail noticeDetail = new NoticeDetail();
        int id2 = this.f16778h1.getId();
        List<SpaceNotification> notification = NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT.equals(recommendType) ? UserSpaceUtil.getNotification() : UserSpaceUtil.getSpaceNotificationList();
        int id3 = 0;
        if (notification != null && notification.size() > 0) {
            for (SpaceNotification spaceNotification : notification) {
                if (spaceNotification != null) {
                    id3 = spaceNotification.getId();
                    if (recommendType.equals(spaceNotification.getNoticeType()) && id2 == id3) {
                        noticeDetail = CloudSpaceNotifyUtil.getInstance().getNoticeContentDetail(spaceNotification);
                        arrayList = spaceNotification.getDetailGoto();
                    }
                }
            }
        }
        m23211w6(noticeContent, noticeDetail, arrayList, id3);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
        this.f16785o1.setVisibility(0);
        this.f16784n1.setVisibility(8);
        this.f16783m1.setVisibility(8);
        this.f16786p1.setVisibility(8);
    }

    /* renamed from: k6 */
    public final void m23199k6() {
        String recommendType = this.f16778h1.getRecommendType();
        List<NoticeDetailGoto> arrayList = new ArrayList<>();
        NoticeContent noticeContent = new NoticeContent();
        NoticeDetail noticeDetail = new NoticeDetail();
        int id2 = this.f16778h1.getId();
        int activityType = this.f16778h1.getActivityType();
        List<NotificationWithActivity> notificationWithTaskCenter = this.f16778h1.isActivityWithTaskCenter() ? UserSpaceUtil.getNotificationWithTaskCenter() : NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT.equals(recommendType) ? UserSpaceUtil.getNotificationWithActivity() : UserSpaceUtil.getNotificationWithActivityList();
        if (notificationWithTaskCenter == null || notificationWithTaskCenter.size() <= 0) {
            C11839m.m70688i("CloudSpaceGuideActivity", "prepareActivityRecommendDetailInfo notificationWithActivity is null");
            return;
        }
        int id3 = 0;
        for (NotificationWithActivity notificationWithActivity : notificationWithTaskCenter) {
            if (notificationWithActivity != null) {
                id3 = notificationWithActivity.getId();
                if (recommendType.equals(notificationWithActivity.getNoticeType()) && activityType == notificationWithActivity.getActivityType() && id2 == id3) {
                    noticeDetail = NoticeWithActivityUtil.queryNoticeDetailForSpaceNotify(notificationWithActivity);
                    arrayList = notificationWithActivity.getDetailGoto();
                }
            }
        }
        m23211w6(noticeContent, noticeDetail, arrayList, id3);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
        this.f16784n1.setVisibility(0);
        this.f16785o1.setVisibility(8);
        this.f16783m1.setVisibility(8);
        this.f16786p1.setVisibility(8);
    }

    /* renamed from: l6 */
    public void m23200l6() {
        if (this.f16767F1 == null || this.f16796z1 == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "refreshCampaignSuccessUI mEntrances null");
            this.f16768G1 = true;
            return;
        }
        boolean zM23194f6 = m23194f6(this.f16570q0);
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70688i("CloudSpaceGuideActivity", "refreshCampaignSuccessUI campagin can not show in child account");
            zM23194f6 = false;
        }
        this.f16796z1.m7368K(m23179O5(zM23194f6));
        this.f16768G1 = false;
    }

    /* renamed from: m6 */
    public final void m23201m6() {
        if (this.f16796z1 == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "removeCampaignEntrance recommendPageAdapter null");
        } else {
            this.f16796z1.m7368K(m23179O5(false));
        }
    }

    /* renamed from: n6 */
    public void m23202n6() {
        C1400c.m8060g("RECOMMONED_PAGE_BANNER_SHOW", null);
        C1442a.m8288d("CloudSpaceGuideActivity", "BI report upgrade page banner show");
    }

    /* renamed from: o6 */
    public final void m23203o6() {
        m22842j4("UNIFORM_CLOUDPAY_UPGRADE_CLICK_AUTO_PAY_AGREEMENT", C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws JSONException, IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C1172h c1172h;
        C1442a.m8290i("CloudSpaceGuideActivity", "onActivityResult requestCode = " + i10 + ", resultCode = " + i11);
        if (10008 == i10 && (c1172h = this.f16796z1) != null) {
            c1172h.m7363F();
        }
        if (i11 == -1) {
            mo19453O4(i10, intent);
        } else if (i11 == 0 || i11 == 1) {
            m28583a1();
            if (this.f16538V == null || this.f21452m == null || this.f16548a0 == null) {
                C1442a.m8288d("CloudSpaceGuideActivity", " data no prepare ok");
                return;
            }
            mo19476h5();
        } else if (i11 == 201 || i11 == 802) {
            C1442a.m8288d("CloudSpaceGuideActivity", "refresh data by requestCode:" + i10 + ", resultCode:" + i11);
            mo19460T3();
        } else if (i11 == 7102 || i11 == 7103) {
            m23201m6();
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        C13227f.m79492i1().m79591l0("mecloud_cloudspacetips_cancel", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "mecloud_cloudspacetips_cancel", "1", "30", linkedHashMapM79499C);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException, IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int id2 = view.getId();
        if (R$id.layout_nonetwork == id2 || R$id.layout_nodata == id2) {
            mo19460T3();
            return;
        }
        if (R$id.set_no_net_btn == id2) {
            mo19446D1();
            return;
        }
        if (R$id.more_plan == id2) {
            Intent intent = new Intent();
            intent.setClass(this, CloudSpaceUpgradeActivity.class);
            intent.putExtra("from_where", 12);
            m28580X0(intent);
            startActivity(intent);
            m23204p6();
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f16787q1);
        m23170v6();
        C1170f c1170f = this.f16791u1;
        if (c1170f != null) {
            c1170f.m5213j();
            this.f16791u1.m7354D();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, JSONException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        new C13149f().m79065c(this, getIntent(), C13222a.m79465g(this));
        float fM1195O = C0209d.m1195O(this);
        if (fM1195O >= 3.2f) {
            setContentView(R$layout.activity_cloud_space_guide_3dot2);
        } else if (fM1195O < 1.75f || fM1195O >= 3.2f) {
            setContentView(R$layout.activity_cloud_space_guide);
        } else {
            setContentView(R$layout.activity_cloud_space_guide_2);
        }
        setResult(3);
        m23167e6();
        m28587n1();
        mo19460T3();
        C12515a.m75110o().m75175e(new C3024d2(this, this.f16526P, 2, "CloudSpaceGuideActivity"), false);
        m23166a6();
        m23207r6();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        RecommendTipData recommendTipData = this.f16779i1;
        if (recommendTipData == null) {
            C11839m.m70687e("CloudSpaceGuideActivity", "onCreateOptionsMenu recommendTipData is null help not display");
        } else if (!TextUtils.isEmpty(recommendTipData.getDisplayHelp()) && C10152c.m63233q(this.f16779i1.getDisplayHelp())) {
            getMenuInflater().inflate(R$menu.tip_help, menu);
            MenuItem menuItemFindItem = menu.findItem(R$id.help);
            menuItemFindItem.setActionView(R$layout.action_item);
            ImageView imageView = (ImageView) C12809f.m76831d(menuItemFindItem.getActionView(), R$id.action_item_image);
            this.f16775N1 = imageView;
            imageView.setImageResource(R$drawable.hicloud_new_backup);
            View actionView = menuItemFindItem.getActionView();
            this.f16774M1 = actionView;
            actionView.setOnClickListener(new ViewOnClickListenerC3606c());
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11842p.m70836m(this);
        super.onDestroy();
        m23177G6();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) throws JSONException, IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onNewIntent(intent);
        setIntent(intent);
        mo19460T3();
        this.f16769H1 = true;
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f16501C0 = true;
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        C12515a.m75110o().m75175e(new C3024d2(this, this.f16526P, 2, "CloudSpaceGuideActivity"), false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) throws Resources.NotFoundException {
        super.onWindowFocusChanged(z10);
        if (m22805V3()) {
            C11839m.m70686d("CloudSpaceGuideActivity", "isShowBubble is true");
            return;
        }
        ImageView imageView = this.f16775N1;
        if (imageView == null) {
            C11839m.m70687e("CloudSpaceGuideActivity", "helpImage is null");
        } else {
            m23191b6(imageView);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: p3 */
    public void mo22860p3(int i10) throws JSONException {
        C1442a.m8289e("CloudSpaceGuideActivity", "dealQuerySignStatusFail code = " + i10);
        m22793Q4(null, null);
        if (i10 == 56 || i10 == 106 || i10 == 120) {
            super.mo22860p3(i10);
        } else {
            m23190Z5();
        }
    }

    /* renamed from: p6 */
    public final void m23204p6() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CLICK_MORE", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_CLICK_MORE", "1", "36", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_CLICK_MORE", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpaceGuideActivity", "reportEnterGuideActivity error occur:" + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: q0 */
    public void mo23205q0(CloudPackage cloudPackage, PackageGrades packageGrades, List<Voucher> list, ReportVoucherInfo reportVoucherInfo) throws JSONException {
        if (cloudPackage == null) {
            C1442a.m8288d("CloudSpaceGuideActivity", " mSelectPackage is null.");
            return;
        }
        if (NotifyConstants.THRID_APP_SPACE_INSUFFICIENT.equals(this.f16778h1.getRecommendType())) {
            m22793Q4("10000", "10000");
        }
        m22880u5(cloudPackage, packageGrades, "recommend_purchase", list, m22886w2(cloudPackage.getProductType() == 12), reportVoucherInfo, this.f21452m.getDeductAmount());
    }

    /* renamed from: q6 */
    public final void m23206q6(String str) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("recommend_type", str);
            m28593u1(linkedHashMapM79497A);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_ENTER_GUIDE_ACITIVY", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_ENTER_GUIDE_ACITIVY", "1", "36", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_ENTER_GUIDE_ACITIVY", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpaceGuideActivity", "reportEnterGuideActivity error occur:" + e10.getMessage());
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: r1 */
    public boolean mo19553r1(int i10, KeyEvent keyEvent) {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("CloudSpaceGuideActivity", "KEYCODE_BACK click too fast");
            return true;
        }
        mo19541d5();
        return true;
    }

    /* renamed from: r6 */
    public final void m23207r6() {
        try {
            RecommendNeedData recommendNeedData = (RecommendNeedData) new HiCloudSafeIntent(getIntent()).getSerializableExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY);
            if (recommendNeedData != null) {
                this.f21460u = recommendNeedData.getAppId();
                LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                linkedHashMapM79497A.put("recommend_type", recommendNeedData.getRecommendType());
                linkedHashMapM79497A.put("enter_guide_type", String.valueOf(recommendNeedData.getEnterType()));
                linkedHashMapM79497A.put("is_formwith_activity", String.valueOf(recommendNeedData.isFormWithActivity()));
                m28593u1(linkedHashMapM79497A);
                linkedHashMapM79497A.put("is_formwith_activity", String.valueOf(recommendNeedData.isFormWithActivity()));
                C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_ENTER_GUIDE_INFO", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_ENTER_GUIDE_INFO", "1", "36", linkedHashMapM79497A);
                m28575A1("UNIFORM_CLOUDPAY_ENTER_GUIDE_INFO", linkedHashMapM79497A);
            }
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpaceGuideActivity", "reportEnterGuideActivity error occur:" + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() throws JSONException, Resources.NotFoundException {
        if (this.f16538V == null || this.f21452m == null || this.f16548a0 == null || this.f16546Z == null || this.f16535T0 == null) {
            C1442a.m8290i("CloudSpaceGuideActivity", "data no prepare ok");
            return;
        }
        C1442a.m8290i("CloudSpaceGuideActivity", "showView");
        if (this.f16778h1 == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "showView recommendNeedData is null.");
            return;
        }
        if (this.f16548a0.isEmpty()) {
            C1442a.m8289e("CloudSpaceGuideActivity", "recommendPackagesList is null");
            m23181P5();
            return;
        }
        this.f16768G1 = true;
        m23193d6(this.f21452m);
        String recommendType = this.f16778h1.getRecommendType();
        String mainText = this.f16778h1.getMainText();
        m23214z6(recommendType);
        if (NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT.equals(recommendType) || NotifyConstants.THRID_APP_SPACE_INSUFFICIENT.equals(recommendType)) {
            long galleryNum = this.f16778h1.getGalleryNum();
            long backupNeedSpace = this.f16778h1.getBackupNeedSpace();
            long notUsedSpace = this.f16778h1.getNotUsedSpace();
            m23210u6(mainText, galleryNum, backupNeedSpace, notUsedSpace >= 0 ? notUsedSpace : 0L);
        } else if (NotifyConstants.SPACE_AVAILABLE_DAYS_V3.equals(recommendType)) {
            this.f16789s1.setText(C10465b.m64293c(mainText, C0223k.m1524g(this, this.f16778h1.getCurrentPackageSpace())));
        } else {
            this.f16789s1.setText(mainText);
        }
        C1442a.m8290i("CloudSpaceGuideActivity", "size  =  " + this.f16548a0.size());
        this.f16790t1.setLayoutManager(new LinearLayoutManager(this));
        C1170f c1170f = new C1170f(this, this.f16548a0, this.f16538V, this.f16771J1, this.f16535T0, this.f21452m);
        this.f16791u1 = c1170f;
        this.f16790t1.setAdapter(c1170f);
        this.f16790t1.addItemDecoration(new C3607d(C11842p.m70840n(this, 8)));
        this.f16790t1.setHasFixedSize(true);
        this.f16790t1.setNestedScrollingEnabled(false);
        this.f16791u1.m5213j();
        if (NotifyConstants.THRID_APP_SPACE_INSUFFICIENT.equals(recommendType)) {
            ChannelInfo channelInfoM22882v2 = m22882v2();
            channelInfoM22882v2.setSalChannel("10000");
            channelInfoM22882v2.setSrcChannel("10000");
            m23174D6(channelInfoM22882v2);
        } else {
            m23173C6();
        }
        mo19476h5();
        m22784M4("recommend_purchase");
        this.f16777P1 = true;
        C1442a.m8290i("CloudSpaceGuideActivity", "showView finish.");
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: t */
    public void mo23208t(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null) {
            C1442a.m8289e("CloudSpaceGuideActivity", "reportClickEvent, eventObject is null.");
        } else {
            linkedHashMap.put("way_of_purchase", "recommend_purchase");
            m22842j4(str, linkedHashMap);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    /* renamed from: t6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m23209t6() throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r4 = this;
            android.app.ActionBar r0 = r4.getActionBar()
            r4.f16763B1 = r0
            java.lang.String r1 = "CloudSpaceGuideActivity"
            if (r0 != 0) goto L10
            java.lang.String r4 = "setActionbarTitle actionBar is null."
            p054cj.C1442a.m8289e(r1, r4)
            return
        L10:
            r4.m23169s6()
            android.app.ActionBar r0 = r4.f16763B1
            int r2 = com.huawei.android.p073ds.R$drawable.cloud_space_guide_back_icon
            r0.setHomeAsUpIndicator(r2)
            vj.e r0 = p709vj.C13452e.m80781L()
            boolean r0 = r0.m80887a1()
            if (r0 == 0) goto L31
            java.lang.String r0 = "new BM, set new title"
            p054cj.C1442a.m8290i(r1, r0)
            android.app.ActionBar r4 = r4.f16763B1
            int r0 = com.huawei.android.p073ds.R$string.full_data_service
            r4.setTitle(r0)
            return
        L31:
            com.huawei.hicloud.notification.db.bean.RecommendNeedData r0 = r4.f16778h1
            if (r0 != 0) goto L3b
            java.lang.String r4 = "setActionbarTitle recommendNeedData is null."
            p054cj.C1442a.m8289e(r1, r4)
            return
        L3b:
            java.lang.String r0 = r0.getRecommendType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L52
            java.lang.String r0 = "setActionbarTitle recommendType is null."
            p054cj.C1442a.m8289e(r1, r0)
            android.app.ActionBar r4 = r4.f16763B1
            int r0 = com.huawei.android.p073ds.R$string.cloudpay_app_name
            r4.setTitle(r0)
            return
        L52:
            com.huawei.hicloud.notification.db.bean.RecommendNeedData r0 = r4.f16778h1
            java.lang.String r0 = r0.getRecommendType()
            int r1 = r0.hashCode()
            r2 = 2
            r3 = 1
            switch(r1) {
                case -2116214370: goto La8;
                case -1849560048: goto L9e;
                case -1502954020: goto L94;
                case -1164837951: goto L8a;
                case -885460156: goto L80;
                case -765047562: goto L76;
                case -372943030: goto L6c;
                case 439781039: goto L62;
                default: goto L61;
            }
        L61:
            goto Lb2
        L62:
            java.lang.String r1 = "cloud_backup_space_insufficient"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb2
            r0 = r3
            goto Lb3
        L6c:
            java.lang.String r1 = "space_used_size"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb2
            r0 = 4
            goto Lb3
        L76:
            java.lang.String r1 = "space_available_days_v3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb2
            r0 = 7
            goto Lb3
        L80:
            java.lang.String r1 = "family_share"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb2
            r0 = 3
            goto Lb3
        L8a:
            java.lang.String r1 = "thirdApp_space_insufficient"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb2
            r0 = r2
            goto Lb3
        L94:
            java.lang.String r1 = "space_available_ratio"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb2
            r0 = 6
            goto Lb3
        L9e:
            java.lang.String r1 = "space_available_size"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb2
            r0 = 5
            goto Lb3
        La8:
            java.lang.String r1 = "cloudphoto_sync_space_insufficient"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb2
            r0 = 0
            goto Lb3
        Lb2:
            r0 = -1
        Lb3:
            if (r0 == 0) goto Lc9
            if (r0 == r3) goto Lc1
            if (r0 == r2) goto Lc1
            android.app.ActionBar r4 = r4.f16763B1
            int r0 = com.huawei.android.p073ds.R$string.cloudpay_app_name
            r4.setTitle(r0)
            goto Ld0
        Lc1:
            android.app.ActionBar r4 = r4.f16763B1
            int r0 = com.huawei.android.p073ds.R$string.cloudpay_cloud_backup_item_title
            r4.setTitle(r0)
            goto Ld0
        Lc9:
            android.app.ActionBar r4 = r4.f16763B1
            int r0 = com.huawei.android.p073ds.R$string.cloud_sync
            r4.setTitle(r0)
        Ld0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceGuideActivity.m23209t6():void");
    }

    /* renamed from: u6 */
    public final void m23210u6(String str, long j10, long j11, long j12) {
        RecommendNeedData recommendNeedData = this.f16778h1;
        if (recommendNeedData != null && recommendNeedData.isV5BackupNotEnoughDialog()) {
            this.f16789s1.setText(str);
            return;
        }
        if (j10 <= 0 || j11 <= 0 || C2783d.m16105R()) {
            this.f16789s1.setText(C10465b.m64293c(str, C0223k.m1524g(this, j11), C0223k.m1524g(this, j12)));
            return;
        }
        Resources resources = getResources();
        if (resources != null) {
            int i10 = (int) j10;
            this.f16789s1.setText(C10465b.m64293c(str, resources.getQuantityString(R$plurals.cloud_backup_fail_remain_data, i10, Integer.valueOf(i10)), C0223k.m1524g(this, j11)));
        }
    }

    /* renamed from: w6 */
    public final void m23211w6(NoticeContent noticeContent, NoticeDetail noticeDetail, List<NoticeDetailGoto> list, int i10) {
        this.f16767F1 = m23187W5(noticeContent, noticeDetail, i10);
        ArrayList arrayList = new ArrayList();
        if (this.f16767F1.size() <= 0 || list == null || list.size() <= 0) {
            return;
        }
        for (SpaceNoticeEntrance spaceNoticeEntrance : this.f16767F1) {
            String linkKey = spaceNoticeEntrance.getLinkKey();
            for (NoticeDetailGoto noticeDetailGoto : list) {
                if (!TextUtils.isEmpty(linkKey) && noticeDetailGoto != null && linkKey.equals(noticeDetailGoto.getCode())) {
                    spaceNoticeEntrance.setType(noticeDetailGoto.getType());
                    spaceNoticeEntrance.setUri(noticeDetailGoto.getUri());
                    if (noticeDetailGoto.getUri().equals(NotifyConstants.HICLOUD_DLAPP)) {
                        spaceNoticeEntrance.setVisiable(false);
                    } else {
                        spaceNoticeEntrance.setVisiable(true);
                    }
                    if (spaceNoticeEntrance.isVisiable()) {
                        arrayList.add(spaceNoticeEntrance);
                    }
                }
            }
        }
        C1172h c1172h = new C1172h(this, "hidisk_recommend_type", arrayList);
        this.f16796z1 = c1172h;
        this.f16795y1.setAdapter(c1172h);
        this.f16795y1.setLayoutManager(new LinearLayoutManager(this));
        if (this.f16768G1 || this.f16769H1) {
            m23200l6();
        }
    }

    /* renamed from: x6 */
    public final void m23212x6(NoticeDetail noticeDetail, List<NoticeDetailGoto> list, ChannelInfo channelInfo) {
        this.f16767F1 = m23188X5(noticeDetail);
        ArrayList arrayList = new ArrayList();
        if (this.f16767F1.size() <= 0 || list == null || list.size() <= 0) {
            return;
        }
        for (SpaceNoticeEntrance spaceNoticeEntrance : this.f16767F1) {
            String linkKey = spaceNoticeEntrance.getLinkKey();
            for (NoticeDetailGoto noticeDetailGoto : list) {
                if (!TextUtils.isEmpty(linkKey) && noticeDetailGoto != null && linkKey.equals(noticeDetailGoto.getCode())) {
                    spaceNoticeEntrance.setType(noticeDetailGoto.getType());
                    spaceNoticeEntrance.setUri(noticeDetailGoto.getUri());
                    if (noticeDetailGoto.getUri().equals(NotifyConstants.HICLOUD_DLAPP)) {
                        spaceNoticeEntrance.setVisiable(false);
                    } else {
                        spaceNoticeEntrance.setVisiable(true);
                    }
                    if (spaceNoticeEntrance.isVisiable()) {
                        arrayList.add(spaceNoticeEntrance);
                    }
                }
            }
        }
        C1172h c1172h = new C1172h(this, "hidisk_recommend_type", arrayList, channelInfo);
        this.f16796z1 = c1172h;
        this.f16795y1.setAdapter(c1172h);
        this.f16795y1.setLayoutManager(new LinearLayoutManager(this));
        if (this.f16768G1 || this.f16769H1) {
            m23200l6();
        }
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: y */
    public void mo23213y(CloudPackage cloudPackage, PackageGrades packageGrades, int i10) {
        m22872s4(cloudPackage, packageGrades, "recommend_purchase", i10);
    }

    /* renamed from: z6 */
    public final void m23214z6(String str) throws Resources.NotFoundException {
        Resources resources = getResources();
        if (resources != null) {
            String title = this.f16778h1.getTitle();
            if (!NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT.equals(str)) {
                this.f16788r1.setText(title);
                return;
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.cloud_space_22_sp);
            long jM16190y = C2783d.m16190y();
            String strValueOf = String.valueOf(jM16190y);
            if (TextUtils.isEmpty(title)) {
                this.f16788r1.setVisibility(8);
                return;
            }
            int i10 = (int) jM16190y;
            String strM64293c = C10465b.m64293c(title, resources.getQuantityString(R$plurals.cloud_backup_fail_days, i10, Integer.valueOf(i10)));
            int iIndexOf = strM64293c != null ? strM64293c.indexOf(strValueOf) : -1;
            if (iIndexOf < 0) {
                this.f16788r1.setText(strM64293c);
                return;
            }
            TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, dimensionPixelSize, ColorStateList.valueOf(resources.getColor(R$color.cloud_backup_fail_not_backup_days_color, null)), null);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strM64293c);
            spannableStringBuilder.setSpan(textAppearanceSpan, iIndexOf, strValueOf.length() + iIndexOf, 34);
            this.f16788r1.setText(spannableStringBuilder);
        }
    }
}
