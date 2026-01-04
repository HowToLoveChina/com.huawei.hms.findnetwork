package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import p022ay.C1054d;
import p022ay.InterfaceC1056f;
import sx.C12875e;

/* renamed from: okhttp3.h0 */
/* loaded from: classes9.dex */
public abstract class AbstractC11924h0 implements Closeable {

    /* renamed from: okhttp3.h0$a */
    public class a extends AbstractC11924h0 {

        /* renamed from: a */
        public final /* synthetic */ C11910a0 f55327a;

        /* renamed from: b */
        public final /* synthetic */ long f55328b;

        /* renamed from: c */
        public final /* synthetic */ InterfaceC1056f f55329c;

        public a(C11910a0 c11910a0, long j10, InterfaceC1056f interfaceC1056f) {
            this.f55327a = c11910a0;
            this.f55328b = j10;
            this.f55329c = interfaceC1056f;
        }

        @Override // okhttp3.AbstractC11924h0
        /* renamed from: u */
        public long mo71634u() {
            return this.f55328b;
        }

        @Override // okhttp3.AbstractC11924h0
        /* renamed from: v */
        public C11910a0 mo71635v() {
            return this.f55327a;
        }

        @Override // okhttp3.AbstractC11924h0
        /* renamed from: y */
        public InterfaceC1056f mo71636y() {
            return this.f55329c;
        }
    }

    /* renamed from: w */
    public static AbstractC11924h0 m71630w(C11910a0 c11910a0, long j10, InterfaceC1056f interfaceC1056f) {
        if (interfaceC1056f != null) {
            return new a(c11910a0, j10, interfaceC1056f);
        }
        throw new NullPointerException("source == null");
    }

    /* renamed from: x */
    public static AbstractC11924h0 m71631x(C11910a0 c11910a0, byte[] bArr) {
        return m71630w(c11910a0, bArr.length, new C1054d().write(bArr));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C12875e.m77250g(mo71636y());
    }

    /* renamed from: s */
    public final InputStream m71632s() {
        return mo71636y().mo6318E0();
    }

    /* renamed from: t */
    public final Charset m71633t() {
        C11910a0 c11910a0Mo71635v = mo71635v();
        return c11910a0Mo71635v != null ? c11910a0Mo71635v.m71447b(StandardCharsets.UTF_8) : StandardCharsets.UTF_8;
    }

    /* renamed from: u */
    public abstract long mo71634u();

    /* renamed from: v */
    public abstract C11910a0 mo71635v();

    /* renamed from: y */
    public abstract InterfaceC1056f mo71636y();

    /* renamed from: z */
    public final String m71637z() throws IOException {
        InterfaceC1056f interfaceC1056fMo71636y = mo71636y();
        try {
            String strMo6331T = interfaceC1056fMo71636y.mo6331T(C12875e.m77246c(interfaceC1056fMo71636y, m71633t()));
            interfaceC1056fMo71636y.close();
            return strMo6331T;
        } catch (Throwable th2) {
            if (interfaceC1056fMo71636y != null) {
                try {
                    interfaceC1056fMo71636y.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }
}
