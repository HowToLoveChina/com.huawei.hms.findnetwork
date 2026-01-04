package com.huawei.fastengine.fastview.download.download;

import com.huawei.fastengine.fastview.download.utils.IoUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes5.dex */
public class HashUtils {
    private static final int BUFF_SIZE = 4096;
    private static final String TAG = "HashUtils";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public static byte[] digestSha2(File file) throws Throwable {
        MessageDigest messageDigest;
        BufferedInputStream bufferedInputStream;
        ?? r12;
        BufferedInputStream bufferedInputStream2 = null;
        BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[4096];
                    r12 = 0;
                    while (true) {
                        int i10 = bufferedInputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i10);
                        r12 += i10;
                    }
                } catch (IOException | NoSuchAlgorithmException unused) {
                    bufferedInputStream3 = bufferedInputStream;
                    FastViewLogUtils.m28724e(TAG, "An exception occurred while computing file 'SHA-256'.");
                    IoUtils.closeStream(bufferedInputStream3);
                    bufferedInputStream2 = bufferedInputStream3;
                    return new byte[0];
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    IoUtils.closeStream(bufferedInputStream2);
                    throw th;
                }
            } catch (IOException | NoSuchAlgorithmException unused2) {
            }
            if (r12 > 0) {
                byte[] bArrDigest = messageDigest.digest();
                IoUtils.closeStream(bufferedInputStream);
                return bArrDigest;
            }
            IoUtils.closeStream(bufferedInputStream);
            bufferedInputStream2 = r12;
            return new byte[0];
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
