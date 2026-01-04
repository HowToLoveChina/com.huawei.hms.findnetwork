package p398jj;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* renamed from: jj.d */
/* loaded from: classes5.dex */
public class ViewTreeObserverOnGlobalLayoutListenerC10895d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    public final WeakReference<TextView> f51730a;

    public ViewTreeObserverOnGlobalLayoutListenerC10895d(TextView textView) {
        this.f51730a = new WeakReference<>(textView);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        TextView textView = this.f51730a.get();
        if (textView == null) {
            return;
        }
        textView.requestLayout();
    }
}
