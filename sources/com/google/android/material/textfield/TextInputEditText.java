package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1775f;
import com.google.android.material.internal.C1784o;
import p416k3.C10981a;

/* loaded from: classes.dex */
public class TextInputEditText extends AppCompatEditText {

    /* renamed from: g */
    public final Rect f8798g;

    /* renamed from: h */
    public boolean f8799h;

    public TextInputEditText(Context context) {
        this(context, null);
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    /* renamed from: e */
    public final boolean m11180e(TextInputLayout textInputLayout) {
        return textInputLayout != null && this.f8799h;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!m11180e(textInputLayout) || rect == null) {
            return;
        }
        textInputLayout.getFocusedRect(this.f8798g);
        rect.bottom = this.f8798g.bottom;
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        return m11180e(textInputLayout) ? textInputLayout.getGlobalVisibleRect(rect, point) : super.getGlobalVisibleRect(rect, point);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        return (textInputLayout == null || !textInputLayout.m11211O()) ? super.getHint() : textInputLayout.getHint();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.m11211O() && super.getHint() == null && C1775f.m10686c()) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        getTextInputLayout();
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!m11180e(textInputLayout) || rect == null) {
            return super.requestRectangleOnScreen(rect);
        }
        this.f8798g.set(rect.left, rect.top, rect.right, rect.bottom + (textInputLayout.getHeight() - getHeight()));
        return super.requestRectangleOnScreen(this.f8798g);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z10) {
        this.f8799h = z10;
    }

    public TextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    public TextInputEditText(Context context, AttributeSet attributeSet, int i10) {
        super(C10981a.m66348c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f8798g = new Rect();
        TypedArray typedArrayM10770h = C1784o.m10770h(context, attributeSet, R$styleable.TextInputEditText, i10, R$style.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(typedArrayM10770h.getBoolean(R$styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        typedArrayM10770h.recycle();
    }
}
