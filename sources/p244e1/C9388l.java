package p244e1;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import p381j1.C10650d1;

/* renamed from: e1.l */
/* loaded from: classes.dex */
public class C9388l implements Closeable, Flushable {

    /* renamed from: a */
    public C10650d1 f46902a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f46902a.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f46902a.flush();
    }
}
