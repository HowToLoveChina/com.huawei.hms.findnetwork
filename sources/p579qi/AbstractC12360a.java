package p579qi;

import com.huawei.cloud.base.http.AbstractC4619v;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.cloud.base.http.C4613p;
import com.huawei.cloud.base.http.InterfaceC4614q;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.InterfaceC4657y;
import java.io.IOException;
import p369ii.C10511b;

/* renamed from: qi.a */
/* loaded from: classes.dex */
public abstract class AbstractC12360a {
    private String applicationName;
    private InterfaceC12362c baseRequestInitializer;
    private final String batchPath;
    private InterfaceC4657y objectParser;
    private C4613p requestFactory;
    private String rootUrl;
    private String servicePath;
    private final boolean suppressRequiredParameterChecks;

    /* renamed from: qi.a$a */
    public static abstract class a {
        private String applicationName;
        private InterfaceC12362c baseRequestInitializer;
        private String batchPath;
        private InterfaceC4614q httpRequestInitializer;
        private boolean ignoreRequiredParameterVerify;
        private InterfaceC4657y objectParser;
        private String rootUrl;
        private String servicePath;
        private AbstractC4619v transport;

        public a(AbstractC4619v abstractC4619v, String str, String str2, InterfaceC4657y interfaceC4657y, InterfaceC4614q interfaceC4614q) {
            this.transport = (AbstractC4619v) C4627a0.m28391d(abstractC4619v);
            this.objectParser = interfaceC4657y;
            setRootUrl(str);
            setServicePath(str2);
            this.httpRequestInitializer = interfaceC4614q;
        }

        public abstract AbstractC12360a build();

        public final String getApplicationName() {
            return this.applicationName;
        }

        public final InterfaceC12362c getGoogleClientRequestInitializer() {
            return this.baseRequestInitializer;
        }

        public final InterfaceC4614q getHttpRequestInitializer() {
            return this.httpRequestInitializer;
        }

        public final boolean getIgnoreRequiredParameterVerify() {
            return this.ignoreRequiredParameterVerify;
        }

        public InterfaceC4657y getObjectParser() {
            return this.objectParser;
        }

        public final String getRootUrl() {
            return this.rootUrl;
        }

        public final String getServicePath() {
            return this.servicePath;
        }

        public final AbstractC4619v getTransport() {
            return this.transport;
        }

        public a setApplicationName(String str) {
            this.applicationName = str;
            return this;
        }

        public a setBaseRequestInitializer(InterfaceC12362c interfaceC12362c) {
            this.baseRequestInitializer = interfaceC12362c;
            return this;
        }

        public a setBatchPath(String str) {
            this.batchPath = str;
            return this;
        }

        public a setHttpRequestInitializer(InterfaceC4614q interfaceC4614q) {
            this.httpRequestInitializer = interfaceC4614q;
            return this;
        }

        public a setIgnoreRequiredParameterVerify(boolean z10) {
            this.ignoreRequiredParameterVerify = z10;
            return this;
        }

        public a setRootUrl(String str) {
            this.rootUrl = AbstractC12360a.normalizeRootUrl(str);
            return this;
        }

        public a setServicePath(String str) {
            this.servicePath = AbstractC12360a.normalizeServicePath(str);
            return this;
        }

        public a setSuppressAllChecks(boolean z10) {
            return setIgnoreRequiredParameterVerify(z10);
        }
    }

    public AbstractC12360a(a aVar) {
        this.baseRequestInitializer = aVar.baseRequestInitializer;
        this.rootUrl = normalizeRootUrl(aVar.rootUrl);
        this.servicePath = normalizeServicePath(aVar.servicePath);
        this.batchPath = aVar.batchPath;
        this.requestFactory = aVar.httpRequestInitializer == null ? aVar.transport.createRequestFactory() : aVar.transport.createRequestFactory(aVar.httpRequestInitializer);
        this.objectParser = aVar.objectParser;
        this.suppressRequiredParameterChecks = aVar.ignoreRequiredParameterVerify;
        this.applicationName = aVar.applicationName;
    }

    public static String normalizeRootUrl(String str) {
        C4627a0.m28392e(str, "root URL cannot be null.");
        if (str.endsWith("/")) {
            return str;
        }
        return str + "/";
    }

    public static String normalizeServicePath(String str) {
        C4627a0.m28392e(str, "service path cannot be null");
        if (str.length() == 1) {
            C4627a0.m28389b("/".equals(str), "service path must equal \"/\" if it is of length 1.");
            return "";
        }
        if (str.length() <= 0) {
            return str;
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        return str.startsWith("/") ? str.substring(1) : str;
    }

    public final C10511b batch() {
        C10511b c10511b = new C10511b(getRequestFactory().m28302f(), getRequestFactory().m28301e());
        if (C4633d0.m28404a(this.batchPath)) {
            c10511b.m64599d(new C4604g(getRootUrl() + "batch"));
        } else {
            c10511b.m64599d(new C4604g(getRootUrl() + this.batchPath));
        }
        return c10511b;
    }

    public final String getApplicationName() {
        return this.applicationName;
    }

    public final InterfaceC12362c getBaseRequestInitializer() {
        return this.baseRequestInitializer;
    }

    public final String getBaseUrl() {
        return this.rootUrl + this.servicePath;
    }

    public InterfaceC4657y getObjectParser() {
        return this.objectParser;
    }

    public final C4613p getRequestFactory() {
        return this.requestFactory;
    }

    public final String getRootUrl() {
        return this.rootUrl;
    }

    public final String getServicePath() {
        return this.servicePath;
    }

    public final boolean getSuppressRequiredParameterChecks() {
        return this.suppressRequiredParameterChecks;
    }

    public void initialize(AbstractC12361b<?> abstractC12361b) throws IOException {
        if (getBaseRequestInitializer() != null) {
            getBaseRequestInitializer().initialize(abstractC12361b);
        }
    }
}
