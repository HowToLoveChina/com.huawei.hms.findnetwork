package mk;

import com.huawei.hicloud.base.bean.Md5AndHash;
import com.huawei.hicloud.base.slice.FileSliceInputStream;
import com.huawei.hicloud.base.slice.LimitedInputStream;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p015ak.C0241z;
import p399jk.AbstractC10896a;

/* renamed from: mk.b */
/* loaded from: classes6.dex */
public class C11476b {
    /* renamed from: a */
    public static String m68619a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            int i10 = b10 & 255;
            if (Integer.toHexString(i10).length() == 1) {
                sb2.append("0");
                sb2.append(Integer.toHexString(i10));
            } else {
                sb2.append(Integer.toHexString(i10));
            }
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m68620b(File file) throws Throwable {
        int i10 = 0;
        while (true) {
            try {
                byte[] bArrM68621c = m68621c(file);
                StringBuilder sb2 = new StringBuilder();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(bArrM68621c);
                    for (byte b10 : messageDigest.digest()) {
                        String hexString = Integer.toHexString(b10 & 255);
                        if (hexString.length() < 2) {
                            sb2.append("0");
                        }
                        sb2.append(hexString);
                    }
                    return sb2.toString();
                } catch (GeneralSecurityException e10) {
                    AbstractC10896a.m65886e("Hash", "get sha256 failed");
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "file hash sha256 error. " + e10.toString(), "HashUtil_getSHA256");
                }
            } catch (IOException e11) {
                int i11 = i10 + 1;
                if (i10 >= 1) {
                    AbstractC10896a.m65887i("Hash", "get manifest file failed due to IOException" + e11.toString());
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, file.getName() + " get manifest file io error. " + e11.toString(), "HashUtil_getManifestFile");
                }
                i10 = i11;
            }
        }
    }

    /* renamed from: c */
    public static byte[] m68621c(File file) throws Throwable {
        ZipFile zipFile;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        String name = file.getName();
        InputStream inputStream = null;
        try {
            zipFile = new ZipFile(file);
            try {
                ZipEntry entry = zipFile.getEntry("META-INF/MANIFEST.MF");
                if (entry == null) {
                    throw new C9721b(1009, name + " META-INF/MANIFEST.MF do not exits", "HashUtil_getManifestFile");
                }
                InputStream inputStream2 = zipFile.getInputStream(entry);
                if (inputStream2 == null) {
                    throw new C9721b(1009, name + " META-INF/MANIFEST.MFzip input stream error.", "HashUtil_getManifestFile");
                }
                while (true) {
                    int i10 = inputStream2.read(bArr);
                    if (i10 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    inputStream2.close();
                } catch (IOException unused) {
                    AbstractC10896a.m65888w("Hash", "zipInputStream close error.");
                }
                try {
                    zipFile.close();
                } catch (IOException unused2) {
                    AbstractC10896a.m65888w("Hash", "zipFile close error.");
                }
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                        AbstractC10896a.m65888w("Hash", "zipInputStream close error.");
                    }
                }
                if (zipFile == null) {
                    throw th;
                }
                try {
                    zipFile.close();
                    throw th;
                } catch (IOException unused4) {
                    AbstractC10896a.m65888w("Hash", "zipFile close error.");
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
        }
    }

    /* renamed from: d */
    public static Md5AndHash m68622d(File file) throws C9721b {
        try {
            return m68624f(C10278a.m63444j(file), C10279b.m63452a(file));
        } catch (FileNotFoundException e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "Unable to compute hash file not found: " + e10.getMessage() + C10279b.m63452a(file));
        }
    }

    /* renamed from: e */
    public static Md5AndHash m68623e(File file, long j10, int i10) throws Throwable {
        Throwable th2;
        DigestInputStream digestInputStream;
        MessageDigest messageDigest;
        LimitedInputStream limitedInputStream = null;
        try {
            try {
                LimitedInputStream limitedInputStream2 = new LimitedInputStream(C10278a.m63444j(file), j10, i10);
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                    digestInputStream = new DigestInputStream(limitedInputStream2, MessageDigest.getInstance("SHA-256"));
                } catch (FileNotFoundException e10) {
                    e = e10;
                } catch (IOException | GeneralSecurityException e11) {
                    e = e11;
                } catch (Throwable th3) {
                    th2 = th3;
                    digestInputStream = null;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i11 = digestInputStream.read(bArr);
                        if (i11 == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i11);
                    }
                    Md5AndHash md5AndHash = new Md5AndHash(m68619a(messageDigest.digest()), m68619a(digestInputStream.getMessageDigest().digest()));
                    try {
                        limitedInputStream2.close();
                    } catch (IOException unused) {
                        AbstractC10896a.m65888w("Hash", "randomAccessFile close error");
                    }
                    try {
                        digestInputStream.close();
                    } catch (IOException e12) {
                        AbstractC10896a.m65888w("Hash", "digestInputStream close error while signing request: " + e12);
                    }
                    return md5AndHash;
                } catch (FileNotFoundException e13) {
                    e = e13;
                    throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "get file range hash error. file not found: " + e.toString(), "range_hash");
                } catch (IOException | GeneralSecurityException e14) {
                    e = e14;
                    AbstractC10896a.m65886e("Hash", "get file range hash error. " + e.toString());
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "get file range hash error. " + e.toString(), "range_hash");
                } catch (Throwable th4) {
                    th2 = th4;
                    limitedInputStream = limitedInputStream2;
                    if (limitedInputStream != null) {
                        try {
                            limitedInputStream.close();
                        } catch (IOException unused2) {
                            AbstractC10896a.m65888w("Hash", "randomAccessFile close error");
                        }
                    }
                    if (digestInputStream == null) {
                        throw th2;
                    }
                    try {
                        digestInputStream.close();
                        throw th2;
                    } catch (IOException e15) {
                        AbstractC10896a.m65888w("Hash", "digestInputStream close error while signing request: " + e15);
                        throw th2;
                    }
                }
            } catch (FileNotFoundException e16) {
                e = e16;
            } catch (IOException | GeneralSecurityException e17) {
                e = e17;
            } catch (Throwable th5) {
                th2 = th5;
                digestInputStream = null;
            }
        } catch (Throwable th6) {
            th2 = th6;
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x002d: MOVE (r4 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:77:0x002d */
    /* renamed from: f */
    public static Md5AndHash m68624f(FileInputStream fileInputStream, String str) throws Throwable {
        FileNotFoundException e10;
        InputStream inputStream;
        if (fileInputStream == null) {
            throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "inputStream is empty");
        }
        InputStream inputStream2 = null;
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("SHA-256"));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i10 = digestInputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i10);
                    }
                    Md5AndHash md5AndHash = new Md5AndHash(m68619a(messageDigest.digest()), m68619a(digestInputStream.getMessageDigest().digest()));
                    try {
                        fileInputStream.close();
                    } catch (IOException e11) {
                        AbstractC10896a.m65888w("Hash", "input close error while signing request: " + e11);
                    }
                    try {
                        digestInputStream.close();
                    } catch (IOException e12) {
                        AbstractC10896a.m65888w("Hash", "digestInputStream close error while signing request: " + e12);
                    }
                    return md5AndHash;
                } catch (FileNotFoundException e13) {
                    e10 = e13;
                    throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "Unable to compute hash file not found: " + e10.getMessage() + str);
                } catch (IOException | GeneralSecurityException e14) {
                    e = e14;
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "Unable to compute hash while signing request: " + e.getMessage() + str);
                }
            } catch (FileNotFoundException e15) {
                e10 = e15;
            } catch (IOException | GeneralSecurityException e16) {
                e = e16;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream2 = inputStream;
            try {
                fileInputStream.close();
            } catch (IOException e17) {
                AbstractC10896a.m65888w("Hash", "input close error while signing request: " + e17);
            }
            if (inputStream2 == null) {
                throw th;
            }
            try {
                inputStream2.close();
                throw th;
            } catch (IOException e18) {
                AbstractC10896a.m65888w("Hash", "digestInputStream close error while signing request: " + e18);
                throw th;
            }
        }
    }

    /* renamed from: g */
    public static Md5AndHash m68625g(List<SliceItem<File>> list) throws Throwable {
        DigestInputStream digestInputStream;
        MessageDigest messageDigest;
        FileSliceInputStream fileSliceInputStream = null;
        try {
            try {
                FileSliceInputStream fileSliceInputStream2 = new FileSliceInputStream(list);
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                    digestInputStream = new DigestInputStream(fileSliceInputStream2, MessageDigest.getInstance("SHA-256"));
                } catch (FileNotFoundException e10) {
                    e = e10;
                } catch (IOException | GeneralSecurityException e11) {
                    e = e11;
                } catch (Throwable th2) {
                    th = th2;
                    digestInputStream = null;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i10 = digestInputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i10);
                    }
                    Md5AndHash md5AndHash = new Md5AndHash(m68619a(messageDigest.digest()), m68619a(digestInputStream.getMessageDigest().digest()));
                    try {
                        fileSliceInputStream2.close();
                    } catch (IOException e12) {
                        AbstractC10896a.m65888w("Hash", "input close error while signing request: " + e12);
                    }
                    try {
                        digestInputStream.close();
                    } catch (IOException e13) {
                        AbstractC10896a.m65888w("Hash", "digestInputStream close error while signing request: " + e13);
                    }
                    return md5AndHash;
                } catch (FileNotFoundException e14) {
                    e = e14;
                    throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "Unable to compute slice hash file not found: " + e.getMessage());
                } catch (IOException | GeneralSecurityException e15) {
                    e = e15;
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "Unable to compute slice hash while signing request: " + e.getMessage());
                } catch (Throwable th3) {
                    th = th3;
                    fileSliceInputStream = fileSliceInputStream2;
                    if (fileSliceInputStream != null) {
                        try {
                            fileSliceInputStream.close();
                        } catch (IOException e16) {
                            AbstractC10896a.m65888w("Hash", "input close error while signing request: " + e16);
                        }
                    }
                    if (digestInputStream == null) {
                        throw th;
                    }
                    try {
                        digestInputStream.close();
                        throw th;
                    } catch (IOException e17) {
                        AbstractC10896a.m65888w("Hash", "digestInputStream close error while signing request: " + e17);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e18) {
                e = e18;
            } catch (IOException | GeneralSecurityException e19) {
                e = e19;
            } catch (Throwable th4) {
                th = th4;
                digestInputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* renamed from: h */
    public static String m68626h(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return m68619a(MessageDigest.getInstance("SHA256").digest(str.getBytes(StandardCharsets.UTF_8)));
            } catch (GeneralSecurityException unused) {
                AbstractC10896a.m65886e("Hash", "messageDigest GeneralSecurityException.");
            }
        }
        return "";
    }

    /* renamed from: i */
    public static String m68627i(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return m68619a(MessageDigest.getInstance("SHA256").digest(bArr));
            } catch (GeneralSecurityException unused) {
                AbstractC10896a.m65886e("Hash", "messageDigest GeneralSecurityException.");
            }
        }
        return "";
    }

    /* renamed from: j */
    public static byte[] m68628j(String str) {
        if (str == null) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            return new byte[0];
        }
        int i10 = length / 2;
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 != i10; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = (byte) C0241z.m1687e(str.substring(i12, i12 + 2), 16, 0);
        }
        return bArr;
    }

    /* renamed from: k */
    public static String m68629k(String str, String str2) throws C9721b, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Charset charset = StandardCharsets.UTF_8;
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(charset), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            return m68619a(mac.doFinal(str.getBytes(charset)));
        } catch (GeneralSecurityException e10) {
            AbstractC10896a.m65886e("Hash", "hMACSHA256 error." + e10.toString());
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "get file part hmcshare256 error." + e10.toString(), "getSequences");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x00c8, code lost:
    
        r16 = r2;
        r17 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00d3, code lost:
    
        if (r5.size() != r10) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00d5, code lost:
    
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00d9, code lost:
    
        p399jk.AbstractC10896a.m65888w(r17, r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00e1, code lost:
    
        r1 = r16;
        r2 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00ec, code lost:
    
        throw new fk.C9721b(com.huawei.hicloud.notification.constants.FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "read content error.", "getSequences");
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x00ed, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00ee, code lost:
    
        r13 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x00f0, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00f1, code lost:
    
        r1 = r16;
        r2 = r17;
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.LinkedHashMap<java.lang.String, java.lang.String> m68630l(java.io.File r26, long r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: mk.C11476b.m68630l(java.io.File, long):java.util.LinkedHashMap");
    }
}
