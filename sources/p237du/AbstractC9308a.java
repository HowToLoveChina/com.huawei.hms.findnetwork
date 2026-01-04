package p237du;

import android.app.backup.BackupDataInputStream;
import android.text.TextUtils;
import gu.C10049c;
import gu.C10052f;
import gu.C10053g;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: du.a */
/* loaded from: classes5.dex */
public abstract class AbstractC9308a {

    /* renamed from: a */
    public static final String f46669a = "FileSHA256";

    /* renamed from: b */
    public static final String[] f46670b = {"SHA-256", "SHA-384", "SHA-512"};

    /* renamed from: a */
    public static boolean m58609a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    /* renamed from: b */
    public static boolean m58610b(String str) {
        for (String str2 : f46670b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static String m58611c(File file) {
        return m58612d(file, "SHA-256");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static String m58612d(File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str) || !m58610b(str)) {
            C10053g.m62491c(f46669a, "algorithm is empty or not safe");
            return "";
        }
        if (!m58609a(file)) {
            C10053g.m62491c(f46669a, "file is not valid");
            return "";
        }
        BackupDataInputStream backupDataInputStream = 0;
        String strM62476a = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    boolean z10 = false;
                    while (true) {
                        int i10 = fileInputStream.read(bArr);
                        if (i10 <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i10);
                        z10 = true;
                    }
                    strM62476a = z10 ? C10049c.m62476a(messageDigest.digest()) : null;
                    C10052f.m62488b(fileInputStream);
                } catch (IOException e10) {
                    e = e10;
                    C10053g.m62491c(f46669a, "IOException" + e.getMessage());
                    C10052f.m62488b(fileInputStream);
                    return strM62476a;
                } catch (NoSuchAlgorithmException e11) {
                    e = e11;
                    C10053g.m62491c(f46669a, "NoSuchAlgorithmException" + e.getMessage());
                    C10052f.m62488b(fileInputStream);
                    return strM62476a;
                }
            } catch (IOException e12) {
                e = e12;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e13) {
                e = e13;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                C10052f.m62488b(backupDataInputStream);
                throw th;
            }
            return strM62476a;
        } catch (Throwable th3) {
            th = th3;
            backupDataInputStream = "";
            C10052f.m62488b(backupDataInputStream);
            throw th;
        }
    }

    /* renamed from: e */
    public static boolean m58613e(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(m58611c(file));
    }
}
