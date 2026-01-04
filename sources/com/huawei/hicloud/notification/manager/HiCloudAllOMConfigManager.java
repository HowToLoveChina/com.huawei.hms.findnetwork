package com.huawei.hicloud.notification.manager;

import android.content.Context;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.spacelanguage.manager.SpaceMultLanguageManager;
import com.huawei.hicloud.notification.task.BackupBeforeNoticeDownloadTask;
import com.huawei.hicloud.notification.task.CampaignActivityConfigQueryTask;
import com.huawei.hicloud.notification.task.CampaignQuestConfigQueryTask;
import com.huawei.hicloud.notification.task.DataUpperLimitConfigDownloadTask;
import com.huawei.hicloud.notification.task.FrequencyControlConfigDownloadTask;
import com.huawei.hicloud.notification.task.HiCloudMsgNoticeConfigDownloadTask;
import com.huawei.hicloud.notification.task.HiCloudParamMetaQueryTask;
import com.huawei.hicloud.notification.task.HiCloudPushGuideTask;
import com.huawei.hicloud.notification.task.HiCloudUpgradeConfigDownloadTask;
import com.huawei.hicloud.notification.task.HiCloudWebViewConfigTask;
import com.huawei.hicloud.notification.task.HomepageSwitchConfigDownloadTask;
import com.huawei.hicloud.notification.task.QueryBlackListConfigTask;
import com.huawei.hicloud.notification.task.QueryHiCloudBrandBuyBannerTask;
import com.huawei.hicloud.notification.task.QueryHiCloudBrandHomePageBannerTask;
import com.huawei.hicloud.notification.task.QueryHiCloudH5ConfigTask;
import com.huawei.hicloud.notification.task.QueryHiCloudSceneBuyBannerTask;
import com.huawei.hicloud.notification.task.QueryHiCloudSceneHomePageBannerTask;
import com.huawei.hicloud.notification.task.QueryHiCloudSceneSpaceMgrBannerTask;
import com.huawei.hicloud.notification.task.QueryHiCloudSpacePositionMgrTask;
import com.huawei.hicloud.notification.task.QueryOmNoticeConfigTask;
import com.huawei.hicloud.notification.task.SpaceNoticeV3ConfigDownloadTask;
import com.huawei.hicloud.notification.task.SpaceNoticeV4ConfigDownloadTask;
import com.huawei.hicloud.notification.task.SpaceNoticeV5ConfigDownloadTask;
import com.huawei.hicloud.notification.task.TextLinkConfigQueryTask;
import com.huawei.hicloud.service.AbstractC5012g;
import com.huawei.hicloud.service.C5000a;
import com.huawei.hicloud.service.C5001a0;
import com.huawei.hicloud.service.C5002b;
import com.huawei.hicloud.service.C5003b0;
import com.huawei.hicloud.service.C5005c0;
import com.huawei.hicloud.service.C5006d;
import com.huawei.hicloud.service.C5007d0;
import com.huawei.hicloud.service.C5008e;
import com.huawei.hicloud.service.C5011f0;
import com.huawei.hicloud.service.C5013g0;
import com.huawei.hicloud.service.C5014h;
import com.huawei.hicloud.service.C5015i;
import com.huawei.hicloud.service.C5016j;
import com.huawei.hicloud.service.C5017k;
import com.huawei.hicloud.service.C5018l;
import com.huawei.hicloud.service.C5020n;
import com.huawei.hicloud.service.C5021o;
import com.huawei.hicloud.service.C5022p;
import com.huawei.hicloud.service.C5023q;
import com.huawei.hicloud.service.C5024r;
import com.huawei.hicloud.service.C5025s;
import com.huawei.hicloud.service.C5027u;
import com.huawei.hicloud.service.C5028v;
import com.huawei.hicloud.service.C5029w;
import com.huawei.hicloud.service.C5030x;
import com.huawei.hicloud.service.C5031y;
import com.huawei.hicloud.service.C5032z;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;
import gp.C10028c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import p015ak.C0209d;
import p292fn.C9733f;
import p459lp.C11327e;
import p459lp.C11329g;
import p459lp.InterfaceC11332j;
import p616rk.C12515a;
import p684un.C13227f;
import p709vj.C13452e;
import p778xk.C13821b;
import p778xk.C13826g;

/* loaded from: classes6.dex */
public class HiCloudAllOMConfigManager {
    private static final String TAG = "HiCloudAllOMConfigManager";
    private static Set<String> needFilterMap;
    private InterfaceC11332j configProxy;
    private static HashMap<String, AbstractC5012g> updateConfigMap = new HashMap<String, AbstractC5012g>() { // from class: com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager.1
        public C49201() {
            put("HiCloudSpaceMultLanguage", new C5031y(null));
            put("HiCloudStaticPage", new C5006d(null));
            put("HiCloudNoticeConfigAllInOne", new C5007d0(null));
            put("HiCloudSysParam", new C5003b0(null));
            put("HiCloudActives", new C5015i(null));
            put("HiCloudAppFiles", new C11329g(null));
            put("HiCloudTrigger", new C5013g0(null));
            put("HiCloudPushGuide", new C5025s(null));
            put("HiCloudActivesH5", new HiCloudH5ConfigService(null));
            put("HiCloudSpaceNoticeConfigV3", new SpaceNoticeConfigServiceV3(null));
            put("HiCloudBrandHomePageBanner", new C5017k(null));
            put("HiCloudBrandBuyBanner", new C5016j(null));
            put("HiCloudSceneHomePageBanner", new C5028v(null));
            put("HiCloudSceneBuyBanner", new C5027u(null));
            put("HiCloudSpacePositionMgr", new C5032z(null));
            put("HiCloudOperPageHints", new C5021o(null));
            put("HiCloudSpaceFrequencyControl", new C5030x(null));
            put("HiCloudSceneSpaceMgrBanner", new C5029w(null));
            put("HiCloudNPSConfig", new C5023q(null));
            put("HiCloudMsgNoticeConfig", new C5022p(null));
            put("grays/functions", new C5008e(null));
            put("HiCloudCampaignActivities", new C5018l(null));
            put("HiCloudCampaignQuests", new C5020n(null));
            put("HiCloudTextLink", new C5011f0(null));
            put("HiCloudParamMeta", new C5024r(null));
            put("HiCloudDataUpperLimitNotice", new DataUpperLimitNoticeService(null));
            put("HiCloudHomepageSwitchNotice", new HomepageSwitchNoticeService(null));
            put(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE, new BackupBeforeNoticeServiceV3(null));
            put("HiCloudBackupSpaceInsuffNotice", new SpaceNoticeConfigServiceV4(null));
            put("HiCloudBackupSpaceInsuffNoticeV5", new BackupSpaceInsuffNoticeV5Service(null));
            put("HiCloudWebViewAllownlist", new C5005c0(null));
            put("HiCloudSpaceUpgrade", new C5001a0(null));
            put("HiCloudNotifyBlackList", new C5014h(null));
        }
    };
    private static HashMap<String, AbstractC5012g> flowControlConfigMap = new HashMap<String, AbstractC5012g>() { // from class: com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager.2
    };
    private static HashMap<String, AbstractC5012g> forceClearConfigMap = new HashMap<String, AbstractC5012g>() { // from class: com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager.3
        public C49223() {
            put("HiCloudSpaceMultLanguage", new C5031y(null));
            put("HiCloudNoticeConfigAllInOne", new C5007d0(null));
            put("HiCloudActives", new C5015i(null));
            put("HiCloudSpaceNoticeConfigV3", new SpaceNoticeConfigServiceV3(null));
            put("HiCloudPayBanners", new C5000a(null));
            put("HiCloudSpaceBannerConfigV2", new C5002b(null));
            put("HiCloudAppFiles", new C11329g(null));
            put("HiCloudActivesH5", new HiCloudH5ConfigService(null));
            put("HiCloudSpaceFrequencyControl", new C5030x(null));
            put("HiCloudBrandHomePageBanner", new C5017k(null));
            put("HiCloudBrandBuyBanner", new C5016j(null));
            put("HiCloudSpacePositionMgr", new C5032z(null));
            put("HiCloudMsgNoticeConfig", new C5022p(null));
            put("HiCloudCampaignActivities", new C5018l(null));
            put("HiCloudCampaignQuests", new C5020n(null));
            put("HiCloudSceneHomePageBanner", new C5028v(null));
            put(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE, new BackupBeforeNoticeServiceV3(null));
            put("HiCloudDataUpperLimitNotice", new DataUpperLimitNoticeService(null));
            put("HiCloudHomepageSwitchNotice", new HomepageSwitchNoticeService(null));
            put("HiCloudBackupSpaceInsuffNotice", new SpaceNoticeConfigServiceV4(null));
            put("HiCloudBackupSpaceInsuffNoticeV5", new BackupSpaceInsuffNoticeV5Service(null));
            put("HiCloudTextLink", new C5011f0(null));
            put("HiCloudOperPageHints", new C5021o(null));
            put("HiCloudSpaceUpgrade", new C5001a0(null));
            put("HiCloudNotifyBlackList", new C5014h(null));
        }
    };

    /* renamed from: com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager$1 */
    public class C49201 extends HashMap<String, AbstractC5012g> {
        public C49201() {
            put("HiCloudSpaceMultLanguage", new C5031y(null));
            put("HiCloudStaticPage", new C5006d(null));
            put("HiCloudNoticeConfigAllInOne", new C5007d0(null));
            put("HiCloudSysParam", new C5003b0(null));
            put("HiCloudActives", new C5015i(null));
            put("HiCloudAppFiles", new C11329g(null));
            put("HiCloudTrigger", new C5013g0(null));
            put("HiCloudPushGuide", new C5025s(null));
            put("HiCloudActivesH5", new HiCloudH5ConfigService(null));
            put("HiCloudSpaceNoticeConfigV3", new SpaceNoticeConfigServiceV3(null));
            put("HiCloudBrandHomePageBanner", new C5017k(null));
            put("HiCloudBrandBuyBanner", new C5016j(null));
            put("HiCloudSceneHomePageBanner", new C5028v(null));
            put("HiCloudSceneBuyBanner", new C5027u(null));
            put("HiCloudSpacePositionMgr", new C5032z(null));
            put("HiCloudOperPageHints", new C5021o(null));
            put("HiCloudSpaceFrequencyControl", new C5030x(null));
            put("HiCloudSceneSpaceMgrBanner", new C5029w(null));
            put("HiCloudNPSConfig", new C5023q(null));
            put("HiCloudMsgNoticeConfig", new C5022p(null));
            put("grays/functions", new C5008e(null));
            put("HiCloudCampaignActivities", new C5018l(null));
            put("HiCloudCampaignQuests", new C5020n(null));
            put("HiCloudTextLink", new C5011f0(null));
            put("HiCloudParamMeta", new C5024r(null));
            put("HiCloudDataUpperLimitNotice", new DataUpperLimitNoticeService(null));
            put("HiCloudHomepageSwitchNotice", new HomepageSwitchNoticeService(null));
            put(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE, new BackupBeforeNoticeServiceV3(null));
            put("HiCloudBackupSpaceInsuffNotice", new SpaceNoticeConfigServiceV4(null));
            put("HiCloudBackupSpaceInsuffNoticeV5", new BackupSpaceInsuffNoticeV5Service(null));
            put("HiCloudWebViewAllownlist", new C5005c0(null));
            put("HiCloudSpaceUpgrade", new C5001a0(null));
            put("HiCloudNotifyBlackList", new C5014h(null));
        }
    }

    /* renamed from: com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager$2 */
    public class C49212 extends HashMap<String, AbstractC5012g> {
    }

    /* renamed from: com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager$3 */
    public class C49223 extends HashMap<String, AbstractC5012g> {
        public C49223() {
            put("HiCloudSpaceMultLanguage", new C5031y(null));
            put("HiCloudNoticeConfigAllInOne", new C5007d0(null));
            put("HiCloudActives", new C5015i(null));
            put("HiCloudSpaceNoticeConfigV3", new SpaceNoticeConfigServiceV3(null));
            put("HiCloudPayBanners", new C5000a(null));
            put("HiCloudSpaceBannerConfigV2", new C5002b(null));
            put("HiCloudAppFiles", new C11329g(null));
            put("HiCloudActivesH5", new HiCloudH5ConfigService(null));
            put("HiCloudSpaceFrequencyControl", new C5030x(null));
            put("HiCloudBrandHomePageBanner", new C5017k(null));
            put("HiCloudBrandBuyBanner", new C5016j(null));
            put("HiCloudSpacePositionMgr", new C5032z(null));
            put("HiCloudMsgNoticeConfig", new C5022p(null));
            put("HiCloudCampaignActivities", new C5018l(null));
            put("HiCloudCampaignQuests", new C5020n(null));
            put("HiCloudSceneHomePageBanner", new C5028v(null));
            put(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE, new BackupBeforeNoticeServiceV3(null));
            put("HiCloudDataUpperLimitNotice", new DataUpperLimitNoticeService(null));
            put("HiCloudHomepageSwitchNotice", new HomepageSwitchNoticeService(null));
            put("HiCloudBackupSpaceInsuffNotice", new SpaceNoticeConfigServiceV4(null));
            put("HiCloudBackupSpaceInsuffNoticeV5", new BackupSpaceInsuffNoticeV5Service(null));
            put("HiCloudTextLink", new C5011f0(null));
            put("HiCloudOperPageHints", new C5021o(null));
            put("HiCloudSpaceUpgrade", new C5001a0(null));
            put("HiCloudNotifyBlackList", new C5014h(null));
        }
    }

    public static class HicloudConfigManagerHolder {
        public static HiCloudAllOMConfigManager INSTANCE = new HiCloudAllOMConfigManager();

        private HicloudConfigManagerHolder() {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        needFilterMap = hashSet;
        hashSet.add("grays/functions");
        needFilterMap.add("HiCloudParamMeta");
        needFilterMap.add("HiCloudSysParam");
    }

    private void deleteOldBannerConfigJson() {
        new C5002b(null).m30029a();
    }

    private void getConfigFromOMThree(String str) {
        str.hashCode();
        switch (str) {
            case "HiCloudDataUpperLimitNotice":
                C12515a.m75110o().m75172d(new DataUpperLimitConfigDownloadTask());
                break;
            case "HiCloudNotifyBlackList":
                C12515a.m75110o().m75172d(new QueryBlackListConfigTask());
                break;
            case "HiCloudParamMeta":
                C12515a.m75110o().m75172d(new HiCloudParamMetaQueryTask());
                break;
            case "HiCloudCampaignQuests":
                C12515a.m75110o().m75172d(new CampaignQuestConfigQueryTask());
                break;
            case "HiCloudSpaceUpgrade":
                C12515a.m75110o().m75172d(new HiCloudUpgradeConfigDownloadTask());
                break;
            case "HiCloudWebViewAllownlist":
                C12515a.m75110o().m75172d(new HiCloudWebViewConfigTask());
                break;
            case "HiCloudBackupBeforeNotice":
                C12515a.m75110o().m75172d(new BackupBeforeNoticeDownloadTask());
                break;
            case "HiCloudCampaignActivities":
                C12515a.m75110o().m75172d(new CampaignActivityConfigQueryTask());
                break;
            case "HiCloudHomepageSwitchNotice":
                C12515a.m75110o().m75172d(new HomepageSwitchConfigDownloadTask());
                break;
            case "HiCloudTextLink":
                C12515a.m75110o().m75172d(new TextLinkConfigQueryTask());
                break;
            default:
                NotifyLogger.m29914e(TAG, "invalid cmd = " + str);
                break;
        }
    }

    private void getConfigFromOMTwo(String str) {
        str.hashCode();
        switch (str) {
            case "HiCloudBackupSpaceInsuffNoticeV5":
                C12515a.m75110o().m75172d(new SpaceNoticeV5ConfigDownloadTask());
                break;
            case "HiCloudSpaceFrequencyControl":
                C12515a.m75110o().m75172d(new FrequencyControlConfigDownloadTask());
                break;
            case "HiCloudBackupSpaceInsuffNotice":
                C12515a.m75110o().m75172d(new SpaceNoticeV4ConfigDownloadTask());
                break;
            case "HiCloudMsgNoticeConfig":
                C12515a.m75110o().m75172d(new HiCloudMsgNoticeConfigDownloadTask());
                break;
            case "HiCloudSceneHomePageBanner":
                C12515a.m75110o().m75172d(new QueryHiCloudSceneHomePageBannerTask());
                break;
            case "HiCloudNPSConfig":
                InterfaceC11332j interfaceC11332j = this.configProxy;
                if (interfaceC11332j != null) {
                    interfaceC11332j.mo68085h();
                    break;
                }
                break;
            case "HiCloudSpaceNoticeConfigV3":
                C12515a.m75110o().m75172d(new SpaceNoticeV3ConfigDownloadTask());
                break;
            case "HiCloudSpacePositionMgr":
                C12515a.m75110o().m75172d(new QueryHiCloudSpacePositionMgrTask());
                break;
            case "HiCloudOperPageHints":
                InterfaceC11332j interfaceC11332j2 = this.configProxy;
                if (interfaceC11332j2 != null) {
                    interfaceC11332j2.mo68081d();
                    break;
                }
                break;
            case "HiCloudBrandHomePageBanner":
                C12515a.m75110o().m75172d(new QueryHiCloudBrandHomePageBannerTask());
                break;
            case "HiCloudSceneSpaceMgrBanner":
                C12515a.m75110o().m75172d(new QueryHiCloudSceneSpaceMgrBannerTask());
                break;
            case "HiCloudActivesH5":
                C12515a.m75110o().m75172d(new QueryHiCloudH5ConfigTask());
                break;
            case "HiCloudBrandBuyBanner":
                C12515a.m75110o().m75172d(new QueryHiCloudBrandBuyBannerTask());
                break;
            case "HiCloudSceneBuyBanner":
                C12515a.m75110o().m75172d(new QueryHiCloudSceneBuyBannerTask());
                break;
            default:
                getConfigFromOMThree(str);
                break;
        }
    }

    public static HiCloudAllOMConfigManager getInstance() {
        return HicloudConfigManagerHolder.INSTANCE;
    }

    public void addFlowControlOMConfig(String str) {
        NotifyLogger.m29915i(TAG, "addFlowControlOMConfig configPoint: " + str);
        C10028c.m62182c0().m62310c(str);
    }

    public void checkConfigUpdate(Context context, boolean z10, boolean z11) {
        NotifyLogger.m29915i(TAG, "checkConfigUpdate");
        if (context == null) {
            NotifyLogger.m29914e(TAG, "checkConfigUpdate context is null.");
            return;
        }
        if (!z11 || !z10) {
            NotifyLogger.m29914e(TAG, "checkConfigUpdate, term not agree or hicloud not login");
            return;
        }
        for (Map.Entry<String, AbstractC5012g> entry : forceClearConfigMap.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().isNeedUpdateConfig(key)) {
                NotifyLogger.m29915i(TAG, "clear download sp， config point: " + key);
                C11327e.m68059b(key);
            }
        }
    }

    public void downloadFlowControlOMConfig() {
        NotifyLogger.m29915i(TAG, "start downloadFlowControlOMConfig");
        Set<String> setM62200D0 = C10028c.m62182c0().m62200D0();
        if (setM62200D0.size() == 0) {
            return;
        }
        Iterator<String> it = setM62200D0.iterator();
        while (it.hasNext()) {
            queryConfigAsync(it.next());
        }
        C10028c.m62182c0().m62259P1();
    }

    public void downloadMultipleConfig(CountDownLatch countDownLatch, boolean z10) {
        if (!C13452e.m80781L().m80842P0()) {
            NotifyLogger.m29915i(TAG, "Account is not login.");
            return;
        }
        NotifyLogger.m29915i(TAG, "start downloadMultipleConfig");
        for (String str : updateConfigMap.keySet()) {
            if ("HiCloudNoticeConfigAllInOne".equals(str)) {
                queryConfigAsync(str, countDownLatch);
            } else if (z10 && needFilterMap.contains(str)) {
                NotifyLogger.m29915i(TAG, "jump config point is :" + str);
            } else {
                queryConfigAsync(str);
            }
        }
    }

    public void initConfigProxy(InterfaceC11332j interfaceC11332j) {
        this.configProxy = interfaceC11332j;
    }

    public void processRiskCfg() {
        InterfaceC11332j interfaceC11332j = this.configProxy;
        if (interfaceC11332j != null) {
            interfaceC11332j.mo68083f();
        }
    }

    public void queryConfigAsync(String str) {
        queryConfigAsync(str, null);
    }

    public void queryConfigSync(String str) {
        NotifyLogger.m29915i(TAG, "HiCloudAllOMConfigManager queryConfigSync cmd:" + str);
        try {
            if ("HiCloudMsgNoticeConfig".equals(str)) {
                HiCloudMsgNoticeConfigManager.getInstance().requestConfig();
            } else if ("HiCloudCampaignQuests".equals(str) || "HiCloudCampaignActivities".equals(str)) {
                C13821b.m82867w().m82874H();
                C13826g.m82950l().m82967r();
            }
        } catch (Exception e10) {
            NotifyLogger.m29915i(TAG, "HiCloudAllOMConfigManager queryConfigSync cmd:" + str);
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("config_point", str);
            linkedHashMap.put(TrackConstants$Events.EXCEPTION, String.valueOf(e10));
            C13227f.m79492i1().m79573U("key_om_error", linkedHashMap);
        }
    }

    public void updateConfig(Context context, boolean z10, boolean z11) {
        NotifyLogger.m29915i(TAG, "updateConfig");
        if (context == null) {
            NotifyLogger.m29914e(TAG, "updateConfig context is null.");
            return;
        }
        if (!z11 || !z10) {
            NotifyLogger.m29914e(TAG, "updateConfig, term not agree or hicloud not login");
            return;
        }
        if (!C0209d.m1333z1(context)) {
            NotifyLogger.m29916w(TAG, "updateConfig netWorkConnected is false.");
            return;
        }
        for (Map.Entry<String, AbstractC5012g> entry : updateConfigMap.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().isNeedUpdateConfig(key)) {
                queryConfigAsync(key);
            }
        }
        deleteOldBannerConfigJson();
    }

    public void queryConfigAsync(String str, CountDownLatch countDownLatch) {
        NotifyLogger.m29915i(TAG, "HiCloudAllOMConfigManager queryConfigAsync cmd:" + str);
        str.hashCode();
        switch (str) {
            case "HiCloudStaticPage":
                InterfaceC11332j interfaceC11332j = this.configProxy;
                if (interfaceC11332j != null) {
                    interfaceC11332j.mo68084g();
                    break;
                }
                break;
            case "HiCloudActives":
                InterfaceC11332j interfaceC11332j2 = this.configProxy;
                if (interfaceC11332j2 != null) {
                    interfaceC11332j2.mo68082e();
                    break;
                }
                break;
            case "HiCloudTrigger":
                InterfaceC11332j interfaceC11332j3 = this.configProxy;
                if (interfaceC11332j3 != null) {
                    interfaceC11332j3.mo68080c();
                    break;
                }
                break;
            case "HiCloudSpaceMultLanguage":
                SpaceMultLanguageManager.getInstance().processOMConfig();
                break;
            case "HiCloudFooterLink":
                InterfaceC11332j interfaceC11332j4 = this.configProxy;
                if (interfaceC11332j4 != null) {
                    interfaceC11332j4.mo68079b();
                    break;
                }
                break;
            case "HiCloudAppFiles":
                InterfaceC11332j interfaceC11332j5 = this.configProxy;
                if (interfaceC11332j5 != null) {
                    interfaceC11332j5.mo68078a();
                    break;
                }
                break;
            case "HiCloudPushGuide":
                C12515a.m75110o().m75172d(new HiCloudPushGuideTask());
                break;
            case "HiCloudSysParam":
                C9733f.m60705z().m60737c0();
                break;
            case "HiCloudNoticeConfigAllInOne":
                C12515a.m75110o().m75172d(new QueryOmNoticeConfigTask(countDownLatch));
                break;
            case "grays/functions":
                C9733f.m60705z().m60748i0(true);
                break;
            default:
                getConfigFromOMTwo(str);
                break;
        }
    }
}
