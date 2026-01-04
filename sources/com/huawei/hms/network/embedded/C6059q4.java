package com.huawei.hms.network.embedded;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.netdiag.tools.NetDetectAndPolicy;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.q4 */
/* loaded from: classes8.dex */
public class C6059q4 extends AbstractC6046p4 {

    /* renamed from: i */
    public static final String f27843i = "NetDiagManagerImpl";

    /* renamed from: e */
    public boolean f27844e;

    /* renamed from: f */
    public C5995l5 f27845f;

    /* renamed from: g */
    public NetDetectAndPolicy f27846g;

    /* renamed from: h */
    public AtomicBoolean f27847h = new AtomicBoolean(false);

    public C6059q4() {
        C5995l5 c5995l5 = new C5995l5();
        this.f27845f = c5995l5;
        this.f27846g = new NetDetectAndPolicy(c5995l5);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: a */
    public LinkedHashMapPack mo34964a(String str) {
        return new LinkedHashMapPack();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: b */
    public String mo34971b() {
        return C6034o5.m34919c().m34920a();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: c */
    public Map<String, Integer> mo34974c() {
        return NetworkUtil.getLteSignalInfo(ContextHolder.getResourceContext());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: d */
    public void mo34976d() {
        if (this.f27847h.get()) {
            this.f27845f.m34656a();
        } else {
            Logger.m32145w(f27843i, "start has error! pls check init is ok?");
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: a */
    public C6021n5 mo34965a(String str, List<InetAddress> list) throws JSONException {
        String str2;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            str2 = "domain or addressList is empty";
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject = new JSONObject().put("enable_site_detect", true);
            } catch (JSONException e10) {
                Logger.m32146w(f27843i, "recordMap fail to put: ", e10);
            }
            try {
                Submit<ResponseBody> submitNewSubmit = AbstractC6046p4.m34962e().newSubmit(AbstractC6046p4.m34962e().newRequest().url("https://" + str).method("GET").tag(list).options(jSONObject.toString()).build());
                Response<ResponseBody> responseExecute = submitNewSubmit.execute();
                if (responseExecute == null) {
                    Logger.m32145w(f27843i, "Connect detect response is null");
                    return null;
                }
                Logger.m32142i(f27843i, "Site detect domain %s status is %d ", str, Integer.valueOf(responseExecute.getCode()));
                return new C6021n5(submitNewSubmit.getRequestFinishedInfo());
            } catch (IOException unused) {
                str2 = "Connect detect failed";
            }
        }
        Logger.m32145w(f27843i, str2);
        return null;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: b */
    public void mo34972b(boolean z10) {
        this.f27844e = z10;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: c */
    public void mo34975c(boolean z10) {
        if (!this.f27847h.get()) {
            Logger.m32145w(f27843i, "stop has error! pls check init is ok?");
            return;
        }
        this.f27845f.m34656a();
        if (this.f27844e) {
            this.f27846g.executeDetectPolicy(Boolean.valueOf(z10));
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: a */
    public C6099t5 mo34966a(boolean z10) {
        return C6073r5.m35195a().m35198a(z10);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: b */
    public boolean mo34973b(long j10, long j11) {
        return this.f27846g.networkUnavailable(j10, j11);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: a */
    public AbstractC6176z4 mo34967a(long j10, long j11) {
        return this.f27847h.get() ? this.f27846g.netDetDiagInfo(j10, j11) : new C5848a5();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: a */
    public void mo34968a(Context context) {
        if (context == null) {
            Logger.m32145w(f27843i, "context == null");
        } else if (this.f27847h.compareAndSet(false, true)) {
            C5994l4.m34650b().m34652a(new C6008m5(this.f27845f));
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: a */
    public void mo34969a(Interceptor.Chain chain) {
        C6034o5.m34919c().m34921a(chain);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6046p4
    /* renamed from: a */
    public boolean mo34970a() {
        if (this.f27847h.get()) {
            return this.f27846g.executeDetectPolicy();
        }
        return false;
    }
}
