package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.C0585c;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import p273f0.C9603h0;

/* loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {

    /* renamed from: a */
    public final Chip f9037a;

    /* renamed from: b */
    public final Chip f9038b;

    /* renamed from: c */
    public final ClockHandView f9039c;

    /* renamed from: d */
    public final ClockFaceView f9040d;

    /* renamed from: e */
    public final MaterialButtonToggleGroup f9041e;

    /* renamed from: f */
    public final View.OnClickListener f9042f;

    /* renamed from: com.google.android.material.timepicker.TimePickerView$a */
    public class ViewOnClickListenerC1880a implements View.OnClickListener {
        public ViewOnClickListenerC1880a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView.m11420b(TimePickerView.this);
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$b */
    public class C1881b implements MaterialButtonToggleGroup.InterfaceC1695d {
        public C1881b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.InterfaceC1695d
        /* renamed from: a */
        public void mo9949a(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10) {
            TimePickerView.m11421c(TimePickerView.this);
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$c */
    public class C1882c extends GestureDetector.SimpleOnGestureListener {
        public C1882c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.m11422d(TimePickerView.this);
            return false;
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$d */
    public class ViewOnTouchListenerC1883d implements View.OnTouchListener {

        /* renamed from: a */
        public final /* synthetic */ GestureDetector f9046a;

        public ViewOnTouchListenerC1883d(GestureDetector gestureDetector) {
            this.f9046a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f9046a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$e */
    public interface InterfaceC1884e {
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$f */
    public interface InterfaceC1885f {
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$g */
    public interface InterfaceC1886g {
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public static /* synthetic */ InterfaceC1886g m11420b(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    /* renamed from: c */
    public static /* synthetic */ InterfaceC1885f m11421c(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    /* renamed from: d */
    public static /* synthetic */ InterfaceC1884e m11422d(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    /* renamed from: e */
    public final void m11423e() {
        Chip chip = this.f9037a;
        int i10 = R$id.selection_type;
        chip.setTag(i10, 12);
        this.f9038b.setTag(i10, 10);
        this.f9037a.setOnClickListener(this.f9042f);
        this.f9038b.setOnClickListener(this.f9042f);
        this.f9037a.setAccessibilityClassName("android.view.View");
        this.f9038b.setAccessibilityClassName("android.view.View");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: f */
    public final void m11424f() {
        ViewOnTouchListenerC1883d viewOnTouchListenerC1883d = new ViewOnTouchListenerC1883d(new GestureDetector(getContext(), new C1882c()));
        this.f9037a.setOnTouchListener(viewOnTouchListenerC1883d);
        this.f9038b.setOnTouchListener(viewOnTouchListenerC1883d);
    }

    /* renamed from: g */
    public final void m11425g() {
        if (this.f9041e.getVisibility() == 0) {
            C0585c c0585c = new C0585c();
            c0585c.m3637p(this);
            c0585c.m3635n(R$id.material_clock_display, C9603h0.m59832A(this) == 0 ? 2 : 1);
            c0585c.m3631i(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m11425g();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this && i10 == 0) {
            m11425g();
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f9042f = new ViewOnClickListenerC1880a();
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        this.f9040d = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.f9041e = materialButtonToggleGroup;
        materialButtonToggleGroup.m9925b(new C1881b());
        this.f9037a = (Chip) findViewById(R$id.material_minute_tv);
        this.f9038b = (Chip) findViewById(R$id.material_hour_tv);
        this.f9039c = (ClockHandView) findViewById(R$id.material_clock_hand);
        m11424f();
        m11423e();
    }
}
