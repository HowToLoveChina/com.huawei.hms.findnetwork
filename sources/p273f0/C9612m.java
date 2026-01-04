package p273f0;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: f0.m */
/* loaded from: classes.dex */
public final class C9612m {

    /* renamed from: a */
    public final a f47722a;

    /* renamed from: f0.m$a */
    public interface a {
        /* renamed from: a */
        boolean mo60100a(MotionEvent motionEvent);
    }

    /* renamed from: f0.m$b */
    public static class b implements a {

        /* renamed from: a */
        public final GestureDetector f47723a;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f47723a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // p273f0.C9612m.a
        /* renamed from: a */
        public boolean mo60100a(MotionEvent motionEvent) {
            return this.f47723a.onTouchEvent(motionEvent);
        }
    }

    public C9612m(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    /* renamed from: a */
    public boolean m60099a(MotionEvent motionEvent) {
        return this.f47722a.mo60100a(motionEvent);
    }

    public C9612m(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f47722a = new b(context, onGestureListener, handler);
    }
}
