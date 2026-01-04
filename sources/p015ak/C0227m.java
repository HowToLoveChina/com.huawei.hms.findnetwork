package p015ak;

import com.huawei.hiar.ARImageMetadata;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p399jk.AbstractC10896a;

/* renamed from: ak.m */
/* loaded from: classes6.dex */
public class C0227m {
    /* renamed from: a */
    public static String m1588a(byte[] bArr) {
        if (bArr == null) {
            AbstractC10896a.m65887i("HashUtil", "byteToHexStr byteArray is null");
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (Integer.toHexString(bArr[i10] & 255).length() == 1) {
                sb2.append("0");
                sb2.append(Integer.toHexString(bArr[i10] & 255));
            } else {
                sb2.append(Integer.toHexString(bArr[i10] & 255));
            }
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m1589b(File file, int i10) throws C9721b, IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                StringBuilder sb2 = new StringBuilder();
                long j10 = 0;
                while (j10 < file.length()) {
                    long length = file.length() - j10;
                    long j11 = i10;
                    sb2.append(m1590c(fileInputStream, j11 < length ? i10 : (int) length));
                    j10 += j11;
                }
                String string = sb2.toString();
                fileInputStream.close();
                return string;
            } finally {
            }
        } catch (Exception e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getDivideSha256e exception: " + e10.getMessage());
        }
    }

    /* renamed from: c */
    public static String m1590c(FileInputStream fileInputStream, int i10) throws C9721b, NoSuchAlgorithmException {
        byte[] bArr;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            boolean z10 = false;
            while (i10 > 0) {
                if (i10 > 524288) {
                    bArr = new byte[ARImageMetadata.LENS_APERTURE];
                    if (-1 == fileInputStream.read(bArr)) {
                        return null;
                    }
                    messageDigest.update(bArr);
                } else {
                    bArr = new byte[i10];
                    if (-1 == fileInputStream.read(bArr)) {
                        return null;
                    }
                    messageDigest.update(bArr);
                }
                i10 -= bArr.length;
                z10 = true;
            }
            if (z10) {
                return m1588a(messageDigest.digest());
            }
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "read content error.", "HashUtil_getFileSHA256Str");
        } catch (IOException e10) {
            AbstractC10896a.m65886e("HashUtil", "getFileSHA256Str IOException");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "get file part SHA256 error." + e10.toString(), "HashUtil_getFileSHA256Str");
        } catch (GeneralSecurityException e11) {
            AbstractC10896a.m65886e("HashUtil", "getFileSHA256Str GeneralSecurityException");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "get file part SHA256 error." + e11.toString(), "HashUtil_getFileSHA256Str");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1591d(java.lang.String r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "get file part SHA256 error."
            java.lang.String r1 = "HashUtil_getFileSHA256Str"
            java.lang.String r2 = "fis close error."
            java.lang.String r3 = "HashUtil"
            r4 = 1011(0x3f3, float:1.417E-42)
            r5 = 0
            java.io.File r11 = hk.C10278a.m63442h(r11)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.security.GeneralSecurityException -> L7b
            java.io.FileInputStream r11 = hk.C10278a.m63444j(r11)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L76 java.security.GeneralSecurityException -> L7b
            java.lang.String r6 = "SHA-256"
            java.security.MessageDigest r6 = java.security.MessageDigest.getInstance(r6)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            int r7 = r11.available()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            r8 = 0
        L1e:
            if (r7 <= 0) goto L5a
            r8 = -1
            r9 = 524288(0x80000, float:7.34684E-40)
            if (r7 <= r9) goto L41
            byte[] r7 = new byte[r9]     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            int r9 = r11.read(r7)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            if (r8 != r9) goto L35
            r11.close()     // Catch: java.io.IOException -> L31
            goto L34
        L31:
            p399jk.AbstractC10896a.m65886e(r3, r2)
        L34:
            return r5
        L35:
            r6.update(r7)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            goto L54
        L39:
            r0 = move-exception
            r5 = r11
            goto Lbc
        L3d:
            r5 = move-exception
            goto L80
        L3f:
            r5 = move-exception
            goto L9e
        L41:
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            int r9 = r11.read(r7)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            if (r8 != r9) goto L51
            r11.close()     // Catch: java.io.IOException -> L4d
            goto L50
        L4d:
            p399jk.AbstractC10896a.m65886e(r3, r2)
        L50:
            return r5
        L51:
            r6.update(r7)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
        L54:
            int r7 = r11.available()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            r8 = 1
            goto L1e
        L5a:
            if (r8 == 0) goto L6c
            byte[] r5 = r6.digest()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            java.lang.String r0 = m1588a(r5)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            r11.close()     // Catch: java.io.IOException -> L68
            goto L6b
        L68:
            p399jk.AbstractC10896a.m65886e(r3, r2)
        L6b:
            return r0
        L6c:
            fk.b r5 = new fk.b     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            java.lang.String r6 = "read content error."
            r5.<init>(r4, r6, r1)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
            throw r5     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d java.security.GeneralSecurityException -> L3f
        L74:
            r0 = move-exception
            goto Lbc
        L76:
            r11 = move-exception
            r10 = r5
            r5 = r11
            r11 = r10
            goto L80
        L7b:
            r11 = move-exception
            r10 = r5
            r5 = r11
            r11 = r10
            goto L9e
        L80:
            java.lang.String r6 = "getFileSHA256Str IOException"
            p399jk.AbstractC10896a.m65886e(r3, r6)     // Catch: java.lang.Throwable -> L39
            fk.b r6 = new fk.b     // Catch: java.lang.Throwable -> L39
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r7.<init>()     // Catch: java.lang.Throwable -> L39
            r7.append(r0)     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L39
            r7.append(r0)     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = r7.toString()     // Catch: java.lang.Throwable -> L39
            r6.<init>(r4, r0, r1)     // Catch: java.lang.Throwable -> L39
            throw r6     // Catch: java.lang.Throwable -> L39
        L9e:
            java.lang.String r6 = "getFileSHA256Str GeneralSecurityException"
            p399jk.AbstractC10896a.m65886e(r3, r6)     // Catch: java.lang.Throwable -> L39
            fk.b r6 = new fk.b     // Catch: java.lang.Throwable -> L39
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r7.<init>()     // Catch: java.lang.Throwable -> L39
            r7.append(r0)     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L39
            r7.append(r0)     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = r7.toString()     // Catch: java.lang.Throwable -> L39
            r6.<init>(r4, r0, r1)     // Catch: java.lang.Throwable -> L39
            throw r6     // Catch: java.lang.Throwable -> L39
        Lbc:
            if (r5 == 0) goto Lc5
            r5.close()     // Catch: java.io.IOException -> Lc2
            goto Lc5
        Lc2:
            p399jk.AbstractC10896a.m65886e(r3, r2)
        Lc5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0227m.m1591d(java.lang.String):java.lang.String");
    }

    /* renamed from: e */
    public static String m1592e(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return m1588a(m1596i(str.getBytes("utf-8")));
            } catch (C9721b e10) {
                AbstractC10896a.m65886e("HashUtil", "get md5 error." + e10.toString());
                return "";
            } catch (UnsupportedEncodingException unused) {
                AbstractC10896a.m65886e("HashUtil", "Unsupported utf-8 Encoding.");
            }
        }
        return "";
    }

    /* renamed from: f */
    public static String m1593f(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return m1588a(MessageDigest.getInstance("SHA256").digest(str.getBytes("utf-8")));
            } catch (UnsupportedEncodingException unused) {
                AbstractC10896a.m65886e("HashUtil", "Unsupported utf-8 Encoding.");
            } catch (GeneralSecurityException unused2) {
                AbstractC10896a.m65886e("HashUtil", "messageDigest GeneralSecurityException.");
            }
        }
        return "";
    }

    /* renamed from: g */
    public static byte[] m1594g(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length != 0) {
            try {
                return MessageDigest.getInstance("SHA256").digest(bArr);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("HashUtil", "getSHA256Str error: " + e10.toString());
            }
        }
        return bArr2;
    }

    /* renamed from: h */
    public static String m1595h(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "HmacSHA256");
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(secretKeySpec);
                return m1588a(mac.doFinal(str.getBytes("utf-8")));
            } catch (UnsupportedEncodingException unused) {
                AbstractC10896a.m65886e("HashUtil", "Unsupported utf-8 Encoding.");
            } catch (GeneralSecurityException e10) {
                AbstractC10896a.m65886e("HashUtil", "hMACSHA256 GeneralSecurityException" + e10.toString());
            }
        }
        return "";
    }

    /* renamed from: i */
    public static byte[] m1596i(byte[] bArr) throws C9721b {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (GeneralSecurityException e10) {
            AbstractC10896a.m65886e("HashUtil", "messageDigest GeneralSecurityException.");
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "md5 digest error. " + e10.toString(), "HashUtil_messageDigest");
        }
    }
}
