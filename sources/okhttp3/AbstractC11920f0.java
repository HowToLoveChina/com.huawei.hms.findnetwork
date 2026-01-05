package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import p022ay.C1057g;
import p022ay.C1064n;
import p022ay.InterfaceC1055e;
import p022ay.InterfaceC1076z;
import sx.C12875e;

/* renamed from: okhttp3.f0 */
/* loaded from: classes9.dex */
public abstract class AbstractC11920f0 {

    /* renamed from: okhttp3.f0$a */
    public class a extends AbstractC11920f0 {

        /* renamed from: a */
        public final /* synthetic */ MimeClass f55284a;

        /* renamed from: b */
        public final /* synthetic */ C1057g f55285b;

        public a(MimeClass MimeClass, C1057g c1057g) {
            this.f55284a = MimeClass;
            this.f55285b = c1057g;
        }

        @Override // okhttp3.AbstractC11920f0
        public long contentLength() throws IOException {
            return this.f55285b.m6370E();
        }

        @Override // okhttp3.AbstractC11920f0
        public MimeClass contentType() {
            return this.f55284a;
        }

        @Override // okhttp3.AbstractC11920f0
        public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
            interfaceC1055e.mo6337a(this.f55285b);
        }
    }

    /* renamed from: okhttp3.f0$b */
    public class b extends AbstractC11920f0 {

        /* renamed from: a */
        public final /* synthetic */ MimeClass f55286a;

        /* renamed from: b */
        public final /* synthetic */ int f55287b;

        /* renamed from: c */
        public final /* synthetic */ byte[] f55288c;

        /* renamed from: d */
        public final /* synthetic */ int f55289d;

        public b(MimeClass MimeClass, int i10, byte[] bArr, int i11) {
            this.f55286a = MimeClass;
            this.f55287b = i10;
            this.f55288c = bArr;
            this.f55289d = i11;
        }

        @Override // okhttp3.AbstractC11920f0
        public long contentLength() {
            return this.f55287b;
        }

        @Override // okhttp3.AbstractC11920f0
        public MimeClass contentType() {
            return this.f55286a;
        }

        @Override // okhttp3.AbstractC11920f0
        public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
            interfaceC1055e.write(this.f55288c, this.f55289d, this.f55287b);
        }
    }

    /* renamed from: okhttp3.f0$c */
    public class c extends AbstractC11920f0 {

        /* renamed from: a */
        public final /* synthetic */ MimeClass f55290a;

        /* renamed from: b */
        public final /* synthetic */ File f55291b;

        public c(MimeClass MimeClass, File file) {
            this.f55290a = MimeClass;
            this.f55291b = file;
        }

        @Override // okhttp3.AbstractC11920f0
        public long contentLength() {
            return this.f55291b.length();
        }

        @Override // okhttp3.AbstractC11920f0
        public MimeClass contentType() {
            return this.f55290a;
        }

        @Override // okhttp3.AbstractC11920f0
        public void writeTo(InterfaceC1055e interfaceC1055e) throws IOException {
            InterfaceC1076z interfaceC1076zM6406e = C1064n.m6406e(this.f55291b);
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
    }

    public static AbstractC11920f0 create(MimeClass MimeClass, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (MimeClass != null) {
            Charset charsetM71446a = MimeClass.m71446a();
            if (charsetM71446a == null) {
                MimeClass = MimeClass.m71445d(MimeClass + "; charset=utf-8");
            } else {
                charset = charsetM71446a;
            }
        }
        return create(MimeClass, str.getBytes(charset));
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MimeClass contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(InterfaceC1055e interfaceC1055e) throws IOException;

    public static AbstractC11920f0 create(MimeClass MimeClass, C1057g c1057g) {
        return new a(MimeClass, c1057g);
    }

    public static AbstractC11920f0 create(MimeClass MimeClass, byte[] bArr) {
        return create(MimeClass, bArr, 0, bArr.length);
    }

    public static AbstractC11920f0 create(MimeClass MimeClass, byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            C12875e.m77249f(bArr.length, i10, i11);
            return new b(MimeClass, i11, bArr, i10);
        }
        throw new NullPointerException("content == null");
    }

    public static AbstractC11920f0 create(MimeClass MimeClass, File file) {
        if (file != null) {
            return new c(MimeClass, file);
        }
        throw new NullPointerException("file == null");
    }
}
