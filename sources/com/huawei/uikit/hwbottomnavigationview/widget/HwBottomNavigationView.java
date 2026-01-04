package com.huawei.uikit.hwbottomnavigationview.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.network.embedded.C5914f2;
import com.huawei.uikit.hwbottomnavigationview.C8702R;
import com.huawei.uikit.hwbottomnavigationview.widget.utils.HwDeviceUtils;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import com.huawei.uikit.hweffect.engine.HwBlurEngine;
import com.huawei.uikit.hweffect.engine.HwBlurable;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import com.huawei.uikit.hwunifiedinteract.widget.HwKeyEventDetector;
import com.huawei.uikit.hwwidgetsafeinsets.widget.HwWidgetSafeInsets;
import huawei.android.widget.ScrollCallback;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class HwBottomNavigationView extends LinearLayout implements HwBlurable {

    /* renamed from: O */
    private static final String f41452O = "HwBottomNavigationView";

    /* renamed from: P */
    private static final int f41453P = 7;

    /* renamed from: Q */
    private static final int f41454Q = 5;

    /* renamed from: R */
    private static final int f41455R = -16777216;

    /* renamed from: S */
    private static final int f41456S = 4;

    /* renamed from: T */
    private static final int f41457T = 678391;

    /* renamed from: U */
    private static final int f41458U = 855638016;

    /* renamed from: V */
    private static final int f41459V = 678391;

    /* renamed from: W */
    private static final int f41460W = -1728053248;

    /* renamed from: a0 */
    private static final int f41461a0 = -452984832;

    /* renamed from: b0 */
    private static final int f41462b0 = 16394797;

    /* renamed from: c0 */
    private static final int f41463c0 = 2;

    /* renamed from: d0 */
    private static final int f41464d0 = 2;

    /* renamed from: e0 */
    private static final int f41465e0 = 2;

    /* renamed from: f0 */
    private static final int f41466f0 = 3;

    /* renamed from: g0 */
    private static final float f41467g0 = 5.0f;

    /* renamed from: h0 */
    private static final int f41468h0 = -1;

    /* renamed from: A */
    private int f41469A;

    /* renamed from: B */
    private int f41470B;

    /* renamed from: C */
    private int f41471C;

    /* renamed from: D */
    private int f41472D;

    /* renamed from: E */
    private String f41473E;

    /* renamed from: F */
    private HwKeyEventDetector f41474F;

    /* renamed from: G */
    private HwKeyEventDetector.OnGlobalNextTabEventListener f41475G;

    /* renamed from: H */
    private HwKeyEventDetector.OnNextTabEventListener f41476H;

    /* renamed from: I */
    private GestureDetector f41477I;

    /* renamed from: J */
    private BottomNavigationItemView f41478J;

    /* renamed from: K */
    private int f41479K;

    /* renamed from: L */
    private boolean f41480L;

    /* renamed from: M */
    private boolean f41481M;

    /* renamed from: N */
    private boolean f41482N;

    /* renamed from: a */
    private final Rect f41483a;

    /* renamed from: b */
    private int f41484b;

    /* renamed from: c */
    private int f41485c;

    /* renamed from: d */
    private MenuInflater f41486d;

    /* renamed from: e */
    private akxao f41487e;

    /* renamed from: f */
    private avpbg f41488f;

    /* renamed from: g */
    private int f41489g;

    /* renamed from: h */
    private int f41490h;

    /* renamed from: i */
    private int f41491i;

    /* renamed from: j */
    private boolean f41492j;

    /* renamed from: k */
    private boolean f41493k;

    /* renamed from: l */
    private boolean f41494l;

    /* renamed from: m */
    private boolean f41495m;
    protected int mActiveColor;
    protected Context mContext;
    protected int mDefaultColor;
    protected OnItemDoubleTapListener mDoubleTapListener;
    protected int mIconFocusActiveColor;
    protected int mIconFocusDefaultColor;
    protected BottomNavListener mListener;
    protected MeasureSize mMeasureSize;
    protected Menu mMenu;
    protected int mMenuSize;
    protected int mMessageBgColor;
    protected Resources mResources;
    protected int mTitleActiveColor;
    protected int mTitleDefaultColor;

    /* renamed from: n */
    private int f41496n;

    /* renamed from: o */
    private int f41497o;

    /* renamed from: p */
    private int f41498p;

    /* renamed from: q */
    private int f41499q;

    /* renamed from: r */
    private int f41500r;

    /* renamed from: s */
    private float f41501s;

    /* renamed from: t */
    private HwBlurEngine f41502t;

    /* renamed from: u */
    private boolean f41503u;

    /* renamed from: v */
    private boolean f41504v;

    /* renamed from: w */
    private Drawable f41505w;

    /* renamed from: x */
    private HwWidgetSafeInsets f41506x;

    /* renamed from: y */
    private HwColumnSystem f41507y;

    /* renamed from: z */
    private boolean f41508z;

    public interface BottomNavListener {
        void onBottomNavItemReselected(MenuItem menuItem, int i10);

        void onBottomNavItemSelected(MenuItem menuItem, int i10);

        void onBottomNavItemUnselected(MenuItem menuItem, int i10);
    }

    public class MeasureSize {

        /* renamed from: a */
        private int f41539a;

        /* renamed from: b */
        private int f41540b;

        public MeasureSize() {
        }

        public int getHeight() {
            return this.f41540b;
        }

        public int getWidth() {
            return this.f41539a;
        }

        public void init() {
            this.f41539a = 0;
            this.f41540b = 0;
        }

        public void setHeight(int i10) {
            this.f41540b = i10;
        }

        public void setWidth(int i10) {
            this.f41539a = i10;
        }
    }

    public interface OnItemDoubleTapListener {
        void onDoubleTaped(MenuItem menuItem, int i10);
    }

    public class aauaf implements HwKeyEventDetector.OnNextTabEventListener {
        public aauaf() {
        }

        @Override // com.huawei.uikit.hwunifiedinteract.widget.HwKeyEventDetector.OnNextTabEventListener
        public boolean onNextTab(int i10, KeyEvent keyEvent) {
            if (i10 == 1) {
                HwBottomNavigationView.this.m54000a();
            }
            return true;
        }
    }

    public class akxao implements View.OnClickListener {
        private akxao() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof BottomNavigationItemView) {
                BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) view;
                if (!HwBottomNavigationView.this.f41481M) {
                    HwBottomNavigationView.this.m54015a(bottomNavigationItemView, true);
                    return;
                }
                boolean z10 = !bottomNavigationItemView.getIsChecked();
                HwBottomNavigationView hwBottomNavigationView = HwBottomNavigationView.this;
                HwNavigationViewHelper.changeItem(bottomNavigationItemView, true, z10, hwBottomNavigationView.mListener, hwBottomNavigationView.mMenu);
            }
        }

        public /* synthetic */ akxao(HwBottomNavigationView hwBottomNavigationView, bzrwd bzrwdVar) {
            this();
        }
    }

    public class avpbg implements View.OnTouchListener {
        private avpbg() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!(view instanceof BottomNavigationItemView)) {
                return false;
            }
            HwBottomNavigationView.this.f41478J = (BottomNavigationItemView) view;
            return HwBottomNavigationView.this.f41477I.onTouchEvent(motionEvent);
        }

        public /* synthetic */ avpbg(HwBottomNavigationView hwBottomNavigationView, bzrwd bzrwdVar) {
            this();
        }
    }

    public class bqmxo implements HwKeyEventDetector.OnGlobalNextTabEventListener {
        public bqmxo() {
        }

        @Override // com.huawei.uikit.hwunifiedinteract.widget.HwKeyEventDetector.OnGlobalNextTabEventListener
        public boolean onGlobalNextTab(int i10, KeyEvent keyEvent) {
            if (i10 == 1) {
                HwBottomNavigationView.this.m54000a();
            }
            return true;
        }
    }

    public class bzrwd extends GestureDetector.SimpleOnGestureListener {
        public bzrwd() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            HwBottomNavigationView hwBottomNavigationView = HwBottomNavigationView.this;
            if (hwBottomNavigationView.mDoubleTapListener != null && hwBottomNavigationView.f41478J != null) {
                int itemIndex = HwBottomNavigationView.this.f41478J.getItemIndex();
                HwBottomNavigationView hwBottomNavigationView2 = HwBottomNavigationView.this;
                hwBottomNavigationView2.mDoubleTapListener.onDoubleTaped(hwBottomNavigationView2.mMenu.getItem(itemIndex), itemIndex);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return super.onDoubleTapEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    public HwBottomNavigationView(Context context) {
        this(context, null);
    }

    public static HwBottomNavigationView instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwBottomNavigationView.class, HwWidgetInstantiator.getCurrentType(context, 7, 1)), HwBottomNavigationView.class);
        if (objInstantiate instanceof HwBottomNavigationView) {
            return (HwBottomNavigationView) objInstantiate;
        }
        return null;
    }

    private void setNavigationViewClipOnLand(BottomNavigationItemView bottomNavigationItemView) {
        if (!bottomNavigationItemView.isSingleImageMode() && !bottomNavigationItemView.isExtendImageMode()) {
            bottomNavigationItemView.setClipChildren(true);
            bottomNavigationItemView.setClipToPadding(true);
        } else {
            setClipChildren(false);
            setClipToPadding(false);
            bottomNavigationItemView.setClipChildren(false);
            bottomNavigationItemView.setClipToPadding(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        View childAt = getChildAt(this.f41471C);
        if (hasFocus() || this.f41471C < 0 || childAt == null) {
            super.addFocusables(arrayList, i10, i11);
        } else if (childAt.isFocusable()) {
            arrayList.add(childAt);
        } else {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    public boolean addMenu(CharSequence charSequence, Drawable drawable) {
        return m54021a(0, 0, charSequence, drawable, true);
    }

    public void addView(View view, int i10, LinearLayout.LayoutParams layoutParams) {
        if (view instanceof BottomNavigationItemView) {
            super.addView(view, i10, (ViewGroup.LayoutParams) layoutParams);
        } else {
            Log.w(f41452O, "illegal to addView by this method");
        }
    }

    public void configureColumn(int i10, int i11, float f10) {
        if (i10 > 0 && i11 > 0 && f10 > 0.0f) {
            this.f41499q = i10;
            this.f41500r = i11;
            this.f41501s = f10;
            this.f41495m = true;
            this.f41496n = m54024b(this.f41507y, this.mMenu.size());
        } else {
            if (!this.f41495m) {
                return;
            }
            this.f41495m = false;
            this.f41496n = m53996a(this.f41507y, this.mMenu.size());
        }
        if (this.f41493k) {
            requestLayout();
        }
    }

    public HwKeyEventDetector createKeyEventDetector() {
        return new HwKeyEventDetector(this.mContext);
    }

    public void createNewItem(MenuItem menuItem, int i10, boolean z10, AttributeSet attributeSet, int i11) {
        if (menuItem == null) {
            Log.w(f41452O, "createNewItem: Param menuItem is null");
            return;
        }
        BottomNavigationItemView bottomNavigationItemView = new BottomNavigationItemView(this.mContext, menuItem, this.f41494l, i10, z10, attributeSet, i11);
        bottomNavigationItemView.setClickable(true);
        bottomNavigationItemView.setFocusable(true);
        bottomNavigationItemView.setBackgroundResource(this.f41479K);
        bottomNavigationItemView.setActiveColor(this.mActiveColor);
        bottomNavigationItemView.setDefaultColor(this.mDefaultColor);
        bottomNavigationItemView.setTitleActiveColor(this.mTitleActiveColor);
        bottomNavigationItemView.setTitleDefaultColor(this.mTitleDefaultColor);
        bottomNavigationItemView.setMsgBgColor(this.mMessageBgColor);
        bottomNavigationItemView.setOnClickListener(this.f41487e);
        bottomNavigationItemView.setOnTouchListener(this.f41488f);
        addView(bottomNavigationItemView);
    }

    public HwKeyEventDetector.OnGlobalNextTabEventListener createOnGlobalNextTabEventListener() {
        return new bqmxo();
    }

    public HwKeyEventDetector.OnNextTabEventListener createOnNextTabEventListener() {
        return new aauaf();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        m54008a(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.f41502t.isShowHwBlur(this) || this.f41508z) {
            super.draw(canvas);
            return;
        }
        this.f41502t.draw(canvas, this);
        super.dispatchDraw(canvas);
        m54008a(canvas);
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public int getBlurColor() {
        return this.f41484b;
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public int getBlurType() {
        return this.f41485c;
    }

    public int getFocusPathColor() {
        return this.f41470B;
    }

    public boolean getLongClickEnable() {
        return this.f41482N;
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public boolean isBlurEnable() {
        return this.f41503u;
    }

    public boolean isColumnEnabled() {
        return this.f41493k;
    }

    public boolean isDividerEnabled() {
        return this.f41504v;
    }

    public boolean isExtendedNextTabEnabled(boolean z10) {
        HwKeyEventDetector hwKeyEventDetector = this.f41474F;
        if (hwKeyEventDetector == null) {
            return false;
        }
        return z10 ? hwKeyEventDetector.getOnGlobalNextTabListener() != null : hwKeyEventDetector.getOnNextTabListener() != null;
    }

    public boolean isHasMessage(int i10) {
        if (i10 >= this.mMenuSize || !(getChildAt(i10) instanceof BottomNavigationItemView)) {
            return false;
        }
        return ((BottomNavigationItemView) getChildAt(i10)).m54054c();
    }

    public boolean isSpaciousStyle() {
        return this.f41481M;
    }

    public void measureOnPortraitByAverageWidth(int i10, int i11, MeasureSize measureSize) {
        int i12;
        int size = View.MeasureSpec.getSize(i10);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (measureSize == null) {
            Log.w(f41452O, "measureOnPortraitByAverageWidth: Param measureSize is null");
            return;
        }
        if (childCount <= 0) {
            measureSize.setWidth(size);
            measureSize.setHeight(0);
            return;
        }
        if (this.f41493k && (i12 = this.f41496n) > 0 && i12 < paddingLeft) {
            paddingLeft = i12;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int iM53995a = m53995a(childCount, paddingLeft / childCount, ViewGroup.getChildMeasureSpec(i11, paddingTop, -2));
        m54027b(childCount, iM53995a);
        measureSize.setWidth(size);
        measureSize.setHeight(iM53995a + paddingTop);
    }

    public void notifyDotMessage(int i10, boolean z10) {
        if (i10 >= this.mMenuSize || !(getChildAt(i10) instanceof BottomNavigationItemView)) {
            return;
        }
        ((BottomNavigationItemView) getChildAt(i10)).setHasMessage(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void notifyScrollToTop(View view) {
        if (view == 0) {
            Log.w(f41452O, "notifyScrollToTop: Param scollView is null");
        } else if ((view instanceof ScrollCallback) && view.getVisibility() == 0) {
            ((ScrollCallback) view).scrollToTop();
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        this.f41506x.updateWindowInsets(windowInsets);
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f41506x.updateOriginPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        HwKeyEventDetector hwKeyEventDetector = this.f41474F;
        if (hwKeyEventDetector != null) {
            hwKeyEventDetector.setOnNextTabListener(this.f41476H);
            this.f41474F.setOnGlobalNextTabListener(this, this.f41475G);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f41495m) {
            this.f41496n = m54024b(this.f41507y, this.mMenu.size());
        } else {
            this.f41496n = m53996a(this.f41507y, this.mMenu.size());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        HwKeyEventDetector hwKeyEventDetector = this.f41474F;
        if (hwKeyEventDetector != null) {
            hwKeyEventDetector.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        HwKeyEventDetector hwKeyEventDetector = this.f41474F;
        if (hwKeyEventDetector == null || !hwKeyEventDetector.onKeyEvent(i10, keyEvent)) {
            return super.onKeyDown(i10, keyEvent);
        }
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        HwKeyEventDetector hwKeyEventDetector = this.f41474F;
        if (hwKeyEventDetector == null || !hwKeyEventDetector.onKeyEvent(i10, keyEvent)) {
            return super.onKeyUp(i10, keyEvent);
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f41506x.applyDisplaySafeInsets(true);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        this.mMeasureSize.init();
        if (getOrientation() == 1) {
            m54005a(i11, this.mMeasureSize);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mMeasureSize.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mMeasureSize.getHeight(), 1073741824));
            return;
        }
        boolean z10 = this.f41493k;
        int size = View.MeasureSpec.getSize(i10);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (this.f41508z) {
            super.onMeasure(i10, i11);
            return;
        }
        if ((childCount > 3 || this.f41497o > 0) && z10 && (i12 = this.f41498p) > 0 && i12 < paddingLeft) {
            paddingLeft = i12;
        }
        boolean zM54031b = m54031b(paddingLeft);
        if (childCount == 0) {
            setMeasuredDimension(size, 0);
            return;
        }
        this.f41494l = zM54031b;
        m54003a(childCount);
        if (this.f41494l) {
            m54004a(i10, i11, this.mMeasureSize);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mMeasureSize.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mMeasureSize.getHeight(), 1073741824));
        } else {
            m54028b(i10, i11, this.mMeasureSize);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mMeasureSize.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mMeasureSize.getHeight(), 1073741824));
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (this.f41508z) {
            return;
        }
        if (i10 != 0) {
            this.f41502t.removeBlurTargetView(this);
            return;
        }
        this.f41502t.addBlurTargetView(this, this.f41485c);
        this.f41502t.setTargetViewBlurEnable(this, isBlurEnable());
        int i11 = this.f41484b;
        if (i11 != f41455R) {
            this.f41502t.setTargetViewOverlayColor(this, i11);
        }
    }

    public void removeMenuItems() {
        this.f41489g = -1;
        this.mMenu.clear();
        this.mMenuSize = 0;
        removeAllViews();
    }

    public void replaceMenuItem(int i10, Drawable drawable, int i11, boolean z10) throws NoSuchMethodException, SecurityException {
        if (i11 < 0 || i11 >= this.mMenuSize) {
            return;
        }
        MenuItem item = this.mMenu.getItem(i11);
        View childAt = getChildAt(i11);
        if (childAt instanceof BottomNavigationItemView) {
            BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt;
            if (i10 != 0) {
                item.setTitle(i10);
            }
            if (drawable != null) {
                item.setIcon(drawable);
            }
            bottomNavigationItemView.m54051b(item, z10);
        }
    }

    public void replaceMenuItems(int[] iArr, Drawable[] drawableArr, boolean z10) throws NoSuchMethodException, SecurityException {
        if (iArr != null) {
            int length = iArr.length;
            int i10 = this.mMenuSize;
            if (length == i10 && drawableArr != null && drawableArr.length == i10) {
                for (int i11 = 0; i11 < this.mMenuSize; i11++) {
                    replaceMenuItem(iArr[i11], drawableArr[i11], i11, z10);
                }
            }
        }
    }

    public void replaceSingleImage(Drawable drawable, int i10, boolean z10) {
        if (i10 < 0 || i10 >= this.mMenuSize || drawable == null) {
            return;
        }
        MenuItem item = this.mMenu.getItem(i10);
        item.setIcon(drawable);
        if (getChildAt(i10) instanceof BottomNavigationItemView) {
            ((BottomNavigationItemView) getChildAt(i10)).m54053c(item, z10);
        }
    }

    public void setActiveColor(int i10) {
        for (int i11 = 0; i11 < this.mMenuSize; i11++) {
            setItemActiveColor(i10, i11);
        }
    }

    public void setBackgroundResourceId(int i10) {
        this.f41479K = i10;
        for (int i11 = 0; i11 < this.mMenuSize; i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof BottomNavigationItemView) {
                ((BottomNavigationItemView) childAt).setBackgroundResource(i10);
            }
        }
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public void setBlurColor(int i10) {
        this.f41484b = i10;
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public void setBlurEnable(boolean z10) {
        this.f41503u = z10;
        this.f41502t.setTargetViewBlurEnable(this, isBlurEnable());
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public void setBlurType(int i10) {
        this.f41485c = i10;
    }

    public void setBottomNavListener(BottomNavListener bottomNavListener) {
        this.mListener = bottomNavListener;
    }

    public void setColumnEnabled(boolean z10) {
        this.f41493k = z10;
        requestLayout();
    }

    public void setDefaultColor(int i10) {
        for (int i11 = 0; i11 < this.mMenuSize; i11++) {
            setItemDefaultColor(i10, i11);
        }
    }

    public void setDividerEnabled(boolean z10) {
        if (this.f41504v == z10) {
            return;
        }
        this.f41504v = z10;
        requestLayout();
    }

    public void setDoubleTapListener(OnItemDoubleTapListener onItemDoubleTapListener) {
        this.mDoubleTapListener = onItemDoubleTapListener;
    }

    public void setExtendedNextTabEnabled(boolean z10, boolean z11) {
        HwKeyEventDetector hwKeyEventDetector = this.f41474F;
        if (hwKeyEventDetector == null) {
            return;
        }
        if (z10) {
            if (!z11) {
                this.f41475G = null;
                hwKeyEventDetector.setOnGlobalNextTabListener(this, null);
                return;
            } else {
                HwKeyEventDetector.OnGlobalNextTabEventListener onGlobalNextTabEventListenerCreateOnGlobalNextTabEventListener = createOnGlobalNextTabEventListener();
                this.f41475G = onGlobalNextTabEventListenerCreateOnGlobalNextTabEventListener;
                this.f41474F.setOnGlobalNextTabListener(this, onGlobalNextTabEventListenerCreateOnGlobalNextTabEventListener);
                return;
            }
        }
        if (!z11) {
            this.f41476H = null;
            hwKeyEventDetector.setOnNextTabListener(null);
        } else {
            HwKeyEventDetector.OnNextTabEventListener onNextTabEventListenerCreateOnNextTabEventListener = createOnNextTabEventListener();
            this.f41476H = onNextTabEventListenerCreateOnNextTabEventListener;
            this.f41474F.setOnNextTabListener(onNextTabEventListenerCreateOnNextTabEventListener);
        }
    }

    public void setFocusPathColor(int i10) {
        this.f41470B = i10;
    }

    public void setIconFocusActiveColor(int i10) {
    }

    public void setIconFocusDefaultColor(int i10) {
    }

    public void setItemActiveColor(int i10, int i11) {
        if (i11 < 0 || i11 >= this.mMenuSize) {
            return;
        }
        View childAt = getChildAt(i11);
        if (childAt instanceof BottomNavigationItemView) {
            ((BottomNavigationItemView) childAt).setActiveColor(i10);
        }
    }

    public void setItemChecked(int i10) {
        int childCount = getChildCount();
        if (i10 < 0 || i10 >= childCount) {
            return;
        }
        View childAt = getChildAt(i10);
        if (childAt instanceof BottomNavigationItemView) {
            BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt;
            bottomNavigationItemView.setChecked(true, this.f41489g != -1);
            m54015a(bottomNavigationItemView, false);
        }
    }

    public void setItemDefaultColor(int i10, int i11) {
        if (i11 < 0 || i11 >= this.mMenuSize) {
            return;
        }
        View childAt = getChildAt(i11);
        if (childAt instanceof BottomNavigationItemView) {
            ((BottomNavigationItemView) childAt).setDefaultColor(i10);
        }
    }

    public void setItemIconFocusActiveColor(int i10, int i11) {
    }

    public void setItemIconFocusDefaultColor(int i10, int i11) {
    }

    public void setItemTitleActiveColor(int i10, int i11) {
        if (i11 < 0 || i11 >= this.mMenuSize) {
            return;
        }
        View childAt = getChildAt(i11);
        if (childAt instanceof BottomNavigationItemView) {
            ((BottomNavigationItemView) childAt).setTitleActiveColor(i10);
        }
    }

    public void setItemTitleDefaultColor(int i10, int i11) {
        if (i11 < 0 || i11 >= this.mMenuSize) {
            return;
        }
        View childAt = getChildAt(i11);
        if (childAt instanceof BottomNavigationItemView) {
            ((BottomNavigationItemView) childAt).setTitleDefaultColor(i10);
        }
    }

    public void setItemUnchecked(int i10) {
        int childCount = getChildCount();
        if (i10 < 0 || i10 >= childCount) {
            return;
        }
        View childAt = getChildAt(i10);
        if (childAt instanceof BottomNavigationItemView) {
            HwNavigationViewHelper.changeItem((BottomNavigationItemView) childAt, false, false, this.mListener, this.mMenu);
        }
    }

    public void setLongClickEnable(boolean z10) {
        this.f41482N = z10;
    }

    public void setMessageBgColor(int i10) {
        this.mMessageBgColor = i10;
        for (int i11 = 0; i11 < this.mMenuSize; i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof BottomNavigationItemView) {
                ((BottomNavigationItemView) childAt).setMsgBgColor(i10);
            }
        }
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        this.f41506x.updateOriginPadding(i10, i11, i12, i13);
    }

    public void setPortLayout(boolean z10) {
        if (this.f41492j != z10) {
            this.f41492j = z10;
            requestLayout();
        }
    }

    public void setSelectItemEnabled(int i10, boolean z10) {
        if (i10 < 0 || i10 >= this.mMenuSize) {
            return;
        }
        View childAt = getChildAt(i10);
        if (childAt instanceof BottomNavigationItemView) {
            ((BottomNavigationItemView) childAt).setEnabled(z10);
        }
    }

    public void setSpaciousStyle(boolean z10) {
        this.f41481M = z10;
    }

    public void setTitle(int i10, int i11, boolean z10) {
    }

    public void setTitleActiveColor(int i10) {
        for (int i11 = 0; i11 < this.mMenuSize; i11++) {
            setItemTitleActiveColor(i10, i11);
        }
    }

    public void setTitleDefaultColor(int i10) {
        for (int i11 = 0; i11 < this.mMenuSize; i11++) {
            setItemTitleDefaultColor(i10, i11);
        }
    }

    public HwBottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8702R.attr.hwBottomNavigationViewStyle);
    }

    /* renamed from: b */
    private void m54029b(Context context, AttributeSet attributeSet, int i10) {
        this.mContext = context;
        this.mResources = context.getResources();
        m54006a(context, attributeSet);
        if (this.mResources.getInteger(C8702R.integer.emui_device_type) == 2) {
            this.f41508z = true;
        }
        try {
            this.mMenu = (Menu) Class.forName("com.android.internal.view.menu.MenuBuilder").getConstructor(Context.class).newInstance(context);
        } catch (ClassNotFoundException unused) {
            Log.e(f41452O, "HwBottomNavigationView: MenuBuilder ClassNotFoundException failed");
        } catch (IllegalAccessException unused2) {
            Log.e(f41452O, "HwBottomNavigationView: MenuBuilder IllegalAccessException failed");
        } catch (InstantiationException unused3) {
            Log.e(f41452O, "HwBottomNavigationView: MenuBuilder InstantiationException failed");
        } catch (NoSuchMethodException unused4) {
            Log.e(f41452O, "HwBottomNavigationView: MenuBuilder NoSuchMethodException failed");
        } catch (InvocationTargetException unused5) {
            Log.e(f41452O, "HwBottomNavigationView: MenuBuilder InvocationTargetException failed");
        }
        this.f41486d = new MenuInflater(this.mContext);
        m54007a(context, attributeSet, i10);
        this.f41469A = this.mResources.getInteger(C8702R.integer.hwbottomnavigationview_space_thread);
        this.f41472D = this.mResources.getDimensionPixelOffset(C8702R.dimen.hwbottomnavigationview_item_port_width_in_vertical);
        bzrwd bzrwdVar = null;
        this.f41487e = new akxao(this, bzrwdVar);
        this.f41488f = new avpbg(this, bzrwdVar);
        m54025b();
        m54009a(attributeSet, i10);
        this.f41474F = createKeyEventDetector();
        HwNavigationViewHelper.setValueFromPlume(context, this);
        m54033c();
    }

    /* renamed from: c */
    private void m54033c() {
        this.f41477I = new GestureDetector(this.mContext, new bzrwd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public boolean m54037d() {
        return getLayoutDirection() == 1;
    }

    public boolean addMenu(int i10, Drawable drawable) {
        return m54020a(0, 0, i10, drawable, true);
    }

    public void setTitle(int i10, CharSequence charSequence, boolean z10) {
    }

    public HwBottomNavigationView(Context context, AttributeSet attributeSet, int i10) {
        super(m53997a(context, i10), attributeSet, i10);
        this.mMeasureSize = new MeasureSize();
        this.mActiveColor = 678391;
        this.mDefaultColor = f41458U;
        this.mTitleActiveColor = 678391;
        this.mTitleDefaultColor = f41460W;
        this.mIconFocusDefaultColor = -452984832;
        this.mIconFocusActiveColor = -452984832;
        this.mMessageBgColor = f41462b0;
        this.f41483a = new Rect();
        this.f41489g = -1;
        this.f41492j = false;
        this.f41502t = HwBlurEngine.getInstance();
        this.f41503u = false;
        this.f41504v = false;
        this.f41508z = false;
        this.f41469A = 0;
        this.f41471C = 0;
        this.f41474F = null;
        this.f41482N = false;
        m54029b(super.getContext(), attributeSet, i10);
    }

    /* renamed from: c */
    private void m54035c(int i10, int i11, MeasureSize measureSize) {
        int i12;
        int size = View.MeasureSpec.getSize(i10);
        float paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        measureSize.setWidth(size);
        int childCount = getChildCount();
        if (childCount <= 0) {
            measureSize.setWidth(size);
            measureSize.setHeight(0);
            return;
        }
        if (this.f41493k && (i12 = this.f41496n) > 0) {
            float f10 = i12;
            if (f10 < paddingLeft) {
                paddingLeft = f10;
            }
        }
        float f11 = paddingLeft / childCount;
        ArrayList arrayList = new ArrayList(childCount);
        for (int i13 = 0; i13 < childCount; i13++) {
            m54018a(arrayList, i13, f11);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        m54002a(f11, childMeasureSpec, arrayList, measureSize);
        m54026b(f11, childMeasureSpec, arrayList, measureSize);
        m54027b(childCount, measureSize.getHeight());
        measureSize.setHeight(measureSize.getHeight() + paddingTop);
    }

    /* renamed from: d */
    private void m54036d(int i10) {
        int i11;
        if (i10 == 21 || i10 == 22) {
            return;
        }
        if (i10 == 19 && (i11 = this.f41471C) > 0) {
            this.f41471C = i11 - 1;
        } else {
            if (i10 != 20 || this.f41471C >= getChildCount()) {
                return;
            }
            this.f41471C++;
        }
    }

    public boolean addMenu(CharSequence charSequence, Drawable drawable, boolean z10) {
        return m54021a(0, 0, charSequence, drawable, z10);
    }

    public boolean addMenu(int i10, Drawable drawable, boolean z10) {
        return m54020a(0, 0, i10, drawable, z10);
    }

    public void replaceMenuItems(CharSequence[] charSequenceArr, Drawable[] drawableArr, boolean z10) throws NoSuchMethodException, SecurityException {
        if (charSequenceArr != null) {
            int length = charSequenceArr.length;
            int i10 = this.mMenuSize;
            if (length == i10 && drawableArr != null && drawableArr.length == i10) {
                for (int i11 = 0; i11 < this.mMenuSize; i11++) {
                    replaceMenuItem(charSequenceArr[i11], drawableArr[i11], i11, z10);
                }
            }
        }
    }

    /* renamed from: a */
    private static Context m53997a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8702R.style.Theme_Emui_HwBottomNavigationView);
    }

    /* renamed from: a */
    private void m54007a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8702R.styleable.HwBottomNavigationView, i10, C8702R.style.Widget_Emui_HwBottomNavigationView);
        this.mDefaultColor = typedArrayObtainStyledAttributes.getColor(C8702R.styleable.HwBottomNavigationView_hwIconDefaultColor, f41458U);
        this.mActiveColor = typedArrayObtainStyledAttributes.getColor(C8702R.styleable.HwBottomNavigationView_hwIconActiveColor, 678391);
        this.mTitleDefaultColor = typedArrayObtainStyledAttributes.getColor(C8702R.styleable.HwBottomNavigationView_hwTitleDefaultColor, f41460W);
        this.mTitleActiveColor = typedArrayObtainStyledAttributes.getColor(C8702R.styleable.HwBottomNavigationView_hwTitleActiveColor, 678391);
        this.mIconFocusDefaultColor = typedArrayObtainStyledAttributes.getColor(C8702R.styleable.HwBottomNavigationView_hwIconFocusColor, -452984832);
        this.mIconFocusActiveColor = typedArrayObtainStyledAttributes.getColor(C8702R.styleable.HwBottomNavigationView_hwIconFocusActiveColor, -452984832);
        this.mMessageBgColor = typedArrayObtainStyledAttributes.getColor(C8702R.styleable.HwBottomNavigationView_hwMessageBgColor, f41462b0);
        this.f41505w = typedArrayObtainStyledAttributes.getDrawable(C8702R.styleable.HwBottomNavigationView_hwBottomNavDivider);
        this.f41485c = typedArrayObtainStyledAttributes.getInteger(C8702R.styleable.HwBottomNavigationView_hwBottomNavBlurType, 4);
        this.f41484b = typedArrayObtainStyledAttributes.getColor(C8702R.styleable.HwBottomNavigationView_hwBottomNavBlurOverlayColor, f41455R);
        this.f41493k = typedArrayObtainStyledAttributes.getBoolean(C8702R.styleable.HwBottomNavigationView_hwColumnEnabled, false);
        this.f41470B = typedArrayObtainStyledAttributes.getColor(C8702R.styleable.HwBottomNavigationView_hwFocusedPathColor, 0);
        this.f41479K = typedArrayObtainStyledAttributes.getResourceId(C8702R.styleable.HwBottomNavigationView_hwInteractSelector, C8702R.drawable.hwbottomnavigationview_item_background_selector);
        this.f41480L = typedArrayObtainStyledAttributes.getBoolean(C8702R.styleable.HwBottomNavigationView_hwTintEnable, true);
        this.f41481M = typedArrayObtainStyledAttributes.getBoolean(C8702R.styleable.HwBottomNavigationView_hwIsBottomNavSpaciousStyle, false);
        this.f41490h = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8702R.styleable.HwBottomNavigationView_hwTextPadding, this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_item_text_margin));
        this.f41491i = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8702R.styleable.HwBottomNavigationView_hwIconBounds, this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_item_icon_size));
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(C8702R.styleable.HwBottomNavigationView_hwBottomNavMenu, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId > 0) {
            this.f41486d.inflate(resourceId, this.mMenu);
        }
        this.f41473E = this.mResources.getString(C8702R.string.hwbottomnavigationview_access_ability_message_text);
    }

    public class BottomNavigationItemView extends LinearLayout {

        /* renamed from: A */
        private static final int f41509A = 255;

        /* renamed from: B */
        private static final float f41510B = 1.0f;

        /* renamed from: C */
        private static final float f41511C = 0.5f;
        protected static final int INVALID_LAYOUT_TYPE = -1;
        protected static final int LAND_LAYOUT_TYPE = 1;
        protected static final int PORT_LAYOUT_TYPE = 0;

        /* renamed from: a */
        float f41512a;

        /* renamed from: b */
        float f41513b;

        /* renamed from: c */
        boolean f41514c;

        /* renamed from: d */
        private ComplexDrawable f41515d;

        /* renamed from: e */
        private ComplexDrawable f41516e;

        /* renamed from: f */
        private ComplexDrawable f41517f;

        /* renamed from: g */
        private ComplexDrawable f41518g;

        /* renamed from: h */
        private int f41519h;

        /* renamed from: i */
        private int f41520i;

        /* renamed from: j */
        private int f41521j;

        /* renamed from: k */
        private int f41522k;

        /* renamed from: l */
        private int f41523l;

        /* renamed from: m */
        private int f41524m;
        protected int mActiveColor;
        protected LinearLayout mContainer;
        protected HwTextView mContent;
        protected Context mContext;
        protected int mDefaultColor;
        protected boolean mIsChecked;
        protected boolean mIsExtendImage;
        protected boolean mIsSingleImage;
        protected boolean mIsTint;
        protected MenuItem mItem;
        protected int mMinTextSize;
        protected Paint mPaint;
        protected int mPortMinHeight;
        protected int mPortTextSize;
        protected ImageView mSingleImage;
        protected ImageView mStartImage;
        protected int mStepGranularity;
        protected ImageView mTopImage;

        /* renamed from: n */
        private int f41525n;

        /* renamed from: o */
        private int f41526o;

        /* renamed from: p */
        private int f41527p;

        /* renamed from: q */
        private boolean f41528q;

        /* renamed from: r */
        private boolean f41529r;

        /* renamed from: s */
        private int f41530s;

        /* renamed from: t */
        private int f41531t;

        /* renamed from: u */
        private int f41532u;

        /* renamed from: v */
        private int f41533v;

        /* renamed from: w */
        private Drawable f41534w;

        /* renamed from: x */
        private float f41535x;

        /* renamed from: y */
        private int f41536y;

        public class bzrwd implements View.OnLongClickListener {
            public bzrwd() {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                HwBottomNavigationView.this.f41482N = true;
                return true;
            }
        }

        public BottomNavigationItemView(Context context, boolean z10, int i10) {
            super(context);
            this.mIsChecked = false;
            this.mIsTint = true;
            this.f41519h = -1;
            this.mContext = context;
            if (z10) {
                this.f41519h = 1;
            } else {
                this.f41519h = 0;
            }
            this.f41521j = i10;
        }

        /* renamed from: a */
        private void m54045a(Context context, AttributeSet attributeSet, int i10) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8702R.styleable.HwBottomNavigationView, i10, C8702R.style.Widget_Emui_HwBottomNavigationView);
            View.inflate(context, typedArrayObtainStyledAttributes.getResourceId(C8702R.styleable.HwBottomNavigationView_hwBottomNavItemLayout, C8702R.layout.hwbottomnavigationview_item_layout), this);
            this.f41536y = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8702R.styleable.HwBottomNavigationView_hwItemIconBounds, 0);
            this.mPortMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8702R.styleable.HwBottomNavigationView_hwPortMinHeight, HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_item_port_minheight));
            this.mMinTextSize = typedArrayObtainStyledAttributes.getInteger(C8702R.styleable.HwBottomNavigationView_hwMinTextSize, HwBottomNavigationView.this.mResources.getInteger(C8702R.integer.hwbottomnavigationview_item_min_textsize));
            this.f41524m = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8702R.styleable.HwBottomNavigationView_hwVerticalPadding, HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_item_vertical_padding));
            this.f41525n = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8702R.styleable.HwBottomNavigationView_hwHorizontalPadding, HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_item_horizontal_padding));
            this.f41526o = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8702R.styleable.HwBottomNavigationView_hwVerticalAddedPadding, HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_item_vertical_add_padding));
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: d */
        private void m54047d() {
            if ((HwDeviceUtils.isFoldable() && !HwDeviceUtils.isDualDisplayFoldDevice() && HwDeviceUtils.isWideScreenPhone(getContext())) || HwDeviceUtils.isTablet() || HwDeviceUtils.isTripleFoldDevice()) {
                setMinimumHeight(this.mPortMinHeight);
            } else {
                setMinimumHeight(this.f41522k);
            }
        }

        /* renamed from: e */
        private void m54048e() {
            int extendImageSize = getExtendImageSize();
            if (this.f41519h != 1) {
                setMinimumHeight(this.mPortMinHeight);
                setPadding(HwBottomNavigationView.this.f41490h, 0, HwBottomNavigationView.this.f41490h, 0);
                LinearLayout.LayoutParams layoutParamsM54043a = m54043a(this.mTopImage);
                layoutParamsM54043a.setMargins(0, HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_single_icon_extend_top_margin), 0, 0);
                this.mTopImage.setLayoutParams(layoutParamsM54043a);
                this.f41518g.m53992a(extendImageSize);
                this.f41518g.setState(this.mIsChecked, false);
                return;
            }
            m54047d();
            int i10 = this.f41525n;
            setPadding(i10, 0, i10, 0);
            if (HwBottomNavigationView.this.getOrientation() == 0) {
                LinearLayout.LayoutParams layoutParamsM54043a2 = m54043a(this.mStartImage);
                layoutParamsM54043a2.gravity = 48;
                layoutParamsM54043a2.setMargins(0, HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_single_icon_extend_top_margin), HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_item_start_magin), 0);
                this.mStartImage.setLayoutParams(layoutParamsM54043a2);
            } else {
                this.mTopImage.setLayoutParams(m54043a(this.mTopImage));
            }
            this.f41517f.m53992a(extendImageSize);
            this.f41517f.setState(this.mIsChecked, false);
        }

        /* renamed from: f */
        private void m54049f() {
            if (this.f41519h == 1) {
                m54047d();
                if (this.f41529r) {
                    int i10 = this.f41525n;
                    setPadding(i10, 0, i10, 0);
                } else {
                    int i11 = this.f41525n;
                    int i12 = this.f41524m;
                    setPadding(i11, i12, i11, i12);
                }
            } else {
                setMinimumHeight(this.mPortMinHeight);
                if (this.f41529r) {
                    setPadding(HwBottomNavigationView.this.f41490h, 0, HwBottomNavigationView.this.f41490h, 0);
                } else {
                    setPadding(HwBottomNavigationView.this.f41490h, this.f41524m, HwBottomNavigationView.this.f41490h, this.f41524m);
                }
            }
            int singleImageSize = getSingleImageSize();
            ViewGroup.LayoutParams layoutParams = this.mSingleImage.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.width = singleImageSize;
                layoutParams2.height = singleImageSize;
                if (this.f41529r) {
                    layoutParams2.setMargins(0, HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_single_icon_extend_top_margin), 0, 0);
                }
                this.mSingleImage.setLayoutParams(layoutParams2);
                this.f41515d.m53992a(singleImageSize);
                this.f41515d.setState(this.mIsChecked, false);
            }
        }

        private int getExtendImageSize() {
            return HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_start_icon_extend_size_port);
        }

        private int getSingleImageSize() {
            int i10 = this.f41519h;
            return (i10 == 1 || this.f41529r) ? (i10 == 1 || !this.f41529r) ? (i10 != 1 || this.f41529r) ? this.f41533v : this.f41532u : this.f41531t : this.f41530s;
        }

        /* renamed from: b */
        public void m54051b(MenuItem menuItem, boolean z10) throws NoSuchMethodException, SecurityException {
            this.mIsSingleImage = false;
            this.mIsTint = z10;
            this.mSingleImage.setVisibility(8);
            this.mContainer.setVisibility(0);
            if (this.f41519h == 0) {
                this.mTopImage.setVisibility(0);
            }
            this.mItem = menuItem;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = 48;
                setLayoutParams(layoutParams2);
            }
            this.f41517f.setSrcDrawable(this.mItem.getIcon());
            this.f41518g.setSrcDrawable(this.mItem.getIcon());
            m54046a(true, true);
        }

        /* renamed from: c */
        public void m54053c(MenuItem menuItem, boolean z10) {
            this.mIsSingleImage = true;
            this.f41529r = z10;
            this.mContainer.setVisibility(8);
            this.mTopImage.setVisibility(8);
            this.mSingleImage.setVisibility(0);
            setGravity(1);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                if (z10) {
                    layoutParams2.gravity = 48;
                } else {
                    layoutParams2.gravity = 16;
                }
                setLayoutParams(layoutParams2);
            }
            this.mItem = menuItem;
            ComplexDrawable complexDrawable = new ComplexDrawable(this.mContext, menuItem.getIcon(), getSingleImageSize());
            this.f41515d = complexDrawable;
            this.mSingleImage.setImageDrawable(complexDrawable);
            this.f41534w = menuItem.getIcon();
            m54049f();
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            if (canvas == null) {
                Log.w(HwBottomNavigationView.f41452O, "dispatchDraw: Param canvas is null");
                return;
            }
            super.dispatchDraw(canvas);
            if (!this.f41528q || this.mIsSingleImage) {
                return;
            }
            ImageView icon = getIcon();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            getGlobalVisibleRect(rect);
            icon.getGlobalVisibleRect(rect2);
            int i10 = HwBottomNavigationView.this.m54037d() ? (rect2.left - rect.left) + this.f41527p : (rect2.right - rect.left) - this.f41527p;
            int i11 = rect2.top - rect.top;
            canvas.drawCircle(i10, i11 + r1, this.f41527p, this.mPaint);
        }

        public LinearLayout getContainer() {
            return this.mContainer;
        }

        public TextView getContent() {
            return this.mContent;
        }

        public ImageView getIcon() {
            return this.f41519h == 1 ? this.mStartImage : this.mTopImage;
        }

        public boolean getIsChecked() {
            return this.mIsChecked;
        }

        public int getItemIndex() {
            return this.f41521j;
        }

        public Drawable getOriginalDrawable() {
            return this.f41534w;
        }

        public boolean isExtendImageMode() {
            return this.mIsExtendImage;
        }

        public boolean isSingleImageMode() {
            return this.mIsSingleImage;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent == null) {
                return;
            }
            super.onInitializeAccessibilityEvent(accessibilityEvent);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            if (accessibilityNodeInfo == null) {
                return;
            }
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setSelected(this.mIsChecked);
            TextUtils.isEmpty(this.mItem.getTitle());
            if (m54054c()) {
                accessibilityNodeInfo.setHintText(HwBottomNavigationView.this.f41473E);
            }
        }

        @Override // android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            HwBottomNavigationView.this.m54011a(keyEvent, i10);
            if (HwBottomNavigationView.this.onKeyDown(i10, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i10, keyEvent);
        }

        @Override // android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyUp(int i10, KeyEvent keyEvent) {
            if (HwBottomNavigationView.this.onKeyUp(i10, keyEvent)) {
                return true;
            }
            return super.onKeyUp(i10, keyEvent);
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            sendAccessibilityEvent(C5914f2.f26733f);
            return zPerformClick;
        }

        public BottomNavigationItemView setActiveColor(int i10) {
            this.mActiveColor = i10;
            m54046a(false, true);
            return this;
        }

        public void setChecked(boolean z10, boolean z11) {
            if (this.mIsSingleImage) {
                this.mIsChecked = z10;
                this.f41515d.setState(z10, false);
            } else if (z10 != this.mIsChecked) {
                this.mIsChecked = z10;
                ComplexDrawable complexDrawable = this.f41519h == 1 ? this.f41517f : this.f41518g;
                this.f41516e = complexDrawable;
                complexDrawable.setState(z10, z11);
                HwTextView hwTextView = this.mContent;
                boolean z12 = this.mIsChecked;
                HwBottomNavigationView hwBottomNavigationView = HwBottomNavigationView.this;
                hwTextView.setTextColor(z12 ? hwBottomNavigationView.mTitleActiveColor : hwBottomNavigationView.mTitleDefaultColor);
            }
        }

        public BottomNavigationItemView setDefaultColor(int i10) {
            this.mDefaultColor = i10;
            m54046a(false, true);
            return this;
        }

        public void setDirection(int i10) {
            if (i10 == this.f41519h) {
                return;
            }
            this.f41519h = i10;
            if (this.mIsSingleImage) {
                m54049f();
            } else {
                m54046a(true, false);
            }
        }

        @Override // android.view.View
        public void setEnabled(boolean z10) {
            ComplexDrawable complexDrawable = this.f41516e;
            if (complexDrawable != null && this.mContent != null) {
                if (z10) {
                    complexDrawable.setAlpha(255);
                    this.mContent.setAlpha(1.0f);
                } else {
                    complexDrawable.setAlpha((int) ((this.f41535x * 255.0f) + f41511C));
                    this.mContent.setAlpha(this.f41535x);
                }
            }
            super.setFocusable(z10);
            super.setClickable(z10);
        }

        public void setHasMessage(boolean z10) {
            this.f41528q = z10;
            invalidate();
        }

        public BottomNavigationItemView setIconFocusActiveColor(int i10) {
            return this;
        }

        public BottomNavigationItemView setIconFocusDefaultColor(int i10) {
            return this;
        }

        public void setMsgBgColor(int i10) {
            this.f41520i = i10;
            this.mPaint.setColor(i10);
            invalidate();
        }

        public void setOriginalDrawable(Drawable drawable) {
            this.f41534w = drawable;
        }

        public BottomNavigationItemView setTitleActiveColor(int i10) {
            HwBottomNavigationView.this.mTitleActiveColor = i10;
            m54046a(false, true);
            return this;
        }

        public BottomNavigationItemView setTitleDefaultColor(int i10) {
            HwBottomNavigationView.this.mTitleDefaultColor = i10;
            m54046a(false, true);
            return this;
        }

        public BottomNavigationItemView(HwBottomNavigationView hwBottomNavigationView, Context context, MenuItem menuItem, boolean z10, int i10) {
            this(context, menuItem, z10, i10, hwBottomNavigationView.f41480L, null, 0);
        }

        public BottomNavigationItemView(Context context, MenuItem menuItem, boolean z10, int i10, boolean z11, AttributeSet attributeSet, int i11) {
            super(context);
            this.mIsChecked = false;
            this.mIsTint = true;
            this.f41519h = -1;
            this.mContext = context;
            this.mItem = menuItem;
            m54045a(context, attributeSet, i11);
            this.mContent = (HwTextView) findViewById(C8702R.id.content);
            this.mTopImage = (ImageView) findViewById(C8702R.id.top_icon);
            this.mStartImage = (ImageView) findViewById(C8702R.id.start_icon);
            this.mSingleImage = (ImageView) findViewById(C8702R.id.single_icon);
            this.mContainer = (LinearLayout) findViewById(C8702R.id.container);
            this.f41535x = HwBottomNavigationView.this.mResources.getFloat(C8702R.dimen.emui_disabled_alpha);
            this.f41517f = new ComplexDrawable(this.mContext, this.mItem.getIcon());
            this.f41518g = new ComplexDrawable(this.mContext, this.mItem.getIcon(), this.f41536y);
            this.f41534w = this.f41517f.getDefaultDrawable();
            this.f41522k = HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_item_land_minheight);
            this.f41523l = HwBottomNavigationView.this.mResources.getInteger(C8702R.integer.hwbottomnavigationview_item_land_textsize);
            this.mPortTextSize = HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.emui_text_size_caption);
            this.mStepGranularity = HwBottomNavigationView.this.mResources.getInteger(C8702R.integer.hwbottomnavigationview_text_stepgranularity);
            this.f41530s = HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_single_icon_normal_size_port);
            this.f41531t = HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_single_icon_extend_size_port);
            this.f41532u = HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_single_icon_normal_size_land);
            this.f41533v = HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_single_icon_extend_size_land);
            this.f41527p = HwBottomNavigationView.this.mResources.getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_item_red_dot_radius);
            this.mContent.setAutoTextInfo(this.mMinTextSize, this.mStepGranularity, 1);
            if (z10) {
                this.f41519h = 1;
            } else {
                this.f41519h = 0;
            }
            this.f41521j = i10;
            this.mIsTint = z11;
            this.mStartImage.setImageDrawable(this.f41517f);
            this.mTopImage.setImageDrawable(this.f41518g);
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            setOrientation(1);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            m54046a(true, true);
            m54044a();
        }

        /* renamed from: b */
        public boolean m54052b() {
            return this.f41529r;
        }

        /* renamed from: c */
        public boolean m54054c() {
            return this.f41528q;
        }

        /* renamed from: a */
        private void m54044a() {
            if (Float.compare(AuxiliaryHelper.getFontSize(this.mContext), 1.75f) >= 0) {
                setOnLongClickListener(new bzrwd());
            }
        }

        /* renamed from: a */
        private void m54046a(boolean z10, boolean z11) {
            ViewGroup.LayoutParams layoutParams = this.mContent.getLayoutParams();
            if (z10 && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                if (this.f41519h == 1) {
                    setGravity(17);
                    m54047d();
                    int i10 = this.f41525n;
                    setPadding(i10, 0, i10, 0);
                    this.mTopImage.setVisibility(8);
                    this.mStartImage.setVisibility(0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(0, 0, 0, 0);
                    this.mContent.setLayoutParams(marginLayoutParams);
                    this.mContent.setAutoTextSize(1, this.f41523l);
                    this.mContent.setGravity(8388611);
                    this.f41516e = this.f41517f;
                } else {
                    setGravity(0);
                    setMinimumHeight(this.mPortMinHeight);
                    int i11 = this.f41524m;
                    setPadding(0, this.f41526o + i11, 0, i11);
                    this.mTopImage.setVisibility(0);
                    this.mStartImage.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams2.setMargins(HwBottomNavigationView.this.f41490h, 0, HwBottomNavigationView.this.f41490h, 0);
                    this.mContent.setLayoutParams(marginLayoutParams2);
                    this.mContent.setAutoTextSize(0, this.mPortTextSize);
                    this.mContent.setGravity(1);
                    this.f41516e = this.f41518g;
                }
                this.mContent.setText(this.mItem.getTitle());
                this.f41516e.setState(this.mIsChecked, false);
            }
            if (z11) {
                if (this.mIsTint) {
                    this.f41517f.setActiveColor(this.mActiveColor);
                    this.f41517f.setDefaultColor(this.mDefaultColor);
                    this.f41518g.setActiveColor(this.mActiveColor);
                    this.f41518g.setDefaultColor(this.mDefaultColor);
                }
                HwTextView hwTextView = this.mContent;
                boolean z12 = this.mIsChecked;
                HwBottomNavigationView hwBottomNavigationView = HwBottomNavigationView.this;
                hwTextView.setTextColor(z12 ? hwBottomNavigationView.mTitleActiveColor : hwBottomNavigationView.mTitleDefaultColor);
            }
        }

        /* renamed from: a */
        public void m54050a(MenuItem menuItem, boolean z10) throws NoSuchMethodException, SecurityException {
            this.mIsExtendImage = true;
            m54051b(menuItem, z10);
            m54048e();
        }

        /* renamed from: a */
        private LinearLayout.LayoutParams m54043a(ImageView imageView) {
            int extendImageSize = getExtendImageSize();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imageView.getLayoutParams());
            layoutParams.width = extendImageSize;
            layoutParams.height = extendImageSize;
            return layoutParams;
        }
    }

    public void replaceMenuItem(CharSequence charSequence, Drawable drawable, int i10, boolean z10) throws NoSuchMethodException, SecurityException {
        if (i10 < 0 || i10 >= this.mMenuSize) {
            return;
        }
        MenuItem item = this.mMenu.getItem(i10);
        View childAt = getChildAt(i10);
        if (childAt instanceof BottomNavigationItemView) {
            BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt;
            if (charSequence != null) {
                item.setTitle(charSequence);
            }
            if (drawable != null) {
                item.setIcon(drawable);
            }
            bottomNavigationItemView.m54051b(item, z10);
        }
    }

    public void replaceMenuItem(CharSequence charSequence, Drawable drawable, int i10, boolean z10, boolean z11) throws NoSuchMethodException, SecurityException {
        if (i10 < 0 || i10 >= this.mMenuSize) {
            return;
        }
        MenuItem item = this.mMenu.getItem(i10);
        View childAt = getChildAt(i10);
        if (childAt instanceof BottomNavigationItemView) {
            BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt;
            if (charSequence != null) {
                item.setTitle(charSequence);
            }
            if (drawable != null) {
                item.setIcon(drawable);
            }
            if (z11) {
                bottomNavigationItemView.m54050a(item, z10);
            } else {
                bottomNavigationItemView.m54051b(item, z10);
            }
        }
    }

    /* renamed from: c */
    private void m54034c(int i10) {
        boolean zM54037d = m54037d();
        if (i10 == 21) {
            if (zM54037d) {
                if (this.f41471C < getChildCount()) {
                    this.f41471C++;
                    return;
                }
                return;
            } else {
                int i11 = this.f41471C;
                if (i11 > 0) {
                    this.f41471C = i11 - 1;
                    return;
                }
                return;
            }
        }
        if (i10 == 22) {
            if (zM54037d) {
                int i12 = this.f41471C;
                if (i12 > 0) {
                    this.f41471C = i12 - 1;
                    return;
                }
                return;
            }
            if (this.f41471C < getChildCount()) {
                this.f41471C++;
            }
        }
    }

    /* renamed from: b */
    private void m54025b() {
        int i10;
        HwColumnSystem hwColumnSystem = new HwColumnSystem(this.mContext);
        this.f41507y = hwColumnSystem;
        this.f41495m = false;
        this.f41496n = m53996a(hwColumnSystem, this.mMenu.size());
        if (this.f41508z) {
            this.f41494l = false;
            this.f41493k = false;
        } else if (this.f41493k && (i10 = this.f41498p) > 0) {
            this.f41494l = m54031b(i10);
        } else {
            this.f41494l = m54031b((this.mContext.getResources().getDisplayMetrics().widthPixels - getPaddingLeft()) - getPaddingRight());
        }
    }

    /* renamed from: a */
    private void m54006a(Context context, AttributeSet attributeSet) {
        HwWidgetSafeInsets hwWidgetSafeInsets = new HwWidgetSafeInsets(this);
        this.f41506x = hwWidgetSafeInsets;
        hwWidgetSafeInsets.parseHwDisplayCutout(context, attributeSet);
        this.f41506x.setDealTop(false);
        this.f41506x.setDealRaduis(true);
    }

    /* renamed from: b */
    private boolean m54031b(int i10) {
        return !this.f41492j && ((float) i10) / 5.0f > getResources().getDisplayMetrics().density * ((float) this.f41469A) && ((HwDeviceUtils.isFoldable() && !HwDeviceUtils.isDualDisplayFoldDevice() && HwDeviceUtils.isWideScreenPhone(getContext())) || HwDeviceUtils.isTablet() || HwDeviceUtils.isTripleFoldDevice());
    }

    /* renamed from: a */
    private boolean m54022a(Menu menu) {
        return menu.size() <= 5;
    }

    /* renamed from: a */
    private boolean m54021a(int i10, int i11, CharSequence charSequence, Drawable drawable, boolean z10) {
        MenuItem icon = this.mMenu.add(0, i10, i11, charSequence).setIcon(drawable);
        int size = this.mMenu.size();
        this.mMenuSize = size;
        if (this.f41495m) {
            this.f41496n = m54024b(this.f41507y, size);
        } else {
            this.f41496n = m53996a(this.f41507y, size);
        }
        createNewItem(icon, this.mMenuSize - 1, z10, null, 0);
        return m54022a(this.mMenu);
    }

    /* renamed from: b */
    private int m54024b(HwColumnSystem hwColumnSystem, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        hwColumnSystem.setColumnType(8);
        hwColumnSystem.updateConfigation(this.mContext, this.f41499q, this.f41500r, this.f41501s);
        this.f41497o = hwColumnSystem.getSuggestWidth();
        hwColumnSystem.setColumnType(9);
        hwColumnSystem.updateConfigation(this.mContext, this.f41499q, this.f41500r, this.f41501s);
        int suggestWidth = hwColumnSystem.getSuggestWidth();
        this.f41498p = suggestWidth;
        return i10 > 3 ? suggestWidth : this.f41497o;
    }

    /* renamed from: a */
    private boolean m54020a(int i10, int i11, int i12, Drawable drawable, boolean z10) {
        MenuItem icon = this.mMenu.add(0, 0, 0, i12).setIcon(drawable);
        int size = this.mMenu.size();
        this.mMenuSize = size;
        if (this.f41495m) {
            this.f41496n = m54024b(this.f41507y, size);
        } else {
            this.f41496n = m53996a(this.f41507y, size);
        }
        createNewItem(icon, this.mMenuSize - 1, z10, null, 0);
        return m54022a(this.mMenu);
    }

    /* renamed from: b */
    private void m54027b(int i10, int i11) {
        for (int i12 = 0; i12 < i10; i12++) {
            View childAt = getChildAt(i12);
            if (childAt instanceof BottomNavigationItemView) {
                BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt;
                ViewGroup.LayoutParams layoutParams = bottomNavigationItemView.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.height = i11;
                    bottomNavigationItemView.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m54009a(AttributeSet attributeSet, int i10) {
        this.mMenuSize = this.mMenu.size();
        for (int i11 = 0; i11 < this.mMenuSize; i11++) {
            createNewItem(this.mMenu.getItem(i11), i11, this.f41480L, attributeSet, i10);
        }
    }

    /* renamed from: a */
    private int m53996a(HwColumnSystem hwColumnSystem, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        hwColumnSystem.setColumnType(8);
        hwColumnSystem.updateConfigation(this.mContext);
        this.f41497o = hwColumnSystem.getSuggestWidth();
        hwColumnSystem.setColumnType(9);
        hwColumnSystem.updateConfigation(this.mContext);
        int suggestWidth = hwColumnSystem.getSuggestWidth();
        this.f41498p = suggestWidth;
        return i10 > 3 ? suggestWidth : this.f41497o;
    }

    /* renamed from: b */
    private void m54026b(float f10, int i10, List<Float> list, MeasureSize measureSize) {
        int height = measureSize.getHeight();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof BottomNavigationItemView) {
                BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt;
                if (!bottomNavigationItemView.isSingleImageMode() && !bottomNavigationItemView.isExtendImageMode()) {
                    bottomNavigationItemView.setClipChildren(true);
                    bottomNavigationItemView.setClipToPadding(true);
                } else {
                    bottomNavigationItemView.setClipChildren(false);
                    bottomNavigationItemView.setClipToPadding(false);
                }
                if (bottomNavigationItemView.f41514c) {
                    bottomNavigationItemView.f41514c = false;
                } else {
                    m54001a(f10, i10, bottomNavigationItemView);
                    int measuredHeight = bottomNavigationItemView.getMeasuredHeight();
                    if (measuredHeight > height) {
                        height = measuredHeight;
                    }
                }
            }
        }
        measureSize.setHeight(height);
    }

    /* renamed from: a */
    private void m54004a(int i10, int i11, MeasureSize measureSize) {
        int i12;
        int size = View.MeasureSpec.getSize(i10);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childCount = getChildCount();
        if (childCount <= 0) {
            measureSize.setWidth(size);
            measureSize.setHeight(0);
            return;
        }
        if (this.f41493k && (i12 = this.f41496n) > 0 && i12 < paddingLeft) {
            paddingLeft = i12;
        }
        int i13 = paddingLeft / childCount;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt instanceof BottomNavigationItemView) {
                BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt;
                setNavigationViewClipOnLand(bottomNavigationItemView);
                bottomNavigationItemView.measure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), childMeasureSpec);
                LinearLayout container = bottomNavigationItemView.getContainer();
                ViewGroup.LayoutParams layoutParams = container.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    if (bottomNavigationItemView.isExtendImageMode()) {
                        layoutParams2.height = -1;
                    }
                    layoutParams2.gravity = 17;
                    m54014a(container, 0, 0, layoutParams2);
                }
                int measuredHeight = bottomNavigationItemView.getMeasuredHeight();
                if (measuredHeight > i14) {
                    i14 = measuredHeight;
                }
                m54012a(bottomNavigationItemView, i13);
            }
        }
        m54027b(childCount, i14);
        measureSize.setWidth(size);
        measureSize.setHeight(i14 + paddingTop);
    }

    /* renamed from: b */
    private void m54028b(int i10, int i11, MeasureSize measureSize) {
        int childCount = getChildCount();
        int i12 = 0;
        boolean z10 = false;
        boolean zIsSingleImageMode = false;
        while (true) {
            boolean z11 = true;
            if (i12 >= childCount) {
                break;
            }
            View childAt = getChildAt(i12);
            if (childAt instanceof BottomNavigationItemView) {
                BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt;
                zIsSingleImageMode |= bottomNavigationItemView.isSingleImageMode();
                if (!bottomNavigationItemView.m54052b() && !bottomNavigationItemView.isExtendImageMode()) {
                    z11 = false;
                }
                z10 |= z11;
            }
            i12++;
        }
        if (z10) {
            setClipChildren(false);
            setClipToPadding(false);
        }
        if (childCount != 2 && childCount != 1 && !zIsSingleImageMode) {
            m54035c(i10, i11, measureSize);
        } else {
            measureOnPortraitByAverageWidth(i10, i11, measureSize);
        }
    }

    /* renamed from: a */
    private int m53995a(int i10, int i11, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            View childAt = getChildAt(i14);
            if (childAt instanceof BottomNavigationItemView) {
                BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt;
                if (!bottomNavigationItemView.isSingleImageMode() && !bottomNavigationItemView.isExtendImageMode()) {
                    bottomNavigationItemView.setClipChildren(true);
                    bottomNavigationItemView.setClipToPadding(true);
                } else {
                    bottomNavigationItemView.setClipChildren(false);
                    bottomNavigationItemView.setClipToPadding(false);
                }
                bottomNavigationItemView.measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), i12);
                m54012a(bottomNavigationItemView, i11);
                View container = bottomNavigationItemView.getContainer();
                ViewGroup.LayoutParams layoutParams = container.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.gravity = 1;
                    container.setLayoutParams(layoutParams2);
                    m54014a(container, 0, 0, layoutParams2);
                }
                View icon = bottomNavigationItemView.getIcon();
                ViewGroup.LayoutParams layoutParams3 = icon.getLayoutParams();
                if (layoutParams3 instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                    layoutParams4.gravity = 1;
                    m54014a(icon, 0, 0, layoutParams4);
                }
                int measuredHeight = bottomNavigationItemView.getMeasuredHeight();
                if (measuredHeight > i13) {
                    i13 = measuredHeight;
                }
            }
        }
        return i13;
    }

    /* renamed from: a */
    private void m54019a(List<Float> list, int i10, float f10, int i11, BottomNavigationItemView bottomNavigationItemView) {
        int i12;
        int childCount = getChildCount();
        if (i10 != 0 && i10 != childCount - 1) {
            int i13 = i10 - 1;
            float fFloatValue = list.get(i13).floatValue();
            int i14 = i10 + 1;
            float fFloatValue2 = list.get(i14).floatValue();
            if (fFloatValue >= 0.0f && fFloatValue2 >= 0.0f) {
                float fFloatValue3 = list.get(i10).floatValue();
                if (fFloatValue > fFloatValue2) {
                    fFloatValue = fFloatValue2;
                }
                float f11 = (fFloatValue3 / 2.0f) + fFloatValue;
                if (!(getChildAt(i13) instanceof BottomNavigationItemView) || !(getChildAt(i14) instanceof BottomNavigationItemView)) {
                    return;
                }
                BottomNavigationItemView bottomNavigationItemView2 = (BottomNavigationItemView) getChildAt(i13);
                BottomNavigationItemView bottomNavigationItemView3 = (BottomNavigationItemView) getChildAt(i14);
                if (f11 > 0.0f) {
                    i12 = (int) (f10 - fFloatValue3);
                    bottomNavigationItemView.measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                    float f12 = (-fFloatValue3) / 2.0f;
                    bottomNavigationItemView2.f41513b = f12;
                    bottomNavigationItemView3.f41512a = f12;
                } else {
                    i12 = (int) (f10 + (2.0f * fFloatValue));
                    bottomNavigationItemView.measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                    bottomNavigationItemView2.f41513b = fFloatValue;
                    bottomNavigationItemView3.f41512a = fFloatValue;
                }
            } else {
                i12 = (int) f10;
                bottomNavigationItemView.measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
            }
        } else {
            i12 = (int) f10;
            bottomNavigationItemView.measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
        }
        bottomNavigationItemView.f41514c = true;
        m54012a(bottomNavigationItemView, i12);
    }

    /* renamed from: a */
    private void m54002a(float f10, int i10, List<Float> list, MeasureSize measureSize) {
        int childCount = getChildCount();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            if (list.get(i12).floatValue() < 0.0f) {
                View childAt = getChildAt(i12);
                if (childAt instanceof BottomNavigationItemView) {
                    BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt;
                    View icon = bottomNavigationItemView.getIcon();
                    ViewGroup.LayoutParams layoutParams = icon.getLayoutParams();
                    if (layoutParams instanceof LinearLayout.LayoutParams) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                        layoutParams2.gravity = 1;
                        m54014a(icon, 0, 0, layoutParams2);
                    }
                    m54013a(bottomNavigationItemView.getContainer(), 0, 0);
                    m54019a(list, i12, f10, i10, bottomNavigationItemView);
                    int measuredHeight = bottomNavigationItemView.getMeasuredHeight();
                    if (measuredHeight > i11) {
                        i11 = measuredHeight;
                    }
                }
            }
        }
        measureSize.setHeight(i11);
    }

    /* renamed from: a */
    private void m54001a(float f10, int i10, BottomNavigationItemView bottomNavigationItemView) {
        ViewGroup.LayoutParams layoutParams = bottomNavigationItemView.getContainer().getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = 1;
        }
        ViewGroup.LayoutParams layoutParams2 = bottomNavigationItemView.getIcon().getLayoutParams();
        if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams2).gravity = 1;
        }
        bottomNavigationItemView.measure(View.MeasureSpec.makeMeasureSpec((int) ((f10 - bottomNavigationItemView.f41512a) - bottomNavigationItemView.f41513b), 1073741824), i10);
        m54012a(bottomNavigationItemView, (int) ((f10 - bottomNavigationItemView.f41512a) - bottomNavigationItemView.f41513b));
        bottomNavigationItemView.f41512a = 0.0f;
        bottomNavigationItemView.f41513b = 0.0f;
    }

    /* renamed from: a */
    private void m54005a(int i10, MeasureSize measureSize) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            measureSize.setHeight(0);
            measureSize.setWidth(0);
            return;
        }
        int size = View.MeasureSpec.getSize(i10);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i11 = (size - paddingTop) / (childCount * 2);
        measureSize.setHeight(size);
        measureSize.setWidth(this.f41472D);
        boolean z10 = layoutParams.height == -2;
        int i12 = z10 ? 0 : i11;
        int iM53994a = m53994a(measureSize.getWidth(), i12);
        if (z10) {
            measureSize.setHeight(iM53994a * childCount * 2);
        } else {
            measureSize.setHeight(i12 * childCount * 2);
        }
        measureSize.setHeight(measureSize.getHeight() + paddingTop);
    }

    /* renamed from: a */
    private int m53994a(int i10, int i11) {
        int childCount = getChildCount();
        int iMax = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt != null) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), 0);
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
            }
        }
        int iMax2 = Math.max(iMax, i11);
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2 instanceof BottomNavigationItemView) {
                BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt2;
                bottomNavigationItemView.setDirection(0);
                bottomNavigationItemView.setGravity(17);
                ViewGroup.LayoutParams layoutParams = bottomNavigationItemView.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.height = iMax2;
                    layoutParams2.width = i10;
                    childAt2.setLayoutParams(layoutParams);
                }
            }
        }
        return iMax2;
    }

    /* renamed from: a */
    private void m54003a(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof BottomNavigationItemView) {
                BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) childAt;
                if (this.f41494l) {
                    bottomNavigationItemView.setDirection(1);
                } else {
                    bottomNavigationItemView.setDirection(0);
                }
            }
        }
    }

    /* renamed from: a */
    private void m54018a(List<Float> list, int i10, float f10) {
        View childAt = getChildAt(i10);
        if (childAt instanceof BottomNavigationItemView) {
            float desiredWidth = f10 - (Layout.getDesiredWidth(this.mMenu.getItem(i10).getTitle(), ((BottomNavigationItemView) childAt).getContent().getPaint()) + (this.f41490h * 2));
            if (desiredWidth > 0.0f) {
                list.add(Float.valueOf(desiredWidth / 2.0f));
            } else {
                list.add(Float.valueOf(desiredWidth));
            }
        }
    }

    /* renamed from: a */
    private void m54013a(View view, int i10, int i11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            m54014a(view, i10, i11, (ViewGroup.MarginLayoutParams) layoutParams);
        }
    }

    /* renamed from: a */
    private void m54014a(View view, int i10, int i11, ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (m54037d()) {
            marginLayoutParams.setMargins(i11, marginLayoutParams.topMargin, i10, marginLayoutParams.bottomMargin);
        } else {
            marginLayoutParams.setMargins(i10, marginLayoutParams.topMargin, i11, marginLayoutParams.bottomMargin);
        }
        view.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: a */
    private void m54012a(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i10;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54015a(BottomNavigationItemView bottomNavigationItemView, boolean z10) {
        BottomNavListener bottomNavListener;
        int itemIndex = bottomNavigationItemView.getItemIndex();
        int i10 = this.f41489g;
        if (itemIndex == i10 && (bottomNavListener = this.mListener) != null) {
            bottomNavListener.onBottomNavItemReselected(this.mMenu.getItem(itemIndex), itemIndex);
        } else if (itemIndex != i10) {
            if (i10 < this.mMenuSize && i10 >= 0) {
                View childAt = getChildAt(i10);
                if (!(childAt instanceof BottomNavigationItemView)) {
                    return;
                }
                ((BottomNavigationItemView) childAt).setChecked(false, true);
                BottomNavListener bottomNavListener2 = this.mListener;
                if (bottomNavListener2 != null) {
                    bottomNavListener2.onBottomNavItemUnselected(this.mMenu.getItem(this.f41489g), this.f41489g);
                }
            }
            this.f41489g = itemIndex;
            if (z10) {
                bottomNavigationItemView.setChecked(true, true);
            }
            BottomNavListener bottomNavListener3 = this.mListener;
            if (bottomNavListener3 != null) {
                bottomNavListener3.onBottomNavItemSelected(this.mMenu.getItem(this.f41489g), this.f41489g);
            }
        } else {
            Log.e(f41452O, "invalid index");
        }
        this.f41471C = this.f41489g;
    }

    /* renamed from: a */
    private void m54008a(Canvas canvas) {
        if (!this.f41504v || this.f41505w == null) {
            return;
        }
        Rect rect = this.f41483a;
        if (getOrientation() == 1) {
            if (m54037d()) {
                rect.left = 0;
                rect.right = this.f41505w.getIntrinsicWidth();
                rect.top = getPaddingTop();
                rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            } else {
                rect.left = ((getRight() - getLeft()) - getPaddingRight()) - 1;
                rect.right = this.f41505w.getIntrinsicWidth();
                rect.top = getPaddingTop();
                rect.bottom = (getBottom() - getTop()) - getPaddingBottom();
            }
        } else {
            rect.left = getPaddingLeft();
            rect.right = (getRight() - getLeft()) - getPaddingRight();
            rect.top = 0;
            rect.bottom = this.f41505w.getIntrinsicHeight();
        }
        this.f41505w.setBounds(rect);
        this.f41505w.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54011a(KeyEvent keyEvent, int i10) {
        View childAt = getChildAt(this.f41471C);
        if (childAt != null && childAt.isFocused()) {
            if (getOrientation() == 1) {
                m54036d(i10);
            } else {
                m54034c(i10);
            }
            if (i10 == 61) {
                m54010a(keyEvent);
                return;
            }
            return;
        }
        if (this.f41471C == getChildCount()) {
            this.f41471C--;
        }
    }

    /* renamed from: a */
    private void m54010a(KeyEvent keyEvent) {
        int i10;
        if (keyEvent != null) {
            if (keyEvent.isShiftPressed() && (i10 = this.f41471C) > 0) {
                this.f41471C = i10 - 1;
            } else {
                if (keyEvent.isShiftPressed() || this.f41471C >= getChildCount() - 1) {
                    return;
                }
                this.f41471C++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54000a() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i10 = (this.f41489g + 1) % childCount;
        setItemChecked(i10);
        if (i10 == this.f41489g) {
            int childCount2 = getChildCount();
            if (i10 < 0 || i10 >= childCount2) {
                return;
            }
            View childAt = getChildAt(i10);
            if (childAt instanceof BottomNavigationItemView) {
                childAt.requestFocus();
            }
        }
    }
}
