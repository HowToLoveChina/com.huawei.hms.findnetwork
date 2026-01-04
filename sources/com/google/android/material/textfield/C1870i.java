package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.internal.C1783n;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: com.google.android.material.textfield.i */
/* loaded from: classes.dex */
public class C1870i extends AbstractC1866e {

    /* renamed from: e */
    public final TextWatcher f8977e;

    /* renamed from: f */
    public final TextInputLayout.InterfaceC1860f f8978f;

    /* renamed from: g */
    public final TextInputLayout.InterfaceC1861g f8979g;

    /* renamed from: com.google.android.material.textfield.i$a */
    public class a extends C1783n {
        public a() {
        }

        @Override // com.google.android.material.internal.C1783n, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            C1870i.this.f8948c.setChecked(!r0.m11377g());
        }
    }

    /* renamed from: com.google.android.material.textfield.i$b */
    public class b implements TextInputLayout.InterfaceC1860f {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC1860f
        /* renamed from: a */
        public void mo11267a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            C1870i.this.f8948c.setChecked(!r0.m11377g());
            editText.removeTextChangedListener(C1870i.this.f8977e);
            editText.addTextChangedListener(C1870i.this.f8977e);
        }
    }

    /* renamed from: com.google.android.material.textfield.i$c */
    public class c implements TextInputLayout.InterfaceC1861g {

        /* renamed from: com.google.android.material.textfield.i$c$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ EditText f8983a;

            public a(EditText editText) {
                this.f8983a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8983a.removeTextChangedListener(C1870i.this.f8977e);
            }
        }

        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC1861g
        /* renamed from: a */
        public void mo11268a(TextInputLayout textInputLayout, int i10) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i10 != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    /* renamed from: com.google.android.material.textfield.i$d */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = C1870i.this.f8946a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (C1870i.this.m11377g()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            C1870i.this.f8946a.m11216U();
        }
    }

    public C1870i(TextInputLayout textInputLayout, int i10) {
        super(textInputLayout, i10);
        this.f8977e = new a();
        this.f8978f = new b();
        this.f8979g = new c();
    }

    /* renamed from: h */
    public static boolean m11376h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    @Override // com.google.android.material.textfield.AbstractC1866e
    /* renamed from: a */
    public void mo11273a() {
        TextInputLayout textInputLayout = this.f8946a;
        int i10 = this.f8949d;
        if (i10 == 0) {
            i10 = R$drawable.design_password_eye;
        }
        textInputLayout.setEndIconDrawable(i10);
        TextInputLayout textInputLayout2 = this.f8946a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R$string.password_toggle_content_description));
        this.f8946a.setEndIconVisible(true);
        this.f8946a.setEndIconCheckable(true);
        this.f8946a.setEndIconOnClickListener(new d());
        this.f8946a.m11225g(this.f8978f);
        this.f8946a.m11227h(this.f8979g);
        EditText editText = this.f8946a.getEditText();
        if (m11376h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* renamed from: g */
    public final boolean m11377g() {
        EditText editText = this.f8946a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
