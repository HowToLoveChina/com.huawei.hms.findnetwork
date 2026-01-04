package p031b7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.android.p069cg.p072vo.SettingsProp;
import com.huawei.hicloud.router.data.SwitchInfo;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import hk.C10278a;
import mk.C11477c;
import p015ak.C0213f;
import p015ak.C0214f0;
import p709vj.C13452e;

/* renamed from: b7.q */
/* loaded from: classes2.dex */
public class C1136q {

    /* renamed from: b7.q$a */
    public static class a {
        /* renamed from: a */
        public static void m6986a(Context context) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.remove("AccountInfoUtilaccountName");
            editorEdit.remove("AccountInfoUtilnickName");
            editorEdit.remove("AccountInfoUtilserviceToken");
            editorEdit.remove("AccountInfoUtildeviceID");
            editorEdit.remove("AccountInfoUtildeviceIDType");
            editorEdit.remove("AccountInfoUtildeviceType");
            editorEdit.remove("AccountInfoUtiluserID");
            editorEdit.remove("AccountInfoUtilsiteID");
            editorEdit.remove("AccountInfoUtilauthType");
            editorEdit.remove("AccountInfoUtilsid");
            editorEdit.remove("AccountInfoUtilsecret");
            editorEdit.remove("AccountInfoUtilclientId");
            editorEdit.remove("AccountInfoUtilphoto_num");
            editorEdit.remove("AccountInfoUtilphoto_exp");
            editorEdit.apply();
        }

        /* renamed from: b */
        public static void m6987b(Context context) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.remove("AccountInfoUtilis_log_on");
            editorEdit.apply();
        }

        /* renamed from: c */
        public static boolean m6988c(Context context) {
            return C13452e.m80781L().m80850R0();
        }
    }

    /* renamed from: b7.q$b */
    public static class b {
        /* renamed from: A */
        public static int m6989A(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("cloud_photo_locktoken_interval", 0);
        }

        /* renamed from: A0 */
        public static void m6990A0(Context context, String str) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0);
            sharedPreferencesM1382b.edit().putString("cloud_photo_device_info_response", str).commit();
            sharedPreferencesM1382b.edit().putLong("cloud_photo_device_info_response_time", System.currentTimeMillis()).commit();
        }

        /* renamed from: B */
        public static long m6991B(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_last_sync_mobile_bytes", 0L);
        }

        /* renamed from: B0 */
        public static void m6992B0(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("CGStatusUtil_disableStatus", i10).commit();
        }

        /* renamed from: C */
        public static int m6993C(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("cloud_photo_last_sync_net_type", 0);
        }

        /* renamed from: C0 */
        public static void m6994C0(boolean z10) {
            C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtil_enableWeakNetworkControl", z10).commit();
        }

        /* renamed from: D */
        public static long m6995D(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_last_sync_time", 0L);
        }

        /* renamed from: D0 */
        public static void m6996D0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_exemptionpower", j10).commit();
        }

        /* renamed from: E */
        public static long m6997E(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_last_sync_wifi_bytes", 0L);
        }

        /* renamed from: E0 */
        public static void m6998E0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_first_sync_time", j10).commit();
        }

        /* renamed from: F */
        public static int m6999F(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtil_latestSyncState", 0);
        }

        /* renamed from: F0 */
        public static void m7000F0(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("gallery_disable_support", z10).commit();
        }

        /* renamed from: G */
        public static int m7001G(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtil_latestSyncStoppedState", 0);
        }

        /* renamed from: G0 */
        public static void m7002G0(Context context, String str) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putString("gallery_disable_version", str).commit();
        }

        /* renamed from: H */
        public static long m7003H(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("CGStatusUtil_latestUpdateTime", 0L);
        }

        /* renamed from: H0 */
        public static void m7004H0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_input_code_fail_first_time", j10).commit();
        }

        /* renamed from: I */
        public static int m7005I(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("cloud_photo_leftdays", 0);
        }

        /* renamed from: I0 */
        public static void m7006I0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_input_code_fail_time", j10).commit();
        }

        /* renamed from: J */
        public static long m7007J(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_local_data_daily_interval", 0L);
        }

        /* renamed from: J0 */
        public static void m7008J0(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("cloud_photo_input_code_fail_number", i10).commit();
        }

        /* renamed from: K */
        public static long m7009K(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_local_data_daily_size", -1L);
        }

        /* renamed from: K0 */
        public static void m7010K0(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("cloud_photo_locktoken_interval", i10).commit();
        }

        /* renamed from: L */
        public static long m7011L(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_local_data_report_interval", 0L);
        }

        /* renamed from: L0 */
        public static void m7012L0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_last_sync_time", j10).commit();
        }

        /* renamed from: M */
        public static long m7013M(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_resourcescan_times", 0L);
        }

        /* renamed from: M0 */
        public static void m7014M0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_last_sync_wifi_bytes", j10).commit();
        }

        /* renamed from: N */
        public static long m7015N(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_about_response_time", 0L);
        }

        /* renamed from: N0 */
        public static void m7016N0(Context context, String str) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putString("CGStatusUtil_latestShareFversion", str);
            editorEdit.apply();
        }

        /* renamed from: O */
        public static long m7017O(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_device_info_response_time", 0L);
        }

        /* renamed from: O0 */
        public static void m7018O0(Context context, int i10) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putInt("CGStatusUtil_latestSyncState", i10);
            editorEdit.apply();
        }

        /* renamed from: P */
        public static boolean m7019P(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("CGStatusUtil_saveOriginal_force", false);
        }

        /* renamed from: P0 */
        public static void m7020P0(Context context, int i10) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putInt("CGStatusUtil_latestSyncStoppedState", i10);
            editorEdit.apply();
        }

        /* renamed from: Q */
        public static int m7021Q(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtil_saveOriginal", 0);
        }

        /* renamed from: Q0 */
        public static void m7022Q0(Context context, long j10) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putLong("CGStatusUtil_latestUpdateTime", j10);
            editorEdit.apply();
        }

        /* renamed from: R */
        public static Boolean m7023R(Context context) {
            return Boolean.valueOf(C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("CGStatusUtilscreenOnCurrentStatus", true));
        }

        /* renamed from: R0 */
        public static void m7024R0(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("cloud_photo_leftdays", i10).commit();
        }

        /* renamed from: S */
        public static long m7025S(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_shelve_deadline", -1L);
        }

        /* renamed from: S0 */
        public static void m7026S0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_local_data_daily_interval", j10).commit();
        }

        /* renamed from: T */
        public static long m7027T(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_shelve_notify", -1L);
        }

        /* renamed from: T0 */
        public static void m7028T0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_local_data_daily_size", j10).commit();
        }

        /* renamed from: U */
        public static int m7029U(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("cloud_photo_shelve_status", -2);
        }

        /* renamed from: U0 */
        public static void m7030U0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_local_data_report_interval", j10).commit();
        }

        /* renamed from: V */
        public static long m7031V(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_subscribe_last_time", 0L);
        }

        /* renamed from: V0 */
        public static void m7032V0(Context context, String str) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putString("CGStatusUtil_recycleAlbumFversion", str).apply();
        }

        /* renamed from: W */
        public static int m7033W(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtil_SyncStatus", 1);
        }

        /* renamed from: W0 */
        public static void m7034W0(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("CGStatusUtil_MetaDataSyncResult", i10).commit();
        }

        /* renamed from: X */
        public static String m7035X(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getString("cloud_photo_synctoken", "");
        }

        /* renamed from: X0 */
        public static void m7036X0(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtil_RefreshScan", z10).commit();
        }

        /* renamed from: Y */
        public static int m7037Y(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtil_ThumbDownloadNum", 500);
        }

        /* renamed from: Y0 */
        public static void m7038Y0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_resourcescan_times", j10).commit();
        }

        /* renamed from: Z */
        public static long m7039Z(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_upload_start_time", 0L);
        }

        /* renamed from: Z0 */
        public static void m7040Z0(Context context, long j10) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putLong("CGStatusUtil_resumeFlversion", j10);
            editorEdit.commit();
        }

        /* renamed from: a */
        public static void m7041a(Context context) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0);
            sharedPreferencesM1382b.edit().putInt("CGStatusUtil_autoUploadFailedCount", sharedPreferencesM1382b.getInt("CGStatusUtil_autoUploadFailedCount", 0) + 1).commit();
        }

        /* renamed from: a0 */
        public static int m7042a0(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("cloud_photo_uploaded_time", 0);
        }

        /* renamed from: a1 */
        public static void m7043a1(Context context, int i10) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putInt("CGStatusUtil_resumeStart", i10);
            editorEdit.commit();
        }

        /* renamed from: b */
        public static void m7044b(Context context) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0);
            if (sharedPreferencesM1382b.getInt("CGStatusUtil_autoUploadFailedCount", 0) != 0) {
                sharedPreferencesM1382b.edit().putInt("CGStatusUtil_autoUploadFailedCount", 0).commit();
            }
        }

        /* renamed from: b0 */
        public static boolean m7045b0() {
            return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("CGStatusUtil_weakNetworkProgressFlag", false);
        }

        /* renamed from: b1 */
        public static void m7046b1(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtil_saveOriginal_force", z10).commit();
        }

        /* renamed from: c */
        public static void m7047c(Context context) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0);
            if (sharedPreferencesM1382b.getInt("CGStatusUtil_autoUploadRetryCount", 0) != 0) {
                sharedPreferencesM1382b.edit().putInt("CGStatusUtil_autoUploadRetryCount", 0).commit();
            }
        }

        /* renamed from: c0 */
        public static int m7048c0() {
            return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtil_weakNetworkRssiThreshold", -75);
        }

        /* renamed from: c1 */
        public static void m7049c1(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("CGStatusUtil_saveOriginal", i10).commit();
        }

        /* renamed from: d */
        public static void m7050d(Context context) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.remove("CGStatusUtilbatteryCurrentLevel");
            editorEdit.remove("CGStatusUtilbatteryCurrentStatus");
            editorEdit.remove("CGStatusUtilbatteryLoseStartLevel");
            editorEdit.remove("CGStatusUtilbatteryLowStatus");
            editorEdit.remove("CGStatusUtilchargePlugStatus");
            editorEdit.remove("CGStatusUtiluserCapacityUsed");
            editorEdit.remove("CGStatusUtiluserCapacityTotal");
            editorEdit.remove("CGStatusUtiluserCapacityRecordTime");
            editorEdit.remove("CGStatusUtildownloadFailNum");
            editorEdit.remove("CGStatusUtilcloudPhotoAuthFailedTime");
            editorEdit.remove("CGStatusUtil_userSpace");
            editorEdit.remove("CGStatusUtil_autoUploadFailedCount");
            editorEdit.remove("CGStatusUtil_autoUploadRetryCount");
            editorEdit.remove("CGStatusUtil_albumFversion");
            editorEdit.remove("CGStatusUtil_shareFversion");
            editorEdit.remove("CGStatusUtil_latestShareFversion");
            editorEdit.remove("CGStatusUtil_resumeFlversion");
            editorEdit.remove("CGStatusUtil_resumeStart");
            editorEdit.remove("CGStatusUtil_latestUpdateTime");
            editorEdit.remove("CGStatusUtil_latestSyncState");
            editorEdit.remove("CGStatusUtil_latestSyncStoppedState");
            editorEdit.remove("CGStatusUtil_fileTransfer");
            editorEdit.remove("CGStatusUtil_recycleBin");
            editorEdit.remove("CGStatusUtil_cloudAlbumSdk");
            editorEdit.remove("CGStatusUtil_UserConfirm");
            editorEdit.remove("CGStatusUtil_SyncStatus");
            editorEdit.remove("CGStatusUtil_RefreshScan");
            editorEdit.remove("CGStatusUtil_ChangeStateScan");
            editorEdit.remove("CGStatusUtil_ChangePowerScan");
            editorEdit.remove("CGStatusUtil_MetaDataSyncResult");
            editorEdit.remove("CGStatusUtil_AutoUploadMaxNum");
            editorEdit.remove("CGStatusUtil_AutoUploadMaxSize");
            editorEdit.remove("CGStatusUtil_AutoUploadMaxSizeLong");
            editorEdit.remove("CGStatusUtil_AutoDownloadMaxNum");
            editorEdit.remove("CGStatusUtil_ThumbDownloadNum");
            editorEdit.remove("CGStatusUtil_smartAlbum");
            editorEdit.remove("CGStatusUtil_recycleAlbumFversion");
            editorEdit.remove("CGStatusUtil_filesErrorCreateTimeCheck");
            editorEdit.remove("CGStatusUtil_lastestRunningVersion");
            editorEdit.remove("CGStatusUtil_lastUploadDomain");
            editorEdit.remove("CGStatusUtil_lastUploadIp");
            editorEdit.remove("CGStatusUtil_downloadCloudFile");
            editorEdit.remove("CGStatusUtil_saveOriginal");
            editorEdit.remove("CGStatusUtil_saveOriginal_type");
            editorEdit.remove("CGStatusUtil_disableStatus");
            editorEdit.remove("CGStatusUtil_shelveNotifyMarker");
            editorEdit.remove("gallery_disable_version");
            editorEdit.remove("gallery_disable_support");
            editorEdit.remove("cloud_photo_shelve_status");
            editorEdit.remove("cloud_photo_shelve_deadline");
            editorEdit.remove("cloud_photo_shelve_notify");
            editorEdit.remove("cloud_photo_local_data_report_interval");
            editorEdit.remove("cloud_photo_local_data_daily_interval");
            editorEdit.remove("cloud_photo_local_data_daily_size");
            editorEdit.remove("cloud_photo_subscribe_last_time");
            editorEdit.remove("cloud_photo_about_response");
            editorEdit.remove("cloud_photo_about_response_time");
            editorEdit.remove("cloud_photo_device_info_response");
            editorEdit.remove("cloud_photo_device_info_response_time");
            editorEdit.remove("cloud_photo_input_code_fail_time");
            editorEdit.remove("cloud_photo_input_code_fail_number");
            editorEdit.remove("cloud_photo_input_code_fail_first_time");
            editorEdit.remove("cloud_photo_last_sync_wifi_bytes");
            editorEdit.remove("cloud_photo_last_sync_mobile_bytes");
            editorEdit.remove("cloud_photo_exemptionpower");
            editorEdit.remove("cloud_photo_first_sync_time");
            editorEdit.remove("cloud_photo_last_sync_time");
            editorEdit.remove("cloud_photo_uploaded_time");
            editorEdit.remove("cloud_photo_upload_start_time");
            editorEdit.remove("atlas_transfer_complete");
            editorEdit.remove("network_enable_notification_base_user_time");
            editorEdit.commit();
        }

        /* renamed from: d0 */
        public static boolean m7051d0(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("CGStatusUtil_shelveNotifyMarker", false);
        }

        /* renamed from: d1 */
        public static void m7052d1(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("CGStatusUtil_saveOriginal_type", i10).commit();
        }

        /* renamed from: e */
        public static String m7053e(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getString("cloud_photo_about_response", "");
        }

        /* renamed from: e0 */
        public static boolean m7054e0(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("CGStatusUtilLowBatteryStatus", false);
        }

        /* renamed from: e1 */
        public static void m7055e1(Context context, String str) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putString("CGStatusUtil_shareFversion", str);
            editorEdit.apply();
        }

        /* renamed from: f */
        public static String m7056f(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getString("CGStatusUtil_albumFversion", "-1");
        }

        /* renamed from: f0 */
        public static boolean m7057f0(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("CGStatusUtilbatteryLowStatus", false);
        }

        /* renamed from: f1 */
        public static void m7058f1(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtil_shelveNotifyMarker", z10).commit();
        }

        /* renamed from: g */
        public static long m7059g(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("CGStatusUtilcloudPhotoAuthFailedTime", 0L);
        }

        /* renamed from: g0 */
        public static boolean m7060g0(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("cloud_photo_first_sync_complete", true);
        }

        /* renamed from: g1 */
        public static void m7061g1(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_shelve_notify", j10).commit();
        }

        /* renamed from: h */
        public static int m7062h(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtil_AutoDownloadMaxNum", 2000);
        }

        /* renamed from: h0 */
        public static boolean m7063h0(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("cloud_photo_incremental_sync_complete", false);
        }

        /* renamed from: h1 */
        public static void m7064h1(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_subscribe_last_time", j10).commit();
        }

        /* renamed from: i */
        public static int m7065i(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtil_autoUploadFailedCount", 0);
        }

        /* renamed from: i0 */
        public static boolean m7066i0(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("cloud_photo_sync_complete", false);
        }

        /* renamed from: i1 */
        public static void m7067i1(Context context, String str) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putString("cloud_photo_synctoken", str).commit();
        }

        /* renamed from: j */
        public static int m7068j(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtil_AutoUploadMaxNum", 500);
        }

        /* renamed from: j0 */
        public static boolean m7069j0(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("gallery_disable_support", false);
        }

        /* renamed from: j1 */
        public static void m7070j1(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("CGStatusUtil_ThumbDownloadNum", i10).commit();
        }

        /* renamed from: k */
        public static long m7071k(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("CGStatusUtil_AutoUploadMaxSizeLong", 2147483648L);
        }

        /* renamed from: k0 */
        public static boolean m7072k0(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("CGStatusUtil_userSpace", false);
        }

        /* renamed from: k1 */
        public static void m7073k1(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_upload_start_time", j10).commit();
        }

        /* renamed from: l */
        public static int m7074l(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtilbatteryCurrentLevel", 100);
        }

        /* renamed from: l0 */
        public static void m7075l0(Context context, String str) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0);
            sharedPreferencesM1382b.edit().putString("cloud_photo_about_response", str).commit();
            sharedPreferencesM1382b.edit().putLong("cloud_photo_about_response_time", System.currentTimeMillis()).commit();
        }

        /* renamed from: l1 */
        public static void m7076l1(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("cloud_photo_uploaded_time", i10).commit();
        }

        /* renamed from: m */
        public static int m7077m(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtilbatteryCurrentStatus", 1);
        }

        /* renamed from: m0 */
        public static void m7078m0(Context context, String str) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putString("CGStatusUtil_albumFversion", str);
            editorEdit.commit();
        }

        /* renamed from: m1 */
        public static void m7079m1(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtil_UserConfirm", z10).commit();
        }

        /* renamed from: n */
        public static int m7080n(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtilchargePlugStatus", -1);
        }

        /* renamed from: n0 */
        public static void m7081n0(Context context, boolean z10) {
            C1120a.m6677i("CGStatusUtil", "setAtlasTransferComplete: " + z10);
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("atlas_transfer_complete", z10).commit();
        }

        /* renamed from: n1 */
        public static void m7082n1(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtil_userSpace", z10).commit();
        }

        /* renamed from: o */
        public static boolean m7083o() {
            return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("CGStatusUtil_checkingWeakNetworkFlag", false);
        }

        /* renamed from: o0 */
        public static void m7084o0(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("CGStatusUtil_AutoDownloadMaxNum", i10).commit();
        }

        /* renamed from: o1 */
        public static void m7085o1(boolean z10) {
            C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtil_weakNetworkProgressFlag", z10).commit();
        }

        /* renamed from: p */
        public static long m7086p(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_sync_time", 0L);
        }

        /* renamed from: p0 */
        public static void m7087p0(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("CGStatusUtil_AutoUploadMaxNum", i10).commit();
        }

        /* renamed from: p1 */
        public static void m7088p1(int i10) {
            C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("CGStatusUtil_weakNetworkRssiThreshold", i10).commit();
        }

        /* renamed from: q */
        public static long m7089q(Context context, String str) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("CGStatusUtil" + str, 0L);
        }

        /* renamed from: q0 */
        public static void m7090q0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("CGStatusUtil_AutoUploadMaxSizeLong", j10).commit();
        }

        /* renamed from: q1 */
        public static void m7091q1(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_last_sync_mobile_bytes", j10).commit();
        }

        /* renamed from: r */
        public static String m7092r(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getString("cloud_photo_device_info_response", "");
        }

        /* renamed from: r0 */
        public static void m7093r0(Context context, boolean z10) {
            C1120a.m6677i("CGStatusUtil", "setBatteryLevelLow: " + z10);
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtilLowBatteryStatus", z10).commit();
        }

        /* renamed from: r1 */
        public static void m7094r1(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("cloud_photo_last_sync_net_type", i10).commit();
        }

        /* renamed from: s */
        public static int m7095s(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("CGStatusUtil_disableStatus", -2);
        }

        /* renamed from: s0 */
        public static void m7096s0(Context context, boolean z10) {
            C1120a.m6677i("CGStatusUtil", "setBatteryLevelTooLow: " + z10);
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtilbatteryLowStatus", z10).commit();
        }

        /* renamed from: s1 */
        public static void m7097s1(Context context, int i10, long j10) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putInt("cloud_photo_shelve_status", i10);
            editorEdit.putLong("cloud_photo_shelve_deadline", j10);
            editorEdit.commit();
        }

        /* renamed from: t */
        public static boolean m7098t() {
            return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("CGStatusUtil_enableWeakNetworkControl", false);
        }

        /* renamed from: t0 */
        public static void m7099t0(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtil_ChangePowerScan", z10).commit();
        }

        /* renamed from: t1 */
        public static void m7100t1(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("CGStatusUtilcloudPhotoAuthFailedTime", j10).commit();
        }

        /* renamed from: u */
        public static long m7101u(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_exemptionpower", 0L);
        }

        /* renamed from: u0 */
        public static void m7102u0(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtil_ChangeStateScan", z10).commit();
        }

        /* renamed from: u1 */
        public static void m7103u1(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("CGStatusUtilbatteryCurrentLevel", i10).commit();
        }

        /* renamed from: v */
        public static long m7104v(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_first_sync_time", 0L);
        }

        /* renamed from: v0 */
        public static void m7105v0(boolean z10) {
            C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtil_checkingWeakNetworkFlag", z10).commit();
        }

        /* renamed from: v1 */
        public static void m7106v1(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("CGStatusUtilbatteryCurrentStatus", i10).commit();
        }

        /* renamed from: w */
        public static String m7107w(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getString("gallery_disable_version", null);
        }

        /* renamed from: w0 */
        public static void m7108w0(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("cloud_photo_first_sync_complete", z10).commit();
        }

        /* renamed from: w1 */
        public static void m7109w1(Context context, int i10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("CGStatusUtilchargePlugStatus", i10).commit();
        }

        /* renamed from: x */
        public static long m7110x(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_input_code_fail_first_time", 0L);
        }

        /* renamed from: x0 */
        public static void m7111x0(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("cloud_photo_incremental_sync_complete", z10).commit();
        }

        /* renamed from: x1 */
        public static void m7112x1(Context context, String str, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("CGStatusUtil" + str, j10).commit();
        }

        /* renamed from: y */
        public static long m7113y(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getLong("cloud_photo_input_code_fail_time", 0L);
        }

        /* renamed from: y0 */
        public static void m7114y0(Context context, long j10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("cloud_photo_sync_time", j10).commit();
        }

        /* renamed from: y1 */
        public static void m7115y1(Context context, Boolean bool) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("CGStatusUtilscreenOnCurrentStatus", bool.booleanValue()).commit();
        }

        /* renamed from: z */
        public static int m7116z(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getInt("cloud_photo_input_code_fail_number", 0);
        }

        /* renamed from: z0 */
        public static void m7117z0(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("cloud_photo_sync_complete", z10).commit();
        }
    }

    /* renamed from: b7.q$c */
    public static class c {
        /* renamed from: a */
        public static SettingsProp m7118a(Context context) {
            SettingsProp settingsProp = new SettingsProp();
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0);
            settingsProp.setThumbWidth(sharedPreferencesM1382b.getInt("thumb_width", 0));
            settingsProp.setThumbHeight(sharedPreferencesM1382b.getInt("thumb_height", 0));
            settingsProp.setLcdWidth(sharedPreferencesM1382b.getInt("lcd_width", 0));
            settingsProp.setLcdHeight(sharedPreferencesM1382b.getInt("lcd_height", 0));
            settingsProp.setInternalRootPath(sharedPreferencesM1382b.getString("internal_root_path", null));
            settingsProp.setExternalRootPath(sharedPreferencesM1382b.getString("external_root_path", null));
            settingsProp.setThumbCachePath(sharedPreferencesM1382b.getString("thumb_cache_path", null));
            settingsProp.setLcdCachePath(sharedPreferencesM1382b.getString("lcd_cache_path", null));
            settingsProp.setDownloadPath(sharedPreferencesM1382b.getString("download_path", null));
            settingsProp.setAutoLcdNum(sharedPreferencesM1382b.getInt("auto_lcd_num", 2000));
            return settingsProp;
        }

        /* renamed from: b */
        public static boolean m7119b(SharedPreferences.Editor editor, String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                return true;
            }
            if (!C10278a.m63442h(str2).isDirectory()) {
                return false;
            }
            editor.putString(str, str2);
            return true;
        }

        /* renamed from: c */
        public static void m7120c(SharedPreferences.Editor editor, String str, int i10) {
            if (i10 >= 0) {
                editor.putInt(str, i10);
            }
        }

        /* renamed from: d */
        public static void m7121d(SharedPreferences.Editor editor, String str, int i10) {
            if (i10 > 0) {
                editor.putInt(str, i10);
            }
        }

        /* renamed from: e */
        public static void m7122e(Context context) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putInt("thumb_width", HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            editorEdit.putInt("thumb_height", HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            editorEdit.putInt("lcd_width", 1080);
            editorEdit.putInt("lcd_height", 1920);
            editorEdit.putString("thumb_cache_path", C1124e.m6870n(context));
            editorEdit.putInt("auto_lcd_num", 2000);
            editorEdit.apply();
        }

        /* renamed from: f */
        public static void m7123f(Context context, SettingsProp settingsProp) {
            if (settingsProp == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            int thumbWidth = settingsProp.getThumbWidth();
            int thumbHeight = settingsProp.getThumbHeight();
            int lcdWidth = settingsProp.getLcdWidth();
            int lcdHeight = settingsProp.getLcdHeight();
            m7121d(editorEdit, "thumb_width", thumbWidth);
            m7121d(editorEdit, "thumb_height", thumbHeight);
            m7121d(editorEdit, "lcd_width", lcdWidth);
            m7121d(editorEdit, "lcd_height", lcdHeight);
            String internalRootPath = settingsProp.getInternalRootPath();
            String externalRootPath = settingsProp.getExternalRootPath();
            String thumbCachePath = settingsProp.getThumbCachePath();
            String lcdCachePath = settingsProp.getLcdCachePath();
            String downloadPath = settingsProp.getDownloadPath();
            boolean zM7119b = m7119b(editorEdit, "internal_root_path", internalRootPath);
            boolean zM7119b2 = m7119b(editorEdit, "external_root_path", externalRootPath);
            if (zM7119b && zM7119b2) {
                editorEdit.putString("thumb_cache_path", thumbCachePath);
                editorEdit.putString("lcd_cache_path", lcdCachePath);
                editorEdit.putString("download_path", downloadPath);
            }
            m7120c(editorEdit, "auto_lcd_num", settingsProp.getAutoLcdNum());
            editorEdit.apply();
        }
    }

    /* renamed from: b7.q$d */
    public static class d {
        @SuppressLint({"ApplySharedPref"})
        /* renamed from: A */
        public static void m7124A(String str) {
            m7154r().edit().putString("DriveStatus_dataVersion", str).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: B */
        public static void m7125B(String str) {
            m7154r().edit().putString("DriveStatus_latestVersion", str).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: C */
        public static void m7126C(String str) {
            m7154r().edit().putString("_lostNextCursor", str).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: D */
        public static void m7127D(int i10) {
            m7154r().edit().putInt("DriveStatus_maxBatchGetNum", i10).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: E */
        public static void m7128E(int i10) {
            m7154r().edit().putInt("DriveStatus_maxBatchNum", i10).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: F */
        public static void m7129F(int i10) {
            m7154r().edit().putInt("DriveStatus_maxBatchUpdateNumber", i10).apply();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: G */
        public static void m7130G(int i10) {
            m7154r().edit().putInt("DriveStatus_maxShareNumber", i10).apply();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: H */
        public static void m7131H(String str) {
            m7154r().edit().putString("DriveStatus_permissionId", str).apply();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: I */
        public static void m7132I(String str) {
            m7154r().edit().putString("DriveStatus_pushToken", C11477c.m68636f(str)).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: J */
        public static void m7133J(String str) {
            m7154r().edit().putString("DriveStatus_shareVersion", str).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: K */
        public static void m7134K(String str) {
            m7154r().edit().putString("DriveStatus_topAlbumId", str).apply();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: L */
        public static void m7135L(int i10) {
            m7154r().edit().putInt("DriveStatus_v2Cut", i10).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: M */
        public static void m7136M(boolean z10) {
            m7154r().edit().putBoolean("DriveStatus_v2CutDataHasCleared", z10).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: a */
        public static void m7137a() {
            SharedPreferences sharedPreferencesM7154r = m7154r();
            sharedPreferencesM7154r.edit().putInt("DriveStatus_clearCloudCacheCount", sharedPreferencesM7154r.getInt("DriveStatus_clearCloudCacheCount", 0) + 1).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: b */
        public static void m7138b(boolean z10) {
            SharedPreferences.Editor editorEdit = m7154r().edit();
            if (z10) {
                editorEdit.remove("DriveStatus_dataVersion");
                editorEdit.remove("DriveStatus_v2Cut");
                editorEdit.remove("DriveStatus_v2CutDataHasCleared");
                editorEdit.remove("DriveStatus_pushToken");
                editorEdit.remove("DriveStatus_clearCloudCacheCount");
                editorEdit.remove("DriveStatus_permissionId");
                editorEdit.remove("DriveStatus_topAlbumId");
            }
            editorEdit.remove("DriveStatus_clearVersion");
            editorEdit.remove("DriveStatus_latestVersion");
            editorEdit.remove("DriveStatus_albumVersion");
            editorEdit.remove("DriveStatus_albumListVersion");
            editorEdit.remove("DriveStatus_shareVersion");
            editorEdit.remove("DriveStatus_recycleVersion");
            editorEdit.remove("DriveStatus_maxBatchNum");
            editorEdit.remove("DriveStatus_maxBatchGetNum");
            editorEdit.remove("DriveStatus_maxShareNumber");
            editorEdit.remove("DriveStatus_maxBatchUpdateNumber");
            editorEdit.remove("_lostNextCursor");
            editorEdit.remove("DriveStatus_clearUserKeyTime");
            editorEdit.commit();
        }

        /* renamed from: c */
        public static String m7139c() {
            return m7154r().getString("DriveStatus_albumListVersion", "");
        }

        /* renamed from: d */
        public static String m7140d() {
            return m7154r().getString("DriveStatus_albumVersion", "");
        }

        /* renamed from: e */
        public static int m7141e() {
            return m7154r().getInt("DriveStatus_clearCloudCacheCount", 0);
        }

        /* renamed from: f */
        public static long m7142f() {
            return m7154r().getLong("DriveStatus_clearUserKeyTime", 0L);
        }

        /* renamed from: g */
        public static String m7143g() {
            return m7154r().getString("DriveStatus_clearVersion", "");
        }

        /* renamed from: h */
        public static String m7144h() {
            return m7154r().getString("DriveStatus_dataVersion", "");
        }

        /* renamed from: i */
        public static String m7145i() {
            return m7154r().getString("DriveStatus_latestVersion", "");
        }

        /* renamed from: j */
        public static String m7146j() {
            return m7154r().getString("_lostNextCursor", null);
        }

        /* renamed from: k */
        public static int m7147k() {
            return m7154r().getInt("DriveStatus_maxBatchGetNum", 10);
        }

        /* renamed from: l */
        public static int m7148l() {
            return m7154r().getInt("DriveStatus_maxBatchNum", 6);
        }

        /* renamed from: m */
        public static int m7149m() {
            return m7154r().getInt("DriveStatus_maxBatchUpdateNumber", 10);
        }

        /* renamed from: n */
        public static int m7150n() {
            return m7154r().getInt("DriveStatus_maxShareNumber", 20);
        }

        /* renamed from: o */
        public static String m7151o() {
            return m7154r().getString("DriveStatus_permissionId", null);
        }

        /* renamed from: p */
        public static String m7152p() {
            return C11477c.m68633c(m7154r().getString("DriveStatus_pushToken", null));
        }

        /* renamed from: q */
        public static String m7153q() {
            return m7154r().getString("DriveStatus_shareVersion", "");
        }

        /* renamed from: r */
        public static SharedPreferences m7154r() {
            return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0);
        }

        /* renamed from: s */
        public static String m7155s() {
            return m7154r().getString("DriveStatus_topAlbumId", "");
        }

        /* renamed from: t */
        public static int m7156t() {
            return m7154r().getInt("DriveStatus_v2Cut", -1);
        }

        /* renamed from: u */
        public static boolean m7157u() {
            return m7154r().getBoolean("DriveStatus_v2CutDataHasCleared", false);
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: v */
        public static void m7158v() {
            m7154r().edit().putInt("DriveStatus_clearCloudCacheCount", 0).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: w */
        public static void m7159w(String str) {
            m7154r().edit().putString("DriveStatus_albumListVersion", str).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: x */
        public static void m7160x(String str) {
            m7154r().edit().putString("DriveStatus_albumVersion", str).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: y */
        public static void m7161y(long j10) {
            m7154r().edit().putLong("DriveStatus_clearUserKeyTime", j10).commit();
        }

        @SuppressLint({"ApplySharedPref"})
        /* renamed from: z */
        public static void m7162z(String str) {
            m7154r().edit().putString("DriveStatus_clearVersion", str).commit();
        }
    }

    /* renamed from: b7.q$e */
    public static class e {
        /* renamed from: a */
        public static void m7163a(Context context) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putBoolean("SwitchHelperUtilisSmartLoading", false);
            editorEdit.apply();
        }

        /* renamed from: b */
        public static void m7164b(Context context) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.remove("SwitchHelperUtilisShareAlbumOn");
            editorEdit.remove("SwitchHelperUtilisCloudAlbumOn");
            editorEdit.remove("SwitchHelperUtilinheritisCloudAlbumOn");
            editorEdit.remove("SwitchHelperUtilinheritisOpenCloudAlbumOn");
            editorEdit.remove("SwitchHelperUtilisSmartAlbumOn");
            editorEdit.remove("SwitchHelperUtilisSmartLoading");
            editorEdit.remove("SwitchHelperUtilSwitchReportStatus");
            editorEdit.apply();
        }

        /* renamed from: c */
        public static int m7165c(Context context) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0);
            if (sharedPreferencesM1382b.contains("SwitchHelperUtilinheritisCloudAlbumOn")) {
                return sharedPreferencesM1382b.getBoolean("SwitchHelperUtilinheritisCloudAlbumOn", false) ? 1 : 0;
            }
            return -1;
        }

        /* renamed from: d */
        public static boolean m7166d(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("SwitchHelperUtilisCloudAlbumOn", false);
        }

        /* renamed from: e */
        public static boolean m7167e(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("SwitchHelperUtilinheritisCloudAlbumOn", true);
        }

        /* renamed from: f */
        public static boolean m7168f(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("SwitchHelperUtilMobileSwitchReportStatus", true);
        }

        /* renamed from: g */
        public static boolean m7169g(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("SwitchHelperUtilinheritisOpenCloudAlbumOn", false);
        }

        /* renamed from: h */
        public static boolean m7170h(Context context) {
            if (C1137r.m7180a()) {
                return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("SwitchHelperUtilisSmartAlbumOn", false);
            }
            return false;
        }

        /* renamed from: i */
        public static boolean m7171i(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("SwitchHelperUtilisSmartLoading", false);
        }

        /* renamed from: j */
        public static boolean m7172j(Context context) {
            return C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("SwitchHelperUtilSwitchReportStatus", false);
        }

        /* renamed from: k */
        public static SwitchInfo m7173k(Context context) {
            SwitchInfo switchInfo = new SwitchInfo();
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0);
            switchInfo.setGeneralAlbumOn(sharedPreferencesM1382b.getBoolean("SwitchHelperUtilisCloudAlbumOn", false));
            switchInfo.setShareAlbumOn(sharedPreferencesM1382b.getBoolean("SwitchHelperUtilisShareAlbumOn", false));
            if (C1137r.m7180a()) {
                switchInfo.setSmartAlbumOn(sharedPreferencesM1382b.getBoolean("SwitchHelperUtilisSmartAlbumOn", false));
            } else {
                switchInfo.setSmartAlbumOn(false);
            }
            return switchInfo;
        }

        /* renamed from: l */
        public static void m7174l(Boolean bool, Context context) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putBoolean("SwitchHelperUtilisCloudAlbumOn", bool.booleanValue());
            editorEdit.commit();
        }

        /* renamed from: m */
        public static void m7175m(boolean z10, Context context) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putBoolean("SwitchHelperUtilinheritisCloudAlbumOn", z10);
            editorEdit.commit();
        }

        /* renamed from: n */
        public static void m7176n(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("SwitchHelperUtilMobileSwitchReportStatus", z10).commit();
        }

        /* renamed from: o */
        public static void m7177o(boolean z10, Context context) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putBoolean("SwitchHelperUtilinheritisOpenCloudAlbumOn", z10);
            editorEdit.commit();
        }

        /* renamed from: p */
        public static void m7178p(Boolean bool, Context context) {
            SharedPreferences.Editor editorEdit = C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
            editorEdit.putBoolean("SwitchHelperUtilisSmartAlbumOn", bool.booleanValue());
            editorEdit.commit();
        }

        /* renamed from: q */
        public static void m7179q(Context context, boolean z10) {
            C0214f0.m1382b(context, "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("SwitchHelperUtilSwitchReportStatus", z10).commit();
        }
    }

    /* renamed from: A */
    public static void m6943A(long j10) {
        C1120a.m6677i("SPUtil", "setLatestOBSFlowControlTime: " + j10);
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("latest_obs_flow_control_time", j10).apply();
    }

    /* renamed from: B */
    public static void m6944B(long j10) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("latest_reset_time", j10).apply();
    }

    /* renamed from: C */
    public static void m6945C() {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("latest_thumb_clear_time", System.currentTimeMillis()).apply();
    }

    /* renamed from: D */
    public static void m6946D(String str) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putString("latestVersion", str).apply();
    }

    /* renamed from: E */
    public static void m6947E(int i10) {
        C1120a.m6677i("SPUtil", "setNetworkEnableNotificationShownCount: " + i10);
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("network_enable_notification_shown_count", i10).apply();
    }

    /* renamed from: F */
    public static void m6948F() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1120a.m6677i("SPUtil", "setNotificationTime: " + jCurrentTimeMillis);
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("network_enable_notification_base_user_time", jCurrentTimeMillis).apply();
    }

    /* renamed from: G */
    public static void m6949G(int i10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0);
        C1120a.m6677i("SPUtil", "setOBSFlowControlCount count: " + i10);
        sharedPreferencesM1382b.edit().putInt("obs_flow_control_count", i10).apply();
    }

    /* renamed from: H */
    public static void m6950H(int i10) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("obs_flow_control_interval_time", i10).apply();
    }

    /* renamed from: I */
    public static void m6951I() {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("latestGalleryReportTime", System.currentTimeMillis()).apply();
    }

    /* renamed from: J */
    public static void m6952J(boolean z10) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putBoolean("isUploadCursorUsed", z10).apply();
    }

    /* renamed from: K */
    public static void m6953K(int i10) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("user_data_period", i10).apply();
    }

    /* renamed from: L */
    public static void m6954L(int i10) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("user_data_status", i10).apply();
        C13452e.m80781L().m80893b2(i10);
    }

    /* renamed from: M */
    public static void m6955M(long j10) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("user_data_validity_period", j10).commit();
    }

    /* renamed from: N */
    public static void m6956N(long j10) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("latest_re_found_time", j10).apply();
    }

    /* renamed from: O */
    public static void m6957O(long j10) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("latest_thumb_fix_time", j10).apply();
    }

    /* renamed from: P */
    public static void m6958P() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0);
        int iM6972m = m6972m() + 1;
        C1120a.m6677i("SPUtil", "setNetworkEnableNotificationShownCount: " + iM6972m);
        sharedPreferencesM1382b.edit().putInt("network_enable_notification_shown_count", iM6972m).apply();
    }

    /* renamed from: Q */
    public static void m6959Q() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0);
        int iM6973n = m6973n() + 1;
        C1120a.m6677i("SPUtil", "updateOBSFlowControlCount count: " + iM6973n);
        sharedPreferencesM1382b.edit().putInt("obs_flow_control_count", iM6973n).apply();
    }

    /* renamed from: a */
    public static int m6960a() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getInt("clear_count", 0);
    }

    /* renamed from: b */
    public static long m6961b(String str) {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getLong(str, 0L);
    }

    /* renamed from: c */
    public static String m6962c() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getString("fullUploadCursor", "");
    }

    /* renamed from: d */
    public static long m6963d() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getLong("last_network_enable_notification_time", 0L);
    }

    /* renamed from: e */
    public static long m6964e() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getLong("network_enable_notification_base_user_time", 0L);
    }

    /* renamed from: f */
    public static long m6965f() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getLong("latest_clear_time", 0L);
    }

    /* renamed from: g */
    public static long m6966g() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getLong("latest_obs_flow_control_time", 0L);
    }

    /* renamed from: h */
    public static long m6967h() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getLong("latest_re_found_time", 0L);
    }

    /* renamed from: i */
    public static long m6968i() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getLong("latest_reset_time", 0L);
    }

    /* renamed from: j */
    public static long m6969j() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getLong("latest_thumb_clear_time", 0L);
    }

    /* renamed from: k */
    public static long m6970k() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getLong("latest_thumb_fix_time", 0L);
    }

    /* renamed from: l */
    public static String m6971l() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getString("latestVersion", "");
    }

    /* renamed from: m */
    public static int m6972m() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getInt("network_enable_notification_shown_count", 0);
    }

    /* renamed from: n */
    public static int m6973n() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getInt("obs_flow_control_count", 0);
    }

    /* renamed from: o */
    public static int m6974o() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getInt("obs_flow_control_interval_time", 0);
    }

    /* renamed from: p */
    public static long m6975p() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getLong("latestGalleryReportTime", 0L);
    }

    /* renamed from: q */
    public static int m6976q() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getInt("user_data_period", -1);
    }

    /* renamed from: r */
    public static int m6977r() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getInt("user_data_status", -1);
    }

    /* renamed from: s */
    public static boolean m6978s() {
        C1120a.m6677i("SPUtil", "user data status is : " + m6977r());
        return m6977r() != 1;
    }

    /* renamed from: t */
    public static boolean m6979t() {
        return C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getBoolean("isUploadCursorUsed", false);
    }

    /* renamed from: u */
    public static boolean m6980u(long j10) {
        long j11 = C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).getLong("user_data_validity_period", 0L);
        return j11 < 1 || j10 - j11 > C5863b6.g.f26453g;
    }

    /* renamed from: v */
    public static void m6981v(String str, long j10) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong(str, j10).apply();
    }

    /* renamed from: w */
    public static void m6982w(int i10) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putInt("clear_count", i10).apply();
    }

    /* renamed from: x */
    public static void m6983x(String str) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putString("fullUploadCursor", str).apply();
    }

    /* renamed from: y */
    public static void m6984y(long j10) {
        C1120a.m6677i("SPUtil", "setLastNetworkEnableNotificationTime: " + j10);
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("last_network_enable_notification_time", j10).apply();
    }

    /* renamed from: z */
    public static void m6985z(long j10) {
        C0214f0.m1382b(C0213f.m1377a(), "com.huawei.android.cg.fileshare.SETTING", 0).edit().putLong("latest_clear_time", j10).apply();
    }
}
