package p015ak;

/* renamed from: ak.u */
/* loaded from: classes6.dex */
public class C0236u {
    /* renamed from: a */
    public static boolean m1650a() {
        return C0214f0.m1382b(C0213f.m1377a(), "non_delete_flag_sp", 0).getBoolean("NEED_EXECUTE_SYNC_TASK", false);
    }

    /* renamed from: b */
    public static long m1651b() {
        return C0214f0.m1382b(C0213f.m1377a(), "non_delete_flag_sp", 0).getLong("PROPORTION_RANDOM_INT", 0L);
    }

    /* renamed from: c */
    public static boolean m1652c() {
        return C0214f0.m1382b(C0213f.m1377a(), "non_delete_flag_sp", 0).getBoolean("SPACE_EXPERIENCE_PARTICIPATE_V4", false);
    }

    /* renamed from: d */
    public static void m1653d() {
        C0214f0.m1382b(C0213f.m1377a(), "non_delete_flag_sp", 0).edit().putBoolean("has_enter_guide", true).commit();
    }

    /* renamed from: e */
    public static void m1654e() {
        C0214f0.m1382b(C0213f.m1377a(), "non_delete_flag_sp", 0).edit().putBoolean("has_exit_guide", true).commit();
    }

    /* renamed from: f */
    public static void m1655f(boolean z10) {
        C0214f0.m1382b(C0213f.m1377a(), "non_delete_flag_sp", 0).edit().putBoolean("NEED_EXECUTE_SYNC_TASK", z10).commit();
    }

    /* renamed from: g */
    public static void m1656g() {
        C0214f0.m1382b(C0213f.m1377a(), "non_delete_flag_sp", 0).edit().putBoolean("has_shown_up_guide_notify", true).commit();
    }

    /* renamed from: h */
    public static void m1657h(long j10) {
        C0214f0.m1382b(C0213f.m1377a(), "non_delete_flag_sp", 0).edit().putLong("PROPORTION_RANDOM_INT", j10).commit();
    }

    /* renamed from: i */
    public static void m1658i() {
        C0214f0.m1382b(C0213f.m1377a(), "non_delete_flag_sp", 0).edit().putBoolean("SPACE_EXPERIENCE_PARTICIPATE_V4", true).commit();
    }
}
