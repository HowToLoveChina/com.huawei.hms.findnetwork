package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        m5616w0();
    }

    /* renamed from: w0 */
    public final void m5616w0() {
        m5766t0(1);
        m5758l0(new Fade(2)).m5758l0(new ChangeBounds()).m5758l0(new Fade(1));
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5616w0();
    }
}
