package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public abstract class ActionProvider {

    /* renamed from: a */
    public final Context f3444a;

    /* renamed from: b */
    public InterfaceC0652a f3445b;

    /* renamed from: c */
    public InterfaceC0653b f3446c;

    /* renamed from: androidx.core.view.ActionProvider$a */
    public interface InterfaceC0652a {
        /* renamed from: j */
        void mo2581j(boolean z10);
    }

    /* renamed from: androidx.core.view.ActionProvider$b */
    public interface InterfaceC0653b {
        void onActionProviderVisibilityChanged(boolean z10);
    }

    public ActionProvider(Context context) {
        this.f3444a = context;
    }

    /* renamed from: a */
    public boolean mo2399a() {
        return false;
    }

    /* renamed from: b */
    public boolean mo2403b() {
        return true;
    }

    /* renamed from: c */
    public abstract View mo2400c();

    /* renamed from: d */
    public View mo2404d(MenuItem menuItem) {
        return mo2400c();
    }

    /* renamed from: e */
    public boolean mo2401e() {
        return false;
    }

    /* renamed from: f */
    public void mo2402f(SubMenu subMenu) {
    }

    /* renamed from: g */
    public boolean mo2405g() {
        return false;
    }

    /* renamed from: h */
    public void m3936h() {
        this.f3446c = null;
        this.f3445b = null;
    }

    /* renamed from: i */
    public void m3937i(InterfaceC0652a interfaceC0652a) {
        this.f3445b = interfaceC0652a;
    }

    /* renamed from: j */
    public void mo2406j(InterfaceC0653b interfaceC0653b) {
        if (this.f3446c != null && interfaceC0653b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f3446c = interfaceC0653b;
    }

    /* renamed from: k */
    public void m3938k(boolean z10) {
        InterfaceC0652a interfaceC0652a = this.f3445b;
        if (interfaceC0652a != null) {
            interfaceC0652a.mo2581j(z10);
        }
    }
}
