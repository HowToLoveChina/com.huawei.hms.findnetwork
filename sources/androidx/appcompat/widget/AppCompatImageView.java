package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView {
    private final C0518c mBackgroundTintHelper;
    private boolean mHasLevel;
    private final C0532j mImageHelper;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0518c c0518c = this.mBackgroundTintHelper;
        if (c0518c != null) {
            c0518c.m2918b();
        }
        C0532j c0532j = this.mImageHelper;
        if (c0532j != null) {
            c0532j.m3037c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0518c c0518c = this.mBackgroundTintHelper;
        if (c0518c != null) {
            return c0518c.m2919c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0518c c0518c = this.mBackgroundTintHelper;
        if (c0518c != null) {
            return c0518c.m2920d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0532j c0532j = this.mImageHelper;
        if (c0532j != null) {
            return c0532j.m3038d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0532j c0532j = this.mImageHelper;
        if (c0532j != null) {
            return c0532j.m3039e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.mImageHelper.m3040f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0518c c0518c = this.mBackgroundTintHelper;
        if (c0518c != null) {
            c0518c.m2922f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0518c c0518c = this.mBackgroundTintHelper;
        if (c0518c != null) {
            c0518c.m2923g(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0532j c0532j = this.mImageHelper;
        if (c0532j != null) {
            c0532j.m3037c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0532j c0532j = this.mImageHelper;
        if (c0532j != null && drawable != null && !this.mHasLevel) {
            c0532j.m3042h(drawable);
        }
        super.setImageDrawable(drawable);
        C0532j c0532j2 = this.mImageHelper;
        if (c0532j2 != null) {
            c0532j2.m3037c();
            if (this.mHasLevel) {
                return;
            }
            this.mImageHelper.m3036b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        C0532j c0532j = this.mImageHelper;
        if (c0532j != null) {
            c0532j.m3043i(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0532j c0532j = this.mImageHelper;
        if (c0532j != null) {
            c0532j.m3037c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0518c c0518c = this.mBackgroundTintHelper;
        if (c0518c != null) {
            c0518c.m2925i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0518c c0518c = this.mBackgroundTintHelper;
        if (c0518c != null) {
            c0518c.m2926j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0532j c0532j = this.mImageHelper;
        if (c0532j != null) {
            c0532j.m3044j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0532j c0532j = this.mImageHelper;
        if (c0532j != null) {
            c0532j.m3045k(mode);
        }
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i10) {
        super(C0517b0.m2916b(context), attributeSet, i10);
        this.mHasLevel = false;
        C0515a0.m2890a(this, getContext());
        C0518c c0518c = new C0518c(this);
        this.mBackgroundTintHelper = c0518c;
        c0518c.m2921e(attributeSet, i10);
        C0532j c0532j = new C0532j(this);
        this.mImageHelper = c0532j;
        c0532j.m3041g(attributeSet, i10);
    }
}
