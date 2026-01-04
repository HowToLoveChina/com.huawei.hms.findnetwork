package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AbstractC0791h;
import androidx.viewpager.widget.AbstractC0984a;
import java.util.ArrayList;

@Deprecated
/* renamed from: androidx.fragment.app.y */
/* loaded from: classes.dex */
public abstract class AbstractC0767y extends AbstractC0984a {

    /* renamed from: h */
    public final FragmentManager f4091h;

    /* renamed from: i */
    public final int f4092i;

    /* renamed from: j */
    public AbstractC0735a0 f4093j;

    /* renamed from: k */
    public ArrayList<Fragment.SavedState> f4094k;

    /* renamed from: l */
    public ArrayList<Fragment> f4095l;

    /* renamed from: m */
    public Fragment f4096m;

    /* renamed from: n */
    public boolean f4097n;

    @Deprecated
    public AbstractC0767y(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f4093j == null) {
            this.f4093j = this.f4091h.m4585o();
        }
        while (this.f4094k.size() <= i10) {
            this.f4094k.add(null);
        }
        this.f4094k.set(i10, fragment.m4379X() ? this.f4091h.m4578l1(fragment) : null);
        this.f4095l.set(i10, null);
        this.f4093j.mo4655q(fragment);
        if (fragment.equals(this.f4096m)) {
            this.f4096m = null;
        }
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public void finishUpdate(ViewGroup viewGroup) {
        AbstractC0735a0 abstractC0735a0 = this.f4093j;
        if (abstractC0735a0 != null) {
            if (!this.f4097n) {
                try {
                    this.f4097n = true;
                    abstractC0735a0.mo4650k();
                } finally {
                    this.f4097n = false;
                }
            }
            this.f4093j = null;
        }
    }

    public abstract Fragment getItem(int i10);

    @Override // androidx.viewpager.widget.AbstractC0984a
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f4095l.size() > i10 && (fragment = this.f4095l.get(i10)) != null) {
            return fragment;
        }
        if (this.f4093j == null) {
            this.f4093j = this.f4091h.m4585o();
        }
        Fragment item = getItem(i10);
        if (this.f4094k.size() > i10 && (savedState = this.f4094k.get(i10)) != null) {
            item.m4443u1(savedState);
        }
        while (this.f4095l.size() <= i10) {
            this.f4095l.add(null);
        }
        item.m4446v1(false);
        if (this.f4092i == 0) {
            item.m4335A1(false);
        }
        this.f4095l.set(i10, item);
        this.f4093j.m4662b(viewGroup.getId(), item);
        if (this.f4092i == 1) {
            this.f4093j.mo4656t(item, AbstractC0791h.c.STARTED);
        }
        return item;
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).m4370S() == view;
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) throws NumberFormatException {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f4094k.clear();
            this.f4095l.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f4094k.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i10 = Integer.parseInt(str.substring(1));
                    Fragment fragmentM4595r0 = this.f4091h.m4595r0(bundle, str);
                    if (fragmentM4595r0 != null) {
                        while (this.f4095l.size() <= i10) {
                            this.f4095l.add(null);
                        }
                        fragmentM4595r0.m4446v1(false);
                        this.f4095l.set(i10, fragmentM4595r0);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f4094k.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f4094k.size()];
            this.f4094k.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i10 = 0; i10 < this.f4095l.size(); i10++) {
            Fragment fragment = this.f4095l.get(i10);
            if (fragment != null && fragment.m4379X()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f4091h.m4563e1(bundle, "f" + i10, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f4096m;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.m4446v1(false);
                if (this.f4092i == 1) {
                    if (this.f4093j == null) {
                        this.f4093j = this.f4091h.m4585o();
                    }
                    this.f4093j.mo4656t(this.f4096m, AbstractC0791h.c.STARTED);
                } else {
                    this.f4096m.m4335A1(false);
                }
            }
            fragment.m4446v1(true);
            if (this.f4092i == 1) {
                if (this.f4093j == null) {
                    this.f4093j = this.f4091h.m4585o();
                }
                this.f4093j.mo4656t(fragment, AbstractC0791h.c.RESUMED);
            } else {
                fragment.m4335A1(true);
            }
            this.f4096m = fragment;
        }
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public AbstractC0767y(FragmentManager fragmentManager, int i10) {
        this.f4093j = null;
        this.f4094k = new ArrayList<>();
        this.f4095l = new ArrayList<>();
        this.f4096m = null;
        this.f4091h = fragmentManager;
        this.f4092i = i10;
    }
}
