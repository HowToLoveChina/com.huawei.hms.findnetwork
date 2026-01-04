package p521og;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import p013ah.C0198c;
import p015ak.C0214f0;
import p575qe.C12347f;
import p809yg.C13981a;

/* renamed from: og.j */
/* loaded from: classes4.dex */
public class C11877j {

    /* renamed from: og.j$a */
    public static class a {
        /* renamed from: a */
        public static void m71321a(Context context) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
            if (sharedPreferencesM1382b == null) {
                C13981a.m83988e("SharedPreferenceUtil", "sp is null");
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            editorEdit.remove("phone_finder_switch_status");
            editorEdit.commit();
        }

        /* renamed from: b */
        public static void m71322b(boolean z10, Context context) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
            if (sharedPreferencesM1382b == null) {
                C13981a.m83988e("SharedPreferenceUtil", "sp is null");
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            if (z10) {
                editorEdit.putInt("phone_finder_switch_status", 1);
            } else {
                editorEdit.putInt("phone_finder_switch_status", 0);
            }
            editorEdit.commit();
        }

        /* renamed from: c */
        public static void m71323c(boolean z10, Context context) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
            if (sharedPreferencesM1382b == null) {
                C13981a.m83988e("SharedPreferenceUtil", "sp is null");
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            if (z10) {
                editorEdit.putInt("phone_finder_switch_status", 1);
            } else {
                editorEdit.putInt("phone_finder_switch_status", 0);
            }
            editorEdit.commit();
        }
    }

    /* renamed from: A */
    public static boolean m71196A(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("unbinding_challenge_check", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: A0 */
    public static void m71197A0(Context context, boolean z10) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 0);
        if (sharedPreferences == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("hasRequestToken", z10);
        editorEdit.commit();
    }

    /* renamed from: B */
    public static boolean m71198B(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("has_handle_settings_sugg", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: B0 */
    public static void m71199B0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("has_set_hms_logout_intent", true);
        editorEdit.commit();
    }

    /* renamed from: C */
    public static boolean m71200C(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("has_set_hms_logout_intent", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: C0 */
    public static void m71201C0(Context context, int i10) {
        if (context == null) {
            C13981a.m83988e("SharedPreferenceUtil", "context is null");
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putInt("need_report_lost_mode_result", i10);
        editorEdit.commit();
    }

    /* renamed from: D */
    public static boolean m71202D(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("phone_finder_lastlocation_switch_status", true);
        }
        return true;
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: D0 */
    public static void m71203D0(Context context, boolean z10) {
        if (context == null) {
            C13981a.m83988e("SharedPreferenceUtil", "context is null");
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("need_report_lost_mode", z10);
        editorEdit.commit();
    }

    /* renamed from: E */
    public static boolean m71204E(Context context) {
        if (context == null) {
            C13981a.m83988e("SharedPreferenceUtil", "context is null");
            return false;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("need_report_lost_mode", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: E0 */
    public static void m71205E0(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("client_push_sign_pk", C11869b.m71143j(context, str));
        editorEdit.commit();
    }

    /* renamed from: F */
    public static boolean m71206F(Context context) {
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return System.currentTimeMillis() - sharedPreferencesM1382b.getLong("network_sim_info_update_time", 0L) < 300000;
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: F0 */
    public static void m71207F0(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("client_push_sign_pk_v11", C11869b.m71143j(context, str));
        editorEdit.commit();
    }

    /* renamed from: G */
    public static void m71208G(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("has_handle_settings_sugg", true);
        editorEdit.commit();
    }

    /* renamed from: G0 */
    public static void m71209G0(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("phonefinder_push_token", C0198c.m1098b(context, str));
        editorEdit.commit();
    }

    /* renamed from: H */
    public static void m71210H(Context context, long j10) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putLong("request_location_permission_time", j10);
        editorEdit.commit();
    }

    /* renamed from: H0 */
    public static void m71211H0(Context context, long j10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putLong("query_find_network_list_time", j10);
        editorEdit.apply();
    }

    /* renamed from: I */
    public static int m71212I(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getInt("anti_theft_data_size", 0);
        }
        C13981a.m83988e("SharedPreferenceUtil", "readAntiTheftSizeToFile sp is null");
        return 0;
    }

    /* renamed from: I0 */
    public static void m71213I0(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("wap_country_code", C11869b.m71142i(context, str));
        editorEdit.commit();
    }

    /* renamed from: J */
    public static String m71214J(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.btwl", 0);
        if (sharedPreferencesM1382b != null) {
            return C11869b.m71136c(context, sharedPreferencesM1382b.getString("perdevice_white_list", ""));
        }
        C13981a.m83988e("SharedPreferenceUtil", "readBtwlConfig sp is null");
        return "";
    }

    /* renamed from: J0 */
    public static void m71215J0(Context context, boolean z10) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("wap_has_login", z10);
        editorEdit.commit();
    }

    /* renamed from: K */
    public static String m71216K(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return C11869b.m71136c(context, sharedPreferencesM1382b.getString("unbinding_challenge", ""));
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: K0 */
    public static void m71217K0(Context context, boolean z10) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("wearDeviceStatus", z10);
        editorEdit.commit();
    }

    /* renamed from: L */
    public static String m71218L(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return C11869b.m71136c(context, sharedPreferencesM1382b.getString("clear_data_cmd", null));
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: L0 */
    public static void m71219L0(Context context, long j10) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putLong("network_sim_info_update_time", j10);
        editorEdit.commit();
    }

    /* renamed from: M */
    public static boolean m71220M(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("clear_report_flag", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: M0 */
    public static void m71221M0(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("phone_finder_account_info", C11869b.m71142i(context, str));
        editorEdit.commit();
    }

    /* renamed from: N */
    public static int m71222N(Context context, int i10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getInt("client_capability_val_last_reported", i10);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return i10;
    }

    /* renamed from: N0 */
    public static void m71223N0(Context context, int i10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        C13981a.m83989i("SharedPreferenceUtil", "writeAntiTheftSizeToFile, dataSize:" + i10);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "writeAntiTheftSizeToFile sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putInt("anti_theft_data_size", i10);
        editorEdit.apply();
    }

    /* renamed from: O */
    public static boolean m71224O(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("is_show_cloud_lock", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: O0 */
    public static void m71225O0(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.btwl", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("perdevice_white_list", C11869b.m71142i(context, str));
        editorEdit.commit();
    }

    /* renamed from: P */
    public static boolean m71226P(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("find_network_switch_status", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: P0 */
    public static void m71227P0(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("unbinding_challenge", C11869b.m71142i(context, str));
        editorEdit.apply();
    }

    /* renamed from: Q */
    public static int m71228Q(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getInt("hd_location_switch_status", 0);
        }
        C13981a.m83988e("SharedPreferenceUtil", "writeTrustCircleStatues sp is null");
        return 0;
    }

    /* renamed from: Q0 */
    public static void m71229Q0(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("clear_data_cmd", C11869b.m71142i(context, str));
        editorEdit.commit();
    }

    /* renamed from: R */
    public static String m71230R(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.btwl", 0);
        if (sharedPreferencesM1382b != null) {
            return C11869b.m71136c(context, sharedPreferencesM1382b.getString("perdevice_white_list_local", ""));
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: R0 */
    public static void m71231R0(Context context, boolean z10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("clear_report_flag", z10);
        editorEdit.apply();
    }

    /* renamed from: S */
    public static String m71232S(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return C11869b.m71136c(context, sharedPreferencesM1382b.getString(str, null));
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: S0 */
    public static void m71233S0(Context context, int i10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putInt("client_capability_val_last_reported", i10);
        editorEdit.commit();
    }

    /* renamed from: T */
    public static boolean m71234T(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("phone_finder_login_success_dialog_status", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: T0 */
    public static void m71235T0(Context context, Boolean bool) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("cloud_active_lock", bool.booleanValue());
        editorEdit.commit();
    }

    /* renamed from: U */
    public static boolean m71236U(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("LossMode_has_been_Cleared", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: U0 */
    public static void m71237U0(Context context, Boolean bool) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("is_show_cloud_lock", bool.booleanValue());
        editorEdit.commit();
    }

    /* renamed from: V */
    public static String m71238V(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return C11869b.m71137d(context, sharedPreferencesM1382b.getString("mac_key", ""));
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: V0 */
    public static void m71239V0(Context context, boolean z10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        C13981a.m83989i("SharedPreferenceUtil", "writeFindNetworkStatusToFile,isOpen:" + z10);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("find_network_switch_status", z10);
        editorEdit.apply();
    }

    /* renamed from: W */
    public static String m71240W(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return C11869b.m71136c(context, sharedPreferencesM1382b.getString("master_device_passive_counts", null));
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: W0 */
    public static void m71241W0(Context context, int i10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        C13981a.m83989i("SharedPreferenceUtil", "writeHdLocateSwitchStatusToFile, isOpen:" + i10);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "writeTrustCircleStatues sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putInt("hd_location_switch_status", i10);
        editorEdit.apply();
    }

    /* renamed from: X */
    public static String m71242X(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getString("network_info", str);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return str;
    }

    /* renamed from: X0 */
    public static void m71243X0(Context context, Boolean bool) {
        C13981a.m83989i("SharedPreferenceUtil", "writeLastlocSwitchStatusToFile,isOpen:" + bool);
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
            editorEdit.putBoolean("phone_finder_lastlocation_switch_status", bool.booleanValue());
            editorEdit.apply();
        }
    }

    /* renamed from: Y */
    public static int m71244Y(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getInt("offline_location_switch_status", 0);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return 0;
    }

    /* renamed from: Y0 */
    public static void m71245Y0(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.btwl", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("perdevice_white_list_local", C11869b.m71142i(context, str));
        editorEdit.commit();
    }

    /* renamed from: Z */
    public static boolean m71246Z(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("offline_location_white_status", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: Z0 */
    public static void m71247Z0(Context context, String str, String str2) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString(str2, C11869b.m71142i(context, str));
        editorEdit.apply();
    }

    /* renamed from: a */
    public static void m71248a(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.remove("phone_finder_account_info");
        editorEdit.commit();
    }

    /* renamed from: a0 */
    public static String m71249a0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return C11869b.m71136c(context, sharedPreferencesM1382b.getString("param_config", ""));
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: a1 */
    public static void m71250a1(Context context, Boolean bool) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("phone_finder_login_success_dialog_status", bool.booleanValue());
        editorEdit.commit();
    }

    /* renamed from: b */
    public static void m71251b(Context context) {
        if (context == null) {
            C13981a.m83988e("SharedPreferenceUtil", "clearAllData context is null");
            return;
        }
        C13981a.m83989i("SharedPreferenceUtil", "sp clearAllData");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        if (sharedPreferencesM1382b.edit().clear().commit()) {
            C13981a.m83987d("SharedPreferenceUtil", "clear settingSp success");
        } else {
            C13981a.m83988e("SharedPreferenceUtil", "clear settingSp failed");
        }
        if (C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).edit().clear().commit()) {
            C13981a.m83987d("SharedPreferenceUtil", "clear syncSp success");
        } else {
            C13981a.m83988e("SharedPreferenceUtil", "clear syncSp failed");
        }
        if (C0214f0.m1382b(context, "push_client_self_info", 0).edit().clear().commit()) {
            C13981a.m83987d("SharedPreferenceUtil", "clear pushSp success");
        } else {
            C13981a.m83988e("SharedPreferenceUtil", "clear pushSp failed");
        }
    }

    /* renamed from: b0 */
    public static String m71252b0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return C11869b.m71136c(context, sharedPreferencesM1382b.getString("pushtkn_hide", null));
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: b1 */
    public static void m71253b1(Context context, Boolean bool) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("LossMode_has_been_Cleared", bool.booleanValue());
        editorEdit.commit();
    }

    /* renamed from: c */
    public static void m71254c(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString(str, null);
        editorEdit.apply();
    }

    /* renamed from: c0 */
    public static String m71255c0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getString("reported_app_version", "");
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: c1 */
    public static void m71256c1(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("mac_key", C11869b.m71142i(context, str));
        editorEdit.apply();
    }

    /* renamed from: d */
    public static void m71257d(Context context) {
        C13981a.m83989i("SharedPreferenceUtil", "clearUISwitchToFile");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.remove("master_device_passive_counts");
        editorEdit.apply();
    }

    /* renamed from: d0 */
    public static String m71258d0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getString("reported_rom_version", "");
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: d1 */
    public static void m71259d1(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("network_info", str);
        editorEdit.commit();
    }

    /* renamed from: e */
    public static void m71260e(Context context) {
        C13981a.m83989i("SharedPreferenceUtil", "clearUISwitchToFile");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.remove("slave_device_passive_counts");
        editorEdit.apply();
    }

    /* renamed from: e0 */
    public static boolean m71261e0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("root_pk_report_status_new", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: e1 */
    public static void m71262e1(Context context, int i10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        C13981a.m83989i("SharedPreferenceUtil", "writeOfflineLocateSwitchStatusToFile,isOpen:" + i10);
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putInt("offline_location_switch_status", i10);
        editorEdit.apply();
    }

    /* renamed from: f */
    public static void m71263f(Context context) {
        C13981a.m83989i("SharedPreferenceUtil", "clearUISwitchToFile");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.remove("phone_finder_switch_status");
        editorEdit.commit();
    }

    /* renamed from: f0 */
    public static long m71264f0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getLong("set_nearby_key_last_time", 0L);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return 0L;
    }

    /* renamed from: f1 */
    public static void m71265f1(Context context, boolean z10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        C13981a.m83989i("SharedPreferenceUtil", "write offline locate white list,is enable:" + z10);
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("offline_location_white_status", z10);
        editorEdit.apply();
    }

    /* renamed from: g */
    public static String m71266g(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return "";
        }
        String string = sharedPreferencesM1382b.getString("phone_finder_account_info", "");
        return TextUtils.isEmpty(string) ? "" : C11869b.m71136c(context, string);
    }

    /* renamed from: g0 */
    public static boolean m71267g0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("share_location_switch_status", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: g1 */
    public static void m71268g1(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("param_config", C11869b.m71142i(context, str));
        editorEdit.commit();
    }

    /* renamed from: h */
    public static String m71269h() {
        Context contextM74301m = C12347f.m74285n().m74301m();
        if (contextM74301m == null) {
            return "";
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(contextM74301m, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getString("active_credential_domain", "");
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: h0 */
    public static String m71270h0(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getString("sim_info", str);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return str;
    }

    /* renamed from: h1 */
    public static void m71271h1(Context context, boolean z10) {
        C13981a.m83989i("SharedPreferenceUtil", "writePhoneFinderSwitch:" + z10);
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("phone_finder_switch", z10);
        editorEdit.commit();
    }

    /* renamed from: i */
    public static String m71272i() {
        Context contextM74301m = C12347f.m74285n().m74301m();
        if (contextM74301m == null) {
            return "";
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(contextM74301m, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getString("active_credential_site_id", "");
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: i0 */
    public static String m71273i0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return C11869b.m71136c(context, sharedPreferencesM1382b.getString("slave_device_passive_counts", null));
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: i1 */
    public static void m71274i1(Context context, Boolean bool) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("pushtoken_has_been_registered", bool.booleanValue());
        editorEdit.commit();
    }

    /* renamed from: j */
    public static String m71275j(Context context) {
        if (context == null) {
            return "";
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getString("active_lock_domain", "");
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: j0 */
    public static boolean m71276j0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("socId_has_report_flag", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: j1 */
    public static void m71277j1(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("pushtkn_hide", C11869b.m71142i(context, str));
        editorEdit.commit();
    }

    /* renamed from: k */
    public static String m71278k(Context context) {
        if (context == null) {
            return "";
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getString("active_lock_domain_site_id", "");
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: k0 */
    public static int m71279k0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getInt("trust_circle_status", -2);
        }
        C13981a.m83988e("SharedPreferenceUtil", "readTrustCircleStatues sp is null");
        return -2;
    }

    /* renamed from: k1 */
    public static void m71280k1(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("reported_app_version", str);
        editorEdit.commit();
    }

    /* renamed from: l */
    public static int m71281l(Context context) {
        if (context == null) {
            return -1;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getInt("cal_lock_type", -1);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return -1;
    }

    /* renamed from: l0 */
    public static String m71282l0(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return C11869b.m71136c(context, sharedPreferencesM1382b.getString("unbinding_code", ""));
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return "";
    }

    /* renamed from: l1 */
    public static void m71283l1(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("reported_rom_version", str);
        editorEdit.commit();
    }

    /* renamed from: m */
    public static long m71284m(Context context) {
        if (context == null) {
            return 0L;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getLong("ta_data_check_time", 0L);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return 0L;
    }

    /* renamed from: m0 */
    public static void m71285m0(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("master_device_passive_counts", C11869b.m71142i(context, str));
        editorEdit.apply();
    }

    /* renamed from: m1 */
    public static void m71286m1(Context context, boolean z10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        C13981a.m83989i("SharedPreferenceUtil", "writeRootPkStatusToFile,isOpen:" + z10);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("root_pk_report_status_new", z10);
        editorEdit.commit();
    }

    /* renamed from: n */
    public static long m71287n(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getLong("unbinding_challenge_check_time", 0L);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return 0L;
    }

    /* renamed from: n0 */
    public static void m71288n0(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("slave_device_passive_counts", C11869b.m71142i(context, str));
        editorEdit.apply();
    }

    /* renamed from: n1 */
    public static void m71289n1(Context context, long j10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        C13981a.m83989i("SharedPreferenceUtil", "writeSetNearbyKeyLastTime");
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putLong("set_nearby_key_last_time", j10);
        editorEdit.apply();
    }

    /* renamed from: o */
    public static String m71290o(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return "";
        }
        String string = sharedPreferencesM1382b.getString("client_ta_key", "");
        if (!TextUtils.isEmpty(string)) {
            return C11869b.m71137d(context, string);
        }
        C13981a.m83987d("SharedPreferenceUtil", "ClientTaKey is empty");
        return "";
    }

    /* renamed from: o0 */
    public static void m71291o0(Context context, String str) {
        C13981a.m83989i("SharedPreferenceUtil", "removeInfo");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null || TextUtils.isEmpty(str)) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null, or input is empty");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.remove(str);
        editorEdit.commit();
    }

    /* renamed from: o1 */
    public static void m71292o1(Context context, long j10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        C13981a.m83989i("SharedPreferenceUtil", "writeSetNearbyKeyLastTime");
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putLong("query_trust_last_time", j10);
        editorEdit.apply();
    }

    /* renamed from: p */
    public static String m71293p(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return "";
        }
        String string = sharedPreferencesM1382b.getString("client_ta_key_sha256", "");
        if (!TextUtils.isEmpty(string)) {
            return C11869b.m71137d(context, string);
        }
        C13981a.m83987d("SharedPreferenceUtil", "ClientTaKeySha256 is empty");
        return "";
    }

    /* renamed from: p0 */
    public static void m71294p0(String str) {
        Context contextM74301m = C12347f.m74285n().m74301m();
        if (contextM74301m == null || TextUtils.isEmpty(str)) {
            return;
        }
        C13981a.m83989i("SharedPreferenceUtil", "setActiveCredentialDomain");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(contextM74301m, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("active_credential_domain", "https://" + str);
        editorEdit.commit();
    }

    /* renamed from: p1 */
    public static void m71295p1(Context context, boolean z10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        C13981a.m83989i("SharedPreferenceUtil", "writeShareLocateSwitchStatusToFile,isOpen:" + z10);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("share_location_switch_status", z10);
        editorEdit.apply();
    }

    /* renamed from: q */
    public static String m71296q(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return "";
        }
        String string = sharedPreferencesM1382b.getString("frp_token_value", "");
        if (!TextUtils.isEmpty(string)) {
            return C11869b.m71137d(context, string);
        }
        C13981a.m83987d("SharedPreferenceUtil", "getFrpToken is empty");
        return "";
    }

    /* renamed from: q0 */
    public static void m71297q0(String str) {
        Context contextM74301m = C12347f.m74285n().m74301m();
        if (contextM74301m == null || TextUtils.isEmpty(str)) {
            return;
        }
        C13981a.m83989i("SharedPreferenceUtil", "setActiveCredentialSiteId");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(contextM74301m, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("active_credential_site_id", str);
        editorEdit.commit();
    }

    /* renamed from: q1 */
    public static void m71298q1(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("sim_info", str);
        editorEdit.commit();
    }

    /* renamed from: r */
    public static int m71299r(Context context) {
        if (context == null) {
            C13981a.m83988e("SharedPreferenceUtil", "context is null");
            return -1;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getInt("need_report_lost_mode_result", -1);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return -1;
    }

    /* renamed from: r0 */
    public static void m71300r0(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("active_lock_domain", str);
        editorEdit.commit();
    }

    /* renamed from: r1 */
    public static void m71301r1(Context context, boolean z10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("socId_has_report_flag", z10);
        editorEdit.apply();
    }

    /* renamed from: s */
    public static boolean m71302s(Context context) {
        if (context == null) {
            C13981a.m83988e("SharedPreferenceUtil", "getPhoneFinderSwitch context is null");
            return false;
        }
        C13981a.m83989i("SharedPreferenceUtil", "getPhoneFinderSwitch");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("phone_finder_switch", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "getPhoneFinderSwitch sp is null");
        return false;
    }

    /* renamed from: s0 */
    public static void m71303s0(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("active_lock_domain_site_id", str);
        editorEdit.commit();
    }

    /* renamed from: s1 */
    public static void m71304s1(Context context, int i10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "writeTrustCircleStatues sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putInt("trust_circle_status", i10);
        editorEdit.apply();
    }

    /* renamed from: t */
    public static String m71305t(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return "";
        }
        String string = sharedPreferencesM1382b.getString("client_push_sign_pk", "");
        if (!TextUtils.isEmpty(string)) {
            return C11869b.m71137d(context, string);
        }
        C13981a.m83987d("SharedPreferenceUtil", "push pk is empty");
        return "";
    }

    /* renamed from: t0 */
    public static void m71306t0(Context context, int i10) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putInt("cal_lock_type", i10);
        editorEdit.commit();
    }

    /* renamed from: t1 */
    public static void m71307t1(Context context) {
        C13981a.m83989i("SharedPreferenceUtil", "writeUISwitchToFile -1");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putInt("phone_finder_switch_status", -1);
        editorEdit.commit();
    }

    /* renamed from: u */
    public static String m71308u(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return "";
        }
        String string = sharedPreferencesM1382b.getString("client_push_sign_pk_v11", "");
        if (!TextUtils.isEmpty(string)) {
            return C11869b.m71137d(context, string);
        }
        C13981a.m83987d("SharedPreferenceUtil", "push pk11 is empty");
        return "";
    }

    /* renamed from: u0 */
    public static void m71309u0(Context context, long j10) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putLong("ta_data_check_time", j10);
        editorEdit.commit();
    }

    /* renamed from: u1 */
    public static void m71310u1(Context context, String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("unbinding_code", C11869b.m71142i(context, str));
        editorEdit.apply();
    }

    /* renamed from: v */
    public static long m71311v(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getLong("query_find_network_list_time", 0L);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return 0L;
    }

    /* renamed from: v0 */
    public static void m71312v0(Context context, long j10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putLong("unbinding_challenge_check_time", j10);
        editorEdit.commit();
    }

    /* renamed from: w */
    public static long m71313w(Context context) {
        if (context == null) {
            return 0L;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getLong("request_location_permission_time", 0L);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return 0L;
    }

    /* renamed from: w0 */
    public static void m71314w0(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("client_ta_key", C11869b.m71142i(context, str));
        editorEdit.commit();
    }

    /* renamed from: x */
    public static int m71315x(Context context) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getInt("phone_finder_switch_status", 0);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return 0;
    }

    /* renamed from: x0 */
    public static void m71316x0(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("client_ta_key_sha256", C11869b.m71142i(context, str));
        editorEdit.commit();
    }

    /* renamed from: y */
    public static boolean m71317y(Context context) {
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("wap_has_login", false);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return false;
    }

    /* renamed from: y0 */
    public static void m71318y0(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putString("frp_token_value", C11869b.m71143j(context, str));
        editorEdit.commit();
    }

    /* renamed from: z */
    public static boolean m71319z(Context context) {
        if (context == null) {
            return true;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.SETTING", 0);
        if (sharedPreferencesM1382b != null) {
            return sharedPreferencesM1382b.getBoolean("wearDeviceStatus", true);
        }
        C13981a.m83988e("SharedPreferenceUtil", "sp is null");
        return true;
    }

    /* renamed from: z0 */
    public static void m71320z0(Context context, boolean z10) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "com.huawei.android.remotecontrol.setting_cfg", 0);
        if (sharedPreferencesM1382b == null) {
            C13981a.m83988e("SharedPreferenceUtil", "sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        editorEdit.putBoolean("unbinding_challenge_check", z10);
        editorEdit.apply();
    }
}
