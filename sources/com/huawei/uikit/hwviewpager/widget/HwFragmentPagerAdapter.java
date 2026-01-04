package com.huawei.uikit.hwviewpager.widget;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractC0735a0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* loaded from: classes9.dex */
public abstract class HwFragmentPagerAdapter extends HwPagerAdapter {

    /* renamed from: g */
    private static final String f44585g = "HwFragmentPagerAdapter";

    /* renamed from: h */
    private static final boolean f44586h = false;

    /* renamed from: d */
    private final FragmentManager f44587d;

    /* renamed from: e */
    private AbstractC0735a0 f44588e = null;

    /* renamed from: f */
    private Fragment f44589f = null;

    public HwFragmentPagerAdapter(FragmentManager fragmentManager) {
        this.f44587d = fragmentManager;
    }

    /* renamed from: a */
    private static String m55770a(int i10, long j10) {
        return "android:switcher:" + i10 + ":" + j10;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            if (this.f44588e == null) {
                this.f44588e = this.f44587d.m4585o();
            }
            this.f44588e.mo4651l(fragment);
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        AbstractC0735a0 abstractC0735a0 = this.f44588e;
        if (abstractC0735a0 != null) {
            abstractC0735a0.mo4650k();
            this.f44588e = null;
        }
    }

    public abstract Fragment getItem(int i10);

    public long getItemId(int i10) {
        return i10;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        if (this.f44588e == null) {
            this.f44588e = this.f44587d.m4585o();
        }
        long itemId = getItemId(i10);
        Fragment fragmentM4571i0 = this.f44587d.m4571i0(m55770a(viewGroup.getId(), itemId));
        if (fragmentM4571i0 != null) {
            this.f44588e.m4667g(fragmentM4571i0);
        } else {
            fragmentM4571i0 = getItem(i10);
            this.f44588e.m4663c(viewGroup.getId(), fragmentM4571i0, m55770a(viewGroup.getId(), itemId));
        }
        if (fragmentM4571i0 != this.f44589f) {
            fragmentM4571i0.m4446v1(false);
            fragmentM4571i0.m4335A1(false);
        }
        return fragmentM4571i0;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof Fragment) && ((Fragment) obj).m4370S() == view;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f44589f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.m4446v1(false);
                this.f44589f.m4335A1(false);
            }
            fragment.m4446v1(true);
            fragment.m4335A1(true);
            this.f44589f = fragment;
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}
