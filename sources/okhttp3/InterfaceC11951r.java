package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* renamed from: okhttp3.r */
/* loaded from: classes9.dex */
public interface InterfaceC11951r {

    /* renamed from: d */
    public static final InterfaceC11951r f55643d = new InterfaceC11951r() { // from class: okhttp3.q
        @Override // okhttp3.InterfaceC11951r
        public final List lookup(String str) {
            return InterfaceC11951r.m71839a(str);
        }
    };

    /* renamed from: a */
    static /* synthetic */ List m71839a(String str) throws UnknownHostException {
        if (str == null) {
            throw new UnknownHostException("hostname == null");
        }
        try {
            return Arrays.asList(InetAddress.getAllByName(str));
        } catch (NullPointerException e10) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
            unknownHostException.initCause(e10);
            throw unknownHostException;
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
