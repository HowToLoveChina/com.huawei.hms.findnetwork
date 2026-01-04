package za;

import android.text.TextUtils;
import com.huawei.hicloud.base.slice.FileSliceInputStream;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.DigestInputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p015ak.C0227m;
import p514o9.C11839m;
import p525ok.C11908a;
import p782xo.C13842a;

/* renamed from: za.b */
/* loaded from: classes3.dex */
public class C14165b {

    /* renamed from: za.b$a */
    public static class a {

        /* renamed from: a */
        public String f63325a;

        public a(String str) {
            this.f63325a = str;
        }

        /* renamed from: a */
        public String m85045a() {
            return this.f63325a;
        }
    }

    /* renamed from: a */
    public static void m85028a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                C11839m.m70689w("HashFile", "close error: " + e10);
            }
        }
    }

    /* renamed from: b */
    public static void m85029b(File file, File file2, long j10, byte[] bArr, byte[] bArr2) throws Throwable {
        RandomAccessFile randomAccessFile;
        byte[] bArr3 = new byte[10240];
        FileInputStream fileInputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                C11839m.m70689w("HashFile", "decryptSliceFile mkdirs = " + parentFile.mkdirs());
            }
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    randomAccessFile.seek(j10);
                    Cipher cipherM85025d = C14164a.m85025d(2, bArr, bArr2);
                    while (true) {
                        int i10 = fileInputStream2.read(bArr3);
                        if (i10 == -1) {
                            break;
                        }
                        byte[] bArrUpdate = cipherM85025d.update(bArr3, 0, i10);
                        if (bArrUpdate != null) {
                            randomAccessFile.write(bArrUpdate);
                        }
                    }
                    byte[] bArrDoFinal = cipherM85025d.doFinal();
                    if (bArrDoFinal != null) {
                        randomAccessFile.write(bArrDoFinal);
                    }
                    m85028a(fileInputStream2);
                    m85028a(randomAccessFile);
                } catch (IOException | GeneralSecurityException e10) {
                    e = e10;
                    fileInputStream = fileInputStream2;
                    try {
                        throw new C9721b(4005, "decrypt slice file error: " + e.getMessage());
                    } catch (Throwable th2) {
                        th = th2;
                        m85028a(fileInputStream);
                        m85028a(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    m85028a(fileInputStream);
                    m85028a(randomAccessFile);
                    throw th;
                }
            } catch (IOException | GeneralSecurityException e11) {
                e = e11;
                randomAccessFile = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
            }
        } catch (IOException | GeneralSecurityException e12) {
            e = e12;
            randomAccessFile = null;
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
        }
    }

    /* renamed from: c */
    public static String m85030c(String str, byte[] bArr) throws C9721b {
        try {
            return C14164a.m85024c(str, bArr, m85041n());
        } catch (IOException | GeneralSecurityException e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "fileEFEK error: " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public static String m85031d(String str) throws C9721b {
        return C14164a.m85022a(m85043p(str));
    }

    /* renamed from: e */
    public static byte[] m85032e(String str) {
        return m85043p(str);
    }

    /* renamed from: f */
    public static String m85033f(String str) {
        return C14164a.m85022a(m85044q(str));
    }

    /* renamed from: g */
    public static byte[] m85034g(String str) {
        return m85044q(str);
    }

    /* renamed from: h */
    public static a m85035h(File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    a aVarM85036i = m85036i(fileInputStream2);
                    m85028a(fileInputStream2);
                    return aVarM85036i;
                } catch (IOException | GeneralSecurityException e10) {
                    e = e10;
                    fileInputStream = fileInputStream2;
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "compute file hash error: " + e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    m85028a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException | GeneralSecurityException e11) {
            e = e11;
        }
    }

    /* renamed from: i */
    public static a m85036i(InputStream inputStream) throws Throwable {
        DigestInputStream digestInputStream = null;
        try {
            DigestInputStream digestInputStream2 = new DigestInputStream(inputStream, MessageDigest.getInstance("SHA-256"));
            try {
                byte[] bArr = new byte[8192];
                for (int i10 = digestInputStream2.read(bArr); i10 != -1; i10 = digestInputStream2.read(bArr)) {
                }
                a aVar = new a(C14164a.m85022a(digestInputStream2.getMessageDigest().digest()));
                m85028a(digestInputStream2);
                return aVar;
            } catch (Throwable th2) {
                th = th2;
                digestInputStream = digestInputStream2;
                m85028a(digestInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: j */
    public static a m85037j(List<SliceItem<File>> list) throws Throwable {
        FileSliceInputStream fileSliceInputStream = null;
        try {
            try {
                FileSliceInputStream fileSliceInputStream2 = new FileSliceInputStream(list);
                try {
                    a aVarM85036i = m85036i(fileSliceInputStream2);
                    m85028a(fileSliceInputStream2);
                    return aVarM85036i;
                } catch (IOException | GeneralSecurityException e10) {
                    e = e10;
                    fileSliceInputStream = fileSliceInputStream2;
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "compute file slice hash error: " + e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    fileSliceInputStream = fileSliceInputStream2;
                    m85028a(fileSliceInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException | GeneralSecurityException e11) {
            e = e11;
        }
    }

    /* renamed from: k */
    public static String m85038k(File file) {
        try {
            return m85035h(file).m85045a();
        } catch (Exception e10) {
            C11839m.m70689w("HashFile", "getFileHashDefault error = " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: l */
    public static String m85039l(String str) {
        try {
            return C0227m.m1591d(str);
        } catch (Exception e10) {
            C11839m.m70689w("HashFile", "getFileSHA256Default error = " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: m */
    public static String m85040m(File file) throws Throwable {
        String strM83034m = C13842a.m83010i().m83034m("hmacsha256_key_common_file");
        if (TextUtils.isEmpty(strM83034m)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "file key is empty");
        }
        byte[] bArrM85026e = C14164a.m85026e(strM83034m);
        FileInputStream fileInputStream = null;
        try {
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(new SecretKeySpec(bArrM85026e, mac.getAlgorithm()));
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int i10 = fileInputStream2.read(bArr);
                        if (i10 <= 0) {
                            break;
                        }
                        mac.update(bArr, 0, i10);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b10 : mac.doFinal()) {
                        sb2.append(String.format(Locale.ENGLISH, "%02x", Byte.valueOf(b10)));
                    }
                    String string = sb2.toString();
                    m85028a(fileInputStream2);
                    return string;
                } catch (IOException | GeneralSecurityException e10) {
                    e = e10;
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "get hmac file error: " + e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    m85028a(fileInputStream);
                    throw th;
                }
            } catch (IOException | GeneralSecurityException e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: n */
    public static byte[] m85041n() throws NoSuchAlgorithmException {
        return C11908a.m71443b(16);
    }

    /* renamed from: o */
    public static String m85042o(String str) throws C9721b {
        String strM83034m = C13842a.m83010i().m83034m("hmacsha256_key_common_string");
        if (TextUtils.isEmpty(strM83034m)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "string key is empty");
        }
        try {
            return C14164a.m85027f(str, strM83034m);
        } catch (IOException | GeneralSecurityException e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "fileEFEK error: " + e10.getMessage());
        }
    }

    /* renamed from: p */
    public static byte[] m85043p(String str) {
        if (str == null) {
            return null;
        }
        return C14164a.m85026e(str.substring(0, str.length() / 2));
    }

    /* renamed from: q */
    public static byte[] m85044q(String str) {
        if (str == null) {
            return null;
        }
        return C14164a.m85026e(str.substring(str.length() / 2));
    }
}
