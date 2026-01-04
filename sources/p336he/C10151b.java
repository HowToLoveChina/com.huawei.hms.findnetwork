package p336he;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12809f;

/* renamed from: he.b */
/* loaded from: classes3.dex */
public class C10151b {

    /* renamed from: a */
    public View f49454a;

    /* renamed from: b */
    public int f49455b;

    /* renamed from: c */
    public int f49456c;

    /* renamed from: d */
    public int f49457d;

    /* renamed from: e */
    public boolean f49458e;

    /* renamed from: f */
    public Activity f49459f;

    /* renamed from: g */
    public FrameLayout.LayoutParams f49460g;

    /* renamed from: he.b$a */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            C10151b.this.m63216c();
        }
    }

    public C10151b(Activity activity, int i10) {
        if (activity == null) {
            return;
        }
        this.f49459f = activity;
        this.f49458e = C12806c.m76815f(activity);
        this.f49456c = C10150a.m63211a(activity);
        int iM76835h = C12809f.m76835h(activity);
        Configuration configuration = activity.getResources().getConfiguration();
        int i11 = configuration.screenWidthDp;
        int i12 = configuration.screenHeightDp;
        this.f49457d = (int) C11842p.m70844o(activity, i11 > i12 ? i12 : i11);
        C11839m.m70686d("SoftKeyboardWorkaround", "statusBarHeight: " + this.f49456c + ", NavigationBarHeight: " + iM76835h + ", ScreenWidthPx: " + this.f49457d);
        FrameLayout frameLayout = (FrameLayout) C12809f.m76829b(activity, i10);
        if (frameLayout == null) {
            C11839m.m70686d("SoftKeyboardWorkaround", "content view is null");
            return;
        }
        View childAt = frameLayout.getChildAt(0);
        this.f49454a = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        ViewGroup.LayoutParams layoutParams = this.f49454a.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            this.f49460g = (FrameLayout.LayoutParams) layoutParams;
        }
    }

    /* renamed from: b */
    public final int m63215b() {
        Rect rect = new Rect();
        this.f49454a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    /* renamed from: c */
    public final void m63216c() {
        int iM63215b = m63215b();
        if (iM63215b == this.f49455b) {
            return;
        }
        boolean zM70753O0 = C11842p.m70753O0(this.f49454a.getContext());
        C11839m.m70686d("SoftKeyboardWorkaround", "possiblyResizeChildOfContent: " + iM63215b + ", " + this.f49457d + ", " + this.f49455b + ", isLandscape:" + zM70753O0);
        this.f49455b = iM63215b;
        int i10 = this.f49456c;
        if (zM70753O0 || !this.f49458e) {
            i10 = 0;
        }
        int iM70852q = C11842p.m70852q(this.f49459f);
        int height = this.f49454a.getHeight();
        FrameLayout.LayoutParams layoutParams = this.f49460g;
        int i11 = (height + layoutParams.bottomMargin) - i10;
        int i12 = i11 - iM63215b;
        int i13 = iM70852q + i12;
        if (i12 > i11 / 4) {
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, i13);
        } else {
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, 0);
        }
        this.f49454a.setLayoutParams(this.f49460g);
        this.f49454a.requestLayout();
        this.f49455b = iM63215b;
    }
}
