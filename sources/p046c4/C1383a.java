package p046c4;

import android.content.Context;
import android.os.RemoteException;
import com.hihonor.android.powerkit.adapter.C2088a;

/* renamed from: c4.a */
/* loaded from: classes.dex */
public class C1383a {

    /* renamed from: c */
    public static volatile C1383a f5943c;

    /* renamed from: a */
    public C2088a f5944a;

    /* renamed from: b */
    public Context f5945b;

    public C1383a(Context context, InterfaceC1384b interfaceC1384b) {
        this.f5944a = null;
        this.f5945b = context;
        this.f5944a = new C2088a(context, interfaceC1384b);
    }

    /* renamed from: b */
    public static C1383a m7934b(Context context, InterfaceC1384b interfaceC1384b) {
        if (f5943c == null) {
            synchronized (C1383a.class) {
                try {
                    if (f5943c == null) {
                        f5943c = new C1383a(context, interfaceC1384b);
                    }
                } finally {
                }
            }
        }
        return f5943c;
    }

    /* renamed from: a */
    public boolean m7935a(String str, int i10, long j10, String str2) throws RemoteException {
        return this.f5944a.m12434h(this.f5945b, true, str, i10, j10, str2);
    }

    /* renamed from: c */
    public boolean m7936c(InterfaceC1385c interfaceC1385c, int i10) throws RemoteException {
        return this.f5944a.m12438l(interfaceC1385c, i10);
    }

    /* renamed from: d */
    public boolean m7937d(String str, int i10, String str2) throws RemoteException {
        return this.f5944a.m12434h(this.f5945b, false, str, i10, -1L, str2);
    }

    /* renamed from: e */
    public boolean m7938e(InterfaceC1385c interfaceC1385c, int i10) throws RemoteException {
        return this.f5944a.m12437k(interfaceC1385c, i10);
    }
}
