package com.huawei.phoneservice.faq.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Keep;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Collection;

/* loaded from: classes4.dex */
public class FaqCommonUtils {

    /* renamed from: a */
    public static String f38688a;

    /* renamed from: a */
    public static float m51809a(CharSequence charSequence, TextPaint textPaint, float f10, int i10, float f11, float f12, float f13, DisplayMetrics displayMetrics) {
        CharSequence charSequence2;
        TextPaint textPaint2;
        float f14;
        int i11;
        float f15;
        float f16 = (f11 + f12) / 2.0f;
        textPaint.setTextSize(TypedValue.applyDimension(0, f16, displayMetrics));
        int lineCount = 1;
        if (i10 != 1) {
            lineCount = new StaticLayout(charSequence, textPaint, (int) f10, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
        }
        if (lineCount > i10) {
            if (f12 - f11 < f13) {
                return f11;
            }
            charSequence2 = charSequence;
            textPaint2 = textPaint;
            f14 = f10;
            i11 = i10;
            f15 = f11;
        } else {
            if (lineCount >= i10) {
                return f16;
            }
            charSequence2 = charSequence;
            textPaint2 = textPaint;
            f14 = f10;
            i11 = i10;
            f15 = f16;
            f16 = f12;
        }
        return m51809a(charSequence2, textPaint2, f14, i11, f15, f16, f13, displayMetrics);
    }

    @Keep
    public static float autoFit(Context context, CharSequence charSequence, TextPaint textPaint, float f10, float f11, float f12, int i10, float f13) {
        if (i10 <= 0 || i10 == Integer.MAX_VALUE) {
            return textPaint.getTextSize();
        }
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = (context != null ? context.getResources() : Resources.getSystem()).getDisplayMetrics();
        if ((i10 == 1 && textPaint.measureText(charSequence, 0, charSequence.length()) > f10) || m51810b(charSequence, textPaint, f12, f10, displayMetrics) > i10) {
            f12 = m51809a(charSequence, textPaint, f10, i10, 0.0f, f12, f13, displayMetrics);
        }
        return f12 < f11 ? f11 : f12;
    }

    /* renamed from: b */
    public static int m51810b(CharSequence charSequence, TextPaint textPaint, float f10, float f11, DisplayMetrics displayMetrics) {
        textPaint.setTextSize(TypedValue.applyDimension(0, f10, displayMetrics));
        return new StaticLayout(charSequence, textPaint, (int) f11, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    /* renamed from: c */
    public static int m51811c(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String strM51813e = m51813e();
        if (TextUtils.isEmpty(strM51813e)) {
            return -1;
        }
        if (str.equals(strM51813e)) {
            return 0;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = strM51813e.split("\\.");
        int length = strArrSplit.length;
        int length2 = strArrSplit2.length;
        int iMin = Math.min(length, length2);
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = Integer.parseInt(strArrSplit[i10]);
            int i12 = Integer.parseInt(strArrSplit2[i10]);
            if (i11 > i12) {
                return -1;
            }
            if (i11 < i12) {
                return 1;
            }
        }
        return Integer.compare(length2, length);
    }

    /* renamed from: d */
    public static DisplayMetrics m51812d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null) {
            ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    /* renamed from: e */
    public static String m51813e() throws Throwable {
        try {
            String strM51814f = m51814f();
            if (TextUtils.isEmpty(strM51814f)) {
                return null;
            }
            return strM51814f.split("_")[1];
        } catch (Exception unused) {
            FaqLogger.m51840e("FaqCommonUtils", "getEmui()  Exception...");
            return null;
        }
    }

    /* renamed from: f */
    public static String m51814f() {
        return m51816h("ro.build.version.emui");
    }

    /* renamed from: g */
    public static boolean m51815g(String str) throws ClassNotFoundException {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Keep
    public static int getScreenHeight(Context context) {
        return m51812d(context).heightPixels;
    }

    @Keep
    public static int getScreenWidth(Context context) {
        return m51812d(context).widthPixels;
    }

    @Keep
    public static int getScreenWidthHeight(Context context) {
        return (isScreenLandscape(context) ? getScreenHeight(context) : getScreenWidth(context)) / 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x002c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m51816h(java.lang.String r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Exception"
            java.lang.String r1 = "FaqCommonUtils"
            r2 = 0
            java.lang.String r3 = "android.os.SystemProperties"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L1a java.lang.NoSuchMethodException -> L1f java.lang.ClassNotFoundException -> L26
            java.lang.String r4 = "get"
            r5 = 1
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L1b java.lang.NoSuchMethodException -> L20 java.lang.ClassNotFoundException -> L27
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch: java.lang.Exception -> L1b java.lang.NoSuchMethodException -> L20 java.lang.ClassNotFoundException -> L27
            java.lang.reflect.Method r2 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L1b java.lang.NoSuchMethodException -> L20 java.lang.ClassNotFoundException -> L27
            goto L2a
        L1a:
            r3 = r2
        L1b:
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r1, r0)
            goto L2a
        L1f:
            r3 = r2
        L20:
            java.lang.String r4 = "NoSuchMethodException"
        L22:
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r1, r4)
            goto L2a
        L26:
            r3 = r2
        L27:
            java.lang.String r4 = "ClassNotFoundException"
            goto L22
        L2a:
            if (r2 == 0) goto L47
            java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch: java.lang.Exception -> L37 java.lang.reflect.InvocationTargetException -> L3b java.lang.IllegalArgumentException -> L41 java.lang.IllegalAccessException -> L44
            java.lang.Object r8 = r2.invoke(r3, r8)     // Catch: java.lang.Exception -> L37 java.lang.reflect.InvocationTargetException -> L3b java.lang.IllegalArgumentException -> L41 java.lang.IllegalAccessException -> L44
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L37 java.lang.reflect.InvocationTargetException -> L3b java.lang.IllegalArgumentException -> L41 java.lang.IllegalAccessException -> L44
            goto L49
        L37:
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r1, r0)
            goto L47
        L3b:
            java.lang.String r8 = "InvocationTargetException"
        L3d:
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r1, r8)
            goto L47
        L41:
            java.lang.String r8 = "IllegalArgumentException"
            goto L3d
        L44:
            java.lang.String r8 = "IllegalAccessException"
            goto L3d
        L47:
            java.lang.String r8 = ""
        L49:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.faq.base.util.FaqCommonUtils.m51816h(java.lang.String):java.lang.String");
    }

    @Keep
    public static void hideIme(Activity activity) {
        View viewPeekDecorView;
        if (activity == null || (viewPeekDecorView = activity.getWindow().peekDecorView()) == null || viewPeekDecorView.getWindowToken() == null) {
            return;
        }
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(viewPeekDecorView.getWindowToken(), 0);
    }

    /* renamed from: i */
    public static boolean m51817i() {
        return "Y".equalsIgnoreCase(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_IS_OTHER_BRAND_CAR));
    }

    @Keep
    public static boolean isAboveEmui10() {
        return m51811c("10.0.0") >= 0;
    }

    @Keep
    public static boolean isAboveEmui60() {
        return m51818j() && m51811c("6.0.0") >= 0;
    }

    @Keep
    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    @Keep
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    @Keep
    public static boolean isEmui50OrLater() {
        return m51818j() && m51811c("5.0.0") >= 0;
    }

    @Keep
    public static boolean isPad() {
        synchronized (FaqCommonUtils.class) {
            try {
                if (f38688a == null) {
                    f38688a = m51816h("ro.build.characteristics");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return "tablet".equals(f38688a) || "car".equals(f38688a) || m51817i();
    }

    @Keep
    public static boolean isScreenLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* renamed from: j */
    public static boolean m51818j() {
        return m51815g("com.huawei.android.os.BuildEx");
    }
}
