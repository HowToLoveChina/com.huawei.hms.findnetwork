package p559pv;

import p374iv.C10626e;
import p535ov.InterfaceC12036c;

/* renamed from: pv.b */
/* loaded from: classes9.dex */
public class C12232b implements InterfaceC12231a<InterfaceC12036c, Integer> {

    /* renamed from: a */
    public String f56609a;

    /* renamed from: b */
    public int f56610b;

    /* renamed from: c */
    public int f56611c;

    /* renamed from: d */
    public String f56612d;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f56609a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12036c interfaceC12036c) throws C10626e {
        this.f56610b = interfaceC12036c.min();
        this.f56611c = interfaceC12036c.max();
        this.f56612d = str;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(Integer num) {
        if (num == null) {
            this.f56609a = this.f56612d + " is null";
            return false;
        }
        if (this.f56610b > num.intValue()) {
            this.f56609a = this.f56612d + " must >= " + this.f56610b;
            return false;
        }
        if (this.f56611c >= num.intValue()) {
            return true;
        }
        this.f56609a = this.f56612d + " must <= " + this.f56611c;
        return false;
    }
}
