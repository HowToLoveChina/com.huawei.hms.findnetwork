package com.huawei.phoneservice.faq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.huawei.phoneservice.faq.R$styleable;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.utils.C8417g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public class FaqButtonContainer extends FrameLayout {

    /* renamed from: a */
    public int f39278a;

    /* renamed from: b */
    public int f39279b;

    /* renamed from: c */
    public int f39280c;

    /* renamed from: d */
    public float f39281d;

    /* renamed from: e */
    public TextPaint f39282e;

    /* renamed from: f */
    public EnumC8424a f39283f;

    /* renamed from: g */
    public List<TextView> f39284g;

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqButtonContainer$a */
    public enum EnumC8424a {
        HORIZONTAL,
        VERTICAL
    }

    public FaqButtonContainer(Context context) {
        this(context, null);
    }

    private int getSingleButtonWidth() {
        int screenHeight;
        if (FaqCommonUtils.isPad()) {
            screenHeight = ((FaqCommonUtils.isScreenLandscape(getContext()) ? FaqCommonUtils.getScreenHeight(getContext()) : FaqCommonUtils.getScreenWidth(getContext())) * 6) / 8;
        } else {
            screenHeight = FaqCommonUtils.isScreenLandscape(getContext()) ? FaqCommonUtils.getScreenHeight(getContext()) : FaqCommonUtils.getScreenWidth(getContext());
        }
        return (screenHeight - getPaddingLeft()) - getPaddingRight();
    }

    /* renamed from: a */
    public int m52438a(int i10) {
        return (getSingleButtonWidth() - (this.f39278a * (i10 - 1))) / i10;
    }

    /* renamed from: b */
    public int m52439b(View view) {
        Drawable background;
        if (this.f39280c == 0 && view != null && (background = view.getBackground()) != null) {
            Drawable current = background.getCurrent();
            Rect rect = new Rect();
            current.getPadding(rect);
            this.f39280c = rect.left + rect.right;
        }
        return this.f39280c;
    }

    /* renamed from: c */
    public final int m52440c(CharSequence charSequence, Paint paint) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        return (int) (paint.measureText(charSequence.toString()) + 0.5f);
    }

    /* renamed from: d */
    public TextPaint m52441d(TextView textView) {
        if (this.f39282e == null) {
            if (textView != null) {
                this.f39282e = new TextPaint(textView.getPaint());
            } else {
                this.f39282e = new TextPaint();
            }
        }
        return this.f39282e;
    }

    /* renamed from: e */
    public final void m52442e(int i10, int i11) throws Throwable {
        float fAutoFit;
        TextView textView = this.f39284g.get(i11);
        TextPaint textPaintM52441d = m52441d(textView);
        textPaintM52441d.setTextSize(this.f39281d);
        if (textView.getText() != null) {
            String upperCase = textView.getText().toString().toUpperCase(Locale.getDefault());
            int measuredWidth = textView.getMeasuredWidth() - m52439b(textView);
            int iM52440c = m52440c(upperCase, textPaintM52441d);
            FaqLogger.m51836d("ButtonContainer", "maxTextWidth:" + iM52440c + "  childView.getMeasuredWidth():" + textView.getMeasuredWidth() + "   textWidth:" + measuredWidth);
            if (iM52440c > measuredWidth) {
                fAutoFit = FaqCommonUtils.autoFit(getContext(), upperCase, textPaintM52441d, measuredWidth, i10, this.f39281d, 1, 0.5f);
                FaqLogger.m51836d("ButtonContainer", "FontSize " + fAutoFit);
            } else {
                FaqLogger.m51836d("ButtonContainer", "FontSize " + this.f39281d);
                fAutoFit = this.f39281d;
            }
            textView.setTextSize(0, fAutoFit);
        }
    }

    /* renamed from: f */
    public final void m52443f(int i10, int i11, int i12, int i13) throws Throwable {
        int iMax;
        int i14 = 0;
        if (this.f39284g.size() > 0) {
            TextView textView = this.f39284g.get(0);
            TextPaint textPaintM52441d = m52441d(textView);
            if (this.f39281d == 0.0f) {
                this.f39281d = textPaintM52441d.getTextSize();
            }
            textPaintM52441d.setTextSize(C8417g.m52398d(getContext(), 9.0f));
            int iMax2 = 0;
            for (TextView textView2 : this.f39284g) {
                if (textView2.getText() != null) {
                    String upperCase = textView2.getText().toString().toUpperCase(Locale.getDefault());
                    int iM52440c = m52440c(upperCase, textPaintM52441d);
                    FaqLogger.m51836d("ButtonContainer", "text:" + upperCase + "  getTextWidth:" + iM52440c);
                    iMax2 = Math.max(iMax2, iM52440c);
                }
            }
            int measuredWidth = (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - ((this.f39284g.size() - 1) * this.f39278a)) / this.f39284g.size();
            int iM52439b = measuredWidth - m52439b(textView);
            FaqLogger.m51836d("ButtonContainer", "minTextWidth:" + iMax2 + "  buttonWidth:" + measuredWidth + "   textWidth:" + iM52439b);
            EnumC8424a enumC8424a = iMax2 > iM52439b ? EnumC8424a.VERTICAL : EnumC8424a.HORIZONTAL;
            this.f39283f = enumC8424a;
            if (EnumC8424a.VERTICAL == enumC8424a) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i12, m52438a(1)), 1073741824);
                int i15 = 0;
                iMax = 0;
                while (i15 < this.f39284g.size()) {
                    TextView textView3 = this.f39284g.get(i15);
                    textView3.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                    iMax += textView3.getMeasuredHeight() + (i15 == 0 ? 0 : this.f39279b);
                    i15++;
                }
            } else {
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, m52438a(this.f39284g.size())), 1073741824);
                iMax = 0;
                while (i14 < this.f39284g.size()) {
                    TextView textView4 = this.f39284g.get(i14);
                    textView4.measure(iMakeMeasureSpec2, i11);
                    iMax = Math.max(iMax, textView4.getMeasuredHeight());
                    i14++;
                }
            }
            i14 = iMax;
        }
        setMeasuredDimension(i10, View.MeasureSpec.makeMeasureSpec(i14, i13));
    }

    /* renamed from: g */
    public final void m52444g(List<TextView> list, int i10, int i11) {
        if (list == null || list.size() == 0) {
            return;
        }
        int measuredWidth = (getMeasuredWidth() - getSingleButtonWidth()) / 2;
        int paddingTop = ((i11 - i10) - getPaddingTop()) - getPaddingBottom();
        if (m52445h()) {
            Collections.reverse(list);
        }
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            TextView textView = list.get(i12);
            if (textView != null && textView.getVisibility() != 8) {
                int measuredWidth2 = textView.getMeasuredWidth();
                int measuredHeight = textView.getMeasuredHeight();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                int paddingTop2 = ((getPaddingTop() + ((paddingTop - measuredHeight) / 2)) + layoutParams.topMargin) - layoutParams.bottomMargin;
                int i13 = measuredWidth + layoutParams.leftMargin;
                textView.layout(i13, paddingTop2, i13 + measuredWidth2, measuredHeight + paddingTop2);
                measuredWidth = i13 + measuredWidth2 + layoutParams.rightMargin + this.f39278a;
            }
        }
    }

    /* renamed from: h */
    public boolean m52445h() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: i */
    public final void m52446i(List<TextView> list, int i10, int i11) {
        if (list == null || list.size() == 0) {
            return;
        }
        int paddingTop = getPaddingTop();
        int i12 = i11 - i10;
        int paddingRight = i12 - getPaddingRight();
        int paddingLeft = (i12 - getPaddingLeft()) - getPaddingBottom();
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            TextView textView = list.get(i13);
            if (textView != null && textView.getVisibility() != 8) {
                int measuredWidth = textView.getMeasuredWidth();
                int measuredHeight = textView.getMeasuredHeight();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                int absoluteGravity = Gravity.getAbsoluteGravity(layoutParams.gravity, getLayoutDirection()) & 7;
                int paddingLeft2 = absoluteGravity != 8388611 ? (absoluteGravity != 8388613 ? (getPaddingLeft() + ((paddingLeft - measuredWidth) / 2)) + layoutParams.leftMargin : paddingRight - measuredWidth) - layoutParams.rightMargin : getPaddingLeft() + layoutParams.leftMargin;
                int i14 = paddingTop + layoutParams.topMargin;
                textView.layout(paddingLeft2, i14, measuredWidth + paddingLeft2, i14 + measuredHeight);
                paddingTop = i14 + measuredHeight + layoutParams.bottomMargin + this.f39279b;
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (EnumC8424a.VERTICAL == this.f39283f) {
            m52446i(this.f39284g, i10, i12);
        } else {
            m52444g(this.f39284g, i11, i13);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) throws Throwable {
        this.f39284g.clear();
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 0 && (childAt instanceof TextView)) {
                this.f39284g.add((TextView) childAt);
            } else {
                childAt.setVisibility(8);
            }
        }
        int size = View.MeasureSpec.getSize(i10);
        if (!this.f39284g.isEmpty()) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(size, m52438a(EnumC8424a.VERTICAL == this.f39283f ? 1 : this.f39284g.size())), 1073741824);
            Iterator<TextView> it = this.f39284g.iterator();
            while (it.hasNext()) {
                it.next().measure(i10, iMakeMeasureSpec);
            }
        }
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != 1073741824) {
            m52443f(i10, i11, size, mode);
        } else {
            super.onMeasure(i10, i11);
        }
        if (this.f39281d != 0.0f) {
            int iM52398d = C8417g.m52398d(getContext(), 5.0f);
            for (int i13 = 0; i13 < this.f39284g.size(); i13++) {
                m52442e(iM52398d, i13);
            }
        }
    }

    public FaqButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39284g = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FaqButtonContainer);
        this.f39278a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FaqButtonContainer_faqsdkhorizontalPadding, C8417g.m52395a(context, 12.0f));
        this.f39279b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FaqButtonContainer_faqsdkverticalPadding, C8417g.m52395a(context, 8.0f));
        typedArrayObtainStyledAttributes.recycle();
    }
}
