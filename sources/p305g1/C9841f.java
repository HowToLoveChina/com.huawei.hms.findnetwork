package p305g1;

import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* renamed from: g1.f */
/* loaded from: classes.dex */
public class C9841f {

    /* renamed from: a */
    public int f48366a;

    /* renamed from: b */
    public int f48367b;

    /* renamed from: c */
    public int f48368c;

    /* renamed from: d */
    public int[] f48369d;

    /* renamed from: a */
    public final void m61176a(int i10, int i11, int i12) {
        if (this.f48369d == null) {
            this.f48369d = new int[6];
        }
        int i13 = this.f48368c;
        int[] iArr = this.f48369d;
        if (i13 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f48369d = iArr2;
        }
        int[] iArr3 = this.f48369d;
        int i14 = this.f48368c;
        iArr3[i14] = i10;
        this.f48368c = i14 + 2;
        iArr3[i14 + 1] = i11 | i12;
    }

    /* renamed from: b */
    public void m61177b(C9844i c9844i, C9836a c9836a, int i10, boolean z10) {
        if ((this.f48366a & 2) != 0) {
            if (z10) {
                c9836a.m61149f(this.f48367b - i10);
                return;
            } else {
                c9836a.m61150g(this.f48367b - i10);
                return;
            }
        }
        if (z10) {
            m61176a(i10, c9836a.f48328b, 536870912);
            c9836a.m61149f(-1);
        } else {
            m61176a(i10, c9836a.f48328b, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            c9836a.m61150g(-1);
        }
    }

    /* renamed from: c */
    public void m61178c(C9844i c9844i, int i10, byte[] bArr) {
        this.f48366a |= 2;
        this.f48367b = i10;
        int i11 = 0;
        while (i11 < this.f48368c) {
            int[] iArr = this.f48369d;
            int i12 = i11 + 1;
            int i13 = iArr[i11];
            i11 += 2;
            int i14 = iArr[i12];
            int i15 = 268435455 & i14;
            int i16 = i10 - i13;
            if ((i14 & (-268435456)) == 268435456) {
                bArr[i15] = (byte) (i16 >>> 8);
                bArr[i15 + 1] = (byte) i16;
            } else {
                bArr[i15] = (byte) (i16 >>> 24);
                bArr[i15 + 1] = (byte) (i16 >>> 16);
                bArr[i15 + 2] = (byte) (i16 >>> 8);
                bArr[i15 + 3] = (byte) i16;
            }
        }
    }
}
