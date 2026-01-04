package ni;

import com.huawei.cloud.base.util.C4635e0;
import com.huawei.cloud.base.util.C4646n;
import java.io.IOException;

/* renamed from: ni.b */
/* loaded from: classes.dex */
public class C11707b extends C4646n implements Cloneable {
    private AbstractC11708c jsonFactory;

    public final AbstractC11708c getFactory() {
        return this.jsonFactory;
    }

    public final void setFactory(AbstractC11708c abstractC11708c) {
        this.jsonFactory = abstractC11708c;
    }

    public String toPrettyString() throws IOException {
        AbstractC11708c abstractC11708c = this.jsonFactory;
        return abstractC11708c != null ? abstractC11708c.m69834g(this) : super.toString();
    }

    @Override // java.util.AbstractMap
    public String toString() {
        AbstractC11708c abstractC11708c = this.jsonFactory;
        if (abstractC11708c == null) {
            return super.toString();
        }
        try {
            return abstractC11708c.m69835h(this);
        } catch (IOException e10) {
            throw C4635e0.m28408a(e10);
        }
    }

    @Override // com.huawei.cloud.base.util.C4646n
    public C11707b set(String str, Object obj) {
        return (C11707b) super.set(str, obj);
    }

    @Override // com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public C11707b clone() {
        return (C11707b) super.clone();
    }
}
