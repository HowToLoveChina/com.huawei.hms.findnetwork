package com.huawei.uikit.phone.hwedittext.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.huawei.uikit.phone.hwunifiedinteract.widget.HwKeyEventDetector;

/* loaded from: classes9.dex */
public class HwEditText extends com.huawei.uikit.hwedittext.widget.HwEditText {

    /* renamed from: e */
    private static final String f44974e = "HwEditText";

    /* renamed from: a */
    private boolean f44975a;

    /* renamed from: b */
    private boolean f44976b;

    /* renamed from: c */
    private boolean f44977c;

    /* renamed from: d */
    private int f44978d;

    public HwEditText(Context context) {
        super(context);
        this.f44977c = false;
        this.f44978d = 0;
    }

    /* renamed from: a */
    private boolean m55993a(boolean z10, boolean z11) {
        return (this.f44975a && this.f44976b) != (z10 && z11);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent != null && !(this.f44978d == 1 && isDirectionalNavigationKey(keyEvent.getKeyCode())) && super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.huawei.uikit.hwedittext.widget.HwEditText, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f44975a = hasFocus();
        boolean zHasWindowFocus = hasWindowFocus();
        this.f44976b = zHasWindowFocus;
        this.f44977c = this.f44975a && zHasWindowFocus;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            Log.d(f44974e, "onDraw: canvas is null.");
            return;
        }
        super.onDraw(canvas);
        if (this.f44978d == 1 && this.f44977c) {
            drawFocusLayer(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (m55993a(z10, this.f44976b)) {
            this.f44977c = z10;
        }
        this.f44975a = z10;
        if (z10 && this.f44978d == 0) {
            if (isInTouchMode()) {
                this.f44978d = 3;
                setCursorVisible(true);
            } else {
                this.f44978d = 1;
                setCursorVisible(false);
            }
        }
        if (z10) {
            return;
        }
        if (this.f44978d != 3) {
            hideSoftInput();
        }
        this.f44978d = 0;
    }

    @Override // com.huawei.uikit.hwedittext.widget.HwEditText, android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        if (i10 == 4 || i10 == 3 || i10 == 124) {
            return super.onKeyPreIme(i10, keyEvent);
        }
        if (this.f44978d == 3 && i10 != 746) {
            this.f44978d = 2;
            hideSoftInput();
        }
        if (this.f44978d != 1) {
            m55992a(i10, keyEvent);
            if (this.f44978d != 2 || i10 != 111) {
                return super.onKeyPreIme(i10, keyEvent);
            }
            this.f44978d = 1;
            setCursorVisible(false);
            return true;
        }
        if (isDirectionalNavigationKey(i10) || i10 == 111) {
            return false;
        }
        if (i10 == 61 && keyEvent.getAction() == 0) {
            handleTabKeyEvent(keyEvent);
        }
        if (isConfirmKey(i10) && keyEvent.getAction() == 1) {
            this.f44978d = 2;
            setCursorVisible(true);
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Log.d(f44974e, "onRestoreInstanceState()");
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        try {
            this.f44978d = bundle.getInt("ViewState");
            setCursorVisible(bundle.getBoolean("CursorState"));
            Parcelable parcelable2 = bundle.getParcelable("InstanceState");
            if (parcelable2 != null) {
                super.onRestoreInstanceState(parcelable2);
            }
        } catch (BadParcelableException unused) {
            Log.e(f44974e, "Parcelable, onRestoreInstanceState error");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        try {
            bundle.putParcelable("InstanceState", super.onSaveInstanceState());
            bundle.putInt("ViewState", this.f44978d);
            bundle.putBoolean("CursorState", isCursorVisible());
        } catch (BadParcelableException unused) {
            Log.e(f44974e, "Parcelable, onSaveInstanceState error.");
        }
        return bundle;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            setCursorVisible(true);
            this.f44978d = 3;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (m55993a(this.f44975a, z10)) {
            this.f44977c = z10;
            if (getFocusedDrawable() != null) {
                invalidate();
            }
        }
        this.f44976b = z10;
    }

    public void requestFocusInTouchMode() {
        this.f44978d = 3;
        requestFocus();
    }

    /* renamed from: a */
    private void m55992a(int i10, KeyEvent keyEvent) {
        if (this.f44978d == 4 && keyEvent.getAction() == 1 && isAltKey(i10)) {
            this.f44978d = 3;
        } else {
            if (!isShiftKey(i10) || (keyEvent.getMetaState() & 2) == 0) {
                return;
            }
            this.f44978d = 4;
        }
    }

    @Override // com.huawei.uikit.hwedittext.widget.HwEditText
    public HwKeyEventDetector createKeyEventDetector() {
        return new HwKeyEventDetector(getContext());
    }

    public HwEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44977c = false;
        this.f44978d = 0;
    }

    public HwEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f44977c = false;
        this.f44978d = 0;
    }
}
