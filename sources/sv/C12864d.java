package sv;

import mv.C11533f;
import p535ov.InterfaceC12041h;
import p559pv.InterfaceC12231a;

/* renamed from: sv.d */
/* loaded from: classes9.dex */
public class C12864d implements InterfaceC12231a<InterfaceC12041h, double[]> {

    /* renamed from: a */
    public String f58627a;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f58627a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12041h interfaceC12041h) {
        this.f58627a = C11533f.m68826d(interfaceC12041h, str);
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(double[] dArr) {
        return dArr == null || dArr.length > 0;
    }
}
