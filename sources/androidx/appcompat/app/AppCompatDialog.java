package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.appcompat.R$attr;
import p273f0.C9616o;
import p303g.AbstractC9814b;

/* loaded from: classes.dex */
public class AppCompatDialog extends ComponentDialog implements InterfaceC0376a {

    /* renamed from: c */
    public AbstractC0378c f1357c;

    /* renamed from: d */
    public final C9616o.a f1358d;

    public AppCompatDialog(Context context) {
        this(context, 0);
    }

    /* renamed from: k */
    private static int m2188k(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m2189j().mo2112e(view, layoutParams);
    }

    @Override // androidx.appcompat.app.InterfaceC0376a
    /* renamed from: b */
    public void mo2036b(AbstractC9814b abstractC9814b) {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        m2189j().mo2142y();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C9616o.m60121b(this.f1358d, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // androidx.appcompat.app.InterfaceC0376a
    /* renamed from: e */
    public AbstractC9814b mo2037e(AbstractC9814b.a aVar) {
        return null;
    }

    @Override // androidx.appcompat.app.InterfaceC0376a
    /* renamed from: f */
    public void mo2039f(AbstractC9814b abstractC9814b) {
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i10) {
        return (T) m2189j().mo2119j(i10);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        m2189j().mo2134t();
    }

    /* renamed from: j */
    public AbstractC0378c m2189j() {
        if (this.f1357c == null) {
            this.f1357c = AbstractC0378c.m2200i(this, this);
        }
        return this.f1357c;
    }

    /* renamed from: l */
    public boolean m2190l(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    /* renamed from: m */
    public boolean m2191m(int i10) {
        return m2189j().mo2063G(i10);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        m2189j().mo2132s();
        super.onCreate(bundle);
        m2189j().mo2140x(bundle);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        m2189j().mo2059D();
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int i10) {
        m2189j().mo2065H(i10);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m2189j().mo2075M(charSequence);
    }

    public AppCompatDialog(Context context, int i10) {
        super(context, m2188k(context, i10));
        this.f1358d = new C9616o.a() { // from class: androidx.appcompat.app.j
            @Override // p273f0.C9616o.a
            /* renamed from: s */
            public final boolean mo2216s(KeyEvent keyEvent) {
                return this.f1370a.m2190l(keyEvent);
            }
        };
        AbstractC0378c abstractC0378cM2189j = m2189j();
        abstractC0378cM2189j.mo2073L(m2188k(context, i10));
        abstractC0378cM2189j.mo2140x(null);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        m2189j().mo2067I(view);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m2189j().mo2069J(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i10) {
        super.setTitle(i10);
        m2189j().mo2075M(getContext().getString(i10));
    }
}
