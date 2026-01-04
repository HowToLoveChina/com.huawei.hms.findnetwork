package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.android.hms.ppskit.InterfaceC4313d;
import com.huawei.android.hms.ppskit.InterfaceC4314e;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.ipc.AbstractC7315b;
import com.huawei.openalliance.p169ad.ipc.C7314a;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.C7830i;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.ms */
/* loaded from: classes8.dex */
public class C7484ms extends AbstractC7315b<InterfaceC4314e> {

    /* renamed from: d */
    private static C7484ms f34695d;

    /* renamed from: e */
    private static final byte[] f34696e = new byte[0];

    /* renamed from: com.huawei.openalliance.ad.ms$a */
    public static class a extends AbstractC7315b.a<InterfaceC4314e> {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b.a
        /* renamed from: a */
        public void mo45090a(InterfaceC4314e interfaceC4314e) {
            try {
                interfaceC4314e.mo25943a();
            } catch (RemoteException unused) {
                AbstractC7185ho.m43823c("PPSApiServiceManager", "setInstallSource RemoteException");
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ms$b */
    public static class b<T> extends AbstractC7315b.a<InterfaceC4314e> {

        /* renamed from: a */
        private String f34697a;

        /* renamed from: b */
        private String f34698b;

        /* renamed from: c */
        private RemoteCallResultCallback<T> f34699c;

        /* renamed from: d */
        private Class<T> f34700d;

        /* renamed from: e */
        private Context f34701e;

        /* renamed from: com.huawei.openalliance.ad.ms$b$1 */
        public class AnonymousClass1 extends InterfaceC4313d.a {
            public AnonymousClass1() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.huawei.android.hms.ppskit.InterfaceC4313d
            /* renamed from: a */
            public void mo25940a(String str, int i10, String str2) {
                String str3;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSApiServiceManager", "call: %s code: %s result: %s", str, Integer.valueOf(i10), AbstractC7819dl.m48375a(str2));
                }
                CallResult callResult = new CallResult();
                callResult.setCode(i10);
                try {
                    if (i10 == 200) {
                        callResult.setData(AbstractC7487mv.m45877a(str2, b.this.f34700d));
                    } else {
                        callResult.setMsg(str2);
                    }
                } catch (IllegalArgumentException e10) {
                    e = e10;
                    str3 = "onCallResult IllegalArgumentException";
                    AbstractC7185ho.m43823c("PPSApiServiceManager", str3);
                    callResult.setCode(-1);
                    callResult.setMsg(e.getMessage());
                    b bVar = b.this;
                    bVar.m45860a(bVar.f34699c, str, callResult);
                } catch (Throwable th2) {
                    e = th2;
                    str3 = "onCallResult " + e.getClass().getSimpleName();
                    AbstractC7185ho.m43823c("PPSApiServiceManager", str3);
                    callResult.setCode(-1);
                    callResult.setMsg(e.getMessage());
                    b bVar2 = b.this;
                    bVar2.m45860a(bVar2.f34699c, str, callResult);
                }
                b bVar22 = b.this;
                bVar22.m45860a(bVar22.f34699c, str, callResult);
            }
        }

        public b(Context context, String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
            this.f34701e = context;
            this.f34697a = str;
            this.f34698b = str2;
            this.f34699c = remoteCallResultCallback;
            this.f34700d = cls;
        }

        /* renamed from: b */
        private void m45863b(String str) {
            AbstractC7185ho.m43823c("PPSApiServiceManager", str);
            CallResult callResult = new CallResult();
            callResult.setCode(-1);
            callResult.setMsg(str);
            m45860a(this.f34699c, this.f34697a, callResult);
        }

        @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b.a
        /* renamed from: a */
        public void mo45090a(InterfaceC4314e interfaceC4314e) {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sdk_version", Config.SDK_VERSION);
                jSONObject.put("content", this.f34698b);
                interfaceC4314e.mo25944a(this.f34697a, jSONObject.toString(), new InterfaceC4313d.a() { // from class: com.huawei.openalliance.ad.ms.b.1
                    public AnonymousClass1() {
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.huawei.android.hms.ppskit.InterfaceC4313d
                    /* renamed from: a */
                    public void mo25940a(String str2, int i10, String str22) {
                        String str3;
                        if (AbstractC7185ho.m43819a()) {
                            AbstractC7185ho.m43818a("PPSApiServiceManager", "call: %s code: %s result: %s", str2, Integer.valueOf(i10), AbstractC7819dl.m48375a(str22));
                        }
                        CallResult callResult = new CallResult();
                        callResult.setCode(i10);
                        try {
                            if (i10 == 200) {
                                callResult.setData(AbstractC7487mv.m45877a(str22, b.this.f34700d));
                            } else {
                                callResult.setMsg(str22);
                            }
                        } catch (IllegalArgumentException e10) {
                            e = e10;
                            str3 = "onCallResult IllegalArgumentException";
                            AbstractC7185ho.m43823c("PPSApiServiceManager", str3);
                            callResult.setCode(-1);
                            callResult.setMsg(e.getMessage());
                            b bVar22 = b.this;
                            bVar22.m45860a(bVar22.f34699c, str2, callResult);
                        } catch (Throwable th2) {
                            e = th2;
                            str3 = "onCallResult " + e.getClass().getSimpleName();
                            AbstractC7185ho.m43823c("PPSApiServiceManager", str3);
                            callResult.setCode(-1);
                            callResult.setMsg(e.getMessage());
                            b bVar222 = b.this;
                            bVar222.m45860a(bVar222.f34699c, str2, callResult);
                        }
                        b bVar2222 = b.this;
                        bVar2222.m45860a(bVar2222.f34699c, str2, callResult);
                    }
                });
            } catch (RemoteException unused) {
                str = "remote call RemoteException";
                m45863b(str);
            } catch (Throwable th2) {
                str = "remote call " + th2.getClass().getSimpleName();
                m45863b(str);
            }
        }

        /* renamed from: a */
        public void m45860a(RemoteCallResultCallback remoteCallResultCallback, String str, CallResult callResult) {
            boolean zMo43345aL;
            if (callResult != null) {
                AbstractC7185ho.m43821b("PPSApiServiceManager", "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
                if (callResult.getCode() == -100 && (zMo43345aL = C7124fh.m43316b(this.f34701e).mo43345aL())) {
                    HiAd.m44014a(this.f34701e).mo44046a(zMo43345aL);
                }
            }
            if (remoteCallResultCallback != null) {
                remoteCallResultCallback.onRemoteCallResult(str, callResult);
            }
        }

        @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b.a
        /* renamed from: a */
        public void mo45092a(String str) {
            m45863b("serviceCallFailed: " + str);
        }
    }

    private C7484ms(Context context) {
        super(context);
        this.f33998c = new C7314a(context, mo45082b(), this);
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: b */
    public InterfaceC4314e mo45080a(IBinder iBinder) {
        return InterfaceC4314e.a.m25945a(iBinder);
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: c */
    public String mo45083c() {
        return "com.huawei.android.hms.ppskit.PPS_API_SERVICE";
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: d */
    public String mo45084d() {
        return C7830i.m48434e(this.f33996a);
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: f */
    public boolean mo45086f() {
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: g */
    public String mo45087g() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: h */
    public String mo45088h() {
        return "com.huawei.android.hms.ppskit.PpsCoreService";
    }

    /* renamed from: i */
    public void m45857i() {
        AbstractC7185ho.m43820b(mo45082b(), "onRequestingAd");
        m45081a(new a(), 3000L);
    }

    /* renamed from: a */
    public static C7484ms m45854a(Context context) {
        C7484ms c7484ms;
        synchronized (f34696e) {
            try {
                if (f34695d == null) {
                    f34695d = new C7484ms(context);
                }
                c7484ms = f34695d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7484ms;
    }

    @Override // com.huawei.openalliance.p169ad.ipc.AbstractC7315b
    /* renamed from: b */
    public final String mo45082b() {
        return "PPSApiServiceManager";
    }

    /* renamed from: a */
    public <T> void m45855a(String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        AbstractC7185ho.m43820b(mo45082b(), "call remote method: " + str);
        m45081a(new b(this.f33996a, str, str2, remoteCallResultCallback, cls), 3000L);
    }
}
