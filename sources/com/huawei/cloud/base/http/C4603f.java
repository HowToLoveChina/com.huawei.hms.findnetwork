package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4650r;
import com.huawei.cloud.base.util.InterfaceC4631c0;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.huawei.cloud.base.http.f */
/* loaded from: classes.dex */
public class C4603f implements InterfaceC4606i {

    /* renamed from: a */
    public static final C4650r f21154a = C4650r.m28485f("GZipEncoding");

    /* renamed from: com.huawei.cloud.base.http.f$a */
    public class a extends BufferedOutputStream {
        public a(OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                flush();
            } catch (IOException e10) {
                C4603f.f21154a.m28487b(e10.toString());
            }
        }
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4606i
    /* renamed from: a */
    public void mo28190a(InterfaceC4631c0 interfaceC4631c0, OutputStream outputStream) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new a(outputStream));
        interfaceC4631c0.mo28157a(gZIPOutputStream);
        gZIPOutputStream.close();
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4606i
    public String getName() {
        return Constants.GZIP;
    }
}
