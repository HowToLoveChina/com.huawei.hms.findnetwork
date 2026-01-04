package p631s3;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import p831z3.C14094c0;
import p831z3.C14096d0;
import p831z3.C14125y;
import p831z3.EnumC14106i0;
import p831z3.EnumC14126z;

/* renamed from: s3.s */
/* loaded from: classes.dex */
public class C12696s {

    /* renamed from: a */
    public static final Charset f58230a = Charset.forName(Constants.UTF_8);

    /* renamed from: a */
    public static C14096d0.c m76396a(C14094c0.c cVar) {
        return C14096d0.c.m84537S().m84543A(cVar.m84495R().m84752S()).m84546z(cVar.m84498U()).m84545y(cVar.m84497T()).m84544x(cVar.m84496S()).build();
    }

    /* renamed from: b */
    public static C14096d0 m76397b(C14094c0 c14094c0) {
        C14096d0.b bVarM84531y = C14096d0.m84525S().m84531y(c14094c0.m84481U());
        Iterator<C14094c0.c> it = c14094c0.m84480T().iterator();
        while (it.hasNext()) {
            bVarM84531y.m84530x(m76396a(it.next()));
        }
        return bVarM84531y.build();
    }

    /* renamed from: c */
    public static void m76398c(C14094c0.c cVar) throws GeneralSecurityException {
        if (!cVar.m84499V()) {
            throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(cVar.m84496S())));
        }
        if (cVar.m84497T() == EnumC14106i0.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(cVar.m84496S())));
        }
        if (cVar.m84498U() == EnumC14126z.UNKNOWN_STATUS) {
            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(cVar.m84496S())));
        }
    }

    /* renamed from: d */
    public static void m76399d(C14094c0 c14094c0) throws GeneralSecurityException {
        int iM84481U = c14094c0.m84481U();
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = true;
        for (C14094c0.c cVar : c14094c0.m84480T()) {
            if (cVar.m84498U() == EnumC14126z.ENABLED) {
                m76398c(cVar);
                if (cVar.m84496S() == iM84481U) {
                    if (z10) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z10 = true;
                }
                if (cVar.m84495R().m84751R() != C14125y.c.ASYMMETRIC_PUBLIC) {
                    z11 = false;
                }
                i10++;
            }
        }
        if (i10 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z10 && !z11) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
