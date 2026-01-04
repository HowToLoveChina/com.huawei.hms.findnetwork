package com.huawei.android.hicloud.p088ui.uiextend.cloudpay;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class LearnMoreLinkTouchMovementMethod extends LinkMovementMethod {
    private LearnMorePayClickSpan mClickSpans;

    private LearnMorePayClickSpan getPressedSpan(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
        int scrollY = y10 + textView.getScrollY();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        LearnMorePayClickSpan[] learnMorePayClickSpanArr = (LearnMorePayClickSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, LearnMorePayClickSpan.class);
        if (learnMorePayClickSpanArr.length > 0) {
            return learnMorePayClickSpanArr[0];
        }
        return null;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            LearnMorePayClickSpan pressedSpan = getPressedSpan(textView, spannable, motionEvent);
            this.mClickSpans = pressedSpan;
            if (pressedSpan != null) {
                pressedSpan.setPressed(true);
                Selection.setSelection(spannable, spannable.getSpanStart(this.mClickSpans), spannable.getSpanEnd(this.mClickSpans));
            }
        } else if (2 == motionEvent.getAction()) {
            LearnMorePayClickSpan pressedSpan2 = getPressedSpan(textView, spannable, motionEvent);
            LearnMorePayClickSpan learnMorePayClickSpan = this.mClickSpans;
            if (learnMorePayClickSpan != null && pressedSpan2 != learnMorePayClickSpan) {
                learnMorePayClickSpan.setPressed(false);
                this.mClickSpans = null;
                Selection.removeSelection(spannable);
            }
        } else {
            Selection.removeSelection(spannable);
            LearnMorePayClickSpan learnMorePayClickSpan2 = this.mClickSpans;
            if (learnMorePayClickSpan2 == null) {
                return true;
            }
            learnMorePayClickSpan2.setPressed(false);
            this.mClickSpans = null;
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
