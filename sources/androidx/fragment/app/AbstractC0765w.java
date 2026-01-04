package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0791h;
import androidx.viewpager.widget.AbstractC0984a;

@Deprecated
/* renamed from: androidx.fragment.app.w */
/* loaded from: classes.dex */
public abstract class AbstractC0765w extends AbstractC0984a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private AbstractC0735a0 mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;

    @Deprecated
    public AbstractC0765w(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    private static String makeFragmentName(int i10, long j10) {
        return "android:switcher:" + i10 + ":" + j10;
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.m4585o();
        }
        this.mCurTransaction.mo4651l(fragment);
        if (fragment.equals(this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = null;
        }
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public void finishUpdate(ViewGroup viewGroup) {
        AbstractC0735a0 abstractC0735a0 = this.mCurTransaction;
        if (abstractC0735a0 != null) {
            if (!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    abstractC0735a0.mo4650k();
                } finally {
                    this.mExecutingFinishUpdate = false;
                }
            }
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int i10);

    public long getItemId(int i10) {
        return i10;
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.m4585o();
        }
        long itemId = getItemId(i10);
        Fragment fragmentM4571i0 = this.mFragmentManager.m4571i0(makeFragmentName(viewGroup.getId(), itemId));
        if (fragmentM4571i0 != null) {
            this.mCurTransaction.m4667g(fragmentM4571i0);
        } else {
            fragmentM4571i0 = getItem(i10);
            this.mCurTransaction.m4663c(viewGroup.getId(), fragmentM4571i0, makeFragmentName(viewGroup.getId(), itemId));
        }
        if (fragmentM4571i0 != this.mCurrentPrimaryItem) {
            fragmentM4571i0.m4446v1(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.mo4656t(fragmentM4571i0, AbstractC0791h.c.STARTED);
            } else {
                fragmentM4571i0.m4335A1(false);
            }
        }
        return fragmentM4571i0;
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).m4370S() == view;
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.m4446v1(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        this.mCurTransaction = this.mFragmentManager.m4585o();
                    }
                    this.mCurTransaction.mo4656t(this.mCurrentPrimaryItem, AbstractC0791h.c.STARTED);
                } else {
                    this.mCurrentPrimaryItem.m4335A1(false);
                }
            }
            fragment.m4446v1(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.m4585o();
                }
                this.mCurTransaction.mo4656t(fragment, AbstractC0791h.c.RESUMED);
            } else {
                fragment.m4335A1(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // androidx.viewpager.widget.AbstractC0984a
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public AbstractC0765w(FragmentManager fragmentManager, int i10) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = fragmentManager;
        this.mBehavior = i10;
    }
}
