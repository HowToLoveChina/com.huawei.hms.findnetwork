package com.huawei.android.hicloud.cloudbackup.constant;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudBackupConstant {
    public static final String BACKUP_DEVICE_ID = "backupDeviceId";
    public static final String BACKUP_OPETION_REPORT_LIST = "backupOptionReportList";
    public static final int BACKUP_TYPE_AUTO = 1;
    public static final int CLOUDBACKUP_STOP_LOW_TEN_BATTERY = 10;
    public static final int CORRECT_LAST_BACKUP_END_TIME_DEFAULT_VALUE = 1;
    public static final String DATA_INTEGRITY = "dataIntegrity";
    public static final int NOT_OCCUPY_SPACE = 0;
    public static final int OCCUPY_SPACE = 1;
    public static final String REPORT_TYPE_BASE_BACKUP_SWITCH_CLOSE = "baseBackupSwitchClose";
    public static final String REPORT_TYPE_BASE_CLEAR_CACHE = "clearCache";
    public static final String REPORT_TYPE_FULL_BACKUP_SWITCH_CLOSE = "fullBackupSwitchClose";
    public static final String REPORT_TYPE_LOGOUT = "logOut";
    public static final String REPORT_TYPE_OLD_BACKUP_SWITCH_CLOSE = "oldBackupSwitchClose";
    public static final int REQUEST_CODE_FOR_GUIDE_SUBSCRIBE = 1000;
    public static final int REQUEST_CODE_FOR_SPACE_NOT_ENOUGH = 1001;
    public static final String SAFEBOX_DATA_CONTENT_URI = "content://com.huawei.filemanager.provider.StrongBoxCompleteProvider";
    public static final int SAVE_TO_SP_RESTORE_ITEM_MAX_COUNT = 30;
    public static final String TIME_EXPIRED_MODULES_INFO = "timeExpiredModulesInfo";

    public static class AnableAppBackupSwitchRecommend {
        public static final int BOOT_SWITCH = 4;
        public static final int DEFAULT = 15;
        public static final int NOTIFY_SWITCH = 8;
        public static final int OPEN = 1;
        public static final int USE = 2;
    }

    public static class ApkDownloadType {
        public static final int AGD_DOWNLOAD = 1;
        public static final int CLOUD_SERVICE_DOWNLOAD = 0;
    }

    public static class AppType {
        public static final int APP_NONSTANDARD = 1;
        public static final int APP_NONSTANDARD_NORMAL = 2;
        public static final int APP_STANDARD = 3;
        public static final int DEFAULT = 0;
        public static final int EXTEND_APP = 1;
        public static final int EXTEND_DEFAULT = 0;
        public static final int EXTEND_HARMONY = 2;
        public static final int OHOS_ARK = 1;
        public static final int SYSTEM = -1;
    }

    public interface AppdataCompatibleFlag {
        public static final int NOT_SUPPORT = -1;
    }

    public static class BackUpReadOmState {
        public static final int CREATE_TEMP_SUCCESS = 0;
        public static final int DEFAULT_STATE = -1;
        public static final int NOT_ENABLED_STATE = -2;
        public static final int READ_FAIL_BY_CONFIG = 3;
        public static final int REPLACE_TEMP_FAIL = 2;
        public static final int REPLACE_TEMP_SUCCESS = 1;
    }

    public static class BackupFlowControl {
        public static final String FLOW_CONTROL_ACTION = "com.huawei.android.hicloud.FLOWCONTROL";
        public static final int FLOW_CONTROL_CLENT_ID = 1555;
    }

    public enum BackupFrequency {
        FREQUENCY_1(1),
        FREQUENCY_3(3),
        FREQUENCY_5(5),
        FREQUENCY_7(7);

        public final int frequency;

        BackupFrequency(int i10) {
            this.frequency = i10;
        }

        public static BackupFrequency getFrequencyLevel(int i10) {
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? FREQUENCY_7 : FREQUENCY_7 : FREQUENCY_5 : FREQUENCY_3 : FREQUENCY_1;
        }
    }

    public static class BackupTimesDefaultValues {
        public static final int DEFAULT_BACKUPCYCLE = 7;
        public static final long DEFAULT_BREAK_TIME = 300000;
        public static final int DEFAULT_CHECK_INTERVAL = 2;
        public static final int DEFAULT_CHECK_INTERVAL_MAX = 30;
        public static final long DEFAULT_DELAYED_TIME = 600000;
        public static final int DEFAULT_NOTIFYCYCLE = 14;
        public static final int DEFAULT_RETRY_INTERVAL = 30;
        public static final int DEFAULT_TIME_ADVANCED = 20;
    }

    public static class ClearRange {
        public static final int DELETE_ALL = 1;
        public static final int DELETE_V2 = 0;
    }

    public static class CloudBackupRecordsSetting {
        public static final String BACKUP_RECORD_NUMBER = "backupRecordNumber";
        public static final String MBR = "MBR";
    }

    public static class Command {
        public static final String PMS_CMD_BACKUP = "backup";
        public static final String PMS_CMD_GET_BRIEF = "get_brief";
        public static final String PMS_CMD_MOVE = "move";
        public static final String PMS_CMD_RESTORE = "restore";
        public static final String PMS_INTERVAL = " ";
        public static final String PMS_OPTION_DIR = "dir";
        public static final String PMS_OPTION_FD = "fd";
        public static final String PMS_OPTION_FILE = "byfile";
        public static final String PMS_OPTION_FILE_TOTAR = "byfile toTar";
        public static final String PMS_OPTION_ONE_FILE = "file";
        public static final String PMS_OPTION_SEINFO = "seinfo";
    }

    public static class DeleteBackupRecord {
        public static final int FAIL = 1;
        public static final int NETWORK_ERROR = 2;
        public static final int SERVICE_ERROR = 3;
        public static final int SUCCESS = 0;
    }

    public interface DiffErrorCode {
        public static final int BACKUP_ERROR = 103;
        public static final int DIFF_ERROR = 101;
        public static final int DIFF_SUCCESS = 0;
        public static final int LOWER_TAR_THRESHOLD = 100;
        public static final int MK_FILE_ERROR = 102;
    }

    public static class DoneStatus {
        public static final int INSTALL_SUCCESS = 1;
        public static final int SPLIT_TYPE_DONE_STATUS = 10;
    }

    public static class FileType {
        public static final int ARK = 2;
        public static final int ARK_APP = 1;
        public static final int BIG_DB = 8;
        public static final int DB_ROOT = 10;
        public static final int DIRECTORY = 5;
        public static final int FILE = 6;
        public static final int MAPLE = 3;
        public static final int NODE = 4;
        public static final int NORMAL_APP = 0;
        public static final int SPLIT_DB = 9;
        public static final int TINY_FILE = 7;
    }

    public static class MetaStatus {
        public static final int DEFAULT = 0;
        public static final int DONE = 2;
        public static final int DOWNLOADED = 1;
    }

    public static class MusicFileFilterPath {
        private static final List<String> BLACK_PATH = new ArrayList<String>() { // from class: com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant.MusicFileFilterPath.1
            {
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH1);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH2);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH3);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH4);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH5);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH6);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH7);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH8);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH9);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH10);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH11);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH12);
            }
        };
        private static final List<String> BLACK_PATH_BACKUP = new ArrayList<String>() { // from class: com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant.MusicFileFilterPath.2
            {
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH11);
                add(MusicFileFilterPath.DEFAULT_BLACK_PATH12);
            }
        };
        private static final String DEFAULT_BLACK_PATH1 = "/external/Recordings/";
        private static final String DEFAULT_BLACK_PATH10 = "/usb/";
        private static final String DEFAULT_BLACK_PATH11 = "/product/media/Pre-loaded/Music/";
        private static final String DEFAULT_BLACK_PATH12 = "/hw_product/media/Pre-loaded/Music/";
        private static final String DEFAULT_BLACK_PATH2 = "/external/record/";
        private static final String DEFAULT_BLACK_PATH3 = "/external/Sounds/";
        private static final String DEFAULT_BLACK_PATH4 = "/external/Sounds/CallRecord/";
        private static final String DEFAULT_BLACK_PATH5 = "/sdcard/Sounds/CallRecord/";
        private static final String DEFAULT_BLACK_PATH6 = "/sdcard/record/";
        private static final String DEFAULT_BLACK_PATH7 = "/data/hw_init/product/media/Pre-loaded/Music/";
        private static final String DEFAULT_BLACK_PATH8 = "/data/hw_init/version/region_comm/china/media/Pre-loaded/Music/";
        private static final String DEFAULT_BLACK_PATH9 = "/data/hw_init/product/region_comm/china/media/Pre-loaded/Music/";

        public static List<String> getBlackPath() {
            return BLACK_PATH;
        }

        public static List<String> getBlackPathBackup() {
            return BLACK_PATH_BACKUP;
        }
    }

    public static class OmAppType {
        public static final int DEFAULT_3RD = 0;
        public static final int REFURBISH_VIRTUAL = 2;
        public static final int VIRTUAL = 1;
    }

    public enum Operation {
        QUERY_BACKUP_DEVICE_SHOW,
        QUERY_MODULE_INFO
    }

    public static class QuerySpaceCleanResult {
        public static final int FAIL = 0;
        public static final int LOADING = -1;
        public static final int SUCCESS = 1;
    }

    public static class ReportAppMarket {
        public static final String KEY_PACKAGE = "package";
        public static final String KEY_PKG_CHANNEL_ID = "pkgChannelId";
        public static final String KEY_SUB_SOURCE = "subSource";
        public static final String KEY_VERSION = "version";
        public static final int SUPPORTED_VERSION_CODE = 110301004;
    }

    public static class ReportReason {
        public static final String REASON = "reason";
        public static final String REPORT_REASON_TIME = "reportReasonTime";
        public static final long REPORT_TIME_INTERVAL = 1800000;
    }

    public interface RestoreDataDictionaryType {
        public static final String BASIC = "basic";
        public static final String FULL = "full";
    }

    public static class RestoreShowType {
        public static final int TYPE_SHOW_FILE_TOTAL = 1;
        public static final int TYPE_SHOW_SIZE = 0;
        public static final int TYPE_SHOW_SIZE_AND_TOTAL = 2;
    }

    public static class SendPush {
        public static final int NOT_SEND = 0;
        public static final int SEND = 1;
    }

    public static class Status {
        public static final int CANCEL = 1;
        public static final int CLONE_UN_SUPPORT = -3;
        public static final int DEFAULT = 0;
        public static final int DONE = 8;
        public static final int DOWNLOAD_APP = 5;
        public static final int DOWNLOAD_FILES = 4;
        public static final int FOREGROUND_UN_SUPPORT = -2;
        public static final int HM_UN_SUPPORT = -4;
        public static final int INSTALLER = 6;
        public static final int INSTALL_UN_SUPPORT = -6;
        public static final int MODULE_NOT_EXIST = -8;
        public static final int NO_EXIST_SUPPORT = -5;
        public static final int PAUSE = 2;
        public static final int RESTORE_FILES = 7;
        public static final int RESUME = 3;
        public static final int SAFE_BOX_RESTORE_UN_SUPPORT = -7;
        public static final int UNSUPPORT = -1;
    }

    public static class StatusCode {
        public static final int PMS_ERROR_FILE_NOTEXIST = -22;
        public static final int PMS_FAILED = -1;
        public static final int PMS_NOT_SUPPORT_HONOR = -5;
        public static final int PMS_NO_PERMISSION = -2;
        public static final int PMS_REPEATED_CMD = -4;
        public static final int PMS_STATUS_ABORT = 2;
        public static final int PMS_STATUS_BRIEF_REPORT_GENERATED = 6;
        public static final int PMS_STATUS_FAILED = -1;
        public static final int PMS_STATUS_FINISH = 0;
        public static final int PMS_STATUS_PROGRESS = 3;
        public static final int PMS_STATUS_START = 1;
        public static final int PMS_STATUS_TAR_GENERATED = 7;
        public static final int PMS_SUCCESS = 0;
        public static final int PMS_UN_SUPPORTED = -3;
        public static final int SAFE_BOX_RESTORE_UN_SUPPORT = -7;
    }

    public static class SwitchAction {
        public static final int DEFAULT = 0;
        public static final int PART_SUPPORT = 1;
        public static final int UNSUPPORT = 2;
    }

    public interface TimeWindowConstant {
        public static final int DEFAULT_VALUE_PERIOD_RANDOM_FACTOR = 7;
        public static final int DEFAULT_VALUE_TIMING_INTERVAL = 10;
        public static final String KEY_CYCLE_DEADLINE_TIME = "cycleDeadlineTime";
        public static final String KEY_IS_NEW_PERIOD = "isNewPeriod";
        public static final String KEY_PERIOD_RANDOM_FACTOR = "periodRandomFactor";
        public static final String KEY_TASK_START_TIME = "taskStartTimeMillis";
        public static final String KEY_TIME_WINDOW_RESULT = "timeWindowResult";
        public static final String KEY_TIMING_INTERVAL = "timingInterval";
        public static final String STAND_ALONE_TASK = "standAloneTask";
    }

    public static class Type {
        public static final int DEFAULT = 0;
        public static final int FAIL = 2;
        public static final int SUCCESS = 1;
    }

    public static class UserPackageInfo {
        public static final String BASE_DATA_SERVICE = "NN";
        public static final String DIAMOND_MEMBER = "D";
        public static final String FULL_DATA_SERVICE_200GB = "NG";
        public static final String FULL_DATA_SERVICE_2048GB = "ND";
        public static final String FULL_DATA_SERVICE_50GB = "NS";
        public static final String GOLD_MEMBER = "G";
        public static final String GRADE_CODE_KEY = "gradeCode";
        public static final String NORMAL_MEMBER = "N";
        public static final String ONE_T_MEMBER = "B";
        public static final String SILVER_MEMBER = "S";
        public static final String TRIAL_MEMBER = "T";
        public static final Integer NORMAL_BACKUP_RECORDS = 1;
        public static final Integer VIP_BACKUP_RECORDS = 3;
    }
}
