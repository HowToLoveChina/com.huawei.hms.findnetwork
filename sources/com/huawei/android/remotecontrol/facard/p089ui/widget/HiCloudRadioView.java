package com.huawei.android.remotecontrol.facard.p089ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.uikit.phone.hwradiobutton.widget.HwRadioButton;
import sk.C12809f;
import wf.InterfaceC13596a;

/* loaded from: classes4.dex */
public class HiCloudRadioView extends RelativeLayout implements Checkable {

    /* renamed from: a */
    public HwRadioButton f19810a;

    /* renamed from: b */
    public TextView f19811b;

    /* renamed from: c */
    public InterfaceC13596a f19812c;

    /* renamed from: d */
    public int f19813d;

    public HiCloudRadioView(Context context, InterfaceC13596a interfaceC13596a, int i10, boolean z10) {
        super(context);
        m26187c(context, z10);
        this.f19812c = interfaceC13596a;
        this.f19813d = i10;
    }

    /* renamed from: c */
    public final void m26187c(Context context, boolean z10) {
        View.inflate(context, R$layout.fa_select_device_item, this);
        HwRadioButton hwRadioButton = (HwRadioButton) C12809f.m76831d(this, R$id.radio_button);
        this.f19810a = hwRadioButton;
        hwRadioButton.setChecked(z10);
        this.f19811b = (TextView) C12809f.m76831d(this, R$id.display_value);
        this.f19810a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: gf.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                this.f48663a.m26188d(compoundButton, z11);
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: gf.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f48664a.m26189e(view);
            }
        });
    }

    /* renamed from: d */
    public final /* synthetic */ void m26188d(CompoundButton compoundButton, boolean z10) {
        if (z10) {
            this.f19812c.mo26171S(this, this.f19813d, 0, true);
        }
    }

    /* renamed from: e */
    public final /* synthetic */ void m26189e(View view) {
        setChecked(true);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f19810a.isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        this.f19810a.setChecked(z10);
    }

    public void setText(String str) {
        this.f19811b.setText(str);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f19810a.toggle();
    }
}
