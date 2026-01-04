package com.huawei.hicloud.notification.constants;

/* loaded from: classes6.dex */
public class StockActiveConstants {
    public static final String ACTIVITY_NAME = "com.huawei.android.hicloud.ui.activity.StockActiveActivity";
    public static final String DIALOG_NAME = "com.huawei.android.hicloud.ui.activity.StockActivePopupGuideActivity";
    public static final String LANGUAGE_ATTRIBUTE_NAME = "name";
    public static final String LANGUAGE_ATTRIBUTE_VALUE = "value";
    public static final String LANGUAGE_FILE_NAME = "stock_active_language_strings.xml";
    public static final String LANGUAGE_RESOURCE_TAG = "resource";
    public static final String LANGUAGE_TEXT_TAG = "text";
    public static final String LANGUAGE_VERSION = "stock_active_language_version";
    public static final String PICTURE_FILE_NAME = "stock_active_picture";
    public static final String STOCK_ACTIVE_LOGIN_FINISH_ACTION = "com.huawei.hicloud.intent.action.STOCK_ACTIVE_LOGIN_FINISH";
    public static final String STOCK_ACTIVE_SP_NAME = "stock_active";

    public static final class ActiveCloudWay {
        public static final int LOGIN = 1;
        public static final int UNLOGIN = 2;
    }

    public interface DownloadConfigReport {
        public static final String ERR_REASON_KEY = "err_reason";
        public static final String FAIL = "1";
        public static final String INFO = "info";
        public static final String REPORT_RESULT_KEY = "result";
        public static final String RETRY_NUM_KEY = "retry_num";
        public static final String SUCCESS = "0";
    }

    public static final class NotifyType {
        public static final int DEFAULT = 0;
        public static final int NOTIFICATION = 1;
        public static final int POPUP = 2;
    }

    public static final class Num {
        public static final int BANNER_NUM = 2;
        public static final int NOTIFY_30_DAYS = 30;
        public static final int NOTIFY_3_DAYS = 3;
        public static final int NOTIFY_5_DAYS = 5;
        public static final int NOTIFY_7_DAYS = 7;
        public static final int POPUP_NUM = 4;
    }

    public static final class PhoneFinderOpenResult {
        public static final int DEFAULT = 0;
        public static final String FAIL = "fail";
        public static final int FAIL_NUM = 2;
        public static final String OPEN_BACKUP_RESULT = "openbackupresult";
        public static final String OPEN_RESULT = "openresult";
        public static final String SUCCESS = "success";
        public static final int SUCCESS_NUM = 1;
    }

    public static final class PpsResult {
        public static final int FAIL = 1;
        public static final int SUCCESS = 2;
    }

    public static final class Report {
        public static final String ACTIVE_CLOUD_BY_LOGIN = "stock_active_active_cloud_by_login";
        public static final String ACTIVE_CLOUD_BY_UNLOGIN = "stock_active_active_cloud_by_unlogin";
        public static final String CANCEL_NOTIFY = "stock_active_cancel_notify";
        public static final String CLICK_ACTIVITY_CLOSE = "stock_active_click_activity_close";
        public static final String CLICK_ACTIVITY_OPEN_LATER = "stock_active_click_activity_open_later";
        public static final String CLICK_ACTIVITY_OPEN_NOW = "stock_active_click_activity_open_now";
        public static final String CLICK_CONFIRM_NOTIFY_TIME = "stock_active_click_confirm_notify_time";
        public static final String CLICK_NOTIFY = "stock_active_click_notify";
        public static final String CLICK_POPUP_GUIDE_OPEN_LATER = "stock_active_click_popup_guide_open_later";
        public static final String CLICK_POPUP_GUIDE_OPEN_NOW = "stock_active_click_popup_guide_open_now";
        public static final String CLICK_POPUP_IN_30_DAYS_3_DAYS = "stock_active_click_popup_in_30_days_3_days";
        public static final String CLICK_POPUP_IN_30_DAYS_5_DAYS = "stock_active_click_popup_in_30_days_5_days";
        public static final String CLICK_POPUP_IN_30_DAYS_7_DAYS = "stock_active_click_popup_in_30_days_7_days";
        public static final String CLICK_POPUP_IN_30_DAYS_CANCEL = "stock_active_click_popup_in_30_days_cancel";
        public static final String CLICK_POPUP_IN_30_DAYS_CONFIRM = "stock_active_click_popup_in_30_days_confirm";
        public static final String CLICK_POPUP_OVER_30_DAYS_3_DAYS = "stock_active_click_popup_over_30_days_3_days";
        public static final String CLICK_POPUP_OVER_30_DAYS_5_DAYS = "stock_active_click_popup_over_30_days_5_days";
        public static final String CLICK_POPUP_OVER_30_DAYS_7_DAYS = "stock_active_click_popup_over_30_days_7_days";
        public static final String CLICK_POPUP_OVER_30_DAYS_CANCEL = "stock_active_click_popup_over_30_days_cancel";
        public static final String CLICK_POPUP_OVER_30_DAYS_CONFIRM = "stock_active_click_popup_over_30_days_confirm";
        public static final String CLICK_POPUP_OVER_30_DAYS_NO_REMINDER = "stock_active_click_popup_over_30_days_no_reminder";
        public static final String NEVER_NOTIFY = "stock_active_never_notify";
        public static final String OPEN_BACKUP = "stock_active_open_backup";
        public static final String OPEN_PHONEFINDER = "stock_active_open_phonefinder";
        public static final String SHOW_ACTIVITY = "stock_active_show_activity";
        public static final String SHOW_NOTIFY = "stock_active_show_notify";
        public static final String SHOW_POPUP_GUIDE = "stock_active_show_popup_guide";
        public static final String SHOW_POPUP_IN_30_DAYS = "stock_active_show_popup_in_30_days";
        public static final String SHOW_POPUP_OVER_30_DAYS = "stock_active_show_popup_over_30_days";
        public static final String TRY_NOTIFY = "stock_active_try_notify";
        public static final String TRY_POPUP_GUIDE = "stock_active_try_popup_guide";
        public static final String UNIFORM_CLICK_AGREE = "stock_active_uniform_click_agree";
        public static final String UNIFORM_CLICK_CANCLE = "stock_active_uniform_click_cancel";
    }

    public static final class SpKey {
        public static final String FIRST_ACTIVE_CLOUD_TIME = "first_active_cloud_time";
        public static final String FIRST_NOTIFY_TIME = "first_notify_time";
        public static final String FREQUENCY = "frequency";
        public static final String IF_HAS_ENTERED_MAIN_ACTIVITY = "if_has_entered_main_activity";
        public static final String IF_NO_MORE_REMINDERS = "ifNoMoreReminders";
        public static final String IS_ACTIVE_CLOUD_AUTO = "is_active_cloud_auto";
        public static final String IS_ACTIVE_CLOUD_FAIL = "is_active_cloud_fail";
        public static final String IS_ACTIVE_CLOUD_ING = "is_active_cloud_ing";
        public static final String LAST_ACTIVE_CLOUD_TIME = "last_active_cloud_time";
        public static final String LAST_NOTIFY_TIME = "last_notify_time";
        public static final String LAST_SEND_NOTIFICATION_TIME = "last_send_notification_time";
        public static final String LAST_SHOW_POPUP_TIME = "last_show_popup_time";
    }

    public static final class Time {
        public static final long ACTIVE_CLOUD_PERIOD = 86400000;
        public static final int CAT_NOT_NOTIFY_TIME = -1;
        public static final int DEFAULT_STOCK_ACTIVE_FREQUENCY = 7;
        public static final long FIRST_ACTIVE_CLOUD_PERIOD = 172800000;
        public static final long INIT_WAIT_TIME = 5000;
        public static final int MAX_STOCK_ACTIVE_FREQUENCY = 365;
        public static final int MAX_STOCK_ACTIVE_TIME = 180;
        public static final int MIN_STOCK_ACTIVE_FREQUENCY = 0;
        public static final int PHONE_FINDER_OPEN_AWAIT = 5;
        public static final long QUERY_LANGUAGE_AND_PICTURE_FAIL_PERIOD = 5000;
        public static final int STOCK_ACTIVE_FREQUENCY_30 = 30;
    }
}
