package p398jj;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: jj.b */
/* loaded from: classes5.dex */
public class ViewOnTouchListenerC10893b implements View.OnTouchListener {

    /* renamed from: a */
    public Context f51725a;

    /* renamed from: b */
    public View f51726b;

    /* renamed from: c */
    public int f51727c;

    public ViewOnTouchListenerC10893b(Context context, View view, int i10) {
        this.f51725a = context;
        this.f51726b = view;
        this.f51727c = i10;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f51725a != null && this.f51726b != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f51726b.setForeground(this.f51725a.getDrawable(this.f51727c));
            } else if (action == 1 || action == 3) {
                this.f51726b.setForeground(null);
            }
        }
        return false;
    }
}
