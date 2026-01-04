package com.huawei.phoneservice.faq.base.widget;

import android.app.ActionBar;
import android.content.res.ColorStateList;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.huawei.phoneservice.faq.base.R$id;
import com.huawei.phoneservice.faq.base.R$layout;

@Keep
/* loaded from: classes4.dex */
public class ActionBarExCompat {
    private static ColorStateList mColorList;
    private static boolean mShowHomeAsUp;
    private static float mTextSize;
    private static CharSequence mTitle;
    private static Boolean support;

    public static <T extends View> T findViewById(View view, int i10) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            view.setTag(sparseArray);
        }
        T t10 = (T) sparseArray.get(i10);
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) view.findViewById(i10);
        sparseArray.put(i10, t11);
        return t11;
    }

    private static View getCustomView(ActionBar actionBar) {
        View customView = actionBar.getCustomView();
        if (customView != null) {
            return customView;
        }
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-1, -1);
        View viewInflate = LayoutInflater.from(actionBar.getThemedContext()).inflate(R$layout.faq_base_sdk_actionbar_layout, (ViewGroup) new LinearLayout(actionBar.getThemedContext()), false);
        actionBar.setCustomView(viewInflate, layoutParams);
        TextView textView = (TextView) findViewById(viewInflate, R$id.title);
        CharSequence title = mTitle;
        if (title == null) {
            title = actionBar.getTitle();
        }
        textView.setText(title);
        updateTitleStyle(actionBar);
        findViewById(viewInflate, R$id.btn_start).setVisibility(mShowHomeAsUp ? 0 : 8);
        return viewInflate;
    }

    public static void initTitleStyle(ActionBar actionBar, TextView textView) {
        mColorList = textView.getTextColors();
        mTextSize = textView.getTextSize();
        updateTitleStyle(actionBar);
    }

    private static boolean isExistOfClass(String str) throws ClassNotFoundException {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isSupportActionBarEx() {
        synchronized (ActionBarExCompat.class) {
            try {
                if (support == null) {
                    support = Boolean.valueOf(isExistOfClass("com.huawei.android.app.ActionBarEx") && isExistOfClass("huawei.com.android.internal.app.HwActionBarImpl"));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return support.booleanValue();
    }

    public static void setDisplayHomeAsUpEnabled(ActionBar actionBar, boolean z10, View.OnClickListener onClickListener) {
        actionBar.setDisplayHomeAsUpEnabled(isSupportActionBarEx() && z10);
        View customView = isSupportActionBarEx() ? actionBar.getCustomView() : getCustomView(actionBar);
        if (customView != null && customView.getTag() != null) {
            View viewFindViewById = findViewById(customView, R$id.btn_start);
            viewFindViewById.setOnClickListener(onClickListener);
            viewFindViewById.setVisibility(z10 ? 0 : 8);
        }
        mShowHomeAsUp = z10;
    }

    public static void setHomeButtonEnabled(ActionBar actionBar, boolean z10) {
        actionBar.setHomeButtonEnabled(isSupportActionBarEx() && z10);
    }

    public static void setTitle(ActionBar actionBar, CharSequence charSequence) {
        mTitle = charSequence;
        View customView = actionBar.getCustomView();
        if (customView == null || customView.getTag() == null) {
            return;
        }
        ((TextView) findViewById(customView, R$id.title)).setText(mTitle);
    }

    private static void updateTitleStyle(ActionBar actionBar) {
        View customView = actionBar.getCustomView();
        if (customView == null || customView.getTag() == null) {
            return;
        }
        TextView textView = (TextView) findViewById(customView, R$id.title);
        ColorStateList colorStateList = mColorList;
        if (colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
        float f10 = mTextSize;
        if (f10 != 0.0f) {
            textView.setTextSize(0, f10);
        }
    }
}
