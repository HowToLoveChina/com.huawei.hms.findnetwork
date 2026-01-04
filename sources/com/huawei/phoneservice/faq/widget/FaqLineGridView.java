package com.huawei.phoneservice.faq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.huawei.phoneservice.faq.R$color;
import com.huawei.phoneservice.faq.base.util.FaqUiUtils;

/* loaded from: classes4.dex */
public class FaqLineGridView extends GridView {

    /* renamed from: a */
    public Context f39300a;

    public FaqLineGridView(Context context) {
        super(context);
        this.f39300a = context;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float left;
        float top;
        int left2;
        float left3;
        float top2;
        int left4;
        float bottom;
        float width;
        float bottom2;
        float left5;
        int left6;
        int top3;
        super.dispatchDraw(canvas);
        if (getChildAt(0) != null) {
            int numColumns = getNumColumns();
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(getContext().getResources().getColor(R$color.faq_sdk_grid_divider_color));
            int childCount = getChildCount();
            int i10 = 0;
            while (i10 < childCount) {
                View childAt = getChildAt(i10);
                int i11 = i10 + 1;
                if (i11 % numColumns == 0) {
                    left5 = childAt.getLeft();
                    top3 = childAt.getBottom();
                } else if (i11 <= childCount - (childCount % numColumns)) {
                    if (FaqUiUtils.isRtlLayout(this.f39300a)) {
                        left3 = childAt.getLeft();
                        top2 = childAt.getTop();
                        left4 = childAt.getLeft();
                    } else {
                        left3 = childAt.getRight();
                        top2 = childAt.getTop();
                        left4 = childAt.getRight();
                    }
                    canvas.drawLine(left3, top2, left4, childAt.getBottom(), paint);
                    bottom = childAt.getBottom();
                    width = getWidth();
                    bottom2 = childAt.getBottom();
                    left5 = 0.0f;
                    canvas.drawLine(left5, bottom, width, bottom2, paint);
                    i10 = i11;
                } else if (FaqUiUtils.isRtlLayout(this.f39300a)) {
                    left5 = childAt.getLeft();
                    bottom = childAt.getTop();
                    left6 = childAt.getLeft();
                    width = left6;
                    bottom2 = childAt.getBottom();
                    canvas.drawLine(left5, bottom, width, bottom2, paint);
                    i10 = i11;
                } else {
                    left5 = childAt.getRight();
                    top3 = childAt.getTop();
                }
                bottom = top3;
                left6 = childAt.getRight();
                width = left6;
                bottom2 = childAt.getBottom();
                canvas.drawLine(left5, bottom, width, bottom2, paint);
                i10 = i11;
            }
            int i12 = childCount % numColumns;
            if (i12 != 0) {
                View childAt2 = getChildAt(childCount - 1);
                for (int i13 = 0; i13 < numColumns - i12; i13++) {
                    if (FaqUiUtils.isRtlLayout(this.f39300a)) {
                        left = childAt2.getLeft() - (childAt2.getWidth() * i13);
                        top = childAt2.getTop();
                        left2 = childAt2.getLeft() - (childAt2.getWidth() * i13);
                    } else {
                        left = childAt2.getRight() + (childAt2.getWidth() * i13);
                        top = childAt2.getTop();
                        left2 = childAt2.getRight() + (childAt2.getWidth() * i13);
                    }
                    canvas.drawLine(left, top, left2, childAt2.getBottom(), paint);
                }
                canvas.drawLine(0.0f, childAt2.getBottom(), getWidth(), childAt2.getBottom(), paint);
            }
        }
    }

    public FaqLineGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39300a = context;
    }

    public FaqLineGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f39300a = context;
    }
}
