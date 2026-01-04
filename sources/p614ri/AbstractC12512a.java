package p614ri;

import com.huawei.cloud.base.http.AbstractC4619v;
import com.huawei.cloud.base.http.InterfaceC4614q;
import com.huawei.cloud.base.json.C4625a;
import java.util.Collections;
import ni.AbstractC11708c;
import p579qi.AbstractC12360a;
import p579qi.InterfaceC12362c;

/* renamed from: ri.a */
/* loaded from: classes.dex */
public abstract class AbstractC12512a extends AbstractC12360a {

    /* renamed from: ri.a$a */
    public static abstract class a extends AbstractC12360a.a {
        public a(AbstractC4619v abstractC4619v, AbstractC11708c abstractC11708c, String str, String str2, InterfaceC4614q interfaceC4614q) {
            super(abstractC4619v, str, str2, new C4625a.a(abstractC11708c).m28372b(Collections.emptySet()).m28371a(), interfaceC4614q);
        }

        @Override // p579qi.AbstractC12360a.a
        public abstract AbstractC12512a build();

        @Override // p579qi.AbstractC12360a.a
        public final C4625a getObjectParser() {
            return (C4625a) super.getObjectParser();
        }

        @Override // p579qi.AbstractC12360a.a
        public a setApplicationName(String str) {
            return (a) super.setApplicationName(str);
        }

        @Override // p579qi.AbstractC12360a.a
        public a setBaseRequestInitializer(InterfaceC12362c interfaceC12362c) {
            return (a) super.setBaseRequestInitializer(interfaceC12362c);
        }

        @Override // p579qi.AbstractC12360a.a
        public a setBatchPath(String str) {
            return (a) super.setBatchPath(str);
        }

        @Override // p579qi.AbstractC12360a.a
        public a setHttpRequestInitializer(InterfaceC4614q interfaceC4614q) {
            return (a) super.setHttpRequestInitializer(interfaceC4614q);
        }

        @Override // p579qi.AbstractC12360a.a
        public a setIgnoreRequiredParameterVerify(boolean z10) {
            return (a) super.setIgnoreRequiredParameterVerify(z10);
        }

        @Override // p579qi.AbstractC12360a.a
        public a setRootUrl(String str) {
            return (a) super.setRootUrl(str);
        }

        @Override // p579qi.AbstractC12360a.a
        public a setServicePath(String str) {
            return (a) super.setServicePath(str);
        }

        @Override // p579qi.AbstractC12360a.a
        public a setSuppressAllChecks(boolean z10) {
            return (a) super.setSuppressAllChecks(z10);
        }
    }

    public AbstractC12512a(a aVar) {
        super(aVar);
    }

    public final AbstractC11708c getJsonFactory() {
        return getObjectParser().m28366c();
    }

    @Override // p579qi.AbstractC12360a
    public C4625a getObjectParser() {
        return (C4625a) super.getObjectParser();
    }
}
