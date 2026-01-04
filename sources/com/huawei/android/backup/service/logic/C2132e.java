package com.huawei.android.backup.service.logic;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.android.backup.common.temperature.TemperatureControl;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.filelogic.utils.C2114g;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.logic.C2153l;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import p006a5.AbstractC0048c;
import p006a5.C0050e;
import p248e5.C9408a;
import p359i6.C10447c;
import p359i6.InterfaceC10445a;
import p386j6.C10713c;
import p386j6.C10715e;
import p444l5.C11235c;
import p633s5.AbstractC12706c;
import p699v4.C13334c;
import p699v4.C13344m;
import p699v4.C13345n;
import p699v4.C13348q;

/* renamed from: com.huawei.android.backup.service.logic.e */
/* loaded from: classes.dex */
public class C2132e extends AbstractC2131d implements InterfaceC10445a {

    /* renamed from: d */
    public static int f9607d = 100;

    /* renamed from: a */
    public TemperatureControl f9608a;

    /* renamed from: b */
    public AtomicBoolean f9609b = new AtomicBoolean(false);

    /* renamed from: c */
    public AtomicBoolean f9610c = new AtomicBoolean(true);

    /* renamed from: com.huawei.android.backup.service.logic.e$a */
    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            C2111d.m12648d("ControlBranchClone", "backupSms Thread is error");
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.e$b */
    public class b implements Runnable {

        /* renamed from: a */
        public C2153l.b f9612a;

        /* renamed from: b */
        public long f9613b;

        /* renamed from: c */
        public long f9614c;

        /* renamed from: d */
        public AtomicBoolean f9615d;

        public b(C2153l.b bVar, long j10, long j11, AtomicBoolean atomicBoolean) {
            this.f9612a = bVar;
            this.f9613b = j10;
            this.f9614c = j11;
            this.f9615d = atomicBoolean;
        }

        /* renamed from: a */
        public final void m12821a(int i10, long j10) {
            if (this.f9612a.f9686b.length <= i10) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            C2132e c2132e = C2132e.this;
            C2153l.b bVar = this.f9612a;
            c2132e.m12777c(bVar, bVar.f9689e, bVar.f9686b[i10], null);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            C2111d.m12654j("Performance_Testing", "backup Module :", this.f9612a.f9686b[i10], ", ModuleSize : ", C2114g.m12662a(j10), ", startTime: ", Long.valueOf(jCurrentTimeMillis), " ,endTime :", Long.valueOf(jCurrentTimeMillis2), " ,costTime :", Long.valueOf((jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000), "s");
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            int i10 = 0;
            this.f9615d.set(false);
            if (C2132e.this.f9608a == null) {
                C2132e.this.f9608a = new TemperatureControl(this.f9612a.f9685a.getApplicationContext());
            }
            C2132e.this.f9608a.m12591a();
            long j10 = this.f9613b;
            if (j10 != 0) {
                m12821a(0, j10);
                i10 = 1;
            }
            long j11 = this.f9614c;
            if (j11 != 0) {
                m12821a(i10, j11);
            }
            this.f9615d.set(true);
            if (!C2153l.m13035b0()) {
                C2132e.this.m12808J(this.f9612a);
                return;
            }
            C13334c.m79980m(this.f9612a.f9688d + File.separator + this.f9612a.f9689e);
        }
    }

    /* renamed from: K */
    public static int m12804K() {
        return f9607d;
    }

    /* renamed from: W */
    public static void m12805W(int i10) {
        f9607d = i10;
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: A */
    public void mo12772A(C2153l.b bVar) {
        if (bVar != null && C2157a.m13166A(bVar.f9685a)) {
            m12773B(bVar);
        }
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: C */
    public void mo12774C(C2153l.b bVar, String str) {
        if (bVar != null && C2157a.m13166A(bVar.f9685a)) {
            m12775D(bVar, str);
        }
    }

    /* renamed from: H */
    public final int m12806H(C2153l.b bVar, String str, int i10, HashMap<String, Long> map) throws InterruptedException {
        if (C2153l.m13035b0()) {
            C13334c.m79980m(bVar.f9688d + "/" + bVar.f9689e);
            C10447c.m64245a().m64248d(this);
            return 0;
        }
        int i11 = i10 + 1;
        String[] strArr = bVar.f9686b;
        if (i11 < strArr.length && m12815R(str, strArr[i11])) {
            m12817T(bVar.f9685a, str);
            if (C2153l.m13035b0()) {
                C2111d.m12657m("ControlBranchClone", "media tar abort, return.");
                C10447c.m64245a().m64248d(this);
                return 0;
            }
            C2111d.m12654j("ControlBranchClone", "media tar is finish last media module is : ", str);
        }
        return -1;
    }

    /* renamed from: I */
    public final int m12807I(C2153l.b bVar, HashMap<String, Long> map) {
        boolean zM12814Q = m12814Q(bVar);
        long jM12811N = m12811N(zM12814Q, map);
        long jM12809L = m12809L(zM12814Q, map);
        if (m12814Q(bVar) && (jM12811N != 0 || jM12809L != 0)) {
            C2111d.m12654j("ControlBranchClone", "start back sms or chatSMS smsSize = ", Long.valueOf(jM12811N), " ;chatSmsSize = ", Long.valueOf(jM12809L));
            this.f9610c.set(false);
            Thread thread = new Thread(new b(bVar, jM12811N, jM12809L, this.f9610c));
            thread.setUncaughtExceptionHandler(new a());
            thread.setName("backupSms");
            thread.start();
        }
        return m12812O(jM12811N, jM12809L);
    }

    /* renamed from: J */
    public final synchronized void m12808J(C2153l.b bVar) {
        if (bVar != null) {
            try {
                Bundle bundle = bVar.f9690f;
                if (bundle != null) {
                    if (!C10713c.m65392b(bundle, "SupportTaskParallelOptimization", false) || (this.f9609b.get() && this.f9610c.get())) {
                        C10447c.m64245a().m64248d(this);
                        C9408a.m59011b();
                        C2153l.m13076w(bVar.f9687c, 4);
                    }
                    return;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        C2111d.m12648d("ControlBranchClone", "doBackUpComplete : cmd or executeParameter is null");
    }

    /* renamed from: L */
    public final long m12809L(boolean z10, HashMap<String, Long> map) {
        if (z10 && map.get("chatSms") != null) {
            return m12810M(map, "chatSms");
        }
        return 0L;
    }

    /* renamed from: M */
    public final long m12810M(HashMap<String, Long> map, String str) {
        Long l10 = map.get(str);
        if (l10 != null) {
            return l10.longValue();
        }
        return 0L;
    }

    /* renamed from: N */
    public final long m12811N(boolean z10, HashMap<String, Long> map) {
        if (!z10 || map.get(NavigationUtils.SMS_SCHEMA_PREF) == null) {
            return 0L;
        }
        long jM12810M = m12810M(map, NavigationUtils.SMS_SCHEMA_PREF);
        if (jM12810M == 0) {
            return 102400L;
        }
        return jM12810M;
    }

    /* renamed from: O */
    public final int m12812O(long j10, long j11) {
        int i10 = j10 > 0 ? 1 : 0;
        return j11 > 0 ? i10 + 1 : i10;
    }

    /* renamed from: P */
    public final HashMap<String, Long> m12813P(C2153l.b bVar) {
        if (bVar == null || bVar.f9686b == null) {
            C2111d.m12648d("ControlBranchClone", "backupImp : cmd is null");
            return new HashMap<>(0);
        }
        this.f9609b.set(false);
        m12805W(100);
        C10447c.m64245a().m64247c(this);
        HashMap<String, Long> mapM13086c = bVar.m13086c();
        if (mapM13086c != null && !mapM13086c.isEmpty()) {
            return mapM13086c;
        }
        C2153l.m13076w(bVar.f9687c, 15);
        C10447c.m64245a().m64248d(this);
        C2111d.m12657m("ControlBranchClone", "backupImp moduleMap is null");
        return new HashMap<>(0);
    }

    /* renamed from: Q */
    public final boolean m12814Q(C2153l.b bVar) {
        Bundle bundle;
        if (bVar != null && (bundle = bVar.f9690f) != null) {
            return C10713c.m65392b(bundle, "SupportTaskParallelOptimization", false) && !C10713c.m65392b(bVar.f9690f, "isNewPhoneFromOOBE", false);
        }
        C2111d.m12648d("ControlBranchClone", "isBackupSmsByParallel : cmd or executeParameter is null");
        return false;
    }

    /* renamed from: R */
    public final boolean m12815R(String str, String str2) {
        if (!BackupObject.isUseDftpTar()) {
            return C10713c.m65392b(BackupObject.getExecuteParameter(), "isUseDataTrans", false) && BackupObject.isMediaModule(str) && !BackupObject.isMediaModule(str2);
        }
        C2111d.m12653i("ControlBranchClone", "[dftpTar] use dftp tar, don't need wait media tar finish");
        return false;
    }

    /* renamed from: S */
    public final boolean m12816S(String str, HashMap<String, Long> map, C2153l.b bVar) {
        if (BackupObject.isSplitTarModule(str)) {
            C2111d.m12654j("ControlBranchClone", "[SplitTar] split tar module skip storage check, ", str);
            return true;
        }
        Long l10 = map.get(str);
        long jLongValue = l10 != null ? l10.longValue() : 0L;
        long jM80061a = C13344m.m80061a(jLongValue);
        if (jLongValue == 0 || C13334c.m79968a(bVar.f9688d, jM80061a) || bVar.m13089f(jM80061a)) {
            return true;
        }
        C2111d.m12648d("ControlBranchClone", "waitUntilSpaceFree, send msg: LOCATION_AVAILABLE_SIZE_SMALL");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0080 A[PHI: r3 r13 r14
  0x0080: PHI (r3v7 boolean) = (r3v4 boolean), (r3v5 boolean), (r3v8 boolean) binds: [B:31:0x008c, B:33:0x0092, B:27:0x007e] A[DONT_GENERATE, DONT_INLINE]
  0x0080: PHI (r13v5 boolean) = (r13v2 boolean), (r13v3 boolean), (r13v6 boolean) binds: [B:31:0x008c, B:33:0x0092, B:27:0x007e] A[DONT_GENERATE, DONT_INLINE]
  0x0080: PHI (r14v5 android.database.Cursor) = (r14v2 android.database.Cursor), (r14v3 android.database.Cursor), (r14v7 android.database.Cursor) binds: [B:31:0x008c, B:33:0x0092, B:27:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: T */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m12817T(android.content.Context r17, java.lang.String r18) throws java.lang.InterruptedException {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            if (r0 != 0) goto L7
            return
        L7:
            r2 = 0
            boolean r3 = p328h6.C10102b.m62916a(r0, r1, r2)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            java.lang.String r5 = "media tar is finished ? "
            java.lang.Object[] r4 = new java.lang.Object[]{r5, r4}
            java.lang.String r5 = "ControlBranchClone"
            com.huawei.android.backup.filelogic.utils.C2111d.m12654j(r5, r4)
            android.content.ContentResolver r4 = r17.getContentResolver()
            r12 = 0
            r6 = r2
            r13 = r6
            r14 = r12
        L23:
            if (r3 != 0) goto Lac
            if (r13 != 0) goto Lac
            r7 = 1
            int r15 = r6 + 1
            boolean r6 = com.huawei.android.backup.service.logic.C2153l.m13035b0()
            if (r6 == 0) goto L37
            java.lang.String r0 = "backup is abort, stop waiting for tar archive over."
            com.huawei.android.backup.filelogic.utils.C2111d.m12657m(r5, r0)
            goto Lac
        L37:
            r8 = 2000(0x7d0, double:9.88E-321)
            java.lang.Thread.sleep(r8)     // Catch: java.lang.InterruptedException -> L9d
            boolean r3 = p328h6.C10102b.m62916a(r0, r1, r15)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.lang.IllegalArgumentException -> L5a
            int r6 = r15 % 100
            if (r6 != 0) goto L5d
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.lang.IllegalArgumentException -> L5a
            java.lang.String r8 = "media tar is finished : "
            r6[r2] = r8     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.lang.IllegalArgumentException -> L5a
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.lang.IllegalArgumentException -> L5a
            r6[r7] = r8     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.lang.IllegalArgumentException -> L5a
            com.huawei.android.backup.filelogic.utils.C2111d.m12654j(r5, r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.lang.IllegalArgumentException -> L5a
            goto L5d
        L55:
            r0 = move-exception
            goto L97
        L57:
            r6 = r16
            goto L85
        L5a:
            r6 = r16
            goto L8d
        L5d:
            android.net.Uri r7 = p328h6.C10106f.f49315a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.lang.IllegalArgumentException -> L5a
            r10 = 0
            r11 = 0
            r8 = 0
            r9 = 0
            r6 = r4
            android.database.Cursor r14 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.lang.IllegalArgumentException -> L5a
            if (r14 == 0) goto L77
            int r6 = r14.getCount()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.lang.IllegalArgumentException -> L5a
            if (r6 <= 0) goto L77
            r6 = r16
            boolean r13 = r6.m12819V(r14, r15, r1)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L85 java.lang.IllegalArgumentException -> L8d
            goto L7e
        L77:
            r6 = r16
            java.lang.String r7 = " tarOverFromProvider cursor is null or this module count = 0"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r5, r7)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L85 java.lang.IllegalArgumentException -> L8d
        L7e:
            if (r14 == 0) goto L95
        L80:
            r14.close()
            r14 = r12
            goto L95
        L85:
            java.lang.String r7 = "query Exception"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r5, r7)     // Catch: java.lang.Throwable -> L55
            if (r14 == 0) goto L95
            goto L80
        L8d:
            java.lang.String r7 = "query IllegalArgumentException"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r5, r7)     // Catch: java.lang.Throwable -> L55
            if (r14 == 0) goto L95
            goto L80
        L95:
            r6 = r15
            goto L23
        L97:
            if (r14 == 0) goto L9c
            r14.close()
        L9c:
            throw r0
        L9d:
            r0 = move-exception
            r1 = r0
            java.lang.String r0 = "sleep InterruptedException"
            java.lang.String r1 = r1.getMessage()
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r1}
            com.huawei.android.backup.filelogic.utils.C2111d.m12649e(r5, r0)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.service.logic.C2132e.m12817T(android.content.Context, java.lang.String):void");
    }

    /* renamed from: U */
    public final void m12818U(HashMap<String, Long> map, String str, long j10, long j11) {
        C2111d.m12654j("ControlBranchClone", "Performance_Testing, backup Module :", str, ", ModuleSize : ", C2114g.m12662a(m12810M(map, str)), ", startTime: ", Long.valueOf(j10), " ,endTime :", Long.valueOf(j11), " ,costTime :", Long.valueOf((j11 - j10) / 1000), "s");
    }

    /* renamed from: V */
    public final boolean m12819V(Cursor cursor, int i10, String str) {
        boolean z10 = false;
        if (cursor == null || cursor.getCount() <= 0 || str == null) {
            C2111d.m12648d("ControlBranchClone", " tarOverFromProvider cursor is null or this module count = 0");
            return false;
        }
        while (cursor.moveToNext()) {
            if (cursor.getInt(cursor.getColumnIndexOrThrow("tarOver")) == 1 && str.equals(cursor.getString(cursor.getColumnIndexOrThrow("moduleName")))) {
                C2111d.m12654j("ControlBranchClone", str, " tar is archive over. ");
                z10 = true;
            }
            if (i10 % 100 == 0) {
                C2111d.m12654j("ControlBranchClone", " moduleName = ", cursor.getString(cursor.getColumnIndexOrThrow("moduleName")), " tar archive over = ", Integer.valueOf(cursor.getInt(cursor.getColumnIndex("tarOver"))));
            }
        }
        return z10;
    }

    @Override // p359i6.InterfaceC10445a
    /* renamed from: a */
    public boolean mo12820a(int i10) {
        m12805W(i10);
        C2111d.m12654j("ControlBranchClone", "updateAppDataWeight: ", Integer.valueOf(f9607d));
        if (PmsCheckUtil.m12611e()) {
            C10715e.m65405b(f9607d);
            return true;
        }
        C2111d.m12647c("ControlBranchClone", "updateAppDataWeight fail is not support PMS: ", Integer.valueOf(f9607d));
        return true;
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: b */
    public void mo12776b(C2153l.b bVar) throws Throwable {
        HashMap<String, Long> mapM12813P = m12813P(bVar);
        if (C13348q.m80083c(mapM12813P)) {
            return;
        }
        int iM12807I = m12807I(bVar, mapM12813P);
        int length = bVar.f9686b.length;
        for (int i10 = iM12807I; i10 < length; i10++) {
            C2111d.m12654j("ControlBranchClone", "backupOneModule begin ", bVar.f9686b[i10]);
            String str = bVar.f9686b[i10];
            if (BackupObject.isOldPhoneStorageNotEnough(str)) {
                C2111d.m12654j("ControlBranchClone", "[Space] backupOneModule storage not enough, ", str);
                C2153l.m13002A(bVar.f9687c, 2, str, null);
            } else if (m12816S(str, mapM12813P, bVar)) {
                if (this.f9608a == null) {
                    this.f9608a = new TemperatureControl(bVar.f9685a.getApplicationContext());
                }
                this.f9608a.m12591a();
                long jCurrentTimeMillis = System.currentTimeMillis();
                m12777c(bVar, bVar.f9689e, str, null);
                m12818U(mapM12813P, str, jCurrentTimeMillis, System.currentTimeMillis());
                int iM12806H = m12806H(bVar, str, i10, mapM12813P);
                if (iM12806H == 0) {
                    return;
                }
                if (iM12806H == 1) {
                    break;
                }
            } else {
                C2111d.m12658n("ControlBranchClone", "space not enough, can't backup module ", str);
                Bundle bundle = new Bundle();
                bundle.putInt("ErrorCode", 1);
                C2153l.m13002A(bVar.f9687c, 2, str, bundle);
            }
        }
        this.f9609b.set(true);
        C2111d.m12653i("ControlBranchClone", "All module backup done.");
        m12808J(bVar);
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: e */
    public void mo12779e(C2153l.b bVar, String str, BackupObject backupObject) {
        if (bVar == null || backupObject == null) {
            C2111d.m12648d("ControlBranchClone", "doMediaRestore : cmd or object is null");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bVar.f9688d);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(bVar.f9689e);
        sb2.append(str2);
        sb2.append(str);
        C2111d.m12653i("ControlBranchClone", "restoreOneModuel doMediaRestore start!");
        C0050e c0050e = new C0050e();
        c0050e.mo172d(sb2.toString());
        backupObject.onRestore(bVar.f9685a, c0050e, new C2153l.g(bVar.f9687c, str), null, str);
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: f */
    public void mo12780f(C2153l.b bVar, String str, BackupObject backupObject) {
        if (bVar == null || backupObject == null) {
            C2111d.m12648d("ControlBranchClone", "doRestore : cmd or object is null");
            return;
        }
        AbstractC0048c abstractC0048cM12785k = m12785k(bVar.f9688d, bVar.f9689e, str, bVar.f9687c);
        C2111d.m12654j("ControlBranchClone", "doRestore start!get storeHandler finish!module:", str, ",fileName:", bVar.f9689e);
        if (abstractC0048cM12785k == null) {
            C2111d.m12648d("ControlBranchClone", "doRestore error!storeHandler is null!");
            C2153l.m13082z(bVar.f9687c, 13, str);
        } else {
            C2111d.m12654j("ControlBranchClone", "doRestore ", str, ", result ", Integer.valueOf(backupObject.onCloneRestorePro(bVar.f9685a, abstractC0048cM12785k, new C2153l.g(bVar.f9687c, str), str)));
            C13334c.m79980m(abstractC0048cM12785k.m196n());
            C13334c.m79980m(abstractC0048cM12785k.m197o());
            abstractC0048cM12785k.mo170b();
        }
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: g */
    public int mo12781g(Context context, AbstractC0048c abstractC0048c, AbstractC0048c abstractC0048c2, BackupObject backupObject, C2153l.g gVar) {
        if (backupObject == null) {
            C2111d.m12648d("ControlBranchClone", "executeBackup : object is null");
            return 0;
        }
        if (!(backupObject instanceof AbstractC12706c)) {
            return backupObject.onClonePro(context, abstractC0048c, gVar, gVar.f9698b);
        }
        if (abstractC0048c == null) {
            return 1;
        }
        abstractC0048c.mo170b();
        C13334c.m79980m(abstractC0048c.m196n() + "-journal");
        String strM197o = abstractC0048c.m197o();
        if (TextUtils.isEmpty(strM197o)) {
            return 1;
        }
        C13334c.m79980m(strM197o);
        return 1;
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: m */
    public Bundle mo12787m(C2153l.b bVar) {
        return m12788n(bVar);
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: o */
    public ArrayList<String> mo12789o(C2153l.b bVar) {
        return m12786l(bVar);
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: r */
    public BackupObject mo12792r(String str, Handler.Callback callback) {
        if (!HNConstants.DataType.CONTACT.equals(str)) {
            return m12794t(str);
        }
        C11235c c11235c = new C11235c();
        c11235c.setModuleName(str);
        return c11235c;
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: u */
    public Bundle mo12795u(C2153l.b bVar, String str) {
        return m12796v(bVar, str);
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: w */
    public void mo12797w(C2153l.b bVar) {
        String[] strArr;
        C2111d.m12653i("ControlBranchClone", "restoreImp start!");
        if (bVar == null || (strArr = bVar.f9686b) == null) {
            if (BackupObject.getFollowingRestoreModules().size() == 0) {
                C9408a.m59011b();
                return;
            }
            return;
        }
        for (String str : strArr) {
            if (!C13334c.m79969b(C13345n.m80066e(), bVar.f9687c, 115343360L) || C2153l.m13035b0()) {
                C2111d.m12648d("ControlBranchClone", "restoreImp error!checkAvailableSize fail!");
                C2153l.m13082z(bVar.f9687c, 13, str);
                C2153l.m13082z(bVar.f9687c, 3, str);
                return;
            }
            m12798x(bVar, str, null);
        }
        if (BackupObject.getFollowingRestoreModules().size() == 0) {
            C9408a.m59011b();
        }
        C2153l.m13076w(bVar.f9687c, 5);
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: y */
    public void mo12799y(C2153l.b bVar) {
        C2111d.m12648d("ControlBranchClone", "setDecryptInfo start!");
    }

    @Override // com.huawei.android.backup.service.logic.AbstractC2131d
    /* renamed from: z */
    public void mo12800z(C2153l.b bVar) {
        C2111d.m12648d("ControlBranchClone", "setEncryptInfo");
    }
}
