package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$styleable;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import p514o9.C11839m;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class HotTitleTextView extends TextView {
    private static final String TAG = "HotTitleTextView";
    private static final int TEXTVIEW_MARGIN = 12;
    private Paint mPaint;
    private int mRedDotVisibility;
    private String mText;

    public HotTitleTextView(Context context) {
        super(context);
        this.mRedDotVisibility = 8;
        this.mText = "";
        init();
    }

    private float getTextViewMargin() {
        float f10;
        float fM70844o;
        int iM70758Q = C11842p.m70758Q(getContext());
        int iM70752O = C11842p.m70752O(getContext());
        if (C11842p.m70771U0()) {
            if (C11842p.m70753O0(getContext())) {
                f10 = iM70752O;
                fM70844o = C11842p.m70844o(getContext(), ErrorCode.ERROR_SIGTOOL_FAIL);
            } else {
                f10 = iM70758Q;
                fM70844o = C11842p.m70844o(getContext(), 466);
            }
        } else if (C11842p.m70747M0(getContext())) {
            if (C11842p.m70753O0(getContext())) {
                f10 = iM70752O;
                fM70844o = C11842p.m70844o(getContext(), 540);
            } else {
                f10 = iM70758Q;
                fM70844o = C11842p.m70844o(getContext(), 472);
            }
        } else {
            if (!C11842p.m70753O0(getContext())) {
                return C11842p.m70844o(getContext(), 12);
            }
            f10 = iM70752O;
            fM70844o = C11842p.m70844o(getContext(), 472);
        }
        return (f10 - fM70844o) / 2.0f;
    }

    private float getTextViewSelectionX(TextView textView, int i10) {
        Layout layout = textView.getLayout();
        layout.getLineBounds(layout.getLineForOffset(i10), new Rect());
        return layout.getSecondaryHorizontal(i10);
    }

    private float getTextViewSelectionY(TextView textView, int i10) {
        Layout layout = textView.getLayout();
        layout.getLineBounds(layout.getLineForOffset(i10), new Rect());
        return (r1.top + r1.bottom) / 2.0f;
    }

    private void init() {
        Paint paint = new Paint(4);
        this.mPaint = paint;
        paint.setColor(getResources().getColor(R$color.emui_functional_blue, null));
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) throws Resources.NotFoundException {
        float f10;
        super.onDraw(canvas);
        if (this.mRedDotVisibility == 0) {
            this.mPaint.setColor(-65536);
            Resources resources = getResources();
            if (resources == null || resources.getConfiguration() == null) {
                C11839m.m70687e(TAG, "resources or getConfiguration is null");
                return;
            }
            int length = this.mText.length();
            float textViewSelectionX = getTextViewSelectionX(this, length);
            float textViewSelectionY = getTextViewSelectionY(this, length);
            float dimension = resources.getDimension(R$dimen.urgency_arrow_width) / 2.0f;
            float dimension2 = resources.getDimension(R$dimen.emui10_textParagraphMarginS);
            float textViewMargin = getTextViewMargin();
            if (!C11842p.m70765S0()) {
                int iM70758Q = C11842p.m70758Q(getContext());
                int iM70752O = C11842p.m70752O(getContext());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("x = ");
                sb2.append(textViewSelectionX);
                sb2.append(" length = ");
                sb2.append(length);
                sb2.append(" space = ");
                sb2.append(dimension2);
                sb2.append(" r = ");
                sb2.append(dimension);
                sb2.append(" margin = ");
                sb2.append(textViewMargin);
                sb2.append(" -------  totalWidth = ");
                float f11 = textViewSelectionX + dimension2 + (dimension * 2.0f) + (textViewMargin * 2.0f);
                sb2.append(f11);
                sb2.append(" screenWidth = ");
                sb2.append(iM70758Q);
                sb2.append(" screenHeight = ");
                sb2.append(iM70752O);
                C11839m.m70686d(TAG, sb2.toString());
                if ((resources.getConfiguration().orientation == 1 && f11 > iM70758Q) || (resources.getConfiguration().orientation == 2 && f11 > iM70752O)) {
                    C11839m.m70688i(TAG, "Non-mirror language, there is not enough space to draw a circle.");
                    return;
                }
                f10 = textViewSelectionX + dimension2 + dimension;
            } else {
                if ((textViewSelectionX - dimension2) - (2.0f * dimension) < textViewMargin) {
                    C11839m.m70688i(TAG, "Mirror language, there is not enough space to draw a circle.");
                    return;
                }
                f10 = textViewSelectionX - (dimension2 + dimension);
            }
            canvas.drawCircle(f10, textViewSelectionY, dimension, this.mPaint);
        }
    }

    public void setRedDotVisibility(int i10) {
        this.mRedDotVisibility = i10;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.mText = charSequence.toString();
    }

    public HotTitleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRedDotVisibility = 8;
        this.mText = "";
        init();
    }

    public HotTitleTextView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        init();
    }

    public HotTitleTextView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mRedDotVisibility = 8;
        this.mText = "";
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.hot_title_textview_attr);
        this.mRedDotVisibility = typedArrayObtainStyledAttributes.getInteger(R$styleable.hot_title_textview_attr_red_dot_visibility, 8);
        typedArrayObtainStyledAttributes.recycle();
        init();
    }
}
