package com.huawei.hicloud.notification.constants;

/* loaded from: classes6.dex */
public class FamilyShareConstants {
    public static final long DEFAULT_NO_OPEN_UID = -1;
    public static final long DELAY_FINISH_TIME = 200;
    public static final String ENTRY_BUTTON_TYPE = "entry_button_type";
    public static final String ENTRY_TYPE = "entry_type";
    public static final String ENTRY_TYPE_FOR_GUIDE = "space_share_entry_type";
    public static final String EXTRA_KEY = "EXTRA_KEY";
    public static final String FAMILY_IMAGE_FILE_PATH = "/familyimage/";
    public static final String FROM_ACCOUNT_CONFIRM_JOIN = "from_account_confirm_join";
    public static final String HAS_ENOUGH_SPACE = "has_enough_space";
    public static final String INVITE_FAMILY_MEMBER_REQUEST_UID_KEY = "requestUids";
    public static final String IS_FROM_GALLERY_LOGIN = "isFromGalleryLogin";
    public static final long MEMBER_QUERY_INTERVAL = 86400000;
    public static final String NOTIFY_MEMBER_SHARE_DETAIL = "notify_member_share_detail";
    public static final String OPEN_FAMILY_SPACE_SHARE = "open_family_space_share";
    public static final int OPEN_LATER_RESULT_CODE = 1;
    public static final int OVER_PAGE_TIME = 500;
    public static final String PURCHASED_STATUS = "purchased_status";
    public static final int REQUEST_CODE_OPEN_CLOUDSHARE = 10;
    public static final String SCHEME_ACCOUNT_CENTER = "hwid://com.huawei.hwid/AccountCenter";
    public static final String SCHEME_FAMILY_INVITATION = "hwid://com.huawei.hwid/InviteFamilyMember";
    public static final String SCHEME_FAMILY_SHARE = "hwid://com.huawei.hwid/FamilyShare";
    public static final String SPACE_SHARE_ENABLE = "space_share_enable";
    public static final String SPACE_SHARE_ROLE = "space_share_role";
    public static final String SPACE_SHARE_TO_USAGE = "space_share_to_usage";

    public interface BroadCast {
        public static final String FAMILY_SHARE_OM_CONFIG_DOWNLOAD_FINISHED_ACTION = "com.huawei.hicloud.FAMILY_SHARE_OM_CONFIG_DOWNLOAD_FINISHED";
    }

    public interface CanSpaceshareEnable {

        /* renamed from: NO */
        public static final int f22629NO = 0;
        public static final int YES = 1;
    }

    public interface Cmd {
        public static final int CMD_DEFAULT = 0;
        public static final String EXTRA_CMD_KEY = "cmd";
        public static final int GET_VERSION = 1;
    }

    public interface DownloadConfigReport {
        public static final String ERR_REASON_KEY = "err_reason";
        public static final String FAIL = "1";
        public static final String REPORT_RESULT_KEY = "result";
        public static final String RETRY_NUM_KEY = "retry_num";
        public static final String SUCCESS = "0";
        public static final String SUCCESS_SCRIPTION = "success_scription";
    }

    public interface EnoughSpace {

        /* renamed from: NO */
        public static final int f22630NO = 0;
        public static final int YES = 1;
    }

    public interface EnterType {
        public static final int ACCOUNT_CENTER = 1;
        public static final int DEFAULT_TYPE = -1;
        public static final int FILE_MANAGER = 4;
        public static final int MAIN_PAGE = 7;
        public static final int MANAGE_CLOUD_SPACE = 2;
        public static final int PUSH_NOTICE = 5;
        public static final int PUSH_NOTICE_STOP = 6;
        public static final int SPACE_SHARE_USAGE = 3;
    }

    public interface ErrorCode {
        public static final int ERROR_CODE_UNSUPPORT_PETALONE = 1024;
        public static final int GET_FAMILY_SHARE_INFO_ERROR = 1001;
        public static final int INVITE_FAMILY_MEMBER_FLOW_CONTROL = 503;
    }

    public interface FamilyExtraKey {
        public static final int DEAFAULT_KEY = -1;
        public static final int FAMILY_INVITATION = 1;
        public static final int FAMILY_JOIN_BY_DEFAULT = 2;
        public static final int FAMILY_SHARE = 0;
    }

    public interface FamilyShareConfig {
        public static final String CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME = "cloud_space_usage_language.xml";
        public static final String CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_CLOUD = "cloud_space_usage_language_cloud.xml";
        public static final String CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_LOCAL = "cloud_space_usage_language_local.xml";
        public static final String CLOUD_USAGE = "cloud_usage";
        public static final String FAMILY_SHARE = "family_share";
        public static final String FAMILY_SHARE_LOCAL = "family_share_local.json";
        public static final String FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME = "family_share_page_language.xml";
        public static final String FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_CLOUD = "family_share_page_language_cloud.xml";
        public static final String FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_LOCAL = "family_share_page_language_local.xml";
        public static final String LANGUAGE_ATTRIBUTE_NAME = "name";
        public static final String LANGUAGE_ATTRIBUTE_VALUE = "value";
        public static final String LANGUAGE_RESOURCE_TAG = "resource";
        public static final String LANGUAGE_TEXT_TAG = "text";
    }

    public interface FamilyShareEnable {
        public static final int NOT_OPNE = 0;
        public static final int OPENED = 1;
    }

    public interface MessageCode {
        public static final int DISABLE_SPACE_SHARE_FAILED = 2005;
        public static final int DISABLE_SPACE_SHARE_SUCCESS = 2004;
        public static final int ENABLE_SPACE_SHARE_FAILED = 2011;
        public static final int ENABLE_SPACE_SHARE_SUCCESS = 2010;
        public static final int FAMILY_DETAI_INFO_FAILED = 2003;
        public static final int FAMILY_DETAI_INFO_SUCCESS = 2002;
        public static final int GET_FAMILY_IMAGE = 2018;
        public static final int GET_FAMILY_SHARE_INFO_AND_DETAIL = 2013;
        public static final int GET_SPACE_SHARE_INFO_FAILED = 2009;
        public static final int GET_SPACE_SHARE_INFO_SUCCESS = 2008;
        public static final int GET_USERPACKAGE_FOR_INVITE_FAMILY_MEMBER = 2019;
        public static final int GO_TO_STORAGE_MANAGE = 2021;
        public static final int INVITE_FAMILY_MEMBER_FAILED = 2017;
        public static final int INVITE_FAMILY_MEMBER_SUCCESS = 2016;
        public static final int JOIN_FAMILY_PETAL_ERROR = 2020;
        public static final int QUIT_SPACE_SHARE_FAILED = 2007;
        public static final int QUIT_SPACE_SHARE_SUCCESS = 2006;
        public static final int SHOW_FAMILY_SHARE_IMAGE = 2012;
        public static final int SPACE_SHARE_FINISH_DELAY_TO_USAGE = 2014;
        public static final int SPACE_SHARE_STRING_DOWNLOAD_FINISH = 2015;
        public static final int USER_SPACE_SHARE_FAILED = 2001;
        public static final int USER_SPACE_SHARE_SUCCESS = 2000;
    }

    public interface OpenButtonType {
        public static final int JOIN_FINISH = 4;
        public static final int OPEN_FINISH = 3;
        public static final int SPACE_NOT_SATISFACTION = 2;
        public static final int SPACE_SATISFACTION = 1;
    }

    public interface OpenCloudShareResultInfo {
        public static final String DESC_CLOUD_NOT_OPEN = "cloud not open";
        public static final String DESC_FAMILY_SHARE_INFO_FAIL = "get family share info fail";
        public static final String DESC_FAMILY_SHARE_NOT_OPEN = "family share not open";
        public static final String DESC_FAMILY_SHARE_RESULT_FAIL = "get family share info and detail info fail";
        public static final String DESC_JOIN_SPACE_SHARE_FAIL = "join space share failed";
        public static final String DESC_JOIN_SPACE_SHARE_SUCCESS = "join space share success";
        public static final String DESC_MIGRATING_DATA = "cloud is migrating data";
        public static final String DESC_MODULE_NOT_SUPPORT = "current module not supported";
        public static final String DESC_NOBODY_SHARE_SPACE = "nobody share cloud space";
        public static final String DESC_NOT_JOIN_SPACE_SHARE = "vip user click not join";
        public static final String DESC_PRIVACY_USER = "privacy user, can not use cloud";
        public static final String DESC_QUERY_USERPACKAGE_FAILED = "query user package failed";
        public static final String DESC_SITE_STATUS_ERROR = "site status error";
        public static final String DESC_SPACE_SHARE_OPENED = "space share opened";
        public static final String DESC_SYNC_RISK = "cloud is in sync risk status";
        public static final String DESC_USER_CLICK_BACK = "user click back";
        public static final int ERR_CLOUD_NOT_OPEN = 1;
        public static final int ERR_FAMILY_SHARE_INFO_FAIL = 8;
        public static final int ERR_FAMILY_SHARE_NOT_OPEN = 9;
        public static final int ERR_FAMILY_SHARE_RESULT_FAIL = 7;
        public static final int ERR_JOIN_SPACE_SHARE_FAIL = 12;
        public static final int ERR_MIGRATING_DATA = 6;
        public static final int ERR_MODULE_NOT_SUPPORT = 5;
        public static final int ERR_NOBODY_SHARE_SPACE = 11;
        public static final int ERR_NOT_JOIN_SPACE_SHARE = 13;
        public static final int ERR_PRIVACY_USER = 3;
        public static final int ERR_QUERY_USERPACKAGE_FAILED = 14;
        public static final int ERR_SITE_STATUS_ERROR = 2;
        public static final int ERR_SPACE_SHARE_OPENED = 10;
        public static final int ERR_SYNC_RISK = 4;
        public static final int ERR_USER_CLICK_BACK = 15;
        public static final int JOIN_SPACE_SHARE_SUCCESS = 0;
        public static final String RESULT_CODE_KEY = "result_code";
        public static final String RESULT_DESC_KEY = "result_desc";
        public static final int RESULT_FREE_USER = 1;
        public static final int RESULT_VIP_USER = 2;
    }

    public interface Purchased {

        /* renamed from: NO */
        public static final int f22631NO = 0;
        public static final int YES = 1;
    }

    public interface Push {
        public static final String KEY_NICK_NAME = "nickname";
        public static final String KEY_PACKAGE_CAPACITY = "packageCapacity";
        public static final int MSG_CODE_INVITED = 4;
        public static final int MSG_CODE_QUIT_OWNER_FAMILY = 5;
        public static final int MSG_CODE_SHARE_DISABLE = 2;
        public static final int MSG_CODE_SHARE_ENABLE = 1;
        public static final int MSG_CODE_SHARE_MEMBER_QUIT = 3;
        public static final String MSG_KEY = "type";
    }

    public interface Report {
        public static final String CLICK_CANCEL_DISABLE_DIALOG_BUTTON = "click_cancel_disable_dialog_button";
        public static final String CLICK_CANCEL_JOIN_HAS_PURCHASED_DIALOG_BUTTON = "click_cancel_join_has_purchased_dialog_button";
        public static final String CLICK_CANCEL_QUIT_DIALOG_BUTTON = "click_cancel_quit_dialog_button";
        public static final String CLICK_DISABLE_BUTTON = "click_disable_button";
        public static final String CLICK_DISABLE_DIALOG_BUTTON = "click_disable_dialog_button";
        public static final String CLICK_ENABLE_BUTTON = "click_enable_button";
        public static final String CLICK_ENABLE_LATER_BUTTON = "click_enable_later_button";
        public static final String CLICK_JOIN_BUTTON = "click_join_button";
        public static final String CLICK_JOIN_HAS_PURCHASED_BUTTON = "click_join_has_purchased_button";
        public static final String CLICK_JOIN_HAS_PURCHASED_DIALOG_BUTTON = "click_join_has_purchased_dialog_button";
        public static final String CLICK_NOT_JOIN_HAS_PURCHASED_BUTTON = "click_not_join_has_purchased_button";
        public static final String CLICK_QUIT_BUTTON = "click_quit_button";
        public static final String CLICK_QUIT_DIALOG_BUTTON = "click_quit_dialog_button";
        public static final String CLICK_SPACE_SHARE = "click_space_share_home_page";
        public static final String CLICK_SPACE_SHARE_ENABLE_NOTICE = "click_space_share_enable_notice";
        public static final String CLICK_SPACE_SHARE_STOP_NOTICE = "click_space_share_stop_notice";
        public static final String DISABLE_FAMILY_SHARE = "disableFamilyShare";
        public static final String ENABLE_FAMILY_SHARE = "enableFamilyShare";
        public static final String GET_FAMILY_DETAIL_INFO = "getFamilyDetaiInfo";
        public static final String GET_FAMILY_SHARE_INFO = "getFamilyShareInfo";
        public static final String JOIN_FAMILY_SHARE = "joinFamilyShare";
        public static final String QUIT_FAMILY_SHARE = "quitFamilyShare";
        public static final String QUIT_OWNER_FAMILY_SHARE_SHOW = "quit_owner_family_share_show";
        public static final String SET_VIEW_STRING = "set_view_string";
        public static final String SET_VIEW_STRING_RESULT = "set_view_result_failed";
        public static final String SHOW_SPACE_SHARE = "show_space_share_home_page";
        public static final String SPACE_SHARE_ENABLE_NOTICE_SHOW = "space_share_enable_notice_show";
        public static final String SPACE_SHARE_ENTRY_TYPE = "space_share_entry_type";
        public static final String SPACE_SHARE_EXTRA_KEY = "space_share_extra_key";
        public static final String SPACE_SHARE_OPERATE_RESULT = "space_share_operate_result";
        public static final String SPACE_SHARE_OPERATE_TYPE = "space_share_operate_type";
        public static final String SPACE_SHARE_RESULT_FAILED = "space_share_result_failed";
        public static final String SPACE_SHARE_RESULT_SUCCESS = "space_share_result_success";
        public static final String SPACE_SHARE_RETCODE = "space_share_retcode";
        public static final String SPACE_SHARE_STOP_NOTICE_SHOW = "space_share_stop_notice_show";
        public static final String USER_PAY_TYPE = "user_pay_type";
    }

    public interface ResultCode {
        public static final int GUIDE_TO_SPACE_SHARE = 103;
        public static final int MANAGE_CLOUD_TO_SPACE_SHARE = 101;
        public static final int MANAGE_CLOUD_TO_USAGE = 102;
        public static final int SPACESHARE_TO_USAGE = 104;
    }

    /* renamed from: com.huawei.hicloud.notification.constants.FamilyShareConstants$SP */
    public interface InterfaceC4905SP {
        public static final String FAMILY_SHARE_SP_NAME = "family_share";
        public static final int RETRY_NUM_DEFAULT = -1;
    }

    public interface ShareDetailDialogType {
        public static final int MEMBER_UPGRADE_STOP_SHARE = 5;
        public static final int QUIT_SHARE = 4;
        public static final int SHARE_SPACE_NOT_ENOUGH = 2;
        public static final int STOP_SHARE = 1;
        public static final int STOP_USING_SHARE = 3;
    }

    public interface ShareDetailType {
        public static final int FINISH_SHARE = 3;
        public static final int JOIN_SHARE = 4;
        public static final int LESS_THAN_200GB = 1;
        public static final int MORE_THAN_200GB = 2;
        public static final int SPACE_FULL = 5;
    }

    public interface ShowMore {

        /* renamed from: NO */
        public static final String f22632NO = "N";
        public static final String YES = "Y";
    }

    public interface SpaceShareEnable {
        public static final int NOT_OPNE = 0;
        public static final int OPENED = 1;
    }

    public interface SpaceShareRole {
        public static final int MEMBER = 2;

        /* renamed from: NA */
        public static final int f22633NA = 0;
        public static final int OWNER = 1;
    }

    public interface SpaceShareStauts {
        public static final int CLOUD_SPACE_SHARE_USAGE = 2;
        public static final int NOT_OPEN_OR_JOIN_FAMILY_SHARE = -1;
        public static final int OPEN_JOIN_CLOUD_SPACE_SHARE = 1;
    }

    public interface SpaceShareUsageStatus {
        public static final int STOP_SPACE_SHARE = 2;
        public static final int USE_SPACE_SHARE = 1;
    }

    public interface StatusCode {
        public static final int COMMON_ERROR = 1100;
        public static final int ERROR_CODE_UNSUPPORT_PETALONE_SEC = 1027;
        public static final int FAILED = -1;
        public static final int FAMILY_SHARE_NOT_OPEN = 1010;
        public static final int SHARE_SPACE_NOT_ENOUGH = 1013;
        public static final int SHARE_UNUSED_SPACE_NOT_ENOUGH = 1014;
        public static final int SNA_GROUP_NOT_EXIST = 1008;
        public static final int SPACE_SHARE_NOT_OPEN = 1012;
        public static final int SPACE_SHARE_OPENED = 1011;
        public static final int SUCCESS = 0;
        public static final int USER_HAS_JOINED_SHARE_SPACE = 1015;
        public static final int USER_JOIN_IS_FROZEN = 1019;
        public static final int USER_ROLE_NOT_ALLOWED = 1016;
    }
}
