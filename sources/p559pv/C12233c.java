package p559pv;

import p374iv.C10626e;
import p535ov.InterfaceC12037d;

/* renamed from: pv.c */
/* loaded from: classes9.dex */
public class C12233c implements InterfaceC12231a<InterfaceC12037d, Long> {

    /* renamed from: a */
    public String f56613a;

    /* renamed from: b */
    public Long f56614b;

    /* renamed from: c */
    public Long f56615c;

    /* renamed from: d */
    public String f56616d;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f56613a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12037d interfaceC12037d) throws C10626e {
        this.f56614b = Long.valueOf(interfaceC12037d.min());
        this.f56615c = Long.valueOf(interfaceC12037d.max());
        this.f56616d = str;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Long l10) {
        if (l10 == null) {
            this.f56613a = this.f56616d + " is null";
            return false;
        }
        if (l10.longValue() < this.f56614b.longValue()) {
            this.f56613a = this.f56616d + " must >= " + this.f56614b;
            return false;
        }
        if (l10.longValue() <= this.f56615c.longValue()) {
            return true;
        }
        this.f56613a = this.f56616d + " must <= " + this.f56615c;
        return false;
    }
}
