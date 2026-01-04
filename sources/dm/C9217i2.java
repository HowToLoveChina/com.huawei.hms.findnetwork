package dm;

import android.os.SystemClock;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10279b;
import hm.C10321z;
import im.AbstractC10548b;
import im.C10564n;
import im.InterfaceC10570t;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.function.Consumer;
import p015ak.C0227m;
import p455ll.C11308a;
import p495nm.C11728i;
import p495nm.C11735p;
import p514o9.C11839m;
import p848zl.C14337f;

/* renamed from: dm.i2 */
/* loaded from: classes6.dex */
public class C9217i2 implements InterfaceC9213h2 {

    /* renamed from: a */
    public File f46281a;

    /* renamed from: b */
    public C10564n f46282b;

    public C9217i2(File file) {
        this.f46281a = file;
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: Q */
    public File mo57841Q() {
        return this.f46281a;
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: U */
    public String mo57842U() {
        return C10279b.m63452a(this.f46281a);
    }

    /* renamed from: b */
    public final C11308a m57930b(int i10, InterfaceC10570t interfaceC10570t, String str, int i11, String str2, String str3, C4879a c4879a, Consumer<AbstractC10548b> consumer, String str4) throws InterruptedException, C9721b {
        c4879a.isCancel();
        String strM63452a = C10279b.m63452a(this.f46281a);
        C11839m.m70688i("NormalFileHandle", "upload file: " + strM63452a);
        if (!this.f46281a.exists() || this.f46281a.length() <= 0) {
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "file not exist, file = " + strM63452a);
        }
        try {
            C10321z c10321z = new C10321z(c4879a.m29713i0(), c4879a.m29636F0(), c4879a.m29587j(), CloudBackupConstant.Command.PMS_CMD_BACKUP, str2);
            c10321z.m63540D0(c4879a.m29761y0());
            C10564n c10564n = new C10564n(str, i11, str2, c10321z, c4879a.m29719k0(), str3, c4879a, this.f46281a, null, c4879a.m29699d1(), new C11728i(new C11735p()), str4);
            this.f46282b = c10564n;
            try {
                consumer.accept(c10564n);
                this.f46282b.m64772V(i10 > 0);
                if (interfaceC10570t != null) {
                    this.f46282b.m64770T(interfaceC10570t);
                }
                return this.f46282b.m64763M(i10);
            } catch (C9721b e10) {
                e = e10;
                c4879a.isCancel();
                int i12 = i10 + 1;
                if (i12 > 2 || C14337f.m85500c().contains(Integer.valueOf(e.m60659c()))) {
                    throw e;
                }
                SystemClock.sleep(500L);
                c4879a.isCancel();
                C11839m.m70688i("NormalFileHandle", "upload file = " + strM63452a + ", retry = " + i12);
                return m57930b(i12, interfaceC10570t, str, i11, str2, str3, c4879a, consumer, str4);
            }
        } catch (C9721b e11) {
            e = e11;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: d0 */
    public boolean mo57843d0() {
        return this.f46281a.exists();
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: e0 */
    public String mo57844e0() {
        return C10279b.m63452a(this.f46281a);
    }

    @Override // dm.InterfaceC9213h2
    public String getName() {
        return this.f46281a.getName();
    }

    @Override // dm.InterfaceC9213h2
    public String getParent() {
        return this.f46281a.getParent();
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: h0 */
    public C11308a mo57845h0(InterfaceC10570t interfaceC10570t, String str, int i10, String str2, String str3, C4879a c4879a, Consumer<AbstractC10548b> consumer, String str4) throws C9721b {
        return m57930b(0, interfaceC10570t, str, i10, str2, str3, c4879a, consumer, str4);
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: k0 */
    public String mo57846k0(long j10) throws C9721b {
        return C0227m.m1589b(this.f46281a, (int) j10);
    }

    @Override // dm.InterfaceC9213h2
    public long length() {
        return this.f46281a.length();
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: p0 */
    public long mo57847p0() {
        return this.f46281a.lastModified();
    }

    @Override // dm.InterfaceC9213h2
    /* renamed from: v0 */
    public FileInputStream mo57848v0() throws FileNotFoundException {
        return new FileInputStream(this.f46281a);
    }
}
