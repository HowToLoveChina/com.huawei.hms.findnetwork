package com.huawei.hicloud.notification.constants;

import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import vn.C13471c;

/* loaded from: classes6.dex */
public class NotifyConstants {
    public static final String ACTIVITIE_CENTER = "activitie_center";
    public static final int ACTIVITY_ENTRY_PICTURE_DOWNLOAD_WAITING_TIME = 30000;
    public static final String ACTIVITY_ENTRY_PICTURE_PATH = "/hicloudactivityentrypic";
    public static final String ACTIVITY_ENTRY_PICTURE_URL_SP_PATH = "activity_entry_pic_url_sp_path";
    public static final String APPLICATION_DATA = "application_data";
    public static final int AUTO_PAY_ERROR_SIGN = -2;
    public static final String BACKUP_COMPLETE = "backup_complete";
    public static final String BACKUP_CYCLE = "cloudbackup_days_notify";
    public static final String BACKUP_NOTIFICATION_CHANNEL_ID = "2";
    public static final String BACKUP_SPACE_NOT_ENOUGH_BUTTON_COUNT_KEY = "backup_space_not_enough_button_count_key";
    public static final String BACKUP_SPACE_NOT_ENOUGH_NEED_DATA_KEY = "backup_space_not_enough_need_data_key";
    public static final String BUY_MORE = "buy_more";
    public static final int CAPACITY_DEFAULT_ERROR = 0;
    public static final int CAPACITY_GET_ERROR = -1;
    public static final String CLEAR_CLOUDBACK_OVER_MONTHS = "clear_cloudback_over_months";
    public static final String CLOSE = "close";
    public static final String CLOSE_BACKUP_REMIND = "disable_hicloud_backup_reminders";
    public static final long CLOUDALBUM_TERRITIME = 1800000;
    public static final String CLOUDBACKUP_CLEAR = "cloudBackup_clear";
    public static final String CLOUD_BACKUP_BEFORE_NOTICE = "HiCloudBackupBeforeNotice";
    public static final String CLOUD_BACKUP_SPACE_INSUFFICIENT = "cloud_backup_space_insufficient";
    public static final String CLOUD_BACKUP_SUCCESS = "cloudback_success_remind";
    public static final String CLOUD_BACK_SUCCESS_NOTIFY = "cloud_back_success_notify";
    public static final String CLOUD_STORAGE = "cloud_storage";
    public static final String DETAIL = "detail";
    public static final String DIAMOND_LEVEL = "D";
    public static final String FIND_MY_PHONE = "find_my_phone";
    public static final int FLAG_REMOVBLE = 65536;
    public static final String FM_CLEAR = "fm_clear";
    public static final String GET_CONFIG_COMPLETE_ACTION = "com.huawei.hidisk.broadcast.GET_NOTICE_CONFIG_COMPLETE";
    public static final String GOTO_BUTTON_FIRST = "button_which1";
    public static final String GOTO_BUTTON_SECOND = "button_which2";
    public static final String GUIDE_SYNC_SWITCH_NOTIFICATION = "guide_sync_switch_notification";
    public static final String HICLOUD_BACKUP = "hicloud_backup";
    public static final String HICLOUD_BACKUP_CLEAR = "hicloud_backup_clear";
    public static final String HICLOUD_BACKUP_DOUBLE_PAGE = "hicloud_backup_double_page";
    public static final String HICLOUD_BACKUP_MANAGER = "hicloud_backup_manager";
    public static final String HICLOUD_BACKUP_OPTION = "hicloud_backup_option";
    public static final String HICLOUD_BACKUP_REMIND_CLOSE = "close_cbs";
    public static final String HICLOUD_BACKUP_REMIND_DELETE = "delete_cbs";
    public static final String HICLOUD_CENTER = "active_center";
    public static final String HICLOUD_CLOSE_BACKUP_REMIND = "close_backup_remind";
    public static final String HICLOUD_DLAPP = "hicloud_dlapp";
    public static final String HICLOUD_GALLERY = "hicloud_gallery";
    public static final String HICLOUD_KA = "ka";
    public static final String HICLOUD_LOGIN = "login";
    public static final String HICLOUD_NPS = "nps";
    public static final String HICLOUD_PPS = "pps";
    public static final String HICLOUD_VOUCHER = "voucher_list";
    public static final String IS_FROM_SPACE_NOTIFY = "from_space_notify";
    public static final String MANAGE = "manage";
    public static final String MANAGE_BACKUP_SIZE = "manage_backup_size";
    public static final long MINUTE_MILLISECOND = 60000;
    public static final String MODIFY_BACKUP_DATA = "modify_backup_data";
    public static final int NOTIFICATION_TO_POP_PACKAGE = 1;
    public static final String NOTIFY_ERROR_CAPACITY = "notify_capacity";
    public static final String NOTIFY_ERROR_CODE = "notify_error_code";
    public static final String NOTIFY_ID_KEY = "notify_id_key";
    public static final String NOTIFY_SHOW = "notification_show";
    public static final String POP_GOTO_BUTTON_FIRST = "button_first";
    public static final String POP_GOTO_BUTTON_SECOND = "button_second";
    public static final String POP_GOTO_BUTTON_THIRD = "button_third";
    public static final long REFRESH_TIME_MILLIS = 200;
    public static final int REGULAR = 100;
    public static final String REMAIND_MODE_NOTIFICATION = "notification";
    public static final String REMAIND_MODE_POPUP = "popup";
    public static final int REQUESTCODE_BACKUP = 0;
    public static final int REQUESTCODE_CLOUDPHOTO = 3;
    public static final int REQUESTCODE_FRONT_APP = 4;
    public static final int REQUESTCODE_PUSH_COMMON = 50;
    public static final int REQUESTCODE_RECOMMEND_CARD_END = 49;
    public static final int REQUESTCODE_RECOMMEND_CARD_START = 10;
    public static final int RISK_RULE_ID = 118;
    public static final String SCHEME_HI_CLOUD = "hicloud";
    public static final String SPACE_AVAILABLE_DAYS_V3 = "space_available_days_v3";
    public static final String SPACE_AVAILABLE_RATIO = "space_available_ratio";
    public static final String SPACE_AVAILABLE_SIZE = "space_available_size";
    public static final String SPACE_DETAIL_NOTIFY_SHOW_TIME = "space_detail_show_time_milli";
    public static final String SPACE_NOTICE_FREQ_COUPON_SUFFIX = "_coupon";
    public static final String SPACE_NOTICE_WITH_ACTIVITY_SP = "space_notice_with_activity_sp";
    public static final String SPACE_QUERY_DETAIL = "cloud_query_detail";
    public static final String SPACE_USED_SIZE = "space_used_size";
    public static final String ST_INVALID_NOTIFY_TIME = "notifytime";
    public static final String TAG = "Constants";
    public static final String THRID_APP_SPACE_INSUFFICIENT = "thirdApp_space_insufficient";
    public static final String TYPE_APPLICATION = "application";
    public static final String TYPE_DEEPLINK = "deeplink";
    public static final String TYPE_DLAPP_AND_ACYIVE = "dlapp_and_active";
    public static final String TYPE_EXTRA_BANNER = "extrabanner";
    public static final String TYPE_FACE_SPAN_FAMILY_HARMONY_HEITI = "HarmonyHeiTi";
    public static final String TYPE_FACE_SPAN_FAMILY_HW_CHINESE_MEDIUM = "HwChinese-medium";
    public static final String TYPE_RECOMMEND_NOTICE = "all_recommend_notice";
    public static final String TYPE_SPACE_NOTICE = "all_space_notice";
    public static final String TYPE_WEB = "web";
    public static final int WORRY_FREE_SPACE_THRESHOLD = 99;
    private static final Map<String, Class<?>> GO_TO_APP_MAPPING = new HashMap();
    private static final Map<String, String> FORCED_UPGRADE_MAPPING = new HashMap();
    public static final String ACTIVITY_POPUP = "activity_popup";
    public static final String DETAIL2 = "detail2";
    public static final String DETAIL3 = "detail3";
    public static final String[] POP_URI_ARRAY = {"close", ACTIVITY_POPUP, "detail", DETAIL2, DETAIL3};

    public interface ACTIVITY {
        public static final int NOTIFICATION_ACTIVITY = 0;
        public static final int NOTIFICATION_V5 = 3;
        public static final int NOTIFICATION_WITH_ACTIVITY = 1;
        public static final int TASK_CENTER = 2;
    }

    public interface Action {
        public static final String ACTION_CLOUDBACKUPCLEAR_ACTIVITY = "com.huawei.android.hicloud.ui.activity.CloudBackupClearActivity";
        public static final String ACTION_DATA_MIGRATION_AUTH_ACTIVITY = "com.huawei.hicloud.action.DataMigrationAuthActivity";
        public static final String ACTION_FORCE_UPGRADE_ACTIVITY = "com.huawei.hicloud.intent.FORCE_UPGRADE_ACTIVITY";
        public static final String ACTION_GALLERYDETAIL_ACTIVITY = "com.huawei.android.hicloud.ui.activity.GalleryDetailActivity";
        public static final String ACTION_MAIN_ACTIVITY = "com.huawei.android.hicloud.ui.activity.MainActivity";
        public static final String ACTION_UPGRADE_EMPTY_ACTIVITY = "com.huawei.hidisk.action.UPGRADE_EMPTY_ACTIVITY";
        public static final String ACTION_UPGRADE_POP_NOTIFICATION_ACTIVITY = "com.huawei.android.hicloud.UPGRADE_POP_NOTIFICATION_ACTIVITY";
        public static final String GALLERY_MAIN_ACTION = "com.huawei.hicloud.action.GALLERY_LOGIN";
        public static final String HICLOUD_PURE_PAGE_WEBVIEW_ACTION = "com.huawei.hicloud.action.PURE_PAGE_WEBVIEW";
        public static final String HICLOUD_WEBVIEW_ACTION = "com.huawei.hicloud.action.SHOW_WEBVIEW";
        public static final String NOTICE_BEFORE_BACKUP_WEBVIEW_ACTION = "com.huawei.hicloud.action.NOTICE_BEFORE_BACKUP";
        public static final String SPACE_CLOUDBACKUP_GUIDE_ACTION = "com.huawei.hicloud.action.CloudBackupSpaceUnEnoughActivity";
        public static final String SPACE_DETAIL_ACTION = "com.huawei.android.ds.SPACE_DETAIL";
        public static final String SPACE_GUIDE_ACTION = "com.huawei.hicloud.action.CloudSpaceGuideActivity";
        public static final String SPACE_INSUFFICIENT_NEW_ACTIVITY_ACTION = "com.huawei.hicloud.action.CloudBackupSpaceInsufficientNewActivity";
        public static final String SPACE_NOTIFY_TIMER_ACTION = "spacenotifyaction";
    }

    public interface ActivityName {
        public static final String ACCOUNT_LOGOUT_ACTIVITY = "AccountLogoutActivity";
        public static final String CHECK_PWD_ACTIVITY = "CheckPwdActivity";
        public static final String FORCED_UPGRADE_ACTIVITY = "ForcedUpgradeActivity";
        public static final String GALLERY_LOGIN_ACTIVITY = "GalleryLoginActivity";
        public static final String HISYNC_EXTERNAL_ACTIVITY = "HisyncExternalActivity";
        public static final String HISYNC_SETTING_ACTIVITY = "NewHiSyncSettingActivity";
        public static final String LOGOUT_PROCESS_ACTIVITY = "LogoutProcessActivity";
        public static final String OPERATION_WEBVIEW_ACTIVITY = "OperationWebViewActivity";
        public static final String STOCK_ACTIVE_ACTIVITY = "StockActiveActivity";
        public static final String STOCK_ACTIVE_POPUP_GUIDE_ACTIVITY = "StockActivePopupGuideActivity";
        public static final String UNIFORM_GUIDE_ACTIVITY = "UniformGuideActivity";
        public static final String UPGRADE_EMPTY_ACTIVITY = "UpgradeEmptyActivity";
        public static final String UPGRADE_POP_NOTIFICATION_ACTIVITY = "UpgradePopNotificationActivity";
    }

    public interface BackupFailNotificationType {
        public static final int NOTIFICATION = 0;
        public static final int NOTIFICATION_V5 = 3;
        public static final int NOTIFICATION_WITH_ACTIVITY = 1;
        public static final int NOTIFICATION_WITH_TASK_CENTER = 2;
    }

    public static class BackupNotificationType {
        public static final String FIELD = "backup_notification_key";
        public static final int SPACE_NOTIFY_PACKAGE_INFO = 8;
        public static final int SPACE_NOT_ENOUGH = 7;
        public static final int SPACE_NOT_ENOUGH_V5 = 9;
        public static final String SP_BACKUP_NOT_COMPLETE_NOTIFY_FLAG = "sp_backup_not_complete_notify_flag";
    }

    public interface Broadcacst {
        public static final String ACTION_PROCESS_FORCE_UPGRADE = "com.huawei.hicloud.actoin.PROCESS_FORCE_UPGRADE";
        public static final String ACTION_PROCESS_FORCE_UPGRADE_FROM_SERVER_CODE = "com.huawei.hicloud.actoin.PROCESS_FORCE_UPGRADE_FROM_SERVER_CODE";
        public static final String ACTION_SHOW_NOTIFY_FOR_ALBUM = "com.huawei.hicloud.actoin.SHOW_NOTIFY_FOR_ALBUM";
        public static final String ACTION_SYNC_LIMIT_CONFIG = "com.huawei.hicloud.actoin.SYNC_LIMIT_CONFIG";
        public static final String FORCE_GRADE_ERROR_CODE = "forceGradeErrorCode";
        public static final String SYNC_LIMIT_CONFIG_DOWNLOAD_MAX_NUM = "downloadMaxNum";
        public static final String SYNC_LIMIT_CONFIG_DOWNLOAD_NUM = "downloadNum";
        public static final String SYNC_LIMIT_CONFIG_UPLOAD_MAX_NUM = "uploadMaxNum";
        public static final String SYNC_LIMIT_CONFIG_UPLOAD_MAX_SIZE = "uploadMaxSize";
    }

    public interface CheckResult {
        public static final int CHECK_DEFAULT = -1;
        public static final int CHECK_FAIL = 1;
        public static final int CHECK_SUCCESS = 0;
    }

    public interface ClearSpaceFrequencyDBFrom {
        public static final String FROM_CLEAR_CLOUD_CONFIG = "clear_cloud_config";
        public static final String FROM_EXIT_ACCOUNT = "exit_account";
        public static final String FROM_GET_LATEST_CONFIG = "get_latest_config";
        public static final String FROM_PROCESS_RISK_CONFIG = "process_risk_config";
    }

    public interface CloudAlbumReleaseSpace {
        public static final String ALBUM_SPACE_SIZE_URI = "content://com.huawei.gallery.provider.GalleryProviderForCloud";
        public static final String KEY_CLEAN_FILE_SIZE = "clean_file_size";
        public static final int MESSAGE_BACK_FILE_SIZE = 100;
        public static final int MESSAGE_BACK_FILE_SIZE_NOT_ENOUGH = 101;
        public static final int MESSAGE_DIRECRT_BACK_FILE_SIZE = 102;
        public static final String METHOD_GET_FILE_SIZE = "getFileSize";
        public static final String METHOD_SYNC_CLOUD_DATA = "syncCloudData";
        public static final String NOTICE_TIMES = "album_release_sapce_notice_times";
        public static final String POP_TIME = "album_release_sapce_notice_pop_time";
        public static final String POP_TYPE = "album_release_sapce_notice_show";
    }

    public interface CloudStorageConstants {
        public static final String AD_NAME_KEY = "ad_id";
    }

    public static class CloudSyncItemReportConstants {
        public static final String LAST_REPORT_TIME = "last_report_time";
        public static final String REPORT_COUNT = "report_count";
        public static final long REPORT_GAP_TIME = 43200000;
        public static final int REPORT_MAX_COUNT = 10;
        public static final String SYNC_ITEM_SHOWN_REPORT_STATUS_SP_NAME = "sync_item_shown_report_sp";
    }

    public interface CommonActionRequestCode {
        public static final String ALARM_ON_RECEIVE_REQUEST_ID = "requestId";
        public static final int GALLERY_NOTICE = 10002;
        public static final int MESSAGE_CENTER_NOTICE = 10005;
        public static final int OPEN_DOUBLE_FRONT_APP_NOTICE = 10006;
        public static final int OPEN_FRONT_APP_NOTICE = 10004;
        public static final int SITE_CHANGE_NOTICE = 10003;
    }

    public interface CommonReportConstants {
        public static final String CHECKLIST_SPLIT = ",";
        public static final String DELETE_BTN_KEY = "btn_delete";
        public static final String DELETE_BTN_TYPE = "btn_type";
        public static final String FAILED = "failed";
        public static final String HAS_LOCAL_DATA = "1";
        public static final String KEY_MODULE_IN_CHECKLIST = "check_list";
        public static final String LOCAL_DATA_CHECK_RESULT = "result";
        public static final String MODULE_NAME = "module_name";
        public static final String NO_LOCAL_DATA = "0";
        public static final String OPERATION_NAME_DELETE_BTN_CLICK = "delete_btn_click";
        public static final String OPERATION_NAME_DELETE_DATA_RESULT = "delete_data_result";
        public static final String OPERATION_NAME_LOCAL_DATA_CHECK = "local_data_check";
        public static final String OPERATION_RESULT = "result";
        public static final String SRC_AD_SWITCH_GET_ABNNER = "getBanner";
        public static final String SRC_AD_SWITCH_QUERY_GUIDE = "queryGuide";
        public static final String SRC_AD_SWITCH_RECOMMEND_CARD = "recommendCard";
        public static final String SRC_QUERY_AD_LIST = "queryAdList";
        public static final String SUCCESS = "success";
    }

    public interface ContentType {
        public static final String NOTICE_CONTENT = "1";
        public static final String NOTICE_CONTENT_DEFAULT = "0";
    }

    public interface DialogMarketRegionStyle {
        public static final int TYPE_ACTIVITY_ENTRY = 5;
        public static final int TYPE_FRONT_APP = 1;
        public static final int TYPE_FRONT_DOUBLE_APP = 7;
        public static final int TYPE_FRONT_ENTRANCE = 2;
        public static final int TYPE_FRONT_ENTRANCE_BY_APP = 3;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_RECOMMOND_PACKAGE = 6;
        public static final int TYPE_RECOMMOND_PACKAGE_BY_APP = 4;
    }

    public interface DialogType {
        public static final int ENABLE_NEW_CARD_TYPE_NO_ICON = 0;
        public static final int ENABLE_NEW_CARD_TYPE_WITH_ICON_AND_NO_PACKAGE = 2;
        public static final int ENABLE_NEW_CARD_TYPE_WITH_ICON_AND_PACKAGE = 1;
    }

    public interface DriveProcess {
        public static final int CURRENT_DRIVE_VERSION = 102;
        public static final int OM_VERSION = 1;
        public static final int ORIGIN_DRIVE_VERSION = 100;
        public static final int SUPPORT_DRIVE_SUBPAGE_VERSION = 1;
    }

    public interface EnableActivityEntry {
        public static final int CLOSE = 0;
        public static final int OPEN = 1;
    }

    public interface EnableNewCard {
        public static final int CLOSE = 0;
        public static final int NEW_OPEN = 2;
        public static final int OPEN = 1;
    }

    public interface EnableRecomPackages {
        public static final int CLOSE = 0;
        public static final int OPEN = 1;
    }

    public static final class EnterType {
        public static final int NOTIFICATION = 0;
    }

    /* renamed from: com.huawei.hicloud.notification.constants.NotifyConstants$FA */
    public interface InterfaceC4908FA {
        public static final String ACTIVITY_MAIN_ABILITY = "com.huawei.hidisk.fa.MainAbility";
        public static final String MAIN_ABILITY = "MainAbility";
        public static final String PACKAGE_NAME = "com.huawei.hidisk.fa";
    }

    public interface FamilyShare {
        public static final String SCHEME = "hwid://com.huawei.hwid/FamilyShare";
        public static final String URI = "family_share";
    }

    public interface FrontAppConstant {
        public static final int CLOSE = 0;
        public static final int MSG_LOAD_DOUBLE_ICON_FAIL = 4;
        public static final int MSG_LOAD_DOUBLE_ICON_SUCCESS = 3;
        public static final int MSG_LOAD_IMAGE_FAIL = 2;
        public static final int MSG_LOAD_IMAGE_SUCCESS = 1;
        public static final int OPEN = 1;
        public static final String STYLE_FRONT_APP = "app";
        public static final String STYLE_FRONT_ENTRANCE = "entry";
    }

    public interface H5BackupNotEnoughNoticeKey {
        public static final String ACTIVE_POP_BUTTON_FIRST = "active_pop_button_first";
        public static final String ACTIVE_POP_BUTTON_SECOND = "active_pop_button_second";
        public static final String ACTIVE_POP_MAIN_TEXT = "active_pop_main_text";
        public static final String ACTIVE_POP_TITLE = "active_pop_title";
        public static final String BACKUP_COUPON_NOTI_DESCRIPTION = "backup_coupon_noti_description";
        public static final String BACKUP_COUPON_NOTI_MAIN_TEXT = "backup_coupon_noti_main_text";
        public static final String BACKUP_COUPON_NOTI_TITLE = "backup_coupon_noti_title";
        public static final String BACKUP_COUPON_POPUP_BUTTON2_FIRST = "backup_coupon_popup_button2_first";
        public static final String BACKUP_COUPON_POPUP_BUTTON2_SECOND = "backup_coupon_popup_button2_second";
        public static final String BACKUP_COUPON_POPUP_BUTTON_FIRST = "backup_coupon_popup_button_first";
        public static final String BACKUP_COUPON_POPUP_BUTTON_SECOND = "backup_coupon_popup_button_second";
        public static final String BACKUP_COUPON_POPUP_BUTTON_THIRD = "backup_coupon_popup_button_third";
        public static final String BACKUP_COUPON_POPUP_DESCRIPTION = "backup_coupon_popup_description";
        public static final String BACKUP_COUPON_POPUP_DESCRIPTION_SECOND = "backup_coupon_popup_description_second";
        public static final String BACKUP_COUPON_POPUP_MAIN_TEXT = "backup_coupon_popup_main_text";
        public static final String BACKUP_COUPON_POPUP_TITLE = "backup_coupon_popup_title";
        public static final String BACKUP_COUPON_V3_MAIN_TEXT = "backup_coupon_v3_main_text";
        public static final String BACKUP_COUPON_V4_MAIN_TEXT = "backup_coupon_v4_main_text";
        public static final String BACKUP_COUPON_V4_POPUP_TITLE = "backup_coupon_v4_popup_title";
        public static final String BACKUP_NOTI_DESCRIPTION = "backup_noti_description";
        public static final String BACKUP_NOTI_MAIN_TEXT = "backup_noti_main_text";
        public static final String BACKUP_NOTI_TITLE = "backup_noti_title";
        public static final String BACKUP_POP_BUTTON2_FIRST = "backup_pop_button2_first";
        public static final String BACKUP_POP_BUTTON2_SECOND = "backup_pop_button2_second";
        public static final String BACKUP_POP_BUTTON3_FIRST = "backup_pop_button3_first";
        public static final String BACKUP_POP_BUTTON3_SECOND = "backup_pop_button3_second";
        public static final String BACKUP_POP_BUTTON3_THIRD = "backup_pop_button3_third";
        public static final String BACKUP_POP_BUTTON_FIRST = "backup_pop_button_first";
        public static final String BACKUP_POP_BUTTON_SECOND = "backup_pop_button_second";
        public static final String BACKUP_POP_BUTTON_THIRD = "backup_pop_button_third";
        public static final String BACKUP_POP_DESCRIPTION = "backup_pop_description";
        public static final String BACKUP_POP_DESCRIPTION_SECOND = "backup_pop_description_second";
        public static final String BACKUP_POP_MAIN_TEXT = "backup_pop_main_text";
        public static final String BACKUP_POP_STANDBY_BUTTON3_FIRST = "backup_pop_standby_button3_first";
        public static final String BACKUP_POP_STANDBY_BUTTON3_SECOND = "backup_pop_standby_button3_second";
        public static final String BACKUP_POP_STANDBY_BUTTON3_THIRD = "backup_pop_standby_button3_third";
        public static final String BACKUP_POP_TITLE = "backup_pop_title";
        public static final String BACKUP_V3_MAIN_TEXT = "backup_v3_main_text";
        public static final String BACKUP_V4_MAIN_TEXT = "backup_v4_main_text";
        public static final String BACKUP_V4_POP_TITLE = "backup_v4_pop_title";
        public static final String BACKUP_V5_MAIN_TEXT = "backup_v5_main_text";
        public static final String BACKUP_V5_POP_BUTTON_FIRST = "backup_v5_pop_button_first";
        public static final String BACKUP_V5_POP_BUTTON_SECOND = "backup_v5_pop_button_second";
        public static final String BACKUP_V5_POP_TITLE = "backup_v5_pop_title";
        public static final String FRONTAPP_DOUBLE_BUTTON = "frontapp_double_button";
        public static final String FRONTAPP_DOUBLE_NOTIFYBAR = "frontapp_double_notifybar";
        public static final String FRONTAPP_DOUBLE_NOTIFYBAR_TITLE = "frontapp_double_notifybar_title";
        public static final String FRONTAPP_DOUBLE_TEXT = "frontapp_double_text";
        public static final String FRONTAPP_DOUBLE_TEXT_SECOND = "frontapp_double_text_second";
        public static final String FRONTAPP_DOUBLE_TITLE = "frontapp_double_title";
        public static final String FRONTAPP_ENTRANCE_TEXT_SECOND = "frontapp_entrance_text_second";
        public static final String FRONTAPP_ENTRANCE_V2_BUTTON = "frontapp_entrance_v2_button";
        public static final String FRONTAPP_ENTRANCE_V2_TEXT = "frontapp_entrance_v2_text";
        public static final String FRONTAPP_SINGLE_TEXT = "frontapp_single_text";
        public static final String FRONTAPP_SINGLE_TEXT_SECOND = "frontapp_single_text_second";
        public static final String FRONTAPP_SINGLE_TITLE = "frontapp_single_title";
        public static final String FRONTAPP_UNMATCH_V2_TEXT = "frontapp_unmatch_v2_text";
        public static final String FRONT_APP_ENTRANCE_TEXT = "frontapp_entrance_text";
        public static final String FRONT_APP_GUIDE_TEXT = "frontapp_guide_text";
        public static final String FRONT_APP_NOTIFY_BAR_TEXT = "frontapp_notifybar_text";
        public static final String FRONT_APP_NOTIFY_BAR_TITLE = "frontapp_notifybar_title";
        public static final String FRONT_APP_OPEN_TEXT = "frontapp_open_text";
        public static final String FRONT_APP_OPEN_TITLE = "frontapp_open_title";
        public static final String FRONT_APP_UNMATCH_TEXT = "frontapp_unmatch_text";
        public static final String RECOMMEND_DETAIL_LINK1 = "recommend_detail_link1";
    }

    public interface H5GuideDialog {
        public static final String BUY_EXIT_DATA = "buy_exit_data";
        public static final String CANCEL_SUB_WEB_VIEW_LOAD_FAIL = "cancel_sub_web_view_load_fail";
        public static final String CANCEL_SUB_WEB_VIEW_OK = "cancel_sub_web_view_load_ok";
        public static final String GUIDE_WEBVIEW_DIALOG_ID = "guide_webview_dialog_id";
        public static final String GUIDE_WEBVIEW_JS = "guide_webview_js";
        public static final String GUIDE_WEBVIEW_LOAD_DATA = "guide_webview_load_data";
        public static final String GUIDE_WEBVIEW_LOAD_FAIL = "guide_webview_load_fail";
        public static final String GUIDE_WEBVIEW_LOAD_OK = "guide_webview_load_ok";
        public static final String H5_GUIDE_DIALOG_EXCEPTION = "h5_guide_dialog_exception";
        public static final String H5_GUIDE_DIALOG_ONBACK_CHECK = "h5_guide_dialog_onback_check";
        public static final String H5_GUIDE_QUERY_CONFIG_FAIL_VERSIONCODE = "h5_guide_query_config_fail_versioncode";
        public static final String H5_GUIDE_QUERY_END = "h5_guide_query_end";
        public static final String H5_GUIDE_QUERY_FIRST_CONDITION_CHECK = "h5_guide_query_first_condition_check";
        public static final String H5_GUIDE_QUERY_START = "h5_guide_query_start";
        public static final String HOMEPAGE_ENTRY_DATA = "homepage_entry_data";
        public static final String HOMEPAGE_EXIT_DATA = "homepage_exit_data";
        public static final String OM_FILE_PARSE_RESULT = "om_file_parse_result";
        public static final String RECOMMNED_EXIT_DATA = "recommend_exit_data";
        public static final String SPACE_UPDATE_GET_SPACE_INFO = "space_update_get_space_info";
    }

    public interface H5SpaceNoticeStringKey {
        public static final String ALMOST_MAIN_TEXT = "almost_main_text";
        public static final String ALMOST_TITLE = "almost_title";
        public static final String FULL_MAIN_TEXT = "full_main_text";
        public static final String FULL_TITLE = "full_title";
        public static final String HOMEPAGE_BANNER_BUTTON = "homepage_banner_button";
        public static final String HOMEPAGE_BANNER_BUTTON_1201 = "homepage_banner_button_1201";
        public static final String HOMEPAGE_BANNER_DESCRIPTION = "homepage_banner_description";
        public static final String HOMEPAGE_BANNER_DESCRIPTION_1201 = "homepage_banner_description_1201";
        public static final String HOMEPAGE_BANNER_REMARK = "homepage_banner_remark";
        public static final String HOMEPAGE_BANNER_REMARK_1201 = "homepage_banner_remark_1201";
        public static final String HOMEPAGE_BANNER_TITLE = "homepage_banner_title";
        public static final String HOMEPAGE_BANNER_TITLE_1201 = "homepage_banner_title_1201";
        public static final String HOMEPAGE_NOTIFYBAR_DESCRIPTION = "homepage_notifybar_description";
        public static final String HOMEPAGE_NOTIFYBAR_TITLE = "homepage_notifybar_title";
        public static final String INSUFFICIENT_MAIN_TEXT = "insufficient_main_text";
        public static final String INSUFFICIENT_TITLE = "insufficient_title";
    }

    public interface Keys {
        public static final String NOTIFY_TYPE = "notifyType";
        public static final String NOTIFY_URI = "notifyUri";
    }

    public interface MarketingConstant {
        public static final String ADID_KEY = "adId";
        public static final String CID_KEY = "cId";
        public static final String CSOURCE_KEY = "cSource";
        public static final int CSOURCE_VALUE_BACKUP_FAIL_NOTIFICATION_POPUP = 411;
        public static final int CSOURCE_VALUE_SPACE_NOT_ENOUGH = 401;
        public static final int CSOURCE_VALUE_UPGRADE = 2;
    }

    public interface MashupKey {
        public static final String BC_SILENCEDEVICE_COUNT = "bc.silencedevice.count";
        public static final String BC_SILENCEDEVICE_REMAINDAYS = "bc.silencedevice.remaindays";
        public static final String BS_MEMBER_REMAIN_DAYS = "bs.member.remain.days";
        public static final String BS_REMAIN_DAYS = "bs.userdata.remainDays";
        public static final String BS_USERDATA_REMAIN_DWNLD1DAYS = "bs.userdata.remain.dwnld1Days";
    }

    public interface NegFeedback {
        public static final int DEFAULT_LIMIT = 360;
        public static final int DEFAULT_STEP = 10;
    }

    public interface NotificationActivityType {
        public static final int ACTIVES_TYPE = 1;
        public static final int DL_ACTIVES = 6;
        public static final int FIFTEEN_GB_TYPE = 2;
        public static final int FIFTY_GB_TYPE = 3;
        public static final int PUSH_MARKETING_NOTICE_TYPE = 4;
    }

    public interface NotificationBIReport {
        public static final String BI_EVENT_ACTIVITY_DAYONECE_CHECK_FAIL = "activity_dayonce_check_fail";
        public static final String BI_EVENT_AUTO_BACKUP_ACTIVITY_DAYONECE_CHECK_FAIL = "auto_backup_activity_dayonce_check_fail";
        public static final String BI_EVENT_AUTO_BACKUP_DAYONECE_CHECK_FAIL = "auto_backup_dayonce_check_fail";
        public static final String BI_EVENT_AUTO_BACKUP_TASK_CENTER_CHECK_FAIL = "auto_backup_task_center_check_fail";
        public static final String BI_EVENT_DAYONECE_CHECK_FAIL = "dayonce_check_fail";
        public static final String BI_EVENT_FULL_FREQ_CHECK_FAIL = "full_freq_check_fail";
        public static final String BI_EVENT_NOTICE_CHECK_EXCEPTION = "notice_check_exception";
        public static final String BI_OM_BLACK_INHIBITED = "om_black_inhibited";
        public static final String BI_PARAM_FAILED_NOTICE_INFO = "failed_notice_info";
        public static final String BI_PARAM_IS_FROM_ALBUM = "is_from_album";
        public static final String BLACK_INHIBITED_DIALOG_TYPE = "black_inhibited_dialog_type";
        public static final String BLACK_INHIBITED_USER_TAG = "black_inhibited_user_tag";
    }

    public interface NotificationReport {
        public static final String BACKUP_FAIL_NOTI_ACTIVITY_OFF_CONDITION = "0015";
        public static final String BACKUP_FAIL_NOTI_OFF_CONDITION = "0016";
        public static final String EVENT_BACKUP_FAIL_DIALOG_MUTED = "backup_fail_dialog_muted";
        public static final String EVENT_BACKUP_FAIL_DIALOG_MUTED_SHOW_CONDITION = "backup_fail_dialog_muted_show_condition";
        public static final String EVENT_GET_FREE_PACKAGE_FAIL = "get_free_package_fail";
        public static final String EVENT_GET_FREE_PACKAGE_SUCCESS = "get_free_package_success";
        public static final String EVENT_NAME_ACTIVITY_BACKUP_FAILED_NOTIFICATION_SHOW = "0007";
        public static final String EVENT_NAME_ACTIVITY_BACKUP_FAILED_POPUP_SHOW = "0014";
        public static final String EVENT_NAME_ACTIVITY_BACKUP_PREPARE_NOTIFICATION = "0008";
        public static final String EVENT_NAME_AUTO_ACTIVITY_BACKUP_FAILED = "0005";
        public static final String EVENT_NAME_AUTO_BACKUP_FAILED = "0001";
        public static final String EVENT_NAME_BACKUP_CYCLE_NOTI_SHOW_FAILED = "0017";
        public static final String EVENT_NAME_BACKUP_FAILED_NOTIFICATION_SHOW = "0003";
        public static final String EVENT_NAME_BACKUP_FAILED_POPUP_SHOW = "0004";
        public static final String EVENT_NAME_BACKUP_FAILED_POPUP_SHOW_FAILED = "0015";
        public static final String EVENT_NAME_CALLLBACK_NUM = "event_name_calllback_num";
        public static final String EVENT_NAME_CHECK_SPACE_AVAILABLE_DAYS = "0006";
        public static final String EVENT_NAME_CHECK_SPACE_AVAILABLE_SIZE = "0003";
        public static final String EVENT_NAME_CHECK_SPACE_CLOUDPHOTO_INSUFFICIENT = "0005";
        public static final String EVENT_NAME_CHECK_SPACE_RATIO = "0002";
        public static final String EVENT_NAME_CHECK_SPACE_USED_SIZE = "0004";
        public static final String EVENT_NAME_CLOUD_SPACE_CHECK_RESULT = "0018";
        public static final String EVENT_NAME_DAILY_JOB_BY_APP_ALREADY_SET = "daily_job_by_app_already_set";
        public static final String EVENT_NAME_DAILY_JOB_BY_APP_EXECUTE_IN_TIME = "event_name_daily_job_by_app_execute_in_time";
        public static final String EVENT_NAME_DAILY_JOB_EXECUTE_TASK = "daily_job_execute_task";
        public static final String EVENT_NAME_DAILY_JOB_EXECUTE_TASK_FAILED = "daily_job_execute_task_failed";
        public static final String EVENT_NAME_DAILY_JOB_LAST_TIME_EXIST = "daily_job_last_time_EXIST";
        public static final String EVENT_NAME_DAILY_JOB_LAST_TIME_NOT_EXIST = "daily_job_last_time_NOT_EXIST";
        public static final String EVENT_NAME_DAILY_JOB_START_FAIL = "daily_job_start_fail";
        public static final String EVENT_NAME_DAILY_JOB_START_INFORMATION = "daily_job_start_information";
        public static final String EVENT_NAME_DAILY_OTHER_OPRATION_CHECK_HAVE_LEGAL_DIALOG = "daily_other_opration_check_have_legal_dialog";
        public static final String EVENT_NAME_DAILY_OTHER_OPRATION_CHECK_IS_NEED_PROCESS = "daily_other_opration_check_is_need_process";
        public static final String EVENT_NAME_DAILY_OTHER_OPRATION_CHECK_IS_TRANS_NOW = "daily_other_opration_check_is_trans_now";
        public static final String EVENT_NAME_DAILY_OTHER_OPRATION_CHECK_NO_LEGAL_DIALOG = "daily_other_opration_check_no_legal_dialog";
        public static final String EVENT_NAME_DELAY_TIMER_CHECK_SUCCESS = "delay_timer_check_success";
        public static final String EVENT_NAME_GET_CLOUD_SPACE = "0001";
        public static final String EVENT_NAME_LEVEL_CONTROL_POLICY_ID = "reach_remind_policy_id";
        public static final String EVENT_NAME_LEVEL_CONTROL_POLICY_NAME = "reach_remind_policy_name";
        public static final String EVENT_NAME_LEVEL_CONTROL_RESULT = "reach_remind_result";
        public static final String EVENT_NAME_LEVEL_CONTROL_SCENES = "reach_remind_scenes_id";
        public static final String EVENT_NAME_LEVEL_CONTROL_TYPE = "reach_remind_type";
        public static final String EVENT_NAME_LEVEL_CONTROL_TYPE_VALUE = "reach_remind_type_value";
        public static final String EVENT_NAME_MANUAL_ACTIVITY_BACKUP_FAILED = "0006";
        public static final String EVENT_NAME_MANUAL_BACKUP_FAILED = "0002";
        public static final String EVENT_NAME_PPS_AD_LOADER_CHECK = "0009";
        public static final String EVENT_NAME_SPACE_ACTIVITY_NOTIFICATION_FAILED = "0010";
        public static final String EVENT_NAME_SPACE_ACTIVITY_NOTIFICATION_SHOW = "0011";
        public static final String EVENT_NAME_SPACE_NOTICE_ACTIVITY_FINAL_SHOW = "space_notice_activity_final_show";
        public static final String EVENT_NAME_SPACE_NOTICE_EXCEPTION = "space_notice_exception";
        public static final String EVENT_NAME_SPACE_NOTICE_FINAL_SHOW = "space_notice_final_show";
        public static final String EVENT_NAME_SPACE_NOTIFICATION_FAIL = "0012";
        public static final String EVENT_NAME_SPACE_NOTIFICATION_SHOW = "0013";
        public static final String EVENT_NAME_SPACE_USE_NOTI_SHOW_FAILED = "0016";
        public static final String EVENT_NAME_START_DELAY_TIMER = "start_delay_timer";
        public static final String EVENT_NAME_SUPPRESSED_NOTICE_TYPE = "suppressed_notice_type";
        public static final String EVENT_NAME_TRIGGER_SRC_ALBUM = "0002";
        public static final String EVENT_NAME_TRIGGER_SRC_CLOUD_BACKUP = "0004";
        public static final String EVENT_NAME_TRIGGER_SRC_DAILY_CHECK = "0005";
        public static final String EVENT_NAME_TRIGGER_SRC_DATA_USE = "0003";
        public static final String EVENT_NAME_TRIGGER_SRC_HIDISK = "0001";
        public static final String EVENT_NAME_WISEMARKETING_SERVICE_REFRESH = "0021";
        public static final String EVENT_NAME_WISEMARKETING_SERVICE_REQEUST = "0019";
        public static final String EVENT_NAME_WISEMARKETING_SERVICE_RESPONSE = "0020";
        public static final String EVENT_NAME_WISEMARKETING_SHARE_APP = "0023";
        public static final String EVENT_NAME_WISEMARKETING_WITELIST_CHECK = "0022";
        public static final String EVENT_NOTICE_NEG_FREQ_CHECK_FAIL = "neg_freq_check_fail";
        public static final String KEY_AUTO_BACKUP_NOTICE_DELAY_EVENT = "auto_backup_notice_delay_event";
        public static final String KEY_BACKUP_NOTICE_NEED_DATA = "backup_notice_need_data";
        public static final String KEY_BACKUP_NOTIFY_FREQUENCY_CHECK = "cloud_backup_frequency_check";
        public static final String KEY_CLEAR_FREQ_FROM = "clear_frequency_from";
        public static final String KEY_CURRENT_VALUE = "current_value";
        public static final String KEY_DAILY_JOB_BY_APP_CURRENT_TIME = "daily_job_by_app_current_time";
        public static final String KEY_DAILY_JOB_BY_APP_DURATION = "daily_job_by_app_duration";
        public static final String KEY_DAILY_JOB_BY_APP_LAST_DURATION = "daily_job_by_app_last_duration";
        public static final String KEY_DAILY_JOB_BY_APP_MIN_LATENCY = "daily_job_by_app_min_latency";
        public static final String KEY_DAILY_JOB_LATENCY_TIME = "daily_job_latency_time";
        public static final String KEY_DAILY_JOB_RETCODE = "daily_job_retcode";
        public static final String KEY_DAILY_JOB_SOURCE = "daily_job_source";
        public static final String KEY_DELAY_RANDOM_TIME = "delay_random_time";
        public static final String KEY_DETAIL = "detail";
        public static final String KEY_EVENT_NAME = "event_name";
        public static final String KEY_INFORMATION = "information";
        public static final String KEY_IS_FROM_ALBUM = "is_from_album";
        public static final String KEY_LAST_SPACE_NOTICE_CHECKING = "last_space_notice_checking";
        public static final String KEY_LAST_SPACE_NOTICE_CHECK_TIME = "last_space_notice_check_time";
        public static final String KEY_LAST_SPACE_NOTICE_PROCESS_ID = "last_space_notice_process_id";
        public static final String KEY_LESS_THAN = "less_than";
        public static final String KEY_MORE_THAN = "more_than";
        public static final String KEY_NOTICE_TYPE = "notice_type";
        public static final String KEY_NOTI_NAME = "notice_name";
        public static final String KEY_NO_BACKUP_WEEKS = "no_backup_weeks";
        public static final String KEY_ORDER = "order";
        public static final String KEY_RESOURCE_ID = "resource_id";
        public static final String KEY_RESULT = "result";
        public static final String KEY_RULE_TYPE = "rule_type";
        public static final String KEY_SPACE_CHECK_MAX = "space_check_max";
        public static final String KEY_SPACE_CHECK_RESULT = "space_check_result";
        public static final String KEY_SPACE_CHECK_SERVICE_COUNTRY = "space_check_service_country";
        public static final String KEY_SPACE_CHECK_TOTAL = "space_check_total";
        public static final String KEY_SPACE_CHECK_USED = "space_check_used";
        public static final String KEY_SPACE_CID = "space_activity_id";
        public static final String KEY_SPACE_CTYPE = "space_activity_type";
        public static final String KEY_SPACE_INFO = "space_info";
        public static final String KEY_SPACE_NOTICE_DELAY_EVENT = "space_notice_delay_event";
        public static final String KEY_SPACE_NOTI_FROM_ALBUM = "space_noti_from_album";
        public static final String KEY_TOTAL_NEED_SPACE = "total_need_space";
        public static final String MAIN_PROCESS_ID = "main_process_id";
        public static final String NOTI_TYPE_BACKUP_CYCLE = "NOTI_TYPE_BACKUP_CYCLE";
        public static final String NOTI_TYPE_BACKUP_SPACE_INSUFFICIENT = "NOTI_TYPE_BACKUP_SPACE_INSUFFICIENT";
        public static final String NOTI_TYPE_BACKUP_SPACE_INSUFFICIENT_ACTIVITY = "NOTI_TYPE_BACKUP_SPACE_INSUFFICIENT_ACTIVITY";
        public static final String NOTI_TYPE_SPACE_NOTIFY = "NOTI_TYPE_SPACE_NOTIFY";
        public static final String NOTI_TYPE_SPACE_USED = "NOTI_TYPE_SPACE_USED";
        public static final int ONE_DAY = 1;
        public static final String OPERATION_AUTO_BACKUP_NOTICE_DELAY = "auto_backup_notice_delay";
        public static final String OPERATION_DAILY_JOB_MANAGER = "daily_job_manager";
        public static final String OPERATION_DAILY_OTHER_OPRATION_CHECK = "daily_other_opration_check";
        public static final String OPERATION_FREQ_CONTROL_SUPPRESS = "freq_control_suppress";
        public static final String OPERATION_LEVEL_FREQ_CONTROL = "Reach_remind_control";
        public static final String OPERATION_NAME_ALL_SWITCH_OFF = "switch_check_all_off";
        public static final String OPERATION_NAME_AUTO_BACKUP_EXECUTE = "auto_backup_execute";
        public static final String OPERATION_NAME_BACKUP_CYCLE_CHECK = "backup_cycle_check";
        public static final String OPERATION_NAME_CLOUD_BACKUP_FREQUENCY = "cloud_backup_frequency";
        public static final String OPERATION_NAME_CLOUD_BACKUP_NO_SPACE = "cloud_backup_no_space";
        public static final String OPERATION_NAME_CLOUD_NO_SPACE = "cloud_no_space";
        public static final String OPERATION_NAME_H5_CANCEL_SUBSCRIPTION_OPERATION = "h5_cancel_subscription_operation";
        public static final String OPERATION_NAME_H5_GUIDE_DIALOG_OPERATION = "h5_guide_dialog_operation";
        public static final String OPERATION_NAME_INVOKE_NOTIFY_EVENT = "invoke_notify_event";
        public static final String OPERATION_NAME_LAST_CLOUD_NO_SPACE = "last_cloud_no_space";
        public static final String OPERATION_NAME_PPS_AD_LOADER_CHECK = "pps_ad_loader_check";
        public static final String OPERATION_NAME_PREPARE_ACTIVITY_NO_SPACE = "prepare_activity_no_space";
        public static final String OPERATION_NAME_SPACE_CHECK = "space_check";
        public static final String OPERATION_NAME_SPACE_NOTIFY_OPERATOR_CLEAR = "space_notify_operator_clear";
        public static final String OPERATION_NAME_SPACE_OVER_MAX = "switch_check_over_max";
        public static final String OPERATION_NAME_SPACE_USE_CHECK = "space_use_check";
        public static final String OPERATION_NAME_TRIGGER_SRC_CHECK = "trigger_src_check";
        public static final String OPERATION_NAME_WISEMARKETING_OPERATION = "wisemarketing_operation";
        public static final String OPERATION_SPACE_NOTICE_DELAY = "space_notice_delay";
        public static final String PARAM_BACKUP_FAIL_DIALOG_MUTED_DELAY_SCENE = "backup_fail_dialog_muted_delay_scene";
        public static final String PARAM_BACKUP_FAIL_DIALOG_MUTED_SCENE = "backup_fail_dialog_muted_scene";
        public static final String PARAM_BACKUP_FAIL_DIALOG_MUTED_SHOW_CONTITION_IS_HOME = "backup_fail_dialog_muted_show_condition_is_home";
        public static final String PARAM_BACKUP_FAIL_DIALOG_MUTED_SHOW_CONTITION_SCREEN_STATUS = "backup_fail_dialog_muted_show_condition_screen_status";
        public static final String PARAM_BACKUP_FAIL_DIALOG_MUTED_TYPE = "backup_fail_dialog_muted_type";
        public static final String PARAM_DESCRIPTION = "description";
        public static final String PARAM_ERROR_CODE = "error_code";
        public static final String PARAM_NEG_NOTIFY_COUNT = "neg_notify_count";
        public static final String PARAM_NEG_NOTIFY_ID = "neg_notify_id";
        public static final String PARAM_NEG_NOTIFY_TYPE = "neg_notify_type";
        public static final String PARAM_WEBVIEW_CURRENT_HOST = "webview_current_host";
        public static final String PARAM_WEBVIEW_CURRENT_URL = "webview_current_url";
        public static final String PARAM_WEBVIEW_SHARE_APP = "webview_share_app";
        public static final String PARAM_WEBVIEW_WHITE_LIST = "webview_white_list";
        public static final String PARAM_WEBVIEW_WHITE_LIST_CHECK_RESULT = "webview_white_list_check_result";
        public static final String PARAM_WISEMARKETING_CMD = "cmd";
        public static final String PARAM_WISEMARKETING_METHOED = "method";
        public static final String PARAM_WISEMARKETING_REFRESH_SERVICE_COUNTRY_OPERATION = "refresh_service_country_operation";
        public static final String PARAM_WISEMARKETING_REFRESH_SERVICE_COUNTRY_RESULT = "refresh_service_country_result";
        public static final String PARAM_WISEMARKETING_REFRESH_SERVICE_ORIGIN_RESULT_CODE = "service_response_origin_result_code";
        public static final String PARAM_WISEMARKETING_REFRESH_SERVICE_RESPONSE = "service_response";
        public static final String PARAM_WISEMARKETING_REFRESH_SERVICE_RESPONSE_RESULT_CODE = "service_response_response_result_code";
        public static final String PARAM_WISEMARKETING_REQUEST_BODY = "requestBody";
        public static final String PARAM_WISEMARKETING_SERVICETYPE = "serviceType";
        public static final String PARAM_WISEMARKETING_TRACE_ID = "user_service_traceId";
        public static final int RANDOM_BOUND = 10000;
        public static final String RESULT_NAME_BACKUP_CYCLE_FAIL_BACKUP_NOTI = "0019";
        public static final String RESULT_NAME_BACKUP_CYCLE_FAIL_FREQ = "0022";
        public static final String RESULT_NAME_BACKUP_CYCLE_FAIL_OFF_CONDITION = "0021";
        public static final String RESULT_NAME_BACKUP_CYCLE_FAIL_RULE = "0020";
        public static final String RESULT_NAME_CLOUD_SPACE_FAIL_ALBUM_FREQ = "0023";
        public static final String RESULT_NAME_CLOUD_SPACE_FAIL_FULL_FREQ = "0024";
        public static final String RESULT_NAME_CLOUD_SPACE_FAIL_SWITCH_CLOSE = "0025";
        public static final String RESULT_NAME_FREQUENCY_CHECK_FAILED = "0002";
        public static final String RESULT_NAME_NOTIFICATION_ACTIVITY_NOT_SUPPORT = "0004";
        public static final String RESULT_NAME_NOTIFICATION_NOT_SUPPORT_FAMILY_MEMBER = "0012";
        public static final String RESULT_NAME_NOTIFICATION_NULL = "0001";
        public static final String RESULT_NAME_NOTIFICATION_POPUP_BUTTON_COUNT = "0011";
        public static final String RESULT_NAME_NOTIFICATION_PPS_CHECK_FAIL = "0009";
        public static final String RESULT_NAME_NOTIFICATION_PPS_CHECK_RESULT = "0010";
        public static final String RESULT_NAME_NOTIFICATION_PREPARE_ACTIVITY_NULL = "0005";
        public static final String RESULT_NAME_NOTIFICATION_RECOMMEND_ACTIVITY_NULL = "0008";
        public static final String RESULT_NAME_NOTIFICATION_RECOMMEND_PARAM_LIST_NULL = "0007";
        public static final String RESULT_NAME_NOTIFICATION_SPECIFIC_ACTIVITY_NULL = "0006";
        public static final String RESULT_NAME_SPACE_CHECK_SATISFY_FAILED = "0014";
        public static final String RESULT_NAME_SPACE_RANGE_CHECK_FAILED = "0013";
        public static final String RESULT_NAME_SPACE_USE_FAIL_CHECK_RULE = "0017";
        public static final String RESULT_NAME_SPACE_USE_FAIL_OFF_CONDITION = "0018";
        public static final String RESULT_NAME_USER_TAG_CHECK_FAILED = "0028";
        public static final String RESULT_NAME_WISEMARKETING_FAIL = "0027";
        public static final String RESULT_NAME_WISEMARKETING_SUC = "0026";
        public static final String RESULT_SUCCESS = "0003";
        public static final String SOURCE_DAILY_JOB = "daily_job";
        public static final String SOURCE_DAILY_JOB_BY_APP = "daily_job_by_app";
        public static final String SOURCE_DAILY_JOB_INSTANTLY = "daily_job_instantly";
        public static final String SOURCE_DELAY_JOB = "delay_job";
        public static final String SOURCE_RETRY_JOB_INTERNAL = "retry_job_internal";
        public static final String SP_KEY_NOTIFICATION_CHECK_TIME = "notification_check_time";
        public static final String SP_NAME_NOTIFICATION_REPORT = "notification_report";
        public static final String TRACE_ID = "trace_id";
        public static final String VALUE_BACKUP_ACTIVITY_CHECK = "backup_activity_check";
        public static final String VALUE_BACKUP_ACTIVITY_CHECK_TIMER = "backup_activity_check_timer";
        public static final String VALUE_BACKUP_ACTIVITY_SCREEN_PRESENT_CHECK = "backup_activity_screen_present_check";
        public static final String VALUE_BACKUP_ACTIVITY_TASK_CHECK = "backup_activity_task_check";
        public static final String VALUE_BACKUP_ACTIVITY_TASK_CHECK_TIMER = "backup_activity_task_check_timer";
        public static final String VALUE_BACKUP_ACTIVITY_TASK_SCREEN_PRESENT_CHECK = "backup_activity_task_screen_present_check";
        public static final String VALUE_BACKUP_CHECK = "backup_check";
        public static final String VALUE_BACKUP_CHECK_TIMER = "backup_check_timer";
        public static final String VALUE_BACKUP_SCREEN_PRESENT_CHECK = "backup_screen_present_check";
    }

    public interface NotificationType {
        public static final String CLOUDPHOTO_SYNC_SPACE_INSUFFICIENT = "cloudphoto_sync_space_insufficient";
        public static final String REMAIND_MODE_NOTIFICATION = "notification";
    }

    public interface NotificationUserType {
        public static final String DETAIL = "detail";
        public static final String DETAIL_MEMBER = "detail_member";
    }

    public interface NotifySpaceType {
        public static final int ALMOST_SPACE = 2;
        public static final int FULL_SPACE = 1;
        public static final int INSUFFICIENT_SPACE = 0;
    }

    public interface NotifyTimerSpValues {
        public static final String AUTO_BACKUP_NOTIFY_TIMER_START = "auto_backup_notify_timer_start";
        public static final String BACKUP_GALLERY_NUM = "backup_gallery_num";
        public static final String BACKUP_IS_FAMILY_SHARE = "backup_is_family_share";
        public static final String BACKUP_NEED_SPACE = "backup_need_space";
        public static final String BACKUP_NOT_USED_SPACE = "backup_not_used_space";
        public static final String BACKUP_TOTAL_NEED_SPACE = "backup_total_need_space";
        public static final String BACKUP_TOTAL_SPACE = "backup_total_space";
        public static final String BACKUP_USED_SPACE = "backup_used_space";
        public static final String NOTI_TIMER_SP_NAME = "notify_timer_sp";
        public static final String SPACE_NOTIFY_IS_FROM_ALBUM = "space_notify_is_from_album";
        public static final String SPACE_NOTIFY_TIMER_START = "space_notify_timer_start";
        public static final String SPACE_NOTIFY_TOTAL_NEED_SPACE = "space_notify_total_need_space";
    }

    public interface RecommendNeedDataKey {
        public static final String RECOMMEND_NEED_DATA_KEY = "recommend_need_data_key";
    }

    public interface Report {
        public static final String ACTION_GALLERY_NOTICE_CLICK = "com.huawei.android.hicloud.GALLERY_NOTICE_CLICK";
        public static final String ACTION_SITE_CHANGE_LATER_NOTICE_CLICK = "com.huawei.android.hicloud.ACTION_SITE_CHANGE_LATER_NOTICE_CLICK";
    }

    public interface RequestCode {
        public static final int REQUESTCODE_CAMPAIGN = 10008;
    }

    /* renamed from: com.huawei.hicloud.notification.constants.NotifyConstants$SP */
    public interface InterfaceC4909SP {
        public static final String USERINFO_SPFILE = "com.huawei.android.sync_settings_cfg";
    }

    public interface SpDefault {
        public static final String ACTIVITY_DEFALT_ADID = "";
        public static final String ACTIVITY_DEFALT_ID = "";
        public static final int ACTIVITY_DEFALT_TYPE = -1;
        public static final boolean CALIM_DIALOG_IS_SHOWN_ALREADY = false;
        public static final boolean CALIM_DIALOG_IS_SUPPORT_DEFAULT = true;
        public static final int DEFALT = -1;
        public static final int DEFALT_ZERO = 0;
        public static final int DEFAULT_CAMPAIGN_QUOTA = -1;
        public static final int POP_GOTO_DEFAULT_BUTTON_COUNT = -1;
    }

    public interface SpaceNoticeSp {
        public static final String ACTIVITY_AD_ID = "_activity_ad_id";
        public static final String ACTIVITY_CID = "_activity_cid";
        public static final String ACTIVITY_TYPE = "_activity_type";
        public static final String CALIM_DIALOG_IS_SHOWN_ALREADY = "isShownAlready";
        public static final String CALIM_DIALOG_IS_SUPPORT = "isSupportClaimSpace";
        public static final String CAMPAIGN_QUOTA = "_campaing_quota";
        public static final String POP_GOTO_BUTTON_COUNT = "_pop_goto_button_count";
        public static final String SPACE_REMINDER_FAIL_TIME = "space_reminder_fail_time";
        public static final String SPACE_REMINDER_FAIL_TIMES = "space_reminder_fail_times";
    }

    public static class SyncItemSupportServer {
        public static final int STATUS_NOT_SUPPORT_ANY_ENCRYPT_MODE = 0;
        public static final int STATUS_SUPPORT_BOTH_ENCRYPT_AND_NO_ENCRYPT = 3;
        public static final int STATUS_SUPPORT_ENCRYPT = 2;
        public static final int STATUS_SUPPORT_NO_ENCRYPT = 1;
    }

    public interface SyncProcess {
        public static final int CURRENT_SYNC_VERSION = 103;
        public static final int CURRENT_SYNC_VERSION_OBS = 103;
        public static final int ORIGIN_SYNC_VERSION = 100;
    }

    public interface TextLinkConst {
        public static final String ENTRANCE_KEY = "entrance";
        public static final String TEXT_LINK_EVENT_CLICK = "text_link_click";
        public static final String TEXT_LINK_EVENT_CLOSE = "text_link_close";
        public static final String TEXT_LINK_EVENT_GOTO_FAILED = "text_link_goto_failed";
        public static final String TEXT_LINK_EVENT_GOTO_FAILED_REASON = "text_link_goto_failed_reason";
        public static final String TEXT_LINK_EVENT_SHOW = "text_link_show";
        public static final String TEXT_LINK_ID = "text_link_id";
        public static final String TEXT_LINK_NOTIFY_TYPE = "text_link_notify_type";
    }

    public static Map<String, String> getForcedUpgradeMapping() {
        return FORCED_UPGRADE_MAPPING;
    }

    public static Map<String, Class<?>> getGotoAppMapping() {
        return GO_TO_APP_MAPPING;
    }

    public static void putServicesMoudleIntoMap(String str, boolean z10) {
        if (new SyncConfigOperator().getAllServicesId().contains(str)) {
            if (z10) {
                C13471c.m81132e().put(str, "CLOUDBACKUP_SYNC_OPEN_" + str.toUpperCase(Locale.US));
                return;
            }
            C13471c.m81131d().put(str, "CLOUDBACKUP_SYNC_CLOSE_" + str.toUpperCase(Locale.US));
        }
    }
}
