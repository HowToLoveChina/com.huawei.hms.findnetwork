package com.huawei.phoneservice.faq.base.util;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import com.huawei.hms.android.SystemUtils;
import com.huawei.phoneservice.faq.base.C8289a;
import com.huawei.phoneservice.faq.base.util.FaqHwFrameworkUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class FaqDeviceUtils {

    /* renamed from: a */
    public static Pattern f38689a = Pattern.compile("\\d");

    /* renamed from: b */
    public static int f38690b = 0;

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqDeviceUtils$a */
    public class C8308a implements FaqHwFrameworkUtil.InterfaceC8310b {

        /* renamed from: a */
        public final /* synthetic */ Activity f38691a;

        /* renamed from: b */
        public final /* synthetic */ int[] f38692b;

        /* renamed from: c */
        public final /* synthetic */ int f38693c;

        public C8308a(Activity activity, int[] iArr, int i10) {
            this.f38691a = activity;
            this.f38692b = iArr;
            this.f38693c = i10;
        }

        @Override // com.huawei.phoneservice.faq.base.util.FaqHwFrameworkUtil.InterfaceC8310b
        /* renamed from: a */
        public void mo51826a(int i10) throws Resources.NotFoundException {
            FaqDeviceUtils.m51823e(i10);
            if (3 == i10) {
                FaqDeviceUtils.m51824f(this.f38691a, this.f38692b, this.f38693c);
            }
        }
    }

    /* renamed from: a */
    public static String m51819a() {
        return C8289a.m51747a("ro.build.version.emui");
    }

    /* renamed from: d */
    public static String m51822d() {
        return C8289a.m51747a("ro.build.version.magic");
    }

    /* renamed from: e */
    public static void m51823e(int i10) {
        f38690b = i10;
    }

    /* renamed from: f */
    public static void m51824f(Activity activity, int[] iArr, int i10) throws Resources.NotFoundException {
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(i10);
        for (int i11 : iArr) {
            View viewFindViewById = activity.findViewById(i11);
            if (viewFindViewById != null) {
                viewFindViewById.setPadding(dimensionPixelSize, viewFindViewById.getPaddingTop(), dimensionPixelSize, viewFindViewById.getPaddingBottom());
            }
        }
    }

    /* renamed from: g */
    public static int m51825g() {
        return f38690b;
    }

    @Keep
    public static String getAndroidVersion() {
        return "Android " + Build.VERSION.RELEASE;
    }

    @Keep
    public static String getBrand() {
        return C8289a.m51747a(SystemUtils.PRODUCT_BRAND);
    }

    @Keep
    public static String getEmui() throws Throwable {
        try {
            String strM51819a = m51819a();
            if (!TextUtils.isEmpty(strM51819a)) {
                if (strM51819a.contains("_")) {
                    return "EMUI" + strM51819a.split("_")[1];
                }
                return "EMUI" + strM51819a;
            }
        } catch (Exception e10) {
            FaqLogger.m51840e("DeviceUtils", "getEmui()  Exception..." + e10.getMessage());
        }
        return getAndroidVersion();
    }

    @Keep
    public static String getMachineType() {
        return FaqCommonUtils.isPad() ? "TABLET" : "PHONE";
    }

    @Keep
    public static String getModel() {
        return Build.MODEL;
    }

    @Keep
    public static String getSpecialEmuiVersion() {
        String strM51822d = m51822d();
        if (!TextUtils.isEmpty(strM51822d)) {
            return "MagicUI_" + strM51822d;
        }
        String strM51819a = m51819a();
        if (TextUtils.isEmpty(strM51819a)) {
            return getAndroidVersion();
        }
        Matcher matcher = f38689a.matcher(strM51819a);
        return matcher.find() ? strM51819a.substring(matcher.start()) : strM51819a;
    }

    @Keep
    public static void initForRing(Activity activity, int[] iArr, int i10) throws Resources.NotFoundException {
        int iM51825g = m51825g();
        if (iM51825g == 0) {
            FaqHwFrameworkUtil.initScreenType(activity, new C8308a(activity, iArr, i10));
        } else if (3 == iM51825g) {
            m51824f(activity, iArr, i10);
        }
    }
}
