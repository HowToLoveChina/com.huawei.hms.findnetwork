package p255ed;

import bb.C1160a;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.CloudSyncAtomicBatch;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.CloudSyncBatch;
import com.huawei.cloud.base.http.C4597b0;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.cloud.services.drive.DriveRequest;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.dnskpr.DnsKprUtil;
import java.io.IOException;
import java.util.Map;
import ni.C11707b;
import p336he.C10156g;
import p514o9.C11839m;
import p709vj.C13452e;
import tm.C13040c;
import vi.C13446a;

/* renamed from: ed.k */
/* loaded from: classes3.dex */
public abstract class AbstractC9455k<T> extends DriveRequest<T> {
    private static final String TAG = "CloudSyncRequest";
    private Drive client;
    private String database;
    private String kind;
    private C11707b requestBody;
    private String uriTemplate;

    public AbstractC9455k(Drive drive, String str, String str2, String str3, String str4, C11707b c11707b, Class<T> cls) throws IOException {
        super(drive, str3, str4, c11707b, cls);
        this.uriTemplate = str4;
        this.client = drive;
        this.database = str;
        this.kind = str2;
        drive.getBaseRequestInitializer().initialize(this);
        C1160a.m7250a(getHeaders());
        this.requestBody = c11707b;
    }

    public AbstractC9455k addHeader(String str, Object obj) {
        getHeaders().set(str, obj);
        return this;
    }

    @Override // p579qi.AbstractC12361b
    public C4604g buildHttpRequestUrl() {
        return new C4604g(C4597b0.m28167b(this.client.getRootUrl() + "", this.uriTemplate, this, true));
    }

    @Override // p579qi.AbstractC12361b
    public T execute() throws IOException {
        C10156g.m63307d(getHeaders(), buildHttpRequestUrl());
        try {
            T t10 = (T) super.execute();
            C10156g.m63310g(super.getLastResponseHeaders());
            return t10;
        } catch (IOException e10) {
            C11839m.m70687e(TAG, "execute IOException");
            if ((e10 instanceof C13446a) && !DnsKprUtil.m29898g()) {
                C11839m.m70687e(TAG, "start forceExpire");
                C13040c.m78609F().m78651i();
                C13452e.m80781L().m80988x1("from_sysConfRefresh");
            }
            throw e10;
        }
    }

    public Map<String, Object> getRequestBody() {
        return this.requestBody;
    }

    public String getRequestDatabase() {
        return this.database;
    }

    public String getRequestKind() {
        return this.kind;
    }

    public String getRequestUrl() {
        return C4597b0.m28167b("", this.uriTemplate, this, true);
    }

    public void queue(CloudSyncBatch cloudSyncBatch, AbstractC9454j<T> abstractC9454j) throws IOException {
        cloudSyncBatch.queue(this, getResponseClass(), ErrorResp.class, abstractC9454j);
    }

    public void queue(CloudSyncAtomicBatch cloudSyncAtomicBatch, AbstractC9454j<T> abstractC9454j) throws IOException {
        cloudSyncAtomicBatch.queue(this, getResponseClass(), ErrorResp.class, abstractC9454j);
    }

    public AbstractC9455k(Drive drive, String str, String str2, C11707b c11707b, Class<T> cls) throws IOException {
        super(drive, str, str2, c11707b, cls);
        this.uriTemplate = str2;
        this.client = drive;
        drive.getBaseRequestInitializer().initialize(this);
        C1160a.m7250a(getHeaders());
        this.requestBody = c11707b;
    }
}
