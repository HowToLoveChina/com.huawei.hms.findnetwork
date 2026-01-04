package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.InterfaceC0414k;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.SubMenuC0419p;
import com.google.android.material.badge.C1653b;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: classes.dex */
public class NavigationBarPresenter implements InterfaceC0414k {

    /* renamed from: a */
    public MenuBuilder f8486a;

    /* renamed from: b */
    public NavigationBarMenuView f8487b;

    /* renamed from: c */
    public boolean f8488c = false;

    /* renamed from: d */
    public int f8489d;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1795a();

        /* renamed from: a */
        public int f8490a;

        /* renamed from: b */
        public ParcelableSparseArray f8491b;

        /* renamed from: com.google.android.material.navigation.NavigationBarPresenter$SavedState$a */
        public class C1795a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f8490a);
            parcel.writeParcelable(this.f8491b, 0);
        }

        public SavedState(Parcel parcel) {
            this.f8490a = parcel.readInt();
            this.f8491b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: a */
    public void mo2413a(MenuBuilder menuBuilder, boolean z10) {
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: b */
    public void mo2414b(boolean z10) {
        if (this.f8488c) {
            return;
        }
        if (z10) {
            this.f8487b.m10821d();
        } else {
            this.f8487b.m10829m();
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: c */
    public boolean mo2439c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: d */
    public boolean mo2415d(MenuBuilder menuBuilder, C0411h c0411h) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: e */
    public boolean mo2416e(MenuBuilder menuBuilder, C0411h c0411h) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: g */
    public void mo2418g(Context context, MenuBuilder menuBuilder) {
        this.f8486a = menuBuilder;
        this.f8487b.mo2328b(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    public int getId() {
        return this.f8489d;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: h */
    public void mo2440h(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f8487b.m10828l(savedState.f8490a);
            this.f8487b.m10827k(C1653b.m9700b(this.f8487b.getContext(), savedState.f8491b));
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: i */
    public boolean mo2419i(SubMenuC0419p subMenuC0419p) {
        return false;
    }

    /* renamed from: j */
    public void m10830j(int i10) {
        this.f8489d = i10;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: k */
    public Parcelable mo2442k() {
        SavedState savedState = new SavedState();
        savedState.f8490a = this.f8487b.getSelectedItemId();
        savedState.f8491b = C1653b.m9701c(this.f8487b.getBadgeDrawables());
        return savedState;
    }

    /* renamed from: l */
    public void m10831l(NavigationBarMenuView navigationBarMenuView) {
        this.f8487b = navigationBarMenuView;
    }

    /* renamed from: m */
    public void m10832m(boolean z10) {
        this.f8488c = z10;
    }
}
