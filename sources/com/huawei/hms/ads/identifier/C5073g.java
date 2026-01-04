package com.huawei.hms.ads.identifier;

/* renamed from: com.huawei.hms.ads.identifier.g */
/* loaded from: classes8.dex */
public class C5073g {
    /* renamed from: a */
    public static String m30268a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }
}
