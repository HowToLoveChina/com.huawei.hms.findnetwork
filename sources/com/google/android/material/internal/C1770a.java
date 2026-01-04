package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.internal.InterfaceC1776g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.material.internal.a */
/* loaded from: classes.dex */
public class C1770a<T extends InterfaceC1776g<T>> {

    /* renamed from: a */
    public final Map<Integer, T> f8252a = new HashMap();

    /* renamed from: b */
    public final Set<Integer> f8253b = new HashSet();

    /* renamed from: c */
    public b f8254c;

    /* renamed from: d */
    public boolean f8255d;

    /* renamed from: e */
    public boolean f8256e;

    /* renamed from: com.google.android.material.internal.a$a */
    public class a implements InterfaceC1776g.a<T> {
        public a() {
        }

        @Override // com.google.android.material.internal.InterfaceC1776g.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo10586a(T t10, boolean z10) {
            if (!z10) {
                C1770a c1770a = C1770a.this;
                if (!c1770a.m10585r(t10, c1770a.f8256e)) {
                    return;
                }
            } else if (!C1770a.this.m10574g(t10)) {
                return;
            }
            C1770a.this.m10580m();
        }
    }

    /* renamed from: com.google.android.material.internal.a$b */
    public interface b {
        /* renamed from: a */
        void mo10033a(Set<Integer> set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public void m10572e(T t10) {
        this.f8252a.put(Integer.valueOf(t10.getId()), t10);
        if (t10.isChecked()) {
            m10574g(t10);
        }
        t10.setInternalOnCheckedChangeListener(new a());
    }

    /* renamed from: f */
    public void m10573f(int i10) {
        T t10 = this.f8252a.get(Integer.valueOf(i10));
        if (t10 != null && m10574g(t10)) {
            m10580m();
        }
    }

    /* renamed from: g */
    public final boolean m10574g(InterfaceC1776g<T> interfaceC1776g) {
        int id2 = interfaceC1776g.getId();
        if (this.f8253b.contains(Integer.valueOf(id2))) {
            return false;
        }
        T t10 = this.f8252a.get(Integer.valueOf(m10578k()));
        if (t10 != null) {
            m10585r(t10, false);
        }
        boolean zAdd = this.f8253b.add(Integer.valueOf(id2));
        if (!interfaceC1776g.isChecked()) {
            interfaceC1776g.setChecked(true);
        }
        return zAdd;
    }

    /* renamed from: h */
    public void m10575h() {
        boolean z10 = !this.f8253b.isEmpty();
        Iterator<T> it = this.f8252a.values().iterator();
        while (it.hasNext()) {
            m10585r(it.next(), false);
        }
        if (z10) {
            m10580m();
        }
    }

    /* renamed from: i */
    public Set<Integer> m10576i() {
        return new HashSet(this.f8253b);
    }

    /* renamed from: j */
    public List<Integer> m10577j(ViewGroup viewGroup) {
        Set<Integer> setM10576i = m10576i();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof InterfaceC1776g) && setM10576i.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    /* renamed from: k */
    public int m10578k() {
        if (!this.f8255d || this.f8253b.isEmpty()) {
            return -1;
        }
        return this.f8253b.iterator().next().intValue();
    }

    /* renamed from: l */
    public boolean m10579l() {
        return this.f8255d;
    }

    /* renamed from: m */
    public final void m10580m() {
        b bVar = this.f8254c;
        if (bVar != null) {
            bVar.mo10033a(m10576i());
        }
    }

    /* renamed from: n */
    public void m10581n(T t10) {
        t10.setInternalOnCheckedChangeListener(null);
        this.f8252a.remove(Integer.valueOf(t10.getId()));
        this.f8253b.remove(Integer.valueOf(t10.getId()));
    }

    /* renamed from: o */
    public void m10582o(b bVar) {
        this.f8254c = bVar;
    }

    /* renamed from: p */
    public void m10583p(boolean z10) {
        this.f8256e = z10;
    }

    /* renamed from: q */
    public void m10584q(boolean z10) {
        if (this.f8255d != z10) {
            this.f8255d = z10;
            m10575h();
        }
    }

    /* renamed from: r */
    public final boolean m10585r(InterfaceC1776g<T> interfaceC1776g, boolean z10) {
        int id2 = interfaceC1776g.getId();
        if (!this.f8253b.contains(Integer.valueOf(id2))) {
            return false;
        }
        if (z10 && this.f8253b.size() == 1 && this.f8253b.contains(Integer.valueOf(id2))) {
            interfaceC1776g.setChecked(true);
            return false;
        }
        boolean zRemove = this.f8253b.remove(Integer.valueOf(id2));
        if (interfaceC1776g.isChecked()) {
            interfaceC1776g.setChecked(false);
        }
        return zRemove;
    }
}
