package p248e5;

import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.BackupConstant;
import java.io.File;
import java.io.IOException;
import p006a5.AbstractC0048c;
import p217d5.C9040a;
import p699v4.C13334c;

/* renamed from: e5.b */
/* loaded from: classes.dex */
public class C9409b {

    /* renamed from: a */
    public static int f47042a;

    /* renamed from: b */
    public static String f47043b;

    /* renamed from: e5.b$a */
    public static class a {
        /* renamed from: a */
        public static boolean m59028a(int i10) {
            return i10 != 0;
        }
    }

    /* renamed from: a */
    public static AbstractC0048c m59020a(C9414g c9414g, boolean z10) {
        if (c9414g != null) {
            if (!C13334c.m79980m(C13334c.m79962F(c9414g.m59039c()) + File.separator + c9414g.m59038b())) {
                C9040a.m57002b(c9414g.m59037a(), 17, 0, 0, c9414g.m59038b());
            }
        }
        return m59024e(c9414g, null, z10);
    }

    /* renamed from: b */
    public static AbstractC0048c m59021b(String str) {
        try {
            try {
                return (AbstractC0048c) Class.forName(BackupConstant.m13134h().get(str)).newInstance();
            } catch (IllegalAccessException unused) {
                C2111d.m12648d("EncryptManager", "createRawStoreHandler IllegalAccessException.");
                return null;
            } catch (InstantiationException unused2) {
                C2111d.m12648d("EncryptManager", "createRawStoreHandler InstantiationException.");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            C2111d.m12648d("EncryptManager", "createRawStoreHandler ClassNotFoundException.");
            return null;
        }
    }

    /* renamed from: c */
    public static String m59022c() {
        return f47043b;
    }

    /* renamed from: d */
    public static int m59023d() {
        return f47042a;
    }

    /* renamed from: e */
    public static AbstractC0048c m59024e(C9414g c9414g, String str, boolean z10) {
        C2111d.m12654j("EncryptManager", "openFile ", Boolean.valueOf(z10));
        if (c9414g == null) {
            return null;
        }
        AbstractC0048c abstractC0048cM59021b = m59021b(c9414g.m59041e());
        if (abstractC0048cM59021b == null) {
            C9040a.m57002b(c9414g.m59037a(), 11, 0, 0, c9414g.m59040d());
            return null;
        }
        try {
            String strM79989v = C13334c.m79989v(c9414g.m59039c(), c9414g.m59038b(), str, c9414g.m59040d());
            if (strM79989v == null) {
                return null;
            }
            if (abstractC0048cM59021b.mo172d(strM79989v)) {
                return abstractC0048cM59021b;
            }
            return null;
        } catch (IOException unused) {
            C2111d.m12648d("EncryptManager", "openFile IOException");
            return null;
        } catch (Exception unused2) {
            C2111d.m12648d("EncryptManager", "openFile error");
            return null;
        }
    }

    /* renamed from: f */
    public static AbstractC0048c m59025f(C9414g c9414g, boolean z10) {
        C2111d.m12654j("EncryptManager", "openFileForRestore ", Boolean.valueOf(z10));
        AbstractC0048c abstractC0048cM59021b = c9414g != null ? m59021b(c9414g.m59041e()) : null;
        if (abstractC0048cM59021b == null) {
            C2111d.m12653i("EncryptManager", "newStoreHandler storeHandler = null");
            return null;
        }
        String strM59040d = c9414g.m59040d();
        String strM59038b = c9414g.m59038b();
        String strM59039c = c9414g.m59039c();
        StringBuilder sb2 = new StringBuilder(strM59039c);
        String str = File.separator;
        sb2.append(str);
        sb2.append(strM59038b);
        sb2.append(str);
        sb2.append(strM59040d);
        sb2.append(abstractC0048cM59021b.mo195m());
        String string = sb2.toString();
        File file = new File(string);
        if (BackupConstant.BackupObject.getBackupSystemObject().contains(strM59040d) && (!file.exists() || file.length() == 0)) {
            if (!AbstractC0048c.m183q()) {
                C9040a.m57002b(c9414g.m59037a(), 1067, 0, 0, strM59040d);
            }
            C2111d.m12649e("EncryptManager", "file empty!!! exist ? ", Boolean.valueOf(file.exists()));
            return null;
        }
        abstractC0048cM59021b.m206z(string);
        abstractC0048cM59021b.m205y(strM59039c + str + strM59038b + str + strM59040d);
        return abstractC0048cM59021b;
    }

    /* renamed from: g */
    public static void m59026g(boolean z10, String str, String str2) {
        if (z10 && str == null) {
            C2111d.m12648d("EncryptManager", "setBackupEncryptInfo password is null");
        } else {
            f47042a = 0;
            f47043b = str2;
        }
    }

    /* renamed from: h */
    public static void m59027h() {
        C2111d.m12653i("EncryptManager", "setRestoreDecryptInfoUnEncrypted");
        f47042a = 0;
    }
}
