package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* loaded from: classes.dex */
public class MockView extends View {

    /* renamed from: a */
    public Paint f2864a;

    /* renamed from: b */
    public Paint f2865b;

    /* renamed from: c */
    public Paint f2866c;

    /* renamed from: d */
    public boolean f2867d;

    /* renamed from: e */
    public boolean f2868e;

    /* renamed from: f */
    public String f2869f;

    /* renamed from: g */
    public Rect f2870g;

    /* renamed from: h */
    public int f2871h;

    /* renamed from: i */
    public int f2872i;

    /* renamed from: j */
    public int f2873j;

    /* renamed from: k */
    public int f2874k;

    public MockView(Context context) {
        super(context);
        this.f2864a = new Paint();
        this.f2865b = new Paint();
        this.f2866c = new Paint();
        this.f2867d = true;
        this.f2868e = true;
        this.f2869f = null;
        this.f2870g = new Rect();
        this.f2871h = Color.argb(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 0, 0, 0);
        this.f2872i = Color.argb(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 200, 200, 200);
        this.f2873j = Color.argb(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 50, 50, 50);
        this.f2874k = 4;
        m3539a(context, null);
    }

    /* renamed from: a */
    private void m3539a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MockView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.MockView_mock_label) {
                    this.f2869f = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MockView_mock_showDiagonals) {
                    this.f2867d = typedArrayObtainStyledAttributes.getBoolean(index, this.f2867d);
                } else if (index == R$styleable.MockView_mock_diagonalsColor) {
                    this.f2871h = typedArrayObtainStyledAttributes.getColor(index, this.f2871h);
                } else if (index == R$styleable.MockView_mock_labelBackgroundColor) {
                    this.f2873j = typedArrayObtainStyledAttributes.getColor(index, this.f2873j);
                } else if (index == R$styleable.MockView_mock_labelColor) {
                    this.f2872i = typedArrayObtainStyledAttributes.getColor(index, this.f2872i);
                } else if (index == R$styleable.MockView_mock_showLabel) {
                    this.f2868e = typedArrayObtainStyledAttributes.getBoolean(index, this.f2868e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f2869f == null) {
            try {
                this.f2869f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f2864a.setColor(this.f2871h);
        this.f2864a.setAntiAlias(true);
        this.f2865b.setColor(this.f2872i);
        this.f2865b.setAntiAlias(true);
        this.f2866c.setColor(this.f2873j);
        this.f2874k = Math.round(this.f2874k * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f2867d) {
            width--;
            height--;
            float f10 = width;
            float f11 = height;
            canvas.drawLine(0.0f, 0.0f, f10, f11, this.f2864a);
            canvas.drawLine(0.0f, f11, f10, 0.0f, this.f2864a);
            canvas.drawLine(0.0f, 0.0f, f10, 0.0f, this.f2864a);
            canvas.drawLine(f10, 0.0f, f10, f11, this.f2864a);
            canvas.drawLine(f10, f11, 0.0f, f11, this.f2864a);
            canvas.drawLine(0.0f, f11, 0.0f, 0.0f, this.f2864a);
        }
        String str = this.f2869f;
        if (str == null || !this.f2868e) {
            return;
        }
        this.f2865b.getTextBounds(str, 0, str.length(), this.f2870g);
        float fWidth = (width - this.f2870g.width()) / 2.0f;
        float fHeight = ((height - this.f2870g.height()) / 2.0f) + this.f2870g.height();
        this.f2870g.offset((int) fWidth, (int) fHeight);
        Rect rect = this.f2870g;
        int i10 = rect.left;
        int i11 = this.f2874k;
        rect.set(i10 - i11, rect.top - i11, rect.right + i11, rect.bottom + i11);
        canvas.drawRect(this.f2870g, this.f2866c);
        canvas.drawText(this.f2869f, fWidth, fHeight, this.f2865b);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2864a = new Paint();
        this.f2865b = new Paint();
        this.f2866c = new Paint();
        this.f2867d = true;
        this.f2868e = true;
        this.f2869f = null;
        this.f2870g = new Rect();
        this.f2871h = Color.argb(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 0, 0, 0);
        this.f2872i = Color.argb(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 200, 200, 200);
        this.f2873j = Color.argb(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 50, 50, 50);
        this.f2874k = 4;
        m3539a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2864a = new Paint();
        this.f2865b = new Paint();
        this.f2866c = new Paint();
        this.f2867d = true;
        this.f2868e = true;
        this.f2869f = null;
        this.f2870g = new Rect();
        this.f2871h = Color.argb(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 0, 0, 0);
        this.f2872i = Color.argb(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 200, 200, 200);
        this.f2873j = Color.argb(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 50, 50, 50);
        this.f2874k = 4;
        m3539a(context, attributeSet);
    }
}
