package p627s;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.C0583a;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p642t.C12896a;

/* renamed from: s.a */
/* loaded from: classes.dex */
public class C12654a {

    /* renamed from: s.a$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f58123a;

        static {
            int[] iArr = new int[C0583a.a.values().length];
            f58123a = iArr;
            try {
                iArr[C0583a.a.INT_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58123a[C0583a.a.FLOAT_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f58123a[C0583a.a.COLOR_DRAWABLE_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f58123a[C0583a.a.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f58123a[C0583a.a.STRING_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f58123a[C0583a.a.BOOLEAN_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f58123a[C0583a.a.DIMENSION_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: a */
    public static int m76183a(int i10) {
        int i11 = (i10 & (~(i10 >> 31))) - 255;
        return (i11 & (i11 >> 31)) + HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
    }

    /* renamed from: b */
    public static void m76184b(C0583a c0583a, View view, float[] fArr) {
        Class<?> cls = view.getClass();
        String str = "set" + c0583a.m3587c();
        try {
            boolean z10 = true;
            switch (a.f58123a[c0583a.m3588d().ordinal()]) {
                case 1:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 2:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 3:
                    Method method = cls.getMethod(str, Drawable.class);
                    int iM76183a = (m76183a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (m76183a((int) (fArr[3] * 255.0f)) << 24) | (m76183a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | m76183a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(iM76183a);
                    method.invoke(view, colorDrawable);
                    return;
                case 4:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf((m76183a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (m76183a((int) (fArr[3] * 255.0f)) << 24) | (m76183a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | m76183a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 5:
                    throw new RuntimeException("unable to interpolate strings " + c0583a.m3587c());
                case 6:
                    Method method2 = cls.getMethod(str, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    if (fArr[0] <= 0.5f) {
                        z10 = false;
                    }
                    objArr[0] = Boolean.valueOf(z10);
                    method2.invoke(view, objArr);
                    return;
                case 7:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e10) {
            Log.e("CustomSupport", "Cannot access method " + str + " on View \"" + C12896a.m77318d(view) + "\"", e10);
        } catch (NoSuchMethodException e11) {
            Log.e("CustomSupport", "No method " + str + " on View \"" + C12896a.m77318d(view) + "\"", e11);
        } catch (InvocationTargetException e12) {
            Log.e("CustomSupport", "Cannot invoke method " + str + " on View \"" + C12896a.m77318d(view) + "\"", e12);
        }
    }
}
