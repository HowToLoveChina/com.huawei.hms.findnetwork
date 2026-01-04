package sy;

import com.huawei.hms.network.embedded.C6010m7;
import java.util.Iterator;
import p271ez.C9575a;

/* renamed from: sy.k */
/* loaded from: classes9.dex */
public abstract class AbstractC12887k extends AbstractC12885i implements Iterable {

    /* renamed from: b */
    public static final AbstractC12890n f58672b = new a(AbstractC12887k.class, 16);

    /* renamed from: a */
    public InterfaceC12878b[] f58673a;

    /* renamed from: sy.k$a */
    public static class a extends AbstractC12890n {
        public a(Class cls, int i10) {
            super(cls, i10);
        }
    }

    public AbstractC12887k() {
        this.f58673a = C12879c.f58655d;
    }

    @Override // sy.AbstractC12885i
    /* renamed from: c */
    public boolean mo77271c(AbstractC12885i abstractC12885i) {
        if (!(abstractC12885i instanceof AbstractC12887k)) {
            return false;
        }
        AbstractC12887k abstractC12887k = (AbstractC12887k) abstractC12885i;
        int size = size();
        if (abstractC12887k.size() != size) {
            return false;
        }
        for (int i10 = 0; i10 < size; i10++) {
            AbstractC12885i abstractC12885iMo77274a = this.f58673a[i10].mo77274a();
            AbstractC12885i abstractC12885iMo77274a2 = abstractC12887k.f58673a[i10].mo77274a();
            if (abstractC12885iMo77274a != abstractC12885iMo77274a2 && !abstractC12885iMo77274a.mo77271c(abstractC12885iMo77274a2)) {
                return false;
            }
        }
        return true;
    }

    @Override // sy.AbstractC12885i
    /* renamed from: h */
    public AbstractC12885i mo77272h() {
        return new C12893q(this.f58673a, false);
    }

    @Override // sy.AbstractC12885i, sy.AbstractC12881e
    public int hashCode() {
        int length = this.f58673a.length;
        int iHashCode = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return iHashCode;
            }
            iHashCode = (iHashCode * 257) ^ this.f58673a[length].mo77274a().hashCode();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<InterfaceC12878b> iterator() {
        return new C9575a.a(this.f58673a);
    }

    public int size() {
        return this.f58673a.length;
    }

    public String toString() {
        int size = size();
        if (size == 0) {
            return C6010m7.f27500n;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int i10 = 0;
        while (true) {
            stringBuffer.append(this.f58673a[i10]);
            i10++;
            if (i10 >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    public AbstractC12887k(C12879c c12879c) {
        if (c12879c == null) {
            throw new NullPointerException("'elementVector' cannot be null");
        }
        this.f58673a = c12879c.m77278d();
    }

    public AbstractC12887k(InterfaceC12878b[] interfaceC12878bArr, boolean z10) {
        this.f58673a = z10 ? C12879c.m77275b(interfaceC12878bArr) : interfaceC12878bArr;
    }
}
