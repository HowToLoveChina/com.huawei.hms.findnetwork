package p381j1;

/* renamed from: j1.y0 */
/* loaded from: classes.dex */
public class C10696y0 {

    /* renamed from: a */
    public final C10696y0 f51332a;

    /* renamed from: b */
    public final Object f51333b;

    /* renamed from: c */
    public final Object f51334c;

    /* renamed from: d */
    public final int f51335d;

    public C10696y0(C10696y0 c10696y0, Object obj, Object obj2, int i10, int i11) {
        this.f51332a = c10696y0;
        this.f51333b = obj;
        this.f51334c = obj2;
        this.f51335d = i10;
    }

    /* renamed from: a */
    public void m65319a(StringBuilder sb2) {
        C10696y0 c10696y0 = this.f51332a;
        if (c10696y0 == null) {
            sb2.append('$');
            return;
        }
        c10696y0.m65319a(sb2);
        Object obj = this.f51334c;
        if (obj == null) {
            sb2.append(".null");
            return;
        }
        if (obj instanceof Integer) {
            sb2.append('[');
            sb2.append(((Integer) this.f51334c).intValue());
            sb2.append(']');
            return;
        }
        sb2.append('.');
        String string = this.f51334c.toString();
        for (int i10 = 0; i10 < string.length(); i10++) {
            char cCharAt = string.charAt(i10);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < 'a' || cCharAt > 'z') && cCharAt <= 128))) {
                for (int i11 = 0; i11 < string.length(); i11++) {
                    char cCharAt2 = string.charAt(i11);
                    if (cCharAt2 == '\\') {
                        sb2.append('\\');
                        sb2.append('\\');
                        sb2.append('\\');
                    } else if ((cCharAt2 >= '0' && cCharAt2 <= '9') || ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || ((cCharAt2 >= 'a' && cCharAt2 <= 'z') || cCharAt2 > 128))) {
                        sb2.append(cCharAt2);
                    } else if (cCharAt2 == '\"') {
                        sb2.append('\\');
                        sb2.append('\\');
                        sb2.append('\\');
                    } else {
                        sb2.append('\\');
                        sb2.append('\\');
                    }
                    sb2.append(cCharAt2);
                }
                return;
            }
        }
        sb2.append(string);
    }

    public String toString() {
        if (this.f51332a == null) {
            return "$";
        }
        StringBuilder sb2 = new StringBuilder();
        m65319a(sb2);
        return sb2.toString();
    }
}
