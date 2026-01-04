package gp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.C1461a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.feedback.FeedbackHelper;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.baseconfig.R$string;
import com.huawei.hicloud.bean.BasicModuleConfigV3Rsp;
import com.huawei.hicloud.notification.constants.StockActiveConstants;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0219i;
import p015ak.C0224k0;
import p015ak.C0241z;
import p362i9.C10461h;
import p372ip.C10583a;
import p372ip.C10584b;
import p399jk.AbstractC10896a;
import p459lp.C11326d;
import p459lp.C11330h;
import p459lp.InterfaceC11331i;
import p616rk.C12515a;
import p709vj.C13452e;

@SuppressLint({"ApplySharedPref"})
/* renamed from: gp.c */
/* loaded from: classes.dex */
public class C10028c {

    /* renamed from: g */
    public static final HashSet<String> f48986g = new a();

    /* renamed from: a */
    public Context f48987a;

    /* renamed from: b */
    public SharedPreferences f48988b;

    /* renamed from: c */
    public boolean f48989c;

    /* renamed from: d */
    public boolean f48990d;

    /* renamed from: e */
    public boolean f48991e;

    /* renamed from: f */
    public boolean f48992f;

    /* renamed from: gp.c$a */
    public class a extends HashSet<String> {
        public a() {
            add("funcfg_cloud_backup");
            add("funcfg_huawei_drive");
            add("funcfg_find_my_phone_globe");
            add("funcfg_gallery");
            add("funcfg_contacts");
            add("funcfg_calendar");
            add("funcfg_notes");
            add("funcfg_wlan");
            add("funcfg_browser");
            add("funcfg_messaging_up");
            add("funcfg_messaging_down");
            add("funcfg_call_log_up");
            add("funcfg_call_log_down");
            add("funcfg_recordings_up");
            add("funcfg_recordings_down");
            add("funcfg_blocked_up");
            add("funcfg_blocked_down");
            add("funcfg_manage_storage");
            add("cloudbackup_toogle");
            add("addressbook_toogle");
            add("cloudphoto_toogle");
            add("calendar_toogle");
            add("notepad_toogle");
            add("wlan_toogle");
            add("browser_toogle");
            add("funcfg_cloudphoto_share");
            add("funcfg_cloudphoto_manager");
        }
    }

    /* renamed from: gp.c$b */
    public static class b {

        /* renamed from: a */
        public static C10028c f48993a = new C10028c(null);
    }

    public /* synthetic */ C10028c(a aVar) {
        this();
    }

    /* renamed from: c0 */
    public static C10028c m62182c0() {
        return m62183d0(C0213f.m1377a());
    }

    /* renamed from: d0 */
    public static C10028c m62183d0(Context context) {
        if (b.f48993a.f48988b == null || b.f48993a.f48987a == null) {
            b.f48993a.m62295Y0(context);
        }
        return b.f48993a;
    }

    /* renamed from: A */
    public String m62184A(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }

    /* renamed from: A0 */
    public boolean m62185A0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("no_disturb_status", false);
        }
        return false;
    }

    /* renamed from: A1 */
    public synchronized boolean m62186A1() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("full_backup_key", false);
    }

    /* renamed from: A2 */
    public void m62187A2(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("email_address", str);
            editorEdit.commit();
        }
    }

    /* renamed from: A3 */
    public void m62188A3() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("pop_times", 0);
            editorEdit.commit();
            AbstractC10896a.m65885d("GlobalModuleSetting", "clear PushGuidePopTimes 0 ");
        }
    }

    /* renamed from: B */
    public int m62189B(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }

    /* renamed from: B0 */
    public int m62190B0(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }

    /* renamed from: B1 */
    public boolean m62191B1() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("isReceiveActivityGift", false);
        }
        return false;
    }

    /* renamed from: B2 */
    public void m62192B2(int i10) {
        AbstractC10896a.m65885d("GlobalModuleSetting", "setEncryptMode");
        if (i10 != 0 && i10 != 1) {
            this.f48988b.edit().putInt("encrypt_mode", 0).commit();
            C0209d.m1334z2(this.f48987a, "hicloud_cloudPhoto_nmd", m62424z0());
        } else {
            SharedPreferences sharedPreferences = this.f48988b;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putInt("encrypt_mode", i10).commit();
            }
            C0209d.m1334z2(this.f48987a, "hicloud_cloudPhoto_nmd", m62424z0());
        }
    }

    /* renamed from: B3 */
    public void m62193B3(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("isReceiveActivityGift", z10).commit();
        }
    }

    /* renamed from: C */
    public String m62194C() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("current_notify_ID", null);
        }
        return null;
    }

    /* renamed from: C0 */
    public int m62195C0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("notice_switch_status_key", 0);
        }
        return 0;
    }

    /* renamed from: C1 */
    public boolean m62196C1() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("isReceiveActivityGiftChecked", false);
        }
        return false;
    }

    /* renamed from: C2 */
    public void m62197C2(String str, long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong(str, j10);
            editorEdit.commit();
        }
    }

    /* renamed from: C3 */
    public void m62198C3(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("isReceiveActivityGiftChecked", z10).commit();
        }
    }

    /* renamed from: D */
    public int m62199D(String str) {
        if (this.f48988b == null) {
            return 0;
        }
        return this.f48988b.getInt("current_notify_times" + str, 0);
    }

    /* renamed from: D0 */
    public Set<String> m62200D0() {
        HashSet hashSet = new HashSet();
        SharedPreferences sharedPreferences = this.f48988b;
        return sharedPreferences != null ? sharedPreferences.getStringSet("omfile_download_flow_control_config_point", hashSet) : hashSet;
    }

    /* renamed from: D1 */
    public boolean m62201D1() {
        return m62395t1("funcfg_recordings_down") || m62395t1("funcfg_recordings_up");
    }

    /* renamed from: D2 */
    public void m62202D2(String str, int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt(str, i10);
            editorEdit.commit();
        }
    }

    /* renamed from: D3 */
    public void m62203D3(boolean z10) {
        this.f48992f = z10;
    }

    /* renamed from: E */
    public boolean m62204E() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("language_database_status", true);
        }
        return true;
    }

    /* renamed from: E0 */
    public int m62205E0(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(str + "omfile_download_flow_control_count", 0);
    }

    /* renamed from: E1 */
    public boolean m62206E1() {
        if (m62219H() != 4) {
            return m62219H() == 3;
        }
        C11326d.m68056r("com.huawei.hicloud.actoin.RETRY_MIGRATION_TASK");
        return true;
    }

    /* renamed from: E2 */
    public void m62207E2(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("expired_device_records_red_tips", z10).commit();
        }
    }

    /* renamed from: E3 */
    public void m62208E3(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("space_clean_red_remind_show_time", j10).commit();
        }
    }

    /* renamed from: F */
    public int m62209F() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("get_random_count", 0);
        }
        return 0;
    }

    /* renamed from: F0 */
    public int m62210F0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("pps_valid_ads_num", -1);
        }
        return -1;
    }

    /* renamed from: F1 */
    public synchronized boolean m62211F1(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains(str);
    }

    /* renamed from: F2 */
    public void m62212F2(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("familyshare_downloading", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: F3 */
    public void m62213F3(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("spacemultlanguage_downloading", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: G */
    public long m62214G() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_random_time", 0L);
        }
        return 0L;
    }

    /* renamed from: G0 */
    public String m62215G0() {
        SharedPreferences sharedPreferences = this.f48988b;
        return sharedPreferences != null ? sharedPreferences.getString("dialog_sign_from", "") : "";
    }

    /* renamed from: G1 */
    public boolean m62216G1(Context context) {
        if (context == null) {
            return false;
        }
        return m62405v1(context, "funcfg_call_log_up", "autocallloglistkey") || m62405v1(context, "funcfg_messaging_up", "autosmslistkey") || m62405v1(context, "funcfg_recordings_up", "autorecordingkey") || m62405v1(context, "funcfg_blocked_up", "autophonemanagerkey");
    }

    /* renamed from: G2 */
    public void m62217G2(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("first_get_lastbackup_time", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: G3 */
    public void m62218G3(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("space_notice_checking", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: H */
    public int m62219H() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("data_status", 0);
        }
        return 0;
    }

    /* renamed from: H0 */
    public String m62220H0() {
        SharedPreferences sharedPreferences = this.f48988b;
        return sharedPreferences != null ? sharedPreferences.getString("popconfig_guid", "") : "";
    }

    /* renamed from: H1 */
    public boolean m62221H1() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("is_hicloud_terms_confirm", false);
        }
        return false;
    }

    /* renamed from: H2 */
    public void m62222H2(String str, boolean z10) {
        AbstractC10896a.m65887i("GlobalModuleSetting", "setFollowState key is: " + str + ", isFollowed is: " + z10);
        if (!m62365n1(str)) {
            AbstractC10896a.m65888w("GlobalModuleSetting", "Failed to setFollowState and followPublicUser key does not meet the requirements");
            return;
        }
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            AbstractC10896a.m65888w("GlobalModuleSetting", "Failed to setFollowState and sp is null");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(str, z10);
        editorEdit.commit();
    }

    /* renamed from: H3 */
    public void m62223H3(FamilyShareInfoResult familyShareInfoResult) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null || familyShareInfoResult == null) {
            return;
        }
        sharedPreferences.edit().putLong("family_share_enable", familyShareInfoResult.getFamilyShareEnable()).commit();
        this.f48988b.edit().putLong("family_Share_Role", familyShareInfoResult.getFamilyShareRole()).commit();
        this.f48988b.edit().putLong("space_Share_Enable", familyShareInfoResult.getSpaceShareEnable()).commit();
        this.f48988b.edit().putLong("space_Share_Role", familyShareInfoResult.getSpaceShareRole()).commit();
    }

    /* renamed from: I */
    public int m62224I() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("data_type", 0);
        }
        return 0;
    }

    /* renamed from: I0 */
    public long m62225I0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("pop_last_time", 0L);
        }
        return 0L;
    }

    /* renamed from: I1 */
    public boolean m62226I1() {
        return m62278U() == 1;
    }

    /* renamed from: I2 */
    public void m62227I2(int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("forcedUpdateServerCode", i10);
            editorEdit.commit();
        }
    }

    /* renamed from: I3 */
    public void m62228I3(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("set_start_daily_job_time", j10);
            editorEdit.commit();
        }
    }

    /* renamed from: J */
    public boolean m62229J() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("ds_start_sticky", false);
        }
        return false;
    }

    /* renamed from: J0 */
    public int m62230J0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("pop_times", 0);
        }
        return 0;
    }

    /* renamed from: J2 */
    public void m62231J2(String str, int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt(str, i10);
            editorEdit.commit();
        }
    }

    /* renamed from: J3 */
    public void m62232J3(String str, String str2) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(str, str2);
            editorEdit.commit();
        }
    }

    /* renamed from: K */
    public int m62233K() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("durationMonth", 0);
        }
        return 0;
    }

    /* renamed from: K0 */
    public String m62234K0() {
        SharedPreferences sharedPreferences = this.f48988b;
        return sharedPreferences != null ? sharedPreferences.getString("sub_consent", "") : "";
    }

    /* renamed from: K2 */
    public void m62235K2(String str, int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt(str, i10);
            editorEdit.commit();
        }
    }

    /* renamed from: K3 */
    public synchronized void m62236K3(String str, int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt(str + "_syncCount", i10);
        editorEdit.commit();
    }

    /* renamed from: L */
    public String m62237L() {
        Context context = this.f48987a;
        String string = context != null ? context.getString(R$string.hidisk_hwcloud_email_address_for_feedback) : "";
        SharedPreferences sharedPreferences = this.f48988b;
        return sharedPreferences != null ? sharedPreferences.getString("email_address", string) : string;
    }

    /* renamed from: L0 */
    public boolean m62238L0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("sign_push_guide_failed", false);
        }
        return false;
    }

    /* renamed from: L1 */
    public void m62239L1(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("backup_delay_info", str);
            editorEdit.commit();
        }
    }

    /* renamed from: L2 */
    public synchronized void m62240L2(boolean z10) {
        if (this.f48988b == null) {
            return;
        }
        AbstractC10896a.m65885d("GlobalModuleSetting", "setFullBackupOn: " + z10);
        SharedPreferences.Editor editorEdit = this.f48988b.edit();
        editorEdit.putBoolean("full_backup_key", z10);
        editorEdit.commit();
    }

    /* renamed from: L3 */
    public synchronized void m62241L3(String str, String str2) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str + "_syncDate", str2);
        editorEdit.commit();
    }

    /* renamed from: M */
    public int m62242M() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("endService", 0);
        }
        return 0;
    }

    /* renamed from: M0 */
    public long m62243M0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("space_clean_red_remind_show_time", 0L);
        }
        return 0L;
    }

    /* renamed from: M1 */
    public void m62244M1(String str) {
        Set<String> setM62200D0 = m62200D0();
        if (setM62200D0 == null || this.f48988b == null || !setM62200D0.remove(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f48988b.edit();
        editorEdit.putStringSet("omfile_download_flow_control_config_point", setM62200D0);
        editorEdit.commit();
    }

    /* renamed from: M2 */
    public synchronized boolean m62245M2(String str, Integer num) {
        try {
            SharedPreferences sharedPreferences = this.f48988b;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (num == null) {
                editorEdit.remove(str + "_backup");
            } else {
                editorEdit.putInt(str + "_backup", num.intValue());
            }
            return editorEdit.commit();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: M3 */
    public void m62246M3(int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("current_version_reminded_times", i10);
            editorEdit.commit();
        }
    }

    /* renamed from: N */
    public long m62247N(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(str, 0L);
        }
        return 0L;
    }

    /* renamed from: N0 */
    public boolean m62248N0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("space_not_enough_close_flag", false);
        }
        return false;
    }

    /* renamed from: N1 */
    public void m62249N1(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("from_class", str).commit();
        }
    }

    /* renamed from: N2 */
    public void m62250N2(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("get_space_clean_big_file_data_time", j10).commit();
        }
    }

    /* renamed from: N3 */
    public void m62251N3(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("userClickForceUpgrade", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: O */
    public int m62252O(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }

    /* renamed from: O0 */
    public boolean m62253O0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("space_notice_checking", false);
        }
        return false;
    }

    /* renamed from: O1 */
    public void m62254O1() {
        C1461a.m8359i("GlobalModuleSetting", "resetForcedUpgrade");
        m62231J2("forcedUpdate", 0);
        m62235K2("upgrade_version_code", 0);
    }

    /* renamed from: O2 */
    public void m62255O2(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("get_space_clean_device_data_time", j10).commit();
        }
    }

    /* renamed from: O3 */
    public void m62256O3(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("cloud_disk_data_version", str).commit();
        }
    }

    /* renamed from: P */
    public boolean m62257P() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("expired_device_records_red_tips", true);
        }
        return true;
    }

    /* renamed from: P0 */
    public long m62258P0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("set_start_daily_job_time", 0L);
        }
        return 0L;
    }

    /* renamed from: P1 */
    public void m62259P1() {
        SharedPreferences sharedPreferences;
        if (m62200D0() == null || (sharedPreferences = this.f48988b) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putStringSet("omfile_download_flow_control_config_point", null);
        editorEdit.commit();
    }

    /* renamed from: P2 */
    public void m62260P2(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("get_space_clean_duplicate_file_data_time", j10).commit();
        }
    }

    /* renamed from: P3 */
    public void m62261P3(String str) {
        int iM62205E0 = m62205E0(str) + 1;
        AbstractC10896a.m65887i("GlobalModuleSetting", "updateOMFileDownloadFlowControlCount count: " + iM62205E0);
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str + "omfile_download_flow_control_count", iM62205E0).apply();
        }
    }

    /* renamed from: Q */
    public int m62262Q() {
        SharedPreferences sharedPreferences = this.f48988b;
        return TextUtils.isEmpty(sharedPreferences != null ? sharedPreferences.getString("email_address", "") : "") ? 2 : 1;
    }

    /* renamed from: Q0 */
    public String m62263Q0(String str, String str2) {
        return this.f48988b.getString(str, str2);
    }

    /* renamed from: Q1 */
    public void m62264Q1(int i10, int i11) {
        m62268R1(i10, String.valueOf(i11));
    }

    /* renamed from: Q2 */
    public void m62265Q2(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("get_cloud_disk_data_version_time", j10).commit();
        }
    }

    /* renamed from: R */
    public boolean m62266R() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("is_first_sign_terms", false);
        }
        return false;
    }

    /* renamed from: R0 */
    public synchronized int m62267R0(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(str + "_syncCount", 0);
    }

    /* renamed from: R1 */
    public void m62268R1(int i10, String str) {
        SharedPreferences.Editor editorEdit;
        AbstractC10896a.m65887i("GlobalModuleSetting", "saveCloudBackupStatus type=" + i10 + ", value=" + str);
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i10);
        stringBuffer.append("-");
        stringBuffer.append(str);
        editorEdit.putString("saved_status", stringBuffer.toString());
        editorEdit.commit();
    }

    /* renamed from: R2 */
    public void m62269R2(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("have_new_version_honor", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: S */
    public long m62270S() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("first_use_share_album_time", 0L);
        }
        return 0L;
    }

    /* renamed from: S0 */
    public synchronized String m62271S0(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(str + "_syncDate", null);
    }

    /* renamed from: S1 */
    public void m62272S1(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("function_item_switch", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: S2 */
    public void m62273S2(boolean z10) {
        this.f48991e = z10;
    }

    /* renamed from: T */
    public int m62274T() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("forcedUpdateServerCode", 0);
        }
        return 0;
    }

    /* renamed from: T0 */
    public int m62275T0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("current_version_reminded_times", 0);
        }
        return 0;
    }

    /* renamed from: T1 */
    public void m62276T1(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("is_first_sign_terms", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: T2 */
    public void m62277T2(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("is_set_time_by_old_ver", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: U */
    public int m62278U() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("forcedUpdate", 0);
        }
        return 0;
    }

    /* renamed from: U0 */
    public int m62279U0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("upgrade_version_code", 0);
        }
        return 0;
    }

    /* renamed from: U1 */
    public void m62280U1() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("first_use_share_album_time", System.currentTimeMillis()).commit();
        }
    }

    /* renamed from: U2 */
    public void m62281U2(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, z10);
            editorEdit.commit();
        }
    }

    /* renamed from: V */
    public String m62282V() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getString("from_class", null);
        }
        return null;
    }

    /* renamed from: V0 */
    public boolean m62283V0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("userClickForceUpgrade", false);
        }
        return false;
    }

    /* renamed from: V1 */
    public void m62284V1(boolean z10, boolean z11) {
        C1461a.m8359i("GlobalModuleSetting", "isForceUpgrade: " + z10 + " isEndService: " + z11);
        if (m62278U() == 0) {
            m62197C2("upgrade_last_notice_time", 0L);
            m62362m3("notice_times", 0);
            m62362m3("popup_times", 0);
            m62231J2("forcedUpdate", z10 ? 1 : 0);
        }
        m62231J2("endService", z11 ? 1 : 0);
    }

    /* renamed from: V2 */
    public void m62285V2(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("key_param_header", z10).commit();
        }
    }

    /* renamed from: W */
    public synchronized int m62286W(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return 2;
        }
        return sharedPreferences.getInt(str + "_backup", 2);
    }

    /* renamed from: W0 */
    public String m62287W0() {
        SharedPreferences sharedPreferences = this.f48988b;
        return sharedPreferences != null ? sharedPreferences.getString("cloud_disk_data_version", "") : "";
    }

    /* renamed from: W1 */
    public void m62288W1() {
        m62377p3("funcfg_cloud_backup", true);
        m62377p3("funcfg_find_my_phone_globe", C11330h.m68077a());
        m62377p3("funcfg_gallery", true);
        m62377p3("funcfg_contacts", true);
        m62377p3("funcfg_calendar", true);
        m62377p3("funcfg_notes", true);
        m62377p3("funcfg_wlan", true);
        m62377p3("funcfg_browser", true);
    }

    /* renamed from: W2 */
    public void m62289W2() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("last_check_honor_upgraded_date", System.currentTimeMillis());
            editorEdit.commit();
        }
    }

    /* renamed from: X */
    public long m62290X() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("get_space_clean_big_file_data_time", 0L);
        }
        return 0L;
    }

    /* renamed from: X0 */
    public boolean m62291X0() {
        Iterator<Map.Entry<String, ?>> it = this.f48988b.getAll().entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (!TextUtils.isEmpty(key) && key.startsWith("funcfg_") && !f48986g.contains(key) && this.f48988b.getBoolean(key, false)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: X1 */
    public void m62292X1(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("dialog_sign_from", str);
            editorEdit.commit();
        }
    }

    /* renamed from: X2 */
    public void m62293X2(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("last_daily_schedule_time", j10);
            editorEdit.commit();
        }
    }

    /* renamed from: Y */
    public long m62294Y() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("get_space_clean_device_data_time", 0L);
        }
        return 0L;
    }

    /* renamed from: Y0 */
    public final void m62295Y0(Context context) {
        Context contextM1377a = C0213f.m1377a();
        this.f48987a = contextM1377a;
        this.f48988b = C0214f0.m1382b(contextM1377a, SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
    }

    /* renamed from: Y1 */
    public void m62296Y1(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("sub_consent", str);
            editorEdit.commit();
        }
    }

    /* renamed from: Y2 */
    public void m62297Y2(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_full_report_switch_status_time", j10).commit();
        }
    }

    /* renamed from: Z */
    public long m62298Z() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("get_space_clean_duplicate_file_data_time", 0L);
        }
        return 0L;
    }

    /* renamed from: Z0 */
    public boolean m62299Z0() {
        return this.f48990d;
    }

    /* renamed from: Z1 */
    public void m62300Z1(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("sign_push_guide_failed", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: Z2 */
    public void m62301Z2(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("space_notice_check_time", j10);
            editorEdit.commit();
        }
    }

    /* renamed from: a0 */
    public long m62302a0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("get_cloud_disk_data_version_time", 0L);
        }
        return 0L;
    }

    /* renamed from: a1 */
    public synchronized boolean m62303a1() {
        if (this.f48988b == null) {
            return false;
        }
        m62333h();
        return this.f48988b.getBoolean("base_backup_new_key", false);
    }

    /* renamed from: a2 */
    public final void m62304a2(BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) {
        HashMap<String, Boolean> syncDynamicFuncFieldMap = basicModuleConfigV3Rsp.getSyncDynamicFuncFieldMap();
        if (syncDynamicFuncFieldMap == null || syncDynamicFuncFieldMap.isEmpty()) {
            AbstractC10896a.m65887i("GlobalModuleSetting", "no syncFuncCfg, module enable empty");
            return;
        }
        for (Map.Entry<String, Boolean> entry : syncDynamicFuncFieldMap.entrySet()) {
            m62377p3(entry.getKey(), entry.getValue().booleanValue());
        }
        AbstractC10896a.m65887i("GlobalModuleSetting", "saveV3ExtraModuleConfig ok");
    }

    /* renamed from: a3 */
    public void m62305a3(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("space_notice_process_id", str);
            editorEdit.commit();
        }
    }

    /* renamed from: b0 */
    public int m62306b0(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null || str == null) {
            return 1;
        }
        return sharedPreferences.getInt(str, 1);
    }

    /* renamed from: b1 */
    public synchronized boolean m62307b1() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("is_base_backup_key_update_new", false);
    }

    /* renamed from: b2 */
    public void m62308b2(BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) {
        if (basicModuleConfigV3Rsp != null) {
            m62377p3("funcfg_cloud_backup", basicModuleConfigV3Rsp.isBackupEnable());
            m62377p3("funcfg_huawei_drive", basicModuleConfigV3Rsp.isDbankEnable());
            m62377p3("funcfg_find_my_phone_globe", basicModuleConfigV3Rsp.isPhoneFinderEnable());
            m62377p3("funcfg_gallery", basicModuleConfigV3Rsp.isGalleryEnable());
            m62377p3("funcfg_contacts", basicModuleConfigV3Rsp.isContactEnable());
            m62377p3("funcfg_calendar", basicModuleConfigV3Rsp.isCalendarEnable());
            m62377p3("funcfg_notes", basicModuleConfigV3Rsp.isNotesEnable());
            m62377p3("funcfg_wlan", basicModuleConfigV3Rsp.isWlanEnable());
            m62377p3("funcfg_browser", basicModuleConfigV3Rsp.isBrowserEnable());
            m62377p3("funcfg_messaging_down", basicModuleConfigV3Rsp.isSmsDownEnable());
            m62377p3("funcfg_messaging_up", basicModuleConfigV3Rsp.isSmsUpEnable());
            m62377p3("funcfg_call_log_down", basicModuleConfigV3Rsp.isCallLogDownEnable());
            m62377p3("funcfg_call_log_up", basicModuleConfigV3Rsp.isCallLogUpEnable());
            m62377p3("funcfg_recordings_down", basicModuleConfigV3Rsp.isRecordingDownEnable());
            m62377p3("funcfg_recordings_up", basicModuleConfigV3Rsp.isRecordingUpEnable());
            m62377p3("funcfg_blocked_down", basicModuleConfigV3Rsp.isBlockedDownEnable());
            m62377p3("funcfg_blocked_up", basicModuleConfigV3Rsp.isBlockedUpEnable());
            m62377p3("funcfg_manage_storage", basicModuleConfigV3Rsp.isStorageManageEnable());
            m62377p3("user_in_red_list", basicModuleConfigV3Rsp.isInRedList());
            m62377p3("funcfg_familyShare", basicModuleConfigV3Rsp.isFamilyShareEnable());
            m62377p3("ds_start_sticky", basicModuleConfigV3Rsp.isDsStartSticky());
            m62377p3("funcfg_cloudphoto_share", basicModuleConfigV3Rsp.isCloudphotoShare());
            m62377p3("funcfg_cloudphoto_manager", basicModuleConfigV3Rsp.isCloudphotoManager());
            m62316d2(basicModuleConfigV3Rsp.getAllowStatus());
            m62187A2(basicModuleConfigV3Rsp.getEmailAddress());
            if (TextUtils.isEmpty(basicModuleConfigV3Rsp.getEmailAddress())) {
                FeedbackHelper.setFeedbackType(2);
            } else {
                FeedbackHelper.setFeedbackType(1);
            }
            m62416x2(basicModuleConfigV3Rsp.getDataState());
            m62421y2(basicModuleConfigV3Rsp.getDataType());
            m62371o2(basicModuleConfigV3Rsp.getCloudbackupV2Status());
            m62304a2(basicModuleConfigV3Rsp);
            m62285V2(basicModuleConfigV3Rsp.isKeyParamHeader());
            m62377p3("is_already_configed_NV4", true);
            m62317d3(System.currentTimeMillis());
        }
    }

    /* renamed from: b3 */
    public void m62309b3(String str, long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong(str + "_report_time", j10);
            editorEdit.commit();
        }
    }

    /* renamed from: c */
    public void m62310c(String str) {
        Set<String> setM62200D0 = m62200D0();
        if (setM62200D0 != null) {
            setM62200D0.add(str);
            SharedPreferences sharedPreferences = this.f48988b;
            if (sharedPreferences != null) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putStringSet("omfile_download_flow_control_config_point", setM62200D0);
                editorEdit.commit();
            }
        }
    }

    /* renamed from: c1 */
    public boolean m62311c1() {
        return m62395t1("funcfg_blocked_down") || m62395t1("funcfg_blocked_up");
    }

    /* renamed from: c2 */
    public synchronized boolean m62312c2(boolean z10, List<String> list) {
        try {
            SharedPreferences sharedPreferences = this.f48988b;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (list == null) {
                return false;
            }
            for (String str : list) {
                if (str != null) {
                    editorEdit.putBoolean(str, z10);
                }
            }
            return editorEdit.commit();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: c3 */
    public void m62313c3(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("last_get_pps_info_time", j10);
            editorEdit.commit();
        }
    }

    /* renamed from: d */
    public boolean m62314d() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return false;
        }
        long j10 = sharedPreferences.getLong("last_update_feature_switch_config_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - j10 <= 79200000) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.f48988b.edit();
        if (editorEdit == null) {
            return true;
        }
        editorEdit.putLong("last_update_feature_switch_config_time", jCurrentTimeMillis);
        editorEdit.commit();
        return true;
    }

    /* renamed from: d1 */
    public boolean m62315d1() {
        return m62395t1("funcfg_call_log_down") || m62395t1("funcfg_call_log_up");
    }

    /* renamed from: d2 */
    public void m62316d2(int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("allow_status", i10).commit();
        }
    }

    /* renamed from: d3 */
    public void m62317d3(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_query_config_time", j10).commit();
        }
    }

    /* renamed from: e */
    public int m62318e(int i10) {
        AbstractC10896a.m65887i("GlobalModuleSetting", "checkEncryptModeByDataStatus data status is " + i10);
        return i10 != 5 ? 0 : 1;
    }

    /* renamed from: e0 */
    public boolean m62319e0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("is_set_time_by_old_ver", false);
        }
        return false;
    }

    /* renamed from: e1 */
    public boolean m62320e1() {
        return m62242M() == 1;
    }

    /* renamed from: e2 */
    public void m62321e2(boolean z10) {
        this.f48990d = z10;
    }

    /* renamed from: e3 */
    public void m62322e3(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("last_report_local_storage_time", j10);
            editorEdit.commit();
        }
    }

    /* renamed from: f */
    public void m62323f(HiCloudSafeIntent hiCloudSafeIntent) {
        m62182c0().m62249N1(hiCloudSafeIntent.getStringExtra("moudle"));
    }

    /* renamed from: f0 */
    public boolean m62324f0(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(str, false);
        }
        return false;
    }

    /* renamed from: f1 */
    public boolean m62325f1() {
        return StringUtil.equals(m62282V(), "myHuawei");
    }

    /* renamed from: f2 */
    public void m62326f2(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("last_app_start_schedule_time", j10);
            editorEdit.commit();
        }
    }

    /* renamed from: f3 */
    public void m62327f3() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("last_report_push_token_app_version", C0241z.m1685c("160000300")).commit();
        }
    }

    /* renamed from: g */
    public void m62328g(String str) {
        m62182c0().m62249N1(str);
    }

    /* renamed from: g0 */
    public boolean m62329g0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("key_param_header", false);
        }
        return false;
    }

    /* renamed from: g1 */
    public synchronized boolean m62330g1(String str) {
        if (!m62388s("backup_key")) {
            return false;
        }
        if (CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE.equals(str)) {
            return true;
        }
        return m62303a1();
    }

    /* renamed from: g2 */
    public void m62331g2(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("entry_applied_data_enable", z10).commit();
        }
    }

    /* renamed from: g3 */
    public void m62332g3(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_report_push_token_time", j10).commit();
        }
    }

    /* renamed from: h */
    public void m62333h() {
        boolean zM62211F1 = m62211F1("base_backup_key");
        boolean zM62211F12 = m62211F1("full_backup_key");
        final boolean z10 = true;
        if (!zM62211F1 || !zM62211F12) {
            if (!m62211F1("backup_key")) {
                AbstractC10896a.m65885d("GlobalModuleSetting", "checkNewBmSwitchInit back switch not init");
                return;
            }
            boolean zM62388s = m62388s("backup_key");
            AbstractC10896a.m65887i("GlobalModuleSetting", "checkNewBmSwitchInit init first:" + zM62388s);
            m62351k2(true);
            m62407v3(zM62388s);
            m62240L2(zM62388s);
            m62356l2(true);
            InterfaceC11331i.get().ifPresent(new Consumer() { // from class: gp.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((InterfaceC11331i) obj).mo64699a("base_backup_new_key", z10);
                }
            });
            return;
        }
        if (!m62211F1("base_backup_new_key") || !m62307b1()) {
            final boolean zM62425z1 = m62182c0().m62425z1();
            boolean zM62186A1 = m62182c0().m62186A1();
            boolean zM80887a1 = C13452e.m80781L().m80887a1();
            boolean zM80858T0 = C13452e.m80781L().m80858T0();
            AbstractC10896a.m65887i("GlobalModuleSetting", "checkNewBmSwitchInit oldBaseBackupOn: " + zM62425z1 + " ,oldFullBackupOn: " + zM62186A1 + " ,newBmType: " + zM80887a1 + " ,memberBusiness: " + zM80858T0);
            if (!zM80887a1) {
                zM62425z1 = true;
            }
            m62351k2(zM62425z1);
            m62407v3(zM62425z1);
            InterfaceC11331i.get().ifPresent(new Consumer() { // from class: gp.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((InterfaceC11331i) obj).mo64699a("base_backup_new_key", zM62425z1);
                }
            });
            boolean zM62388s2 = m62182c0().m62388s("backup_key");
            m62356l2(true);
            if (!zM62186A1 && zM62388s2 && zM80858T0) {
                InterfaceC11331i.get().ifPresent(new C10461h());
            }
        }
        if (m62307b1()) {
            return;
        }
        m62356l2(true);
    }

    /* renamed from: h0 */
    public long m62334h0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_check_honor_upgraded_date", 0L);
        }
        return 0L;
    }

    /* renamed from: h1 */
    public boolean m62335h1() {
        String strM80942m = C13452e.m80781L().m80942m();
        boolean zEqualsIgnoreCase = !TextUtils.isEmpty(strM80942m) ? "CN".equalsIgnoreCase(strM80942m) : false;
        int iM62418y = m62182c0().m62418y();
        boolean z10 = zEqualsIgnoreCase || iM62418y == 1;
        AbstractC10896a.m65885d("GlobalModuleSetting", "isDoCloudBackupV2About isChinaAccount: " + zEqualsIgnoreCase + " ,cloudbackupV2Status: " + iM62418y + " ,isV2About: " + z10);
        return z10;
    }

    /* renamed from: h2 */
    public synchronized boolean m62336h2(String str, boolean z10) {
        try {
            if (this.f48988b == null) {
                return false;
            }
            C11326d.m68057s(str, z10);
            SharedPreferences.Editor editorEdit = this.f48988b.edit();
            editorEdit.putBoolean(str, z10);
            if (m62415x1(str)) {
                editorEdit.putBoolean("has_send_switch_to_ds", false);
            }
            C12515a.m75110o().m75175e(new C10584b(this.f48987a, str, z10), false);
            return editorEdit.commit();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: h3 */
    public synchronized void m62337h3(String str, long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong(str + "_last_syncTime", j10);
        editorEdit.commit();
    }

    /* renamed from: i */
    public boolean m62338i() {
        this.f48991e = false;
        this.f48992f = false;
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.clear();
        return editorEdit.commit();
    }

    /* renamed from: i0 */
    public long m62339i0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_daily_schedule_time", 0L);
        }
        return 0L;
    }

    /* renamed from: i1 */
    public boolean m62340i1() {
        SharedPreferences sharedPreferences = this.f48988b;
        return !TextUtils.isEmpty(sharedPreferences != null ? sharedPreferences.getString("email_address", "") : "");
    }

    /* renamed from: i2 */
    public synchronized boolean m62341i2(String str, boolean z10, int i10) {
        try {
            if (this.f48988b == null) {
                return false;
            }
            C11326d.m68057s(str, z10);
            SharedPreferences.Editor editorEdit = this.f48988b.edit();
            editorEdit.putBoolean(str, z10);
            if (m62415x1(str)) {
                editorEdit.putBoolean("has_send_switch_to_ds", false);
            }
            C12515a.m75110o().m75175e(new C10583a(this.f48987a, str, i10), false);
            return editorEdit.commit();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: i3 */
    public void m62342i3(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("last_set_time_by_old_ver", j10);
            editorEdit.commit();
        }
    }

    /* renamed from: j */
    public void m62343j() {
        AbstractC10896a.m65887i("GlobalModuleSetting", "clearAllConfig");
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove("server_config_structure");
            editorEdit.remove("server_config_no_structure");
            editorEdit.remove("server_config_backup");
            editorEdit.remove("server_config_dbank");
            editorEdit.remove("server_config_phone_finder");
            editorEdit.remove("server_config_gallery");
            editorEdit.remove("user_in_red_list");
            editorEdit.remove("server_config_space");
            editorEdit.remove("is_already_configed_NV4");
            editorEdit.remove("funcfg_cloud_backup");
            editorEdit.remove("funcfg_huawei_drive");
            editorEdit.remove("funcfg_find_my_phone_globe");
            editorEdit.remove("funcfg_gallery");
            editorEdit.remove("funcfg_contacts");
            editorEdit.remove("funcfg_calendar");
            editorEdit.remove("funcfg_notes");
            editorEdit.remove("funcfg_wlan");
            editorEdit.remove("funcfg_browser");
            editorEdit.remove("funcfg_messaging_up");
            editorEdit.remove("funcfg_call_log_up");
            editorEdit.remove("funcfg_recordings_up");
            editorEdit.remove("funcfg_blocked_up");
            editorEdit.remove("funcfg_messaging_down");
            editorEdit.remove("funcfg_call_log_down");
            editorEdit.remove("funcfg_recordings_down");
            editorEdit.remove("funcfg_blocked_down");
            editorEdit.remove("funcfg_manage_storage");
            editorEdit.remove("funcfg_familyShare");
            editorEdit.remove("user_in_red_list");
            editorEdit.remove("data_type");
            editorEdit.remove("allow_status");
            editorEdit.remove("data_status");
            editorEdit.remove("enable_bbr");
            editorEdit.remove("last_query_config_time");
            editorEdit.remove("funcfg_cloudphoto_share");
            editorEdit.remove("funcfg_cloudphoto_manager");
            editorEdit.remove("email_address");
            editorEdit.commit();
            FeedbackHelper.setFeedbackType(3);
        }
    }

    /* renamed from: j0 */
    public long m62344j0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_full_report_switch_status_time", 0L);
        }
        return 0L;
    }

    /* renamed from: j1 */
    public boolean m62345j1() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("familyshare_downloading", false);
        }
        return false;
    }

    /* renamed from: j2 */
    public void m62346j2(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("backup_clear_red_remind_show_time", j10).commit();
        }
    }

    /* renamed from: j3 */
    public void m62347j3(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("last_sns_msg_num_time", j10);
            editorEdit.commit();
        }
    }

    /* renamed from: k */
    public synchronized void m62348k(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(str + "_syncDate");
        editorEdit.remove(str + "_syncCount");
        editorEdit.remove(str + "_last_syncTime");
        editorEdit.commit();
    }

    /* renamed from: k0 */
    public long m62349k0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("space_notice_check_time", 0L);
        }
        return 0L;
    }

    /* renamed from: k1 */
    public boolean m62350k1(boolean z10, String str) {
        if (!m62355l1()) {
            return false;
        }
        boolean z11 = C0219i.m1463a() < 23;
        if ("CN".equalsIgnoreCase(str) || !z11) {
            return z10;
        }
        AbstractC10896a.m65887i("GlobalModuleSetting", "EMUI version less than 10.1");
        return false;
    }

    /* renamed from: k2 */
    public synchronized void m62351k2(boolean z10) {
        if (this.f48988b == null) {
            return;
        }
        AbstractC10896a.m65885d("GlobalModuleSetting", "setBaseBackupOn: " + z10);
        SharedPreferences.Editor editorEdit = this.f48988b.edit();
        editorEdit.putBoolean("base_backup_new_key", z10);
        editorEdit.commit();
    }

    /* renamed from: k3 */
    public void m62352k3(long j10, String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong(StockActiveConstants.SpKey.LAST_NOTIFY_TIME + str, j10);
            editorEdit.commit();
        }
    }

    /* renamed from: l */
    public void m62353l(String str) {
        this.f48988b.edit().remove(str).commit();
    }

    /* renamed from: l0 */
    public String m62354l0() {
        SharedPreferences sharedPreferences = this.f48988b;
        return sharedPreferences != null ? sharedPreferences.getString("space_notice_process_id", "") : "";
    }

    /* renamed from: l1 */
    public boolean m62355l1() {
        if (C0219i.m1467e()) {
            AbstractC10896a.m65887i("GlobalModuleSetting", "isDemoVersion");
            return false;
        }
        String strM1572a = C0224k0.a.m1572a("ro.frp.pst");
        String strM1572a2 = C0224k0.a.m1572a("ro.com.google.gmsversion");
        AbstractC10896a.m65887i("GlobalModuleSetting", "frp is:" + strM1572a + ",gmsVersion is:" + strM1572a2);
        if (C0209d.m1269j1() && C0209d.m1202Q0()) {
            AbstractC10896a.m65888w("GlobalModuleSetting", "honor and cn device show HwFrp");
            return true;
        }
        if (TextUtils.isEmpty(strM1572a) || TextUtils.isEmpty(strM1572a2)) {
            AbstractC10896a.m65887i("GlobalModuleSetting", "show HwFrp");
            return true;
        }
        AbstractC10896a.m65888w("GlobalModuleSetting", "do not show HwFrp");
        return false;
    }

    /* renamed from: l2 */
    public synchronized void m62356l2(boolean z10) {
        if (this.f48988b == null) {
            return;
        }
        AbstractC10896a.m65885d("GlobalModuleSetting", "baseBackupOnUpdated: " + z10);
        SharedPreferences.Editor editorEdit = this.f48988b.edit();
        editorEdit.putBoolean("is_base_backup_key_update_new", z10);
        editorEdit.commit();
    }

    /* renamed from: l3 */
    public void m62357l3(long j10, String str) {
        AbstractC10896a.m65887i("GlobalModuleSetting", "setLatestOMFileDownloadFlowControlTime: " + j10);
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str + "latest_omfile_download_flow_control_time", j10).commit();
        }
    }

    /* renamed from: m */
    public void m62358m() {
        AbstractC10896a.m65887i("GlobalModuleSetting", "clearMoreDataFlag");
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove("autosmslistkey");
            editorEdit.remove("autocallloglistkey");
            editorEdit.remove("autorecordingkey");
            editorEdit.remove("autophonemanagerkey");
            editorEdit.commit();
        }
    }

    /* renamed from: m0 */
    public long m62359m0(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str + "_report_time", 0L);
    }

    /* renamed from: m1 */
    public boolean m62360m1() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("first_get_lastbackup_time", true);
        }
        return true;
    }

    /* renamed from: m2 */
    public void m62361m2(int i10) {
        if (i10 != 0 && i10 != 1) {
            this.f48988b.edit().putInt("basic_encrypt_mode", 0).commit();
            return;
        }
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("basic_encrypt_mode", i10).commit();
        }
    }

    /* renamed from: m3 */
    public void m62362m3(String str, int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt(str, i10);
            editorEdit.commit();
        }
    }

    /* renamed from: n */
    public void m62363n(BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) {
        AbstractC10896a.m65887i("GlobalModuleSetting", "clearRedundantSetting");
        HashMap map = new HashMap();
        if (basicModuleConfigV3Rsp.getSyncDynamicFuncFieldMap() != null) {
            map.putAll(basicModuleConfigV3Rsp.getSyncDynamicFuncFieldMap());
        }
        if (basicModuleConfigV3Rsp.getSyncDynamicToggleFieldMap() != null) {
            map.putAll(basicModuleConfigV3Rsp.getSyncDynamicToggleFieldMap());
        }
        if (map.isEmpty()) {
            AbstractC10896a.m65887i("GlobalModuleSetting", "syncFuncCfg empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, ?>> it = this.f48988b.getAll().entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (!TextUtils.isEmpty(key) && (key.startsWith("funcfg_") || key.startsWith("reccfg_") || key.endsWith("_toogle"))) {
                if (!f48986g.contains(key) && !map.containsKey(key)) {
                    arrayList.add(key);
                }
            }
        }
        if (arrayList.size() <= 0) {
            AbstractC10896a.m65887i("GlobalModuleSetting", "no module to clear.");
            return;
        }
        AbstractC10896a.m65887i("GlobalModuleSetting", "clear item name: " + arrayList.toString());
        SharedPreferences.Editor editorEdit = this.f48988b.edit();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            editorEdit.remove((String) it2.next());
        }
        editorEdit.commit();
    }

    /* renamed from: n0 */
    public long m62364n0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_get_pps_info_time", 0L);
        }
        return 0L;
    }

    /* renamed from: n1 */
    public final boolean m62365n1(String str) {
        return "follow_public_user".equals(str);
    }

    /* renamed from: n2 */
    public void m62366n2(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("capacity", j10).commit();
        }
    }

    /* renamed from: n3 */
    public void m62367n3(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("marketing_notify_checked_status", z10);
            editorEdit.commit();
            AbstractC10896a.m65885d("GlobalModuleSetting", "setMarketingNotifyChecked isChecked:" + z10);
        }
    }

    /* renamed from: o */
    public boolean m62368o(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.contains(str);
        }
        return false;
    }

    /* renamed from: o0 */
    public long m62369o0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_query_config_time", 0L);
        }
        return 0L;
    }

    /* renamed from: o1 */
    public boolean m62370o1(String str) {
        return this.f48988b != null && m62365n1(str) && this.f48988b.getBoolean(str, false);
    }

    /* renamed from: o2 */
    public void m62371o2(int i10) {
        if (1 == m62418y() && i10 == 0) {
            AbstractC10896a.m65887i("GlobalModuleSetting", "setCloudbackupV2Status server is v2, local is v1");
            return;
        }
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("cloudbackup_v2_status", i10).commit();
        }
    }

    /* renamed from: o3 */
    public void m62372o3() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("marketing_notify_checked_status", false);
            editorEdit.commit();
            AbstractC10896a.m65885d("GlobalModuleSetting", "clear setMarketingNotifyCheckedClear false ");
        }
    }

    /* renamed from: p */
    public int m62373p() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("encrypt_mode", 0);
        }
        return 0;
    }

    /* renamed from: p0 */
    public long m62374p0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_report_local_storage_time", 0L);
        }
        return 0L;
    }

    /* renamed from: p1 */
    public boolean m62375p1() {
        if (!m62182c0().m62380q1() || !m62182c0().m62320e1()) {
            return false;
        }
        C1461a.m8358e("GlobalModuleSetting", "forced upgrade");
        return true;
    }

    /* renamed from: p2 */
    public void m62376p2(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("config_success_flag", z10).commit();
        }
    }

    /* renamed from: p3 */
    public void m62377p3(String str, boolean z10) {
        AbstractC10896a.m65885d("GlobalModuleSetting", "setModuleEnable:" + str + z10);
        if ("funcfg_find_my_phone_globe".equals(str)) {
            z10 = m62350k1(z10, C13452e.m80781L().m80942m());
        }
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str, z10);
            editorEdit.commit();
        }
    }

    /* renamed from: q */
    public int m62378q() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("allow_status", 0);
        }
        return 0;
    }

    /* renamed from: q0 */
    public int m62379q0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("last_report_push_token_app_version", 0);
        }
        return 0;
    }

    /* renamed from: q1 */
    public boolean m62380q1() {
        return m62278U() == 1 && m62279U0() != 0;
    }

    /* renamed from: q2 */
    public void m62381q2(String str, String str2) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(str, str2);
            editorEdit.commit();
        }
    }

    /* renamed from: q3 */
    public void m62382q3(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("no_disturb_status", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: r */
    public long m62383r() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_app_start_schedule_time", 0L);
        }
        return 0L;
    }

    /* renamed from: r0 */
    public long m62384r0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_report_push_token_time", 0L);
        }
        return 0L;
    }

    /* renamed from: r1 */
    public boolean m62385r1() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("have_new_version_honor", false);
        }
        return false;
    }

    /* renamed from: r2 */
    public void m62386r2(String str, int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt(str, i10);
            editorEdit.commit();
        }
    }

    /* renamed from: r3 */
    public void m62387r3(String str, int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str, i10).commit();
        }
    }

    /* renamed from: s */
    public synchronized boolean m62388s(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }

    /* renamed from: s0 */
    public synchronized long m62389s0(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str + "_last_syncTime", 0L);
    }

    /* renamed from: s1 */
    public boolean m62390s1() {
        return m62395t1("funcfg_messaging_down") || m62395t1("funcfg_messaging_up");
    }

    /* renamed from: s2 */
    public void m62391s2(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("current_notify_ID", str);
            editorEdit.commit();
        }
    }

    /* renamed from: s3 */
    public void m62392s3(int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("notice_switch_status_key", i10);
            editorEdit.commit();
        }
    }

    /* renamed from: t */
    public long m62393t() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("backup_clear_red_remind_show_time", 0L);
        }
        return 0L;
    }

    /* renamed from: t0 */
    public long m62394t0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_set_time_by_old_ver", 0L);
        }
        return 0L;
    }

    /* renamed from: t1 */
    public boolean m62395t1(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        boolean z10 = false;
        if (sharedPreferences != null) {
            z10 = sharedPreferences.getBoolean(str, false);
        } else {
            C1461a.m8360w("GlobalModuleSetting", "isModuleEnable sp is null");
        }
        if ("funcfg_find_my_phone_globe".equals(str) && C0209d.m1269j1() && m62299Z0()) {
            return true;
        }
        return z10;
    }

    /* renamed from: t2 */
    public void m62396t2(int i10, String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("current_notify_times" + str, i10);
            editorEdit.commit();
        }
    }

    /* renamed from: t3 */
    public void m62397t3(int i10, String str) {
        AbstractC10896a.m65887i("GlobalModuleSetting", "setOMFileDownloadFlowControlCount count: " + i10);
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str + "omfile_download_flow_control_count", i10).apply();
        }
    }

    /* renamed from: u */
    public String m62398u() {
        SharedPreferences sharedPreferences = this.f48988b;
        return sharedPreferences != null ? sharedPreferences.getString("backup_delay_info", "") : "";
    }

    /* renamed from: u0 */
    public long m62399u0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_sns_msg_num_time", 0L);
        }
        return 0L;
    }

    /* renamed from: u1 */
    public boolean m62400u1(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        boolean z11 = sharedPreferences != null ? sharedPreferences.getBoolean(str, z10) : false;
        if ("funcfg_find_my_phone_globe".equals(str) && C0209d.m1269j1() && m62299Z0()) {
            return true;
        }
        return z11;
    }

    /* renamed from: u2 */
    public void m62401u2(boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean("language_database_status", z10);
            editorEdit.commit();
        }
    }

    /* renamed from: u3 */
    public void m62402u3(long j10, String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str + "omfile_download_flow_control_interval_time", j10).commit();
        }
    }

    /* renamed from: v */
    public boolean m62403v(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f48988b;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z10) : z10;
    }

    /* renamed from: v0 */
    public long m62404v0(String str) {
        if (this.f48988b == null) {
            return 0L;
        }
        return this.f48988b.getLong(StockActiveConstants.SpKey.LAST_NOTIFY_TIME + str, 0L);
    }

    /* renamed from: v1 */
    public final boolean m62405v1(Context context, String str, String str2) {
        C10028c c10028cM62183d0 = m62183d0(context);
        return c10028cM62183d0.m62395t1(str) && c10028cM62183d0.m62388s(str2);
    }

    /* renamed from: v2 */
    public void m62406v2(int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("get_random_count", i10);
            editorEdit.commit();
        }
    }

    /* renamed from: v3 */
    public synchronized void m62407v3(boolean z10) {
        if (this.f48988b == null) {
            return;
        }
        AbstractC10896a.m65885d("GlobalModuleSetting", "setOldBaseBackupOn: " + z10);
        SharedPreferences.Editor editorEdit = this.f48988b.edit();
        editorEdit.putBoolean("base_backup_key", z10);
        editorEdit.commit();
    }

    /* renamed from: w */
    public long m62408w() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("capacity", 0L);
        }
        return 0L;
    }

    /* renamed from: w0 */
    public long m62409w0(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str + "latest_omfile_download_flow_control_time", 0L);
    }

    /* renamed from: w1 */
    public boolean m62410w1() {
        return this.f48991e && this.f48992f;
    }

    /* renamed from: w2 */
    public void m62411w2(long j10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("last_random_time", j10);
            editorEdit.commit();
        }
    }

    /* renamed from: w3 */
    public void m62412w3(int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("pps_valid_ads_num", i10);
            editorEdit.commit();
        }
    }

    /* renamed from: x */
    public boolean m62413x() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("function_item_switch", true);
        }
        return true;
    }

    /* renamed from: x0 */
    public int m62414x0(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }

    /* renamed from: x1 */
    public final boolean m62415x1(String str) {
        return "wlan".equals(str) || "autosmslistkey".equals(str) || "autocallloglistkey".equals(str) || "autorecordingkey".equals(str) || "autophonemanagerkey".equals(str);
    }

    /* renamed from: x2 */
    public void m62416x2(int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("data_status", i10).commit();
        }
    }

    /* renamed from: x3 */
    public void m62417x3(String str) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("popconfig_guid", str);
            editorEdit.commit();
        }
    }

    /* renamed from: y */
    public int m62418y() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("cloudbackup_v2_status", 0);
        }
        return 0;
    }

    /* renamed from: y0 */
    public boolean m62419y0() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("marketing_notify_checked_status", false);
        }
        return false;
    }

    /* renamed from: y1 */
    public boolean m62420y1() {
        return m62373p() == 0;
    }

    /* renamed from: y2 */
    public void m62421y2(int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("data_type", i10).commit();
        }
    }

    /* renamed from: y3 */
    public void m62422y3() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("pop_last_time", System.currentTimeMillis()).apply();
        }
    }

    /* renamed from: z */
    public boolean m62423z() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("config_success_flag", false);
        }
        return false;
    }

    /* renamed from: z0 */
    public int m62424z0() {
        return !C13452e.m80781L().m80850R0() ? C0209d.m1202Q0() ? 1 : 0 : m62420y1() ? 1 : 0;
    }

    /* renamed from: z1 */
    public synchronized boolean m62425z1() {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("base_backup_key", false);
    }

    /* renamed from: z2 */
    public void m62426z2(int i10) {
        SharedPreferences sharedPreferences = this.f48988b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("durationMonth", i10).commit();
        }
    }

    /* renamed from: z3 */
    public void m62427z3() {
        if (this.f48988b != null) {
            m62422y3();
            int iM62230J0 = m62230J0() + 1;
            SharedPreferences.Editor editorEdit = this.f48988b.edit();
            editorEdit.putInt("pop_times", iM62230J0);
            editorEdit.commit();
            AbstractC10896a.m65885d("GlobalModuleSetting", "set PushGuidePopTimes:" + iM62230J0);
        }
    }

    public C10028c() {
        this.f48987a = null;
        this.f48988b = null;
        this.f48989c = false;
        this.f48991e = false;
        this.f48992f = false;
    }
}
