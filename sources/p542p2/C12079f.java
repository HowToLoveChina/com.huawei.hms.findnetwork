package p542p2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* renamed from: p2.f */
/* loaded from: classes.dex */
public class C12079f {
    /* renamed from: a */
    public <Z> AbstractC12083j<ImageView, Z> m72236a(ImageView imageView, Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new C12075b(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new C12077d(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
