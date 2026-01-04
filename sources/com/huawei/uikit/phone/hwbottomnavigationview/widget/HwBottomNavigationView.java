package com.huawei.uikit.phone.hwbottomnavigationview.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import com.huawei.uikit.phone.hwbottomnavigationview.C8753R;
import com.huawei.uikit.phone.hwunifiedinteract.widget.HwKeyEventDetector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class HwBottomNavigationView extends com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView {

    /* renamed from: q */
    private static final int f44928q = -1;

    /* renamed from: r */
    private static final int f44929r = 4;

    /* renamed from: a */
    private PopupWindow f44930a;

    /* renamed from: b */
    private View f44931b;

    /* renamed from: c */
    private TextView f44932c;

    /* renamed from: d */
    private ImageView f44933d;

    /* renamed from: e */
    private View f44934e;

    /* renamed from: f */
    private int f44935f;

    /* renamed from: g */
    private int f44936g;

    /* renamed from: h */
    private int f44937h;

    /* renamed from: i */
    private List<Rect> f44938i;

    /* renamed from: j */
    private Rect f44939j;

    /* renamed from: k */
    private int f44940k;

    /* renamed from: l */
    private int f44941l;

    /* renamed from: m */
    private HwBottomNavigationView.BottomNavigationItemView f44942m;

    /* renamed from: n */
    private Drawable[] f44943n;

    /* renamed from: o */
    private boolean f44944o;

    /* renamed from: p */
    private int f44945p;

    public class aauaf implements ViewTreeObserver.OnPreDrawListener {
        public aauaf() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            HwBottomNavigationView.this.f44934e.getViewTreeObserver().removeOnPreDrawListener(this);
            HwBottomNavigationView.this.f44930a.dismiss();
            if (Float.compare(AuxiliaryHelper.getFontSize(((com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView) HwBottomNavigationView.this).mContext), 3.2f) >= 0) {
                HwBottomNavigationView hwBottomNavigationView = HwBottomNavigationView.this;
                hwBottomNavigationView.setPopupHeight(hwBottomNavigationView.f44935f);
            } else {
                HwBottomNavigationView hwBottomNavigationView2 = HwBottomNavigationView.this;
                hwBottomNavigationView2.setPopupHeight(hwBottomNavigationView2.f44936g);
            }
            HwBottomNavigationView.this.f44930a.showAtLocation(HwBottomNavigationView.this.getRootView(), 17, 0, 0);
            return true;
        }
    }

    public class bzrwd implements Runnable {
        public bzrwd() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwBottomNavigationView.this.f44939j = new Rect(HwBottomNavigationView.this.getLeft(), HwBottomNavigationView.this.getTop(), HwBottomNavigationView.this.getRight(), HwBottomNavigationView.this.getBottom());
            int childCount = HwBottomNavigationView.this.getChildCount();
            HwBottomNavigationView.this.f44938i.clear();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = HwBottomNavigationView.this.getChildAt(i10);
                HwBottomNavigationView.this.f44938i.add(new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()));
            }
            HwBottomNavigationView.this.f44940k = -1;
            HwBottomNavigationView.this.f44941l = -1;
        }
    }

    public HwBottomNavigationView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPopupHeight(int i10) {
        this.f44930a.setHeight(Math.max(this.f44934e.getHeight(), i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            android.content.Context r1 = r7.mContext
            float r1 = com.huawei.uikit.hwresources.utils.AuxiliaryHelper.getFontSize(r1)
            r2 = 1071644672(0x3fe00000, float:1.75)
            int r1 = java.lang.Float.compare(r1, r2)
            r2 = -1
            if (r1 != r2) goto L18
            boolean r7 = super.dispatchTouchEvent(r8)
            return r7
        L18:
            int r1 = r8.getAction()
            r3 = 1
            if (r1 == r3) goto L7b
            r3 = 2
            if (r1 == r3) goto L26
            r2 = 3
            if (r1 == r2) goto L7b
            goto L89
        L26:
            java.util.List<android.graphics.Rect> r1 = r7.f44938i
            if (r1 == 0) goto L76
            boolean r1 = r7.getLongClickEnable()
            if (r1 != 0) goto L31
            goto L76
        L31:
            float r1 = r8.getX()
            float r3 = r8.getY()
        L39:
            java.util.List<android.graphics.Rect> r4 = r7.f44938i
            int r4 = r4.size()
            if (r0 >= r4) goto L72
            java.util.List<android.graphics.Rect> r4 = r7.f44938i
            java.lang.Object r4 = r4.get(r0)
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            int r5 = (int) r1
            int r6 = (int) r3
            boolean r4 = r4.contains(r5, r6)
            if (r4 == 0) goto L53
            r7.f44940k = r0
        L53:
            r7.m55986d()
            int r4 = r7.f44940k
            if (r4 == r2) goto L6f
            int r5 = r7.f44941l
            if (r5 == r4) goto L6f
            android.view.View r4 = r7.getChildAt(r4)
            boolean r5 = r4 instanceof com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView.BottomNavigationItemView
            if (r5 == 0) goto L6a
            r7.m55976a(r4)
            goto L6f
        L6a:
            boolean r7 = super.dispatchTouchEvent(r8)
            return r7
        L6f:
            int r0 = r0 + 1
            goto L39
        L72:
            r7.m55974a(r1, r3)
            goto L89
        L76:
            boolean r7 = super.dispatchTouchEvent(r8)
            return r7
        L7b:
            r7.setLongClickEnable(r0)
            android.widget.PopupWindow r0 = r7.f44930a
            if (r0 == 0) goto L89
            com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView$BottomNavigationItemView r0 = r7.f44942m
            if (r0 == 0) goto L89
            r7.m55990f()
        L89:
            boolean r7 = super.dispatchTouchEvent(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.phone.hwbottomnavigationview.widget.HwBottomNavigationView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public Drawable[] getPopupIconSet() {
        return this.f44943n;
    }

    public boolean isTintPopupEnable() {
        return this.f44944o;
    }

    @Override // com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m55983c();
    }

    @Override // com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView, android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        m55983c();
    }

    public void setPopupIconSet(Drawable[] drawableArr) {
        this.f44943n = drawableArr;
    }

    public void setTintPopupEnable(boolean z10) {
        this.f44944o = z10;
    }

    public HwBottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8753R.attr.hwBottomNavigationViewStyle);
    }

    /* renamed from: d */
    private void m55986d() {
        int i10;
        HwBottomNavigationView.BottomNavigationItemView bottomNavigationItemView;
        int i11 = this.f44940k;
        if (i11 == -1 || (i10 = this.f44941l) == -1 || i11 != i10 || this.f44930a != null || (bottomNavigationItemView = this.f44942m) == null) {
            return;
        }
        bottomNavigationItemView.setPressed(true);
        m55981b();
    }

    /* renamed from: e */
    private void m55988e() {
        if (!AuxiliaryHelper.isPortrait(this.mContext) || AuxiliaryHelper.isMultiWindowActivity(this.mContext)) {
            this.f44932c.setSingleLine();
        } else {
            this.f44932c.setMaxLines(4);
        }
        this.f44934e.getViewTreeObserver().addOnPreDrawListener(new aauaf());
    }

    /* renamed from: f */
    private void m55990f() {
        this.f44942m.setPressed(false);
        this.f44942m.performClick();
        this.f44930a.dismiss();
        this.f44930a = null;
        this.f44932c = null;
        this.f44933d = null;
        this.f44934e = null;
    }

    @Override // com.huawei.uikit.hwbottomnavigationview.widget.HwBottomNavigationView
    public HwKeyEventDetector createKeyEventDetector() {
        return new HwKeyEventDetector(getContext());
    }

    public HwBottomNavigationView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f44940k = -1;
        this.f44941l = -1;
        m55973a();
    }

    /* renamed from: b */
    private void m55981b() {
        Drawable originalDrawable;
        Drawable.ConstantState constantState;
        Drawable[] popupIconSet = getPopupIconSet();
        if (popupIconSet == null) {
            originalDrawable = this.f44942m.getOriginalDrawable();
        } else {
            int length = popupIconSet.length;
            int i10 = this.f44940k;
            if (i10 <= -1 || i10 >= length || (originalDrawable = popupIconSet[i10]) == null) {
                originalDrawable = this.f44942m.getOriginalDrawable();
            }
        }
        if (originalDrawable == null || (constantState = originalDrawable.getConstantState()) == null) {
            return;
        }
        Drawable drawableNewDrawable = constantState.newDrawable();
        if (this.f44942m.isEnabled()) {
            HwBottomNavigationView.BottomNavigationItemView bottomNavigationItemView = this.f44942m;
            m55978a(bottomNavigationItemView, bottomNavigationItemView.getContent().getText().toString(), drawableNewDrawable);
        }
    }

    /* renamed from: c */
    private void m55983c() {
        post(new bzrwd());
    }

    /* renamed from: a */
    private void m55973a() {
        this.f44936g = getResources().getDimensionPixelSize(C8753R.dimen.auxiliary_height_normal);
        this.f44935f = getResources().getDimensionPixelSize(C8753R.dimen.auxiliary_height_large);
        this.f44945p = ContextCompat.getColor(this.mContext, C8753R.color.emui_primary_inverse);
        this.f44944o = true;
        this.f44938i = new ArrayList();
        m55983c();
    }

    /* renamed from: a */
    private void m55976a(View view) {
        HwBottomNavigationView.BottomNavigationItemView bottomNavigationItemView = this.f44942m;
        if (bottomNavigationItemView != null) {
            bottomNavigationItemView.setPressed(false);
            PopupWindow popupWindow = this.f44930a;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f44930a = null;
            }
        }
        HwBottomNavigationView.BottomNavigationItemView bottomNavigationItemView2 = (HwBottomNavigationView.BottomNavigationItemView) view;
        this.f44942m = bottomNavigationItemView2;
        if (this.f44930a == null) {
            bottomNavigationItemView2.setPressed(true);
            m55981b();
            this.f44941l = this.f44940k;
        }
    }

    /* renamed from: a */
    private void m55974a(float f10, float f11) {
        if (AuxiliaryHelper.pointInView(this.f44939j, f10, f11)) {
            return;
        }
        setLongClickEnable(false);
        HwBottomNavigationView.BottomNavigationItemView bottomNavigationItemView = this.f44942m;
        if (bottomNavigationItemView != null) {
            bottomNavigationItemView.setPressed(false);
        }
        PopupWindow popupWindow = this.f44930a;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f44930a = null;
            this.f44932c = null;
            this.f44933d = null;
            this.f44934e = null;
        }
    }

    /* renamed from: a */
    private void m55978a(HwBottomNavigationView.BottomNavigationItemView bottomNavigationItemView, String str, Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (Float.compare(AuxiliaryHelper.getFontSize(this.mContext), 3.2f) >= 0) {
            this.f44937h = this.f44935f;
        } else {
            this.f44937h = this.f44936g;
        }
        if (this.f44930a == null) {
            View viewInflate = LayoutInflater.from(this.mContext).inflate(C8753R.layout.hwbottomnavigationview_auxiliary_popup_layout, (ViewGroup) null, false);
            this.f44931b = viewInflate;
            this.f44932c = (TextView) viewInflate.findViewById(C8753R.id.popup_window_text_view);
            this.f44933d = (ImageView) this.f44931b.findViewById(C8753R.id.popup_window_image_view);
            this.f44934e = this.f44931b.findViewById(C8753R.id.popup_window_content);
            if (this.f44933d != null && this.f44932c != null) {
                m55975a(drawable);
                if (str != null) {
                    m55977a(bottomNavigationItemView, str);
                }
            }
            this.f44930a = new PopupWindow(this.f44931b, this.f44937h, -2);
            m55988e();
            this.f44930a.showAtLocation(getRootView(), 17, 0, 0);
        }
    }

    /* renamed from: a */
    private void m55975a(Drawable drawable) {
        if (isTintPopupEnable()) {
            drawable.setTint(this.f44945p);
        }
        this.f44933d.setImageDrawable(drawable);
    }

    /* renamed from: a */
    private void m55977a(HwBottomNavigationView.BottomNavigationItemView bottomNavigationItemView, String str) {
        if (bottomNavigationItemView.isSingleImageMode()) {
            this.f44932c.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.f44933d.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(15);
                this.f44934e.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        this.f44932c.setText(str);
        this.f44932c.setVisibility(0);
    }
}
