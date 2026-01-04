package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.InterfaceC0414k;
import androidx.appcompat.view.menu.InterfaceC0415l;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.e */
/* loaded from: classes.dex */
public class C0408e implements InterfaceC0414k, AdapterView.OnItemClickListener {

    /* renamed from: a */
    public Context f1635a;

    /* renamed from: b */
    public LayoutInflater f1636b;

    /* renamed from: c */
    public MenuBuilder f1637c;

    /* renamed from: d */
    public ExpandedMenuView f1638d;

    /* renamed from: e */
    public int f1639e;

    /* renamed from: f */
    public int f1640f;

    /* renamed from: g */
    public int f1641g;

    /* renamed from: h */
    public InterfaceC0414k.a f1642h;

    /* renamed from: i */
    public a f1643i;

    /* renamed from: j */
    public int f1644j;

    /* renamed from: androidx.appcompat.view.menu.e$a */
    public class a extends BaseAdapter {

        /* renamed from: a */
        public int f1645a = -1;

        public a() {
            m2460a();
        }

        /* renamed from: a */
        public void m2460a() {
            C0411h c0411hM2392x = C0408e.this.f1637c.m2392x();
            if (c0411hM2392x != null) {
                ArrayList<C0411h> arrayListM2338B = C0408e.this.f1637c.m2338B();
                int size = arrayListM2338B.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (arrayListM2338B.get(i10) == c0411hM2392x) {
                        this.f1645a = i10;
                        return;
                    }
                }
            }
            this.f1645a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b */
        public C0411h getItem(int i10) {
            ArrayList<C0411h> arrayListM2338B = C0408e.this.f1637c.m2338B();
            int i11 = i10 + C0408e.this.f1639e;
            int i12 = this.f1645a;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return arrayListM2338B.get(i11);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = C0408e.this.f1637c.m2338B().size() - C0408e.this.f1639e;
            return this.f1645a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                C0408e c0408e = C0408e.this;
                view = c0408e.f1636b.inflate(c0408e.f1641g, viewGroup, false);
            }
            ((InterfaceC0415l.a) view).mo2320e(getItem(i10), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            m2460a();
            super.notifyDataSetChanged();
        }
    }

    public C0408e(Context context, int i10) {
        this(i10, 0);
        this.f1635a = context;
        this.f1636b = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: a */
    public void mo2413a(MenuBuilder menuBuilder, boolean z10) {
        InterfaceC0414k.a aVar = this.f1642h;
        if (aVar != null) {
            aVar.mo2158a(menuBuilder, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: b */
    public void mo2414b(boolean z10) {
        a aVar = this.f1643i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
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
    /* renamed from: f */
    public void mo2417f(InterfaceC0414k.a aVar) {
        this.f1642h = aVar;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: g */
    public void mo2418g(Context context, MenuBuilder menuBuilder) {
        if (this.f1640f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f1640f);
            this.f1635a = contextThemeWrapper;
            this.f1636b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f1635a != null) {
            this.f1635a = context;
            if (this.f1636b == null) {
                this.f1636b = LayoutInflater.from(context);
            }
        }
        this.f1637c = menuBuilder;
        a aVar = this.f1643i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    public int getId() {
        return this.f1644j;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: h */
    public void mo2440h(Parcelable parcelable) {
        m2458m((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: i */
    public boolean mo2419i(SubMenuC0419p subMenuC0419p) {
        if (!subMenuC0419p.hasVisibleItems()) {
            return false;
        }
        new DialogInterfaceOnKeyListenerC0410g(subMenuC0419p).m2467d(null);
        InterfaceC0414k.a aVar = this.f1642h;
        if (aVar == null) {
            return true;
        }
        aVar.mo2159b(subMenuC0419p);
        return true;
    }

    /* renamed from: j */
    public ListAdapter m2456j() {
        if (this.f1643i == null) {
            this.f1643i = new a();
        }
        return this.f1643i;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: k */
    public Parcelable mo2442k() {
        if (this.f1638d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        m2459n(bundle);
        return bundle;
    }

    /* renamed from: l */
    public InterfaceC0415l m2457l(ViewGroup viewGroup) {
        if (this.f1638d == null) {
            this.f1638d = (ExpandedMenuView) this.f1636b.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1643i == null) {
                this.f1643i = new a();
            }
            this.f1638d.setAdapter((ListAdapter) this.f1643i);
            this.f1638d.setOnItemClickListener(this);
        }
        return this.f1638d;
    }

    /* renamed from: m */
    public void m2458m(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1638d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    /* renamed from: n */
    public void m2459n(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f1638d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f1637c.m2350O(this.f1643i.getItem(i10), this, 0);
    }

    public C0408e(int i10, int i11) {
        this.f1641g = i10;
        this.f1640f = i11;
    }
}
