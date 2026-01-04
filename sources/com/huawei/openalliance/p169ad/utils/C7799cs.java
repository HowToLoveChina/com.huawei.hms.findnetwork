package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/* renamed from: com.huawei.openalliance.ad.utils.cs */
/* loaded from: classes2.dex */
public class C7799cs {

    /* renamed from: a */
    private static final String f36038a = "cs";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    /* renamed from: a */
    public static Serializable m48110a(String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th2;
        C7797cq c7797cq;
        String str2;
        String str3;
        Serializable serializable = null;
        try {
            try {
                fileInputStream = new FileInputStream((String) str);
            } catch (FileNotFoundException unused) {
                c7797cq = null;
                fileInputStream = null;
            } catch (IOException unused2) {
                c7797cq = null;
                fileInputStream = null;
            } catch (ClassNotFoundException unused3) {
                c7797cq = null;
                fileInputStream = null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th2 = th3;
                str = 0;
            }
            try {
                c7797cq = new C7797cq(fileInputStream);
            } catch (FileNotFoundException unused4) {
                c7797cq = null;
            } catch (IOException unused5) {
                c7797cq = null;
            } catch (ClassNotFoundException unused6) {
                c7797cq = null;
            } catch (Throwable th4) {
                th2 = th4;
                str = 0;
                AbstractC7805cy.m48142a((Closeable) fileInputStream);
                AbstractC7805cy.m48142a((Closeable) str);
                throw th2;
            }
            try {
                Object object = c7797cq.readObject();
                if (object instanceof Serializable) {
                    serializable = (Serializable) object;
                }
            } catch (FileNotFoundException unused7) {
                AbstractC7185ho.m43826d(f36038a, "read file FileNotFoundException");
                AbstractC7805cy.m48142a((Closeable) fileInputStream);
                AbstractC7805cy.m48142a((Closeable) c7797cq);
                return serializable;
            } catch (IOException unused8) {
                str2 = f36038a;
                str3 = "read file IOException";
                AbstractC7185ho.m43823c(str2, str3);
                AbstractC7805cy.m48142a((Closeable) fileInputStream);
                AbstractC7805cy.m48142a((Closeable) c7797cq);
                return serializable;
            } catch (ClassNotFoundException unused9) {
                str2 = f36038a;
                str3 = "read file ClassNotFoundException";
                AbstractC7185ho.m43823c(str2, str3);
                AbstractC7805cy.m48142a((Closeable) fileInputStream);
                AbstractC7805cy.m48142a((Closeable) c7797cq);
                return serializable;
            }
            AbstractC7805cy.m48142a((Closeable) fileInputStream);
            AbstractC7805cy.m48142a((Closeable) c7797cq);
            return serializable;
        } catch (Throwable th5) {
            th2 = th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* renamed from: b */
    public static Serializable m48113b(String str) {
        C7797cq c7797cq;
        String str2;
        String str3;
        Closeable closeable;
        Closeable closeable2;
        ?? M48165b = AbstractC7806cz.m48165b((String) str);
        Serializable serializable = null;
        try {
            if (M48165b != 0) {
                return null;
            }
            try {
                M48165b = new ByteArrayInputStream(AbstractC7740an.m47532a((String) str));
            } catch (UnsupportedEncodingException unused) {
                c7797cq = null;
                M48165b = 0;
            } catch (IOException unused2) {
                c7797cq = null;
                M48165b = 0;
            } catch (ClassNotFoundException unused3) {
                c7797cq = null;
                M48165b = 0;
            } catch (Throwable th2) {
                M48165b = 0;
                th = th2;
                str = 0;
            }
            try {
                c7797cq = new C7797cq(M48165b);
            } catch (UnsupportedEncodingException unused4) {
                c7797cq = null;
            } catch (IOException unused5) {
                c7797cq = null;
            } catch (ClassNotFoundException unused6) {
                c7797cq = null;
            } catch (Throwable th3) {
                th = th3;
                str = 0;
                AbstractC7805cy.m48142a((Closeable) str);
                AbstractC7805cy.m48142a((Closeable) M48165b);
                throw th;
            }
            try {
                Object object = c7797cq.readObject();
                closeable2 = M48165b;
                if (object instanceof Serializable) {
                    serializable = (Serializable) object;
                    closeable2 = M48165b;
                }
            } catch (UnsupportedEncodingException unused7) {
                str2 = f36038a;
                str3 = "fail to get Serializable UnsupportedEncodingException";
                closeable = M48165b;
                AbstractC7185ho.m43826d(str2, str3);
                closeable2 = closeable;
                AbstractC7805cy.m48142a((Closeable) c7797cq);
                AbstractC7805cy.m48142a(closeable2);
                return serializable;
            } catch (IOException unused8) {
                str2 = f36038a;
                str3 = "fail to get Serializable IOException";
                closeable = M48165b;
                AbstractC7185ho.m43826d(str2, str3);
                closeable2 = closeable;
                AbstractC7805cy.m48142a((Closeable) c7797cq);
                AbstractC7805cy.m48142a(closeable2);
                return serializable;
            } catch (ClassNotFoundException unused9) {
                str2 = f36038a;
                str3 = "fail to get Serializable ClassNotFoundException";
                closeable = M48165b;
                AbstractC7185ho.m43826d(str2, str3);
                closeable2 = closeable;
                AbstractC7805cy.m48142a((Closeable) c7797cq);
                AbstractC7805cy.m48142a(closeable2);
                return serializable;
            }
            AbstractC7805cy.m48142a((Closeable) c7797cq);
            AbstractC7805cy.m48142a(closeable2);
            return serializable;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: a */
    public static String m48111a(Serializable serializable) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            return "";
        }
        ObjectOutputStream objectOutputStream2 = null;
        byte[] byteArray = null;
        objectOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException unused) {
                byteArrayOutputStream = null;
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException unused2) {
                objectOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                AbstractC7805cy.m48142a(objectOutputStream2);
                AbstractC7805cy.m48142a(byteArrayOutputStream);
                throw th;
            }
            try {
                objectOutputStream.writeObject(serializable);
                objectOutputStream.flush();
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException unused3) {
                AbstractC7185ho.m43826d(f36038a, "fail to get sequence");
                AbstractC7805cy.m48142a(objectOutputStream);
                AbstractC7805cy.m48142a(byteArrayOutputStream);
                return AbstractC7740an.m47531a(byteArray);
            }
            AbstractC7805cy.m48142a(objectOutputStream);
            AbstractC7805cy.m48142a(byteArrayOutputStream);
            return AbstractC7740an.m47531a(byteArray);
        } catch (Throwable th4) {
            th = th4;
            objectOutputStream2 = objectOutputStream;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.io.Closeable, java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* renamed from: a */
    public static boolean m48112a(Serializable serializable, String str) throws Throwable {
        Object obj;
        Object obj2;
        String str2;
        String str3;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File((String) str);
                if (!file.getParentFile().exists() && !AbstractC7731ae.m47468g(file.getParentFile())) {
                    AbstractC7185ho.m43823c(f36038a, "writeObject, mkdir failed");
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream((String) str);
                try {
                    str = new ObjectOutputStream(fileOutputStream2);
                } catch (FileNotFoundException unused) {
                    str = 0;
                } catch (IOException unused2) {
                    str = 0;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                }
                try {
                    str.writeObject(serializable);
                    AbstractC7805cy.m48142a(fileOutputStream2);
                    AbstractC7805cy.m48142a((Closeable) str);
                    return true;
                } catch (FileNotFoundException unused3) {
                    fileOutputStream = fileOutputStream2;
                    obj2 = str;
                    str2 = f36038a;
                    str3 = "write file FileNotFoundException";
                    str = obj2;
                    AbstractC7185ho.m43823c(str2, str3);
                    AbstractC7805cy.m48142a(fileOutputStream);
                    AbstractC7805cy.m48142a((Closeable) str);
                    return false;
                } catch (IOException unused4) {
                    fileOutputStream = fileOutputStream2;
                    obj = str;
                    str2 = f36038a;
                    str3 = "write file IOException";
                    str = obj;
                    AbstractC7185ho.m43823c(str2, str3);
                    AbstractC7805cy.m48142a(fileOutputStream);
                    AbstractC7805cy.m48142a((Closeable) str);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    AbstractC7805cy.m48142a(fileOutputStream);
                    AbstractC7805cy.m48142a((Closeable) str);
                    throw th;
                }
            } catch (FileNotFoundException unused5) {
                obj2 = null;
            } catch (IOException unused6) {
                obj = null;
            } catch (Throwable th4) {
                th = th4;
                str = 0;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
