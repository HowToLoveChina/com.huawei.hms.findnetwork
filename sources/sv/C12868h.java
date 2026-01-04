package sv;

import mv.C11533f;
import p535ov.InterfaceC12041h;
import p559pv.InterfaceC12231a;

/* renamed from: sv.h */
/* loaded from: classes9.dex */
public class C12868h implements InterfaceC12231a<InterfaceC12041h, Object[]> {

    /* renamed from: a */
    public String f58631a;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f58631a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12041h interfaceC12041h) {
        this.f58631a = C11533f.m68826d(interfaceC12041h, str);
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Object[] objArr) {
        return objArr == null || objArr.length > 0;
    }
}
