package p719vv;

import mv.C11533f;
import p374iv.C10626e;
import p535ov.InterfaceC12043j;
import p559pv.InterfaceC12231a;
import p789xv.C13868b;

/* renamed from: vv.a */
/* loaded from: classes9.dex */
public class C13494a implements InterfaceC12231a<InterfaceC12043j, CharSequence> {

    /* renamed from: a */
    public String f60727a;

    /* renamed from: b */
    public int f60728b;

    /* renamed from: c */
    public int f60729c;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f60727a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12043j interfaceC12043j) throws C10626e {
        C13868b.m83204a(interfaceC12043j);
        this.f60728b = interfaceC12043j.min();
        this.f60729c = interfaceC12043j.max();
        this.f60727a = C11533f.m68827e(interfaceC12043j, str);
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        int length = charSequence.length();
        return length >= this.f60728b && length <= this.f60729c;
    }
}
