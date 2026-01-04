package com.huawei.android.p069cg.event;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.hms.network.embedded.C5928g3;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.AbstractC11953t;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.C11926i0;
import okhttp3.C11954u;
import okhttp3.EnumC11914c0;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11944k;
import okhttp3.internal.connection.C11935i;
import p031b7.C1120a;

/* renamed from: com.huawei.android.cg.event.a */
/* loaded from: classes2.dex */
public class C2277a extends AbstractC11953t {
    /* renamed from: b */
    public final String m14400b(InetSocketAddress inetSocketAddress) {
        InetAddress address;
        return (inetSocketAddress == null || (address = inetSocketAddress.getAddress()) == null) ? "" : address.getHostAddress();
    }

    @Override // okhttp3.AbstractC11953t
    public void callEnd(InterfaceC11919f interfaceC11919f) {
        super.callEnd(interfaceC11919f);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getCallEnd().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " callEnd " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void callFailed(InterfaceC11919f interfaceC11919f, IOException iOException) {
        super.callFailed(interfaceC11919f, iOException);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String str2 = new C4644l(System.currentTimeMillis()) + " " + (iOException == null ? "*" : iOException.toString());
                HttpEventManager.m14396b().m14397a(str).getCallFailed().add(str2);
                C1120a.m6675d(C5928g3.f26831h, str + " callFailed " + str2);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void callStart(InterfaceC11919f interfaceC11919f) {
        super.callStart(interfaceC11919f);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getCallStart().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " callStart " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void connectEnd(InterfaceC11919f interfaceC11919f, InetSocketAddress inetSocketAddress, Proxy proxy, EnumC11914c0 enumC11914c0) {
        super.connectEnd(interfaceC11919f, inetSocketAddress, proxy, enumC11914c0);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String str2 = new C4644l(System.currentTimeMillis()) + " " + m14400b(inetSocketAddress) + " " + (enumC11914c0 == null ? "*" : enumC11914c0.toString());
                HttpEventManager.m14396b().m14397a(str).getConnectEnd().add(str2);
                C1120a.m6675d(C5928g3.f26831h, str + " connectEnd " + str2);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void connectFailed(InterfaceC11919f interfaceC11919f, InetSocketAddress inetSocketAddress, Proxy proxy, EnumC11914c0 enumC11914c0, IOException iOException) {
        super.connectFailed(interfaceC11919f, inetSocketAddress, proxy, enumC11914c0, iOException);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String strM14400b = m14400b(inetSocketAddress);
                String string = "*";
                String string2 = enumC11914c0 == null ? "*" : enumC11914c0.toString();
                if (iOException != null) {
                    string = iOException.toString();
                }
                String str2 = new C4644l(System.currentTimeMillis()) + " " + strM14400b + " " + string2 + " " + string;
                HttpEventManager.m14396b().m14397a(str).getConnectFailed().add(str2);
                C1120a.m6675d(C5928g3.f26831h, str + " connectFailed " + str2);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void connectStart(InterfaceC11919f interfaceC11919f, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(interfaceC11919f, inetSocketAddress, proxy);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String str2 = new C4644l(System.currentTimeMillis()) + " " + m14400b(inetSocketAddress);
                HttpEventManager.m14396b().m14397a(str).getConnectStart().add(str2);
                C1120a.m6675d(C5928g3.f26831h, str + " connectStart " + str2);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void connectionAcquired(InterfaceC11919f interfaceC11919f, InterfaceC11944k interfaceC11944k) {
        String strM71794f;
        String strM71791e;
        super.connectionAcquired(interfaceC11919f, interfaceC11944k);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                C11935i c11935i = (C11935i) interfaceC11944k;
                if (c11935i == null) {
                    return;
                }
                C11926i0 c11926i0Mo71709a = c11935i.mo71709a();
                EnumC11914c0 enumC11914c0M71728t = c11935i.m71728t();
                if (c11935i.m71721m() != null) {
                    strM71794f = c11935i.m71721m().m71847e().m71794f();
                    strM71791e = c11935i.m71721m().m71844a().m71791e();
                } else {
                    strM71794f = null;
                    strM71791e = null;
                }
                String strM14400b = m14400b(c11926i0Mo71709a.m71641d());
                String string = enumC11914c0M71728t == null ? "*" : enumC11914c0M71728t.toString();
                if (strM71794f == null) {
                    strM71794f = "*";
                }
                if (strM71791e == null) {
                    strM71791e = "*";
                }
                String str2 = new C4644l(System.currentTimeMillis()) + " " + strM14400b + " " + string + " " + strM71794f + " " + strM71791e;
                HttpEventManager.m14396b().m14397a(str).getConnectionAcquired().add(str2);
                C1120a.m6675d(C5928g3.f26831h, str + " connectionAcquired " + str2);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void connectionReleased(InterfaceC11919f interfaceC11919f, InterfaceC11944k interfaceC11944k) {
        super.connectionReleased(interfaceC11919f, interfaceC11944k);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getConnectionReleased().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " connectionReleased " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void dnsEnd(InterfaceC11919f interfaceC11919f, String str, List<InetAddress> list) {
        super.dnsEnd(interfaceC11919f, str, list);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str2 = (String) objM71571k;
                String str3 = new C4644l(System.currentTimeMillis()) + " " + str + " " + list;
                HttpEventManager.m14396b().m14397a(str2).getDnsEnd().add(str3);
                C1120a.m6675d(C5928g3.f26831h, str2 + " dnsEnd " + str3);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void dnsStart(InterfaceC11919f interfaceC11919f, String str) {
        super.dnsStart(interfaceC11919f, str);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str2 = (String) objM71571k;
                String str3 = new C4644l(System.currentTimeMillis()) + " " + str;
                HttpEventManager.m14396b().m14397a(str2).getDnsStart().add(str3);
                C1120a.m6675d(C5928g3.f26831h, str2 + " dnsStart " + str3);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void requestBodyEnd(InterfaceC11919f interfaceC11919f, long j10) {
        super.requestBodyEnd(interfaceC11919f, j10);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getRequestBodyEnd().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " requestBodyEnd " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void requestBodyStart(InterfaceC11919f interfaceC11919f) {
        super.requestBodyStart(interfaceC11919f);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getRequestBodyStart().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " requestBodyStart " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void requestFailed(InterfaceC11919f interfaceC11919f, IOException iOException) {
        super.requestFailed(interfaceC11919f, iOException);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String str2 = new C4644l(System.currentTimeMillis()) + " " + (iOException == null ? "*" : iOException.toString());
                HttpEventManager.m14396b().m14397a(str).getRequestFailed().add(str2);
                C1120a.m6675d(C5928g3.f26831h, str + " requestFailed " + str2);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void requestHeadersEnd(InterfaceC11919f interfaceC11919f, C11918e0 c11918e0) {
        super.requestHeadersEnd(interfaceC11919f, c11918e0);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getRequestHeadersEnd().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " requestHeadersEnd " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void requestHeadersStart(InterfaceC11919f interfaceC11919f) {
        super.requestHeadersStart(interfaceC11919f);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getRequestHeadersStart().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " requestHeadersStart " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void responseBodyEnd(InterfaceC11919f interfaceC11919f, long j10) {
        super.responseBodyEnd(interfaceC11919f, j10);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getResponseBodyEnd().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " responseBodyEnd " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void responseBodyStart(InterfaceC11919f interfaceC11919f) {
        super.responseBodyStart(interfaceC11919f);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getResponseBodyStart().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " responseBodyStart " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void responseFailed(InterfaceC11919f interfaceC11919f, IOException iOException) {
        super.responseFailed(interfaceC11919f, iOException);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String str2 = new C4644l(System.currentTimeMillis()) + " " + (iOException == null ? "*" : iOException.toString());
                HttpEventManager.m14396b().m14397a(str).getResponseFailed().add(str2);
                C1120a.m6675d(C5928g3.f26831h, str + " responseFailed " + str2);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void responseHeadersEnd(InterfaceC11919f interfaceC11919f, C11922g0 c11922g0) {
        super.responseHeadersEnd(interfaceC11919f, c11922g0);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getResponseHeadersEnd().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " responseHeadersEnd " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void responseHeadersStart(InterfaceC11919f interfaceC11919f) {
        super.responseHeadersStart(interfaceC11919f);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getResponseHeadersStart().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " responseHeadersStart " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void secureConnectEnd(InterfaceC11919f interfaceC11919f, C11954u c11954u) {
        super.secureConnectEnd(interfaceC11919f, c11954u);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getSecureConnectEnd().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " secureConnectEnd " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }

    @Override // okhttp3.AbstractC11953t
    public void secureConnectStart(InterfaceC11919f interfaceC11919f) {
        super.secureConnectStart(interfaceC11919f);
        try {
            Object objM71571k = interfaceC11919f.request().m71571k();
            if (objM71571k instanceof String) {
                String str = (String) objM71571k;
                String string = new C4644l(System.currentTimeMillis()).toString();
                HttpEventManager.m14396b().m14397a(str).getSecureConnectStart().add(string);
                C1120a.m6675d(C5928g3.f26831h, str + " secureConnectStart " + string);
            }
        } catch (Exception e10) {
            C1120a.m6676e(C5928g3.f26831h, "HttpEventListener Exception: " + e10);
        }
    }
}
