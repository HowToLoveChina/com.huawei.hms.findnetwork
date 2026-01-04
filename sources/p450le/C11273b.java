package p450le;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.TerminationRetentionData;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.router.R$string;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import hu.C10344c;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p054cj.C1442a;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: le.b */
/* loaded from: classes3.dex */
public class C11273b {

    /* renamed from: a */
    public static a f52899a = new a(Looper.getMainLooper());

    /* renamed from: b */
    public static GetClientUIConfigResp f52900b = new GetClientUIConfigResp();

    /* renamed from: c */
    public static long f52901c;

    /* renamed from: d */
    public static C11060c f52902d;

    /* renamed from: le.b$a */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (2002 == message.what) {
                C1442a.m8290i("CloudPayUtil", "initClientUIConfig");
                C11273b.m67662q((GetClientUIConfigResp) message.obj);
            }
        }
    }

    /* renamed from: a */
    public static String m67646a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            int iIndexOf = str.indexOf(Constants.QUESTION_STR);
            StringBuilder sb2 = new StringBuilder(str);
            if (iIndexOf != -1) {
                sb2.insert(iIndexOf + 1, "packageName=" + str2 + "&");
            }
            return sb2.toString();
        } catch (Exception unused) {
            C11839m.m70687e("CloudPayUtil", "appendPackageName err: " + str);
            return str;
        }
    }

    /* renamed from: b */
    public static GetClientUIConfigResp m67647b() {
        return f52900b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:206:0x0109, code lost:
    
        continue;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m67648c(com.huawei.secure.android.common.intent.SafeIntent r13, android.content.Context r14) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p450le.C11273b.m67648c(com.huawei.secure.android.common.intent.SafeIntent, android.content.Context):java.lang.String");
    }

    /* renamed from: d */
    public static Intent m67649d(Context context, String str, SafeIntent safeIntent, String str2) {
        String strM67646a = m67646a(str, str2);
        Intent intent = new Intent(context, (Class<?>) OperationWebViewActivity.class);
        intent.putExtra("url", strM67646a);
        String stringExtra = safeIntent.getStringExtra("srcChannel");
        boolean booleanExtra = safeIntent.getBooleanExtra("useMargin", false);
        String stringExtra2 = safeIntent.getStringExtra("salChannel");
        String stringExtra3 = safeIntent.getStringExtra("activityCode");
        String stringExtra4 = safeIntent.getStringExtra("sceneId");
        String stringExtra5 = safeIntent.getStringExtra("showToast");
        if (booleanExtra) {
            intent.putExtra("useMargin", true);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            intent.putExtra("srcChannel", stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            intent.putExtra("salChannel", stringExtra2);
        }
        if (!TextUtils.isEmpty(stringExtra3)) {
            intent.putExtra("activityCode", stringExtra3);
        }
        if (!TextUtils.isEmpty(stringExtra4)) {
            intent.putExtra("sceneId", stringExtra4);
        }
        if (!TextUtils.isEmpty(stringExtra5)) {
            intent.putExtra("showToast", stringExtra5);
        }
        intent.putExtra("isEnableJs", true);
        intent.putExtra("action_bar_color_hm_os_bg", true);
        intent.putExtra("is_support_dark_mode", true);
        return intent;
    }

    /* renamed from: e */
    public static void m67650e() {
        C11060c c11060c = new C11060c();
        f52902d = c11060c;
        c11060c.m66636B("06024");
        f52902d.m66643I(C11058a.m66627b("06024"));
        f52902d.m66637C("com.huawei.hidisk\u0001_cloudspace");
        f52902d.m66670z("2.0");
    }

    /* renamed from: f */
    public static boolean m67651f() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = jCurrentTimeMillis - f52901c <= 600;
        f52901c = jCurrentTimeMillis;
        return z10;
    }

    /* renamed from: g */
    public static boolean m67652g(UserPackage userPackage) {
        if (userPackage == null) {
            C1442a.m8289e("CloudPayUtil", "isHasMultipleRenew, userPackage is null.");
            return false;
        }
        List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
        if (effectivePackages != null && effectivePackages.size() > 1) {
            Iterator<CloudSpace> it = effectivePackages.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (it.next().getIsAutoPay() == 1) {
                    i10++;
                }
                if (i10 >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m67653h(TerminationRetentionData terminationRetentionData) {
        if (terminationRetentionData != null) {
            return m67654i(terminationRetentionData.getGetClientUIConfigResp(), terminationRetentionData.getUserPackage());
        }
        C1442a.m8289e("CloudPayUtil", "isIAPRetentionTextEmpty, terminationRetentionData is null.");
        return true;
    }

    /* renamed from: i */
    public static boolean m67654i(GetClientUIConfigResp getClientUIConfigResp, UserPackage userPackage) {
        if (getClientUIConfigResp == null) {
            C1442a.m8289e("CloudPayUtil", "isRetentionTextEmpty, getClientUIConfigResp is null.");
            return true;
        }
        if (userPackage != null) {
            return userPackage.getUsed() > 5368709120L ? TextUtils.isEmpty(getClientUIConfigResp.getUnSubreservedExceed5GB()) : TextUtils.isEmpty(getClientUIConfigResp.getUnSubreservedNotExceed5GB());
        }
        C1442a.m8289e("CloudPayUtil", "isIAPRetentionTextEmpty, userPackage is null.");
        return true;
    }

    /* renamed from: j */
    public static int m67655j(NotificationWithActivity notificationWithActivity) {
        int enableFrontApp = notificationWithActivity.getEnableFrontApp();
        String frontAppStyle = notificationWithActivity.getFrontAppStyle();
        int enableActivityEntry = notificationWithActivity.getEnableActivityEntry();
        int enableRecomPackages = notificationWithActivity.getEnableRecomPackages();
        C11839m.m70688i("CloudPayUtil", "marketRegionDisplayStyle, frontAppEnable: " + enableFrontApp + ", frontAppStyle: " + frontAppStyle + ", activityEntry: " + enableActivityEntry + ", recommendPackageEnable: " + enableRecomPackages);
        if (enableFrontApp == 1) {
            if (NotifyConstants.FrontAppConstant.STYLE_FRONT_ENTRANCE.equals(frontAppStyle)) {
                return 2;
            }
            return "app".equals(frontAppStyle) ? 1 : 4;
        }
        if (enableActivityEntry == 1) {
            return 5;
        }
        return enableRecomPackages == 1 ? 6 : 0;
    }

    /* renamed from: k */
    public static int m67656k(SpaceNotification spaceNotification) {
        int enableActivityEntry = spaceNotification.getEnableActivityEntry();
        int enableRecomPackages = spaceNotification.getEnableRecomPackages();
        if (enableActivityEntry == 1) {
            return 5;
        }
        return enableRecomPackages == 1 ? 6 : 0;
    }

    /* renamed from: l */
    public static boolean m67657l(Context context, String str, SafeIntent safeIntent, String str2) {
        try {
            Intent intentM67649d = m67649d(context, str, safeIntent, str2);
            intentM67649d.setFlags(335544320);
            context.startActivity(intentM67649d);
            return true;
        } catch (ActivityNotFoundException e10) {
            C1442a.m8289e("CloudPayUtil", "openH5GuidePage ActivityNotFoundException: " + e10.toString());
            return false;
        }
    }

    /* renamed from: m */
    public static boolean m67658m(Context context, String str, SafeIntent safeIntent, String str2) {
        try {
            Intent intentM67649d = m67649d(context, str, safeIntent, str2);
            intentM67649d.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(intentM67649d);
            return true;
        } catch (ActivityNotFoundException e10) {
            C1442a.m8289e("CloudPayUtil", "openH5GuidePage ActivityNotFoundException: " + e10.toString());
            return false;
        }
    }

    /* renamed from: n */
    public static void m67659n(Activity activity, String str, RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback) {
        if (activity == null) {
            C1442a.m8289e("CloudPayUtil", "openRenewAgreement, activity is null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("CloudPayUtil", "openRenewAgreement, url is null.");
            return;
        }
        try {
            Intent intent = new Intent(activity, (Class<?>) OperationWebViewActivity.class);
            intent.putExtra("channel_refer", "2");
            intent.putExtra("nav_source", 0);
            intent.putExtra("is_activity_need_back_to_main", false);
            intent.putExtra("url", str);
            intent.putExtra("is_support_orientation", true);
            intent.putExtra("isEnableJs", true);
            intent.putExtra("launch_web_type", 6);
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.putExtra("is_support_dark_mode", true);
            activity.startActivityForResult(intent, 10016);
            if (renewAgreementTVCallback != null) {
                renewAgreementTVCallback.mo18858j0(false);
            }
        } catch (Exception e10) {
            C1442a.m8289e("CloudPayUtil", "openRenewAgreement, err : " + e10.getMessage());
        }
    }

    /* renamed from: o */
    public static void m67660o(Activity activity, String str, String str2, RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback, ConfirmRenewAgreementDialog.AgreementDlgCallback agreementDlgCallback) {
        if (activity == null) {
            C1442a.m8289e("CloudPayUtil", "openUserAgreement, activity is null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("CloudPayUtil", "openUserAgreement, url is null.");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.putExtra("srcChannel", "0");
            intent.putExtra("salChannel", "0");
            intent.putExtra("url", str);
            intent.putExtra("title", activity.getString(R$string.HiCloud_app_name));
            intent.putExtra("launch_web_type", -1);
            intent.putExtra("isEnableJs", true);
            intent.putExtra("if_use_browser_when_url_not_in_white_list", true);
            intent.putExtra("is_support_orientation", true);
            intent.putExtra("is_support_dark_mode", true);
            if (intent.resolveActivity(activity.getPackageManager()) == null || (!str2.equals("user_agreement_cn") && !str2.equals("privacy_statement_cn"))) {
                intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
            }
            PackageManager packageManager = activity.getPackageManager();
            if (packageManager == null) {
                C11839m.m70688i("CloudPayUtil", "packageManager is null");
            } else if (intent.resolveActivity(packageManager) != null) {
                C11839m.m70688i("CloudPayUtil", "openUserAgreement startActivity");
                activity.startActivityForResult(intent, 10016);
                if (renewAgreementTVCallback != null) {
                    renewAgreementTVCallback.mo18858j0(true);
                } else if (agreementDlgCallback != null) {
                    agreementDlgCallback.reportRenewDlgEvent("UNIFORM_CLOUDPAY_UPGRADE_CLICK_USER_AGREEMENT", new LinkedHashMap<>());
                }
            } else {
                C11839m.m70688i("CloudPayUtil", "openUserAgreement resolveActivity is null");
            }
            LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("productType", str2);
            C13227f.m79492i1().m79591l0("mecloud_agrenment_click", linkedHashMapM79499C);
            UBAAnalyze.m29957R("PVC", "mecloud_agrenment_click", "1", "34", "productType", str2);
        } catch (Exception e10) {
            C1442a.m8289e("CloudPayUtil", "openUserAgreement, err : " + e10.getMessage());
        }
    }

    /* renamed from: p */
    public static void m67661p(Context context, String str, LinkedHashMap<String, String> linkedHashMap) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06011"), "06011", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B(str);
        c11060cM66626a.m66665u("0");
        C13622a.m81969o(context, c11060cM66626a, linkedHashMap);
    }

    /* renamed from: q */
    public static void m67662q(GetClientUIConfigResp getClientUIConfigResp) {
        f52900b = getClientUIConfigResp;
    }

    /* renamed from: r */
    public static boolean m67663r(Context context, SafeIntent safeIntent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str;
        Intent intent;
        C1442a.m8290i("CloudPayUtil", "upgradeJumpToGuidePage");
        if (safeIntent == null || context == null) {
            C1442a.m8291w("CloudPayUtil", "upgradeJumpToGuidePage, intent || context is null");
            return false;
        }
        String strM67648c = m67648c(safeIntent, context);
        if (TextUtils.isEmpty(strM67648c)) {
            C1442a.m8291w("CloudPayUtil", "upgradeJumpToGuidePage, OM H5 url is empty");
            return false;
        }
        C1442a.m8290i("CloudPayUtil", "upgradeJumpToGuidePage, url: " + strM67648c);
        if (m67651f()) {
            C1442a.m8291w("CloudPayUtil", "H5 jump to the fast click");
            return true;
        }
        try {
            intent = new Intent(context, (Class<?>) OperationWebViewActivity.class);
            intent.putExtra("url", strM67648c);
            String strM63704b = C10344c.m63704b(safeIntent.getData(), "sceneCode");
            String strM63704b2 = C10344c.m63704b(safeIntent.getData(), "sceneId");
            String strM63704b3 = C10344c.m63704b(safeIntent.getData(), "userLabel");
            String strM63704b4 = C10344c.m63704b(safeIntent.getData(), "showToast");
            String strM63704b5 = C10344c.m63704b(safeIntent.getData(), "channel_refer");
            String strM63704b6 = C10344c.m63704b(safeIntent.getData(), "srcChannel");
            try {
                String strM63704b7 = C10344c.m63704b(safeIntent.getData(), "salChannel");
                String strM63704b8 = C10344c.m63704b(safeIntent.getData(), "activityCode");
                if (!TextUtils.isEmpty(strM63704b)) {
                    intent.putExtra("sceneCode", strM63704b);
                }
                if (!TextUtils.isEmpty(strM63704b2)) {
                    intent.putExtra("sceneId", strM63704b2);
                }
                if (!TextUtils.isEmpty(strM63704b3)) {
                    intent.putExtra("userLabel", strM63704b3);
                }
                if (!TextUtils.isEmpty(strM63704b4)) {
                    intent.putExtra("showToast", strM63704b4);
                }
                if (!TextUtils.isEmpty(strM63704b5)) {
                    intent.putExtra("channel_refer", strM63704b5);
                }
                if (!TextUtils.isEmpty(strM63704b6)) {
                    intent.putExtra("srcChannel", strM63704b6);
                }
                if (!TextUtils.isEmpty(strM63704b7)) {
                    intent.putExtra("salChannel", strM63704b7);
                }
                if (!TextUtils.isEmpty(strM63704b8)) {
                    intent.putExtra("activityCode", strM63704b8);
                }
                intent.putExtra("isEnableJs", true);
                intent.putExtra("action_bar_color_hm_os_bg", true);
                intent.putExtra("is_support_dark_mode", true);
                intent.setFlags(335544320);
                str = "CloudPayUtil";
            } catch (ActivityNotFoundException e10) {
                e = e10;
                str = "CloudPayUtil";
            }
        } catch (ActivityNotFoundException e11) {
            e = e11;
            str = "CloudPayUtil";
        }
        try {
            C1442a.m8290i(str, "upgradeJumpToGuidePage, isRunningForeground: " + C0209d.m1185K1(context));
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e12) {
            e = e12;
            C1442a.m8289e(str, "upgradeJumpToGuidePage ActivityNotFoundException: " + e.toString());
            return false;
        }
    }
}
