package com.huawei.android.hicloud.cloudbackup.process;

import am.AbstractC0249a;
import am.C0258d;
import android.os.SystemClock;
import android.text.TextUtils;
import bm.InterfaceC1262c;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.p104v3.core.ICBBaseV3Task;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12574n;
import p709vj.C13452e;
import p711vl.C13466f;
import p744wl.C13617a;
import p815ym.AbstractC14026a;
import p848zl.C14342k;
import p851zp.InterfaceC14355b;
import tl.C13029h;
import tl.C13030i;
import tl.C13032k;
import tl.C13033l;
import tl.C13035n;

/* loaded from: classes2.dex */
public class CBAccess {
    private static final String TAG = "CBAccess";
    private static final Object LOCK = new Object();
    private static final Object DELETE_TASK_LOCK = new Object();
    private static volatile List<CacheTask> tasks = new ArrayList();
    private static volatile List<AbstractC0249a> deleteTasks = new ArrayList();

    public static class RestoreCacheClearTask extends AbstractC12367d {
        private final boolean isClearStatus;

        public RestoreCacheClearTask(boolean z10) {
            this.isClearStatus = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i(CBAccess.TAG, "restoreCacheClearTask start " + this.isClearStatus);
            try {
                if (new C13030i().m78495f(3) != null) {
                    if (this.isClearStatus) {
                        C13617a.m81933o();
                    }
                    C13617a.m81932n(this.isClearStatus);
                    C12574n.m75558k(C0213f.m1377a());
                }
            } catch (C9721b e10) {
                C11839m.m70689w(CBAccess.TAG, "query restore tag error." + e10);
            }
        }
    }

    public static void abort(int i10) {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof ICBBaseTask) {
                        ((ICBBaseTask) cacheTask).abort(i10);
                    } else if (cacheTask instanceof ICBBaseV3Task) {
                        ((ICBBaseV3Task) cacheTask).abort(i10);
                    } else if (cacheTask instanceof C0258d) {
                        cacheTask.abort();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void abortAllBackupExRefurbish(final int i10, final InterfaceC1262c interfaceC1262c) {
        synchronized (LOCK) {
            try {
                List list = (List) tasks.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.f
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CBAccess.lambda$abortAllBackupExRefurbish$4((CacheTask) obj);
                    }
                }).map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.g
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return CBAccess.lambda$abortAllBackupExRefurbish$5((CacheTask) obj);
                    }
                }).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.h
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CBAccess.lambda$abortAllBackupExRefurbish$6((C4879a) obj);
                    }
                }).collect(Collectors.toList());
                if (AbstractC14026a.m84159a(list)) {
                    interfaceC1262c.mo1754b();
                } else {
                    list.forEach(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.i
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            ((C4879a) obj).m29581c(i10, null, interfaceC1262c);
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void abortAllBackupExTemp(final int i10, final InterfaceC1262c interfaceC1262c) {
        synchronized (LOCK) {
            try {
                List list = (List) tasks.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.j
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CBAccess.lambda$abortAllBackupExTemp$0((CacheTask) obj);
                    }
                }).map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.k
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return CBAccess.lambda$abortAllBackupExTemp$1((CacheTask) obj);
                    }
                }).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.m
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CBAccess.lambda$abortAllBackupExTemp$2((C4879a) obj);
                    }
                }).collect(Collectors.toList());
                if (AbstractC14026a.m84159a(list)) {
                    interfaceC1262c.mo1754b();
                } else {
                    list.forEach(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.n
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            ((C4879a) obj).m29581c(i10, null, interfaceC1262c);
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void abortAutoBackup(int i10) {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof ICBBaseTask) {
                        if ((cacheTask instanceof CloudBackupTask) && ((CloudBackupTask) cacheTask).isAutoBackup()) {
                            if (((CloudBackupTask) cacheTask).abortRequired()) {
                                ((CloudBackupTask) cacheTask).abort(i10);
                            } else {
                                C11839m.m70688i(TAG, "state created, not abort");
                            }
                        }
                    } else if ((cacheTask instanceof ICBBaseV3Task) && (cacheTask instanceof C4879a) && ((C4879a) cacheTask).isAutoBackup()) {
                        ((C4879a) cacheTask).abort(i10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void abortBackupOnly(int i10) {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof C4879a) {
                        ((C4879a) cacheTask).abort(i10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void abortManulBackup(int i10) {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if ((cacheTask instanceof ICBBaseTask) && !((CloudBackupTask) cacheTask).isAutoBackup()) {
                        ((ICBBaseTask) cacheTask).abort(i10);
                    }
                    if ((cacheTask instanceof ICBBaseV3Task) && !((C4879a) cacheTask).isAutoBackup()) {
                        ((ICBBaseV3Task) cacheTask).abort(i10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean addRefurbish(CacheTask cacheTask) {
        synchronized (LOCK) {
            try {
                if (isInRefurbish()) {
                    return false;
                }
                C12515a.m75110o().m75172d(cacheTask);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean addTask(CacheTask cacheTask) {
        synchronized (LOCK) {
            try {
                if (!tasks.isEmpty()) {
                    return false;
                }
                tasks.add(cacheTask);
                C12515a.m75110o().m75172d(cacheTask);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean addTempTask(CacheTask cacheTask) {
        synchronized (LOCK) {
            try {
                if (isInTempBackup()) {
                    return false;
                }
                C12515a.m75110o().m75172d(cacheTask);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void appRestoreResume(String str, int i10) throws C9721b {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof CloudRestoreTask) {
                        ((CloudRestoreTask) cacheTask).resume3rd(str);
                    } else if (cacheTask instanceof C4880b) {
                        ((C4880b) cacheTask).m29802k0(str, i10);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void checkProcessKill() {
        int iM80916g0 = C13452e.m80781L().m80916g0();
        C13033l c13033l = new C13033l();
        C13032k c13032kM78546d = c13033l.m78546d(2);
        if (iM80916g0 == 1 || (c13032kM78546d != null && C14342k.m85520a(c13032kM78546d.m78532p()))) {
            c13032kM78546d.m78514K(2);
            c13033l.m78547e(c13032kM78546d);
            C13452e.m80781L().m80914f3(7);
        }
    }

    public static void clearDeleteTask() {
        synchronized (DELETE_TASK_LOCK) {
            deleteTasks.clear();
        }
    }

    public static void clearRestoreCacheAsync(boolean z10) {
        C12515a.m75110o().m75172d(new RestoreCacheClearTask(z10));
    }

    public static boolean deleteTempSingleBak(String str) {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof C4879a) {
                        C4879a c4879a = (C4879a) cacheTask;
                        if (c4879a.mo29591n()) {
                            c4879a.m29724l2(str);
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String getCurrent() {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof ICBBaseTask) {
                        return ((ICBBaseTask) cacheTask).getCurrent();
                    }
                    if (cacheTask instanceof ICBBaseV3Task) {
                        return ((ICBBaseV3Task) cacheTask).getCurrent();
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static CacheTask.State getState() {
        synchronized (LOCK) {
            try {
                Iterator<CacheTask> it = tasks.iterator();
                if (it.hasNext()) {
                    return it.next().getState();
                }
                return CacheTask.State.NOT_STARTED;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean hasDeleteTask() {
        boolean z10;
        synchronized (DELETE_TASK_LOCK) {
            z10 = !deleteTasks.isEmpty();
        }
        return z10;
    }

    public static boolean hasManualBackupOrRestore() {
        synchronized (LOCK) {
            try {
                boolean z10 = false;
                if (tasks.isEmpty()) {
                    return false;
                }
                Iterator<CacheTask> it = tasks.iterator();
                if (!it.hasNext()) {
                    return false;
                }
                CacheTask next = it.next();
                boolean z11 = (next instanceof CloudBackupTask) && ((CloudBackupTask) next).isAutoBackup();
                boolean z12 = (next instanceof C4879a) && ((C4879a) next).isAutoBackup();
                if (!z11 && !z12) {
                    z10 = true;
                }
                return z10;
            } finally {
            }
        }
    }

    public static boolean hasRestoreTask() {
        C13029h c13029hM78495f;
        try {
            c13029hM78495f = new C13030i().m78495f(3);
        } catch (C9721b unused) {
            c13029hM78495f = null;
        }
        if (c13029hM78495f == null) {
            C11839m.m70688i(TAG, "restore task not exist.");
            return false;
        }
        if (isShowRestorePause()) {
            C11839m.m70688i(TAG, "doRestore in pause");
            return false;
        }
        int iM78441G = c13029hM78495f.m78441G();
        if (iM78441G == 0 || iM78441G == 1) {
            boolean z10 = !C0209d.m1206R1(C0213f.m1377a());
            C11839m.m70688i(TAG, "restore in first state, is in oobe = " + z10);
            return !z10 || inRestoreTask();
        }
        if (iM78441G == 2 || iM78441G == 3) {
            C11839m.m70688i(TAG, "restore in second state, need retry");
            return true;
        }
        if (iM78441G != 4) {
            return false;
        }
        C11839m.m70688i(TAG, "restore normal end , do not retry " + iM78441G);
        if (!TextUtils.equals(c13029hM78495f.m78484v(), "1") && C13452e.m80781L().m80916g0() == 1) {
            C13452e.m80781L().m80890b();
        }
        return false;
    }

    public static boolean hasTaskWorking() {
        boolean z10;
        synchronized (LOCK) {
            z10 = !tasks.isEmpty();
        }
        return z10;
    }

    public static boolean hasValidTempBackup() {
        if (isInTempBackup()) {
            return true;
        }
        try {
            C13029h c13029hM78495f = new C13030i().m78495f(5);
            if (c13029hM78495f == null || c13029hM78495f.m78441G() == 4) {
                C11839m.m70688i(TAG, "tempbackup tag is null.");
                return false;
            }
            long jM1688f = C0241z.m1688f(c13029hM78495f.m78486w());
            C11839m.m70688i(TAG, "isHasValidTempBackup expireTime: " + jM1688f);
            return System.currentTimeMillis() <= jM1688f;
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "isExistTempBackup query backup tags error: " + e10);
            return false;
        }
    }

    public static boolean inBackup() {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (!(cacheTask instanceof CloudBackupTask) && !(cacheTask instanceof C4879a) && !(cacheTask instanceof C0258d)) {
                    }
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0060, code lost:
    
        if (r7.m78441G() == 1) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean inCurrentRestoreFirst(java.lang.String r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L81
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto Lb
            goto L81
        Lb:
            java.lang.Object r1 = com.huawei.android.hicloud.cloudbackup.process.CBAccess.LOCK
            monitor-enter(r1)
            java.util.List<com.huawei.android.hicloud.cloudbackup.process.CacheTask> r2 = com.huawei.android.hicloud.cloudbackup.process.CBAccess.tasks     // Catch: java.lang.Throwable -> L35
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L35
            r3 = r0
        L15:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Throwable -> L35
            r5 = 1
            if (r4 == 0) goto L48
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Throwable -> L35
            com.huawei.android.hicloud.cloudbackup.process.CacheTask r4 = (com.huawei.android.hicloud.cloudbackup.process.CacheTask) r4     // Catch: java.lang.Throwable -> L35
            boolean r6 = r4 instanceof com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask     // Catch: java.lang.Throwable -> L35
            if (r6 == 0) goto L37
            r6 = r4
            com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask r6 = (com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask) r6     // Catch: java.lang.Throwable -> L35
            java.lang.String r6 = r6.getBackupId()     // Catch: java.lang.Throwable -> L35
            boolean r6 = r7.equals(r6)     // Catch: java.lang.Throwable -> L35
            if (r6 == 0) goto L37
        L33:
            r3 = r5
            goto L15
        L35:
            r7 = move-exception
            goto L7f
        L37:
            boolean r6 = r4 instanceof com.huawei.hicloud.cloudbackup.p104v3.core.C4880b     // Catch: java.lang.Throwable -> L35
            if (r6 == 0) goto L15
            com.huawei.hicloud.cloudbackup.v3.core.b r4 = (com.huawei.hicloud.cloudbackup.p104v3.core.C4880b) r4     // Catch: java.lang.Throwable -> L35
            java.lang.String r4 = r4.getBackupId()     // Catch: java.lang.Throwable -> L35
            boolean r4 = r7.equals(r4)     // Catch: java.lang.Throwable -> L35
            if (r4 == 0) goto L15
            goto L33
        L48:
            if (r3 == 0) goto L7d
            tl.i r7 = new tl.i     // Catch: java.lang.Throwable -> L35
            r7.<init>()     // Catch: java.lang.Throwable -> L35
            r2 = 3
            tl.h r7 = r7.m78495f(r2)     // Catch: java.lang.Throwable -> L35 fk.C9721b -> L63
            if (r7 == 0) goto L7d
            int r2 = r7.m78441G()     // Catch: java.lang.Throwable -> L35 fk.C9721b -> L63
            if (r2 == 0) goto L65
            int r7 = r7.m78441G()     // Catch: java.lang.Throwable -> L35 fk.C9721b -> L63
            if (r7 != r5) goto L7d
            goto L65
        L63:
            r7 = move-exception
            goto L67
        L65:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L35
            return r5
        L67:
            java.lang.String r2 = "CBAccess"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            r3.<init>()     // Catch: java.lang.Throwable -> L35
            java.lang.String r4 = "inCurrentRestoreFirst query restore tag error."
            r3.append(r4)     // Catch: java.lang.Throwable -> L35
            r3.append(r7)     // Catch: java.lang.Throwable -> L35
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> L35
            p514o9.C11839m.m70689w(r2, r7)     // Catch: java.lang.Throwable -> L35
        L7d:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L35
            return r0
        L7f:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L35
            throw r7
        L81:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.CBAccess.inCurrentRestoreFirst(java.lang.String):boolean");
    }

    public static boolean inRestore() {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (!(cacheTask instanceof CloudRestoreTask) && !(cacheTask instanceof C4880b)) {
                        if (!(cacheTask instanceof CloudBackupTask) && !(cacheTask instanceof C4879a) && !(cacheTask instanceof C0258d)) {
                        }
                        return false;
                    }
                    return true;
                }
                try {
                    C13029h c13029hM78495f = new C13030i().m78495f(3);
                    if (c13029hM78495f != null && c13029hM78495f.m78441G() != 0) {
                        if (c13029hM78495f.m78441G() != 4) {
                            return true;
                        }
                    }
                } catch (C9721b e10) {
                    C11839m.m70689w(TAG, "query restore tag error." + e10);
                }
                return false;
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0038, code lost:
    
        if (r1.m78441G() == 1) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean inRestoreFirst() {
        /*
            java.lang.Object r0 = com.huawei.android.hicloud.cloudbackup.process.CBAccess.LOCK
            monitor-enter(r0)
            java.util.List<com.huawei.android.hicloud.cloudbackup.process.CacheTask> r1 = com.huawei.android.hicloud.cloudbackup.process.CBAccess.tasks     // Catch: java.lang.Throwable -> L1f
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1f
        L9:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L1f
            r3 = 0
            if (r2 == 0) goto L57
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L1f
            com.huawei.android.hicloud.cloudbackup.process.CacheTask r2 = (com.huawei.android.hicloud.cloudbackup.process.CacheTask) r2     // Catch: java.lang.Throwable -> L1f
            boolean r4 = r2 instanceof com.huawei.android.hicloud.cloudbackup.process.CloudRestoreTask     // Catch: java.lang.Throwable -> L1f
            if (r4 != 0) goto L21
            boolean r2 = r2 instanceof com.huawei.hicloud.cloudbackup.p104v3.core.C4880b     // Catch: java.lang.Throwable -> L1f
            if (r2 == 0) goto L9
            goto L21
        L1f:
            r1 = move-exception
            goto L59
        L21:
            tl.i r1 = new tl.i     // Catch: java.lang.Throwable -> L1f
            r1.<init>()     // Catch: java.lang.Throwable -> L1f
            r2 = 3
            tl.h r1 = r1.m78495f(r2)     // Catch: java.lang.Throwable -> L1f fk.C9721b -> L3b
            if (r1 == 0) goto L55
            int r2 = r1.m78441G()     // Catch: java.lang.Throwable -> L1f fk.C9721b -> L3b
            r4 = 1
            if (r2 == 0) goto L3d
            int r1 = r1.m78441G()     // Catch: java.lang.Throwable -> L1f fk.C9721b -> L3b
            if (r1 != r4) goto L55
            goto L3d
        L3b:
            r1 = move-exception
            goto L3f
        L3d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1f
            return r4
        L3f:
            java.lang.String r2 = "CBAccess"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r4.<init>()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r5 = "inRestoreFirst query restore tag error."
            r4.append(r5)     // Catch: java.lang.Throwable -> L1f
            r4.append(r1)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L1f
            p514o9.C11839m.m70689w(r2, r1)     // Catch: java.lang.Throwable -> L1f
        L55:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1f
            return r3
        L57:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1f
            return r3
        L59:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1f
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.CBAccess.inRestoreFirst():boolean");
    }

    public static boolean inRestoreLast() {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (!(cacheTask instanceof CloudRestoreTask) && !(cacheTask instanceof C4880b)) {
                    }
                    try {
                        C13029h c13029hM78495f = new C13030i().m78495f(3);
                        if (c13029hM78495f != null) {
                            if (c13029hM78495f.m78441G() == 2) {
                                return true;
                            }
                        }
                    } catch (C9721b e10) {
                        C11839m.m70689w(TAG, "query restore tag error." + e10);
                    }
                    return false;
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static int inRestorePaused() {
        synchronized (LOCK) {
            try {
                int i10 = 0;
                if (7 != C13452e.m80781L().m80916g0()) {
                    return 0;
                }
                Iterator<CacheTask> it = tasks.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof CloudRestoreTask) {
                        return 0;
                    }
                }
                try {
                    C13029h c13029hM78495f = new C13030i().m78495f(3);
                    if (c13029hM78495f != null && c13029hM78495f.m78441G() != 0) {
                        for (CloudRestoreStatus cloudRestoreStatus : new C13035n().m78552d()) {
                            if (cloudRestoreStatus == null) {
                                C11839m.m70689w(TAG, "inRestorePaused reports is null.");
                            } else if (cloudRestoreStatus.getStatus() == 2) {
                                i10++;
                            }
                        }
                    }
                } catch (C9721b e10) {
                    C11839m.m70689w(TAG, "query restore tag error." + e10);
                }
                return i10;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean inRestoreTask() {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (!(cacheTask instanceof CloudRestoreTask) && !(cacheTask instanceof C4880b)) {
                    }
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public static boolean inRestoreWithRetryClearCheck(boolean z10) {
        C13029h c13029hM78495f;
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (!(cacheTask instanceof CloudRestoreTask) && !(cacheTask instanceof C4880b)) {
                        if (!(cacheTask instanceof CloudBackupTask) && !(cacheTask instanceof C4879a) && !(cacheTask instanceof C0258d)) {
                        }
                        C11839m.m70688i(TAG, "inRestoreWithRetryClearCheck in backup: " + z10);
                        return false;
                    }
                    C11839m.m70688i(TAG, "inRestoreWithRetryClearCheck in restore: " + z10);
                    return true;
                }
                C13030i c13030i = new C13030i();
                try {
                    c13029hM78495f = c13030i.m78495f(3);
                } catch (C9721b e10) {
                    C11839m.m70689w(TAG, "query restore tag error." + e10);
                }
                if (c13029hM78495f == null) {
                    C11839m.m70688i(TAG, "inRestoreWithRetryClearCheck tags is empty " + z10);
                    return false;
                }
                if (TextUtils.equals(c13029hM78495f.m78484v(), "1")) {
                    if (z10) {
                        C13452e.m80781L().m80890b();
                        RestoreNotification.getInstance().cancelNotification();
                        clearRestoreCacheAsync(true);
                    }
                    C11839m.m70688i(TAG, "inRestoreWithRetryClearCheck restore is already expired " + z10);
                    return false;
                }
                if (c13029hM78495f.m78441G() != 0 && c13029hM78495f.m78441G() != 4) {
                    boolean zIsRestoreRetryTimeExpires = ICBUtil.isRestoreRetryTimeExpires(c13029hM78495f.m78440F());
                    boolean zIsShowRestorePause = isShowRestorePause();
                    C11839m.m70688i(TAG, "inRestoreWithRetryClearCheck timeExpires: " + zIsRestoreRetryTimeExpires + " ,pause" + zIsShowRestorePause + " ,clear: " + z10);
                    if (!zIsRestoreRetryTimeExpires || zIsShowRestorePause) {
                        return true;
                    }
                    checkProcessKill();
                    c13029hM78495f.m78477r0(4);
                    c13029hM78495f.m78457W("1");
                    c13030i.m78496g(c13029hM78495f);
                    RestoreProgress.clearCache();
                    ICBBroadcastManager.sendCancelRestoreBroadcast(C0213f.m1377a());
                    C13452e.m80781L().m80909e3(0.0f);
                    if (z10) {
                        C13452e.m80781L().m80890b();
                        RestoreNotification.getInstance().cancelNotification();
                    }
                    clearRestoreCacheAsync(z10);
                    return false;
                }
                return false;
            } finally {
            }
        }
    }

    public static boolean inV3Backup() {
        synchronized (LOCK) {
            try {
                Iterator<CacheTask> it = tasks.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof C4879a) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean isAppDataPreparing() {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof CloudBackupTask) {
                        return ((CloudBackupTask) cacheTask).isAppDataPreparing();
                    }
                    if (cacheTask instanceof C4879a) {
                        return ((C4879a) cacheTask).m29729n1();
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean isBackupAbout() {
        synchronized (LOCK) {
            try {
                Iterator<CacheTask> it = tasks.iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof C0258d) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean isBackupPause() {
        try {
            C13030i c13030i = new C13030i();
            C13029h c13029hM78495f = c13030i.m78495f(2);
            boolean z10 = true;
            if (c13029hM78495f == null) {
                c13029hM78495f = c13030i.m78495f(1);
            }
            if (c13029hM78495f == null || c13029hM78495f.m78441G() == 4) {
                z10 = false;
            }
            C11839m.m70688i(TAG, "isBackupPaused:" + z10);
            return z10;
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "query backup pause error:" + e10.getMessage());
            return false;
        }
    }

    public static boolean isCloudBackupTaskRunning() {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof CloudRestoreTask) {
                        return true;
                    }
                    if (cacheTask instanceof CloudBackupTask) {
                        return true;
                    }
                    if (cacheTask instanceof C4880b) {
                        return true;
                    }
                    if (cacheTask instanceof C4879a) {
                        return true;
                    }
                    if (cacheTask instanceof C0258d) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean isInPrepare() {
        return CacheTask.State.PREPARE.equals(getState());
    }

    public static boolean isInRefurbish() {
        boolean z10;
        synchronized (LOCK) {
            z10 = tasks.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.a
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CBAccess.lambda$isInRefurbish$14((CacheTask) obj);
                }
            }).map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.l
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return CBAccess.lambda$isInRefurbish$15((CacheTask) obj);
                }
            }).anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.o
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((C4879a) obj).isRefurbishment();
                }
            }) || tasks.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.p
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CBAccess.lambda$isInRefurbish$16((CacheTask) obj);
                }
            }).map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.q
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return CBAccess.lambda$isInRefurbish$17((CacheTask) obj);
                }
            }).anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.r
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((C0258d) obj).m1747p();
                }
            });
        }
        return z10;
    }

    public static boolean isInRelease() {
        return CacheTask.State.DONE.equals(getState());
    }

    public static boolean isInTempBackup() {
        boolean z10;
        synchronized (LOCK) {
            z10 = tasks.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.s
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CBAccess.lambda$isInTempBackup$8((CacheTask) obj);
                }
            }).map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.t
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return CBAccess.lambda$isInTempBackup$9((CacheTask) obj);
                }
            }).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.u
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CBAccess.lambda$isInTempBackup$10((C4879a) obj);
                }
            }).anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.v
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((C4879a) obj).mo29591n();
                }
            }) || tasks.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CBAccess.lambda$isInTempBackup$11((CacheTask) obj);
                }
            }).map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.c
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return CBAccess.lambda$isInTempBackup$12((CacheTask) obj);
                }
            }).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.d
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CBAccess.lambda$isInTempBackup$13((C0258d) obj);
                }
            }).anyMatch(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.e
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((C0258d) obj).m1748r();
                }
            });
        }
        return z10;
    }

    public static boolean isMyhuaweiPullRestoreTask() {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof CloudRestoreTask) {
                        return ((CloudRestoreTask) cacheTask).isRefurbishment();
                    }
                    if (cacheTask instanceof C4880b) {
                        return ((C4880b) cacheTask).isRefurbishment();
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean isNeedShowBackupNotify() {
        synchronized (LOCK) {
            try {
                boolean z10 = false;
                if (tasks.isEmpty()) {
                    return false;
                }
                Iterator<CacheTask> it = tasks.iterator();
                if (!it.hasNext()) {
                    return false;
                }
                CacheTask next = it.next();
                if ((next instanceof C4879a) && ((C4879a) next).m29735p1()) {
                    z10 = true;
                }
                return z10;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean isShowRestorePause() {
        return C13452e.m80781L().m80916g0() == 7 && C13466f.m81073d().m81075b("has_moudles_restore_pause", false);
    }

    public static boolean isSupportResume(String str) {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof CloudRestoreTask) {
                        CloudRestoreTask cloudRestoreTask = (CloudRestoreTask) cacheTask;
                        if (cloudRestoreTask.modules.contains(str)) {
                            C11839m.m70686d(TAG, "isSupportResume not, report is in restoring");
                            return false;
                        }
                        if (!cloudRestoreTask.isRestoringThirdApp) {
                            C11839m.m70686d(TAG, "isSupportResume not, report not support resume");
                            return false;
                        }
                    }
                    if (cacheTask instanceof C4880b) {
                        C4880b c4880b = (C4880b) cacheTask;
                        if (c4880b.modules.contains(str)) {
                            C11839m.m70686d(TAG, "isSupportResume not, report is in restoring");
                            return false;
                        }
                        if (!c4880b.f22515I) {
                            C11839m.m70686d(TAG, "isSupportResume not, report not support resume");
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void keepLock() {
        AbstractC0249a next;
        CacheTask next2;
        synchronized (LOCK) {
            try {
                Iterator<CacheTask> it = tasks.iterator();
                next = null;
                next2 = null;
                while (it.hasNext()) {
                    next2 = it.next();
                }
            } finally {
            }
        }
        if (next2 instanceof CloudBackupTask) {
            ((CloudBackupTask) next2).keepLock();
        } else if (next2 instanceof C4879a) {
            ((C4879a) next2).keepLock();
        } else if (next2 instanceof C4880b) {
            ((C4880b) next2).keepLock();
        }
        synchronized (DELETE_TASK_LOCK) {
            try {
                Iterator<AbstractC0249a> it2 = deleteTasks.iterator();
                while (it2.hasNext()) {
                    next = it2.next();
                }
            } finally {
            }
        }
        if (next != null) {
            next.keepLock();
        }
    }

    public static /* synthetic */ boolean lambda$abortAllBackupExRefurbish$4(CacheTask cacheTask) {
        return cacheTask instanceof C4879a;
    }

    public static /* synthetic */ C4879a lambda$abortAllBackupExRefurbish$5(CacheTask cacheTask) {
        return (C4879a) cacheTask;
    }

    public static /* synthetic */ boolean lambda$abortAllBackupExRefurbish$6(C4879a c4879a) {
        return !c4879a.isRefurbishment();
    }

    public static /* synthetic */ boolean lambda$abortAllBackupExTemp$0(CacheTask cacheTask) {
        return cacheTask instanceof C4879a;
    }

    public static /* synthetic */ C4879a lambda$abortAllBackupExTemp$1(CacheTask cacheTask) {
        return (C4879a) cacheTask;
    }

    public static /* synthetic */ boolean lambda$abortAllBackupExTemp$2(C4879a c4879a) {
        return !c4879a.mo29591n();
    }

    public static /* synthetic */ boolean lambda$isInRefurbish$14(CacheTask cacheTask) {
        return cacheTask instanceof C4879a;
    }

    public static /* synthetic */ C4879a lambda$isInRefurbish$15(CacheTask cacheTask) {
        return (C4879a) cacheTask;
    }

    public static /* synthetic */ boolean lambda$isInRefurbish$16(CacheTask cacheTask) {
        return cacheTask instanceof C0258d;
    }

    public static /* synthetic */ C0258d lambda$isInRefurbish$17(CacheTask cacheTask) {
        return (C0258d) cacheTask;
    }

    public static /* synthetic */ boolean lambda$isInTempBackup$10(C4879a c4879a) {
        return !c4879a.isAbort();
    }

    public static /* synthetic */ boolean lambda$isInTempBackup$11(CacheTask cacheTask) {
        return cacheTask instanceof C0258d;
    }

    public static /* synthetic */ C0258d lambda$isInTempBackup$12(CacheTask cacheTask) {
        return (C0258d) cacheTask;
    }

    public static /* synthetic */ boolean lambda$isInTempBackup$13(C0258d c0258d) {
        return !c0258d.isAbort();
    }

    public static /* synthetic */ boolean lambda$isInTempBackup$8(CacheTask cacheTask) {
        return cacheTask instanceof C4879a;
    }

    public static /* synthetic */ C4879a lambda$isInTempBackup$9(CacheTask cacheTask) {
        return (C4879a) cacheTask;
    }

    public static boolean manualAbort() {
        return manualAbort(1001);
    }

    public static void pause() {
        synchronized (LOCK) {
            try {
                Iterator<CacheTask> it = tasks.iterator();
                while (it.hasNext()) {
                    it.next().pause();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean prePareDateDone() {
        try {
            C13029h c13029hM78495f = new C13030i().m78495f(3);
            if (c13029hM78495f == null || c13029hM78495f.m78441G() == 0) {
                return false;
            }
            return c13029hM78495f.m78441G() != 4;
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "prePareDateDone query restore tag error." + e10);
            return false;
        }
    }

    public static void removeDeleteTask(AbstractC0249a abstractC0249a) {
        synchronized (DELETE_TASK_LOCK) {
            deleteTasks.remove(abstractC0249a);
            C12515a.m75110o().m75165a1(abstractC0249a);
        }
    }

    public static void removeTask(CacheTask cacheTask) {
        synchronized (LOCK) {
            tasks.remove(cacheTask);
            C12515a.m75110o().m75165a1(cacheTask);
        }
    }

    public static List<RestoreStatus> restoreStatusList() {
        ArrayList arrayList;
        ArrayList arrayList2;
        synchronized (LOCK) {
            try {
                arrayList = null;
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof CloudRestoreTask) {
                        arrayList2 = new ArrayList(((CloudRestoreTask) cacheTask).restoreStatusList());
                    } else if (cacheTask instanceof C4880b) {
                        arrayList2 = new ArrayList(((C4880b) cacheTask).m29781P());
                    }
                    arrayList = arrayList2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    public static void setLauncherLayoutOk() {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof CloudRestoreTask) {
                        ((CloudRestoreTask) cacheTask).setLauncherLayoutOk(true);
                    } else if (cacheTask instanceof C4880b) {
                        ((C4880b) cacheTask).setLauncherLayoutOk(true);
                        return;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void setRestoreTaskToMyHuawei() {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof CloudRestoreTask) {
                        ((CloudRestoreTask) cacheTask).setTaskMyHuawei();
                        return;
                    } else if (cacheTask instanceof C4880b) {
                        ((C4880b) cacheTask).setTaskMyHuawei();
                        return;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void startDeleteTask(AbstractC0249a abstractC0249a) {
        synchronized (DELETE_TASK_LOCK) {
            try {
                if (!C12515a.m75110o().m75158X0(abstractC0249a.getClass().getName())) {
                    deleteTasks.add(abstractC0249a);
                    C12515a.m75110o().m75172d(abstractC0249a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void startRestoreLast() {
        synchronized (LOCK) {
            try {
                for (CacheTask cacheTask : tasks) {
                    if (cacheTask instanceof CloudRestoreTask) {
                        ((CloudRestoreTask) cacheTask).notifyToRestoreAppByLauncher();
                    } else if (cacheTask instanceof C4880b) {
                        ((C4880b) cacheTask).notifyToRestoreAppByLauncher();
                        return;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void waitCacheClear(InterfaceC14355b interfaceC14355b) throws C9721b {
        C11839m.m70688i(TAG, "waitCacheClear start");
        while (C12515a.m75110o().m75158X0(RestoreCacheClearTask.class.getName())) {
            if (interfaceC14355b != null) {
                interfaceC14355b.execute();
            }
            SystemClock.sleep(1000L);
        }
        C11839m.m70688i(TAG, "waitCacheClear end");
    }

    public static boolean manualAbort(int i10) {
        if (tasks.isEmpty()) {
            return false;
        }
        abort(i10);
        return true;
    }
}
