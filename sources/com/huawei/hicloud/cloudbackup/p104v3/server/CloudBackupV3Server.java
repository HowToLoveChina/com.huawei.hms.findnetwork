package com.huawei.hicloud.cloudbackup.p104v3.server;

import com.huawei.cloud.base.http.InterfaceC4614q;
import com.huawei.cloud.base.util.C4641i;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Abnormal;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.About;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Backup;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Batch;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Changes;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Channels;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Recover;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Remove;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.View;
import java.util.List;
import p523oi.C11903a;
import p579qi.InterfaceC12362c;
import p583qm.C12377e;
import p614ri.AbstractC12512a;

/* loaded from: classes6.dex */
public class CloudBackupV3Server extends AbstractC12512a {
    public static final String DEFAULT_SERVICE_PATH = "cloudbackup/v3/service";

    public CloudBackupV3Server(Builder builder) {
        super(builder);
    }

    public Abnormal abnormal() {
        return new Abnormal(this);
    }

    public About about() {
        return new About(this);
    }

    public Backup backup() {
        return new Backup(this);
    }

    public Batch batchRequest() {
        return new Batch(this);
    }

    public Changes changes() {
        return new Changes(this);
    }

    public Channels channels() {
        return new Channels(this);
    }

    public Recover recover() {
        return new Recover(this);
    }

    public Remove remove() {
        return new Remove(this);
    }

    public View view() {
        return new View(this);
    }

    public static class Builder extends AbstractC12512a.a {
        public Builder(String str, String str2, InterfaceC4614q interfaceC4614q) {
            super(new C12377e(), C11903a.m71435l(), str, str2, interfaceC4614q);
            setBaseRequestInitializer((InterfaceC12362c) new CloudBackupV3RequestInitializer());
        }

        public Builder setAnonymousHeaders(List<String> list) {
            C4641i.m28437b(list);
            return this;
        }

        public Builder setLogLevel(int i10) {
            C4650r.m28486i(i10);
            return this;
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public CloudBackupV3Server build() {
            return new CloudBackupV3Server(this);
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setBaseRequestInitializer(InterfaceC12362c interfaceC12362c) {
            return (Builder) super.setBaseRequestInitializer(interfaceC12362c);
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setBatchPath(String str) {
            return (Builder) super.setBatchPath(str);
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setHttpRequestInitializer(InterfaceC4614q interfaceC4614q) {
            return (Builder) super.setHttpRequestInitializer(interfaceC4614q);
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setIgnoreRequiredParameterVerify(boolean z10) {
            return (Builder) super.setIgnoreRequiredParameterVerify(z10);
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // p614ri.AbstractC12512a.a, p579qi.AbstractC12360a.a
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }
    }
}
