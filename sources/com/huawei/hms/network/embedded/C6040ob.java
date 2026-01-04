package com.huawei.hms.network.embedded;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* renamed from: com.huawei.hms.network.embedded.ob */
/* loaded from: classes8.dex */
public final class C6040ob {

    /* renamed from: a */
    public static final Logger f27633a = Logger.getLogger(C6040ob.class.getName());

    /* renamed from: com.huawei.hms.network.embedded.ob$a */
    public class a implements InterfaceC6170yb {

        /* renamed from: a */
        public final /* synthetic */ C5855ac f27634a;

        /* renamed from: b */
        public final /* synthetic */ OutputStream f27635b;

        public a(C5855ac c5855ac, OutputStream outputStream) {
            this.f27634a = c5855ac;
            this.f27635b = outputStream;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            this.f27635b.close();
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
        public void flush() throws IOException {
            this.f27635b.flush();
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return this.f27634a;
        }

        public String toString() {
            return "sink(" + this.f27635b + ")";
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public void write(C5868bb c5868bb, long j10) throws IOException {
            C5883cc.m34088a(c5868bb.f26524b, 0L, j10);
            while (j10 > 0) {
                this.f27634a.throwIfReached();
                C6131vb c6131vb = c5868bb.f26523a;
                int iMin = (int) Math.min(j10, c6131vb.f28800c - c6131vb.f28799b);
                this.f27635b.write(c6131vb.f28798a, c6131vb.f28799b, iMin);
                int i10 = c6131vb.f28799b + iMin;
                c6131vb.f28799b = i10;
                long j11 = iMin;
                j10 -= j11;
                c5868bb.f26524b -= j11;
                if (i10 == c6131vb.f28800c) {
                    c5868bb.f26523a = c6131vb.m35704b();
                    C6144wb.m35761a(c6131vb);
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.ob$b */
    public class b implements InterfaceC6183zb {

        /* renamed from: a */
        public final /* synthetic */ C5855ac f27636a;

        /* renamed from: b */
        public final /* synthetic */ InputStream f27637b;

        public b(C5855ac c5855ac, InputStream inputStream) {
            this.f27636a = c5855ac;
            this.f27637b = inputStream;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void close() throws IOException {
            this.f27637b.close();
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
        public long read(C5868bb c5868bb, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (j10 == 0) {
                return 0L;
            }
            try {
                this.f27636a.throwIfReached();
                C6131vb c6131vbM33961e = c5868bb.m33961e(1);
                int i10 = this.f27637b.read(c6131vbM33961e.f28798a, c6131vbM33961e.f28800c, (int) Math.min(j10, 8192 - c6131vbM33961e.f28800c));
                if (i10 != -1) {
                    c6131vbM33961e.f28800c += i10;
                    long j11 = i10;
                    c5868bb.f26524b += j11;
                    return j11;
                }
                if (c6131vbM33961e.f28799b != c6131vbM33961e.f28800c) {
                    return -1L;
                }
                c5868bb.f26523a = c6131vbM33961e.m35704b();
                C6144wb.m35761a(c6131vbM33961e);
                return -1L;
            } catch (AssertionError e10) {
                if (C6040ob.m34943a(e10)) {
                    throw new IOException(e10);
                }
                throw e10;
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return this.f27636a;
        }

        public String toString() {
            return "source(" + this.f27637b + ")";
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.ob$c */
    public class c implements InterfaceC6170yb {
        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
        public void flush() throws IOException {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return C5855ac.f26380d;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public void write(C5868bb c5868bb, long j10) throws IOException {
            c5868bb.skip(j10);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.ob$d */
    public class d extends C6182za {

        /* renamed from: l */
        public final /* synthetic */ Socket f27638l;

        public d(Socket socket) {
            this.f27638l = socket;
        }

        @Override // com.huawei.hms.network.embedded.C6182za
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hms.network.embedded.C6182za
        public void timedOut() throws IOException {
            Level level;
            StringBuilder sb2;
            Logger logger;
            Exception exc;
            try {
                this.f27638l.close();
            } catch (AssertionError e10) {
                if (!C6040ob.m34943a(e10)) {
                    throw e10;
                }
                Logger logger2 = C6040ob.f27633a;
                level = Level.WARNING;
                sb2 = new StringBuilder();
                exc = e10;
                logger = logger2;
                sb2.append("Failed to close timed out socket ");
                sb2.append(this.f27638l);
                logger.log(level, sb2.toString(), (Throwable) exc);
            } catch (Exception e11) {
                Logger logger3 = C6040ob.f27633a;
                level = Level.WARNING;
                sb2 = new StringBuilder();
                exc = e11;
                logger = logger3;
                sb2.append("Failed to close timed out socket ");
                sb2.append(this.f27638l);
                logger.log(level, sb2.toString(), (Throwable) exc);
            }
        }
    }

    /* renamed from: a */
    public static InterfaceC5882cb m34933a(InterfaceC6170yb interfaceC6170yb) {
        return new C6105tb(interfaceC6170yb);
    }

    /* renamed from: b */
    public static InterfaceC6170yb m34944b(File file) throws FileNotFoundException {
        if (file != null) {
            return m34937a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: c */
    public static C6182za m34947c(Socket socket) {
        return new d(socket);
    }

    /* renamed from: a */
    public static InterfaceC5896db m34934a(InterfaceC6183zb interfaceC6183zb) {
        return new C6118ub(interfaceC6183zb);
    }

    /* renamed from: b */
    public static InterfaceC6183zb m34945b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        C6182za c6182zaM34947c = m34947c(socket);
        return c6182zaM34947c.m35957a(m34942a(socket.getInputStream(), c6182zaM34947c));
    }

    /* renamed from: c */
    public static InterfaceC6183zb m34948c(File file) throws FileNotFoundException {
        if (file != null) {
            return m34941a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: a */
    public static InterfaceC6170yb m34935a() {
        return new c();
    }

    @IgnoreJRERequirement
    /* renamed from: b */
    public static InterfaceC6183zb m34946b(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return m34941a(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    /* renamed from: a */
    public static InterfaceC6170yb m34936a(File file) throws FileNotFoundException {
        if (file != null) {
            return m34937a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: a */
    public static InterfaceC6170yb m34937a(OutputStream outputStream) {
        return m34938a(outputStream, new C5855ac());
    }

    /* renamed from: a */
    public static InterfaceC6170yb m34938a(OutputStream outputStream, C5855ac c5855ac) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (c5855ac != null) {
            return new a(c5855ac, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    /* renamed from: a */
    public static InterfaceC6170yb m34939a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        C6182za c6182zaM34947c = m34947c(socket);
        return c6182zaM34947c.m35956a(m34938a(socket.getOutputStream(), c6182zaM34947c));
    }

    @IgnoreJRERequirement
    /* renamed from: a */
    public static InterfaceC6170yb m34940a(Path path, OpenOption... openOptionArr) throws IOException {
        if (path != null) {
            return m34937a(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    /* renamed from: a */
    public static InterfaceC6183zb m34941a(InputStream inputStream) {
        return m34942a(inputStream, new C5855ac());
    }

    /* renamed from: a */
    public static InterfaceC6183zb m34942a(InputStream inputStream, C5855ac c5855ac) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (c5855ac != null) {
            return new b(c5855ac, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    /* renamed from: a */
    public static boolean m34943a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
