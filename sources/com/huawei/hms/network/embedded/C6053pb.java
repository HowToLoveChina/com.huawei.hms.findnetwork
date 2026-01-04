package com.huawei.hms.network.embedded;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.huawei.hms.network.embedded.pb */
/* loaded from: classes8.dex */
public final class C6053pb extends AbstractList<C5910eb> implements RandomAccess {

    /* renamed from: a */
    public final C5910eb[] f27791a;

    /* renamed from: b */
    public final int[] f27792b;

    public C6053pb(C5910eb[] c5910ebArr, int[] iArr) {
        this.f27791a = c5910ebArr;
        this.f27792b = iArr;
    }

    /* renamed from: a */
    public static int m35042a(C5868bb c5868bb) {
        return (int) (c5868bb.m33913B() / 4);
    }

    @Override // java.util.AbstractList, java.util.List
    public C5910eb get(int i10) {
        return this.f27791a[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f27791a.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x00ba, code lost:
    
        continue;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.network.embedded.C6053pb m35043a(com.huawei.hms.network.embedded.C5910eb... r11) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6053pb.m35043a(com.huawei.hms.network.embedded.eb[]):com.huawei.hms.network.embedded.pb");
    }

    /* renamed from: a */
    public static void m35044a(long j10, C5868bb c5868bb, int i10, List<C5910eb> list, int i11, int i12, List<Integer> list2) {
        int iIntValue;
        int i13;
        int i14;
        int i15;
        int i16;
        C5868bb c5868bb2;
        if (i11 >= i12) {
            throw new AssertionError();
        }
        for (int i17 = i11; i17 < i12; i17++) {
            if (list.get(i17).mo34192j() < i10) {
                throw new AssertionError();
            }
        }
        C5910eb c5910eb = list.get(i11);
        C5910eb c5910eb2 = list.get(i12 - 1);
        if (i10 == c5910eb.mo34192j()) {
            int i18 = i11 + 1;
            i13 = i18;
            iIntValue = list2.get(i11).intValue();
            c5910eb = list.get(i18);
        } else {
            iIntValue = -1;
            i13 = i11;
        }
        if (c5910eb.mo34159a(i10) != c5910eb2.mo34159a(i10)) {
            int i19 = 1;
            for (int i20 = i13 + 1; i20 < i12; i20++) {
                if (list.get(i20 - 1).mo34159a(i10) != list.get(i20).mo34159a(i10)) {
                    i19++;
                }
            }
            long jM35042a = j10 + m35042a(c5868bb) + 2 + (i19 * 2);
            c5868bb.writeInt(i19);
            c5868bb.writeInt(iIntValue);
            for (int i21 = i13; i21 < i12; i21++) {
                byte bMo34159a = list.get(i21).mo34159a(i10);
                if (i21 == i13 || bMo34159a != list.get(i21 - 1).mo34159a(i10)) {
                    c5868bb.writeInt(bMo34159a & 255);
                }
            }
            C5868bb c5868bb3 = new C5868bb();
            int i22 = i13;
            while (i22 < i12) {
                byte bMo34159a2 = list.get(i22).mo34159a(i10);
                int i23 = i22 + 1;
                int i24 = i23;
                while (true) {
                    if (i24 >= i12) {
                        i15 = i12;
                        break;
                    } else {
                        if (bMo34159a2 != list.get(i24).mo34159a(i10)) {
                            i15 = i24;
                            break;
                        }
                        i24++;
                    }
                }
                if (i23 != i15 || i10 + 1 != list.get(i22).mo34192j()) {
                    c5868bb.writeInt((int) ((m35042a(c5868bb3) + jM35042a) * (-1)));
                    i16 = i15;
                    c5868bb2 = c5868bb3;
                    m35044a(jM35042a, c5868bb3, i10 + 1, list, i22, i15, list2);
                } else {
                    c5868bb.writeInt(list2.get(i22).intValue());
                    i16 = i15;
                    c5868bb2 = c5868bb3;
                }
                c5868bb3 = c5868bb2;
                i22 = i16;
            }
            C5868bb c5868bb4 = c5868bb3;
            c5868bb.write(c5868bb4, c5868bb4.m33913B());
            return;
        }
        int iMin = Math.min(c5910eb.mo34192j(), c5910eb2.mo34192j());
        int i25 = 0;
        for (int i26 = i10; i26 < iMin && c5910eb.mo34159a(i26) == c5910eb2.mo34159a(i26); i26++) {
            i25++;
        }
        long jM35042a2 = 1 + j10 + m35042a(c5868bb) + 2 + i25;
        c5868bb.writeInt(-i25);
        c5868bb.writeInt(iIntValue);
        int i27 = i10;
        while (true) {
            i14 = i10 + i25;
            if (i27 >= i14) {
                break;
            }
            c5868bb.writeInt(c5910eb.mo34159a(i27) & 255);
            i27++;
        }
        if (i13 + 1 == i12) {
            if (i14 != list.get(i13).mo34192j()) {
                throw new AssertionError();
            }
            c5868bb.writeInt(list2.get(i13).intValue());
        } else {
            C5868bb c5868bb5 = new C5868bb();
            c5868bb.writeInt((int) ((m35042a(c5868bb5) + jM35042a2) * (-1)));
            m35044a(jM35042a2, c5868bb5, i14, list, i13, i12, list2);
            c5868bb.write(c5868bb5, c5868bb5.m33913B());
        }
    }
}
