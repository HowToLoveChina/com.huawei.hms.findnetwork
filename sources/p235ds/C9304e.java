package p235ds;

import as.C1016d;
import cu.C8952a;

/* renamed from: ds.e */
/* loaded from: classes8.dex */
public final class C9304e implements InterfaceC9303d {

    /* renamed from: a */
    public C9300a f46662a = new C9300a();

    @Override // p235ds.InterfaceC9303d
    /* renamed from: a */
    public final String mo38472a(String str, String str2) {
        String str3;
        if (this.f46662a == null) {
            str3 = "rootKey is null";
        } else {
            if (str.isEmpty()) {
                return "";
            }
            try {
                return C8952a.m56686h(str, this.f46662a.m58599b());
            } catch (Exception unused) {
                str3 = "AesCbc decrypt failed";
            }
        }
        C1016d.m6183c("ACECipher", str3);
        return "";
    }

    @Override // p235ds.InterfaceC9303d
    /* renamed from: b */
    public final String mo38473b(String str, String str2) {
        String str3;
        if (this.f46662a == null) {
            str3 = "rootKey is null";
        } else {
            if (str.isEmpty()) {
                return "";
            }
            try {
                return C8952a.m56690l(str, this.f46662a.m58599b());
            } catch (Exception unused) {
                str3 = "AesCbc encrypt failed";
            }
        }
        C1016d.m6183c("ACECipher", str3);
        return "";
    }
}
