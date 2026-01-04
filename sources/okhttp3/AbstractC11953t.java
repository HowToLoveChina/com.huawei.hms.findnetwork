package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* renamed from: okhttp3.t */
/* loaded from: classes9.dex */
public abstract class AbstractC11953t {
    public static final AbstractC11953t NONE = new a();

    /* renamed from: okhttp3.t$a */
    public class a extends AbstractC11953t {
    }

    /* renamed from: okhttp3.t$b */
    public interface b {
        /* renamed from: a */
        AbstractC11953t mo71841a(InterfaceC11919f interfaceC11919f);
    }

    public static b factory(final AbstractC11953t abstractC11953t) {
        return new b() { // from class: okhttp3.s
            @Override // okhttp3.AbstractC11953t.b
            /* renamed from: a */
            public final AbstractC11953t mo71841a(InterfaceC11919f interfaceC11919f) {
                return AbstractC11953t.lambda$factory$0(this.f55644a, interfaceC11919f);
            }
        };
    }

    public static /* synthetic */ AbstractC11953t lambda$factory$0(AbstractC11953t abstractC11953t, InterfaceC11919f interfaceC11919f) {
        return abstractC11953t;
    }

    public void callEnd(InterfaceC11919f interfaceC11919f) {
    }

    public void callFailed(InterfaceC11919f interfaceC11919f, IOException iOException) {
    }

    public void callStart(InterfaceC11919f interfaceC11919f) {
    }

    public void connectEnd(InterfaceC11919f interfaceC11919f, InetSocketAddress inetSocketAddress, Proxy proxy, EnumC11914c0 enumC11914c0) {
    }

    public void connectFailed(InterfaceC11919f interfaceC11919f, InetSocketAddress inetSocketAddress, Proxy proxy, EnumC11914c0 enumC11914c0, IOException iOException) {
    }

    public void connectStart(InterfaceC11919f interfaceC11919f, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void connectionAcquired(InterfaceC11919f interfaceC11919f, InterfaceC11944k interfaceC11944k) {
    }

    public void connectionReleased(InterfaceC11919f interfaceC11919f, InterfaceC11944k interfaceC11944k) {
    }

    public void dnsEnd(InterfaceC11919f interfaceC11919f, String str, List<InetAddress> list) {
    }

    public void dnsStart(InterfaceC11919f interfaceC11919f, String str) {
    }

    public void requestBodyEnd(InterfaceC11919f interfaceC11919f, long j10) {
    }

    public void requestBodyStart(InterfaceC11919f interfaceC11919f) {
    }

    public void requestFailed(InterfaceC11919f interfaceC11919f, IOException iOException) {
    }

    public void requestHeadersEnd(InterfaceC11919f interfaceC11919f, C11918e0 c11918e0) {
    }

    public void requestHeadersStart(InterfaceC11919f interfaceC11919f) {
    }

    public void responseBodyEnd(InterfaceC11919f interfaceC11919f, long j10) {
    }

    public void responseBodyStart(InterfaceC11919f interfaceC11919f) {
    }

    public void responseFailed(InterfaceC11919f interfaceC11919f, IOException iOException) {
    }

    public void responseHeadersEnd(InterfaceC11919f interfaceC11919f, C11922g0 c11922g0) {
    }

    public void responseHeadersStart(InterfaceC11919f interfaceC11919f) {
    }

    public void secureConnectEnd(InterfaceC11919f interfaceC11919f, C11954u c11954u) {
    }

    public void secureConnectStart(InterfaceC11919f interfaceC11919f) {
    }
}
