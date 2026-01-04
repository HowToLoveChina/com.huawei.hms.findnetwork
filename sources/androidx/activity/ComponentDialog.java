package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.C0790g0;
import androidx.lifecycle.C0797m;
import androidx.lifecycle.InterfaceC0796l;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import p692uw.C13264g;
import p692uw.C13267j;

/* loaded from: classes.dex */
public class ComponentDialog extends Dialog implements InterfaceC0796l, InterfaceC0337k {

    /* renamed from: a */
    public C0797m f1089a;

    /* renamed from: b */
    public final OnBackPressedDispatcher f1090b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComponentDialog(Context context) {
        this(context, 0, 2, null);
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
    }

    /* renamed from: d */
    private final void m1929d() {
        Window window = getWindow();
        C13267j.m79674b(window);
        C0790g0.m4947a(window.getDecorView(), this);
        Window window2 = getWindow();
        C13267j.m79674b(window2);
        View decorView = window2.getDecorView();
        C13267j.m79676d(decorView, "window!!.decorView");
        C0338l.m1954a(decorView, this);
    }

    /* renamed from: i */
    public static final void m1930i(ComponentDialog componentDialog) {
        C13267j.m79677e(componentDialog, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        C13267j.m79677e(view, "view");
        m1929d();
        super.addContentView(view, layoutParams);
    }

    /* renamed from: c */
    public final C0797m m1931c() {
        C0797m c0797m = this.f1089a;
        if (c0797m != null) {
            return c0797m;
        }
        C0797m c0797m2 = new C0797m(this);
        this.f1089a = c0797m2;
        return c0797m2;
    }

    @Override // androidx.lifecycle.InterfaceC0796l
    /* renamed from: g */
    public final AbstractC0791h mo1915g() {
        return m1931c();
    }

    @Override // androidx.activity.InterfaceC0337k
    /* renamed from: h */
    public final OnBackPressedDispatcher mo1916h() {
        return this.f1090b;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f1090b.m1938f();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            this.f1090b.m1939g(getOnBackInvokedDispatcher());
        }
        m1931c().m4962h(AbstractC0791h.b.ON_CREATE);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        m1931c().m4962h(AbstractC0791h.b.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        m1931c().m4962h(AbstractC0791h.b.ON_DESTROY);
        this.f1089a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        m1929d();
        super.setContentView(i10);
    }

    public /* synthetic */ ComponentDialog(Context context, int i10, int i11, C13264g c13264g) {
        this(context, (i11 & 2) != 0 ? 0 : i10);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        C13267j.m79677e(view, "view");
        m1929d();
        super.setContentView(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComponentDialog(Context context, int i10) {
        super(context, i10);
        C13267j.m79677e(context, ParamConstants.Param.CONTEXT);
        this.f1090b = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.f
            @Override // java.lang.Runnable
            public final void run() {
                ComponentDialog.m1930i(this.f1111a);
            }
        });
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        C13267j.m79677e(view, "view");
        m1929d();
        super.setContentView(view, layoutParams);
    }
}
