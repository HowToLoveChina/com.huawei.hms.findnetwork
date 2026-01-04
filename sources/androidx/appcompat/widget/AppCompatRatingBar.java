package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {

    /* renamed from: a */
    public final C0534k f1915a;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Bitmap bitmapM3050b = this.f1915a.m3050b();
        if (bitmapM3050b != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapM3050b.getWidth() * getNumStars(), i10, 0), getMeasuredHeight());
        }
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        C0515a0.m2890a(this, getContext());
        C0534k c0534k = new C0534k(this);
        this.f1915a = c0534k;
        c0534k.mo3051c(attributeSet, i10);
    }
}
