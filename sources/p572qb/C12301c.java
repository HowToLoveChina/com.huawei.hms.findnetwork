package p572qb;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverService;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import com.huawei.android.hicloud.task.simple.C3095x;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0219i;
import p514o9.C11829c;
import p514o9.C11839m;
import p515oa.C11844a;
import p573qc.C12338d;
import p609rc.C12487a;
import p616rk.C12515a;

/* renamed from: qb.c */
/* loaded from: classes3.dex */
public class C12301c {

    /* renamed from: qb.c$a */
    public static final class a {

        /* renamed from: a */
        public static C12301c f56997a = new C12301c();
    }

    /* renamed from: b */
    public static C12301c m73945b() {
        return a.f56997a;
    }

    /* renamed from: a */
    public final void m73946a() {
        C12515a.m75110o().m75175e(new C3095x(), false);
    }

    /* renamed from: c */
    public void m73947c() {
        if (C10028c.m62182c0().m62221H1()) {
            C12338d.m74195s().m74224b0();
        } else {
            C11839m.m70689w("CloudSyncManager", "disagree HiCloud terms");
        }
    }

    /* renamed from: d */
    public void m73948d(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m73951g(context);
        m73952h(context);
    }

    /* renamed from: e */
    public final void m73949e(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m73950f();
        C12487a.m74966b(context);
        C11844a.m70903b(context);
        if (!C10028c.m62182c0().m62324f0("has_send_switch_to_ds")) {
            C11839m.m70688i("CloudSyncManager", "retry sync switch to ds");
            C12338d.m74195s().m74229g0("dsswitch");
        }
        m73946a();
    }

    /* renamed from: f */
    public final void m73950f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = C0209d.m1277l1() ? Class.forName("com.hihonor.android.os.FileBackupEx") : Class.forName("com.huawei.android.os.FileBackupEx");
            cls.getMethod("startFileBackup", new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e10) {
            C11839m.m70687e("CloudSyncManager", "init file backup native service err: " + e10.toString());
        }
    }

    /* renamed from: g */
    public final void m73951g(Context context) {
        m73953i(context);
    }

    /* renamed from: h */
    public final void m73952h(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (C0209d.m1309t1(context)) {
            m73949e(context);
        } else {
            C11839m.m70688i("CloudSyncManager", "not main process");
        }
    }

    /* renamed from: i */
    public final void m73953i(Context context) {
        C11839m.m70688i("CloudSyncManager", "initObserverService");
        SyncObserverServiceInvoker.getInstance().initHandler();
        if (!C11829c.m70611r0()) {
            C12338d.m74195s().m74251u();
        }
        m73947c();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62388s("addressbook") || c10028cM62182c0.m62388s("wlan") || c10028cM62182c0.m62216G1(context)) {
            if (C11829c.m70611r0()) {
                if (C0219i.m1463a() >= 23) {
                    C12338d.m74195s().m74233k0();
                }
                C11839m.m70688i("CloudSyncManager", "open service");
                m73954j(context);
                return;
            }
            C12338d.m74195s().m74253v();
            if (C0219i.m1463a() >= 23) {
                m73955k(context);
            }
        }
    }

    /* renamed from: j */
    public void m73954j(Context context) {
        context.startService(new Intent(context, (Class<?>) SyncObserverService.class));
    }

    /* renamed from: k */
    public void m73955k(Context context) {
        context.stopService(new Intent(context, (Class<?>) SyncObserverService.class));
    }
}
