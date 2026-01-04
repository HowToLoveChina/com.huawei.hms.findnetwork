package p328h6;

import android.os.Handler;
import android.util.SparseArray;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import p359i6.C10447c;
import p359i6.InterfaceC10445a;

/* renamed from: h6.d */
/* loaded from: classes.dex */
public class C10104d implements InterfaceC10445a {

    /* renamed from: c */
    public static SparseArray<LinkedBlockingQueue<C10112l>> f49309c = new SparseArray<>();

    /* renamed from: d */
    public static Map<String, Set<String>> f49310d = new HashMap();

    /* renamed from: e */
    public static Map<String, Handler.Callback> f49311e = new HashMap();

    /* renamed from: f */
    public static C10104d f49312f = new C10104d();

    /* renamed from: a */
    public C10111k[] f49313a = new C10111k[2];

    /* renamed from: b */
    public C10111k[] f49314b = new C10111k[2];

    public C10104d() {
        f49309c.put(0, new LinkedBlockingQueue<>());
        f49309c.put(1, new LinkedBlockingQueue<>());
        m62937k();
        m62938l();
        C10447c.m64245a().m64247c(this);
    }

    /* renamed from: c */
    public static void m62928c(String str) {
        C2111d.m12654j("ProcessUnTarManager", "clear module data, ", str);
        f49311e.remove(str);
        f49310d.remove(str);
    }

    /* renamed from: d */
    public static Handler.Callback m62929d(String str) {
        return f49311e.get(str);
    }

    /* renamed from: i */
    public static C10104d m62930i() {
        return f49312f;
    }

    /* renamed from: j */
    public static void m62931j(String str, Handler.Callback callback) {
        f49311e.put(str, callback);
    }

    @Override // p359i6.InterfaceC10445a
    /* renamed from: a */
    public boolean mo12820a(int i10) throws SecurityException, IllegalArgumentException {
        C2111d.m12646b("ProcessUnTarManager", "setWeight:AdjustThreadPriority weight is " + i10);
        boolean z10 = false;
        for (C10111k c10111k : this.f49313a) {
            if (c10111k.isAlive()) {
                C10101a.m62912b().m62914c(c10111k.m62988d(), i10);
                z10 = true;
            }
        }
        for (C10111k c10111k2 : this.f49314b) {
            if (c10111k2.isAlive()) {
                C10101a.m62912b().m62914c(c10111k2.m62988d(), i10);
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: b */
    public void m62932b(C10112l c10112l, Handler.Callback callback) throws InterruptedException {
        if (c10112l == null) {
            C2111d.m12648d("ProcessUnTarManager", "unTarTaskInfo is null");
            return;
        }
        String strM62996f = c10112l.m62996f();
        String strM62993c = c10112l.m62993c();
        m62931j(strM62993c, callback);
        try {
            Set<String> hashSet = f49310d.get(strM62993c);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                f49310d.put(strM62993c, hashSet);
            }
            if (hashSet.contains(strM62996f)) {
                C2111d.m12657m("ProcessUnTarManager", "addUnTarTask hadAddTaskList path is " + strM62996f);
                return;
            }
            hashSet.add(strM62996f);
            int iM62934f = m62934f(strM62993c);
            LinkedBlockingQueue<C10112l> linkedBlockingQueue = f49309c.get(iM62934f);
            if (linkedBlockingQueue == null) {
                linkedBlockingQueue = new LinkedBlockingQueue<>();
                f49309c.put(iM62934f, linkedBlockingQueue);
            }
            linkedBlockingQueue.put(c10112l);
        } catch (InterruptedException unused) {
            C2111d.m12648d("ProcessUnTarManager", "unTarTask queue put fail,exception info");
        }
    }

    /* renamed from: e */
    public C10112l m62933e(int i10) {
        try {
            LinkedBlockingQueue<C10112l> linkedBlockingQueue = f49309c.get(i10);
            if (linkedBlockingQueue != null) {
                return linkedBlockingQueue.take();
            }
            return null;
        } catch (InterruptedException unused) {
            C2111d.m12648d("ProcessUnTarManager", "unTarList queue take fail,exception info");
            return null;
        }
    }

    /* renamed from: f */
    public final int m62934f(String str) {
        return !BackupObject.isMediaModule(str) ? 1 : 0;
    }

    /* renamed from: g */
    public boolean m62935g(String str) {
        if (!m62936h(str)) {
            return false;
        }
        boolean z10 = true;
        for (C10111k c10111k : m62934f(str) == 0 ? this.f49313a : this.f49314b) {
            if (c10111k != null && !c10111k.m62989e()) {
                z10 = false;
            }
        }
        return z10;
    }

    /* renamed from: h */
    public final boolean m62936h(String str) {
        LinkedBlockingQueue<C10112l> linkedBlockingQueue = f49309c.get(m62934f(str));
        if (linkedBlockingQueue != null) {
            return linkedBlockingQueue.isEmpty();
        }
        return true;
    }

    /* renamed from: k */
    public final void m62937k() {
        for (int i10 = 0; i10 < 2; i10++) {
            C10111k c10111k = this.f49313a[i10];
            if (c10111k == null || !c10111k.m62990f()) {
                this.f49313a[i10] = new C10111k(0);
                this.f49313a[i10].start();
            }
        }
    }

    /* renamed from: l */
    public final void m62938l() {
        for (int i10 = 0; i10 < 2; i10++) {
            C10111k c10111k = this.f49314b[i10];
            if (c10111k == null || !c10111k.m62990f()) {
                this.f49314b[i10] = new C10111k(1);
                this.f49314b[i10].start();
            }
        }
    }
}
