package com.huawei.phoneservice.faq.base.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.annotation.Keep;
import p212d0.C8974f;
import p273f0.C9582a;
import p273f0.C9603h0;
import p304g0.C9832l;

/* loaded from: classes4.dex */
public class FaqUiUtils {

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqUiUtils$a */
    public class C8324a extends C9582a {
        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            if (c9832l == null) {
                return;
            }
            c9832l.m61065U(Button.class.getName());
        }
    }

    /* renamed from: a */
    public static boolean m51888a(Activity activity) {
        return (activity == null || activity.getResources() == null || activity.getResources().getConfiguration() == null || (activity.getResources().getConfiguration().uiMode & 48) != 32) ? false : true;
    }

    @Keep
    public static int dip2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Keep
    public static boolean isRtlLayout(Context context) {
        return C8974f.m56783a(context.getResources().getConfiguration().locale) == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isSplitActivity(android.app.Activity r5) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "FaqUiUtils"
            r1 = 0
            java.lang.String r2 = "android.content.Intent"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Exception -> L22 java.lang.RuntimeException -> L28 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalArgumentException -> L2e java.lang.IllegalAccessException -> L31 java.lang.NoSuchMethodException -> L34 java.lang.ClassNotFoundException -> L37
            java.lang.String r3 = "getHwFlags"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L22 java.lang.RuntimeException -> L28 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalArgumentException -> L2e java.lang.IllegalAccessException -> L31 java.lang.NoSuchMethodException -> L34 java.lang.ClassNotFoundException -> L37
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch: java.lang.Exception -> L22 java.lang.RuntimeException -> L28 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalArgumentException -> L2e java.lang.IllegalAccessException -> L31 java.lang.NoSuchMethodException -> L34 java.lang.ClassNotFoundException -> L37
            android.content.Intent r5 = r5.getIntent()     // Catch: java.lang.Exception -> L22 java.lang.RuntimeException -> L28 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalArgumentException -> L2e java.lang.IllegalAccessException -> L31 java.lang.NoSuchMethodException -> L34 java.lang.ClassNotFoundException -> L37
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L22 java.lang.RuntimeException -> L28 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalArgumentException -> L2e java.lang.IllegalAccessException -> L31 java.lang.NoSuchMethodException -> L34 java.lang.ClassNotFoundException -> L37
            java.lang.Object r5 = r2.invoke(r5, r3)     // Catch: java.lang.Exception -> L22 java.lang.RuntimeException -> L28 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalArgumentException -> L2e java.lang.IllegalAccessException -> L31 java.lang.NoSuchMethodException -> L34 java.lang.ClassNotFoundException -> L37
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Exception -> L22 java.lang.RuntimeException -> L28 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalArgumentException -> L2e java.lang.IllegalAccessException -> L31 java.lang.NoSuchMethodException -> L34 java.lang.ClassNotFoundException -> L37
            int r5 = r5.intValue()     // Catch: java.lang.Exception -> L22 java.lang.RuntimeException -> L28 java.lang.reflect.InvocationTargetException -> L2b java.lang.IllegalArgumentException -> L2e java.lang.IllegalAccessException -> L31 java.lang.NoSuchMethodException -> L34 java.lang.ClassNotFoundException -> L37
            goto L3b
        L22:
            java.lang.String r5 = "isSplitActivity Exception"
        L24:
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51846i(r0, r5)
            goto L3a
        L28:
            java.lang.String r5 = "isSplitActivity RuntimeException"
            goto L24
        L2b:
            java.lang.String r5 = "isSplitActivity InvocationTargetException"
            goto L24
        L2e:
            java.lang.String r5 = "isSplitActivity IllegalArgumentException"
            goto L24
        L31:
            java.lang.String r5 = "isSplitActivity IllegalAccessException"
            goto L24
        L34:
            java.lang.String r5 = "isSplitActivity NoSuchMethodException"
            goto L24
        L37:
            java.lang.String r5 = "isSplitActivity ClassNotFoundException"
            goto L24
        L3a:
            r5 = r1
        L3b:
            r5 = r5 & 4
            if (r5 == 0) goto L40
            r1 = 1
        L40:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.faq.base.util.FaqUiUtils.isSplitActivity(android.app.Activity):boolean");
    }

    @Keep
    public static void setPadPadding(Activity activity, int[] iArr) {
        if (iArr == null || iArr.length <= 0 || isSplitActivity(activity) || !FaqCommonUtils.isPad()) {
            return;
        }
        for (int i10 : iArr) {
            View viewFindViewById = activity.findViewById(i10);
            if (viewFindViewById != null) {
                viewFindViewById.setPadding(0, viewFindViewById.getPaddingTop(), 0, viewFindViewById.getPaddingBottom());
            }
        }
    }

    @Keep
    public static void setRootViewDefaultFocusHighlight(Activity activity) throws Throwable {
        View viewFindViewById;
        if (activity == null || (viewFindViewById = activity.findViewById(R.id.content)) == null) {
            return;
        }
        View childAt = ((ViewGroup) viewFindViewById).getChildAt(0);
        if (childAt == null) {
            FaqLogger.m51840e("FaqUiUtils", "root view is null");
            return;
        }
        childAt.setFocusable(true);
        childAt.setFocusableInTouchMode(true);
        childAt.requestFocus();
        childAt.requestFocusFromTouch();
        childAt.setDefaultFocusHighlightEnabled(false);
    }

    @Keep
    public static void setStatusBarColor(Activity activity, boolean z10, int i10) {
        Window window;
        if (activity == null || !z10 || (window = activity.getWindow()) == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i10);
        View decorView = window.getDecorView();
        if (decorView == null) {
            return;
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(m51888a(activity) ? systemUiVisibility & (-8193) : systemUiVisibility | 8192);
    }

    @Keep
    public static void setViewLayoutParams(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i10;
        view.setLayoutParams(layoutParams);
    }

    @Keep
    public static void viewMapToButton(View view) {
        if (view == null) {
            return;
        }
        C9603h0.m59902p0(view, new C8324a());
    }
}
