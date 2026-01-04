package p559pv;

import p374iv.C10626e;
import p535ov.InterfaceC12046m;

/* renamed from: pv.h */
/* loaded from: classes9.dex */
public class C12238h implements InterfaceC12231a<InterfaceC12046m, String> {

    /* renamed from: a */
    public String f56624a;

    /* renamed from: b */
    public String f56625b;

    @Override // p559pv.InterfaceC12231a
    /* renamed from: a */
    public String mo73423a() {
        return this.f56625b;
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void mo73425c(String str, InterfaceC12046m interfaceC12046m) throws C10626e {
        this.f56624a = interfaceC12046m.regex();
    }

    @Override // p559pv.InterfaceC12231a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean mo73424b(String str) {
        if (str == null) {
            this.f56625b = "string is null";
            return false;
        }
        if (str.matches(this.f56624a)) {
            return true;
        }
        this.f56625b = "value is not match";
        return false;
    }
}
