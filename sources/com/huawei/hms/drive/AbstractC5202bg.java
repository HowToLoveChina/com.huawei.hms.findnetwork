package com.huawei.hms.drive;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import p022ay.C1057g;
import p022ay.C1064n;
import p022ay.InterfaceC1055e;
import p022ay.InterfaceC1076z;

/* renamed from: com.huawei.hms.drive.bg */
/* loaded from: classes8.dex */
public abstract class AbstractC5202bg {
    public static AbstractC5202bg create(C5197bb c5197bb, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (c5197bb != null) {
            Charset charsetM31038a = c5197bb.m31038a();
            if (charsetM31038a == null) {
                c5197bb = C5197bb.m31037b(c5197bb + "; charset=utf-8");
            } else {
                charset = charsetM31038a;
            }
        }
        return create(c5197bb, str.getBytes(charset));
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract C5197bb contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(InterfaceC1055e interfaceC1055e) throws IOException;

    public static AbstractC5202bg create(final C5197bb c5197bb, final C1057g c1057g) {
        return new AbstractC5202bg() { // from class: com.huawei.hms.drive.bg.1
            @Override // com.huawei.hms.drive.AbstractC5202bg
            public long contentLength() throws IOException {
                return c1057g.m6370E();
            }

            @Override // com.huawei.hms.drive.AbstractC5202bg
            public C5197bb contentType() {
                return c5197bb;
            }

            @Override // com.huawei.hms.drive.AbstractC5202bg
            public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
                interfaceC1055e.mo6337a(c1057g);
            }
        };
    }

    public static AbstractC5202bg create(C5197bb c5197bb, byte[] bArr) {
        return create(c5197bb, bArr, 0, bArr.length);
    }

    public static AbstractC5202bg create(final C5197bb c5197bb, final byte[] bArr, final int i10, final int i11) {
        if (bArr != null) {
            C5210bo.m31190a(bArr.length, i10, i11);
            return new AbstractC5202bg() { // from class: com.huawei.hms.drive.bg.2
                @Override // com.huawei.hms.drive.AbstractC5202bg
                public long contentLength() {
                    return i11;
                }

                @Override // com.huawei.hms.drive.AbstractC5202bg
                public C5197bb contentType() {
                    return c5197bb;
                }

                @Override // com.huawei.hms.drive.AbstractC5202bg
                public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
                    interfaceC1055e.write(bArr, i10, i11);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static AbstractC5202bg create(final C5197bb c5197bb, final File file) {
        if (file != null) {
            return new AbstractC5202bg() { // from class: com.huawei.hms.drive.bg.3
                @Override // com.huawei.hms.drive.AbstractC5202bg
                public long contentLength() {
                    return file.length();
                }

                @Override // com.huawei.hms.drive.AbstractC5202bg
                public C5197bb contentType() {
                    return c5197bb;
                }

                @Override // com.huawei.hms.drive.AbstractC5202bg
                public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
                    InterfaceC1076z interfaceC1076zM6406e = C1064n.m6406e(file);
                    try {
                        interfaceC1055e.mo6328P(interfaceC1076zM6406e);
                        if (interfaceC1076zM6406e != null) {
                            interfaceC1076zM6406e.close();
                        }
                    } catch (Throwable th2) {
                        if (interfaceC1076zM6406e != null) {
                            try {
                                interfaceC1076zM6406e.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            };
        }
        throw new NullPointerException("file == null");
    }
}
