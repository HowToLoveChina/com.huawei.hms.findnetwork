package com.huawei.hicloud.base.view.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;

/* loaded from: classes6.dex */
public class TextOnClickTextView extends HwTextView {

    /* renamed from: Q */
    public final GestureDetector f22183Q;

    /* renamed from: com.huawei.hicloud.base.view.widget.TextOnClickTextView$a */
    public class GestureDetectorOnGestureListenerC4862a implements GestureDetector.OnGestureListener {

        /* renamed from: a */
        public final TextView f22184a;

        public GestureDetectorOnGestureListenerC4862a(TextView textView) {
            this.f22184a = textView;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            int y10 = (int) motionEvent.getY();
            int x10 = (int) motionEvent.getX();
            int totalPaddingTop = (y10 - this.f22184a.getTotalPaddingTop()) + this.f22184a.getScrollY();
            int totalPaddingLeft = (x10 - this.f22184a.getTotalPaddingLeft()) + this.f22184a.getScrollX();
            Layout layout = this.f22184a.getLayout();
            int lineForVertical = layout.getLineForVertical(totalPaddingTop);
            float f10 = totalPaddingLeft;
            if (f10 > layout.getLineRight(lineForVertical) || f10 < layout.getLineLeft(lineForVertical)) {
                return true;
            }
            this.f22184a.performClick();
            return true;
        }
    }

    public TextOnClickTextView(Context context) {
        super(context);
        this.f22183Q = new GestureDetector(getContext(), new GestureDetectorOnGestureListenerC4862a(this));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f22183Q.onTouchEvent(motionEvent);
    }

    public TextOnClickTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22183Q = new GestureDetector(getContext(), new GestureDetectorOnGestureListenerC4862a(this));
    }

    public TextOnClickTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22183Q = new GestureDetector(getContext(), new GestureDetectorOnGestureListenerC4862a(this));
    }
}
