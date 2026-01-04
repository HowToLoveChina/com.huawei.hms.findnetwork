package p216d4;

import android.text.TextUtils;

/* renamed from: d4.b0 */
/* loaded from: classes.dex */
public class C9001b0 {

    /* renamed from: a */
    public int f45617a;

    /* renamed from: b */
    public int f45618b;

    /* renamed from: c */
    public StringBuilder f45619c;

    /* renamed from: a */
    public int m56864a() {
        return this.f45618b;
    }

    /* renamed from: b */
    public void m56865b(int i10) {
        this.f45618b = i10;
    }

    /* renamed from: c */
    public void m56866c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb2 = this.f45619c;
        if (sb2 == null) {
            this.f45619c = new StringBuilder(str);
        } else {
            sb2.append("|");
            sb2.append(str);
        }
    }

    /* renamed from: d */
    public String m56867d() {
        StringBuilder sb2 = this.f45619c;
        if (sb2 == null) {
            return null;
        }
        return sb2.toString();
    }

    /* renamed from: e */
    public void m56868e(int i10) {
        this.f45617a = i10;
    }

    /* renamed from: f */
    public int m56869f() {
        return this.f45617a;
    }
}
