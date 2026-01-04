package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.bean.H5ConfigBean;
import com.huawei.hicloud.notification.p106db.bean.H5ConfigPicture;
import com.huawei.hicloud.notification.p106db.bean.H5Resource;
import com.huawei.hicloud.notification.p106db.bean.HicloudH5Incentive;
import com.huawei.hicloud.notification.p106db.bean.IncentiveActivity;
import com.huawei.hicloud.notification.p106db.operator.H5ConfigOperator;
import com.huawei.hicloud.notification.p106db.operator.H5LanguageConfigOperator;
import com.huawei.hicloud.notification.task.QueryHiCloudBannerPicturesTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0234s;
import p459lp.C11327e;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class HicloudH5ConfigManager {
    private static final String BUY_PICTURE_PATH = "buy";
    private static final String HICLOUDACTIVES_URL_PATH_SP = "hicloud_actives_path_url_pair";
    private static final String HICLOUDH5_PICTURE_PATH = "/hicloudh5pictures";
    public static final String KEY_HASH = "hash";
    public static final String KEY_RESOLUTION = "resolution";
    public static final String KEY_URL = "url";
    private static final int MAX_FAIL_RETRY = 2;
    private static final int PICTURE_NAME_RANDOM_RANGE = 10000;
    public static final String RECOMMEND_DETAIL_LINK1 = "recommend_detail_link1";
    private static final String TAG = "HicloudH5ConfigManager";
    public static final String TASK_CENTER = "taskCenter";
    public static final String UPDATE_PICTURE_FIRST = "updatePictureFirst";
    public static final String UPDATE_PICTURE_SECOND = "updatePictureSecond";
    private HicloudH5Incentive mHicloudH5Incentive;
    private HiCloudH5ConfigService hiCloudH5ConfigService = new HiCloudH5ConfigService(null);
    private Random mPictureNameRand = new Random();
    private boolean isExtractingV3Language = false;
    private final Lock lock = new ReentrantLock();

    public static class Holder {
        private static final HicloudH5ConfigManager INSTANCE = new HicloudH5ConfigManager();

        private Holder() {
        }
    }

    private void clearDb() throws SQLException {
        new H5ConfigOperator().clear();
    }

    private void deleteFiles(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.isDirectory() && !file2.delete()) {
                NotifyLogger.m29914e(TAG, "del file failed, file name is " + file2.getPath());
            }
        }
    }

    private void downloadH5picture(H5ConfigPicture h5ConfigPicture) {
        if (h5ConfigPicture == null) {
            return;
        }
        String url = h5ConfigPicture.getUrl();
        String hash = h5ConfigPicture.getHash();
        if (isLocalFileExist(url)) {
            NotifyLogger.m29915i(TAG, "already download: " + h5ConfigPicture.getUrl());
            return;
        }
        String str = C0213f.m1377a().getFilesDir() + HICLOUDH5_PICTURE_PATH + "/" + (C0227m.m1593f(url) + "" + this.mPictureNameRand.nextInt(10000) + "" + System.currentTimeMillis());
        C4896a c4896a = new C4896a(url, str, 0L);
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                NotifyUtil.downloadFileToPath(str, c4896a.getUrl(), c4896a);
                File file = new File(str);
                if (!file.exists()) {
                    NotifyLogger.m29914e(TAG, "downloadH5picture icon failed");
                } else if (TextUtils.isEmpty(hash) || hash.equals(generateFileHash(str))) {
                    NotifyLogger.m29915i(TAG, "downloadH5picture icon success");
                    saveDownloadPictue(url, str);
                    return;
                } else if (file.delete()) {
                    NotifyLogger.m29914e(TAG, "picture hash not equals, delete file successed");
                }
            } catch (Exception e10) {
                NotifyLogger.m29914e(TAG, "downloadH5picture download icon failed:" + e10.toString());
            }
        }
    }

    private void extractConfig() throws InterruptedException {
        HicloudH5Incentive configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "getConfigFromFile null");
            return;
        }
        this.mHicloudH5Incentive = configFromFile;
        IncentiveActivity incentiveActivitie = configFromFile.getIncentiveActivitie();
        if (incentiveActivitie == null) {
            return;
        }
        H5ConfigOperator h5ConfigOperator = new H5ConfigOperator();
        for (H5Resource h5Resource : incentiveActivitie.getResources()) {
            NotifyLogger.m29915i(TAG, "extracting config: " + h5Resource.getResourceId());
            ArrayList arrayList = new ArrayList();
            String resourceId = h5Resource.getResourceId();
            H5ConfigPicture taskCenter = h5Resource.getTaskCenter();
            downloadH5picture(taskCenter);
            arrayList.addAll(getConfigBeans(resourceId, TASK_CENTER, taskCenter));
            CommonPicture[] homePagePictureSecond = h5Resource.getHomePagePictureSecond();
            if (homePagePictureSecond != null) {
                C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(homePagePictureSecond), false);
            }
            CommonPicture updatePictureFirst = h5Resource.getUpdatePictureFirst();
            if (updatePictureFirst != null) {
                RecommendCardManager.getInstance().downloadPicture(updatePictureFirst);
            }
            CommonPicture updatePictureSecond = h5Resource.getUpdatePictureSecond();
            if (updatePictureSecond != null) {
                RecommendCardManager.getInstance().downloadPicture(updatePictureSecond);
            }
            CommonPicture[] homePagePicture = h5Resource.getHomePagePicture();
            if (homePagePicture != null) {
                C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(homePagePicture), false);
            }
            for (Map.Entry<String, String> entry : h5Resource.getNoticeText().entrySet()) {
                String key = entry.getKey();
                H5ConfigBean h5ConfigBean = new H5ConfigBean();
                h5ConfigBean.setKey(key);
                h5ConfigBean.setResourceId(resourceId);
                h5ConfigBean.setValue(entry.getValue());
                arrayList.add(h5ConfigBean);
            }
            h5ConfigOperator.saveConfigs(arrayList);
        }
        new H5ConfigLangDownloader().extractCommonLanguage(incentiveActivitie.getLanguage());
        saveClientVesion(incentiveActivitie.getClientVersion());
        NotifyLogger.m29915i(TAG, "extractConfig end");
    }

    private void extractLanguageConfig() throws InterruptedException {
        HicloudH5Incentive configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "getConfigFromFile null");
            return;
        }
        IncentiveActivity incentiveActivitie = configFromFile.getIncentiveActivitie();
        if (incentiveActivitie == null) {
            return;
        }
        new H5ConfigLangDownloader().extractCommonLanguage(incentiveActivitie.getLanguage());
        for (H5Resource h5Resource : incentiveActivitie.getResources()) {
            if (h5Resource != null) {
                CommonPicture[] homePagePictureSecond = h5Resource.getHomePagePictureSecond();
                if (homePagePictureSecond != null) {
                    C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(homePagePictureSecond), false);
                }
                CommonPicture updatePictureFirst = h5Resource.getUpdatePictureFirst();
                if (updatePictureFirst != null) {
                    RecommendCardManager.getInstance().downloadPicture(updatePictureFirst);
                }
                CommonPicture updatePictureSecond = h5Resource.getUpdatePictureSecond();
                if (updatePictureSecond != null) {
                    RecommendCardManager.getInstance().downloadPicture(updatePictureSecond);
                }
                CommonPicture[] homePagePicture = h5Resource.getHomePagePicture();
                if (homePagePicture != null) {
                    C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(homePagePicture), false);
                }
            }
        }
    }

    private String generateFileHash(String str) {
        try {
            return C0227m.m1591d(str);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "generateFileHash exceptions:" + e10.toString());
            return "";
        }
    }

    private List<H5ConfigBean> getConfigBeans(String str, String str2, H5ConfigPicture h5ConfigPicture) {
        ArrayList arrayList = new ArrayList();
        if (h5ConfigPicture == null) {
            return arrayList;
        }
        H5ConfigBean h5ConfigBean = new H5ConfigBean();
        h5ConfigBean.setResourceId(str);
        h5ConfigBean.setKey(str2 + "url");
        h5ConfigBean.setValue(h5ConfigPicture.getUrl());
        H5ConfigBean h5ConfigBean2 = new H5ConfigBean();
        h5ConfigBean2.setResourceId(str);
        h5ConfigBean2.setKey(str2 + KEY_HASH);
        h5ConfigBean2.setValue(h5ConfigPicture.getHash());
        H5ConfigBean h5ConfigBean3 = new H5ConfigBean();
        h5ConfigBean3.setResourceId(str);
        h5ConfigBean3.setKey(str2 + "resolution");
        h5ConfigBean3.setValue(h5ConfigPicture.getResolution());
        arrayList.add(h5ConfigBean);
        arrayList.add(h5ConfigBean2);
        arrayList.add(h5ConfigBean3);
        return arrayList;
    }

    public static HicloudH5ConfigManager getInstance() {
        return Holder.INSTANCE;
    }

    private boolean isLocalFileExist(String str) {
        String strM1363m = C0212e0.m1363m(C0213f.m1377a(), HICLOUDACTIVES_URL_PATH_SP, C0227m.m1593f(str), null);
        if (TextUtils.isEmpty(strM1363m)) {
            NotifyLogger.m29914e(TAG, " SP record not exist, url = " + str);
            return false;
        }
        if (new File(strM1363m).exists()) {
            return true;
        }
        NotifyLogger.m29914e(TAG, "local file do not exist, SP record exist, url = " + str + " file path = " + strM1363m);
        C0212e0.m1374x(C0213f.m1377a(), HICLOUDACTIVES_URL_PATH_SP, C0227m.m1593f(str));
        return false;
    }

    private void requestConfig() throws InterruptedException, SQLException {
        NotifyLogger.m29915i(TAG, "request H5 Config");
        if (this.hiCloudH5ConfigService == null) {
            this.hiCloudH5ConfigService = new HiCloudH5ConfigService(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request h5 config exception: " + e10.toString());
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    extractLanguageConfig();
                    return;
                } else {
                    if (!this.hiCloudH5ConfigService.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (this.hiCloudH5ConfigService.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "request h5 config success");
                clearDb();
                extractConfig();
                return;
            }
            NotifyLogger.m29914e(TAG, "query cloud h5 config failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    private void saveClientVesion(long j10) {
        NotifyLogger.m29915i(TAG, "saveClientVesion: " + j10);
        C0212e0.m1371u(C0213f.m1377a(), "config_service_download_sp", "h5_config_tag", j10);
    }

    private void saveDownloadPictue(String str, String str2) {
        SharedPreferences.Editor editorEdit = C0213f.m1377a().getSharedPreferences(HICLOUDACTIVES_URL_PATH_SP, 0).edit();
        editorEdit.putString(C0227m.m1593f(str), str2);
        editorEdit.commit();
    }

    public void checkH5ClientVersion(long j10) {
        if (j10 <= getClientVersion()) {
            NotifyLogger.m29915i(TAG, "clientVersion not changed");
            return;
        }
        this.lock.lock();
        try {
            NotifyLogger.m29915i(TAG, "clientVersion changed");
            requestVersion();
        } finally {
            this.lock.unlock();
        }
    }

    public void checkResource(H5Resource h5Resource) throws InterruptedException {
        if (h5Resource == null) {
            NotifyLogger.m29914e(TAG, "null resource: ");
            return;
        }
        H5ConfigPicture taskCenter = h5Resource.getTaskCenter();
        CommonPicture updatePictureFirst = h5Resource.getUpdatePictureFirst();
        CommonPicture updatePictureSecond = h5Resource.getUpdatePictureSecond();
        String resourceId = h5Resource.getResourceId();
        if (updatePictureFirst != null && updatePictureSecond != null) {
            if (TextUtils.isEmpty(getInstance().getPicturePath("buy", resourceId, true))) {
                RecommendCardManager.getInstance().downloadPicture(updatePictureSecond);
            }
            if (TextUtils.isEmpty(getInstance().getPicturePath("buy", resourceId, false))) {
                RecommendCardManager.getInstance().downloadPicture(updatePictureFirst);
            }
        }
        CommonPicture[] homePagePicture = h5Resource.getHomePagePicture();
        if (homePagePicture != null) {
            String picturePath = getInstance().getPicturePath(RecommendCardConstants.Entrance.HOMEPAGE, resourceId, true);
            String picturePath2 = getInstance().getPicturePath(RecommendCardConstants.Entrance.HOMEPAGE, resourceId, false);
            if (TextUtils.isEmpty(picturePath) || TextUtils.isEmpty(picturePath2)) {
                C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(homePagePicture), false);
            }
        }
        ArrayList<H5ConfigPicture> arrayList = new ArrayList();
        arrayList.add(taskCenter);
        for (H5ConfigPicture h5ConfigPicture : arrayList) {
            if (h5ConfigPicture != null) {
                if (isLocalFileExist(h5ConfigPicture.getUrl())) {
                    NotifyLogger.m29915i(TAG, "already download: " + h5ConfigPicture.getUrl());
                } else {
                    NotifyLogger.m29914e(TAG, "need redownload: " + h5ConfigPicture.getUrl());
                    downloadH5picture(h5ConfigPicture);
                }
            }
        }
    }

    public void clear() throws SQLException {
        NotifyLogger.m29915i(TAG, "HiCloudH5Incentive clear()");
        Context contextM1378b = C0213f.m1378b();
        new H5ConfigOperator().clear();
        new H5LanguageConfigOperator().clear();
        boolean zDelete = new File(contextM1378b.getFilesDir() + File.separator + "HiCloudH5Incentive.json").delete();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("deleteResult:");
        sb2.append(zDelete);
        NotifyLogger.m29915i(TAG, sb2.toString());
        deleteFiles(new File(C0213f.m1377a().getFilesDir() + HICLOUDH5_PICTURE_PATH));
    }

    public long getClientVersion() {
        return C0212e0.m1360j(C0213f.m1377a(), "config_service_download_sp", "h5_config_tag", 0L);
    }

    public HicloudH5Incentive getConfigFromFile() {
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        File file = new File(C0213f.m1378b().getFilesDir() + File.separator + "HiCloudH5Incentive.json");
        HicloudH5Incentive hicloudH5Incentive = null;
        if (!file.exists()) {
            NotifyLogger.m29915i(TAG, "config file not existed");
            return null;
        }
        try {
            hicloudH5Incentive = (HicloudH5Incentive) new Gson().fromJson(C0209d.m1290o2(new FileInputStream(file)), HicloudH5Incentive.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getConfigFromFile exception: " + e10.toString());
        }
        NotifyLogger.m29915i(TAG, "hicloudH5Incentive: " + new Gson().toJson(hicloudH5Incentive));
        return hicloudH5Incentive;
    }

    public String getConfigValue(String str, String str2, String str3) throws Throwable {
        H5ConfigBean h5ConfigBeanQueryH5Config = new H5ConfigOperator().queryH5Config(str, str2 + str3);
        if (h5ConfigBeanQueryH5Config == null) {
            return null;
        }
        return h5ConfigBeanQueryH5Config.getValue();
    }

    public H5Resource getH5ResourceById(String str) {
        NotifyLogger.m29915i(TAG, "getH5ResourceById");
        H5Resource h5Resource = null;
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e(TAG, "getH5ResourceById error , resId is null");
            return null;
        }
        if (this.mHicloudH5Incentive == null) {
            HicloudH5Incentive configFromFile = getConfigFromFile();
            this.mHicloudH5Incentive = configFromFile;
            if (configFromFile == null) {
                NotifyLogger.m29914e(TAG, "getH5ResourceById error , hicloudH5Incentive is null");
                return null;
            }
        }
        IncentiveActivity incentiveActivitie = this.mHicloudH5Incentive.getIncentiveActivitie();
        if (incentiveActivitie == null) {
            NotifyLogger.m29914e(TAG, "getH5ResourceById error , incentiveActivity is null");
            return null;
        }
        List<H5Resource> resources = incentiveActivitie.getResources();
        if (resources == null || resources.size() <= 0) {
            NotifyLogger.m29914e(TAG, "getH5ResourceById error , resourceList is null or size <=0");
            return null;
        }
        for (H5Resource h5Resource2 : resources) {
            if (h5Resource2 != null && str.equals(h5Resource2.getResourceId())) {
                h5Resource = h5Resource2;
            }
        }
        return h5Resource;
    }

    public HicloudH5Incentive getHicloudH5Incentive() {
        return this.mHicloudH5Incentive;
    }

    public String getNoticeTextFromConfig(String str, String str2) throws Throwable {
        H5ConfigBean h5ConfigBeanQueryH5Config = new H5ConfigOperator().queryH5Config(str, str2);
        if (h5ConfigBeanQueryH5Config == null) {
            return null;
        }
        String value = h5ConfigBeanQueryH5Config.getValue();
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        return NotifyUtil.getStringFromConfig(value, true, new H5LanguageConfigOperator().queryString(C0234s.m1631i(), HNUtil.getCurrentBaseLanguage(), HNConstants.Language.EN_STANDARD, value));
    }

    public String getPicturePath(String str, String str2, boolean z10) {
        H5Resource h5ResourceById;
        if (!RecommendCardManager.getInstance().checkEntrance(str) || (h5ResourceById = getH5ResourceById(str2)) == null) {
            return "";
        }
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            return RecommendCardManager.getInstance().getPicturePath(h5ResourceById.getHomePagePicture(), z10);
        }
        if (str.equals("buy")) {
            CommonPicture updatePictureFirst = h5ResourceById.getUpdatePictureFirst();
            CommonPicture updatePictureSecond = h5ResourceById.getUpdatePictureSecond();
            if (updatePictureFirst != null && updatePictureSecond != null) {
                return RecommendCardManager.getInstance().getPicturePath(new CommonPicture[]{updatePictureFirst, updatePictureSecond}, z10);
            }
        }
        return "";
    }

    public String getTaskCenterUrl(String str) throws Throwable {
        H5ConfigBean h5ConfigBeanQueryH5Config = new H5ConfigOperator().queryH5Config(str, "taskCenterurl");
        if (h5ConfigBeanQueryH5Config == null) {
            return null;
        }
        return h5ConfigBeanQueryH5Config.getValue();
    }

    public String getTextFromConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return NotifyUtil.getStringFromConfig(str, true, new H5LanguageConfigOperator().queryString(C0234s.m1631i(), HNUtil.getCurrentBaseLanguage(), HNConstants.Language.EN_STANDARD, str));
    }

    public boolean isExtractingV3Language() {
        return this.isExtractingV3Language;
    }

    public boolean isHasResourceId(String str) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29916w(TAG, "isHasResourceId source is null or emptry.");
            return false;
        }
        HicloudH5Incentive configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29916w(TAG, "isHasResourceId hicloudH5Incentive is null or emptry.");
            return false;
        }
        List<H5Resource> resources = configFromFile.getIncentiveActivitie().getResources();
        if (resources == null || resources.isEmpty()) {
            NotifyLogger.m29916w(TAG, "isHasResourceId h5ResourceList is null or emptry.");
            return false;
        }
        Iterator<H5Resource> it = resources.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next().getResourceId())) {
                return true;
            }
        }
        return false;
    }

    public boolean requestVersion() {
        NotifyLogger.m29915i(TAG, "request hicloud h5 config version");
        if (this.hiCloudH5ConfigService == null) {
            this.hiCloudH5ConfigService = new HiCloudH5ConfigService(null);
        }
        long configVersion = 0;
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
                configVersion = this.hiCloudH5ConfigService.getConfigVersion();
                NotifyLogger.m29913d(TAG, "hicloud h5 latestVersion:" + configVersion);
                break;
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request hicloud h5 config version exception: " + e10.toString());
                if (!this.hiCloudH5ConfigService.isExceptionNeedRetry(e10) || i10 >= 2) {
                    return false;
                }
                NotifyLogger.m29915i(TAG, "hicloud h5 config requestVersion exception retry, retry num: " + i10);
            }
        }
        long jM68063f = C11327e.m68063f("HiCloudActivesH5");
        this.lock.lock();
        try {
            if (jM68063f >= configVersion) {
                NotifyLogger.m29915i(TAG, "version not updated, extract h5 config");
                extractLanguageConfig();
                return false;
            }
            NotifyLogger.m29915i(TAG, "version updated, query h5 config");
            requestConfig();
            this.lock.unlock();
            return true;
        } finally {
            this.lock.unlock();
        }
    }

    public void setExtractingV3Language(boolean z10) {
        this.isExtractingV3Language = z10;
    }

    public String getPicturePath(String str) {
        H5Resource h5ResourceById = getH5ResourceById(str);
        if (h5ResourceById == null) {
            return "";
        }
        return RecommendCardManager.getInstance().getPicturePath(h5ResourceById.getHomePagePictureSecond());
    }
}
