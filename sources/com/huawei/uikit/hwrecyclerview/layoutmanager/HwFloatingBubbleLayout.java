package com.huawei.uikit.hwrecyclerview.layoutmanager;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.security.SecureRandom;

/* loaded from: classes4.dex */
public class HwFloatingBubbleLayout extends FrameLayout {

    /* renamed from: h */
    private static final float f43248h = 2.0f;

    /* renamed from: i */
    private static final float f43249i = 0.9f;

    /* renamed from: j */
    private static final int f43250j = 10;

    /* renamed from: k */
    private static final float f43251k = 100.0f;

    /* renamed from: a */
    private boolean f43252a;

    /* renamed from: b */
    private int f43253b;

    /* renamed from: c */
    private int f43254c;

    /* renamed from: d */
    private Path f43255d;

    /* renamed from: e */
    private Region f43256e;

    /* renamed from: f */
    private float f43257f;

    /* renamed from: g */
    private OnSelectedListener f43258g;

    public interface OnSelectedListener {
        void onSelectedChanged(ViewGroup viewGroup, boolean z10);
    }

    public HwFloatingBubbleLayout(Context context) {
        super(context);
        this.f43252a = false;
        this.f43255d = new Path();
        this.f43257f = 1.0f;
        m54799a();
    }

    /* renamed from: a */
    private void m54799a() {
        this.f43257f = (new SecureRandom().nextInt(10) / f43251k) + 0.9f;
    }

    /* renamed from: b */
    private void m54801b() {
        this.f43256e = new Region();
        this.f43255d.reset();
        float f10 = this.f43253b / 2.0f;
        this.f43255d.addCircle(f10, this.f43254c / 2.0f, f10, Path.Direction.CW);
        this.f43256e.setPath(this.f43255d, new Region(0, 0, this.f43253b, this.f43254c));
    }

    public OnSelectedListener getOnSelectedListener() {
        return this.f43258g;
    }

    public float getRandomFactor() {
        return this.f43257f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m54800a(getParent());
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f43253b = i10;
        this.f43254c = i11;
        m54801b();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (motionEvent.getAction() != 0 || this.f43256e.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.f43258g = onSelectedListener;
    }

    @Override // android.view.View
    public void setSelected(boolean z10) {
        super.setSelected(z10);
        if (z10 != this.f43252a) {
            OnSelectedListener onSelectedListener = this.f43258g;
            if (onSelectedListener != null) {
                onSelectedListener.onSelectedChanged(this, z10);
            }
            this.f43252a = z10;
        }
    }

    /* renamed from: a */
    private void m54800a(ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    public HwFloatingBubbleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f43252a = false;
        this.f43255d = new Path();
        this.f43257f = 1.0f;
        m54799a();
    }

    public HwFloatingBubbleLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f43252a = false;
        this.f43255d = new Path();
        this.f43257f = 1.0f;
        m54799a();
    }
}
