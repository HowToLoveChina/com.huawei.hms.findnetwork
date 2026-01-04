package tr;

import java.io.IOException;
import java.util.List;
import p688ur.C13243c;
import p688ur.C13244d;
import p688ur.C13245e;
import p785xr.C13851a;
import tr.InterfaceC13062f;

/* renamed from: tr.g */
/* loaded from: classes8.dex */
public class C13063g implements InterfaceC13062f.a {

    /* renamed from: a */
    public InterfaceC13059c f59431a;

    /* renamed from: b */
    public InterfaceC13060d f59432b;

    /* renamed from: c */
    public List<InterfaceC13062f> f59433c;

    /* renamed from: d */
    public C13851a f59434d;

    /* renamed from: e */
    public int f59435e;

    public C13063g(InterfaceC13059c interfaceC13059c, C13851a c13851a, List<InterfaceC13062f> list, int i10, InterfaceC13060d interfaceC13060d) {
        this.f59431a = interfaceC13059c;
        this.f59434d = c13851a;
        this.f59433c = list;
        this.f59435e = i10;
        this.f59432b = interfaceC13060d;
    }

    @Override // tr.InterfaceC13062f.a
    /* renamed from: a */
    public C13065i mo78789a(C13851a c13851a) throws C13245e, C13244d, IOException {
        if (this.f59435e >= this.f59433c.size()) {
            throw new AssertionError();
        }
        C13065i c13065iMo78788a = this.f59433c.get(this.f59435e).mo78788a(new C13063g(this.f59431a, c13851a, this.f59433c, this.f59435e + 1, this.f59432b));
        if (c13065iMo78788a != null) {
            return c13065iMo78788a;
        }
        throw new C13245e(C13243c.m79629a(10307));
    }

    /* renamed from: b */
    public InterfaceC13060d m78790b() {
        return this.f59432b;
    }

    @Override // tr.InterfaceC13062f.a
    public C13851a request() {
        return this.f59434d;
    }
}
