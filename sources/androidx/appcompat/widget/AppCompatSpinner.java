package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.InterfaceC0417n;
import p211d.C8968a;
import p243e0.C9368c;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner {

    /* renamed from: i */
    @SuppressLint({"ResourceType"})
    public static final int[] f1917i = {R.attr.spinnerMode};

    /* renamed from: a */
    public final C0518c f1918a;

    /* renamed from: b */
    public final Context f1919b;

    /* renamed from: c */
    public AbstractViewOnTouchListenerC0546u f1920c;

    /* renamed from: d */
    public SpinnerAdapter f1921d;

    /* renamed from: e */
    public final boolean f1922e;

    /* renamed from: f */
    public InterfaceC0456i f1923f;

    /* renamed from: g */
    public int f1924g;

    /* renamed from: h */
    public final Rect f1925h;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0447a();

        /* renamed from: a */
        public boolean f1926a;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$SavedState$a */
        public class C0447a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f1926a ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1926a = parcel.readByte() != 0;
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$a */
    public class C0448a extends AbstractViewOnTouchListenerC0546u {

        /* renamed from: j */
        public final /* synthetic */ C0455h f1927j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0448a(View view, C0455h c0455h) {
            super(view);
            this.f1927j = c0455h;
        }

        @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u
        /* renamed from: b */
        public InterfaceC0417n mo2324b() {
            return this.f1927j;
        }

        @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u
        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: c */
        public boolean mo2325c() {
            if (AppCompatSpinner.this.getInternalPopup().isShowing()) {
                return true;
            }
            AppCompatSpinner.this.m2634b();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$b */
    public class ViewTreeObserverOnGlobalLayoutListenerC0449b implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC0449b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                AppCompatSpinner.this.m2634b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                C0450c.m2637a(viewTreeObserver, this);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$c */
    public static final class C0450c {
        /* renamed from: a */
        public static void m2637a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$d */
    public static final class C0451d {
        /* renamed from: a */
        public static int m2638a(View view) {
            return view.getTextAlignment();
        }

        /* renamed from: b */
        public static int m2639b(View view) {
            return view.getTextDirection();
        }

        /* renamed from: c */
        public static void m2640c(View view, int i10) {
            view.setTextAlignment(i10);
        }

        /* renamed from: d */
        public static void m2641d(View view, int i10) {
            view.setTextDirection(i10);
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$e */
    public static final class C0452e {
        /* renamed from: a */
        public static void m2642a(android.widget.ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (C9368c.m58729a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$f */
    public class DialogInterfaceOnClickListenerC0453f implements InterfaceC0456i, DialogInterface.OnClickListener {

        /* renamed from: a */
        public AlertDialog f1930a;

        /* renamed from: b */
        public ListAdapter f1931b;

        /* renamed from: c */
        public CharSequence f1932c;

        public DialogInterfaceOnClickListenerC0453f() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        /* renamed from: b */
        public CharSequence mo2643b() {
            return this.f1932c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        /* renamed from: d */
        public void mo2644d(CharSequence charSequence) {
            this.f1932c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        public void dismiss() {
            AlertDialog alertDialog = this.f1930a;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f1930a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        /* renamed from: e */
        public void mo2645e(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        /* renamed from: f */
        public void mo2646f(int i10, int i11) {
            if (this.f1931b == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f1932c;
            if (charSequence != null) {
                builder.mo2034h(charSequence);
            }
            AlertDialog alertDialogMo2027a = builder.mo2033g(this.f1931b, AppCompatSpinner.this.getSelectedItemPosition(), this).mo2027a();
            this.f1930a = alertDialogMo2027a;
            ListView listViewM2024n = alertDialogMo2027a.m2024n();
            C0451d.m2641d(listViewM2024n, i10);
            C0451d.m2640c(listViewM2024n, i11);
            this.f1930a.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        public Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        public int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        public int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        public boolean isShowing() {
            AlertDialog alertDialog = this.f1930a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AppCompatSpinner.this.setSelection(i10);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i10, this.f1931b.getItemId(i10));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        public void setAdapter(ListAdapter listAdapter) {
            this.f1931b = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        public void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        public void setHorizontalOffset(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        public void setVerticalOffset(int i10) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$g */
    public static class C0454g implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        public SpinnerAdapter f1934a;

        /* renamed from: b */
        public ListAdapter f1935b;

        public C0454g(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1934a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1935b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter) {
                    C0452e.m2642a((android.widget.ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() == null) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1935b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1934a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1934a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1934a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1934a;
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
            SpinnerAdapter spinnerAdapter = this.f1934a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f1935b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1934a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1934a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$h */
    public class C0455h extends ListPopupWindow implements InterfaceC0456i {

        /* renamed from: G */
        public CharSequence f1936G;

        /* renamed from: H */
        public ListAdapter f1937H;

        /* renamed from: I */
        public final Rect f1938I;

        /* renamed from: J */
        public int f1939J;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$h$a */
        public class a implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            public final /* synthetic */ AppCompatSpinner f1941a;

            public a(AppCompatSpinner appCompatSpinner) {
                this.f1941a = appCompatSpinner;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                AppCompatSpinner.this.setSelection(i10);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    C0455h c0455h = C0455h.this;
                    AppCompatSpinner.this.performItemClick(view, i10, c0455h.f1937H.getItemId(i10));
                }
                C0455h.this.dismiss();
            }
        }

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$h$b */
        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                C0455h c0455h = C0455h.this;
                if (!c0455h.m2650K(AppCompatSpinner.this)) {
                    C0455h.this.dismiss();
                } else {
                    C0455h.this.m2648I();
                    C0455h.super.show();
                }
            }
        }

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$h$c */
        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: a */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1944a;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1944a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1944a);
                }
            }
        }

        public C0455h(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f1938I = new Rect();
            m2740t(AppCompatSpinner.this);
            m2746z(true);
            m2724E(0);
            m2721B(new a(AppCompatSpinner.this));
        }

        /* renamed from: I */
        public void m2648I() {
            int i10;
            Drawable background = getBackground();
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.f1925h);
                i10 = C0535k0.m3056b(AppCompatSpinner.this) ? AppCompatSpinner.this.f1925h.right : -AppCompatSpinner.this.f1925h.left;
            } else {
                Rect rect = AppCompatSpinner.this.f1925h;
                rect.right = 0;
                rect.left = 0;
                i10 = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i11 = appCompatSpinner.f1924g;
            if (i11 == -2) {
                int iM2633a = appCompatSpinner.m2633a((SpinnerAdapter) this.f1937H, getBackground());
                int i12 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f1925h;
                int i13 = (i12 - rect2.left) - rect2.right;
                if (iM2633a > i13) {
                    iM2633a = i13;
                }
                m2742v(Math.max(iM2633a, (width - paddingLeft) - paddingRight));
            } else if (i11 == -1) {
                m2742v((width - paddingLeft) - paddingRight);
            } else {
                m2742v(i11);
            }
            setHorizontalOffset(C0535k0.m3056b(AppCompatSpinner.this) ? i10 + (((width - paddingRight) - m2736p()) - m2649J()) : i10 + paddingLeft + m2649J());
        }

        /* renamed from: J */
        public int m2649J() {
            return this.f1939J;
        }

        /* renamed from: K */
        public boolean m2650K(View view) {
            return C9603h0.m59863S(view) && view.getGlobalVisibleRect(this.f1938I);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        /* renamed from: b */
        public CharSequence mo2643b() {
            return this.f1936G;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        /* renamed from: d */
        public void mo2644d(CharSequence charSequence) {
            this.f1936G = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        /* renamed from: e */
        public void mo2645e(int i10) {
            this.f1939J = i10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        /* renamed from: f */
        public void mo2646f(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean zIsShowing = isShowing();
            m2648I();
            m2745y(2);
            super.show();
            ListView listView = getListView();
            listView.setChoiceMode(1);
            C0451d.m2641d(listView, i10);
            C0451d.m2640c(listView, i11);
            m2725F(AppCompatSpinner.this.getSelectedItemPosition());
            if (zIsShowing || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            m2720A(new c(bVar));
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.InterfaceC0456i
        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.f1937H = listAdapter;
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$i */
    public interface InterfaceC0456i {
        /* renamed from: b */
        CharSequence mo2643b();

        /* renamed from: d */
        void mo2644d(CharSequence charSequence);

        void dismiss();

        /* renamed from: e */
        void mo2645e(int i10);

        /* renamed from: f */
        void mo2646f(int i10, int i11);

        Drawable getBackground();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i10);

        void setVerticalOffset(int i10);
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public int m2633a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f1925h);
        Rect rect = this.f1925h;
        return iMax2 + rect.left + rect.right;
    }

    /* renamed from: b */
    public void m2634b() {
        this.f1923f.mo2646f(C0451d.m2639b(this), C0451d.m2638a(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0518c c0518c = this.f1918a;
        if (c0518c != null) {
            c0518c.m2918b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        InterfaceC0456i interfaceC0456i = this.f1923f;
        return interfaceC0456i != null ? interfaceC0456i.getHorizontalOffset() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        InterfaceC0456i interfaceC0456i = this.f1923f;
        return interfaceC0456i != null ? interfaceC0456i.getVerticalOffset() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f1923f != null ? this.f1924g : super.getDropDownWidth();
    }

    public final InterfaceC0456i getInternalPopup() {
        return this.f1923f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        InterfaceC0456i interfaceC0456i = this.f1923f;
        return interfaceC0456i != null ? interfaceC0456i.getBackground() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1919b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        InterfaceC0456i interfaceC0456i = this.f1923f;
        return interfaceC0456i != null ? interfaceC0456i.mo2643b() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0518c c0518c = this.f1918a;
        if (c0518c != null) {
            return c0518c.m2919c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0518c c0518c = this.f1918a;
        if (c0518c != null) {
            return c0518c.m2920d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC0456i interfaceC0456i = this.f1923f;
        if (interfaceC0456i == null || !interfaceC0456i.isShowing()) {
            return;
        }
        this.f1923f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f1923f == null || View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m2633a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f1926a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0449b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        InterfaceC0456i interfaceC0456i = this.f1923f;
        savedState.f1926a = interfaceC0456i != null && interfaceC0456i.isShowing();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractViewOnTouchListenerC0546u abstractViewOnTouchListenerC0546u = this.f1920c;
        if (abstractViewOnTouchListenerC0546u == null || !abstractViewOnTouchListenerC0546u.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        InterfaceC0456i interfaceC0456i = this.f1923f;
        if (interfaceC0456i == null) {
            return super.performClick();
        }
        if (interfaceC0456i.isShowing()) {
            return true;
        }
        m2634b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0518c c0518c = this.f1918a;
        if (c0518c != null) {
            c0518c.m2922f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0518c c0518c = this.f1918a;
        if (c0518c != null) {
            c0518c.m2923g(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        InterfaceC0456i interfaceC0456i = this.f1923f;
        if (interfaceC0456i == null) {
            super.setDropDownHorizontalOffset(i10);
        } else {
            interfaceC0456i.mo2645e(i10);
            this.f1923f.setHorizontalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        InterfaceC0456i interfaceC0456i = this.f1923f;
        if (interfaceC0456i != null) {
            interfaceC0456i.setVerticalOffset(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.f1923f != null) {
            this.f1924g = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        InterfaceC0456i interfaceC0456i = this.f1923f;
        if (interfaceC0456i != null) {
            interfaceC0456i.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(C8968a.m56743b(getPopupContext(), i10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        InterfaceC0456i interfaceC0456i = this.f1923f;
        if (interfaceC0456i != null) {
            interfaceC0456i.mo2644d(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0518c c0518c = this.f1918a;
        if (c0518c != null) {
            c0518c.m2925i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0518c c0518c = this.f1918a;
        if (c0518c != null) {
            c0518c.m2926j(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spinnerStyle);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1922e) {
            this.f1921d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1923f != null) {
            Context context = this.f1919b;
            if (context == null) {
                context = getContext();
            }
            this.f1923f.setAdapter(new C0454g(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00db  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.AppCompatSpinner] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
