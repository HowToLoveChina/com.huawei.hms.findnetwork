package com.huawei.uikit.hwtimepicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import com.huawei.uikit.hwtimepicker.C8741R;

/* loaded from: classes5.dex */
public class HwTimePickerDialogBottomBar extends LinearLayout {

    /* renamed from: e */
    private static final float f44519e = 16.0f;

    /* renamed from: f */
    private static final float f44520f = 32.0f;

    /* renamed from: a */
    private HwTextView f44521a;

    /* renamed from: b */
    private HwTextView f44522b;

    /* renamed from: c */
    private float f44523c;

    /* renamed from: d */
    private Context f44524d;

    public HwTimePickerDialogBottomBar(Context context) {
        super(context);
        this.f44524d = context;
    }

    /* renamed from: a */
    private void m55750a() {
        this.f44522b = (HwTextView) findViewById(C8741R.id.hwtimepicker_negative_btn);
        this.f44521a = (HwTextView) findViewById(C8741R.id.hwtimepicker_positive_btn);
        this.f44523c = getResources().getDimension(C8741R.dimen.hwtimepicker_alert_dialog_button_text_size);
    }

    /* renamed from: b */
    private void m55751b() {
        if (AuxiliaryHelper.isAuxiliaryDevice(this.f44524d) && Float.compare(AuxiliaryHelper.getFontSize(this.f44524d), 1.75f) >= 0) {
            if (AuxiliaryHelper.isMultiWindowActivity(this.f44524d)) {
                this.f44521a.setTextSize(1, f44519e);
                this.f44522b.setTextSize(1, f44519e);
            } else if (Float.compare(AuxiliaryHelper.getFontSize(this.f44524d), 2.0f) > 0 && this.f44524d.getResources().getConfiguration().orientation == 2) {
                this.f44521a.setTextSize(1, f44520f);
                this.f44522b.setTextSize(1, f44520f);
            }
        }
    }

    /* renamed from: c */
    private void m55752c() {
        HwTextView hwTextView = this.f44522b;
        if (hwTextView == null || this.f44521a == null) {
            return;
        }
        hwTextView.setTextSize(this.f44523c);
        this.f44521a.setTextSize(this.f44523c);
    }

    /* renamed from: d */
    private void m55753d() {
        HwTextView hwTextView = this.f44522b;
        if (hwTextView == null || this.f44521a == null) {
            return;
        }
        float fMin = Math.min(hwTextView.getTextSize(), this.f44521a.getTextSize());
        this.f44522b.setTextSize(0, fMin);
        this.f44521a.setTextSize(0, fMin);
        m55751b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m55750a();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        m55752c();
        super.onMeasure(i10, i11);
        m55753d();
    }

    public HwTimePickerDialogBottomBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44524d = context;
    }

    public HwTimePickerDialogBottomBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f44524d = context;
    }
}
