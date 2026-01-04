package p305g1;

/* renamed from: g1.g */
/* loaded from: classes.dex */
public class C9842g {

    /* renamed from: a */
    public final int f48370a;

    /* renamed from: b */
    public final int f48371b;

    /* renamed from: e */
    public boolean f48374e;

    /* renamed from: d */
    public final StringBuilder f48373d = new StringBuilder();

    /* renamed from: c */
    public int f48372c = 0;

    public C9842g(int i10, int i11) {
        this.f48371b = i10;
        this.f48370a = i11;
        this.f48374e = i11 == 0;
    }

    /* renamed from: a */
    public String m61179a() {
        return this.f48373d.length() != 0 ? this.f48373d.substring(1) : "";
    }

    /* renamed from: b */
    public void m61180b(String str, int i10) {
        int i11 = this.f48371b;
        if (i10 < i11 || i10 >= i11 + this.f48370a) {
            return;
        }
        if (!str.equals("arg" + this.f48372c)) {
            this.f48374e = true;
        }
        this.f48373d.append(',');
        this.f48373d.append(str);
        this.f48372c++;
    }
}
