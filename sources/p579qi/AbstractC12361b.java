package p579qi;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.cloud.base.http.AbstractC4596b;
import com.huawei.cloud.base.http.C4597b0;
import com.huawei.cloud.base.http.C4600d;
import com.huawei.cloud.base.http.C4603f;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.http.C4613p;
import com.huawei.cloud.base.http.C4615r;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.http.C4618u;
import com.huawei.cloud.base.http.InterfaceC4605h;
import com.huawei.cloud.base.http.InterfaceC4617t;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4646n;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.hms.drive.C5284g;
import gi.C9947b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p369ii.C10511b;
import p369ii.InterfaceC10510a;
import p477mi.C11472a;
import p553pi.C12143a;
import p553pi.C12144b;

/* renamed from: qi.b */
/* loaded from: classes.dex */
public abstract class AbstractC12361b<T> extends C4646n {
    private final AbstractC12360a abstractClient;
    private boolean disableGZip;
    private C12143a downloader;
    private final InterfaceC4605h httpContent;
    private C4609l lastResponseHeaders;
    private C11472a lastStatusError;
    private String lastStatusMessage;
    private final String requestMethod;
    private Class<T> responseClass;
    private C12144b uploader;
    private final String uriTemplate;
    private static final String TAG = "AbstractClientRequest";
    private static final C4650r LOGGER = C4650r.m28485f(TAG);
    private C4609l headers = new C4609l();
    private int lastStatusCode = -1;

    /* renamed from: qi.b$a */
    public class a implements InterfaceC4617t {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC4617t f57161a;

        /* renamed from: b */
        public final /* synthetic */ C4612o f57162b;

        public a(InterfaceC4617t interfaceC4617t, C4612o c4612o) {
            this.f57161a = interfaceC4617t;
            this.f57162b = c4612o;
        }

        @Override // com.huawei.cloud.base.http.InterfaceC4617t
        /* renamed from: a */
        public void mo28331a(C4615r c4615r) throws IOException {
            InterfaceC4617t interfaceC4617t = this.f57161a;
            if (interfaceC4617t != null) {
                interfaceC4617t.mo28331a(c4615r);
            }
            if (!c4615r.m28315l() && this.f57162b.m28285q()) {
                throw AbstractC12361b.this.newExceptionOnError(c4615r);
            }
        }
    }

    public AbstractC12361b(AbstractC12360a abstractC12360a, String str, String str2, InterfaceC4605h interfaceC4605h, Class<T> cls) {
        this.responseClass = (Class) C4627a0.m28391d(cls);
        this.abstractClient = (AbstractC12360a) C4627a0.m28391d(abstractC12360a);
        this.requestMethod = (String) C4627a0.m28391d(str);
        this.uriTemplate = (String) C4627a0.m28391d(str2);
        this.httpContent = interfaceC4605h;
        String applicationName = abstractC12360a.getApplicationName();
        if (applicationName != null) {
            this.headers.set("x-hw-app-name", applicationName);
        }
    }

    private C4612o buildHttpRequest() throws IOException {
        C4612o c4612oM28300d = this.abstractClient.getRequestFactory().m28300d(this.requestMethod, buildHttpRequestUrl(), this.httpContent);
        new C9947b().mo28207c(c4612oM28300d);
        c4612oM28300d.m28262C(this.abstractClient.getObjectParser());
        if (this.httpContent == null && (this.requestMethod.equals("POST") || this.requestMethod.equals("PUT") || this.requestMethod.equals(RequestMethod.PATCH))) {
            c4612oM28300d.m28292x(new C4600d());
        }
        c4612oM28300d.m28277i().putAll(this.headers);
        if (!this.disableGZip) {
            c4612oM28300d.m28293y(new C4603f());
        }
        c4612oM28300d.m28265F(new a(c4612oM28300d.m28284p(), c4612oM28300d));
        return c4612oM28300d;
    }

    private C4615r executeUnparsed() throws IOException {
        C4615r c4615rM72844W;
        if (this.uploader == null) {
            c4615rM72844W = buildHttpRequest().m28272d();
        } else {
            C4604g c4604gBuildHttpRequestUrl = buildHttpRequestUrl();
            boolean zM28285q = getAbstractClient().getRequestFactory().m28300d(this.requestMethod, c4604gBuildHttpRequestUrl, this.httpContent).m28285q();
            this.headers.set("x-hw-trace-id", C5284g.m31720a("12214"));
            c4615rM72844W = this.uploader.m72839R(this.headers).m72838Q(this.disableGZip).m72844W(c4604gBuildHttpRequestUrl);
            c4615rM72844W.m28310g().m28262C(getAbstractClient().getObjectParser());
            if (!c4615rM72844W.m28315l()) {
                IOException iOExceptionNewExceptionOnError = newExceptionOnError(c4615rM72844W);
                if (zM28285q) {
                    throw iOExceptionNewExceptionOnError;
                }
            }
        }
        this.lastResponseHeaders = c4615rM72844W.m28308e();
        this.lastStatusCode = c4615rM72844W.m28311h();
        this.lastStatusMessage = c4615rM72844W.m28312i();
        if (!C4618u.m28333b(this.lastStatusCode)) {
            this.lastStatusError = (C11472a) getAbstractClient().getObjectParser().mo28364a(c4615rM72844W.m28306c(), c4615rM72844W.m28307d(), C11472a.class);
        }
        return c4615rM72844W;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IOException newExceptionOnError(C4615r c4615r) {
        return new C4616s(c4615r);
    }

    public C4604g buildHttpRequestUrl() {
        return new C4604g(C4597b0.m28167b(this.abstractClient.getBaseUrl(), this.uriTemplate, this, true));
    }

    public final void checkRequiredParameter(Object obj, String str) {
        C4627a0.m28390c(this.abstractClient.getSuppressRequiredParameterChecks() || obj != null, "Required parameter %s must be specified", str);
    }

    public T execute() throws IOException {
        return (T) executeUnparsed().m28316m(this.responseClass);
    }

    public void executeAndDownloadTo(OutputStream outputStream) throws IOException {
        executeUnparsed().m28305b(outputStream);
    }

    public InputStream executeAsInputStream() throws IOException {
        return executeUnparsed().m28306c();
    }

    public C4615r executeContent() throws IOException {
        set("form", (Object) "content");
        return executeUnparsed();
    }

    public void executeContentAndDownloadTo(OutputStream outputStream) throws IOException {
        if (this.downloader == null) {
            executeContent().m28305b(outputStream);
            return;
        }
        this.headers.set("x-hw-trace-id", C5284g.m31720a("12215"));
        C4604g c4604gBuildHttpRequestUrl = buildHttpRequestUrl();
        boolean zM28285q = getAbstractClient().getRequestFactory().m28297a(c4604gBuildHttpRequestUrl).m28285q();
        try {
            this.downloader.m72791a(c4604gBuildHttpRequestUrl, this.headers, outputStream);
        } catch (IOException e10) {
            if (zM28285q) {
                throw e10;
            }
        }
    }

    public InputStream executeContentAsInputStream() throws IOException {
        return executeContent().m28306c();
    }

    public AbstractC12360a getAbstractClient() {
        return this.abstractClient;
    }

    public final boolean getDisableGZip() {
        return this.disableGZip;
    }

    public final C4609l getHeaders() {
        return this.headers;
    }

    public final InterfaceC4605h getHttpContent() {
        return this.httpContent;
    }

    public final C4609l getLastResponseHeaders() {
        return this.lastResponseHeaders;
    }

    public final int getLastStatusCode() {
        return this.lastStatusCode;
    }

    public C11472a getLastStatusError() {
        return this.lastStatusError;
    }

    public final String getLastStatusMessage() {
        return this.lastStatusMessage;
    }

    public final C12143a getMediaHttpDownloader() {
        return this.downloader;
    }

    public final C12144b getMediaHttpUploader() {
        return this.uploader;
    }

    public final String getRequestMethod() {
        return this.requestMethod;
    }

    public final Class<T> getResponseClass() {
        return this.responseClass;
    }

    public final String getUriTemplate() {
        return this.uriTemplate;
    }

    public final void initializeMediaDownload() {
        C4613p requestFactory = this.abstractClient.getRequestFactory();
        this.downloader = new C12143a(requestFactory.m28302f(), requestFactory.m28301e());
    }

    public final void initializeMediaUpload(AbstractC4596b abstractC4596b) {
        C4613p requestFactory = this.abstractClient.getRequestFactory();
        C12144b c12144b = new C12144b(abstractC4596b, requestFactory.m28302f(), requestFactory.m28301e());
        this.uploader = c12144b;
        c12144b.m72840S(this.requestMethod);
        InterfaceC4605h interfaceC4605h = this.httpContent;
        if (interfaceC4605h != null) {
            this.uploader.m72841T(interfaceC4605h);
        }
    }

    public final <E> void queue(C10511b c10511b, Class<E> cls, InterfaceC10510a<T, E> interfaceC10510a) throws IOException {
        C4627a0.m28389b(this.uploader == null, "Batching media requests is not supported");
        c10511b.m64598c(buildHttpRequest(), getResponseClass(), cls, interfaceC10510a);
    }

    public AbstractC12361b<T> setDisableGZip(boolean z10) {
        this.disableGZip = z10;
        return this;
    }

    public AbstractC12361b<T> setHeaders(C4609l c4609l) {
        this.headers = c4609l;
        return this;
    }

    @Override // com.huawei.cloud.base.util.C4646n
    public AbstractC12361b<T> set(String str, Object obj) {
        return (AbstractC12361b) super.set(str, obj);
    }
}
