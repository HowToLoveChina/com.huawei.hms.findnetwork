package p305g1;

import com.google.flatbuffers.reflection.BaseType;

/* renamed from: g1.b */
/* loaded from: classes.dex */
public class C9837b {

    /* renamed from: a */
    public final byte[] f48329a;

    /* renamed from: b */
    public final int[] f48330b;

    /* renamed from: c */
    public final String[] f48331c;

    /* renamed from: d */
    public final int f48332d;

    /* renamed from: e */
    public final int f48333e;

    /* renamed from: f */
    public boolean f48334f;

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C9837b(java.io.InputStream r9, boolean r10) throws java.io.IOException {
        /*
            r8 = this;
            r8.<init>()
            r8.f48334f = r10
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream
            r10.<init>()
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
        Le:
            int r1 = r9.read(r0)
            r2 = -1
            r3 = 0
            if (r1 != r2) goto L71
            r9.close()
            byte[] r9 = r10.toByteArray()
            r8.f48329a = r9
            r9 = 8
            int r9 = r8.m61158g(r9)
            int[] r9 = new int[r9]
            r8.f48330b = r9
            int r9 = r9.length
            java.lang.String[] r10 = new java.lang.String[r9]
            r8.f48331c = r10
            r10 = 1
            r0 = 10
            r1 = r10
        L32:
            if (r1 >= r9) goto L6c
            int[] r2 = r8.f48330b
            int r4 = r0 + 1
            r2[r1] = r4
            byte[] r2 = r8.f48329a
            r2 = r2[r0]
            r5 = 3
            if (r2 == r10) goto L61
            r4 = 15
            r6 = 4
            if (r2 == r4) goto L5f
            r4 = 18
            r7 = 5
            if (r2 == r4) goto L5d
            if (r2 == r5) goto L5d
            if (r2 == r6) goto L5d
            if (r2 == r7) goto L58
            r4 = 6
            if (r2 == r4) goto L58
            switch(r2) {
                case 9: goto L5d;
                case 10: goto L5d;
                case 11: goto L5d;
                case 12: goto L5d;
                default: goto L57;
            }
        L57:
            goto L69
        L58:
            int r1 = r1 + 1
            r5 = 9
            goto L69
        L5d:
            r5 = r7
            goto L69
        L5f:
            r5 = r6
            goto L69
        L61:
            int r2 = r8.m61158g(r4)
            int r5 = r5 + r2
            if (r5 <= r3) goto L69
            r3 = r5
        L69:
            int r0 = r0 + r5
            int r1 = r1 + r10
            goto L32
        L6c:
            r8.f48332d = r3
            r8.f48333e = r0
            return
        L71:
            if (r1 <= 0) goto Le
            r10.write(r0, r3, r1)
            goto Le
        */
        throw new UnsupportedOperationException("Method not decompiled: p305g1.C9837b.<init>(java.io.InputStream, boolean):void");
    }

    /* renamed from: a */
    public void m61152a(C9846k c9846k) {
        int i10;
        char[] cArr = new char[this.f48332d];
        if (this.f48334f) {
            int iM61153b = m61153b();
            for (int iM61158g = m61158g(iM61153b); iM61158g > 0; iM61158g--) {
                if ("RuntimeVisibleAnnotations".equals(m61157f(iM61153b + 2, cArr))) {
                    i10 = iM61153b + 8;
                    break;
                }
                iM61153b += m61154c(iM61153b + 4) + 6;
            }
            i10 = 0;
        } else {
            i10 = 0;
        }
        int i11 = this.f48333e;
        int iM61158g2 = m61158g(i11 + 6);
        int i12 = i11 + 8;
        for (int i13 = 0; i13 < iM61158g2; i13++) {
            i12 += 2;
        }
        int iM61154c = i12 + 2;
        int iM61154c2 = iM61154c;
        for (int iM61158g3 = m61158g(i12); iM61158g3 > 0; iM61158g3--) {
            iM61154c2 += 8;
            for (int iM61158g4 = m61158g(iM61154c2 + 6); iM61158g4 > 0; iM61158g4--) {
                iM61154c2 += m61154c(iM61154c2 + 2) + 6;
            }
        }
        int iM61154c3 = iM61154c2 + 2;
        for (int iM61158g5 = m61158g(iM61154c2); iM61158g5 > 0; iM61158g5--) {
            iM61154c3 += 8;
            for (int iM61158g6 = m61158g(iM61154c3 + 6); iM61158g6 > 0; iM61158g6--) {
                iM61154c3 += m61154c(iM61154c3 + 2) + 6;
            }
        }
        int iM61154c4 = iM61154c3 + 2;
        for (int iM61158g7 = m61158g(iM61154c3); iM61158g7 > 0; iM61158g7--) {
            iM61154c4 += m61154c(iM61154c4 + 2) + 6;
        }
        if (i10 != 0) {
            int i14 = i10 + 2;
            for (int iM61158g8 = m61158g(i10); iM61158g8 > 0; iM61158g8--) {
                c9846k.m61206d(m61157f(i14, cArr));
            }
        }
        for (int iM61158g9 = m61158g(i12); iM61158g9 > 0; iM61158g9--) {
            iM61154c += 8;
            for (int iM61158g10 = m61158g(iM61154c + 6); iM61158g10 > 0; iM61158g10--) {
                iM61154c += m61154c(iM61154c + 2) + 6;
            }
        }
        int iM61155d = iM61154c + 2;
        for (int iM61158g11 = m61158g(iM61154c); iM61158g11 > 0; iM61158g11--) {
            iM61155d = m61155d(c9846k, cArr, iM61155d);
        }
    }

    /* renamed from: b */
    public final int m61153b() {
        int i10 = this.f48333e;
        int iM61158g = i10 + 8 + (m61158g(i10 + 6) * 2);
        for (int iM61158g2 = m61158g(iM61158g); iM61158g2 > 0; iM61158g2--) {
            for (int iM61158g3 = m61158g(iM61158g + 8); iM61158g3 > 0; iM61158g3--) {
                iM61158g += m61154c(iM61158g + 12) + 6;
            }
            iM61158g += 8;
        }
        int iM61154c = iM61158g + 2;
        for (int iM61158g4 = m61158g(iM61154c); iM61158g4 > 0; iM61158g4--) {
            for (int iM61158g5 = m61158g(iM61154c + 8); iM61158g5 > 0; iM61158g5--) {
                iM61154c += m61154c(iM61154c + 12) + 6;
            }
            iM61154c += 8;
        }
        return iM61154c + 2;
    }

    /* renamed from: c */
    public final int m61154c(int i10) {
        byte[] bArr = this.f48329a;
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    /* renamed from: d */
    public final int m61155d(C9846k c9846k, char[] cArr, int i10) {
        int iM61158g = m61158g(i10);
        String strM61157f = m61157f(i10 + 2, cArr);
        String strM61157f2 = m61157f(i10 + 4, cArr);
        int i11 = i10 + 8;
        int i12 = 0;
        int i13 = 0;
        for (int iM61158g2 = m61158g(i10 + 6); iM61158g2 > 0; iM61158g2--) {
            String strM61157f3 = m61157f(i11, cArr);
            int iM61154c = m61154c(i11 + 2);
            int i14 = i11 + 6;
            if (strM61157f3.equals("Code")) {
                i13 = i14;
            }
            i11 = i14 + iM61154c;
        }
        C9842g c9842gM61207e = c9846k.m61207e(iM61158g, strM61157f, strM61157f2);
        if (c9842gM61207e != null && i13 != 0) {
            int iM61154c2 = i13 + 8 + m61154c(i13 + 4);
            int i15 = iM61154c2 + 2;
            for (int iM61158g3 = m61158g(iM61154c2); iM61158g3 > 0; iM61158g3--) {
                i15 += 8;
            }
            int iM61154c3 = i15 + 2;
            int i16 = 0;
            for (int iM61158g4 = m61158g(i15); iM61158g4 > 0; iM61158g4--) {
                String strM61157f4 = m61157f(iM61154c3, cArr);
                if (strM61157f4.equals("LocalVariableTable")) {
                    i12 = iM61154c3 + 6;
                } else if (strM61157f4.equals("LocalVariableTypeTable")) {
                    i16 = iM61154c3 + 6;
                }
                iM61154c3 += m61154c(iM61154c3 + 2) + 6;
            }
            if (i12 != 0) {
                if (i16 != 0) {
                    int iM61158g5 = m61158g(i16) * 3;
                    int i17 = i16 + 2;
                    int[] iArr = new int[iM61158g5];
                    while (iM61158g5 > 0) {
                        iArr[iM61158g5 - 1] = i17 + 6;
                        iArr[iM61158g5 - 2] = m61158g(i17 + 8);
                        iM61158g5 -= 3;
                        iArr[iM61158g5] = m61158g(i17);
                        i17 += 10;
                    }
                }
                int i18 = i12 + 2;
                for (int iM61158g6 = m61158g(i12); iM61158g6 > 0; iM61158g6--) {
                    c9842gM61207e.m61180b(m61157f(i18 + 4, cArr), m61158g(i18 + 8));
                    i18 += 10;
                }
            }
        }
        return i11;
    }

    /* renamed from: e */
    public final String m61156e(int i10, int i11, char[] cArr) {
        int i12;
        int i13 = i11 + i10;
        byte[] bArr = this.f48329a;
        int i14 = 0;
        char c10 = 0;
        char c11 = 0;
        while (i10 < i13) {
            int i15 = i10 + 1;
            byte b10 = bArr[i10];
            if (c10 == 0) {
                int i16 = b10 & 255;
                if (i16 < 128) {
                    cArr[i14] = (char) i16;
                    i14++;
                } else if (i16 >= 224 || i16 <= 191) {
                    c11 = (char) (b10 & BaseType.Obj);
                    c10 = 2;
                } else {
                    i12 = b10 & 31;
                    c11 = (char) i12;
                    c10 = 1;
                }
            } else if (c10 == 1) {
                cArr[i14] = (char) ((b10 & 63) | (c11 << 6));
                i14++;
                c10 = 0;
            } else if (c10 == 2) {
                i12 = (b10 & 63) | (c11 << 6);
                c11 = (char) i12;
                c10 = 1;
            }
            i10 = i15;
        }
        return new String(cArr, 0, i14);
    }

    /* renamed from: f */
    public final String m61157f(int i10, char[] cArr) {
        int iM61158g = m61158g(i10);
        String[] strArr = this.f48331c;
        String str = strArr[iM61158g];
        if (str != null) {
            return str;
        }
        int i11 = this.f48330b[iM61158g];
        String strM61156e = m61156e(i11 + 2, m61158g(i11), cArr);
        strArr[iM61158g] = strM61156e;
        return strM61156e;
    }

    /* renamed from: g */
    public final int m61158g(int i10) {
        byte[] bArr = this.f48329a;
        return (bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8);
    }
}
