package com.huawei.hicloud.base.p103ui;

import android.content.Context;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import p015ak.C0209d;
import p399jk.AbstractC10896a;
import sk.C12806c;
import sk.InterfaceC12805b;

/* loaded from: classes6.dex */
public class CustomOnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {

    /* renamed from: a */
    public Context f22150a;

    public CustomOnApplyWindowInsetsListener(Context context) {
        this.f22150a = context;
    }

    /* renamed from: a */
    public final boolean m29114a(WindowInsets windowInsets) {
        DisplayCutout displayCutout = windowInsets.getDisplayCutout();
        if (displayCutout == null) {
            AbstractC10896a.m65885d("CustomOnApplyWindowInsetsListener", "displayCutout is null");
        }
        return (C0209d.m1237b1(this.f22150a) && !C0209d.m1249e1() && displayCutout == null) ? false : true;
    }

    /* renamed from: b */
    public final void m29115b(WindowInsets windowInsets, InterfaceC12805b interfaceC12805b, int i10) {
        if (1 == i10) {
            AbstractC10896a.m65885d("CustomOnApplyWindowInsetsListener", "ROTATION_90");
            interfaceC12805b.onRotation90(windowInsets);
        } else if (2 == i10) {
            AbstractC10896a.m65885d("CustomOnApplyWindowInsetsListener", "ROTATION_180");
            interfaceC12805b.onRotation180(windowInsets);
        } else if (3 == i10) {
            AbstractC10896a.m65885d("CustomOnApplyWindowInsetsListener", "ROTATION_270");
            interfaceC12805b.onRotation270(windowInsets);
        } else {
            AbstractC10896a.m65885d("CustomOnApplyWindowInsetsListener", "portrait");
            interfaceC12805b.onRotationPortrait(windowInsets);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        boolean z10 = view instanceof InterfaceC12805b;
        if (view == 0 || !z10) {
            AbstractC10896a.m65886e("CustomOnApplyWindowInsetsListener", "view is null or isRotationListener=" + z10);
            return windowInsets.consumeStableInsets();
        }
        InterfaceC12805b interfaceC12805b = (InterfaceC12805b) view;
        if (C12806c.m76816g(this.f22150a) && C12806c.m76810a(this.f22150a) && m29114a(windowInsets)) {
            m29115b(windowInsets, interfaceC12805b, C12806c.m76811b(this.f22150a));
        } else {
            AbstractC10896a.m65885d("CustomOnApplyWindowInsetsListener", "no need fit nothch");
            interfaceC12805b.onRotationPortrait(windowInsets);
        }
        return windowInsets.consumeStableInsets();
    }
}
