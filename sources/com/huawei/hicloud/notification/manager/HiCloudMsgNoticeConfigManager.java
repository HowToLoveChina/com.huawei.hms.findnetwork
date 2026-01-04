package com.huawei.hicloud.notification.manager;

import android.database.SQLException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.bean.HiCloudMsgNoticeAction;
import com.huawei.hicloud.notification.bean.HiCloudMsgNoticeBean;
import com.huawei.hicloud.notification.bean.HiCloudMsgNoticeRoot;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.languageoperator.HiCloudMsgNoticeLanguageOperator;
import com.huawei.hicloud.notification.task.BaseDownLoadFileTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5022p;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0234s;
import p292fn.C9734g;
import p616rk.C12515a;
import p783xp.C13843a;

/* loaded from: classes6.dex */
public class HiCloudMsgNoticeConfigManager {
    private static final String PICTURE_CACHE_FOLDER = "msgNoticePic";
    private static final String TAG = "HiCloudMsgNoticeConfigManager";
    private C5022p mConfigService;

    public static class Holder {
        private static HiCloudMsgNoticeConfigManager instance = new HiCloudMsgNoticeConfigManager();

        private Holder() {
        }
    }

    private void cachePictures() throws IOException {
        Map<String, CommonPicture> allPicturesObj = getAllPicturesObj();
        if (allPicturesObj.isEmpty()) {
            NotifyLogger.m29915i(TAG, "pictures is empty");
            return;
        }
        File[] fileArrListFiles = new File(getPictureCacheFolder()).listFiles();
        final HashSet<String> hashSet = new HashSet<>();
        allPicturesObj.values().stream().forEach(new Consumer() { // from class: com.huawei.hicloud.notification.manager.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f22673a.lambda$cachePictures$0(hashSet, (CommonPicture) obj);
            }
        });
        deleteNotUsedFiles(fileArrListFiles, hashSet);
    }

    private void clearLangVersionAndResult() {
        new HiCloudMsgNoticeLangDownloader().clearLangVersionAndResult();
    }

    private void clearLanguage() throws SQLException {
        HiCloudMsgNoticeLangDownloader hiCloudMsgNoticeLangDownloader = new HiCloudMsgNoticeLangDownloader();
        hiCloudMsgNoticeLangDownloader.clearLanguageDb();
        hiCloudMsgNoticeLangDownloader.clearLangVersionAndResult();
        hiCloudMsgNoticeLangDownloader.clearCurrentLanguageDownloadResult();
        hiCloudMsgNoticeLangDownloader.deleteLanguageFile();
    }

    private void deleteCachedPictures() {
        NotifyLogger.m29915i(TAG, "delete cached pictures");
        C13843a.m83085g(getPictureCacheFolder());
    }

    private void deleteConfigFile() {
        File file = new File(this.mConfigService.getConfigFilePath());
        if (!file.exists() || file.delete()) {
            return;
        }
        NotifyLogger.m29914e(TAG, "delete config file failed.");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020 A[Catch: SecurityException -> 0x0024, IOException -> 0x003d, TRY_LEAVE, TryCatch #2 {IOException -> 0x003d, SecurityException -> 0x0024, blocks: (B:10:0x0010, B:12:0x0016, B:14:0x0020), top: B:20:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void deleteNotUsedFiles(java.io.File[] r6, java.util.HashSet<java.lang.String> r7) {
        /*
            r5 = this;
            if (r6 == 0) goto L45
            int r5 = r6.length
            if (r5 != 0) goto L6
            goto L45
        L6:
            int r5 = r6.length
            r0 = 0
        L8:
            if (r0 >= r5) goto L45
            r1 = r6[r0]
            java.lang.String r2 = "HiCloudMsgNoticeConfigManager"
            if (r7 == 0) goto L20
            boolean r3 = r7.isEmpty()     // Catch: java.lang.SecurityException -> L24 java.io.IOException -> L3d
            if (r3 != 0) goto L20
            java.lang.String r3 = r1.getCanonicalPath()     // Catch: java.lang.SecurityException -> L24 java.io.IOException -> L3d
            boolean r3 = r7.contains(r3)     // Catch: java.lang.SecurityException -> L24 java.io.IOException -> L3d
            if (r3 != 0) goto L42
        L20:
            r1.delete()     // Catch: java.lang.SecurityException -> L24 java.io.IOException -> L3d
            goto L42
        L24:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "pictureFile can not be delete! picturePath:"
            r3.append(r4)
            java.lang.String r1 = r1.getPath()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r2, r1)
            goto L42
        L3d:
            java.lang.String r1 = "Invalid picture file path!"
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r2, r1)
        L42:
            int r0 = r0 + 1
            goto L8
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.HiCloudMsgNoticeConfigManager.deleteNotUsedFiles(java.io.File[], java.util.HashSet):void");
    }

    private void executeRequestSpaceConfig() throws IOException {
        NotifyLogger.m29915i(TAG, "requestSpaceUsageNoticeConfig");
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request notice config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudMsgNoticeConfig")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    extractLanguage();
                    cachePictures();
                    return;
                } else {
                    if (!this.mConfigService.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (this.mConfigService.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "request notice config success");
                C9734g.m60767a().m60769c("HiCloudMsgNoticeConfig");
                clearLangVersionAndResult();
                extractLanguage();
                cachePictures();
                return;
            }
            NotifyLogger.m29914e(TAG, "query cloud notify config failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    private void extractLanguage() throws IOException {
        NotifyLogger.m29915i(TAG, "begin extractLanguage");
        HiCloudMsgNoticeRoot configFromFile = getConfigFromFile();
        if (configFromFile != null) {
            new HiCloudMsgNoticeLangDownloader().extractCommonLanguage(configFromFile.getCommonLanguage());
        }
    }

    private Map<String, CommonPicture> getAllPicturesObj() throws IOException {
        Map<String, CommonPicture> resourceMap;
        HiCloudMsgNoticeBean[] configBean;
        CommonPicture commonPicture;
        HashMap map = new HashMap();
        HiCloudMsgNoticeRoot configFromFile = getConfigFromFile();
        if (configFromFile != null && (resourceMap = configFromFile.getResourceMap()) != null && !resourceMap.isEmpty() && (configBean = configFromFile.getConfigBean()) != null && configBean.length != 0) {
            for (HiCloudMsgNoticeBean hiCloudMsgNoticeBean : configBean) {
                HiCloudMsgNoticeAction[] actionList = hiCloudMsgNoticeBean.getActionList();
                if (actionList != null && actionList.length != 0) {
                    for (HiCloudMsgNoticeAction hiCloudMsgNoticeAction : actionList) {
                        if (hiCloudMsgNoticeAction != null) {
                            String picture = hiCloudMsgNoticeAction.getPicture();
                            if (!TextUtils.isEmpty(picture) && (commonPicture = resourceMap.get(picture)) != null) {
                                map.put(commonPicture.getUrl(), commonPicture);
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    public static HiCloudMsgNoticeConfigManager getInstance() {
        return Holder.instance;
    }

    private List<CommonLanguageDbString> getLanguageStringFromDb(String str, String str2, String str3) {
        return new HiCloudMsgNoticeLanguageOperator().queryString(str, str2, HNConstants.Language.EN_STANDARD, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cachePictures$0(HashSet hashSet, CommonPicture commonPicture) {
        if (commonPicture == null || !commonPicture.isValid()) {
            NotifyLogger.m29915i(TAG, "picture is invalid");
        } else {
            if (pictureCacheExisted(commonPicture)) {
                hashSet.add(getPicturePath(commonPicture.getUrl()));
                return;
            }
            String url = commonPicture.getUrl();
            C12515a.m75110o().m75175e(new BaseDownLoadFileTask(url, getPicturePath(url), commonPicture.getHash(), null), false);
        }
    }

    private boolean pictureCacheExisted(CommonPicture commonPicture) throws Throwable {
        String strM1591d;
        String url = commonPicture.getUrl();
        String hash = commonPicture.getHash();
        try {
            strM1591d = C0227m.m1591d(getPicturePath(url));
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "getFileSha256 exception: " + e10.toString());
            strM1591d = null;
        }
        return !TextUtils.isEmpty(strM1591d) && TextUtils.equals(hash, strM1591d);
    }

    public void clearAll() throws SQLException {
        NotifyLogger.m29915i(TAG, "clear all files");
        clearLanguage();
        deleteCachedPictures();
        deleteConfigFile();
    }

    public HiCloudMsgNoticeAction getActionById(String str) throws IOException {
        HiCloudMsgNoticeBean[] configBean;
        NotifyLogger.m29915i(TAG, "getActionById id" + str);
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e(TAG, "getActionById but id is empty");
            return null;
        }
        HiCloudMsgNoticeRoot configFromFile = getInstance().getConfigFromFile();
        if (configFromFile != null && (configBean = configFromFile.getConfigBean()) != null && configBean.length != 0) {
            for (HiCloudMsgNoticeBean hiCloudMsgNoticeBean : configBean) {
                HiCloudMsgNoticeAction[] actionList = hiCloudMsgNoticeBean.getActionList();
                if (actionList != null && actionList.length != 0) {
                    for (HiCloudMsgNoticeAction hiCloudMsgNoticeAction : actionList) {
                        String id2 = hiCloudMsgNoticeAction.getId();
                        if (id2 != null && id2.equals(str)) {
                            return hiCloudMsgNoticeAction;
                        }
                    }
                }
            }
        }
        return null;
    }

    public HiCloudMsgNoticeRoot getConfigFromFile() throws IOException {
        HiCloudMsgNoticeRoot hiCloudMsgNoticeRoot;
        Exception e10;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(this.mConfigService.getConfigFilePath()));
        } catch (Exception e11) {
            hiCloudMsgNoticeRoot = null;
            e10 = e11;
        }
        try {
            hiCloudMsgNoticeRoot = (HiCloudMsgNoticeRoot) new Gson().fromJson(C0209d.m1290o2(fileInputStream), HiCloudMsgNoticeRoot.class);
            try {
                fileInputStream.close();
            } catch (Exception e12) {
                e10 = e12;
                NotifyLogger.m29914e(TAG, "config file not exitst, msg:" + e10.getMessage());
                return hiCloudMsgNoticeRoot;
            }
            return hiCloudMsgNoticeRoot;
        } finally {
        }
    }

    public String getPictureCacheFolder() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C0213f.m1378b().getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append(PICTURE_CACHE_FOLDER);
        sb2.append(str);
        return sb2.toString();
    }

    public String getPicturePath(String str) {
        return getPictureCacheFolder() + C0227m.m1593f(str);
    }

    public String getStringFromDB(String str) {
        return NotifyUtil.getStringFromConfig(str, true, true, getLanguageStringFromDb(C0234s.m1631i(), HNUtil.getCurrentBaseLanguage(), str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudMsgNoticeConfig") >= r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.HiCloudMsgNoticeConfigManager.TAG, "version updated, query config");
        executeRequestSpaceConfig();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.HiCloudMsgNoticeConfigManager.TAG, "version not updated, extract sync module config");
        extractLanguage();
        cachePictures();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
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
            java.lang.String r1 = "HiCloudMsgNoticeConfigManager"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r0 = 0
            r2 = r0
        L9:
            r3 = 2
            if (r2 > r3) goto L4e
            com.huawei.hicloud.service.p r4 = r7.mConfigService     // Catch: fk.C9721b -> L13
            long r2 = r4.getConfigVersion()     // Catch: fk.C9721b -> L13
            goto L50
        L13:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "request notice config version exception: "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r5)
            com.huawei.hicloud.service.p r5 = r7.mConfigService
            boolean r4 = r5.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L4d
            if (r2 >= r3) goto L4d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r3)
            int r2 = r2 + 1
            goto L9
        L4d:
            return r0
        L4e:
            r2 = 0
        L50:
            java.lang.String r4 = "HiCloudMsgNoticeConfig"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L64
            java.lang.String r0 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r7.executeRequestSpaceConfig()
            r7 = 1
            return r7
        L64:
            java.lang.String r2 = "version not updated, extract sync module config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            r7.extractLanguage()
            r7.cachePictures()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.HiCloudMsgNoticeConfigManager.requestConfig():boolean");
    }

    private HiCloudMsgNoticeConfigManager() {
        this.mConfigService = null;
        this.mConfigService = new C5022p(null);
    }
}
