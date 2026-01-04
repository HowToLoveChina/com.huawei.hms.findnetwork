package com.huawei.uikit.hwdatepicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.huawei.uikit.hwdatepicker.C8710R;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.hwtextview.widget.HwTextView;

/* loaded from: classes7.dex */
public class HwDatePickerDialogBottomBar extends LinearLayout {

    /* renamed from: e */
    private static final float f42274e = 16.0f;

    /* renamed from: f */
    private static final float f42275f = 32.0f;

    /* renamed from: a */
    private HwTextView f42276a;

    /* renamed from: b */
    private HwTextView f42277b;

    /* renamed from: c */
    private float f42278c;

    /* renamed from: d */
    private Context f42279d;

    public HwDatePickerDialogBottomBar(Context context) {
        super(context);
        this.f42279d = context;
    }

    /* renamed from: a */
    private void m54344a() {
        this.f42277b = (HwTextView) findViewById(C8710R.id.hwdatepicker_dialog_negative_btn);
        this.f42276a = (HwTextView) findViewById(C8710R.id.hwdatepicker_dialog_positive_btn);
        this.f42278c = getResources().getDimension(C8710R.dimen.hwdatepicker_alert_dialog_button_text_size);
    }

    /* renamed from: b */
    private void m54345b() {
        if (AuxiliaryHelper.isAuxiliaryDevice(this.f42279d) && Float.compare(AuxiliaryHelper.getFontSize(this.f42279d), 1.75f) >= 0) {
            if (AuxiliaryHelper.isMultiWindowActivity(this.f42279d)) {
                this.f42276a.setTextSize(1, f42274e);
                this.f42277b.setTextSize(1, f42274e);
            } else if (Float.compare(AuxiliaryHelper.getFontSize(this.f42279d), 2.0f) > 0 && this.f42279d.getResources().getConfiguration().orientation == 2) {
                this.f42276a.setTextSize(1, f42275f);
                this.f42277b.setTextSize(1, f42275f);
            }
        }
    }

    /* renamed from: c */
    private void m54346c() {
        HwTextView hwTextView = this.f42277b;
        if (hwTextView == null || this.f42276a == null) {
            return;
        }
        hwTextView.setTextSize(this.f42278c);
        this.f42276a.setTextSize(this.f42278c);
    }

    /* renamed from: d */
    private void m54347d() {
        HwTextView hwTextView = this.f42277b;
        if (hwTextView == null || this.f42276a == null) {
            return;
        }
        float fMin = Math.min(hwTextView.getTextSize(), this.f42276a.getTextSize());
        this.f42277b.setTextSize(0, fMin);
        this.f42276a.setTextSize(0, fMin);
        m54345b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m54344a();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        m54346c();
        super.onMeasure(i10, i11);
        m54347d();
    }

    public HwDatePickerDialogBottomBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f42279d = context;
    }

    public HwDatePickerDialogBottomBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f42279d = context;
    }
}
