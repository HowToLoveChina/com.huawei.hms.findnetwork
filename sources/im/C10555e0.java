package im;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;
import mk.C11476b;
import p015ak.C0213f;
import p495nm.C11733n;
import p514o9.C11839m;
import p618rm.C12590s0;

/* renamed from: im.e0 */
/* loaded from: classes6.dex */
public class C10555e0 implements InterfaceC10549b0 {

    /* renamed from: a */
    public String f50773a;

    public C10555e0(String str) {
        this.f50773a = str;
    }

    @Override // im.InterfaceC10549b0
    /* renamed from: a */
    public boolean mo64721a(long j10, long j11, String str) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorM70021c;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            C11733n c11733nM64759g = m64759g();
            boolean z10 = j10 != c11733nM64759g.m70020b();
            boolean z11 = c11733nM64759g.m70019a() != j11;
            if (!z10 && !z11) {
                m64757d(null, null);
                return false;
            }
            parcelFileDescriptorM70021c = c11733nM64759g.m70021c();
            try {
                if (parcelFileDescriptorM70021c == null) {
                    C11839m.m70689w("PmsGetFdStreamSupplier", "executeConsume pfd is null");
                    throw new C9721b(1007, "pfd not find.");
                }
                fileInputStream = new FileInputStream(parcelFileDescriptorM70021c.getFileDescriptor());
                try {
                    Md5AndHash md5AndHashM68624f = C11476b.m68624f(fileInputStream, "");
                    if (TextUtils.isEmpty(md5AndHashM68624f.getHash())) {
                        throw new C9721b(404, "getMd5AndHash fail.");
                    }
                    boolean z12 = !md5AndHashM68624f.getHash().equals(str);
                    m64757d(fileInputStream, parcelFileDescriptorM70021c);
                    return z12;
                } catch (Exception e10) {
                    e = e10;
                    fileInputStream2 = parcelFileDescriptorM70021c;
                    try {
                        if (e instanceof C9721b) {
                            throw ((C9721b) e);
                        }
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, e.getMessage() + ", stackTrace " + C12590s0.m75731C0(e));
                    } catch (Throwable th2) {
                        th = th2;
                        parcelFileDescriptorM70021c = fileInputStream2;
                        fileInputStream2 = fileInputStream;
                        m64757d(fileInputStream2, parcelFileDescriptorM70021c);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream2 = fileInputStream;
                    m64757d(fileInputStream2, parcelFileDescriptorM70021c);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                m64757d(fileInputStream2, parcelFileDescriptorM70021c);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            parcelFileDescriptorM70021c = null;
        }
    }

    @Override // im.InterfaceC10549b0
    /* renamed from: b */
    public void mo64722b(Consumer<FileInputStream> consumer, long j10, long j11) throws C9721b, IOException {
        C11733n c11733nM64759g = m64759g();
        boolean z10 = j10 != c11733nM64759g.m70020b();
        boolean z11 = c11733nM64759g.m70019a() != j11;
        if (!z10 && !z11) {
            m64758e(consumer, c11733nM64759g);
            return;
        }
        C11839m.m70689w("PmsGetFdStreamSupplier", "supplierInputStream has change");
        m64757d(null, c11733nM64759g.m70021c());
        throw new C9721b(1031, "file has modify. timeChange: " + z10 + " sizeChange: " + z11);
    }

    /* renamed from: d */
    public final void m64757d(FileInputStream fileInputStream, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        C11839m.m70686d("PmsGetFdStreamSupplier", "close pms fd.");
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e10) {
                C11839m.m70689w("PmsGetFdStreamSupplier", "input close error: " + e10.toString());
            }
        }
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e11) {
                C11839m.m70689w("PmsGetFdStreamSupplier", "pfd close error: " + e11.toString());
            }
        }
    }

    /* renamed from: e */
    public final void m64758e(Consumer<FileInputStream> consumer, C11733n c11733n) throws C9721b, IOException {
        ParcelFileDescriptor parcelFileDescriptorM70021c = c11733n.m70021c();
        if (parcelFileDescriptorM70021c == null) {
            C11839m.m70689w("PmsGetFdStreamSupplier", "executeConsume pfd is null");
            throw new C9721b(1007, "pfd not find.");
        }
        final FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorM70021c.getFileDescriptor());
        try {
            Optional.of(consumer).ifPresent(new Consumer() { // from class: im.d0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(fileInputStream);
                }
            });
        } catch (Exception e10) {
            C11839m.m70689w("PmsGetFdStreamSupplier", "executeConsume execute consume error: " + e10.toString());
        }
        m64757d(fileInputStream, parcelFileDescriptorM70021c);
    }

    /* renamed from: g */
    public final C11733n m64759g() throws C9721b, IOException {
        if (TextUtils.isEmpty(this.f50773a)) {
            C11839m.m70689w("PmsGetFdStreamSupplier", "supplierInputCheck filePath is null.");
            throw new C9721b(1007, "supplierInputCheck filePath is null.");
        }
        C11733n c11733nBackupFd = new BackupRestoreUtil(C0213f.m1377a(), this.f50773a).backupFd(this.f50773a);
        if (c11733nBackupFd == null) {
            C11839m.m70689w("PmsGetFdStreamSupplier", "supplierInputCheck pmsFdModel is null.");
            throw new C9721b(1007, "pmsFdModel not find.");
        }
        if (c11733nBackupFd.m70022d()) {
            return c11733nBackupFd;
        }
        C11839m.m70689w("PmsGetFdStreamSupplier", "supplierInputCheck not exist");
        m64757d(null, c11733nBackupFd.m70021c());
        throw new C9721b(1032, "file not exist.");
    }

    /* renamed from: h */
    public long[] m64760h(Consumer<FileInputStream> consumer) throws C9721b, IOException {
        C11733n c11733nM64759g = m64759g();
        m64758e(consumer, c11733nM64759g);
        return new long[]{c11733nM64759g.m70020b(), c11733nM64759g.m70019a()};
    }
}
