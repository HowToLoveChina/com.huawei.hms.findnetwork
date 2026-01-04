package p398jj;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.cloud.pay.R$drawable;

/* renamed from: jj.c */
/* loaded from: classes5.dex */
public class ViewOnTouchListenerC10894c implements View.OnTouchListener {

    /* renamed from: a */
    public final Context f51728a;

    /* renamed from: b */
    public final LinearLayout f51729b;

    public ViewOnTouchListenerC10894c(Context context, LinearLayout linearLayout) {
        this.f51728a = context;
        this.f51729b = linearLayout;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent == null || this.f51729b == null || this.f51728a == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f51729b.setBackground(this.f51728a.getDrawable(R$drawable.payment_tab_press));
        } else if (action == 1 || action == 3) {
            this.f51729b.setBackground(null);
            view.performClick();
        }
        return true;
    }
}
