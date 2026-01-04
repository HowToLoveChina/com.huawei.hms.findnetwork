package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.InterfaceC0415l;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.f */
/* loaded from: classes.dex */
public class C0409f extends BaseAdapter {

    /* renamed from: a */
    public MenuBuilder f1647a;

    /* renamed from: b */
    public int f1648b = -1;

    /* renamed from: c */
    public boolean f1649c;

    /* renamed from: d */
    public final boolean f1650d;

    /* renamed from: e */
    public final LayoutInflater f1651e;

    /* renamed from: f */
    public final int f1652f;

    public C0409f(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f1650d = z10;
        this.f1651e = layoutInflater;
        this.f1647a = menuBuilder;
        this.f1652f = i10;
        m2462a();
    }

    /* renamed from: a */
    public void m2462a() {
        C0411h c0411hM2392x = this.f1647a.m2392x();
        if (c0411hM2392x != null) {
            ArrayList<C0411h> arrayListM2338B = this.f1647a.m2338B();
            int size = arrayListM2338B.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (arrayListM2338B.get(i10) == c0411hM2392x) {
                    this.f1648b = i10;
                    return;
                }
            }
        }
        this.f1648b = -1;
    }

    /* renamed from: b */
    public MenuBuilder m2463b() {
        return this.f1647a;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0411h getItem(int i10) {
        ArrayList<C0411h> arrayListM2338B = this.f1650d ? this.f1647a.m2338B() : this.f1647a.m2342G();
        int i11 = this.f1648b;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return arrayListM2338B.get(i10);
    }

    /* renamed from: d */
    public void m2465d(boolean z10) {
        this.f1649c = z10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1648b < 0 ? (this.f1650d ? this.f1647a.m2338B() : this.f1647a.m2342G()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1651e.inflate(this.f1652f, viewGroup, false);
        }
        int groupId = getItem(i10).getGroupId();
        int i11 = i10 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1647a.mo2343H() && groupId != (i11 >= 0 ? getItem(i11).getGroupId() : groupId));
        InterfaceC0415l.a aVar = (InterfaceC0415l.a) view;
        if (this.f1649c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.mo2320e(getItem(i10), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        m2462a();
        super.notifyDataSetChanged();
    }
}
