package p235ds;

import as.C1016d;
import com.huawei.location.lite.common.security.OpensslSm4Security;

/* renamed from: ds.c */
/* loaded from: classes8.dex */
public class C9302c implements InterfaceC9303d {

    /* renamed from: a */
    public final int f46661a;

    public C9302c(int i10) {
        this.f46661a = i10;
    }

    @Override // p235ds.InterfaceC9303d
    /* renamed from: a */
    public String mo38472a(String str, String str2) {
        InterfaceC9303d interfaceC9303dM58600c = m58600c();
        if (interfaceC9303dM58600c != null) {
            return interfaceC9303dM58600c.mo38472a(str, str2);
        }
        C1016d.m6183c("LocationSecurityManager", "locationCipher is null");
        return str;
    }

    @Override // p235ds.InterfaceC9303d
    /* renamed from: b */
    public String mo38473b(String str, String str2) {
        InterfaceC9303d interfaceC9303dM58600c = m58600c();
        if (interfaceC9303dM58600c != null) {
            return interfaceC9303dM58600c.mo38473b(str, str2);
        }
        C1016d.m6183c("LocationSecurityManager", "locationCipher is null");
        return str;
    }

    /* renamed from: c */
    public final InterfaceC9303d m58600c() {
        int i10 = this.f46661a;
        if (i10 == 1) {
            return new C9301b();
        }
        if (i10 == 2) {
            return new OpensslSm4Security();
        }
        if (i10 == 3) {
            return new C9305f();
        }
        if (i10 != 4) {
            return null;
        }
        return new C9304e();
    }
}
