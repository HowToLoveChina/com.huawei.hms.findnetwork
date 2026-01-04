package p642t;

import android.view.View;
import androidx.constraintlayout.widget.C0583a;
import androidx.constraintlayout.widget.C0585c;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Arrays;
import java.util.LinkedHashMap;
import p504o.C11770c;

/* renamed from: t.o */
/* loaded from: classes.dex */
public class C12910o implements Comparable<C12910o> {

    /* renamed from: t */
    public static String[] f58859t = {"position", Constants.MULTIPLE_SIGN, "y", "width", "height", "pathRotate"};

    /* renamed from: a */
    public C11770c f58860a;

    /* renamed from: c */
    public float f58862c;

    /* renamed from: d */
    public float f58863d;

    /* renamed from: e */
    public float f58864e;

    /* renamed from: f */
    public float f58865f;

    /* renamed from: g */
    public float f58866g;

    /* renamed from: h */
    public float f58867h;

    /* renamed from: k */
    public int f58870k;

    /* renamed from: l */
    public int f58871l;

    /* renamed from: m */
    public float f58872m;

    /* renamed from: n */
    public C12908m f58873n;

    /* renamed from: o */
    public LinkedHashMap<String, C0583a> f58874o;

    /* renamed from: p */
    public int f58875p;

    /* renamed from: q */
    public int f58876q;

    /* renamed from: r */
    public double[] f58877r;

    /* renamed from: s */
    public double[] f58878s;

    /* renamed from: b */
    public int f58861b = 0;

    /* renamed from: i */
    public float f58868i = Float.NaN;

    /* renamed from: j */
    public float f58869j = Float.NaN;

    public C12910o() {
        int i10 = AbstractC12899d.f58688f;
        this.f58870k = i10;
        this.f58871l = i10;
        this.f58872m = Float.NaN;
        this.f58873n = null;
        this.f58874o = new LinkedHashMap<>();
        this.f58875p = 0;
        this.f58877r = new double[18];
        this.f58878s = new double[18];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: A */
    public void m77516A(float f10, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z10) {
        float f11;
        float f12;
        float f13 = this.f58864e;
        float f14 = this.f58865f;
        float f15 = this.f58866g;
        float f16 = this.f58867h;
        if (iArr.length != 0 && this.f58877r.length <= iArr[iArr.length - 1]) {
            int i10 = iArr[iArr.length - 1] + 1;
            this.f58877r = new double[i10];
            this.f58878s = new double[i10];
        }
        Arrays.fill(this.f58877r, Double.NaN);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            double[] dArr4 = this.f58877r;
            int i12 = iArr[i11];
            dArr4[i12] = dArr[i11];
            this.f58878s[i12] = dArr2[i11];
        }
        float f17 = Float.NaN;
        int i13 = 0;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        while (true) {
            double[] dArr5 = this.f58877r;
            if (i13 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i13]) && (dArr3 == null || dArr3[i13] == 0.0d)) {
                f12 = f17;
            } else {
                double d10 = dArr3 != null ? dArr3[i13] : 0.0d;
                if (!Double.isNaN(this.f58877r[i13])) {
                    d10 = this.f58877r[i13] + d10;
                }
                f12 = f17;
                float f22 = (float) d10;
                float f23 = (float) this.f58878s[i13];
                if (i13 == 1) {
                    f17 = f12;
                    f13 = f22;
                    f18 = f23;
                } else if (i13 == 2) {
                    f17 = f12;
                    f14 = f22;
                    f19 = f23;
                } else if (i13 == 3) {
                    f17 = f12;
                    f15 = f22;
                    f20 = f23;
                } else if (i13 == 4) {
                    f17 = f12;
                    f16 = f22;
                    f21 = f23;
                } else if (i13 == 5) {
                    f17 = f22;
                }
                i13++;
            }
            f17 = f12;
            i13++;
        }
        float f24 = f17;
        C12908m c12908m = this.f58873n;
        if (c12908m != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            c12908m.m77499i(f10, fArr, fArr2);
            float f25 = fArr[0];
            float f26 = fArr[1];
            float f27 = fArr2[0];
            float f28 = fArr2[1];
            double d11 = f13;
            double d12 = f14;
            float fSin = (float) ((f25 + (Math.sin(d12) * d11)) - (f15 / 2.0f));
            f11 = f16;
            float fCos = (float) ((f26 - (Math.cos(d12) * d11)) - (f16 / 2.0f));
            double d13 = f18;
            double d14 = f19;
            float fSin2 = (float) (f27 + (Math.sin(d12) * d13) + (Math.cos(d12) * d11 * d14));
            float fCos2 = (float) ((f28 - (d13 * Math.cos(d12))) + (d11 * Math.sin(d12) * d14));
            if (dArr2.length >= 2) {
                dArr2[0] = fSin2;
                dArr2[1] = fCos2;
            }
            if (!Float.isNaN(f24)) {
                view.setRotation((float) (f24 + Math.toDegrees(Math.atan2(fCos2, fSin2))));
            }
            f13 = fSin;
            f14 = fCos;
        } else {
            f11 = f16;
            if (!Float.isNaN(f24)) {
                view.setRotation(f24 + ((float) Math.toDegrees(Math.atan2(f19 + (f21 / 2.0f), f18 + (f20 / 2.0f)))) + 0.0f);
            }
        }
        if (view instanceof InterfaceC12898c) {
            ((InterfaceC12898c) view).mo3545a(f13, f14, f15 + f13, f14 + f11);
            return;
        }
        float f29 = f13 + 0.5f;
        int i14 = (int) f29;
        float f30 = f14 + 0.5f;
        int i15 = (int) f30;
        int i16 = (int) (f29 + f15);
        int i17 = (int) (f30 + f11);
        int i18 = i16 - i14;
        int i19 = i17 - i15;
        if (i18 != view.getMeasuredWidth() || i19 != view.getMeasuredHeight() || z10) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
        }
        view.layout(i14, i15, i16, i17);
    }

    /* renamed from: B */
    public void m77517B(C12908m c12908m, C12910o c12910o) {
        double d10 = ((this.f58864e + (this.f58866g / 2.0f)) - c12910o.f58864e) - (c12910o.f58866g / 2.0f);
        double d11 = ((this.f58865f + (this.f58867h / 2.0f)) - c12910o.f58865f) - (c12910o.f58867h / 2.0f);
        this.f58873n = c12908m;
        this.f58864e = (float) Math.hypot(d11, d10);
        if (Float.isNaN(this.f58872m)) {
            this.f58865f = (float) (Math.atan2(d11, d10) + 1.5707963267948966d);
        } else {
            this.f58865f = (float) Math.toRadians(this.f58872m);
        }
    }

    /* renamed from: a */
    public void m77518a(C0585c.a aVar) {
        this.f58860a = C11770c.m70116c(aVar.f3108d.f3199d);
        C0585c.c cVar = aVar.f3108d;
        this.f58870k = cVar.f3200e;
        this.f58871l = cVar.f3197b;
        this.f58868i = cVar.f3204i;
        this.f58861b = cVar.f3201f;
        this.f58876q = cVar.f3198c;
        this.f58869j = aVar.f3107c.f3214e;
        this.f58872m = aVar.f3109e.f3129D;
        for (String str : aVar.f3111g.keySet()) {
            C0583a c0583a = aVar.f3111g.get(str);
            if (c0583a != null && c0583a.m3591g()) {
                this.f58874o.put(str, c0583a);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(C12910o c12910o) {
        return Float.compare(this.f58863d, c12910o.f58863d);
    }

    /* renamed from: e */
    public final boolean m77520e(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) != Float.isNaN(f11) : Math.abs(f10 - f11) > 1.0E-6f;
    }

    /* renamed from: f */
    public void m77521f(C12910o c12910o, boolean[] zArr, String[] strArr, boolean z10) {
        boolean zM77520e = m77520e(this.f58864e, c12910o.f58864e);
        boolean zM77520e2 = m77520e(this.f58865f, c12910o.f58865f);
        zArr[0] = zArr[0] | m77520e(this.f58863d, c12910o.f58863d);
        boolean z11 = zM77520e | zM77520e2 | z10;
        zArr[1] = zArr[1] | z11;
        zArr[2] = z11 | zArr[2];
        zArr[3] = zArr[3] | m77520e(this.f58866g, c12910o.f58866g);
        zArr[4] = m77520e(this.f58867h, c12910o.f58867h) | zArr[4];
    }

    /* renamed from: h */
    public void m77522h(double[] dArr, int[] iArr) {
        float[] fArr = {this.f58863d, this.f58864e, this.f58865f, this.f58866g, this.f58867h, this.f58868i};
        int i10 = 0;
        for (int i11 : iArr) {
            if (i11 < 6) {
                dArr[i10] = fArr[r1];
                i10++;
            }
        }
    }

    /* renamed from: i */
    public void m77523i(double d10, int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f58864e;
        float fCos = this.f58865f;
        float f11 = this.f58866g;
        float f12 = this.f58867h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f13 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f13;
            } else if (i12 == 2) {
                fCos = f13;
            } else if (i12 == 3) {
                f11 = f13;
            } else if (i12 == 4) {
                f12 = f13;
            }
        }
        C12908m c12908m = this.f58873n;
        if (c12908m != null) {
            float[] fArr2 = new float[2];
            c12908m.m77499i(d10, fArr2, new float[2]);
            float f14 = fArr2[0];
            float f15 = fArr2[1];
            double d11 = f10;
            double d12 = fCos;
            float fSin = (float) ((f14 + (Math.sin(d12) * d11)) - (f11 / 2.0f));
            fCos = (float) ((f15 - (d11 * Math.cos(d12))) - (f12 / 2.0f));
            f10 = fSin;
        }
        fArr[i10] = f10 + (f11 / 2.0f) + 0.0f;
        fArr[i10 + 1] = fCos + (f12 / 2.0f) + 0.0f;
    }

    /* renamed from: k */
    public void m77524k(double d10, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f10;
        float f11;
        float f12 = this.f58864e;
        float f13 = this.f58865f;
        float f14 = this.f58866g;
        float f15 = this.f58867h;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f20 = (float) dArr[i10];
            float f21 = (float) dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f12 = f20;
                f16 = f21;
            } else if (i11 == 2) {
                f13 = f20;
                f18 = f21;
            } else if (i11 == 3) {
                f14 = f20;
                f17 = f21;
            } else if (i11 == 4) {
                f15 = f20;
                f19 = f21;
            }
        }
        float f22 = (f17 / 2.0f) + f16;
        float fCos = (f19 / 2.0f) + f18;
        C12908m c12908m = this.f58873n;
        if (c12908m != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            c12908m.m77499i(d10, fArr3, fArr4);
            float f23 = fArr3[0];
            float f24 = fArr3[1];
            float f25 = fArr4[0];
            float f26 = fArr4[1];
            double d11 = f12;
            double d12 = f13;
            f10 = f14;
            float fSin = (float) ((f23 + (Math.sin(d12) * d11)) - (f14 / 2.0f));
            float fCos2 = (float) ((f24 - (d11 * Math.cos(d12))) - (f15 / 2.0f));
            double d13 = f16;
            double d14 = f18;
            float fSin2 = (float) (f25 + (Math.sin(d12) * d13) + (Math.cos(d12) * d14));
            fCos = (float) ((f26 - (d13 * Math.cos(d12))) + (Math.sin(d12) * d14));
            f12 = fSin;
            f13 = fCos2;
            f22 = fSin2;
            f11 = 2.0f;
        } else {
            f10 = f14;
            f11 = 2.0f;
        }
        fArr[0] = f12 + (f10 / f11) + 0.0f;
        fArr[1] = f13 + (f15 / f11) + 0.0f;
        fArr2[0] = f22;
        fArr2[1] = fCos;
    }

    /* renamed from: p */
    public int m77525p(String str, double[] dArr, int i10) {
        C0583a c0583a = this.f58874o.get(str);
        int i11 = 0;
        if (c0583a == null) {
            return 0;
        }
        if (c0583a.m3592h() == 1) {
            dArr[i10] = c0583a.m3589e();
            return 1;
        }
        int iM3592h = c0583a.m3592h();
        c0583a.m3590f(new float[iM3592h]);
        while (i11 < iM3592h) {
            dArr[i10] = r1[i11];
            i11++;
            i10++;
        }
        return iM3592h;
    }

    /* renamed from: q */
    public int m77526q(String str) {
        C0583a c0583a = this.f58874o.get(str);
        if (c0583a == null) {
            return 0;
        }
        return c0583a.m3592h();
    }

    /* renamed from: r */
    public void m77527r(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f58864e;
        float fCos = this.f58865f;
        float f11 = this.f58866g;
        float f12 = this.f58867h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f13 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f13;
            } else if (i12 == 2) {
                fCos = f13;
            } else if (i12 == 3) {
                f11 = f13;
            } else if (i12 == 4) {
                f12 = f13;
            }
        }
        C12908m c12908m = this.f58873n;
        if (c12908m != null) {
            float fM77500j = c12908m.m77500j();
            float fM77501k = this.f58873n.m77501k();
            double d10 = f10;
            double d11 = fCos;
            float fSin = (float) ((fM77500j + (Math.sin(d11) * d10)) - (f11 / 2.0f));
            fCos = (float) ((fM77501k - (d10 * Math.cos(d11))) - (f12 / 2.0f));
            f10 = fSin;
        }
        float f14 = f11 + f10;
        float f15 = f12 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i10] = f10 + 0.0f;
        fArr[i10 + 1] = fCos + 0.0f;
        fArr[i10 + 2] = f14 + 0.0f;
        fArr[i10 + 3] = fCos + 0.0f;
        fArr[i10 + 4] = f14 + 0.0f;
        fArr[i10 + 5] = f15 + 0.0f;
        fArr[i10 + 6] = f10 + 0.0f;
        fArr[i10 + 7] = f15 + 0.0f;
    }

    /* renamed from: s */
    public boolean m77528s(String str) {
        return this.f58874o.containsKey(str);
    }

    /* renamed from: t */
    public void m77529t(C12903h c12903h, C12910o c12910o, C12910o c12910o2) {
        float f10 = c12903h.f58689a / 100.0f;
        this.f58862c = f10;
        this.f58861b = c12903h.f58737j;
        float f11 = Float.isNaN(c12903h.f58738k) ? f10 : c12903h.f58738k;
        float f12 = Float.isNaN(c12903h.f58739l) ? f10 : c12903h.f58739l;
        float f13 = c12910o2.f58866g;
        float f14 = c12910o.f58866g;
        float f15 = f13 - f14;
        float f16 = c12910o2.f58867h;
        float f17 = c12910o.f58867h;
        float f18 = f16 - f17;
        this.f58863d = this.f58862c;
        float f19 = (f14 / 2.0f) + c12910o.f58864e;
        float f20 = c12910o.f58865f + (f17 / 2.0f);
        float f21 = c12910o2.f58864e + (f13 / 2.0f);
        float f22 = c12910o2.f58865f + (f16 / 2.0f);
        if (f19 > f21) {
            f19 = f21;
            f21 = f19;
        }
        if (f20 <= f22) {
            f20 = f22;
            f22 = f20;
        }
        float f23 = f21 - f19;
        float f24 = f20 - f22;
        float f25 = (f15 * f11) / 2.0f;
        this.f58864e = (int) ((r13 + (f23 * f10)) - f25);
        float f26 = (f18 * f12) / 2.0f;
        this.f58865f = (int) ((r1 + (f24 * f10)) - f26);
        this.f58866g = (int) (f14 + r9);
        this.f58867h = (int) (f17 + r12);
        float f27 = Float.isNaN(c12903h.f58740m) ? f10 : c12903h.f58740m;
        float f28 = Float.isNaN(c12903h.f58743p) ? 0.0f : c12903h.f58743p;
        if (!Float.isNaN(c12903h.f58741n)) {
            f10 = c12903h.f58741n;
        }
        float f29 = Float.isNaN(c12903h.f58742o) ? 0.0f : c12903h.f58742o;
        this.f58875p = 0;
        this.f58864e = (int) (((c12910o.f58864e + (f27 * f23)) + (f29 * f24)) - f25);
        this.f58865f = (int) (((c12910o.f58865f + (f23 * f28)) + (f24 * f10)) - f26);
        this.f58860a = C11770c.m70116c(c12903h.f58735h);
        this.f58870k = c12903h.f58736i;
    }

    /* renamed from: u */
    public void m77530u(C12903h c12903h, C12910o c12910o, C12910o c12910o2) {
        float f10 = c12903h.f58689a / 100.0f;
        this.f58862c = f10;
        this.f58861b = c12903h.f58737j;
        float f11 = Float.isNaN(c12903h.f58738k) ? f10 : c12903h.f58738k;
        float f12 = Float.isNaN(c12903h.f58739l) ? f10 : c12903h.f58739l;
        float f13 = c12910o2.f58866g;
        float f14 = c12910o.f58866g;
        float f15 = c12910o2.f58867h;
        float f16 = c12910o.f58867h;
        this.f58863d = this.f58862c;
        float f17 = c12910o.f58864e;
        float f18 = c12910o.f58865f;
        float f19 = (c12910o2.f58864e + (f13 / 2.0f)) - ((f14 / 2.0f) + f17);
        float f20 = (c12910o2.f58865f + (f15 / 2.0f)) - (f18 + (f16 / 2.0f));
        float f21 = ((f13 - f14) * f11) / 2.0f;
        this.f58864e = (int) ((f17 + (f19 * f10)) - f21);
        float f22 = ((f15 - f16) * f12) / 2.0f;
        this.f58865f = (int) ((f18 + (f20 * f10)) - f22);
        this.f58866g = (int) (f14 + r9);
        this.f58867h = (int) (f16 + r12);
        float f23 = Float.isNaN(c12903h.f58740m) ? f10 : c12903h.f58740m;
        float f24 = Float.isNaN(c12903h.f58743p) ? 0.0f : c12903h.f58743p;
        if (!Float.isNaN(c12903h.f58741n)) {
            f10 = c12903h.f58741n;
        }
        float f25 = Float.isNaN(c12903h.f58742o) ? 0.0f : c12903h.f58742o;
        this.f58875p = 0;
        this.f58864e = (int) (((c12910o.f58864e + (f23 * f19)) + (f25 * f20)) - f21);
        this.f58865f = (int) (((c12910o.f58865f + (f19 * f24)) + (f20 * f10)) - f22);
        this.f58860a = C11770c.m70116c(c12903h.f58735h);
        this.f58870k = c12903h.f58736i;
    }

    /* renamed from: v */
    public void m77531v(C12903h c12903h, C12910o c12910o, C12910o c12910o2) {
        float f10 = c12903h.f58689a / 100.0f;
        this.f58862c = f10;
        this.f58861b = c12903h.f58737j;
        float f11 = Float.isNaN(c12903h.f58738k) ? f10 : c12903h.f58738k;
        float f12 = Float.isNaN(c12903h.f58739l) ? f10 : c12903h.f58739l;
        float f13 = c12910o2.f58866g - c12910o.f58866g;
        float f14 = c12910o2.f58867h - c12910o.f58867h;
        this.f58863d = this.f58862c;
        if (!Float.isNaN(c12903h.f58740m)) {
            f10 = c12903h.f58740m;
        }
        float f15 = c12910o.f58864e;
        float f16 = c12910o.f58866g;
        float f17 = c12910o.f58865f;
        float f18 = c12910o.f58867h;
        float f19 = (c12910o2.f58864e + (c12910o2.f58866g / 2.0f)) - ((f16 / 2.0f) + f15);
        float f20 = (c12910o2.f58865f + (c12910o2.f58867h / 2.0f)) - ((f18 / 2.0f) + f17);
        float f21 = f19 * f10;
        float f22 = (f13 * f11) / 2.0f;
        this.f58864e = (int) ((f15 + f21) - f22);
        float f23 = f10 * f20;
        float f24 = (f14 * f12) / 2.0f;
        this.f58865f = (int) ((f17 + f23) - f24);
        this.f58866g = (int) (f16 + r7);
        this.f58867h = (int) (f18 + r8);
        float f25 = Float.isNaN(c12903h.f58741n) ? 0.0f : c12903h.f58741n;
        this.f58875p = 1;
        float f26 = (int) ((c12910o.f58864e + f21) - f22);
        float f27 = (int) ((c12910o.f58865f + f23) - f24);
        this.f58864e = f26 + ((-f20) * f25);
        this.f58865f = f27 + (f19 * f25);
        this.f58871l = this.f58871l;
        this.f58860a = C11770c.m70116c(c12903h.f58735h);
        this.f58870k = c12903h.f58736i;
    }

    /* renamed from: w */
    public void m77532w(int i10, int i11, C12903h c12903h, C12910o c12910o, C12910o c12910o2) {
        float fMin;
        float f10;
        float f11 = c12903h.f58689a / 100.0f;
        this.f58862c = f11;
        this.f58861b = c12903h.f58737j;
        this.f58875p = c12903h.f58744q;
        float f12 = Float.isNaN(c12903h.f58738k) ? f11 : c12903h.f58738k;
        float f13 = Float.isNaN(c12903h.f58739l) ? f11 : c12903h.f58739l;
        float f14 = c12910o2.f58866g;
        float f15 = c12910o.f58866g;
        float f16 = c12910o2.f58867h;
        float f17 = c12910o.f58867h;
        this.f58863d = this.f58862c;
        this.f58866g = (int) (f15 + ((f14 - f15) * f12));
        this.f58867h = (int) (f17 + ((f16 - f17) * f13));
        if (c12903h.f58744q != 2) {
            float f18 = Float.isNaN(c12903h.f58740m) ? f11 : c12903h.f58740m;
            float f19 = c12910o2.f58864e;
            float f20 = c12910o.f58864e;
            this.f58864e = (f18 * (f19 - f20)) + f20;
            if (!Float.isNaN(c12903h.f58741n)) {
                f11 = c12903h.f58741n;
            }
            float f21 = c12910o2.f58865f;
            float f22 = c12910o.f58865f;
            this.f58865f = (f11 * (f21 - f22)) + f22;
        } else {
            if (Float.isNaN(c12903h.f58740m)) {
                float f23 = c12910o2.f58864e;
                float f24 = c12910o.f58864e;
                fMin = ((f23 - f24) * f11) + f24;
            } else {
                fMin = Math.min(f13, f12) * c12903h.f58740m;
            }
            this.f58864e = fMin;
            if (Float.isNaN(c12903h.f58741n)) {
                float f25 = c12910o2.f58865f;
                float f26 = c12910o.f58865f;
                f10 = (f11 * (f25 - f26)) + f26;
            } else {
                f10 = c12903h.f58741n;
            }
            this.f58865f = f10;
        }
        this.f58871l = c12910o.f58871l;
        this.f58860a = C11770c.m70116c(c12903h.f58735h);
        this.f58870k = c12903h.f58736i;
    }

    /* renamed from: x */
    public void m77533x(int i10, int i11, C12903h c12903h, C12910o c12910o, C12910o c12910o2) {
        float f10 = c12903h.f58689a / 100.0f;
        this.f58862c = f10;
        this.f58861b = c12903h.f58737j;
        float f11 = Float.isNaN(c12903h.f58738k) ? f10 : c12903h.f58738k;
        float f12 = Float.isNaN(c12903h.f58739l) ? f10 : c12903h.f58739l;
        float f13 = c12910o2.f58866g;
        float f14 = c12910o.f58866g;
        float f15 = c12910o2.f58867h;
        float f16 = c12910o.f58867h;
        this.f58863d = this.f58862c;
        float f17 = c12910o.f58864e;
        float f18 = c12910o.f58865f;
        float f19 = c12910o2.f58864e + (f13 / 2.0f);
        float f20 = c12910o2.f58865f + (f15 / 2.0f);
        float f21 = (f13 - f14) * f11;
        this.f58864e = (int) ((f17 + ((f19 - ((f14 / 2.0f) + f17)) * f10)) - (f21 / 2.0f));
        float f22 = (f15 - f16) * f12;
        this.f58865f = (int) ((f18 + ((f20 - (f18 + (f16 / 2.0f))) * f10)) - (f22 / 2.0f));
        this.f58866g = (int) (f14 + f21);
        this.f58867h = (int) (f16 + f22);
        this.f58875p = 2;
        if (!Float.isNaN(c12903h.f58740m)) {
            this.f58864e = (int) (c12903h.f58740m * (i10 - ((int) this.f58866g)));
        }
        if (!Float.isNaN(c12903h.f58741n)) {
            this.f58865f = (int) (c12903h.f58741n * (i11 - ((int) this.f58867h)));
        }
        this.f58871l = this.f58871l;
        this.f58860a = C11770c.m70116c(c12903h.f58735h);
        this.f58870k = c12903h.f58736i;
    }

    /* renamed from: y */
    public void m77534y(float f10, float f11, float f12, float f13) {
        this.f58864e = f10;
        this.f58865f = f11;
        this.f58866g = f12;
        this.f58867h = f13;
    }

    /* renamed from: z */
    public void m77535z(float f10, float f11, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f16 = (float) dArr[i10];
            double d10 = dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f12 = f16;
            } else if (i11 == 2) {
                f14 = f16;
            } else if (i11 == 3) {
                f13 = f16;
            } else if (i11 == 4) {
                f15 = f16;
            }
        }
        float f17 = f12 - ((0.0f * f13) / 2.0f);
        float f18 = f14 - ((0.0f * f15) / 2.0f);
        fArr[0] = (f17 * (1.0f - f10)) + (((f13 * 1.0f) + f17) * f10) + 0.0f;
        fArr[1] = (f18 * (1.0f - f11)) + (((f15 * 1.0f) + f18) * f11) + 0.0f;
    }

    public C12910o(int i10, int i11, C12903h c12903h, C12910o c12910o, C12910o c12910o2) {
        int i12 = AbstractC12899d.f58688f;
        this.f58870k = i12;
        this.f58871l = i12;
        this.f58872m = Float.NaN;
        this.f58873n = null;
        this.f58874o = new LinkedHashMap<>();
        this.f58875p = 0;
        this.f58877r = new double[18];
        this.f58878s = new double[18];
        if (c12910o.f58871l != AbstractC12899d.f58688f) {
            m77532w(i10, i11, c12903h, c12910o, c12910o2);
            return;
        }
        int i13 = c12903h.f58744q;
        if (i13 == 1) {
            m77531v(c12903h, c12910o, c12910o2);
            return;
        }
        if (i13 == 2) {
            m77533x(i10, i11, c12903h, c12910o, c12910o2);
        } else if (i13 != 3) {
            m77530u(c12903h, c12910o, c12910o2);
        } else {
            m77529t(c12903h, c12910o, c12910o2);
        }
    }
}
