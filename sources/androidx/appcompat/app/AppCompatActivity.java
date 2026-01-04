package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.C0338l;
import androidx.appcompat.widget.C0533j0;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.C0790g0;
import androidx.lifecycle.C0792h0;
import p023b.InterfaceC1084b;
import p024b0.C1090f;
import p303g.AbstractC9814b;
import p694v.C13299a;
import p694v.C13302d;
import p694v.C13312n;
import p724w0.C13512b;
import p724w0.C13515e;

/* loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements InterfaceC0376a, C13312n.a {

    /* renamed from: y */
    public AbstractC0378c f1251y;

    /* renamed from: z */
    public Resources f1252z;

    /* renamed from: androidx.appcompat.app.AppCompatActivity$a */
    public class C0354a implements C13512b.c {
        public C0354a() {
        }

        @Override // p724w0.C13512b.c
        /* renamed from: a */
        public Bundle mo1944a() {
            Bundle bundle = new Bundle();
            AppCompatActivity.this.m2038e0().mo2055B(bundle);
            return bundle;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatActivity$b */
    public class C0355b implements InterfaceC1084b {
        public C0355b() {
        }

        @Override // p023b.InterfaceC1084b
        /* renamed from: a */
        public void mo1945a(Context context) {
            AbstractC0378c abstractC0378cM2038e0 = AppCompatActivity.this.m2038e0();
            abstractC0378cM2038e0.mo2132s();
            abstractC0378cM2038e0.mo2140x(AppCompatActivity.this.mo1909J().m81262b("androidx:appcompat"));
        }
    }

    public AppCompatActivity() {
        m2041g0();
    }

    /* renamed from: K */
    public final void m2035K() {
        C0790g0.m4947a(getWindow().getDecorView(), this);
        C0792h0.m4955a(getWindow().getDecorView(), this);
        C13515e.m81275a(getWindow().getDecorView(), this);
        C0338l.m1954a(getWindow().getDecorView(), this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m2035K();
        m2038e0().mo2112e(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(m2038e0().mo2115g(context));
    }

    @Override // androidx.appcompat.app.InterfaceC0376a
    /* renamed from: b */
    public void mo2036b(AbstractC9814b abstractC9814b) {
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar actionBarM2040f0 = m2040f0();
        if (getWindow().hasFeature(0)) {
            if (actionBarM2040f0 == null || !actionBarM2040f0.m1974g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar actionBarM2040f0 = m2040f0();
        if (keyCode == 82 && actionBarM2040f0 != null && actionBarM2040f0.m1983p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.appcompat.app.InterfaceC0376a
    /* renamed from: e */
    public AbstractC9814b mo2037e(AbstractC9814b.a aVar) {
        return null;
    }

    /* renamed from: e0 */
    public AbstractC0378c m2038e0() {
        if (this.f1251y == null) {
            this.f1251y = AbstractC0378c.m2199h(this, this);
        }
        return this.f1251y;
    }

    @Override // androidx.appcompat.app.InterfaceC0376a
    /* renamed from: f */
    public void mo2039f(AbstractC9814b abstractC9814b) {
    }

    /* renamed from: f0 */
    public ActionBar m2040f0() {
        return m2038e0().mo2130r();
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i10) {
        return (T) m2038e0().mo2119j(i10);
    }

    /* renamed from: g0 */
    public final void m2041g0() {
        mo1909J().m81267h("androidx:appcompat", new C0354a());
        m1906G(new C0355b());
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return m2038e0().mo2127p();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f1252z == null && C0533j0.m3048c()) {
            this.f1252z = new C0533j0(this, super.getResources());
        }
        Resources resources = this.f1252z;
        return resources == null ? super.getResources() : resources;
    }

    /* renamed from: h0 */
    public void m2042h0(C13312n c13312n) {
        c13312n.m79809b(this);
    }

    /* renamed from: i0 */
    public void m2043i0(C1090f c1090f) {
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        m2038e0().mo2134t();
    }

    /* renamed from: j0 */
    public void m2044j0(int i10) {
    }

    /* renamed from: k0 */
    public void m2045k0(C13312n c13312n) {
    }

    @Override // p694v.C13312n.a
    /* renamed from: l */
    public Intent mo2046l() {
        return C13302d.m79770a(this);
    }

    @Deprecated
    /* renamed from: l0 */
    public void m2047l0() {
    }

    /* renamed from: m0 */
    public boolean m2048m0() {
        Intent intentMo2046l = mo2046l();
        if (intentMo2046l == null) {
            return false;
        }
        if (!m2051p0(intentMo2046l)) {
            m2050o0(intentMo2046l);
            return true;
        }
        C13312n c13312nM79807d = C13312n.m79807d(this);
        m2042h0(c13312nM79807d);
        m2045k0(c13312nM79807d);
        c13312nM79807d.m79811e();
        try {
            C13299a.m79749a(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    /* renamed from: n0 */
    public final boolean m2049n0(KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: o0 */
    public void m2050o0(Intent intent) {
        C13302d.m79774e(this, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m2038e0().mo2138w(configuration);
        if (this.f1252z != null) {
            this.f1252z.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        m2047l0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m2038e0().mo2142y();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (m2049n0(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        ActionBar actionBarM2040f0 = m2040f0();
        if (menuItem.getItemId() != 16908332 || actionBarM2040f0 == null || (actionBarM2040f0.mo1977j() & 4) == 0) {
            return false;
        }
        return m2048m0();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m2038e0().mo2144z(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        m2038e0().mo2053A();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        m2038e0().mo2057C();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        m2038e0().mo2059D();
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        m2038e0().mo2075M(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar actionBarM2040f0 = m2040f0();
        if (getWindow().hasFeature(0)) {
            if (actionBarM2040f0 == null || !actionBarM2040f0.m1984q()) {
                super.openOptionsMenu();
            }
        }
    }

    /* renamed from: p0 */
    public boolean m2051p0(Intent intent) {
        return C13302d.m79775f(this, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        m2035K();
        m2038e0().mo2065H(i10);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        super.setTheme(i10);
        m2038e0().mo2073L(i10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        m2035K();
        m2038e0().mo2067I(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m2035K();
        m2038e0().mo2069J(view, layoutParams);
    }
}
