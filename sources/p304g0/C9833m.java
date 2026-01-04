package p304g0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* renamed from: g0.m */
/* loaded from: classes.dex */
public class C9833m {

    /* renamed from: a */
    public final Object f48324a;

    /* renamed from: g0.m$a */
    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a */
        public final C9833m f48325a;

        public a(C9833m c9833m) {
            this.f48325a = c9833m;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            C9832l c9832lMo61130b = this.f48325a.mo61130b(i10);
            if (c9832lMo61130b == null) {
                return null;
            }
            return c9832lMo61130b.m61120z0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            List<C9832l> listM61131c = this.f48325a.m61131c(str, i10);
            if (listM61131c == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listM61131c.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(listM61131c.get(i11).m61120z0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f48325a.mo61134f(i10, i11, bundle);
        }
    }

    /* renamed from: g0.m$b */
    public static class b extends a {
        public b(C9833m c9833m) {
            super(c9833m);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i10) {
            C9832l c9832lMo61132d = this.f48325a.mo61132d(i10);
            if (c9832lMo61132d == null) {
                return null;
            }
            return c9832lMo61132d.m61120z0();
        }
    }

    /* renamed from: g0.m$c */
    public static class c extends b {
        public c(C9833m c9833m) {
            super(c9833m);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f48325a.m61129a(i10, C9832l.m61042A0(accessibilityNodeInfo), str, bundle);
        }
    }

    public C9833m() {
        this.f48324a = new c(this);
    }

    /* renamed from: a */
    public void m61129a(int i10, C9832l c9832l, String str, Bundle bundle) {
    }

    /* renamed from: b */
    public C9832l mo61130b(int i10) {
        return null;
    }

    /* renamed from: c */
    public List<C9832l> m61131c(String str, int i10) {
        return null;
    }

    /* renamed from: d */
    public C9832l mo61132d(int i10) {
        return null;
    }

    /* renamed from: e */
    public Object m61133e() {
        return this.f48324a;
    }

    /* renamed from: f */
    public boolean mo61134f(int i10, int i11, Bundle bundle) {
        return false;
    }

    public C9833m(Object obj) {
        this.f48324a = obj;
    }
}
