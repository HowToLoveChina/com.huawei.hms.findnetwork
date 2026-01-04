package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import hk.C10279b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import je.C10806t;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0214f0;
import p514o9.C11839m;
import p709vj.C13452e;
import p711vl.C13467g;

/* loaded from: classes3.dex */
public class HicloudMigrateProvider extends ContentProvider {

    /* renamed from: b */
    public static final UriMatcher f11967b = new UriMatcher(-1);

    /* renamed from: c */
    public static final String[] f11968c = {"funcfg_calendar", "funcfg_call_log_down", "cloudbackup_toogle", "has_clear_more_data_flag", "funcfg_huawei_drive", "funcfg_blocked_down", "funcfg_messaging_up", "funcfg_recordings_up", "uploadphotokey", "notepad", "cleared_channel_ids", "funcfg_notes", "reccfg_contacts", "funcfg_browser", "show_merge_sp", "guide_tag", "cloudphoto_toogle", "user_in_red_list", "funcfg_wlan", "funcfg_find_my_phone", "funcfg_recordings_down", "funcfg_blocked_up", "funcfg_messaging_down", "is_already_configed_V8", "funcfg_manage_storage", "funcfg_drive", "config_success_flag", "addressbook", "notepad_has_history_data", "addressbook_toogle", "funcfg_cloud_backup", "funcfg_gallery", "funcfg_find_my_phone_globe", "backup_key", "funcfg_familyShare", "toggle_default", "urls_sp_version", "support_push_notify_control", "push_receive_status", "wlan_toogle", "has_send_wlan_switch_to_ds", "browser_toogle", "funcfg_contacts", "funcfg_call_log_up", "has_send_data_switch_to_ds", "follow_public_user", "browser", "hms_agr_force_query", "is_agree_root_alert_hicloud", "calendar", "notepad_toogle", "is_hicloud_terms_confirm", "ds_start_sticky", "oobe_phonefinder", "is_all_guide_over", "wlan", "calendar_toogle", "config_tag", "reccfg_notes", "funcfg_cloudphoto_share", "funcfg_cloudphoto_manager"};

    /* renamed from: d */
    public static final String[] f11969d = {"last_query_config_time", "last_report_push_token_time", "get_notepad_history_time", "last_full_report_switch_status_time", "hms_agr_query_time"};

    /* renamed from: e */
    public static final String[] f11970e = {"data_status", "forcedUpdate", "notice_switch_status_key", "basic_encrypt_mode", "encrypt_mode"};

    /* renamed from: f */
    public static final String[] f11971f = {"email_address"};

    /* renamed from: g */
    public static final String[] f11972g = {"SwitchHelperUtilisCloudAlbumOn", "SwitchHelperUtilisSmartAlbumOn", "SwitchHelperUtilisShareAlbumOn"};

    /* renamed from: a */
    public boolean f11973a = false;

    /* renamed from: a */
    public final ParcelFileDescriptor m15696a(int i10) {
        C11839m.m70686d("HicloudMigrateProvider", "backupSharedPreference !");
        try {
            return ParcelFileDescriptor.open(new File(m15698c(i10)), HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        } catch (FileNotFoundException unused) {
            C11839m.m70686d("HicloudMigrateProvider", "backupSharedPreference FileNotFoundException.");
            return null;
        } catch (Exception e10) {
            C11839m.m70686d("HicloudMigrateProvider", e10.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public final int m15697b(String str) {
        if ("r".equals(str)) {
            return HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK;
        }
        return 536870912;
    }

    /* renamed from: c */
    public final String m15698c(int i10) {
        return "";
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        C11839m.m70688i("HicloudMigrateProvider", "call method = " + str + " arg = " + str2);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "backup_recover_complete":
                m15701f();
                break;
            case "backup_recover_start":
                break;
            case "backup_query":
                break;
            default:
                C11839m.m70688i("HicloudMigrateProvider", "unknown method");
                break;
        }
        return null;
    }

    /* renamed from: d */
    public final MatrixCursor m15699d() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"type", "key", "value", "dynamic_flag"});
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext(), SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        for (String str : f11968c) {
            if (str.equals("config_tag")) {
                matrixCursor.addRow(new Object[]{"boolean", "config_tag", Boolean.valueOf(C2783d.m16097N()), Boolean.FALSE});
            } else {
                matrixCursor.addRow(new Object[]{"boolean", str, Boolean.valueOf(sharedPreferencesM1382b.getBoolean(str, false)), Boolean.FALSE});
            }
        }
        for (String str2 : f11969d) {
            matrixCursor.addRow(new Object[]{"long", str2, Long.valueOf(sharedPreferencesM1382b.getLong(str2, 0L)), Boolean.FALSE});
        }
        for (String str3 : f11970e) {
            matrixCursor.addRow(new Object[]{"int", str3, Integer.valueOf(sharedPreferencesM1382b.getInt(str3, 0)), Boolean.FALSE});
        }
        for (String str4 : f11971f) {
            matrixCursor.addRow(new Object[]{ExtractOWiFiHelper.STING_NODE, str4, sharedPreferencesM1382b.getString(str4, ""), Boolean.FALSE});
        }
        Iterator<SyncConfigService> it = NotifyUtil.getShownSyncServiceItems(getContext()).iterator();
        while (it.hasNext()) {
            String id2 = it.next().getId();
            matrixCursor.addRow(new Object[]{"boolean", id2, Boolean.valueOf(sharedPreferencesM1382b.getBoolean(id2, false)), Boolean.TRUE});
            String str5 = "funcfg_" + id2;
            String str6 = id2 + "_toogle";
            Boolean boolValueOf = Boolean.valueOf(sharedPreferencesM1382b.getBoolean(str5, false));
            Boolean bool = Boolean.FALSE;
            matrixCursor.addRow(new Object[]{"boolean", str5, boolValueOf, bool});
            matrixCursor.addRow(new Object[]{"boolean", str6, Boolean.valueOf(sharedPreferencesM1382b.getBoolean(str6, false)), bool});
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: e */
    public final Bundle m15700e(String str) {
        if (TextUtils.equals(str, "restore")) {
            this.f11973a = true;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/global_module_setting");
        arrayList.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/grs_urls");
        arrayList.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/albulm_switch");
        arrayList.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/backup_frequency");
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/global_module_setting");
        arrayList2.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/grs_urls");
        arrayList2.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/albulm_switch");
        arrayList2.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/backup_frequency");
        Context context = getContext();
        if (context == null) {
            context = getContext().getApplicationContext();
        }
        if (context == null) {
            context = C0213f.m1377a();
        }
        if (context == null) {
            C11839m.m70688i("HicloudMigrateProvider", "context null");
            return new Bundle();
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        boolean zM80842P0 = C13452e.m80781L().m80842P0();
        boolean zM62221H1 = c10028cM62183d0.m62221H1();
        boolean zM62395t1 = c10028cM62183d0.m62395t1("is_already_configed_NV4");
        boolean z10 = zM80842P0 && zM62221H1 && zM62395t1;
        C11839m.m70688i("HicloudMigrateProvider", "isHiCloudLogin: " + zM80842P0 + " isAgreedHiCloudTerms: " + zM62221H1 + " isConfigTag: " + zM62395t1);
        Bundle bundle = new Bundle();
        if (str.equals(CloudBackupConstant.Command.PMS_CMD_BACKUP) && !z10) {
            return bundle;
        }
        bundle.putInt("version", 1);
        bundle.putStringArrayList("uri_list", arrayList);
        bundle.putStringArrayList("uri_list_need_count", arrayList2);
        return bundle;
    }

    /* renamed from: f */
    public final void m15701f() {
        C11839m.m70688i("HicloudMigrateProvider", "handleBackupRecoverComplete" + this.f11973a);
        Context context = getContext();
        if (context == null) {
            context = getContext().getApplicationContext();
        }
        if (context == null) {
            C11839m.m70687e("HicloudMigrateProvider", "handleBackupRecoverComplete context null");
        } else if (this.f11973a) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
            if (sharedPreferencesM1382b != null) {
                sharedPreferencesM1382b.edit().putBoolean("quick_migrate_flag", true).commit();
            }
            C0209d.m1318v2(context);
        }
    }

    /* renamed from: g */
    public final Bundle m15702g(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            return bundle2;
        }
        C11839m.m70688i("HicloudMigrateProvider", "handleBackupRecoverStart");
        boolean z10 = bundle.getInt("version", 1) <= 1;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/global_module_setting");
        arrayList2.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/grs_urls");
        arrayList2.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/albulm_switch");
        arrayList2.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/backup_frequency");
        if (z10) {
            arrayList.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/global_module_setting");
            arrayList.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/grs_urls");
            arrayList.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/albulm_switch");
            arrayList.add("content://com.huawei.android.hicloud.hicloudmigrateprovider/backup_frequency");
        }
        bundle2.putBoolean("permit", z10);
        bundle2.putStringArrayList("uri_list", arrayList);
        bundle2.putStringArrayList("uri_list_need_count", arrayList2);
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    /* renamed from: h */
    public final void m15703h(ContentValues contentValues) {
        String asString = contentValues.getAsString("type");
        String asString2 = contentValues.getAsString("key");
        if (asString2 == null || asString == null) {
            return;
        }
        if (TextUtils.equals(asString, "boolean")) {
            Boolean asBoolean = contentValues.getAsBoolean("value");
            if (contentValues.getAsBoolean("dynamic_flag").booleanValue()) {
                C11839m.m70686d("HicloudMigrateProvider", "addSyncDynamicItem:" + asString2);
                C10806t.m65775b(asString2);
            }
            if (TextUtils.equals(asString2, "backup_key")) {
                asBoolean = Boolean.FALSE;
            }
            C11839m.m70686d("HicloudMigrateProvider", "keyStr: " + asString2 + "; value:" + asBoolean);
            if (TextUtils.equals(asString2, "config_tag")) {
                C0212e0.m1366p(getContext(), SharedPreferencesStorage.BACKUPOPTION_SPFILE, "is_already_configed_NV4", asBoolean.booleanValue());
                return;
            } else {
                C0212e0.m1366p(getContext(), SharedPreferencesStorage.BACKUPOPTION_SPFILE, asString2, asBoolean.booleanValue());
                return;
            }
        }
        if (TextUtils.equals(asString, "long")) {
            long jLongValue = contentValues.getAsLong("value").longValue();
            C11839m.m70686d("HicloudMigrateProvider", "keyStr: " + asString2 + "; value:" + jLongValue);
            C0212e0.m1371u(getContext(), SharedPreferencesStorage.BACKUPOPTION_SPFILE, asString2, jLongValue);
            return;
        }
        if (!TextUtils.equals(asString, "int")) {
            if (TextUtils.equals(asString, ExtractOWiFiHelper.STING_NODE)) {
                String asString3 = contentValues.getAsString("value");
                if (TextUtils.isEmpty(asString3)) {
                    return;
                }
                C0212e0.m1373w(getContext(), SharedPreferencesStorage.BACKUPOPTION_SPFILE, asString2, asString3);
                return;
            }
            return;
        }
        int iIntValue = contentValues.getAsInteger("value").intValue();
        C11839m.m70686d("HicloudMigrateProvider", "keyStr: " + asString2 + "; value:" + iIntValue);
        C0212e0.m1369s(getContext(), SharedPreferencesStorage.BACKUPOPTION_SPFILE, asString2, iIntValue);
    }

    /* renamed from: i */
    public final ParcelFileDescriptor m15704i(int i10) throws IOException {
        C11839m.m70686d("HicloudMigrateProvider", "restoreSharedPrefernece !");
        File file = new File(m15698c(i10));
        C11839m.m70686d("HicloudMigrateProvider", "restoreSharedPrefernece.restoreDirFile===" + C10279b.m63452a(file));
        if (file.exists()) {
            C11839m.m70686d("HicloudMigrateProvider", "restoreDirFile delete result: " + file.delete());
        }
        try {
            C11839m.m70686d("HicloudMigrateProvider", "restoreDirFile createNewFile result: " + file.createNewFile());
            return ParcelFileDescriptor.open(file, 536870912);
        } catch (FileNotFoundException unused) {
            C11839m.m70687e("HicloudMigrateProvider", "restoreSharedPrefernece FileNotFoundException");
            return null;
        } catch (IOException e10) {
            C11839m.m70687e("HicloudMigrateProvider", e10.getMessage());
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        int iMatch = f11967b.match(uri);
        C11839m.m70686d("HicloudMigrateProvider", "match insert result: " + iMatch);
        if (iMatch == 1) {
            m15703h(contentValues);
        } else if (iMatch == 2) {
            String asString = contentValues.getAsString("key");
            if (asString != null) {
                C0212e0.m1373w(getContext(), "grs_urls", asString, contentValues.getAsString("value"));
            }
        } else if (iMatch == 3) {
            String asString2 = contentValues.getAsString("key");
            if (asString2 != null) {
                C0212e0.m1366p(getContext(), "com.huawei.android.cg.fileshare.SETTING", asString2, contentValues.getAsBoolean("value").booleanValue());
            }
        } else if (iMatch == 4) {
            String asString3 = contentValues.getAsString("type");
            String asString4 = contentValues.getAsString("key");
            if (asString4 != null && asString3 != null) {
                if (TextUtils.equals(asString3, "int")) {
                    int iIntValue = contentValues.getAsInteger("value").intValue();
                    C11839m.m70686d("HicloudMigrateProvider", "keyStr: " + asString4 + "; value:" + iIntValue);
                    C13467g.m81086c().m81094i(asString4, iIntValue);
                } else if (TextUtils.equals(asString3, ExtractOWiFiHelper.STING_NODE)) {
                    String asString5 = contentValues.getAsString("value");
                    C11839m.m70686d("HicloudMigrateProvider", "keyStr: " + asString4 + "; value:" + asString5);
                    C13467g.m81086c().m81095j(asString4, asString5);
                }
            }
        }
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        C11839m.m70688i("HicloudMigrateProvider", "onCreate: ");
        UriMatcher uriMatcher = f11967b;
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudmigrateprovider", "global_module_setting", 1);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudmigrateprovider", "grs_urls", 2);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudmigrateprovider", "albulm_switch", 3);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudmigrateprovider", "backup_frequency", 4);
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        int iMatch = f11967b.match(uri);
        if (iMatch == 1) {
            int iM15697b = m15697b(str);
            if (iM15697b == 268435456) {
                return m15696a(iMatch);
            }
            if (iM15697b == 536870912) {
                return m15704i(iMatch);
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int iMatch = f11967b.match(uri);
        C11839m.m70686d("HicloudMigrateProvider", "match query result: " + iMatch);
        if (iMatch == 1) {
            return m15699d();
        }
        if (iMatch == 2) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"key", "value"});
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext(), "grs_urls", 0);
            for (String str3 : sharedPreferencesM1382b.getAll().keySet()) {
                matrixCursor.addRow(new Object[]{str3, sharedPreferencesM1382b.getString(str3, "")});
            }
            return matrixCursor;
        }
        if (iMatch != 3) {
            if (iMatch != 4) {
                return null;
            }
            MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"type", "key", "value"});
            matrixCursor2.addRow(new Object[]{"int", "backup_frequency", Integer.valueOf(C13467g.m81086c().m81091f())});
            matrixCursor2.addRow(new Object[]{ExtractOWiFiHelper.STING_NODE, "backup_sha_id", C13467g.m81086c().m81090e("backup_sha_id", "")});
            return matrixCursor2;
        }
        MatrixCursor matrixCursor3 = new MatrixCursor(new String[]{"key", "value"});
        SharedPreferences sharedPreferencesM1382b2 = C0214f0.m1382b(getContext(), "com.huawei.android.cg.fileshare.SETTING", 0);
        for (String str4 : f11972g) {
            matrixCursor3.addRow(new Object[]{str4, Boolean.valueOf(sharedPreferencesM1382b2.getBoolean(str4, false))});
        }
        return matrixCursor3;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
