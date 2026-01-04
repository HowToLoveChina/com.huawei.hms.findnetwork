package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.C1783n;
import com.google.android.material.internal.C1788s;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: a */
    public final Chip f8986a;

    /* renamed from: b */
    public final TextInputLayout f8987b;

    /* renamed from: c */
    public final EditText f8988c;

    /* renamed from: d */
    public TextWatcher f8989d;

    /* renamed from: e */
    public TextView f8990e;

    /* renamed from: com.google.android.material.timepicker.ChipTextInputComboView$b */
    public class C1872b extends C1783n {
        public C1872b() {
        }

        @Override // com.google.android.material.internal.C1783n, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f8986a.setText(ChipTextInputComboView.this.m11385c("00"));
            } else {
                ChipTextInputComboView.this.f8986a.setText(ChipTextInputComboView.this.m11385c(editable));
            }
        }
    }

    public ChipTextInputComboView(Context context) {
        this(context, null);
    }

    /* renamed from: c */
    public final String m11385c(CharSequence charSequence) {
        return TimeModel.m11415a(getResources(), charSequence);
    }

    /* renamed from: d */
    public final void m11386d() {
        this.f8988c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f8986a.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m11386d();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        this.f8986a.setChecked(z10);
        this.f8988c.setVisibility(z10 ? 0 : 4);
        this.f8986a.setVisibility(z10 ? 8 : 0);
        if (isChecked()) {
            C1788s.m10791l(this.f8988c);
            if (TextUtils.isEmpty(this.f8988c.getText())) {
                return;
            }
            EditText editText = this.f8988c;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f8986a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        this.f8986a.setTag(i10, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f8986a.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R$layout.material_time_chip, (ViewGroup) this, false);
        this.f8986a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R$layout.material_time_input, (ViewGroup) this, false);
        this.f8987b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f8988c = editText;
        editText.setVisibility(4);
        C1872b c1872b = new C1872b();
        this.f8989d = c1872b;
        editText.addTextChangedListener(c1872b);
        m11386d();
        addView(chip);
        addView(textInputLayout);
        this.f8990e = (TextView) findViewById(R$id.material_label);
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
