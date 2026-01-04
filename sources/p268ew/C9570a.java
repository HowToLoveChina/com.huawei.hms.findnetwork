package p268ew;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.api.ConnectionResult;
import com.ultrasoniclibrary.ultrasoundcore.classfun.FreqParam;
import gw.C10055a;
import gw.C10056b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import p299fw.C9775a;
import p299fw.C9776b;
import p299fw.C9777c;
import p299fw.C9778d;
import p348hw.C10346a;
import p348hw.C10347b;
import p348hw.C10349d;
import p348hw.C10350e;
import p348hw.C10352g;
import p348hw.C10353h;
import p348hw.C10354i;
import p348hw.EnumC10351f;
import p375iw.C10628a;
import p375iw.C10629b;
import p375iw.C10630c;

/* renamed from: ew.a */
/* loaded from: classes9.dex */
public class C9570a {

    /* renamed from: S1 */
    public static int f47500S1 = 6;

    /* renamed from: T1 */
    public static long[] f47501T1 = new long[6];

    /* renamed from: U1 */
    public static long[] f47502U1 = new long[6];

    /* renamed from: V1 */
    public static int[] f47503V1 = new int[6];

    /* renamed from: W1 */
    public static List<Float> f47504W1 = new ArrayList();

    /* renamed from: X1 */
    public static List<Integer> f47505X1 = new ArrayList();

    /* renamed from: Y1 */
    public static C9570a f47506Y1;

    /* renamed from: A0 */
    public double[] f47508A0;

    /* renamed from: B0 */
    public double[] f47511B0;

    /* renamed from: C0 */
    public double[] f47514C0;

    /* renamed from: D0 */
    public double[] f47517D0;

    /* renamed from: E0 */
    public double[] f47520E0;

    /* renamed from: F0 */
    public C10347b[] f47523F0;

    /* renamed from: G0 */
    public C10347b[] f47526G0;

    /* renamed from: H0 */
    public C10347b[] f47529H0;

    /* renamed from: I0 */
    public C10347b[] f47532I0;

    /* renamed from: J0 */
    public C10347b[] f47535J0;

    /* renamed from: K0 */
    public C10347b[] f47538K0;

    /* renamed from: L0 */
    public C10347b[] f47541L0;

    /* renamed from: M0 */
    public C10347b[] f47544M0;

    /* renamed from: N0 */
    public C10347b[] f47547N0;

    /* renamed from: N1 */
    public double f47548N1;

    /* renamed from: O1 */
    public double f47551O1;

    /* renamed from: P1 */
    public double f47554P1;

    /* renamed from: Q */
    public double f47555Q;

    /* renamed from: Q1 */
    public double f47557Q1;

    /* renamed from: R */
    public double f47558R;

    /* renamed from: S */
    public double f47561S;

    /* renamed from: S0 */
    public C9775a f47562S0;

    /* renamed from: T */
    public double f47563T;

    /* renamed from: W */
    public double f47569W;

    /* renamed from: X */
    public double f47571X;

    /* renamed from: Y */
    public double f47573Y;

    /* renamed from: Z */
    public double f47575Z;

    /* renamed from: a */
    public double[] f47577a;

    /* renamed from: b */
    public double[] f47580b;

    /* renamed from: c */
    public double[] f47583c;

    /* renamed from: d */
    public double[] f47586d;

    /* renamed from: e */
    public double[] f47589e;

    /* renamed from: e0 */
    public int f47590e0;

    /* renamed from: f */
    public double[] f47592f;

    /* renamed from: g */
    public C10350e f47595g;

    /* renamed from: g0 */
    public Map<Integer, Double> f47596g0;

    /* renamed from: h */
    public float f47598h;

    /* renamed from: k */
    public float f47607k;

    /* renamed from: l */
    public float f47610l;

    /* renamed from: m */
    public float f47613m;

    /* renamed from: n */
    public float f47616n;

    /* renamed from: p0 */
    public boolean f47623p0;

    /* renamed from: q0 */
    public String f47626q0;

    /* renamed from: r0 */
    public int f47629r0;

    /* renamed from: s0 */
    public int f47632s0;

    /* renamed from: t1 */
    public String f47636t1;

    /* renamed from: v0 */
    public C10056b f47641v0;

    /* renamed from: w0 */
    public C9777c f47644w0;

    /* renamed from: z0 */
    public double[] f47653z0;

    /* renamed from: i */
    public int f47601i = 0;

    /* renamed from: j */
    public int f47604j = 0;

    /* renamed from: o */
    public boolean f47619o = true;

    /* renamed from: p */
    public int f47622p = 0;

    /* renamed from: q */
    public int f47625q = 0;

    /* renamed from: r */
    public int f47628r = 0;

    /* renamed from: s */
    public int f47631s = 2;

    /* renamed from: t */
    public int f47634t = 0;

    /* renamed from: u */
    public int f47637u = 0;

    /* renamed from: v */
    public boolean f47640v = false;

    /* renamed from: w */
    public int f47643w = 0;

    /* renamed from: x */
    public int f47646x = 0;

    /* renamed from: y */
    public int f47649y = 0;

    /* renamed from: z */
    public boolean f47652z = false;

    /* renamed from: A */
    public int f47507A = 0;

    /* renamed from: B */
    public boolean f47510B = false;

    /* renamed from: C */
    public int f47513C = 2;

    /* renamed from: D */
    public int f47516D = 0;

    /* renamed from: E */
    public double f47519E = 0.0d;

    /* renamed from: F */
    public int f47522F = 0;

    /* renamed from: G */
    public int f47525G = 0;

    /* renamed from: H */
    public boolean f47528H = false;

    /* renamed from: I */
    public CopyOnWriteArrayList<float[]> f47531I = new CopyOnWriteArrayList<>();

    /* renamed from: J */
    public CopyOnWriteArrayList<Float> f47534J = new CopyOnWriteArrayList<>();

    /* renamed from: K */
    public CopyOnWriteArrayList<Float> f47537K = new CopyOnWriteArrayList<>();

    /* renamed from: L */
    public CopyOnWriteArrayList<Float> f47540L = new CopyOnWriteArrayList<>();

    /* renamed from: M */
    public CopyOnWriteArrayList<Float> f47543M = new CopyOnWriteArrayList<>();

    /* renamed from: N */
    public float f47546N = 20.0f;

    /* renamed from: O */
    public float f47549O = 15.0f;

    /* renamed from: P */
    public int f47552P = 3;

    /* renamed from: U */
    public double f47565U = 1.0d;

    /* renamed from: V */
    public double f47567V = 1.0d;

    /* renamed from: a0 */
    public double f47578a0 = 1.0d;

    /* renamed from: b0 */
    public double f47581b0 = 1.0d;

    /* renamed from: c0 */
    public int f47584c0 = 1;

    /* renamed from: d0 */
    public float f47587d0 = 15.0f;

    /* renamed from: f0 */
    public float f47593f0 = 34.0f;

    /* renamed from: h0 */
    public int f47599h0 = 23;

    /* renamed from: i0 */
    public float f47602i0 = 3.45E-4f;

    /* renamed from: j0 */
    public double f47605j0 = 8.0d;

    /* renamed from: k0 */
    public double f47608k0 = 5.0d;

    /* renamed from: l0 */
    public double f47611l0 = 8.0d;

    /* renamed from: m0 */
    public double f47614m0 = 300.0d;

    /* renamed from: n0 */
    public double f47617n0 = 24.0d;

    /* renamed from: o0 */
    public float f47620o0 = 70.0f;

    /* renamed from: t0 */
    public boolean f47635t0 = false;

    /* renamed from: u0 */
    public EnumC10351f f47638u0 = EnumC10351f.PIANO;

    /* renamed from: x0 */
    public int f47647x0 = 4096;

    /* renamed from: y0 */
    public int f47650y0 = 0;

    /* renamed from: O0 */
    public float f47550O0 = 40.0f;

    /* renamed from: P0 */
    public float f47553P0 = -1.6f;

    /* renamed from: Q0 */
    public long f47556Q0 = 1000000000;

    /* renamed from: R0 */
    public long f47559R0 = 1000000;

    /* renamed from: T0 */
    public float f47564T0 = 34.0f;

    /* renamed from: U0 */
    public double f47566U0 = 0.5d;

    /* renamed from: V0 */
    public double f47568V0 = 600.0d;

    /* renamed from: W0 */
    public double f47570W0 = 500.0d;

    /* renamed from: X0 */
    public double f47572X0 = 0.0d;

    /* renamed from: Y0 */
    public double f47574Y0 = 0.0d;

    /* renamed from: Z0 */
    public int f47576Z0 = 600;

    /* renamed from: a1 */
    public long f47579a1 = 0;

    /* renamed from: b1 */
    public long f47582b1 = 1000000000;

    /* renamed from: c1 */
    public int f47585c1 = 0;

    /* renamed from: d1 */
    public int f47588d1 = 0;

    /* renamed from: e1 */
    public int f47591e1 = 3;

    /* renamed from: f1 */
    public int f47594f1 = 0;

    /* renamed from: g1 */
    public float f47597g1 = -500.0f;

    /* renamed from: h1 */
    public float f47600h1 = 0.0f;

    /* renamed from: i1 */
    public boolean f47603i1 = false;

    /* renamed from: j1 */
    public final int f47606j1 = 20;

    /* renamed from: k1 */
    public int f47609k1 = 0;

    /* renamed from: l1 */
    public double f47612l1 = 0.0d;

    /* renamed from: m1 */
    public double f47615m1 = 0.0d;

    /* renamed from: n1 */
    public boolean f47618n1 = false;

    /* renamed from: o1 */
    public int f47621o1 = 0;

    /* renamed from: p1 */
    public float f47624p1 = -500.0f;

    /* renamed from: q1 */
    public int f47627q1 = 1;

    /* renamed from: r1 */
    public int f47630r1 = 0;

    /* renamed from: s1 */
    public int f47633s1 = 0;

    /* renamed from: u1 */
    public int f47639u1 = 0;

    /* renamed from: v1 */
    public boolean f47642v1 = false;

    /* renamed from: w1 */
    public double f47645w1 = 20.0d;

    /* renamed from: x1 */
    public double f47648x1 = 120.0d;

    /* renamed from: y1 */
    public double f47651y1 = 340.0d;

    /* renamed from: z1 */
    public double f47654z1 = 30.0d;

    /* renamed from: A1 */
    public double f47509A1 = 60.0d;

    /* renamed from: B1 */
    public double f47512B1 = 10.0d;

    /* renamed from: C1 */
    public int f47515C1 = 0;

    /* renamed from: D1 */
    public int f47518D1 = 0;

    /* renamed from: E1 */
    public int f47521E1 = 0;

    /* renamed from: F1 */
    public int f47524F1 = 0;

    /* renamed from: G1 */
    public int f47527G1 = 0;

    /* renamed from: H1 */
    public double f47530H1 = 0.0d;

    /* renamed from: I1 */
    public double f47533I1 = 0.0d;

    /* renamed from: J1 */
    public int f47536J1 = 0;

    /* renamed from: K1 */
    public Boolean f47539K1 = Boolean.FALSE;

    /* renamed from: L1 */
    public boolean f47542L1 = false;

    /* renamed from: M1 */
    public int f47545M1 = 0;

    /* renamed from: R1 */
    public int f47560R1 = 0;

    /* renamed from: t */
    public static C9570a m59702t() {
        if (f47506Y1 == null) {
            synchronized (C9570a.class) {
                try {
                    if (f47506Y1 == null) {
                        f47506Y1 = new C9570a();
                    }
                } finally {
                }
            }
        }
        return f47506Y1;
    }

    /* renamed from: A */
    public Boolean m59703A(int i10) {
        boolean z10 = false;
        float fIntValue = 0.0f;
        if (f47505X1.size() < 20) {
            f47505X1.add(Integer.valueOf(i10));
        } else {
            if (f47505X1.isEmpty()) {
                Log.e("UltraAlg", "hisMoveState Queue is empty！");
                return Boolean.FALSE;
            }
            f47505X1.remove(0);
            f47505X1.add(Integer.valueOf(i10));
            for (int i11 = 0; i11 < 20; i11++) {
                fIntValue += f47505X1.get(i11).intValue();
            }
        }
        if (f47505X1.size() >= 20 ? fIntValue > 3.0f : i10 == 1) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }

    /* renamed from: B */
    public float m59704B(float f10) {
        if (Math.abs(Math.abs(f10) - 500.0f) < 1.0E-6f) {
            int i10 = this.f47594f1 + 1;
            this.f47594f1 = i10;
            return i10 <= 3 ? this.f47597g1 : f10;
        }
        this.f47597g1 = f10;
        this.f47594f1 = 0;
        return f10;
    }

    /* renamed from: C */
    public float m59705C(float f10, float f11) {
        if (f10 >= 0.0f || f10 < f11) {
            return f10;
        }
        return 0.5f;
    }

    /* JADX WARN: Removed duplicated region for block: B:206:0x0415 A[Catch: all -> 0x005c, TryCatch #0 {, blocks: (B:111:0x0003, B:113:0x0048, B:118:0x005f, B:119:0x0070, B:121:0x0076, B:122:0x0097, B:124:0x00a6, B:125:0x00ad, B:127:0x011f, B:129:0x0131, B:131:0x01db, B:133:0x01e1, B:135:0x01e6, B:140:0x01f0, B:142:0x01f4, B:145:0x01fd, B:147:0x024c, B:148:0x0254, B:155:0x027c, B:157:0x0281, B:159:0x028b, B:161:0x0297, B:163:0x02ac, B:165:0x02c5, B:169:0x0304, B:175:0x0310, B:177:0x033b, B:180:0x0340, B:186:0x0369, B:188:0x0378, B:190:0x037c, B:192:0x0383, B:194:0x039e, B:196:0x03cf, B:198:0x03d7, B:200:0x03e8, B:205:0x040d, B:207:0x0425, B:201:0x03f3, B:203:0x03fb, B:206:0x0415, B:174:0x030e, B:144:0x01f8, B:138:0x01ec, B:128:0x012b), top: B:212:0x0003 }] */
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized p299fw.C9778d m59706D(p299fw.C9776b r28) {
        /*
            Method dump skipped, instructions count: 1069
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p268ew.C9570a.m59706D(fw.b):fw.d");
    }

    /* renamed from: E */
    public float m59707E(float f10, float[] fArr, float f11, float[] fArr2) {
        return Math.abs(f10 - 1.0f) < 1.0E-5f ? fArr2.length < 1 ? this.f47616n : Math.round(C10628a.m65104s(fArr2[fArr2.length - 1]) / 10.0f) * 10.0f : this.f47510B ? 0.0f : C10628a.m65096k(fArr, f11, 45.0f);
    }

    /* renamed from: F */
    public void m59708F(int i10, int i11, float f10, float f11) {
        if (i10 != 4 && this.f47591e1 != 1 && i11 != 0) {
            this.f47613m = this.f47610l;
            this.f47610l = this.f47607k;
            this.f47607k = f10;
            if (!this.f47619o) {
                float f12 = this.f47616n;
                Log.e("UltraAlg", "angleFinalFlag: " + f12);
                this.f47616n = C10628a.m65104s(f12 - (((float) Math.round(f11 / 10.0f)) * 10.0f));
                Log.e("UltraAlg", " Math.round(deltaRotateAngle1 / 10f) * 10f: " + (Math.round(r0) * 10.0f));
                Log.e("UltraAlg", "angle_final: " + this.f47616n);
            }
            Log.e("UltraAlg", "angleOri-angleDeM-deltaRotateAngle1: " + f10 + "; " + this.f47616n + "; " + f11);
        }
        if (this.f47591e1 == 1 || i11 == 0) {
            Log.e("UltraAlg", "This is calFlag = 0 or no change, case: " + i11 + "; " + this.f47591e1);
            if (this.f47619o) {
                this.f47613m = this.f47610l;
                this.f47610l = this.f47607k;
            } else {
                float f13 = f11 / 10.0f;
                this.f47616n = C10628a.m65104s(this.f47616n - (Math.round(f13) * 10.0f));
                Log.e("UltraAlg", "Math.round(sensorGap / 10) * 10: " + (Math.round(f13) * 10.0f));
                this.f47613m = this.f47610l;
                this.f47610l = this.f47607k;
                this.f47607k = Math.abs(this.f47616n);
            }
            Log.e("UltraAlg", "angle_final: " + this.f47616n);
            Log.e("UltraAlg", "angleOri-angleDeM-deltaRotateAngle1: " + f10 + "; " + this.f47616n + "; " + f11);
        }
    }

    /* renamed from: G */
    public float m59709G(float f10) {
        if (Math.abs(f10 - 20.0f) < 0.001d) {
            return 0.0f;
        }
        return f10;
    }

    /* renamed from: H */
    public void m59710H(float f10, float f11) {
        if (this.f47591e1 != 1) {
            if (Math.abs(this.f47616n - 1.0f) < 0.001d) {
                this.f47534J = C10628a.m65101p(this.f47534J, 4, 800.0f);
            } else {
                this.f47534J = C10628a.m65101p(this.f47534J, 4, C10628a.m65086a(f10));
            }
            this.f47537K = C10628a.m65101p(this.f47537K, 4, f11);
        }
    }

    /* renamed from: I */
    public void m59711I(float f10, double d10, double d11, int i10) {
        double d12 = this.f47565U;
        if (d12 < 0.6d) {
            d12 *= 1.2d;
        }
        if (f10 <= 15.0d || d10 >= d11 * d12) {
            this.f47522F++;
        } else {
            this.f47522F = 0;
        }
        if (i10 == 2) {
            this.f47525G++;
        } else {
            this.f47525G = 0;
        }
        if (this.f47522F >= 3) {
            this.f47528H = true;
        }
        if (this.f47525G >= 6) {
            this.f47528H = false;
        }
    }

    /* renamed from: J */
    public void m59712J(long j10, long j11) {
        Log.e("UltraAlg", "tT2-tT1: " + (j11 - j10) + " us");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("tT2Last: ");
        sb2.append(this.f47582b1);
        Log.e("UltraAlg", sb2.toString());
        Log.e("UltraAlg", "tT1Last: " + this.f47579a1);
        if (this.f47585c1 > 1) {
            long j12 = this.f47579a1;
            if ((j10 != j12 && j11 == this.f47582b1) || (j10 == j12 && j11 == this.f47582b1)) {
                this.f47591e1 = 1;
            } else if (j10 == j12 && j11 != this.f47582b1) {
                this.f47591e1 = 2;
            } else if (j10 != j12 && j11 != this.f47582b1) {
                this.f47591e1 = 3;
            }
        }
        Log.e("UltraAlg", "caseNum is: " + this.f47591e1);
        this.f47579a1 = j10;
        this.f47582b1 = j11;
        if (this.f47585c1 <= 1) {
            for (int i10 = 0; i10 < f47500S1; i10++) {
                f47502U1[i10] = this.f47556Q0;
            }
            this.f47562S0 = new C9775a(6, new C10630c.a(), 0.0d);
        }
    }

    /* renamed from: K */
    public void m59713K(float f10, float f11, float f12, float f13) {
        if (Math.abs(f10 - f11) < 0.001d || Math.abs(f10 - f12) < 0.001d) {
            this.f47616n = f13;
        } else {
            this.f47616n = -f13;
        }
    }

    /* renamed from: L */
    public void m59714L(float f10) {
        if (Math.abs(f10) > 5.0f) {
            this.f47510B = false;
        }
    }

    /* renamed from: M */
    public void m59715M(float f10) {
        if (Math.abs(f10 - 1.0f) <= 0.5d) {
            f10 = this.f47616n;
        }
        this.f47616n = f10;
        Log.e("UltraAlg", "angleFinal2: " + f10);
        if (Math.abs(Math.abs(this.f47616n) - 180.0f) < 0.001d) {
            this.f47616n = 180.0f;
        }
    }

    /* renamed from: N */
    public void m59716N() {
        if (Math.abs(this.f47616n) >= 30.0f) {
            this.f47619o = false;
            this.f47640v = true;
            this.f47643w = 0;
        }
    }

    /* renamed from: O */
    public void m59717O(float[] fArr, double d10, double d11) {
        if (this.f47643w >= 4 || !this.f47640v) {
            this.f47616n = 1.0f;
            this.f47619o = true;
            Log.e("UltraAlg", "The first deM fails, prompts the user to rotate. ");
        } else if (this.f47534J.size() >= 1) {
            this.f47616n = Math.round(C10628a.m65104s(fArr[fArr.length - 1]) / 10.0f) * 10.0f;
        } else {
            this.f47616n = this.f47616n;
        }
    }

    /* renamed from: P */
    public void m59718P() {
        if (this.f47510B) {
            return;
        }
        this.f47534J = new CopyOnWriteArrayList<>();
        this.f47537K = new CopyOnWriteArrayList<>();
    }

    /* renamed from: Q */
    public void m59719Q(int i10, float f10, double d10, double d11) {
        if (this.f47591e1 != 1 && i10 != 0) {
            if (Math.abs(f10) > this.f47620o0 || d10 < d11) {
                this.f47507A = 0;
            } else {
                this.f47507A++;
            }
        }
        if (this.f47507A >= 3) {
            this.f47652z = true;
        }
    }

    /* renamed from: R */
    public void m59720R(double d10, double d11) {
        double d12 = this.f47595g.m63738c() >= 14000 ? this.f47608k0 * this.f47565U : this.f47608k0;
        if (d10 >= d11 || d10 <= d12) {
            return;
        }
        this.f47623p0 = true;
    }

    /* renamed from: S */
    public void m59721S(C10350e c10350e) {
        C10349d c10349d = new C10349d();
        c10349d.m63733j(6, c10350e.m63739d(), c10350e.m63738c(), c10350e.m63738c() + c10350e.m63736a(), true);
        this.f47580b = c10349d.m63732i();
        this.f47577a = c10349d.m63731h();
        c10349d.m63733j(6, c10350e.m63739d(), c10350e.m63737b(), c10350e.m63737b() + c10350e.m63736a(), true);
        this.f47586d = c10349d.m63732i();
        this.f47583c = c10349d.m63731h();
        if (this.f47642v1 && this.f47636t1.equals(EnumC10351f.HWTAG.m63742e())) {
            C10350e c10350e2 = new C10350e(48000, 5000, 6000, 8500);
            c10349d.m63733j(6, c10350e2.m63739d(), c10350e2.m63738c(), c10350e2.m63738c() + c10350e2.m63736a(), true);
            this.f47592f = c10349d.m63732i();
            this.f47589e = c10349d.m63731h();
        }
    }

    /* renamed from: a */
    public synchronized C9778d m59722a(C9776b c9776b) {
        try {
            Log.i("UltraAlg", "Begin: " + this.f47595g.toString());
            int actionFlag = c9776b.f48076k.getActionFlag();
            Log.i("UltraAlg", "actionFlag: " + actionFlag + " workFlag: " + this.f47639u1);
            C9778d c9778d = new C9778d();
            boolean z10 = this.f47542L1;
            if (!z10 && actionFlag == 0) {
                this.f47545M1 = 0;
                int i10 = this.f47639u1;
                if (i10 == 2) {
                    this.f47639u1 = 1;
                } else if (i10 == 3) {
                    this.f47639u1 = 0;
                }
                c9778d = m59742v(this.f47639u1, c9776b);
            } else if (!z10 && actionFlag == 1) {
                Log.e("FrequencySwitch", "`Positioning` doubleCheckFlag false,wait change actionFlag ");
                c9778d = m59742v(this.f47639u1, c9776b);
            } else if (!z10 && actionFlag == 2) {
                this.f47545M1 = 0;
                Log.i("FrequencySwitch", "`Positioning` doubleCheckFlag false, change workFlag ");
                int i11 = this.f47639u1;
                if (i11 == 2) {
                    this.f47639u1 = 1;
                } else if (i11 == 3) {
                    this.f47639u1 = 0;
                }
                c9778d = m59742v(this.f47639u1, c9776b);
            } else if (z10) {
                if (actionFlag == 1) {
                    this.f47545M1++;
                    Log.i("FrequencySwitch", "doubleCheckCount: " + this.f47545M1);
                    if (this.f47545M1 >= 20) {
                        Log.i("FrequencySwitch", "doubleCheck failed, change workFlag");
                        int i12 = this.f47639u1;
                        if (i12 == 2) {
                            this.f47639u1 = 0;
                        } else if (i12 == 3) {
                            this.f47639u1 = 1;
                        }
                        this.f47545M1 = 0;
                        this.f47542L1 = false;
                        return m59742v(this.f47639u1, c9776b);
                    }
                }
                this.f47595g = new C10350e(48000, 4000, 14000, 16000);
                this.f47644w0 = C10352g.m63743b().m63751g(this.f47636t1, this.f47627q1, this.f47595g.m63738c());
                m59721S(this.f47595g);
                C9778d c9778dM59706D = m59706D(c9776b);
                this.f47595g = new C10350e(48000, 5000, 6000, 8500);
                this.f47644w0 = C10352g.m63743b().m63751g(this.f47636t1, this.f47627q1, this.f47595g.m63738c());
                m59721S(this.f47595g);
                C9778d c9778dM59706D2 = m59706D(c9776b);
                Log.e("FrequencySwitch", " rssi1418: " + this.f47548N1 + " rssi611: " + this.f47551O1);
                int i13 = this.f47639u1;
                if (i13 == 2) {
                    if (this.f47551O1 < this.f47548N1 * 5.0d) {
                        double d10 = this.f47530H1;
                        if (d10 <= 350.0d || d10 < this.f47533I1 * 3.0d) {
                            Log.i("FrequencySwitch", "res = res1418");
                            c9778d = c9778dM59706D;
                        }
                    }
                    Log.i("FrequencySwitch", "workFlag: " + this.f47639u1 + " maxValue611: " + this.f47530H1 + " maxValue1418: " + this.f47533I1);
                    this.f47542L1 = false;
                    c9778d = c9778dM59706D2;
                } else if (i13 == 3) {
                    if (this.f47551O1 > this.f47548N1 * 3.0d) {
                        double d11 = this.f47533I1;
                        if (d11 <= 350.0d || d11 < this.f47530H1 * 3.0d) {
                            Log.i("FrequencySwitch", "res = res611");
                            c9778d = c9778dM59706D2;
                        }
                    }
                    Log.i("FrequencySwitch", "workFlag: " + this.f47639u1 + " maxValue611: " + this.f47530H1 + " maxValue1418: " + this.f47533I1);
                    this.f47542L1 = false;
                    c9778d = c9778dM59706D;
                }
                Log.e("FrequencySwitch", "Positioning doubleCheckFlag: " + this.f47542L1);
            }
            Log.i("FrequencySwitch", "PositioningResult: " + c9778d.toString());
            return c9778d;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b */
    public void m59723b() {
        Log.e("UltraAlg", " angle Meas initialize... ");
        this.f47599h0 = 23;
        this.f47598h = 0.0f;
        this.f47601i = 0;
        this.f47604j = 0;
        this.f47607k = 0.0f;
        this.f47610l = 0.0f;
        this.f47613m = 0.0f;
        this.f47616n = 0.0f;
        this.f47619o = true;
        this.f47622p = 0;
        this.f47625q = 0;
        this.f47628r = 0;
        this.f47631s = 2;
        this.f47634t = 0;
        this.f47637u = 0;
        this.f47640v = false;
        this.f47643w = 0;
        this.f47531I = new CopyOnWriteArrayList<>();
        this.f47534J = new CopyOnWriteArrayList<>();
        this.f47537K = new CopyOnWriteArrayList<>();
        this.f47646x = 0;
        this.f47649y = 0;
        this.f47652z = false;
        this.f47507A = 0;
        this.f47510B = false;
        this.f47513C = 2;
        this.f47540L = new CopyOnWriteArrayList<>();
        this.f47543M = new CopyOnWriteArrayList<>();
    }

    /* renamed from: c */
    public float m59724c(float f10, boolean z10, float f11) {
        return (Math.abs(f10) - 500.0f <= 0.0f || z10 || f11 - 0.0f <= 0.0f || Math.abs(f11 - f10) <= 3.5f) ? f10 : this.f47600h1;
    }

    /* renamed from: d */
    public FreqParam m59725d(float f10, int i10) {
        FreqParam freqParam = new FreqParam();
        int i11 = this.f47639u1;
        if (i11 == 2 || i11 == 3) {
            if (i10 == 14000) {
                this.f47548N1 = this.f47554P1;
                freqParam = C10352g.m63743b().m63746a(this.f47636t1, 14000);
            } else if (i10 == 6000) {
                this.f47551O1 = this.f47554P1;
                freqParam = C10352g.m63743b().m63746a(this.f47636t1, 6000);
            }
        }
        if (this.f47639u1 == 0) {
            double d10 = f10;
            double d11 = (this.f47645w1 - (0.7d * d10)) * this.f47565U;
            Log.i("FrequencySwitch", " checkFrequencySwitch disCalFinal: " + f10 + " rssiFinalMin: " + this.f47557Q1 + " thrRssih2l: " + d11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" checkFrequencySwitch highToLowCount:");
            sb2.append(this.f47521E1);
            sb2.append(" rssiFinal < thrRssih2l: ");
            sb2.append(this.f47557Q1 < d11);
            Log.i("FrequencySwitch", sb2.toString());
            if (f10 <= 0.0f || this.f47557Q1 > d11 || d10 >= this.f47512B1) {
                this.f47521E1 = 0;
            } else {
                this.f47521E1++;
            }
            freqParam = C10352g.m63743b().m63746a(this.f47636t1, 14000);
            Log.e("FrequencySwitch", " checkFrequencySwitch highToLowCount: " + this.f47521E1 + " disCalFinal: " + f10 + " rssiFinalmin: " + this.f47557Q1);
        }
        if (this.f47639u1 == 1) {
            double d12 = this.f47648x1 * this.f47565U;
            double d13 = this.f47627q1 == 1 ? 1.0d : 0.8d;
            double d14 = f10 < 5.0f ? d13 * 280.0d : d13 * (this.f47651y1 - (12.0f * f10));
            Log.i("FrequencySwitch", " checkFrequencySwitch disCalFinal: " + f10 + " rssiFinalMax: " + this.f47554P1 + " thrRssil2h: " + d14);
            if (f10 <= 0.0f || this.f47554P1 < d14 || f10 >= 15.0f) {
                this.f47524F1 = 0;
            } else {
                this.f47524F1++;
            }
            Log.e("FrequencySwitch", " checkFrequencySwitch lowToHighCount1: " + this.f47524F1 + " disCalFinal: " + f10 + " rssiFinalmax: " + this.f47554P1);
            if (Float.compare(f10, -500.0f) != 0 || this.f47554P1 <= d12) {
                this.f47527G1 = 0;
            } else {
                this.f47527G1++;
            }
            Log.e("FrequencySwitch", " checkFrequencySwitch lowToHighCount2:" + this.f47527G1);
            freqParam = C10352g.m63743b().m63746a(this.f47636t1, 6000);
        }
        if (this.f47539K1.booleanValue() && this.f47627q1 == 1 && f10 <= 1.5d && this.f47554P1 < 800.0d) {
            this.f47524F1 = 0;
            this.f47527G1 = 0;
            this.f47518D1 = 0;
        }
        boolean z10 = this.f47521E1 >= 5 && this.f47515C1 >= 4;
        if (this.f47639u1 == 0 && z10) {
            Log.e("FrequencySwitch", " checkFrequencySwitch high->low");
            Log.e("FrequencySwitch", " checkFrequencySwitch latest disCalFinal:" + f10);
            Log.e("FrequencySwitch", " checkFrequencySwitch latest sigRssi:" + this.f47557Q1);
            this.f47639u1 = 2;
            this.f47521E1 = 0;
            this.f47515C1 = 0;
            this.f47539K1 = Boolean.TRUE;
            freqParam = C10352g.m63743b().m63746a(this.f47636t1, 6000);
            freqParam.setActionFlag(1);
            this.f47542L1 = true;
        }
        boolean z11 = this.f47524F1 >= 5 || this.f47527G1 >= 10 || this.f47518D1 >= 5;
        if (this.f47639u1 == 1 && z11) {
            Log.e("FrequencySwitch", " checkFrequencySwitch low->high");
            Log.e("FrequencySwitch", " checkFrequencySwitch latest disCalFinal:" + f10);
            Log.e("FrequencySwitch", " checkFrequencySwitch latest sigRssi:" + this.f47554P1);
            this.f47639u1 = 3;
            this.f47524F1 = 0;
            this.f47527G1 = 0;
            this.f47518D1 = 0;
            this.f47539K1 = Boolean.FALSE;
            freqParam = C10352g.m63743b().m63746a(this.f47636t1, 14000);
            freqParam.setActionFlag(1);
            this.f47542L1 = true;
        }
        Log.i("FrequencySwitch", " freqParam: " + freqParam.toString());
        return freqParam;
    }

    /* renamed from: e */
    public boolean m59726e(Context context, String str, int i10) throws IOException {
        C10055a.a aVarM62497a = C10055a.m62496i().m62497a(context);
        boolean zM62509e = aVarM62497a.m62509e();
        int iM62507c = aVarM62497a.m62507c();
        int iM62506b = aVarM62497a.m62506b();
        this.f47650y0 = aVarM62497a.m62505a();
        boolean z10 = false;
        if (zM62509e) {
            Log.i("CheckPreciseSearch", "target productId:  " + str + "  sequence: " + i10);
            boolean zM62516b = C10055a.m62496i().m62498b(context, str, i10).m62516b();
            boolean z11 = C10055a.m62496i().m62502f(context, iM62507c) && C10055a.m62496i().m62501e(context, iM62506b);
            if (zM62516b && z11) {
                z10 = true;
            }
            Log.e("CheckPreciseSearch", "isDevicesMatch result: " + zM62516b + "  isOSVerCorrect result: " + z11);
        } else {
            Log.e("CheckPreciseSearch", "isContainInCSV result: false");
        }
        Log.e("CheckPreciseSearch", str + "-" + i10 + " CheckPreciseResult result: " + z10);
        return z10;
    }

    /* renamed from: f */
    public void m59727f(float f10, float[] fArr, int i10, float f11, float f12) {
        if (f10 > 40.0f) {
            this.f47637u++;
            this.f47616n = Math.round(C10628a.m65104s(fArr[fArr.length - 1]) / 10.0f) * 10.0f;
            return;
        }
        this.f47637u = 0;
        if (i10 == 1) {
            if (Math.abs(f11 - 0.0f) < 0.001d) {
                this.f47616n = f11;
            } else if (Math.abs(f10 - f12) < 0.001d) {
                this.f47616n = f11;
            } else {
                this.f47616n = -f11;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x06d0  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x07e7  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x07ed  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p299fw.C9775a m59728g(double[] r55) {
        /*
            Method dump skipped, instructions count: 2138
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p268ew.C9570a.m59728g(double[]):fw.a");
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04ff  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float m59729h(float r24, int r25, double r26, float r28, int r29) {
        /*
            Method dump skipped, instructions count: 2230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p268ew.C9570a.m59729h(float, int, double, float, int):float");
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0666  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float m59730i(int r23, long r24, long r26, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 1920
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p268ew.C9570a.m59730i(int, long, long, int, int):float");
    }

    /* renamed from: j */
    public void m59731j() {
        Log.e("UltraAlg", " dis Meas initialize... ");
        int i10 = f47500S1;
        f47501T1 = new long[i10];
        f47502U1 = new long[i10];
        f47503V1 = new int[i10];
        this.f47579a1 = 0L;
        this.f47582b1 = this.f47556Q0;
        this.f47585c1 = 0;
        this.f47588d1 = 0;
        this.f47591e1 = 3;
        this.f47594f1 = 0;
        this.f47597g1 = -500.0f;
        this.f47600h1 = 0.0f;
        this.f47603i1 = false;
        this.f47609k1 = 0;
        this.f47612l1 = 0.0d;
        this.f47615m1 = 0.0d;
        this.f47618n1 = false;
        this.f47621o1 = 0;
        this.f47624p1 = -500.0f;
    }

    /* renamed from: k */
    public float m59732k(float f10, float f11) {
        if (Math.abs(Math.abs(f10) - 500.0f) < 1.0E-6f) {
            return f10;
        }
        if (this.f47603i1) {
            if (Math.abs(f10 - this.f47600h1) >= 1.0f) {
                float f12 = this.f47600h1;
                f10 = f10 - f12 > 0.0f ? f12 + 1.0f : f12 - 1.0f;
            }
            this.f47600h1 = ((1.0f - f11) * this.f47600h1) + (f11 * f10);
        } else {
            this.f47600h1 = f10;
        }
        this.f47603i1 = true;
        return Math.round(this.f47600h1 * 10.0f) / 10.0f;
    }

    /* renamed from: l */
    public float m59733l(int i10) {
        if (i10 == 0) {
            this.f47621o1++;
        } else {
            this.f47621o1 = 0;
        }
        return this.f47621o1 >= 3 ? 0.2f : 0.5f;
    }

    /* renamed from: m */
    public int m59734m(int i10, int i11, float f10) {
        int i12 = (f10 > 5.0f || f10 <= 0.0f) ? 1 : 2;
        if (i10 == 2) {
            if (i11 != 0 && this.f47591e1 != 1) {
                this.f47622p++;
            }
            this.f47625q = 0;
            this.f47628r = 0;
            if (this.f47622p < 3 * i12) {
                i10 = this.f47631s;
            } else {
                this.f47631s = i10;
            }
        } else if (i10 == 8) {
            if (i11 != 0 && this.f47591e1 != 1) {
                this.f47625q++;
            }
            this.f47622p = 0;
            this.f47628r = 0;
            if (this.f47625q < 3) {
                i10 = this.f47631s;
            } else {
                this.f47631s = i10;
            }
        } else if (i10 == 9) {
            if (i11 != 0 && this.f47591e1 != 1) {
                this.f47628r++;
            }
            this.f47622p = 0;
            this.f47625q = 0;
            if (this.f47628r < 3) {
                i10 = this.f47631s;
            } else {
                this.f47631s = i10;
            }
        } else {
            this.f47631s = i10;
            this.f47622p = 0;
            this.f47625q = 0;
            this.f47628r = 0;
        }
        Log.e("UltraAlg", "flag2Cnt: " + this.f47622p);
        Log.e("UltraAlg", "flag8Cnt: " + this.f47625q);
        Log.e("UltraAlg", "flag9Cnt: " + this.f47628r);
        Log.e("UltraAlg", "dataFlagLast: " + this.f47631s);
        return i10;
    }

    /* renamed from: n */
    public final double m59735n(String str) {
        double dAtan = EnumC10351f.m63740f(this.f47626q0) ? (Math.atan((this.f47555Q - this.f47561S) / (this.f47558R - this.f47563T)) / 3.141592653589793d) * 180.0d : 0.0d;
        if (str.equals("GRL-AL10") && this.f47632s0 == 0) {
            return 90.0d;
        }
        return dAtan;
    }

    /* renamed from: o */
    public int m59736o() {
        if (this.f47591e1 != 1) {
            this.f47516D++;
        }
        int i10 = this.f47516D % 2 != 1 ? 0 : 1;
        Log.e("UltraAlg", "getCalFlag: calCount：" + this.f47516D);
        Log.e("UltraAlg", "getCalFlag: calFlag：" + i10);
        return i10;
    }

    /* renamed from: p */
    public float m59737p(float f10, int i10) {
        if (this.f47540L.size() >= 4) {
            float fM65104s = C10628a.m65104s(this.f47540L.get(i10).floatValue() - this.f47540L.get(i10 - 1).floatValue());
            float fM65104s2 = C10628a.m65104s(this.f47540L.get(i10).floatValue() - this.f47540L.get(i10 - 2).floatValue());
            if (Math.abs(fM65104s) < this.f47546N && Math.abs(fM65104s2) >= this.f47546N) {
                this.f47607k = this.f47610l;
                f10 = fM65104s2;
            }
        }
        if (this.f47540L.size() < 5) {
            return f10;
        }
        float fM65104s3 = C10628a.m65104s(this.f47540L.get(i10).floatValue() - this.f47540L.get(i10 - 1).floatValue());
        float fM65104s4 = C10628a.m65104s(this.f47540L.get(i10).floatValue() - this.f47540L.get(i10 - 2).floatValue());
        float fM65104s5 = C10628a.m65104s(this.f47540L.get(i10).floatValue() - this.f47540L.get(i10 - 3).floatValue());
        if (Math.abs(fM65104s3) >= this.f47546N || Math.abs(fM65104s4) >= this.f47546N || Math.abs(fM65104s5) < this.f47546N) {
            return f10;
        }
        this.f47607k = this.f47613m;
        return fM65104s5;
    }

    /* renamed from: q */
    public double[] m59738q(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return C10630c.m65120k(bArr2);
    }

    /* renamed from: r */
    public int m59739r(int i10, float f10) {
        if (i10 == 1) {
            if (Math.abs(f10) <= 5.0f) {
                this.f47646x++;
            } else {
                this.f47646x = 0;
            }
        }
        return (this.f47646x < this.f47552P || !EnumC10351f.m63740f(this.f47636t1)) ? 3 : 6;
    }

    /* renamed from: s */
    public double m59740s(int i10, float f10) {
        double d10;
        if (this.f47595g.m63738c() >= 14000) {
            this.f47617n0 = 24.0d;
            d10 = 24.0d * this.f47565U;
        } else {
            d10 = 32.0d;
            this.f47617n0 = 32.0d;
        }
        if (i10 == 2 || f10 > 5.0f || f10 <= 0.0f) {
            return d10;
        }
        double d11 = this.f47608k0;
        double d12 = this.f47565U;
        if (d11 * d12 < 5.0d) {
            return 4.0d;
        }
        return d11 * d12;
    }

    /* renamed from: u */
    public int m59741u() {
        return this.f47650y0;
    }

    /* renamed from: v */
    public final C9778d m59742v(int i10, C9776b c9776b) {
        new C9778d();
        if (i10 != 0) {
            if (i10 != 1) {
                Log.e("UltraAlg", "getResult failed");
                return new C9778d(2, new float[]{1.0f, -500.0f}, new FreqParam());
            }
            this.f47644w0 = C10352g.m63743b().m63751g(this.f47636t1, this.f47627q1, 6000);
            Log.e("UltraAlg", "posParam initialize based on: " + this.f47636t1);
            C10350e c10350e = new C10350e(48000, 5000, 6000, 8500);
            this.f47595g = c10350e;
            m59721S(c10350e);
            return m59706D(c9776b);
        }
        if (this.f47636t1.equals(EnumC10351f.HWTAG.m63742e())) {
            this.f47644w0 = C10352g.m63743b().m63751g(this.f47636t1, this.f47627q1, 14000);
            this.f47595g = new C10350e(48000, 4000, 14000, 16000);
        }
        Log.i("UltraAlg", "workFlag: " + this.f47644w0.toString());
        m59721S(this.f47595g);
        Log.i("UltraAlg", "Positioning Begin: " + this.f47595g.toString());
        return m59706D(c9776b);
    }

    /* renamed from: w */
    public float m59743w(float f10) {
        if (Math.abs(f10) <= 20.0f) {
            this.f47649y++;
            return 0.0f;
        }
        this.f47649y = 0;
        return f10;
    }

    /* renamed from: x */
    public float m59744x(float f10) {
        float fFloatValue = 0.0f;
        if (f47504W1.size() < 20) {
            if (Math.abs(f10) - 500.0f >= 1.0E-6d) {
                f47504W1.add(Float.valueOf(f10));
                return 0.0f;
            }
            if (f47504W1.isEmpty()) {
                return 0.0f;
            }
            List<Float> list = f47504W1;
            list.add(list.get(list.size() - 1));
            return 0.0f;
        }
        if (f47504W1.isEmpty()) {
            Log.e("UltraAlg", "hisDis Queue is empty！");
            return -1.0f;
        }
        f47504W1.remove(0);
        f47504W1.add(Float.valueOf(f10));
        for (int i10 = 0; i10 < 20; i10++) {
            fFloatValue += f47504W1.get(i10).floatValue();
        }
        return fFloatValue / 20.0f;
    }

    /* renamed from: y */
    public FreqParam m59745y(C10354i c10354i, Context context) throws IOException {
        Log.i("UltraAlg", "Positioning is initialize... Version_ParameterSinking_TAG 2025-0625");
        this.f47626q0 = c10354i.m63761b();
        this.f47629r0 = c10354i.m63762c();
        this.f47632s0 = c10354i.m63760a();
        Log.i("UltraAlg", "Positioning is initialize... productId:  " + this.f47626q0 + "  sequence: " + this.f47629r0 + "  foldState: " + this.f47632s0);
        C10055a.a aVarM62504h = C10055a.m62496i().m62504h(context, this.f47632s0);
        C10056b c10056bM62508d = aVarM62504h.m62508d();
        this.f47641v0 = c10056bM62508d;
        Map<Integer, List<C10346a>> mapM62519a = c10056bM62508d.m62519a();
        this.f47627q1 = aVarM62504h.m62507c();
        C10055a.b bVarM62498b = C10055a.m62496i().m62498b(context, this.f47626q0, this.f47629r0);
        this.f47596g0 = bVarM62498b.m62515a().m62523b();
        C10346a c10346a = mapM62519a.get(Integer.valueOf(this.f47632s0)).get(0);
        this.f47569W = c10346a.m63708b();
        this.f47571X = c10346a.m63709c();
        this.f47578a0 = c10346a.m63707a();
        C10346a c10346a2 = mapM62519a.get(Integer.valueOf(this.f47632s0)).get(1);
        this.f47573Y = c10346a2.m63708b();
        this.f47575Z = c10346a2.m63709c();
        this.f47581b0 = c10346a2.m63707a();
        C10346a c10346a3 = mapM62519a.get(Integer.valueOf(this.f47632s0)).get(2);
        this.f47555Q = c10346a3.m63708b();
        this.f47558R = c10346a3.m63709c();
        C10346a c10346a4 = mapM62519a.get(Integer.valueOf(this.f47632s0)).get(3);
        this.f47561S = c10346a4.m63708b();
        this.f47563T = c10346a4.m63709c();
        this.f47565U = bVarM62498b.m62515a().m62522a();
        this.f47584c0 = this.f47641v0.m62520b();
        Log.e("UltraAlg", "channelOrder is: " + this.f47584c0);
        int i10 = f47500S1;
        f47501T1 = new long[i10];
        f47502U1 = new long[i10];
        f47503V1 = new int[i10];
        this.f47579a1 = 0L;
        this.f47582b1 = this.f47556Q0;
        this.f47585c1 = 0;
        this.f47588d1 = 0;
        this.f47591e1 = 3;
        this.f47594f1 = 0;
        this.f47597g1 = -500.0f;
        this.f47600h1 = 0.0f;
        this.f47603i1 = false;
        this.f47609k1 = 0;
        this.f47612l1 = 0.0d;
        this.f47615m1 = 0.0d;
        this.f47618n1 = false;
        this.f47602i0 = 3.45E-4f;
        this.f47621o1 = 0;
        this.f47624p1 = -500.0f;
        this.f47560R1 = 0;
        this.f47572X0 = 0.0d;
        this.f47574Y0 = 0.0d;
        this.f47599h0 = 23;
        this.f47598h = 0.0f;
        Log.i("UltraAlg", "xMic1: " + this.f47555Q + " xMic2: " + this.f47561S + " yMic1: " + this.f47558R + " yMic2: " + this.f47563T);
        this.f47519E = m59735n(this.f47641v0.m62521c());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("angleCal: ");
        sb2.append(this.f47519E);
        Log.i("UltraAlg", sb2.toString());
        this.f47601i = 0;
        this.f47604j = 0;
        this.f47607k = 0.0f;
        this.f47610l = 0.0f;
        this.f47613m = 0.0f;
        this.f47616n = 0.0f;
        this.f47619o = true;
        this.f47622p = 0;
        this.f47625q = 0;
        this.f47628r = 0;
        this.f47631s = 2;
        this.f47634t = 0;
        this.f47637u = 0;
        this.f47640v = false;
        this.f47643w = 0;
        this.f47531I = new CopyOnWriteArrayList<>();
        this.f47534J = new CopyOnWriteArrayList<>();
        this.f47537K = new CopyOnWriteArrayList<>();
        this.f47646x = 0;
        this.f47649y = 0;
        this.f47652z = false;
        this.f47507A = 0;
        this.f47510B = false;
        this.f47513C = 2;
        this.f47516D = 0;
        this.f47540L = new CopyOnWriteArrayList<>();
        this.f47543M = new CopyOnWriteArrayList<>();
        this.f47630r1 = 0;
        this.f47633s1 = 0;
        this.f47542L1 = false;
        this.f47639u1 = 0;
        this.f47636t1 = bVarM62498b.m62515a().m62524c().split("-")[0];
        FreqParam freqParamM63746a = C10352g.m63743b().m63746a(this.f47636t1, 14000);
        Log.e("UltraAlg", "freqParam initialize based on: " + this.f47636t1);
        this.f47635t0 = EnumC10351f.m63740f(this.f47626q0) && this.f47629r0 == 0;
        if (this.f47636t1.equals(EnumC10351f.HWTAG.m63742e())) {
            this.f47642v1 = true;
            this.f47539K1 = Boolean.FALSE;
            this.f47536J1 = 0;
            this.f47514C0 = C10352g.m63743b().m63747c(context, this.f47627q1, this.f47636t1, 14000);
            this.f47517D0 = C10352g.m63743b().m63749e(context, this.f47627q1, this.f47636t1, 14000);
            this.f47520E0 = C10352g.m63743b().m63748d(context, this.f47627q1, this.f47636t1, 14000);
            if (this.f47642v1) {
                this.f47653z0 = C10352g.m63743b().m63747c(context, this.f47627q1, this.f47636t1, 6000);
                this.f47508A0 = C10352g.m63743b().m63749e(context, this.f47627q1, this.f47636t1, 6000);
                this.f47511B0 = C10352g.m63743b().m63748d(context, this.f47627q1, this.f47636t1, 6000);
            }
        } else if (EnumC10351f.m63740f(this.f47636t1)) {
            this.f47642v1 = false;
            Iterator it = EnumSet.of(EnumC10351f.PIANO, EnumC10351f.DOVE, EnumC10351f.PIANOP, EnumC10351f.HARPER).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EnumC10351f enumC10351f = (EnumC10351f) it.next();
                if (enumC10351f.m63742e().equals(this.f47636t1)) {
                    this.f47638u0 = enumC10351f;
                    break;
                }
            }
            Log.e("UltraAlg", " originalSigLp initialize based on: " + this.f47636t1);
            this.f47514C0 = C10352g.m63743b().m63747c(context, this.f47627q1, this.f47636t1, this.f47638u0.m63741b());
            this.f47517D0 = C10352g.m63743b().m63749e(context, this.f47627q1, this.f47636t1, this.f47638u0.m63741b());
            this.f47520E0 = C10352g.m63743b().m63748d(context, this.f47627q1, this.f47636t1, this.f47638u0.m63741b());
        }
        Log.i("UltraAlg", "gMic1: " + this.f47565U);
        if (this.f47642v1) {
            this.f47532I0 = C10353h.m63759h(this.f47517D0, this.f47520E0);
            this.f47595g = new C10350e(48000, 4000, 14000, 16000);
            this.f47644w0 = C10352g.m63743b().m63751g(this.f47636t1, this.f47627q1, this.f47595g.m63738c());
            Log.i("UltraAlg", "posParam initialize based on: " + this.f47636t1);
            int iM60834b = this.f47644w0.m60834b();
            C10347b[] c10347bArrM65128s = C10630c.m65128s(this.f47647x0);
            this.f47535J0 = c10347bArrM65128s;
            System.arraycopy(this.f47532I0, 0, c10347bArrM65128s, 0, iM60834b);
            this.f47535J0 = C10629b.m65106a(this.f47535J0);
            C10347b[] c10347bArrM65128s2 = C10630c.m65128s(this.f47647x0);
            this.f47538K0 = c10347bArrM65128s2;
            System.arraycopy(this.f47532I0, 0, c10347bArrM65128s2, 0, iM60834b);
            this.f47538K0 = C10629b.m65106a(this.f47538K0);
            this.f47541L0 = C10353h.m63759h(this.f47508A0, this.f47511B0);
            this.f47595g = new C10350e(48000, 5000, 6000, 8500);
            this.f47644w0 = C10352g.m63743b().m63751g(this.f47636t1, this.f47627q1, this.f47595g.m63738c());
            Log.i("UltraAlg", "posParam initialize based on: " + this.f47636t1);
            int iM60834b2 = this.f47644w0.m60834b();
            C10347b[] c10347bArrM65128s3 = C10630c.m65128s(this.f47647x0);
            this.f47544M0 = c10347bArrM65128s3;
            System.arraycopy(this.f47541L0, 0, c10347bArrM65128s3, 0, iM60834b2);
            this.f47544M0 = C10629b.m65106a(this.f47544M0);
            C10347b[] c10347bArrM65128s4 = C10630c.m65128s(this.f47647x0);
            this.f47547N0 = c10347bArrM65128s4;
            System.arraycopy(this.f47541L0, 0, c10347bArrM65128s4, 0, iM60834b2);
            this.f47547N0 = C10629b.m65106a(this.f47547N0);
        } else {
            this.f47523F0 = C10353h.m63759h(this.f47517D0, this.f47520E0);
            this.f47595g = new C10350e(48000, 4000, this.f47638u0.m63741b(), this.f47638u0.m63741b() + 2000);
            this.f47644w0 = C10352g.m63743b().m63751g(this.f47636t1, this.f47627q1, this.f47595g.m63738c());
            Log.i("UltraAlg", "posParam initialize based on: " + this.f47636t1);
            int iM60834b3 = this.f47644w0.m60834b();
            C10347b[] c10347bArrM65128s5 = C10630c.m65128s(this.f47647x0);
            this.f47526G0 = c10347bArrM65128s5;
            System.arraycopy(this.f47523F0, 0, c10347bArrM65128s5, 0, iM60834b3);
            this.f47526G0 = C10629b.m65106a(this.f47526G0);
            C10347b[] c10347bArrM65128s6 = C10630c.m65128s(this.f47647x0);
            this.f47529H0 = c10347bArrM65128s6;
            System.arraycopy(this.f47523F0, 0, c10347bArrM65128s6, 0, iM60834b3);
            this.f47529H0 = C10629b.m65106a(this.f47529H0);
        }
        if (this.f47644w0.m60837e() == 680) {
            this.f47576Z0 = 600;
        } else {
            this.f47576Z0 = 300;
        }
        Log.i("UltraAlg", "Init: " + this.f47644w0.toString());
        return freqParamM63746a;
    }

    /* renamed from: z */
    public final void m59746z(double[] dArr, double[] dArr2, int i10) {
        double d10;
        double dMax;
        double d11;
        double d12;
        double dAbs;
        int i11;
        int i12 = this.f47639u1;
        if (i12 == 0) {
            int i13 = 0;
            double dMax2 = 0.0d;
            double dMax3 = 0.0d;
            double dMax4 = 0.0d;
            while (i13 < 3) {
                int i14 = (2400 * i13) + 12480;
                double dAbs2 = 0.0d;
                double dAbs3 = 0.0d;
                while (true) {
                    i11 = i13 + 1;
                    if (i14 < 12480 + (2400 * i11)) {
                        dAbs2 += Math.abs(dArr[i14]);
                        dAbs3 += Math.abs(dArr2[i14]);
                        i14++;
                    }
                }
                double d13 = 2400;
                double d14 = dAbs2 / d13;
                dMax3 = Math.max(d14, dMax3);
                double d15 = dAbs3 / d13;
                dMax4 = Math.max(d15, dMax4);
                Log.i("FrequencySwitch", "sigPowMean1: " + d14 + " sigPowMean2: " + d15);
                dMax2 = Math.max(dMax3, dMax4);
                i13 = i11;
            }
            double d16 = this.f47654z1;
            Log.i("FrequencySwitch", "611sigInterfereH2LPowMean1: " + dMax3 + " 611sigInterfereH2LPowMean2: " + dMax4);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sigPowMean: ");
            sb2.append(dMax2);
            sb2.append(" thrH2L: ");
            sb2.append(d16);
            sb2.append(" sigPowMean < thrH2L: ");
            sb2.append(dMax2 < d16);
            Log.i("FrequencySwitch", sb2.toString());
            if (dMax2 < d16) {
                this.f47515C1++;
            } else {
                this.f47515C1 = 0;
            }
            Log.i("FrequencySwitch", "interfere-611H2LCount: " + this.f47515C1);
            return;
        }
        if (i12 == 1) {
            int i15 = i10 + ConnectionResult.NETWORK_ERROR;
            int i16 = i10 + 11400;
            int iMin = Math.min(i16, dArr.length);
            if (i16 <= dArr.length) {
                double dAbs4 = 0.0d;
                for (int i17 = i15; i17 < iMin; i17++) {
                    dAbs4 += Math.abs(dArr[i17]);
                }
                double dAbs5 = 0.0d;
                for (int i18 = i15; i18 < iMin; i18++) {
                    dAbs5 += Math.abs(dArr2[i18]);
                }
                double d17 = iMin - i15;
                d10 = dAbs4 / d17;
                dMax = dAbs5 / d17;
            } else {
                d10 = 0.0d;
                dMax = 0.0d;
            }
            Log.i("FrequencySwitch", "9000  sigPowMean1: " + d10 + " sigPowMean2: " + dMax);
            int i19 = i10 + (-7000);
            int iMax = Math.max(i19, 0);
            int i20 = iMax + 2400;
            if (i19 >= 0) {
                double dAbs6 = 0.0d;
                for (int i21 = iMax; i21 < i20; i21++) {
                    dAbs6 += Math.abs(dArr[i21]);
                }
                dAbs = 0.0d;
                for (int i22 = iMax; i22 < i20; i22++) {
                    dAbs += Math.abs(dArr2[i22]);
                }
                double d18 = i20 - iMax;
                double dMax5 = Math.max(d10, dAbs6 / d18);
                dMax = Math.max(dMax, dAbs / d18);
                d11 = dMax5;
                d12 = dAbs6;
            } else {
                d11 = d10;
                d12 = 0.0d;
                dAbs = 0.0d;
            }
            double d19 = i20 - iMax;
            double dMax6 = Math.max(d11, dMax);
            Log.i("FrequencySwitch", "7000  sigPowMean1: " + (d12 / d19) + " sigPowMean2: " + (dAbs / d19));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("sigPowMean: ");
            sb3.append(dMax6);
            Log.i("FrequencySwitch", sb3.toString());
            Log.i("FrequencySwitch", "611sigInterfereL2HPowMean1: " + d11 + " 611sigInterfereL2HPowMean2: " + dMax);
            if (dMax6 > this.f47509A1) {
                this.f47518D1++;
            } else {
                this.f47518D1 = 0;
            }
            Log.i("FrequencySwitch", "interf611L2HCount: " + this.f47518D1);
        }
    }
}
