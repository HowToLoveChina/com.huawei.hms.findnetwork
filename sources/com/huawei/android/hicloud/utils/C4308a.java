package com.huawei.android.hicloud.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudspace.campaign.bean.H5TaskCacheBean;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CampaignActivity;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.Response;
import com.huawei.hicloud.campaign.bean.QuestAttributes;
import com.huawei.hicloud.campaign.bean.QuestBean;
import com.huawei.hicloud.campaign.bean.quest.KaActivationAttr;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.p106db.bean.H5Resource;
import com.huawei.hicloud.notification.p106db.bean.HicloudH5Incentive;
import com.huawei.hicloud.notification.p106db.bean.HicloudH5IncentiveConfig;
import com.huawei.hicloud.notification.p106db.bean.ShowTaskCon;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.phoneservice.feedbackcommon.utils.NetworkUtils;
import com.huawei.secure.android.common.webview.SafeWebView;
import fj.C9718g;
import fk.C9721b;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p341hj.C10271w0;
import p393jd.C10774a;
import p514o9.C11839m;
import p618rm.C12540b1;
import p651t8.C12996d;
import p651t8.C12997e;
import p651t8.C12998f;
import p664u0.C13108a;
import p778xk.C13821b;
import p778xk.C13823d;
import p778xk.C13826g;
import p802y8.AbstractC13919c;

/* renamed from: com.huawei.android.hicloud.utils.a */
/* loaded from: classes3.dex */
public class C4308a {

    /* renamed from: a */
    public static int f19642a = -1;

    /* renamed from: com.huawei.android.hicloud.utils.a$a */
    public class a implements C10271w0.a {

        /* renamed from: a */
        public final /* synthetic */ Handler f19643a;

        public a(Handler handler) {
            this.f19643a = handler;
        }

        @Override // p341hj.C10271w0.a
        /* renamed from: a */
        public void mo21634a(Response response) throws JSONException {
            C11839m.m70688i("CampaignUtil", "PermissionUpdateTask finish, resultCode: " + response.getResultCode());
            C4308a.m25916o(response.getResultCode() == 0, this.f19643a);
        }

        @Override // p341hj.C10271w0.a
        public void onError(String str) throws JSONException {
            C11839m.m70687e("CampaignUtil", "permissionUpdateTask fail");
            C4308a.m25916o(false, this.f19643a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.a$b */
    public class b implements C10271w0.a {

        /* renamed from: a */
        public final /* synthetic */ boolean f19644a;

        public b(boolean z10) {
            this.f19644a = z10;
        }

        @Override // p341hj.C10271w0.a
        /* renamed from: a */
        public void mo21634a(Response response) {
            C11839m.m70688i("CampaignUtil", "entryPermissionUpdateTask success");
            if (this.f19644a) {
                C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.action.updateCampaign"));
            }
            C0212e0.m1368r(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "showSettingFlag", 1);
            C0212e0.m1368r(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "settingStatus", 1);
        }

        @Override // p341hj.C10271w0.a
        public void onError(String str) {
            C11839m.m70687e("CampaignUtil", "entryPermissionUpdateTask fail");
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.a$c */
    public static class c extends AbstractC13919c {

        /* renamed from: a */
        public final Activity f19645a;

        /* renamed from: b */
        public final Handler f19646b;

        /* renamed from: c */
        public final String f19647c;

        /* renamed from: d */
        public final String f19648d;

        public c(Activity activity, Handler handler, String str, String str2) {
            this.f19645a = activity;
            this.f19646b = handler;
            this.f19647c = str;
            this.f19648d = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b, IOException {
            C12998f.m78034R().m78106j(this.f19646b, C12998f.m78034R().m78051E(this.f19647c, this.f19648d, C13821b.m82867w().m82894u(), (List) C13823d.m82904y().m82926j(this.f19645a).stream().map(new C10774a()).collect(Collectors.toList())));
        }
    }

    /* renamed from: com.huawei.android.hicloud.utils.a$d */
    public static class d extends AbstractC13919c {

        /* renamed from: a */
        public final Handler f19649a;

        /* renamed from: b */
        public final String f19650b;

        /* renamed from: c */
        public final String[] f19651c;

        /* renamed from: d */
        public final String[] f19652d;

        /* renamed from: e */
        public final boolean f19653e;

        public d(Handler handler, String str, String[] strArr) {
            this(handler, str, strArr, null, false);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b, IOException {
            C12998f.m78034R().m78123r0(this.f19649a, C12998f.m78034R().m78090Y(this.f19650b, this.f19651c, this.f19652d, C13826g.m82950l().m82963k(), C13821b.m82867w().m82894u(), this.f19653e), this.f19653e ? "questResourcesJSSDKListener " : "questResourcesListener");
        }

        public d(Handler handler, String str, String[] strArr, String[] strArr2) {
            this(handler, str, strArr, strArr2, false);
        }

        public d(Handler handler, String str, String[] strArr, String[] strArr2, boolean z10) {
            this.f19649a = handler;
            this.f19650b = str;
            this.f19651c = strArr;
            this.f19652d = strArr2;
            this.f19653e = z10;
        }
    }

    /* renamed from: b */
    public static void m25903b(boolean z10, Handler handler) {
        C11839m.m70688i("CampaignUtil", "agreeJoinCampaign");
        HashMap map = new HashMap();
        map.put("item", 1);
        map.put("value", 1);
        new C10271w0(C12540b1.m75485c(map), new a(handler)).m63381g();
        HashMap map2 = new HashMap();
        map2.put("item", 3);
        map2.put("value", 1);
        new C10271w0(C12540b1.m75485c(map2), new b(z10)).m63381g();
    }

    /* renamed from: c */
    public static boolean m25904c(Activity activity, SafeWebView safeWebView, String str) {
        C11839m.m70688i("CampaignUtil", "checkResume");
        if (C0209d.m1245d1(activity, str)) {
            return true;
        }
        C11839m.m70687e("CampaignUtil", "checkResume isFinishing()");
        return false;
    }

    /* renamed from: d */
    public static void m25905d(String str, SafeWebView safeWebView) {
        C11839m.m70688i("CampaignUtil", "evaluateJavaScript");
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("CampaignUtil", "script null" + str);
            return;
        }
        if (safeWebView == null) {
            C11839m.m70687e("CampaignUtil", "safeWebView null");
            return;
        }
        try {
            C11839m.m70686d("CampaignUtil", "evaluateJavascript, script start: " + str);
            safeWebView.evaluateJavascript(str, null);
            C11839m.m70686d("CampaignUtil", "evaluateJavascript, script end");
        } catch (Exception e10) {
            C11839m.m70686d("CampaignUtil", "evaluateJavascript, exception:" + e10.getMessage());
        }
    }

    /* renamed from: e */
    public static int m25906e() {
        return f19642a;
    }

    /* renamed from: f */
    public static void m25907f(Activity activity, String str) {
        C11839m.m70688i("CampaignUtil", "jumpCampaignCentre");
        try {
            Intent intent = new Intent(activity, (Class<?>) CampaignActivity.class);
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.putExtra("srcChannel", "500");
            intent.putExtra("channels", 9);
            intent.putExtra("taskActivityId", str);
            intent.putExtra("isEnableJs", true);
            intent.putExtra("launch_web_type", -1);
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            C11839m.m70687e("CampaignUtil", "ActivityNotFoundException:");
        }
    }

    /* renamed from: g */
    public static boolean m25908g(Activity activity, String str) {
        if (activity != null && str != null) {
            C11839m.m70688i("CampaignUtil", "jump web");
            try {
                Intent intent = new Intent();
                intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.putExtra("url", str);
                intent.putExtra("srcChannel", "500");
                intent.putExtra("isEnableJs", true);
                intent.putExtra("launch_web_type", -1);
                intent.putExtra("channel_refer", "2");
                intent.putExtra(RemoteMessageConst.FROM, "campaign_center");
                activity.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                C11839m.m70687e("CampaignUtil", "ActivityNotFoundException, wapUrl error");
            }
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m25909h(Activity activity, String str, String str2) {
        if (activity != null && str != null) {
            C11839m.m70688i("CampaignUtil", "jump to third app");
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.setSelector(null);
                if (!TextUtils.isEmpty(str2)) {
                    C0209d.m1302r2(intent, str2);
                }
                activity.startActivityIfNeeded(intent, -1);
                return true;
            } catch (ActivityNotFoundException unused) {
                C11839m.m70687e("CampaignUtil", "ActivityNotFoundException, wapUrl error, wapUrl error");
            }
        }
        return false;
    }

    /* renamed from: i */
    public static boolean m25910i(Activity activity, String str) {
        if (activity == null) {
            C11839m.m70687e("CampaignUtil", "activity null");
            return false;
        }
        if (str == null) {
            C11839m.m70687e("CampaignUtil", "packageName null");
            return false;
        }
        try {
            PackageManager packageManager = activity.getPackageManager();
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (packageManager.queryIntentActivities(launchIntentForPackage, 0).size() > 0) {
                activity.startActivity(launchIntentForPackage);
                return true;
            }
        } catch (Exception e10) {
            C11839m.m70687e("CampaignUtil", "jumpToApp exception: " + e10.getMessage());
        }
        return false;
    }

    /* renamed from: j */
    public static void m25911j(Handler handler, QuestBean questBean, String str, String str2, H5TaskCacheBean h5TaskCacheBean, String str3, boolean z10) {
        m25917p(questBean, str, str2, h5TaskCacheBean, str3);
        C12998f.m78034R().m78126t(handler, null, z10);
    }

    /* renamed from: k */
    public static void m25912k(SafeWebView safeWebView) {
        String strM78023p = C12997e.m78023p();
        C11839m.m70688i("CampaignUtil", "notifyResume, callBackName: " + strM78023p);
        if (TextUtils.isEmpty(strM78023p)) {
            return;
        }
        m25905d(String.format(Locale.ENGLISH, "%s()", strM78023p), safeWebView);
    }

    /* renamed from: l */
    public static void m25913l(SafeWebView safeWebView) {
        String strM78088X = C12998f.m78034R().m78088X();
        String strM78092Z = C12998f.m78034R().m78092Z();
        int iM78099d0 = C12998f.m78034R().m78099d0();
        int iM78086W = C12998f.m78034R().m78086W();
        C11839m.m70688i("CampaignUtil", "checkResumeQuest, questIdCache: " + strM78088X + ", questStateCache: " + strM78092Z);
        if (TextUtils.isEmpty(strM78088X) || TextUtils.isEmpty(strM78092Z)) {
            return;
        }
        m25915n(strM78088X, strM78092Z, iM78099d0, iM78086W, safeWebView);
        C12998f.m78034R().m78085V0("", "", 0, 0);
    }

    /* renamed from: m */
    public static String m25914m(String str) throws JSONException {
        List<H5Resource> resources;
        C11839m.m70688i("CampaignUtil", "queryShowTaskCon");
        HicloudH5Incentive configFromFile = new HicloudH5IncentiveConfig().getConfigFromFile();
        if (configFromFile != null && (resources = configFromFile.getIncentiveActivitie().getResources()) != null && !TextUtils.isEmpty(str)) {
            C11839m.m70688i("CampaignUtil", "incentiveActivityId: " + str);
            for (int i10 = 0; i10 < resources.size(); i10++) {
                H5Resource h5Resource = resources.get(i10);
                if (TextUtils.equals(str, h5Resource.getActivityId()) && h5Resource.getShowTaskCon() != null) {
                    ShowTaskCon showTaskCon = h5Resource.getShowTaskCon();
                    C11839m.m70688i("CampaignUtil", "show: " + showTaskCon.getIsShow() + ", appUsage: " + showTaskCon.getAppUsage());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("isShow", showTaskCon.getIsShow());
                        jSONObject.put("appUsage", showTaskCon.getAppUsage());
                        return jSONObject.toString();
                    } catch (JSONException unused) {
                        C11839m.m70687e("CampaignUtil", "get showTaskCon error");
                        return null;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: n */
    public static void m25915n(String str, String str2, int i10, int i11, SafeWebView safeWebView) {
        C11839m.m70688i("CampaignUtil", "refreshH5");
        String strM78022o = C12997e.m78022o();
        if (TextUtils.isEmpty(strM78022o)) {
            C11839m.m70687e("CampaignUtil", "refreshH5 callBack null");
        } else {
            m25905d(String.format(Locale.ENGLISH, "%s(%s,%s,%d,%d)", strM78022o, C12996d.m77972o(str), C12996d.m77972o(str2), Integer.valueOf(i10), Integer.valueOf(i11)), safeWebView);
        }
    }

    /* renamed from: o */
    public static void m25916o(boolean z10, Handler handler) throws JSONException {
        C11839m.m70688i("CampaignUtil", "respToH5, isAgree: " + z10);
        if (handler == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isAgree", z10);
            jSONObject.put("guideTaskPos", m25906e() - 12);
        } catch (JSONException unused) {
            C11839m.m70687e("CampaignUtil", "agreeJoinCampaign JSONException");
        }
        String str = String.format(Locale.ENGLISH, "%s(%s)", "listenAgreeCallback", jSONObject.toString());
        Bundle bundle = new Bundle();
        bundle.putString("javascript", str);
        handler.obtainMessage(FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN, bundle).sendToTarget();
    }

    /* renamed from: p */
    public static void m25917p(QuestBean questBean, String str, String str2, H5TaskCacheBean h5TaskCacheBean, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("task_type", "ka_activation");
        linkedHashMap.put("task_id", str);
        h5TaskCacheBean.setActivityId(str3);
        h5TaskCacheBean.setSessionId(str2);
        h5TaskCacheBean.setQuestId(str);
        h5TaskCacheBean.setQuestType(questBean.getType());
        h5TaskCacheBean.setStartTime(System.currentTimeMillis());
        C12998f.m78034R().m78139z0(h5TaskCacheBean);
        C12997e.m78025r("ka_app_event", linkedHashMap);
    }

    /* renamed from: q */
    public static void m25918q(int i10, String str) {
        Intent intent = new Intent("com.huawei.hicloud.action.agreeCampaign");
        intent.putExtra("cardId", i10);
        intent.putExtra(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    /* renamed from: r */
    public static void m25919r(Handler handler, String str) {
        if (handler != null) {
            Message messageObtain = Message.obtain(handler);
            messageObtain.what = 105;
            Bundle bundle = new Bundle();
            bundle.putString("toast_content", str);
            messageObtain.setData(bundle);
            handler.sendMessage(messageObtain);
        }
    }

    /* renamed from: s */
    public static void m25920s(int i10) {
        f19642a = i10;
    }

    /* renamed from: t */
    public static void m25921t(Activity activity, Handler handler, QuestBean questBean, String str, String str2, String str3, boolean z10) {
        C11839m.m70688i("CampaignUtil", "startKaActivation");
        if (activity == null) {
            C11839m.m70687e("CampaignUtil", "activity null");
            return;
        }
        QuestAttributes attributes = questBean.getAttributes();
        if (attributes == null) {
            C11839m.m70687e("CampaignUtil", "attributes null");
            return;
        }
        KaActivationAttr kaActivation = attributes.getKaActivation();
        if (kaActivation == null) {
            C11839m.m70687e("CampaignUtil", "kaActivation null");
            return;
        }
        if (!NetworkUtils.isNetworkConnected(activity)) {
            C11839m.m70687e("CampaignUtil", "network is not connected!");
            m25919r(handler, activity.getString(R$string.network_unavailable));
            return;
        }
        H5TaskCacheBean h5TaskCacheBeanM78078S = C12998f.m78034R().m78078S();
        if (h5TaskCacheBeanM78078S == null) {
            h5TaskCacheBeanM78078S = new H5TaskCacheBean();
        }
        String appPackage = kaActivation.getAppPackage();
        String strM78082U = C12998f.m78034R().m78082U(kaActivation);
        String strM78080T = C12998f.m78034R().m78080T(kaActivation);
        if (TextUtils.isEmpty(appPackage)) {
            appPackage = "";
        }
        C11839m.m70688i("CampaignUtil", "kaNotifyType: " + strM78080T);
        if (TextUtils.isEmpty(strM78080T) || "web".equals(strM78080T)) {
            if (m25908g(activity, strM78082U)) {
                C11839m.m70688i("CampaignUtil", "startKaActivation url");
                m25917p(questBean, str, str2, h5TaskCacheBeanM78078S, str3);
                return;
            } else {
                C11839m.m70687e("CampaignUtil", "startKaActivation url fail");
                m25919r(handler, activity.getString(R$string.msg_create_fail_app_not_intall));
                return;
            }
        }
        if (TextUtils.equals(strM78080T, NotifyConstants.TYPE_DEEPLINK)) {
            if (m25909h(activity, strM78082U, appPackage)) {
                C11839m.m70688i("CampaignUtil", "startKaActivation app by url");
                m25911j(handler, questBean, str, str2, h5TaskCacheBeanM78078S, str3, z10);
                return;
            } else {
                C11839m.m70687e("CampaignUtil", "startKaActivation app fail");
                m25919r(handler, activity.getString(R$string.msg_create_fail_app_not_intall));
                return;
            }
        }
        if (!C0209d.m1187L0(activity, appPackage)) {
            C11839m.m70687e("CampaignUtil", "startKaActivation app not install!");
            m25919r(handler, activity.getString(R$string.msg_create_fail_app_not_intall));
        } else if (m25909h(activity, strM78082U, appPackage)) {
            C11839m.m70688i("CampaignUtil", "startKaActivation app by url");
            m25911j(handler, questBean, str, str2, h5TaskCacheBeanM78078S, str3, z10);
        } else if (m25910i(activity, appPackage)) {
            C11839m.m70688i("CampaignUtil", "startKaActivation app");
            m25911j(handler, questBean, str, str2, h5TaskCacheBeanM78078S, str3, z10);
        } else {
            C11839m.m70687e("CampaignUtil", "startKaActivation app fail");
            m25919r(handler, activity.getString(R$string.msg_create_fail_app_not_intall));
        }
    }

    /* renamed from: u */
    public static void m25922u(Activity activity, Handler handler, String str, String str2, String str3) {
        QuestBean questBeanM60632l = C9718g.m60602t().m60632l(str);
        if (questBeanM60632l != null && "ka_activation".equals(questBeanM60632l.getType())) {
            m25921t(activity, handler, questBeanM60632l, str, str2, str3, true);
        }
    }
}
