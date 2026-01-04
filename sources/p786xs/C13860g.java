package p786xs;

/* renamed from: xs.g */
/* loaded from: classes8.dex */
public final class C13860g {

    /* renamed from: a */
    public static final char[] f62144a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Removed duplicated region for block: B:39:0x0087  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m83182a(java.lang.String r9, java.lang.String r10) throws java.io.IOException {
        /*
            java.lang.String r9 = p786xs.C13859f.m83176c(r9)
            java.io.File r0 = new java.io.File
            r0.<init>(r9)
            java.lang.String r9 = "UTF-8"
            java.nio.charset.Charset r9 = java.nio.charset.Charset.forName(r9)
            byte[] r9 = r10.getBytes(r9)
            java.lang.String r10 = "SHA-256"
            boolean r1 = r0.exists()
            java.lang.String r2 = "dC"
            r3 = 0
            r4 = 0
            if (r1 != 0) goto L26
            java.lang.String r9 = "file not exist"
        L21:
            as.C1016d.m6183c(r2, r9)
            goto L84
        L26:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.io.IOException -> L7b java.io.FileNotFoundException -> L7e java.security.NoSuchAlgorithmException -> L81
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.io.IOException -> L7b java.io.FileNotFoundException -> L7e java.security.NoSuchAlgorithmException -> L81
            r5.<init>(r0)     // Catch: java.io.IOException -> L7b java.io.FileNotFoundException -> L7e java.security.NoSuchAlgorithmException -> L81
            r1.<init>(r5)     // Catch: java.io.IOException -> L7b java.io.FileNotFoundException -> L7e java.security.NoSuchAlgorithmException -> L81
            java.security.MessageDigest r10 = java.security.MessageDigest.getInstance(r10)     // Catch: java.lang.Throwable -> L49
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r5 = new byte[r0]     // Catch: java.lang.Throwable -> L49
            int r6 = r1.read(r5)     // Catch: java.lang.Throwable -> L49
            r7 = r3
        L3d:
            r8 = -1
            if (r6 == r8) goto L4b
            r10.update(r5, r3, r6)     // Catch: java.lang.Throwable -> L49
            int r7 = r7 + r6
            int r6 = r1.read(r5)     // Catch: java.lang.Throwable -> L49
            goto L3d
        L49:
            r9 = move-exception
            goto L72
        L4b:
            if (r7 <= 0) goto L6e
            if (r9 == 0) goto L66
            int r5 = r9.length     // Catch: java.lang.Throwable -> L49
            if (r5 <= 0) goto L66
            r5 = r3
        L53:
            int r6 = r9.length     // Catch: java.lang.Throwable -> L49
            if (r5 >= r6) goto L66
            int r6 = r5 + 8192
            int r7 = r9.length     // Catch: java.lang.Throwable -> L49
            if (r6 > r7) goto L5f
            r10.update(r9, r5, r0)     // Catch: java.lang.Throwable -> L49
            goto L64
        L5f:
            int r7 = r9.length     // Catch: java.lang.Throwable -> L49
            int r7 = r7 - r5
            r10.update(r9, r5, r7)     // Catch: java.lang.Throwable -> L49
        L64:
            r5 = r6
            goto L53
        L66:
            byte[] r9 = r10.digest()     // Catch: java.lang.Throwable -> L49
            r1.close()     // Catch: java.io.IOException -> L7b java.io.FileNotFoundException -> L7e java.security.NoSuchAlgorithmException -> L81
            goto L85
        L6e:
            r1.close()     // Catch: java.io.IOException -> L7b java.io.FileNotFoundException -> L7e java.security.NoSuchAlgorithmException -> L81
            goto L84
        L72:
            r1.close()     // Catch: java.lang.Throwable -> L76
            goto L7a
        L76:
            r10 = move-exception
            r9.addSuppressed(r10)     // Catch: java.io.IOException -> L7b java.io.FileNotFoundException -> L7e java.security.NoSuchAlgorithmException -> L81
        L7a:
            throw r9     // Catch: java.io.IOException -> L7b java.io.FileNotFoundException -> L7e java.security.NoSuchAlgorithmException -> L81
        L7b:
            java.lang.String r9 = "IOException."
            goto L21
        L7e:
            java.lang.String r9 = "FileNotFoundException."
            goto L21
        L81:
            java.lang.String r9 = "NoSuchAlgorithmException."
            goto L21
        L84:
            r9 = r4
        L85:
            if (r9 == 0) goto Lb1
            int r10 = r9.length
            if (r10 <= 0) goto Lb1
            java.lang.String r10 = new java.lang.String
            int r0 = r9.length
            int r1 = r0 << 1
            char[] r1 = new char[r1]
            r2 = r3
        L92:
            if (r3 >= r0) goto Lad
            int r4 = r2 + 1
            char[] r5 = p786xs.C13860g.f62144a
            r6 = r9[r3]
            r7 = r6 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >>> 4
            char r7 = r5[r7]
            r1[r2] = r7
            int r2 = r2 + 2
            r6 = r6 & 15
            char r5 = r5[r6]
            r1[r4] = r5
            int r3 = r3 + 1
            goto L92
        Lad:
            r10.<init>(r1)
            return r10
        Lb1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p786xs.C13860g.m83182a(java.lang.String, java.lang.String):java.lang.String");
    }
}
