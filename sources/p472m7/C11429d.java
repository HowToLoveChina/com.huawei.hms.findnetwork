package p472m7;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

/* renamed from: m7.d */
/* loaded from: classes2.dex */
public class C11429d extends LinkMovementMethod {

    /* renamed from: a */
    public C11428c f53269a;

    /* renamed from: a */
    public final C11428c m68477a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y10 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        C11428c[] c11428cArr = (C11428c[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, C11428c.class);
        if (c11428cArr.length > 0) {
            return c11428cArr[0];
        }
        return null;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            C11428c c11428cM68477a = m68477a(textView, spannable, motionEvent);
            this.f53269a = c11428cM68477a;
            if (c11428cM68477a != null) {
                c11428cM68477a.m68476d(true);
                Selection.setSelection(spannable, spannable.getSpanStart(this.f53269a), spannable.getSpanEnd(this.f53269a));
            }
        } else if (2 == motionEvent.getAction()) {
            C11428c c11428cM68477a2 = m68477a(textView, spannable, motionEvent);
            C11428c c11428c = this.f53269a;
            if (c11428c != null && c11428cM68477a2 != c11428c) {
                c11428c.m68476d(false);
                this.f53269a = null;
                Selection.removeSelection(spannable);
            }
        } else {
            Selection.removeSelection(spannable);
            C11428c c11428c2 = this.f53269a;
            if (c11428c2 == null) {
                return true;
            }
            c11428c2.m68476d(false);
            this.f53269a = null;
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
