package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.C7800ct;
import java.lang.reflect.Method;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.cn */
/* loaded from: classes8.dex */
public class C6997cn extends C6986cc {

    /* renamed from: c */
    private static InterfaceC6998co f32132c;

    /* renamed from: d */
    private static final byte[] f32133d = new byte[0];

    /* renamed from: e */
    private CountryCodeBean f32134e;

    public C6997cn(Context context) {
        super(context);
        this.f32134e = new CountryCodeBean(context);
    }

    /* renamed from: b */
    public static InterfaceC6998co m41226b(Context context) {
        return m41227c(context);
    }

    /* renamed from: c */
    private static InterfaceC6998co m41227c(Context context) {
        InterfaceC6998co interfaceC6998co;
        synchronized (f32133d) {
            try {
                if (f32132c == null) {
                    f32132c = new C6997cn(context);
                }
                interfaceC6998co = f32132c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC6998co;
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: a */
    public int mo41169a(View view) {
        int identifier;
        DisplayCutout displayCutout;
        int dimensionPixelSize = -1;
        if (view == null) {
            return -1;
        }
        try {
            if (view.getRootWindowInsets() != null && (displayCutout = view.getRootWindowInsets().getDisplayCutout()) != null) {
                List<Rect> boundingRects = displayCutout.getBoundingRects();
                if (!AbstractC7760bg.m47767a(boundingRects)) {
                    dimensionPixelSize = boundingRects.get(0).height();
                }
            }
            if (dimensionPixelSize < 0 && (identifier = this.f32106a.getResources().getIdentifier("notch_height", "dimen", OsType.ANDROID)) > 0) {
                dimensionPixelSize = this.f32106a.getResources().getDimensionPixelSize(identifier);
            }
            if (dimensionPixelSize >= 0) {
                return dimensionPixelSize;
            }
            int identifier2 = this.f32106a.getResources().getIdentifier("status_bar_height", "dimen", OsType.ANDROID);
            if (identifier2 > 0) {
                dimensionPixelSize = this.f32106a.getResources().getDimensionPixelSize(identifier2);
            }
            if (dimensionPixelSize == 0) {
                return 110;
            }
            return dimensionPixelSize;
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("ThirdDeviceImpl", "getNotchHeight err: %s", th2.getClass().getSimpleName());
            return -1;
        }
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: d */
    public boolean mo41175d() {
        return mo41170a();
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: a */
    public boolean mo41170a() {
        String strM48118b = C7800ct.m48114a().m48118b();
        if (TextUtils.isEmpty(strM48118b)) {
            strM48118b = this.f32134e.m39390a();
        }
        return "CN".equalsIgnoreCase(strM48118b);
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: a */
    public boolean mo41171a(Context context) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        String str;
        Class<?> cls;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("ThirdDeviceImpl", "isNotchEnable mi Throwable:" + th2.getClass().getSimpleName());
        }
        boolean zHasSystemFeature = ((Integer) cls.getMethod("getInt", String.class, Integer.TYPE).invoke(cls, "ro.miui.notch", 0)).intValue() != 0;
        AbstractC7185ho.m43818a("ThirdDeviceImpl", "isNotchEnable xiaomi, hasNotch = %s", Boolean.valueOf(zHasSystemFeature));
        if (!zHasSystemFeature) {
            try {
                zHasSystemFeature = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
            } catch (Throwable th3) {
                AbstractC7185ho.m43823c("ThirdDeviceImpl", "isNotchEnable oppo Throwable:" + th3.getClass().getSimpleName());
            }
        }
        AbstractC7185ho.m43818a("ThirdDeviceImpl", "isNotchEnable oppo, hasNotch = %s", Boolean.valueOf(zHasSystemFeature));
        if (!zHasSystemFeature) {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                Method method = clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE);
                ((Boolean) method.invoke(clsLoadClass, 32)).booleanValue();
                zHasSystemFeature = ((Boolean) method.invoke(clsLoadClass, 8)).booleanValue();
            } catch (ClassNotFoundException unused) {
                str = "hasNotchAtVivo ClassNotFoundException";
                AbstractC7185ho.m43826d("Notch", str);
                AbstractC7185ho.m43818a("ThirdDeviceImpl", "isNotchEnable vivo, hasNotch = %s", Boolean.valueOf(zHasSystemFeature));
                return zHasSystemFeature;
            } catch (NoSuchMethodException unused2) {
                str = "hasNotchAtVivo NoSuchMethodException";
                AbstractC7185ho.m43826d("Notch", str);
                AbstractC7185ho.m43818a("ThirdDeviceImpl", "isNotchEnable vivo, hasNotch = %s", Boolean.valueOf(zHasSystemFeature));
                return zHasSystemFeature;
            } catch (Exception unused3) {
                str = "hasNotchAtVivo Exception";
                AbstractC7185ho.m43826d("Notch", str);
                AbstractC7185ho.m43818a("ThirdDeviceImpl", "isNotchEnable vivo, hasNotch = %s", Boolean.valueOf(zHasSystemFeature));
                return zHasSystemFeature;
            }
        }
        AbstractC7185ho.m43818a("ThirdDeviceImpl", "isNotchEnable vivo, hasNotch = %s", Boolean.valueOf(zHasSystemFeature));
        return zHasSystemFeature;
    }
}
