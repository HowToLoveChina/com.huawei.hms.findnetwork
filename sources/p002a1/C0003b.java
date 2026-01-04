package p002a1;

import android.content.Context;
import android.content.res.Resources;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* renamed from: a1.b */
/* loaded from: classes.dex */
public class C0003b {
    /* renamed from: a */
    public static Interpolator m4a(Context context, int i10) throws Resources.NotFoundException {
        return AnimationUtils.loadInterpolator(context, i10);
    }
}
