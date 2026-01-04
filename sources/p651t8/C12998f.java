package p651t8;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudspace.campaign.bean.H5ActivityEntery;
import com.huawei.android.hicloud.cloudspace.campaign.bean.H5ActivityResources;
import com.huawei.android.hicloud.cloudspace.campaign.bean.H5TaskCacheBean;
import com.huawei.android.hicloud.cloudspace.campaign.bean.ReqDispatchActivateApp;
import com.huawei.android.hicloud.cloudspace.campaign.bean.ReqDispatchDownloadApp;
import com.huawei.android.hicloud.cloudspace.campaign.bean.ReqDispatchEvent;
import com.huawei.android.hicloud.cloudspace.campaign.bean.ReqDispatchFeatureEnable;
import com.huawei.android.hicloud.cloudspace.campaign.bean.ReqDispatchRoot;
import com.huawei.android.hicloud.cloudspace.campaign.bean.ReqDispatchUploadFile;
import com.huawei.android.hicloud.p088ui.activity.GuideWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CampaignActivity;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceSwitchSuggestDialog;
import com.huawei.android.hicloud.utils.C4308a;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.AdAppInfo;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.cloud.pay.model.Response;
import com.huawei.gson.JsonSyntaxException;
import com.huawei.hicloud.bean.DispatchCampaignActivityResp;
import com.huawei.hicloud.campaign.bean.Award;
import com.huawei.hicloud.campaign.bean.CamJump;
import com.huawei.hicloud.campaign.bean.CampaignActivityConfig;
import com.huawei.hicloud.campaign.bean.CampaignActivityRoot;
import com.huawei.hicloud.campaign.bean.QuestAttributes;
import com.huawei.hicloud.campaign.bean.QuestBean;
import com.huawei.hicloud.campaign.bean.QuestRoot;
import com.huawei.hicloud.campaign.bean.quest.AdsActivationAttr;
import com.huawei.hicloud.campaign.bean.quest.DownloadAppAttr;
import com.huawei.hicloud.campaign.bean.quest.KaActivationAttr;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.secure.android.common.webview.SafeWebView;
import fj.C9718g;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0241z;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9287f;
import p341hj.C10240k;
import p341hj.C10271w0;
import p454lj.C11280c;
import p514o9.C11839m;
import p618rm.C12540b1;
import p681uj.C13194k;
import p681uj.C13196m;
import p681uj.C13199p;
import p778xk.C13821b;
import p778xk.C13823d;

/* renamed from: t8.f */
/* loaded from: classes2.dex */
public class C12998f {

    /* renamed from: a */
    public final ConcurrentHashMap<String, H5TaskCacheBean> f59177a;

    /* renamed from: b */
    public final ConcurrentHashMap<String, H5TaskCacheBean> f59178b;

    /* renamed from: c */
    public Handler f59179c;

    /* renamed from: d */
    public Toast f59180d;

    /* renamed from: e */
    public String f59181e;

    /* renamed from: f */
    public String f59182f;

    /* renamed from: g */
    public String f59183g;

    /* renamed from: h */
    public int f59184h;

    /* renamed from: i */
    public int f59185i;

    /* renamed from: j */
    public String f59186j;

    /* renamed from: k */
    public boolean f59187k;

    /* renamed from: l */
    public boolean f59188l;

    /* renamed from: m */
    public boolean f59189m;

    /* renamed from: n */
    public boolean f59190n;

    /* renamed from: o */
    public String f59191o;

    /* renamed from: t8.f$a */
    public class a implements C10240k.a {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f59192a;

        /* renamed from: b */
        public final /* synthetic */ Handler f59193b;

        /* renamed from: c */
        public final /* synthetic */ String f59194c;

        /* renamed from: d */
        public final /* synthetic */ boolean f59195d;

        /* renamed from: e */
        public final /* synthetic */ H5TaskCacheBean f59196e;

        public a(CountDownLatch countDownLatch, Handler handler, String str, boolean z10, H5TaskCacheBean h5TaskCacheBean) {
            this.f59192a = countDownLatch;
            this.f59193b = handler;
            this.f59194c = str;
            this.f59195d = z10;
            this.f59196e = h5TaskCacheBean;
        }

        @Override // p341hj.C10240k.a
        /* renamed from: a */
        public void mo63400a(DispatchCampaignActivityResp dispatchCampaignActivityResp) {
            C11839m.m70686d("QuestManager", "postActivityDispatch finish, resp: " + dispatchCampaignActivityResp);
            C12998f.this.m78043A(this.f59192a);
            if (dispatchCampaignActivityResp != null) {
                C12998f.this.m78117o0(this.f59193b, this.f59194c, "3", dispatchCampaignActivityResp.getCounter().intValue(), dispatchCampaignActivityResp.getTaskAwards().intValue(), this.f59195d);
            }
            C12998f.this.m78133w0(this.f59193b, 0, this.f59195d);
            C12998f.this.m78131v0(this.f59196e);
            C12998f.this.m78127t0(this.f59196e);
            C12998f.this.m78125s0(this.f59194c);
            C13823d.m82903c();
        }

        @Override // p341hj.C10240k.a
        public void onError(String str) {
            String strM63399h = C10240k.m63399h(str);
            C11839m.m70687e("QuestManager", "postActivityDispatch error=" + strM63399h);
            C12998f.this.m78043A(this.f59192a);
            C12998f.this.m78115n0(this.f59193b, this.f59194c, strM63399h, this.f59195d);
            C12998f.this.m78133w0(this.f59193b, C0241z.m1685c(strM63399h), this.f59195d);
            if ("31014001".equals(strM63399h) || "31014002".equals(strM63399h) || "31014004".equals(strM63399h) || "31014005".equals(strM63399h) || "31014032".equals(strM63399h) || "31014033".equals(strM63399h) || "31014037".equals(strM63399h)) {
                C12998f.this.m78131v0(this.f59196e);
            }
            C12998f.this.m78127t0(this.f59196e);
            C12998f.this.m78125s0(this.f59194c);
        }
    }

    /* renamed from: t8.f$b */
    public class b implements C10271w0.a {

        /* renamed from: a */
        public final /* synthetic */ Handler f59198a;

        /* renamed from: b */
        public final /* synthetic */ H5TaskCacheBean f59199b;

        /* renamed from: c */
        public final /* synthetic */ String f59200c;

        public b(Handler handler, H5TaskCacheBean h5TaskCacheBean, String str) {
            this.f59198a = handler;
            this.f59199b = h5TaskCacheBean;
            this.f59200c = str;
        }

        @Override // p341hj.C10271w0.a
        /* renamed from: a */
        public void mo21634a(Response response) {
            C11839m.m70686d("QuestManager", "permissionUpdateTask finish");
            if (response != null) {
                C12998f.m78034R().m78109k0(this.f59198a, this.f59199b, null);
            }
        }

        @Override // p341hj.C10271w0.a
        public void onError(String str) {
            C11839m.m70687e("QuestManager", "permissionUpdateTask error");
            C12998f.this.m78115n0(this.f59198a, this.f59200c, "", false);
            C12998f.this.m78129u0(this.f59200c);
        }
    }

    /* renamed from: t8.f$c */
    public static class c {

        /* renamed from: a */
        public static final C12998f f59202a = new C12998f(null);
    }

    public /* synthetic */ C12998f(a aVar) {
        this();
    }

    /* renamed from: R */
    public static C12998f m78034R() {
        return c.f59202a;
    }

    /* renamed from: A */
    public final void m78043A(CountDownLatch countDownLatch) {
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* renamed from: A0 */
    public void m78044A0(H5TaskCacheBean h5TaskCacheBean) {
        if (h5TaskCacheBean == null) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "download_app", C12540b1.m75485c(h5TaskCacheBean));
    }

    /* renamed from: B */
    public void m78045B(Context context, Handler handler, boolean z10, int i10) {
        C11839m.m70688i("QuestManager", "checkFileManagerTaskReport campaignTaskId : " + i10);
        H5TaskCacheBean h5TaskCacheBeanM78069N = m78069N(i10);
        if (h5TaskCacheBeanM78069N == null) {
            C11839m.m70688i("QuestManager", "checkFileManagerTaskReport taskCacheBean null");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long startTime = h5TaskCacheBeanM78069N.getStartTime();
        if (jCurrentTimeMillis < startTime || jCurrentTimeMillis - startTime > C9718g.m60602t().m60643y()) {
            C11839m.m70689w("QuestManager", "doFileManagerTaskReport delay");
            m78137y0(handler, h5TaskCacheBeanM78069N.getQuestId(), z10);
        } else if (context == null) {
            C11839m.m70688i("QuestManager", "context null");
            m78137y0(handler, h5TaskCacheBeanM78069N.getQuestId(), z10);
        } else {
            C11839m.m70688i("QuestManager", "doFileManagerTaskReport");
            m78034R().m78109k0(handler, h5TaskCacheBeanM78069N, null);
            m78047C(i10, h5TaskCacheBeanM78069N);
        }
    }

    /* renamed from: B0 */
    public final void m78046B0(Handler handler, String str, String str2, String str3) {
        if (handler != null) {
            Bundle bundle = new Bundle();
            bundle.putString("questId", str);
            bundle.putString(CommonConstant.ReqAccessTokenParam.STATE_LABEL, str2);
            bundle.putString(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, str3);
            handler.obtainMessage(1004, bundle).sendToTarget();
        }
    }

    /* renamed from: C */
    public final void m78047C(int i10, H5TaskCacheBean h5TaskCacheBean) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("task_id", h5TaskCacheBean.getQuestId());
        if (i10 == 1) {
            linkedHashMap.put("task_type", "upload_file");
            linkedHashMap.put("task_attr", String.valueOf(h5TaskCacheBean.getService()));
            C12997e.m78025r("upload_file_event", linkedHashMap);
        } else if (i10 == 2) {
            linkedHashMap.put("task_type", "create_drive_folder");
            C12997e.m78025r("create_folder_event", linkedHashMap);
        } else {
            if (i10 != 4) {
                return;
            }
            linkedHashMap.put("task_type", "create_drive_file");
            C12997e.m78025r("create_file_event", linkedHashMap);
        }
    }

    /* renamed from: C0 */
    public final void m78048C0(Handler handler, String str, String str2, int i10, int i11) {
        if (handler != null) {
            C11839m.m70688i("QuestManager", "postActivityDispatch finish send message");
            Bundle bundle = new Bundle();
            bundle.putString("questId", str);
            bundle.putString(CommonConstant.ReqAccessTokenParam.STATE_LABEL, str2);
            bundle.putInt("count", i10);
            bundle.putInt("taskAwards", i11);
            handler.obtainMessage(1003, bundle).sendToTarget();
        }
    }

    /* renamed from: D */
    public final HiCloudNativeAd m78049D(String str, AdAppInfo adAppInfo, List<HiCloudNativeAd> list) {
        String packageName;
        if (str == null || adAppInfo == null || list == null) {
            C11839m.m70687e("QuestManager", "setHiCloudNativeAd: null");
            return null;
        }
        if (!str.equals(adAppInfo.getChannel())) {
            C11839m.m70687e("QuestManager", "setHiCloudNativeAd: appSource not match");
            return null;
        }
        if (list.size() > 0) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                HiCloudNativeAd hiCloudNativeAd = list.get(i10);
                if (hiCloudNativeAd != null && hiCloudNativeAd.getAppInfo() != null && (packageName = adAppInfo.getPackageName()) != null && packageName.equals(hiCloudNativeAd.getAppInfo().getPackageName())) {
                    return hiCloudNativeAd;
                }
            }
        }
        return null;
    }

    /* renamed from: D0 */
    public final void m78050D0(H5ActivityEntery h5ActivityEntery, String str, CampaignActivityRoot campaignActivityRoot) {
        if (campaignActivityRoot == null || campaignActivityRoot.getConfig() == null) {
            C11839m.m70687e("QuestManager", "setActivityTime: activityRoot null");
            return;
        }
        CampaignActivityConfig[] config = campaignActivityRoot.getConfig();
        if (config == null) {
            C11839m.m70687e("QuestManager", "setActivityTime: configs null");
            return;
        }
        for (CampaignActivityConfig campaignActivityConfig : config) {
            if (campaignActivityConfig != null && str != null && str.equals(campaignActivityConfig.getId())) {
                h5ActivityEntery.setBeginTime(campaignActivityConfig.getBeginTime());
                h5ActivityEntery.setEndTime(campaignActivityConfig.getEndTime());
                return;
            }
        }
    }

    /* renamed from: E */
    public String m78051E(String str, String str2, CampaignActivityRoot campaignActivityRoot, List<String> list) {
        H5ActivityEntery h5ActivityEntery = new H5ActivityEntery();
        h5ActivityEntery.setActivityId(str);
        h5ActivityEntery.setChannel(C0241z.m1685c(str2));
        h5ActivityEntery.setCheckedQuests(list);
        h5ActivityEntery.setSettingStatus(C0212e0.m1357g(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "settingStatus", 0));
        h5ActivityEntery.setExceedRedemptionLimit(C0212e0.m1354d(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "exceedRedemptionLimit", true));
        m78050D0(h5ActivityEntery, str, campaignActivityRoot);
        String strM75485c = C12540b1.m75485c(h5ActivityEntery);
        C11839m.m70686d("QuestManager", "getActivityEnteryList: " + strM75485c);
        return strM75485c;
    }

    /* renamed from: E0 */
    public final void m78052E0(QuestBean questBean, AdAppInfo adAppInfo) {
        if (adAppInfo == null) {
            C11839m.m70687e("QuestManager", "setAppInfo：appInfo empty");
            return;
        }
        C11839m.m70686d("QuestManager", "setAppInfo:" + adAppInfo.getPackageName() + ", " + adAppInfo.getAppName());
        CommonPicture commonPicture = new CommonPicture();
        String iconUrl = adAppInfo.getIconUrl();
        commonPicture.setUrl(iconUrl);
        commonPicture.setHash(C0227m.m1593f(iconUrl));
        questBean.setName(adAppInfo.getAppName());
        questBean.setDetail(adAppInfo.getAppDesc());
        questBean.setPicture(commonPicture);
    }

    /* renamed from: F */
    public String m78053F(String str, String str2, CampaignActivityRoot campaignActivityRoot, List<String> list) {
        H5ActivityEntery h5ActivityEntery = new H5ActivityEntery();
        h5ActivityEntery.setActivityId(str);
        h5ActivityEntery.setChannel(C0241z.m1685c(str2));
        h5ActivityEntery.setCheckedQuests(list);
        h5ActivityEntery.setSettingStatus(C0212e0.m1357g(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "settingStatus", 0));
        h5ActivityEntery.setExceedRedemptionLimit(C0212e0.m1354d(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "exceedRedemptionLimit", true));
        try {
            h5ActivityEntery.setEntryOriginJson((JsonObject) new Gson().fromJson(C13823d.m82904y().m82927k(C0213f.m1377a()), JsonObject.class));
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("QuestManager", "JsonSyntaxException: " + e10.getMessage());
        }
        h5ActivityEntery.setCampaignConfig(C13821b.m82867w().m82895v());
        m78050D0(h5ActivityEntery, str, campaignActivityRoot);
        String strM75485c = C12540b1.m75485c(h5ActivityEntery);
        C11839m.m70686d("QuestManager", "getActivityEnteryList: " + strM75485c);
        return strM75485c;
    }

    /* renamed from: F0 */
    public void m78054F0(String str) {
        H5TaskCacheBean h5TaskCacheBeanM78084V = m78084V();
        if (h5TaskCacheBeanM78084V == null || !TextUtils.isEmpty(h5TaskCacheBeanM78084V.getApp())) {
            return;
        }
        h5TaskCacheBeanM78084V.setApp(str);
        m78044A0(h5TaskCacheBeanM78084V);
    }

    /* renamed from: G */
    public String m78055G(String str, CampaignActivityRoot campaignActivityRoot) {
        H5ActivityResources h5ActivityResources = new H5ActivityResources();
        ArrayList arrayList = new ArrayList();
        m78056G0(arrayList, str, campaignActivityRoot);
        h5ActivityResources.setAwards(arrayList);
        String strM75485c = C12540b1.m75485c(h5ActivityResources);
        C11839m.m70686d("QuestManager", "getActivityResources: " + strM75485c);
        return strM75485c;
    }

    /* renamed from: G0 */
    public final void m78056G0(List<Award> list, String str, CampaignActivityRoot campaignActivityRoot) {
        Award[] awards;
        if (campaignActivityRoot == null || campaignActivityRoot.getConfig() == null) {
            C11839m.m70687e("QuestManager", "setAwards: activityRoot null");
            return;
        }
        CampaignActivityConfig[] config = campaignActivityRoot.getConfig();
        if (config == null) {
            C11839m.m70687e("QuestManager", "setAwards: configs null");
            return;
        }
        for (CampaignActivityConfig campaignActivityConfig : config) {
            if (campaignActivityConfig != null && str != null && str.equals(campaignActivityConfig.getId()) && (awards = campaignActivityConfig.getAwards()) != null) {
                list.addAll(Arrays.asList(awards));
            }
        }
    }

    /* renamed from: H */
    public final String m78057H(String str) {
        String str2;
        str.hashCode();
        str2 = "notepad";
        switch (str) {
            case "wlan":
                str2 = "wlan";
                break;
            case "browser":
                str2 = "browser";
                break;
            case "contact":
                str2 = "addressbook";
                break;
            case "notepad":
                break;
            default:
                str2 = null;
                break;
        }
        C11839m.m70688i("QuestManager", "getSpKeyName, spKey is: " + str2);
        return str2;
    }

    /* renamed from: H0 */
    public final boolean m78058H0(QuestBean questBean, String str, HiCloudNativeAd hiCloudNativeAd) {
        C11839m.m70688i("QuestManager", "setCacheAppData");
        C12993a.m77957a(hiCloudNativeAd);
        questBean.setHiCloudNativeAdId(str);
        questBean.setHiCloudNativeAd(hiCloudNativeAd);
        m78052E0(questBean, hiCloudNativeAd.getAppInfo());
        return true;
    }

    /* renamed from: I */
    public H5TaskCacheBean m78059I() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "calendar_notify", "");
        if (strM1364n != null) {
            return (H5TaskCacheBean) C12540b1.m75483a(strM1364n, H5TaskCacheBean.class);
        }
        return null;
    }

    /* renamed from: I0 */
    public void m78060I0(String str) {
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "calendar_notify", str);
    }

    /* renamed from: J */
    public H5TaskCacheBean m78061J() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "future_switch_backup", "");
        if (strM1364n != null) {
            return (H5TaskCacheBean) C12540b1.m75483a(strM1364n, H5TaskCacheBean.class);
        }
        return null;
    }

    /* renamed from: J0 */
    public void m78062J0(String str) {
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "future_switch_backup", str);
    }

    /* renamed from: K */
    public H5TaskCacheBean m78063K(String str) {
        C11839m.m70688i("QuestManager", "getCloudMainSwitchTime");
        String strM78096b0 = m78096b0(str);
        if (TextUtils.isEmpty(strM78096b0)) {
            C11839m.m70687e("QuestManager", "getCloudMainSwitchTime, spKey is null!");
            return null;
        }
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", strM78096b0, "");
        if (strM1364n != null) {
            return (H5TaskCacheBean) C12540b1.m75483a(strM1364n, H5TaskCacheBean.class);
        }
        return null;
    }

    /* renamed from: K0 */
    public void m78064K0(String str, String str2) {
        this.f59186j = str2;
        C11839m.m70688i("QuestManager", "setCloudMainSwitchTime");
        String strM78096b0 = m78096b0(str2);
        if (TextUtils.isEmpty(strM78096b0)) {
            C11839m.m70687e("QuestManager", "setCloudMainSwitchTime, spKey is null!");
        } else {
            C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", strM78096b0, str);
        }
    }

    /* renamed from: L */
    public H5TaskCacheBean m78065L() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "create_drive_file", "");
        if (strM1364n != null) {
            return (H5TaskCacheBean) C12540b1.m75483a(strM1364n, H5TaskCacheBean.class);
        }
        return null;
    }

    /* renamed from: L0 */
    public void m78066L0(String str) {
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "create_drive_file", str);
    }

    /* renamed from: M */
    public H5TaskCacheBean m78067M() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "create_drive_folder", "");
        if (strM1364n != null) {
            return (H5TaskCacheBean) C12540b1.m75483a(strM1364n, H5TaskCacheBean.class);
        }
        return null;
    }

    /* renamed from: M0 */
    public void m78068M0(String str) {
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "create_drive_folder", str);
    }

    /* renamed from: N */
    public final H5TaskCacheBean m78069N(int i10) {
        if (i10 == 1) {
            return m78100e0();
        }
        if (i10 == 2) {
            return m78067M();
        }
        if (i10 != 4) {
            return null;
        }
        return m78065L();
    }

    /* renamed from: N0 */
    public void m78070N0(String str) {
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "feature_switch_find_device", str);
    }

    /* renamed from: O */
    public H5TaskCacheBean m78071O() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "feature_switch_find_device", "");
        if (strM1364n != null) {
            return (H5TaskCacheBean) C12540b1.m75483a(strM1364n, H5TaskCacheBean.class);
        }
        return null;
    }

    /* renamed from: O0 */
    public void m78072O0(String str) {
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "future_switch_photo", str);
    }

    /* renamed from: P */
    public H5TaskCacheBean m78073P() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "future_switch_photo", "");
        if (strM1364n != null) {
            return (H5TaskCacheBean) C12540b1.m75483a(strM1364n, H5TaskCacheBean.class);
        }
        return null;
    }

    /* renamed from: P0 */
    public void m78074P0(Handler handler) {
        this.f59179c = handler;
    }

    /* renamed from: Q */
    public Handler m78075Q(Handler handler, boolean z10) {
        return (!z10 && handler == null) ? this.f59179c : handler;
    }

    /* renamed from: Q0 */
    public final boolean m78076Q0(QuestBean questBean, boolean z10) {
        if (questBean == null) {
            C11839m.m70687e("QuestManager", "setHiCloudNativeAd：questBean null");
            return false;
        }
        QuestAttributes attributes = questBean.getAttributes();
        if (attributes == null) {
            C11839m.m70687e("QuestManager", "setHiCloudNativeAd：attributes null");
            return false;
        }
        DownloadAppAttr downloadApp = attributes.getDownloadApp();
        if (downloadApp == null) {
            C11839m.m70687e("QuestManager", "setHiCloudNativeAd：downloadApp null");
            return false;
        }
        String appSource = downloadApp.getAppSource();
        String adSlotId = downloadApp.getAdSlotId();
        questBean.setAppSource(appSource);
        questBean.setHiCloudNativeAdId(adSlotId);
        C11839m.m70688i("QuestManager", "setHiCloudNativeAd：appSource " + appSource);
        if (HiCloudNativeAd.CHANNEL_PPS.equals(appSource) && z10) {
            return true;
        }
        String id2 = questBean.getId();
        HiCloudNativeAd hiCloudNativeAdM77961e = C12993a.m77961e(appSource, adSlotId, id2);
        if (hiCloudNativeAdM77961e != null && hiCloudNativeAdM77961e.getAppInfo() != null && !C12993a.m77966j(hiCloudNativeAdM77961e)) {
            C11839m.m70688i("QuestManager", "setHiCloudNativeAd：getCacheDownloadApp");
            AdAppInfo appInfo = hiCloudNativeAdM77961e.getAppInfo();
            String packageName = appInfo.getPackageName();
            if (C0209d.m1187L0(C0213f.m1377a(), packageName)) {
                C11839m.m70688i("QuestManager", "setHiCloudNativeAd：packageName " + packageName);
                if (m78058H0(questBean, adSlotId, hiCloudNativeAdM77961e)) {
                    return true;
                }
            } else {
                C11839m.m70688i("QuestManager", "setHiCloudNativeAd：getDownloadApp for cache ");
                List<HiCloudNativeAd> listM77962f = C12993a.m77962f(appSource, adSlotId, 9);
                HiCloudNativeAd hiCloudNativeAdM78049D = m78049D(appSource, appInfo, listM77962f);
                if (hiCloudNativeAdM78049D != null) {
                    C11839m.m70688i("QuestManager", "setHiCloudNativeAd：findCacheAppData");
                    if (m78058H0(questBean, adSlotId, hiCloudNativeAdM78049D)) {
                        return true;
                    }
                } else {
                    C11839m.m70688i("QuestManager", "setHiCloudNativeAd：findCacheAppData false");
                    if (hiCloudNativeAdM77961e.getAppInfo() != null) {
                        C12996d.m77971n().m78004w(adSlotId, hiCloudNativeAdM77961e.getAppInfo().getUniqueId());
                    }
                    HiCloudNativeAd hiCloudNativeAdM78083U0 = m78083U0(questBean, adSlotId, listM77962f);
                    if (hiCloudNativeAdM78083U0 != null) {
                        C12996d.m77971n().m78006z(id2);
                        C12996d.m77971n().m77981E(adSlotId, hiCloudNativeAdM78083U0.getAppInfo().getUniqueId(), id2);
                        return true;
                    }
                }
            }
        }
        C11839m.m70688i("QuestManager", "setHiCloudNativeAd：getDownloadApp");
        List<HiCloudNativeAd> listM77962f2 = C12993a.m77962f(appSource, adSlotId, 9);
        if (hiCloudNativeAdM77961e != null && hiCloudNativeAdM77961e.getAppInfo() != null) {
            C12996d.m77971n().m78004w(adSlotId, hiCloudNativeAdM77961e.getAppInfo().getUniqueId());
        }
        if (m78083U0(questBean, adSlotId, listM77962f2) == null) {
            return false;
        }
        C11839m.m70688i("QuestManager", "setHiCloudNativeAd: setNewAppData");
        C12996d.m77971n().m78006z(id2);
        return true;
    }

    /* renamed from: R0 */
    public void m78077R0(boolean z10) {
        this.f59188l = z10;
    }

    /* renamed from: S */
    public H5TaskCacheBean m78078S() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "ka_activation", "");
        if (strM1364n != null) {
            return (H5TaskCacheBean) C12540b1.m75483a(strM1364n, H5TaskCacheBean.class);
        }
        return null;
    }

    /* renamed from: S0 */
    public void m78079S0(boolean z10) {
        this.f59189m = z10;
    }

    /* renamed from: T */
    public String m78080T(KaActivationAttr kaActivationAttr) {
        CamJump gotoX;
        if (kaActivationAttr == null || (gotoX = kaActivationAttr.getGotoX()) == null) {
            return null;
        }
        String notifyType = gotoX.getNotifyType();
        if (TextUtils.isEmpty(notifyType)) {
            return null;
        }
        return notifyType;
    }

    /* renamed from: T0 */
    public void m78081T0(boolean z10) {
        this.f59187k = z10;
    }

    /* renamed from: U */
    public String m78082U(KaActivationAttr kaActivationAttr) {
        CamJump gotoX;
        if (kaActivationAttr == null || (gotoX = kaActivationAttr.getGotoX()) == null) {
            return null;
        }
        String notifyUri = gotoX.getNotifyUri();
        if (TextUtils.isEmpty(notifyUri)) {
            return null;
        }
        return notifyUri;
    }

    /* renamed from: U0 */
    public final HiCloudNativeAd m78083U0(QuestBean questBean, String str, List<HiCloudNativeAd> list) {
        HiCloudNativeAd hiCloudNativeAdM77964h;
        C11839m.m70688i("QuestManager", "setNewAppData");
        if (list.size() <= 0 || (hiCloudNativeAdM77964h = C12993a.m77964h(list)) == null || hiCloudNativeAdM77964h.getAppInfo() == null) {
            C11839m.m70688i("QuestManager", "adList is empty");
            return null;
        }
        C12993a.m77957a(hiCloudNativeAdM77964h);
        questBean.setHiCloudNativeAdId(str);
        questBean.setHiCloudNativeAd(hiCloudNativeAdM77964h);
        m78052E0(questBean, hiCloudNativeAdM77964h.getAppInfo());
        return hiCloudNativeAdM77964h;
    }

    /* renamed from: V */
    public H5TaskCacheBean m78084V() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "download_app", "");
        if (strM1364n != null) {
            return (H5TaskCacheBean) C12540b1.m75483a(strM1364n, H5TaskCacheBean.class);
        }
        return null;
    }

    /* renamed from: V0 */
    public void m78085V0(String str, String str2, int i10, int i11) {
        this.f59182f = str;
        this.f59183g = str2;
        this.f59184h = i10;
        this.f59185i = i11;
    }

    /* renamed from: W */
    public int m78086W() {
        return this.f59185i;
    }

    /* renamed from: W0 */
    public void m78087W0(String str) {
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "space_optimization", str);
    }

    /* renamed from: X */
    public String m78088X() {
        return this.f59182f;
    }

    /* renamed from: X0 */
    public void m78089X0(boolean z10) {
        this.f59190n = z10;
    }

    /* renamed from: Y */
    public String m78090Y(String str, String[] strArr, String[] strArr2, QuestRoot questRoot, CampaignActivityRoot campaignActivityRoot, boolean z10) {
        C11839m.m70686d("QuestManager", "getQuestResources");
        C12993a.m77958b();
        ArrayList arrayList = new ArrayList();
        if (str == null || strArr == null || strArr.length == 0) {
            return C12540b1.m75485c(arrayList);
        }
        if (questRoot == null || questRoot.getConfig() == null) {
            return C12540b1.m75485c(arrayList);
        }
        if (questRoot.getConfig() == null) {
            return C12540b1.m75485c(arrayList);
        }
        for (String str2 : strArr) {
            QuestBean questBeanM60633m = C9718g.m60602t().m60633m(str2, questRoot);
            if (questBeanM60633m == null) {
                C11839m.m70687e("QuestManager", "questBean null");
            } else if (!C9718g.m60602t().m60619Q(questBeanM60633m, strArr2)) {
                C11839m.m70687e("QuestManager", "not support quest");
            } else if (C9718g.m60602t().m60624b0(questBeanM60633m, str, campaignActivityRoot)) {
                String type = questBeanM60633m.getType();
                if (!"download_app".equals(type)) {
                    if ("app_activation".equals(type) || "motivating_video".equals(type)) {
                        QuestAttributes attributes = questBeanM60633m.getAttributes();
                        if (attributes == null) {
                            C11839m.m70687e("QuestManager", "adsActivation attributes null");
                        } else {
                            AdsActivationAttr adsActivation = attributes.getAdsActivation();
                            if (adsActivation == null) {
                                C11839m.m70687e("QuestManager", "adsActivation null");
                            } else {
                                questBeanM60633m.setHiCloudNativeAdId(adsActivation.getAdSlotId());
                            }
                        }
                    } else if (!"feature_switch".equals(type)) {
                        questBeanM60633m.setAttributes(null);
                    }
                    arrayList.add(questBeanM60633m);
                    C11839m.m70686d("QuestManager", "getQuestResources: add " + questBeanM60633m.getId());
                } else if (m78076Q0(questBeanM60633m, z10)) {
                    arrayList.add(questBeanM60633m);
                    C11839m.m70686d("QuestManager", "getQuestResources: add " + questBeanM60633m.getId());
                } else {
                    C11839m.m70687e("QuestManager", "adsActivation null");
                }
            } else {
                C11839m.m70687e("QuestManager", "quest quota null");
            }
        }
        String strM75485c = C12540b1.m75485c(arrayList);
        C11839m.m70686d("QuestManager", "getQuestResources: " + strM75485c);
        return strM75485c;
    }

    /* renamed from: Y0 */
    public void m78091Y0(String str) {
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "upload_file", str);
    }

    /* renamed from: Z */
    public String m78092Z() {
        return this.f59183g;
    }

    /* renamed from: Z0 */
    public void m78093Z0(Context context, CharSequence charSequence) {
        C11839m.m70686d("QuestManager", "show toast, text: " + ((Object) charSequence));
        if (context == null) {
            C11839m.m70687e("QuestManager", "show toast, context null ");
            return;
        }
        if (this.f59180d != null) {
            C11839m.m70686d("QuestManager", "mToast is not null, text: " + ((Object) charSequence));
            this.f59180d.cancel();
        }
        Toast toastMakeText = Toast.makeText(context, charSequence, 0);
        this.f59180d = toastMakeText;
        toastMakeText.show();
    }

    /* renamed from: a0 */
    public final String m78094a0(H5TaskCacheBean h5TaskCacheBean) {
        ReqDispatchRoot reqDispatchRoot = new ReqDispatchRoot();
        ReqDispatchEvent reqDispatchEvent = new ReqDispatchEvent();
        if (h5TaskCacheBean == null) {
            reqDispatchRoot.setEvent(reqDispatchEvent);
            return C12540b1.m75485c(reqDispatchRoot);
        }
        String id2 = h5TaskCacheBean.getId();
        String questType = h5TaskCacheBean.getQuestType();
        reqDispatchEvent.setId(id2);
        if ("calendar_notify".equals(questType)) {
            reqDispatchEvent.setType("calendar_notify");
        } else if ("feature_switch".equals(questType)) {
            reqDispatchEvent.setType("feature_enable");
            ReqDispatchFeatureEnable reqDispatchFeatureEnable = new ReqDispatchFeatureEnable();
            reqDispatchFeatureEnable.setTag(h5TaskCacheBean.getTag());
            reqDispatchEvent.setFeatureEnable(reqDispatchFeatureEnable);
        } else if ("upload_file".equals(questType)) {
            reqDispatchEvent.setType("upload_file");
            ReqDispatchUploadFile reqDispatchUploadFile = new ReqDispatchUploadFile();
            reqDispatchUploadFile.setService(h5TaskCacheBean.getService());
            reqDispatchEvent.setUploadFile(reqDispatchUploadFile);
        } else if ("download_app".equals(questType)) {
            reqDispatchEvent.setType("download_app");
            ReqDispatchDownloadApp reqDispatchDownloadApp = new ReqDispatchDownloadApp();
            reqDispatchDownloadApp.setApp(h5TaskCacheBean.getApp());
            reqDispatchEvent.setDownloadApp(reqDispatchDownloadApp);
        } else if ("ka_activation".equals(questType)) {
            reqDispatchEvent.setType("ka_activation");
        } else if ("create_drive_file".equals(questType)) {
            reqDispatchEvent.setType("create_drive_file");
        } else if ("create_drive_folder".equals(questType)) {
            reqDispatchEvent.setType("create_drive_folder");
        } else if ("use_space_optimization".equals(questType)) {
            reqDispatchEvent.setType("use_space_optimization");
        } else if ("motivating_video".equals(questType)) {
            reqDispatchEvent.setType("motivating_video");
        } else if ("app_activation".equals(questType)) {
            reqDispatchEvent.setType("app_activation");
            ReqDispatchActivateApp reqDispatchActivateApp = new ReqDispatchActivateApp();
            reqDispatchActivateApp.setApp(h5TaskCacheBean.getApp());
            reqDispatchEvent.setActivateApp(reqDispatchActivateApp);
        }
        reqDispatchRoot.setEvent(reqDispatchEvent);
        return C12540b1.m75485c(reqDispatchRoot);
    }

    /* renamed from: a1 */
    public void m78095a1(Handler handler, String str) {
        m78119p0(handler, String.format(Locale.ENGLISH, "%s(%s)", "triggerReportListener", C12996d.m77973p(str)));
    }

    /* renamed from: b0 */
    public final String m78096b0(String str) {
        String str2;
        str.hashCode();
        switch (str) {
            case "wlan":
                str2 = "feature_switch_wlan";
                break;
            case "browser":
                str2 = "feature_switch_browser";
                break;
            case "contact":
                str2 = "feature_switch_contact";
                break;
            case "notepad":
                str2 = "feature_switch_notepad";
                break;
            default:
                str2 = null;
                break;
        }
        C11839m.m70688i("QuestManager", "getSpKeyName, spKey is: " + str2);
        return str2;
    }

    /* renamed from: b1 */
    public void m78097b1(Handler handler, String str) {
        m78119p0(handler, String.format(Locale.ENGLISH, "%s(%s)", "webAtListener", C12996d.m77973p(str)));
    }

    /* renamed from: c0 */
    public H5TaskCacheBean m78098c0() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "space_optimization", "");
        if (strM1364n != null) {
            return (H5TaskCacheBean) C12540b1.m75483a(strM1364n, H5TaskCacheBean.class);
        }
        return null;
    }

    /* renamed from: d0 */
    public int m78099d0() {
        return this.f59184h;
    }

    /* renamed from: e0 */
    public H5TaskCacheBean m78100e0() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "upload_file", "");
        if (strM1364n != null) {
            return (H5TaskCacheBean) C12540b1.m75483a(strM1364n, H5TaskCacheBean.class);
        }
        return null;
    }

    /* renamed from: f0 */
    public String m78101f0(boolean z10) {
        C11839m.m70688i("QuestManager", "getWebAt forceUpdate=" + z10);
        if (z10) {
            try {
                C13196m.m79363o().m79375t(this.f59181e);
            } catch (C13194k | C13199p e10) {
                C11839m.m70686d("QuestManager", "getWebAt exception=" + e10.getMessage());
            }
        }
        this.f59181e = C13196m.m79363o().m79367k();
        return this.f59181e;
    }

    /* renamed from: g0 */
    public void m78102g0() {
        this.f59181e = "";
        this.f59190n = false;
    }

    /* renamed from: h0 */
    public final boolean m78103h0(String str) {
        return (TextUtils.isEmpty(str) || this.f59177a.get(str) == null) ? false : true;
    }

    /* renamed from: i */
    public void m78104i(Handler handler, String str) {
        m78119p0(handler, String.format(Locale.ENGLISH, "%s(%s)", "activityEnteryAndConfigListener", C12996d.m77973p(str)));
    }

    /* renamed from: i0 */
    public final boolean m78105i0(String str) {
        return (TextUtils.isEmpty(str) || this.f59178b.get(str) == null) ? false : true;
    }

    /* renamed from: j */
    public void m78106j(Handler handler, String str) {
        m78119p0(handler, String.format(Locale.ENGLISH, "%s(%s)", "activityEnteryListListener", C12996d.m77973p(str)));
    }

    /* renamed from: j0 */
    public void m78107j0(Handler handler, H5TaskCacheBean h5TaskCacheBean) {
        if (h5TaskCacheBean == null) {
            C11839m.m70689w("QuestManager", "permissionUpdate taskCacheBean null");
            return;
        }
        String questId = h5TaskCacheBean.getQuestId();
        HashMap map = new HashMap();
        map.put("item", 2);
        map.put("value", 1);
        C10271w0 c10271w0 = new C10271w0(C12540b1.m75485c(map), new b(handler, h5TaskCacheBean, questId));
        if (!m78105i0(questId)) {
            C11839m.m70688i("QuestManager", "send permissionUpdate TaskReq");
            m78112m(questId, h5TaskCacheBean);
            c10271w0.m63381g();
        } else {
            C11839m.m70686d("QuestManager", "contains cache task: " + questId);
        }
    }

    /* renamed from: k */
    public void m78108k(Handler handler, String str) {
        m78119p0(handler, String.format(Locale.ENGLISH, "%s(%s)", "activityResourcesListener", C12996d.m77973p(str)));
    }

    /* renamed from: k0 */
    public void m78109k0(Handler handler, H5TaskCacheBean h5TaskCacheBean, CountDownLatch countDownLatch) {
        C11839m.m70688i("QuestManager", "postActivityDispatch");
        m78111l0(handler, null, h5TaskCacheBean, countDownLatch, false);
    }

    /* renamed from: l */
    public final void m78110l(String str, H5TaskCacheBean h5TaskCacheBean) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f59177a.put(str, h5TaskCacheBean);
    }

    /* renamed from: l0 */
    public final void m78111l0(Handler handler, String str, H5TaskCacheBean h5TaskCacheBean, CountDownLatch countDownLatch, boolean z10) {
        if (h5TaskCacheBean == null) {
            C11839m.m70689w("QuestManager", "postActivityDispatch taskCacheBean null");
            m78043A(countDownLatch);
            return;
        }
        String activityId = h5TaskCacheBean.getActivityId();
        String sessionId = h5TaskCacheBean.getSessionId();
        String questId = h5TaskCacheBean.getQuestId();
        String strM78094a0 = TextUtils.isEmpty(str) ? m78094a0(h5TaskCacheBean) : str;
        C11839m.m70686d("QuestManager", "postActivityDispatch:" + strM78094a0);
        C10240k c10240k = new C10240k(activityId, sessionId, questId, strM78094a0, new a(countDownLatch, handler, questId, z10, h5TaskCacheBean));
        if (!m78103h0(questId)) {
            C11839m.m70688i("QuestManager", "sendTaskReq");
            m78110l(questId, h5TaskCacheBean);
            c10240k.m63381g();
        } else {
            C11839m.m70688i("QuestManager", "contains cache report: " + questId);
            m78043A(countDownLatch);
        }
    }

    /* renamed from: m */
    public final void m78112m(String str, H5TaskCacheBean h5TaskCacheBean) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f59178b.put(str, h5TaskCacheBean);
    }

    /* renamed from: m0 */
    public void m78113m0(Handler handler, String str, String str2, String str3, String str4, CountDownLatch countDownLatch) {
        C11839m.m70688i("QuestManager", "postActivityDispatch by h5");
        H5TaskCacheBean h5TaskCacheBean = new H5TaskCacheBean();
        h5TaskCacheBean.setActivityId(str);
        h5TaskCacheBean.setSessionId(str2);
        h5TaskCacheBean.setQuestId(str3);
        m78111l0(handler, str4, h5TaskCacheBean, countDownLatch, false);
    }

    /* renamed from: n */
    public void m78114n() {
        C11839m.m70686d("QuestManager", "cancel toast");
        if (this.f59180d != null) {
            C11839m.m70686d("QuestManager", "mToast is not null");
            this.f59180d.cancel();
        }
    }

    /* renamed from: n0 */
    public final void m78115n0(Handler handler, String str, String str2, boolean z10) {
        String str3;
        C11839m.m70687e("QuestManager", "post activity dispatch failed");
        this.f59191o = "1";
        if ("31014033".equals(str2)) {
            str3 = "4";
            this.f59191o = "4";
        } else if ("31014004".equals(str2)) {
            str3 = "5";
            this.f59191o = "5";
        } else {
            str3 = "2";
        }
        if (z10) {
            if (C0209d.m1245d1(C0213f.m1377a(), GuideWebViewActivity.class.getName())) {
                m78046B0(handler, str, str3, str2);
                return;
            }
        } else if (this.f59190n && C0209d.m1245d1(C0213f.m1377a(), CampaignActivity.class.getName())) {
            Handler handlerM78075Q = m78075Q(handler, false);
            C11839m.m70688i("QuestManager", "postActivityDispatch error send message");
            m78046B0(handlerM78075Q, str, str3, str2);
            return;
        }
        C11839m.m70688i("QuestManager", "postActivityDispatchFail save cache");
    }

    /* renamed from: o */
    public void m78116o(Handler handler, boolean z10, CountDownLatch countDownLatch) {
        C11839m.m70688i("QuestManager", "checkCloudBackupSwitchReport");
        H5TaskCacheBean h5TaskCacheBeanM78061J = m78061J();
        if (h5TaskCacheBeanM78061J == null) {
            C11839m.m70688i("QuestManager", "taskCacheBean null");
            m78043A(countDownLatch);
            return;
        }
        long startTime = h5TaskCacheBeanM78061J.getStartTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < startTime || jCurrentTimeMillis - startTime > C9718g.m60602t().m60643y()) {
            C11839m.m70688i("QuestManager", "cloudBackupSwitchReport false");
            m78137y0(handler, h5TaskCacheBeanM78061J.getQuestId(), z10);
            m78043A(countDownLatch);
        } else {
            if (!C10028c.m62182c0().m62388s("backup_key")) {
                C11839m.m70688i("QuestManager", "backup switch off");
                m78137y0(handler, h5TaskCacheBeanM78061J.getQuestId(), z10);
                m78043A(countDownLatch);
                return;
            }
            C11839m.m70688i("QuestManager", "cloudBackupSwitchReport");
            m78034R().m78109k0(handler, h5TaskCacheBeanM78061J, countDownLatch);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("task_type", "feature_switch");
            linkedHashMap.put("task_id", h5TaskCacheBeanM78061J.getQuestId());
            linkedHashMap.put("task_attr", h5TaskCacheBeanM78061J.getTag());
            C12997e.m78025r("feature_switch_event", linkedHashMap);
        }
    }

    /* renamed from: o0 */
    public final void m78117o0(Handler handler, String str, String str2, int i10, int i11, boolean z10) {
        C11839m.m70688i("QuestManager", "post activity dispatch success");
        this.f59191o = "0";
        if (z10) {
            if (C0209d.m1245d1(C0213f.m1377a(), GuideWebViewActivity.class.getName())) {
                m78048C0(handler, str, str2, i10, i11);
                return;
            }
        } else if (this.f59190n && C0209d.m1245d1(C0213f.m1377a(), CampaignActivity.class.getName())) {
            m78048C0(m78075Q(handler, false), str, str2, i10, i11);
            return;
        }
        C11839m.m70688i("QuestManager", "postActivityDispatchResult save cache");
        m78034R().m78085V0(str, str2, i10, i11);
    }

    /* renamed from: p */
    public void m78118p(Handler handler) {
        C11839m.m70688i("QuestManager", "checkDiskBack");
        H5TaskCacheBean h5TaskCacheBeanM78069N = this.f59187k ? m78069N(1) : this.f59188l ? m78069N(4) : this.f59189m ? m78069N(2) : null;
        this.f59187k = false;
        this.f59188l = false;
        this.f59189m = false;
        if (h5TaskCacheBeanM78069N == null) {
            C11839m.m70688i("QuestManager", "cacheBean null");
        } else {
            m78137y0(handler, h5TaskCacheBeanM78069N.getQuestId(), true);
            m78131v0(h5TaskCacheBeanM78069N);
        }
    }

    /* renamed from: p0 */
    public final void m78119p0(Handler handler, String str) {
        if (handler != null) {
            Message message = new Message();
            message.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString("javascript", str);
            message.setData(bundle);
            handler.sendMessage(message);
        }
    }

    /* renamed from: q */
    public void m78120q(Handler handler, CountDownLatch countDownLatch) {
        C11839m.m70688i("QuestManager", "checkDownloadAppReport");
        H5TaskCacheBean h5TaskCacheBeanM78084V = m78084V();
        if (h5TaskCacheBeanM78084V == null) {
            C11839m.m70688i("QuestManager", "cacheBean null");
            m78043A(countDownLatch);
        } else if (!TextUtils.isEmpty(h5TaskCacheBeanM78084V.getApp())) {
            m78034R().m78109k0(handler, h5TaskCacheBeanM78084V, countDownLatch);
        } else {
            C11839m.m70688i("QuestManager", "cacheBean app null");
            m78043A(countDownLatch);
        }
    }

    /* renamed from: q0 */
    public void m78121q0(Handler handler) {
        C11839m.m70688i("QuestManager", "processBackFromUpgradeActivity");
        String strM67701h = C11280c.m67701h();
        if (TextUtils.isEmpty(strM67701h)) {
            C11839m.m70687e("QuestManager", "processBackFromUpgradeActivity: questId is empty");
        } else {
            C11280c.m67706m("");
            m78117o0(handler, strM67701h, "-1", 0, 0, false);
        }
    }

    /* renamed from: r */
    public void m78122r(Handler handler, boolean z10, CountDownLatch countDownLatch) {
        C11839m.m70688i("QuestManager", "checkFindDeviceSwitchReport");
        H5TaskCacheBean h5TaskCacheBeanM78071O = m78071O();
        if (h5TaskCacheBeanM78071O == null) {
            m78043A(countDownLatch);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long startTime = h5TaskCacheBeanM78071O.getStartTime();
        if (jCurrentTimeMillis < startTime || jCurrentTimeMillis - startTime > C9718g.m60602t().m60643y()) {
            C11839m.m70688i("QuestManager", "findDeviceSwitchReport false");
            m78043A(countDownLatch);
            m78137y0(handler, h5TaskCacheBeanM78071O.getQuestId(), z10);
            return;
        }
        InterfaceC9287f interfaceC9287f = (InterfaceC9287f) C1270a.m7534b().m7535a(InterfaceC9287f.class);
        if (interfaceC9287f != null && !interfaceC9287f.mo58574q(C0213f.m1377a())) {
            C11839m.m70688i("QuestManager", "checkFindDeviceSwitchReport not open!");
            m78043A(countDownLatch);
            m78137y0(handler, h5TaskCacheBeanM78071O.getQuestId(), z10);
            return;
        }
        C11839m.m70688i("QuestManager", "findDeviceSwitchReport");
        m78034R().m78109k0(handler, h5TaskCacheBeanM78071O, countDownLatch);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("task_type", "feature_switch");
        linkedHashMap.put("task_id", h5TaskCacheBeanM78071O.getQuestId());
        linkedHashMap.put("task_attr", h5TaskCacheBeanM78071O.getTag());
        C12997e.m78025r("feature_switch_event", linkedHashMap);
    }

    /* renamed from: r0 */
    public void m78123r0(Handler handler, String str, String str2) {
        m78119p0(handler, String.format(Locale.ENGLISH, "%s(%s)", str2, str));
    }

    /* renamed from: s */
    public void m78124s(Handler handler, boolean z10, CountDownLatch countDownLatch) {
        C11839m.m70688i("QuestManager", "checkGalleryMainSwitchReport");
        H5TaskCacheBean h5TaskCacheBeanM78073P = m78073P();
        if (h5TaskCacheBeanM78073P == null) {
            m78043A(countDownLatch);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long startTime = h5TaskCacheBeanM78073P.getStartTime();
        if (jCurrentTimeMillis < startTime || jCurrentTimeMillis - startTime > C9718g.m60602t().m60643y()) {
            C11839m.m70688i("QuestManager", "galleryMainSwitchReport false");
            m78137y0(handler, h5TaskCacheBeanM78073P.getQuestId(), z10);
            m78043A(countDownLatch);
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("QuestManager", "cloudAlbumRouter null");
            m78137y0(handler, h5TaskCacheBeanM78073P.getQuestId(), z10);
            m78043A(countDownLatch);
        } else {
            if (!interfaceC9282a.mo58417d(C0213f.m1377a())) {
                C11839m.m70688i("QuestManager", "album switch off");
                m78137y0(handler, h5TaskCacheBeanM78073P.getQuestId(), z10);
                m78043A(countDownLatch);
                return;
            }
            C11839m.m70688i("QuestManager", "galleryMainSwitchReport");
            m78034R().m78109k0(handler, h5TaskCacheBeanM78073P, countDownLatch);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("task_type", "feature_switch");
            linkedHashMap.put("task_id", h5TaskCacheBeanM78073P.getQuestId());
            linkedHashMap.put("task_attr", h5TaskCacheBeanM78073P.getTag());
            C12997e.m78025r("feature_switch_event", linkedHashMap);
        }
    }

    /* renamed from: s0 */
    public final void m78125s0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f59177a.remove(str);
    }

    /* renamed from: t */
    public void m78126t(Handler handler, CountDownLatch countDownLatch, boolean z10) {
        C11839m.m70688i("QuestManager", "checkKAReport");
        H5TaskCacheBean h5TaskCacheBeanM78078S = m78078S();
        if (h5TaskCacheBeanM78078S != null) {
            m78034R().m78111l0(handler, null, h5TaskCacheBeanM78078S, countDownLatch, z10);
        } else {
            C11839m.m70688i("QuestManager", "checkKAReport cacheBean null");
            m78043A(countDownLatch);
        }
    }

    /* renamed from: t0 */
    public final void m78127t0(H5TaskCacheBean h5TaskCacheBean) {
        if (h5TaskCacheBean == null || !SpaceSwitchSuggestDialog.SCENE_ID_NOTIFY.equals(h5TaskCacheBean.getTag())) {
            return;
        }
        m78129u0(h5TaskCacheBean.getQuestId());
    }

    /* renamed from: u */
    public void m78128u(Handler handler, CountDownLatch countDownLatch, boolean z10) {
        C11839m.m70688i("QuestManager", "checkKAReport");
        H5TaskCacheBean h5TaskCacheBeanM78078S = m78078S();
        if (h5TaskCacheBeanM78078S == null) {
            C11839m.m70688i("QuestManager", "checkKAReport cacheBean null");
            m78043A(countDownLatch);
        } else {
            m78137y0(handler, h5TaskCacheBeanM78078S.getQuestId(), z10);
            m78043A(countDownLatch);
        }
    }

    /* renamed from: u0 */
    public final void m78129u0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f59178b.remove(str);
    }

    /* renamed from: v */
    public void m78130v(Handler handler, boolean z10, String str, CountDownLatch countDownLatch) {
        C11839m.m70688i("QuestManager", "checkMainSwitchReport");
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("QuestManager", "checkMainSwitchReport, switchType null");
            m78043A(countDownLatch);
            return;
        }
        H5TaskCacheBean h5TaskCacheBeanM78063K = m78063K(str);
        if (h5TaskCacheBeanM78063K == null) {
            C11839m.m70688i("QuestManager", "checkMainSwitchReport, taskCacheBean null");
            m78043A(countDownLatch);
            return;
        }
        long startTime = h5TaskCacheBeanM78063K.getStartTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < startTime || jCurrentTimeMillis - startTime > C9718g.m60602t().m60643y()) {
            C11839m.m70688i("QuestManager", "checkMainSwitchReport false");
            m78043A(countDownLatch);
            m78137y0(handler, h5TaskCacheBeanM78063K.getQuestId(), z10);
            return;
        }
        if (C10028c.m62182c0().m62388s(m78057H(str))) {
            m78034R().m78109k0(handler, h5TaskCacheBeanM78063K, countDownLatch);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("task_type", "feature_switch");
            linkedHashMap.put("task_id", h5TaskCacheBeanM78063K.getQuestId());
            linkedHashMap.put("task_attr", h5TaskCacheBeanM78063K.getTag());
            C12997e.m78025r("feature_switch_event", linkedHashMap);
            return;
        }
        C11839m.m70688i("QuestManager", "checkMainSwitchReport, switchType is: " + str + ", not open!");
        m78137y0(handler, h5TaskCacheBeanM78063K.getQuestId(), z10);
        m78043A(countDownLatch);
    }

    /* renamed from: v0 */
    public final void m78131v0(H5TaskCacheBean h5TaskCacheBean) {
        C11839m.m70688i("QuestManager", "removeTaskCache");
        if (h5TaskCacheBean == null) {
            C11839m.m70688i("QuestManager", "taskCacheBean null");
            return;
        }
        String questType = h5TaskCacheBean.getQuestType();
        String questId = h5TaskCacheBean.getQuestId();
        if (TextUtils.isEmpty(questType)) {
            C11839m.m70688i("QuestManager", "questType is empty");
            return;
        }
        Context contextM1377a = C0213f.m1377a();
        if ("calendar_notify".equals(questType)) {
            C11839m.m70688i("QuestManager", "remove calendar cache");
            C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "calendar_notify");
            return;
        }
        if ("feature_switch".equals(questType)) {
            String tag = h5TaskCacheBean.getTag();
            if (CloudBackupConstant.Command.PMS_CMD_BACKUP.equals(tag)) {
                C11839m.m70688i("QuestManager", "remove backup cache");
                C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "future_switch_backup");
                return;
            }
            if ("photo".equals(tag)) {
                C11839m.m70688i("QuestManager", "remove album cache");
                C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "future_switch_photo");
                return;
            }
            if ("findDevice".equals(tag)) {
                C11839m.m70688i("QuestManager", "remove find cache");
                C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "feature_switch_find_device");
                return;
            } else {
                if ("browser".equals(tag) || HNConstants.DataType.CONTACT.equals(tag) || "notepad".equals(tag) || "wlan".equals(tag)) {
                    C11839m.m70688i("QuestManager", "remove album cache");
                    C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", m78096b0(tag));
                    return;
                }
                return;
            }
        }
        if ("upload_file".equals(questType)) {
            C11839m.m70688i("QuestManager", "remove cloud disk [upload] cache ");
            C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "upload_file");
            return;
        }
        if ("create_drive_file".equals(questType)) {
            C11839m.m70688i("QuestManager", "remove cloud disk [create_file] cache");
            C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "create_drive_file");
            return;
        }
        if ("create_drive_folder".equals(questType)) {
            C11839m.m70688i("QuestManager", "remove cloud disk [create_folder] cache");
            C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "create_drive_folder");
            return;
        }
        if ("download_app".equals(questType)) {
            C11839m.m70688i("QuestManager", "remove app cache");
            C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "download_app");
            C12996d.m77971n().m78006z(questId);
            return;
        }
        if ("ka_activation".equals(questType)) {
            C11839m.m70688i("QuestManager", "remove ka cache");
            C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "ka_activation");
            return;
        }
        if ("use_space_optimization".equals(questType)) {
            C11839m.m70688i("QuestManager", "remove use_space_optimization cache");
            C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "space_optimization");
        } else if ("motivating_video".equals(questType)) {
            C11839m.m70688i("QuestManager", "remove motivating_video cache");
            C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "motivating_video");
        } else if ("app_activation".equals(questType)) {
            C11839m.m70688i("QuestManager", "remove app_activation cache");
            C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "app_activation");
        }
    }

    /* renamed from: w */
    public void m78132w(Handler handler, String str) {
        C11839m.m70688i("QuestManager", "checkPPSDownloadReport");
        H5TaskCacheBean h5TaskCacheBeanM78084V = m78084V();
        if (h5TaskCacheBeanM78084V == null) {
            C11839m.m70688i("QuestManager", "cacheBean null");
            return;
        }
        if (TextUtils.isEmpty(h5TaskCacheBeanM78084V.getApp())) {
            C11839m.m70688i("QuestManager", "cacheBean app null");
        } else if (str == null) {
            C11839m.m70688i("QuestManager", "packageName null");
        } else if (str.equals(h5TaskCacheBeanM78084V.getApp())) {
            m78034R().m78109k0(handler, h5TaskCacheBeanM78084V, null);
        }
    }

    /* renamed from: w0 */
    public final void m78133w0(Handler handler, int i10, boolean z10) {
        C11839m.m70688i("QuestManager", "reportCampaignLaunched");
        Handler handlerM78075Q = m78075Q(handler, z10);
        if (handlerM78075Q == null) {
            C11839m.m70687e("QuestManager", "handler is null");
            return;
        }
        Message messageObtain = Message.obtain(handlerM78075Q);
        if (i10 == 0) {
            messageObtain.what = 7007;
            messageObtain.arg1 = 0;
        } else {
            messageObtain.what = 7008;
            messageObtain.arg1 = i10;
        }
        handlerM78075Q.sendMessage(messageObtain);
    }

    /* renamed from: x */
    public void m78134x(Context context, SafeWebView safeWebView, String str) {
        C11839m.m70688i("QuestManager", "checkPostActivityDispatchResult, state: " + this.f59191o + "errCode " + str);
        if (TextUtils.equals("1", this.f59191o) && !"31015042".equals(str)) {
            m78093Z0(context, context.getString(R$string.msg_campaign_report_fail));
        } else if (TextUtils.equals("5", this.f59191o)) {
            m78093Z0(context, context.getString(R$string.msg_campaign_report_repeat));
        } else if (TextUtils.equals("4", this.f59191o)) {
            C4308a.m25915n("", "4", 0, 0, safeWebView);
        }
        this.f59191o = "0";
    }

    /* renamed from: x0 */
    public void m78135x0(Handler handler, String str, String str2, String str3, String str4) {
        m78113m0(handler, str, str2, str3, str4, null);
    }

    /* renamed from: y */
    public void m78136y(Handler handler, boolean z10, CountDownLatch countDownLatch) {
        C11839m.m70688i("QuestManager", "checkSpaceOptimizationReport");
        H5TaskCacheBean h5TaskCacheBeanM78098c0 = m78098c0();
        if (h5TaskCacheBeanM78098c0 == null) {
            m78043A(countDownLatch);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long startTime = h5TaskCacheBeanM78098c0.getStartTime();
        if (jCurrentTimeMillis < startTime || jCurrentTimeMillis - startTime > C9718g.m60602t().m60643y()) {
            C11839m.m70688i("QuestManager", "galleryMainSwitchReport false");
            m78043A(countDownLatch);
            m78137y0(handler, h5TaskCacheBeanM78098c0.getQuestId(), z10);
            return;
        }
        C11839m.m70688i("QuestManager", "SpaceOptimizationReport");
        m78034R().m78109k0(handler, h5TaskCacheBeanM78098c0, countDownLatch);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("task_type", "feature_switch");
        linkedHashMap.put("task_id", h5TaskCacheBeanM78098c0.getQuestId());
        linkedHashMap.put("task_attr", h5TaskCacheBeanM78098c0.getTag());
        C12997e.m78025r("feature_switch_event", linkedHashMap);
    }

    /* renamed from: y0 */
    public final void m78137y0(Handler handler, String str, boolean z10) {
        if (!z10) {
            C11839m.m70688i("QuestManager", "no need to report NotComplete");
        } else if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("QuestManager", "questId is empty");
        } else {
            C11839m.m70686d("QuestManager", "report task not complete");
            m78117o0(handler, str, "2", 0, 0, false);
        }
    }

    /* renamed from: z */
    public void m78138z() {
        this.f59177a.clear();
        this.f59178b.clear();
    }

    /* renamed from: z0 */
    public void m78139z0(H5TaskCacheBean h5TaskCacheBean) {
        if (h5TaskCacheBean == null) {
            return;
        }
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "ka_activation", C12540b1.m75485c(h5TaskCacheBean));
    }

    public C12998f() {
        this.f59177a = new ConcurrentHashMap<>();
        this.f59178b = new ConcurrentHashMap<>();
        this.f59187k = false;
        this.f59188l = false;
        this.f59189m = false;
        this.f59190n = false;
    }
}
