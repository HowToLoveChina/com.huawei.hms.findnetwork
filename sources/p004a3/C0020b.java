package p004a3;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* renamed from: a3.b */
/* loaded from: classes.dex */
public final class C0020b {

    /* renamed from: a */
    public final View f39a;

    /* renamed from: b */
    public boolean f40b = false;

    /* renamed from: c */
    public int f41c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public C0020b(InterfaceC0019a interfaceC0019a) {
        this.f39a = (View) interfaceC0019a;
    }

    /* renamed from: a */
    public final void m76a() {
        ViewParent parent = this.f39a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).m3712p(this.f39a);
        }
    }

    /* renamed from: b */
    public int m77b() {
        return this.f41c;
    }

    /* renamed from: c */
    public boolean m78c() {
        return this.f40b;
    }

    /* renamed from: d */
    public void m79d(Bundle bundle) {
        this.f40b = bundle.getBoolean("expanded", false);
        this.f41c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f40b) {
            m76a();
        }
    }

    /* renamed from: e */
    public Bundle m80e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f40b);
        bundle.putInt("expandedComponentIdHint", this.f41c);
        return bundle;
    }

    /* renamed from: f */
    public void m81f(int i10) {
        this.f41c = i10;
    }
}
