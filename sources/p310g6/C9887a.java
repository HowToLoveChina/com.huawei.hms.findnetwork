package p310g6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.ncdft.INcDft;
import java.util.ArrayList;
import java.util.List;
import p229di.C9142g;

/* renamed from: g6.a */
/* loaded from: classes.dex */
public class C9887a {

    /* renamed from: e */
    public static final String f48525e;

    /* renamed from: f */
    public static final String f48526f;

    /* renamed from: g */
    public static final String f48527g;

    /* renamed from: h */
    public static final List<b> f48528h;

    /* renamed from: a */
    public Context f48529a;

    /* renamed from: b */
    public INcDft f48530b;

    /* renamed from: d */
    public ServiceConnection f48532d = new a();

    /* renamed from: c */
    public boolean f48531c = false;

    /* renamed from: g6.a$a */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C2111d.m12653i("CloneNcDftConnImpl", "NcDft service is connected");
            C9887a.this.m61357f(INcDft.AbstractBinderC6824a.m38538a(iBinder));
            for (b bVar : C9887a.f48528h) {
                try {
                    C9887a.this.f48530b.connectivityDftReport(bVar.f48534a, bVar.f48535b, bVar.f48536c);
                } catch (RemoteException unused) {
                    C2111d.m12648d("CloneNcDftConnImpl", "reportToDft fail");
                } catch (NoSuchMethodError unused2) {
                    C2111d.m12648d("CloneNcDftConnImpl", "no such Methods in framework.");
                }
            }
            C9887a.f48528h.clear();
            C9887a.this.m61356e();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C2111d.m12653i("CloneNcDftConnImpl", "NcDft service is disconnceted");
            C9887a.this.m61357f(null);
        }
    }

    /* renamed from: g6.a$b */
    public static class b {

        /* renamed from: a */
        public String f48534a;

        /* renamed from: b */
        public int f48535b;

        /* renamed from: c */
        public String f48536c;
    }

    static {
        f48525e = C9142g.m57463b() ? "com.hihonor.ncdft.INcDft" : "com.huawei.ncdft.INcDft";
        f48526f = C9142g.m57463b() ? "com.hihonor.hiview" : "com.huawei.hiview";
        f48527g = C9142g.m57463b() ? "com.hihonor.ncdft.NcDftService" : "com.huawei.ncdft.NcDftService";
        f48528h = new ArrayList(2);
    }

    public C9887a(Context context) {
        this.f48529a = context;
        m61355d();
    }

    /* renamed from: d */
    public final void m61355d() {
        if (this.f48531c && this.f48530b != null) {
            C2111d.m12653i("CloneNcDftConnImpl", "bindToService already");
            return;
        }
        C2111d.m12653i("CloneNcDftConnImpl", "bindToService start");
        Intent intent = new Intent(f48525e);
        intent.setClassName(f48526f, f48527g);
        try {
            boolean zBindService = this.f48529a.bindService(intent, this.f48532d, 1);
            this.f48531c = zBindService;
            C2111d.m12654j("CloneNcDftConnImpl", "bindToService result = ", Boolean.valueOf(zBindService));
        } catch (SecurityException unused) {
            C2111d.m12648d("CloneNcDftConnImpl", "bindService fail");
        }
    }

    /* renamed from: e */
    public void m61356e() {
        this.f48529a.unbindService(this.f48532d);
        this.f48531c = false;
    }

    /* renamed from: f */
    public final void m61357f(INcDft iNcDft) {
        this.f48530b = iNcDft;
    }
}
