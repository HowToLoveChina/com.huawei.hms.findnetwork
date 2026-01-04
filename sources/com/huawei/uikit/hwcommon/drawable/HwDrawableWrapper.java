package com.huawei.uikit.hwcommon.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import java.util.Arrays;

@TargetApi(23)
/* loaded from: classes7.dex */
public class HwDrawableWrapper extends DrawableWrapper {

    /* renamed from: a */
    private ColorStateList f42065a;

    /* renamed from: b */
    private int[] f42066b;

    /* renamed from: c */
    private OnStateChangedListener f42067c;

    public interface OnStateChangedListener {
        void onStateChanged(int[] iArr, int[] iArr2, int i10, int i11);
    }

    public HwDrawableWrapper(Drawable drawable, ColorStateList colorStateList) {
        super(drawable instanceof HwDrawableWrapper ? ((HwDrawableWrapper) drawable).getDrawable() : drawable);
        this.f42065a = colorStateList;
    }

    public OnStateChangedListener getOnStateChangedListener() {
        return this.f42067c;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f42065a.isStateful();
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (getDrawable() != null) {
            int colorForState = this.f42065a.getColorForState(iArr, 0);
            int colorForState2 = this.f42065a.getColorForState(this.f42066b, 0);
            OnStateChangedListener onStateChangedListener = this.f42067c;
            if (onStateChangedListener != null) {
                onStateChangedListener.onStateChanged(iArr, this.f42066b, colorForState, colorForState2);
            }
        }
        return super.onStateChange(iArr);
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.f42067c = onStateChangedListener;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        int[] state = getState();
        this.f42066b = Arrays.copyOf(state, state.length);
        return super.setState(iArr);
    }
}
