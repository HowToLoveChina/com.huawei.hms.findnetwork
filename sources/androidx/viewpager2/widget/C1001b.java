package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.viewpager2.widget.b */
/* loaded from: classes.dex */
public final class C1001b extends ViewPager2.AbstractC0995i {

    /* renamed from: a */
    public final List<ViewPager2.AbstractC0995i> f5010a;

    public C1001b(int i10) {
        this.f5010a = new ArrayList(i10);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0995i
    /* renamed from: a */
    public void mo5879a(int i10) {
        try {
            Iterator<ViewPager2.AbstractC0995i> it = this.f5010a.iterator();
            while (it.hasNext()) {
                it.next().mo5879a(i10);
            }
        } catch (ConcurrentModificationException e10) {
            m5911e(e10);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0995i
    /* renamed from: b */
    public void mo5900b(int i10, float f10, int i11) {
        try {
            Iterator<ViewPager2.AbstractC0995i> it = this.f5010a.iterator();
            while (it.hasNext()) {
                it.next().mo5900b(i10, f10, i11);
            }
        } catch (ConcurrentModificationException e10) {
            m5911e(e10);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0995i
    /* renamed from: c */
    public void mo5880c(int i10) {
        try {
            Iterator<ViewPager2.AbstractC0995i> it = this.f5010a.iterator();
            while (it.hasNext()) {
                it.next().mo5880c(i10);
            }
        } catch (ConcurrentModificationException e10) {
            m5911e(e10);
        }
    }

    /* renamed from: d */
    public void m5910d(ViewPager2.AbstractC0995i abstractC0995i) {
        this.f5010a.add(abstractC0995i);
    }

    /* renamed from: e */
    public final void m5911e(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
