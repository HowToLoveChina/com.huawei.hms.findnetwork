package com.huawei.uikit.hwsubtab.widget;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.AbstractC0735a0;
import androidx.fragment.app.AbstractC0765w;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class HwSubTabFragmentPagerAdapter extends AbstractC0765w implements HwSubTabListener, ViewPager.InterfaceC0980i {

    /* renamed from: f */
    private static final String f44227f = "HwSubTabFragmentPagerAdapter";

    /* renamed from: g */
    private static final int f44228g = 2;

    /* renamed from: a */
    private final HwSubTabWidget f44229a;

    /* renamed from: b */
    private final ViewPager f44230b;

    /* renamed from: c */
    private boolean f44231c;

    /* renamed from: d */
    private final ArrayList<bzrwd> f44232d;

    /* renamed from: e */
    private int f44233e;

    public static final class bzrwd {

        /* renamed from: a */
        private final Bundle f44234a;

        /* renamed from: b */
        private Fragment f44235b;

        public bzrwd(Fragment fragment, Bundle bundle) {
            this.f44235b = fragment;
            this.f44234a = bundle;
        }

        /* renamed from: a */
        public Bundle m55549a() {
            return this.f44234a;
        }

        /* renamed from: a */
        public void m55550a(Fragment fragment) {
            this.f44235b = fragment;
        }
    }

    public HwSubTabFragmentPagerAdapter(FragmentActivity fragmentActivity, ViewPager viewPager, HwSubTabWidget hwSubTabWidget) throws Resources.NotFoundException {
        super(fragmentActivity.m4473U());
        this.f44231c = true;
        this.f44232d = new ArrayList<>(2);
        this.f44233e = 0;
        this.f44229a = hwSubTabWidget;
        this.f44230b = viewPager;
        viewPager.setAdapter(this);
        viewPager.addOnPageChangeListener(this);
    }

    /* renamed from: a */
    private void m55547a(HwSubTab hwSubTab) throws Resources.NotFoundException {
        Object tag = hwSubTab.getTag();
        if (tag instanceof bzrwd) {
            bzrwd bzrwdVar = (bzrwd) tag;
            int size = this.f44232d.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f44232d.get(i10) == bzrwdVar) {
                    notifyDataSetChanged();
                    this.f44230b.setCurrentItem(i10);
                    return;
                }
            }
        }
    }

    public void addSubTab(HwSubTab hwSubTab, Fragment fragment, Bundle bundle, boolean z10) {
        if (hwSubTab == null || fragment == null) {
            Log.w(f44227f, "Parameter subTab and fragment of method add SubTab should not be null.");
            return;
        }
        if (!fragment.m4379X() && !fragment.m4381Y()) {
            fragment.m4437s1(bundle);
        }
        bzrwd bzrwdVar = new bzrwd(fragment, bundle);
        hwSubTab.setTag(bzrwdVar);
        if (hwSubTab.getCallback() == null) {
            hwSubTab.setSubTabListener(this);
        }
        this.f44232d.add(bzrwdVar);
        this.f44229a.addSubTab(hwSubTab, z10);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public int getCount() {
        return this.f44232d.size();
    }

    @Override // androidx.fragment.app.AbstractC0765w
    public Fragment getItem(int i10) {
        int size = this.f44232d.size();
        if (i10 < 0 || i10 >= size) {
            return null;
        }
        return this.f44232d.get(i10).f44235b;
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageScrollStateChanged(int i10) {
        if (i10 == 0) {
            this.f44229a.setIsViewPagerScroll(false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageScrolled(int i10, float f10, int i11) {
        if (this.f44231c) {
            this.f44229a.setIsViewPagerScroll(true);
            this.f44229a.setSubTabScrollingOffsets(i10, f10);
        }
        if (Float.compare(f10, 0.0f) == 0 && this.f44233e == this.f44230b.getCurrentItem()) {
            this.f44231c = true;
            this.f44229a.setIsViewPagerScroll(false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
    public void onPageSelected(int i10) throws Resources.NotFoundException {
        this.f44229a.setSubTabSelected(i10);
    }

    @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabListener
    public void onSubTabReselected(HwSubTab hwSubTab, AbstractC0735a0 abstractC0735a0) {
    }

    @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabListener
    public void onSubTabSelected(HwSubTab hwSubTab, AbstractC0735a0 abstractC0735a0) throws Resources.NotFoundException {
        if (this.f44229a.getSubTabAppearance() == 1) {
            this.f44231c = false;
            this.f44233e = hwSubTab.getPosition();
        }
        m55547a(hwSubTab);
    }

    @Override // com.huawei.uikit.hwsubtab.widget.HwSubTabListener
    public void onSubTabUnselected(HwSubTab hwSubTab, AbstractC0735a0 abstractC0735a0) {
    }

    public void removeAllSubTabs() {
        this.f44232d.clear();
        this.f44229a.removeAllSubTabs();
        notifyDataSetChanged();
    }

    public void setItem(Fragment fragment, int i10) {
        int size = this.f44232d.size();
        if (i10 < 0 || i10 >= size) {
            return;
        }
        this.f44232d.get(i10).m55550a(fragment);
        notifyDataSetChanged();
    }

    public HwSubTabFragmentPagerAdapter(FragmentManager fragmentManager, ViewPager viewPager, HwSubTabWidget hwSubTabWidget) throws Resources.NotFoundException {
        super(fragmentManager);
        this.f44231c = true;
        this.f44232d = new ArrayList<>(2);
        this.f44233e = 0;
        this.f44229a = hwSubTabWidget;
        this.f44230b = viewPager;
        viewPager.setAdapter(this);
        viewPager.addOnPageChangeListener(this);
    }

    public void addSubTab(HwSubTab hwSubTab, int i10, Fragment fragment, Bundle bundle, boolean z10) throws Resources.NotFoundException {
        if (hwSubTab != null && fragment != null) {
            if (!fragment.m4379X() && !fragment.m4381Y()) {
                fragment.m4437s1(bundle);
            }
            bzrwd bzrwdVar = new bzrwd(fragment, bundle);
            hwSubTab.setTag(bzrwdVar);
            if (hwSubTab.getCallback() == null) {
                hwSubTab.setSubTabListener(this);
            }
            this.f44232d.add(i10, bzrwdVar);
            this.f44229a.addSubTab(hwSubTab, i10, z10);
            notifyDataSetChanged();
            if (z10 || this.f44229a.getSelectedSubTab() == null) {
                return;
            }
            m55547a(this.f44229a.getSelectedSubTab());
            return;
        }
        Log.w(f44227f, "Parameter subTab and fragment of method add SubTab should not be null.");
    }
}
