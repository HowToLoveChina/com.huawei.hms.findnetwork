package p559pv;

import mv.C11533f;
import p535ov.InterfaceC12040g;

/* renamed from: pv.d */
/* loaded from: classes9.dex */
public class C12234d implements InterfaceC12231a<InterfaceC12040g, CharSequence> {

    /* renamed from: a */
    public String f56617a;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f56617a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12040g interfaceC12040g) {
        this.f56617a = C11533f.m68823a(interfaceC12040g.message(), str + " can't be blank");
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(CharSequence charSequence) {
        return charSequence == null || charSequence.toString().trim().length() > 0;
    }
}
