package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a */
    public final ArrayList<C0733a> f3873a;

    /* renamed from: b */
    public Context f3874b;

    /* renamed from: c */
    public FragmentManager f3875c;

    /* renamed from: d */
    public int f3876d;

    /* renamed from: e */
    public TabHost.OnTabChangeListener f3877e;

    /* renamed from: f */
    public C0733a f3878f;

    /* renamed from: g */
    public boolean f3879g;

    public static class DummyTabFactory implements TabHost.TabContentFactory {

        /* renamed from: a */
        public final Context f3880a;

        public DummyTabFactory(Context context) {
            this.f3880a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.f3880a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0732a();

        /* renamed from: a */
        public String f3881a;

        /* renamed from: androidx.fragment.app.FragmentTabHost$SavedState$a */
        public class C0732a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f3881a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f3881a);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f3881a = parcel.readString();
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTabHost$a */
    public static final class C0733a {

        /* renamed from: a */
        public final String f3882a;

        /* renamed from: b */
        public final Class<?> f3883b;

        /* renamed from: c */
        public final Bundle f3884c;

        /* renamed from: d */
        public Fragment f3885d;
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, null);
        this.f3873a = new ArrayList<>();
        m4638c(context, null);
    }

    /* renamed from: a */
    public final AbstractC0735a0 m4636a(String str, AbstractC0735a0 abstractC0735a0) {
        Fragment fragment;
        C0733a c0733aM4637b = m4637b(str);
        if (this.f3878f != c0733aM4637b) {
            if (abstractC0735a0 == null) {
                abstractC0735a0 = this.f3875c.m4585o();
            }
            C0733a c0733a = this.f3878f;
            if (c0733a != null && (fragment = c0733a.f3885d) != null) {
                abstractC0735a0.mo4651l(fragment);
            }
            if (c0733aM4637b != null) {
                Fragment fragment2 = c0733aM4637b.f3885d;
                if (fragment2 == null) {
                    Fragment fragmentMo4623a = this.f3875c.m4601t0().mo4623a(this.f3874b.getClassLoader(), c0733aM4637b.f3883b.getName());
                    c0733aM4637b.f3885d = fragmentMo4623a;
                    fragmentMo4623a.m4437s1(c0733aM4637b.f3884c);
                    abstractC0735a0.m4663c(this.f3876d, c0733aM4637b.f3885d, c0733aM4637b.f3882a);
                } else {
                    abstractC0735a0.m4667g(fragment2);
                }
            }
            this.f3878f = c0733aM4637b;
        }
        return abstractC0735a0;
    }

    /* renamed from: b */
    public final C0733a m4637b(String str) {
        int size = this.f3873a.size();
        for (int i10 = 0; i10 < size; i10++) {
            C0733a c0733a = this.f3873a.get(i10);
            if (c0733a.f3882a.equals(str)) {
                return c0733a;
            }
        }
        return null;
    }

    /* renamed from: c */
    public final void m4638c(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f3876d = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f3873a.size();
        AbstractC0735a0 abstractC0735a0M4585o = null;
        for (int i10 = 0; i10 < size; i10++) {
            C0733a c0733a = this.f3873a.get(i10);
            Fragment fragmentM4571i0 = this.f3875c.m4571i0(c0733a.f3882a);
            c0733a.f3885d = fragmentM4571i0;
            if (fragmentM4571i0 != null && !fragmentM4571i0.m4381Y()) {
                if (c0733a.f3882a.equals(currentTabTag)) {
                    this.f3878f = c0733a;
                } else {
                    if (abstractC0735a0M4585o == null) {
                        abstractC0735a0M4585o = this.f3875c.m4585o();
                    }
                    abstractC0735a0M4585o.mo4651l(c0733a.f3885d);
                }
            }
        }
        this.f3879g = true;
        AbstractC0735a0 abstractC0735a0M4636a = m4636a(currentTabTag, abstractC0735a0M4585o);
        if (abstractC0735a0M4636a != null) {
            abstractC0735a0M4636a.mo4647h();
            this.f3875c.m4562e0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3879g = false;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f3881a);
    }

    @Override // android.view.View
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3881a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        AbstractC0735a0 abstractC0735a0M4636a;
        if (this.f3879g && (abstractC0735a0M4636a = m4636a(str, null)) != null) {
            abstractC0735a0M4636a.mo4647h();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f3877e;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f3877e = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3873a = new ArrayList<>();
        m4638c(context, attributeSet);
    }
}
