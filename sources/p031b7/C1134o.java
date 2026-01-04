package p031b7;

import androidx.recyclerview.widget.C0867f;
import java.util.List;
import p471m6.C11424j;

/* renamed from: b7.o */
/* loaded from: classes2.dex */
public class C1134o extends C0867f.b {

    /* renamed from: a */
    public List<C11424j> f5399a;

    /* renamed from: b */
    public List<C11424j> f5400b;

    public C1134o(List<C11424j> list, List<C11424j> list2) {
        this.f5399a = list;
        this.f5400b = list2;
    }

    @Override // androidx.recyclerview.widget.C0867f.b
    /* renamed from: a */
    public boolean mo5482a(int i10, int i11) {
        return true;
    }

    @Override // androidx.recyclerview.widget.C0867f.b
    /* renamed from: b */
    public boolean mo5483b(int i10, int i11) {
        List<C11424j> list = this.f5399a;
        if (list != null && this.f5400b != null) {
            C11424j c11424j = list.get(i10);
            C11424j c11424j2 = this.f5400b.get(i11);
            String strM68454b = c11424j.m68454b();
            String strM68454b2 = c11424j2.m68454b();
            if (strM68454b != null && strM68454b2 != null) {
                return strM68454b.equals(strM68454b2);
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.C0867f.b
    /* renamed from: d */
    public int mo5485d() {
        List<C11424j> list = this.f5400b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.C0867f.b
    /* renamed from: e */
    public int mo5486e() {
        List<C11424j> list = this.f5399a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
