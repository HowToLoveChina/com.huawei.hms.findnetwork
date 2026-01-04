package p635s7;

import android.os.Bundle;
import java.util.Hashtable;
import p650t7.AbstractC12988v;
import p701v6.AbstractC13354a;
import p764x6.AbstractC13709a;

/* renamed from: s7.w */
/* loaded from: classes2.dex */
public abstract class AbstractC12758w<T> extends AbstractC13354a<T> {

    /* renamed from: k */
    public String f58397k = "cmd";

    /* renamed from: s */
    public Bundle m76583s(String str) {
        AbstractC13709a<T> abstractC13709a = this.f60185a;
        return abstractC13709a instanceof AbstractC12988v ? ((AbstractC12988v) abstractC13709a).mo77877m() : mo15143u(str);
    }

    /* renamed from: t */
    public String m76584t() {
        return this.f58397k;
    }

    /* renamed from: u */
    public abstract Bundle mo15143u(String str);

    /* renamed from: v */
    public void m76585v(String str) {
        if (this.f60191g == null) {
            this.f60191g = new Hashtable();
        }
        this.f60190f = str;
        this.f60191g.put("Lock-Token", str);
    }
}
