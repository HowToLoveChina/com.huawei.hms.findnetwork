package cm;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.BackupLockParams;
import com.huawei.android.hicloud.cloudbackup.bean.ServerRetryPolicy;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.LockKeepResult;
import fk.C9721b;
import hm.C10321z;
import java.util.List;
import java.util.function.Predicate;
import je.C10782d;
import ni.C11707b;
import p015ak.C0213f;
import p015ak.C0241z;
import p495nm.C11722c;
import p514o9.C11839m;
import p529op.C11979a;
import p617rl.C12526j;
import p618rm.C12540b1;
import p618rm.C12590s0;
import p711vl.C13466f;
import p851zp.InterfaceC14355b;

/* renamed from: cm.c */
/* loaded from: classes6.dex */
public class C1457c extends AbstractC1455a {

    /* renamed from: u */
    public static final Object f6229u = new Object();

    /* renamed from: v */
    public static final Object f6230v = new Object();

    /* renamed from: d */
    public C10321z f6231d;

    /* renamed from: e */
    public Lock f6232e;

    /* renamed from: f */
    public String f6233f;

    /* renamed from: g */
    public String f6234g;

    /* renamed from: h */
    public String f6235h;

    /* renamed from: i */
    public int f6236i;

    /* renamed from: j */
    public long f6237j;

    /* renamed from: k */
    public boolean f6238k;

    /* renamed from: l */
    public boolean f6239l;

    /* renamed from: m */
    public boolean f6240m = false;

    /* renamed from: n */
    public long f6241n = 0;

    /* renamed from: o */
    public boolean f6242o;

    /* renamed from: p */
    public String f6243p;

    /* renamed from: q */
    public String f6244q;

    /* renamed from: r */
    public int f6245r;

    /* renamed from: s */
    public int f6246s;

    /* renamed from: t */
    public BackupLockParams.LockParamVFSRef f6247t;

    public C1457c(C10321z c10321z, String str, String str2, String str3, int i10, long j10, boolean z10, boolean z11, String str4, String str5) {
        this.f6231d = c10321z;
        this.f6233f = str;
        this.f6234g = str2;
        this.f6235h = str3;
        this.f6236i = i10;
        this.f6237j = j10;
        this.f6238k = z10;
        this.f6239l = z11;
        this.f6243p = str4;
        this.f6244q = str5;
    }

    /* renamed from: k */
    public static long m8334k(C9721b c9721b) {
        C11707b c11707b;
        String message = c9721b.getMessage();
        C11839m.m70688i("CloudBackupV3Lock", "getLockByDelDeviceTime, the retryParams is :" + message);
        if (TextUtils.isEmpty(message) || (c11707b = (C11707b) C12540b1.m75483a(message, C11707b.class)) == null) {
            return 0L;
        }
        String str = (String) c11707b.get("lockByDelDeviceTime");
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return C0241z.m1689g(str, 0L);
    }

    /* renamed from: n */
    public static /* synthetic */ boolean m8335n(C9721b c9721b, Integer num) {
        return String.valueOf(c9721b.m60663g()).endsWith(String.valueOf(num));
    }

    @Override // cm.AbstractC1455a
    /* renamed from: d */
    public Lock mo8329d() {
        Lock lock;
        synchronized (f6229u) {
            lock = this.f6232e;
        }
        return lock;
    }

    @Override // cm.AbstractC1455a
    /* renamed from: e */
    public LockKeepResult mo8330e() throws C9721b {
        C11839m.m70688i("CloudBackupV3Lock", "keep backup lock");
        return this.f6231d.m63561X(this, this.f6233f, true);
    }

    @Override // cm.AbstractC1455a
    /* renamed from: g */
    public boolean mo8332g(C9721b c9721b, String str) throws C9721b {
        boolean z10;
        synchronized (f6230v) {
            try {
                C11839m.m70688i("CloudBackupV3Lock", "retry get backup lock");
                if (this.f6240m) {
                    throw c9721b;
                }
                z10 = false;
                if (System.currentTimeMillis() - this.f6241n > this.f6227b) {
                    C11839m.m70688i("CloudBackupV3Lock", "get backup lock");
                    m8344s(this.f6231d.m63554Q(new BackupLockParams(new BackupLockParams.LockParamDevice(this.f6233f, 0, 0), new BackupLockParams.LockParamBak(this.f6234g, this.f6236i, this.f6237j, this.f6238k, this.f6243p, this.f6244q), this.f6235h, this.f6239l)));
                    SystemClock.sleep(400L);
                    C11839m.m70688i("CloudBackupV3Lock", "keep backup lock");
                    m8331f(this.f6231d.m63561X(this, this.f6233f, false));
                    this.f6241n = System.currentTimeMillis();
                    this.f6226a = System.currentTimeMillis();
                }
                Lock lock = this.f6232e;
                String lockId = lock == null ? "" : lock.getLockId();
                if (!TextUtils.isEmpty(str) && !str.equals(lockId)) {
                    z10 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    /* renamed from: i */
    public void m8336i() {
        synchronized (f6230v) {
            C11839m.m70688i("CloudBackupV3Lock", "lock delete");
            this.f6240m = true;
            m8326a();
            try {
                this.f6231d.m63547J(this, this.f6233f);
            } catch (C9721b e10) {
                BaseLogger.m28732e("CloudBackupV3Lock", "backup lock delete error" + e10.toString(), "Backup.Lock.delete");
            }
            m8344s(null);
        }
    }

    /* renamed from: j */
    public Lock m8337j(InterfaceC14355b interfaceC14355b) throws C9721b {
        Lock lockM8339m;
        try {
            lockM8339m = m8340o(interfaceC14355b);
        } catch (C9721b e10) {
            lockM8339m = m8339m(e10, interfaceC14355b);
        }
        m8344s(lockM8339m);
        return lockM8339m;
    }

    /* renamed from: l */
    public boolean m8338l() {
        return this.f6238k || this.f6242o;
    }

    /* renamed from: m */
    public final Lock m8339m(C9721b c9721b, InterfaceC14355b interfaceC14355b) throws C9721b {
        if (c9721b.m60659c() != 3935) {
            throw c9721b;
        }
        long jM81078f = C13466f.m81073d().m81078f("backup_key_active_time", 0L);
        long jM8334k = m8334k(c9721b);
        C11839m.m70688i("CloudBackupV3Lock", "get backup lock, the active time is:" + jM81078f + ", the server lockByDelDeviceTime is:" + jM8334k);
        if (jM8334k >= jM81078f) {
            C11839m.m70688i("CloudBackupV3Lock", "get backup lock fail, throw server lock exception");
            throw new C9721b(3935, 4094, "keep lock error, the device has been frozen.");
        }
        this.f6245r = 1;
        this.f6246s = 0;
        C11839m.m70688i("CloudBackupV3Lock", "get backup lock, the device has been activated and starts to unfreeze.");
        return m8340o(interfaceC14355b);
    }

    /* renamed from: o */
    public Lock m8340o(InterfaceC14355b interfaceC14355b) throws C9721b {
        C11839m.m70688i("CloudBackupV3Lock", "get backup lock,the lockByDelDevice is :" + this.f6245r + ",the lockByDelDeviceFlag is:" + this.f6246s);
        ServerRetryPolicy serverRetryPolicy = new ServerRetryPolicy();
        if (interfaceC14355b != null) {
            serverRetryPolicy = new C12526j().m75343J0("Backup.Lock.get");
        }
        int iIntValue = serverRetryPolicy.getRetryInterval().intValue();
        int i10 = 0;
        int iMax = Math.max(0, serverRetryPolicy.getRetryTimes().intValue());
        C9721b c9721b = null;
        while (i10 <= iMax) {
            try {
                C11839m.m70688i("CloudBackupV3Lock", "lockRequest attempt: " + i10);
                Lock lockM8341p = m8341p();
                m8344s(lockM8341p);
                return lockM8341p;
            } catch (C9721b e10) {
                C9721b c9721b2 = (e10.m60659c() == 3911 && String.valueOf(e10.m60663g()).endsWith(String.valueOf(4959))) ? new C9721b(3920, e10.getMessage()) : (e10.m60659c() == 3911 && String.valueOf(e10.m60663g()).endsWith(String.valueOf(4291))) ? new C9721b(3941, e10.getMessage()) : e10;
                List<Integer> retryErrorCodes = serverRetryPolicy.getRetryErrorCodes();
                if (interfaceC14355b == null) {
                    throw c9721b2;
                }
                if (i10 >= iMax) {
                    throw c9721b2;
                }
                if (e10.m60659c() != 3911) {
                    throw c9721b2;
                }
                if (!retryErrorCodes.stream().anyMatch(new Predicate() { // from class: cm.b
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return C1457c.m8335n(e10, (Integer) obj);
                    }
                })) {
                    throw c9721b2;
                }
                C11839m.m70688i("CloudBackupV3Lock", "lockGet retryInterval: " + iIntValue + " ,status: " + e10.m60663g());
                iIntValue = m8348w(iIntValue, interfaceC14355b);
                i10++;
                c9721b = c9721b2;
            }
        }
        throw c9721b;
    }

    /* renamed from: p */
    public Lock m8341p() throws C9721b {
        return this.f6231d.m63554Q(new BackupLockParams(new BackupLockParams.LockParamDevice(this.f6233f, this.f6245r, this.f6246s), new BackupLockParams.LockParamBak(this.f6234g, this.f6236i, this.f6237j, this.f6238k, this.f6243p, this.f6244q), this.f6235h, this.f6239l, this.f6247t));
    }

    /* renamed from: q */
    public void m8342q(boolean z10) {
        this.f6242o = z10;
    }

    /* renamed from: r */
    public void m8343r(boolean z10) {
        this.f6238k = z10;
    }

    /* renamed from: s */
    public void m8344s(Lock lock) {
        synchronized (f6229u) {
            try {
                Lock lock2 = this.f6232e;
                if (lock2 == null || lock == null) {
                    this.f6232e = lock;
                } else {
                    lock2.setLockId(lock.getLockId());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: t */
    public void m8345t(boolean z10) {
        if (z10) {
            this.f6245r = 0;
            this.f6246s = 1;
            C12590s0.m75771M0("AutoBackup");
        } else {
            this.f6245r = 1;
            this.f6246s = 0;
            C12590s0.m75809V2("ManualBackup");
        }
    }

    /* renamed from: u */
    public void m8346u(long j10, long j11, boolean z10, long j12) {
        this.f6247t = new BackupLockParams.LockParamVFSRef(j10, j11, z10, j12);
    }

    /* renamed from: v */
    public void m8347v(C11722c c11722c) throws C9721b {
        c11722c.m69936m(this.f6236i);
        c11722c.m69938o(this.f6237j);
        c11722c.m69940q(this.f6244q);
        c11722c.m69942s(this.f6243p);
        c11722c.m69935l(this.f6233f);
        c11722c.m69941r(this.f6235h);
        c11722c.m69937n(this.f6234g);
        c11722c.m69943t(String.valueOf(Math.min(Math.max(0, CloudBackupConditionsUtil.getChargeAttr().getChargeLevel()), 100)));
        c11722c.m69944u(String.valueOf(C11979a.m72102l().m72105j()));
        c11722c.m69945v(C10782d.m65634a().m65635b(C0213f.m1377a()));
        this.f6231d.m63543F0(c11722c);
    }

    /* renamed from: w */
    public final int m8348w(int i10, InterfaceC14355b interfaceC14355b) throws C9721b {
        for (int i11 = 0; i11 < i10; i11++) {
            interfaceC14355b.execute();
            SystemClock.sleep(1000L);
        }
        return i10 * 2;
    }
}
