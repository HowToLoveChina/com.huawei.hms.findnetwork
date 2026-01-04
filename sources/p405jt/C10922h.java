package p405jt;

import android.text.TextUtils;

/* renamed from: jt.h */
/* loaded from: classes2.dex */
public class C10922h {

    /* renamed from: b */
    public InterfaceC10925k f51812b;

    /* renamed from: d */
    public String f51814d;

    /* renamed from: a */
    public String f51811a = "SDK.";

    /* renamed from: c */
    public int f51813c = 4;

    /* renamed from: e */
    public boolean f51815e = false;

    /* renamed from: a */
    public final C10927m m66016a(int i10, String str, String str2) {
        C10927m c10927m = new C10927m(this.f51814d, i10, str);
        c10927m.m66029c(str2);
        return c10927m;
    }

    /* renamed from: b */
    public void m66017b(int i10, String str, String str2, Throwable th2) {
        m66022g(i10, str, str2 + " | Exception: " + th2.getClass().getSimpleName() + " msg: " + AbstractC10928n.m66033a(th2.getMessage()));
    }

    /* renamed from: c */
    public void m66018c(int i10, String str, Throwable th2) {
        if (th2 == null || !m66021f(i10)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Exception: ");
        sb2.append(th2.getClass().getName());
        sb2.append(" msg: ");
        sb2.append(AbstractC10928n.m66033a(th2.getMessage()));
        sb2.append('\n');
        int i11 = 0;
        for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
            if (i11 >= 10) {
                break;
            }
            sb2.append(stackTraceElement.toString());
            sb2.append('\n');
            i11++;
        }
        m66022g(i10, str, sb2.toString());
    }

    /* renamed from: d */
    public void m66019d(String str, String str2) {
        if (this.f51815e) {
            this.f51812b.mo66002a(m66016a(4, str, str2), 4, str);
        }
    }

    /* renamed from: e */
    public void m66020e(C10917c c10917c) {
        int iM65983c = c10917c.m65983c();
        String strM65984d = c10917c.m65984d();
        String strM65982b = c10917c.m65982b();
        String strM65981a = c10917c.m65981a();
        this.f51812b = C10926l.m66026a(c10917c.m65987g());
        this.f51813c = iM65983c;
        this.f51814d = strM65982b;
        String str = strM65982b + "_Log";
        if (TextUtils.isEmpty(strM65981a)) {
            strM65981a = str;
        }
        this.f51811a = strM65982b + ".";
        this.f51812b.mo66001a(strM65984d, strM65981a);
        this.f51815e = true;
    }

    /* renamed from: f */
    public boolean m66021f(int i10) {
        return this.f51815e && i10 >= this.f51813c;
    }

    /* renamed from: g */
    public void m66022g(int i10, String str, String str2) {
        if (m66021f(i10)) {
            String str3 = this.f51811a + str;
            this.f51812b.mo66002a(m66016a(i10, str3, str2), i10, str3);
        }
    }
}
