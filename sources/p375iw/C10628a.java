package p375iw;

import android.util.Log;
import com.ultrasoniclibrary.ultrasoundcore.classfun.FreqParam;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p299fw.C9778d;

/* renamed from: iw.a */
/* loaded from: classes9.dex */
public class C10628a {

    /* renamed from: a */
    public static long f51066a = 1000000000;

    /* renamed from: b */
    public static int f51067b = 1000000000;

    /* renamed from: iw.a$a */
    public static class a {

        /* renamed from: a */
        public double f51068a = 0.0d;

        /* renamed from: b */
        public double f51069b = 0.0d;
    }

    /* renamed from: a */
    public static float m65086a(float f10) {
        return f10 >= 0.0f ? f10 : f10 + 360.0f;
    }

    /* renamed from: b */
    public static a m65087b(float[] fArr) {
        a aVar = new a();
        double dSin = 0.0d;
        double dCos = 0.0d;
        for (float f10 : fArr) {
            double d10 = (f10 * 3.141592653589793d) / 180.0d;
            dSin += Math.sin(d10);
            dCos += Math.cos(d10);
        }
        int length = fArr.length;
        if (length > 0) {
            double d11 = length;
            dSin /= d11;
            dCos /= d11;
        }
        aVar.f51068a = dSin;
        aVar.f51069b = dCos;
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m65088c(double r5, double r7, double r9, double r11, float r13, int r14) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "inputCoors: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = "; "
            r0.append(r1)
            r0.append(r7)
            r0.append(r1)
            r0.append(r9)
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "UltraAlg"
            android.util.Log.e(r1, r0)
            r0 = 1232348160(0x49742400, float:1000000.0)
            float r13 = r13 * r0
            r0 = 1120403456(0x42c80000, float:100.0)
            float r13 = r13 * r0
            r0 = 0
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            r2 = 0
            if (r0 > 0) goto L3e
            r13 = 4604660403266387968(0x3fe70a3d80000000, double:0.7200000286102295)
            goto L45
        L3e:
            if (r14 <= 0) goto L44
            float r14 = (float) r14
            float r13 = r13 / r14
            double r13 = (double) r13
            goto L45
        L44:
            r13 = r2
        L45:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "waveLen: "
            r0.append(r4)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 <= 0) goto L9b
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 <= 0) goto L9b
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 <= 0) goto L9b
            double r9 = r9 - r5
            double r9 = r9 * r9
            double r11 = r11 - r7
            double r11 = r11 * r11
            double r9 = r9 + r11
            double r5 = java.lang.Math.sqrt(r9)
            r7 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r5 = r5 / r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "micDis: "
            r7.append(r8)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            android.util.Log.e(r1, r7)
            double r7 = r13 - r2
            double r7 = java.lang.Math.abs(r7)
            r9 = 4532020583610935537(0x3ee4f8b588e368f1, double:1.0E-5)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L9b
            double r5 = r5 / r13
            double r5 = java.lang.Math.ceil(r5)
            int r5 = (int) r5
            goto L9d
        L9b:
            r5 = 23
        L9d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "micDisPoint: "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            android.util.Log.e(r1, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p375iw.C10628a.m65088c(double, double, double, double, float, int):int");
    }

    /* renamed from: d */
    public static float m65089d(float f10) {
        float f11 = f10 % 360.0f;
        float f12 = 0.0f;
        if (f11 >= 0.0f && f11 < 180.0f) {
            f12 = f11;
        }
        return f11 >= 180.0f ? 360.0f - f11 : f12;
    }

    /* renamed from: e */
    public static float m65090e(float f10, float f11, int i10, int i11) {
        boolean z10 = i10 > i11 * 48 || i10 < 960;
        float f12 = (f10 < 150.0f || !z10) ? f10 : f10 - ((i11 * f11) * 1000.0f);
        return (f10 > -100.0f || !z10) ? f12 : f10 + (f11 * i11 * 1000.0f);
    }

    /* renamed from: f */
    public static int[] m65091f(int[] iArr, int i10, int i11) {
        if (iArr.length < 1 || i10 < 1) {
            return new int[]{0};
        }
        int[] iArr2 = new int[i10];
        int[] iArr3 = new int[i10];
        System.arraycopy(iArr, 0, iArr2, 1, i11);
        int i12 = i11 + 1;
        if (i12 < i10) {
            System.arraycopy(iArr, i12, iArr2, i12, (i10 - 1) - i11);
        }
        iArr2[0] = f51067b;
        System.arraycopy(iArr2, 0, iArr3, 0, i10);
        return iArr3;
    }

    /* renamed from: g */
    public static long[] m65092g(long[] jArr, int i10, int i11) {
        if (jArr.length < 1 || i10 < 1) {
            return new long[]{0};
        }
        long[] jArr2 = new long[i10];
        long[] jArr3 = new long[i10];
        System.arraycopy(jArr, 0, jArr2, 1, i11);
        int i12 = i11 + 1;
        if (i12 < i10) {
            System.arraycopy(jArr, i12, jArr2, i12, (i10 - 1) - i11);
        }
        jArr2[0] = f51066a;
        System.arraycopy(jArr2, 0, jArr3, 0, i10);
        return jArr3;
    }

    /* renamed from: h */
    public static int[] m65093h(int[] iArr, int i10, int i11) {
        if (iArr.length < 1 || i10 < 1) {
            return new int[]{0};
        }
        int[] iArr2 = new int[i10];
        int[] iArr3 = new int[i10];
        int i12 = i10 - 1;
        System.arraycopy(iArr, 1, iArr2, 0, i12);
        iArr2[i12] = i11;
        System.arraycopy(iArr2, 0, iArr3, 0, i10);
        return iArr3;
    }

    /* renamed from: i */
    public static long[] m65094i(long[] jArr, int i10, long j10) {
        if (jArr.length < 1 || i10 < 1) {
            return new long[]{0};
        }
        long[] jArr2 = new long[i10];
        long[] jArr3 = new long[i10];
        int i11 = i10 - 1;
        System.arraycopy(jArr, 1, jArr2, 0, i11);
        jArr2[i11] = j10;
        System.arraycopy(jArr2, 0, jArr3, 0, i10);
        return jArr3;
    }

    /* renamed from: j */
    public static float m65095j(int i10, int i11) {
        if (i10 > i11) {
            i10 = i11;
        } else {
            int i12 = -i11;
            if (i10 < i12) {
                i10 = i12;
            }
        }
        return Math.round(((Math.asin(i10 / i11) * 57.29577951308232d) + 90.0d) / 10.0d) * 10;
    }

    /* renamed from: k */
    public static float m65096k(float[] fArr, float f10, float f11) {
        int length = fArr.length;
        float f12 = 0.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (Math.abs(fArr[i11] - f10) <= f11) {
                Log.e("UltraAlg", "angle[i]: " + fArr[i11]);
                f12 += fArr[i11];
                i10++;
            }
        }
        Log.e("UltraAlg", "getFilterAngle sumTmp: " + f12);
        Log.e("UltraAlg", "angleBeta k count: " + i10);
        if (i10 <= 0) {
            return 1.0f;
        }
        float fRound = Math.round(((f12 / i10) % 360.0f) / 10.0f) * 10;
        Log.e("UltraAlg", "angleFilterTmp2: " + fRound);
        return m65104s(fRound);
    }

    /* renamed from: l */
    public static C9778d m65097l(float f10, float f11, int i10, FreqParam freqParam) {
        float[] fArr = {f10, f11};
        Log.i("UltraAlg", "resultValues[0]: " + f10 + "  resultValues[1]: " + f11 + "  freqParam: " + freqParam.toString());
        if (i10 == 4 && Math.abs(f10 - 1.0f) < 0.2f) {
            i10 = 1;
        }
        return new C9778d(i10, fArr, freqParam);
    }

    /* renamed from: m */
    public static float m65098m(float[] fArr) {
        boolean z10;
        Log.e("UltraAlg", "getMeanAngle: angleArray: " + Arrays.toString(fArr));
        a aVarM65087b = m65087b(fArr);
        double d10 = aVarM65087b.f51068a;
        double d11 = aVarM65087b.f51069b;
        double dM65115f = C10630c.m65115f(fArr);
        if (Math.abs(d11 - 0.0d) > 1.0E-5d) {
            dM65115f = (Math.atan(d10 / d11) * 180.0d) / 3.141592653589793d;
            z10 = true;
        } else {
            z10 = false;
        }
        Log.e("UltraAlg", "getMeanAngle: meanAngle: " + dM65115f);
        if (z10 && d11 < 0.0d && d11 < 0.0d) {
            dM65115f += 180.0d;
        }
        if (dM65115f < 0.0d) {
            dM65115f += 360.0d;
        }
        return (float) dM65115f;
    }

    /* renamed from: n */
    public static int m65099n(CopyOnWriteArrayList<float[]> copyOnWriteArrayList) {
        if (copyOnWriteArrayList.isEmpty()) {
            return 0;
        }
        int size = copyOnWriteArrayList.size();
        float[] fArr = new float[3];
        for (int i10 = 0; i10 < 3; i10++) {
            float[] fArr2 = new float[size];
            for (int i11 = 0; i11 < size; i11++) {
                fArr2[i11] = copyOnWriteArrayList.get(i11)[i10];
            }
            float fM65115f = C10630c.m65115f(fArr2);
            fArr[i10] = (C10630c.m65117h(fArr2) - (fM65115f * fM65115f)) * 1000.0f;
        }
        Log.e("UltraAlg", "getMoveState: std" + Arrays.toString(fArr));
        float[] fArr3 = {3800.0f, 200.0f, 3800.0f};
        int i12 = 0;
        for (int i13 = 0; i13 < 3; i13++) {
            if (fArr[i13] > fArr3[i13]) {
                i12 = 1;
            }
        }
        return i12;
    }

    /* renamed from: o */
    public static float m65100o(int i10, int i11, List<float[]> list, int i12) {
        if (i11 == 0) {
            Log.e("UltraAlg", "getSensorDegree: length of sensorList is 0!");
            return 0.0f;
        }
        int iRound = Math.round(600.0f / i11);
        Log.e("UltraAlg", "getSensorIdx unit is: " + iRound);
        int i13 = 1;
        if (i12 == 0) {
            Log.e("UltraAlg", "getSensorDegree: calFlag=0, sensorIdx is the last idx");
            i13 = i11 - 1;
        } else {
            int i14 = (iRound + 80) * 48;
            if (i10 <= i14) {
                i13 = 0;
            } else {
                int i15 = ((iRound * 2) + 80) * 48;
                if (i10 > i15 || i10 <= i14) {
                    int i16 = ((iRound * 3) + 80) * 48;
                    if (i10 > i16 || i10 <= i15) {
                        int i17 = ((iRound * 4) + 80) * 48;
                        if (i10 > i17 || i10 <= i16) {
                            int i18 = ((iRound * 5) + 80) * 48;
                            if (i10 > i18 || i10 <= i17) {
                                int i19 = ((iRound * 6) + 80) * 48;
                                if (i10 > i19 || i10 <= i18) {
                                    int i20 = ((iRound * 7) + 80) * 48;
                                    if (i10 > i20 || i10 <= i19) {
                                        i13 = 8;
                                        if (i10 <= (80 + (iRound * 8)) * 48 && i10 > i20) {
                                            i13 = 7;
                                        }
                                    } else {
                                        i13 = 6;
                                    }
                                } else {
                                    i13 = 5;
                                }
                            } else {
                                i13 = 4;
                            }
                        } else {
                            i13 = 3;
                        }
                    } else {
                        i13 = 2;
                    }
                }
            }
        }
        Log.e("UltraAlg", "sensorIdx is：" + i13);
        Log.e("UltraAlg", "sensorDegreeTemp is：" + Arrays.toString(list.get(i13)));
        return Math.round(r5[0]);
    }

    /* renamed from: p */
    public static CopyOnWriteArrayList<Float> m65101p(CopyOnWriteArrayList<Float> copyOnWriteArrayList, int i10, float f10) {
        if (copyOnWriteArrayList.size() >= i10) {
            copyOnWriteArrayList.remove(0);
        }
        copyOnWriteArrayList.add(Float.valueOf(f10));
        return copyOnWriteArrayList;
    }

    /* renamed from: q */
    public static CopyOnWriteArrayList<float[]> m65102q(CopyOnWriteArrayList<float[]> copyOnWriteArrayList, int i10, CopyOnWriteArrayList<float[]> copyOnWriteArrayList2) {
        int size = copyOnWriteArrayList2.size();
        if (copyOnWriteArrayList.size() >= i10 - size) {
            for (int i11 = 0; i11 < size; i11++) {
                copyOnWriteArrayList.remove(0);
            }
        }
        for (int i12 = 0; i12 < size; i12++) {
            copyOnWriteArrayList.add(copyOnWriteArrayList2.get(i12));
        }
        return copyOnWriteArrayList;
    }

    /* renamed from: r */
    public static float[] m65103r(CopyOnWriteArrayList<Float> copyOnWriteArrayList, CopyOnWriteArrayList<Float> copyOnWriteArrayList2, float f10) {
        int size = copyOnWriteArrayList.size();
        if (size < 1) {
            return new float[size];
        }
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            if (Math.abs(copyOnWriteArrayList.get(i11).floatValue() - 800.0f) > 1.0f) {
                i10++;
            }
        }
        Log.e("UltraAlg", "minusNoEmpty: arrayLen：" + i10);
        float[] fArr = new float[i10];
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            if (Math.abs(copyOnWriteArrayList.get(i13).floatValue() - 800.0f) > 1.0f) {
                float[] fArr2 = new float[(size - 1) - i13];
                for (int i14 = i13 + 1; i14 < size; i14++) {
                    fArr2[(i14 - i13) - 1] = copyOnWriteArrayList2.get(i14).floatValue();
                }
                fArr[i12] = m65086a((copyOnWriteArrayList.get(i13).floatValue() - (C10630c.m65118i(fArr2) + f10)) % 360.0f);
                i12++;
            }
        }
        Log.e("UltraAlg", "minusNoEmpty: arrayOutput: " + Arrays.toString(fArr));
        return fArr;
    }

    /* renamed from: s */
    public static float m65104s(float f10) {
        return Math.abs(f10) <= 180.0f ? f10 : f10 > 180.0f ? f10 - 360.0f : f10 + 360.0f;
    }

    /* renamed from: t */
    public static float m65105t(float f10) {
        if (f10 > -95.0f) {
            return ((f10 * 0.6f) + 331.6f) / 1000000.0f;
        }
        return 3.45E-4f;
    }
}
