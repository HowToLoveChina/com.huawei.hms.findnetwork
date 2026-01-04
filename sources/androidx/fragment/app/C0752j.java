package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import p243e0.C9373h;

/* renamed from: androidx.fragment.app.j */
/* loaded from: classes.dex */
public class C0752j {

    /* renamed from: a */
    public final AbstractC0754l<?> f4057a;

    public C0752j(AbstractC0754l<?> abstractC0754l) {
        this.f4057a = abstractC0754l;
    }

    /* renamed from: b */
    public static C0752j m4780b(AbstractC0754l<?> abstractC0754l) {
        return new C0752j((AbstractC0754l) C9373h.m58746g(abstractC0754l, "callbacks == null"));
    }

    /* renamed from: a */
    public void m4781a(Fragment fragment) {
        AbstractC0754l<?> abstractC0754l = this.f4057a;
        abstractC0754l.f4063e.m4579m(abstractC0754l, abstractC0754l, fragment);
    }

    /* renamed from: c */
    public void m4782c() {
        this.f4057a.f4063e.m4610x();
    }

    /* renamed from: d */
    public boolean m4783d(MenuItem menuItem) {
        return this.f4057a.f4063e.m4505A(menuItem);
    }

    /* renamed from: e */
    public void m4784e() {
        this.f4057a.f4063e.m4507B();
    }

    /* renamed from: f */
    public void m4785f() {
        this.f4057a.f4063e.m4510D();
    }

    /* renamed from: g */
    public void m4786g() {
        this.f4057a.f4063e.m4527M();
    }

    /* renamed from: h */
    public void m4787h() {
        this.f4057a.f4063e.m4535Q();
    }

    /* renamed from: i */
    public void m4788i() {
        this.f4057a.f4063e.m4537R();
    }

    /* renamed from: j */
    public void m4789j() {
        this.f4057a.f4063e.m4541T();
    }

    /* renamed from: k */
    public boolean m4790k() {
        return this.f4057a.f4063e.m4555a0(true);
    }

    /* renamed from: l */
    public FragmentManager m4791l() {
        return this.f4057a.f4063e;
    }

    /* renamed from: m */
    public void m4792m() {
        this.f4057a.f4063e.m4548W0();
    }

    /* renamed from: n */
    public View m4793n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f4057a.f4063e.m4609w0().onCreateView(view, str, context, attributeSet);
    }
}
