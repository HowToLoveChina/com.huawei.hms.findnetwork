package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: androidx.lifecycle.e0 */
/* loaded from: classes.dex */
public class C0786e0 {

    /* renamed from: a */
    public final HashMap<String, AbstractC0780b0> f4164a = new HashMap<>();

    /* renamed from: a */
    public final void m4942a() {
        Iterator<AbstractC0780b0> it = this.f4164a.values().iterator();
        while (it.hasNext()) {
            it.next().m4924a();
        }
        this.f4164a.clear();
    }

    /* renamed from: b */
    public final AbstractC0780b0 m4943b(String str) {
        return this.f4164a.get(str);
    }

    /* renamed from: c */
    public Set<String> m4944c() {
        return new HashSet(this.f4164a.keySet());
    }

    /* renamed from: d */
    public final void m4945d(String str, AbstractC0780b0 abstractC0780b0) {
        AbstractC0780b0 abstractC0780b0Put = this.f4164a.put(str, abstractC0780b0);
        if (abstractC0780b0Put != null) {
            abstractC0780b0Put.mo4815d();
        }
    }
}
