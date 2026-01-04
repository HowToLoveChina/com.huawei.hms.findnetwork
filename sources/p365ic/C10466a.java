package p365ic;

import android.text.TextUtils;
import com.huawei.android.hicloud.security.bean.DataDecryptReq;
import com.huawei.android.hicloud.security.bean.DataEncryptReq;
import com.huawei.android.hicloud.security.bean.EncryptedData;
import com.huawei.android.hicloud.security.bean.SliceDecryptReq;
import com.huawei.android.hicloud.security.bean.SliceEncryptReq;
import com.huawei.android.hicloud.security.bean.Unique;
import com.huawei.android.hicloud.security.bean.UniqueReq;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.hms.utils.FileUtil;
import fk.C9720a;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mk.C11476b;
import p514o9.C11839m;
import p525ok.C11908a;
import p782xo.C13842a;

/* renamed from: ic.a */
/* loaded from: classes3.dex */
public class C10466a {
    /* renamed from: a */
    public static String m64310a(byte[] bArr) {
        return C11476b.m68619a(bArr);
    }

    /* renamed from: b */
    public static String m64311b(String str, byte[] bArr) throws C9721b {
        try {
            return new String(m64326q(2, bArr, m64329t(str.substring(0, 32))).doFinal(m64329t(str.substring(32))), StandardCharsets.UTF_8);
        } catch (Exception e10) {
            throw new C9721b(4005, "decryptData error:" + e10.toString());
        }
    }

    /* renamed from: c */
    public static String m64312c(String str, byte[] bArr, byte[] bArr2) throws C9721b {
        try {
            return m64310a(m64326q(2, bArr, bArr2).doFinal(m64329t(str)));
        } catch (Exception e10) {
            throw new C9721b(4005, "decryptData error:" + e10.toString());
        }
    }

    /* renamed from: d */
    public static byte[] m64313d(byte[] bArr, int i10, String str) throws C9721b {
        return m64329t(m64311b(m64310a(bArr), UserKeyUtils.getInstance().getSyncUser(i10, str).getUserKey()));
    }

    /* renamed from: e */
    public static void m64314e(SliceDecryptReq sliceDecryptReq) throws Throwable {
        m64315f(C10278a.m63442h(sliceDecryptReq.getSrcFile()), C10278a.m63442h(sliceDecryptReq.getDesFile()), sliceDecryptReq.getOffset(), m64313d(m64329t(sliceDecryptReq.getEfek()), sliceDecryptReq.getType(), sliceDecryptReq.getTraceID()), m64329t(sliceDecryptReq.getIv()));
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m64315f(java.io.File r9, java.io.File r10, long r11, byte[] r13, byte[] r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p365ic.C10466a.m64315f(java.io.File, java.io.File, long, byte[], byte[]):void");
    }

    /* renamed from: g */
    public static String m64316g(DataDecryptReq dataDecryptReq) throws C9721b {
        C9720a.m60653b(dataDecryptReq.getSrcData(), "source is invalid.");
        C9720a.m60653b(dataDecryptReq.getEdek(), "edek is invalid.");
        return m64311b(dataDecryptReq.getSrcData(), m64313d(m64329t(dataDecryptReq.getEdek()), dataDecryptReq.getType(), dataDecryptReq.getTraceID()));
    }

    /* renamed from: h */
    public static String m64317h(UserKeyObject userKeyObject, DataDecryptReq dataDecryptReq) throws C9721b {
        C9720a.m60653b(dataDecryptReq.getSrcData(), "source is invalid.");
        C9720a.m60653b(dataDecryptReq.getEdek(), "edek is invalid.");
        return m64311b(dataDecryptReq.getSrcData(), m64329t(m64311b(dataDecryptReq.getEdek(), userKeyObject.getUserKey())));
    }

    /* renamed from: i */
    public static String m64318i(String str, byte[] bArr, byte[] bArr2) throws BadPaddingException, IllegalBlockSizeException, C9721b {
        try {
            return m64310a(bArr2) + m64310a(m64326q(1, bArr, bArr2).doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e10) {
            throw new C9721b(4004, "encryptData error:" + e10.toString());
        }
    }

    /* renamed from: j */
    public static String m64319j(String str, int i10, String str2) throws C9721b {
        return m64318i(str, UserKeyUtils.getInstance().getSyncUser(i10, str2).getUserKey(), m64328s());
    }

    /* renamed from: k */
    public static void m64320k(SliceEncryptReq sliceEncryptReq) throws Throwable {
        C9720a.m60653b(sliceEncryptReq.getSrcFile(), "source file is invalid.");
        C9720a.m60653b(sliceEncryptReq.getDesFile(), "destination file is invalid.");
        C9720a.m60653b(sliceEncryptReq.getEfek(), "file efek is invalid.");
        C9720a.m60653b(sliceEncryptReq.getIv(), "file iv is invalid.");
        byte[] bArrM64313d = m64313d(m64329t(sliceEncryptReq.getEfek()), sliceEncryptReq.getType(), sliceEncryptReq.getTraceID());
        byte[] bArrM64329t = m64329t(sliceEncryptReq.getIv());
        m64321l(C10278a.m63442h(sliceEncryptReq.getSrcFile()), sliceEncryptReq.getStart(), sliceEncryptReq.getLength(), C10278a.m63442h(sliceEncryptReq.getDesFile()), bArrM64313d, bArrM64329t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m64321l(java.io.File r15, long r16, long r18, java.io.File r20, byte[] r21, byte[] r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p365ic.C10466a.m64321l(java.io.File, long, long, java.io.File, byte[], byte[]):void");
    }

    /* renamed from: m */
    public static void m64322m(FileInputStream fileInputStream, long j10, long j11, File file, byte[] bArr, byte[] bArr2) throws C9721b, IOException {
        int i10;
        byte[] bArr3 = new byte[(int) Math.min(j11, FileUtil.LOCAL_REPORT_FILE_MAX_SIZE)];
        FileOutputStream fileOutputStream = null;
        try {
            try {
                Cipher cipherM64326q = m64326q(1, bArr, bArr2);
                File fileM63437c = C10278a.m63437c(file);
                if (fileM63437c != null && !fileM63437c.exists()) {
                    C11839m.m70689w("SecurityUtils", "encryptSliceFileStream mkdirs = " + fileM63437c.mkdirs());
                }
                FileOutputStream fileOutputStreamM63445k = C10278a.m63445k(file);
                m64325p(fileInputStream, j10);
                int i11 = 0;
                while (i11 < j11 && (i10 = fileInputStream.read(bArr3)) != -1) {
                    i11 += i10;
                    byte[] bArrUpdate = cipherM64326q.update(bArr3, 0, i10);
                    if (bArrUpdate == null) {
                        throw new C9721b(4004, "bytes is null. ");
                    }
                    fileOutputStreamM63445k.write(bArrUpdate);
                    fileOutputStreamM63445k.flush();
                    bArr3 = new byte[(int) Math.min(j11 - i11, FileUtil.LOCAL_REPORT_FILE_MAX_SIZE)];
                }
                byte[] bArrDoFinal = cipherM64326q.doFinal();
                if (bArrDoFinal != null) {
                    fileOutputStreamM63445k.write(bArrDoFinal);
                    fileOutputStreamM63445k.flush();
                }
                if (fileOutputStreamM63445k != null) {
                    try {
                        fileOutputStreamM63445k.close();
                    } catch (IOException e10) {
                        C11839m.m70687e("SecurityUtils", "encrypt file close out error:" + e10.toString());
                    }
                }
            } catch (Exception e11) {
                throw new C9721b(4004, "encrypt slice error. " + e11.getMessage(), "encryptSliceFile");
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            try {
                fileOutputStream.close();
                throw th2;
            } catch (IOException e12) {
                C11839m.m70687e("SecurityUtils", "encrypt file close out error:" + e12.toString());
                throw th2;
            }
        }
    }

    /* renamed from: n */
    public static EncryptedData m64323n(DataEncryptReq dataEncryptReq) throws C9721b {
        C9720a.m60653b(dataEncryptReq.getSrcData(), "source is invalid.");
        return m64324o(UserKeyUtils.getInstance().getSyncUser(dataEncryptReq.getType(), dataEncryptReq.getTraceID()), dataEncryptReq);
    }

    /* renamed from: o */
    public static EncryptedData m64324o(UserKeyObject userKeyObject, DataEncryptReq dataEncryptReq) throws C9721b {
        C9720a.m60653b(dataEncryptReq.getSrcData(), "source is invalid.");
        byte[] bArrM64328s = dataEncryptReq.getDek() == null ? m64328s() : m64329t(dataEncryptReq.getDek());
        byte[] bArrM64328s2 = m64328s();
        EncryptedData encryptedData = new EncryptedData();
        encryptedData.setData(m64318i(dataEncryptReq.getSrcData(), bArrM64328s, bArrM64328s2));
        encryptedData.setEdek(m64318i(m64310a(bArrM64328s), userKeyObject.getUserKey(), bArrM64328s2));
        encryptedData.setKeyGuid(userKeyObject.getUserKeyGuid());
        return encryptedData;
    }

    /* renamed from: p */
    public static void m64325p(FileInputStream fileInputStream, long j10) throws IOException {
        if (fileInputStream == null) {
            C11839m.m70689w("SecurityUtils", "fileInputStreamSeekTo input is null.");
        } else {
            if (j10 <= 0) {
                return;
            }
            fileInputStream.skip(j10);
        }
    }

    /* renamed from: q */
    public static Cipher m64326q(int i10, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i10, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher;
    }

    /* renamed from: r */
    public static Unique m64327r(UniqueReq uniqueReq) throws C9721b {
        Unique unique = new Unique();
        String strM64331v = m64331v(uniqueReq.getFile());
        StringBuilder sb2 = new StringBuilder(strM64331v);
        sb2.append(uniqueReq.getLength() > 0 ? Long.valueOf(uniqueReq.getLength()) : "");
        unique.setHmac(m64330u(sb2.toString()));
        UserKeyObject syncUser = UserKeyUtils.getInstance().getSyncUser(uniqueReq.getKeyType(), uniqueReq.getTraceID());
        unique.setEfek(m64318i(m64310a(m64333x(strM64331v)), syncUser.getUserKey(), m64328s()));
        unique.setIv(m64310a(m64334y(strM64331v)));
        unique.setKeyGuid(syncUser.getUserKeyGuid());
        return unique;
    }

    /* renamed from: s */
    public static byte[] m64328s() throws C9721b {
        try {
            return C11908a.m71443b(16);
        } catch (NoSuchAlgorithmException e10) {
            throw new C9721b(4001, "generateTempKey Fail." + e10.toString());
        }
    }

    /* renamed from: t */
    public static byte[] m64329t(String str) {
        return C11476b.m68628j(str);
    }

    /* renamed from: u */
    public static String m64330u(String str) throws C9721b, NoSuchAlgorithmException, InvalidKeyException {
        String strM83034m = C13842a.m83010i().m83034m("hmacsha256_key_common_string");
        if (TextUtils.isEmpty(strM83034m)) {
            throw new C9721b(4004, "string key is empty");
        }
        byte[] bArrM64329t = m64329t(strM83034m);
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(bArrM64329t, mac.getAlgorithm()));
            return m64310a(mac.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (GeneralSecurityException e10) {
            throw new C9721b(4004, "sha256EncryptFEK error:" + e10.toString());
        }
    }

    /* renamed from: v */
    public static String m64331v(File file) throws C9721b {
        try {
            return m64332w(new FileInputStream(file));
        } catch (IOException e10) {
            throw new C9721b(4004, "sha256EncryptFile error:" + e10.toString());
        }
    }

    /* renamed from: w */
    public static String m64332w(FileInputStream fileInputStream) throws C9721b, IOException {
        if (fileInputStream == null) {
            throw new C9721b(4004, "inputStream is empty");
        }
        String strM83034m = C13842a.m83010i().m83034m("hmacsha256_key_common_file");
        if (TextUtils.isEmpty(strM83034m)) {
            throw new C9721b(4004, "file key is empty");
        }
        byte[] bArrM64329t = m64329t(strM83034m);
        try {
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(new SecretKeySpec(bArrM64329t, mac.getAlgorithm()));
                byte[] bArr = new byte[10240];
                while (true) {
                    int i10 = fileInputStream.read(bArr);
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
                try {
                    fileInputStream.close();
                } catch (IOException e10) {
                    C11839m.m70687e("SecurityUtils", "hmac-sha-256 error:" + e10.toString());
                }
                return string;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (IOException e11) {
                    C11839m.m70687e("SecurityUtils", "hmac-sha-256 error:" + e11.toString());
                }
                throw th2;
            }
        } catch (IOException | GeneralSecurityException e12) {
            throw new C9721b(4004, "sha256EncryptFile error:" + e12.toString());
        }
    }

    /* renamed from: x */
    public static byte[] m64333x(String str) {
        if (str == null) {
            return null;
        }
        return m64329t(str.substring(0, str.length() / 2));
    }

    /* renamed from: y */
    public static byte[] m64334y(String str) {
        if (str == null) {
            return null;
        }
        return m64329t(str.substring(str.length() / 2));
    }
}
