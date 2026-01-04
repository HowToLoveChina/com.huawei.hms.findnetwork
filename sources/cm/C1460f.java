package cm;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.ServerRetryPolicy;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Request;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Lock;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.LockKeepResult;
import com.huawei.hicloud.cloudbackup.p104v3.server.request.Recover;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import fk.C9721b;
import hm.C10309n0;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;
import p514o9.C11839m;
import p617rl.C12526j;
import p814yl.C14000c0;
import p851zp.InterfaceC14355b;

/* renamed from: cm.f */
/* loaded from: classes6.dex */
public class C1460f extends AbstractC1455a {

    /* renamed from: f */
    public final String f6253f;

    /* renamed from: g */
    public final String f6254g;

    /* renamed from: h */
    public final String f6255h;

    /* renamed from: i */
    public final C10309n0 f6256i;

    /* renamed from: j */
    public Lock f6257j;

    /* renamed from: l */
    public long f6259l;

    /* renamed from: d */
    public final ReadWriteLock f6251d = new ReentrantReadWriteLock();

    /* renamed from: e */
    public final Object f6252e = new Object();

    /* renamed from: k */
    public volatile boolean f6258k = false;

    public C1460f(String str, String str2, String str3) {
        this.f6253f = str;
        this.f6254g = str2;
        this.f6255h = str3;
        this.f6256i = new C10309n0(str);
    }

    /* renamed from: m */
    public static /* synthetic */ boolean m8351m(C9721b c9721b, Integer num) {
        return String.valueOf(c9721b.m60663g()).endsWith(String.valueOf(num));
    }

    /* renamed from: o */
    private int m8352o(int i10, InterfaceC14355b interfaceC14355b) throws C9721b {
        for (int i11 = 0; i11 < i10; i11++) {
            if (interfaceC14355b != null) {
                interfaceC14355b.execute();
            }
            SystemClock.sleep(1000L);
        }
        return i10 * 2;
    }

    @Override // cm.AbstractC1455a
    /* renamed from: d */
    public Lock mo8329d() {
        this.f6251d.readLock().lock();
        try {
            return this.f6257j;
        } finally {
            this.f6251d.readLock().unlock();
        }
    }

    @Override // cm.AbstractC1455a
    /* renamed from: e */
    public LockKeepResult mo8330e() throws C9721b {
        return this.f6256i.m63498q(true, this.f6254g, this.f6255h, this);
    }

    @Override // cm.AbstractC1455a
    /* renamed from: g */
    public boolean mo8332g(C9721b c9721b, String str) throws C9721b {
        boolean z10;
        synchronized (this.f6252e) {
            try {
                C11839m.m70688i("CloudRestoreV3Lock", "retry get restore lock");
                if (this.f6258k) {
                    throw c9721b;
                }
                z10 = false;
                if (System.currentTimeMillis() - this.f6259l > this.f6227b) {
                    C11839m.m70688i("CloudRestoreV3Lock", "retry get restore lock start");
                    m8354k(null);
                    SystemClock.sleep(400L);
                    C11839m.m70688i("CloudRestoreV3Lock", "keep restore lock");
                    m8331f(this.f6256i.m63498q(false, this.f6254g, this.f6255h, this));
                    this.f6259l = System.currentTimeMillis();
                    this.f6226a = System.currentTimeMillis();
                }
                Lock lockMo8329d = mo8329d();
                String lockId = lockMo8329d == null ? "" : lockMo8329d.getLockId();
                if (!TextUtils.isEmpty(str) && !str.equals(lockId)) {
                    z10 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    /* renamed from: j */
    public void m8353j() {
        Lock lockMo8329d;
        C11839m.m70688i("CloudRestoreV3Lock", "lock delete");
        synchronized (this.f6252e) {
            try {
                this.f6258k = true;
                m8326a();
                try {
                    lockMo8329d = mo8329d();
                } catch (C9721b e10) {
                    BaseLogger.m28732e("CloudRestoreV3Lock", "restore lock delete error" + e10, "Recover.Lock.delete");
                }
                if (lockMo8329d == null) {
                    throw new C9721b(HwConstants.LUNAR_YEAR_MIN, "lock is invalid", "Recover.Lock.delete");
                }
                final String lockId = lockMo8329d.getLockId();
                new C14000c0(new C14000c0.a() { // from class: cm.e
                    @Override // p814yl.C14000c0.a
                    /* renamed from: a */
                    public final CloudBackupV3Request mo1697a(CloudBackupV3Server cloudBackupV3Server) {
                        return this.f6249a.m8355l(lockId, cloudBackupV3Server);
                    }
                }).m84139b("Recover.Lock.delete", this.f6253f);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: k */
    public Lock m8354k(InterfaceC14355b interfaceC14355b) throws C9721b {
        C11839m.m70688i("CloudRestoreV3Lock", "get restore lock");
        ServerRetryPolicy serverRetryPolicy = new ServerRetryPolicy();
        if (interfaceC14355b != null) {
            serverRetryPolicy = new C12526j().m75343J0("Recover.Lock.get");
        }
        int iIntValue = serverRetryPolicy.getRetryInterval().intValue();
        C11839m.m70688i("CloudRestoreV3Lock", "recover lockGet retryInterval: " + iIntValue + " ,getRetryErrorCodes: " + serverRetryPolicy.getRetryErrorCodes());
        int iMax = Math.max(0, serverRetryPolicy.getRetryTimes().intValue());
        final C9721b e10 = null;
        for (int i10 = 0; i10 <= iMax; i10++) {
            try {
                this.m8356n(this.f6256i.m63491E(this.f6254g, this.f6255h));
                return this.mo8329d();
            } catch (C9721b e11) {
                e10 = e11;
                List<Integer> retryErrorCodes = serverRetryPolicy.getRetryErrorCodes();
                if (interfaceC14355b == null || i10 >= iMax || e10.m60659c() != 3911 || !retryErrorCodes.stream().anyMatch(new Predicate() { // from class: cm.d
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return C1460f.m8351m(e10, (Integer) obj);
                    }
                })) {
                    throw e10;
                }
                C11839m.m70688i("CloudRestoreV3Lock", "recover lockGet retryInterval: " + iIntValue + " ,status: " + e10.m60663g());
                iIntValue = this.m8352o(iIntValue, interfaceC14355b);
            }
        }
        throw e10;
    }

    /* renamed from: l */
    public final /* synthetic */ CloudBackupV3Request m8355l(String str, CloudBackupV3Server cloudBackupV3Server) throws IOException {
        Recover.Lock.Delete delete = cloudBackupV3Server.recover().lock().delete();
        delete.setBackupDeviceId(this.f6254g).setBakId(this.f6255h).setLockId(str);
        return delete;
    }

    /* renamed from: n */
    public void m8356n(Lock lock) {
        this.f6251d.writeLock().lock();
        try {
            Lock lock2 = this.f6257j;
            if (lock2 == null || lock == null) {
                this.f6257j = lock;
            } else {
                lock2.setLockId(lock.getLockId());
            }
            this.f6251d.writeLock().unlock();
        } catch (Throwable th2) {
            this.f6251d.writeLock().unlock();
            throw th2;
        }
    }
}
