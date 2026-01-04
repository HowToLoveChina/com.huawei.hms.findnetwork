package p689ut;

import java.util.Objects;

/* renamed from: ut.a */
/* loaded from: classes5.dex */
public class C13248a {

    /* renamed from: c */
    public static final C13248a f59931c = new C13248a(0, "Success");

    /* renamed from: d */
    public static final C13248a f59932d = new C13248a(500010, "Input info is empty");

    /* renamed from: e */
    public static final C13248a f59933e = new C13248a(500020, "The number of input info exceeds the limit");

    /* renamed from: f */
    public static final C13248a f59934f = new C13248a(500030, "One of the RSSI exceeds the limit(should be -127 <= RSSI <= 0)");

    /* renamed from: g */
    public static final C13248a f59935g = new C13248a(500050, "All infos is filtered, resulting in no info being able to give location");

    /* renamed from: h */
    public static final C13248a f59936h = new C13248a(500060, "The localization algorithm failed to run, usually because the number of iterations exceeded the upper limit");

    /* renamed from: i */
    public static final C13248a f59937i = new C13248a(500070, "Confidence error (All of confidences may be 0)");

    /* renamed from: j */
    public static final C13248a f59938j = new C13248a(500080, "The LogFunc is null");

    /* renamed from: k */
    public static final C13248a f59939k = new C13248a(500090, "Tag is moved");

    /* renamed from: l */
    public static final C13248a f59940l = new C13248a(510000, "Unknown error");

    /* renamed from: a */
    public final int f59941a;

    /* renamed from: b */
    public final String f59942b;

    public C13248a(int i10, String str) {
        this.f59941a = i10;
        this.f59942b = str;
    }

    /* renamed from: a */
    public int m79634a() {
        return this.f59941a;
    }

    /* renamed from: b */
    public String m79635b() {
        return this.f59942b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f59941a == ((C13248a) obj).f59941a;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f59941a));
    }

    public String toString() {
        return "{\"errorCode\":" + this.f59941a + ",\"errorMsg\":\"" + this.f59942b + "\"}";
    }
}
