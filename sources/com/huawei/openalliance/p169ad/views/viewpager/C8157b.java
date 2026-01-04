package com.huawei.openalliance.p169ad.views.viewpager;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: com.huawei.openalliance.ad.views.viewpager.b */
/* loaded from: classes2.dex */
class C8157b extends View.AccessibilityDelegate {

    /* renamed from: a */
    private C8160e f38192a;

    public C8157b(C8160e c8160e) {
        this.f38192a = c8160e;
    }

    /* renamed from: a */
    private boolean m50534a() {
        AbstractC8161f abstractC8161f = this.f38192a.f38226b;
        return abstractC8161f != null && abstractC8161f.mo42547a() > 1;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        AbstractC8161f abstractC8161f;
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(C8160e.class.getName());
        accessibilityEvent.setScrollable(m50534a());
        if (accessibilityEvent.getEventType() != 4096 || (abstractC8161f = this.f38192a.f38226b) == null) {
            return;
        }
        accessibilityEvent.setItemCount(abstractC8161f.mo42547a());
        accessibilityEvent.setFromIndex(this.f38192a.f38221a);
        accessibilityEvent.setToIndex(this.f38192a.f38221a);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(C8160e.class.getName());
        accessibilityNodeInfo.setScrollable(m50534a());
        if (this.f38192a.canScrollHorizontally(1)) {
            accessibilityNodeInfo.addAction(4096);
        }
        if (this.f38192a.canScrollHorizontally(-1)) {
            accessibilityNodeInfo.addAction(8192);
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        C8160e c8160e;
        int i11;
        if (super.performAccessibilityAction(view, i10, bundle)) {
            return true;
        }
        if (i10 != 4096) {
            if (i10 != 8192 || !this.f38192a.canScrollHorizontally(-1)) {
                return false;
            }
            c8160e = this.f38192a;
            i11 = c8160e.f38221a - 1;
        } else {
            if (!this.f38192a.canScrollHorizontally(1)) {
                return false;
            }
            c8160e = this.f38192a;
            i11 = c8160e.f38221a + 1;
        }
        c8160e.setCurrentItem(i11);
        return true;
    }
}
