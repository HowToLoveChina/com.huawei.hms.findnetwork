package p832z4;

import android.content.Context;
import com.huawei.android.backup.filelogic.config.LoadAppControlStrategyTask;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.C2157a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p029b5.C1111d;
import p029b5.C1113f;
import p029b5.C1114g;
import p029b5.C1115h;
import p029b5.C1116i;
import p699v4.C13337f;
import p699v4.C13348q;

/* renamed from: z4.a */
/* loaded from: classes.dex */
public class C14127a {

    /* renamed from: g */
    public static final C14127a f63154g = new C14127a();

    /* renamed from: h */
    public static boolean f63155h = false;

    /* renamed from: i */
    public static Context f63156i;

    /* renamed from: a */
    public boolean f63157a = true;

    /* renamed from: b */
    public C1111d.a f63158b;

    /* renamed from: c */
    public C1115h.a f63159c;

    /* renamed from: d */
    public C1113f.a f63160d;

    /* renamed from: e */
    public C1114g.a f63161e;

    /* renamed from: f */
    public C1116i.b f63162f;

    /* renamed from: d */
    public static C14127a m84764d() {
        return f63154g;
    }

    /* renamed from: e */
    public static HashSet<String> m84765e() {
        C2111d.m12653i("BackupAppControlStrategy", "begin get system hot patch.");
        HashSet<String> hashSet = new HashSet<>();
        C13337f c13337f = new C13337f();
        if (!c13337f.m80000a()) {
            return hashSet;
        }
        C2111d.m12653i("BackupAppControlStrategy", "Have hot patches to handle.");
        if (c13337f.m80003d()) {
            List<C13337f.a> listM80001b = c13337f.m80001b();
            if (C13348q.m80084d(listM80001b)) {
                Iterator<C13337f.a> it = listM80001b.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next().m80009f());
                }
            }
        }
        return hashSet;
    }

    /* renamed from: g */
    public static void m84766g(Context context) {
        if (context == null) {
            return;
        }
        C2157a.m13189X(context);
        synchronized (C14127a.class) {
            try {
                if (!f63155h) {
                    f63156i = context.getApplicationContext();
                    new LoadAppControlStrategyTask(context).run();
                    f63155h = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public synchronized C1111d.a m84767a() {
        return this.f63158b;
    }

    /* renamed from: b */
    public Context m84768b() {
        return f63156i;
    }

    /* renamed from: c */
    public synchronized C1113f.a m84769c() {
        return this.f63160d;
    }

    /* renamed from: f */
    public synchronized C1116i.b m84770f() {
        return this.f63162f;
    }

    /* renamed from: h */
    public synchronized void m84771h(C1111d.a aVar) {
        this.f63158b = aVar;
    }

    /* renamed from: i */
    public synchronized void m84772i(C1113f.a aVar) {
        this.f63160d = aVar;
    }

    /* renamed from: j */
    public synchronized void m84773j(C1114g.a aVar) {
        this.f63161e = aVar;
    }

    /* renamed from: k */
    public synchronized void m84774k(C1115h.a aVar) {
        this.f63159c = aVar;
    }

    /* renamed from: l */
    public synchronized void m84775l(boolean z10) {
        this.f63157a = z10;
    }

    /* renamed from: m */
    public synchronized void m84776m(C1116i.b bVar) {
        this.f63162f = bVar;
    }
}
