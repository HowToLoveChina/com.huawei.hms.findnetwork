package com.huawei.uikit.hwviewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes9.dex */
public abstract class HwPagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;

    /* renamed from: c */
    private static final String f44605c = "HwPagerAdapter";

    /* renamed from: a */
    private final DataSetObservable f44606a = new DataSetObservable();

    /* renamed from: b */
    private DataSetObserver f44607b;

    /* renamed from: a */
    public void mo55780a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f44607b = dataSetObserver;
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
    }

    public void finishUpdate(ViewGroup viewGroup) {
    }

    public abstract int getCount();

    public int getItemPosition(Object obj) {
        return -1;
    }

    public float getPageHeight(int i10) {
        return 1.0f;
    }

    public CharSequence getPageTitle(int i10) {
        return null;
    }

    public float getPageWidth(int i10) {
        return 1.0f;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        return null;
    }

    public abstract boolean isViewFromObject(View view, Object obj);

    public void notifyDataSetChanged() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.f44607b;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f44606a.notifyChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f44606a.registerObserver(dataSetObserver);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
    }

    public void startUpdate(ViewGroup viewGroup) {
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f44606a.unregisterObserver(dataSetObserver);
    }
}
