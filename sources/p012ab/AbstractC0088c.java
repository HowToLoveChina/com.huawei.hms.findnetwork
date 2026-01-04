package p012ab;

import bb.C1160a;
import com.huawei.cloud.base.http.C4597b0;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.cloud.services.drive.Drive;
import com.huawei.cloud.services.drive.DriveRequest;
import java.io.IOException;

/* renamed from: ab.c */
/* loaded from: classes3.dex */
public abstract class AbstractC0088c<T> extends DriveRequest<T> {
    private Drive client;
    private String uriTemplate;

    public AbstractC0088c(Drive drive, String str, String str2, Object obj, Class<T> cls) throws IOException {
        super(drive, str, str2, obj, cls);
        this.uriTemplate = str2;
        this.client = drive;
        drive.getBaseRequestInitializer().initialize(this);
        C1160a.m7250a(getHeaders());
    }

    @Override // p579qi.AbstractC12361b
    public C4604g buildHttpRequestUrl() {
        return new C4604g(C4597b0.m28167b(this.client.getRootUrl() + "", this.uriTemplate, this, true));
    }

    @Override // p579qi.AbstractC12361b
    public T execute() throws IOException {
        return (T) super.execute();
    }
}
