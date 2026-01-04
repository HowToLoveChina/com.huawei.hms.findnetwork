package p023b;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: b.a */
/* loaded from: classes.dex */
public final class C1083a {

    /* renamed from: a */
    public final Set<InterfaceC1084b> f5201a = new CopyOnWriteArraySet();

    /* renamed from: b */
    public volatile Context f5202b;

    /* renamed from: a */
    public void m6458a(InterfaceC1084b interfaceC1084b) {
        if (this.f5202b != null) {
            interfaceC1084b.mo1945a(this.f5202b);
        }
        this.f5201a.add(interfaceC1084b);
    }

    /* renamed from: b */
    public void m6459b() {
        this.f5202b = null;
    }

    /* renamed from: c */
    public void m6460c(Context context) {
        this.f5202b = context;
        Iterator<InterfaceC1084b> it = this.f5201a.iterator();
        while (it.hasNext()) {
            it.next().mo1945a(context);
        }
    }
}
