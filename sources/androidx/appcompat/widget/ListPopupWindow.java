package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.InterfaceC0417n;
import androidx.core.widget.C0668i;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class ListPopupWindow implements InterfaceC0417n {

    /* renamed from: A */
    public Runnable f2006A;

    /* renamed from: B */
    public final Handler f2007B;

    /* renamed from: C */
    public final Rect f2008C;

    /* renamed from: D */
    public Rect f2009D;

    /* renamed from: E */
    public boolean f2010E;

    /* renamed from: F */
    public PopupWindow f2011F;

    /* renamed from: a */
    public Context f2012a;

    /* renamed from: b */
    public ListAdapter f2013b;

    /* renamed from: c */
    public DropDownListView f2014c;

    /* renamed from: d */
    public int f2015d;

    /* renamed from: e */
    public int f2016e;

    /* renamed from: f */
    public int f2017f;

    /* renamed from: g */
    public int f2018g;

    /* renamed from: h */
    public int f2019h;

    /* renamed from: i */
    public boolean f2020i;

    /* renamed from: j */
    public boolean f2021j;

    /* renamed from: k */
    public boolean f2022k;

    /* renamed from: l */
    public int f2023l;

    /* renamed from: m */
    public boolean f2024m;

    /* renamed from: n */
    public boolean f2025n;

    /* renamed from: o */
    public int f2026o;

    /* renamed from: p */
    public View f2027p;

    /* renamed from: q */
    public int f2028q;

    /* renamed from: r */
    public DataSetObserver f2029r;

    /* renamed from: s */
    public View f2030s;

    /* renamed from: t */
    public Drawable f2031t;

    /* renamed from: u */
    public AdapterView.OnItemClickListener f2032u;

    /* renamed from: v */
    public AdapterView.OnItemSelectedListener f2033v;

    /* renamed from: w */
    public final RunnableC0475i f2034w;

    /* renamed from: x */
    public final ViewOnTouchListenerC0474h f2035x;

    /* renamed from: y */
    public final C0473g f2036y;

    /* renamed from: z */
    public final RunnableC0471e f2037z;

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$a */
    public class RunnableC0467a implements Runnable {
        public RunnableC0467a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewM2730j = ListPopupWindow.this.m2730j();
            if (viewM2730j == null || viewM2730j.getWindowToken() == null) {
                return;
            }
            ListPopupWindow.this.show();
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$b */
    public class C0468b implements AdapterView.OnItemSelectedListener {
        public C0468b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            DropDownListView dropDownListView;
            if (i10 == -1 || (dropDownListView = ListPopupWindow.this.f2014c) == null) {
                return;
            }
            dropDownListView.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$c */
    public static class C0469c {
        /* renamed from: a */
        public static int m2747a(PopupWindow popupWindow, View view, int i10, boolean z10) {
            return popupWindow.getMaxAvailableHeight(view, i10, z10);
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$d */
    public static class C0470d {
        /* renamed from: a */
        public static void m2748a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        /* renamed from: b */
        public static void m2749b(PopupWindow popupWindow, boolean z10) {
            popupWindow.setIsClippedToScreen(z10);
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$e */
    public class RunnableC0471e implements Runnable {
        public RunnableC0471e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.m2728h();
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$f */
    public class C0472f extends DataSetObserver {
        public C0472f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$g */
    public class C0473g implements AbsListView.OnScrollListener {
        public C0473g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 != 1 || ListPopupWindow.this.m2737q() || ListPopupWindow.this.f2011F.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.f2007B.removeCallbacks(listPopupWindow.f2034w);
            ListPopupWindow.this.f2034w.run();
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$h */
    public class ViewOnTouchListenerC0474h implements View.OnTouchListener {
        public ViewOnTouchListenerC0474h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.f2011F) != null && popupWindow.isShowing() && x10 >= 0 && x10 < ListPopupWindow.this.f2011F.getWidth() && y10 >= 0 && y10 < ListPopupWindow.this.f2011F.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f2007B.postDelayed(listPopupWindow.f2034w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
            listPopupWindow2.f2007B.removeCallbacks(listPopupWindow2.f2034w);
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$i */
    public class RunnableC0475i implements Runnable {
        public RunnableC0475i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f2014c;
            if (dropDownListView == null || !C9603h0.m59863S(dropDownListView) || ListPopupWindow.this.f2014c.getCount() <= ListPopupWindow.this.f2014c.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.f2014c.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.f2026o) {
                listPopupWindow.f2011F.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R$attr.listPopupWindowStyle);
    }

    /* renamed from: A */
    public void m2720A(PopupWindow.OnDismissListener onDismissListener) {
        this.f2011F.setOnDismissListener(onDismissListener);
    }

    /* renamed from: B */
    public void m2721B(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2032u = onItemClickListener;
    }

    /* renamed from: C */
    public void m2722C(boolean z10) {
        this.f2022k = true;
        this.f2021j = z10;
    }

    /* renamed from: D */
    public final void m2723D(boolean z10) {
        C0470d.m2749b(this.f2011F, z10);
    }

    /* renamed from: E */
    public void m2724E(int i10) {
        this.f2028q = i10;
    }

    /* renamed from: F */
    public void m2725F(int i10) {
        DropDownListView dropDownListView = this.f2014c;
        if (!isShowing() || dropDownListView == null) {
            return;
        }
        dropDownListView.setListSelectionHidden(false);
        dropDownListView.setSelection(i10);
        if (dropDownListView.getChoiceMode() != 0) {
            dropDownListView.setItemChecked(i10, true);
        }
    }

    /* renamed from: G */
    public void m2726G(int i10) {
        this.f2016e = i10;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public void dismiss() {
        this.f2011F.dismiss();
        m2739s();
        this.f2011F.setContentView(null);
        this.f2014c = null;
        this.f2007B.removeCallbacks(this.f2034w);
    }

    /* renamed from: g */
    public final int m2727g() {
        int measuredHeight;
        int i10;
        int iMakeMeasureSpec;
        int i11;
        if (this.f2014c == null) {
            Context context = this.f2012a;
            this.f2006A = new RunnableC0467a();
            DropDownListView dropDownListViewMo2729i = mo2729i(context, !this.f2010E);
            this.f2014c = dropDownListViewMo2729i;
            Drawable drawable = this.f2031t;
            if (drawable != null) {
                dropDownListViewMo2729i.setSelector(drawable);
            }
            this.f2014c.setAdapter(this.f2013b);
            this.f2014c.setOnItemClickListener(this.f2032u);
            this.f2014c.setFocusable(true);
            this.f2014c.setFocusableInTouchMode(true);
            this.f2014c.setOnItemSelectedListener(new C0468b());
            this.f2014c.setOnScrollListener(this.f2036y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f2033v;
            if (onItemSelectedListener != null) {
                this.f2014c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f2014c;
            View view2 = this.f2027p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i12 = this.f2028q;
                if (i12 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i12 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f2028q);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i13 = this.f2016e;
                if (i13 >= 0) {
                    i11 = Integer.MIN_VALUE;
                } else {
                    i13 = 0;
                    i11 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i13, i11), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
            }
            this.f2011F.setContentView(view);
        } else {
            View view3 = this.f2027p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f2011F.getBackground();
        if (background != null) {
            background.getPadding(this.f2008C);
            Rect rect = this.f2008C;
            int i14 = rect.top;
            i10 = rect.bottom + i14;
            if (!this.f2020i) {
                this.f2018g = -i14;
            }
        } else {
            this.f2008C.setEmpty();
            i10 = 0;
        }
        int iM2731k = m2731k(m2730j(), this.f2018g, this.f2011F.getInputMethodMode() == 2);
        if (this.f2024m || this.f2015d == -1) {
            return iM2731k + i10;
        }
        int i15 = this.f2016e;
        if (i15 == -2) {
            int i16 = this.f2012a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f2008C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i15 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
        } else {
            int i17 = this.f2012a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f2008C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - (rect3.left + rect3.right), 1073741824);
        }
        int iMo2682d = this.f2014c.mo2682d(iMakeMeasureSpec, 0, -1, iM2731k - measuredHeight, -1);
        if (iMo2682d > 0) {
            measuredHeight += i10 + this.f2014c.getPaddingTop() + this.f2014c.getPaddingBottom();
        }
        return iMo2682d + measuredHeight;
    }

    public Drawable getBackground() {
        return this.f2011F.getBackground();
    }

    public int getHorizontalOffset() {
        return this.f2017f;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public ListView getListView() {
        return this.f2014c;
    }

    public int getVerticalOffset() {
        if (this.f2020i) {
            return this.f2018g;
        }
        return 0;
    }

    /* renamed from: h */
    public void m2728h() {
        DropDownListView dropDownListView = this.f2014c;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    /* renamed from: i */
    public DropDownListView mo2729i(Context context, boolean z10) {
        return new DropDownListView(context, z10);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public boolean isShowing() {
        return this.f2011F.isShowing();
    }

    /* renamed from: j */
    public View m2730j() {
        return this.f2030s;
    }

    /* renamed from: k */
    public final int m2731k(View view, int i10, boolean z10) {
        return C0469c.m2747a(this.f2011F, view, i10, z10);
    }

    /* renamed from: l */
    public Object m2732l() {
        if (isShowing()) {
            return this.f2014c.getSelectedItem();
        }
        return null;
    }

    /* renamed from: m */
    public long m2733m() {
        if (isShowing()) {
            return this.f2014c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    /* renamed from: n */
    public int m2734n() {
        if (isShowing()) {
            return this.f2014c.getSelectedItemPosition();
        }
        return -1;
    }

    /* renamed from: o */
    public View m2735o() {
        if (isShowing()) {
            return this.f2014c.getSelectedView();
        }
        return null;
    }

    /* renamed from: p */
    public int m2736p() {
        return this.f2016e;
    }

    /* renamed from: q */
    public boolean m2737q() {
        return this.f2011F.getInputMethodMode() == 2;
    }

    /* renamed from: r */
    public boolean m2738r() {
        return this.f2010E;
    }

    /* renamed from: s */
    public final void m2739s() {
        View view = this.f2027p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2027p);
            }
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f2029r;
        if (dataSetObserver == null) {
            this.f2029r = new C0472f();
        } else {
            ListAdapter listAdapter2 = this.f2013b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2013b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f2029r);
        }
        DropDownListView dropDownListView = this.f2014c;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f2013b);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f2011F.setBackgroundDrawable(drawable);
    }

    public void setHorizontalOffset(int i10) {
        this.f2017f = i10;
    }

    public void setVerticalOffset(int i10) {
        this.f2018g = i10;
        this.f2020i = true;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public void show() {
        int iM2727g = m2727g();
        boolean zM2737q = m2737q();
        C0668i.m4060b(this.f2011F, this.f2019h);
        if (this.f2011F.isShowing()) {
            if (C9603h0.m59863S(m2730j())) {
                int width = this.f2016e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = m2730j().getWidth();
                }
                int i10 = this.f2015d;
                if (i10 == -1) {
                    if (!zM2737q) {
                        iM2727g = -1;
                    }
                    if (zM2737q) {
                        this.f2011F.setWidth(this.f2016e == -1 ? -1 : 0);
                        this.f2011F.setHeight(0);
                    } else {
                        this.f2011F.setWidth(this.f2016e == -1 ? -1 : 0);
                        this.f2011F.setHeight(-1);
                    }
                } else if (i10 != -2) {
                    iM2727g = i10;
                }
                this.f2011F.setOutsideTouchable((this.f2025n || this.f2024m) ? false : true);
                this.f2011F.update(m2730j(), this.f2017f, this.f2018g, width < 0 ? -1 : width, iM2727g < 0 ? -1 : iM2727g);
                return;
            }
            return;
        }
        int width2 = this.f2016e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = m2730j().getWidth();
        }
        int i11 = this.f2015d;
        if (i11 == -1) {
            iM2727g = -1;
        } else if (i11 != -2) {
            iM2727g = i11;
        }
        this.f2011F.setWidth(width2);
        this.f2011F.setHeight(iM2727g);
        m2723D(true);
        this.f2011F.setOutsideTouchable((this.f2025n || this.f2024m) ? false : true);
        this.f2011F.setTouchInterceptor(this.f2035x);
        if (this.f2022k) {
            C0668i.m4059a(this.f2011F, this.f2021j);
        }
        C0470d.m2748a(this.f2011F, this.f2009D);
        C0668i.m4061c(this.f2011F, m2730j(), this.f2017f, this.f2018g, this.f2023l);
        this.f2014c.setSelection(-1);
        if (!this.f2010E || this.f2014c.isInTouchMode()) {
            m2728h();
        }
        if (this.f2010E) {
            return;
        }
        this.f2007B.post(this.f2037z);
    }

    /* renamed from: t */
    public void m2740t(View view) {
        this.f2030s = view;
    }

    /* renamed from: u */
    public void m2741u(int i10) {
        this.f2011F.setAnimationStyle(i10);
    }

    /* renamed from: v */
    public void m2742v(int i10) {
        Drawable background = this.f2011F.getBackground();
        if (background == null) {
            m2726G(i10);
            return;
        }
        background.getPadding(this.f2008C);
        Rect rect = this.f2008C;
        this.f2016e = rect.left + rect.right + i10;
    }

    /* renamed from: w */
    public void m2743w(int i10) {
        this.f2023l = i10;
    }

    /* renamed from: x */
    public void m2744x(Rect rect) {
        this.f2009D = rect != null ? new Rect(rect) : null;
    }

    /* renamed from: y */
    public void m2745y(int i10) {
        this.f2011F.setInputMethodMode(i10);
    }

    /* renamed from: z */
    public void m2746z(boolean z10) {
        this.f2010E = z10;
        this.f2011F.setFocusable(z10);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f2015d = -2;
        this.f2016e = -2;
        this.f2019h = 1002;
        this.f2023l = 0;
        this.f2024m = false;
        this.f2025n = false;
        this.f2026o = Integer.MAX_VALUE;
        this.f2028q = 0;
        this.f2034w = new RunnableC0475i();
        this.f2035x = new ViewOnTouchListenerC0474h();
        this.f2036y = new C0473g();
        this.f2037z = new RunnableC0471e();
        this.f2008C = new Rect();
        this.f2012a = context;
        this.f2007B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i10, i11);
        this.f2017f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f2018g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f2020i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i10, i11);
        this.f2011F = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
