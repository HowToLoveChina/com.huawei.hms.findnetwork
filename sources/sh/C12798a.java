package sh;

import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import p613rh.C12510a;
import th.C13012a;

/* renamed from: sh.a */
/* loaded from: classes4.dex */
public class C12798a {
    /* renamed from: a */
    public static String m76786a(int i10) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(0);
        if (i10 >= 100) {
            i10 = 100;
        }
        return percentInstance.format(i10 / 100.0d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* renamed from: b */
    public static String m76787b(String str, String str2) throws Throwable {
        Throwable th2;
        ?? r10;
        Throwable e10;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        String str3;
        String str4;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        strM75103a = null;
        strM75103a = null;
        String strM75103a = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance(str2);
                fileInputStream = new FileInputStream(str);
            } catch (FileNotFoundException unused) {
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (IOException e11) {
                e10 = e11;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (IllegalArgumentException e12) {
                e10 = e12;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (IndexOutOfBoundsException e13) {
                e10 = e13;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e14) {
                e10 = e14;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (Throwable th3) {
                th2 = th3;
                r10 = 0;
                m76788c(r10);
                m76788c(fileInputStream2);
                throw th2;
            }
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    byte[] bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                    long j10 = 0;
                    while (true) {
                        int i10 = bufferedInputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i10);
                        j10 += i10;
                    }
                    if (j10 > 0) {
                        strM75103a = C12510a.m75103a(messageDigest.digest());
                    }
                } catch (FileNotFoundException unused2) {
                    C13012a.m78317c("FileUtils", "getFileHashData FileNotFoundException");
                    m76788c(bufferedInputStream);
                    m76788c(fileInputStream);
                    return strM75103a;
                } catch (IOException e15) {
                    e10 = e15;
                    str4 = "getFileHashData IOException";
                    C13012a.m78316b("FileUtils", str4, e10);
                    m76788c(bufferedInputStream);
                    m76788c(fileInputStream);
                    return strM75103a;
                } catch (IllegalArgumentException e16) {
                    e10 = e16;
                    str4 = "getFileHashData IllegalArgumentException";
                    C13012a.m78316b("FileUtils", str4, e10);
                    m76788c(bufferedInputStream);
                    m76788c(fileInputStream);
                    return strM75103a;
                } catch (IndexOutOfBoundsException e17) {
                    e10 = e17;
                    str4 = "getFileHashData IndexOutOfBoundsException";
                    C13012a.m78316b("FileUtils", str4, e10);
                    m76788c(bufferedInputStream);
                    m76788c(fileInputStream);
                    return strM75103a;
                } catch (NoSuchAlgorithmException e18) {
                    e10 = e18;
                    str4 = "getFileHashData NoSuchAlgorithmException";
                    C13012a.m78316b("FileUtils", str4, e10);
                    m76788c(bufferedInputStream);
                    m76788c(fileInputStream);
                    return strM75103a;
                }
            } catch (FileNotFoundException unused3) {
                bufferedInputStream = null;
            } catch (IOException e19) {
                e10 = e19;
                bufferedInputStream = null;
            } catch (IllegalArgumentException e20) {
                e10 = e20;
                bufferedInputStream = null;
            } catch (IndexOutOfBoundsException e21) {
                e10 = e21;
                bufferedInputStream = null;
            } catch (NoSuchAlgorithmException e22) {
                e10 = e22;
                bufferedInputStream = null;
            } catch (Throwable th4) {
                th2 = th4;
                str3 = null;
                fileInputStream2 = fileInputStream;
                r10 = str3;
                m76788c(r10);
                m76788c(fileInputStream2);
                throw th2;
            }
            m76788c(bufferedInputStream);
            m76788c(fileInputStream);
            return strM75103a;
        } catch (Throwable th5) {
            th2 = th5;
            str3 = str;
        }
    }

    /* renamed from: c */
    public static void m76788c(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
                C13012a.m78319e("FileUtils", "close stream exception");
            }
        }
    }
}
