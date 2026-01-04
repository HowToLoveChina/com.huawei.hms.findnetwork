package com.huawei.hms.network.embedded;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* renamed from: com.huawei.hms.network.embedded.w7 */
/* loaded from: classes8.dex */
public abstract class AbstractC6140w7 implements Closeable {

    /* renamed from: a */
    public Reader f28846a;

    /* renamed from: com.huawei.hms.network.embedded.w7$a */
    public class a extends AbstractC6140w7 {

        /* renamed from: b */
        public final /* synthetic */ C6036o7 f28847b;

        /* renamed from: c */
        public final /* synthetic */ long f28848c;

        /* renamed from: d */
        public final /* synthetic */ InterfaceC5896db f28849d;

        public a(C6036o7 c6036o7, long j10, InterfaceC5896db interfaceC5896db) {
            this.f28847b = c6036o7;
            this.f28848c = j10;
            this.f28849d = interfaceC5896db;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6140w7
        /* renamed from: v */
        public long mo34710v() {
            return this.f28848c;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6140w7
        /* renamed from: w */
        public C6036o7 mo34711w() {
            return this.f28847b;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6140w7
        /* renamed from: x */
        public InterfaceC5896db mo34712x() {
            return this.f28849d;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.w7$b */
    public static final class b extends Reader {

        /* renamed from: a */
        public final InterfaceC5896db f28850a;

        /* renamed from: b */
        public final Charset f28851b;

        /* renamed from: c */
        public boolean f28852c;

        /* renamed from: d */
        public Reader f28853d;

        public b(InterfaceC5896db interfaceC5896db, Charset charset) {
            this.f28850a = interfaceC5896db;
            this.f28851b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f28852c = true;
            Reader reader = this.f28853d;
            if (reader != null) {
                reader.close();
            } else {
                this.f28850a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) throws IOException {
            if (this.f28852c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.f28853d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f28850a.mo33977m(), C5920f8.m34240a(this.f28850a, this.f28851b));
                this.f28853d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i10, i11);
        }
    }

    /* renamed from: a */
    public static AbstractC6140w7 m35731a(C6036o7 c6036o7, long j10, InterfaceC5896db interfaceC5896db) {
        if (interfaceC5896db != null) {
            return new a(c6036o7, j10, interfaceC5896db);
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: z */
    private Charset m35735z() {
        C6036o7 c6036o7Mo34711w = mo34711w();
        return c6036o7Mo34711w != null ? c6036o7Mo34711w.m34925a(StandardCharsets.UTF_8) : StandardCharsets.UTF_8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C5920f8.m34248a(mo34712x());
    }

    /* renamed from: s */
    public final InputStream m35736s() {
        return mo34712x().mo33977m();
    }

    /* renamed from: t */
    public final byte[] m35737t() throws IOException {
        long jMo34710v = mo34710v();
        if (jMo34710v > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + jMo34710v);
        }
        InterfaceC5896db interfaceC5896dbMo34712x = mo34712x();
        try {
            byte[] bArrMo33981q = interfaceC5896dbMo34712x.mo33981q();
            interfaceC5896dbMo34712x.close();
            if (jMo34710v == -1 || jMo34710v == bArrMo33981q.length) {
                return bArrMo33981q;
            }
            throw new IOException("Content-Length (" + jMo34710v + ") and stream length (" + bArrMo33981q.length + ") disagree");
        } catch (Throwable th2) {
            if (interfaceC5896dbMo34712x != null) {
                try {
                    interfaceC5896dbMo34712x.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    /* renamed from: u */
    public final Reader m35738u() {
        Reader reader = this.f28846a;
        if (reader != null) {
            return reader;
        }
        b bVar = new b(mo34712x(), m35735z());
        this.f28846a = bVar;
        return bVar;
    }

    /* renamed from: v */
    public abstract long mo34710v();

    /* renamed from: w */
    public abstract C6036o7 mo34711w();

    /* renamed from: x */
    public abstract InterfaceC5896db mo34712x();

    /* renamed from: y */
    public final String m35739y() throws IOException {
        InterfaceC5896db interfaceC5896dbMo34712x = mo34712x();
        try {
            String strMo33940a = interfaceC5896dbMo34712x.mo33940a(C5920f8.m34240a(interfaceC5896dbMo34712x, m35735z()));
            interfaceC5896dbMo34712x.close();
            return strMo33940a;
        } catch (Throwable th2) {
            if (interfaceC5896dbMo34712x != null) {
                try {
                    interfaceC5896dbMo34712x.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    /* renamed from: a */
    public static AbstractC6140w7 m35732a(C6036o7 c6036o7, C5910eb c5910eb) {
        return m35731a(c6036o7, c5910eb.mo34192j(), new C5868bb().mo33928a(c5910eb));
    }

    /* renamed from: a */
    public static AbstractC6140w7 m35733a(C6036o7 c6036o7, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (c6036o7 != null) {
            Charset charsetM34924a = c6036o7.m34924a();
            if (charsetM34924a == null) {
                c6036o7 = C6036o7.m34923b(c6036o7 + "; charset=utf-8");
            } else {
                charset = charsetM34924a;
            }
        }
        C5868bb c5868bbMo33937a = new C5868bb().mo33937a(str, charset);
        return m35731a(c6036o7, c5868bbMo33937a.m33913B(), c5868bbMo33937a);
    }

    /* renamed from: a */
    public static AbstractC6140w7 m35734a(C6036o7 c6036o7, byte[] bArr) {
        return m35731a(c6036o7, bArr.length, new C5868bb().write(bArr));
    }
}
