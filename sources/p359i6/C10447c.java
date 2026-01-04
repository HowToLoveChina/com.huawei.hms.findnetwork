package p359i6;

import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.tce.TceTempTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

/* renamed from: i6.c */
/* loaded from: classes.dex */
public final class C10447c {

    /* renamed from: e */
    public static final Object f50403e = new Object();

    /* renamed from: f */
    public static final Object f50404f = new Object();

    /* renamed from: g */
    public static C10447c f50405g = new C10447c();

    /* renamed from: a */
    public TceTempTask f50406a = null;

    /* renamed from: b */
    public Timer f50407b = new Timer();

    /* renamed from: c */
    public volatile long f50408c = 0;

    /* renamed from: d */
    public List<InterfaceC10445a> f50409d = new ArrayList();

    /* renamed from: a */
    public static C10447c m64245a() {
        return f50405g;
    }

    /* renamed from: b */
    public long m64246b() {
        long j10;
        synchronized (f50404f) {
            j10 = this.f50408c;
        }
        return j10;
    }

    /* renamed from: c */
    public void m64247c(InterfaceC10445a interfaceC10445a) {
        if (interfaceC10445a == null) {
            return;
        }
        synchronized (f50403e) {
            try {
                if (!this.f50409d.contains(interfaceC10445a)) {
                    C2111d.m12654j("TCE", "registerSCEngine obj is ", interfaceC10445a.getClass(), " ,current weight is ", Integer.valueOf(TceTempTask.m13114g()));
                    this.f50409d.add(interfaceC10445a);
                    interfaceC10445a.mo12820a(TceTempTask.m13114g());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public void m64248d(InterfaceC10445a interfaceC10445a) {
        if (interfaceC10445a == null) {
            return;
        }
        synchronized (f50403e) {
            try {
                if (this.f50409d.contains(interfaceC10445a)) {
                    C2111d.m12654j("TCE", "unregisterSCEngine obj is ", interfaceC10445a.getClass());
                    interfaceC10445a.mo12820a(100);
                    this.f50409d.remove(interfaceC10445a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public void m64249e(int i10) {
        C2111d.m12654j("TCE", "update weight ", Integer.valueOf(i10));
        if (this.f50406a != null) {
            synchronized (f50403e) {
                try {
                    Iterator<InterfaceC10445a> it = this.f50409d.iterator();
                    while (it.hasNext()) {
                        it.next().mo12820a(i10);
                    }
                } finally {
                }
            }
        }
    }
}
