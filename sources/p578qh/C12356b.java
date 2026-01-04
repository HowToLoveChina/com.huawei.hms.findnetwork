package p578qh;

import android.text.TextUtils;

/* renamed from: qh.b */
/* loaded from: classes4.dex */
public class C12356b {

    /* renamed from: c */
    public static C12356b f57157c;

    /* renamed from: a */
    public int f57158a;

    /* renamed from: b */
    public String f57159b;

    public C12356b() {
        this.f57158a = 0;
        this.f57159b = "";
        this.f57158a = C12359e.m74385a("ro.build.hw_emui_api_level", 0);
        this.f57159b = m74379b(m74381d());
    }

    /* renamed from: e */
    public static synchronized C12356b m74377e() {
        try {
            if (f57157c == null) {
                f57157c = new C12356b();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f57157c;
    }

    /* renamed from: a */
    public int m74378a() {
        return this.f57158a;
    }

    /* renamed from: b */
    public final String m74379b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length == 2) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    /* renamed from: c */
    public String m74380c() {
        return this.f57159b;
    }

    /* renamed from: d */
    public final String m74381d() {
        return C12359e.m74387c("ro.build.version.emui", "");
    }
}
