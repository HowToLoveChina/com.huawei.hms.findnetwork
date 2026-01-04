package p719vv;

import java.util.Collection;
import mv.C11533f;
import p374iv.C10626e;
import p535ov.InterfaceC12043j;
import p559pv.InterfaceC12231a;
import p789xv.C13868b;

/* renamed from: vv.b */
/* loaded from: classes9.dex */
public class C13495b implements InterfaceC12231a<InterfaceC12043j, Collection> {

    /* renamed from: a */
    public String f60730a;

    /* renamed from: b */
    public int f60731b;

    /* renamed from: c */
    public int f60732c;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f60730a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12043j interfaceC12043j) throws C10626e {
        C13868b.m83204a(interfaceC12043j);
        this.f60731b = interfaceC12043j.min();
        this.f60732c = interfaceC12043j.max();
        this.f60730a = C11533f.m68827e(interfaceC12043j, str);
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Collection collection) {
        if (collection == null) {
            return true;
        }
        int size = collection.size();
        return size >= this.f60731b && size <= this.f60732c;
    }
}
