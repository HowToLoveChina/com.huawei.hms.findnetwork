package com.baidu.location;

import com.baidu.location.p065a.C1534f;
import com.baidu.p061a.p062a.p063a.Base64Lib;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class Jni {

    /* renamed from: a */
    private static int f6555a = 1024;

    /* renamed from: b */
    private static boolean f6556b = false;

    static {
        try {
            System.loadLibrary("locSDK6c");
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            f6556b = true;
            throw new IllegalStateException("no found the liblocSDK6c.so file, please correct settings");
        }
    }

    public static String Encrypt(String str) {
        if (f6556b) {
            return null;
        }
        try {
            return URLEncoder.encode(m8674a(encrypt(str.getBytes())), Constants.UTF_8);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static String m8674a(byte[] bArr) {
        try {
            return Base64Lib.Base64Encode(bArr, Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static native String m8675a(byte[] bArr, int i10);

    /* renamed from: c */
    private static native String m8676c(byte[] bArr, int i10);

    public static String en1(String str) {
        if (f6556b) {
            return "err!";
        }
        if (str == null) {
            return "null";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[f6555a];
        int length = bytes.length;
        if (length > 740) {
            length = 740;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            byte b10 = bytes[i11];
            if (b10 != 0) {
                bArr[i10] = b10;
                i10++;
            } else {
                C1534f.m8725c("\\0 found in string");
            }
        }
        C1534f.m8725c("number:" + bytes.length);
        return m8675a(bArr, 132456);
    }

    public static String encode(String str) {
        if (f6556b) {
            return "err!";
        }
        return en1(str) + "|tp=3";
    }

    public static String encode2(String str) {
        return f6556b ? "err!" : str == null ? "null" : m8676c(str.getBytes(), 132456);
    }

    public static long encode3(String str) {
        String str2;
        try {
            str2 = new String(str.getBytes(), Constants.UTF_8);
        } catch (Exception unused) {
            str2 = "";
        }
        return murmur(str2);
    }

    private static native String encodeNotLimit(String str, int i10);

    public static String encodeOfflineLocationUpdateRequest(String str) {
        String str2;
        if (f6556b) {
            return "err!";
        }
        try {
            str2 = new String(str.getBytes(), Constants.UTF_8);
        } catch (Exception unused) {
            str2 = "";
        }
        return encodeNotLimit(str2, 132456) + "|tp=3";
    }

    private static native byte[] encrypt(byte[] bArr);

    private static native long murmur(String str);
}
