package p807yd;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import ck.C1445c;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.common.task.ClickExchangeTask;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupActivity;
import com.huawei.android.hicloud.p088ui.activity.HisyncSpaceDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.IntelligentClearActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.MessageCenterActivity;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.OverdueBackupRecordsActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CampaignActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CouponCenterActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.OrderListActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.PaymentManagerAndOrderActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.PurchaseCloudCardActivity;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupCheckActivity;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$string;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import gp.C10028c;
import gt.C10045a;
import hu.C10344c;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import je.C10794j;
import je.C10811y;
import mu.C11526c;
import org.json.JSONArray;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0239x;
import p020ap.C1006a;
import p037bp.C1270a;
import p232dp.InterfaceC9287f;
import p292fn.C9733f;
import p329h7.C10121i;
import p399jk.AbstractC10896a;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11839m;
import p550pb.C12126b;
import p616rk.C12515a;
import p674ub.C13149f;
import p684un.C13227f;
import p709vj.C13452e;
import pk.C12158a;

/* renamed from: yd.b */
/* loaded from: classes3.dex */
public class C13946b {

    /* renamed from: yd.b$b */
    public static class b {

        /* renamed from: a */
        public static C13946b f62533a = new C13946b();
    }

    public /* synthetic */ C13946b(a aVar) {
        this();
    }

    /* renamed from: e */
    public static C13946b m83729e() {
        return b.f62533a;
    }

    /* renamed from: A */
    public final boolean m83730A(Context context, SafeIntent safeIntent, String str) {
        InterfaceC9287f interfaceC9287f;
        if (!C0209d.m1166E1() || !C10028c.m62182c0().m62395t1("funcfg_find_my_phone_globe") || (interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class)) == null) {
            return false;
        }
        m83773v(context, safeIntent, interfaceC9287f.mo58539B(), "CLOUDBACKUP_ENTER_FINDMYPHONE", str);
        return true;
    }

    /* renamed from: B */
    public final boolean m83731B(Context context, SafeIntent safeIntent, String str) {
        if (!C0209d.m1166E1() || !C10028c.m62182c0().m62395t1("funcfg_gallery")) {
            return false;
        }
        m83773v(context, safeIntent, C1006a.m5936k().m5963i(), "CLOUDBACKUP_ENTER_GALLERY", str);
        return true;
    }

    /* renamed from: C */
    public final boolean m83732C(Context context, SafeIntent safeIntent) {
        Uri data = safeIntent.getData();
        if (data == null) {
            return false;
        }
        String strM63704b = C10344c.m63704b(data, "srcChannel");
        String strM63704b2 = C10344c.m63704b(data, "salChannel");
        String strM63704b3 = C10344c.m63704b(data, "activityCode");
        String strM63704b4 = C10344c.m63704b(data, "pkg_name");
        Intent intent = new Intent(context, (Class<?>) IntelligentClearActivity.class);
        intent.putExtra("channel_refer", "5");
        intent.putExtra("srcChannel", strM63704b);
        intent.putExtra("salChannel", strM63704b2);
        intent.putExtra("activityCode", strM63704b3);
        intent.putExtra("pkg_name", strM63704b4);
        C11296s.m67817h(context, "ENTER_INTELLIGENT_CLEAR_ACTIVITY", "1", C13452e.m80781L().m80971t0(), "5");
        UBAAnalyze.m29950K("CKC", "ENTER_INTELLIGENT_CLEAR_ACTIVITY", "1", "5");
        context.startActivity(intent);
        return true;
    }

    /* renamed from: D */
    public final boolean m83733D(Context context, SafeIntent safeIntent) {
        if (safeIntent == null) {
            return false;
        }
        String stringExtra = safeIntent.getStringExtra("srcChannel");
        String stringExtra2 = safeIntent.getStringExtra("salChannel");
        String stringExtra3 = safeIntent.getStringExtra("activityCode");
        String stringExtra4 = safeIntent.getStringExtra("pkg_name");
        Intent intent = new Intent(context, (Class<?>) IntelligentClearActivity.class);
        intent.putExtra("channel_refer", "0");
        intent.putExtra("srcChannel", stringExtra);
        intent.putExtra("salChannel", stringExtra2);
        intent.putExtra("activityCode", stringExtra3);
        intent.putExtra("pkg_name", stringExtra4);
        C11296s.m67817h(context, "ENTER_INTELLIGENT_CLEAR_ACTIVITY", "1", C13452e.m80781L().m80971t0(), "0");
        UBAAnalyze.m29950K("CKC", "ENTER_INTELLIGENT_CLEAR_ACTIVITY", "1", "0");
        context.startActivity(intent);
        return true;
    }

    /* renamed from: E */
    public final boolean m83734E(Context context, SafeIntent safeIntent, String str) {
        C11839m.m70688i("EntranceTransUtil", "startInterimBackupView");
        if (!C0209d.m1166E1()) {
            return false;
        }
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("funcfg_cloud_backup");
        C11839m.m70688i("EntranceTransUtil", "the funcfg cloud backup is:" + zM62395t1);
        if (!zM62395t1) {
            return false;
        }
        m83773v(context, safeIntent, TempBackupCheckActivity.class, "CLOUDBACKUP_ENTER_INTERIM_BACKUP", str);
        return true;
    }

    /* renamed from: F */
    public final boolean m83735F(Context context, SafeIntent safeIntent) {
        try {
            Uri data = safeIntent.getData();
            String strM63704b = C10344c.m63704b(data, "enter");
            String strM63704b2 = C10344c.m63704b(data, "srcChannel");
            String strM63704b3 = C10344c.m63704b(data, "salChannel");
            String strM63704b4 = C10344c.m63704b(data, "activityCode");
            String strM63704b5 = C10344c.m63704b(data, "pkg_name");
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(NotifyConstants.InterfaceC4908FA.PACKAGE_NAME, NotifyConstants.InterfaceC4908FA.ACTIVITY_MAIN_ABILITY);
            intent.putExtra("ohos.extra.param.key.INSTALL_ON_DEMAND", true);
            intent.setComponent(componentName);
            C10045a.m62452b(context, intent);
            intent.putExtra("channel_refer", "5");
            intent.putExtra("nav_source", 2);
            intent.putExtra("srcChannel", strM63704b2);
            intent.putExtra("salChannel", strM63704b3);
            intent.putExtra("activityCode", strM63704b4);
            intent.putExtra("pkg_name", strM63704b5);
            if (safeIntent.getBooleanExtra(HNConstants.C4906BI.FROM_NOTIFY, false)) {
                intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
                String stringExtra = safeIntent.getStringExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY);
                intent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, stringExtra);
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.contains("recommend_card_notification")) {
                    intent.putExtra("recommend_card_activity_id", safeIntent.getStringExtra("recommend_card_activity_id"));
                    intent.putExtra("recommend_card_activity_type", safeIntent.getStringExtra("recommend_card_activity_type"));
                    intent.putExtra("recommend_card_entrance", safeIntent.getStringExtra("recommend_card_entrance"));
                    new C13149f().m79065c(context, intent, "5");
                }
            }
            C13227f.m79492i1().m79495h1("ENTER_MAIN_ABILITY", "1", C13452e.m80781L().m80971t0(), "5", strM63704b3, strM63704b2, strM63704b4, strM63704b, strM63704b5);
            UBAAnalyze.m29951L("CKC", "ENTER_MAIN_ABILITY", "1", "5", strM63704b3, strM63704b2, strM63704b4, strM63704b5);
            context.startActivity(intent);
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("EntranceTransUtil", "startMainAbilityByBrowser exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: G */
    public final boolean m83736G(Context context, SafeIntent safeIntent, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m83773v(context, safeIntent, MainActivity.class, "CLOUDBACKUP_ENTER_MAIN", str);
        new HwAnimationReflection(context).m15927c(2);
        return true;
    }

    /* renamed from: H */
    public final boolean m83737H(Context context, SafeIntent safeIntent) {
        C11839m.m70688i("EntranceTransUtil", "startMessageCenterView");
        return m83768q(context, safeIntent, new Intent(context, (Class<?>) MessageCenterActivity.class));
    }

    /* renamed from: I */
    public final boolean m83738I(Context context, SafeIntent safeIntent) {
        String strM83764m = m83764m(safeIntent.getStringExtra("url"));
        if (!m83756d(strM83764m)) {
            C11839m.m70687e("EntranceTransUtil", "url host check failed");
            return false;
        }
        String stringExtra = safeIntent.getStringExtra("srcChannel");
        String stringExtra2 = safeIntent.getStringExtra("salChannel");
        String stringExtra3 = safeIntent.getStringExtra("activityCode");
        String stringExtra4 = safeIntent.getStringExtra("pkg_name");
        String string = context.getString(R$string.HiCloud_app_name);
        Intent intent = new Intent(context, (Class<?>) OperationWebViewActivity.class);
        intent.putExtra("url", strM83764m);
        intent.putExtra("title", string);
        intent.putExtra("isEnableJs", true);
        C13227f.m79492i1().m79494g1("ENTER_PHONE_FINDER_WEBVIEW", "1", C13452e.m80781L().m80971t0(), "0", stringExtra2, stringExtra, stringExtra3);
        UBAAnalyze.m29951L("CKC", "ENTER_PHONE_FINDER_WEBVIEW", "1", "0", stringExtra2, stringExtra, stringExtra3, stringExtra4);
        context.startActivity(intent);
        return true;
    }

    /* renamed from: J */
    public final boolean m83739J(Context context, SafeIntent safeIntent, String str) {
        if (!C11829c.m70528K0()) {
            return false;
        }
        m83773v(context, safeIntent, OrderListActivity.class, "TRADE_RECORD", str);
        return true;
    }

    /* renamed from: K */
    public final boolean m83740K(Context context, SafeIntent safeIntent) {
        Uri data = safeIntent.getData();
        if (data == null) {
            return false;
        }
        String path = data.getPath();
        if (!"/voucherListFragment".equals(path)) {
            C11839m.m70687e("EntranceTransUtil", "startPaymentManagerView invalid path = " + path);
            return false;
        }
        String strM63704b = C10344c.m63704b(data, "srcChannel");
        String strM63704b2 = C10344c.m63704b(data, "salChannel");
        String strM63704b3 = C10344c.m63704b(data, "activityCode");
        String strM63704b4 = C10344c.m63704b(data, "pkg_name");
        Intent intent = new Intent(context, (Class<?>) PaymentManagerAndOrderActivity.class);
        intent.putExtra("nav_source", 13);
        intent.putExtra("srcChannel", strM63704b);
        intent.putExtra("salChannel", strM63704b2);
        intent.putExtra("activityCode", strM63704b3);
        intent.putExtra("pkg_name", strM63704b4);
        context.startActivity(intent);
        return true;
    }

    /* renamed from: L */
    public final boolean m83741L(Context context, SafeIntent safeIntent) {
        try {
            String strM63704b = C10344c.m63704b(safeIntent.getData(), "tab");
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.hidisk", "com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity"));
            intent.putExtra("tab", strM63704b);
            intent.putExtra(RemoteMessageConst.FROM, NotifyConstants.TYPE_DEEPLINK);
            intent.putExtra("isSystemAcc", true);
            intent.putExtra("isFromInner", true);
            intent.putExtra("isEnableJs", true);
            intent.putExtra("needShowLoading", true);
            intent.setFlags(268468224);
            context.startActivity(intent);
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("EntranceTransUtil", "startPhoneFinderSlaveByBrowser exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: M */
    public final boolean m83742M(Context context, SafeIntent safeIntent) {
        C11839m.m70688i("EntranceTransUtil", "startSilenceDevicePage");
        Intent intent = new Intent(context, (Class<?>) OverdueBackupRecordsActivity.class);
        Uri data = safeIntent.getData();
        if (data != null) {
            String strM63704b = C10344c.m63704b(data, "srcChannel");
            String strM63704b2 = C10344c.m63704b(data, "salChannel");
            String strM63704b3 = C10344c.m63704b(data, "activityCode");
            C11839m.m70686d("EntranceTransUtil", "src: " + strM63704b + ", sal: " + strM63704b2 + ", activityCode: " + strM63704b3);
            intent.putExtra("srcChannel", strM63704b);
            intent.putExtra("salChannel", strM63704b2);
            intent.putExtra("activityCode", strM63704b3);
            intent.putExtra("from_where", safeIntent.getStringExtra("from_where"));
            intent.putExtra("startupSource", safeIntent.getStringExtra("startupSource"));
            intent.putExtra("startupSourceId", safeIntent.getStringExtra("startupSourceId"));
            intent.putExtra("cfgId", safeIntent.getStringExtra("cfgId"));
        }
        context.startActivity(intent);
        return true;
    }

    /* renamed from: N */
    public final boolean m83743N(Context context, SafeIntent safeIntent) {
        if (!C0209d.m1166E1() || !C10028c.m62182c0().m62395t1("funcfg_cloud_backup")) {
            return false;
        }
        m83773v(context, safeIntent, CloudSpaceBackupActivity.class, "CLOUDBACKUP_ENTER_BACKUP", "0002");
        return true;
    }

    /* renamed from: O */
    public final boolean m83744O(Context context, SafeIntent safeIntent) {
        Uri data;
        if (!C11829c.m70528K0() || (data = safeIntent.getData()) == null) {
            return false;
        }
        String path = data.getPath();
        String strM63704b = C10344c.m63704b(data, "campaignID");
        String strM63704b2 = C10344c.m63704b(data, "srcChannel");
        String strM63704b3 = C10344c.m63704b(data, "sceneCode");
        String strM63704b4 = C10344c.m63704b(safeIntent.getData(), "sceneId");
        String strM63704b5 = C10344c.m63704b(safeIntent.getData(), "userLabel");
        String strM63704b6 = C10344c.m63704b(data, "salChannel");
        String strM63704b7 = C10344c.m63704b(data, "showToast");
        String strM63704b8 = C10344c.m63704b(data, "appId");
        String strM63704b9 = C10344c.m63704b(data, "thirdApp");
        String strM63704b10 = C10344c.m63704b(data, "packageName");
        String strM63704b11 = C10344c.m63704b(data, "activityCode");
        String strM63704b12 = C10344c.m63704b(data, "specifiedPackageId");
        String strM63704b13 = C10344c.m63704b(data, "pkg_name");
        String strM63704b14 = C10344c.m63704b(data, "enter");
        Bundle bundle = new Bundle();
        bundle.putString("srcChannel", strM63704b2);
        bundle.putString("sceneCode", strM63704b3);
        bundle.putString("sceneId", strM63704b4);
        bundle.putString("userLabel", strM63704b5);
        m83765n(strM63704b2, strM63704b3, strM63704b4, strM63704b5);
        bundle.putString("salChannel", strM63704b6);
        bundle.putString("showToast", strM63704b7);
        bundle.putString("activityCode", strM63704b11);
        bundle.putString("pkg_name", strM63704b13);
        bundle.putInt("nav_source", 2);
        bundle.putString("specified_pkg_id_key", strM63704b12);
        bundle.putInt("from_where", 9);
        bundle.putString(NotifyConstants.CloudStorageConstants.AD_NAME_KEY, strM63704b);
        bundle.putString("appId", strM63704b8);
        if (Boolean.parseBoolean(strM63704b9)) {
            bundle.putString("channel_refer", "7");
            bundle.putInt("nav_source", 9);
            bundle.putString("packageName", strM63704b10);
        } else {
            bundle.putString("channel_refer", "5");
        }
        if ("/startPay".equals(path)) {
            bundle.putString("package_id", C10344c.m63704b(data, "packageId"));
            bundle.putInt("from_where", 1);
            bundle.putString(Inviter.INVITE_CODE, C10344c.m63704b(data, Inviter.INVITE_CODE));
            bundle.putString("tranUrlSuccess", C10344c.m63704b(data, "tranUrlSuccess"));
            bundle.putString("tranUrlFail", C10344c.m63704b(data, "tranUrlFail"));
            bundle.putString("verifyIsAutoPay", C10344c.m63704b(data, "verifyIsAutoPay"));
        }
        bundle.putString("payResultType", C10344c.m63704b(data, "payResultType"));
        bundle.putString("payResultUrl", C10344c.m63704b(data, "payResultUrl"));
        String strM63704b15 = C10344c.m63704b(data, "activityId");
        AbstractC10896a.m65885d("EntranceTransUtil", "activeId:" + strM63704b15);
        bundle.putString("activityId", strM63704b15);
        String strM63704b16 = C10344c.m63704b(data, Constants.CONTENT_SERVER_REALM);
        AbstractC10896a.m65885d("EntranceTransUtil", "action:" + strM63704b16);
        bundle.putString(Constants.CONTENT_SERVER_REALM, strM63704b16);
        String strM63704b17 = C10344c.m63704b(data, "forOtherPage");
        AbstractC10896a.m65885d("EntranceTransUtil", "forOtherPage:" + strM63704b17);
        if (!TextUtils.isEmpty(strM63704b17)) {
            bundle.putString("forOtherPage", strM63704b17);
        }
        if (safeIntent.getBooleanExtra(HNConstants.C4906BI.FROM_NOTIFY, false)) {
            bundle.putBoolean(HNConstants.C4906BI.FROM_NOTIFY, true);
            String stringExtra = safeIntent.getStringExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY);
            bundle.putString(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, stringExtra);
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.contains("recommend_card_notification")) {
                bundle.putString("recommend_card_activity_id", safeIntent.getStringExtra("recommend_card_activity_id"));
                bundle.putString("recommend_card_activity_type", safeIntent.getStringExtra("recommend_card_activity_type"));
                bundle.putString("recommend_card_entrance", safeIntent.getStringExtra("recommend_card_entrance"));
            }
        }
        C11839m.m70688i("EntranceTransUtil", "upgrade srcChannel: " + strM63704b2 + ", salChannel: " + strM63704b6 + ", code: " + strM63704b11);
        if (TextUtils.isEmpty(strM63704b14) || !strM63704b14.equals("HuaweiCard")) {
            C12126b.m72707c("5", bundle);
            return true;
        }
        bundle.putString("enter", "HuaweiCard");
        C12515a.m75110o().m75172d(new ClickExchangeTask(context, 3, strM63704b2, strM63704b11, "5", bundle));
        return true;
    }

    /* renamed from: P */
    public final boolean m83745P(SafeIntent safeIntent) {
        if (!C11829c.m70528K0()) {
            return false;
        }
        String stringExtra = safeIntent.getStringExtra("srcChannel");
        String stringExtra2 = safeIntent.getStringExtra("salChannel");
        String stringExtra3 = safeIntent.getStringExtra("showToast");
        String stringExtra4 = safeIntent.getStringExtra("activityCode");
        String stringExtra5 = safeIntent.getStringExtra("specifiedPackageId");
        Bundle bundle = new Bundle();
        bundle.putString("channel_refer", "0");
        bundle.putInt("nav_source", 1);
        bundle.putString("srcChannel", stringExtra);
        bundle.putString("salChannel", stringExtra2);
        bundle.putString("showToast", stringExtra3);
        bundle.putString("activityCode", stringExtra4);
        bundle.putString("specified_pkg_id_key", stringExtra5);
        C11839m.m70688i("EntranceTransUtil", "upgrade srcChannel: " + stringExtra + ", salChannel: " + stringExtra2 + ", code: " + stringExtra4);
        C12126b.m72707c("0", bundle);
        return true;
    }

    /* renamed from: Q */
    public final boolean m83746Q(Context context, SafeIntent safeIntent) {
        C11839m.m70688i("EntranceTransUtil", "startTaskCenter");
        if (!C10028c.m62182c0().m62413x()) {
            NotifyLogger.m29916w("EntranceTransUtil", "startTaskCenter extendFuncSwitch is false");
            return false;
        }
        Uri data = safeIntent.getData();
        if (data == null) {
            return false;
        }
        String path = data.getPath();
        if (!"/getInfo".equals(path)) {
            C11839m.m70687e("EntranceTransUtil", "invalid uriPath: " + path);
            return false;
        }
        C11839m.m70688i("EntranceTransUtil", "match URI_GET_INFO");
        String strM63704b = C10344c.m63704b(data, "url");
        if (TextUtils.isEmpty(strM63704b)) {
            C11839m.m70689w("EntranceTransUtil", "startH5CampaignWeb url is null");
        }
        String strM63704b2 = C10344c.m63704b(data, "srcChannel");
        String strM63704b3 = C10344c.m63704b(data, "activityCode");
        String strM63704b4 = C10344c.m63704b(data, "taskActivityId");
        String strM63704b5 = C10344c.m63704b(data, NotifyConstants.Keys.NOTIFY_TYPE);
        C11839m.m70686d("EntranceTransUtil", "src: " + strM63704b2 + ", code: " + strM63704b3 + ", taskActivityId: " + strM63704b4 + ",notifyType:" + strM63704b5);
        Intent intent = new Intent(context, (Class<?>) CampaignActivity.class);
        intent.putExtra("url", strM63704b);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("srcChannel", strM63704b2);
        intent.putExtra("activityCode", strM63704b3);
        intent.putExtra("taskActivityId", strM63704b4);
        intent.putExtra(NotifyConstants.Keys.NOTIFY_TYPE, strM63704b5);
        intent.putExtra("is_activity_need_back_to_main", false);
        intent.putExtra("entrance_from", strM63704b2);
        String stringExtra = safeIntent.getStringExtra("unique_id");
        if (!TextUtils.isEmpty(stringExtra)) {
            intent.putExtra("unique_id", stringExtra);
        }
        m83753a(intent);
        context.startActivity(intent);
        return true;
    }

    /* renamed from: R */
    public final boolean m83747R(Context context, SafeIntent safeIntent) {
        try {
            if (safeIntent == null) {
                C11839m.m70689w("EntranceTransUtil", "ecology safeIntent is null, return");
                return false;
            }
            String stringExtra = safeIntent.getStringExtra("srcChannel");
            String stringExtra2 = safeIntent.getStringExtra("salChannel");
            String stringExtra3 = safeIntent.getStringExtra("activityCode");
            String stringExtra4 = safeIntent.getStringExtra("ecologyType");
            String stringExtra5 = safeIntent.getStringExtra("pkg_name");
            String stringExtra6 = safeIntent.getStringExtra("url");
            String stringExtra7 = safeIntent.getStringExtra("ecologyMode");
            C11839m.m70688i("EntranceTransUtil", "ecologyMode = " + stringExtra7 + ", ecologyType = " + stringExtra4 + ", url = " + stringExtra6);
            Intent intentM65688o = C10794j.m65688o(context, stringExtra7, stringExtra4, stringExtra6);
            if (intentM65688o == null) {
                C11839m.m70689w("EntranceTransUtil", "ecology jumpinto intent is null, return");
                return false;
            }
            intentM65688o.putExtra("channel_refer", "0");
            intentM65688o.putExtra("srcChannel", stringExtra);
            intentM65688o.putExtra("salChannel", stringExtra2);
            intentM65688o.putExtra("activityCode", stringExtra3);
            intentM65688o.putExtra("ecologyMode", stringExtra7);
            intentM65688o.putExtra("ecologyType", stringExtra4);
            intentM65688o.putExtra("url", stringExtra6);
            intentM65688o.putExtra("pkg_name", stringExtra5);
            C11296s.m67817h(context, "ENTER_TOOL_ECOLOGY_ACTIVITY", "1", C13452e.m80781L().m80971t0(), "0");
            UBAAnalyze.m29950K("CKC", "ENTER_TOOL_ECOLOGY_ACTIVITY", "1", "0");
            context.startActivity(intentM65688o);
            return true;
        } catch (Exception e10) {
            C11839m.m70687e("EntranceTransUtil", "startMainAbilityByBrowser exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: S */
    public final boolean m83748S(Context context, SafeIntent safeIntent) {
        Intent intent = new Intent(context, (Class<?>) CloudSpaceUpgradeActivity.class);
        intent.putExtra("from_where", 6);
        m83766o(safeIntent, intent);
        context.startActivity(intent);
        return true;
    }

    /* renamed from: T */
    public final boolean m83749T(Context context, SafeIntent safeIntent) {
        String stringExtra = safeIntent.getStringExtra("iap_intent_voucher_info");
        Intent intent = new Intent(context, (Class<?>) CloudSpaceUpgradeActivity.class);
        intent.putExtra("iap_intent_voucher_info", stringExtra);
        intent.putExtra("from_where", 9);
        Uri data = safeIntent.getData();
        if (data != null) {
            String strM63704b = C10344c.m63704b(data, "salChannel");
            String strM63704b2 = C10344c.m63704b(data, "srcChannel");
            String strM63704b3 = C10344c.m63704b(data, "activityCode");
            intent.putExtra("srcChannel", strM63704b2);
            intent.putExtra("activityCode", strM63704b3);
            intent.putExtra("salChannel", strM63704b);
        }
        m83766o(safeIntent, intent);
        context.startActivity(intent);
        return true;
    }

    /* renamed from: U */
    public final boolean m83750U(Context context, SafeIntent safeIntent) {
        int i10;
        boolean z10;
        C11839m.m70688i("EntranceTransUtil", "startWebViewByBrowser");
        Uri data = safeIntent.getData();
        if (data == null) {
            return false;
        }
        String path = data.getPath();
        if ("/startWeb".equals(path)) {
            C11839m.m70688i("EntranceTransUtil", "match URI_WEB_PATH");
            i10 = 0;
        } else {
            if (!"/startWebForMonth".equals(path)) {
                C11839m.m70687e("EntranceTransUtil", "invalid uriPath: " + path);
                return false;
            }
            C11839m.m70688i("EntranceTransUtil", "match URI_WEB_PATH_FOR_MONTH");
            if (!C13452e.m80781L().m80971t0().equals(C10344c.m63704b(data, "uid"))) {
                C11839m.m70687e("EntranceTransUtil", "not match current user");
                return false;
            }
            i10 = 1;
        }
        String strM63704b = C10344c.m63704b(data, "url");
        if (TextUtils.isEmpty(strM63704b)) {
            C11839m.m70687e("EntranceTransUtil", "startH5OperationWeb url is null");
            return false;
        }
        String strM63704b2 = C10344c.m63704b(data, "srcChannel");
        String strM63704b3 = C10344c.m63704b(data, "salChannel");
        String strM63704b4 = C10344c.m63704b(data, "activityCode");
        String strM63704b5 = C10344c.m63704b(data, "pkg_name");
        String strM63704b6 = C10344c.m63704b(data, "appId");
        int i11 = i10;
        C11839m.m70686d("EntranceTransUtil", "src: " + strM63704b2 + ", sal: " + strM63704b3 + ", code: " + strM63704b4);
        Intent intent = new Intent(context, (Class<?>) OperationWebViewActivity.class);
        intent.putExtra("channel_refer", "5");
        intent.putExtra("nav_source", 2);
        if (TextUtils.equals(strM63704b2, "542")) {
            intent.putExtra("is_activity_need_back_to_main", true);
            z10 = false;
        } else {
            z10 = false;
            intent.putExtra("is_activity_need_back_to_main", false);
        }
        intent.putExtra("url", strM63704b);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("srcChannel", strM63704b2);
        intent.putExtra("salChannel", strM63704b3);
        intent.putExtra("action_bar_color_hm_os_bg", safeIntent.getBooleanExtra("action_bar_color_hm_os_bg", z10));
        intent.putExtra("is_support_dark_mode", safeIntent.getBooleanExtra("is_support_dark_mode", z10));
        intent.putExtra("activityCode", strM63704b4);
        intent.putExtra("pkg_name", strM63704b5);
        intent.putExtra("appId", strM63704b6);
        intent.putExtra("launch_web_type", i11);
        m83753a(intent);
        if (safeIntent.getBooleanExtra(HNConstants.C4906BI.FROM_NOTIFY, z10)) {
            intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
            String stringExtra = safeIntent.getStringExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY);
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.contains("recommend_card_notification")) {
                intent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, stringExtra);
                intent.putExtra("recommend_card_activity_id", safeIntent.getStringExtra("recommend_card_activity_id"));
                intent.putExtra("recommend_card_activity_type", safeIntent.getStringExtra("recommend_card_activity_type"));
                intent.putExtra("recommend_card_entrance", safeIntent.getStringExtra("recommend_card_entrance"));
            }
        }
        C11296s.m67817h(context, "ENTER_H5_OPERATOR", "1", C13452e.m80781L().m80971t0(), "5");
        UBAAnalyze.m29950K("CKC", "ENTER_H5_OPERATOR", "1", "5");
        context.startActivity(intent);
        return true;
    }

    /* renamed from: V */
    public final boolean m83751V(Context context, SafeIntent safeIntent) {
        C11839m.m70688i("EntranceTransUtil", "start WebViewActivity");
        String stringExtra = safeIntent.getStringExtra("srcChannel");
        String stringExtra2 = safeIntent.getStringExtra("salChannel");
        String stringExtra3 = safeIntent.getStringExtra("activityCode");
        String stringExtra4 = safeIntent.getStringExtra("url");
        String stringExtra5 = safeIntent.getStringExtra("appId");
        C11839m.m70686d("EntranceTransUtil", "src: " + stringExtra + ", sal: " + stringExtra2 + ", code: " + stringExtra3);
        if (TextUtils.isEmpty(stringExtra4)) {
            C11839m.m70687e("EntranceTransUtil", "WebViewActivity url is null");
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) OperationWebViewActivity.class);
        intent.putExtra("channel_refer", "0");
        intent.putExtra("nav_source", 1);
        intent.putExtra("is_activity_need_back_to_main", false);
        intent.putExtra("url", stringExtra4);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("srcChannel", stringExtra);
        intent.putExtra("salChannel", stringExtra2);
        intent.putExtra("activityCode", stringExtra3);
        intent.putExtra("appId", stringExtra5);
        intent.putExtra("launch_web_type", 0);
        m83753a(intent);
        C11296s.m67817h(context, "ENTER_H5_OPERATOR", "1", C13452e.m80781L().m80971t0(), "0");
        UBAAnalyze.m29950K("CKC", "ENTER_H5_OPERATOR", "1", "0");
        context.startActivity(intent);
        return true;
    }

    /* renamed from: W */
    public boolean m83752W(Context context, SafeIntent safeIntent) {
        if (context == null) {
            return false;
        }
        C10811y.m65827k(safeIntent);
        if (m83763l(safeIntent)) {
            return m83760i(context, safeIntent);
        }
        if (m83762k(safeIntent)) {
            return m83758g(context, safeIntent);
        }
        C11839m.m70689w("EntranceTransUtil", "illegal transfer intent");
        return false;
    }

    /* renamed from: a */
    public void m83753a(Intent intent) {
        AdParametersExt adParametersExtM63035a = C10121i.m63035a();
        if (adParametersExtM63035a == null) {
            C11839m.m70688i("EntranceTransUtil", "adParameters is null");
            return;
        }
        intent.putExtra("agd_resource_enable", adParametersExtM63035a.getEnabled());
        intent.putExtra("agd_resource_slot_id", adParametersExtM63035a.getAgdAdid());
        intent.putExtra("pps_threshold", adParametersExtM63035a.getThreshold());
    }

    /* renamed from: b */
    public final boolean m83754b(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("EntranceTransUtil", "checkHostBySysParam, host is null");
            return false;
        }
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C11839m.m70687e("EntranceTransUtil", "checkHostBySysParam, hiCloudSysParamMap is null");
            return false;
        }
        String pushUrlHostAllowList = hiCloudSysParamMapM60757p.getPushUrlHostAllowList();
        if (TextUtils.isEmpty(pushUrlHostAllowList)) {
            C11839m.m70687e("EntranceTransUtil", "checkHostBySysParam, hostAllowList is null");
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(pushUrlHostAllowList);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                if (TextUtils.equals(str, jSONArray.getString(i10))) {
                    C11839m.m70688i("EntranceTransUtil", "checkHostBySysParam correct host match");
                    return true;
                }
            }
            C11839m.m70687e("EntranceTransUtil", "checkHostBySysParam no host match");
            return false;
        } catch (JSONException e10) {
            C11839m.m70687e("EntranceTransUtil", "checkHostBySysParam catch exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: c */
    public final boolean m83755c(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("EntranceTransUtil", "checkHostLocal, host is null");
            return false;
        }
        String strM8322b = C1445c.m8322b("push.hicloud");
        String strM8322b2 = C1445c.m8322b("push.dbankcloud");
        if (TextUtils.equals(strM8322b, str) || TextUtils.equals(strM8322b2, str)) {
            C11839m.m70688i("EntranceTransUtil", "checkHostLocal, correct host match");
            return true;
        }
        C11839m.m70688i("EntranceTransUtil", "checkHostLocal, no host match");
        return false;
    }

    /* renamed from: d */
    public final boolean m83756d(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("EntranceTransUtil", "checkUrlHost, urlStr is empty");
            return false;
        }
        String strM68805b = C11526c.m68805b(str);
        if (m83754b(strM68805b)) {
            C11839m.m70688i("EntranceTransUtil", "checkHostBySysParam success");
            return true;
        }
        if (m83755c(strM68805b)) {
            C11839m.m70688i("EntranceTransUtil", "checkHostLocal success");
            return true;
        }
        C11839m.m70687e("EntranceTransUtil", "checkUrlHost, url host invalid");
        return false;
    }

    /* renamed from: f */
    public final boolean m83757f(Context context, String str, SafeIntent safeIntent) {
        str.hashCode();
        switch (str) {
            case "Gallery_sync":
                return m83731B(context, safeIntent, "0002");
            case "Backup_options":
            case "Backup_recovery":
            case "Backup_app_data_options":
                return m83770s(context, safeIntent, "0002");
            case "ManageSpace_contact":
            case "ManageSpace_disk":
            case "ManageSpace_note":
            case "ManageSpace_wlan":
            case "ManageSpace_share":
            case "ManageSpace_calendar":
            case "ManageSpace_gallery":
            case "ManageSpace_backup":
                return m83772u(context, safeIntent, "0002");
            default:
                return m83777z(context);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:151:0x002d  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m83758g(android.content.Context r6, com.huawei.secure.android.common.intent.SafeIntent r7) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p807yd.C13946b.m83758g(android.content.Context, com.huawei.secure.android.common.intent.SafeIntent):boolean");
    }

    /* renamed from: h */
    public final boolean m83759h(Context context, String str, SafeIntent safeIntent) {
        str.hashCode();
        switch (str) {
            case "Gallery_sync":
                return m83731B(context, safeIntent, "0001");
            case "Backup_options":
            case "Backup_recovery":
            case "Backup_app_data_options":
                return m83770s(context, safeIntent, "0001");
            case "ManageSpace_contact":
            case "ManageSpace_disk":
            case "ManageSpace_note":
            case "ManageSpace_wlan":
            case "ManageSpace_share":
            case "ManageSpace_calendar":
            case "ManageSpace_gallery":
            case "ManageSpace_backup":
                return m83772u(context, safeIntent, "0001");
            default:
                return m83777z(context);
        }
    }

    /* renamed from: i */
    public final boolean m83760i(Context context, SafeIntent safeIntent) {
        String strM53581f;
        C0239x.m1671c().m1677g("0001");
        strM53581f = safeIntent.m53581f("path");
        strM53581f.hashCode();
        switch (strM53581f) {
            case "PhoneFinderActivity":
                return m83730A(context, safeIntent, "0001");
            case "ToolEcologyActivity":
                return m83747R(context, safeIntent);
            case "OrderListActivity":
                return m83739J(context, safeIntent, "0001");
            case "PackageInfoActivity":
                return m83745P(safeIntent);
            case "HisyncSpaceDetailActivity":
                return m83772u(context, safeIntent, "0001");
            case "GalleryMainActivity":
                return m83731B(context, safeIntent, "0001");
            case "IntelligentClearActivity":
                return m83733D(context, safeIntent);
            case "PaymentManagerAndOrderActivity":
                return m83740K(context, safeIntent);
            case "BackupMainActivity":
                return m83770s(context, safeIntent, "0001");
            case "PhoneFinderWebView":
                return m83738I(context, safeIntent);
            case "OperationWebViewActivity":
                return m83751V(context, safeIntent);
            case "MainActivity":
                return m83736G(context, safeIntent, "0001");
            default:
                return m83759h(context, strM53581f, safeIntent);
        }
    }

    /* renamed from: j */
    public boolean m83761j(SafeIntent safeIntent) {
        Boolean bool = Boolean.FALSE;
        String action = safeIntent.getAction();
        if (!TextUtils.isEmpty(action) && action.equals("com.huawei.hidisk.push.action")) {
            bool = Boolean.TRUE;
        }
        String scheme = safeIntent.getScheme();
        C11839m.m70686d("EntranceTransUtil", "isAbleToNavBySchema action：" + action + " scheme:" + scheme);
        if (!TextUtils.isEmpty(scheme) && scheme.equals("hicloud")) {
            bool = Boolean.TRUE;
        }
        return bool.booleanValue();
    }

    /* renamed from: k */
    public final boolean m83762k(SafeIntent safeIntent) {
        String scheme = safeIntent.getScheme();
        return !TextUtils.isEmpty(scheme) && scheme.equals("hicloud");
    }

    /* renamed from: l */
    public final boolean m83763l(SafeIntent safeIntent) {
        String action = safeIntent.getAction();
        return !TextUtils.isEmpty(action) && action.equals("com.huawei.hidisk.push.action");
    }

    /* renamed from: m */
    public final String m83764m(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("EntranceTransUtil", "original url is null");
            return null;
        }
        try {
            String strM72864a = C12158a.m72864a(str, Constants.UTF_8);
            if (!strM72864a.contains("param1=UID")) {
                C11839m.m70687e("EntranceTransUtil", "original url not contain UID");
                return strM72864a;
            }
            String strM80971t0 = C13452e.m80781L().m80971t0();
            if (TextUtils.isEmpty(strM80971t0)) {
                C11839m.m70687e("EntranceTransUtil", "user id is null");
                return strM72864a.replace("param1=UID", "param1=NA");
            }
            return strM72864a.replace("param1=UID", "param1=" + strM80971t0);
        } catch (C9721b e10) {
            C11839m.m70687e("EntranceTransUtil", "decode url exception: " + e10.toString());
            return str;
        }
    }

    /* renamed from: n */
    public final void m83765n(String str, String str2, String str3, String str4) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (!TextUtils.isEmpty(str)) {
            linkedHashMap.put("srcChannel", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            linkedHashMap.put("sceneCode", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            linkedHashMap.put("sceneId", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            linkedHashMap.put("userLabel", str4);
        }
        linkedHashMap.put("isBasicBusiness", String.valueOf(C13452e.m80781L().m80791C0()));
        C13227f.m79492i1().m79567R("gallery_openswitch_data_info", linkedHashMap);
        UBAAnalyze.m29947H("PVC", "gallery_openswitch_data_info", linkedHashMap);
    }

    /* renamed from: o */
    public final void m83766o(SafeIntent safeIntent, Intent intent) {
        if (safeIntent == null || intent == null) {
            C11839m.m70687e("EntranceTransUtil", "input intent is null");
        } else if (safeIntent.getBooleanExtra("isFromNoticeBeforeBackupActivity", false)) {
            intent.putExtra("is_support_orientation", true);
            intent.putExtra("is_support_dark_mode", true);
        }
    }

    /* renamed from: p */
    public final void m83767p(Intent intent, String str, String str2) {
        if (intent == null) {
            C11839m.m70686d("EntranceTransUtil", "intent is null");
            return;
        }
        if (TextUtils.equals(str, "MainActivity")) {
            C11839m.m70686d("EntranceTransUtil", "goto main activity");
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        } else if (TextUtils.isEmpty(str2) || !"HuaweiService".equals(str2)) {
            intent.addFlags(268468224);
        } else {
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
    }

    /* renamed from: q */
    public final boolean m83768q(Context context, SafeIntent safeIntent, Intent intent) {
        Uri data = safeIntent.getData();
        if (data != null) {
            String strM63704b = C10344c.m63704b(data, "srcChannel");
            C11839m.m70686d("EntranceTransUtil", "src: " + strM63704b);
            intent.putExtra("srcChannel", strM63704b);
        }
        context.startActivity(intent);
        return true;
    }

    /* renamed from: r */
    public final boolean m83769r(Context context, SafeIntent safeIntent, String str) {
        if (!C0209d.m1166E1() || !C10028c.m62182c0().m62395t1("funcfg_cloud_backup")) {
            return false;
        }
        m83773v(context, safeIntent, BackupOptionsActivity.class, "ENTER_BACKUP_OPTION", str);
        return true;
    }

    /* renamed from: s */
    public final boolean m83770s(Context context, SafeIntent safeIntent, String str) {
        if (!C0209d.m1166E1() || !C10028c.m62182c0().m62395t1("funcfg_cloud_backup")) {
            return false;
        }
        m83773v(context, safeIntent, BackupMainActivity.class, "CLOUDBACKUP_ENTER_BACKUP", str);
        return true;
    }

    /* renamed from: t */
    public final boolean m83771t(Context context, SafeIntent safeIntent) {
        String stringExtra = safeIntent.getStringExtra("iap_intent_voucher_info");
        Intent intent = new Intent(context, (Class<?>) PurchaseCloudCardActivity.class);
        intent.putExtra("iap_intent_voucher_info", stringExtra);
        context.startActivity(intent);
        return true;
    }

    /* renamed from: u */
    public final boolean m83772u(Context context, SafeIntent safeIntent, String str) {
        if (!C11829c.m70528K0()) {
            return false;
        }
        m83773v(context, safeIntent, HisyncSpaceDetailActivity.class, "CLOUDBACKUP_ENTER_CLOUD_SPACE", str);
        return true;
    }

    /* renamed from: v */
    public final void m83773v(Context context, SafeIntent safeIntent, Class<?> cls, String str, String str2) {
        C11839m.m70688i("EntranceTransUtil", "startCommonActivity: " + cls);
        if (cls == null) {
            C11839m.m70689w("EntranceTransUtil", "illegal cls");
            return;
        }
        str2.hashCode();
        if (str2.equals("0001")) {
            m83775x(context, safeIntent, cls, str);
            return;
        }
        if (str2.equals("0002")) {
            m83774w(context, safeIntent, cls, str);
            return;
        }
        C11839m.m70689w("EntranceTransUtil", "illegal source type: " + str2);
    }

    /* renamed from: w */
    public final void m83774w(Context context, SafeIntent safeIntent, Class<?> cls, String str) {
        String str2;
        C13946b c13946b;
        Uri data = safeIntent.getData();
        String strM63704b = C10344c.m63704b(data, "path");
        String strM63704b2 = C10344c.m63704b(data, "enter");
        String strM63704b3 = C10344c.m63704b(data, "campaignID");
        String strM63704b4 = C10344c.m63704b(data, "srcChannel");
        String strM63704b5 = C10344c.m63704b(data, "salChannel");
        String strM63704b6 = C10344c.m63704b(data, "sceneCode");
        String strM63704b7 = C10344c.m63704b(data, "activityCode");
        String strM63704b8 = C10344c.m63704b(data, "pkg_name");
        boolean zM63703a = C10344c.m63703a(data, "autoOpen", false);
        C11839m.m70686d("EntranceTransUtil", "startCommonActivityByBrowser path " + strM63704b);
        Intent intent = new Intent(context, cls);
        intent.putExtra("channel_refer", "5");
        intent.putExtra("nav_source", 2);
        intent.putExtra("enterType", strM63704b2);
        intent.putExtra("srcChannel", strM63704b4);
        intent.putExtra("sceneCode", strM63704b6);
        intent.putExtra("salChannel", strM63704b5);
        intent.putExtra("activityCode", strM63704b7);
        intent.putExtra("pkg_name", strM63704b8);
        intent.putExtra(NotifyConstants.CloudStorageConstants.AD_NAME_KEY, strM63704b3);
        intent.putExtra("gallery_start_to_open_cloud_album", zM63703a);
        intent.putExtra("deeplink_sub_page", strM63704b);
        if (safeIntent.getBooleanExtra("is_from_webview_filemanager", false)) {
            intent.putExtra("is_from_webview_filemanager", true);
        }
        boolean booleanExtra = safeIntent.getBooleanExtra(RecommendCardConstants.IS_FROM_RECOMMEND_CARD, false);
        boolean booleanExtra2 = safeIntent.getBooleanExtra("isFromNoticeBeforeBackupActivity", false);
        boolean booleanExtra3 = safeIntent.getBooleanExtra("isFromBackupMainActivityCard", false);
        if (booleanExtra || booleanExtra2 || booleanExtra3) {
            str2 = strM63704b8;
            c13946b = this;
        } else {
            intent.putExtra("is_activity_need_back_to_main", true);
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, "Browser");
            str2 = strM63704b8;
            c13946b = this;
            c13946b.m83767p(intent, strM63704b, strM63704b2);
        }
        if (TextUtils.equals(strM63704b4, "539")) {
            intent.putExtra("is_activity_need_back_to_main", false);
        }
        if (TextUtils.equals(strM63704b4, "542")) {
            intent.putExtra("is_activity_need_back_to_main", true);
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, "Browser");
        }
        c13946b.m83766o(safeIntent, intent);
        if (safeIntent.getBooleanExtra(HNConstants.C4906BI.FROM_NOTIFY, false)) {
            intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
            String stringExtra = safeIntent.getStringExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY);
            intent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, stringExtra);
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.contains("recommend_card_notification")) {
                intent.putExtra("recommend_card_activity_id", safeIntent.getStringExtra("recommend_card_activity_id"));
                intent.putExtra("recommend_card_activity_type", safeIntent.getStringExtra("recommend_card_activity_type"));
                intent.putExtra("recommend_card_entrance", safeIntent.getStringExtra("recommend_card_entrance"));
            }
        }
        C13227f.m79492i1().m79495h1(str, "1", C13452e.m80781L().m80971t0(), "5", strM63704b5, strM63704b4, strM63704b7, strM63704b2, str2);
        UBAAnalyze.m29951L("CKC", str, "1", "5", strM63704b5, strM63704b4, strM63704b7, str2);
        context.startActivity(intent);
    }

    /* renamed from: x */
    public final void m83775x(Context context, SafeIntent safeIntent, Class<?> cls, String str) {
        String stringExtra = safeIntent.getStringExtra("enter");
        String stringExtra2 = safeIntent.getStringExtra("srcChannel");
        String stringExtra3 = safeIntent.getStringExtra("salChannel");
        String stringExtra4 = safeIntent.getStringExtra("path");
        String stringExtra5 = safeIntent.getStringExtra("activityCode");
        String stringExtra6 = safeIntent.getStringExtra("pkg_name");
        C11839m.m70686d("EntranceTransUtil", "startCommonActivityByPush path " + stringExtra4);
        Intent intent = new Intent(context, cls);
        intent.putExtra("channel_refer", "0");
        intent.putExtra("nav_source", 1);
        intent.putExtra("is_activity_need_back_to_main", true);
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, "Push");
        intent.putExtra("enterType", stringExtra);
        intent.putExtra("srcChannel", stringExtra2);
        intent.putExtra("salChannel", stringExtra3);
        intent.putExtra("activityCode", stringExtra5);
        intent.putExtra("pkg_name", stringExtra6);
        intent.putExtra("deeplink_sub_page", stringExtra4);
        m83767p(intent, stringExtra4, stringExtra);
        C13227f.m79492i1().m79495h1(str, "1", C13452e.m80781L().m80971t0(), "0", stringExtra3, stringExtra2, stringExtra5, stringExtra, stringExtra6);
        UBAAnalyze.m29951L("CKC", str, "1", "0", stringExtra3, stringExtra2, stringExtra5, stringExtra6);
        context.startActivity(intent);
    }

    /* renamed from: y */
    public final boolean m83776y(Context context, SafeIntent safeIntent) {
        C11839m.m70688i("EntranceTransUtil", "startCouponCenter");
        if (!C10028c.m62182c0().m62413x()) {
            NotifyLogger.m29916w("EntranceTransUtil", "startCouponCenter extendFuncSwitch is false");
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) CouponCenterActivity.class);
        intent.putExtra("page_from", context.getString(com.huawei.android.p073ds.R$string.reward_detail_title));
        String stringExtra = safeIntent.getStringExtra("unique_id");
        if (!TextUtils.isEmpty(stringExtra)) {
            intent.putExtra("unique_id", stringExtra);
        }
        return m83768q(context, safeIntent, intent);
    }

    /* renamed from: z */
    public final boolean m83777z(Context context) {
        context.startActivity(new Intent(context, (Class<?>) MainActivity.class));
        return true;
    }

    public C13946b() {
    }
}
