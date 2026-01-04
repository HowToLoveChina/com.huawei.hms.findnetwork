package com.huawei.phoneservice.feedback.media.impl.wiget.pictureview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes5.dex */
public class PictureView extends AppCompatImageView {

    /* renamed from: a */
    public ViewOnTouchListenerC8489k f39551a;

    /* renamed from: b */
    public ImageView.ScaleType f39552b;

    public PictureView(Context context) {
        this(context, null);
    }

    /* renamed from: c */
    private void m52652c() {
        this.f39551a = new ViewOnTouchListenerC8489k(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f39552b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f39552b = null;
        }
    }

    public ViewOnTouchListenerC8489k getAttaches() {
        return this.f39551a;
    }

    public RectF getDisplayRect() {
        return this.f39551a.m52697N();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f39551a.m52701T();
    }

    public float getMaximumScale() {
        return this.f39551a.m52703W();
    }

    public float getMediumScale() {
        return this.f39551a.m52704Y();
    }

    public float getMinimumScale() {
        return this.f39551a.m52706a0();
    }

    public float getScale() {
        return this.f39551a.m52708c0();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f39551a.m52710e0();
    }

    public void setAllowParentInterceptOnEdge(boolean z10) {
        this.f39551a.m52731x(z10);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i10, int i11, int i12, int i13) {
        boolean frame = super.setFrame(i10, i11, i12, i13);
        if (frame) {
            this.f39551a.m52718k0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        ViewOnTouchListenerC8489k viewOnTouchListenerC8489k = this.f39551a;
        if (viewOnTouchListenerC8489k != null) {
            viewOnTouchListenerC8489k.m52718k0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        super.setImageResource(i10);
        ViewOnTouchListenerC8489k viewOnTouchListenerC8489k = this.f39551a;
        if (viewOnTouchListenerC8489k != null) {
            viewOnTouchListenerC8489k.m52718k0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        ViewOnTouchListenerC8489k viewOnTouchListenerC8489k = this.f39551a;
        if (viewOnTouchListenerC8489k != null) {
            viewOnTouchListenerC8489k.m52718k0();
        }
    }

    public void setMaximumScale(float f10) {
        this.f39551a.m52712h(f10);
    }

    public void setMediumScale(float f10) {
        this.f39551a.m52692H(f10);
    }

    public void setMinimumScale(float f10) {
        this.f39551a.m52695L(f10);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f39551a.m52721n(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f39551a.m52720m(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f39551a.m52722o(onLongClickListener);
    }

    public void setOnMatrixChangeListener(InterfaceC8482d interfaceC8482d) {
        this.f39551a.m52724q(interfaceC8482d);
    }

    public void setOnOutsidePhotoTapListener(InterfaceC8483e interfaceC8483e) {
        this.f39551a.m52725r(interfaceC8483e);
    }

    public void setOnPhotoTapListener(InterfaceC8484f interfaceC8484f) {
        this.f39551a.m52726s(interfaceC8484f);
    }

    public void setOnScaleChangeListener(InterfaceC8485g interfaceC8485g) {
        this.f39551a.m52727t(interfaceC8485g);
    }

    public void setOnSingleFlingListener(InterfaceC8486h interfaceC8486h) {
        this.f39551a.m52728u(interfaceC8486h);
    }

    public void setOnViewDragListener(InterfaceC8487i interfaceC8487i) {
        this.f39551a.m52729v(interfaceC8487i);
    }

    public void setOnViewTapListener(InterfaceC8488j interfaceC8488j) {
        this.f39551a.m52730w(interfaceC8488j);
    }

    public void setRotationBy(float f10) {
        this.f39551a.m52698P(f10);
    }

    public void setRotationTo(float f10) {
        this.f39551a.m52700S(f10);
    }

    public void setScale(float f10) {
        this.f39551a.m52702V(f10);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        ViewOnTouchListenerC8489k viewOnTouchListenerC8489k = this.f39551a;
        if (viewOnTouchListenerC8489k == null) {
            this.f39552b = scaleType;
        } else {
            viewOnTouchListenerC8489k.m52723p(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i10) {
        this.f39551a.m52717k(i10);
    }

    public void setZoomable(boolean z10) {
        this.f39551a.m52694J(z10);
    }

    public PictureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PictureView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m52652c();
    }
}
