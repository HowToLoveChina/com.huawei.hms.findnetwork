package p631s3;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Iterator;
import p831z3.C14090a0;
import p831z3.C14094c0;
import p831z3.C14125y;
import p831z3.EnumC14106i0;
import p831z3.EnumC14126z;

/* renamed from: s3.j */
/* loaded from: classes.dex */
public final class C12687j {

    /* renamed from: a */
    public final C14094c0.b f58211a;

    public C12687j(C14094c0.b bVar) {
        this.f58211a = bVar;
    }

    /* renamed from: g */
    public static int m76341g() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i10 = 0;
        while (i10 == 0) {
            secureRandom.nextBytes(bArr);
            i10 = ((bArr[0] & 127) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return i10;
    }

    /* renamed from: i */
    public static C12687j m76342i() {
        return new C12687j(C14094c0.m84474V());
    }

    /* renamed from: j */
    public static C12687j m76343j(C12686i c12686i) {
        return new C12687j(c12686i.m76336f().mo12138d());
    }

    /* renamed from: a */
    public synchronized C12687j m76344a(C12684g c12684g) throws GeneralSecurityException {
        m76345b(c12684g.m76314b(), false);
        return this;
    }

    @Deprecated
    /* renamed from: b */
    public synchronized int m76345b(C14090a0 c14090a0, boolean z10) throws GeneralSecurityException {
        C14094c0.c cVarM76348e;
        try {
            cVarM76348e = m76348e(c14090a0);
            this.f58211a.m84485x(cVarM76348e);
            if (z10) {
                this.f58211a.m84484B(cVarM76348e.m84496S());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return cVarM76348e.m84496S();
    }

    /* renamed from: c */
    public synchronized C12686i m76346c() throws GeneralSecurityException {
        return C12686i.m76334e(this.f58211a.build());
    }

    /* renamed from: d */
    public final synchronized boolean m76347d(int i10) {
        Iterator<C14094c0.c> it = this.f58211a.m84483A().iterator();
        while (it.hasNext()) {
            if (it.next().m84496S() == i10) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public final synchronized C14094c0.c m76348e(C14090a0 c14090a0) throws GeneralSecurityException {
        C14125y c14125yM76387p;
        int iM76349f;
        EnumC14106i0 enumC14106i0M84456R;
        try {
            c14125yM76387p = C12695r.m76387p(c14090a0);
            iM76349f = m76349f();
            enumC14106i0M84456R = c14090a0.m84456R();
            if (enumC14106i0M84456R == EnumC14106i0.UNKNOWN_PREFIX) {
                enumC14106i0M84456R = EnumC14106i0.TINK;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return C14094c0.c.m84493W().m84504x(c14125yM76387p).m84505y(iM76349f).m84503A(EnumC14126z.ENABLED).m84506z(enumC14106i0M84456R).build();
    }

    /* renamed from: f */
    public final synchronized int m76349f() {
        int iM76341g;
        iM76341g = m76341g();
        while (m76347d(iM76341g)) {
            iM76341g = m76341g();
        }
        return iM76341g;
    }

    /* renamed from: h */
    public synchronized C12687j m76350h(int i10) throws GeneralSecurityException {
        for (int i11 = 0; i11 < this.f58211a.m84487z(); i11++) {
            C14094c0.c cVarM84486y = this.f58211a.m84486y(i11);
            if (cVarM84486y.m84496S() == i10) {
                if (!cVarM84486y.m84498U().equals(EnumC14126z.ENABLED)) {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i10);
                }
                this.f58211a.m84484B(i10);
            }
        }
        throw new GeneralSecurityException("key not found: " + i10);
        return this;
    }
}
