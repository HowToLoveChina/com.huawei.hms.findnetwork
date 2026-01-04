package p559pv;

import p374iv.C10626e;
import p535ov.InterfaceC12045l;

/* renamed from: pv.g */
/* loaded from: classes9.dex */
public class C12237g implements InterfaceC12231a<InterfaceC12045l, String> {

    /* renamed from: a */
    public String f56620a;

    /* renamed from: b */
    public int f56621b;

    /* renamed from: c */
    public int f56622c;

    /* renamed from: d */
    public String f56623d;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f56620a;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12045l interfaceC12045l) throws C10626e {
        this.f56621b = interfaceC12045l.min();
        this.f56622c = interfaceC12045l.max();
        this.f56623d = str;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(String str) {
        if (str == null) {
            this.f56620a = this.f56623d + " is null";
            return false;
        }
        if (str.length() < this.f56621b) {
            this.f56620a = this.f56623d + " length must >= " + this.f56621b;
            return false;
        }
        if (str.length() <= this.f56622c) {
            return true;
        }
        this.f56620a = this.f56623d + " length must <= " + this.f56622c;
        return false;
    }
}
