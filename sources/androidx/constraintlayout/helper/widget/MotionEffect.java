package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class MotionEffect extends MotionHelper {

    /* renamed from: n */
    public float f2547n;

    /* renamed from: o */
    public int f2548o;

    /* renamed from: p */
    public int f2549p;

    /* renamed from: q */
    public int f2550q;

    /* renamed from: r */
    public int f2551r;

    /* renamed from: s */
    public boolean f2552s;

    /* renamed from: t */
    public int f2553t;

    /* renamed from: u */
    public int f2554u;

    public MotionEffect(Context context) {
        super(context);
        this.f2547n = 0.1f;
        this.f2548o = 49;
        this.f2549p = 50;
        this.f2550q = 0;
        this.f2551r = 0;
        this.f2552s = true;
        this.f2553t = -1;
        this.f2554u = -1;
    }

    /* renamed from: F */
    private void m3262F(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionEffect);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.MotionEffect_motionEffect_start) {
                    int i11 = typedArrayObtainStyledAttributes.getInt(index, this.f2548o);
                    this.f2548o = i11;
                    this.f2548o = Math.max(Math.min(i11, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_end) {
                    int i12 = typedArrayObtainStyledAttributes.getInt(index, this.f2549p);
                    this.f2549p = i12;
                    this.f2549p = Math.max(Math.min(i12, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationX) {
                    this.f2550q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2550q);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationY) {
                    this.f2551r = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2551r);
                } else if (index == R$styleable.MotionEffect_motionEffect_alpha) {
                    this.f2547n = typedArrayObtainStyledAttributes.getFloat(index, this.f2547n);
                } else if (index == R$styleable.MotionEffect_motionEffect_move) {
                    this.f2554u = typedArrayObtainStyledAttributes.getInt(index, this.f2554u);
                } else if (index == R$styleable.MotionEffect_motionEffect_strict) {
                    this.f2552s = typedArrayObtainStyledAttributes.getBoolean(index, this.f2552s);
                } else if (index == R$styleable.MotionEffect_motionEffect_viewTransition) {
                    this.f2553t = typedArrayObtainStyledAttributes.getResourceId(index, this.f2553t);
                }
            }
            int i13 = this.f2548o;
            int i14 = this.f2549p;
            if (i13 == i14) {
                if (i13 > 0) {
                    this.f2548o = i13 - 1;
                } else {
                    this.f2549p = i14 + 1;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0185, code lost:
    
        if (r14 == 0.0f) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0199, code lost:
    
        if (r14 == 0.0f) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a9, code lost:
    
        if (r15 == 0.0f) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e4  */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo3263D(androidx.constraintlayout.motion.widget.MotionLayout r23, java.util.HashMap<android.view.View, p642t.C12908m> r24) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.mo3263D(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    /* renamed from: x */
    public boolean mo3264x() {
        return true;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2547n = 0.1f;
        this.f2548o = 49;
        this.f2549p = 50;
        this.f2550q = 0;
        this.f2551r = 0;
        this.f2552s = true;
        this.f2553t = -1;
        this.f2554u = -1;
        m3262F(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2547n = 0.1f;
        this.f2548o = 49;
        this.f2549p = 50;
        this.f2550q = 0;
        this.f2551r = 0;
        this.f2552s = true;
        this.f2553t = -1;
        this.f2554u = -1;
        m3262F(context, attributeSet);
    }
}
