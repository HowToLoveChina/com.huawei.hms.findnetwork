package com.huawei.uikit.hwedittext.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hwedittext.C8712R;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwunifiedinteract.widget.HwKeyEventDetector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p757x.C13669a;

/* loaded from: classes7.dex */
public class HwEditText extends EditText {
    protected static final int ALT_SHIFT_STATUS = 4;
    protected static final String CURSOR_STATE = "CursorState";
    protected static final int EDIT_STATUS = 2;
    protected static final int FOCUSED_STATUS = 1;
    protected static final String INSTANCE_STATE = "InstanceState";
    protected static final int KEYCODE_INPUTMETHOD_ACTION = 746;
    protected static final int TOUCH_STATUS = 3;
    protected static final int UNFOCUSED_STATUS = 0;
    protected static final String VIEW_STATE = "ViewState";

    /* renamed from: i */
    private static final String f42720i = "HwEditText";

    /* renamed from: j */
    private static final int f42721j = 3;

    /* renamed from: a */
    private int f42722a;

    /* renamed from: b */
    private HwKeyEventDetector f42723b;

    /* renamed from: c */
    private final Drawable f42724c;

    /* renamed from: d */
    private boolean f42725d;

    /* renamed from: e */
    private boolean f42726e;

    /* renamed from: f */
    private boolean f42727f;

    /* renamed from: g */
    private Drawable f42728g;

    /* renamed from: h */
    private TextWatcher f42729h;

    public class bzrwd implements TextWatcher {
        public bzrwd() {
        }

        /* renamed from: a */
        private void m54645a(int i10, int i11, int i12) {
            int i13 = i11 + i12;
            int i14 = i12 + i13;
            if (i14 <= i10) {
                i10 = i14;
            }
            if (i10 > i13) {
                HwEditText.this.getText().replace(i13, i10, "");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence == null || !HwEditText.this.f42725d) {
                return;
            }
            if (i10 >= charSequence.length() || charSequence.charAt(i10) != '\n') {
                int length = charSequence.length();
                Object[] spans = HwEditText.this.getText().getSpans(i10, i10 + i12, UnderlineSpan.class);
                if (i11 == 0) {
                    if (spans == null || spans.length == 0) {
                        m54645a(length, i10, i12);
                        return;
                    }
                    return;
                }
                if (spans == null || spans.length == 0) {
                    m54645a(length, i10, i12);
                } else {
                    Log.e(HwEditText.f42720i, "Before not zero and builders exist");
                }
            }
        }
    }

    public HwEditText(Context context) {
        this(context, null);
    }

    public static HwEditText instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwEditText.class, HwWidgetInstantiator.getCurrentType(context, 3, 1)), HwEditText.class);
        if (objInstantiate instanceof HwEditText) {
            return (HwEditText) objInstantiate;
        }
        return null;
    }

    private void setValueFromPlume(Context context) {
        Method method = HwReflectUtil.getMethod("getBoolean", new Class[]{Context.class, View.class, String.class, Boolean.TYPE}, "huawei.android.widget.HwPlume");
        if (method == null) {
            setExtendedEditEnabled(true);
            return;
        }
        Object objInvokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{context, this, "insertEnabled", Boolean.TRUE});
        if (objInvokeMethod instanceof Boolean) {
            setExtendedEditEnabled(((Boolean) objInvokeMethod).booleanValue());
        } else {
            setExtendedEditEnabled(true);
        }
    }

    public HwKeyEventDetector createKeyEventDetector() {
        return new HwKeyEventDetector(getContext());
    }

    public void drawFocusLayer(Canvas canvas) {
        Drawable focusedDrawable = getFocusedDrawable();
        if (focusedDrawable != null) {
            canvas.translate(getScrollX(), getScrollY());
            focusedDrawable.setBounds(0, 0, getWidth(), getHeight());
            focusedDrawable.draw(canvas);
            canvas.translate(-getScrollX(), -getScrollY());
        }
    }

    public Drawable getFocusedDrawable() {
        return this.f42728g;
    }

    public HwKeyEventDetector.OnSearchEventListener getOnSearchEventListener() {
        HwKeyEventDetector hwKeyEventDetector = this.f42723b;
        if (hwKeyEventDetector != null) {
            return hwKeyEventDetector.getOnSearchEventListener();
        }
        return null;
    }

    public void handleTabKeyEvent(KeyEvent keyEvent) {
        View viewFindNextFocus;
        View rootView = getRootView();
        if (rootView instanceof ViewGroup) {
            boolean z10 = (keyEvent.getMetaState() & 1) != 0;
            FocusFinder focusFinder = FocusFinder.getInstance();
            viewFindNextFocus = z10 ? focusFinder.findNextFocus((ViewGroup) rootView, this, 1) : focusFinder.findNextFocus((ViewGroup) rootView, this, 2);
        } else {
            viewFindNextFocus = null;
        }
        if (viewFindNextFocus != null) {
            viewFindNextFocus.requestFocus();
        }
    }

    public void hideSoftInput() {
        if (Build.VERSION.SDK_INT > 29) {
            return;
        }
        Object systemService = getContext().getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
    }

    public boolean isAltKey(int i10) {
        return i10 == 57 || i10 == 58;
    }

    public boolean isConfirmKey(int i10) {
        return i10 == 23 || i10 == 62 || i10 == 66 || i10 == 160;
    }

    public boolean isDirectionalNavigationKey(int i10) {
        switch (i10) {
            case 19:
            case 20:
            case 21:
            case 22:
                return true;
            default:
                return false;
        }
    }

    public boolean isExtendedEditEnabled() {
        return this.f42726e;
    }

    public boolean isSafeEditText() {
        return this.f42727f;
    }

    public boolean isShiftKey(int i10) {
        return i10 == 59 || i10 == 60;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f42726e) {
            addTextChangedListener(this.f42729h);
        } else {
            removeTextChangedListener(this.f42729h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        if (i10 == 124 && keyEvent.getAction() == 0) {
            this.f42725d = !this.f42725d;
        }
        return super.onKeyPreIme(i10, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        HwKeyEventDetector hwKeyEventDetector = this.f42723b;
        if (hwKeyEventDetector == null || !hwKeyEventDetector.onKeyEvent(keyEvent.getKeyCode(), keyEvent)) {
            return super.onKeyUp(i10, keyEvent);
        }
        return true;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i10) {
        if (this.f42727f && (16908321 == i10 || 16908320 == i10)) {
            return false;
        }
        return super.onTextContextMenuItem(i10);
    }

    public void setExtendedEditEnabled(boolean z10) {
        if (!isAttachedToWindow() || this.f42729h == null) {
            return;
        }
        this.f42726e = z10;
        if (isAttachedToWindow()) {
            if (z10) {
                addTextChangedListener(this.f42729h);
            } else {
                removeTextChangedListener(this.f42729h);
            }
        }
    }

    public void setFocusedDrawable(Drawable drawable) {
        this.f42728g = drawable;
    }

    public void setOnSearchEventListener(HwKeyEventDetector.OnSearchEventListener onSearchEventListener) {
        if (this.f42723b == null) {
            this.f42723b = createKeyEventDetector();
        }
        HwKeyEventDetector hwKeyEventDetector = this.f42723b;
        if (hwKeyEventDetector != null) {
            hwKeyEventDetector.setOnSearchEventListener(onSearchEventListener);
        }
    }

    public void setSafeEditText(boolean z10) {
        this.f42727f = z10;
    }

    public void setTextCursorColor(int i10) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (i10 != this.f42722a) {
            this.f42722a = i10;
            m54642a();
        }
    }

    public HwEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8712R.attr.hwEditTextStyle);
    }

    /* renamed from: a */
    private static Context m54640a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8712R.style.Theme_Emui_HwEditText);
    }

    public HwEditText(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super(m54640a(context, i10), attributeSet, i10);
        this.f42723b = null;
        this.f42724c = ContextCompat.getDrawable(getContext(), C8712R.drawable.hwedittext_cursor);
        this.f42725d = false;
        this.f42726e = false;
        this.f42727f = false;
        this.f42729h = new bzrwd();
        m54643a(super.getContext(), attributeSet, i10);
    }

    /* renamed from: a */
    private void m54643a(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8712R.styleable.HwEditText, i10, C8712R.style.Widget_Emui_HwEditText);
        int color = typedArrayObtainStyledAttributes.getColor(C8712R.styleable.HwEditText_hwTextCursorColor, ContextCompat.getColor(context, C8712R.color.hwedittext_color_control_highlight));
        this.f42728g = typedArrayObtainStyledAttributes.getDrawable(C8712R.styleable.HwEditText_hwFocusedDrawable);
        typedArrayObtainStyledAttributes.recycle();
        setTextCursorColor(color);
        setValueFromPlume(context);
    }

    /* renamed from: a */
    private void m54642a() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Object object = HwReflectUtil.getObject(this, "mEditor", TextView.class);
            Class<?> cls = Class.forName("android.widget.Editor");
            HwReflectUtil.callMethod(object, "updateCursorPosition", null, null, cls);
            try {
                Object objInvoke = TextView.class.getDeclaredMethod("getTextCursorDrawable", new Class[0]).invoke(this, new Object[0]);
                if (objInvoke instanceof Drawable) {
                    TextView.class.getDeclaredMethod("setTextCursorDrawable", Drawable.class).invoke(this, m54641a((Drawable) objInvoke, this.f42722a));
                }
            } catch (NoSuchMethodException unused) {
                Object object2 = HwReflectUtil.getObject(object, "mDrawableForCursor", cls);
                if (object2 instanceof Drawable) {
                    HwReflectUtil.setObject("mDrawableForCursor", object, m54641a((Drawable) object2, this.f42722a), cls);
                }
            }
        } catch (ClassNotFoundException unused2) {
            Log.e(f42720i, "class not found");
        } catch (IllegalAccessException unused3) {
            Log.e(f42720i, "illegal access");
        } catch (InvocationTargetException unused4) {
            Log.e(f42720i, "invocation error");
        }
    }

    /* renamed from: a */
    private Drawable m54641a(Drawable drawable, int i10) {
        Drawable drawable2;
        if (drawable == null) {
            if (this.f42722a == 0 || (drawable2 = this.f42724c) == null) {
                return null;
            }
            drawable = drawable2.mutate();
        }
        Drawable drawableMutate = C13669a.m82231l(drawable).mutate();
        C13669a.m82227h(drawableMutate, i10);
        return drawableMutate;
    }
}
