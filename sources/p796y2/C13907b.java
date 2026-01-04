package p796y2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;

/* renamed from: y2.b */
/* loaded from: classes.dex */
public class C13907b {
    /* renamed from: a */
    public static Rect m83327a(Context context, int i10, int i11) {
        TypedArray typedArrayM10770h = C1784o.m10770h(context, null, R$styleable.MaterialAlertDialog, i10, i11, new int[0]);
        int dimensionPixelSize = typedArrayM10770h.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetStart, context.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayM10770h.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetTop, context.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayM10770h.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetEnd, context.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayM10770h.getDimensionPixelSize(R$styleable.MaterialAlertDialog_backgroundInsetBottom, context.getResources().getDimensionPixelSize(R$dimen.mtrl_alert_dialog_background_inset_bottom));
        typedArrayM10770h.recycle();
        if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        return new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
    }

    /* renamed from: b */
    public static InsetDrawable m83328b(Drawable drawable, Rect rect) {
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }
}
