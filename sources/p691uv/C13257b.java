package p691uv;

import mv.C11533f;
import p535ov.InterfaceC12039f;
import p559pv.InterfaceC12231a;

/* renamed from: uv.b */
/* loaded from: classes9.dex */
public class C13257b implements InterfaceC12231a<InterfaceC12039f, Long> {

    /* renamed from: a */
    public String f59955a;

    /* renamed from: b */
    public long f59956b;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f59955a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12039f interfaceC12039f) {
        this.f59955a = C11533f.m68825c(interfaceC12039f, str);
        this.f59956b = interfaceC12039f.value();
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Long l10) {
        return l10 == null || l10.compareTo(Long.valueOf(this.f59956b)) >= 0;
    }
}
