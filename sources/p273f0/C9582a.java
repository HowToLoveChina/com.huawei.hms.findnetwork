package p273f0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import p304g0.C9832l;
import p304g0.C9833m;

/* renamed from: f0.a */
/* loaded from: classes.dex */
public class C9582a {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    /* renamed from: f0.a$a */
    public static final class a extends View.AccessibilityDelegate {

        /* renamed from: a */
        public final C9582a f47677a;

        public a(C9582a c9582a) {
            this.f47677a = c9582a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f47677a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            C9833m accessibilityNodeProvider = this.f47677a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.m61133e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f47677a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            C9832l c9832lM61042A0 = C9832l.m61042A0(accessibilityNodeInfo);
            c9832lM61042A0.m61100p0(C9603h0.m59867W(view));
            c9832lM61042A0.m61082f0(C9603h0.m59862R(view));
            c9832lM61042A0.m61091k0(C9603h0.m59899o(view));
            c9832lM61042A0.m61112v0(C9603h0.m59848I(view));
            this.f47677a.onInitializeAccessibilityNodeInfo(view, c9832lM61042A0);
            c9832lM61042A0.m61079e(accessibilityNodeInfo.getText(), view);
            List<C9832l.a> actionList = C9582a.getActionList(view);
            for (int i10 = 0; i10 < actionList.size(); i10++) {
                c9832lM61042A0.m61073b(actionList.get(i10));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f47677a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f47677a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            return this.f47677a.performAccessibilityAction(view, i10, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i10) {
            this.f47677a.sendAccessibilityEvent(view, i10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f47677a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    /* renamed from: f0.a$b */
    public static class b {
        /* renamed from: a */
        public static AccessibilityNodeProvider m59781a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        /* renamed from: b */
        public static boolean m59782b(View.AccessibilityDelegate accessibilityDelegate, View view, int i10, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i10, bundle);
        }
    }

    public C9582a() {
        this(DEFAULT_DELEGATE);
    }

    public static List<C9832l.a> getActionList(View view) {
        List<C9832l.a> list = (List) view.getTag(R$id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrM61047n = C9832l.m61047n(view.createAccessibilityNodeInfo().getText());
            for (int i10 = 0; clickableSpanArrM61047n != null && i10 < clickableSpanArrM61047n.length; i10++) {
                if (clickableSpan.equals(clickableSpanArrM61047n[i10])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean performClickableSpanAction(int i10, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i10)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!isSpanStillValid(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public C9833m getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProviderM59781a = b.m59781a(this.mOriginalDelegate, view);
        if (accessibilityNodeProviderM59781a != null) {
            return new C9833m(accessibilityNodeProviderM59781a);
        }
        return null;
    }

    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, c9832l.m61120z0());
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int i10, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        List<C9832l.a> actionList = getActionList(view);
        boolean zM59782b = false;
        int i11 = 0;
        while (true) {
            if (i11 >= actionList.size()) {
                break;
            }
            C9832l.a aVar = actionList.get(i11);
            if (aVar.m61122b() == i10) {
                zM59782b = aVar.m61124d(view, bundle);
                break;
            }
            i11++;
        }
        if (!zM59782b) {
            zM59782b = b.m59782b(this.mOriginalDelegate, view, i10, bundle);
        }
        return (zM59782b || i10 != R$id.accessibility_action_clickable_span || bundle == null) ? zM59782b : performClickableSpanAction(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void sendAccessibilityEvent(View view, int i10) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i10);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C9582a(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new a(this);
    }
}
