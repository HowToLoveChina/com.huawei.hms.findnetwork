package com.huawei.uikit.hwspinner.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
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
import androidx.appcompat.view.menu.InterfaceC0417n;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hwspinner.C8734R;

/* loaded from: classes5.dex */
public class HwListPopupWindow implements InterfaceC0417n {
    public static final int INPUT_METHOD_NOT_NEEDED = 2;

    /* renamed from: K */
    private static final String f44123K = "HwListPopupWindow";

    /* renamed from: L */
    private static final int f44124L = 250;

    /* renamed from: M */
    private static final int f44125M = -1;
    public static final int MATCH_PARENT = -1;

    /* renamed from: N */
    private static final int f44126N = 2;

    /* renamed from: O */
    private static final float f44127O = -1.0f;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: A */
    private final Handler f44128A;

    /* renamed from: B */
    private final Rect f44129B;

    /* renamed from: C */
    private boolean f44130C;

    /* renamed from: D */
    private boolean f44131D;

    /* renamed from: E */
    private int f44132E;

    /* renamed from: F */
    private int f44133F;

    /* renamed from: G */
    private int f44134G;

    /* renamed from: H */
    private Rect f44135H;

    /* renamed from: I */
    private boolean f44136I;

    /* renamed from: J */
    private PopupWindow f44137J;

    /* renamed from: a */
    private Context f44138a;

    /* renamed from: b */
    private ListAdapter f44139b;

    /* renamed from: c */
    private HwDropDownListView f44140c;

    /* renamed from: d */
    private int f44141d;

    /* renamed from: e */
    private int f44142e;

    /* renamed from: f */
    private int f44143f;

    /* renamed from: g */
    private int f44144g;

    /* renamed from: h */
    private int f44145h;

    /* renamed from: i */
    private boolean f44146i;

    /* renamed from: j */
    private boolean f44147j;

    /* renamed from: k */
    private boolean f44148k;

    /* renamed from: l */
    private int f44149l;

    /* renamed from: m */
    private boolean f44150m;

    /* renamed from: n */
    private boolean f44151n;

    /* renamed from: o */
    private int f44152o;

    /* renamed from: p */
    private View f44153p;

    /* renamed from: q */
    private int f44154q;

    /* renamed from: r */
    private DataSetObserver f44155r;

    /* renamed from: s */
    private View f44156s;

    /* renamed from: t */
    private Drawable f44157t;

    /* renamed from: u */
    private AdapterView.OnItemClickListener f44158u;

    /* renamed from: v */
    private final bxac f44159v;

    /* renamed from: w */
    private final brnby f44160w;

    /* renamed from: x */
    private final blfhz f44161x;

    /* renamed from: y */
    private final akxao f44162y;

    /* renamed from: z */
    private Runnable f44163z;

    public class aauaf implements Runnable {
        public aauaf() {
        }

        @Override // java.lang.Runnable
        public void run() throws NoSuchMethodException, SecurityException {
            View anchorView = HwListPopupWindow.this.getAnchorView();
            if (anchorView == null || anchorView.getWindowToken() == null) {
                return;
            }
            HwListPopupWindow.this.show();
        }
    }

    public class akxao implements Runnable {
        private akxao() {
        }

        @Override // java.lang.Runnable
        public void run() throws NoSuchMethodException, SecurityException {
            HwListPopupWindow.this.clearListSelection();
        }

        public /* synthetic */ akxao(HwListPopupWindow hwListPopupWindow, bzrwd bzrwdVar) {
            this();
        }
    }

    public class avpbg extends DataSetObserver {
        private avpbg() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws NoSuchMethodException, SecurityException {
            if (HwListPopupWindow.this.isShowing()) {
                HwListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            HwListPopupWindow.this.dismiss();
        }

        public /* synthetic */ avpbg(HwListPopupWindow hwListPopupWindow, bzrwd bzrwdVar) {
            this();
        }
    }

    public class blfhz implements AbsListView.OnScrollListener {
        private blfhz() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) throws NoSuchMethodException, SecurityException {
            if (i10 == 1 && HwListPopupWindow.this.isInputMethodNeeded() && HwListPopupWindow.this.f44137J.getContentView() != null) {
                HwListPopupWindow.this.f44128A.removeCallbacks(HwListPopupWindow.this.f44159v);
                HwListPopupWindow.this.f44159v.run();
            }
        }

        public /* synthetic */ blfhz(HwListPopupWindow hwListPopupWindow, bzrwd bzrwdVar) {
            this();
        }
    }

    public class bqmxo implements AdapterView.OnItemSelectedListener {
        public bqmxo() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            HwDropDownListView hwDropDownListView;
            if (i10 == -1 || (hwDropDownListView = HwListPopupWindow.this.f44140c) == null) {
                return;
            }
            hwDropDownListView.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public class brnby implements View.OnTouchListener {
        private brnby() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view == null || motionEvent == null) {
                Log.w(HwListPopupWindow.f44123K, "setOnTouchListener: onTouch: view or event is null");
                return false;
            }
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            boolean z10 = action == 0 && HwListPopupWindow.this.f44137J != null && HwListPopupWindow.this.f44137J.isShowing();
            boolean z11 = x10 >= 0 && x10 < HwListPopupWindow.this.f44137J.getWidth() && y10 >= 0 && y10 < HwListPopupWindow.this.f44137J.getHeight();
            if (z10 && z11) {
                HwListPopupWindow.this.f44128A.postDelayed(HwListPopupWindow.this.f44159v, 250L);
            }
            if (action == 1) {
                HwListPopupWindow.this.f44128A.removeCallbacks(HwListPopupWindow.this.f44159v);
            }
            return false;
        }

        public /* synthetic */ brnby(HwListPopupWindow hwListPopupWindow, bzrwd bzrwdVar) {
            this();
        }
    }

    public class bxac implements Runnable {
        private bxac() {
        }

        @Override // java.lang.Runnable
        public void run() throws NoSuchMethodException, SecurityException {
            if (((HwListPopupWindow.this.f44140c != null && HwListPopupWindow.this.f44140c.isAttachedToWindow()) & (HwListPopupWindow.this.f44140c.getCount() > HwListPopupWindow.this.f44140c.getChildCount())) && (HwListPopupWindow.this.f44140c.getChildCount() <= HwListPopupWindow.this.f44152o)) {
                HwListPopupWindow.this.f44137J.setInputMethodMode(2);
                HwListPopupWindow.this.show();
            }
        }

        public /* synthetic */ bxac(HwListPopupWindow hwListPopupWindow, bzrwd bzrwdVar) {
            this();
        }
    }

    public class bzrwd extends HwForwardingListener {
        public bzrwd(View view) {
            super(view);
        }

        @Override // com.huawei.uikit.hwspinner.widget.HwForwardingListener
        public InterfaceC0417n getPopup() {
            return HwListPopupWindow.this;
        }
    }

    public HwListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle, 0);
    }

    /* renamed from: a */
    private static boolean m55502a(int i10) {
        return i10 == 23 || i10 == 62 || i10 == 66 || i10 == 160;
    }

    /* renamed from: f */
    private int m55515f() {
        int i10;
        int i11 = this.f44142e;
        if (i11 >= 0) {
            i10 = Integer.MIN_VALUE;
        } else {
            i11 = 0;
            i10 = 0;
        }
        return View.MeasureSpec.makeMeasureSpec(i11, i10);
    }

    /* renamed from: g */
    private void m55516g() {
        View view = this.f44153p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f44153p);
            }
        }
    }

    /* renamed from: h */
    private void m55517h() throws NoSuchMethodException, SecurityException {
        float measuredHeight;
        View view;
        if (this.f44137J == null) {
            return;
        }
        Class cls = Boolean.TYPE;
        HwReflectUtil.callMethod(this.f44137J, "setShadowEnabled", new Class[]{cls}, new Object[]{Boolean.valueOf(this.f44130C)}, PopupWindow.class);
        if (this.f44130C) {
            Class cls2 = Integer.TYPE;
            HwReflectUtil.callMethod(this.f44137J, "setShadowStyle", new Class[]{cls2}, new Object[]{Integer.valueOf(this.f44132E)}, PopupWindow.class);
            HwReflectUtil.callMethod(this.f44137J, "setShadowSize", new Class[]{cls2}, new Object[]{Integer.valueOf(this.f44133F)}, PopupWindow.class);
            HwReflectUtil.callMethod(this.f44137J, "setShadowColor", new Class[]{cls2}, new Object[]{Integer.valueOf(this.f44134G)}, PopupWindow.class);
            HwReflectUtil.callMethod(this.f44137J, "setShadowClip", new Class[]{cls}, new Object[]{Boolean.valueOf(this.f44131D)}, PopupWindow.class);
            ListAdapter adapter = this.f44140c.getAdapter();
            if (adapter == null || adapter.getCount() <= 0 || (view = adapter.getView(0, null, this.f44140c)) == null) {
                measuredHeight = -1.0f;
            } else {
                view.measure(0, 0);
                measuredHeight = view.getMeasuredHeight() / 2.0f;
            }
            HwReflectUtil.callMethod(this.f44137J, "setShadowViewZ", new Class[]{Float.TYPE}, new Object[]{Float.valueOf(measuredHeight)}, PopupWindow.class);
        }
    }

    public void clearListSelection() throws NoSuchMethodException, SecurityException {
        HwDropDownListView hwDropDownListView = this.f44140c;
        if (hwDropDownListView != null) {
            hwDropDownListView.setListSelectionHidden(true);
            HwReflectUtil.callMethod(hwDropDownListView, "hideSelector", null, null, AbsListView.class);
            hwDropDownListView.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new bzrwd(view);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public void dismiss() {
        this.f44137J.dismiss();
        m55516g();
        this.f44137J.setContentView(null);
        this.f44140c = null;
        this.f44128A.removeCallbacks(this.f44159v);
    }

    public View getAnchorView() {
        return this.f44156s;
    }

    public int getAnimationStyle() {
        return this.f44137J.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.f44137J.getBackground();
    }

    public int getHeight() {
        return this.f44141d;
    }

    public int getHorizontalOffset() {
        return this.f44143f;
    }

    public int getInputMethodMode() {
        return this.f44137J.getInputMethodMode();
    }

    public int getPromptPosition() {
        return this.f44154q;
    }

    public Object getSelectedItem() {
        if (isShowing()) {
            return this.f44140c.getSelectedItem();
        }
        return null;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.f44140c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.f44140c.getSelectedItemPosition();
        }
        return -1;
    }

    public View getSelectedView() {
        if (isShowing()) {
            return this.f44140c.getSelectedView();
        }
        return null;
    }

    public int getSoftInputMode() {
        return this.f44137J.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (this.f44146i) {
            return this.f44144g;
        }
        return 0;
    }

    public int getWidth() {
        return this.f44142e;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.f44150m;
    }

    public boolean isInputMethodNeeded() {
        return this.f44137J.getInputMethodMode() != 2;
    }

    public boolean isModal() {
        return this.f44136I;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public boolean isShowing() {
        return this.f44137J.isShowing();
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) throws NoSuchMethodException, SecurityException {
        if (!isShowing()) {
            return false;
        }
        if ((m55502a(i10) && this.f44140c.getSelectedItemPosition() < 0) || i10 == 62) {
            return false;
        }
        int selectedItemPosition = this.f44140c.getSelectedItemPosition();
        boolean z10 = !this.f44137J.isAboveAnchor();
        ListAdapter listAdapter = this.f44139b;
        int iM55499a = listAdapter != null ? m55499a(listAdapter) : Integer.MAX_VALUE;
        int iM55504b = listAdapter != null ? m55504b(listAdapter) : Integer.MIN_VALUE;
        boolean z11 = z10 && i10 == 19 && selectedItemPosition <= iM55499a;
        boolean z12 = !z10 && i10 == 20 && selectedItemPosition >= iM55504b;
        boolean z13 = !z10 && i10 == 19 && selectedItemPosition == iM55499a;
        if (z11 || z12) {
            clearListSelection();
            this.f44137J.setInputMethodMode(1);
            show();
            return true;
        }
        this.f44140c.setListSelectionHidden(false);
        if (!this.f44140c.onKeyDown(i10, keyEvent)) {
            return (z10 && i10 == 20) ? selectedItemPosition == iM55504b : z13;
        }
        this.f44137J.setInputMethodMode(2);
        this.f44140c.requestFocusFromTouch();
        show();
        return i10 == 19 || i10 == 20 || i10 == 23 || i10 == 66;
    }

    public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
        if (i10 == 4 && isShowing()) {
            View view = this.f44156s;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                return true;
            }
            if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    dismiss();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (!isShowing() || this.f44140c.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean zOnKeyUp = this.f44140c.onKeyUp(i10, keyEvent);
        if (zOnKeyUp && m55502a(i10)) {
            dismiss();
        }
        return zOnKeyUp;
    }

    public boolean performItemClick(int i10) {
        if (!isShowing()) {
            return false;
        }
        if (this.f44158u == null) {
            return true;
        }
        HwDropDownListView hwDropDownListView = this.f44140c;
        this.f44158u.onItemClick(hwDropDownListView, hwDropDownListView.getChildAt(i10 - hwDropDownListView.getFirstVisiblePosition()), i10, hwDropDownListView.getAdapter().getItemId(i10));
        return true;
    }

    public void postShow() {
        this.f44128A.post(this.f44163z);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.f44155r == null) {
            this.f44155r = new avpbg(this, null);
        }
        ListAdapter listAdapter2 = this.f44139b;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.f44155r);
        }
        this.f44139b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f44155r);
        }
        HwDropDownListView hwDropDownListView = this.f44140c;
        if (hwDropDownListView != null) {
            hwDropDownListView.setAdapter(this.f44139b);
        }
    }

    public void setAnchorView(View view) {
        this.f44156s = view;
    }

    public void setAnimationStyle(int i10) {
        this.f44137J.setAnimationStyle(i10);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f44137J.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i10) {
        Drawable background = this.f44137J.getBackground();
        if (background == null) {
            setWidth(i10);
            return;
        }
        background.getPadding(this.f44129B);
        Rect rect = this.f44129B;
        this.f44142e = rect.left + rect.right + i10;
    }

    public void setDropDownAlwaysVisible(boolean z10) {
        this.f44150m = z10;
    }

    public void setDropDownGravity(int i10) {
        this.f44149l = i10;
    }

    public void setEpicenterBounds(Rect rect) {
        this.f44135H = rect;
    }

    public void setForceIgnoreOutsideTouch(boolean z10) {
        this.f44151n = z10;
    }

    public void setHeight(int i10) {
        if (i10 < 0 && i10 != -2 && i10 != -1) {
            if (this.f44138a.getApplicationInfo().targetSdkVersion >= 26) {
                Log.w(f44123K, "Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
                return;
            }
            Log.w(f44123K, "Negative value height passed to HwListPopupWindow#setHeight produces undefined results");
        }
        this.f44141d = i10;
    }

    public void setHorizontalOffset(int i10) {
        this.f44143f = i10;
    }

    public void setInputMethodMode(int i10) {
        this.f44137J.setInputMethodMode(i10);
    }

    public void setListSelector(Drawable drawable) {
        this.f44157t = drawable;
    }

    public void setListShadowClip(boolean z10) {
        this.f44131D = z10;
    }

    public void setListShadowColor(int i10) {
        this.f44134G = i10;
    }

    public void setListShadowEnabled(boolean z10) {
        this.f44130C = z10;
    }

    public void setListShadowSize(int i10) {
        this.f44133F = i10;
    }

    public void setListShadowStyle(int i10) {
        this.f44132E = i10;
    }

    public void setModal(boolean z10) {
        this.f44136I = z10;
        this.f44137J.setFocusable(z10);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f44137J.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f44158u = onItemClickListener;
    }

    public void setOverlapAnchor(boolean z10) {
        this.f44148k = true;
        this.f44147j = z10;
    }

    public void setPromptPosition(int i10) {
        this.f44154q = i10;
    }

    public void setPromptView(View view) throws NoSuchMethodException, SecurityException {
        boolean zIsShowing = isShowing();
        if (zIsShowing) {
            m55516g();
        }
        this.f44153p = view;
        if (zIsShowing) {
            show();
        }
    }

    public void setSelection(int i10) {
        HwDropDownListView hwDropDownListView = this.f44140c;
        if (!isShowing() || hwDropDownListView == null) {
            return;
        }
        hwDropDownListView.setListSelectionHidden(false);
        hwDropDownListView.setSelection(i10);
        if (hwDropDownListView.getChoiceMode() != 0) {
            hwDropDownListView.setItemChecked(i10, true);
        }
    }

    public void setSoftInputMode(int i10) {
        this.f44137J.setSoftInputMode(i10);
    }

    public void setVerticalOffset(int i10) {
        this.f44144g = i10;
        this.f44146i = true;
    }

    public void setWidth(int i10) {
        this.f44142e = i10;
    }

    public void setWindowLayoutType(int i10) {
        this.f44145h = i10;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public void show() throws NoSuchMethodException, SecurityException {
        int iM55503b = m55503b();
        boolean zIsInputMethodNeeded = isInputMethodNeeded();
        HwReflectUtil.callMethod(this.f44137J, "setAllowScrollingAnchorParent", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(zIsInputMethodNeeded)}, PopupWindow.class);
        this.f44137J.setWindowLayoutType(this.f44145h);
        m55517h();
        if (this.f44137J.isShowing()) {
            m55501a(zIsInputMethodNeeded, iM55503b);
        } else if (getAnchorView() != null) {
            m55509c(iM55503b);
        }
    }

    public HwListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle, 0);
    }

    /* renamed from: c */
    private void m55509c(int i10) throws NoSuchMethodException, SecurityException {
        int width = this.f44142e;
        if (width == -1) {
            width = -1;
        } else if (width == -2) {
            width = getAnchorView().getWidth();
        }
        int i11 = this.f44141d;
        if (i11 == -1) {
            i10 = -1;
        } else if (i11 != -2) {
            i10 = i11;
        }
        this.f44137J.setWidth(width);
        this.f44137J.setHeight(i10);
        HwReflectUtil.callMethod(this.f44137J, "setClipToScreenEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE}, PopupWindow.class);
        this.f44137J.setOutsideTouchable((this.f44151n || this.f44150m) ? false : true);
        this.f44137J.setTouchInterceptor(this.f44160w);
        HwReflectUtil.callMethod(this.f44137J, "setEpicenterBounds", new Class[]{Rect.class}, new Object[]{this.f44135H}, PopupWindow.class);
        if (this.f44148k) {
            this.f44137J.setOverlapAnchor(this.f44147j);
        }
        this.f44137J.showAsDropDown(getAnchorView(), this.f44143f, this.f44144g, this.f44149l);
        this.f44140c.setSelection(-1);
        this.f44137J.getContentView().requestFocus(130);
        if (!this.f44136I || this.f44140c.isInTouchMode()) {
            clearListSelection();
        }
        if (this.f44136I) {
            return;
        }
        this.f44128A.post(this.f44162y);
    }

    /* renamed from: d */
    private int m55511d() {
        if (getAnchorView() == null) {
            return 0;
        }
        int maxAvailableHeight = this.f44137J.getMaxAvailableHeight(getAnchorView(), this.f44144g, this.f44137J.getInputMethodMode() == 2);
        return (m55510c(this.f44138a) && this.f44154q == 0) ? maxAvailableHeight - m55497a(this.f44138a) : maxAvailableHeight;
    }

    /* renamed from: e */
    private int m55513e() {
        Drawable background = this.f44137J.getBackground();
        if (background == null) {
            this.f44129B.setEmpty();
            return 0;
        }
        background.getPadding(this.f44129B);
        Rect rect = this.f44129B;
        int i10 = rect.top;
        int i11 = rect.bottom + i10;
        if (this.f44146i) {
            return i11;
        }
        this.f44144g = -i10;
        return i11;
    }

    /* renamed from: b */
    public void m55519b(int i10) {
        this.f44152o = i10;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0417n
    public HwDropDownListView getListView() {
        return this.f44140c;
    }

    public HwListPopupWindow(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    /* renamed from: a */
    private void m55501a(boolean z10, int i10) {
        if (getAnchorView() == null || !getAnchorView().isAttachedToWindow()) {
            return;
        }
        int width = this.f44142e;
        if (width == -1) {
            width = -1;
        } else if (width == -2) {
            width = getAnchorView().getWidth();
        }
        int i11 = this.f44141d;
        boolean z11 = false;
        if (i11 == -1) {
            if (z10) {
                i10 = -1;
            }
            if (!z10) {
                this.f44137J.setWidth(this.f44142e == -1 ? -1 : 0);
                this.f44137J.setHeight(0);
            } else {
                this.f44137J.setWidth(this.f44142e == -1 ? -1 : 0);
                this.f44137J.setHeight(-1);
            }
        } else if (i11 != -2) {
            i10 = i11;
        }
        PopupWindow popupWindow = this.f44137J;
        if (!this.f44151n && !this.f44150m) {
            z11 = true;
        }
        popupWindow.setOutsideTouchable(z11);
        this.f44137J.update(getAnchorView(), this.f44143f, this.f44144g, width < 0 ? -1 : width, i10 < 0 ? -1 : i10);
        this.f44137J.getContentView().requestFocus(130);
    }

    /* renamed from: b */
    private int m55504b(ListAdapter listAdapter) throws NoSuchMethodException, SecurityException {
        boolean zAreAllItemsEnabled = listAdapter.areAllItemsEnabled();
        Object objCallMethod = HwReflectUtil.callMethod(this.f44140c, "lookForSelectablePosition", new Class[]{Integer.TYPE, Boolean.TYPE}, new Object[]{Integer.valueOf(listAdapter.getCount() - 1), Boolean.FALSE}, ListView.class);
        return zAreAllItemsEnabled ? listAdapter.getCount() - 1 : objCallMethod instanceof Integer ? ((Integer) objCallMethod).intValue() : 0;
    }

    public HwListPopupWindow(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        this.f44141d = -2;
        this.f44142e = -2;
        this.f44145h = 1002;
        this.f44146i = false;
        this.f44147j = false;
        this.f44148k = false;
        this.f44149l = 0;
        this.f44150m = false;
        this.f44151n = false;
        this.f44152o = Integer.MAX_VALUE;
        this.f44154q = 0;
        this.f44159v = new bxac(this, null);
        this.f44160w = new brnby(this, null);
        this.f44161x = new blfhz(this, null);
        this.f44162y = new akxao(this, null);
        this.f44129B = new Rect();
        this.f44136I = false;
        this.f44138a = context;
        this.f44128A = new Handler(context.getMainLooper());
        this.f44143f = 0;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(C8734R.dimen.hwspinner_dropdown_vertical_offset);
        this.f44144g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f44146i = true;
        }
        PopupWindow popupWindow = new PopupWindow(context, attributeSet, i10, i11);
        this.f44137J = popupWindow;
        popupWindow.setInputMethodMode(1);
    }

    /* renamed from: b */
    private int m55503b() {
        int iM55498a;
        if (this.f44140c == null) {
            Context context = this.f44138a;
            m55506b(context);
            View view = this.f44140c;
            View view2 = this.f44153p;
            iM55498a = 0;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i10 = this.f44154q;
                if (i10 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i10 == 1) {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                view2.measure(m55515f(), 0);
                iM55498a = m55498a(view2);
                view = linearLayout;
            }
            this.f44137J.setContentView(view);
        } else {
            iM55498a = m55498a(this.f44153p);
        }
        int iM55513e = m55513e();
        int iM55511d = m55511d();
        if (this.f44150m || this.f44141d == -1) {
            return iM55511d + iM55513e;
        }
        int iMeasureHeightOfChildren = this.f44140c.measureHeightOfChildren(m55507c(), iM55511d - iM55498a);
        if (iMeasureHeightOfChildren > 0) {
            iM55498a += iM55513e + this.f44140c.getPaddingTop() + this.f44140c.getPaddingBottom();
        }
        return iMeasureHeightOfChildren + iM55498a;
    }

    /* renamed from: a */
    public HwDropDownListView m55518a(Context context, boolean z10) {
        return new HwDropDownListView(context, z10);
    }

    /* renamed from: a */
    private int m55499a(ListAdapter listAdapter) throws NoSuchMethodException, SecurityException {
        boolean zAreAllItemsEnabled = listAdapter.areAllItemsEnabled();
        Object objCallMethod = HwReflectUtil.callMethod(this.f44140c, "lookForSelectablePosition", new Class[]{Integer.TYPE, Boolean.TYPE}, new Object[]{0, Boolean.TRUE}, ListView.class);
        int iIntValue = objCallMethod instanceof Integer ? ((Integer) objCallMethod).intValue() : 0;
        if (zAreAllItemsEnabled) {
            return 0;
        }
        return iIntValue;
    }

    /* renamed from: c */
    private boolean m55510c(Context context) {
        return context != null && Settings.Global.getInt(context.getContentResolver(), Constants.NAVIGATIONBAR_IS_MIN, 0) == 0;
    }

    /* renamed from: a */
    private int m55498a(View view) {
        int i10 = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            i10 = layoutParams2.topMargin + layoutParams2.bottomMargin;
        }
        return view.getMeasuredHeight() + i10;
    }

    /* renamed from: c */
    private int m55507c() {
        int i10 = this.f44142e;
        if (i10 == -2) {
            int i11 = this.f44138a.getResources().getDisplayMetrics().widthPixels;
            Rect rect = this.f44129B;
            return View.MeasureSpec.makeMeasureSpec(i11 - (rect.left + rect.right), Integer.MIN_VALUE);
        }
        if (i10 != -1) {
            Rect rect2 = this.f44129B;
            return View.MeasureSpec.makeMeasureSpec(i10 - (rect2.left + rect2.right), 1073741824);
        }
        int i12 = this.f44138a.getResources().getDisplayMetrics().widthPixels;
        Rect rect3 = this.f44129B;
        return View.MeasureSpec.makeMeasureSpec(i12 - (rect3.left + rect3.right), 1073741824);
    }

    /* renamed from: a */
    private int m55497a(Context context) {
        if (context == null || context.getResources() == null) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", OsType.ANDROID));
    }

    /* renamed from: b */
    private void m55506b(Context context) {
        this.f44163z = new aauaf();
        this.f44140c = m55518a(context, !this.f44136I);
        this.f44140c.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        Drawable drawable = this.f44157t;
        if (drawable != null) {
            this.f44140c.setSelector(drawable);
        } else {
            this.f44140c.setSelector(C8734R.drawable.hwspinner_list_selector_emui);
        }
        this.f44140c.setAdapter(this.f44139b);
        this.f44140c.setOnItemClickListener(this.f44158u);
        this.f44140c.setFocusable(true);
        this.f44140c.setFocusableInTouchMode(true);
        this.f44140c.setOnItemSelectedListener(new bqmxo());
        this.f44140c.setOnScrollListener(this.f44161x);
    }
}
