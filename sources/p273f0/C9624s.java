package p273f0;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0794j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: f0.s */
/* loaded from: classes.dex */
public class C9624s {

    /* renamed from: a */
    public final Runnable f47733a;

    /* renamed from: b */
    public final CopyOnWriteArrayList<InterfaceC9628u> f47734b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    public final Map<InterfaceC9628u, a> f47735c = new HashMap();

    /* renamed from: f0.s$a */
    public static class a {

        /* renamed from: a */
        public final AbstractC0791h f47736a;

        /* renamed from: b */
        public InterfaceC0794j f47737b;

        /* renamed from: a */
        public void m60145a() {
            this.f47736a.mo4950c(this.f47737b);
            this.f47737b = null;
        }
    }

    public C9624s(Runnable runnable) {
        this.f47733a = runnable;
    }

    /* renamed from: a */
    public void m60139a(InterfaceC9628u interfaceC9628u) {
        this.f47734b.add(interfaceC9628u);
        this.f47733a.run();
    }

    /* renamed from: b */
    public void m60140b(Menu menu, MenuInflater menuInflater) {
        Iterator<InterfaceC9628u> it = this.f47734b.iterator();
        while (it.hasNext()) {
            it.next().mo4621c(menu, menuInflater);
        }
    }

    /* renamed from: c */
    public void m60141c(Menu menu) {
        Iterator<InterfaceC9628u> it = this.f47734b.iterator();
        while (it.hasNext()) {
            it.next().mo4620b(menu);
        }
    }

    /* renamed from: d */
    public boolean m60142d(MenuItem menuItem) {
        Iterator<InterfaceC9628u> it = this.f47734b.iterator();
        while (it.hasNext()) {
            if (it.next().mo4619a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public void m60143e(Menu menu) {
        Iterator<InterfaceC9628u> it = this.f47734b.iterator();
        while (it.hasNext()) {
            it.next().mo4622d(menu);
        }
    }

    /* renamed from: f */
    public void m60144f(InterfaceC9628u interfaceC9628u) {
        this.f47734b.remove(interfaceC9628u);
        a aVarRemove = this.f47735c.remove(interfaceC9628u);
        if (aVarRemove != null) {
            aVarRemove.m60145a();
        }
        this.f47733a.run();
    }
}
