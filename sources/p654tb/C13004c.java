package p654tb;

/* renamed from: tb.c */
/* loaded from: classes3.dex */
public class C13004c {

    /* renamed from: a */
    public boolean f59247a;

    /* renamed from: b */
    public String f59248b;

    /* renamed from: c */
    public String f59249c;

    /* renamed from: d */
    public C13002a f59250d;

    /* renamed from: e */
    public boolean f59251e;

    public C13004c(boolean z10, String str, String str2, C13002a c13002a, boolean z11) {
        this.f59247a = z10;
        this.f59248b = str;
        this.f59249c = str2;
        this.f59250d = c13002a;
        this.f59251e = z11;
    }

    /* renamed from: a */
    public static C13004c m78185a(String str, String str2, C13002a c13002a, boolean z10) {
        return new C13004c(false, str, str2, c13002a, z10);
    }

    /* renamed from: f */
    public static C13004c m78186f(String str, C13002a c13002a, boolean z10) {
        return new C13004c(true, "Success", str, c13002a, z10);
    }

    /* renamed from: b */
    public C13002a m78187b() {
        return this.f59250d;
    }

    /* renamed from: c */
    public String m78188c() {
        return this.f59249c;
    }

    /* renamed from: d */
    public boolean m78189d() {
        return this.f59247a;
    }

    /* renamed from: e */
    public boolean m78190e() {
        return this.f59251e;
    }
}
