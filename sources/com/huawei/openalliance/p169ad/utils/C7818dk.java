package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.utils.dk */
/* loaded from: classes2.dex */
public class C7818dk {
    /* renamed from: a */
    public static float m48367a(Context context, int i10) {
        return i10 * m48369a(context).density;
    }

    /* renamed from: b */
    public static int m48371b(Context context) {
        return m48369a(context).widthPixels;
    }

    /* renamed from: c */
    public static int m48373c(Context context) {
        return m48369a(context).heightPixels;
    }

    /* renamed from: d */
    public static View m48374d(Context context) {
        if (context == null) {
            return null;
        }
        View view = new View(context);
        view.setBackgroundResource(C6849R.color.hiad_30_percent_white);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return view;
    }

    /* renamed from: a */
    public static Drawable m48368a(Drawable drawable) {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            drawable.setLayoutDirection(1);
        }
        return drawable;
    }

    /* renamed from: b */
    public static Drawable m48372b(Context context, int i10) {
        return m48368a(context.getResources().getDrawable(i10));
    }

    /* renamed from: a */
    public static DisplayMetrics m48369a(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null && (windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)) != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    /* renamed from: a */
    public static void m48370a(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        view.setPaddingRelative(view2.getPaddingStart(), view2.getPaddingTop(), view2.getPaddingEnd(), view2.getPaddingBottom());
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                m48370a(childAt, childAt == null ? null : view2.findViewById(childAt.getId()));
            }
        }
    }
}
