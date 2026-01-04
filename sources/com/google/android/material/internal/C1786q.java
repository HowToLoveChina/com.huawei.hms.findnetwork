package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* renamed from: com.google.android.material.internal.q */
/* loaded from: classes.dex */
public class C1786q implements InterfaceC1787r {

    /* renamed from: a */
    public final ViewOverlay f8407a;

    public C1786q(View view) {
        this.f8407a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.InterfaceC1787r
    /* renamed from: a */
    public void mo10778a(Drawable drawable) {
        this.f8407a.add(drawable);
    }

    @Override // com.google.android.material.internal.InterfaceC1787r
    /* renamed from: b */
    public void mo10779b(Drawable drawable) {
        this.f8407a.remove(drawable);
    }
}
