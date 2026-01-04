package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.openalliance.ad.utils.cu */
/* loaded from: classes2.dex */
public abstract class AbstractC7801cu {
    /* renamed from: a */
    public static String m48124a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null || !AbstractC7731ae.m47464d(file)) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException unused) {
            fileInputStream = null;
        } catch (IOException unused2) {
            fileInputStream = null;
        } catch (NoSuchAlgorithmException unused3) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            AbstractC7805cy.m48142a((Closeable) fileInputStream2);
            throw th;
        }
        try {
            try {
                String strM48125a = m48125a(fileInputStream);
                AbstractC7805cy.m48142a((Closeable) fileInputStream);
                return strM48125a;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                AbstractC7805cy.m48142a((Closeable) fileInputStream2);
                throw th;
            }
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused4) {
            AbstractC7185ho.m43823c("Sha256Util", "fail to get file sha256");
            AbstractC7805cy.m48142a((Closeable) fileInputStream);
            return null;
        }
    }

    /* renamed from: a */
    private static String m48125a(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bArr = new byte[8192];
        boolean z10 = false;
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 <= 0) {
                break;
            }
            messageDigest.update(bArr, 0, i10);
            z10 = true;
        }
        if (z10) {
            return AbstractC7740an.m47531a(messageDigest.digest());
        }
        return null;
    }

    /* renamed from: a */
    public static String m48126a(String str) {
        if (AbstractC7806cz.m48165b(str)) {
            return "";
        }
        try {
            return AbstractC7740an.m47531a(m48127a(str.getBytes(Constants.UTF_8)));
        } catch (UnsupportedEncodingException unused) {
            AbstractC7185ho.m43823c("Sha256Util", "digest UnsupportedEncodingException");
            return "";
        }
    }

    /* renamed from: a */
    public static byte[] m48127a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            AbstractC7185ho.m43826d("Sha256Util", "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
