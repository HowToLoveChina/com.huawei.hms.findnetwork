package com.huawei.android.hicloud.cloudbackup.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.BackupOptionSize;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.OMFilterModule;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class RuleConfig {
    public static final int ALL_SCENES_RED_DOT = -1;
    public static final int CLOSE_SWITCH_DELETE_SUPPORT = 1;
    public static final int CLOSE_SWITCH_DELETE_UN_SUPPORT = 0;
    public static final int DEFAULT_APP_FILE_ID_MAX_CNT = 0;
    public static final int DEFAULT_BACKUP_CYCLE = 7;
    public static final long DEFAULT_BACKUP_DELAY_ON_SCREEN = 300000;
    public static final int DEFAULT_BACKUP_FREQUENCY_ON_DEVICE_IDLE = 0;
    public static final int DEFAULT_BACKUP_MODULES_CACHE_NUM = 2;
    public static final long DEFAULT_BACKUP_RESTORE_TAR_COUNT = 6000;
    public static final long DEFAULT_BACKUP_START_INTERVAL = 120;
    public static final int DEFAULT_BACKUP_START_RETRY_TIMES = 5;
    public static final int DEFAULT_BACKUP_THREAD_SIZE = 6;
    public static final int DEFAULT_BATCHRMNUM = 50;
    public static final int DEFAULT_BM_BASE_DATA_BACKUP_CYCLE = 7;
    public static final int DEFAULT_CACHE_DURATION = 2;
    private static final int DEFAULT_CHECK_INTERVAL_MAX = 30;
    public static final int DEFAULT_CLIENT_SIZE_CACHE = 48;
    public static final int DEFAULT_CLOUDBACKUP_CLONE_TIMEOUT_DURATION = 15;
    public static final long DEFAULT_CLOUD_SPACE_SKIP_THRESHOLD = 0;
    public static final long DEFAULT_CLOUD_SPACE_THRESHOLD = -1;
    private static final int DEFAULT_CREATE_V1 = 1;
    public static final int DEFAULT_DATA_ACPT_ERR_NUM = 0;
    public static final int DEFAULT_DATA_ACPT_ERR_RATE = 0;
    public static final int DEFAULT_DATA_CACHE_DURATION = 0;
    public static final int DEFAULT_DB_DIFF_MAX_FILE_SIZE = 20480;
    public static final int DEFAULT_DB_INCR_BACK_SIZE = 100;
    public static final double DEFAULT_DB_SIMILARITY_SIZE = 0.6d;
    public static final int DEFAULT_DIFFERENCE_DB_SPLITE_SIZE = 4;
    public static final int DEFAULT_DIFF_PACKET_NUM = 10;
    public static final long DEFAULT_FILEID_LIST_MAX_LEN = 1048576;
    public static final int DEFAULT_FILE_FINISH_RETRY_INTERVAL = 10;
    public static final float DEFAULT_FILE_FINISH_RETRY_INTERVAL_RATEL = 0.0f;
    public static final int DEFAULT_FILE_FINISH_RETRY_TIMES = 3;
    public static final int DEFAULT_MAX_FILE_TASK_SIZE = 2;
    public static final int DEFAULT_MKFILE_BATCH_NUM = 20;
    private static final int DEFAULT_MKFILE_LGR_SCR_PWR = 0;
    public static final int DEFAULT_MKFILE_THREADS = 1;
    public static final int DEFAULT_MKFILE_THREADS_ADVANCED = 2;
    public static final double DEFAULT_OLD_TAR_REFERENCE_RATE = 0.1d;
    public static final int DEFAULT_RESERVED_SIZE = 0;
    public static final int DEFAULT_RETRY_INTERVAL = 30;
    public static final int DEFAULT_SDCARD_ACPT_ERR_NUM = 20;
    public static final int DEFAULT_SDCARD_ACPT_ERR_RATE = 5;
    public static final int DEFAULT_SDCARD_CACHE_DURATION = 36;
    public static final int DEFAULT_SDCARD_FILE_IGNORE = 1;
    public static final double DEFAULT_TAR_REFERENCE_RATE = 0.2d;
    public static final long DEFAULT_TAR_SIZE = 102400000;
    public static final int DEFAULT_TAR_THRESHOLD = 4000;
    private static final int DEFAULT_TIME_ADVANCED = 20;
    public static final int DEFAULT_TINY_THRESHOLD = 200;
    private static final int DEFUALT_CHECK_INTERVAL = 2;
    public static final int MAX_BACKUP_MODULES_CACHE_NUM = 5;
    public static final int MY_HW_SCENES_RED_DOT = 0;
    public static final int RESTORE_RETRY_DURATION = 2;
    public static final int UNSUPPORT_BATTERY_CHARGE_CONNECTED = -1;

    @SerializedName("DBDiffMaxFileSize")
    private int DBDiffMaxFileSize;
    private String appBackupDurationConfig;
    private float appBackupNoStoragePopupThreshold;
    private List<AppBackupSwitchListApp> appBackupSwitchListApps;
    private String appBackupSwitchRecommendConfig;
    private List<BlackModules> appDataBlackModules;
    private int backupCycle;
    private int batchRMNum;
    private int cacheDuration;
    private int cacheMin;
    private int cacheNum;
    private float cacheRatio;
    private int cacheUpper;
    private int checkInterval;
    private int checkIntervalMax;
    private int closeSwitchDeleteTip;
    private int cloudBackupPathMapping;
    private int correctLastBackupEndTime;
    private int createV1;
    private int dBSplitBlock;
    private String data;
    private int dataAcptErrNum;
    private int dataAcptErrRate;
    private int dataCacheDuration;
    private List<String> dataErrApp;

    @SerializedName("DBIncrBack")
    private int dbIncrBack;

    @SerializedName("DBSimilarity")
    private double dbSimilarity;
    private int defaultRedDot;

    @SerializedName("DffPacketNum")
    private int dffPacketNum;
    private int enableAppBackupSwitchRecommend;

    @SerializedName("fileFinishRetryInterval")
    private int fileFinishRetryInterval;

    @SerializedName("fileFinishRetryIntervalRate")
    private float fileFinishRetryIntervalRate;

    @SerializedName("fileFinishRetryTimes")
    private int fileFinishRetryTimes;
    private int mkfileBatchNum;
    private int mkfileLgrScrPwr;
    private int mkfileThreads;
    private int mkfileThreadsAdvanced;
    private String refurbishValidPeriod;
    private long reminderCycle;
    private int reservedSize;
    private String restoreRetry;
    private int restoreRetryPeriod;
    private int retryInterval;
    private int sdcardAcptErrNum;
    private int sdcardAcptErrRate;
    private int sdcardCacheDuration;
    private int sdcardFileIgnore;
    private long tarThreshold;
    private String thermalControl;
    private String thermalControlGroup;
    private int timeAdvanced;
    private long tinyThreshold;
    private String twinAppControl;
    private List<TwinAppRestoreControl> twinAppRestoreControlList;
    private int typeOfAppCfg;
    private List<String> threadsAdvancedDevice = new ArrayList();
    private int clientSizeCache = -1;
    private List<DisperseRule> disperseRule = new ArrayList();
    private int batteryChargeConnected = -1;
    private List<String> appBackupBlackList = new ArrayList();
    private List<OMFilterModule> appBackupSkipList = new ArrayList();
    private List<BackupOptionSize> backupOptionSize = new ArrayList();
    private List<Next2hmosMappingItem> next2hmosMappingItems = new ArrayList();
    private List<String> appDataBackupBlackList = new ArrayList();
    private List<Map<String, Object>> systemPackageNameList = new ArrayList();
    private List<String> hiddenAlbumPath = new ArrayList();

    public List<String> getAppBackupBlackList() {
        return this.appBackupBlackList;
    }

    public String getAppBackupDurationConfig() {
        return this.appBackupDurationConfig;
    }

    public float getAppBackupNoStoragePopupThreshold() {
        return this.appBackupNoStoragePopupThreshold;
    }

    public List<OMFilterModule> getAppBackupSkipList() {
        return this.appBackupSkipList;
    }

    public List<AppBackupSwitchListApp> getAppBackupSwitchListApps() {
        return this.appBackupSwitchListApps;
    }

    public String getAppBackupSwitchRecommendConfig() {
        return this.appBackupSwitchRecommendConfig;
    }

    public List<String> getAppDataBackupBlackList() {
        List<String> list = this.appDataBackupBlackList;
        return list == null ? new ArrayList() : list;
    }

    public List<BlackModules> getAppDataBlackModule() {
        return this.appDataBlackModules;
    }

    public int getBackupCycle() {
        if (this.backupCycle == 0) {
            this.backupCycle = 7;
        }
        return this.backupCycle;
    }

    public List<BackupOptionSize> getBackupOptionSize() {
        return this.backupOptionSize;
    }

    public int getBatchRMNum() {
        if (this.batchRMNum == 0) {
            this.batchRMNum = 50;
        }
        return this.batchRMNum;
    }

    public int getBatteryChargeConnected() {
        return this.batteryChargeConnected;
    }

    public int getCacheDuration() {
        if (this.cacheDuration <= 0) {
            this.cacheDuration = 2;
        }
        return this.cacheDuration;
    }

    public int getCacheMin() {
        return this.cacheMin;
    }

    public int getCacheNum() {
        int i10 = this.cacheNum;
        if (i10 == 0 || i10 > 5) {
            this.cacheNum = 2;
        }
        return this.cacheNum;
    }

    public float getCacheRatio() {
        return this.cacheRatio;
    }

    public int getCacheUpper() {
        return this.cacheUpper;
    }

    public int getCheckInterval() {
        if (this.checkInterval == 0) {
            this.checkInterval = 2;
        }
        return this.checkInterval;
    }

    public int getCheckIntervalMax() {
        if (this.checkIntervalMax == 0) {
            this.checkIntervalMax = 30;
        }
        return this.checkIntervalMax;
    }

    public int getClientSizeCache() {
        if (this.clientSizeCache < 0) {
            this.clientSizeCache = 48;
        }
        return this.clientSizeCache;
    }

    public int getCloseSwitchDeleteTip() {
        return this.closeSwitchDeleteTip;
    }

    public int getCloudBackupPathMapping() {
        return this.cloudBackupPathMapping;
    }

    public int getCorrectLastBackupEndTime() {
        return this.correctLastBackupEndTime;
    }

    public int getCreateV1() {
        if (this.createV1 == 0) {
            this.createV1 = 1;
        }
        return this.createV1;
    }

    public int getDBDiffMaxFileSize() {
        return this.DBDiffMaxFileSize;
    }

    public String getData() {
        String str = this.data;
        return str == null ? "" : str;
    }

    public int getDataAcptErrNum() {
        return this.dataAcptErrNum;
    }

    public int getDataAcptErrRate() {
        return this.dataAcptErrRate;
    }

    public int getDataCacheDuration() {
        if (this.dataCacheDuration == 0) {
            this.dataCacheDuration = 0;
        }
        return this.dataCacheDuration;
    }

    public List<String> getDataErrApp() {
        return this.dataErrApp;
    }

    public int getDbIncrBack() {
        if (this.dbIncrBack == 0) {
            this.dbIncrBack = 100;
        }
        return this.dbIncrBack;
    }

    public double getDbSimilarity() {
        if (this.dbSimilarity == 0.0d) {
            this.dbSimilarity = 0.6d;
        }
        return this.dbSimilarity;
    }

    public int getDefaultRedDot() {
        if (this.defaultRedDot != -1) {
            this.defaultRedDot = 0;
        }
        return this.defaultRedDot;
    }

    public int getDffPacketNum() {
        if (this.dffPacketNum == 0) {
            this.dffPacketNum = 10;
        }
        return this.dffPacketNum;
    }

    public List<DisperseRule> getDisperseRule() {
        List<DisperseRule> list = this.disperseRule;
        return list == null ? new ArrayList() : list;
    }

    public int getEnableAppBackupSwitchRecommend() {
        return this.enableAppBackupSwitchRecommend;
    }

    public int getFileFinishRetryInterval() {
        return this.fileFinishRetryInterval;
    }

    public float getFileFinishRetryIntervalRate() {
        return this.fileFinishRetryIntervalRate;
    }

    public int getFileFinishRetryTimes() {
        return this.fileFinishRetryTimes;
    }

    public List<String> getHiddenAlbumPath() {
        return this.hiddenAlbumPath;
    }

    public int getMkfileBatchNum() {
        if (this.mkfileBatchNum == 0) {
            this.mkfileBatchNum = 20;
        }
        return this.mkfileBatchNum;
    }

    public int getMkfileLgrScrPwr() {
        int i10 = this.mkfileLgrScrPwr;
        if (i10 != 0 && i10 != 1) {
            this.mkfileLgrScrPwr = 0;
        }
        return this.mkfileLgrScrPwr;
    }

    public int getMkfileThreads() {
        if (this.mkfileThreads == 0) {
            this.mkfileThreads = 1;
        }
        return this.mkfileThreads;
    }

    public int getMkfileThreadsAdvanced() {
        if (this.mkfileThreadsAdvanced == 0) {
            this.mkfileThreadsAdvanced = 2;
        }
        return this.mkfileThreadsAdvanced;
    }

    public List<Next2hmosMappingItem> getNext2hmosMappingItems() {
        return this.next2hmosMappingItems;
    }

    public String getRefurbishValidPeriod() {
        return this.refurbishValidPeriod;
    }

    public long getReminderCycle() {
        return this.reminderCycle;
    }

    public int getReservedSize() {
        return this.reservedSize;
    }

    public String getRestoreRetry() {
        return this.restoreRetry;
    }

    public int getRestoreRetryPeriod() {
        return this.restoreRetryPeriod;
    }

    public int getRetryInterval() {
        if (this.retryInterval == 0) {
            this.retryInterval = 30;
        }
        return this.retryInterval;
    }

    public int getSdcardAcptErrNum() {
        if (this.sdcardAcptErrNum == 0) {
            this.sdcardAcptErrNum = 20;
        }
        return this.sdcardAcptErrNum;
    }

    public int getSdcardAcptErrRate() {
        if (this.sdcardAcptErrRate == 0) {
            this.sdcardAcptErrRate = 5;
        }
        return this.sdcardAcptErrRate;
    }

    public int getSdcardCacheDuration() {
        if (this.sdcardCacheDuration == 0) {
            this.sdcardCacheDuration = 36;
        }
        return this.sdcardCacheDuration;
    }

    public int getSdcardFileIgnore() {
        return this.sdcardFileIgnore;
    }

    public List<Map<String, Object>> getSystemPackageNameList() {
        return this.systemPackageNameList;
    }

    public long getTarThreshold() {
        if (this.tarThreshold == 0) {
            this.tarThreshold = 4000L;
        }
        return this.tarThreshold;
    }

    public String getThermalControl() {
        return this.thermalControl;
    }

    public String getThermalControlGroup() {
        return this.thermalControlGroup;
    }

    public List<String> getThreadsAdvancedDevice() {
        List<String> list = this.threadsAdvancedDevice;
        return list == null ? new ArrayList() : list;
    }

    public int getTimeAdvanced() {
        if (this.timeAdvanced == 0) {
            this.timeAdvanced = 20;
        }
        return this.timeAdvanced;
    }

    public long getTinyThreshold() {
        if (this.tinyThreshold == 0) {
            this.tinyThreshold = 200L;
        }
        return this.tinyThreshold;
    }

    public String getTwinAppControl() {
        return this.twinAppControl;
    }

    public List<TwinAppRestoreControl> getTwinAppRestoreControlList() {
        return this.twinAppRestoreControlList;
    }

    public int getTypeOfAppCfg() {
        return this.typeOfAppCfg;
    }

    public int getdBSplitBlock() {
        if (this.dBSplitBlock == 0) {
            this.dBSplitBlock = 4;
        }
        return 4;
    }

    public void setAppBackupDurationConfig(String str) {
        this.appBackupDurationConfig = str;
    }

    public void setAppBackupNoStoragePopupThreshold(float f10) {
        this.appBackupNoStoragePopupThreshold = f10;
    }

    public void setAppBackupSkipList(List<OMFilterModule> list) {
        this.appBackupSkipList = list;
    }

    public void setAppBackupSwitchListApps(List<AppBackupSwitchListApp> list) {
        this.appBackupSwitchListApps = list;
    }

    public void setAppBackupSwitchRecommendConfig(String str) {
        this.appBackupSwitchRecommendConfig = str;
    }

    public void setAppDataBackupBlackList(List<String> list) {
        this.appDataBackupBlackList = list;
    }

    public void setAppDataBlackModule(List<BlackModules> list) {
        this.appDataBlackModules = list;
    }

    public void setAppsBlackList(List<String> list) {
        this.appBackupBlackList = list;
    }

    public void setBackupCycle(int i10) {
        this.backupCycle = i10;
    }

    public void setBackupOptionSize(List<BackupOptionSize> list) {
        this.backupOptionSize = list;
    }

    public void setBatchRMNum(int i10) {
        this.batchRMNum = i10;
    }

    public void setBatteryChargeConnected(int i10) {
        this.batteryChargeConnected = i10;
    }

    public void setCacheDuration(int i10) {
        this.cacheDuration = i10;
    }

    public void setCacheMin(int i10) {
        this.cacheMin = i10;
    }

    public void setCacheNum(int i10) {
        this.cacheNum = i10;
    }

    public void setCacheRatio(float f10) {
        this.cacheRatio = f10;
    }

    public void setCacheUpper(int i10) {
        this.cacheUpper = i10;
    }

    public void setCheckInterval(int i10) {
        this.checkInterval = i10;
    }

    public void setCheckIntervalMax(int i10) {
        this.checkIntervalMax = i10;
    }

    public void setClientSizeCache(int i10) {
        this.clientSizeCache = i10;
    }

    public void setCloseSwitchDeleteTip(int i10) {
        this.closeSwitchDeleteTip = i10;
    }

    public void setCloudBackupPathMapping(int i10) {
        this.cloudBackupPathMapping = i10;
    }

    public void setCorrectLastBackupEndTime(int i10) {
        this.correctLastBackupEndTime = i10;
    }

    public void setCreateV1(int i10) {
        this.createV1 = i10;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDataAcptErrNum(int i10) {
        this.dataAcptErrNum = i10;
    }

    public void setDataAcptErrRate(int i10) {
        this.dataAcptErrRate = i10;
    }

    public void setDataCacheDuration(int i10) {
        this.dataCacheDuration = i10;
    }

    public void setDataErrApp(List<String> list) {
        this.dataErrApp = list;
    }

    public void setDbIncrBack(int i10) {
        this.dbIncrBack = i10;
    }

    public void setDbSimilarity(double d10) {
        this.dbSimilarity = d10;
    }

    public void setDefaultRedDot(int i10) {
        this.defaultRedDot = i10;
    }

    public void setDffPacketNum(int i10) {
        this.dffPacketNum = i10;
    }

    public void setDisperseRule(List<DisperseRule> list) {
        this.disperseRule = list;
    }

    public void setEnableAppBackupSwitchRecommend(int i10) {
        this.enableAppBackupSwitchRecommend = i10;
    }

    public void setHiddenAlbumPath(List<String> list) {
        this.hiddenAlbumPath = list;
    }

    public void setMkfileBatchNum(int i10) {
        this.mkfileBatchNum = i10;
    }

    public void setMkfileLgrScrPwr(int i10) {
        this.mkfileLgrScrPwr = i10;
    }

    public void setMkfileThreads(int i10) {
        this.mkfileThreads = i10;
    }

    public void setMkfileThreadsAdvanced(int i10) {
        this.mkfileThreadsAdvanced = i10;
    }

    public void setNext2hmosMappingItems(List<Next2hmosMappingItem> list) {
        this.next2hmosMappingItems = list;
    }

    public void setRefurbishValidPeriod(String str) {
        this.refurbishValidPeriod = str;
    }

    public void setReminderCycle(long j10) {
        this.reminderCycle = j10;
    }

    public void setReservedSize(int i10) {
        this.reservedSize = i10;
    }

    public void setRestoreRetry(String str) {
        this.restoreRetry = str;
    }

    public void setRestoreRetryPeriod(int i10) {
        this.restoreRetryPeriod = i10;
    }

    public void setRetryInterval(int i10) {
        this.retryInterval = i10;
    }

    public void setSdcardAcptErrNum(int i10) {
        this.sdcardAcptErrNum = i10;
    }

    public void setSdcardAcptErrRate(int i10) {
        this.sdcardAcptErrRate = i10;
    }

    public void setSdcardCacheDuration(int i10) {
        this.sdcardCacheDuration = i10;
    }

    public void setSdcardFileIgnore(int i10) {
        this.sdcardFileIgnore = i10;
    }

    public void setSystemPackageNameList(List<Map<String, Object>> list) {
        this.systemPackageNameList = list;
    }

    public void setTarThreshold(long j10) {
        this.tarThreshold = j10;
    }

    public void setThermalControl(String str) {
        this.thermalControl = str;
    }

    public void setThermalControlGroup(String str) {
        this.thermalControlGroup = str;
    }

    public void setThreadsAdvancedDevice(List<String> list) {
        this.threadsAdvancedDevice = list;
    }

    public void setTimeAdvanced(int i10) {
        this.timeAdvanced = i10;
    }

    public void setTinyThreshold(long j10) {
        this.tinyThreshold = j10;
    }

    public void setTwinAppControl(String str) {
        this.twinAppControl = str;
    }

    public void setTwinAppRestoreControlList(List<TwinAppRestoreControl> list) {
        this.twinAppRestoreControlList = list;
    }

    public void setTypeOfAppCfg(int i10) {
        this.typeOfAppCfg = i10;
    }

    public void setdBSplitBlock(int i10) {
        this.dBSplitBlock = i10;
    }

    public String toString() {
        return "RuleConfig{backupCycle=" + this.backupCycle + ", cacheDuration=" + this.cacheDuration + ", tinyThreshold=" + this.tinyThreshold + ", tarThreshold=" + this.tarThreshold + ", dBSplitBlock=" + this.dBSplitBlock + ", dbIncrBack=" + this.dbIncrBack + ", dbSimilarity=" + this.dbSimilarity + ", dffPacketNum=" + this.dffPacketNum + ", createV1=" + this.createV1 + ", typeOfAppCfg=" + this.typeOfAppCfg + ", batchRMNum=" + this.batchRMNum + ", retryInterval=" + this.retryInterval + ", dataCacheDuration=" + this.dataCacheDuration + ", timeAdvanced=" + this.timeAdvanced + ", checkInterval=" + this.checkInterval + ", checkIntervalMax=" + this.checkIntervalMax + ", mkfileBatchNum=" + this.mkfileBatchNum + ", mkfileThreads=" + this.mkfileThreads + ", mkfileLgrScrPwr=" + this.mkfileLgrScrPwr + ", mkfileThreadsAdvanced=" + this.mkfileThreadsAdvanced + ", threadsAdvancedDevice=" + this.threadsAdvancedDevice + ", clientSizeCache=" + this.clientSizeCache + ", disperseRule=" + this.disperseRule + ", sdcardCacheDuration=" + this.sdcardCacheDuration + ", sdcardAcptErrNum=" + this.sdcardAcptErrNum + ", sdcardAcptErrRate=" + this.sdcardAcptErrRate + ", data='" + this.data + ", defaultRedDot =" + this.defaultRedDot + "', thermalControl=" + this.thermalControl + ", restoreRetry=" + this.restoreRetry + ", twinAppControl=" + this.twinAppControl + ", refurbishValidPeriod=" + this.refurbishValidPeriod + ", closeSwitchDeleteTip=" + this.closeSwitchDeleteTip + ", fileFinishRetryTimes=" + this.fileFinishRetryTimes + ", fileFinishRetryInterval=" + this.fileFinishRetryInterval + ", fileFinishRetryIntervalRate=" + this.fileFinishRetryIntervalRate + ", DBDiffMaxFileSize=" + this.DBDiffMaxFileSize + ", appBackupDurationConfig=" + this.appBackupDurationConfig + ", hiddenAlbumPath=" + this.hiddenAlbumPath + ", thermalControlGroup=" + this.thermalControlGroup + '}';
    }
}
