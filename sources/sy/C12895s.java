package sy;

/* renamed from: sy.s */
/* loaded from: classes9.dex */
public class C12895s {

    /* renamed from: a */
    public String f58679a;

    /* renamed from: b */
    public int f58680b = 0;

    public C12895s(String str) {
        this.f58679a = str;
    }

    /* renamed from: a */
    public boolean m77313a() {
        return this.f58680b != -1;
    }

    /* renamed from: b */
    public String m77314b() {
        int i10 = this.f58680b;
        if (i10 == -1) {
            return null;
        }
        int iIndexOf = this.f58679a.indexOf(46, i10);
        if (iIndexOf == -1) {
            String strSubstring = this.f58679a.substring(this.f58680b);
            this.f58680b = -1;
            return strSubstring;
        }
        String strSubstring2 = this.f58679a.substring(this.f58680b, iIndexOf);
        this.f58680b = iIndexOf + 1;
        return strSubstring2;
    }
}
