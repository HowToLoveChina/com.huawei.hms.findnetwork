package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import android.util.ArrayMap;
import ck.C1443a;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.ForceUpgradeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.ForcedUpgradeConfig;
import com.huawei.hicloud.notification.p106db.bean.HiCloudVerRange;
import com.huawei.hicloud.notification.p106db.languageoperator.HiCloudUpgradeNoticeLanguageOperator;
import com.huawei.hicloud.notification.task.HiCloudUpgradeConfigClearTask;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.service.C5001a0;
import fk.C9721b;
import gp.C10028c;
import hk.C10280c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p292fn.C9734g;
import p459lp.C11327e;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class HiCloudForceUpgradeConfigManager {
    private static final String TAG = "HiCloudForceUpgradeConfigManager";
    private static final List<String> instanceIds = new ArrayList();
    private ForceUpgradeConfiguration forceUpgradeConfig;
    private C5001a0 hiCloudSpaceUpgradeService = new C5001a0(null);
    private Map<Integer, ForceUpgradeConfiguration> forceUpgradeConfigFromServerCodeMap = new ArrayMap();

    public static class Holder {
        private static final HiCloudForceUpgradeConfigManager INSTANCE = new HiCloudForceUpgradeConfigManager();

        private Holder() {
        }
    }

    private void clearLanguage() throws SQLException {
        NotifyLogger.m29915i(TAG, "notificationList is null or empty");
        clearLanguageVersion();
        new HiCloudUpgradeNoticeLanguageOperator().clear();
    }

    private void clearLanguageVersion() {
        NotifyLogger.m29915i(TAG, "clear HiCloudBackupSpaceInsufficientNotice language");
        List<ForceUpgradeConfiguration> configList = getConfigList();
        if (configList == null) {
            NotifyLogger.m29916w(TAG, "configurations is null");
            return;
        }
        for (ForceUpgradeConfiguration forceUpgradeConfiguration : configList) {
            if (forceUpgradeConfiguration == null) {
                NotifyLogger.m29916w(TAG, "config is null");
            } else {
                C10028c.m62182c0().m62353l(forceUpgradeConfiguration.getId() + "_hicloud_upgrade_notice_version");
                C10028c.m62182c0().m62353l(forceUpgradeConfiguration.getId() + "_hicloud_upgrade_notice_download_result");
                C10028c.m62182c0().m62353l(forceUpgradeConfiguration.getId() + "_hicloud_upgrade_notice_hash");
            }
        }
    }

    private void downloadLanguage(String str, CommonLanguage commonLanguage) {
        if (commonLanguage == null) {
            NotifyLogger.m29916w(TAG, "configurationLanguage is nully");
        } else {
            instanceIds.add(str);
            new HiCloudUpgradeNoticeLangDownloader(str).extractCommonLanguage(commonLanguage);
        }
    }

    private void downloadLanguageForNotification(List<ForceUpgradeConfiguration> list) {
        for (ForceUpgradeConfiguration forceUpgradeConfiguration : list) {
            downloadLanguage(String.valueOf(forceUpgradeConfiguration.getId()), forceUpgradeConfiguration.getLanguage());
        }
    }

    private void executeRequestUpgradeConfig() {
        NotifyLogger.m29915i(TAG, "requestSpaceUsageUpgradeConfig");
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request notice config exception: " + e10);
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    extractLanguage();
                    return;
                } else if (this.hiCloudSpaceUpgradeService.isExceptionNeedRetry(e10) && i10 < 2) {
                    NotifyLogger.m29915i(TAG, "getLatestConfig exception retry, retry num: " + i10);
                } else {
                    if (e10.m60659c() != 400) {
                        return;
                    }
                    NotifyLogger.m29914e(TAG, "clear all Upgrade config");
                    clearAllConfig();
                }
            }
            if (this.hiCloudSpaceUpgradeService.getLatestConfig()) {
                C9734g.m60767a().m60769c("HiCloudSpaceUpgrade");
                NotifyLogger.m29915i(TAG, "request notice config success");
                extractLanguage();
                return;
            }
            NotifyLogger.m29914e(TAG, "query cloud notify config failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    private void extractLanguage() {
        List<ForceUpgradeConfiguration> configList = getConfigList();
        if (configList != null) {
            downloadLanguageForNotification(configList);
        }
    }

    private List<ForceUpgradeConfiguration> getConfigList() {
        ForcedUpgradeConfig hiCloudSpaceUpgradeLocal = getHiCloudSpaceUpgradeLocal();
        if (hiCloudSpaceUpgradeLocal == null) {
            NotifyLogger.m29916w(TAG, "noticeRoot is null");
            return null;
        }
        List<ForceUpgradeConfiguration> configurations = hiCloudSpaceUpgradeLocal.getConfigurations();
        if (configurations != null && !configurations.isEmpty()) {
            return configurations;
        }
        NotifyLogger.m29916w(TAG, "notificationList is null or empty");
        return null;
    }

    public static HiCloudForceUpgradeConfigManager getInstance() {
        return Holder.INSTANCE;
    }

    private boolean isCompriseErrorCode(ForceUpgradeConfiguration forceUpgradeConfiguration, int i10) {
        if (forceUpgradeConfiguration == null) {
            NotifyLogger.m29915i(TAG, "forceUpgradeConfiguration is null, not need end service");
            return false;
        }
        String serverErrorCode = forceUpgradeConfiguration.getServerErrorCode();
        if (TextUtils.isEmpty(serverErrorCode)) {
            NotifyLogger.m29915i(TAG, "serverErrorCode is null, not need end service");
        }
        String[] strArrSplit = serverErrorCode.split(",");
        if (strArrSplit.length == 0) {
            NotifyLogger.m29915i(TAG, "errors is empty, not need end service");
        }
        for (String str : strArrSplit) {
            if (i10 == C0241z.m1685c(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUserInRange(List<String> list) {
        if (C0209d.m1269j1()) {
            NotifyLogger.m29915i(TAG, "the device is honor product, not check user range");
            return false;
        }
        if (list.isEmpty()) {
            return true;
        }
        return RecommendCardManager.getInstance().isCurrentUserInUserGroupExtIds((String[]) list.toArray(new String[0]));
    }

    private boolean isValidityScopeDate(ForceUpgradeConfiguration forceUpgradeConfiguration) {
        if (C0209d.m1269j1()) {
            NotifyLogger.m29915i(TAG, "the device is honor product, not check date");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - C0241z.m1688f(forceUpgradeConfiguration.getPublishTime()) < 0) {
            NotifyLogger.m29915i(TAG, "current time not publish time");
            return false;
        }
        if (jCurrentTimeMillis - C0241z.m1688f(forceUpgradeConfiguration.getExpireTime()) <= 0) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "current time out of expire time");
        return false;
    }

    private boolean isVersionInterval(ForceUpgradeConfiguration forceUpgradeConfiguration) {
        if (C0209d.m1269j1()) {
            NotifyLogger.m29915i(TAG, "the device is honor product, not check version");
            return false;
        }
        HiCloudVerRange oldVerRange = forceUpgradeConfiguration.getOldVerRange();
        if (oldVerRange.getEndVer() == null && oldVerRange.getBeginVer() == null) {
            return true;
        }
        String str = C1443a.f6213a;
        if (C0241z.m1685c(str) > C0241z.m1685c(oldVerRange.getEndVer())) {
            NotifyLogger.m29915i(TAG, "current version > om configure");
            return false;
        }
        if (C0241z.m1685c(str) >= C0241z.m1685c(oldVerRange.getBeginVer())) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "current version < om configure");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getForceUpgradeConfigFromServerCode$1(int i10, ForceUpgradeConfiguration forceUpgradeConfiguration) {
        return isValidityScopeDate(forceUpgradeConfiguration) && isCompriseErrorCode(forceUpgradeConfiguration, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getUpgradeConfig$0(ForceUpgradeConfiguration forceUpgradeConfiguration) {
        return isUserInRange(forceUpgradeConfiguration.getUserGroupExtIDs()) && isValidityScopeDate(forceUpgradeConfiguration) && isVersionInterval(forceUpgradeConfiguration);
    }

    public void clearAllConfig() {
        NotifyLogger.m29915i(TAG, "clearAllConfig");
        C11327e.m68059b("HiCloudSpaceUpgrade");
        clearLanguage();
        clearConfigFile();
    }

    public void clearAllConfigInTask() {
        C12515a.m75110o().m75175e(new HiCloudUpgradeConfigClearTask(), true);
        NotificationReportUtil.reportSpaceNotifyClear(NotifyConstants.ClearSpaceFrequencyDBFrom.FROM_EXIT_ACCOUNT);
    }

    public void clearConfigFile() {
        boolean zDelete;
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                NotifyLogger.m29914e(TAG, "clearConfigFile context null");
                return;
            }
            File file = new File(contextM1377a.getFilesDir() + File.separator + "HiCloudSpaceUpgrade.json");
            if (file.exists() && !(zDelete = file.delete())) {
                NotifyLogger.m29914e(TAG, "deleteResult is:" + zDelete);
            }
            NotifyLogger.m29915i(TAG, "delete language result is:" + C10280c.m63454b(new File(HiCloudUpgradeNoticeLangDownloader.getV5LanguageDir())));
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clearConfigFile exception:" + e10);
        }
    }

    public void clearForceUpgradeConfig() {
        this.forceUpgradeConfig = null;
        Map<Integer, ForceUpgradeConfiguration> map = this.forceUpgradeConfigFromServerCodeMap;
        if (map != null) {
            map.clear();
        }
    }

    public ForcedUpgradeConfig getConfigRaw(String str) throws IOException {
        ForcedUpgradeConfig forcedUpgradeConfig;
        Exception e10;
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(C0213f.m1377a().getFilesDir() + File.separator + str));
            try {
                forcedUpgradeConfig = (ForcedUpgradeConfig) new Gson().fromJson(C0209d.m1290o2(fileInputStream), ForcedUpgradeConfig.class);
                try {
                    fileInputStream.close();
                } catch (Exception e11) {
                    e10 = e11;
                    NotifyLogger.m29914e(TAG, "cloud config file not exitst, msg:" + e10.getMessage());
                    return forcedUpgradeConfig;
                }
            } finally {
            }
        } catch (Exception e12) {
            forcedUpgradeConfig = null;
            e10 = e12;
        }
        return forcedUpgradeConfig;
    }

    public ForceUpgradeConfiguration getConformsConfig() {
        if (this.forceUpgradeConfig == null) {
            this.forceUpgradeConfig = getUpgradeConfig();
        }
        return this.forceUpgradeConfig;
    }

    public ForceUpgradeConfiguration getForceUpgradeConfigFromServerCode(final int i10) {
        List<ForceUpgradeConfiguration> configList = getConfigList();
        if (configList != null) {
            Optional<ForceUpgradeConfiguration> optionalMax = configList.stream().filter(new C4949a()).filter(new Predicate() { // from class: com.huawei.hicloud.notification.manager.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f22670a.lambda$getForceUpgradeConfigFromServerCode$1(i10, (ForceUpgradeConfiguration) obj);
                }
            }).max(Comparator.comparing(new C4951c()));
            if (optionalMax.isPresent()) {
                return optionalMax.get();
            }
        }
        return null;
    }

    public ForcedUpgradeConfig getHiCloudSpaceUpgradeLocal() {
        return getConfigRaw("HiCloudSpaceUpgrade.json");
    }

    public ForceUpgradeConfiguration getUpgradeConfig() {
        List<ForceUpgradeConfiguration> configList = getConfigList();
        if (configList != null) {
            Optional<ForceUpgradeConfiguration> optionalMax = configList.stream().filter(new C4949a()).filter(new Predicate() { // from class: com.huawei.hicloud.notification.manager.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f22672a.lambda$getUpgradeConfig$0((ForceUpgradeConfiguration) obj);
                }
            }).max(Comparator.comparing(new C4951c()));
            if (optionalMax.isPresent()) {
                return optionalMax.get();
            }
        }
        return null;
    }

    public boolean isValidityAppMarketVersion(int i10) {
        HiCloudVerRange newVerRange;
        if (C0209d.m1269j1()) {
            NotifyLogger.m29915i(TAG, "the device is honor product, not check versionCode");
            return false;
        }
        if (C10028c.m62182c0().m62274T() != 0) {
            NotifyLogger.m29915i(TAG, "server code need update grade in isValidityAppMarketVersion!");
            return true;
        }
        ForceUpgradeConfiguration conformsConfig = getConformsConfig();
        if (conformsConfig == null || (newVerRange = conformsConfig.getNewVerRange()) == null) {
            return true;
        }
        int iM1685c = C0241z.m1685c(newVerRange.getBeginVer());
        int iM1685c2 = C0241z.m1685c(newVerRange.getEndVer());
        if (newVerRange.getEndVer() == null) {
            if (newVerRange.getBeginVer() == null) {
                NotifyLogger.m29915i(TAG, "new ver range begin and end ver range end!");
                return true;
            }
            if (i10 >= iM1685c) {
                NotifyLogger.m29915i(TAG, "end ver range int null, beginVer <= versionCode");
                return true;
            }
        }
        return i10 >= iM1685c && i10 <= iM1685c2;
    }

    public boolean isValidityServerCode(int i10) {
        if (C0209d.m1269j1()) {
            NotifyLogger.m29915i(TAG, "the device is honor product, not check server code");
            return false;
        }
        NotifyLogger.m29915i(TAG, "check error code is need end service");
        return getConformsConfig(i10) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudSpaceUpgrade") >= r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager.TAG, "version updated, query config");
        executeRequestUpgradeConfig();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager.TAG, "version not updated, extract sync module config");
        extractLanguage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean requestConfig() {
        /*
            r7 = this;
            java.lang.String r0 = "request notice config version"
            java.lang.String r1 = "HiCloudForceUpgradeConfigManager"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r0 = 0
            r2 = r0
        L9:
            r3 = 2
            if (r2 > r3) goto L4a
            com.huawei.hicloud.service.a0 r4 = r7.hiCloudSpaceUpgradeService     // Catch: fk.C9721b -> L13
            long r2 = r4.getConfigVersion()     // Catch: fk.C9721b -> L13
            goto L4c
        L13:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "request notice config version exception: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r5)
            com.huawei.hicloud.service.a0 r5 = r7.hiCloudSpaceUpgradeService
            boolean r4 = r5.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L49
            if (r2 >= r3) goto L49
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r3)
            int r2 = r2 + 1
            goto L9
        L49:
            return r0
        L4a:
            r2 = 0
        L4c:
            java.lang.String r4 = "HiCloudSpaceUpgrade"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L60
            java.lang.String r0 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r7.executeRequestUpgradeConfig()
            r7 = 1
            return r7
        L60:
            java.lang.String r2 = "version not updated, extract sync module config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            r7.extractLanguage()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager.requestConfig():boolean");
    }

    public void saveForcedUpgradeConfig(ForcedUpgradeUtil.QueryUpdate queryUpdate) {
        if (C0209d.m1269j1()) {
            NotifyLogger.m29915i(TAG, "the device is honor product, not need save force config");
            return;
        }
        ForceUpgradeConfiguration conformsConfig = getConformsConfig();
        if (conformsConfig != null) {
            CloudSpaceNotifyUtil.getInstance().saveForcedUpgradeConfig(C0213f.m1377a(), conformsConfig.getForceUpgrade() == 1, queryUpdate);
        } else {
            NotifyLogger.m29915i(TAG, "forceUpgradeConfiguration is null, not need write force upgrade conf to sp files");
            C10028c.m62182c0().m62284V1(false, false);
        }
    }

    public void saveForcedUpgradeConfigFromServerCode(ForcedUpgradeUtil.QueryUpdate queryUpdate, int i10) {
        if (C0209d.m1269j1()) {
            NotifyLogger.m29915i(TAG, "the device is honor product, not need save force config");
            return;
        }
        ForceUpgradeConfiguration conformsConfig = getConformsConfig(i10);
        if (conformsConfig != null) {
            CloudSpaceNotifyUtil.getInstance().saveForcedUpgradeConfig(C0213f.m1377a(), conformsConfig.getForceUpgrade() == 1, queryUpdate);
        } else {
            NotifyLogger.m29915i(TAG, "forceUpgradeConfiguration is null, not need write force upgrade conf to sp files");
            C10028c.m62182c0().m62284V1(false, false);
        }
    }

    public ForceUpgradeConfiguration getConformsConfig(int i10) {
        NotifyLogger.m29915i(TAG, "start getConformsConfig for error code:" + i10);
        Map<Integer, ForceUpgradeConfiguration> map = this.forceUpgradeConfigFromServerCodeMap;
        if (map == null || !map.containsKey(Integer.valueOf(i10))) {
            NotifyLogger.m29915i(TAG, "local upgrade server config is null, need get new config");
            this.forceUpgradeConfigFromServerCodeMap.put(Integer.valueOf(i10), getForceUpgradeConfigFromServerCode(i10));
        }
        return this.forceUpgradeConfigFromServerCodeMap.get(Integer.valueOf(i10));
    }
}
