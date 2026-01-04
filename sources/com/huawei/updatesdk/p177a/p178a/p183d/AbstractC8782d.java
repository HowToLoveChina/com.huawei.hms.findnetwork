package com.huawei.updatesdk.p177a.p178a.p183d;

import android.text.TextUtils;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.updatesdk.a.a.d.d */
/* loaded from: classes9.dex */
public abstract class AbstractC8782d {
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* renamed from: a */
    public static String m56038a(String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        String str3;
        MessageDigest messageDigest;
        ?? M56044d = m56044d(str);
        Closeable closeable = null;
        strM56034a = null;
        strM56034a = null;
        String strM56034a = null;
        try {
            if (M56044d != 0) {
                return null;
            }
            try {
                messageDigest = MessageDigest.getInstance(str2);
                fileInputStream = new FileInputStream(str);
            } catch (FileNotFoundException unused) {
                fileInputStream = null;
            } catch (IOException e10) {
                e = e10;
                fileInputStream = null;
            } catch (IllegalArgumentException e11) {
                e = e11;
                fileInputStream = null;
            } catch (IndexOutOfBoundsException e12) {
                e = e12;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e13) {
                e = e13;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                m56039a(closeable);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                long j10 = 0;
                while (true) {
                    int i10 = fileInputStream.read(bArr);
                    if (i10 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i10);
                    j10 += i10;
                }
                if (j10 > 0) {
                    strM56034a = C8780b.m56034a(messageDigest.digest());
                }
            } catch (FileNotFoundException unused2) {
                C8777a.m56028b("FileUtil", "getFileHashData FileNotFoundException");
                m56039a(fileInputStream);
                return strM56034a;
            } catch (IOException e14) {
                e = e14;
                str3 = "getFileHashData IOException";
                C8777a.m56027a("FileUtil", str3, e);
                m56039a(fileInputStream);
                return strM56034a;
            } catch (IllegalArgumentException e15) {
                e = e15;
                str3 = "getFileHashData IllegalArgumentException";
                C8777a.m56027a("FileUtil", str3, e);
                m56039a(fileInputStream);
                return strM56034a;
            } catch (IndexOutOfBoundsException e16) {
                e = e16;
                str3 = "getFileHashData IndexOutOfBoundsException";
                C8777a.m56027a("FileUtil", str3, e);
                m56039a(fileInputStream);
                return strM56034a;
            } catch (NoSuchAlgorithmException e17) {
                e = e17;
                str3 = "getFileHashData NoSuchAlgorithmException";
                C8777a.m56027a("FileUtil", str3, e);
                m56039a(fileInputStream);
                return strM56034a;
            }
            m56039a(fileInputStream);
            return strM56034a;
        } catch (Throwable th3) {
            th = th3;
            closeable = M56044d;
        }
    }

    /* renamed from: b */
    private static boolean m56042b(String str) {
        return m56041a(str) || m56043c(str);
    }

    /* renamed from: c */
    private static boolean m56043c(String str) {
        return str.contains("%00") || str.contains(".\\.\\") || str.contains("./");
    }

    /* renamed from: d */
    public static boolean m56044d(String str) {
        return TextUtils.isEmpty(str) || m56042b(str);
    }

    /* renamed from: a */
    public static void m56039a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                C8777a.m56027a("FileUtil", "Closeable exception", e10);
            }
        }
    }

    /* renamed from: a */
    public static boolean m56040a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                m56040a(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: a */
    private static boolean m56041a(String str) {
        return str.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE) || str.contains("..");
    }
}
