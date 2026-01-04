package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1775f;
import com.google.android.material.internal.C1784o;
import p416k3.C10981a;

/* loaded from: classes.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* renamed from: e */
    public final ListPopupWindow f8785e;

    /* renamed from: f */
    public final AccessibilityManager f8786f;

    /* renamed from: g */
    public final Rect f8787g;

    /* renamed from: h */
    public final int f8788h;

    /* renamed from: com.google.android.material.textfield.MaterialAutoCompleteTextView$a */
    public class C1853a implements AdapterView.OnItemClickListener {
        public C1853a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
            MaterialAutoCompleteTextView.this.m11155f(i10 < 0 ? materialAutoCompleteTextView.f8785e.m2732l() : materialAutoCompleteTextView.getAdapter().getItem(i10));
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i10 < 0) {
                    view = MaterialAutoCompleteTextView.this.f8785e.m2735o();
                    i10 = MaterialAutoCompleteTextView.this.f8785e.m2734n();
                    j10 = MaterialAutoCompleteTextView.this.f8785e.m2733m();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f8785e.getListView(), view, i10, j10);
            }
            MaterialAutoCompleteTextView.this.f8785e.dismiss();
        }
    }

    public MaterialAutoCompleteTextView(Context context) {
        this(context, null);
    }

    /* renamed from: d */
    public final TextInputLayout m11153d() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    /* renamed from: e */
    public final int m11154e() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutM11153d = m11153d();
        int i10 = 0;
        if (adapter == null || textInputLayoutM11153d == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f8785e.m2734n()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutM11153d);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable background = this.f8785e.getBackground();
        if (background != null) {
            background.getPadding(this.f8787g);
            Rect rect = this.f8787g;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutM11153d.getEndIconView().getMeasuredWidth();
    }

    /* renamed from: f */
    public final <T extends ListAdapter & Filterable> void m11155f(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutM11153d = m11153d();
        return (textInputLayoutM11153d == null || !textInputLayoutM11153d.m11211O()) ? super.getHint() : textInputLayoutM11153d.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutM11153d = m11153d();
        if (textInputLayoutM11153d != null && textInputLayoutM11153d.m11211O() && super.getHint() == null && C1775f.m10686c()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m11154e()), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        super.setAdapter(t10);
        this.f8785e.setAdapter(getAdapter());
    }

    public void setSimpleItems(int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f8786f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f8785e.show();
        }
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new ArrayAdapter(getContext(), this.f8788h, strArr));
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i10) {
        super(C10981a.m66348c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f8787g = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.MaterialAutoCompleteTextView, i10, R$style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i11 = R$styleable.MaterialAutoCompleteTextView_android_inputType;
        if (typedArrayM10770h.hasValue(i11) && typedArrayM10770h.getInt(i11, 0) == 0) {
            setKeyListener(null);
        }
        this.f8788h = typedArrayM10770h.getResourceId(R$styleable.MaterialAutoCompleteTextView_simpleItemLayout, R$layout.mtrl_auto_complete_simple_item);
        this.f8786f = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f8785e = listPopupWindow;
        listPopupWindow.m2746z(true);
        listPopupWindow.m2740t(this);
        listPopupWindow.m2745y(2);
        listPopupWindow.setAdapter(getAdapter());
        listPopupWindow.m2721B(new C1853a());
        int i12 = R$styleable.MaterialAutoCompleteTextView_simpleItems;
        if (typedArrayM10770h.hasValue(i12)) {
            setSimpleItems(typedArrayM10770h.getResourceId(i12, 0));
        }
        typedArrayM10770h.recycle();
    }
}
