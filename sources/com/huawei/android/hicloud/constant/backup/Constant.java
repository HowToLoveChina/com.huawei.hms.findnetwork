package com.huawei.android.hicloud.constant.backup;

import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.HashMap;
import p015ak.C0209d;

/* loaded from: classes3.dex */
public class Constant {

    /* renamed from: a */
    public static final HashMap<String, Integer> f12138a = new C2789a();

    /* renamed from: b */
    public static final HashMap<Integer, Integer> f12139b = new C2790b();

    /* renamed from: c */
    public static final HashMap<String, String> f12140c = new C2791c();

    /* renamed from: d */
    public static final HashMap<String, String> f12141d = new C2792d();

    /* renamed from: e */
    public static final HashMap<String, Integer> f12142e = new C2793e();

    public interface AppType {
    }

    public interface BackupReport {
    }

    public interface CalendarOpFlag {
    }

    public interface ContactOpFlag {
    }

    public interface DataType {
    }

    public interface FeatureProvider {
    }

    public interface GalleryOpFlag {
    }

    public interface NotepadOpFlag {
    }

    public interface OperateFlag {
    }

    public interface PreviousLanguage {
    }

    public interface SpaceSize {
    }

    public interface SpaceSwitchItemType {
    }

    public interface TempBackupButton {
    }

    public interface TimeFormatStyle {
    }

    public interface UpGuideConstant {
    }

    /* renamed from: com.huawei.android.hicloud.constant.backup.Constant$a */
    public class C2789a extends HashMap<String, Integer> {
        public C2789a() {
            put("addressbook", Integer.valueOf(R$string.contact));
            put("calendar", Integer.valueOf(R$string.calendar_sync_item));
            put("notepad", Integer.valueOf(R$string.cloudbackup_back_item_notepad));
            if (C0209d.m1262h2()) {
                put("wlan", Integer.valueOf(R$string.merge_dialog_wlan_sync));
            } else {
                put("wlan", Integer.valueOf(R$string.wifi_sync));
            }
            put("browser", Integer.valueOf(R$string.browser));
            put(HNConstants.DataType.MEDIA, Integer.valueOf(R$string.gallery_item_title));
            put("message", Integer.valueOf(R$string.cloudbackup_back_item_sms));
            put("calllog", Integer.valueOf(R$string.cloudbackup_Calllog));
            put("recording", Integer.valueOf(R$string.cloudbackup_back_item_record));
            put("interception", Integer.valueOf(R$string.cloudbackup_back_item_phonemanager));
        }
    }

    /* renamed from: com.huawei.android.hicloud.constant.backup.Constant$b */
    public class C2790b extends HashMap<Integer, Integer> {
        public C2790b() {
            put(1, Integer.valueOf(R$string.sync_data_merge_confirm_tips));
            put(2, Integer.valueOf(R$string.sync_data_merge_confirm_tips_double));
            put(3, Integer.valueOf(R$string.sync_data_merge_confirm_tips_triple));
            put(4, Integer.valueOf(R$string.sync_data_merge_confirm_tips_fourth));
            put(5, Integer.valueOf(R$string.sync_data_merge_confirm_tips_fifth));
            put(6, Integer.valueOf(R$string.sync_data_merge_confirm_tips_sixth));
            put(7, Integer.valueOf(R$string.sync_data_merge_confirm_tips_seven));
            put(8, Integer.valueOf(R$string.sync_data_merge_confirm_tips_seven_and_more));
        }
    }

    /* renamed from: com.huawei.android.hicloud.constant.backup.Constant$c */
    public class C2791c extends HashMap<String, String> {
        public C2791c() {
            put(CloudBackupConstant.Command.PMS_CMD_BACKUP, "#00BFC9");
            put("drive", "#007DFF");
            put("photos", "#47CC47");
            put("other", "#FFBF00");
            put("family", "#FF7500");
        }
    }

    /* renamed from: com.huawei.android.hicloud.constant.backup.Constant$d */
    public class C2792d extends HashMap<String, String> {
        public C2792d() {
            put(CloudBackupConstant.Command.PMS_CMD_BACKUP, "#00777E");
            put("drive", "#006CDE");
            put("photos", "#007900");
            put("other", "#8C6800");
            put("family", "#BA5500");
        }
    }

    /* renamed from: com.huawei.android.hicloud.constant.backup.Constant$e */
    public class C2793e extends HashMap<String, Integer> {
        public C2793e() {
            put(CloudBackupConstant.Command.PMS_CMD_BACKUP, Integer.valueOf(R$string.space_display_backup_title));
            put("drive", Integer.valueOf(R$string.space_display_drive_title));
            put("photos", Integer.valueOf(R$string.space_display_photos_title));
            put("other", Integer.valueOf(R$string.space_display_other_title));
            put("family", Integer.valueOf(R$string.space_display_family_title));
        }
    }

    /* renamed from: com.huawei.android.hicloud.constant.backup.Constant$f */
    public static class C2794f {

        /* renamed from: a */
        public static final int[] f12143a = {R$id.cloud_backup_item_view, R$id.phonefinder_item_view};

        /* renamed from: b */
        public static final int[] f12144b = {R$id.gallery_item_view, R$id.contact_item_view, R$id.browser_item_view, R$id.carlendar_item_view, R$id.notepad_item_view, R$id.wlan_item_view, R$id.cloud_disk_item};

        /* renamed from: a */
        public static int[] m16246a() {
            return (int[]) f12143a.clone();
        }

        /* renamed from: b */
        public static int[] m16247b() {
            return (int[]) f12144b.clone();
        }
    }

    /* renamed from: a */
    public static HashMap<Integer, Integer> m16241a() {
        return f12139b;
    }

    /* renamed from: b */
    public static HashMap<String, String> m16242b() {
        return f12140c;
    }

    /* renamed from: c */
    public static HashMap<String, String> m16243c() {
        return f12141d;
    }

    /* renamed from: d */
    public static HashMap<String, Integer> m16244d() {
        return f12142e;
    }

    /* renamed from: e */
    public static HashMap<String, Integer> m16245e() {
        return f12138a;
    }
}
