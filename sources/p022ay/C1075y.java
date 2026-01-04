package p022ay;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import p692uw.C13267j;

/* renamed from: ay.y */
/* loaded from: classes9.dex */
public final class C1075y extends C1053c {

    /* renamed from: b */
    public final Socket f5181b;

    public C1075y(Socket socket) {
        C13267j.m79677e(socket, "socket");
        this.f5181b = socket;
    }

    @Override // p022ay.C1053c
    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // p022ay.C1053c
    public void timedOut() throws IOException {
        try {
            this.f5181b.close();
        } catch (AssertionError e10) {
            if (!C1064n.m6404c(e10)) {
                throw e10;
            }
            C1065o.f5152a.log(Level.WARNING, "Failed to close timed out socket " + this.f5181b, (Throwable) e10);
        } catch (Exception e11) {
            C1065o.f5152a.log(Level.WARNING, "Failed to close timed out socket " + this.f5181b, (Throwable) e11);
        }
    }
}
