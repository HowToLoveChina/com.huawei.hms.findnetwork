package com.huawei.uikit.hwviewpager.widget;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractC0735a0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes9.dex */
public abstract class HwFragmentStatePagerAdapter extends HwPagerAdapter {

    /* renamed from: i */
    private static final String f44590i = "HwFragmentStatePagerAdapt";

    /* renamed from: j */
    private static final boolean f44591j = false;

    /* renamed from: k */
    private static final int f44592k = -1;

    /* renamed from: d */
    private final FragmentManager f44593d;

    /* renamed from: e */
    private AbstractC0735a0 f44594e = null;

    /* renamed from: f */
    private ArrayList<Fragment.SavedState> f44595f = new ArrayList<>();

    /* renamed from: g */
    private ArrayList<Fragment> f44596g = new ArrayList<>();

    /* renamed from: h */
    private Fragment f44597h = null;

    public HwFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f44593d = fragmentManager;
    }

    /* renamed from: a */
    private void m55772a(Parcelable[] parcelableArr) {
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable instanceof Fragment.SavedState) {
                this.f44595f.add((Fragment.SavedState) parcelable);
            }
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            if (this.f44594e == null) {
                this.f44594e = this.f44593d.m4585o();
            }
            while (this.f44595f.size() <= i10) {
                this.f44595f.add(null);
            }
            this.f44595f.set(i10, fragment.m4379X() ? this.f44593d.m4578l1(fragment) : null);
            this.f44596g.set(i10, null);
            this.f44594e.mo4655q(fragment);
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        AbstractC0735a0 abstractC0735a0 = this.f44594e;
        if (abstractC0735a0 != null) {
            abstractC0735a0.mo4650k();
            this.f44594e = null;
        }
    }

    public abstract Fragment getItem(int i10);

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f44596g.size() > i10 && (fragment = this.f44596g.get(i10)) != null) {
            return fragment;
        }
        if (this.f44594e == null) {
            this.f44594e = this.f44593d.m4585o();
        }
        Fragment item = getItem(i10);
        if (this.f44595f.size() > i10 && (savedState = this.f44595f.get(i10)) != null) {
            item.m4443u1(savedState);
        }
        while (this.f44596g.size() <= i10) {
            this.f44596g.add(null);
        }
        item.m4446v1(false);
        item.m4335A1(false);
        this.f44596g.set(i10, item);
        this.f44594e.m4662b(viewGroup.getId(), item);
        return item;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof Fragment) && ((Fragment) obj).m4370S() == view;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) throws NumberFormatException {
        Parcelable[] parcelableArray;
        int i10;
        if (parcelable != null && (parcelable instanceof Bundle)) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Set<String> setKeySet = null;
            try {
                parcelableArray = bundle.getParcelableArray("states");
            } catch (BadParcelableException unused) {
                Log.e(f44590i, "restoreState: get fragmentSavedState failed");
                parcelableArray = null;
            }
            this.f44595f.clear();
            this.f44596g.clear();
            if (parcelableArray != null) {
                m55772a(parcelableArray);
            }
            try {
                setKeySet = bundle.keySet();
            } catch (BadParcelableException unused2) {
                Log.e(f44590i, "restoreState: get keys failed");
            }
            if (setKeySet == null) {
                return;
            }
            for (String str : setKeySet) {
                if (str.startsWith("f")) {
                    try {
                        i10 = Integer.parseInt(str.substring(1));
                    } catch (NumberFormatException unused3) {
                        Log.e(f44590i, "restoreState: get Index failed");
                        i10 = -1;
                    }
                    if (i10 != -1) {
                        m55771a(str, i10, this.f44593d.m4595r0(bundle, str));
                    }
                }
            }
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f44595f.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f44595f.size()];
            this.f44595f.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i10 = 0; i10 < this.f44596g.size(); i10++) {
            Fragment fragment = this.f44596g.get(i10);
            if (fragment != null && fragment.m4379X()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f44593d.m4563e1(bundle, "f" + i10, fragment);
            }
        }
        return bundle;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment;
        Fragment fragment2;
        if (!(obj instanceof Fragment) || (fragment = (Fragment) obj) == (fragment2 = this.f44597h)) {
            return;
        }
        if (fragment2 != null) {
            fragment2.m4446v1(false);
            this.f44597h.m4335A1(false);
        }
        fragment.m4446v1(true);
        fragment.m4335A1(true);
        this.f44597h = fragment;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    /* renamed from: a */
    private void m55771a(String str, int i10, Fragment fragment) {
        if (fragment != null) {
            while (this.f44596g.size() <= i10) {
                this.f44596g.add(null);
            }
            fragment.m4446v1(false);
            this.f44596g.set(i10, fragment);
            return;
        }
        Log.w(f44590i, "Bad fragment at key " + str);
    }
}
