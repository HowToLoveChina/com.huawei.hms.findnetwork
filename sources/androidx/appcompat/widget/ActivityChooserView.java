package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.InterfaceC0417n;
import androidx.core.view.ActionProvider;
import com.huawei.hiar.ARImageMetadata;
import p273f0.C9603h0;
import p304g0.C9832l;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a */
    public final C0444f f1849a;

    /* renamed from: b */
    public final ViewOnClickListenerC0445g f1850b;

    /* renamed from: c */
    public final View f1851c;

    /* renamed from: d */
    public final Drawable f1852d;

    /* renamed from: e */
    public final FrameLayout f1853e;

    /* renamed from: f */
    public final ImageView f1854f;

    /* renamed from: g */
    public final FrameLayout f1855g;

    /* renamed from: h */
    public final ImageView f1856h;

    /* renamed from: i */
    public final int f1857i;

    /* renamed from: j */
    public ActionProvider f1858j;

    /* renamed from: k */
    public final DataSetObserver f1859k;

    /* renamed from: l */
    public final ViewTreeObserver.OnGlobalLayoutListener f1860l;

    /* renamed from: m */
    public ListPopupWindow f1861m;

    /* renamed from: n */
    public PopupWindow.OnDismissListener f1862n;

    /* renamed from: o */
    public boolean f1863o;

    /* renamed from: p */
    public int f1864p;

    /* renamed from: q */
    public boolean f1865q;

    /* renamed from: r */
    public int f1866r;

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a */
        public static final int[] f1867a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C0523e0 c0523e0M2945u = C0523e0.m2945u(context, attributeSet, f1867a);
            setBackgroundDrawable(c0523e0M2945u.m2953g(0));
            c0523e0M2945u.m2966w();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$a */
    public class C0439a extends DataSetObserver {
        public C0439a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f1849a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f1849a.notifyDataSetInvalidated();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$b */
    public class ViewTreeObserverOnGlobalLayoutListenerC0440b implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC0440b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.m2604b()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                ActionProvider actionProvider = ActivityChooserView.this.f1858j;
                if (actionProvider != null) {
                    actionProvider.m3938k(true);
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$c */
    public class C0441c extends View.AccessibilityDelegate {
        public C0441c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            C9832l.m61042A0(accessibilityNodeInfo).m61062R(true);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$d */
    public class C0442d extends AbstractViewOnTouchListenerC0546u {
        public C0442d(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u
        /* renamed from: b */
        public InterfaceC0417n mo2324b() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u
        /* renamed from: c */
        public boolean mo2325c() {
            ActivityChooserView.this.m2605c();
            return true;
        }

        @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u
        /* renamed from: d */
        public boolean mo2582d() {
            ActivityChooserView.this.m2603a();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$e */
    public class C0443e extends DataSetObserver {
        public C0443e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.m2607e();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$f */
    public class C0444f extends BaseAdapter {

        /* renamed from: a */
        public C0516b f1873a;

        /* renamed from: b */
        public int f1874b = 4;

        /* renamed from: c */
        public boolean f1875c;

        /* renamed from: d */
        public boolean f1876d;

        /* renamed from: e */
        public boolean f1877e;

        public C0444f() {
        }

        /* renamed from: a */
        public int m2608a() {
            return this.f1873a.m2901f();
        }

        /* renamed from: b */
        public C0516b m2609b() {
            return this.f1873a;
        }

        /* renamed from: c */
        public ResolveInfo m2610c() {
            return this.f1873a.m2903h();
        }

        /* renamed from: d */
        public int m2611d() {
            return this.f1873a.m2904i();
        }

        /* renamed from: e */
        public boolean m2612e() {
            return this.f1875c;
        }

        /* renamed from: f */
        public int m2613f() {
            int i10 = this.f1874b;
            this.f1874b = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int iMax = 0;
            View view = null;
            for (int i11 = 0; i11 < count; i11++) {
                view = getView(i11, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.f1874b = i10;
            return iMax;
        }

        /* renamed from: g */
        public void m2614g(C0516b c0516b) {
            C0516b c0516bM2609b = ActivityChooserView.this.f1849a.m2609b();
            if (c0516bM2609b != null && ActivityChooserView.this.isShown()) {
                c0516bM2609b.unregisterObserver(ActivityChooserView.this.f1859k);
            }
            this.f1873a = c0516b;
            if (c0516b != null && ActivityChooserView.this.isShown()) {
                c0516b.registerObserver(ActivityChooserView.this.f1859k);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iM2901f = this.f1873a.m2901f();
            if (!this.f1875c && this.f1873a.m2903h() != null) {
                iM2901f--;
            }
            int iMin = Math.min(iM2901f, this.f1874b);
            return this.f1877e ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f1875c && this.f1873a.m2903h() != null) {
                i10++;
            }
            return this.f1873a.m2900e(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i10) {
            return (this.f1877e && i10 == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                viewInflate.setId(1);
                ((TextView) viewInflate.findViewById(R$id.title)).setText(ActivityChooserView.this.getContext().getString(R$string.abc_activity_chooser_view_see_all));
                return viewInflate;
            }
            if (view == null || view.getId() != R$id.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(R$id.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i10);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(R$id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f1875c && i10 == 0 && this.f1876d) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        /* renamed from: h */
        public void m2615h(int i10) {
            if (this.f1874b != i10) {
                this.f1874b = i10;
                notifyDataSetChanged();
            }
        }

        /* renamed from: i */
        public void m2616i(boolean z10, boolean z11) {
            if (this.f1875c == z10 && this.f1876d == z11) {
                return;
            }
            this.f1875c = z10;
            this.f1876d = z11;
            notifyDataSetChanged();
        }

        /* renamed from: j */
        public void m2617j(boolean z10) {
            if (this.f1877e != z10) {
                this.f1877e = z10;
                notifyDataSetChanged();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$g */
    public class ViewOnClickListenerC0445g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public ViewOnClickListenerC0445g() {
        }

        /* renamed from: a */
        public final void m2618a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f1862n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f1855g) {
                if (view != activityChooserView.f1853e) {
                    throw new IllegalArgumentException();
                }
                activityChooserView.f1863o = false;
                activityChooserView.m2606d(activityChooserView.f1864p);
                return;
            }
            activityChooserView.m2603a();
            Intent intentM2898b = ActivityChooserView.this.f1849a.m2609b().m2898b(ActivityChooserView.this.f1849a.m2609b().m2902g(ActivityChooserView.this.f1849a.m2610c()));
            if (intentM2898b != null) {
                intentM2898b.addFlags(ARImageMetadata.LENS_APERTURE);
                ActivityChooserView.this.getContext().startActivity(intentM2898b);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            m2618a();
            ActionProvider actionProvider = ActivityChooserView.this.f1858j;
            if (actionProvider != null) {
                actionProvider.m3938k(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            int itemViewType = ((C0444f) adapterView.getAdapter()).getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.m2606d(Integer.MAX_VALUE);
                return;
            }
            ActivityChooserView.this.m2603a();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.f1863o) {
                if (i10 > 0) {
                    activityChooserView.f1849a.m2609b().m2910o(i10);
                    return;
                }
                return;
            }
            if (!activityChooserView.f1849a.m2612e()) {
                i10++;
            }
            Intent intentM2898b = ActivityChooserView.this.f1849a.m2609b().m2898b(i10);
            if (intentM2898b != null) {
                intentM2898b.addFlags(ARImageMetadata.LENS_APERTURE);
                ActivityChooserView.this.getContext().startActivity(intentM2898b);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f1855g) {
                throw new IllegalArgumentException();
            }
            if (activityChooserView.f1849a.getCount() > 0) {
                ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                activityChooserView2.f1863o = true;
                activityChooserView2.m2606d(activityChooserView2.f1864p);
            }
            return true;
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public boolean m2603a() {
        if (!m2604b()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1860l);
        return true;
    }

    /* renamed from: b */
    public boolean m2604b() {
        return getListPopupWindow().isShowing();
    }

    /* renamed from: c */
    public boolean m2605c() {
        if (m2604b() || !this.f1865q) {
            return false;
        }
        this.f1863o = false;
        m2606d(this.f1864p);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean, int] */
    /* renamed from: d */
    public void m2606d(int i10) {
        if (this.f1849a.m2609b() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1860l);
        ?? r02 = this.f1855g.getVisibility() == 0 ? 1 : 0;
        int iM2608a = this.f1849a.m2608a();
        if (i10 == Integer.MAX_VALUE || iM2608a <= i10 + r02) {
            this.f1849a.m2617j(false);
            this.f1849a.m2615h(i10);
        } else {
            this.f1849a.m2617j(true);
            this.f1849a.m2615h(i10 - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.isShowing()) {
            return;
        }
        if (this.f1863o || r02 == 0) {
            this.f1849a.m2616i(true, r02);
        } else {
            this.f1849a.m2616i(false, false);
        }
        listPopupWindow.m2742v(Math.min(this.f1849a.m2613f(), this.f1857i));
        listPopupWindow.show();
        ActionProvider actionProvider = this.f1858j;
        if (actionProvider != null) {
            actionProvider.m3938k(true);
        }
        listPopupWindow.getListView().setContentDescription(getContext().getString(R$string.abc_activitychooserview_choose_application));
        listPopupWindow.getListView().setSelector(new ColorDrawable(0));
    }

    /* renamed from: e */
    public void m2607e() {
        if (this.f1849a.getCount() > 0) {
            this.f1853e.setEnabled(true);
        } else {
            this.f1853e.setEnabled(false);
        }
        int iM2608a = this.f1849a.m2608a();
        int iM2611d = this.f1849a.m2611d();
        if (iM2608a == 1 || (iM2608a > 1 && iM2611d > 0)) {
            this.f1855g.setVisibility(0);
            ResolveInfo resolveInfoM2610c = this.f1849a.m2610c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f1856h.setImageDrawable(resolveInfoM2610c.loadIcon(packageManager));
            if (this.f1866r != 0) {
                this.f1855g.setContentDescription(getContext().getString(this.f1866r, resolveInfoM2610c.loadLabel(packageManager)));
            }
        } else {
            this.f1855g.setVisibility(8);
        }
        if (this.f1855g.getVisibility() == 0) {
            this.f1851c.setBackgroundDrawable(this.f1852d);
        } else {
            this.f1851c.setBackgroundDrawable(null);
        }
    }

    public C0516b getDataModel() {
        return this.f1849a.m2609b();
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f1861m == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f1861m = listPopupWindow;
            listPopupWindow.setAdapter(this.f1849a);
            this.f1861m.m2740t(this);
            this.f1861m.m2746z(true);
            this.f1861m.m2721B(this.f1850b);
            this.f1861m.m2720A(this.f1850b);
        }
        return this.f1861m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0516b c0516bM2609b = this.f1849a.m2609b();
        if (c0516bM2609b != null) {
            c0516bM2609b.registerObserver(this.f1859k);
        }
        this.f1865q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0516b c0516bM2609b = this.f1849a.m2609b();
        if (c0516bM2609b != null) {
            c0516bM2609b.unregisterObserver(this.f1859k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1860l);
        }
        if (m2604b()) {
            m2603a();
        }
        this.f1865q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f1851c.layout(0, 0, i12 - i10, i13 - i11);
        if (m2604b()) {
            return;
        }
        m2603a();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        View view = this.f1851c;
        if (this.f1855g.getVisibility() != 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), 1073741824);
        }
        measureChild(view, i10, i11);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0516b c0516b) {
        this.f1849a.m2614g(c0516b);
        if (m2604b()) {
            m2603a();
            m2605c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i10) {
        this.f1866r = i10;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i10) {
        this.f1854f.setContentDescription(getContext().getString(i10));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1854f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i10) {
        this.f1864p = i10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1862n = onDismissListener;
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f1858j = actionProvider;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1859k = new C0439a();
        this.f1860l = new ViewTreeObserverOnGlobalLayoutListenerC0440b();
        this.f1864p = 4;
        int[] iArr = R$styleable.ActivityChooserView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        C9603h0.m59898n0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        this.f1864p = typedArrayObtainStyledAttributes.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.abc_activity_chooser_view, (ViewGroup) this, true);
        ViewOnClickListenerC0445g viewOnClickListenerC0445g = new ViewOnClickListenerC0445g();
        this.f1850b = viewOnClickListenerC0445g;
        View viewFindViewById = findViewById(R$id.activity_chooser_view_content);
        this.f1851c = viewFindViewById;
        this.f1852d = viewFindViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.default_activity_button);
        this.f1855g = frameLayout;
        frameLayout.setOnClickListener(viewOnClickListenerC0445g);
        frameLayout.setOnLongClickListener(viewOnClickListenerC0445g);
        int i11 = R$id.image;
        this.f1856h = (ImageView) frameLayout.findViewById(i11);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.expand_activities_button);
        frameLayout2.setOnClickListener(viewOnClickListenerC0445g);
        frameLayout2.setAccessibilityDelegate(new C0441c());
        frameLayout2.setOnTouchListener(new C0442d(frameLayout2));
        this.f1853e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i11);
        this.f1854f = imageView;
        imageView.setImageDrawable(drawable);
        C0444f c0444f = new C0444f();
        this.f1849a = c0444f;
        c0444f.registerDataSetObserver(new C0443e());
        Resources resources = context.getResources();
        this.f1857i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }
}
