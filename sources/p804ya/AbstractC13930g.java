package p804ya;

import android.text.TextUtils;
import bb.C1160a;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.cloud.base.http.C4597b0;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.cloud.services.drive.DriveRequest;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.dnskpr.DnsKprUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import ni.C11707b;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p265ep.C9530a;
import p336he.C10156g;
import p514o9.C11839m;
import p523oi.C11903a;
import p709vj.C13452e;
import p783xp.C13843a;
import tm.C13040c;
import vi.C13446a;

/* renamed from: ya.g */
/* loaded from: classes3.dex */
public abstract class AbstractC13930g<T> extends DriveRequest<T> {
    private static Map<String, a> cacheResponses = new HashMap();
    private long cacheControl;
    private Drive client;
    private C11707b requestBody;
    private Class<T> responseClass;
    private String uriTemplate;

    /* renamed from: ya.g$a */
    public static class a {

        /* renamed from: a */
        public String f62483a;

        /* renamed from: b */
        public long f62484b;

        public a(String str, long j10) {
            this.f62483a = str;
            this.f62484b = j10;
        }

        /* renamed from: a */
        public long m83665a() {
            return this.f62484b;
        }

        /* renamed from: b */
        public String m83666b() {
            return this.f62483a;
        }
    }

    public AbstractC13930g(Drive drive, String str, String str2, C11707b c11707b, Class<T> cls) throws IOException {
        super(drive, str, str2, c11707b, cls);
        this.cacheControl = 0L;
        this.uriTemplate = str2;
        this.client = drive;
        drive.getBaseRequestInitializer().initialize(this);
        C4609l headers = getHeaders();
        C1160a.m7250a(headers);
        headers.set("x-hw-thinsdkapp-version", C1122c.m6833t0(C0213f.m1377a()));
        headers.set("x-hw-3rdapp-packagename", C13843a.m83054F(C0213f.m1377a()));
        headers.set("x-hw-3rdapp-version", C1122c.m6833t0(C0213f.m1377a()));
        String strM7151o = C1136q.d.m7151o();
        if (!TextUtils.isEmpty(strM7151o)) {
            headers.set("x-hw-upid", strM7151o);
        }
        this.requestBody = c11707b;
        this.responseClass = cls;
    }

    public AbstractC13930g addHeader(String str, Object obj) {
        getHeaders().set(str, obj);
        return this;
    }

    @Override // p579qi.AbstractC12361b
    public C4604g buildHttpRequestUrl() {
        return new C4604g(C4597b0.m28167b(this.client.getRootUrl() + "", this.uriTemplate, this, true));
    }

    @Override // p579qi.AbstractC12361b
    public T execute() throws IOException {
        try {
            C10156g.m63307d(getHeaders(), buildHttpRequestUrl());
            if (this.cacheControl <= 0) {
                T t10 = (T) super.execute();
                C10156g.m63310g(super.getLastResponseHeaders());
                return t10;
            }
            String str = C13452e.m80781L().m80971t0() + "_" + buildHttpRequestUrl().toString();
            if (!cacheResponses.containsKey(str)) {
                T t11 = (T) super.execute();
                C10156g.m63310g(super.getLastResponseHeaders());
                cacheResponses.put(str, new a(t11.toString(), System.currentTimeMillis()));
                return t11;
            }
            a aVar = cacheResponses.get(str);
            if (System.currentTimeMillis() - aVar.m83665a() <= this.cacheControl) {
                return (T) C11903a.m71435l().mo69832e(aVar.m83666b()).m69886u(this.responseClass);
            }
            T t12 = (T) super.execute();
            C10156g.m63310g(super.getLastResponseHeaders());
            cacheResponses.put(str, new a(t12.toString(), System.currentTimeMillis()));
            return t12;
        } catch (IOException e10) {
            C1120a.m6677i("CloudPhotoRequest", "CloudPhotoRequest server execute IOException");
            if ((e10 instanceof C13446a) && !DnsKprUtil.m29898g()) {
                C11839m.m70687e("CloudPhotoRequest", "start forceExpire");
                C13040c.m78609F().m78651i();
                C13452e.m80781L().m80988x1("from_sysConfRefresh");
            }
            throw e10;
        }
    }

    public long getCacheControl() {
        return this.cacheControl;
    }

    public Map<String, Object> getRequestBody() {
        return this.requestBody;
    }

    public String getRequestUrl() {
        return C4597b0.m28167b("", this.uriTemplate, this, true);
    }

    public void queue(CloudPhotoBatch cloudPhotoBatch, AbstractC13926c<T> abstractC13926c) throws IOException {
        cloudPhotoBatch.queue(this, getResponseClass(), ErrorResp.class, abstractC13926c);
    }

    public void setAlbumClientHeader(String str) {
        C4609l headers = getHeaders();
        headers.set("x-hw-3rdapp-packagename", "com.huawei.hidisk");
        headers.set("x-hw-3rdapp-version", "16.0.0.300");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        headers.set("x-hw-trace-id", str);
    }

    public void setCacheControl(long j10) {
        this.cacheControl = j10;
    }

    public void setRiskToken() {
        String strM59527d = C9530a.m59524b().m59527d(new HashMap());
        if (TextUtils.isEmpty(strM59527d)) {
            return;
        }
        getHeaders().set("x-hw-risk-token", strM59527d);
    }
}
