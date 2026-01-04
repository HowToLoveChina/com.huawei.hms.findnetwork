package tt;

/* renamed from: tt.a */
/* loaded from: classes5.dex */
public class C13068a {

    /* renamed from: a */
    public final int f59474a;

    /* renamed from: b */
    public int f59475b = 0;

    public C13068a(int i10) {
        this.f59474a = i10;
    }

    /* renamed from: a */
    public void m78834a() throws C13069b {
        int i10 = this.f59475b + 1;
        this.f59475b = i10;
        if (i10 > this.f59474a) {
            throw new C13069b("trigger %d", Integer.valueOf(this.f59474a));
        }
    }

    /* renamed from: b */
    public int m78835b() {
        return this.f59475b;
    }
}
