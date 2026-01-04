package p040bx;

/* renamed from: bx.c1 */
/* loaded from: classes9.dex */
public abstract class AbstractC1301c1 extends AbstractC1344t {
    /* renamed from: A */
    public final String m7737A() {
        AbstractC1301c1 abstractC1301c1Mo7738z;
        AbstractC1301c1 abstractC1301c1M7756b = C1312g0.m7756b();
        if (this == abstractC1301c1M7756b) {
            return "Dispatchers.Main";
        }
        try {
            abstractC1301c1Mo7738z = abstractC1301c1M7756b.mo7738z();
        } catch (UnsupportedOperationException unused) {
            abstractC1301c1Mo7738z = null;
        }
        if (this == abstractC1301c1Mo7738z) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // p040bx.AbstractC1344t
    public String toString() {
        String strM7737A = m7737A();
        if (strM7737A != null) {
            return strM7737A;
        }
        return C1354y.m7844a(this) + '@' + C1354y.m7845b(this);
    }

    /* renamed from: z */
    public abstract AbstractC1301c1 mo7738z();
}
