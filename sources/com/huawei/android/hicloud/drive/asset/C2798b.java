package com.huawei.android.hicloud.drive.asset;

import android.text.TextUtils;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.hicloud.base.slice.FileSliceInputStream;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.base.slice.SliceItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import fk.C9721b;
import ga.C9900c;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.DigestInputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p031b7.C1120a;
import p031b7.C1122c;
import p525ok.C11908a;
import p782xo.C13842a;

/* renamed from: com.huawei.android.hicloud.drive.asset.b */
/* loaded from: classes3.dex */
public class C2798b {

    /* renamed from: com.huawei.android.hicloud.drive.asset.b$a */
    public static class a {

        /* renamed from: a */
        public String f12201a;

        /* renamed from: b */
        public String f12202b;

        public a(String str, String str2) {
            this.f12201a = str;
            this.f12202b = str2;
        }

        /* renamed from: a */
        public String m16340a() {
            return this.f12202b;
        }

        /* renamed from: b */
        public String m16341b() {
            return this.f12201a;
        }
    }

    /* renamed from: a */
    public static void m16320a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                C1120a.m6678w("HashFile", "close error: " + e10);
            }
        }
    }

    /* renamed from: b */
    public static void m16321b(File file, File file2, long j10, byte[] bArr, byte[] bArr2) throws Throwable {
        RandomAccessFile randomAccessFile;
        byte[] bArr3 = new byte[1024000];
        FileInputStream fileInputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                C1120a.m6678w("HashFile", "decryptSliceFile mkdirs = " + parentFile.mkdirs());
            }
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    randomAccessFile.seek(j10);
                    Cipher cipherM61476d = C9900c.m61476d(2, bArr, bArr2);
                    while (true) {
                        int i10 = fileInputStream2.read(bArr3);
                        if (i10 == -1) {
                            break;
                        }
                        byte[] bArrUpdate = cipherM61476d.update(bArr3, 0, i10);
                        if (bArrUpdate != null) {
                            randomAccessFile.write(bArrUpdate);
                        }
                    }
                    byte[] bArrDoFinal = cipherM61476d.doFinal();
                    if (bArrDoFinal != null) {
                        randomAccessFile.write(bArrDoFinal);
                    }
                    m16320a(fileInputStream2);
                    m16320a(randomAccessFile);
                } catch (IOException | GeneralSecurityException e10) {
                    e = e10;
                    fileInputStream = fileInputStream2;
                    try {
                        throw new C9721b(4005, "decrypt slice file error: " + e.getMessage() + ", " + C1122c.m6758a0());
                    } catch (Throwable th2) {
                        th = th2;
                        m16320a(fileInputStream);
                        m16320a(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    m16320a(fileInputStream);
                    m16320a(randomAccessFile);
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
    public static Slice<File> m16322c(Slice<File> slice, byte[] bArr, byte[] bArr2, File file, String str) throws Throwable {
        ArrayList arrayList = new ArrayList();
        C1120a.m6677i("HashFile", "slice item size: " + slice.getSliceItems().size());
        long length = 0;
        int i10 = 0;
        for (SliceItem<File> sliceItem : slice.getSliceItems()) {
            i10++;
            File file2 = new File(file + "/" + m16334o(str, i10));
            if (file2.exists()) {
                C1120a.m6677i("HashFile", "desFile exits, delete = " + file2.delete());
            }
            m16323d(file2, sliceItem, bArr, bArr2);
            SliceItem sliceItem2 = new SliceItem(file2, sliceItem.getIndex(), 0L, file2.length());
            arrayList.add(sliceItem2);
            length += sliceItem2.getLength();
        }
        C4627a0.m28395h(slice.getLength() == length, "encrypt length invalid.");
        C1120a.m6678w("HashFile", "encrypt file slice end.");
        return new Slice<>(arrayList, length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.io.Closeable, java.io.FileOutputStream, java.io.OutputStream] */
    /* renamed from: d */
    public static void m16323d(File file, SliceItem<File> sliceItem, byte[] bArr, byte[] bArr2) throws Throwable {
        int i10;
        File object = sliceItem.getObject();
        long length = sliceItem.getLength();
        byte[] bArr3 = new byte[(int) (length > FileUtil.LOCAL_REPORT_FILE_MAX_SIZE ? 10240L : length)];
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                Cipher cipherM61476d = C9900c.m61476d(1, bArr, bArr2);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    C1120a.m6678w("HashFile", "encryptSliceFile mkdirs = " + parentFile.mkdirs());
                }
                bArr2 = new FileOutputStream(file);
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(object, "r");
                    try {
                        randomAccessFile2.seek(sliceItem.getOffset());
                        int i11 = 0;
                        while (i11 < length && (i10 = randomAccessFile2.read(bArr3)) != -1) {
                            i11 += i10;
                            byte[] bArrUpdate = cipherM61476d.update(bArr3, 0, i10);
                            C4627a0.m28392e(bArrUpdate, "cipher update buffer is null. ");
                            bArr2.write(bArrUpdate);
                            bArr2.flush();
                            long j10 = length - i11;
                            if (j10 > FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) {
                                j10 = 10240;
                            }
                            bArr3 = new byte[(int) j10];
                        }
                        byte[] bArrDoFinal = cipherM61476d.doFinal();
                        if (bArrDoFinal != null) {
                            bArr2.write(bArrDoFinal);
                            bArr2.flush();
                        }
                        m16320a(randomAccessFile2);
                        m16320a(bArr2);
                    } catch (IOException | GeneralSecurityException e10) {
                        e = e10;
                        if (e.getMessage().contains("ENOSPC")) {
                            throw new C9721b(PlayerConstants.ErrorCode.SWITCH_PLAYMODE_AUDIO_FAILED, "write error:" + e.getMessage(), "encrypt");
                        }
                        throw new C9721b(4004, "encrypt slice file error: " + e.getMessage(), "encrypt");
                    } catch (Throwable th2) {
                        randomAccessFile = randomAccessFile2;
                        th = th2;
                        m16320a(randomAccessFile);
                        m16320a(bArr2);
                        throw th;
                    }
                } catch (IOException | GeneralSecurityException e11) {
                    e = e11;
                }
            } catch (IOException | GeneralSecurityException e12) {
                e = e12;
            } catch (Throwable th3) {
                th = th3;
                bArr2 = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: e */
    public static String m16324e(String str, byte[] bArr) throws C9721b {
        try {
            return C9900c.m61475c(str, bArr, m16335p());
        } catch (IOException | GeneralSecurityException e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "fileEFEK error: " + e10.getMessage());
        }
    }

    /* renamed from: f */
    public static String m16325f(String str) throws C9721b {
        return C9900c.m61473a(m16338s(str));
    }

    /* renamed from: g */
    public static String m16326g(String str) {
        return C9900c.m61473a(m16339t(str));
    }

    /* renamed from: h */
    public static String m16327h(File file) {
        try {
            return m16328i(file);
        } catch (Exception e10) {
            C1120a.m6678w("HashFile", "getFileSHA256Default error = " + e10.getMessage());
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    public static String m16328i(File file) throws Throwable {
        DigestInputStream digestInputStream;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    try {
                        try {
                            digestInputStream = new DigestInputStream(fileInputStream2, MessageDigest.getInstance("SHA-256"));
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            byte[] bArr = new byte[8192];
                            for (int i10 = digestInputStream.read(bArr); i10 != -1; i10 = digestInputStream.read(bArr)) {
                            }
                            String strM61473a = C9900c.m61473a(digestInputStream.getMessageDigest().digest());
                            m16320a(digestInputStream);
                            m16320a(fileInputStream2);
                            return strM61473a;
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = digestInputStream;
                            m16320a(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = fileInputStream2;
                        m16320a(fileInputStream);
                        throw th;
                    }
                } catch (IOException | GeneralSecurityException e10) {
                    e = e10;
                    fileInputStream = fileInputStream2;
                    C1120a.m6678w("HashFile", "compute file hash error = " + e.getMessage());
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "compute file hash error: " + e.getMessage());
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (IOException | GeneralSecurityException e11) {
            e = e11;
        }
    }

    /* renamed from: j */
    public static String m16329j(File file) throws Throwable {
        String strM83034m = C13842a.m83010i().m83034m("hmacsha256_key_common_file");
        if (TextUtils.isEmpty(strM83034m)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "file key is empty");
        }
        byte[] bArrM61477e = C9900c.m61477e(strM83034m);
        FileInputStream fileInputStream = null;
        try {
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(new SecretKeySpec(bArrM61477e, mac.getAlgorithm()));
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
                    m16320a(fileInputStream2);
                    return string;
                } catch (IOException | GeneralSecurityException e10) {
                    e = e10;
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "get hmac file error: " + e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    m16320a(fileInputStream);
                    throw th;
                }
            } catch (IOException | GeneralSecurityException e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: k */
    public static String m16330k(List<File> list) throws Throwable {
        String strM83034m = C13842a.m83010i().m83034m("hmacsha256_key_common_file");
        if (TextUtils.isEmpty(strM83034m)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "file key is empty");
        }
        byte[] bArrM61477e = C9900c.m61477e(strM83034m);
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    Mac mac = Mac.getInstance("HmacSHA256");
                    mac.init(new SecretKeySpec(bArrM61477e, mac.getAlgorithm()));
                    Iterator<File> it = list.iterator();
                    while (it.hasNext()) {
                        FileInputStream fileInputStream2 = new FileInputStream(it.next());
                        try {
                            byte[] bArr = new byte[10240];
                            while (true) {
                                int i10 = fileInputStream2.read(bArr);
                                if (i10 <= 0) {
                                    break;
                                }
                                mac.update(bArr, 0, i10);
                            }
                            m16320a(fileInputStream2);
                            fileInputStream = fileInputStream2;
                        } catch (IOException | GeneralSecurityException e10) {
                            e = e10;
                            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "get hmac fileList error: " + e.getMessage());
                        } catch (Exception e11) {
                            e = e11;
                            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "get hmac fileList exception: " + e.getMessage());
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            m16320a(fileInputStream);
                            throw th;
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b10 : mac.doFinal()) {
                        sb2.append(String.format(Locale.ENGLISH, "%02x", Byte.valueOf(b10)));
                    }
                    String string = sb2.toString();
                    m16320a(fileInputStream);
                    return string;
                } catch (IOException | GeneralSecurityException e12) {
                    e = e12;
                }
            } catch (Exception e13) {
                e = e13;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: l */
    public static a m16331l(File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    a aVarM16332m = m16332m(fileInputStream2);
                    m16320a(fileInputStream2);
                    return aVarM16332m;
                } catch (IOException | GeneralSecurityException e10) {
                    e = e10;
                    fileInputStream = fileInputStream2;
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "compute file hash error: " + e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    m16320a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException | GeneralSecurityException e11) {
            e = e11;
        }
    }

    /* renamed from: m */
    public static a m16332m(InputStream inputStream) throws Throwable {
        DigestInputStream digestInputStream;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        DigestInputStream digestInputStream2 = null;
        try {
            digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance("SHA-256"));
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int i10 = digestInputStream.read(bArr);
                if (i10 == -1) {
                    a aVar = new a(C9900c.m61473a(messageDigest.digest()), C9900c.m61473a(digestInputStream.getMessageDigest().digest()));
                    m16320a(digestInputStream);
                    return aVar;
                }
                messageDigest.update(bArr, 0, i10);
            }
        } catch (Throwable th3) {
            th = th3;
            digestInputStream2 = digestInputStream;
            m16320a(digestInputStream2);
            throw th;
        }
    }

    /* renamed from: n */
    public static a m16333n(List<SliceItem<File>> list) throws C9721b {
        FileSliceInputStream fileSliceInputStream = null;
        try {
            try {
                FileSliceInputStream fileSliceInputStream2 = new FileSliceInputStream(list);
                try {
                    a aVarM16332m = m16332m(fileSliceInputStream2);
                    m16320a(fileSliceInputStream2);
                    return aVarM16332m;
                } catch (IOException | GeneralSecurityException e10) {
                    e = e10;
                    fileSliceInputStream = fileSliceInputStream2;
                    throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "compute file slice hash error: " + e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    fileSliceInputStream = fileSliceInputStream2;
                    m16320a(fileSliceInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException | GeneralSecurityException e11) {
            e = e11;
        }
    }

    /* renamed from: o */
    public static String m16334o(String str, int i10) {
        if (i10 == 1) {
            return str;
        }
        if (i10 != 2) {
            return UUID.randomUUID().toString();
        }
        return str + "_largethumbnail";
    }

    /* renamed from: p */
    public static byte[] m16335p() throws NoSuchAlgorithmException {
        return C11908a.m71443b(16);
    }

    /* renamed from: q */
    public static String m16336q(List<File> list) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    Iterator<File> it = list.iterator();
                    while (it.hasNext()) {
                        FileInputStream fileInputStream2 = new FileInputStream(it.next());
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int i10 = fileInputStream2.read(bArr);
                                if (i10 == -1) {
                                    break;
                                }
                                messageDigest.update(bArr, 0, i10);
                            }
                            m16320a(fileInputStream2);
                            fileInputStream = fileInputStream2;
                        } catch (IOException | GeneralSecurityException e10) {
                            e = e10;
                            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "get sha256 fileList error: " + e.getMessage());
                        } catch (Exception e11) {
                            e = e11;
                            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "get sha256 fileList exception: " + e.getMessage());
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            m16320a(fileInputStream);
                            throw th;
                        }
                    }
                    String strM61473a = C9900c.m61473a(messageDigest.digest());
                    m16320a(fileInputStream);
                    return strM61473a;
                } catch (IOException | GeneralSecurityException e12) {
                    e = e12;
                }
            } catch (Exception e13) {
                e = e13;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: r */
    public static String m16337r(String str) throws C9721b {
        String strM83034m = C13842a.m83010i().m83034m("hmacsha256_key_common_string");
        if (TextUtils.isEmpty(strM83034m)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "string key is empty");
        }
        try {
            return C9900c.m61478f(str, strM83034m);
        } catch (IOException | GeneralSecurityException e10) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, "fileEFEK error: " + e10.getMessage());
        }
    }

    /* renamed from: s */
    public static byte[] m16338s(String str) {
        if (str == null) {
            return null;
        }
        return C9900c.m61477e(str.substring(0, str.length() / 2));
    }

    /* renamed from: t */
    public static byte[] m16339t(String str) {
        if (str == null) {
            return null;
        }
        return C9900c.m61477e(str.substring(str.length() / 2));
    }
}
