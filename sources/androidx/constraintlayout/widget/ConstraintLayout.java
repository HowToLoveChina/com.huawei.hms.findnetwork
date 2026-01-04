package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import p479n.C11575e;
import p561q.C12257d;
import p561q.C12258e;
import p561q.C12259f;
import p561q.C12261h;
import p561q.C12264k;
import p561q.C12266m;
import p596r.C12435b;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.2.0-alpha04";
    private static C0587e sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected C0584b mConstraintLayoutSpec;
    private C0585c mConstraintSet;
    private int mConstraintSetId;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected C12259f mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    C0581b mMeasurer;
    private C11575e mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private ArrayList<InterfaceC0582c> mModifiers;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<C12258e> mTempMapIdToWidget;

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a */
    public static /* synthetic */ class C0580a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f3026a;

        static {
            int[] iArr = new int[C12258e.b.values().length];
            f3026a = iArr;
            try {
                iArr[C12258e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3026a[C12258e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3026a[C12258e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3026a[C12258e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$b */
    public class C0581b implements C12435b.b {

        /* renamed from: a */
        public ConstraintLayout f3027a;

        /* renamed from: b */
        public int f3028b;

        /* renamed from: c */
        public int f3029c;

        /* renamed from: d */
        public int f3030d;

        /* renamed from: e */
        public int f3031e;

        /* renamed from: f */
        public int f3032f;

        /* renamed from: g */
        public int f3033g;

        public C0581b(ConstraintLayout constraintLayout) {
            this.f3027a = constraintLayout;
        }

        @Override // p596r.C12435b.b
        /* renamed from: a */
        public final void mo3571a() {
            int childCount = this.f3027a.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.f3027a.getChildAt(i10);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).m3580b(this.f3027a);
                }
            }
            int size = this.f3027a.mConstraintHelpers.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    ((ConstraintHelper) this.f3027a.mConstraintHelpers.get(i11)).m3565s(this.f3027a);
                }
            }
        }

        @Override // p596r.C12435b.b
        @SuppressLint({"WrongCall"})
        /* renamed from: b */
        public final void mo3572b(C12258e c12258e, C12435b.a aVar) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int baseline;
            int iMax;
            int i10;
            int measuredHeight;
            int i11;
            if (c12258e == null) {
                return;
            }
            if (c12258e.m73592X() == 8 && !c12258e.m73627l0()) {
                aVar.f57288e = 0;
                aVar.f57289f = 0;
                aVar.f57290g = 0;
                return;
            }
            if (c12258e.m73570M() == null) {
                return;
            }
            ConstraintLayout.access$000(ConstraintLayout.this);
            C12258e.b bVar = aVar.f57284a;
            C12258e.b bVar2 = aVar.f57285b;
            int i12 = aVar.f57286c;
            int i13 = aVar.f57287d;
            int i14 = this.f3028b + this.f3029c;
            int i15 = this.f3030d;
            View view = (View) c12258e.m73650u();
            int[] iArr = C0580a.f3026a;
            int i16 = iArr[bVar.ordinal()];
            if (i16 == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else if (i16 == 2) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f3032f, i15, -2);
            } else if (i16 == 3) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f3032f, i15 + c12258e.m73552D(), -1);
            } else if (i16 != 4) {
                iMakeMeasureSpec = 0;
            } else {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f3032f, i15, -2);
                boolean z10 = c12258e.f56792w == 1;
                int i17 = aVar.f57293j;
                if (i17 == C12435b.a.f57282l || i17 == C12435b.a.f57283m) {
                    boolean z11 = view.getMeasuredHeight() == c12258e.m73662z();
                    if (aVar.f57293j == C12435b.a.f57283m || !z10 || ((z10 && z11) || (view instanceof Placeholder) || c12258e.mo73515p0())) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(c12258e.m73594Y(), 1073741824);
                    }
                }
            }
            int i18 = iArr[bVar2.ordinal()];
            if (i18 == 1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
            } else if (i18 == 2) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f3033g, i14, -2);
            } else if (i18 == 3) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f3033g, i14 + c12258e.m73590W(), -1);
            } else if (i18 != 4) {
                iMakeMeasureSpec2 = 0;
            } else {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f3033g, i14, -2);
                boolean z12 = c12258e.f56794x == 1;
                int i19 = aVar.f57293j;
                if (i19 == C12435b.a.f57282l || i19 == C12435b.a.f57283m) {
                    boolean z13 = view.getMeasuredWidth() == c12258e.m73594Y();
                    if (aVar.f57293j == C12435b.a.f57283m || !z12 || ((z12 && z13) || (view instanceof Placeholder) || c12258e.mo73516q0())) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(c12258e.m73662z(), 1073741824);
                    }
                }
            }
            C12259f c12259f = (C12259f) c12258e.m73570M();
            if (c12259f != null && C12264k.m73772b(ConstraintLayout.this.mOptimizationLevel, 256) && view.getMeasuredWidth() == c12258e.m73594Y() && view.getMeasuredWidth() < c12259f.m73594Y() && view.getMeasuredHeight() == c12258e.m73662z() && view.getMeasuredHeight() < c12259f.m73662z() && view.getBaseline() == c12258e.m73641r() && !c12258e.m73635o0() && m3574d(c12258e.m73554E(), iMakeMeasureSpec, c12258e.m73594Y()) && m3574d(c12258e.m73556F(), iMakeMeasureSpec2, c12258e.m73662z())) {
                aVar.f57288e = c12258e.m73594Y();
                aVar.f57289f = c12258e.m73662z();
                aVar.f57290g = c12258e.m73641r();
                return;
            }
            C12258e.b bVar3 = C12258e.b.MATCH_CONSTRAINT;
            boolean z14 = bVar == bVar3;
            boolean z15 = bVar2 == bVar3;
            C12258e.b bVar4 = C12258e.b.MATCH_PARENT;
            boolean z16 = bVar2 == bVar4 || bVar2 == C12258e.b.FIXED;
            boolean z17 = bVar == bVar4 || bVar == C12258e.b.FIXED;
            boolean z18 = z14 && c12258e.f56759f0 > 0.0f;
            boolean z19 = z15 && c12258e.f56759f0 > 0.0f;
            if (view == null) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i20 = aVar.f57293j;
            if (i20 != C12435b.a.f57282l && i20 != C12435b.a.f57283m && z14 && c12258e.f56792w == 0 && z15 && c12258e.f56794x == 0) {
                i11 = -1;
                measuredHeight = 0;
                baseline = 0;
                iMax = 0;
            } else {
                if ((view instanceof VirtualLayout) && (c12258e instanceof C12266m)) {
                    ((VirtualLayout) view).mo3234x((C12266m) c12258e, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                c12258e.m73599a1(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i21 = c12258e.f56798z;
                iMax = i21 > 0 ? Math.max(i21, measuredWidth) : measuredWidth;
                int i22 = c12258e.f56702A;
                if (i22 > 0) {
                    iMax = Math.min(i22, iMax);
                }
                int i23 = c12258e.f56706C;
                if (i23 > 0) {
                    measuredHeight = Math.max(i23, measuredHeight2);
                    i10 = iMakeMeasureSpec;
                } else {
                    i10 = iMakeMeasureSpec;
                    measuredHeight = measuredHeight2;
                }
                int i24 = c12258e.f56708D;
                if (i24 > 0) {
                    measuredHeight = Math.min(i24, measuredHeight);
                }
                int i25 = iMakeMeasureSpec2;
                if (!C12264k.m73772b(ConstraintLayout.this.mOptimizationLevel, 1)) {
                    if (z18 && z16) {
                        iMax = (int) ((measuredHeight * c12258e.f56759f0) + 0.5f);
                    } else if (z19 && z17) {
                        measuredHeight = (int) ((iMax / c12258e.f56759f0) + 0.5f);
                    }
                }
                if (measuredWidth != iMax || measuredHeight2 != measuredHeight) {
                    int iMakeMeasureSpec3 = measuredWidth != iMax ? View.MeasureSpec.makeMeasureSpec(iMax, 1073741824) : i10;
                    int iMakeMeasureSpec4 = measuredHeight2 != measuredHeight ? View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824) : i25;
                    view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
                    c12258e.m73599a1(iMakeMeasureSpec3, iMakeMeasureSpec4);
                    iMax = view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i11 = -1;
            }
            boolean z20 = baseline != i11;
            aVar.f57292i = (iMax == aVar.f57286c && measuredHeight == aVar.f57287d) ? false : true;
            if (layoutParams.f2989g0) {
                z20 = true;
            }
            if (z20 && baseline != -1 && c12258e.m73641r() != baseline) {
                aVar.f57292i = true;
            }
            aVar.f57288e = iMax;
            aVar.f57289f = measuredHeight;
            aVar.f57291h = z20;
            aVar.f57290g = baseline;
            ConstraintLayout.access$000(ConstraintLayout.this);
        }

        /* renamed from: c */
        public void m3573c(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f3028b = i12;
            this.f3029c = i13;
            this.f3030d = i14;
            this.f3031e = i15;
            this.f3032f = i10;
            this.f3033g = i11;
        }

        /* renamed from: d */
        public final boolean m3574d(int i10, int i11, int i12) {
            if (i10 == i11) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i10);
            return View.MeasureSpec.getMode(i11) == 1073741824 && (mode == Integer.MIN_VALUE || mode == 0) && i12 == View.MeasureSpec.getSize(i11);
        }
    }

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$c */
    public interface InterfaceC0582c {
        /* renamed from: a */
        boolean m3575a(int i10, int i11, int i12, View view, LayoutParams layoutParams);
    }

    public ConstraintLayout(Context context) throws XmlPullParserException, IOException, NumberFormatException {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new C12259f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new C0581b(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    public static /* synthetic */ C11575e access$000(ConstraintLayout constraintLayout) {
        constraintLayout.getClass();
        return null;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static C0587e getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new C0587e();
        }
        return sSharedValues;
    }

    private C12258e getTargetWidget(int i10) {
        if (i10 == 0) {
            return this.mLayoutWidget;
        }
        View viewFindViewById = this.mChildrenByIds.get(i10);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i10)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.mLayoutWidget;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((LayoutParams) viewFindViewById.getLayoutParams()).f3019v0;
    }

    private void init(AttributeSet attributeSet, int i10, int i11) throws XmlPullParserException, IOException, NumberFormatException {
        this.mLayoutWidget.m73559G0(this);
        this.mLayoutWidget.m73692b2(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, i10, i11);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i12 = 0; i12 < indexCount; i12++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i12);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = typedArrayObtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R$styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        C0585c c0585c = new C0585c();
                        this.mConstraintSet = c0585c;
                        c0585c.m3621D(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.m73693c2(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            C12258e viewWidget = getViewWidget(getChildAt(i10));
            if (viewWidget != null) {
                viewWidget.mo73654v0();
            }
        }
        if (zIsInEditMode) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).m73561H0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        C0585c c0585c = this.mConstraintSet;
        if (c0585c != null) {
            c0585c.m3633k(this, true);
        }
        this.mLayoutWidget.m73797z1();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                this.mConstraintHelpers.get(i13).m3566u(this);
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt3 = getChildAt(i14);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).m3581c(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt4 = getChildAt(i15);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt5 = getChildAt(i16);
            C12258e viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                this.mLayoutWidget.m73794a(viewWidget2);
                applyConstraintsFromLayoutParams(zIsInEditMode, childAt5, viewWidget2, layoutParams, this.mTempMapIdToWidget);
            }
        }
    }

    private void setWidgetBaseline(C12258e c12258e, LayoutParams layoutParams, SparseArray<C12258e> sparseArray, int i10, C12257d.a aVar) {
        View view = this.mChildrenByIds.get(i10);
        C12258e c12258e2 = sparseArray.get(i10);
        if (c12258e2 == null || view == null || !(view.getLayoutParams() instanceof LayoutParams)) {
            return;
        }
        layoutParams.f2989g0 = true;
        C12257d.a aVar2 = C12257d.a.BASELINE;
        if (aVar == aVar2) {
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            layoutParams2.f2989g0 = true;
            layoutParams2.f3019v0.m73577P0(true);
        }
        c12258e.mo73639q(aVar2).m73525b(c12258e2.mo73639q(aVar), layoutParams.f2953D, layoutParams.f2952C, true);
        c12258e.m73577P0(true);
        c12258e.mo73639q(C12257d.a.TOP).m73540q();
        c12258e.mo73639q(C12257d.a.BOTTOM).m73540q();
    }

    private boolean updateHierarchy() throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            setChildrenConstraints();
        }
        return z10;
    }

    public void addValueModifier(InterfaceC0582c interfaceC0582c) {
        if (this.mModifiers == null) {
            this.mModifiers = new ArrayList<>();
        }
        this.mModifiers.add(interfaceC0582c);
    }

    public void applyConstraintsFromLayoutParams(boolean z10, View view, C12258e c12258e, LayoutParams layoutParams, SparseArray<C12258e> sparseArray) {
        C12258e c12258e2;
        C12258e c12258e3;
        C12258e c12258e4;
        C12258e c12258e5;
        int i10;
        layoutParams.m3570c();
        layoutParams.f3021w0 = false;
        c12258e.m73636o1(view.getVisibility());
        if (layoutParams.f2995j0) {
            c12258e.m73595Y0(true);
            c12258e.m73636o1(8);
        }
        c12258e.m73559G0(view);
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper) view).mo3233q(c12258e, this.mLayoutWidget.m73687V1());
        }
        if (layoutParams.f2991h0) {
            C12261h c12261h = (C12261h) c12258e;
            int i11 = layoutParams.f3013s0;
            int i12 = layoutParams.f3015t0;
            float f10 = layoutParams.f3017u0;
            if (f10 != -1.0f) {
                c12261h.m73760E1(f10);
                return;
            } else if (i11 != -1) {
                c12261h.m73758C1(i11);
                return;
            } else {
                if (i12 != -1) {
                    c12261h.m73759D1(i12);
                    return;
                }
                return;
            }
        }
        int i13 = layoutParams.f2999l0;
        int i14 = layoutParams.f3001m0;
        int i15 = layoutParams.f3003n0;
        int i16 = layoutParams.f3005o0;
        int i17 = layoutParams.f3007p0;
        int i18 = layoutParams.f3009q0;
        float f11 = layoutParams.f3011r0;
        int i19 = layoutParams.f3006p;
        if (i19 != -1) {
            C12258e c12258e6 = sparseArray.get(i19);
            if (c12258e6 != null) {
                c12258e.m73629m(c12258e6, layoutParams.f3010r, layoutParams.f3008q);
            }
        } else {
            if (i13 != -1) {
                C12258e c12258e7 = sparseArray.get(i13);
                if (c12258e7 != null) {
                    C12257d.a aVar = C12257d.a.LEFT;
                    c12258e.m73613g0(aVar, c12258e7, aVar, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i17);
                }
            } else if (i14 != -1 && (c12258e2 = sparseArray.get(i14)) != null) {
                c12258e.m73613g0(C12257d.a.LEFT, c12258e2, C12257d.a.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i17);
            }
            if (i15 != -1) {
                C12258e c12258e8 = sparseArray.get(i15);
                if (c12258e8 != null) {
                    c12258e.m73613g0(C12257d.a.RIGHT, c12258e8, C12257d.a.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i18);
                }
            } else if (i16 != -1 && (c12258e3 = sparseArray.get(i16)) != null) {
                C12257d.a aVar2 = C12257d.a.RIGHT;
                c12258e.m73613g0(aVar2, c12258e3, aVar2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i18);
            }
            int i20 = layoutParams.f2992i;
            if (i20 != -1) {
                C12258e c12258e9 = sparseArray.get(i20);
                if (c12258e9 != null) {
                    C12257d.a aVar3 = C12257d.a.TOP;
                    c12258e.m73613g0(aVar3, c12258e9, aVar3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.f3022x);
                }
            } else {
                int i21 = layoutParams.f2994j;
                if (i21 != -1 && (c12258e4 = sparseArray.get(i21)) != null) {
                    c12258e.m73613g0(C12257d.a.TOP, c12258e4, C12257d.a.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.f3022x);
                }
            }
            int i22 = layoutParams.f2996k;
            if (i22 != -1) {
                C12258e c12258e10 = sparseArray.get(i22);
                if (c12258e10 != null) {
                    c12258e.m73613g0(C12257d.a.BOTTOM, c12258e10, C12257d.a.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.f3024z);
                }
            } else {
                int i23 = layoutParams.f2998l;
                if (i23 != -1 && (c12258e5 = sparseArray.get(i23)) != null) {
                    C12257d.a aVar4 = C12257d.a.BOTTOM;
                    c12258e.m73613g0(aVar4, c12258e5, aVar4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.f3024z);
                }
            }
            int i24 = layoutParams.f3000m;
            if (i24 != -1) {
                setWidgetBaseline(c12258e, layoutParams, sparseArray, i24, C12257d.a.BASELINE);
            } else {
                int i25 = layoutParams.f3002n;
                if (i25 != -1) {
                    setWidgetBaseline(c12258e, layoutParams, sparseArray, i25, C12257d.a.TOP);
                } else {
                    int i26 = layoutParams.f3004o;
                    if (i26 != -1) {
                        setWidgetBaseline(c12258e, layoutParams, sparseArray, i26, C12257d.a.BOTTOM);
                    }
                }
            }
            if (f11 >= 0.0f) {
                c12258e.m73581R0(f11);
            }
            float f12 = layoutParams.f2957H;
            if (f12 >= 0.0f) {
                c12258e.m73619i1(f12);
            }
        }
        if (z10 && ((i10 = layoutParams.f2973X) != -1 || layoutParams.f2974Y != -1)) {
            c12258e.m73614g1(i10, layoutParams.f2974Y);
        }
        if (layoutParams.f2985e0) {
            c12258e.m73587U0(C12258e.b.FIXED);
            c12258e.m73638p1(((ViewGroup.MarginLayoutParams) layoutParams).width);
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                c12258e.m73587U0(C12258e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
            if (layoutParams.f2977a0) {
                c12258e.m73587U0(C12258e.b.MATCH_CONSTRAINT);
            } else {
                c12258e.m73587U0(C12258e.b.MATCH_PARENT);
            }
            c12258e.mo73639q(C12257d.a.LEFT).f56688g = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            c12258e.mo73639q(C12257d.a.RIGHT).f56688g = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            c12258e.m73587U0(C12258e.b.MATCH_CONSTRAINT);
            c12258e.m73638p1(0);
        }
        if (layoutParams.f2987f0) {
            c12258e.m73628l1(C12258e.b.FIXED);
            c12258e.m73579Q0(((ViewGroup.MarginLayoutParams) layoutParams).height);
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                c12258e.m73628l1(C12258e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
            if (layoutParams.f2979b0) {
                c12258e.m73628l1(C12258e.b.MATCH_CONSTRAINT);
            } else {
                c12258e.m73628l1(C12258e.b.MATCH_PARENT);
            }
            c12258e.mo73639q(C12257d.a.TOP).f56688g = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            c12258e.mo73639q(C12257d.a.BOTTOM).f56688g = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        } else {
            c12258e.m73628l1(C12258e.b.MATCH_CONSTRAINT);
            c12258e.m73579Q0(0);
        }
        c12258e.m73563I0(layoutParams.f2958I);
        c12258e.m73591W0(layoutParams.f2961L);
        c12258e.m73633n1(layoutParams.f2962M);
        c12258e.m73583S0(layoutParams.f2963N);
        c12258e.m73622j1(layoutParams.f2964O);
        c12258e.m73640q1(layoutParams.f2983d0);
        c12258e.m73589V0(layoutParams.f2965P, layoutParams.f2967R, layoutParams.f2969T, layoutParams.f2971V);
        c12258e.m73631m1(layoutParams.f2966Q, layoutParams.f2968S, layoutParams.f2970U, layoutParams.f2972W);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.mConstraintHelpers.get(i10).mo3258t(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i12 = Integer.parseInt(strArrSplit[0]);
                        int i13 = Integer.parseInt(strArrSplit[1]);
                        int i14 = Integer.parseInt(strArrSplit[2]);
                        int i15 = (int) ((i12 / 1080.0f) * width);
                        int i16 = (int) ((i13 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = i15;
                        float f11 = i16;
                        float f12 = i15 + ((int) ((i14 / 1080.0f) * width));
                        canvas.drawLine(f10, f11, f12, f11, paint);
                        float f13 = i16 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f12, f11, f12, f13, paint);
                        canvas.drawLine(f12, f13, f10, f13, paint);
                        canvas.drawLine(f10, f13, f10, f11, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f10, f11, f12, f13, paint);
                        canvas.drawLine(f10, f13, f12, f11, paint);
                    }
                }
            }
        }
    }

    public boolean dynamicUpdateConstraints(int i10, int i11) {
        boolean zM3575a = false;
        if (this.mModifiers == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        Iterator<InterfaceC0582c> it = this.mModifiers.iterator();
        while (it.hasNext()) {
            InterfaceC0582c next = it.next();
            Iterator<C12258e> it2 = this.mLayoutWidget.m73795w1().iterator();
            while (it2.hasNext()) {
                View view = (View) it2.next().m73650u();
                zM3575a |= next.m3575a(size, size2, view.getId(), view, (LayoutParams) view.getLayoutParams());
            }
        }
        return zM3575a;
    }

    public void fillMetrics(C11575e c11575e) {
        this.mLayoutWidget.m73679N1(c11575e);
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i10, Object obj) {
        if (i10 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.mDesignIds;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.m73681P1();
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb2 = new StringBuilder();
        if (this.mLayoutWidget.f56776o == null) {
            int id3 = getId();
            if (id3 != -1) {
                this.mLayoutWidget.f56776o = getContext().getResources().getResourceEntryName(id3);
            } else {
                this.mLayoutWidget.f56776o = "parent";
            }
        }
        if (this.mLayoutWidget.m73653v() == null) {
            C12259f c12259f = this.mLayoutWidget;
            c12259f.m73561H0(c12259f.f56776o);
            Log.v(TAG, " setDebugName " + this.mLayoutWidget.m73653v());
        }
        Iterator<C12258e> it = this.mLayoutWidget.m73795w1().iterator();
        while (it.hasNext()) {
            C12258e next = it.next();
            View view = (View) next.m73650u();
            if (view != null) {
                if (next.f56776o == null && (id2 = view.getId()) != -1) {
                    next.f56776o = getContext().getResources().getResourceEntryName(id2);
                }
                if (next.m73653v() == null) {
                    next.m73561H0(next.f56776o);
                    Log.v(TAG, " setDebugName " + next.m73653v());
                }
            }
        }
        this.mLayoutWidget.mo73578Q(sb2);
        return sb2.toString();
    }

    public View getViewById(int i10) {
        return this.mChildrenByIds.get(i10);
    }

    public final C12258e getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f3019v0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f3019v0;
        }
        return null;
    }

    public boolean isRtl() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public void loadLayoutDescription(int i10) {
        if (i10 == 0) {
            this.mConstraintLayoutSpec = null;
            return;
        }
        try {
            this.mConstraintLayoutSpec = new C0584b(getContext(), this, i10);
        } catch (Resources.NotFoundException unused) {
            this.mConstraintLayoutSpec = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            C12258e c12258e = layoutParams.f3019v0;
            if ((childAt.getVisibility() != 8 || layoutParams.f2991h0 || layoutParams.f2993i0 || layoutParams.f2997k0 || zIsInEditMode) && !layoutParams.f2995j0) {
                int iM73596Z = c12258e.m73596Z();
                int iM73598a0 = c12258e.m73598a0();
                int iM73594Y = c12258e.m73594Y() + iM73596Z;
                int iM73662z = c12258e.m73662z() + iM73598a0;
                childAt.layout(iM73596Z, iM73598a0, iM73594Y, iM73662z);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iM73596Z, iM73598a0, iM73594Y, iM73662z);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                this.mConstraintHelpers.get(i15).mo3257r(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        boolean zDynamicUpdateConstraints = this.mDirtyHierarchy | dynamicUpdateConstraints(i10, i11);
        this.mDirtyHierarchy = zDynamicUpdateConstraints;
        if (!zDynamicUpdateConstraints) {
            int childCount = getChildCount();
            int i12 = 0;
            while (true) {
                if (i12 >= childCount) {
                    break;
                }
                if (getChildAt(i12).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
                i12++;
            }
        }
        this.mOnMeasureWidthMeasureSpec = i10;
        this.mOnMeasureHeightMeasureSpec = i11;
        this.mLayoutWidget.m73695e2(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.m73697g2();
            }
        }
        this.mLayoutWidget.m73679N1(null);
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i10, i11);
        resolveMeasuredDimension(i10, i11, this.mLayoutWidget.m73594Y(), this.mLayoutWidget.m73662z(), this.mLayoutWidget.m73688W1(), this.mLayoutWidget.m73686U1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        C12258e viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof C12261h)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            C12261h c12261h = new C12261h();
            layoutParams.f3019v0 = c12261h;
            layoutParams.f2991h0 = true;
            c12261h.m73761F1(layoutParams.f2975Z);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.m3567w();
            ((LayoutParams) view.getLayoutParams()).f2993i0 = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.m73796y1(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int i10) {
        this.mConstraintLayoutSpec = new C0584b(getContext(), this, i10);
    }

    public void removeValueModifier(InterfaceC0582c interfaceC0582c) {
        if (interfaceC0582c == null) {
            return;
        }
        this.mModifiers.remove(interfaceC0582c);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        C0581b c0581b = this.mMeasurer;
        int i14 = c0581b.f3031e;
        int iResolveSizeAndState = View.resolveSizeAndState(i12 + c0581b.f3030d, i10, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i13 + i14, i11, 0) & 16777215;
        int iMin = Math.min(this.mMaxWidth, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState2);
        if (z10) {
            iMin |= 16777216;
        }
        if (z11) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.mLastMeasureWidth = iMin;
        this.mLastMeasureHeight = iMin2;
    }

    public void resolveSystem(C12259f c12259f, int i10, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i13 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.m3573c(i11, i12, iMax, iMax2, paddingWidth, i13);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        if (iMax3 <= 0 && iMax4 <= 0) {
            iMax4 = Math.max(0, getPaddingLeft());
        } else if (!isRtl()) {
            iMax4 = iMax3;
        }
        int i14 = size - paddingWidth;
        int i15 = size2 - i13;
        setSelfDimensionBehaviour(c12259f, mode, i14, mode2, i15);
        c12259f.m73689X1(i10, mode, i14, mode2, i15, this.mLastMeasureWidth, this.mLastMeasureHeight, iMax4, iMax);
    }

    public void setConstraintSet(C0585c c0585c) {
        this.mConstraintSet = c0585c;
    }

    public void setDesignInformation(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.mDesignIds.put(strSubstring, num);
        }
    }

    @Override // android.view.View
    public void setId(int i10) {
        this.mChildrenByIds.remove(getId());
        super.setId(i10);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i10;
        requestLayout();
    }

    public void setMaxWidth(int i10) {
        if (i10 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i10;
        requestLayout();
    }

    public void setMinHeight(int i10) {
        if (i10 == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i10;
        requestLayout();
    }

    public void setMinWidth(int i10) {
        if (i10 == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i10;
        requestLayout();
    }

    public void setOnConstraintsChanged(AbstractC0586d abstractC0586d) {
        C0584b c0584b = this.mConstraintLayoutSpec;
        if (c0584b != null) {
            c0584b.m3597c(abstractC0586d);
        }
    }

    public void setOptimizationLevel(int i10) {
        this.mOptimizationLevel = i10;
        this.mLayoutWidget.m73693c2(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r2
  0x003e: PHI (r2v4 q.e$b) = (r2v3 q.e$b), (r2v0 q.e$b) binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSelfDimensionBehaviour(p561q.C12259f r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$b r0 = r7.mMeasurer
            int r1 = r0.f3031e
            int r0 = r0.f3030d
            q.e$b r2 = p561q.C12258e.b.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 0
            if (r9 == r5) goto L2e
            if (r9 == 0) goto L23
            if (r9 == r4) goto L1a
            r9 = r2
        L18:
            r10 = r6
            goto L38
        L1a:
            int r9 = r7.mMaxWidth
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L38
        L23:
            q.e$b r9 = p561q.C12258e.b.WRAP_CONTENT
            if (r3 != 0) goto L18
            int r10 = r7.mMinWidth
            int r10 = java.lang.Math.max(r6, r10)
            goto L38
        L2e:
            q.e$b r9 = p561q.C12258e.b.WRAP_CONTENT
            if (r3 != 0) goto L38
            int r10 = r7.mMinWidth
            int r10 = java.lang.Math.max(r6, r10)
        L38:
            if (r11 == r5) goto L53
            if (r11 == 0) goto L48
            if (r11 == r4) goto L40
        L3e:
            r12 = r6
            goto L5d
        L40:
            int r11 = r7.mMaxHeight
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L5d
        L48:
            q.e$b r2 = p561q.C12258e.b.WRAP_CONTENT
            if (r3 != 0) goto L3e
            int r11 = r7.mMinHeight
            int r12 = java.lang.Math.max(r6, r11)
            goto L5d
        L53:
            q.e$b r2 = p561q.C12258e.b.WRAP_CONTENT
            if (r3 != 0) goto L5d
            int r11 = r7.mMinHeight
            int r12 = java.lang.Math.max(r6, r11)
        L5d:
            int r11 = r8.m73594Y()
            if (r10 != r11) goto L69
            int r11 = r8.m73662z()
            if (r12 == r11) goto L6c
        L69:
            r8.m73685T1()
        L6c:
            r8.m73643r1(r6)
            r8.m73646s1(r6)
            int r11 = r7.mMaxWidth
            int r11 = r11 - r0
            r8.m73603c1(r11)
            int r11 = r7.mMaxHeight
            int r11 = r11 - r1
            r8.m73601b1(r11)
            r8.m73612f1(r6)
            r8.m73609e1(r6)
            r8.m73587U0(r9)
            r8.m73638p1(r10)
            r8.m73628l1(r2)
            r8.m73579Q0(r12)
            int r9 = r7.mMinWidth
            int r9 = r9 - r0
            r8.m73612f1(r9)
            int r7 = r7.mMinHeight
            int r7 = r7 - r1
            r8.m73609e1(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.setSelfDimensionBehaviour(q.f, int, int, int, int):void");
    }

    public void setState(int i10, int i11, int i12) {
        C0584b c0584b = this.mConstraintLayoutSpec;
        if (c0584b != null) {
            c0584b.m3598d(i10, i11, i12);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new C12259f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new C0581b(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet, i10);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new C12259f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new C0581b(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i10, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10, int i11) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet, i10, i11);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new C12259f();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new C0581b(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i10, i11);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: A */
        public int f2950A;

        /* renamed from: B */
        public int f2951B;

        /* renamed from: C */
        public int f2952C;

        /* renamed from: D */
        public int f2953D;

        /* renamed from: E */
        public boolean f2954E;

        /* renamed from: F */
        public boolean f2955F;

        /* renamed from: G */
        public float f2956G;

        /* renamed from: H */
        public float f2957H;

        /* renamed from: I */
        public String f2958I;

        /* renamed from: J */
        public float f2959J;

        /* renamed from: K */
        public int f2960K;

        /* renamed from: L */
        public float f2961L;

        /* renamed from: M */
        public float f2962M;

        /* renamed from: N */
        public int f2963N;

        /* renamed from: O */
        public int f2964O;

        /* renamed from: P */
        public int f2965P;

        /* renamed from: Q */
        public int f2966Q;

        /* renamed from: R */
        public int f2967R;

        /* renamed from: S */
        public int f2968S;

        /* renamed from: T */
        public int f2969T;

        /* renamed from: U */
        public int f2970U;

        /* renamed from: V */
        public float f2971V;

        /* renamed from: W */
        public float f2972W;

        /* renamed from: X */
        public int f2973X;

        /* renamed from: Y */
        public int f2974Y;

        /* renamed from: Z */
        public int f2975Z;

        /* renamed from: a */
        public int f2976a;

        /* renamed from: a0 */
        public boolean f2977a0;

        /* renamed from: b */
        public int f2978b;

        /* renamed from: b0 */
        public boolean f2979b0;

        /* renamed from: c */
        public float f2980c;

        /* renamed from: c0 */
        public String f2981c0;

        /* renamed from: d */
        public boolean f2982d;

        /* renamed from: d0 */
        public int f2983d0;

        /* renamed from: e */
        public int f2984e;

        /* renamed from: e0 */
        public boolean f2985e0;

        /* renamed from: f */
        public int f2986f;

        /* renamed from: f0 */
        public boolean f2987f0;

        /* renamed from: g */
        public int f2988g;

        /* renamed from: g0 */
        public boolean f2989g0;

        /* renamed from: h */
        public int f2990h;

        /* renamed from: h0 */
        public boolean f2991h0;

        /* renamed from: i */
        public int f2992i;

        /* renamed from: i0 */
        public boolean f2993i0;

        /* renamed from: j */
        public int f2994j;

        /* renamed from: j0 */
        public boolean f2995j0;

        /* renamed from: k */
        public int f2996k;

        /* renamed from: k0 */
        public boolean f2997k0;

        /* renamed from: l */
        public int f2998l;

        /* renamed from: l0 */
        public int f2999l0;

        /* renamed from: m */
        public int f3000m;

        /* renamed from: m0 */
        public int f3001m0;

        /* renamed from: n */
        public int f3002n;

        /* renamed from: n0 */
        public int f3003n0;

        /* renamed from: o */
        public int f3004o;

        /* renamed from: o0 */
        public int f3005o0;

        /* renamed from: p */
        public int f3006p;

        /* renamed from: p0 */
        public int f3007p0;

        /* renamed from: q */
        public int f3008q;

        /* renamed from: q0 */
        public int f3009q0;

        /* renamed from: r */
        public float f3010r;

        /* renamed from: r0 */
        public float f3011r0;

        /* renamed from: s */
        public int f3012s;

        /* renamed from: s0 */
        public int f3013s0;

        /* renamed from: t */
        public int f3014t;

        /* renamed from: t0 */
        public int f3015t0;

        /* renamed from: u */
        public int f3016u;

        /* renamed from: u0 */
        public float f3017u0;

        /* renamed from: v */
        public int f3018v;

        /* renamed from: v0 */
        public C12258e f3019v0;

        /* renamed from: w */
        public int f3020w;

        /* renamed from: w0 */
        public boolean f3021w0;

        /* renamed from: x */
        public int f3022x;

        /* renamed from: y */
        public int f3023y;

        /* renamed from: z */
        public int f3024z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$LayoutParams$a */
        public static class C0579a {

            /* renamed from: a */
            public static final SparseIntArray f3025a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f3025a = sparseIntArray;
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        @SuppressLint({"ClassVerificationFailure"})
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2976a = -1;
            this.f2978b = -1;
            this.f2980c = -1.0f;
            this.f2982d = true;
            this.f2984e = -1;
            this.f2986f = -1;
            this.f2988g = -1;
            this.f2990h = -1;
            this.f2992i = -1;
            this.f2994j = -1;
            this.f2996k = -1;
            this.f2998l = -1;
            this.f3000m = -1;
            this.f3002n = -1;
            this.f3004o = -1;
            this.f3006p = -1;
            this.f3008q = 0;
            this.f3010r = 0.0f;
            this.f3012s = -1;
            this.f3014t = -1;
            this.f3016u = -1;
            this.f3018v = -1;
            this.f3020w = Integer.MIN_VALUE;
            this.f3022x = Integer.MIN_VALUE;
            this.f3023y = Integer.MIN_VALUE;
            this.f3024z = Integer.MIN_VALUE;
            this.f2950A = Integer.MIN_VALUE;
            this.f2951B = Integer.MIN_VALUE;
            this.f2952C = Integer.MIN_VALUE;
            this.f2953D = 0;
            this.f2954E = true;
            this.f2955F = true;
            this.f2956G = 0.5f;
            this.f2957H = 0.5f;
            this.f2958I = null;
            this.f2959J = 0.0f;
            this.f2960K = 1;
            this.f2961L = -1.0f;
            this.f2962M = -1.0f;
            this.f2963N = 0;
            this.f2964O = 0;
            this.f2965P = 0;
            this.f2966Q = 0;
            this.f2967R = 0;
            this.f2968S = 0;
            this.f2969T = 0;
            this.f2970U = 0;
            this.f2971V = 1.0f;
            this.f2972W = 1.0f;
            this.f2973X = -1;
            this.f2974Y = -1;
            this.f2975Z = -1;
            this.f2977a0 = false;
            this.f2979b0 = false;
            this.f2981c0 = null;
            this.f2983d0 = 0;
            this.f2985e0 = true;
            this.f2987f0 = true;
            this.f2989g0 = false;
            this.f2991h0 = false;
            this.f2993i0 = false;
            this.f2995j0 = false;
            this.f2997k0 = false;
            this.f2999l0 = -1;
            this.f3001m0 = -1;
            this.f3003n0 = -1;
            this.f3005o0 = -1;
            this.f3007p0 = Integer.MIN_VALUE;
            this.f3009q0 = Integer.MIN_VALUE;
            this.f3011r0 = 0.5f;
            this.f3019v0 = new C12258e();
            this.f3021w0 = false;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
                ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
                ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
                ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
                setMarginStart(marginLayoutParams.getMarginStart());
                setMarginEnd(marginLayoutParams.getMarginEnd());
            }
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.f2976a = layoutParams2.f2976a;
                this.f2978b = layoutParams2.f2978b;
                this.f2980c = layoutParams2.f2980c;
                this.f2982d = layoutParams2.f2982d;
                this.f2984e = layoutParams2.f2984e;
                this.f2986f = layoutParams2.f2986f;
                this.f2988g = layoutParams2.f2988g;
                this.f2990h = layoutParams2.f2990h;
                this.f2992i = layoutParams2.f2992i;
                this.f2994j = layoutParams2.f2994j;
                this.f2996k = layoutParams2.f2996k;
                this.f2998l = layoutParams2.f2998l;
                this.f3000m = layoutParams2.f3000m;
                this.f3002n = layoutParams2.f3002n;
                this.f3004o = layoutParams2.f3004o;
                this.f3006p = layoutParams2.f3006p;
                this.f3008q = layoutParams2.f3008q;
                this.f3010r = layoutParams2.f3010r;
                this.f3012s = layoutParams2.f3012s;
                this.f3014t = layoutParams2.f3014t;
                this.f3016u = layoutParams2.f3016u;
                this.f3018v = layoutParams2.f3018v;
                this.f3020w = layoutParams2.f3020w;
                this.f3022x = layoutParams2.f3022x;
                this.f3023y = layoutParams2.f3023y;
                this.f3024z = layoutParams2.f3024z;
                this.f2950A = layoutParams2.f2950A;
                this.f2951B = layoutParams2.f2951B;
                this.f2952C = layoutParams2.f2952C;
                this.f2953D = layoutParams2.f2953D;
                this.f2956G = layoutParams2.f2956G;
                this.f2957H = layoutParams2.f2957H;
                this.f2958I = layoutParams2.f2958I;
                this.f2959J = layoutParams2.f2959J;
                this.f2960K = layoutParams2.f2960K;
                this.f2961L = layoutParams2.f2961L;
                this.f2962M = layoutParams2.f2962M;
                this.f2963N = layoutParams2.f2963N;
                this.f2964O = layoutParams2.f2964O;
                this.f2977a0 = layoutParams2.f2977a0;
                this.f2979b0 = layoutParams2.f2979b0;
                this.f2965P = layoutParams2.f2965P;
                this.f2966Q = layoutParams2.f2966Q;
                this.f2967R = layoutParams2.f2967R;
                this.f2969T = layoutParams2.f2969T;
                this.f2968S = layoutParams2.f2968S;
                this.f2970U = layoutParams2.f2970U;
                this.f2971V = layoutParams2.f2971V;
                this.f2972W = layoutParams2.f2972W;
                this.f2973X = layoutParams2.f2973X;
                this.f2974Y = layoutParams2.f2974Y;
                this.f2975Z = layoutParams2.f2975Z;
                this.f2985e0 = layoutParams2.f2985e0;
                this.f2987f0 = layoutParams2.f2987f0;
                this.f2989g0 = layoutParams2.f2989g0;
                this.f2991h0 = layoutParams2.f2991h0;
                this.f2999l0 = layoutParams2.f2999l0;
                this.f3001m0 = layoutParams2.f3001m0;
                this.f3003n0 = layoutParams2.f3003n0;
                this.f3005o0 = layoutParams2.f3005o0;
                this.f3007p0 = layoutParams2.f3007p0;
                this.f3009q0 = layoutParams2.f3009q0;
                this.f3011r0 = layoutParams2.f3011r0;
                this.f2981c0 = layoutParams2.f2981c0;
                this.f2983d0 = layoutParams2.f2983d0;
                this.f3019v0 = layoutParams2.f3019v0;
                this.f2954E = layoutParams2.f2954E;
                this.f2955F = layoutParams2.f2955F;
            }
        }

        /* renamed from: a */
        public String m3568a() {
            return this.f2981c0;
        }

        /* renamed from: b */
        public C12258e m3569b() {
            return this.f3019v0;
        }

        /* renamed from: c */
        public void m3570c() {
            this.f2991h0 = false;
            this.f2985e0 = true;
            this.f2987f0 = true;
            int i10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i10 == -2 && this.f2977a0) {
                this.f2985e0 = false;
                if (this.f2965P == 0) {
                    this.f2965P = 1;
                }
            }
            int i11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i11 == -2 && this.f2979b0) {
                this.f2987f0 = false;
                if (this.f2966Q == 0) {
                    this.f2966Q = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f2985e0 = false;
                if (i10 == 0 && this.f2965P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f2977a0 = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f2987f0 = false;
                if (i11 == 0 && this.f2966Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f2979b0 = true;
                }
            }
            if (this.f2980c == -1.0f && this.f2976a == -1 && this.f2978b == -1) {
                return;
            }
            this.f2991h0 = true;
            this.f2985e0 = true;
            this.f2987f0 = true;
            if (!(this.f3019v0 instanceof C12261h)) {
                this.f3019v0 = new C12261h();
            }
            ((C12261h) this.f3019v0).m73761F1(this.f2975Z);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 259
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public LayoutParams(Context context, AttributeSet attributeSet) throws NumberFormatException {
            super(context, attributeSet);
            this.f2976a = -1;
            this.f2978b = -1;
            this.f2980c = -1.0f;
            this.f2982d = true;
            this.f2984e = -1;
            this.f2986f = -1;
            this.f2988g = -1;
            this.f2990h = -1;
            this.f2992i = -1;
            this.f2994j = -1;
            this.f2996k = -1;
            this.f2998l = -1;
            this.f3000m = -1;
            this.f3002n = -1;
            this.f3004o = -1;
            this.f3006p = -1;
            this.f3008q = 0;
            this.f3010r = 0.0f;
            this.f3012s = -1;
            this.f3014t = -1;
            this.f3016u = -1;
            this.f3018v = -1;
            this.f3020w = Integer.MIN_VALUE;
            this.f3022x = Integer.MIN_VALUE;
            this.f3023y = Integer.MIN_VALUE;
            this.f3024z = Integer.MIN_VALUE;
            this.f2950A = Integer.MIN_VALUE;
            this.f2951B = Integer.MIN_VALUE;
            this.f2952C = Integer.MIN_VALUE;
            this.f2953D = 0;
            this.f2954E = true;
            this.f2955F = true;
            this.f2956G = 0.5f;
            this.f2957H = 0.5f;
            this.f2958I = null;
            this.f2959J = 0.0f;
            this.f2960K = 1;
            this.f2961L = -1.0f;
            this.f2962M = -1.0f;
            this.f2963N = 0;
            this.f2964O = 0;
            this.f2965P = 0;
            this.f2966Q = 0;
            this.f2967R = 0;
            this.f2968S = 0;
            this.f2969T = 0;
            this.f2970U = 0;
            this.f2971V = 1.0f;
            this.f2972W = 1.0f;
            this.f2973X = -1;
            this.f2974Y = -1;
            this.f2975Z = -1;
            this.f2977a0 = false;
            this.f2979b0 = false;
            this.f2981c0 = null;
            this.f2983d0 = 0;
            this.f2985e0 = true;
            this.f2987f0 = true;
            this.f2989g0 = false;
            this.f2991h0 = false;
            this.f2993i0 = false;
            this.f2995j0 = false;
            this.f2997k0 = false;
            this.f2999l0 = -1;
            this.f3001m0 = -1;
            this.f3003n0 = -1;
            this.f3005o0 = -1;
            this.f3007p0 = Integer.MIN_VALUE;
            this.f3009q0 = Integer.MIN_VALUE;
            this.f3011r0 = 0.5f;
            this.f3019v0 = new C12258e();
            this.f3021w0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = C0579a.f3025a.get(index);
                switch (i11) {
                    case 1:
                        this.f2975Z = typedArrayObtainStyledAttributes.getInt(index, this.f2975Z);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f3006p);
                        this.f3006p = resourceId;
                        if (resourceId == -1) {
                            this.f3006p = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f3008q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3008q);
                        break;
                    case 4:
                        float f10 = typedArrayObtainStyledAttributes.getFloat(index, this.f3010r) % 360.0f;
                        this.f3010r = f10;
                        if (f10 < 0.0f) {
                            this.f3010r = (360.0f - f10) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f2976a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2976a);
                        break;
                    case 6:
                        this.f2978b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2978b);
                        break;
                    case 7:
                        this.f2980c = typedArrayObtainStyledAttributes.getFloat(index, this.f2980c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2984e);
                        this.f2984e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f2984e = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2986f);
                        this.f2986f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f2986f = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2988g);
                        this.f2988g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f2988g = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2990h);
                        this.f2990h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f2990h = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2992i);
                        this.f2992i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f2992i = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2994j);
                        this.f2994j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f2994j = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2996k);
                        this.f2996k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f2996k = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2998l);
                        this.f2998l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f2998l = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3000m);
                        this.f3000m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f3000m = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3012s);
                        this.f3012s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f3012s = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3014t);
                        this.f3014t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f3014t = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3016u);
                        this.f3016u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f3016u = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3018v);
                        this.f3018v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f3018v = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f3020w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3020w);
                        break;
                    case 22:
                        this.f3022x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3022x);
                        break;
                    case 23:
                        this.f3023y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3023y);
                        break;
                    case 24:
                        this.f3024z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3024z);
                        break;
                    case 25:
                        this.f2950A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2950A);
                        break;
                    case 26:
                        this.f2951B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2951B);
                        break;
                    case 27:
                        this.f2977a0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f2977a0);
                        break;
                    case 28:
                        this.f2979b0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f2979b0);
                        break;
                    case 29:
                        this.f2956G = typedArrayObtainStyledAttributes.getFloat(index, this.f2956G);
                        break;
                    case 30:
                        this.f2957H = typedArrayObtainStyledAttributes.getFloat(index, this.f2957H);
                        break;
                    case 31:
                        int i12 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f2965P = i12;
                        if (i12 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i13 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f2966Q = i13;
                        if (i13 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.f2967R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2967R);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2967R) == -2) {
                                this.f2967R = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.f2969T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2969T);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2969T) == -2) {
                                this.f2969T = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.f2971V = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f2971V));
                        this.f2965P = 2;
                        break;
                    case 36:
                        try {
                            this.f2968S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2968S);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2968S) == -2) {
                                this.f2968S = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.f2970U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2970U);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2970U) == -2) {
                                this.f2970U = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.f2972W = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f2972W));
                        this.f2966Q = 2;
                        break;
                    default:
                        switch (i11) {
                            case 44:
                                C0585c.m3605I(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.f2961L = typedArrayObtainStyledAttributes.getFloat(index, this.f2961L);
                                break;
                            case 46:
                                this.f2962M = typedArrayObtainStyledAttributes.getFloat(index, this.f2962M);
                                break;
                            case 47:
                                this.f2963N = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.f2964O = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.f2973X = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2973X);
                                break;
                            case 50:
                                this.f2974Y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2974Y);
                                break;
                            case 51:
                                this.f2981c0 = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3002n);
                                this.f3002n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f3002n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.f3004o);
                                this.f3004o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f3004o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                this.f2953D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2953D);
                                break;
                            case 55:
                                this.f2952C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2952C);
                                break;
                            default:
                                switch (i11) {
                                    case 64:
                                        C0585c.m3603G(this, typedArrayObtainStyledAttributes, index, 0);
                                        this.f2954E = true;
                                        break;
                                    case 65:
                                        C0585c.m3603G(this, typedArrayObtainStyledAttributes, index, 1);
                                        this.f2955F = true;
                                        break;
                                    case 66:
                                        this.f2983d0 = typedArrayObtainStyledAttributes.getInt(index, this.f2983d0);
                                        break;
                                    case 67:
                                        this.f2982d = typedArrayObtainStyledAttributes.getBoolean(index, this.f2982d);
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            m3570c();
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f2976a = -1;
            this.f2978b = -1;
            this.f2980c = -1.0f;
            this.f2982d = true;
            this.f2984e = -1;
            this.f2986f = -1;
            this.f2988g = -1;
            this.f2990h = -1;
            this.f2992i = -1;
            this.f2994j = -1;
            this.f2996k = -1;
            this.f2998l = -1;
            this.f3000m = -1;
            this.f3002n = -1;
            this.f3004o = -1;
            this.f3006p = -1;
            this.f3008q = 0;
            this.f3010r = 0.0f;
            this.f3012s = -1;
            this.f3014t = -1;
            this.f3016u = -1;
            this.f3018v = -1;
            this.f3020w = Integer.MIN_VALUE;
            this.f3022x = Integer.MIN_VALUE;
            this.f3023y = Integer.MIN_VALUE;
            this.f3024z = Integer.MIN_VALUE;
            this.f2950A = Integer.MIN_VALUE;
            this.f2951B = Integer.MIN_VALUE;
            this.f2952C = Integer.MIN_VALUE;
            this.f2953D = 0;
            this.f2954E = true;
            this.f2955F = true;
            this.f2956G = 0.5f;
            this.f2957H = 0.5f;
            this.f2958I = null;
            this.f2959J = 0.0f;
            this.f2960K = 1;
            this.f2961L = -1.0f;
            this.f2962M = -1.0f;
            this.f2963N = 0;
            this.f2964O = 0;
            this.f2965P = 0;
            this.f2966Q = 0;
            this.f2967R = 0;
            this.f2968S = 0;
            this.f2969T = 0;
            this.f2970U = 0;
            this.f2971V = 1.0f;
            this.f2972W = 1.0f;
            this.f2973X = -1;
            this.f2974Y = -1;
            this.f2975Z = -1;
            this.f2977a0 = false;
            this.f2979b0 = false;
            this.f2981c0 = null;
            this.f2983d0 = 0;
            this.f2985e0 = true;
            this.f2987f0 = true;
            this.f2989g0 = false;
            this.f2991h0 = false;
            this.f2993i0 = false;
            this.f2995j0 = false;
            this.f2997k0 = false;
            this.f2999l0 = -1;
            this.f3001m0 = -1;
            this.f3003n0 = -1;
            this.f3005o0 = -1;
            this.f3007p0 = Integer.MIN_VALUE;
            this.f3009q0 = Integer.MIN_VALUE;
            this.f3011r0 = 0.5f;
            this.f3019v0 = new C12258e();
            this.f3021w0 = false;
        }
    }
}
