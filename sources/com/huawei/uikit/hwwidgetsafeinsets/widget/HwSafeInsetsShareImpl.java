package com.huawei.uikit.hwwidgetsafeinsets.widget;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import huawei.android.widget.HwSafeInsetsShareable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes9.dex */
public class HwSafeInsetsShareImpl implements HwSafeInsetsShareable {

    /* renamed from: b */
    private static final String f44876b = "HwSafeInsetsShareImpl";

    /* renamed from: a */
    private Map<View, bzrwd> f44877a = new HashMap();

    public class bzrwd {

        /* renamed from: a */
        View f44878a;

        /* renamed from: b */
        Rect f44879b = new Rect();

        /* renamed from: c */
        int f44880c;

        public bzrwd(View view, int i10) {
            this.f44880c = 1;
            this.f44878a = view;
            if (i10 == 2) {
                this.f44880c = i10;
            }
            m55957a();
        }

        /* renamed from: a */
        private void m55957a() {
            View view = this.f44878a;
            if (this.f44880c == 2) {
                this.f44879b.set(HwSafeInsetsShareImpl.this.m55953b(view));
            } else {
                this.f44879b.set(HwSafeInsetsShareImpl.this.m55948a(view));
            }
        }
    }

    /* renamed from: c */
    private boolean m55956c(bzrwd bzrwdVar, HwWidgetSafeInsets hwWidgetSafeInsets) {
        View view = bzrwdVar.f44878a;
        Rect displaySafeInsets = hwWidgetSafeInsets.getDisplaySafeInsets(view, bzrwdVar.f44879b);
        if (displaySafeInsets.equals(m55953b(view))) {
            return false;
        }
        view.setPadding(displaySafeInsets.left, displaySafeInsets.top, displaySafeInsets.right, displaySafeInsets.bottom);
        return true;
    }

    @Override // huawei.android.widget.HwSafeInsetsShareable
    public void addSharedView(View view, int i10) {
        if (view == null || this.f44877a.containsKey(view)) {
            return;
        }
        this.f44877a.put(view, new bzrwd(view, i10));
    }

    public void clearSharedView() {
        this.f44877a.clear();
    }

    public void onConfigurationChanged(Configuration configuration) {
        m55950a();
    }

    @Override // huawei.android.widget.HwSafeInsetsShareable
    public void removeSharedView(View view) {
        this.f44877a.remove(view);
    }

    public void shareSafeInsets(HwWidgetSafeInsets hwWidgetSafeInsets) {
        Iterator<bzrwd> it = this.f44877a.values().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (m55952a(it.next(), hwWidgetSafeInsets)) {
                z10 = true;
            }
        }
        if (z10) {
            hwWidgetSafeInsets.postRequestLayout();
        }
    }

    /* renamed from: a */
    private boolean m55952a(bzrwd bzrwdVar, HwWidgetSafeInsets hwWidgetSafeInsets) {
        int i10 = bzrwdVar.f44880c;
        if (i10 == 1) {
            return m55955b(bzrwdVar, hwWidgetSafeInsets);
        }
        if (i10 != 2) {
            return false;
        }
        return m55956c(bzrwdVar, hwWidgetSafeInsets);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m55955b(com.huawei.uikit.hwwidgetsafeinsets.widget.HwSafeInsetsShareImpl.bzrwd r8, com.huawei.uikit.hwwidgetsafeinsets.widget.HwWidgetSafeInsets r9) {
        /*
            r7 = this;
            android.view.View r0 = r8.f44878a
            int r1 = r0.getWidth()
            r2 = 0
            if (r1 == 0) goto L72
            int r1 = r0.getHeight()
            if (r1 != 0) goto L10
            goto L72
        L10:
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            boolean r3 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r3 != 0) goto L19
            return r2
        L19:
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            android.graphics.Rect r3 = r9.getSafeInsets()
            android.graphics.Rect r8 = r8.f44879b
            android.graphics.Rect r9 = r9.getDisplaySafeInsets(r0, r8)
            android.graphics.Rect r7 = r7.m55948a(r0)
            int r4 = r3.left
            r5 = 1
            if (r4 != 0) goto L42
            int r6 = r3.right
            if (r6 != 0) goto L42
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L6d
            int r7 = r8.left
            r1.leftMargin = r7
            int r7 = r8.right
            r1.rightMargin = r7
        L40:
            r2 = r5
            goto L6d
        L42:
            if (r4 <= 0) goto L4e
            int r4 = r9.left
            int r6 = r7.left
            if (r4 <= r6) goto L57
            r1.leftMargin = r4
        L4c:
            r2 = r5
            goto L57
        L4e:
            int r4 = r7.left
            int r6 = r8.left
            if (r4 <= r6) goto L57
            r1.leftMargin = r6
            goto L4c
        L57:
            int r3 = r3.right
            if (r3 <= 0) goto L64
            int r8 = r9.right
            int r7 = r7.right
            if (r8 <= r7) goto L6d
            r1.rightMargin = r8
            goto L40
        L64:
            int r7 = r7.right
            int r8 = r8.right
            if (r7 <= r8) goto L6d
            r1.rightMargin = r8
            goto L40
        L6d:
            if (r2 == 0) goto L72
            r0.setLayoutParams(r1)
        L72:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwwidgetsafeinsets.widget.HwSafeInsetsShareImpl.m55955b(com.huawei.uikit.hwwidgetsafeinsets.widget.HwSafeInsetsShareImpl$bzrwd, com.huawei.uikit.hwwidgetsafeinsets.widget.HwWidgetSafeInsets):boolean");
    }

    /* renamed from: a */
    private void m55950a() {
        Iterator<bzrwd> it = this.f44877a.values().iterator();
        while (it.hasNext()) {
            m55951a(it.next());
        }
    }

    public void shareSafeInsets(View view, HwWidgetSafeInsets hwWidgetSafeInsets) {
        bzrwd bzrwdVar = this.f44877a.get(view);
        if (bzrwdVar != null) {
            m55952a(bzrwdVar, hwWidgetSafeInsets);
        }
    }

    /* renamed from: a */
    private void m55951a(bzrwd bzrwdVar) {
        View view = bzrwdVar.f44878a;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            Rect rect = bzrwdVar.f44879b;
            marginLayoutParams.leftMargin = rect.left;
            marginLayoutParams.rightMargin = rect.right;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Rect m55948a(View view) {
        Rect rect = new Rect();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            rect.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Rect m55953b(View view) {
        Rect rect = new Rect();
        if (view != null) {
            rect.set(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
        return rect;
    }
}
