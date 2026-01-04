package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton {

    /* renamed from: a */
    public final C0518c f1902a;

    /* renamed from: b */
    public final C0532j f1903b;

    /* renamed from: c */
    public boolean f1904c;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0518c c0518c = this.f1902a;
        if (c0518c != null) {
            c0518c.m2918b();
        }
        C0532j c0532j = this.f1903b;
        if (c0532j != null) {
            c0532j.m3037c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0518c c0518c = this.f1902a;
        if (c0518c != null) {
            return c0518c.m2919c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0518c c0518c = this.f1902a;
        if (c0518c != null) {
            return c0518c.m2920d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0532j c0532j = this.f1903b;
        if (c0532j != null) {
            return c0532j.m3038d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0532j c0532j = this.f1903b;
        if (c0532j != null) {
            return c0532j.m3039e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f1903b.m3040f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0518c c0518c = this.f1902a;
        if (c0518c != null) {
            c0518c.m2922f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0518c c0518c = this.f1902a;
        if (c0518c != null) {
            c0518c.m2923g(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0532j c0532j = this.f1903b;
        if (c0532j != null) {
            c0532j.m3037c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0532j c0532j = this.f1903b;
        if (c0532j != null && drawable != null && !this.f1904c) {
            c0532j.m3042h(drawable);
        }
        super.setImageDrawable(drawable);
        C0532j c0532j2 = this.f1903b;
        if (c0532j2 != null) {
            c0532j2.m3037c();
            if (this.f1904c) {
                return;
            }
            this.f1903b.m3036b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.f1904c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        this.f1903b.m3043i(i10);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0532j c0532j = this.f1903b;
        if (c0532j != null) {
            c0532j.m3037c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0518c c0518c = this.f1902a;
        if (c0518c != null) {
            c0518c.m2925i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0518c c0518c = this.f1902a;
        if (c0518c != null) {
            c0518c.m2926j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0532j c0532j = this.f1903b;
        if (c0532j != null) {
            c0532j.m3044j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0532j c0532j = this.f1903b;
        if (c0532j != null) {
            c0532j.m3045k(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i10) {
        super(C0517b0.m2916b(context), attributeSet, i10);
        this.f1904c = false;
        C0515a0.m2890a(this, getContext());
        C0518c c0518c = new C0518c(this);
        this.f1902a = c0518c;
        c0518c.m2921e(attributeSet, i10);
        C0532j c0532j = new C0532j(this);
        this.f1903b = c0532j;
        c0532j.m3041g(attributeSet, i10);
    }
}
