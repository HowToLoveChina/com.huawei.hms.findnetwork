package p796y2;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: y2.a */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC13906a implements View.OnTouchListener {

    /* renamed from: a */
    public final Dialog f62259a;

    /* renamed from: b */
    public final int f62260b;

    /* renamed from: c */
    public final int f62261c;

    /* renamed from: d */
    public final int f62262d;

    public ViewOnTouchListenerC13906a(Dialog dialog, Rect rect) {
        this.f62259a = dialog;
        this.f62260b = rect.left;
        this.f62261c = rect.top;
        this.f62262d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f62260b + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, this.f62261c + viewFindViewById.getTop(), width, viewFindViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        view.performClick();
        return this.f62259a.onTouchEvent(motionEventObtain);
    }
}
