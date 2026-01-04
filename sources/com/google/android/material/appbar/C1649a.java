package com.google.android.material.appbar;

import android.view.View;
import p273f0.C9603h0;

/* renamed from: com.google.android.material.appbar.a */
/* loaded from: classes.dex */
public class C1649a {

    /* renamed from: a */
    public final View f7448a;

    /* renamed from: b */
    public int f7449b;

    /* renamed from: c */
    public int f7450c;

    /* renamed from: d */
    public int f7451d;

    /* renamed from: e */
    public int f7452e;

    /* renamed from: f */
    public boolean f7453f = true;

    /* renamed from: g */
    public boolean f7454g = true;

    public C1649a(View view) {
        this.f7448a = view;
    }

    /* renamed from: a */
    public void m9600a() {
        View view = this.f7448a;
        C9603h0.m59872a0(view, this.f7451d - (view.getTop() - this.f7449b));
        View view2 = this.f7448a;
        C9603h0.m59870Z(view2, this.f7452e - (view2.getLeft() - this.f7450c));
    }

    /* renamed from: b */
    public int m9601b() {
        return this.f7449b;
    }

    /* renamed from: c */
    public int m9602c() {
        return this.f7451d;
    }

    /* renamed from: d */
    public void m9603d() {
        this.f7449b = this.f7448a.getTop();
        this.f7450c = this.f7448a.getLeft();
    }

    /* renamed from: e */
    public boolean m9604e(int i10) {
        if (!this.f7454g || this.f7452e == i10) {
            return false;
        }
        this.f7452e = i10;
        m9600a();
        return true;
    }

    /* renamed from: f */
    public boolean m9605f(int i10) {
        if (!this.f7453f || this.f7451d == i10) {
            return false;
        }
        this.f7451d = i10;
        m9600a();
        return true;
    }
}
