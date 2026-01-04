package com.huawei.hicloud.notification.constants;

/* loaded from: classes6.dex */
public class HNConstants {

    public static class App {
        public static final int ANDROID_VERSION_CODE_N = 24;
        public static final int WAIT_TIME = 20000;
    }

    /* renamed from: com.huawei.hicloud.notification.constants.HNConstants$BI */
    public static class C4906BI {
        public static final String BI_CLOUD_SPACE_TYPE = "bi_cloud_space_type";
        public static final String BI_KEY_CLICK_FROM_NOTIFY = "bi_key_click_from_notify";
        public static final String BI_NOTIFY_TYPE = "bi_notify_type";
        public static final String BI_PERCENTAGE = "bi_percentage";
        public static final String DATA_IS_SUPPORT_ACTIVITY = "data_is_support_activity";
        public static final String DATA_IS_VOUCHER_NOTICE = "data_is_voucher_notice";
        public static final String DATA_OF_ACTIVITY_INFO = "data_of_activity_info";
        public static final String DATA_TYPE_ID = "data_type_id";
        public static final String FROM_NOTIFY = "from_notify";
        public static final String KEY_OF_ACTIVITY_ID = "activity_id";
        public static final String KEY_OF_ACTIVITY_TYPE = "activity_type";
        public static final String KEY_OF_GOTO_URI_VALUE = "goto_uri_value";
        public static final String NOTIFY_TITLE = "notify_title";
    }

    public interface BICloudSpaceNotifyType {
        public static final String ALBUM_NOT_ENOUTH_NOTIFY = "3";
        public static final String BUSINESS_CLOUD_SPACE_NOTIFY = "2";
        public static final String NOTICE_BEFORE_BACKUP = "4";
        public static final String USE_CLOUD_SPACE_NOTIFY = "1";
    }

    public static class BINotifyTypeValue {
        public static final String BACK_UP_OVER_MONTH_RECORD = "8";
        public static final String CLOUDSPACE = "2";
        public static final String CLOUDSPACE_NOT_ENOUGH = "3";
        public static final String CLOUD_DATA_RECOVER = "11";
        public static final String FORCED_UPGRADE = "6";
        public static final String FRONT_APP_ACCEPT_GIFT = "9";
        public static final String FRONT_APP_INSTALLED_SUCCESS = "10";
        public static final String PULLNEW = "1";
        public static final String RISK_MANAGEMENT = "5";
        public static final String STOCK_ACTIVE = "7";
        public static final String ST_NOT_STINVAILD = "4";
    }

    public static class CloudConfig {
        public static final String CLOUD_CONFIG_EXT_FILE_PATH = "/hicloud_notify_config_ext.txt";
        public static final String CLOUD_CONFIG_FILE_EXT_NAME = "hicloud_notify_config_ext.txt";
        public static final String CLOUD_CONFIG_FILE_NAME = "hicloud_notify_config.txt";
        public static final String CLOUD_CONFIG_FILE_PATH = "/hicloud_notify_config.txt";
        public static final String CLOUD_CONFIG_FILE_TMP_PATH = "/hicloud_notify_config.txt.tmp";
        public static final String LOCAL_CONFIG_EXT_FILE_PATH = "/hicloud_notify_config_ext_local.txt";
        public static final String LOCAL_CONFIG_FILE_EXT_NAME = "hicloud_notify_config_ext_local.txt";
        public static final String LOCAL_EXTRA_NOTIFY_LANGUAGE_XML_NAME = "hicloud_extra_notify_language.xml";
        public static final String LOCAL_NOTIFY_LANGUAGE_XML_NAME = "hicloud_notify_with_activity_language.xml";
    }

    public static class Cmd {
        public static final int CMD_ALBUM_NOTIFY = 6;
        public static final int CMD_ALBUM_SPACE_NOT_ENOUGH = 7;
        public static final int CMD_BACKUP_CYCLE_NOTIFY = 9;
        public static final int CMD_CHECK_DATABASE = 11;
        public static final int CMD_GET_MODULE_CONFIG = 5;
        public static final int CMD_GET_NOTICE_CONFIG = 8;
        public static final int CMD_GET_VERSION = 2;
        public static final int CMD_NOTIFY = 3;
        public static final int CMD_NOTIFY_CLOUD_SPACE = 4;
        public static final int CMD_SPACE_USED_NOTIFY = 10;
    }

    public static class Compare {
        public static final float DAY_TO_HOURS_CONVERSION_UNIT = 24.0f;
        public static final int EQUAL = 0;
        public static final int HIGHER_THAN = 1;
        public static final int LOW_THAN = -1;
        public static final float MILLIS_TO_HOURS_CONVERSION_UNIT = 3600000.0f;
        public static final int NO_PRIORITY = -1;
        public static final long TEN_SECOND = 10000;
    }

    public static class DataType {
        public static final String APP = "application";
        public static final String CONTACT = "contact";
        public static final String MEDIA = "gallery";

        /* renamed from: NA */
        public static final String f22634NA = "NA";
    }

    public static class DbNotifyType {
        public static final int CANCEL_DIALOG = 5;
        public static final int CLOUDALBUM_SPACE = 7;
        public static final int CONFIRM_PAGE = 4;
        public static final int NOTICE = 3;
        public static final int PULL_NEW = 1;
        public static final int RECONFIRM = 6;
        public static final int SPACE = 2;
    }

    public static class DownloadConfigReport {
        public static final String ERR_REASON_KEY = "err_reason";
        public static final String FAIL = "1";
        public static final String REPORT_RESULT_KEY = "result";
        public static final String RETRY_NUM_KEY = "retry_num";
        public static final String SUCCESS = "0";
        public static final String SUCCESS_SCRIPTION = "success_scription";
    }

    public interface FrequencyControl {
        public static final String FREQUENCY_CONTROL_LANGUAGE_DOWNLOAD_RESULT = "frequency_control_language_download";
        public static final String FREQUENCY_CONTROL_LANGUAGE_HASH = "frequency_control_language_hash";
        public static final String FREQUENCY_CONTROL_LANGUAGE_VERSION = "frequency_control_language_version";
        public static final String FREQUENCY_CONTROL_LANGUAGE_XML_NAME = "frequency_control_language.xml";
    }

    public static class HiCloudSpaceNoticeLanguage {
        public static final String LANGUAGE_ATTRIBUTE_NAME = "name";
        public static final String LANGUAGE_ATTRIBUTE_VALUE = "value";
        public static final String LANGUAGE_RESOURCE_TAG = "resource";
        public static final String LANGUAGE_TEXT_TAG = "text";
    }

    public static class Language {

        /* renamed from: CN */
        public static final String f22635CN = "zh_cn";
        public static final String CN_STANDARD = "zh-CN";

        /* renamed from: EN */
        public static final String f22636EN = "en_us";
        public static final String EN_STANDARD = "en-US";
    }

    public static class Limit {
        public static final float AMOUNT_NA = -1.0f;
        public static final int RETRY_TIMES = 3;
    }

    public static class LocalConfig {
        public static final String DEFAUT_CONFIG_FILE = "notification_default.json";
    }

    public static class LoginState {
        public static final String LOGIN = "login";
        public static final String LOGOUT = "logout";
    }

    public static class Media {
        public static final int URI_TYPE_PIC = 0;
        public static final int URI_TYPE_VIDEO = 1;
    }

    public static class NotifyType {
        public static final String SCENE_BOOT = "device_boot_check";
        public static final String SCENE_DAILY_CHECK = "daily_check";
        public static final String SCENE_HIDISK = "filemanager_boot_check";
        public static final String SCENE_SYNC = "app_data_use";
    }

    public static class Operator {
        public static final String AND = "AND";

        /* renamed from: OR */
        public static final String f22637OR = "OR";
    }

    public interface PayIntentKey {
        public static final String IS_FROM_COUPON_CENTER_WELFARE_CARD = "is_from_coupon_center_welfare_card";
        public static final String IS_FROM_NOTI_OR_DIALOG_RECOMMEND_KEY = "is_from_noti_or_dialog_recommend";
        public static final String RECOMMEND_CAPACITY_KEY = "recommend_capacity";
        public static final String RECOMMEND_GRADE_CODE_KEY = "recommend_grade_code";
        public static final String RECOMMEND_PACKAGE_ID_KEY = "recommend_package_id";
    }

    public static class Region {

        /* renamed from: CN */
        public static final String f22638CN = "CN";
    }

    public static class RemindMode {
        public static final String DETAIL = "detail";
        public static final String DETAIL_MEMBER = "detail_member";
        public static final String NOTIFICATION = "notification";
        public static final String POPUP = "popup";
    }

    public static class RuleType {
        public static final String CONDITION_TYPE_NUMBER = "number";
        public static final String CONDITION_TYPE_SIZE = "size_mb";
        public static final float CONVERSION_UNIT = 1048576.0f;
        public static final String INCREMENT_VALUE = "incremental_value";
        public static final String INIT_VALUE = "initial_value";
        public static final int NEED_CHECK = 0;
        public static final int NO_NEED_CHECK = 1;
    }

    /* renamed from: com.huawei.hicloud.notification.constants.HNConstants$SP */
    public static class C4907SP {
        public static final String APP_AMOUNT = "app_amount";
        public static final String APP_SIZE = "app_size";
        public static final String CONTACT_AMOUNT = "contact_amount";
        public static final String CONTACT_SIZE = "contact_size";
        public static final String EXTRA_NOTIFICATION_LANGUAGE_DOWNLOAD_RESULT = "extra_notification_with_language_download";
        public static final String EXTRA_NOTIFICATION_LANGUAGE_HASH = "extra_notification_with_language_hash";
        public static final String EXTRA_NOTIFICATION_LANGUAGE_VERSION = "extra_notification_with_language_version";
        public static final String IS_RISK_UPDATE = "is_risk_update";
        public static final String IS_UPDATE = "is_version_update_v2";
        public static final String MEDIA_AMOUNT = "media_amount";
        public static final String MEDIA_SIZE = "media_size";
        public static final String NAME = "notification";
        public static final String NOTIFICATION_LANGUAGE_DOWNLOAD_RESULT = "notification_with_language_download";
        public static final String NOTIFICATION_LANGUAGE_HASH = "notification_with_language_hash";
        public static final String NOTIFICATION_LANGUAGE_VERSION = "notification_with_language_version";
    }

    public static class Update {
        public static final long PERIOD = 86400000;
    }
}
