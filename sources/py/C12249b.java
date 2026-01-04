package py;

import java.io.FilterInputStream;
import java.io.InputStream;

/* renamed from: py.b */
/* loaded from: classes9.dex */
public class C12249b extends AbstractC12253f {
    @Deprecated
    public C12249b(InputStream inputStream) {
        super(inputStream);
    }

    /* renamed from: g */
    public static C12249b m73500g(InputStream inputStream) {
        return new C12249b(inputStream);
    }

    @Override // py.AbstractC12253f, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterInputStream) this).in = C12250c.f56652a;
    }
}
