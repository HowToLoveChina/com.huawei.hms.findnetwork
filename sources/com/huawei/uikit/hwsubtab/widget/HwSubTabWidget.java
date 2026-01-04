package com.huawei.uikit.hwsubtab.widget;

import android.R;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.AbstractC0735a0;
import androidx.fragment.app.FragmentActivity;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hweffect.engine.HwBlurEngine;
import com.huawei.uikit.hweffect.engine.HwBlurable;
import com.huawei.uikit.hweventbadge.drawable.HwEventBadgeDrawable;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwsubtab.C8735R;
import com.huawei.uikit.hwsubtab.widget.HwSubTabViewContainer;
import com.huawei.uikit.hwunifiedinteract.widget.HwKeyEventDetector;
import com.huawei.uikit.hwwidgetsafeinsets.widget.HwWidgetSafeInsets;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class HwSubTabWidget extends LinearLayout implements HwBlurable {

    /* renamed from: Q */
    private static final String f44273Q = "HwSubTabWidget";

    /* renamed from: R */
    private static final int f44274R = 7;

    /* renamed from: S */
    private static final int f44275S = 2;

    /* renamed from: T */
    private static final int f44276T = -16777216;

    /* renamed from: U */
    private static final int f44277U = 4;

    /* renamed from: V */
    private static final int f44278V = -1;

    /* renamed from: W */
    private static final int f44279W = 300;

    /* renamed from: a0 */
    private static final int f44280a0 = 20;

    /* renamed from: b0 */
    private static final int f44281b0 = 0;

    /* renamed from: c0 */
    private static final float f44282c0 = 3.2f;

    /* renamed from: d0 */
    private static final float f44283d0 = 1.75f;

    /* renamed from: A */
    private boolean f44284A;

    /* renamed from: B */
    private boolean f44285B;

    /* renamed from: C */
    private boolean f44286C;

    /* renamed from: D */
    private int f44287D;

    /* renamed from: E */
    private int f44288E;

    /* renamed from: F */
    private HwWidgetSafeInsets f44289F;

    /* renamed from: G */
    private int f44290G;

    /* renamed from: H */
    private int f44291H;

    /* renamed from: I */
    private HwKeyEventDetector f44292I;

    /* renamed from: J */
    private ValueAnimator f44293J;

    /* renamed from: K */
    private HwKeyEventDetector.OnNextTabEventListener f44294K;

    /* renamed from: L */
    private HwKeyEventDetector.OnGlobalNextTabEventListener f44295L;

    /* renamed from: M */
    private ArgbEvaluator f44296M;

    /* renamed from: N */
    private boolean f44297N;

    /* renamed from: O */
    private String f44298O;

    /* renamed from: P */
    private boolean f44299P;

    /* renamed from: a */
    private int f44300a;

    /* renamed from: b */
    private int f44301b;

    /* renamed from: c */
    private float f44302c;

    /* renamed from: d */
    private HwSubTabViewContainer.SlidingTabStrip f44303d;

    /* renamed from: e */
    private HwSubTab f44304e;

    /* renamed from: f */
    private HwSubTab f44305f;

    /* renamed from: g */
    private blfhz f44306g;

    /* renamed from: h */
    private boolean f44307h;

    /* renamed from: i */
    private Context f44308i;

    /* renamed from: j */
    private OnSubTabChangeListener f44309j;

    /* renamed from: k */
    private Typeface f44310k;

    /* renamed from: l */
    private Typeface f44311l;

    /* renamed from: m */
    private int f44312m;
    protected ImageView mFunctionView;
    protected HwSubTabViewContainer mSubTabContainer;

    /* renamed from: n */
    private int f44313n;

    /* renamed from: o */
    private int f44314o;

    /* renamed from: p */
    private int f44315p;

    /* renamed from: q */
    private int f44316q;

    /* renamed from: r */
    private int f44317r;

    /* renamed from: s */
    private int f44318s;

    /* renamed from: t */
    private int f44319t;

    /* renamed from: u */
    private int f44320u;

    /* renamed from: v */
    private int f44321v;

    /* renamed from: w */
    private int f44322w;

    /* renamed from: x */
    private int f44323x;

    /* renamed from: y */
    private ColorStateList f44324y;

    /* renamed from: z */
    private HwBlurEngine f44325z;

    public interface OnSubTabChangeListener {
        void onSubTabReselected(HwSubTab hwSubTab);

        void onSubTabSelected(HwSubTab hwSubTab);

        void onSubTabUnselected(HwSubTab hwSubTab);
    }

    public class aauaf implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ SubTabView f44335a;

        /* renamed from: b */
        final /* synthetic */ SubTabView f44336b;

        public aauaf(SubTabView subTabView, SubTabView subTabView2) {
            this.f44335a = subTabView;
            this.f44336b = subTabView2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            HwSubTabWidget.this.mSubTabContainer.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            if (HwSubTabWidget.this.f44297N) {
                return;
            }
            float animatedFraction = valueAnimator.getAnimatedFraction();
            HwSubTabWidget.this.m55576a(animatedFraction, this.f44335a, this.f44336b);
            HwSubTabWidget.this.m55588b(animatedFraction, this.f44335a, this.f44336b);
        }
    }

    public class akxao implements HwKeyEventDetector.OnGlobalNextTabEventListener {
        public akxao() {
        }

        @Override // com.huawei.uikit.hwunifiedinteract.widget.HwKeyEventDetector.OnGlobalNextTabEventListener
        public boolean onGlobalNextTab(int i10, KeyEvent keyEvent) throws Resources.NotFoundException {
            if (i10 == 1) {
                HwSubTabWidget.this.m55592b();
            }
            return true;
        }
    }

    public static class avpbg extends View.BaseSavedState {
        public static final Parcelable.Creator<avpbg> CREATOR = new bzrwd();

        /* renamed from: a */
        private int f44339a;

        public class bzrwd implements Parcelable.Creator<avpbg> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public avpbg createFromParcel(Parcel parcel) {
                return new avpbg(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public avpbg[] newArray(int i10) {
                return new avpbg[i10];
            }
        }

        public avpbg(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            if (parcel == null) {
                Log.w(HwSubTabWidget.f44273Q, "Parameter dest of writeToParcel should not be null.");
            } else {
                super.writeToParcel(parcel, i10);
                parcel.writeInt(this.f44339a);
            }
        }

        public avpbg(Parcel parcel) {
            super(parcel);
            this.f44339a = parcel.readInt();
        }

        /* renamed from: a */
        public void m55620a(int i10) {
            this.f44339a = i10;
        }

        /* renamed from: a */
        public int m55619a() {
            return this.f44339a;
        }
    }

    public class blfhz implements View.OnClickListener {
        private blfhz() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                Log.w(HwSubTabWidget.f44273Q, "Parameter view of onClick should not be null.");
                return;
            }
            if (HwSubTabWidget.this.f44307h) {
                HwSubTabWidget.this.f44299P = true;
                int childCount = HwSubTabWidget.this.f44303d.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = HwSubTabWidget.this.f44303d.getChildAt(i10);
                    childAt.setSelected(childAt == view);
                    if (childAt == view && HwSubTabWidget.this.f44291H == 0) {
                        HwSubTabWidget.this.mSubTabContainer.animateToTab(i10);
                    }
                }
                if (view instanceof SubTabView) {
                    ((SubTabView) view).getSubTab().select();
                }
            }
        }

        public /* synthetic */ blfhz(HwSubTabWidget hwSubTabWidget, bzrwd bzrwdVar) {
            this();
        }
    }

    public class bqmxo implements HwKeyEventDetector.OnNextTabEventListener {
        public bqmxo() {
        }

        @Override // com.huawei.uikit.hwunifiedinteract.widget.HwKeyEventDetector.OnNextTabEventListener
        public boolean onNextTab(int i10, KeyEvent keyEvent) throws Resources.NotFoundException {
            if (i10 == 1) {
                HwSubTabWidget.this.m55592b();
            }
            return true;
        }
    }

    public class bzrwd implements ViewTreeObserver.OnGlobalLayoutListener {
        public bzrwd() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            HwSubTabWidget.this.mSubTabContainer.fullScroll(66);
            HwSubTabWidget.this.f44303d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public HwSubTabWidget(Context context) {
        this(context, null);
    }

    public static HwSubTabWidget instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwSubTabWidget.class, HwWidgetInstantiator.getCurrentType(context, 7, 1)), HwSubTabWidget.class);
        if (objInstantiate instanceof HwSubTabWidget) {
            return (HwSubTabWidget) objInstantiate;
        }
        return null;
    }

    private void setSubTabSelectedInner(int i10) {
        int childCount = this.f44303d.getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            SubTabView subTabViewAt = getSubTabViewAt(i11);
            boolean z10 = i11 == i10;
            if (subTabViewAt != null) {
                subTabViewAt.setTypeface(z10 ? this.f44310k : this.f44311l);
                subTabViewAt.setSelected(z10);
                if (z10) {
                    setTabHorizontalPadding(subTabViewAt);
                }
            }
            i11++;
        }
    }

    private void setSubTitleTextSize(int i10) {
        this.f44319t = i10;
    }

    private void setTabHorizontalPadding(SubTabView subTabView) {
        if (this.f44291H == 0) {
            m55602f();
        } else {
            subTabView.setViewHorizontalPadding();
        }
    }

    private void setValueFromPlume(Context context) {
        Method method = HwReflectUtil.getMethod("getBoolean", new Class[]{Context.class, View.class, String.class, Boolean.TYPE}, "huawei.android.widget.HwPlume");
        if (method == null) {
            setExtendedNextTabEnabled(true, true);
            setExtendedNextTabEnabled(false, true);
            return;
        }
        Boolean bool = Boolean.TRUE;
        Object objInvokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{context, this, "switchTabEnabled", bool});
        if (objInvokeMethod instanceof Boolean) {
            setExtendedNextTabEnabled(true, ((Boolean) objInvokeMethod).booleanValue());
        } else {
            setExtendedNextTabEnabled(true, true);
        }
        Object objInvokeMethod2 = HwReflectUtil.invokeMethod(null, method, new Object[]{context, this, "switchTabWhenFocusedEnabled", bool});
        if (objInvokeMethod2 instanceof Boolean) {
            setExtendedNextTabEnabled(false, ((Boolean) objInvokeMethod2).booleanValue());
        } else {
            setExtendedNextTabEnabled(false, true);
        }
    }

    public void addFunctionMenu(int i10, View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            Log.w(f44273Q, "Parameter clickListener should not be null.");
            return;
        }
        ImageView imageView = this.mFunctionView;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.mFunctionView.setContentDescription(this.f44298O);
            this.mFunctionView.setImageResource(i10);
            this.mFunctionView.setBackgroundResource(this.f44316q);
            this.mFunctionView.setOnClickListener(onClickListener);
            if (this.f44291H == 1) {
                ViewGroup.LayoutParams layoutParams = this.mFunctionView.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.bottomMargin = this.f44321v;
                    this.mFunctionView.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void addSubTab(HwSubTab hwSubTab, int i10, boolean z10) {
        if (hwSubTab == null) {
            Log.w(f44273Q, "Parameter subTab of addSubTab should not be null.");
            return;
        }
        SubTabView subTabViewM55587b = m55587b(hwSubTab);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.setMarginStart(this.f44314o);
        layoutParams.setMarginEnd(this.f44314o);
        subTabViewM55587b.setLayoutParams(layoutParams);
        this.f44303d.addView(subTabViewM55587b, i10, layoutParams);
        hwSubTab.setPosition(i10);
        updateSubTabPosition(i10, getSubTabCount(), true);
        if (z10) {
            hwSubTab.select();
            subTabViewM55587b.setSelected(true);
            subTabViewM55587b.setTextSize(0, this.f44301b);
        } else {
            subTabViewM55587b.setTextSize(0, this.f44318s);
        }
        setTabHorizontalPadding(subTabViewM55587b);
    }

    public HwKeyEventDetector createKeyEventDetector() {
        return new HwKeyEventDetector(this.f44308i);
    }

    public HwKeyEventDetector.OnGlobalNextTabEventListener createOnGlobalNextTabEventListener() {
        return new akxao();
    }

    public HwKeyEventDetector.OnNextTabEventListener createOnNextTabEventListener() {
        return new bqmxo();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.f44325z.isShowHwBlur(this)) {
            super.draw(canvas);
        } else {
            this.f44325z.draw(canvas, this);
            super.dispatchDraw(canvas);
        }
    }

    public int getAdjustTriggerWidth() {
        return getMeasuredWidth() / 2;
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public int getBlurColor() {
        return this.f44287D;
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public int getBlurType() {
        return this.f44288E;
    }

    public int getFadingMargin() {
        return this.mSubTabContainer.getFadingMargin();
    }

    public int getFocusPathColor() {
        return this.f44300a;
    }

    public int getIndicatorHeight() {
        return this.f44303d.getSelectedIndicatorHeight();
    }

    public OnSubTabChangeListener getOnSubTabChangeListener() {
        return this.f44309j;
    }

    public HwSubTab getSelectedSubTab() {
        return this.f44304e;
    }

    public int getSelectedSubTabPostion() {
        int subTabCount = getSubTabCount();
        for (int i10 = 0; i10 < subTabCount; i10++) {
            if (this.f44304e == getSubTabAt(i10)) {
                return i10;
            }
        }
        return -1;
    }

    public int getSubTabAppearance() {
        return this.f44291H;
    }

    public HwSubTab getSubTabAt(int i10) {
        View childAt = this.f44303d.getChildAt(i10);
        if (childAt instanceof SubTabView) {
            return ((SubTabView) childAt).getSubTab();
        }
        return null;
    }

    public HwSubTabViewContainer.SlidingTabStrip getSubTabContentView() {
        return this.f44303d;
    }

    public int getSubTabCount() {
        return this.f44303d.getChildCount();
    }

    public int getSubTabItemActivatedTextSize() {
        return this.f44301b;
    }

    public int getSubTabItemMargin() {
        return this.f44314o;
    }

    public int getSubTabItemPadding() {
        return this.f44312m;
    }

    public int getSubTabItemPaddingSecondary() {
        return this.f44313n;
    }

    public int getSubTabItemTextSize() {
        return this.f44318s;
    }

    public int getSubTabLeftScrollPadding() {
        return this.f44323x;
    }

    public SubTabView getSubTabView(HwSubTab hwSubTab) {
        return new SubTabView(getContext(), hwSubTab);
    }

    public SubTabView getSubTabViewAt(int i10) {
        View childAt = this.f44303d.getChildAt(i10);
        if (childAt instanceof SubTabView) {
            return (SubTabView) childAt;
        }
        return null;
    }

    public HwSubTabViewContainer getSubTabViewContainer() {
        return this.mSubTabContainer;
    }

    public int getSubTitleTextSize() {
        return this.f44319t;
    }

    public HwEventBadgeDrawable getTargetEventBadgeDrawable(int i10) {
        SubTabView subTabViewAt = getSubTabViewAt(i10);
        if (subTabViewAt == null) {
            return null;
        }
        return subTabViewAt.getEventBadgeDrawable();
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public boolean isBlurEnable() {
        return this.f44284A;
    }

    public boolean isExtendedNextTabEnabled(boolean z10) {
        HwKeyEventDetector hwKeyEventDetector = this.f44292I;
        if (hwKeyEventDetector == null) {
            return false;
        }
        return z10 ? hwKeyEventDetector.getOnGlobalNextTabListener() != null : hwKeyEventDetector.getOnNextTabListener() != null;
    }

    public boolean isSubTabClicked() {
        return this.f44299P;
    }

    public HwSubTab newSubTab() {
        return new HwSubTab(this);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        this.f44289F.updateWindowInsets(windowInsets);
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f44289F.updateOriginPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        HwKeyEventDetector hwKeyEventDetector = this.f44292I;
        if (hwKeyEventDetector != null) {
            hwKeyEventDetector.setOnNextTabListener(this.f44294K);
            this.f44292I.setOnGlobalNextTabListener(this, this.f44295L);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f44285B = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        HwKeyEventDetector hwKeyEventDetector = this.f44292I;
        if (hwKeyEventDetector != null) {
            hwKeyEventDetector.onDetachedFromWindow();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        HwKeyEventDetector hwKeyEventDetector = this.f44292I;
        if (hwKeyEventDetector == null || !hwKeyEventDetector.onKeyEvent(i10, keyEvent)) {
            return super.onKeyDown(i10, keyEvent);
        }
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        HwKeyEventDetector hwKeyEventDetector = this.f44292I;
        if (hwKeyEventDetector == null || !hwKeyEventDetector.onKeyEvent(i10, keyEvent)) {
            return super.onKeyUp(i10, keyEvent);
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f44285B) {
            HwSubTab hwSubTab = this.f44304e;
            if (hwSubTab != null && hwSubTab.getPosition() != -1) {
                setSubTabScrollingOffsets(this.f44304e.getPosition(), 0.0f);
                m55602f();
            }
            this.f44285B = false;
        }
        this.f44289F.applyDisplaySafeInsets(true);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f44322w, 1073741824);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight(), Integer.MIN_VALUE);
        this.f44303d.measure(childMeasureSpec, iMakeMeasureSpec);
        this.mSubTabContainer.measure(childMeasureSpec, iMakeMeasureSpec);
        super.onMeasure(i10, iMakeMeasureSpec);
        if (this.f44291H == 0) {
            m55575a();
            super.onMeasure(i10, iMakeMeasureSpec);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (this.f44308i.getApplicationInfo().targetSdkVersion <= 18) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        if (!(parcelable instanceof avpbg)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        avpbg avpbgVar = (avpbg) parcelable;
        super.onRestoreInstanceState(avpbgVar.getSuperState());
        int i10 = avpbgVar.f44339a;
        if (i10 < 0 || i10 >= getSubTabCount()) {
            return;
        }
        HwSubTab subTabAt = getSubTabAt(i10);
        if (subTabAt != null) {
            subTabAt.select();
        }
        SubTabView subTabViewAt = getSubTabViewAt(i10);
        if (subTabViewAt != null) {
            subTabViewAt.setSelected(true);
        }
        HwSubTabViewContainer hwSubTabViewContainer = this.mSubTabContainer;
        if (hwSubTabViewContainer != null) {
            hwSubTabViewContainer.animateToTab(i10);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        if (this.f44308i.getApplicationInfo().targetSdkVersion <= 18) {
            return super.onSaveInstanceState();
        }
        int selectedSubTabPostion = getSelectedSubTabPostion();
        avpbg avpbgVar = new avpbg(super.onSaveInstanceState());
        avpbgVar.f44339a = selectedSubTabPostion;
        return avpbgVar;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (i10 != 0) {
            this.f44325z.removeBlurTargetView(this);
            return;
        }
        this.f44325z.addBlurTargetView(this, this.f44288E);
        this.f44325z.setTargetViewBlurEnable(this, isBlurEnable());
        int i11 = this.f44287D;
        if (i11 != f44276T) {
            this.f44325z.setTargetViewOverlayColor(this, i11);
        }
    }

    public void removeAllSubTabs() {
        HwSubTabViewContainer.SlidingTabStrip slidingTabStrip = this.f44303d;
        if (slidingTabStrip == null) {
            return;
        }
        slidingTabStrip.removeAllViews();
        this.f44305f = null;
        this.f44304e = null;
    }

    public void removeSubTab(HwSubTab hwSubTab) throws Resources.NotFoundException {
        if (hwSubTab == null) {
            Log.w(f44273Q, "Parameter subTab of removeSubTab should not be null.");
        } else {
            removeSubTabAt(hwSubTab.getPosition());
        }
    }

    public void removeSubTabAt(int i10) throws Resources.NotFoundException {
        if (this.f44303d == null) {
            return;
        }
        HwSubTab subTabAt = getSubTabAt(i10);
        if (subTabAt != null) {
            subTabAt.setPosition(-1);
        }
        this.f44303d.removeViewAt(i10);
        if (getSubTabCount() == 0) {
            this.f44305f = null;
            this.f44304e = null;
        }
        updateSubTabPosition(i10, getSubTabCount(), false);
        if (subTabAt == this.f44304e) {
            int i11 = i10 - 1;
            HwSubTab subTabAt2 = getSubTabAt(i11 > 0 ? i11 : 0);
            if (subTabAt2 != null) {
                selectSubTab(subTabAt2);
                selectSubTabEx(subTabAt2);
            }
        }
    }

    public int requestFocusedIndicatorColor() {
        return this.f44290G;
    }

    public void selectSubTab(HwSubTab hwSubTab) throws Resources.NotFoundException {
        if (this.f44297N) {
            return;
        }
        Context context = this.f44308i;
        AbstractC0735a0 abstractC0735a0M4668m = context instanceof FragmentActivity ? ((FragmentActivity) context).m4473U().m4585o().m4668m() : null;
        HwSubTab hwSubTab2 = this.f44304e;
        if ((hwSubTab2 == null || hwSubTab2.getPosition() == -1) && hwSubTab != null && hwSubTab.getPosition() != -1) {
            this.mSubTabContainer.setScrollPosition(hwSubTab.getPosition(), 0.0f);
        }
        if (this.f44304e == hwSubTab) {
            m55579a(abstractC0735a0M4668m);
        } else {
            m55580a(hwSubTab, abstractC0735a0M4668m);
        }
        if (abstractC0735a0M4668m == null || abstractC0735a0M4668m.mo4654p()) {
            return;
        }
        abstractC0735a0M4668m.mo4647h();
    }

    public void selectSubTabEx(HwSubTab hwSubTab) throws Resources.NotFoundException {
        HwSubTab hwSubTab2;
        if (this.f44297N) {
            return;
        }
        HwSubTab hwSubTab3 = this.f44304e;
        if ((hwSubTab3 == null || hwSubTab3.getPosition() == -1) && hwSubTab.getPosition() != -1) {
            this.mSubTabContainer.setScrollPosition(hwSubTab.getPosition(), 0.0f);
        }
        HwSubTab hwSubTab4 = this.f44304e;
        if (hwSubTab4 == hwSubTab) {
            OnSubTabChangeListener onSubTabChangeListener = this.f44309j;
            if (onSubTabChangeListener == null || hwSubTab4 == null) {
                return;
            }
            onSubTabChangeListener.onSubTabReselected(hwSubTab4);
            return;
        }
        if (hwSubTab4 != null && this.f44291H == 1) {
            m55594c(hwSubTab);
        }
        setSubTabSelectedInner(hwSubTab.getPosition());
        OnSubTabChangeListener onSubTabChangeListener2 = this.f44309j;
        if (onSubTabChangeListener2 != null && (hwSubTab2 = this.f44304e) != null) {
            onSubTabChangeListener2.onSubTabUnselected(hwSubTab2);
        }
        this.f44305f = this.f44304e;
        this.f44304e = hwSubTab;
        OnSubTabChangeListener onSubTabChangeListener3 = this.f44309j;
        if (onSubTabChangeListener3 != null) {
            onSubTabChangeListener3.onSubTabSelected(hwSubTab);
        }
    }

    public void setActivatedTextSize(int i10, int i11) {
        if (this.f44291H == 1) {
            this.f44318s = i10;
            this.f44301b = i11;
        }
    }

    public void setAnimationEnabled(boolean z10) {
        this.f44286C = z10;
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public void setBlurColor(int i10) {
        this.f44287D = i10;
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public void setBlurEnable(boolean z10) {
        this.f44284A = z10;
        this.f44325z.setTargetViewBlurEnable(this, isBlurEnable());
    }

    @Override // com.huawei.uikit.hweffect.engine.HwBlurable
    public void setBlurType(int i10) {
        this.f44288E = i10;
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        this.f44307h = z10;
    }

    public void setConfigChange(boolean z10) {
        this.f44285B = z10;
    }

    public void setExtendedNextTabEnabled(boolean z10, boolean z11) {
        HwKeyEventDetector hwKeyEventDetector = this.f44292I;
        if (hwKeyEventDetector == null) {
            return;
        }
        if (z10) {
            if (!z11) {
                this.f44295L = null;
                hwKeyEventDetector.setOnGlobalNextTabListener(this, null);
                return;
            } else {
                HwKeyEventDetector.OnGlobalNextTabEventListener onGlobalNextTabEventListenerCreateOnGlobalNextTabEventListener = createOnGlobalNextTabEventListener();
                this.f44295L = onGlobalNextTabEventListenerCreateOnGlobalNextTabEventListener;
                this.f44292I.setOnGlobalNextTabListener(this, onGlobalNextTabEventListenerCreateOnGlobalNextTabEventListener);
                return;
            }
        }
        if (!z11) {
            this.f44294K = null;
            hwKeyEventDetector.setOnNextTabListener(null);
        } else {
            HwKeyEventDetector.OnNextTabEventListener onNextTabEventListenerCreateOnNextTabEventListener = createOnNextTabEventListener();
            this.f44294K = onNextTabEventListenerCreateOnNextTabEventListener;
            this.f44292I.setOnNextTabListener(onNextTabEventListenerCreateOnNextTabEventListener);
        }
    }

    public void setFocusPathColor(int i10) {
        this.f44300a = i10;
    }

    public void setFunctionMenuContent(String str) {
        this.f44298O = str;
    }

    public void setIndicatorColor(int i10) {
        this.f44290G = i10;
        this.f44303d.setSelectedIndicatorColor(i10);
    }

    public void setIsNeedSafeInsets(boolean z10) {
        this.f44289F.setIsNeedSafeInsets(z10);
    }

    public void setIsViewPagerScroll(boolean z10) {
        if (this.f44291H == 0) {
            return;
        }
        this.f44297N = z10;
    }

    public void setOnSubTabChangeListener(OnSubTabChangeListener onSubTabChangeListener) {
        this.f44309j = onSubTabChangeListener;
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        this.f44289F.updateOriginPadding(i10, i11, i12, i13);
    }

    public void setSubTabClicked(boolean z10) {
        this.f44299P = z10;
    }

    public void setSubTabItemPadding(int i10) {
        this.f44312m = i10;
    }

    public void setSubTabItemPaddingSecondary(int i10) {
        this.f44313n = i10;
    }

    public void setSubTabItemTextColors(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        this.f44324y = colorStateList;
    }

    public void setSubTabLeftScrollPadding(int i10) {
        this.f44323x = i10;
    }

    public void setSubTabScrollingOffsets(int i10, float f10) {
        this.mSubTabContainer.setScrollPosition(i10, f10);
        if (this.f44291H != 1 || Float.compare(f10, 0.0f) == 0) {
            return;
        }
        ValueAnimator valueAnimator = this.f44293J;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f44293J.cancel();
            m55600e();
        }
        SubTabView subTabViewAt = getSubTabViewAt(this.f44303d.f44257a);
        if (i10 >= this.f44303d.f44257a) {
            i10++;
        }
        SubTabView subTabViewAt2 = getSubTabViewAt(i10);
        if (subTabViewAt == null || subTabViewAt2 == null) {
            return;
        }
        m55576a(f10, subTabViewAt, subTabViewAt2);
        m55588b(f10, subTabViewAt, subTabViewAt2);
    }

    public void setSubTabSelected(int i10) throws Resources.NotFoundException {
        HwSubTab subTabAt = getSubTabAt(i10);
        if (subTabAt == null) {
            return;
        }
        HwSubTab hwSubTab = this.f44304e;
        if (hwSubTab == null || hwSubTab.getPosition() == -1) {
            this.mSubTabContainer.setScrollPosition(i10, 0.0f);
        }
        if (this.f44291H == 1 && this.f44304e != subTabAt) {
            selectSubTab(subTabAt);
        }
        this.f44304e = subTabAt;
        setSubTabSelectedInner(i10);
    }

    public void updateSubTab(int i10) {
        SubTabView subTabViewAt = getSubTabViewAt(i10);
        if (subTabViewAt != null) {
            subTabViewAt.update();
            setTabHorizontalPadding(subTabViewAt);
        }
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0000, code lost:
    
        if (r3 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0003, code lost:
    
        if (r1 >= r2) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0005, code lost:
    
        r3 = getSubTabAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0009, code lost:
    
        if (r3 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x000b, code lost:
    
        r3.setPosition(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x000e, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0011, code lost:
    
        return;
     */
    /* JADX WARN: Path cross not found for [B:18:0x000e, B:14:0x0003], limit reached: 9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x000e -> B:14:0x0003). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateSubTabPosition(int r1, int r2, boolean r3) {
        /*
            r0 = this;
            if (r3 == 0) goto L3
            goto Le
        L3:
            if (r1 >= r2) goto L11
            com.huawei.uikit.hwsubtab.widget.HwSubTab r3 = r0.getSubTabAt(r1)
            if (r3 == 0) goto Le
            r3.setPosition(r1)
        Le:
            int r1 = r1 + 1
            goto L3
        L11:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwsubtab.widget.HwSubTabWidget.updateSubTabPosition(int, int, boolean):void");
    }

    public HwSubTabWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8735R.attr.hwSubTabBarStyle);
    }

    /* renamed from: c */
    private void m55593c(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        int dimensionPixelSize;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8735R.styleable.HwSubTabWidget, i10, C8735R.style.Widget_Emui_HwSubTabBar);
        if (m55598d()) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_height_larger);
            if (this.f44302c == 3.2f && this.f44291H == 0) {
                dimensionPixelSize = getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_height_max);
            }
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_height);
        }
        try {
            this.f44286C = typedArrayObtainStyledAttributes.getBoolean(C8735R.styleable.HwSubTabWidget_hwSubTabAnimationEnabled, true);
        } catch (UnsupportedOperationException unused) {
            this.f44286C = true;
        }
        try {
            try {
                this.f44322w = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8735R.styleable.HwSubTabWidget_hwSubTabHeight, dimensionPixelSize);
            } catch (UnsupportedOperationException unused2) {
                this.f44322w = dimensionPixelSize;
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: d */
    public boolean m55598d() {
        return Float.compare(this.f44302c, 1.75f) >= 0 && AuxiliaryHelper.isAuxiliaryDevice(this.f44308i);
    }

    /* renamed from: e */
    private void m55600e() {
        SubTabView subTabViewAt;
        HwSubTab hwSubTab = this.f44305f;
        if (hwSubTab == null || (subTabViewAt = getSubTabViewAt(hwSubTab.getPosition())) == null) {
            return;
        }
        ColorStateList subTabColor = subTabViewAt.getSubTabColor();
        if (subTabColor != null) {
            subTabViewAt.setTextColor(subTabColor.getDefaultColor());
        }
        subTabViewAt.setTextSize(0, this.f44318s);
    }

    /* renamed from: f */
    private void m55602f() {
        int childCount = this.f44303d.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.f44303d.getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).width = -2;
                if (childAt instanceof SubTabView) {
                    ((SubTabView) childAt).setViewHorizontalPadding();
                }
            }
        }
    }

    public HwSubTab newSubTab(CharSequence charSequence) {
        return new HwSubTab(this, charSequence);
    }

    public HwSubTabWidget(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(m55573a(context, i10), attributeSet, i10);
        this.f44300a = 0;
        this.f44307h = true;
        this.f44323x = 20;
        this.f44325z = HwBlurEngine.getInstance();
        this.f44284A = false;
        this.f44285B = false;
        this.f44286C = true;
        this.f44287D = f44276T;
        this.f44288E = 4;
        this.f44291H = 0;
        this.f44292I = null;
        this.f44297N = false;
        this.f44299P = false;
        m55578a(getContext(), attributeSet, i10);
    }

    public HwSubTab newSubTab(CharSequence charSequence, CharSequence charSequence2) {
        return new HwSubTab(this, charSequence, charSequence2, null, null);
    }

    /* renamed from: b */
    private void m55589b(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        View viewInflate;
        int dimensionPixelSize;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8735R.styleable.HwSubTabWidget, i10, C8735R.style.Widget_Emui_HwSubTabBar);
        this.f44291H = typedArrayObtainStyledAttributes.getInt(C8735R.styleable.HwSubTabWidget_hwSubTabAppearance, 0);
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (layoutInflater == null) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (this.f44291H == 1) {
            viewInflate = layoutInflater.inflate(C8735R.layout.hwsubtab_content_headline, (ViewGroup) this, true);
            dimensionPixelSize = getResources().getDimensionPixelSize(C8735R.dimen.emui_text_size_headline7);
        } else {
            viewInflate = layoutInflater.inflate(C8735R.layout.hwsubtab_content, (ViewGroup) this, true);
            dimensionPixelSize = getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_text_size);
        }
        this.f44318s = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8735R.styleable.HwSubTabWidget_hwSubTabItemTextSize, dimensionPixelSize);
        this.f44301b = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8735R.styleable.HwSubTabWidget_hwSubTabItemActivedTextSize, getResources().getDimensionPixelSize(C8735R.dimen.emui_text_size_headline6));
        this.f44319t = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8735R.styleable.HwSubTabWidget_hwSubTitleTextSize, getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_text_sub_size));
        this.f44300a = typedArrayObtainStyledAttributes.getColor(C8735R.styleable.HwSubTabWidget_hwFocusedPathColor, 0);
        this.mSubTabContainer = (HwSubTabViewContainer) viewInflate.findViewById(C8735R.id.hwsubtab_view_container);
        this.mFunctionView = (ImageView) viewInflate.findViewById(C8735R.id.hwsubtab_function_icon);
        this.f44303d = this.mSubTabContainer.getTabStrip();
        m55577a(context, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public HwSubTab newSubTab(CharSequence charSequence, HwSubTabListener hwSubTabListener, Object obj) {
        return new HwSubTab(this, charSequence, null, hwSubTabListener, obj);
    }

    /* renamed from: a */
    private void m55577a(Context context, TypedArray typedArray) throws Resources.NotFoundException {
        this.f44302c = this.f44308i.getResources().getConfiguration().fontScale;
        if (m55598d()) {
            this.f44303d.setSelectedIndicatorMargin(getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_item_line_padding_top));
        } else {
            this.f44303d.setSelectedIndicatorMargin(getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_margin));
        }
        this.f44303d.setSelectedIndicatorHeight(typedArray.getDimensionPixelSize(C8735R.styleable.HwSubTabWidget_hwSubTabIndicatorHeight, getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_indicator_height)));
        this.f44290G = typedArray.getColor(C8735R.styleable.HwSubTabWidget_hwSubTabIndicatorColor, ContextCompat.getColor(context, C8735R.color.hwsubtab_accent));
        this.f44314o = typedArray.getDimensionPixelSize(C8735R.styleable.HwSubTabWidget_hwSubTabItemMargin, getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_item_margin));
        this.f44312m = typedArray.getDimensionPixelSize(C8735R.styleable.HwSubTabWidget_hwSubTabItemPadding, getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_item_padding));
        this.f44313n = typedArray.getDimensionPixelSize(C8735R.styleable.HwSubTabWidget_hwSubTabItemPaddingSecondary, getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_function_view_padding));
        int i10 = C8735R.styleable.HwSubTabWidget_hwSubTabItemBg;
        int i11 = C8735R.drawable.hwsubtab_selector_item_bg;
        this.f44315p = typedArray.getResourceId(i10, i11);
        this.f44316q = typedArray.getResourceId(C8735R.styleable.HwSubTabWidget_hwSubTabFunctionViewBg, i11);
        this.f44317r = typedArray.getDimensionPixelSize(C8735R.styleable.HwSubTabWidget_hwSubTabItemMinWidth, 0);
        this.f44324y = typedArray.getColorStateList(C8735R.styleable.HwSubTabWidget_hwSubTabItemTextColor);
        this.f44288E = typedArray.getInteger(C8735R.styleable.HwSubTabWidget_hwSubTabBlurType, 4);
        this.f44287D = typedArray.getColor(C8735R.styleable.HwSubTabWidget_hwSubTabBlurColor, f44276T);
        this.f44320u = typedArray.getDimensionPixelSize(C8735R.styleable.HwSubTabWidget_hwSubTabTextPaddingBottom, getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_text_padding_bottom));
        this.f44321v = typedArray.getDimensionPixelSize(C8735R.styleable.HwSubTabWidget_hwSubTabIconMarginBottom, getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_icon_margin_bottom));
        this.mSubTabContainer.setSubTabFaddingEdgeColor(typedArray.getColor(C8735R.styleable.HwSubTabWidget_hwSubTabFadingEdgeColor, 0));
    }

    /* renamed from: c */
    public boolean m55595c() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: c */
    private void m55594c(HwSubTab hwSubTab) throws Resources.NotFoundException {
        int position = this.f44304e.getPosition();
        int position2 = hwSubTab.getPosition();
        SubTabView subTabViewAt = getSubTabViewAt(position);
        SubTabView subTabViewAt2 = getSubTabViewAt(position2);
        if (subTabViewAt == null || subTabViewAt2 == null) {
            return;
        }
        m55600e();
        int scrollX = this.mSubTabContainer.getScrollX();
        int iM55572a = m55572a(hwSubTab);
        if (!this.f44286C) {
            this.mSubTabContainer.scrollTo(iM55572a, 0);
            m55576a(1.0f, subTabViewAt, subTabViewAt2);
            m55588b(1.0f, subTabViewAt, subTabViewAt2);
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(scrollX, iM55572a);
        this.f44293J = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(300L);
        this.f44293J.setInterpolator(AnimationUtils.loadInterpolator(this.f44308i, C8735R.interpolator.cubic_bezier_interpolator_type_20_80));
        this.f44293J.addUpdateListener(new aauaf(subTabViewAt, subTabViewAt2));
        this.f44293J.start();
    }

    public void addSubTab(HwSubTab hwSubTab, boolean z10) {
        if (hwSubTab == null) {
            Log.w(f44273Q, "Parameter subTab of addSubTab should not be null.");
            return;
        }
        SubTabView subTabViewM55587b = m55587b(hwSubTab);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        subTabViewM55587b.setLayoutParams(layoutParams);
        layoutParams.setMarginStart(this.f44314o);
        layoutParams.setMarginEnd(this.f44314o);
        this.f44303d.addView(subTabViewM55587b, layoutParams);
        if (m55595c()) {
            this.f44303d.getViewTreeObserver().addOnGlobalLayoutListener(new bzrwd());
        }
        hwSubTab.setPosition(getSubTabCount() - 1);
        if (z10) {
            hwSubTab.select();
            subTabViewM55587b.setSelected(true);
            subTabViewM55587b.setTextSize(0, this.f44291H == 1 ? this.f44301b : this.f44318s);
        } else {
            subTabViewM55587b.setTextSize(0, this.f44318s);
        }
        setTabHorizontalPadding(subTabViewM55587b);
    }

    public class SubTabView extends TextView {

        /* renamed from: a */
        private final int f44326a;

        /* renamed from: b */
        private final int f44327b;

        /* renamed from: c */
        private float f44328c;

        /* renamed from: d */
        private HwSubTab f44329d;

        /* renamed from: e */
        private ColorStateList f44330e;

        /* renamed from: f */
        private HwEventBadgeDrawable f44331f;

        /* renamed from: g */
        private int f44332g;

        /* renamed from: h */
        private Context f44333h;

        public SubTabView(Context context, HwSubTab hwSubTab) throws Resources.NotFoundException {
            super(context, null, 0);
            this.f44326a = 6;
            this.f44327b = 2;
            this.f44332g = 0;
            this.f44329d = hwSubTab;
            this.f44333h = context;
            m55613a(context);
        }

        /* renamed from: a */
        private void m55613a(Context context) throws Resources.NotFoundException {
            if (HwSubTabWidget.this.f44291H == 0) {
                setGravity(17);
                setViewHorizontalPadding();
            }
            m55614a(context, getResources().getConfiguration());
            setTextSize(0, HwSubTabWidget.this.f44318s);
            if (HwSubTabWidget.this.f44324y != null) {
                setTextColor(HwSubTabWidget.this.f44324y);
                this.f44330e = HwSubTabWidget.this.f44324y;
            }
            setBackgroundResource(HwSubTabWidget.this.f44315p);
            setMinWidth(HwSubTabWidget.this.f44317r);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            m55612a();
            this.f44328c = getContext().getResources().getDisplayMetrics().density;
            HwEventBadgeDrawable hwEventBadgeDrawable = new HwEventBadgeDrawable();
            this.f44331f = hwEventBadgeDrawable;
            hwEventBadgeDrawable.parseAttrsAndInit(context, null, 0);
            this.f44331f.setBadgeMode(1);
            this.f44331f.setCallback(this);
        }

        /* renamed from: b */
        private void m55616b() {
            setPadding(getPaddingLeft(), ((HwSubTabWidget.this.f44322w - HwSubTabWidget.this.f44320u) - (-getPaint().getFontMetricsInt().top)) - (HwSubTabWidget.this.m55598d() ? this.f44333h.getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_item_padding) : 0), getPaddingRight(), getPaddingBottom());
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            m55615a(canvas);
        }

        public HwEventBadgeDrawable getEventBadgeDrawable() {
            return this.f44331f;
        }

        public HwSubTab getSubTab() {
            return this.f44329d;
        }

        public ColorStateList getSubTabColor() {
            return this.f44330e;
        }

        public int getTextPaddingLeft() {
            return this.f44332g + getPaddingLeft();
        }

        public int getTextPaddingRight() {
            return this.f44332g + getPaddingRight();
        }

        @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            super.invalidateDrawable(drawable);
            invalidate();
        }

        @Override // android.widget.TextView, android.view.View
        public void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            m55614a(this.f44333h, configuration);
        }

        @Override // android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z10, int i10, Rect rect) {
            responseToFocusChanged();
            super.onFocusChanged(z10, i10, rect);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            if (accessibilityNodeInfo == null) {
                return;
            }
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (isSelected()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
            }
        }

        @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            if (HwSubTabWidget.this.onKeyDown(i10, keyEvent)) {
                return true;
            }
            return super.onKeyDown(i10, keyEvent);
        }

        @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyUp(int i10, KeyEvent keyEvent) {
            if (HwSubTabWidget.this.onKeyUp(i10, keyEvent)) {
                return true;
            }
            return super.onKeyUp(i10, keyEvent);
        }

        @Override // android.widget.TextView, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            if (HwSubTabWidget.this.f44291H == 1) {
                m55616b();
            }
            super.onLayout(z10, i10, i11, i12, i13);
            this.f44332g = ((int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) - getPaint().measureText(this.f44329d.getText().toString()))) / 2;
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent == null) {
                Log.w(HwSubTabWidget.f44273Q, "onTouchEvent: event is null!");
                return false;
            }
            if (motionEvent.getAction() == 1) {
                HwEventBadgeDrawable eventBadgeDrawable = getEventBadgeDrawable();
                if (eventBadgeDrawable != null) {
                    eventBadgeDrawable.setBadgeCount(0);
                }
                if (!isInTouchMode() && HwSubTabWidget.this.f44303d.hasFocus()) {
                    requestFocus();
                }
            }
            return super.onTouchEvent(motionEvent);
        }

        public void responseToFocusChanged() {
            if (!hasFocus()) {
                HwSubTabWidget.this.f44303d.setSelectedIndicatorColor(HwSubTabWidget.this.f44290G);
                return;
            }
            HwSubTabWidget.this.f44303d.setSelectedIndicatorColor(HwSubTabWidget.this.requestFocusedIndicatorColor());
            HwEventBadgeDrawable eventBadgeDrawable = getEventBadgeDrawable();
            if (eventBadgeDrawable != null) {
                eventBadgeDrawable.setBadgeCount(0);
            }
            selectTab();
        }

        public void selectTab() {
            performClick();
        }

        public void setSubTabColor(ColorStateList colorStateList) {
            this.f44330e = colorStateList;
            setTextColor(colorStateList);
        }

        public void setViewHorizontalPadding() {
            setPadding(HwSubTabWidget.this.f44312m, 0, HwSubTabWidget.this.f44312m, 0);
        }

        public void update() {
            m55612a();
        }

        /* renamed from: a */
        private void m55614a(Context context, Configuration configuration) {
            if (configuration.orientation == 1) {
                setMaxLines(1);
            }
            if (configuration.orientation == 2) {
                if (HwWidgetInstantiator.getCurrentType(context, 7, 1) == 4) {
                    setSingleLine(true);
                } else {
                    setMaxLines(1);
                }
            }
        }

        /* renamed from: a */
        private void m55615a(Canvas canvas) {
            Paint.FontMetrics fontMetrics;
            float f10;
            int height;
            if (this.f44331f == null || Float.compare(this.f44328c, 0.0f) <= 0) {
                return;
            }
            int paddingEnd = HwSubTabWidget.this.m55595c() ? getPaddingEnd() - ((int) (this.f44328c * 8.0f)) : (getWidth() - getPaddingEnd()) + ((int) (this.f44328c * 2.0f));
            int i10 = ((int) (this.f44328c * 6.0f)) + paddingEnd;
            if (HwSubTabWidget.this.f44291H == 0) {
                f10 = this.f44328c;
                height = (int) ((getHeight() / 2.0f) - (3.0f * f10));
            } else {
                TextPaint paint = getPaint();
                if (paint == null || (fontMetrics = paint.getFontMetrics()) == null) {
                    return;
                }
                int baseline = getBaseline() + ((int) ((fontMetrics.top + fontMetrics.bottom) / 2.0f));
                f10 = this.f44328c;
                height = baseline - ((int) (3.0f * f10));
            }
            this.f44331f.setBounds(paddingEnd, height, i10, ((int) (f10 * 6.0f)) + height);
            this.f44331f.draw(canvas);
        }

        /* renamed from: a */
        private void m55612a() {
            CharSequence text = this.f44329d.getText();
            if (!TextUtils.isEmpty(text)) {
                setText(text);
                setVisibility(0);
            } else {
                setVisibility(8);
                setText((CharSequence) null);
            }
            if (this.f44329d.getSubTabId() != -1) {
                setId(this.f44329d.getSubTabId());
            }
        }
    }

    /* renamed from: b */
    public void m55588b(float f10, final SubTabView subTabView, final SubTabView subTabView2) {
        final float f11 = (this.f44301b - this.f44318s) * f10;
        post(new Runnable() { // from class: com.huawei.uikit.hwsubtab.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f44348a.m55581a(subTabView, f11, subTabView2);
            }
        });
    }

    /* renamed from: b */
    private SubTabView m55587b(HwSubTab hwSubTab) {
        SubTabView subTabView = getSubTabView(hwSubTab);
        subTabView.setFocusable(true);
        if (this.f44306g == null) {
            this.f44306g = new blfhz(this, null);
        }
        subTabView.setOnClickListener(this.f44306g);
        return subTabView;
    }

    /* renamed from: b */
    public boolean m55592b() throws Resources.NotFoundException {
        int i10;
        HwSubTab subTabAt;
        if (this.f44303d == null) {
            return false;
        }
        int selectedSubTabPostion = getSelectedSubTabPostion();
        int subTabCount = getSubTabCount();
        if (subTabCount <= 0 || (subTabAt = getSubTabAt((i10 = (selectedSubTabPostion + 1) % subTabCount))) == null) {
            return false;
        }
        this.f44303d.setSelectedIndicatorColor(this.f44290G);
        selectSubTab(subTabAt);
        selectSubTabEx(subTabAt);
        this.f44303d.setSelectedIndicatorColor(requestFocusedIndicatorColor());
        View childAt = this.f44303d.getChildAt(i10);
        if (childAt != null) {
            childAt.requestFocus();
        }
        return true;
    }

    /* renamed from: a */
    private static Context m55573a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8735R.style.Theme_Emui_HwSubTabWidget);
    }

    /* renamed from: a */
    private void m55578a(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        this.f44308i = context;
        this.f44289F = new HwWidgetSafeInsets(this);
        setOrientation(0);
        m55589b(this.f44308i, attributeSet, i10);
        m55593c(context, attributeSet, i10);
        this.mSubTabContainer.setAnimationEnabled(this.f44286C);
        this.f44310k = Typeface.create(getResources().getString(C8735R.string.emui_text_font_family_medium), 0);
        this.f44311l = Typeface.create(getResources().getString(C8735R.string.emui_text_font_family_regular), 0);
        this.f44303d.setSelectedIndicatorColor(this.f44290G);
        this.mSubTabContainer.setAppearance(this.f44291H);
        this.mSubTabContainer.setSubTabItemMargin(this.f44314o);
        this.f44292I = createKeyEventDetector();
        this.f44296M = new ArgbEvaluator();
        setValueFromPlume(context);
    }

    /* renamed from: a */
    private void m55580a(HwSubTab hwSubTab, AbstractC0735a0 abstractC0735a0) throws Resources.NotFoundException {
        if (this.f44304e != null && this.f44291H == 1) {
            m55594c(hwSubTab);
        }
        setSubTabSelectedInner(hwSubTab != null ? hwSubTab.getPosition() : -1);
        HwSubTab hwSubTab2 = this.f44304e;
        if (hwSubTab2 != null) {
            if (hwSubTab2.getCallback() != null) {
                this.f44304e.getCallback().onSubTabUnselected(this.f44304e, abstractC0735a0);
            }
            OnSubTabChangeListener onSubTabChangeListener = this.f44309j;
            if (onSubTabChangeListener != null) {
                onSubTabChangeListener.onSubTabUnselected(this.f44304e);
            }
        }
        this.f44305f = this.f44304e;
        this.f44304e = hwSubTab;
        if (hwSubTab != null) {
            if (hwSubTab.getCallback() != null) {
                this.f44304e.getCallback().onSubTabSelected(this.f44304e, abstractC0735a0);
            }
            OnSubTabChangeListener onSubTabChangeListener2 = this.f44309j;
            if (onSubTabChangeListener2 != null) {
                onSubTabChangeListener2.onSubTabSelected(this.f44304e);
            }
        }
    }

    /* renamed from: a */
    private void m55579a(AbstractC0735a0 abstractC0735a0) {
        HwSubTab hwSubTab = this.f44304e;
        if (hwSubTab != null) {
            if (hwSubTab.getCallback() != null) {
                this.f44304e.getCallback().onSubTabReselected(this.f44304e, abstractC0735a0);
            }
            OnSubTabChangeListener onSubTabChangeListener = this.f44309j;
            if (onSubTabChangeListener != null) {
                onSubTabChangeListener.onSubTabReselected(this.f44304e);
            }
        }
    }

    /* renamed from: a */
    private int m55572a(HwSubTab hwSubTab) {
        int right;
        int width;
        int position = this.f44304e.getPosition();
        int position2 = hwSubTab.getPosition();
        SubTabView subTabViewAt = getSubTabViewAt(position);
        SubTabView subTabViewAt2 = getSubTabViewAt(position2);
        if (subTabViewAt != null && subTabViewAt2 != null) {
            TextPaint textPaint = new TextPaint(1);
            TextPaint textPaint2 = new TextPaint(1);
            textPaint.setTextSize(this.f44318s);
            textPaint2.setTextSize(this.f44301b);
            String string = subTabViewAt.getText().toString();
            String string2 = subTabViewAt2.getText().toString();
            int iMeasureText = (int) (textPaint2.measureText(string) - textPaint.measureText(string));
            int iMeasureText2 = (int) (textPaint2.measureText(string2) - textPaint.measureText(string2));
            int i10 = this.f44314o;
            int iM55559a = i10 + i10 + this.mSubTabContainer.m55559a(this.f44323x);
            if (!m55595c()) {
                return (position < position2 ? subTabViewAt2.getLeft() - iMeasureText : subTabViewAt2.getLeft()) - iM55559a;
            }
            if (position < position2) {
                right = subTabViewAt2.getRight() + iMeasureText2 + iM55559a;
                width = this.mSubTabContainer.getWidth();
            } else {
                right = subTabViewAt2.getRight() + iMeasureText2 + iM55559a;
                width = this.mSubTabContainer.getWidth() + iMeasureText;
            }
            return right - width;
        }
        return this.mSubTabContainer.getScrollX();
    }

    /* renamed from: a */
    public void m55576a(float f10, final SubTabView subTabView, final SubTabView subTabView2) {
        if (f10 < 0.0f) {
            return;
        }
        ColorStateList subTabColor = subTabView.getSubTabColor();
        ColorStateList subTabColor2 = subTabView2.getSubTabColor();
        if (subTabColor == null || subTabColor2 == null || this.f44296M == null) {
            return;
        }
        int[] iArr = {R.attr.state_selected};
        int defaultColor = subTabColor.getDefaultColor();
        int colorForState = subTabColor.getColorForState(iArr, defaultColor);
        int defaultColor2 = subTabColor2.getDefaultColor();
        int colorForState2 = subTabColor2.getColorForState(iArr, defaultColor2);
        final int iIntValue = ((Integer) this.f44296M.evaluate(f10, Integer.valueOf(colorForState), Integer.valueOf(defaultColor))).intValue();
        final int iIntValue2 = ((Integer) this.f44296M.evaluate(f10, Integer.valueOf(defaultColor2), Integer.valueOf(colorForState2))).intValue();
        post(new Runnable() { // from class: com.huawei.uikit.hwsubtab.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                HwSubTabWidget.m55582a(subTabView, iIntValue, subTabView2, iIntValue2);
            }
        });
    }

    /* renamed from: a */
    public static /* synthetic */ void m55582a(SubTabView subTabView, int i10, SubTabView subTabView2, int i11) {
        subTabView.setTextColor(i10);
        subTabView2.setTextColor(i11);
    }

    /* renamed from: a */
    public /* synthetic */ void m55581a(SubTabView subTabView, float f10, SubTabView subTabView2) {
        subTabView.setTextSize(0, this.f44301b - f10);
        subTabView2.setTextSize(0, this.f44318s + f10);
    }

    /* renamed from: a */
    private void m55575a() {
        int adjustTriggerWidth = getAdjustTriggerWidth();
        int measuredWidth = this.f44303d.getMeasuredWidth();
        int childCount = this.f44303d.getChildCount();
        if (measuredWidth >= adjustTriggerWidth || childCount <= 0) {
            return;
        }
        int i10 = childCount - 1;
        int i11 = this.f44314o;
        int i12 = (adjustTriggerWidth - ((i11 + i11) * i10)) / childCount;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = this.f44303d.getChildAt(i13);
            if (childAt == null || childAt.getMeasuredWidth() > i12) {
                return;
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = this.f44303d.getChildAt(i14);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int paddingLeft = childAt2.getPaddingLeft();
            if (measuredWidth2 < i12) {
                int i15 = ((i12 - measuredWidth2) / 2) + paddingLeft;
                childAt2.setPadding(i15, 0, i15, 0);
            }
            ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                if (i14 == i10) {
                    int i16 = this.f44314o;
                    layoutParams2.width = adjustTriggerWidth - (((i16 + i16) + i12) * i10);
                } else {
                    layoutParams2.width = i12;
                }
            }
        }
    }
}
