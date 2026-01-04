package p022ay;

import ax.C1046p;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import p692uw.C13267j;

/* renamed from: ay.o */
/* loaded from: classes9.dex */
public final /* synthetic */ class C1065o {

    /* renamed from: a */
    public static final Logger f5152a = Logger.getLogger("okio.Okio");

    /* renamed from: b */
    public static final boolean m6410b(AssertionError assertionError) {
        String message;
        C13267j.m79677e(assertionError, "<this>");
        return (assertionError.getCause() == null || (message = assertionError.getMessage()) == null || !C1046p.m6272k(message, "getsockname failed", false, 2, null)) ? false : true;
    }

    /* renamed from: c */
    public static final InterfaceC1074x m6411c(Socket socket) throws IOException {
        C13267j.m79677e(socket, "<this>");
        C1075y c1075y = new C1075y(socket);
        OutputStream outputStream = socket.getOutputStream();
        C13267j.m79676d(outputStream, "getOutputStream()");
        return c1075y.sink(new C1068r(outputStream, c1075y));
    }

    /* renamed from: d */
    public static final InterfaceC1076z m6412d(File file) throws FileNotFoundException {
        C13267j.m79677e(file, "<this>");
        return new C1063m(new FileInputStream(file), C1050a0.NONE);
    }

    /* renamed from: e */
    public static final InterfaceC1076z m6413e(InputStream inputStream) {
        C13267j.m79677e(inputStream, "<this>");
        return new C1063m(inputStream, new C1050a0());
    }

    /* renamed from: f */
    public static final InterfaceC1076z m6414f(Socket socket) throws IOException {
        C13267j.m79677e(socket, "<this>");
        C1075y c1075y = new C1075y(socket);
        InputStream inputStream = socket.getInputStream();
        C13267j.m79676d(inputStream, "getInputStream()");
        return c1075y.source(new C1063m(inputStream, c1075y));
    }
}
