package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import p757x.InterfaceC13673e;

/* renamed from: androidx.appcompat.widget.k */
/* loaded from: classes.dex */
public class C0534k {

    /* renamed from: c */
    public static final int[] f2365c = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a */
    public final ProgressBar f2366a;

    /* renamed from: b */
    public Bitmap f2367b;

    /* renamed from: androidx.appcompat.widget.k$a */
    public static class a {
        /* renamed from: a */
        public static void m3054a(LayerDrawable layerDrawable, LayerDrawable layerDrawable2, int i10) {
            layerDrawable2.setLayerGravity(i10, layerDrawable.getLayerGravity(i10));
            layerDrawable2.setLayerWidth(i10, layerDrawable.getLayerWidth(i10));
            layerDrawable2.setLayerHeight(i10, layerDrawable.getLayerHeight(i10));
            layerDrawable2.setLayerInsetLeft(i10, layerDrawable.getLayerInsetLeft(i10));
            layerDrawable2.setLayerInsetRight(i10, layerDrawable.getLayerInsetRight(i10));
            layerDrawable2.setLayerInsetTop(i10, layerDrawable.getLayerInsetTop(i10));
            layerDrawable2.setLayerInsetBottom(i10, layerDrawable.getLayerInsetBottom(i10));
            layerDrawable2.setLayerInsetStart(i10, layerDrawable.getLayerInsetStart(i10));
            layerDrawable2.setLayerInsetEnd(i10, layerDrawable.getLayerInsetEnd(i10));
        }
    }

    public C0534k(ProgressBar progressBar) {
        this.f2366a = progressBar;
    }

    /* renamed from: a */
    public final Shape m3049a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* renamed from: b */
    public Bitmap m3050b() {
        return this.f2367b;
    }

    /* renamed from: c */
    public void mo3051c(AttributeSet attributeSet, int i10) {
        C0523e0 c0523e0M2946v = C0523e0.m2946v(this.f2366a.getContext(), attributeSet, f2365c, i10, 0);
        Drawable drawableM2954h = c0523e0M2946v.m2954h(0);
        if (drawableM2954h != null) {
            this.f2366a.setIndeterminateDrawable(m3053e(drawableM2954h));
        }
        Drawable drawableM2954h2 = c0523e0M2946v.m2954h(1);
        if (drawableM2954h2 != null) {
            this.f2366a.setProgressDrawable(m3052d(drawableM2954h2, false));
        }
        c0523e0M2946v.m2966w();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public Drawable m3052d(Drawable drawable, boolean z10) {
        if (drawable instanceof InterfaceC13673e) {
            InterfaceC13673e interfaceC13673e = (InterfaceC13673e) drawable;
            Drawable drawableM82257b = interfaceC13673e.m82257b();
            if (drawableM82257b != null) {
                interfaceC13673e.m82256a(m3052d(drawableM82257b, z10));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    int id2 = layerDrawable.getId(i10);
                    drawableArr[i10] = m3052d(layerDrawable.getDrawable(i10), id2 == 16908301 || id2 == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i11 = 0; i11 < numberOfLayers; i11++) {
                    layerDrawable2.setId(i11, layerDrawable.getId(i11));
                    a.m3054a(layerDrawable, layerDrawable2, i11);
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f2367b == null) {
                    this.f2367b = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(m3049a());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z10 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    /* renamed from: e */
    public final Drawable m3053e(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i10 = 0; i10 < numberOfFrames; i10++) {
            Drawable drawableM3052d = m3052d(animationDrawable.getFrame(i10), true);
            drawableM3052d.setLevel(10000);
            animationDrawable2.addFrame(drawableM3052d, animationDrawable.getDuration(i10));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }
}
