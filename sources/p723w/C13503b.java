package p723w;

import android.graphics.Color;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: w.b */
/* loaded from: classes.dex */
public final class C13503b {

    /* renamed from: a */
    public static final ThreadLocal<double[]> f60768a = new ThreadLocal<>();

    /* renamed from: a */
    public static void m81217a(int i10, int i11, int i12, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d10 = i10 / 255.0d;
        double dPow = d10 < 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
        double d11 = i11 / 255.0d;
        double dPow2 = d11 < 0.04045d ? d11 / 12.92d : Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
        double d12 = i12 / 255.0d;
        double dPow3 = d12 < 0.04045d ? d12 / 12.92d : Math.pow((d12 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * dPow) + (0.3576d * dPow2) + (0.1805d * dPow3)) * 100.0d;
        dArr[1] = ((0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3)) * 100.0d;
        dArr[2] = ((dPow * 0.0193d) + (dPow2 * 0.1192d) + (dPow3 * 0.9505d)) * 100.0d;
    }

    /* renamed from: b */
    public static int m81218b(double d10, double d11, double d12) {
        double d13 = (((3.2406d * d10) + ((-1.5372d) * d11)) + ((-0.4986d) * d12)) / 100.0d;
        double d14 = ((((-0.9689d) * d10) + (1.8758d * d11)) + (0.0415d * d12)) / 100.0d;
        double d15 = (((0.0557d * d10) + ((-0.204d) * d11)) + (1.057d * d12)) / 100.0d;
        return Color.rgb(m81224h((int) Math.round((d13 > 0.0031308d ? (Math.pow(d13, 0.4166666666666667d) * 1.055d) - 0.055d : d13 * 12.92d) * 255.0d), 0, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), m81224h((int) Math.round((d14 > 0.0031308d ? (Math.pow(d14, 0.4166666666666667d) * 1.055d) - 0.055d : d14 * 12.92d) * 255.0d), 0, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), m81224h((int) Math.round((d15 > 0.0031308d ? (Math.pow(d15, 0.4166666666666667d) * 1.055d) - 0.055d : d15 * 12.92d) * 255.0d), 0, HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA));
    }

    /* renamed from: c */
    public static double m81219c(int i10) {
        double[] dArrM81225i = m81225i();
        m81220d(i10, dArrM81225i);
        return dArrM81225i[1] / 100.0d;
    }

    /* renamed from: d */
    public static void m81220d(int i10, double[] dArr) {
        m81217a(Color.red(i10), Color.green(i10), Color.blue(i10), dArr);
    }

    /* renamed from: e */
    public static int m81221e(int i10, int i11) {
        return 255 - (((255 - i11) * (255 - i10)) / HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }

    /* renamed from: f */
    public static int m81222f(int i10, int i11) {
        int iAlpha = Color.alpha(i11);
        int iAlpha2 = Color.alpha(i10);
        int iM81221e = m81221e(iAlpha2, iAlpha);
        return Color.argb(iM81221e, m81223g(Color.red(i10), iAlpha2, Color.red(i11), iAlpha, iM81221e), m81223g(Color.green(i10), iAlpha2, Color.green(i11), iAlpha, iM81221e), m81223g(Color.blue(i10), iAlpha2, Color.blue(i11), iAlpha, iM81221e));
    }

    /* renamed from: g */
    public static int m81223g(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            return 0;
        }
        return (((i10 * HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) * i11) + ((i12 * i13) * (255 - i11))) / (i14 * HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
    }

    /* renamed from: h */
    public static int m81224h(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : Math.min(i10, i12);
    }

    /* renamed from: i */
    public static double[] m81225i() {
        ThreadLocal<double[]> threadLocal = f60768a;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    /* renamed from: j */
    public static int m81226j(int i10, int i11) {
        if (i11 < 0 || i11 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i10 & 16777215) | (i11 << 24);
    }
}
