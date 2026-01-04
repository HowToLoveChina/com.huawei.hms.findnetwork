package com.huawei.uikit.hwcolumnsystem.widget;

/* loaded from: classes7.dex */
abstract class akxao {

    /* renamed from: a */
    protected int f41917a;

    /* renamed from: b */
    protected int f41918b;

    /* renamed from: c */
    protected float f41919c;

    /* renamed from: d */
    protected float f41920d;

    /* renamed from: e */
    protected int f41921e;

    /* renamed from: f */
    protected int f41922f;

    /* renamed from: g */
    protected int f41923g;

    /* renamed from: h */
    protected int f41924h;

    /* renamed from: i */
    protected int f41925i;

    /* renamed from: j */
    protected float f41926j;

    /* renamed from: k */
    protected int f41927k;

    /* renamed from: l */
    protected boolean f41928l;

    /* renamed from: a */
    public abstract float mo54173a(int i10);

    /* renamed from: a */
    public void m54175a(int i10, int i11, float f10, boolean z10) {
        this.f41917a = i10;
        this.f41918b = i11;
        this.f41919c = f10;
        this.f41928l = z10;
    }

    /* renamed from: b */
    public abstract int mo54177b();

    /* renamed from: b */
    public void m54178b(int i10) {
        this.f41927k = i10;
    }

    /* renamed from: c */
    public abstract int mo54179c();

    /* renamed from: c */
    public void m54180c(int i10) {
        this.f41923g = i10;
    }

    /* renamed from: d */
    public abstract int mo54181d();

    /* renamed from: e */
    public abstract void mo54182e();

    /* renamed from: a */
    public void m54176a(bzrwd bzrwdVar, int i10, boolean z10) {
        this.f41928l = z10;
        this.f41921e = bzrwdVar.m54197c();
        this.f41922f = bzrwdVar.m54195b();
        this.f41923g = bzrwdVar.m54193a();
        this.f41924h = bzrwdVar.m54199d();
        this.f41925i = i10;
        mo54182e();
    }

    /* renamed from: a */
    public int m54174a() {
        return this.f41927k;
    }
}
