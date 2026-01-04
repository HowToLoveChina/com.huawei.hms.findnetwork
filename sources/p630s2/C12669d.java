package p630s2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* renamed from: s2.d */
/* loaded from: classes.dex */
public final class C12669d extends InputStream {

    /* renamed from: c */
    public static final Queue<C12669d> f58170c = C12677l.m76282e(0);

    /* renamed from: a */
    public InputStream f58171a;

    /* renamed from: b */
    public IOException f58172b;

    /* renamed from: t */
    public static C12669d m76255t(InputStream inputStream) {
        C12669d c12669dPoll;
        Queue<C12669d> queue = f58170c;
        synchronized (queue) {
            c12669dPoll = queue.poll();
        }
        if (c12669dPoll == null) {
            c12669dPoll = new C12669d();
        }
        c12669dPoll.m76258v(inputStream);
        return c12669dPoll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f58171a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f58171a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f58171a.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f58171a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f58171a.read();
        } catch (IOException e10) {
            this.f58172b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f58171a.reset();
    }

    /* renamed from: s */
    public IOException m76256s() {
        return this.f58172b;
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        try {
            return this.f58171a.skip(j10);
        } catch (IOException e10) {
            this.f58172b = e10;
            throw e10;
        }
    }

    /* renamed from: u */
    public void m76257u() {
        this.f58172b = null;
        this.f58171a = null;
        Queue<C12669d> queue = f58170c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    /* renamed from: v */
    public void m76258v(InputStream inputStream) {
        this.f58171a = inputStream;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f58171a.read(bArr);
        } catch (IOException e10) {
            this.f58172b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        try {
            return this.f58171a.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.f58172b = e10;
            throw e10;
        }
    }
}
