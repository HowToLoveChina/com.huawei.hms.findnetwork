package com.huawei.uikit.hwviewpager.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes9.dex */
class aauaf extends HwPagerAdapter {

    /* renamed from: j */
    private static final int f44848j = 4;

    /* renamed from: k */
    private static final int f44849k = 2;

    /* renamed from: l */
    private static final int f44850l = 1;

    /* renamed from: d */
    private final HwPagerAdapter f44851d;

    /* renamed from: e */
    private boolean f44852e;

    /* renamed from: f */
    private int f44853f = 4;

    /* renamed from: g */
    private int f44854g = 2;

    /* renamed from: h */
    private SparseArray<bzrwd> f44855h = new SparseArray<>();

    /* renamed from: i */
    private boolean f44856i;

    public static class bzrwd {

        /* renamed from: a */
        ViewGroup f44857a;

        /* renamed from: b */
        int f44858b;

        /* renamed from: c */
        Object f44859c;

        public bzrwd(ViewGroup viewGroup, int i10, Object obj) {
            this.f44857a = viewGroup;
            this.f44858b = i10;
            this.f44859c = obj;
        }
    }

    public aauaf(HwPagerAdapter hwPagerAdapter, boolean z10) {
        this.f44851d = hwPagerAdapter;
        this.f44852e = z10;
    }

    /* renamed from: d */
    private int m55936d() {
        return this.f44854g;
    }

    /* renamed from: e */
    private int m55937e() {
        return (m55936d() + m55943c()) - 1;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    /* renamed from: a */
    public void mo55780a(DataSetObserver dataSetObserver) {
        this.f44851d.mo55780a(dataSetObserver);
    }

    /* renamed from: b */
    public int m55941b(int i10) {
        return i10 + this.f44854g;
    }

    /* renamed from: c */
    public int m55944c(int i10) {
        int iM55943c = m55943c();
        if (iM55943c == 0) {
            return 0;
        }
        int i11 = (i10 - this.f44854g) % iM55943c;
        return i11 < 0 ? i11 + iM55943c : i11;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        int iM55936d = m55936d();
        int iM55937e = m55937e();
        int iM55944c = this.f44852e ? m55944c(i10) : i10;
        if (this.f44856i && (i10 == iM55936d || i10 == iM55937e)) {
            this.f44855h.put(i10, new bzrwd(viewGroup, iM55944c, obj));
        } else {
            this.f44851d.destroyItem(viewGroup, iM55944c, obj);
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        this.f44851d.finishUpdate(viewGroup);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public int getCount() {
        return this.f44852e ? this.f44851d.getCount() + this.f44853f : this.f44851d.getCount();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public int getItemPosition(Object obj) {
        return this.f44851d.getItemPosition(obj);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public CharSequence getPageTitle(int i10) {
        if (this.f44852e) {
            i10 = m55944c(i10);
        }
        return this.f44851d.getPageTitle(i10);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public float getPageWidth(int i10) {
        if (this.f44852e) {
            i10 = m55944c(i10);
        }
        return this.f44851d.getPageWidth(i10);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        bzrwd bzrwdVar;
        int iM55944c = this.f44852e ? m55944c(i10) : i10;
        if (!this.f44856i || (bzrwdVar = this.f44855h.get(i10)) == null) {
            return this.f44851d.instantiateItem(viewGroup, iM55944c);
        }
        this.f44855h.remove(i10);
        return bzrwdVar.f44859c;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return this.f44851d.isViewFromObject(view, obj);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void notifyDataSetChanged() {
        this.f44855h = new SparseArray<>();
        this.f44851d.notifyDataSetChanged();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f44851d.registerDataSetObserver(dataSetObserver);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.f44851d.restoreState(parcelable, classLoader);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Parcelable saveState() {
        return this.f44851d.saveState();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        if (this.f44852e) {
            i10 = m55944c(i10);
        }
        this.f44851d.setPrimaryItem(viewGroup, i10, obj);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        this.f44851d.startUpdate(viewGroup);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f44851d.unregisterDataSetObserver(dataSetObserver);
    }

    /* renamed from: a */
    public void m55940a(boolean z10) {
        this.f44856i = z10;
    }

    /* renamed from: b */
    public HwPagerAdapter m55942b() {
        return this.f44851d;
    }

    /* renamed from: a */
    public void m55939a(int i10) {
        int i11 = i10 - 1;
        this.f44854g = i11;
        this.f44853f = i10 + i11;
    }

    /* renamed from: c */
    public int m55943c() {
        return this.f44851d.getCount();
    }

    /* renamed from: a */
    public int m55938a() {
        return this.f44853f;
    }
}
