package p273f0;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: f0.a0 */
/* loaded from: classes.dex */
public class C9583a0 {

    /* renamed from: a */
    public int f47678a;

    /* renamed from: b */
    public int f47679b;

    public C9583a0(ViewGroup viewGroup) {
    }

    /* renamed from: a */
    public int m59783a() {
        return this.f47679b | this.f47678a;
    }

    /* renamed from: b */
    public void m59784b(View view, View view2, int i10) {
        m59785c(view, view2, i10, 0);
    }

    /* renamed from: c */
    public void m59785c(View view, View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f47679b = i10;
        } else {
            this.f47678a = i10;
        }
    }

    /* renamed from: d */
    public void m59786d(View view, int i10) {
        if (i10 == 1) {
            this.f47679b = 0;
        } else {
            this.f47678a = 0;
        }
    }
}
