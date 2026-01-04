package androidx.fragment.app;

import android.view.View;
import androidx.transition.C0937e;
import java.util.ArrayList;
import p438l.C11207a;

/* renamed from: androidx.fragment.app.b0 */
/* loaded from: classes.dex */
public class C0737b0 {

    /* renamed from: a */
    public static final AbstractC0741d0 f3964a = new C0739c0();

    /* renamed from: b */
    public static final AbstractC0741d0 f3965b = m4692b();

    /* renamed from: a */
    public static void m4691a(Fragment fragment, Fragment fragment2, boolean z10, C11207a<String, View> c11207a, boolean z11) {
        if (z10) {
            fragment2.m4435s();
        } else {
            fragment.m4435s();
        }
    }

    /* renamed from: b */
    public static AbstractC0741d0 m4692b() {
        try {
            return (AbstractC0741d0) C0937e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static void m4693c(C11207a<String, String> c11207a, C11207a<String, View> c11207a2) {
        for (int size = c11207a.size() - 1; size >= 0; size--) {
            if (!c11207a2.containsKey(c11207a.m67335m(size))) {
                c11207a.mo67333k(size);
            }
        }
    }

    /* renamed from: d */
    public static void m4694d(ArrayList<View> arrayList, int i10) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i10);
        }
    }
}
