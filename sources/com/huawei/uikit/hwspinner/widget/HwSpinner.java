package com.huawei.uikit.hwspinner.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.view.menu.InterfaceC0417n;
import androidx.core.content.ContextCompat;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwspinner.C8734R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class HwSpinner extends Spinner implements DialogInterface.OnClickListener {

    /* renamed from: A */
    private static final int f44172A = -1;

    /* renamed from: B */
    private static final float f44173B = -1.0f;

    /* renamed from: C */
    private static final int f44174C = -1;
    public static final int MODE_DIALOG = 0;
    public static final int MODE_DROPDOWN = 1;

    /* renamed from: w */
    private static final int f44175w = -1;

    /* renamed from: x */
    private static final String f44176x = "HwSpinner";

    /* renamed from: y */
    private static final int f44177y = 1;

    /* renamed from: z */
    private static final int f44178z = 20;

    /* renamed from: a */
    AdapterView.OnItemClickListener f44179a;

    /* renamed from: b */
    private final Rect f44180b;

    /* renamed from: c */
    private Context f44181c;

    /* renamed from: d */
    private HwForwardingListener f44182d;

    /* renamed from: e */
    private SpinnerAdapter f44183e;

    /* renamed from: f */
    private akxao f44184f;

    /* renamed from: g */
    private int f44185g;

    /* renamed from: h */
    private int f44186h;

    /* renamed from: i */
    private boolean f44187i;

    /* renamed from: j */
    private Context f44188j;

    /* renamed from: k */
    private boolean f44189k;

    /* renamed from: l */
    private int f44190l;

    /* renamed from: m */
    private int f44191m;

    /* renamed from: n */
    private float f44192n;

    /* renamed from: o */
    private HwColumnSystem f44193o;

    /* renamed from: p */
    private boolean f44194p;

    /* renamed from: q */
    private Drawable f44195q;

    /* renamed from: r */
    private boolean f44196r;

    /* renamed from: s */
    private boolean f44197s;

    /* renamed from: t */
    private int f44198t;

    /* renamed from: u */
    private int f44199u;

    /* renamed from: v */
    private int f44200v;

    public class aauaf extends HwListPopupWindow implements akxao {

        /* renamed from: P */
        private CharSequence f44201P;

        /* renamed from: Q */
        private ListAdapter f44202Q;

        public class bzrwd implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ HwSpinner f44204a;

            public bzrwd(HwSpinner hwSpinner) {
                this.f44204a = hwSpinner;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                HwSpinner.this.setSelection(i10);
                aauaf aauafVar = aauaf.this;
                HwSpinner hwSpinner = HwSpinner.this;
                if (hwSpinner.f44179a != null) {
                    hwSpinner.performItemClick(view, i10, aauafVar.f44202Q.getItemId(i10));
                }
                aauaf.this.dismiss();
            }
        }

        public aauaf(Context context, AttributeSet attributeSet, int i10, int i11) {
            super(context, attributeSet, i10, i11);
            setAnchorView(HwSpinner.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new bzrwd(HwSpinner.this));
        }

        /* renamed from: i */
        public void m55542i() {
            int i10;
            Drawable background = getBackground();
            if (background != null) {
                background.getPadding(HwSpinner.this.f44180b);
                i10 = HwSpinner.this.m55524a() ? HwSpinner.this.f44180b.right : -HwSpinner.this.f44180b.left;
            } else {
                HwSpinner.this.f44180b.left = 0;
                HwSpinner.this.f44180b.right = 0;
                i10 = 0;
            }
            int paddingLeft = HwSpinner.this.getPaddingLeft();
            int paddingRight = HwSpinner.this.getPaddingRight();
            int width = HwSpinner.this.getWidth();
            if (HwSpinner.this.f44189k) {
                setContentWidth(HwSpinner.this.m55535a(m55538a(width, paddingLeft, paddingRight)));
            } else if (HwSpinner.this.f44185g == -2) {
                setContentWidth(m55538a(width, paddingLeft, paddingRight));
            } else if (HwSpinner.this.f44185g == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(HwSpinner.this.f44185g);
            }
            setHorizontalOffset(HwSpinner.this.m55524a() ? i10 + ((width - paddingRight) - getWidth()) : i10 + paddingLeft);
        }

        @Override // com.huawei.uikit.hwspinner.widget.HwListPopupWindow, com.huawei.uikit.hwspinner.widget.HwSpinner.akxao
        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.f44202Q = listAdapter;
        }

        @Override // com.huawei.uikit.hwspinner.widget.HwSpinner.akxao
        /* renamed from: a */
        public CharSequence mo55539a() {
            return this.f44201P;
        }

        @Override // com.huawei.uikit.hwspinner.widget.HwSpinner.akxao
        /* renamed from: a */
        public void mo55541a(CharSequence charSequence) {
            this.f44201P = charSequence;
        }

        /* renamed from: a */
        public int m55538a(int i10, int i11, int i12) {
            int iM55536a = 0;
            if (this.f44202Q instanceof SpinnerAdapter) {
                boolean z10 = HwSpinner.this.f44194p;
                HwSpinner.this.f44194p = false;
                iM55536a = HwSpinner.this.m55536a((SpinnerAdapter) this.f44202Q, getBackground());
                HwSpinner.this.f44194p = z10;
            }
            int i13 = (HwSpinner.this.f44188j.getResources().getDisplayMetrics().widthPixels - HwSpinner.this.f44180b.left) - HwSpinner.this.f44180b.right;
            if (iM55536a > i13) {
                iM55536a = i13;
            }
            int i14 = (i10 - i11) - i12;
            return iM55536a >= i14 ? iM55536a : i14;
        }

        @Override // com.huawei.uikit.hwspinner.widget.HwSpinner.akxao
        /* renamed from: a */
        public void mo55540a(int i10, int i11) throws NoSuchMethodException, SecurityException {
            m55542i();
            setInputMethodMode(2);
            super.show();
            HwDropDownListView listView = getListView();
            if (HwSpinner.this.f44186h != 0) {
                listView.setTint(HwSpinner.this.f44186h);
            }
            listView.setChoiceMode(1);
            listView.setTextDirection(i10);
            listView.setTextAlignment(i11);
            if (HwSpinner.this.f44195q != null) {
                listView.setDivider(HwSpinner.this.f44195q);
                listView.setDividerHeight(HwSpinner.this.f44188j.getResources().getDimensionPixelSize(C8734R.dimen.hwspinner_divider_horizontal_height));
            }
            setSelection(HwSpinner.this.getSelectedItemPosition());
        }
    }

    public interface akxao {
        /* renamed from: a */
        CharSequence mo55539a();

        /* renamed from: a */
        void mo55540a(int i10, int i11);

        /* renamed from: a */
        void mo55541a(CharSequence charSequence);

        void dismiss();

        Drawable getBackground();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i10);

        void setVerticalOffset(int i10);
    }

    public class bqmxo extends HwForwardingListener {

        /* renamed from: i */
        aauaf f44206i;

        public bqmxo(View view, aauaf aauafVar) {
            super(view);
            this.f44206i = aauafVar;
        }

        @Override // com.huawei.uikit.hwspinner.widget.HwForwardingListener
        public InterfaceC0417n getPopup() {
            return this.f44206i;
        }

        @Override // com.huawei.uikit.hwspinner.widget.HwForwardingListener
        public boolean onForwardingStarted() {
            if (HwSpinner.this.f44184f.isShowing()) {
                return true;
            }
            HwSpinner.this.f44184f.mo55540a(HwSpinner.this.getTextDirection(), HwSpinner.this.getTextAlignment());
            return true;
        }
    }

    public static class bzrwd implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        private ListAdapter f44208a;

        /* renamed from: b */
        private SpinnerAdapter f44209b;

        public bzrwd(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f44209b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f44208a = (ListAdapter) spinnerAdapter;
            }
            if (theme == null || !(spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                return;
            }
            ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
            if (themedSpinnerAdapter.getDropDownViewTheme() == null) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f44208a;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f44209b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f44209b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f44209b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f44209b;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i10);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f44209b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f44208a;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f44209b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f44209b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public HwSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public static HwSpinner instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwSpinner.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwSpinner.class);
        if (objInstantiate instanceof HwSpinner) {
            return (HwSpinner) objInstantiate;
        }
        return null;
    }

    public void configureColumn(int i10, int i11, float f10) {
        this.f44190l = i10;
        this.f44191m = i11;
        this.f44192n = f10;
        if (this.f44189k) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (getBackground() != null) {
            getBackground().setState(getDrawableState());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Spinner.class.getName();
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        return this.f44184f.getHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        return this.f44184f.getVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f44185g;
    }

    public boolean getListShadowClip() {
        return this.f44197s;
    }

    public int getListShadowColor() {
        return this.f44200v;
    }

    public int getListShadowSize() {
        if (this.f44196r) {
            return this.f44199u;
        }
        return -1;
    }

    public int getListShadowStyle() {
        if (this.f44196r) {
            return this.f44198t;
        }
        return -1;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        return this.f44184f.getBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f44181c;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.f44184f.mo55539a();
    }

    public boolean isColumnEnabled() {
        return this.f44189k;
    }

    public boolean isDynamicWidthEnabled() {
        return this.f44194p;
    }

    public boolean isListShadowEnabled() {
        return this.f44196r;
    }

    public boolean isPopupShowing() {
        akxao akxaoVar = this.f44184f;
        return akxaoVar != null && akxaoVar.isShowing();
    }

    @Override // android.widget.Spinner, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        setSelection(i10);
        if (dialogInterface == null) {
            Log.w(f44176x, "onClick: dialog is null");
        } else {
            dialogInterface.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f44184f == null || View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int iM55536a = m55536a(getAdapter(), getBackground());
        int iMin = this.f44194p ? Math.min(measuredWidth, iM55536a) : Math.max(measuredWidth, iM55536a);
        if (iMin > View.MeasureSpec.getSize(i10)) {
            iMin = View.MeasureSpec.getSize(i10);
        }
        setMeasuredDimension(iMin, getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.ViewGroup, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i10) {
        return (getPointerIcon() == null && isClickable() && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i10);
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        HwForwardingListener hwForwardingListener = this.f44182d;
        if (hwForwardingListener == null || !hwForwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        if (getAdapter() == null || getAdapter().getCount() < 1) {
            return false;
        }
        if (!this.f44184f.isShowing()) {
            this.f44184f.mo55540a(getTextDirection(), getTextAlignment());
        }
        return true;
    }

    public void setColumnEnabled(boolean z10) {
        this.f44189k = z10;
        requestLayout();
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        this.f44184f.setHorizontalOffset(i10);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        this.f44184f.setVerticalOffset(i10);
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.f44184f instanceof aauaf) {
            this.f44185g = i10;
        } else {
            Log.e(f44176x, "Cannot set dropdown width for MODE_DIALOG, ignoring");
        }
    }

    public void setDynamicWidthEnabled(boolean z10) {
        this.f44194p = z10;
    }

    @Override // android.widget.Spinner, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (this.f44187i) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                getChildAt(i10).setEnabled(z10);
            }
        }
    }

    public void setListShadowClip(boolean z10) {
        this.f44197s = z10;
        akxao akxaoVar = this.f44184f;
        if (akxaoVar instanceof aauaf) {
            ((aauaf) akxaoVar).setListShadowClip(z10);
        }
    }

    public void setListShadowColor(int i10) {
        this.f44200v = i10;
        akxao akxaoVar = this.f44184f;
        if (akxaoVar instanceof aauaf) {
            ((aauaf) akxaoVar).setListShadowColor(i10);
        }
    }

    public void setListShadowEnabled(boolean z10) {
        this.f44196r = z10;
        akxao akxaoVar = this.f44184f;
        if (akxaoVar instanceof aauaf) {
            ((aauaf) akxaoVar).setListShadowEnabled(z10);
        }
    }

    public void setListShadowSize(int i10) {
        this.f44199u = i10;
        akxao akxaoVar = this.f44184f;
        if (akxaoVar instanceof aauaf) {
            ((aauaf) akxaoVar).setListShadowSize(i10);
        }
    }

    public void setListShadowStyle(int i10) {
        this.f44198t = i10;
        akxao akxaoVar = this.f44184f;
        if (akxaoVar instanceof aauaf) {
            ((aauaf) akxaoVar).setListShadowStyle(i10);
        }
    }

    public void setOnItemClickListenerInt(AdapterView.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        akxao akxaoVar = this.f44184f;
        if (akxaoVar instanceof aauaf) {
            akxaoVar.setBackgroundDrawable(drawable);
        } else {
            Log.e(f44176x, "setPopupBackgroundDrawable: incompatible spinner mode, ignoring.");
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(getPopupContext().getDrawable(i10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        this.f44184f.mo55541a(charSequence);
    }

    @Override // android.widget.Spinner
    public void setPromptId(int i10) {
        setPrompt(getContext().getText(i10));
    }

    public void setTint(int i10) {
        this.f44186h = i10;
    }

    public HwSpinner(Context context, int i10) {
        this(context, null, C8734R.attr.hwSpinnerStyle, i10);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f44184f == null) {
            this.f44183e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f44188j.getApplicationInfo().targetSdkVersion >= 21 && spinnerAdapter != null && spinnerAdapter.getViewTypeCount() != 1) {
            Log.w(f44176x, "setAdapter: Spinner adapter view type count must be 1");
            return;
        }
        Context context = this.f44181c;
        if (context == null) {
            context = this.f44188j;
        }
        this.f44184f.setAdapter(new bzrwd(spinnerAdapter, context.getTheme()));
    }

    public HwSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8734R.attr.hwSpinnerStyle);
    }

    /* renamed from: a */
    private static Context m55520a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8734R.style.Theme_Emui_HwSpinner);
    }

    public HwSpinner(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    /* renamed from: a */
    private void m55521a(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f44188j = context;
        int[] iArr = C8734R.styleable.HwSpinner;
        int i12 = C8734R.style.Widget_Emui_HwSpinner;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i12);
        m55523a(typedArrayObtainStyledAttributes);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C8734R.styleable.HwSpinner_hwBackground);
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(this.f44188j, C8734R.drawable.hwspinner_selector_background_emui);
        }
        setBackground(drawable);
        if (i11 == -1 || i11 == 0 || i11 == 1) {
            aauaf aauafVar = new aauaf(this.f44181c, attributeSet, i10, i12);
            TypedArray typedArrayObtainStyledAttributes2 = this.f44181c.obtainStyledAttributes(attributeSet, iArr, i10, i12);
            this.f44185g = typedArrayObtainStyledAttributes2.getLayoutDimension(C8734R.styleable.HwSpinner_hwDropDownWidth, -2);
            m55522a(context, aauafVar, typedArrayObtainStyledAttributes2);
            aauafVar.setBackgroundDrawable(typedArrayObtainStyledAttributes2.getDrawable(C8734R.styleable.HwSpinner_hwPopupBackground));
            aauafVar.mo55541a(typedArrayObtainStyledAttributes.getString(C8734R.styleable.HwSpinner_hwPrompt));
            typedArrayObtainStyledAttributes2.recycle();
            this.f44184f = aauafVar;
            this.f44182d = new bqmxo(this, aauafVar);
            setListShadowEnabled(this.f44196r);
            setListShadowStyle(this.f44198t);
            setListShadowSize(this.f44199u);
            setListShadowColor(this.f44200v);
            setListShadowClip(this.f44197s);
        }
        this.f44187i = typedArrayObtainStyledAttributes.getBoolean(C8734R.styleable.HwSpinner_hwDisableChildrenWhenDisabled, false);
        typedArrayObtainStyledAttributes.recycle();
        SpinnerAdapter spinnerAdapter = this.f44183e;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f44183e = null;
        }
    }

    public HwSpinner(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(m55520a(context, i10), attributeSet, i10);
        this.f44180b = new Rect();
        this.f44187i = false;
        this.f44189k = false;
        this.f44190l = -1;
        this.f44191m = -1;
        this.f44192n = -1.0f;
        m55521a(super.getContext(), attributeSet, i10, i11);
        this.f44193o = new HwColumnSystem(this.f44181c);
    }

    /* renamed from: a */
    private void m55523a(TypedArray typedArray) {
        this.f44189k = typedArray.getBoolean(C8734R.styleable.HwSpinner_hwColumnEnabled, false);
        this.f44194p = typedArray.getBoolean(C8734R.styleable.HwSpinner_hwDynamicWidthEnabled, false);
        this.f44195q = typedArray.getDrawable(C8734R.styleable.HwSpinner_hwDropDownDivider);
        this.f44196r = typedArray.getBoolean(C8734R.styleable.HwSpinner_hwListShadowEnabled, false);
        this.f44199u = typedArray.getInt(C8734R.styleable.HwSpinner_hwListShadowSize, 2);
        this.f44198t = typedArray.getInt(C8734R.styleable.HwSpinner_hwWidgetStyle, 0);
        this.f44200v = typedArray.getColor(C8734R.styleable.HwSpinner_hwListShadowColor, -16777216);
        int resourceId = typedArray.getResourceId(C8734R.styleable.HwSpinner_hwPopupTheme, C8734R.style.Theme_Emui_HwSpinner);
        if (resourceId != 0) {
            this.f44181c = new ContextThemeWrapper(this.f44188j, resourceId);
        } else {
            this.f44181c = this.f44188j;
        }
    }

    /* renamed from: a */
    public int m55536a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10;
        if (spinnerAdapter == null) {
            return 0;
        }
        int selectedItemPosition = getSelectedItemPosition() <= 0 ? 0 : getSelectedItemPosition();
        int count = selectedItemPosition + 20;
        if (spinnerAdapter.getCount() <= count) {
            count = spinnerAdapter.getCount();
        }
        int i11 = selectedItemPosition - (20 - (count - selectedItemPosition));
        if (i11 <= 0) {
            i11 = 0;
            i10 = 0;
        } else {
            i10 = 0;
        }
        int measuredWidth = i10;
        View view = null;
        while (true) {
            if (i11 < count) {
                int itemViewType = spinnerAdapter.getItemViewType(i11);
                if (itemViewType != i10) {
                    view = null;
                    i10 = itemViewType;
                }
                view = spinnerAdapter.getView(i11, view, this);
                if (view != null) {
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0));
                    if (this.f44194p && i11 == getSelectedItemPosition()) {
                        measuredWidth = view.getMeasuredWidth();
                        break;
                    }
                    if (measuredWidth <= view.getMeasuredWidth()) {
                        measuredWidth = view.getMeasuredWidth();
                    }
                    i11++;
                } else {
                    return 0;
                }
            } else {
                break;
            }
        }
        if (drawable == null) {
            return measuredWidth;
        }
        drawable.getPadding(this.f44180b);
        Rect rect = this.f44180b;
        return measuredWidth + rect.left + rect.right;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m55535a(int r6) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r5 = this;
            com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem r0 = r5.f44193o
            r1 = 10
            r0.setColumnType(r1)
            int r0 = r5.f44190l
            if (r0 <= 0) goto L1e
            int r1 = r5.f44191m
            if (r1 <= 0) goto L1e
            float r2 = r5.f44192n
            r3 = 0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L1e
            com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem r3 = r5.f44193o
            android.content.Context r4 = r5.f44181c
            r3.updateConfigation(r4, r0, r1, r2)
            goto L25
        L1e:
            com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem r0 = r5.f44193o
            android.content.Context r1 = r5.f44181c
            r0.updateConfigation(r1)
        L25:
            com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem r0 = r5.f44193o
            int r0 = r0.getMaxColumnWidth()
            com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem r5 = r5.f44193o
            int r5 = r5.getMinColumnWidth()
            if (r6 <= r0) goto L35
            r6 = r0
            goto L38
        L35:
            if (r6 >= r5) goto L38
            r6 = r5
        L38:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwspinner.widget.HwSpinner.m55535a(int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m55524a() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: a */
    private void m55522a(Context context, aauaf aauafVar, TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(C8734R.styleable.HwSpinner_hwDropDownSelector);
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(context, C8734R.drawable.hwspinner_list_selector_emui);
        }
        aauafVar.setListSelector(drawable);
    }
}
