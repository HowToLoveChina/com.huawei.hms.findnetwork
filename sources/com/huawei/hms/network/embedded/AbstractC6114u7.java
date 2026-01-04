package com.huawei.hms.network.embedded;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* renamed from: com.huawei.hms.network.embedded.u7 */
/* loaded from: classes8.dex */
public abstract class AbstractC6114u7 {

    /* renamed from: com.huawei.hms.network.embedded.u7$a */
    public class a extends AbstractC6114u7 {

        /* renamed from: a */
        public final /* synthetic */ C6036o7 f28512a;

        /* renamed from: b */
        public final /* synthetic */ C5910eb f28513b;

        public a(C6036o7 c6036o7, C5910eb c5910eb) {
            this.f28512a = c6036o7;
            this.f28513b = c5910eb;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6114u7
        public long contentLength() throws IOException {
            return this.f28513b.mo34192j();
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6114u7
        public C6036o7 contentType() {
            return this.f28512a;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6114u7
        public void writeTo(InterfaceC5882cb interfaceC5882cb) throws IOException {
            interfaceC5882cb.mo33928a(this.f28513b);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.u7$b */
    public class b extends AbstractC6114u7 {

        /* renamed from: a */
        public final /* synthetic */ C6036o7 f28514a;

        /* renamed from: b */
        public final /* synthetic */ int f28515b;

        /* renamed from: c */
        public final /* synthetic */ byte[] f28516c;

        /* renamed from: d */
        public final /* synthetic */ int f28517d;

        public b(C6036o7 c6036o7, int i10, byte[] bArr, int i11) {
            this.f28514a = c6036o7;
            this.f28515b = i10;
            this.f28516c = bArr;
            this.f28517d = i11;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6114u7
        public long contentLength() {
            return this.f28515b;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6114u7
        public C6036o7 contentType() {
            return this.f28514a;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6114u7
        public void writeTo(InterfaceC5882cb interfaceC5882cb) throws IOException {
            interfaceC5882cb.write(this.f28516c, this.f28517d, this.f28515b);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.u7$c */
    public class c extends AbstractC6114u7 {

        /* renamed from: a */
        public final /* synthetic */ C6036o7 f28518a;

        /* renamed from: b */
        public final /* synthetic */ File f28519b;

        public c(C6036o7 c6036o7, File file) {
            this.f28518a = c6036o7;
            this.f28519b = file;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6114u7
        public long contentLength() {
            return this.f28519b.length();
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6114u7
        public C6036o7 contentType() {
            return this.f28518a;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6114u7
        public void writeTo(InterfaceC5882cb interfaceC5882cb) throws IOException {
            InterfaceC6183zb interfaceC6183zbM34948c = C6040ob.m34948c(this.f28519b);
            try {
                interfaceC5882cb.mo33922a(interfaceC6183zbM34948c);
                if (interfaceC6183zbM34948c != null) {
                    interfaceC6183zbM34948c.close();
                }
            } catch (Throwable th2) {
                if (interfaceC6183zbM34948c != null) {
                    try {
                        interfaceC6183zbM34948c.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static AbstractC6114u7 create(C6036o7 c6036o7, C5910eb c5910eb) {
        return new a(c6036o7, c5910eb);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract C6036o7 contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(InterfaceC5882cb interfaceC5882cb) throws IOException;

    public static AbstractC6114u7 create(C6036o7 c6036o7, File file) {
        if (file != null) {
            return new c(c6036o7, file);
        }
        throw new NullPointerException("file == null");
    }

    public static AbstractC6114u7 create(C6036o7 c6036o7, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (c6036o7 != null) {
            Charset charsetM34924a = c6036o7.m34924a();
            if (charsetM34924a == null) {
                c6036o7 = C6036o7.m34923b(c6036o7 + "; charset=utf-8");
            } else {
                charset = charsetM34924a;
            }
        }
        return create(c6036o7, str.getBytes(charset));
    }

    public static AbstractC6114u7 create(C6036o7 c6036o7, byte[] bArr) {
        return create(c6036o7, bArr, 0, bArr.length);
    }

    public static AbstractC6114u7 create(C6036o7 c6036o7, byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        C5920f8.m34247a(bArr.length, i10, i11);
        return new b(c6036o7, i11, bArr, i10);
    }
}
