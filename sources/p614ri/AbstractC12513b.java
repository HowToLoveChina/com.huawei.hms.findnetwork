package p614ri;

import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.json.JsonErrorContainer;
import java.io.IOException;
import li.C11277a;
import p369ii.C10511b;
import p397ji.AbstractC10891a;
import p579qi.AbstractC12361b;

/* renamed from: ri.b */
/* loaded from: classes.dex */
public abstract class AbstractC12513b<T> extends AbstractC12361b<T> {
    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC12513b(AbstractC12512a abstractC12512a, String str, String str2, Object obj, Class<T> cls) {
        C11277a c11277aM67682h = null;
        if (obj != null) {
            c11277aM67682h = new C11277a(abstractC12512a.getJsonFactory(), obj).m67682h(abstractC12512a.getObjectParser().m28367d().isEmpty() ? null : "data");
        }
        super(abstractC12512a, str, str2, c11277aM67682h, cls);
    }

    public final void queue(C10511b c10511b, AbstractC10891a<T> abstractC10891a) throws IOException {
        super.queue(c10511b, JsonErrorContainer.class, abstractC10891a);
    }

    @Override // p579qi.AbstractC12361b
    public AbstractC12512a getAbstractClient() {
        return (AbstractC12512a) super.getAbstractClient();
    }

    @Override // p579qi.AbstractC12361b
    public AbstractC12513b<T> setDisableGZip(boolean z10) {
        return (AbstractC12513b) super.setDisableGZip(z10);
    }

    @Override // p579qi.AbstractC12361b
    public AbstractC12513b<T> setHeaders(C4609l c4609l) {
        return (AbstractC12513b) super.setHeaders(c4609l);
    }

    @Override // p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
    public AbstractC12513b<T> set(String str, Object obj) {
        return (AbstractC12513b) super.set(str, obj);
    }
}
