package com.huawei.hicloud.cloudbackup.p104v3.server;

import com.huawei.cloud.base.http.C4597b0;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.http.InterfaceC4608k;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchCallback;
import com.huawei.hicloud.cloudbackup.p104v3.server.batch.CloudBackupV3BatchRequest;
import java.io.IOException;
import ni.C11707b;
import p495nm.C11732m;
import p614ri.AbstractC12513b;

/* loaded from: classes6.dex */
public class CloudBackupV3Request<T> extends AbstractC12513b<T> {

    @InterfaceC4648p
    private String fields;

    @InterfaceC4648p
    private String form;

    public CloudBackupV3Request(CloudBackupV3Server cloudBackupV3Server, String str, String str2, C11707b c11707b, Class<T> cls) throws IOException {
        super(cloudBackupV3Server, str, str2, c11707b, cls);
        cloudBackupV3Server.getBaseRequestInitializer().initialize(this);
        setForm("json");
        setDisableGZip(true);
    }

    public String getFields() {
        return this.fields;
    }

    public String getForm() {
        return this.form;
    }

    public String getRequestUrl() {
        return C4597b0.m28167b(getAbstractClient().getServicePath(), getUriTemplate(), this, true);
    }

    public final void queue(CloudBackupV3BatchRequest cloudBackupV3BatchRequest, CloudBackupV3BatchCallback<T> cloudBackupV3BatchCallback) throws IOException {
        C4612o c4612oM28300d = getAbstractClient().getRequestFactory().m28300d(getRequestMethod(), buildHttpRequestUrl(), getHttpContent());
        InterfaceC4608k interfaceC4608kM28279k = c4612oM28300d.m28279k();
        if (interfaceC4608kM28279k != null) {
            interfaceC4608kM28279k.mo28207c(c4612oM28300d);
        }
        c4612oM28300d.m28277i().putAll(getHeaders());
        cloudBackupV3BatchRequest.queue(c4612oM28300d, getResponseClass(), ErrorResp.class, cloudBackupV3BatchCallback);
    }

    public CloudBackupV3Request<T> setFields(String str) {
        this.fields = str;
        return this;
    }

    public CloudBackupV3Request<T> setForm(String str) {
        this.form = str;
        return this;
    }

    public CloudBackupV3Request<T> setHeader(String str, Object obj) {
        if (obj == null || ((obj instanceof String) && C4633d0.m28404a((String) obj))) {
            return this;
        }
        getHeaders().set(str, obj);
        return this;
    }

    public CloudBackupV3Request<T> setOpSceneParam(C11732m c11732m) {
        if (c11732m == null) {
            return this;
        }
        setHeader("x-hw-op-scene", c11732m.m70017a());
        setHeader("x-hw-extend-fields", c11732m.m70018b());
        return this;
    }

    public CloudBackupV3Request<T> setTraceId(String str) {
        return setHeader("x-hw-trace-id", str);
    }

    @Override // p614ri.AbstractC12513b, p579qi.AbstractC12361b
    public CloudBackupV3Server getAbstractClient() {
        return (CloudBackupV3Server) super.getAbstractClient();
    }

    @Override // p614ri.AbstractC12513b, p579qi.AbstractC12361b
    public CloudBackupV3Request<T> setDisableGZip(boolean z10) {
        return (CloudBackupV3Request) super.setDisableGZip(z10);
    }

    @Override // p614ri.AbstractC12513b, p579qi.AbstractC12361b
    public CloudBackupV3Request<T> setHeaders(C4609l c4609l) {
        return (CloudBackupV3Request) super.setHeaders(c4609l);
    }

    @Override // p614ri.AbstractC12513b, p579qi.AbstractC12361b, com.huawei.cloud.base.util.C4646n
    public CloudBackupV3Request<T> set(String str, Object obj) {
        return (CloudBackupV3Request) super.set(str, obj);
    }
}
