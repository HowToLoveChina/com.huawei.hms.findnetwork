package dm;

import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import hm.C10321z;
import im.AbstractC10548b;
import im.C10565o;
import im.InterfaceC10570t;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import p015ak.C0213f;
import p015ak.C0227m;
import p455ll.C11308a;
import p495nm.C11733n;
import p514o9.C11839m;
import p618rm.C12590s0;
import p848zl.C14337f;

/* renamed from: dm.s2 */
/* loaded from: classes6.dex */
public class C9257s2 implements InterfaceC9213h2 {

    /* renamed from: a */
    public File f46484a;

    /* renamed from: b */
    public File f46485b;

    /* renamed from: c */
    public C10565o f46486c;

    /* renamed from: d */
    public C11733n f46487d;

    public C9257s2(File file, File file2) {
        this.f46484a = file2;
        this.f46485b = file;
    }

    /* renamed from: o */
    public static /* synthetic */ void m58202o(AtomicBoolean atomicBoolean, C11733n c11733n) {
        atomicBoolean.set(c11733n.m70022d());
    }

    /* renamed from: p */
    public static /* synthetic */ void m58203p(final AtomicBoolean atomicBoolean, C11733n c11733n) {
        Optional.ofNullable(c11733n).ifPresent(new Consumer() { // from class: dm.q2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9257s2.m58202o(atomicBoolean, (C11733n) obj);
            }
        });
    }

    /* renamed from: s */
    public static /* synthetic */ void m58205s(AtomicLong atomicLong, C11733n c11733n) {
        atomicLong.set(c11733n.m70020b());
    }

    /* renamed from: t */
    public static /* synthetic */ void m58206t(final AtomicLong atomicLong, C11733n c11733n) {
        Optional.ofNullable(c11733n).ifPresent(new Consumer() { // from class: dm.r2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9257s2.m58205s(atomicLong, (C11733n) obj);
            }
        });
    }

    /* renamed from: u */
    public static /* synthetic */ void m58207u(AtomicLong atomicLong, C11733n c11733n) {
        atomicLong.set(c11733n.m70019a());
    }

    /* renamed from: v */
    public static /* synthetic */ void m58208v(final AtomicLong atomicLong, C11733n c11733n) {
        Optional.ofNullable(c11733n).ifPresent(new Consumer() { // from class: dm.o2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9257s2.m58207u(atomicLong, (C11733n) obj);
            }
        });
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: Q */
    public File mo57841Q() {
        return this.f46485b;
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: U */
    public String mo57842U() {
        return C10279b.m63452a(this.f46484a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        C11733n c11733n = this.f46487d;
        if (c11733n != null) {
            if (c11733n.m70021c() != null) {
                this.f46487d.m70021c().close();
                C11839m.m70686d("PmsSoftFileHandle", "close pms fd1.");
            }
            this.f46487d = null;
        }
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: d0 */
    public boolean mo57843d0() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        m58210m(new Consumer() { // from class: dm.l2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9257s2.m58203p(atomicBoolean, (C11733n) obj);
            }
        });
        return atomicBoolean.get();
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: e0 */
    public String mo57844e0() {
        File fileM63437c = C10278a.m63437c(this.f46485b);
        if (!fileM63437c.exists() && !fileM63437c.mkdirs()) {
            C11839m.m70688i("PmsSoftFileHandle", "getOriginPath mkdir parent failed: " + C10279b.m63452a(fileM63437c));
        }
        return C10279b.m63452a(this.f46485b);
    }

    @Override // dm.InterfaceC9213h2
    public String getName() {
        return this.f46484a.getName();
    }

    @Override // dm.InterfaceC9213h2
    public String getParent() {
        return this.f46485b.getParent();
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: h0 */
    public C11308a mo57845h0(InterfaceC10570t interfaceC10570t, String str, int i10, String str2, String str3, C4879a c4879a, Consumer<AbstractC10548b> consumer, String str4) throws C9721b {
        return m58214x(0, interfaceC10570t, str, i10, str2, str3, c4879a, consumer, str4);
    }

    /* renamed from: k */
    public final void m58209k(C11733n c11733n) throws IOException {
        if (c11733n != null) {
            try {
                if (c11733n.m70021c() != null) {
                    c11733n.m70021c().close();
                    C11839m.m70686d("PmsSoftFileHandle", "close pms fd2.");
                }
            } catch (IOException e10) {
                C11839m.m70687e("PmsSoftFileHandle", "closePmsFd error: " + e10.getMessage());
            }
        }
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: k0 */
    public String mo57846k0(long j10) throws C9721b {
        long length = length();
        int i10 = (int) j10;
        try {
            try {
                FileInputStream fileInputStreamMo57848v0 = mo57848v0();
                try {
                    StringBuilder sb2 = new StringBuilder();
                    long j11 = 0;
                    while (j11 < length) {
                        long j12 = length - j11;
                        long j13 = i10;
                        sb2.append(C0227m.m1590c(fileInputStreamMo57848v0, j13 < j12 ? i10 : (int) j12));
                        j11 += j13;
                    }
                    String string = sb2.toString();
                    if (fileInputStreamMo57848v0 != null) {
                        fileInputStreamMo57848v0.close();
                    }
                    close();
                    return string;
                } finally {
                }
            } finally {
            }
        } catch (Exception e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getDivideSha256e exception: " + e10.getMessage() + " stack: " + C12590s0.m75731C0(e10));
        }
    }

    @Override // dm.InterfaceC9213h2
    public long length() {
        final AtomicLong atomicLong = new AtomicLong(0L);
        m58210m(new Consumer() { // from class: dm.k2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9257s2.m58208v(atomicLong, (C11733n) obj);
            }
        });
        return atomicLong.get();
    }

    /* renamed from: m */
    public final void m58210m(Consumer<C11733n> consumer) {
        m58211n(consumer, true);
    }

    /* renamed from: n */
    public final void m58211n(Consumer<C11733n> consumer, boolean z10) {
        String strM63452a = C10279b.m63452a(this.f46484a);
        final C11733n c11733nBackupFd = null;
        try {
            c11733nBackupFd = new BackupRestoreUtil(C0213f.m1377a(), strM63452a).backupFd(strM63452a);
            Optional.ofNullable(consumer).ifPresent(new Consumer() { // from class: dm.m2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(c11733nBackupFd);
                }
            });
        } finally {
            if (z10) {
                Optional.ofNullable(consumer).ifPresent(new Consumer() { // from class: dm.n2
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) throws IOException {
                        this.f46368a.m58212r(c11733nBackupFd, (Consumer) obj);
                    }
                });
            }
        }
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: p0 */
    public long mo57847p0() {
        final AtomicLong atomicLong = new AtomicLong(0L);
        m58210m(new Consumer() { // from class: dm.j2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C9257s2.m58206t(atomicLong, (C11733n) obj);
            }
        });
        return atomicLong.get();
    }

    /* renamed from: r */
    public final /* synthetic */ void m58212r(C11733n c11733n, Consumer consumer) throws IOException {
        m58209k(c11733n);
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: v0 */
    public FileInputStream mo57848v0() throws FileNotFoundException {
        m58211n(new Consumer() { // from class: dm.p2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f46382a.m58213w((C11733n) obj);
            }
        }, false);
        C11733n c11733n = this.f46487d;
        if (c11733n == null) {
            C11839m.m70689w("PmsSoftFileHandle", "pmsFdModel is null.");
            throw new FileNotFoundException("pmsFdModel is null. path: " + C10279b.m63452a(this.f46485b));
        }
        ParcelFileDescriptor parcelFileDescriptorM70021c = c11733n.m70021c();
        if (parcelFileDescriptorM70021c != null) {
            return new FileInputStream(parcelFileDescriptorM70021c.getFileDescriptor());
        }
        C11839m.m70689w("PmsSoftFileHandle", "pfd is null.");
        throw new FileNotFoundException("pfd is null. path: " + C10279b.m63452a(this.f46485b));
    }

    /* renamed from: w */
    public final /* synthetic */ void m58213w(C11733n c11733n) {
        this.f46487d = c11733n;
    }

    /* renamed from: x */
    public final C11308a m58214x(int i10, InterfaceC10570t interfaceC10570t, String str, int i11, String str2, String str3, C4879a c4879a, Consumer<AbstractC10548b> consumer, String str4) throws InterruptedException, C9721b {
        long length = length();
        String name = getName();
        String strM63452a = C10279b.m63452a(this.f46484a);
        long jMo57847p0 = mo57847p0();
        c4879a.isCancel();
        if (length <= 0) {
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "file not exist, file = " + name);
        }
        try {
            C10321z c10321z = new C10321z(c4879a.m29713i0(), c4879a.m29636F0(), c4879a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, str2);
            c10321z.m63540D0(c4879a.m29761y0());
            C10565o c10565o = new C10565o(str, i11, str2, c10321z, c4879a.m29719k0(), str3, c4879a.m29728n0(), null, c4879a.m29699d1(), strM63452a, name, length, jMo57847p0, str4);
            this.f46486c = c10565o;
            c10565o.m64827i0(i10 > 0);
            try {
                consumer.accept(this.f46486c);
                try {
                    this.f46486c.m64826h0(interfaceC10570t);
                    return this.f46486c.m64818R(i10);
                } catch (C9721b e10) {
                    e = e10;
                    c4879a.isCancel();
                    int i12 = i10 + 1;
                    if (i12 > 2 || C14337f.m85500c().contains(Integer.valueOf(e.m60659c()))) {
                        throw e;
                    }
                    SystemClock.sleep(500L);
                    c4879a.isCancel();
                    C11839m.m70688i("PmsSoftFileHandle", "upload file = " + getName() + ", retry = " + i12);
                    return m58214x(i12, interfaceC10570t, str, i11, str2, str3, c4879a, consumer, str4);
                }
            } catch (C9721b e11) {
                e = e11;
            }
        } catch (C9721b e12) {
            e = e12;
        }
    }
}
