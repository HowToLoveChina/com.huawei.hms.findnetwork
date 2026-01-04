package p753wv;

import mv.C11533f;
import p374iv.C10626e;
import p535ov.InterfaceC12043j;
import p559pv.InterfaceC12231a;
import p789xv.C13868b;

/* renamed from: wv.h */
/* loaded from: classes9.dex */
public class C13649h implements InterfaceC12231a<InterfaceC12043j, Object[]> {

    /* renamed from: a */
    public String f61358a;

    /* renamed from: b */
    public int f61359b;

    /* renamed from: c */
    public int f61360c;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f61358a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12043j interfaceC12043j) throws C10626e {
        C13868b.m83204a(interfaceC12043j);
        this.f61359b = interfaceC12043j.min();
        this.f61360c = interfaceC12043j.max();
        this.f61358a = C11533f.m68827e(interfaceC12043j, str);
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Object[] objArr) {
        if (objArr == null) {
            return true;
        }
        int length = objArr.length;
        return length >= this.f61359b && length <= this.f61360c;
    }
}
