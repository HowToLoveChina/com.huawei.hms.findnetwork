package p306g2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;
import p003a2.C0010e;
import p003a2.InterfaceC0009d;
import p829z1.InterfaceC14083v;

/* renamed from: g2.o */
/* loaded from: classes.dex */
public final class C9863o {

    /* renamed from: a */
    public static final InterfaceC0009d f48456a = new a();

    /* renamed from: g2.o$a */
    public class a extends C0010e {
        @Override // p003a2.C0010e, p003a2.InterfaceC0009d
        /* renamed from: b */
        public void mo15b(Bitmap bitmap) {
        }
    }

    /* renamed from: a */
    public static InterfaceC14083v<Bitmap> m61287a(InterfaceC0009d interfaceC0009d, Drawable drawable, int i10, int i11) {
        Bitmap bitmapM61288b;
        Drawable current = drawable.getCurrent();
        boolean z10 = false;
        if (current instanceof BitmapDrawable) {
            bitmapM61288b = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapM61288b = null;
        } else {
            bitmapM61288b = m61288b(interfaceC0009d, current, i10, i11);
            z10 = true;
        }
        if (!z10) {
            interfaceC0009d = f48456a;
        }
        return C9853e.m61232e(bitmapM61288b, interfaceC0009d);
    }

    /* renamed from: b */
    public static Bitmap m61288b(InterfaceC0009d interfaceC0009d, Drawable drawable, int i10, int i11) {
        if (i10 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i11 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i10 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i11 = drawable.getIntrinsicHeight();
        }
        Lock lockM61216i = C9848a0.m61216i();
        lockM61216i.lock();
        Bitmap bitmapMo16c = interfaceC0009d.mo16c(i10, i11, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapMo16c);
            drawable.setBounds(0, 0, i10, i11);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmapMo16c;
        } finally {
            lockM61216i.unlock();
        }
    }
}
