package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.appcompat.widget.a */
/* loaded from: classes.dex */
public class C0514a extends Drawable {

    /* renamed from: a */
    public final ActionBarContainer f2258a;

    /* renamed from: androidx.appcompat.widget.a$a */
    public static class a {
        /* renamed from: a */
        public static void m2889a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public C0514a(ActionBarContainer actionBarContainer) {
        this.f2258a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f2258a;
        if (actionBarContainer.f1748h) {
            Drawable drawable = actionBarContainer.f1747g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f1745e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f2258a;
        Drawable drawable3 = actionBarContainer2.f1746f;
        if (drawable3 == null || !actionBarContainer2.f1749i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f2258a;
        if (actionBarContainer.f1748h) {
            if (actionBarContainer.f1747g != null) {
                a.m2889a(actionBarContainer.f1745e, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f1745e;
            if (drawable != null) {
                a.m2889a(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
