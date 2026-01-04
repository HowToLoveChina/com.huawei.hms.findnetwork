package com.huawei.android.hicloud.constant;

import com.huawei.hicloud.sync.R$string;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class CommonBase {

    /* renamed from: a */
    public static final List<String> f12112a = new C2787a();

    /* renamed from: b */
    public static final Map<String, Integer> f12113b = new C2788b();

    public interface AdType {
    }

    public interface AgrConstant {
    }

    public interface CommonActionRequestCode {
    }

    public interface CommonReportConstants {
    }

    public interface EntryType {
    }

    public interface FollowPublicUser {
    }

    public interface HuaWeiCard {
    }

    public interface HwidLoginStatus {
    }

    public interface MainDialogRank {
    }

    public interface NotificationActivityType {
    }

    public interface NotificationReport {
    }

    public interface OOBEQueryEntrance {
    }

    public interface PolicyEntry {
    }

    public interface PrivacyClickType {
    }

    public interface Quota {
    }

    public interface ServiceApp {
    }

    public interface TempSwitchKey {
    }

    public interface TermType {
    }

    public interface UrgencyNotice {
    }

    public interface WhiteHost {
    }

    /* renamed from: com.huawei.android.hicloud.constant.CommonBase$a */
    public class C2787a extends ArrayList<String> {
        public C2787a() {
            add("POLICY_SERVICE");
            add("ADD_ICON_DIALOG_ID");
            add("PUSH_MARKETING_NOTICE");
            add("GET_SPACE_OK_H5_DIALOG");
            add("CLAM_POP");
            add("SPACE_FULL");
            add("GUIDE_H5_WEBVIEW_DAILOG");
            add("GUIDE_BACKUP_SWITCH");
            add("BACKUP_OPTION_ALERT_DIALOG_ID");
        }
    }

    /* renamed from: com.huawei.android.hicloud.constant.CommonBase$b */
    public class C2788b extends HashMap<String, Integer> {
        public C2788b() {
            put("@null/base_data_service_title", Integer.valueOf(R$string.base_data_service_title));
            put("@null/basic_data_guide_title", Integer.valueOf(R$string.basic_data_guide_title_new));
            put("@null/basic_data_gallery_title", Integer.valueOf(R$string.gallery_item_title));
            put("@null/basic_data_gallery_content", Integer.valueOf(R$string.basic_data_gallery_content_new));
            put("@null/basic_data_other_backup_title", Integer.valueOf(R$string.basic_data_other_backup_title_new));
            put("@null/basic_data_other_backup_content", Integer.valueOf(R$string.basic_data_other_backup_content_new));
            put("@null/basic_data_cloud_disk_title", Integer.valueOf(R$string.basic_data_cloud_disk_title));
            put("@null/basic_data_cloud_disk_content", Integer.valueOf(R$string.basic_data_cloud_disk_content_new));
            put("@null/cloud_space_share_title", Integer.valueOf(R$string.cloud_space_share));
            put("@null/basic_data_cloud_share_content", Integer.valueOf(R$string.basic_data_cloud_share_content));
            put("@null/cloud_space_share_content", Integer.valueOf(R$string.cloud_space_share_content_new));
            put("@null/basic_data_upgrade_btn", Integer.valueOf(R$string.basic_data_upgrade_btn));
            put("@null/full_data_service_title", Integer.valueOf(R$string.full_data_service_title));
            put("@null/manage_space", Integer.valueOf(R$string.manage_space));
            put("@null/change_storage_plan", Integer.valueOf(R$string.change_storage_plan));
            put("@null/sync_and_backup_basic_data", Integer.valueOf(R$string.sync_and_backup_basic_data_new));
            put("@null/low_space_tip_buy_new", Integer.valueOf(R$string.main_upgrade_storage));
            put("@null/expirationItemJumpButtonText", Integer.valueOf(R$string.expiration_card_item_continue_button));
            put("@null/expirationItemJumpTitle", Integer.valueOf(R$string.expiration_card_item_continue_title));
            put("@null/expirationItemJumpContent", Integer.valueOf(R$string.expiration_card_item_continue_content));
            put("@null/expirationItemDownButtonText", Integer.valueOf(R$string.expiration_card_item_download_button));
            put("@null/expirationItemDownTitle", Integer.valueOf(R$string.expiration_card_item_download_title));
            put("@null/default_expiration_card_title", Integer.valueOf(R$string.expiration_card_default_title));
            put("@null/retain_service_data", Integer.valueOf(R$string.retain_service_data));
            put("@null/download_service_data", Integer.valueOf(R$string.download_service_data));
            put("@null/photos_download_data_tips", Integer.valueOf(R$string.photos_download_data_tips));
            put("@null/restore_membership_service_data", Integer.valueOf(R$string.restore_membership_service_data));
            put("@null/member_servic_no_download", Integer.valueOf(R$string.member_servic_no_download));
            put("@null/subscribe_and_restore_data", Integer.valueOf(R$string.subscribe_and_restore_data));
            put("@null/view_data", Integer.valueOf(R$string.view_data));
            put("@null/data_stored_cloud", Integer.valueOf(R$string.data_stored_cloud));
            int i10 = R$string.main_recommend_title;
            put("@null/main_recommend_title", Integer.valueOf(i10));
            put("@null/see_details", Integer.valueOf(R$string.see_details));
            put("@null/recommendation", Integer.valueOf(i10));
            put("@null/cloud_home_page_basic_server_des", Integer.valueOf(R$string.cloud_home_page_basic_server_des));
            put("@null/cloud_home_page_sync_card_tips", Integer.valueOf(R$string.main_data_sync_app_title));
        }
    }

    /* renamed from: a */
    public static List<String> m16239a() {
        return f12112a;
    }

    /* renamed from: b */
    public static Map<String, Integer> m16240b() {
        return f12113b;
    }
}
