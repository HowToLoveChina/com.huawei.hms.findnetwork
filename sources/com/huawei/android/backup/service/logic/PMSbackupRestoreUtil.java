package com.huawei.android.backup.service.logic;

import android.content.Context;
import android.os.Handler;
import android.p018os.IBackupSessionCallback;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import java.io.File;
import p229di.C9137b;
import p229di.C9142g;
import p229di.C9153r;
import p699v4.C13334c;
import p699v4.C13345n;

/* loaded from: classes.dex */
public class PMSbackupRestoreUtil {

    /* renamed from: b */
    public boolean f9573b;

    /* renamed from: c */
    public boolean f9574c;

    /* renamed from: j */
    public Context f9581j;

    /* renamed from: a */
    public long f9572a = 240000;

    /* renamed from: d */
    public int f9575d = -1;

    /* renamed from: e */
    public int f9576e = -1;

    /* renamed from: f */
    public boolean f9577f = false;

    /* renamed from: g */
    public boolean f9578g = false;

    /* renamed from: h */
    public long f9579h = 0;

    /* renamed from: i */
    public long f9580i = 0;

    /* renamed from: k */
    public IBackupSessionCallback f9582k = new IBackupSessionCallback.Stub() { // from class: com.huawei.android.backup.service.logic.PMSbackupRestoreUtil.1
        @Override // android.p018os.IBackupSessionCallback
        public void onTaskStatusChanged(int i10, int i11, int i12, String str) {
            C2111d.m12647c("PMSbackupRestoreUtil", "onTaskStatusChanged:conversationId = ", Integer.valueOf(PMSbackupRestoreUtil.this.f9576e), "/", Integer.valueOf(i10), ",taskId = ", Integer.valueOf(PMSbackupRestoreUtil.this.f9575d), "/", Integer.valueOf(i11), ",statusCode = ", Integer.valueOf(i12), ",appendData = ", str);
            if (PMSbackupRestoreUtil.this.f9576e == i10 || i11 == PMSbackupRestoreUtil.this.f9575d) {
                PMSbackupRestoreUtil.this.f9579h = System.currentTimeMillis();
                if (i12 == 0) {
                    C2111d.m12653i("PMSbackupRestoreUtil", "PMS copy file success, statusCode: " + i12);
                    PMSbackupRestoreUtil.this.f9577f = true;
                }
                if (i12 == 1) {
                    PMSbackupRestoreUtil pMSbackupRestoreUtil = PMSbackupRestoreUtil.this;
                    pMSbackupRestoreUtil.f9580i = pMSbackupRestoreUtil.f9579h;
                    C2111d.m12653i("PMSbackupRestoreUtil", "PMS copy file begin, statusCode: " + i12);
                }
                if (i12 == 2) {
                    C2111d.m12653i("PMSbackupRestoreUtil", "PMS stoped, statusCode: " + i12);
                    PMSbackupRestoreUtil.this.f9578g = true;
                }
                if (i12 == 3 && PMSbackupRestoreUtil.this.f9579h - PMSbackupRestoreUtil.this.f9580i >= 5000) {
                    PMSbackupRestoreUtil pMSbackupRestoreUtil2 = PMSbackupRestoreUtil.this;
                    pMSbackupRestoreUtil2.f9580i = pMSbackupRestoreUtil2.f9579h;
                    C2111d.m12653i("PMSbackupRestoreUtil", "PMS running, statusCode: " + i12 + ";appendData: " + str);
                }
                if (i12 == -1) {
                    C2111d.m12653i("PMSbackupRestoreUtil", "PMS Exception, statusCode: " + i12);
                    PMSbackupRestoreUtil.this.f9578g = true;
                }
            }
        }
    };

    public PMSbackupRestoreUtil(Context context) {
        this.f9581j = context;
    }

    /* renamed from: i */
    public static void m12715i(String str, Context context) {
        boolean zM79980m = C13334c.m79980m("/data/data/com.hicloud.android.clone/files/clone/" + str);
        if (context == null) {
            return;
        }
        String str2 = C13345n.m80070i(context) + str;
        String str3 = C13345n.m80070i(context) + str + ".txt";
        if (!TextUtils.isEmpty(str2)) {
            C13334c.m79980m(str2);
            C13334c.m79980m(str3);
        }
        if (zM79980m) {
            return;
        }
        C2111d.m12653i("PMSbackupRestoreUtil", "begin backup FileHelper deleteAndCreateNewDir fail：" + str);
    }

    /* renamed from: A */
    public final void m12716A(int i10) throws InterruptedException {
        try {
            Thread.sleep(i10);
        } catch (InterruptedException e10) {
            C2111d.m12648d("PMSbackupRestoreUtil", "InterruptedException" + e10.getMessage());
        }
    }

    /* renamed from: B */
    public final int m12717B(long j10) {
        while (!this.f9577f) {
            if (BackupObject.isAbort()) {
                C2111d.m12648d("PMSbackupRestoreUtil", "restore phone clone is abort");
                return 0;
            }
            if (m12718C(j10)) {
                return -1;
            }
            boolean z10 = this.f9578g;
            if (z10) {
                C2111d.m12654j("PMSbackupRestoreUtil", "PMS Exception, mTaskIdException: ", Boolean.valueOf(z10));
                return -1;
            }
        }
        return 0;
    }

    /* renamed from: C */
    public final boolean m12718C(long j10) throws InterruptedException {
        m12716A(100);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = this.f9579h;
        if (jCurrentTimeMillis - j11 <= j10) {
            return false;
        }
        C2111d.m12649e("PMSbackupRestoreUtil", "Time = ", Long.valueOf(jCurrentTimeMillis - j11));
        return true;
    }

    /* renamed from: j */
    public final void m12719j(int i10, int i11, int i12, int i13) {
        if (i10 == 0 && i11 == 4) {
            String strM12723n = m12723n(null, i11, i12);
            C2111d.m12654j("PMSbackupRestoreUtil", "shotcut backup conversationId = ", Integer.valueOf(i13), ";backupCmd = ", strM12723n, ";backupFilePath = ", "shortcut_service");
            C2111d.m12654j("PMSbackupRestoreUtil", "clear shotcut tmpFile success ? 0 is true : ", Integer.valueOf(C9137b.m57449a(i13, strM12723n)));
        }
    }

    /* renamed from: k */
    public final void m12720k(int i10, int i11, int i12, String str, String str2) {
        if (i10 == 0 && i11 == 4) {
            String strM12725p = m12725p(null, str, str2, i11, 0);
            C2111d.m12654j("PMSbackupRestoreUtil", "shotcut restore conversationId = ", Integer.valueOf(i12), ";restoreCmd = ", strM12725p);
            C2111d.m12654j("PMSbackupRestoreUtil", "doRestore shotcut success ? 0 is true : ", Integer.valueOf(C9137b.m57449a(i12, strM12725p)));
        }
    }

    /* renamed from: l */
    public final int m12721l(String str, int i10, long j10, boolean z10) {
        int iM57449a = C9137b.m57449a(i10, str);
        this.f9575d = iM57449a;
        C2111d.m12654j("PMSbackupRestoreUtil", "execute taskId = ", Integer.valueOf(iM57449a), " is backup ? ", Boolean.valueOf(z10));
        if (C2154m.m13107l(this.f9575d)) {
            this.f9579h = System.currentTimeMillis();
            return m12717B(j10);
        }
        C2111d.m12654j("PMSbackupRestoreUtil", "PackageManagerEx startBackupSession fail, taskId:", Integer.valueOf(this.f9575d));
        return -1;
    }

    /* renamed from: m */
    public final void m12722m(int i10) {
        int iM57450b = C9137b.m57450b(i10);
        if (C2154m.m13106k(iM57450b)) {
            return;
        }
        C2111d.m12648d("PMSbackupRestoreUtil", "PackageManagerEx finishBackupSession fail, pes:" + iM57450b);
    }

    /* renamed from: n */
    public final String m12723n(String str, int i10, int i11) {
        return i10 != 2 ? i10 != 3 ? i10 != 4 ? C2154m.m13096a(str, this.f9573b, i11) : C2154m.m13103h(str, i11) : C2154m.m13098c(str, i11) : C2154m.m13099d(str, i11);
    }

    /* renamed from: o */
    public final String m12724o(String str, int i10, int i11) {
        String str2 = C9142g.m57463b() ? "com.hihonor.notepad" : NextRestoreConstants.PKG_NAME_MEMO;
        if (str != null && i11 == 2 && str.contains(str2)) {
            str = str.replace(str2, "com.example.android.notepad");
        }
        if (C9153r.m57494b() == i10) {
            return str;
        }
        return str + "#TwinApp";
    }

    /* renamed from: p */
    public final String m12725p(String str, String str2, String str3, int i10, int i11) {
        return i10 == 3 ? C2154m.m13097b(str, str2) : i10 == 4 ? C2154m.m13105j(str, str2) : this.f9574c ? C2154m.m13102g(str, str2, i11) : i10 == 2 ? C2154m.m13100e(str, str2, str3) : C2154m.m13101f(str, this.f9573b, str2, i11);
    }

    /* renamed from: q */
    public final int m12726q(String str, int i10, int i11) {
        C2111d.m12654j("PMSbackupRestoreUtil", "PMS backup file begin:", str, ", userId is ", Integer.valueOf(i11));
        this.f9577f = false;
        this.f9578g = false;
        if (i10 == 3) {
            C13334c.m79980m("/data/data/com.hicloud.android.clone/files/clone/" + str);
        } else if (i10 != 4) {
            m12715i(m12724o(str, i11, i10), this.f9581j);
        } else {
            C2111d.m12646b("PMSbackupRestoreUtil", "do nothing.");
        }
        int iM57453e = C9137b.m57453e(this.f9582k);
        this.f9576e = iM57453e;
        return iM57453e;
    }

    /* renamed from: r */
    public final int m12727r() {
        this.f9577f = false;
        this.f9578g = false;
        int lastRestoreSession = BackupObject.getLastRestoreSession();
        if (C2154m.m13106k(lastRestoreSession)) {
            C2111d.m12654j("PMSbackupRestoreUtil", "finish last restoreSession is : ", Integer.valueOf(lastRestoreSession));
            C9137b.m57450b(lastRestoreSession);
        }
        int iM57453e = C9137b.m57453e(this.f9582k);
        this.f9576e = iM57453e;
        return iM57453e;
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0024: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:10:0x0024 */
    /* renamed from: s */
    public int m12728s(String str, int i10, int i11) throws Throwable {
        int iM12726q;
        int i12;
        int i13 = -1;
        try {
            try {
                iM12726q = m12726q(str, i10, i11);
            } catch (Exception unused) {
                iM12726q = -1;
            } catch (Throwable th2) {
                th = th2;
                m12722m(i13);
                throw th;
            }
            try {
                if (!C2154m.m13106k(iM12726q)) {
                    C2111d.m12654j("PMSbackupRestoreUtil", "PackageManagerEx startBackupSession fail,conversationId:", Integer.valueOf(iM12726q));
                    m12722m(iM12726q);
                    return -1;
                }
                String strM12723n = m12723n(str, i10, i11);
                if (TextUtils.isEmpty(strM12723n)) {
                    C2111d.m12648d("PMSbackupRestoreUtil", "get backup cmd faild.");
                    m12722m(iM12726q);
                    return -1;
                }
                C2111d.m12654j("PMSbackupRestoreUtil", "backup conversationId = ", Integer.valueOf(iM12726q), ";backupCmd = ", strM12723n, ";backupFilePath = ", str);
                int iM12721l = m12721l(strM12723n, iM12726q, 90000L, true);
                m12719j(iM12721l, i10, i11, iM12726q);
                m12722m(iM12726q);
                return iM12721l;
            } catch (Exception unused2) {
                C2111d.m12648d("PMSbackupRestoreUtil", "PMS Exception.");
                m12722m(iM12726q);
                return -1;
            }
        } catch (Throwable th3) {
            th = th3;
            i13 = i12;
            m12722m(i13);
            throw th;
        }
    }

    /* renamed from: t */
    public int m12729t(String str, int i10, Handler.Callback callback, Object obj) {
        return m12728s(str, i10, C9153r.m57494b());
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0037: MOVE (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:10:0x0037 */
    /* renamed from: u */
    public int m12730u(String str, int i10, int i11, String str2, String str3) throws Throwable {
        int iM12727r;
        int i12;
        int i13 = -1;
        try {
            try {
                C2111d.m12654j("PMSbackupRestoreUtil", "PMS restore file begin:", str);
                iM12727r = m12727r();
            } catch (Exception unused) {
                iM12727r = -1;
            } catch (Throwable th2) {
                th = th2;
                m12732w(i11, str2, str, i13);
                throw th;
            }
            try {
                if (!C2154m.m13106k(iM12727r)) {
                    C2111d.m12654j("PMSbackupRestoreUtil", "PackageManagerEx startBackupSession fail,conversationId:", Integer.valueOf(iM12727r));
                    m12732w(i11, str2, str, iM12727r);
                    return -1;
                }
                BackupObject.setLastRestoreSession(iM12727r);
                String strM12725p = m12725p(str, str2, str3, i11, i10);
                C2111d.m12654j("PMSbackupRestoreUtil", "restore conversationId = ", Integer.valueOf(iM12727r), ";restoreCmd = ", strM12725p, ";moudleName = ", str);
                m12733x(str2, str);
                int iM12721l = m12721l(strM12725p, iM12727r, this.f9572a, false);
                m12720k(iM12721l, i11, iM12727r, str2, str3);
                m12732w(i11, str2, str, iM12727r);
                return iM12721l;
            } catch (Exception unused2) {
                C2111d.m12653i("PMSbackupRestoreUtil", "PMS Exception.");
                m12732w(i11, str2, str, iM12727r);
                return -1;
            }
        } catch (Throwable th3) {
            th = th3;
            i13 = i12;
            m12732w(i11, str2, str, i13);
            throw th;
        }
    }

    /* renamed from: v */
    public int m12731v(String str, int i10, String str2, String str3) {
        return m12730u(str, C9153r.m57494b(), i10, str2, str3);
    }

    /* renamed from: w */
    public final void m12732w(int i10, String str, String str2, int i11) {
        if (i10 == 3) {
            C13334c.m79980m(str2);
        } else if (i10 == 4) {
            C13334c.m79980m(str + File.separator + str2);
        } else {
            m12715i(str2, this.f9581j);
        }
        m12722m(i11);
    }

    /* renamed from: x */
    public final void m12733x(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long jM79988u = C13334c.m79988u(new File(str));
        if (jM79988u > 21474836480L) {
            this.f9572a = (long) (this.f9572a * ((jM79988u * 1.0d) / 2.147483648E10d));
        }
        C2111d.m12654j("PMSbackupRestoreUtil", "set ", str2, " restoreWaitDataTimeout = ", Long.valueOf(this.f9572a));
    }

    /* renamed from: y */
    public void m12734y(boolean z10) {
        this.f9574c = z10;
    }

    /* renamed from: z */
    public void m12735z(boolean z10) {
        this.f9573b = z10;
    }
}
