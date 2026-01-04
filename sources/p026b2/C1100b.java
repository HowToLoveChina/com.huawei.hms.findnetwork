package p026b2;

import android.annotation.SuppressLint;
import p026b2.InterfaceC1101c;
import p630s2.C12673h;
import p759x1.InterfaceC13681f;
import p829z1.InterfaceC14083v;

/* renamed from: b2.b */
/* loaded from: classes.dex */
public class C1100b extends C12673h<InterfaceC13681f, InterfaceC14083v<?>> implements InterfaceC1101c {

    /* renamed from: e */
    public InterfaceC1101c.a f5229e;

    public C1100b(long j10) {
        super(j10);
    }

    @Override // p026b2.InterfaceC1101c
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo6540a(int i10) {
        if (i10 >= 40) {
            clearMemory();
        } else if (i10 >= 20 || i10 == 15) {
            m76269l(m76266g() / 2);
        }
    }

    @Override // p026b2.InterfaceC1101c
    /* renamed from: b */
    public /* bridge */ /* synthetic */ InterfaceC14083v mo6541b(InterfaceC13681f interfaceC13681f, InterfaceC14083v interfaceC14083v) {
        return (InterfaceC14083v) super.m76267j(interfaceC13681f, interfaceC14083v);
    }

    @Override // p026b2.InterfaceC1101c
    /* renamed from: c */
    public /* bridge */ /* synthetic */ InterfaceC14083v mo6542c(InterfaceC13681f interfaceC13681f) {
        return (InterfaceC14083v) super.m76268k(interfaceC13681f);
    }

    @Override // p026b2.InterfaceC1101c
    /* renamed from: d */
    public void mo6543d(InterfaceC1101c.a aVar) {
        this.f5229e = aVar;
    }

    @Override // p630s2.C12673h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public int mo6544h(InterfaceC14083v<?> interfaceC14083v) {
        return interfaceC14083v == null ? super.mo6544h(null) : interfaceC14083v.getSize();
    }

    @Override // p630s2.C12673h
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void mo6545i(InterfaceC13681f interfaceC13681f, InterfaceC14083v<?> interfaceC14083v) {
        InterfaceC1101c.a aVar = this.f5229e;
        if (aVar == null || interfaceC14083v == null) {
            return;
        }
        aVar.mo6548b(interfaceC14083v);
    }
}
