package com.huawei.openalliance.p169ad.views.viewpager;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.huawei.openalliance.ad.views.viewpager.f */
/* loaded from: classes2.dex */
public abstract class AbstractC8161f {

    /* renamed from: a */
    private final DataSetObservable f38250a = new DataSetObservable();

    /* renamed from: b */
    private DataSetObserver f38251b;

    /* renamed from: a */
    public float m50598a(int i10) {
        return 1.0f;
    }

    /* renamed from: a */
    public abstract int mo42547a();

    /* renamed from: a */
    public abstract boolean mo42550a(View view, Object obj);

    /* renamed from: b */
    public Parcelable m50603b() {
        return null;
    }

    /* renamed from: a */
    public int m50599a(Object obj) {
        return -1;
    }

    /* renamed from: b */
    public void m50604b(ViewGroup viewGroup) {
    }

    /* renamed from: a */
    public Object mo42548a(ViewGroup viewGroup, int i10) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    /* renamed from: b */
    public void m50605b(ViewGroup viewGroup, int i10, Object obj) {
    }

    /* renamed from: a */
    public void m50600a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f38251b = dataSetObserver;
        }
    }

    /* renamed from: a */
    public void m50601a(Parcelable parcelable, ClassLoader classLoader) {
    }

    /* renamed from: a */
    public void m50602a(ViewGroup viewGroup) {
    }

    /* renamed from: a */
    public void mo42549a(ViewGroup viewGroup, int i10, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }
}
