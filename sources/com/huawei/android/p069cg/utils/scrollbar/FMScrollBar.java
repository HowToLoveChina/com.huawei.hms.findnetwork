package com.huawei.android.p069cg.utils.scrollbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.GridView;
import android.widget.ListView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.R$style;
import com.huawei.android.p069cg.R$styleable;
import com.huawei.android.p069cg.p071ui.EmptyLoadRecyclerMediaAdapter;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import p031b7.C1120a;
import p049c7.C1389a;
import p049c7.C1390b;
import p049c7.C1393e;
import p049c7.InterfaceC1391c;
import p514o9.C11839m;
import p757x.C13669a;

/* loaded from: classes2.dex */
public class FMScrollBar extends View {

    /* renamed from: K */
    public static final InterfaceC1391c f11382K = new C1393e();

    /* renamed from: A */
    public ValueAnimator f11383A;

    /* renamed from: B */
    public C2383c f11384B;

    /* renamed from: C */
    public C2384d f11385C;

    /* renamed from: D */
    public String f11386D;

    /* renamed from: E */
    public Runnable f11387E;

    /* renamed from: F */
    public int[] f11388F;

    /* renamed from: G */
    public int f11389G;

    /* renamed from: H */
    public int f11390H;

    /* renamed from: I */
    public int f11391I;

    /* renamed from: J */
    public Handler f11392J;

    /* renamed from: a */
    public boolean f11393a;

    /* renamed from: b */
    public boolean f11394b;

    /* renamed from: c */
    public int f11395c;

    /* renamed from: d */
    public Rect f11396d;

    /* renamed from: e */
    public Rect f11397e;

    /* renamed from: f */
    public int f11398f;

    /* renamed from: g */
    public int f11399g;

    /* renamed from: h */
    public int f11400h;

    /* renamed from: i */
    public int f11401i;

    /* renamed from: j */
    public Drawable f11402j;

    /* renamed from: k */
    public Drawable f11403k;

    /* renamed from: l */
    public boolean f11404l;

    /* renamed from: m */
    public int f11405m;

    /* renamed from: n */
    public boolean f11406n;

    /* renamed from: o */
    public boolean f11407o;

    /* renamed from: p */
    public View f11408p;

    /* renamed from: q */
    public RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> f11409q;

    /* renamed from: r */
    public InterfaceC2386f f11410r;

    /* renamed from: s */
    public Handler f11411s;

    /* renamed from: t */
    public RunnableC2385e f11412t;

    /* renamed from: u */
    public View.OnTouchListener f11413u;

    /* renamed from: v */
    public int f11414v;

    /* renamed from: w */
    public int f11415w;

    /* renamed from: x */
    public int f11416x;

    /* renamed from: y */
    public int f11417y;

    /* renamed from: z */
    public ValueAnimator f11418z;

    /* renamed from: com.huawei.android.cg.utils.scrollbar.FMScrollBar$a */
    public class RunnableC2381a implements Runnable {
        public RunnableC2381a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FMScrollBar.this.f11409q != null) {
                if (!(FMScrollBar.this.f11409q instanceof EmptyLoadRecyclerMediaAdapter)) {
                    FMScrollBar.this.f11409q.m5213j();
                    return;
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 1044;
                FMScrollBar.this.f11392J.sendMessage(messageObtain);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.utils.scrollbar.FMScrollBar$b */
    public class ViewOnTouchListenerC2382b implements View.OnTouchListener {
        public ViewOnTouchListenerC2382b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FMScrollBar.this.f11394b = true;
            if (FMScrollBar.this.m14950v()) {
                return false;
            }
            FMScrollBar.this.m14924C(motionEvent);
            return false;
        }
    }

    /* renamed from: com.huawei.android.cg.utils.scrollbar.FMScrollBar$c */
    public class C2383c implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        public C2383c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FMScrollBar.this.f11390H = 2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FMScrollBar.this.f11390H = 3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FMScrollBar.this.m14932K(valueAnimator, true);
        }

        public /* synthetic */ C2383c(FMScrollBar fMScrollBar, RunnableC2381a runnableC2381a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.cg.utils.scrollbar.FMScrollBar$d */
    public class C2384d implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        public C2384d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FMScrollBar.this.f11390H = 1;
            FMScrollBar.this.f11398f = 0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FMScrollBar.this.f11390H = 4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FMScrollBar.this.m14932K(valueAnimator, false);
        }

        public /* synthetic */ C2384d(FMScrollBar fMScrollBar, RunnableC2381a runnableC2381a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.cg.utils.scrollbar.FMScrollBar$e */
    public static class RunnableC2385e implements Runnable {

        /* renamed from: a */
        public FMScrollBar f11423a;

        public RunnableC2385e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f11423a.f11383A == null || this.f11423a.f11390H != 2) {
                return;
            }
            this.f11423a.m14926E();
            this.f11423a.f11383A.start();
        }

        public /* synthetic */ RunnableC2385e(RunnableC2381a runnableC2381a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.cg.utils.scrollbar.FMScrollBar$f */
    public interface InterfaceC2386f {
        /* renamed from: a */
        void mo14956a(int i10, int i11, boolean z10, int i12);
    }

    public FMScrollBar(Context context) {
        this(context, null);
    }

    public static InterfaceC1391c getHwScrollBindImpl() {
        return f11382K;
    }

    private int getScrollViewViewVerticalScrollRange() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod;
        try {
            declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollRange", new Class[0]);
        } catch (NoSuchMethodException unused) {
            Log.w("FMScrollBar", "NoSuchMethodException computeVerticalScrollRange");
            declaredMethod = null;
        }
        if (declaredMethod == null) {
            return -1;
        }
        try {
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(this.f11408p, new Object[0]);
            if (objInvoke == null || !(objInvoke instanceof Integer)) {
                return -1;
            }
            return ((Integer) objInvoke).intValue();
        } catch (IllegalAccessException unused2) {
            Log.w("FMScrollBar", "IllegalAccessException computeVerticalScrollRange");
            return -1;
        } catch (InvocationTargetException unused3) {
            Log.w("FMScrollBar", "InvocationTargetException computeVerticalScrollRange");
            return -1;
        }
    }

    private int getScrollableViewVerticalScrollExtent() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod;
        try {
            declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", new Class[0]);
        } catch (NoSuchMethodException unused) {
            Log.w("FMScrollBar", "NoSuchMethodException computeVerticalScrollExtent ");
            declaredMethod = null;
        }
        if (declaredMethod == null) {
            return -1;
        }
        try {
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(this.f11408p, new Object[0]);
            if (objInvoke == null || !(objInvoke instanceof Integer)) {
                return -1;
            }
            return ((Integer) objInvoke).intValue();
        } catch (IllegalAccessException unused2) {
            Log.w("FMScrollBar", "IllegalAccessException computeVerticalScrollExtent");
            return -1;
        } catch (InvocationTargetException unused3) {
            Log.w("FMScrollBar", "InvocationTargetException computeVerticalScrollExtent");
            return -1;
        }
    }

    private int getScrollableViewVerticalScrollOffset() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod;
        try {
            declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollOffset", new Class[0]);
        } catch (NoSuchMethodException unused) {
            Log.w("FMScrollBar", "NoSuchMethodException computeVerticalScrollOffset");
            declaredMethod = null;
        }
        if (declaredMethod == null) {
            return -1;
        }
        try {
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(this.f11408p, new Object[0]);
            if (objInvoke == null || !(objInvoke instanceof Integer)) {
                return -1;
            }
            return ((Integer) objInvoke).intValue();
        } catch (IllegalAccessException unused2) {
            Log.w("FMScrollBar", "IllegalAccessException computeVerticalScrollOffset");
            return -1;
        } catch (InvocationTargetException unused3) {
            Log.w("FMScrollBar", "InvocationTargetException computeVerticalScrollOffset");
            return -1;
        }
    }

    /* renamed from: A */
    public void m14922A() {
        View view = this.f11408p;
        if ((view instanceof HwRecyclerView) && (((HwRecyclerView) view).getLayoutManager() instanceof GridLayoutManager)) {
            this.f11409q = ((HwRecyclerView) this.f11408p).getAdapter();
        }
    }

    /* renamed from: B */
    public final void m14923B(int i10) {
        Drawable drawable = this.f11402j;
        if (drawable != null) {
            C13669a.m82226g(drawable, i10);
        }
        Drawable drawable2 = this.f11403k;
        if (drawable2 != null) {
            C13669a.m82226g(drawable2, i10);
        }
    }

    /* renamed from: C */
    public final void m14924C(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int y10 = (int) motionEvent.getY();
        if (action == 0) {
            this.f11400h = y10;
            return;
        }
        if (action != 1) {
            if (action == 2) {
                if (this.f11400h != y10) {
                    this.f11405m = 2;
                    m14929H();
                    return;
                }
                return;
            }
            if (action != 3) {
                return;
            }
        }
        this.f11405m = 0;
        m14953y();
    }

    /* renamed from: D */
    public void m14925D(int i10) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = i10;
        message.obj = this.f11386D;
        this.f11392J.sendMessage(message);
    }

    /* renamed from: E */
    public void m14926E() {
        Message message = new Message();
        message.what = 3;
        this.f11392J.sendMessage(message);
    }

    /* renamed from: F */
    public void m14927F() {
        Message message = new Message();
        message.what = 2;
        this.f11386D = "";
        this.f11392J.sendMessage(message);
    }

    /* renamed from: G */
    public void m14928G(View view, boolean z10) {
        if (this.f11408p == null) {
            this.f11408p = view;
            if (z10) {
                view.setOnTouchListener(this.f11413u);
            }
            view.setVerticalScrollBarEnabled(false);
        }
    }

    /* renamed from: H */
    public final void m14929H() {
        if (m14944p()) {
            int i10 = this.f11390H;
            if (i10 == 2 || i10 == 3) {
                RunnableC2385e runnableC2385e = this.f11412t;
                if (runnableC2385e != null) {
                    this.f11411s.removeCallbacks(runnableC2385e);
                    return;
                }
                return;
            }
            if (!this.f11383A.isRunning()) {
                ValueAnimator valueAnimator = this.f11418z;
                if (valueAnimator != null) {
                    valueAnimator.start();
                    return;
                }
                return;
            }
            if (this.f11384B != null) {
                this.f11383A.cancel();
                int i11 = this.f11417y;
                int i12 = this.f11415w;
                int iRound = Math.round((((i11 - i12) * 1.0f) / (this.f11416x - i12)) * 450.0f);
                ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new C1390b(), new C1389a(this.f11417y, this.f11389G), new C1389a(this.f11415w, this.f11388F[0]));
                valueAnimatorOfObject.setDuration(iRound);
                valueAnimatorOfObject.addListener(this.f11384B);
                valueAnimatorOfObject.addUpdateListener(this.f11384B);
                valueAnimatorOfObject.start();
            }
        }
    }

    /* renamed from: I */
    public final void m14930I(int i10) {
        int i11;
        int paddingTop = getPaddingTop();
        int height = (getHeight() - getPaddingBottom()) - this.f11396d.height();
        int i12 = this.f11396d.top;
        int i13 = i12 + i10;
        if (i13 < paddingTop) {
            i11 = paddingTop - i12;
        } else if (i13 > height) {
            i11 = height - i12;
        } else {
            C1120a.m6677i("FMScrollBar", "thumbScrollBy: do nothing.");
            i11 = i10;
        }
        m14938j(i10 > 0, i10);
        if (i11 != 0) {
            this.f11396d.offset(0, i11);
            postInvalidate();
        }
        m14939k();
        m14925D(i13);
    }

    /* renamed from: J */
    public final void m14931J() {
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f11402j;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f11403k;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    /* renamed from: K */
    public final void m14932K(ValueAnimator valueAnimator, boolean z10) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof C1389a) {
            if (z10) {
                this.f11389G = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                this.f11417y = ((C1389a) animatedValue).m7962b();
            } else {
                C1389a c1389a = (C1389a) animatedValue;
                this.f11389G = c1389a.m7961a();
                this.f11417y = c1389a.m7962b();
            }
            invalidate();
        }
    }

    /* renamed from: L */
    public final void m14933L() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m14937P();
        m14935N();
    }

    /* renamed from: M */
    public final void m14934M() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m14935N();
        postInvalidate();
    }

    /* renamed from: N */
    public final void m14935N() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f11408p != null) {
            int scrollViewViewVerticalScrollRange = getScrollViewViewVerticalScrollRange();
            int scrollableViewVerticalScrollExtent = getScrollableViewVerticalScrollExtent();
            int scrollableViewVerticalScrollOffset = getScrollableViewVerticalScrollOffset();
            if (scrollViewViewVerticalScrollRange > scrollableViewVerticalScrollExtent) {
                m14936O(scrollViewViewVerticalScrollRange, scrollableViewVerticalScrollExtent, scrollableViewVerticalScrollOffset);
            } else {
                this.f11396d.setEmpty();
            }
        }
    }

    /* renamed from: O */
    public final void m14936O(int i10, int i11, int i12) {
        if (i10 >= i11) {
            int iHeight = (this.f11397e.height() * i11) / i10;
            int i13 = this.f11395c;
            if (iHeight < i13) {
                iHeight = i13;
            }
            Drawable drawable = this.f11402j;
            if (drawable != null) {
                iHeight = drawable.getIntrinsicHeight();
            }
            int iHeight2 = this.f11397e.height() - iHeight;
            int i14 = (int) (((iHeight2 * 1.0f) / (i10 - i11)) * i12);
            if (i14 <= iHeight2) {
                iHeight2 = i14;
            }
            m14939k();
            m14925D(iHeight2);
            int paddingTop = getPaddingTop();
            int paddingTop2 = getPaddingTop() + iHeight;
            int paddingLeft = this.f11417y;
            int paddingRight = (this.f11414v + paddingLeft) - getPaddingRight();
            if (m14947s()) {
                paddingLeft = getPaddingLeft();
                paddingRight = this.f11417y;
            }
            this.f11396d.set(paddingLeft, paddingTop, paddingRight, paddingTop2);
            this.f11396d.offset(0, iHeight2);
        }
    }

    /* renamed from: P */
    public final void m14937P() {
        this.f11397e.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m14931J();
    }

    public View getScrollableView() {
        return this.f11408p;
    }

    /* renamed from: j */
    public final void m14938j(boolean z10, int i10) {
        int iHeight = this.f11397e.height() - this.f11396d.height();
        int i11 = this.f11396d.top - this.f11397e.top;
        InterfaceC2386f interfaceC2386f = this.f11410r;
        if (interfaceC2386f != null) {
            interfaceC2386f.mo14956a(iHeight, i11, z10, i10);
        }
    }

    /* renamed from: k */
    public final void m14939k() {
        String strM14762S;
        C1120a.m6675d("FMScrollBar", "start checkAndUpdateScrollDateValue");
        View view = this.f11408p;
        if (view instanceof HwRecyclerView) {
            RecyclerView.AbstractC0846p layoutManager = ((HwRecyclerView) view).getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                int iFindFirstCompletelyVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
                RecyclerView.AbstractC0838h adapter = ((HwRecyclerView) this.f11408p).getAdapter();
                View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iFindFirstCompletelyVisibleItemPosition);
                float f10 = this.f11396d.top;
                float y10 = 0.0f;
                while (viewFindViewByPosition != null && viewFindViewByPosition.getY() < f10) {
                    iFindFirstCompletelyVisibleItemPosition++;
                    y10 = viewFindViewByPosition.getY();
                    viewFindViewByPosition = gridLayoutManager.findViewByPosition(iFindFirstCompletelyVisibleItemPosition);
                }
                int i10 = iFindFirstCompletelyVisibleItemPosition - 1;
                C1120a.m6675d("FMScrollBar", "itemY: " + y10 + " currentItemPosition: " + i10 + " offsetY " + f10);
                if ((adapter instanceof RecyclerMediaAdapter) && (strM14762S = ((RecyclerMediaAdapter) adapter).m14762S(i10)) != null && !strM14762S.isEmpty()) {
                    this.f11386D = strM14762S;
                }
                C1120a.m6675d("FMScrollBar", "date now position of scroll bar: " + this.f11386D);
            }
        }
    }

    /* renamed from: l */
    public final void m14940l(Canvas canvas) {
        boolean zM14947s = m14947s();
        Drawable drawable = this.f11402j;
        Rect rect = this.f11396d;
        if (drawable == null || rect == null) {
            return;
        }
        int i10 = this.f11390H;
        if (i10 == 1) {
            rect.left = this.f11416x;
            rect.right = this.f11417y + this.f11414v;
        } else if (i10 == 2) {
            int i11 = this.f11415w;
            rect.left = i11;
            rect.right = i11 + this.f11414v;
        } else if (i10 == 3 || i10 == 4) {
            int i12 = this.f11417y;
            rect.left = i12;
            rect.right = i12 + this.f11414v;
        }
        drawable.setBounds(rect);
        if (zM14947s) {
            canvas.save();
            canvas.scale(-1.0f, 1.0f, this.f11414v * 0.5f, (rect.top + rect.bottom) * 0.5f);
            int i13 = this.f11390H;
            if (i13 == 3 || i13 == 4) {
                int i14 = this.f11417y;
                rect.right = i14;
                rect.left = i14 - this.f11414v;
            }
        }
        drawable.mutate().setAlpha(this.f11389G);
        drawable.draw(canvas);
        if (zM14947s) {
            canvas.restore();
        }
    }

    /* renamed from: m */
    public final void m14941m(Canvas canvas) {
        Rect rect;
        if (this.f11403k == null || !m14949u() || (rect = this.f11397e) == null) {
            return;
        }
        this.f11403k.setBounds(rect);
        boolean zM14947s = m14947s();
        if (zM14947s) {
            canvas.save();
            canvas.scale(-1.0f, 1.0f, (rect.left + rect.right) * 0.5f, (rect.top + rect.bottom) * 0.5f);
        }
        this.f11403k.draw(canvas);
        if (zM14947s) {
            canvas.restore();
        }
    }

    /* renamed from: n */
    public final void m14942n(Context context) {
        this.f11401i = ViewConfiguration.get(context).getScaledTouchSlop();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        RunnableC2385e runnableC2385e = new RunnableC2385e(null);
        this.f11412t = runnableC2385e;
        runnableC2385e.f11423a = this;
        Drawable drawable = this.f11402j;
        if (drawable != null) {
            this.f11402j = C13669a.m82231l(drawable);
        }
        Drawable drawable2 = this.f11403k;
        if (drawable2 != null) {
            this.f11403k = C13669a.m82231l(drawable2);
        }
        if (isInEditMode()) {
            this.f11396d = new Rect(0, 0, 48, 192);
        }
        Drawable drawable3 = this.f11402j;
        if (drawable3 != null) {
            this.f11414v = drawable3.getIntrinsicWidth();
        }
        this.f11415w = 0;
        this.f11416x = this.f11414v;
        m14943o();
    }

    /* renamed from: o */
    public final void m14943o() {
        if (this.f11418z == null) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new C1390b(), new C1389a(this.f11416x, this.f11388F[1]), new C1389a(this.f11415w, this.f11388F[0]));
            this.f11418z = valueAnimatorOfObject;
            valueAnimatorOfObject.setDuration(450L);
            if (this.f11384B == null) {
                this.f11384B = new C2383c(this, null);
            }
            this.f11418z.addListener(this.f11384B);
            this.f11418z.addUpdateListener(this.f11384B);
        }
        if (this.f11383A == null) {
            ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(new C1390b(), new C1389a(this.f11415w, this.f11388F[0]), new C1389a(this.f11416x, this.f11388F[1]));
            this.f11383A = valueAnimatorOfObject2;
            valueAnimatorOfObject2.setDuration(450L);
            if (this.f11385C == null) {
                this.f11385C = new C2384d(this, null);
            }
            this.f11383A.addListener(this.f11385C);
            this.f11383A.addUpdateListener(this.f11385C);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        m14941m(canvas);
        m14940l(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (z10) {
            m14933L();
        }
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            mode = 0;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), i11);
        if (this.f11402j != null) {
            setMeasuredDimension(this.f11414v, getMeasuredHeight());
            return;
        }
        int measuredWidth = getMeasuredWidth();
        this.f11414v = measuredWidth;
        this.f11416x = measuredWidth;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        m14923B(i10);
        super.onRtlPropertiesChanged(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00a5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.p069cg.utils.scrollbar.FMScrollBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: p */
    public final boolean m14944p() {
        int itemCount;
        View view = this.f11408p;
        if (view == null) {
            C11839m.m70689w("FMScrollBar", "isNeedShow scrollableView is null");
            return false;
        }
        if (this.f11406n) {
            if (this.f11407o) {
                return true;
            }
            C11839m.m70688i("FMScrollBar", "browser not edit state");
            return false;
        }
        if (view instanceof GridView) {
            int childCount = ((GridView) view).getChildCount();
            int count = ((GridView) this.f11408p).getCount();
            int numColumns = ((GridView) this.f11408p).getNumColumns();
            if (this.f11391I == -1) {
                this.f11391I = (int) Math.ceil((childCount * 1.0f) / numColumns);
            }
            itemCount = (int) Math.ceil((count * 1.0f) / numColumns);
        } else if (view instanceof ListView) {
            if (this.f11391I == -1) {
                this.f11391I = ((ListView) view).getChildCount();
            }
            itemCount = ((ListView) this.f11408p).getCount();
        } else if (view instanceof RecyclerView) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) ((RecyclerView) view).getLayoutManager();
            if (this.f11391I == -1) {
                this.f11391I = linearLayoutManager.getChildCount();
            }
            itemCount = linearLayoutManager.getItemCount();
        } else {
            itemCount = 0;
        }
        if (itemCount != 0) {
            return Math.floor((double) ((((float) itemCount) * 1.0f) / ((float) this.f11391I))) >= 0.0d;
        }
        C11839m.m70688i("FMScrollBar", "isNeedShow itemCount 0");
        return false;
    }

    /* renamed from: q */
    public final boolean m14945q() {
        String language = Locale.getDefault().getLanguage();
        boolean z10 = true;
        boolean z11 = language.contains(Constants.AR_CACHE) || language.contains("fa") || language.contains("iw");
        if (!language.contains("ug") && !language.contains(Constants.URDU_LANG)) {
            z10 = false;
        }
        return z11 | z10;
    }

    /* renamed from: r */
    public final boolean m14946r() {
        return this.f11405m != 0;
    }

    /* renamed from: s */
    public final boolean m14947s() {
        return getLayoutDirection() == 1 || m14945q();
    }

    public void setBrowserEdit(boolean z10) {
        this.f11407o = z10;
    }

    public void setFromBrowser(boolean z10) {
        this.f11406n = z10;
    }

    public void setHandler(Handler handler) {
        this.f11392J = handler;
    }

    public void setOnTouchOffsetListener(InterfaceC2386f interfaceC2386f) {
        this.f11410r = interfaceC2386f;
    }

    /* renamed from: t */
    public final boolean m14948t() {
        return this.f11412t != null && this.f11390H == 1;
    }

    /* renamed from: u */
    public final boolean m14949u() {
        return this.f11390H == 2;
    }

    /* renamed from: v */
    public boolean m14950v() {
        return this.f11398f != 0;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f11402j || drawable == this.f11403k || super.verifyDrawable(drawable);
    }

    /* renamed from: w */
    public final boolean m14951w(int i10, int i11) {
        if (!this.f11404l) {
            return false;
        }
        Rect rect = new Rect(this.f11396d);
        rect.left = 0;
        rect.right = getWidth();
        return rect.contains(i10, i11);
    }

    /* renamed from: x */
    public void m14952x(View view, int i10, int i11, int i12, int i13) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (m14950v()) {
            return;
        }
        if (!m14946r()) {
            if (this.f11393a) {
                this.f11393a = false;
            } else if (this.f11394b) {
                m14953y();
                this.f11394b = false;
            }
        }
        m14934M();
    }

    /* renamed from: y */
    public final void m14953y() {
        m14954z(2000);
    }

    /* renamed from: z */
    public final void m14954z(int i10) {
        this.f11411s.removeCallbacks(this.f11412t);
        this.f11411s.postDelayed(this.f11412t, i10);
    }

    public FMScrollBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FMScrollBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11386D = "";
        this.f11387E = new RunnableC2381a();
        this.f11388F = new int[]{HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA, 0};
        this.f11390H = 1;
        this.f11391I = -1;
        this.f11393a = true;
        this.f11396d = new Rect();
        this.f11397e = new Rect();
        this.f11398f = 0;
        this.f11404l = true;
        this.f11405m = 0;
        this.f11411s = new Handler();
        this.f11413u = new ViewOnTouchListenerC2382b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FMScrollBar, i10, R$style.Widget_Emui_HwScrollbarView);
        this.f11402j = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FMScrollBar_hwScrollThumb);
        this.f11403k = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FMScrollBar_hwScrollTrack);
        this.f11395c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FMScrollBar_hwMinThumbHeight, 48);
        typedArrayObtainStyledAttributes.recycle();
        m14942n(context);
    }
}
