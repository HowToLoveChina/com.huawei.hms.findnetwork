package p666u2;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* renamed from: u2.e */
/* loaded from: classes.dex */
public class C13114e extends Property<Drawable, Integer> {

    /* renamed from: b */
    public static final Property<Drawable, Integer> f59604b = new C13114e();

    /* renamed from: a */
    public final WeakHashMap<Drawable, Integer> f59605a;

    public C13114e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f59605a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
