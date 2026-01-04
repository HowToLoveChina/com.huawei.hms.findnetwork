package tc;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p015ak.C0214f0;
import p514o9.C11839m;

/* renamed from: tc.b */
/* loaded from: classes3.dex */
public final class C13007b {

    /* renamed from: c */
    public static C13007b f59257c;

    /* renamed from: a */
    public Context f59258a;

    /* renamed from: b */
    public SharedPreferences f59259b;

    public C13007b(Context context) {
        this(context, 0);
    }

    /* renamed from: Y */
    public static synchronized C13007b m78205Y(Context context) {
        try {
            if (f59257c == null) {
                f59257c = new C13007b(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f59257c;
    }

    /* renamed from: A */
    public boolean m78206A(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str + "_firstMigrateV2", true);
    }

    /* renamed from: A0 */
    public synchronized boolean m78207A0(String str, String str2, String str3) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str + "_" + str2 + "_local_lost_cursor", str3);
        return editorEdit.commit();
    }

    /* renamed from: B */
    public long m78208B(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str + "_first_prepare_time", 0L);
    }

    /* renamed from: B0 */
    public synchronized boolean m78209B0(String str, String str2, String str3) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str + str2 + "lock", str3);
        return editorEdit.commit();
    }

    /* renamed from: C */
    public String m78210C() {
        SharedPreferences sharedPreferences = this.f59259b;
        return sharedPreferences == null ? "" : sharedPreferences.getString("full_data_list_datas", "");
    }

    /* renamed from: C0 */
    public void m78211C0(String str, int i10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putInt(str + "_maxBatchNumber", i10).commit();
    }

    /* renamed from: D */
    public long m78212D(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return -1L;
        }
        return sharedPreferences.getLong(str + "_" + str2 + "_upperlimits", -1L);
    }

    /* renamed from: D0 */
    public void m78213D0(String str, int i10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str + "_prepare_times", i10).commit();
        }
    }

    /* renamed from: E */
    public long m78214E() {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_data_request_time", 0L);
        }
        return 0L;
    }

    /* renamed from: E0 */
    public void m78215E0(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str + "_prepare_trace_id", str2).commit();
        }
    }

    /* renamed from: F */
    public long m78216F(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str + "_lastVersionTime", 0L);
    }

    /* renamed from: F0 */
    public synchronized boolean m78217F0(String str, String str2, String str3) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str + "_" + str2 + "_server_lost_cursor", str3);
        return editorEdit.commit();
    }

    /* renamed from: G */
    public long m78218G(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str + "_lastSubscribeTime", 0L);
    }

    /* renamed from: G0 */
    public void m78219G0(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str + "_startCursor", str2).commit();
    }

    /* renamed from: H */
    public long m78220H(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str + "_" + str2 + "_lastUpperLimitsTime", 0L);
    }

    /* renamed from: H0 */
    public void m78221H0(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str + "_has_subscribed_suc", z10).commit();
        }
    }

    /* renamed from: I */
    public synchronized String m78222I(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(str + "_" + str2 + "_local_lost_cursor", "");
    }

    /* renamed from: I0 */
    public void m78223I0(String str, int i10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putInt(str + "_fromH5Set", i10).commit();
    }

    /* renamed from: J */
    public synchronized String m78224J(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(str + str2 + "lock", null);
    }

    /* renamed from: J0 */
    public synchronized void m78225J0(long j10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong("sync_scan_task_last_time", j10);
        editorEdit.commit();
    }

    /* renamed from: K */
    public int m78226K(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(str + "_maxBatchNumber", -1);
    }

    /* renamed from: K0 */
    public synchronized void m78227K0(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str + "sync_token", str2);
        editorEdit.commit();
    }

    /* renamed from: L */
    public int m78228L(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(str + "_prepare_times", 0);
    }

    /* renamed from: L0 */
    public synchronized void m78229L0(String str, Set<String> set) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putStringSet(str + "to_datatype", set);
        editorEdit.commit();
    }

    /* renamed from: M */
    public String m78230M(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(str + "_prepare_trace_id", "");
    }

    /* renamed from: M0 */
    public void m78231M0(String str, int i10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str + "_third_sync_scene", i10).commit();
        }
    }

    /* renamed from: N */
    public synchronized String m78232N(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(str + "_" + str2 + "_server_lost_cursor", "");
    }

    /* renamed from: N0 */
    public synchronized boolean m78233N0(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(str + "updatectag", z10);
        return editorEdit.commit();
    }

    /* renamed from: O */
    public String m78234O(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(str + "_startCursor", "");
    }

    /* renamed from: O0 */
    public synchronized boolean m78235O0(String str, String str2, long j10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong(str + "_" + str2 + "_refund_update_time", j10);
        return editorEdit.commit();
    }

    /* renamed from: P */
    public synchronized boolean m78236P(String str) {
        boolean z10;
        SharedPreferences sharedPreferences = this.f59259b;
        z10 = false;
        if (sharedPreferences != null) {
            if (sharedPreferences.getBoolean(str + "_has_subscribed_suc", false)) {
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: P0 */
    public void m78237P0(boolean z10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("isUploadQuic", z10).commit();
        }
    }

    /* renamed from: Q */
    public int m78238Q(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(str + "_fromH5Set", -1);
    }

    /* renamed from: Q0 */
    public void m78239Q0(String str, int i10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putInt(str + "_v2Cut", i10).commit();
    }

    /* renamed from: R */
    public synchronized long m78240R() {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong("sync_scan_task_last_time", 0L);
    }

    /* renamed from: S */
    public synchronized String m78241S(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(str + "sync_token", "");
    }

    /* renamed from: T */
    public synchronized Set<String> m78242T(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getStringSet(str + "to_datatype", null);
    }

    /* renamed from: U */
    public int m78243U(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(str + "_third_sync_scene", -1);
    }

    /* renamed from: V */
    public synchronized boolean m78244V(String str) {
        boolean z10;
        SharedPreferences sharedPreferences = this.f59259b;
        z10 = false;
        if (sharedPreferences != null) {
            if (sharedPreferences.getBoolean(str + "updatectag", false)) {
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: W */
    public synchronized long m78245W(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str + "_" + str2 + "_refund_update_time", 0L);
    }

    /* renamed from: X */
    public int m78246X(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(str + "_v2Cut", -1);
    }

    /* renamed from: Z */
    public synchronized boolean m78247Z() {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("delete_wlan_fail", false);
    }

    /* renamed from: a */
    public boolean m78248a() {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.clear();
        return editorEdit.commit();
    }

    /* renamed from: a0 */
    public boolean m78249a0() {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("isDownloadQuic", false);
        }
        return false;
    }

    /* renamed from: b */
    public void m78250b(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(str + SyncProtocol.Constant.CTAG).commit();
        editorEdit.remove(str + "ctagstatus").commit();
    }

    /* renamed from: b0 */
    public synchronized boolean m78251b0(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return true;
        }
        return sharedPreferences.getBoolean(str + str2 + "_risk_ignore", false);
    }

    /* renamed from: c */
    public void m78252c() {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove("delete_wlan_fail").commit();
    }

    /* renamed from: c0 */
    public boolean m78253c0(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str + "_lastChannelStopFail", false);
    }

    /* renamed from: d */
    public void m78254d(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str + "_first_prepare_time").commit();
        }
    }

    /* renamed from: d0 */
    public boolean m78255d0() {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean("isUploadQuic", false);
        }
        return false;
    }

    /* renamed from: e */
    public void m78256e(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str + str2 + "_risk_ignore").commit();
    }

    /* renamed from: e0 */
    public synchronized void m78257e0(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str + "_" + str2 + "_local_lost_cursor").commit();
    }

    /* renamed from: f */
    public void m78258f(String str, List<String> list) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove(str + "_" + it.next() + "_upperlimits").commit();
        }
    }

    /* renamed from: f0 */
    public synchronized void m78259f0(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str + "_" + str2 + "_server_lost_cursor").commit();
    }

    /* renamed from: g */
    public void m78260g(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str + "_lastChannelStopFail").commit();
    }

    /* renamed from: g0 */
    public synchronized void m78261g0(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str + "_" + str2 + "_refund_update_time").commit();
    }

    /* renamed from: h */
    public void m78262h(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str + "_lastVersionTime").commit();
    }

    /* renamed from: h0 */
    public synchronized void m78263h0(boolean z10) {
        if (this.f59259b == null) {
            return;
        }
        C11839m.m70688i("SyncSetting", "syncV2 set calendar need full sync: " + z10);
        SharedPreferences.Editor editorEdit = this.f59259b.edit();
        editorEdit.putBoolean("calendarNeedFullSync", z10);
        editorEdit.commit();
    }

    /* renamed from: i */
    public void m78264i(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str + "_lastVersionTime_sizeOrNum").commit();
    }

    /* renamed from: i0 */
    public synchronized boolean m78265i0(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str + SyncProtocol.Constant.CTAG, str2);
        return editorEdit.commit();
    }

    /* renamed from: j */
    public void m78266j(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str + "_lastSubscribeTime").commit();
    }

    /* renamed from: j0 */
    public synchronized void m78267j0(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(str + "ctag_expired", z10);
        editorEdit.commit();
    }

    /* renamed from: k */
    public void m78268k(String str, List<String> list) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove(str + "_" + it.next() + "_lastUpperLimitsTime").commit();
        }
    }

    /* renamed from: k0 */
    public synchronized void m78269k0(String str, int i10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt(str + "ctagstatus", i10);
        editorEdit.commit();
    }

    /* renamed from: l */
    public void m78270l(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str + str2 + "lock").commit();
    }

    /* renamed from: l0 */
    public void m78271l0(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString("data_base_list_data", str).commit();
    }

    /* renamed from: m */
    public void m78272m(String str) {
        C13007b c13007bM78205Y = m78205Y(this.f59258a);
        Set<String> setM78242T = c13007bM78205Y.m78242T(str);
        if (setM78242T == null || setM78242T.isEmpty()) {
            return;
        }
        for (String str2 : setM78242T) {
            c13007bM78205Y.m78250b(str2);
            C11839m.m70688i("SyncSetting", "clear old ctag success, dataType: " + str2);
        }
    }

    /* renamed from: m0 */
    public void m78273m0(String str, String str2) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str + "_dataVersion", str2).commit();
    }

    /* renamed from: n */
    public void m78274n(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str + "_prepare_times").commit();
        }
    }

    /* renamed from: n0 */
    public synchronized boolean m78275n0() {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("delete_wlan_fail", true);
        return editorEdit.commit();
    }

    /* renamed from: o */
    public void m78276o(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str + "_prepare_trace_id").commit();
        }
    }

    /* renamed from: o0 */
    public void m78277o0(boolean z10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("isDownloadQuic", z10).commit();
        }
    }

    /* renamed from: p */
    public void m78278p(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(str + "_third_sync_scene").commit();
        }
    }

    /* renamed from: p0 */
    public synchronized void m78279p0(String str, String str2, boolean z10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(str + "_" + str2 + "_needFullSync", z10);
        editorEdit.commit();
    }

    /* renamed from: q */
    public void m78280q(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str + "updatectag").commit();
    }

    /* renamed from: q0 */
    public void m78281q0(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str + "_firstMigrateV2", z10).commit();
        }
    }

    /* renamed from: r */
    public void m78282r(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str + "_has_subscribed_suc").commit();
    }

    /* renamed from: r0 */
    public void m78283r0(String str, long j10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str + "_first_prepare_time", j10).commit();
        }
    }

    /* renamed from: s */
    public synchronized Map<String, ?> m78284s() {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return new HashMap();
        }
        return sharedPreferences.getAll();
    }

    /* renamed from: s0 */
    public void m78285s0(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString("full_data_list_datas", str).commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011  */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean m78286t() {
        /*
            r3 = this;
            monitor-enter(r3)
            android.content.SharedPreferences r0 = r3.f59259b     // Catch: java.lang.Throwable -> Lf
            if (r0 == 0) goto L11
            java.lang.String r1 = "calendarNeedFullSync"
            r2 = 1
            boolean r0 = r0.getBoolean(r1, r2)     // Catch: java.lang.Throwable -> Lf
            if (r0 == 0) goto L11
            goto L12
        Lf:
            r0 = move-exception
            goto L14
        L11:
            r2 = 0
        L12:
            monitor-exit(r3)
            return r2
        L14:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tc.C13007b.m78286t():boolean");
    }

    /* renamed from: t0 */
    public synchronized boolean m78287t0(String str, String str2, boolean z10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean(str + str2 + "_risk_ignore", z10);
        return editorEdit.commit();
    }

    /* renamed from: u */
    public synchronized String m78288u(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(str + SyncProtocol.Constant.CTAG, null);
    }

    /* renamed from: u0 */
    public void m78289u0(String str, String str2, long j10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str + "_" + str2 + "_upperlimits", j10).commit();
        }
    }

    /* renamed from: v */
    public synchronized boolean m78290v(String str) {
        boolean z10;
        SharedPreferences sharedPreferences = this.f59259b;
        z10 = true;
        if (sharedPreferences != null) {
            if (!sharedPreferences.getBoolean(str + "ctag_expired", true)) {
                z10 = false;
            }
        }
        return z10;
    }

    /* renamed from: v0 */
    public void m78291v0(String str, boolean z10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str + "_lastChannelStopFail", z10).commit();
        }
    }

    /* renamed from: w */
    public synchronized int m78292w(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(str + "ctagstatus", 0);
    }

    /* renamed from: w0 */
    public void m78293w0(long j10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_data_request_time", j10).commit();
        }
    }

    /* renamed from: x */
    public String m78294x() {
        SharedPreferences sharedPreferences = this.f59259b;
        return sharedPreferences == null ? "" : sharedPreferences.getString("data_base_list_data", "");
    }

    /* renamed from: x0 */
    public void m78295x0(String str, long j10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str + "_lastVersionTime", j10).commit();
        }
    }

    /* renamed from: y */
    public String m78296y(String str) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(str + "_dataVersion", "");
    }

    /* renamed from: y0 */
    public void m78297y0(String str, long j10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str + "_lastSubscribeTime", j10).commit();
        }
    }

    /* renamed from: z */
    public synchronized boolean m78298z(String str, String str2) {
        boolean z10;
        SharedPreferences sharedPreferences = this.f59259b;
        z10 = false;
        if (sharedPreferences != null) {
            if (sharedPreferences.getBoolean(str + "_" + str2 + "_needFullSync", false)) {
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: z0 */
    public void m78299z0(String str, String str2, long j10) {
        SharedPreferences sharedPreferences = this.f59259b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str + "_" + str2 + "_lastUpperLimitsTime", j10).commit();
        }
    }

    public C13007b(Context context, int i10) {
        this.f59258a = context;
        this.f59259b = C0214f0.m1382b(context, "syncsetting", i10);
    }
}
