package pe;

import android.content.Context;
import android.os.RemoteException;
import com.huawei.android.powerkit.adapter.C4319a;

/* renamed from: pe.a */
/* loaded from: classes.dex */
public class C12132a {

    /* renamed from: c */
    public static volatile C12132a f56278c;

    /* renamed from: a */
    public C4319a f56279a;

    /* renamed from: b */
    public Context f56280b;

    public C12132a(Context context, InterfaceC12133b interfaceC12133b) {
        this.f56279a = null;
        this.f56280b = context;
        this.f56279a = new C4319a(context, interfaceC12133b);
    }

    /* renamed from: b */
    public static C12132a m72750b(Context context, InterfaceC12133b interfaceC12133b) {
        if (f56278c == null) {
            synchronized (C12132a.class) {
                try {
                    if (f56278c == null) {
                        f56278c = new C12132a(context, interfaceC12133b);
                    }
                } finally {
                }
            }
        }
        return f56278c;
    }

    /* renamed from: a */
    public boolean m72751a(String str, int i10, long j10, String str2) throws RemoteException {
        return this.f56279a.m25959h(this.f56280b, true, str, i10, j10, str2);
    }

    /* renamed from: c */
    public boolean m72752c(InterfaceC12134c interfaceC12134c, int i10) throws RemoteException {
        return this.f56279a.m25963l(interfaceC12134c, i10);
    }

    /* renamed from: d */
    public boolean m72753d(String str, int i10, String str2) throws RemoteException {
        return this.f56279a.m25959h(this.f56280b, false, str, i10, -1L, str2);
    }

    /* renamed from: e */
    public boolean m72754e(InterfaceC12134c interfaceC12134c, int i10) throws RemoteException {
        return this.f56279a.m25962k(interfaceC12134c, i10);
    }
}
