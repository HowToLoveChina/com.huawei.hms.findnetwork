package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.InterfaceC0414k;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.SubMenuC0419p;
import androidx.core.widget.C0669j;
import androidx.recyclerview.widget.C0877p;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p304g0.C9832l;

/* renamed from: com.google.android.material.internal.h */
/* loaded from: classes.dex */
public class C1777h implements InterfaceC0414k {

    /* renamed from: A */
    public int f8335A;

    /* renamed from: a */
    public NavigationMenuView f8338a;

    /* renamed from: b */
    public LinearLayout f8339b;

    /* renamed from: c */
    public InterfaceC0414k.a f8340c;

    /* renamed from: d */
    public MenuBuilder f8341d;

    /* renamed from: e */
    public int f8342e;

    /* renamed from: f */
    public c f8343f;

    /* renamed from: g */
    public LayoutInflater f8344g;

    /* renamed from: i */
    public ColorStateList f8346i;

    /* renamed from: k */
    public ColorStateList f8348k;

    /* renamed from: l */
    public ColorStateList f8349l;

    /* renamed from: m */
    public Drawable f8350m;

    /* renamed from: n */
    public RippleDrawable f8351n;

    /* renamed from: o */
    public int f8352o;

    /* renamed from: p */
    public int f8353p;

    /* renamed from: q */
    public int f8354q;

    /* renamed from: r */
    public int f8355r;

    /* renamed from: s */
    public int f8356s;

    /* renamed from: t */
    public int f8357t;

    /* renamed from: u */
    public int f8358u;

    /* renamed from: v */
    public int f8359v;

    /* renamed from: w */
    public boolean f8360w;

    /* renamed from: y */
    public int f8362y;

    /* renamed from: z */
    public int f8363z;

    /* renamed from: h */
    public int f8345h = 0;

    /* renamed from: j */
    public int f8347j = 0;

    /* renamed from: x */
    public boolean f8361x = true;

    /* renamed from: B */
    public int f8336B = -1;

    /* renamed from: C */
    public final View.OnClickListener f8337C = new a();

    /* renamed from: com.google.android.material.internal.h$a */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z10 = true;
            C1777h.this.m10710V(true);
            C0411h itemData = ((NavigationMenuItemView) view).getItemData();
            C1777h c1777h = C1777h.this;
            boolean zM2350O = c1777h.f8341d.m2350O(itemData, c1777h, 0);
            if (itemData != null && itemData.isCheckable() && zM2350O) {
                C1777h.this.f8343f.m10736M(itemData);
            } else {
                z10 = false;
            }
            C1777h.this.m10710V(false);
            if (z10) {
                C1777h.this.mo2414b(false);
            }
        }
    }

    /* renamed from: com.google.android.material.internal.h$b */
    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    /* renamed from: com.google.android.material.internal.h$c */
    public class c extends RecyclerView.AbstractC0838h<l> {

        /* renamed from: d */
        public final ArrayList<e> f8365d = new ArrayList<>();

        /* renamed from: e */
        public C0411h f8366e;

        /* renamed from: f */
        public boolean f8367f;

        public c() {
            m10734K();
        }

        /* renamed from: D */
        public final void m10727D(int i10, int i11) {
            while (i10 < i11) {
                ((g) this.f8365d.get(i10)).f8372b = true;
                i10++;
            }
        }

        /* renamed from: E */
        public Bundle m10728E() {
            Bundle bundle = new Bundle();
            C0411h c0411h = this.f8366e;
            if (c0411h != null) {
                bundle.putInt("android:menu:checked", c0411h.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f8365d.size();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar = this.f8365d.get(i10);
                if (eVar instanceof g) {
                    C0411h c0411hM10741a = ((g) eVar).m10741a();
                    View actionView = c0411hM10741a != null ? c0411hM10741a.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(c0411hM10741a.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        /* renamed from: F */
        public C0411h m10729F() {
            return this.f8366e;
        }

        /* renamed from: G */
        public int m10730G() {
            int i10 = C1777h.this.f8339b.getChildCount() == 0 ? 0 : 1;
            for (int i11 = 0; i11 < C1777h.this.f8343f.mo721e(); i11++) {
                if (C1777h.this.f8343f.mo749g(i11) == 0) {
                    i10++;
                }
            }
            return i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public void mo723s(l lVar, int i10) throws Resources.NotFoundException {
            int iMo749g = mo749g(i10);
            if (iMo749g != 0) {
                if (iMo749g != 1) {
                    if (iMo749g != 2) {
                        return;
                    }
                    f fVar = (f) this.f8365d.get(i10);
                    lVar.f4327a.setPadding(C1777h.this.f8356s, fVar.m10740b(), C1777h.this.f8357t, fVar.m10739a());
                    return;
                }
                TextView textView = (TextView) lVar.f4327a;
                textView.setText(((g) this.f8365d.get(i10)).m10741a().getTitle());
                int i11 = C1777h.this.f8345h;
                if (i11 != 0) {
                    C0669j.m4080n(textView, i11);
                }
                textView.setPadding(C1777h.this.f8358u, textView.getPaddingTop(), C1777h.this.f8359v, textView.getPaddingBottom());
                ColorStateList colorStateList = C1777h.this.f8346i;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                    return;
                }
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.f4327a;
            navigationMenuItemView.setIconTintList(C1777h.this.f8349l);
            int i12 = C1777h.this.f8347j;
            if (i12 != 0) {
                navigationMenuItemView.setTextAppearance(i12);
            }
            ColorStateList colorStateList2 = C1777h.this.f8348k;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = C1777h.this.f8350m;
            C9603h0.m59910t0(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            RippleDrawable rippleDrawable = C1777h.this.f8351n;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            g gVar = (g) this.f8365d.get(i10);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f8372b);
            C1777h c1777h = C1777h.this;
            int i13 = c1777h.f8352o;
            int i14 = c1777h.f8353p;
            navigationMenuItemView.setPadding(i13, i14, i13, i14);
            navigationMenuItemView.setIconPadding(C1777h.this.f8354q);
            C1777h c1777h2 = C1777h.this;
            if (c1777h2.f8360w) {
                navigationMenuItemView.setIconSize(c1777h2.f8355r);
            }
            navigationMenuItemView.setMaxLines(C1777h.this.f8362y);
            navigationMenuItemView.mo2320e(gVar.m10741a(), 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public l mo724u(ViewGroup viewGroup, int i10) {
            if (i10 == 0) {
                C1777h c1777h = C1777h.this;
                return new i(c1777h.f8344g, viewGroup, c1777h.f8337C);
            }
            if (i10 == 1) {
                return new k(C1777h.this.f8344g, viewGroup);
            }
            if (i10 == 2) {
                return new j(C1777h.this.f8344g, viewGroup);
            }
            if (i10 != 3) {
                return null;
            }
            return new b(C1777h.this.f8339b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public void mo5227z(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.f4327a).m10556D();
            }
        }

        /* renamed from: K */
        public final void m10734K() {
            if (this.f8367f) {
                return;
            }
            boolean z10 = true;
            this.f8367f = true;
            this.f8365d.clear();
            this.f8365d.add(new d());
            int size = C1777h.this.f8341d.m2342G().size();
            int i10 = -1;
            int i11 = 0;
            boolean z11 = false;
            int size2 = 0;
            while (i11 < size) {
                C0411h c0411h = C1777h.this.f8341d.m2342G().get(i11);
                if (c0411h.isChecked()) {
                    m10736M(c0411h);
                }
                if (c0411h.isCheckable()) {
                    c0411h.m2487t(false);
                }
                if (c0411h.hasSubMenu()) {
                    SubMenu subMenu = c0411h.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i11 != 0) {
                            this.f8365d.add(new f(C1777h.this.f8335A, 0));
                        }
                        this.f8365d.add(new g(c0411h));
                        int size3 = this.f8365d.size();
                        int size4 = subMenu.size();
                        int i12 = 0;
                        boolean z12 = false;
                        while (i12 < size4) {
                            C0411h c0411h2 = (C0411h) subMenu.getItem(i12);
                            if (c0411h2.isVisible()) {
                                if (!z12 && c0411h2.getIcon() != null) {
                                    z12 = z10;
                                }
                                if (c0411h2.isCheckable()) {
                                    c0411h2.m2487t(false);
                                }
                                if (c0411h.isChecked()) {
                                    m10736M(c0411h);
                                }
                                this.f8365d.add(new g(c0411h2));
                            }
                            i12++;
                            z10 = true;
                        }
                        if (z12) {
                            m10727D(size3, this.f8365d.size());
                        }
                    }
                } else {
                    int groupId = c0411h.getGroupId();
                    if (groupId != i10) {
                        size2 = this.f8365d.size();
                        z11 = c0411h.getIcon() != null;
                        if (i11 != 0) {
                            size2++;
                            ArrayList<e> arrayList = this.f8365d;
                            int i13 = C1777h.this.f8335A;
                            arrayList.add(new f(i13, i13));
                        }
                    } else if (!z11 && c0411h.getIcon() != null) {
                        m10727D(size2, this.f8365d.size());
                        z11 = true;
                    }
                    g gVar = new g(c0411h);
                    gVar.f8372b = z11;
                    this.f8365d.add(gVar);
                    i10 = groupId;
                }
                i11++;
                z10 = true;
            }
            this.f8367f = false;
        }

        /* renamed from: L */
        public void m10735L(Bundle bundle) {
            C0411h c0411hM10741a;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            C0411h c0411hM10741a2;
            int i10 = bundle.getInt("android:menu:checked", 0);
            if (i10 != 0) {
                this.f8367f = true;
                int size = this.f8365d.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    e eVar = this.f8365d.get(i11);
                    if ((eVar instanceof g) && (c0411hM10741a2 = ((g) eVar).m10741a()) != null && c0411hM10741a2.getItemId() == i10) {
                        m10736M(c0411hM10741a2);
                        break;
                    }
                    i11++;
                }
                this.f8367f = false;
                m10734K();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f8365d.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    e eVar2 = this.f8365d.get(i12);
                    if ((eVar2 instanceof g) && (c0411hM10741a = ((g) eVar2).m10741a()) != null && (actionView = c0411hM10741a.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(c0411hM10741a.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        /* renamed from: M */
        public void m10736M(C0411h c0411h) {
            if (this.f8366e == c0411h || !c0411h.isCheckable()) {
                return;
            }
            C0411h c0411h2 = this.f8366e;
            if (c0411h2 != null) {
                c0411h2.setChecked(false);
            }
            this.f8366e = c0411h;
            c0411h.setChecked(true);
        }

        /* renamed from: N */
        public void m10737N(boolean z10) {
            this.f8367f = z10;
        }

        /* renamed from: O */
        public void m10738O() {
            m10734K();
            m5213j();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: e */
        public int mo721e() {
            return this.f8365d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: f */
        public long mo722f(int i10) {
            return i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
        /* renamed from: g */
        public int mo749g(int i10) {
            e eVar = this.f8365d.get(i10);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).m10741a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }
    }

    /* renamed from: com.google.android.material.internal.h$d */
    public static class d implements e {
    }

    /* renamed from: com.google.android.material.internal.h$e */
    public interface e {
    }

    /* renamed from: com.google.android.material.internal.h$f */
    public static class f implements e {

        /* renamed from: a */
        public final int f8369a;

        /* renamed from: b */
        public final int f8370b;

        public f(int i10, int i11) {
            this.f8369a = i10;
            this.f8370b = i11;
        }

        /* renamed from: a */
        public int m10739a() {
            return this.f8370b;
        }

        /* renamed from: b */
        public int m10740b() {
            return this.f8369a;
        }
    }

    /* renamed from: com.google.android.material.internal.h$g */
    public static class g implements e {

        /* renamed from: a */
        public final C0411h f8371a;

        /* renamed from: b */
        public boolean f8372b;

        public g(C0411h c0411h) {
            this.f8371a = c0411h;
        }

        /* renamed from: a */
        public C0411h m10741a() {
            return this.f8371a;
        }
    }

    /* renamed from: com.google.android.material.internal.h$h */
    public class h extends C0877p {
        public h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.C0877p, p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            c9832l.m61067W(C9832l.b.m61125a(C1777h.this.f8343f.m10730G(), 0, false));
        }
    }

    /* renamed from: com.google.android.material.internal.h$i */
    public static class i extends l {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.f4327a.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: com.google.android.material.internal.h$j */
    public static class j extends l {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* renamed from: com.google.android.material.internal.h$k */
    public static class k extends l {
        public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* renamed from: com.google.android.material.internal.h$l */
    public static abstract class l extends RecyclerView.AbstractC0833c0 {
        public l(View view) {
            super(view);
        }
    }

    /* renamed from: A */
    public int m10689A() {
        return this.f8358u;
    }

    /* renamed from: B */
    public View m10690B(int i10) {
        View viewInflate = this.f8344g.inflate(i10, (ViewGroup) this.f8339b, false);
        m10712l(viewInflate);
        return viewInflate;
    }

    /* renamed from: C */
    public void m10691C(boolean z10) {
        if (this.f8361x != z10) {
            this.f8361x = z10;
            m10711W();
        }
    }

    /* renamed from: D */
    public void m10692D(C0411h c0411h) {
        this.f8343f.m10736M(c0411h);
    }

    /* renamed from: E */
    public void m10693E(int i10) {
        this.f8357t = i10;
        mo2414b(false);
    }

    /* renamed from: F */
    public void m10694F(int i10) {
        this.f8356s = i10;
        mo2414b(false);
    }

    /* renamed from: G */
    public void m10695G(int i10) {
        this.f8342e = i10;
    }

    /* renamed from: H */
    public void m10696H(Drawable drawable) {
        this.f8350m = drawable;
        mo2414b(false);
    }

    /* renamed from: I */
    public void m10697I(RippleDrawable rippleDrawable) {
        this.f8351n = rippleDrawable;
        mo2414b(false);
    }

    /* renamed from: J */
    public void m10698J(int i10) {
        this.f8352o = i10;
        mo2414b(false);
    }

    /* renamed from: K */
    public void m10699K(int i10) {
        this.f8354q = i10;
        mo2414b(false);
    }

    /* renamed from: L */
    public void m10700L(int i10) {
        if (this.f8355r != i10) {
            this.f8355r = i10;
            this.f8360w = true;
            mo2414b(false);
        }
    }

    /* renamed from: M */
    public void m10701M(ColorStateList colorStateList) {
        this.f8349l = colorStateList;
        mo2414b(false);
    }

    /* renamed from: N */
    public void m10702N(int i10) {
        this.f8362y = i10;
        mo2414b(false);
    }

    /* renamed from: O */
    public void m10703O(int i10) {
        this.f8347j = i10;
        mo2414b(false);
    }

    /* renamed from: P */
    public void m10704P(ColorStateList colorStateList) {
        this.f8348k = colorStateList;
        mo2414b(false);
    }

    /* renamed from: Q */
    public void m10705Q(int i10) {
        this.f8353p = i10;
        mo2414b(false);
    }

    /* renamed from: R */
    public void m10706R(int i10) {
        this.f8336B = i10;
        NavigationMenuView navigationMenuView = this.f8338a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i10);
        }
    }

    /* renamed from: S */
    public void m10707S(ColorStateList colorStateList) {
        this.f8346i = colorStateList;
        mo2414b(false);
    }

    /* renamed from: T */
    public void m10708T(int i10) {
        this.f8358u = i10;
        mo2414b(false);
    }

    /* renamed from: U */
    public void m10709U(int i10) {
        this.f8345h = i10;
        mo2414b(false);
    }

    /* renamed from: V */
    public void m10710V(boolean z10) {
        c cVar = this.f8343f;
        if (cVar != null) {
            cVar.m10737N(z10);
        }
    }

    /* renamed from: W */
    public final void m10711W() {
        int i10 = (this.f8339b.getChildCount() == 0 && this.f8361x) ? this.f8363z : 0;
        NavigationMenuView navigationMenuView = this.f8338a;
        navigationMenuView.setPadding(0, i10, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: a */
    public void mo2413a(MenuBuilder menuBuilder, boolean z10) {
        InterfaceC0414k.a aVar = this.f8340c;
        if (aVar != null) {
            aVar.mo2158a(menuBuilder, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: b */
    public void mo2414b(boolean z10) {
        c cVar = this.f8343f;
        if (cVar != null) {
            cVar.m10738O();
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
        this.f8344g = LayoutInflater.from(context);
        this.f8341d = menuBuilder;
        this.f8335A = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    public int getId() {
        return this.f8342e;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: h */
    public void mo2440h(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f8338a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f8343f.m10735L(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f8339b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: i */
    public boolean mo2419i(SubMenuC0419p subMenuC0419p) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: k */
    public Parcelable mo2442k() {
        Bundle bundle = new Bundle();
        if (this.f8338a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f8338a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f8343f;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.m10728E());
        }
        if (this.f8339b != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.f8339b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    /* renamed from: l */
    public void m10712l(View view) {
        this.f8339b.addView(view);
        NavigationMenuView navigationMenuView = this.f8338a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    /* renamed from: m */
    public void m10713m(C9625s0 c9625s0) {
        int iM60160l = c9625s0.m60160l();
        if (this.f8363z != iM60160l) {
            this.f8363z = iM60160l;
            m10711W();
        }
        NavigationMenuView navigationMenuView = this.f8338a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, c9625s0.m60157i());
        C9603h0.m59885h(this.f8339b, c9625s0);
    }

    /* renamed from: n */
    public C0411h m10714n() {
        return this.f8343f.m10729F();
    }

    /* renamed from: o */
    public int m10715o() {
        return this.f8357t;
    }

    /* renamed from: p */
    public int m10716p() {
        return this.f8356s;
    }

    /* renamed from: q */
    public int m10717q() {
        return this.f8339b.getChildCount();
    }

    /* renamed from: r */
    public Drawable m10718r() {
        return this.f8350m;
    }

    /* renamed from: s */
    public int m10719s() {
        return this.f8352o;
    }

    /* renamed from: t */
    public int m10720t() {
        return this.f8354q;
    }

    /* renamed from: u */
    public int m10721u() {
        return this.f8362y;
    }

    /* renamed from: v */
    public ColorStateList m10722v() {
        return this.f8348k;
    }

    /* renamed from: w */
    public ColorStateList m10723w() {
        return this.f8349l;
    }

    /* renamed from: x */
    public int m10724x() {
        return this.f8353p;
    }

    /* renamed from: y */
    public InterfaceC0415l m10725y(ViewGroup viewGroup) {
        if (this.f8338a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f8344g.inflate(R$layout.design_navigation_menu, viewGroup, false);
            this.f8338a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f8338a));
            if (this.f8343f == null) {
                this.f8343f = new c();
            }
            int i10 = this.f8336B;
            if (i10 != -1) {
                this.f8338a.setOverScrollMode(i10);
            }
            this.f8339b = (LinearLayout) this.f8344g.inflate(R$layout.design_navigation_item_header, (ViewGroup) this.f8338a, false);
            this.f8338a.setAdapter(this.f8343f);
        }
        return this.f8338a;
    }

    /* renamed from: z */
    public int m10726z() {
        return this.f8359v;
    }
}
