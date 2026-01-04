package p354i1;

import java.lang.reflect.Type;
import java.util.Arrays;
import p244e1.C9380d;
import p323h1.C10077a;
import p323h1.EnumC10078b;
import p323h1.InterfaceC10079c;

/* renamed from: i1.h */
/* loaded from: classes.dex */
public class C10396h implements InterfaceC10408t {

    /* renamed from: a */
    public final Class<?> f50194a;

    /* renamed from: b */
    public final Enum[] f50195b;

    /* renamed from: c */
    public final Enum[] f50196c;

    /* renamed from: d */
    public long[] f50197d;

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C10396h(java.lang.Class<?> r22) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p354i1.C10396h.<init>(java.lang.Class):void");
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: b */
    public <T> T mo63891b(C10077a c10077a, Type type, Object obj) {
        try {
            InterfaceC10079c interfaceC10079c = c10077a.f49153f;
            int iMo62768a0 = interfaceC10079c.mo62768a0();
            if (iMo62768a0 == 2) {
                int iMo62753B = interfaceC10079c.mo62753B();
                interfaceC10079c.mo62756D(16);
                if (iMo62753B >= 0) {
                    Object[] objArr = this.f50196c;
                    if (iMo62753B < objArr.length) {
                        return (T) objArr[iMo62753B];
                    }
                }
                throw new C9380d("parse enum " + this.f50194a.getName() + " error, value : " + iMo62753B);
            }
            if (iMo62768a0 != 4) {
                if (iMo62768a0 == 8) {
                    interfaceC10079c.mo62756D(16);
                    return null;
                }
                throw new C9380d("parse enum " + this.f50194a.getName() + " error, value : " + c10077a.m62712G());
            }
            String strMo62763J = interfaceC10079c.mo62763J();
            interfaceC10079c.mo62756D(16);
            if (strMo62763J.length() == 0) {
                return null;
            }
            long j10 = -3750763034362895579L;
            long j11 = -3750763034362895579L;
            for (int i10 = 0; i10 < strMo62763J.length(); i10++) {
                int iCharAt = strMo62763J.charAt(i10);
                long j12 = j10 ^ iCharAt;
                if (iCharAt >= 65 && iCharAt <= 90) {
                    iCharAt += 32;
                }
                j10 = j12 * 1099511628211L;
                j11 = (j11 ^ iCharAt) * 1099511628211L;
            }
            T t10 = (T) m63901d(j10);
            if (t10 == null && j11 != j10) {
                t10 = (T) m63901d(j11);
            }
            if (t10 == null && interfaceC10079c.mo62788x0(EnumC10078b.ErrorOnEnumNotMatch)) {
                throw new C9380d("not match enum value, " + this.f50194a.getName() + " : " + strMo62763J);
            }
            return t10;
        } catch (C9380d e10) {
            throw e10;
        } catch (Exception e11) {
            throw new C9380d(e11.getMessage(), e11);
        }
    }

    @Override // p354i1.InterfaceC10408t
    /* renamed from: c */
    public int mo63892c() {
        return 2;
    }

    /* renamed from: d */
    public Enum m63901d(long j10) {
        int iBinarySearch;
        if (this.f50195b != null && (iBinarySearch = Arrays.binarySearch(this.f50197d, j10)) >= 0) {
            return this.f50195b[iBinarySearch];
        }
        return null;
    }

    /* renamed from: e */
    public Enum<?> m63902e(int i10) {
        return this.f50196c[i10];
    }
}
