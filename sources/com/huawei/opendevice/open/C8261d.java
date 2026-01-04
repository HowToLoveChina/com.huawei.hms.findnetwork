package com.huawei.opendevice.open;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* renamed from: com.huawei.opendevice.open.d */
/* loaded from: classes2.dex */
public class C8261d extends LinkMovementMethod {

    /* renamed from: a */
    public int f38483a;

    /* renamed from: b */
    public int f38484b;

    public C8261d(int i10, int i11) {
        this.f38484b = i10;
        this.f38483a = i11;
    }

    /* renamed from: a */
    public final ClickableSpan[] m51592a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y10 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        return (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            ClickableSpan[] clickableSpanArrM51592a = m51592a(textView, spannable, motionEvent);
            if (clickableSpanArrM51592a.length != 0) {
                clickableSpanArrM51592a[0].onClick(textView);
                if (this.f38484b != 0) {
                    spannable.setSpan(new ForegroundColorSpan(this.f38484b), spannable.getSpanStart(clickableSpanArrM51592a[0]), spannable.getSpanEnd(clickableSpanArrM51592a[0]), 33);
                }
                return true;
            }
        } else {
            if (action != 0) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            ClickableSpan[] clickableSpanArrM51592a2 = m51592a(textView, spannable, motionEvent);
            if (clickableSpanArrM51592a2.length != 0) {
                if (this.f38483a != 0) {
                    spannable.setSpan(new ForegroundColorSpan(this.f38483a), spannable.getSpanStart(clickableSpanArrM51592a2[0]), spannable.getSpanEnd(clickableSpanArrM51592a2[0]), 33);
                }
                return true;
            }
        }
        Selection.removeSelection(spannable);
        Touch.onTouchEvent(textView, spannable, motionEvent);
        return false;
    }
}
