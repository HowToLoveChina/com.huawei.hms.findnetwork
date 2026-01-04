package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.d0 */
/* loaded from: classes.dex */
public class C0521d0 extends C0549x {

    /* renamed from: b */
    public final WeakReference<Context> f2311b;

    public C0521d0(Context context, Resources resources) {
        super(resources);
        this.f2311b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10) throws Resources.NotFoundException {
        Drawable drawableM3181a = m3181a(i10);
        Context context = this.f2311b.get();
        if (drawableM3181a != null && context != null) {
            C0548w.m3156g().m3176w(context, i10, drawableM3181a);
        }
        return drawableM3181a;
    }
}
