package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p561q.C12258e;

/* loaded from: classes.dex */
public class Placeholder extends View {

    /* renamed from: a */
    public int f3050a;

    /* renamed from: b */
    public View f3051b;

    /* renamed from: c */
    public int f3052c;

    public Placeholder(Context context) {
        super(context);
        this.f3050a = -1;
        this.f3051b = null;
        this.f3052c = 4;
        m3579a(null);
    }

    /* renamed from: a */
    public final void m3579a(AttributeSet attributeSet) {
        super.setVisibility(this.f3052c);
        this.f3050a = -1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_placeholder);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_placeholder_content) {
                    this.f3050a = typedArrayObtainStyledAttributes.getResourceId(index, this.f3050a);
                } else if (index == R$styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f3052c = typedArrayObtainStyledAttributes.getInt(index, this.f3052c);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    public void m3580b(ConstraintLayout constraintLayout) {
        if (this.f3051b == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f3051b.getLayoutParams();
        layoutParams2.f3019v0.m73636o1(0);
        C12258e.b bVarM73550C = layoutParams.f3019v0.m73550C();
        C12258e.b bVar = C12258e.b.FIXED;
        if (bVarM73550C != bVar) {
            layoutParams.f3019v0.m73638p1(layoutParams2.f3019v0.m73594Y());
        }
        if (layoutParams.f3019v0.m73588V() != bVar) {
            layoutParams.f3019v0.m73579Q0(layoutParams2.f3019v0.m73662z());
        }
        layoutParams2.f3019v0.m73636o1(8);
    }

    /* renamed from: c */
    public void m3581c(ConstraintLayout constraintLayout) {
        if (this.f3050a == -1 && !isInEditMode()) {
            setVisibility(this.f3052c);
        }
        View viewFindViewById = constraintLayout.findViewById(this.f3050a);
        this.f3051b = viewFindViewById;
        if (viewFindViewById != null) {
            ((ConstraintLayout.LayoutParams) viewFindViewById.getLayoutParams()).f2995j0 = true;
            this.f3051b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f3051b;
    }

    public int getEmptyVisibility() {
        return this.f3052c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(Constant.ERROR_WSS_TIME_DIFF_LARGE, Constant.ERROR_WSS_TIME_DIFF_LARGE, Constant.ERROR_WSS_TIME_DIFF_LARGE);
            Paint paint = new Paint();
            paint.setARGB(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds(Constants.QUESTION_STR, 0, 1, rect);
            canvas.drawText(Constants.QUESTION_STR, ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i10) {
        View viewFindViewById;
        if (this.f3050a == i10) {
            return;
        }
        View view = this.f3051b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.f3051b.getLayoutParams()).f2995j0 = false;
            this.f3051b = null;
        }
        this.f3050a = i10;
        if (i10 == -1 || (viewFindViewById = ((View) getParent()).findViewById(i10)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i10) {
        this.f3052c = i10;
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3050a = -1;
        this.f3051b = null;
        this.f3052c = 4;
        m3579a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3050a = -1;
        this.f3051b = null;
        this.f3052c = 4;
        m3579a(attributeSet);
    }
}
