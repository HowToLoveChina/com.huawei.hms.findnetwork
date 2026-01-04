package com.huawei.uikit.phone.hwswitch.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.huawei.uikit.hwswitch.C8739R;

/* loaded from: classes9.dex */
public class HwSwitch extends com.huawei.uikit.hwswitch.widget.HwSwitch {

    /* renamed from: e */
    private static final int f45052e = 2;

    /* renamed from: f */
    private static final int f45053f = 24;

    /* renamed from: a */
    private int f45054a;

    /* renamed from: b */
    private int f45055b;

    /* renamed from: c */
    private Paint f45056c;

    /* renamed from: d */
    private int f45057d;

    public HwSwitch(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m56007a() {
        setDefaultFocusHighlightEnabled(false);
        Paint paint = new Paint();
        this.f45056c = paint;
        paint.setAntiAlias(true);
        this.f45056c.setStyle(Paint.Style.STROKE);
        this.f45056c.setColor(getFocusedPathColor());
        this.f45057d = (int) getResources().getDimension(C8739R.dimen.hwswitch_focus_status_vertical);
        this.f45054a = (int) getResources().getDimension(C8739R.dimen.hwswitch_focus_status_stroke_width);
        initFocusTrackHorizontalPadding();
    }

    public void initFocusTrackHorizontalPadding() {
        this.f45055b = (int) (getResources().getDimension(C8739R.dimen.hwswitch_focus_status_horizontal) - (getResources().getDimension(C8739R.dimen.hwswitch_min_width) / 24.0f));
    }

    @Override // com.huawei.uikit.hwswitch.widget.HwSwitch, android.widget.Switch, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        if (canvas == null) {
            return;
        }
        super.onDraw(canvas);
        if (isFocused() && this.mTrackDrawable != null && hasWindowFocus()) {
            Rect bounds = this.mTrackDrawable.getBounds();
            this.f45056c.setStrokeWidth(this.f45054a);
            int i10 = bounds.left;
            int i11 = this.f45055b;
            int i12 = bounds.top;
            int i13 = this.f45057d;
            RectF rectF = new RectF(i10 - i11, i12 - i13, bounds.right + i11, bounds.bottom + i13);
            float f10 = ((bounds.bottom - bounds.top) / 2) + this.f45057d;
            canvas.drawRoundRect(rectF, f10, f10, this.f45056c);
        }
    }

    public HwSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8739R.attr.hwSwitchStyle);
    }

    public HwSwitch(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f45054a = 0;
        m56007a();
    }
}
