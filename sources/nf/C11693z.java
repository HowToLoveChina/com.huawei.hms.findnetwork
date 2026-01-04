package nf;

import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.huawei.android.remotecontrol.sdk.R$string;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import p809yg.C13981a;

/* renamed from: nf.z */
/* loaded from: classes4.dex */
public class C11693z {

    /* renamed from: a */
    public static int f54165a = 1;

    /* renamed from: b */
    public static int f54166b = 2;

    /* renamed from: c */
    public static int f54167c = 3;

    /* renamed from: d */
    public static int f54168d = 4;

    /* renamed from: e */
    public static int f54169e = 6;

    /* renamed from: f */
    public static int f54170f = 7;

    /* renamed from: g */
    public static int f54171g = 8;

    /* renamed from: h */
    public static int f54172h = 9;

    /* renamed from: a */
    public static String m69751a(float f10) {
        float fFloatValue = new BigDecimal(f10).setScale(1, 4).floatValue();
        C13981a.m83989i("LocationUtil", "getDeviceDistance" + fFloatValue);
        return String.valueOf(fFloatValue).contains(".0") ? String.valueOf((int) fFloatValue) : String.valueOf(fFloatValue);
    }

    /* renamed from: b */
    public static Map<Integer, Integer> m69752b() {
        HashMap map = new HashMap();
        map.put(Integer.valueOf(f54165a), Integer.valueOf(R$string.forward));
        map.put(Integer.valueOf(f54166b), Integer.valueOf(R$string.behind));
        map.put(Integer.valueOf(f54168d), Integer.valueOf(R$string.right));
        map.put(Integer.valueOf(f54169e), Integer.valueOf(R$string.left_forward));
        map.put(Integer.valueOf(f54170f), Integer.valueOf(R$string.left_behind));
        map.put(Integer.valueOf(f54171g), Integer.valueOf(R$string.right_forward));
        map.put(Integer.valueOf(f54172h), Integer.valueOf(R$string.right_behind));
        map.put(Integer.valueOf(f54167c), Integer.valueOf(R$string.left));
        return map;
    }

    /* renamed from: c */
    public static int m69753c(float f10) {
        if (Float.isNaN(f10)) {
            C13981a.m83988e("LocationUtil", "angle is null");
            return -1;
        }
        double d10 = f10;
        if ((-22.5d <= d10 && d10 < 22.5d) || (337.5d <= d10 && f10 <= 360.0f)) {
            return f54165a;
        }
        if ((22.5d <= d10 && d10 < 67.5d) || (-337.5d <= d10 && d10 < -292.5d)) {
            return f54171g;
        }
        if ((67.5d <= d10 && d10 < 112.5d) || (-292.5d <= d10 && d10 < -247.5d)) {
            return f54168d;
        }
        if ((112.5d <= d10 && d10 < 157.5d) || (-247.5d <= d10 && d10 < -202.5d)) {
            return f54172h;
        }
        if ((157.5d <= d10 && d10 < 202.5d) || (-202.5d <= d10 && d10 < -157.5d)) {
            return f54166b;
        }
        if ((202.5d <= d10 && d10 < 247.5d) || (-157.5d <= d10 && d10 < -112.5d)) {
            return f54170f;
        }
        if ((247.5d <= d10 && d10 < 292.5d) || (-112.5d <= d10 && d10 < -67.5d)) {
            return f54167c;
        }
        if ((292.5d <= d10 && d10 < 337.5d) || (-67.5d <= d10 && d10 < -22.5d)) {
            return f54169e;
        }
        if (-360.0f > f10 || d10 >= -337.5d) {
            return -1;
        }
        return f54165a;
    }

    /* renamed from: d */
    public static float m69754d(float f10) {
        if (f10 > 50.0f) {
            return 0.1f;
        }
        if (f10 <= 5.0f) {
            return 1.0f;
        }
        return 1.0f - ((((int) (f10 - 2.0f)) / 3) * 0.06f);
    }

    /* renamed from: e */
    public static RotateAnimation m69755e(float f10, float f11) {
        C13981a.m83989i("LocationUtil", "fromDegrees:" + f10 + " getRotateAnimation fineToDegrees：" + f11);
        RotateAnimation rotateAnimation = new RotateAnimation(f10, f11, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        long jAbs = (long) (Math.abs(f11 - f10) / 1.0f);
        if (jAbs < 50) {
            jAbs = 50;
        }
        rotateAnimation.setDuration(jAbs);
        return rotateAnimation;
    }

    /* renamed from: f */
    public static float m69756f(float f10, float f11) {
        C13981a.m83989i("LocationUtil", " | fromDegrees: " + f10 + "toDegrees：" + f11);
        float fFloor = (float) (((double) f11) + (Math.floor((double) (f10 / 360.0f)) * 360.0d));
        double d10 = (double) (fFloor - f10);
        if (d10 > 0.0d) {
            if (d10 > 180.0d) {
                fFloor -= 360.0f;
            }
        } else if (Math.abs(d10) > 180.0d) {
            fFloor += 360.0f;
        }
        C13981a.m83989i("LocationUtil", "fineToDegrees：" + fFloor);
        return fFloor;
    }
}
