package com.huawei.hms.framework.network.grs.p125h;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.framework.network.grs.h.b */
/* loaded from: classes8.dex */
public class C5456b {

    /* renamed from: a */
    private static final String f25001a = "b";

    /* renamed from: b */
    private static final Pattern f25002b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: a */
    public static String m32323a(String str) {
        return m32324a(str, "SHA-256");
    }

    /* renamed from: b */
    public static String m32326b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i10 = 1;
        if (str.length() == 1) {
            return "*";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < str.length(); i11++) {
            String str2 = str.charAt(i11) + "";
            if (f25002b.matcher(str2).matches()) {
                if (i10 % 2 == 0) {
                    str2 = "*";
                }
                i10++;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static String m32324a(String str, String str2) throws UnsupportedEncodingException {
        String str3;
        String str4;
        try {
        } catch (UnsupportedEncodingException unused) {
            str3 = f25001a;
            str4 = "encrypt UnsupportedEncodingException";
        }
        try {
            return m32325a(MessageDigest.getInstance(str2).digest(str.getBytes(Constants.UTF_8)));
        } catch (NoSuchAlgorithmException unused2) {
            str3 = f25001a;
            str4 = "encrypt NoSuchAlgorithmException";
            Logger.m32145w(str3, str4);
            return null;
        }
    }

    /* renamed from: a */
    private static String m32325a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append("0");
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }
}
