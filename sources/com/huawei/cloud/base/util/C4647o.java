package com.huawei.cloud.base.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* renamed from: com.huawei.cloud.base.util.o */
/* loaded from: classes.dex */
public class C4647o {

    /* renamed from: a */
    public static final C4650r f21332a = C4650r.m28485f("IOUtils");

    /* renamed from: a */
    public static long m28474a(InterfaceC4631c0 interfaceC4631c0) throws IOException {
        C4632d c4632d = new C4632d();
        try {
            interfaceC4631c0.mo28157a(c4632d);
            c4632d.close();
            return c4632d.f21265a;
        } catch (Throwable th2) {
            c4632d.close();
            throw th2;
        }
    }

    /* renamed from: b */
    public static void m28475b(InputStream inputStream, OutputStream outputStream) throws IOException {
        m28476c(inputStream, outputStream, true);
    }

    /* renamed from: c */
    public static void m28476c(InputStream inputStream, OutputStream outputStream, boolean z10) throws IOException {
        try {
            C4634e.m28406a(inputStream, outputStream);
        } finally {
            if (z10) {
                inputStream.close();
            }
        }
    }

    /* renamed from: d */
    public static <S extends Serializable> S m28477d(InputStream inputStream) throws IOException {
        try {
            try {
                return (S) new ObjectInputStream(inputStream).readObject();
            } catch (ClassNotFoundException e10) {
                IOException iOException = new IOException("Failed to deserialize object");
                iOException.initCause(e10);
                throw iOException;
            }
        } finally {
            inputStream.close();
        }
    }

    /* renamed from: e */
    public static <S extends Serializable> S m28478e(byte[] bArr) throws IOException {
        if (bArr == null) {
            return null;
        }
        return (S) m28477d(new ByteArrayInputStream(bArr));
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0077  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m28479f(java.io.File r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.String r1 = "java.nio.file.Files"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.NoSuchMethodException -> L33 java.lang.IllegalAccessException -> L35 java.lang.SecurityException -> L37 java.lang.IllegalArgumentException -> L39 java.lang.ClassNotFoundException -> L3b java.lang.reflect.InvocationTargetException -> L3d
            java.lang.Class<java.nio.file.Path> r2 = java.nio.file.Path.class
            java.lang.Class<java.io.File> r3 = java.io.File.class
            java.lang.String r4 = "toPath"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch: java.lang.NoSuchMethodException -> L33 java.lang.IllegalAccessException -> L35 java.lang.SecurityException -> L37 java.lang.IllegalArgumentException -> L39 java.lang.ClassNotFoundException -> L3b java.lang.reflect.InvocationTargetException -> L3d
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L33 java.lang.IllegalAccessException -> L35 java.lang.SecurityException -> L37 java.lang.IllegalArgumentException -> L39 java.lang.ClassNotFoundException -> L3b java.lang.reflect.InvocationTargetException -> L3d
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch: java.lang.NoSuchMethodException -> L33 java.lang.IllegalAccessException -> L35 java.lang.SecurityException -> L37 java.lang.IllegalArgumentException -> L39 java.lang.ClassNotFoundException -> L3b java.lang.reflect.InvocationTargetException -> L3d
            java.lang.Object r3 = r3.invoke(r6, r4)     // Catch: java.lang.NoSuchMethodException -> L33 java.lang.IllegalAccessException -> L35 java.lang.SecurityException -> L37 java.lang.IllegalArgumentException -> L39 java.lang.ClassNotFoundException -> L3b java.lang.reflect.InvocationTargetException -> L3d
            java.lang.String r4 = "isSymbolicLink"
            java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch: java.lang.NoSuchMethodException -> L33 java.lang.IllegalAccessException -> L35 java.lang.SecurityException -> L37 java.lang.IllegalArgumentException -> L39 java.lang.ClassNotFoundException -> L3b java.lang.reflect.InvocationTargetException -> L3d
            java.lang.reflect.Method r1 = r1.getMethod(r4, r2)     // Catch: java.lang.NoSuchMethodException -> L33 java.lang.IllegalAccessException -> L35 java.lang.SecurityException -> L37 java.lang.IllegalArgumentException -> L39 java.lang.ClassNotFoundException -> L3b java.lang.reflect.InvocationTargetException -> L3d
            java.lang.Object[] r2 = new java.lang.Object[]{r3}     // Catch: java.lang.NoSuchMethodException -> L33 java.lang.IllegalAccessException -> L35 java.lang.SecurityException -> L37 java.lang.IllegalArgumentException -> L39 java.lang.ClassNotFoundException -> L3b java.lang.reflect.InvocationTargetException -> L3d
            r3 = 0
            java.lang.Object r1 = r1.invoke(r3, r2)     // Catch: java.lang.NoSuchMethodException -> L33 java.lang.IllegalAccessException -> L35 java.lang.SecurityException -> L37 java.lang.IllegalArgumentException -> L39 java.lang.ClassNotFoundException -> L3b java.lang.reflect.InvocationTargetException -> L3d
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.NoSuchMethodException -> L33 java.lang.IllegalAccessException -> L35 java.lang.SecurityException -> L37 java.lang.IllegalArgumentException -> L39 java.lang.ClassNotFoundException -> L3b java.lang.reflect.InvocationTargetException -> L3d
            boolean r6 = r1.booleanValue()     // Catch: java.lang.NoSuchMethodException -> L33 java.lang.IllegalAccessException -> L35 java.lang.SecurityException -> L37 java.lang.IllegalArgumentException -> L39 java.lang.ClassNotFoundException -> L3b java.lang.reflect.InvocationTargetException -> L3d
            return r6
        L33:
            r1 = move-exception
            goto L3f
        L35:
            r1 = move-exception
            goto L49
        L37:
            r1 = move-exception
            goto L53
        L39:
            r1 = move-exception
            goto L5d
        L3b:
            r1 = move-exception
            goto L67
        L3d:
            r6 = move-exception
            goto L9e
        L3f:
            com.huawei.cloud.base.util.r r2 = com.huawei.cloud.base.util.C4647o.f21332a
            java.lang.String r1 = r1.toString()
            r2.m28487b(r1)
            goto L70
        L49:
            com.huawei.cloud.base.util.r r2 = com.huawei.cloud.base.util.C4647o.f21332a
            java.lang.String r1 = r1.toString()
            r2.m28487b(r1)
            goto L70
        L53:
            com.huawei.cloud.base.util.r r2 = com.huawei.cloud.base.util.C4647o.f21332a
            java.lang.String r1 = r1.toString()
            r2.m28487b(r1)
            goto L70
        L5d:
            com.huawei.cloud.base.util.r r2 = com.huawei.cloud.base.util.C4647o.f21332a
            java.lang.String r1 = r1.toString()
            r2.m28487b(r1)
            goto L70
        L67:
            com.huawei.cloud.base.util.r r2 = com.huawei.cloud.base.util.C4647o.f21332a
            java.lang.String r1 = r1.toString()
            r2.m28487b(r1)
        L70:
            char r1 = java.io.File.separatorChar
            r2 = 92
            if (r1 != r2) goto L77
            return r0
        L77:
            java.lang.String r0 = r6.getParent()
            if (r0 == 0) goto L8f
            java.io.File r0 = new java.io.File
            java.io.File r1 = r6.getParentFile()
            java.io.File r1 = r1.getCanonicalFile()
            java.lang.String r6 = r6.getName()
            r0.<init>(r1, r6)
            r6 = r0
        L8f:
            java.io.File r0 = r6.getCanonicalFile()
            java.io.File r6 = r6.getAbsoluteFile()
            boolean r6 = r0.equals(r6)
            r6 = r6 ^ 1
            return r6
        L9e:
            java.lang.Throwable r6 = r6.getCause()
            java.lang.Class<java.io.IOException> r0 = java.io.IOException.class
            com.huawei.cloud.base.util.C4635e0.m28410c(r6, r0)
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.cloud.base.util.C4647o.m28479f(java.io.File):boolean");
    }

    /* renamed from: g */
    public static void m28480g(Object obj, OutputStream outputStream) throws IOException {
        try {
            new ObjectOutputStream(outputStream).writeObject(obj);
        } finally {
            outputStream.close();
        }
    }

    /* renamed from: h */
    public static byte[] m28481h(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m28480g(obj, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
