package com.huawei.location.lite.common.security;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.framework.common.StringUtils;
import es.C9544i;
import gu.C10048b;
import gu.C10049c;
import p235ds.InterfaceC9303d;

/* loaded from: classes8.dex */
public class OpensslSm4Security implements InterfaceC9303d {
    public static native byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static native byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    @Override // p235ds.InterfaceC9303d
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String mo38472a(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r7 = "libOpensslSm4Security.so"
            boolean r7 = es.C9544i.m59597f(r7)
            java.lang.String r0 = "OpensslSm4Security"
            java.lang.String r1 = ""
            if (r7 != 0) goto L12
            java.lang.String r7 = "load openssl sm4 plugin fail"
            as.C1016d.m6181a(r0, r7)
            return r1
        L12:
            boolean r7 = android.text.TextUtils.isEmpty(r8)
            if (r7 == 0) goto L1e
            java.lang.String r7 = "gcm decrypt param is not right"
            as.C1016d.m6183c(r0, r7)
            return r1
        L1e:
            boolean r7 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r2 = "gcm decrypt key is not right"
            if (r7 != 0) goto Lc2
            int r7 = r9.length()
            r3 = 32
            if (r7 == r3) goto L30
            goto Lc2
        L30:
            java.lang.String r7 = ":"
            java.lang.String[] r7 = r8.split(r7)
            int r8 = r7.length
            r4 = 2
            if (r8 >= r4) goto L3f
            as.C1016d.m6183c(r0, r2)
            goto Lc1
        L3f:
            r8 = 0
            r2 = r7[r8]
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 != 0) goto Lbe
            int r5 = r2.length()
            r6 = 24
            if (r5 == r6) goto L52
            goto Lbe
        L52:
            r5 = 1
            r7 = r7[r5]
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 != 0) goto Lbb
            int r5 = r7.length()
            if (r5 > r3) goto L62
            goto Lbb
        L62:
            int r5 = r7.length()
            int r5 = r5 - r3
            java.lang.String r8 = r7.substring(r8, r5)
            boolean r5 = android.text.TextUtils.isEmpty(r8)
            if (r5 != 0) goto Lb8
            int r5 = r8.length()
            int r5 = r5 % r4
            if (r5 == 0) goto L79
            goto Lb8
        L79:
            int r4 = r7.length()
            int r4 = r4 - r3
            java.lang.String r7 = r7.substring(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r7)
            if (r4 != 0) goto Lb8
            int r4 = r7.length()
            if (r4 == r3) goto L8f
            goto Lb8
        L8f:
            byte[] r8 = gu.C10049c.m62477b(r8)
            byte[] r9 = gu.C10049c.m62477b(r9)
            byte[] r2 = gu.C10049c.m62477b(r2)
            byte[] r7 = gu.C10049c.m62477b(r7)
            byte[] r7 = decrypt(r8, r9, r2, r7)
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = java.nio.charset.StandardCharsets.UTF_8
            r8.<init>(r7, r9)
            boolean r7 = android.text.TextUtils.isEmpty(r8)
            if (r7 == 0) goto Lb6
            java.lang.String r7 = "gcm decrypt result is not right"
        Lb2:
            as.C1016d.m6183c(r0, r7)
            goto Lc1
        Lb6:
            r1 = r8
            goto Lc1
        Lb8:
            java.lang.String r7 = "gcm decrypt tag is not right"
            goto Lb2
        Lbb:
            java.lang.String r7 = "gcm cipherAndTag length is not right"
            goto Lb2
        Lbe:
            java.lang.String r7 = "gcm decrypt iv is not right"
            goto Lb2
        Lc1:
            return r1
        Lc2:
            as.C1016d.m6183c(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.security.OpensslSm4Security.mo38472a(java.lang.String, java.lang.String):java.lang.String");
    }

    @Override // p235ds.InterfaceC9303d
    /* renamed from: b */
    public final String mo38473b(String str, String str2) {
        if (!C9544i.m59597f("libOpensslSm4Security.so")) {
            C1016d.m6181a("OpensslSm4Security", "load openssl sm4 plugin fail");
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            C1016d.m6183c("OpensslSm4Security", "gcm encrypt param is not right");
            return "";
        }
        if (TextUtils.isEmpty(str2) || str2.length() != 32) {
            C1016d.m6183c("OpensslSm4Security", "gcm encrypt key is not right");
            return "";
        }
        String strM62473e = C10048b.m62473e(12);
        if (TextUtils.isEmpty(strM62473e) || strM62473e.length() != 24) {
            C1016d.m6183c("OpensslSm4Security", "gcm encrypt iv is not right");
            return "";
        }
        String strM62476a = C10049c.m62476a(encrypt(StringUtils.getBytes(str), C10049c.m62477b(str2), C10049c.m62477b(strM62473e)));
        if (TextUtils.isEmpty(strM62476a) || strM62476a.length() <= 32) {
            C1016d.m6183c("OpensslSm4Security", "gcm encrypt result is not right");
            return "";
        }
        return strM62473e + ":" + strM62476a;
    }
}
