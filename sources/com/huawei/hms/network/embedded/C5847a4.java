package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C5939h1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;

/* renamed from: com.huawei.hms.network.embedded.a4 */
/* loaded from: classes8.dex */
public class C5847a4 extends AbstractC6114u7 {

    /* renamed from: b */
    public static final String f26338b = "OkRequestBody";

    /* renamed from: a */
    public final C5939h1.e f26339a;

    public C5847a4(C5939h1.e eVar) {
        this.f26339a = eVar;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6114u7
    public long contentLength() throws IOException {
        return this.f26339a.contentLength();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6114u7
    public C6036o7 contentType() {
        String strContentType = this.f26339a.contentType();
        if (strContentType == null) {
            return null;
        }
        return C6036o7.m34923b(strContentType);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6114u7
    public boolean isDuplex() {
        return this.f26339a.isDuplex();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6114u7
    public void writeTo(InterfaceC5882cb interfaceC5882cb) throws IOException {
        C5861b4 c5861b4 = new C5861b4(interfaceC5882cb);
        try {
            this.f26339a.writeTo(c5861b4);
            if (isDuplex()) {
                return;
            }
            c5861b4.close();
        } catch (FileNotFoundException e10) {
            Logger.m32145w(f26338b, "the requestBody with writeTo has error! and the FileNotFound must be changed to InterruptedIOException");
            IoUtils.closeSecure((OutputStream) c5861b4);
            throw new InterruptedIOException(e10.getMessage());
        } catch (IOException e11) {
            Logger.m32145w(f26338b, "the requestBody with writeTo has other error");
            IoUtils.closeSecure((OutputStream) c5861b4);
            throw e11;
        }
    }
}
