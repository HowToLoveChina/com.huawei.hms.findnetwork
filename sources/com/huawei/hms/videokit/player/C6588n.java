package com.huawei.hms.videokit.player;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.hms.videokit.player.n */
/* loaded from: classes8.dex */
public final class C6588n {

    /* renamed from: a */
    private static final C6588n f30643a = new C6588n();

    private C6588n() {
    }

    /* renamed from: a */
    public static C6588n m37563a() {
        return f30643a;
    }

    /* renamed from: a */
    public String m37564a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String str2;
        if (C6600t0.m37680b(str)) {
            return str;
        }
        try {
            byte[] bytes = str.getBytes(Constants.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bytes);
            return new String(new C6586m().m37561a(messageDigest.digest()), Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            str2 = "Error in generate SHA256 UnsupportedEncodingException";
            C6550c1.m37262b("SHA256Encrypter", str2);
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            str2 = "Error in generate SHA256 NoSuchAlgorithmException";
            C6550c1.m37262b("SHA256Encrypter", str2);
            return null;
        }
    }
}
