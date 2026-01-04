package com.huawei.android.p069cg.p071ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$styleable;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import p031b7.C1120a;

/* loaded from: classes2.dex */
public class InvitationCodeView extends LinearLayout implements TextWatcher, View.OnKeyListener, View.OnFocusChangeListener {

    /* renamed from: a */
    public Context f11184a;

    /* renamed from: b */
    public InterfaceC2340b f11185b;

    /* renamed from: c */
    public int f11186c;

    /* renamed from: d */
    public EnumC2344f f11187d;

    /* renamed from: e */
    public int f11188e;

    /* renamed from: f */
    public int f11189f;

    /* renamed from: g */
    public float f11190g;

    /* renamed from: h */
    public int f11191h;

    /* renamed from: i */
    public int f11192i;

    /* renamed from: j */
    public int f11193j;

    /* renamed from: k */
    public boolean f11194k;

    /* renamed from: l */
    public int f11195l;

    /* renamed from: m */
    public boolean f11196m;

    /* renamed from: n */
    public int f11197n;

    /* renamed from: o */
    public int f11198o;

    /* renamed from: com.huawei.android.cg.ui.InvitationCodeView$a */
    public class C2339a implements InterfaceC2341c {

        /* renamed from: a */
        public final /* synthetic */ EditText f11199a;

        public C2339a(EditText editText) {
            this.f11199a = editText;
        }

        @Override // com.huawei.android.p069cg.p071ui.InvitationCodeView.InterfaceC2341c
        public void onResult(boolean z10) {
            if (z10) {
                this.f11199a.setBackgroundResource(InvitationCodeView.this.f11191h);
                if (InvitationCodeView.this.f11185b != null) {
                    InvitationCodeView.this.f11185b.mo14719a();
                    return;
                }
                return;
            }
            this.f11199a.setBackground(InvitationCodeView.this.getContext().getDrawable(R$drawable.input_error_code_shape));
            if (InvitationCodeView.this.f11185b != null) {
                InvitationCodeView.this.f11185b.mo14720b();
            }
        }
    }

    /* renamed from: com.huawei.android.cg.ui.InvitationCodeView$b */
    public interface InterfaceC2340b {
        /* renamed from: a */
        void mo14719a();

        /* renamed from: b */
        void mo14720b();
    }

    /* renamed from: com.huawei.android.cg.ui.InvitationCodeView$c */
    public interface InterfaceC2341c {
        void onResult(boolean z10);
    }

    /* renamed from: com.huawei.android.cg.ui.InvitationCodeView$d */
    public interface InterfaceC2342d {
    }

    /* renamed from: com.huawei.android.cg.ui.InvitationCodeView$e */
    public static class C2343e implements PrivilegedAction<Object> {

        /* renamed from: a */
        public Field f11201a;

        public C2343e(Field field) {
            this.f11201a = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f11201a.setAccessible(true);
            return null;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.InvitationCodeView$f */
    public enum EnumC2344f {
        NUMBER
    }

    public InvitationCodeView(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        super(context, attributeSet);
        this.f11184a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.vericationCodeView);
        this.f11186c = typedArrayObtainStyledAttributes.getInteger(R$styleable.vericationCodeView_vcv_et_number, 5);
        this.f11187d = EnumC2344f.values()[typedArrayObtainStyledAttributes.getInt(R$styleable.vericationCodeView_vcv_et_inputType, EnumC2344f.NUMBER.ordinal())];
        this.f11188e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.vericationCodeView_vcv_et_width, 120);
        this.f11189f = typedArrayObtainStyledAttributes.getColor(R$styleable.vericationCodeView_vcv_et_text_color, -16777216);
        this.f11190g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.vericationCodeView_vcv_et_text_size, 16);
        this.f11191h = typedArrayObtainStyledAttributes.getResourceId(R$styleable.vericationCodeView_vcv_et_bg, R$drawable.invat_code_shape);
        this.f11197n = typedArrayObtainStyledAttributes.getResourceId(R$styleable.vericationCodeView_vcv_et_cursor, R$drawable.invate_code_cursor);
        int i10 = R$styleable.vericationCodeView_vcv_et_spacing;
        this.f11196m = typedArrayObtainStyledAttributes.hasValue(i10);
        this.f11194k = typedArrayObtainStyledAttributes.getBoolean(R$styleable.vericationCodeView_vcv_et_cursor_visible, true);
        if (this.f11196m) {
            this.f11192i = typedArrayObtainStyledAttributes.getDimensionPixelSize(i10, 0);
        }
        m14713f();
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable.length() != 0) {
            m14715h();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    /* renamed from: c */
    public final void m14710c() {
        for (int i10 = this.f11186c - 1; i10 >= 0; i10--) {
            View childAt = getChildAt(i10);
            if (childAt instanceof EditText) {
                EditText editText = (EditText) childAt;
                if (editText.getText().length() >= 1) {
                    editText.setText("");
                    if (this.f11194k) {
                        editText.setCursorVisible(true);
                    } else {
                        editText.setCursorVisible(false);
                    }
                    editText.requestFocus();
                    return;
                }
            }
        }
    }

    /* renamed from: d */
    public LinearLayout.LayoutParams m14711d(int i10) {
        int i11 = this.f11188e;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, i11);
        if (this.f11196m) {
            int i12 = this.f11192i;
            layoutParams.leftMargin = i12 / 2;
            layoutParams.rightMargin = i12 / 2;
        } else {
            int i13 = this.f11198o;
            int i14 = this.f11186c;
            int i15 = (i13 - (this.f11188e * i14)) / (i14 + 1);
            this.f11195l = i15;
            if (i10 == 0) {
                layoutParams.leftMargin = i15;
                layoutParams.rightMargin = i15 / 2;
            } else if (i10 == i14 - 1) {
                layoutParams.leftMargin = i15 / 2;
                layoutParams.rightMargin = i15;
            } else {
                layoutParams.leftMargin = i15 / 2;
                layoutParams.rightMargin = i15 / 2;
            }
        }
        layoutParams.gravity = 17;
        return layoutParams;
    }

    /* renamed from: e */
    public final EditText m14712e(View view) {
        if (view instanceof EditText) {
            return (EditText) view;
        }
        return null;
    }

    @SuppressLint({"ResourceAsColor"})
    /* renamed from: f */
    public final void m14713f() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        for (int i10 = 0; i10 < this.f11186c; i10++) {
            EditText editText = new EditText(this.f11184a);
            m14714g(editText, i10);
            addView(editText);
            if (i10 == 0) {
                editText.setFocusable(true);
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
            }
        }
    }

    @TargetApi(17)
    /* renamed from: g */
    public final void m14714g(EditText editText, int i10) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        editText.setLayoutParams(m14711d(i10));
        editText.setTextAlignment(4);
        editText.setGravity(17);
        editText.setMaxLines(1);
        editText.setCursorVisible(false);
        editText.setMaxEms(1);
        editText.setId(i10);
        editText.setTextSize(1, this.f11190g);
        editText.setCursorVisible(this.f11194k);
        editText.setTextColor(this.f11189f);
        editText.setImeOptions(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        editText.setPadding(0, 0, 0, 0);
        setEditTextCursorDrawable(editText);
        editText.addTextChangedListener(this);
        editText.setOnKeyListener(this);
        editText.setOnKeyListener(this);
        editText.setBackgroundResource(this.f11191h);
        editText.setTypeface(Typeface.create("HwChinese-medium", 0));
        editText.setOnFocusChangeListener(this);
        editText.setFilters(new InputFilter[]{new C2379a(new C2339a(editText)), new InputFilter.LengthFilter(1)});
    }

    public InterfaceC2340b getOnCodeErrorListener() {
        return this.f11185b;
    }

    public InterfaceC2342d getOnCodeFinishListener() {
        return null;
    }

    public String getResultStr() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < this.f11186c; i10++) {
            EditText editTextM14712e = m14712e(getChildAt(i10));
            if (editTextM14712e == null) {
                C1120a.m6676e("InvitationCodeView", "getResult editTextView is null");
                return "";
            }
            sb2.append((CharSequence) editTextM14712e.getText());
        }
        return sb2.toString();
    }

    public int getmCursorBgDrawable() {
        return this.f11197n;
    }

    public EnumC2344f getmEditTextInputType() {
        return this.f11187d;
    }

    public int getmEditTextMargin() {
        return this.f11193j;
    }

    public int getmEditTextNumber() {
        return this.f11186c;
    }

    public int getmEditTextTextBg() {
        return this.f11191h;
    }

    public int getmEditTextTextColor() {
        return this.f11189f;
    }

    public float getmEditTextTextSize() {
        return this.f11190g;
    }

    public int getmEditTextWidth() {
        return this.f11188e;
    }

    /* renamed from: h */
    public final void m14715h() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof EditText) {
                EditText editText = (EditText) childAt;
                if (editText.getText().length() < 1) {
                    if (this.f11194k) {
                        editText.setCursorVisible(true);
                    } else {
                        editText.setCursorVisible(false);
                    }
                    editText.requestFocus();
                    return;
                }
                editText.setCursorVisible(false);
                if (i10 == childCount - 1) {
                    editText.requestFocus();
                }
            }
        }
    }

    /* renamed from: i */
    public void m14716i(String str, boolean z10) {
        if (str == null || str.length() != this.f11186c) {
            C1120a.m6676e("InvitationCodeView", "text size is error");
            return;
        }
        int i10 = 0;
        while (i10 < this.f11186c) {
            EditText editTextM14712e = m14712e(getChildAt(i10));
            if (editTextM14712e == null) {
                C1120a.m6676e("InvitationCodeView", "setText editTextView is null");
                return;
            }
            int i11 = i10 + 1;
            editTextM14712e.setText(str.substring(i10, i11));
            editTextM14712e.setEnabled(z10);
            i10 = i11;
        }
    }

    /* renamed from: j */
    public void m14717j() {
        for (int i10 = 0; i10 < this.f11186c; i10++) {
            EditText editTextM14712e = m14712e(getChildAt(i10));
            if (editTextM14712e == null) {
                C1120a.m6676e("InvitationCodeView", "showAllErrorFrame editText is null");
                return;
            }
            editTextM14712e.setBackground(getContext().getDrawable(R$drawable.input_error_all_code_shape));
        }
    }

    /* renamed from: k */
    public final void m14718k() {
        for (int i10 = 0; i10 < this.f11186c; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof EditText) {
                ((EditText) childAt).setLayoutParams(m14711d(i10));
            }
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        if (z10) {
            m14715h();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (i10 != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        m14710c();
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f11198o = getMeasuredWidth();
        m14718k();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void setEditTextCursorDrawable(EditText editText) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (this.f11194k) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                AccessController.doPrivileged(new C2343e(declaredField));
                declaredField.set(editText, Integer.valueOf(this.f11197n));
            } catch (SecurityException e10) {
                C1120a.m6676e("InvitationCodeView", "SecurityException :" + e10.toString());
            } catch (Exception e11) {
                C1120a.m6676e("InvitationCodeView", "exception :" + e11.toString());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).setEnabled(z10);
        }
    }

    public void setOnCodeErrorListener(InterfaceC2340b interfaceC2340b) {
        this.f11185b = interfaceC2340b;
    }

    public void setOnCodeFinishListener(InterfaceC2342d interfaceC2342d) {
    }

    public void setmCursorBgDrawable(int i10) {
        this.f11197n = i10;
    }

    public void setmEditTextInputType(EnumC2344f enumC2344f) {
        this.f11187d = enumC2344f;
    }

    public void setmEditTextMargin(int i10) {
        this.f11193j = i10;
    }

    public void setmEditTextNumber(int i10) {
        this.f11186c = i10;
    }

    public void setmEditTextTextBg(int i10) {
        this.f11191h = i10;
    }

    public void setmEditTextTextColor(int i10) {
        this.f11189f = i10;
    }

    public void setmEditTextTextSize(float f10) {
        this.f11190g = f10;
    }

    public void setmEditTextWidth(int i10) {
        this.f11188e = i10;
    }
}
