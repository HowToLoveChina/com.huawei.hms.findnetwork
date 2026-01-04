package p248e5;

import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import ly.C11376j;

/* renamed from: e5.c */
/* loaded from: classes.dex */
public class C9410c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* renamed from: a */
    public static String m59029a(String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        ?? r12 = 0;
        if (str == null || str2 == null) {
            C2111d.m12648d("HMACHash", "[hmac] key or filePath is null");
            return null;
        }
        File file = new File(str2);
        if (!file.exists() || !file.isFile()) {
            C2111d.m12648d("HMACHash", "[hmac] file not exists or not file");
            return null;
        }
        byte[] bArr = new byte[8192];
        try {
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(new SecretKeySpec(str.getBytes(Constants.UTF_8), "HmacSHA256"));
                fileInputStream = new FileInputStream(str2);
                while (true) {
                    try {
                        int i10 = fileInputStream.read(bArr, 0, 8192);
                        if (i10 == -1) {
                            String strM59031b = C9411d.m59031b(mac.doFinal());
                            C11376j.m68227a(fileInputStream);
                            return strM59031b;
                        }
                        mac.update(bArr, 0, i10);
                    } catch (FileNotFoundException unused) {
                        C2111d.m12648d("HMACHash", "[hmacSHA256_file] FileNotFoundException.");
                        C11376j.m68227a(fileInputStream);
                        return null;
                    } catch (UnsupportedEncodingException unused2) {
                        C2111d.m12648d("HMACHash", "[hmacSHA256_file] UnsupportedEncodingException.");
                        C11376j.m68227a(fileInputStream);
                        return null;
                    } catch (IOException unused3) {
                        C2111d.m12648d("HMACHash", "[hmacSHA256_file] IOException.");
                        C11376j.m68227a(fileInputStream);
                        return null;
                    } catch (IllegalStateException unused4) {
                        C2111d.m12648d("HMACHash", "[hmacSHA256_file] IllegalStateException.");
                        C11376j.m68227a(fileInputStream);
                        return null;
                    } catch (InvalidKeyException unused5) {
                        C2111d.m12648d("HMACHash", "[hmacSHA256_file] InvalidKeyException.");
                        C11376j.m68227a(fileInputStream);
                        return null;
                    } catch (NoSuchAlgorithmException unused6) {
                        C2111d.m12648d("HMACHash", "[hmacSHA256_file] NoSuchAlgorithmException.");
                        C11376j.m68227a(fileInputStream);
                        return null;
                    }
                }
            } catch (FileNotFoundException unused7) {
                fileInputStream = null;
            } catch (UnsupportedEncodingException unused8) {
                fileInputStream = null;
            } catch (IOException unused9) {
                fileInputStream = null;
            } catch (IllegalStateException unused10) {
                fileInputStream = null;
            } catch (InvalidKeyException unused11) {
                fileInputStream = null;
            } catch (NoSuchAlgorithmException unused12) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                C11376j.m68227a(r12);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            r12 = str;
            C11376j.m68227a(r12);
            throw th;
        }
    }
}
