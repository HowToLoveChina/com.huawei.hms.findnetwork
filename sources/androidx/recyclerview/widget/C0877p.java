package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.Map;
import java.util.WeakHashMap;
import p273f0.C9582a;
import p273f0.C9603h0;
import p304g0.C9832l;
import p304g0.C9833m;

/* renamed from: androidx.recyclerview.widget.p */
/* loaded from: classes.dex */
public class C0877p extends C9582a {

    /* renamed from: b */
    public final RecyclerView f4629b;

    /* renamed from: c */
    public final a f4630c;

    /* renamed from: androidx.recyclerview.widget.p$a */
    public static class a extends C9582a {

        /* renamed from: b */
        public final C0877p f4631b;

        /* renamed from: c */
        public Map<View, C9582a> f4632c = new WeakHashMap();

        public a(C0877p c0877p) {
            this.f4631b = c0877p;
        }

        /* renamed from: a */
        public C9582a m5577a(View view) {
            return this.f4632c.remove(view);
        }

        /* renamed from: b */
        public void m5578b(View view) {
            C9582a c9582aM59893l = C9603h0.m59893l(view);
            if (c9582aM59893l == null || c9582aM59893l == this) {
                return;
            }
            this.f4632c.put(view, c9582aM59893l);
        }

        @Override // p273f0.C9582a
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C9582a c9582a = this.f4632c.get(view);
            return c9582a != null ? c9582a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // p273f0.C9582a
        public C9833m getAccessibilityNodeProvider(View view) {
            C9582a c9582a = this.f4632c.get(view);
            return c9582a != null ? c9582a.getAccessibilityNodeProvider(view) : super.getAccessibilityNodeProvider(view);
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C9582a c9582a = this.f4632c.get(view);
            if (c9582a != null) {
                c9582a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            if (this.f4631b.m5576c() || this.f4631b.f4629b.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, c9832l);
                return;
            }
            this.f4631b.f4629b.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, c9832l);
            C9582a c9582a = this.f4632c.get(view);
            if (c9582a != null) {
                c9582a.onInitializeAccessibilityNodeInfo(view, c9832l);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, c9832l);
            }
        }

        @Override // p273f0.C9582a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C9582a c9582a = this.f4632c.get(view);
            if (c9582a != null) {
                c9582a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // p273f0.C9582a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            C9582a c9582a = this.f4632c.get(viewGroup);
            return c9582a != null ? c9582a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // p273f0.C9582a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (this.f4631b.m5576c() || this.f4631b.f4629b.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i10, bundle);
            }
            C9582a c9582a = this.f4632c.get(view);
            if (c9582a != null) {
                if (c9582a.performAccessibilityAction(view, i10, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            return this.f4631b.f4629b.getLayoutManager().performAccessibilityActionForItem(view, i10, bundle);
        }

        @Override // p273f0.C9582a
        public void sendAccessibilityEvent(View view, int i10) {
            C9582a c9582a = this.f4632c.get(view);
            if (c9582a != null) {
                c9582a.sendAccessibilityEvent(view, i10);
            } else {
                super.sendAccessibilityEvent(view, i10);
            }
        }

        @Override // p273f0.C9582a
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            C9582a c9582a = this.f4632c.get(view);
            if (c9582a != null) {
                c9582a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public C0877p(RecyclerView recyclerView) {
        this.f4629b = recyclerView;
        C9582a c9582aM5575b = m5575b();
        if (c9582aM5575b == null || !(c9582aM5575b instanceof a)) {
            this.f4630c = new a(this);
        } else {
            this.f4630c = (a) c9582aM5575b;
        }
    }

    /* renamed from: b */
    public C9582a m5575b() {
        return this.f4630c;
    }

    /* renamed from: c */
    public boolean m5576c() {
        return this.f4629b.hasPendingAdapterUpdates();
    }

    @Override // p273f0.C9582a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || m5576c()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // p273f0.C9582a
    public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
        super.onInitializeAccessibilityNodeInfo(view, c9832l);
        if (m5576c() || this.f4629b.getLayoutManager() == null) {
            return;
        }
        this.f4629b.getLayoutManager().onInitializeAccessibilityNodeInfo(c9832l);
    }

    @Override // p273f0.C9582a
    public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        if (super.performAccessibilityAction(view, i10, bundle)) {
            return true;
        }
        if (m5576c() || this.f4629b.getLayoutManager() == null) {
            return false;
        }
        return this.f4629b.getLayoutManager().performAccessibilityAction(i10, bundle);
    }
}
