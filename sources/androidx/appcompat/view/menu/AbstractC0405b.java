package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.InterfaceC0414k;
import androidx.appcompat.view.menu.InterfaceC0415l;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.b */
/* loaded from: classes.dex */
public abstract class AbstractC0405b implements InterfaceC0414k {

    /* renamed from: a */
    public Context f1585a;

    /* renamed from: b */
    public Context f1586b;

    /* renamed from: c */
    public MenuBuilder f1587c;

    /* renamed from: d */
    public LayoutInflater f1588d;

    /* renamed from: e */
    public LayoutInflater f1589e;

    /* renamed from: f */
    public InterfaceC0414k.a f1590f;

    /* renamed from: g */
    public int f1591g;

    /* renamed from: h */
    public int f1592h;

    /* renamed from: i */
    public InterfaceC0415l f1593i;

    /* renamed from: j */
    public int f1594j;

    public AbstractC0405b(Context context, int i10, int i11) {
        this.f1585a = context;
        this.f1588d = LayoutInflater.from(context);
        this.f1591g = i10;
        this.f1592h = i11;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: a */
    public void mo2413a(MenuBuilder menuBuilder, boolean z10) {
        InterfaceC0414k.a aVar = this.f1590f;
        if (aVar != null) {
            aVar.mo2158a(menuBuilder, z10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: b */
    public void mo2414b(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f1593i;
        if (viewGroup == null) {
            return;
        }
        MenuBuilder menuBuilder = this.f1587c;
        int i10 = 0;
        if (menuBuilder != null) {
            menuBuilder.m2388t();
            ArrayList<C0411h> arrayListM2342G = this.f1587c.m2342G();
            int size = arrayListM2342G.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                C0411h c0411h = arrayListM2342G.get(i12);
                if (mo2428t(i11, c0411h)) {
                    View childAt = viewGroup.getChildAt(i11);
                    C0411h itemData = childAt instanceof InterfaceC0415l.a ? ((InterfaceC0415l.a) childAt).getItemData() : null;
                    View viewMo2425q = mo2425q(c0411h, childAt, viewGroup);
                    if (c0411h != itemData) {
                        viewMo2425q.setPressed(false);
                        viewMo2425q.jumpDrawablesToCurrentState();
                    }
                    if (viewMo2425q != childAt) {
                        m2420l(viewMo2425q, i11);
                    }
                    i11++;
                }
            }
            i10 = i11;
        }
        while (i10 < viewGroup.getChildCount()) {
            if (!mo2423o(viewGroup, i10)) {
                i10++;
            }
        }
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
        this.f1590f = aVar;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: g */
    public void mo2418g(Context context, MenuBuilder menuBuilder) {
        this.f1586b = context;
        this.f1589e = LayoutInflater.from(context);
        this.f1587c = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    public int getId() {
        return this.f1594j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.appcompat.view.menu.MenuBuilder] */
    @Override // androidx.appcompat.view.menu.InterfaceC0414k
    /* renamed from: i */
    public boolean mo2419i(SubMenuC0419p subMenuC0419p) {
        InterfaceC0414k.a aVar = this.f1590f;
        SubMenuC0419p subMenuC0419p2 = subMenuC0419p;
        if (aVar == null) {
            return false;
        }
        if (subMenuC0419p == null) {
            subMenuC0419p2 = this.f1587c;
        }
        return aVar.mo2159b(subMenuC0419p2);
    }

    /* renamed from: l */
    public void m2420l(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1593i).addView(view, i10);
    }

    /* renamed from: m */
    public abstract void mo2421m(C0411h c0411h, InterfaceC0415l.a aVar);

    /* renamed from: n */
    public InterfaceC0415l.a m2422n(ViewGroup viewGroup) {
        return (InterfaceC0415l.a) this.f1588d.inflate(this.f1592h, viewGroup, false);
    }

    /* renamed from: o */
    public boolean mo2423o(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    /* renamed from: p */
    public InterfaceC0414k.a m2424p() {
        return this.f1590f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: q */
    public View mo2425q(C0411h c0411h, View view, ViewGroup viewGroup) {
        InterfaceC0415l.a aVarM2422n = view instanceof InterfaceC0415l.a ? (InterfaceC0415l.a) view : m2422n(viewGroup);
        mo2421m(c0411h, aVarM2422n);
        return (View) aVarM2422n;
    }

    /* renamed from: r */
    public InterfaceC0415l mo2426r(ViewGroup viewGroup) {
        if (this.f1593i == null) {
            InterfaceC0415l interfaceC0415l = (InterfaceC0415l) this.f1588d.inflate(this.f1591g, viewGroup, false);
            this.f1593i = interfaceC0415l;
            interfaceC0415l.mo2328b(this.f1587c);
            mo2414b(true);
        }
        return this.f1593i;
    }

    /* renamed from: s */
    public void m2427s(int i10) {
        this.f1594j = i10;
    }

    /* renamed from: t */
    public abstract boolean mo2428t(int i10, C0411h c0411h);
}
