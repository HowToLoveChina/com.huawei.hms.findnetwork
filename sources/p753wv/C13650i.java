package p753wv;

import mv.C11533f;
import p374iv.C10626e;
import p535ov.InterfaceC12043j;
import p559pv.InterfaceC12231a;
import p789xv.C13868b;

/* renamed from: wv.i */
/* loaded from: classes9.dex */
public class C13650i implements InterfaceC12231a<InterfaceC12043j, short[]> {

    /* renamed from: a */
    public String f61361a;

    /* renamed from: b */
    public int f61362b;

    /* renamed from: c */
    public int f61363c;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f61361a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12043j interfaceC12043j) throws C10626e {
        C13868b.m83204a(interfaceC12043j);
        this.f61362b = interfaceC12043j.min();
        this.f61363c = interfaceC12043j.max();
        this.f61361a = C11533f.m68827e(interfaceC12043j, str);
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(short[] sArr) {
        if (sArr == null) {
            return true;
        }
        int length = sArr.length;
        return length >= this.f61362b && length <= this.f61363c;
    }
}
