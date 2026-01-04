package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: androidx.transition.j */
/* loaded from: classes.dex */
public class C0947j {
    /* renamed from: a */
    public static <T> ObjectAnimator m5823a(T t10, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t10, property, (TypeConverter) null, path);
    }
}
