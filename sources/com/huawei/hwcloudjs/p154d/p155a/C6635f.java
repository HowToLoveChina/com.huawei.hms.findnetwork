package com.huawei.hwcloudjs.p154d.p155a;

import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.p164f.C6663h;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* renamed from: com.huawei.hwcloudjs.d.a.f */
/* loaded from: classes8.dex */
public class C6635f<T> {

    /* renamed from: a */
    private static final String f30837a = "SerializedObject";

    /* renamed from: b */
    private String f30838b;

    public C6635f(String str) {
        this.f30838b = str;
    }

    /* renamed from: a */
    public long m37803a() {
        return new File(this.f30838b).lastModified();
    }

    /* renamed from: b */
    public T m37805b() throws Throwable {
        Throwable th2;
        FileInputStream fileInputStream;
        C6634e c6634e;
        Closeable closeable = (T) null;
        try {
            fileInputStream = new FileInputStream(this.f30838b);
            try {
                c6634e = new C6634e(fileInputStream);
            } catch (IOException | Exception unused) {
                c6634e = null;
            } catch (Throwable th3) {
                th2 = th3;
                C6663h.m37901a(fileInputStream);
                C6663h.m37901a(closeable);
                throw th2;
            }
        } catch (IOException | Exception unused2) {
            c6634e = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th2 = th4;
            fileInputStream = null;
        }
        try {
            try {
                closeable = (T) c6634e.readObject();
            } catch (Throwable th5) {
                th2 = th5;
                closeable = (T) c6634e;
                C6663h.m37901a(fileInputStream);
                C6663h.m37901a(closeable);
                throw th2;
            }
        } catch (IOException | Exception unused3) {
            C6659d.m37881b(f30837a, "read file error ", true);
            C6663h.m37901a(fileInputStream);
            C6663h.m37901a(c6634e);
            return (T) closeable;
        }
        C6663h.m37901a(fileInputStream);
        C6663h.m37901a(c6634e);
        return (T) closeable;
    }

    /* renamed from: a */
    public boolean m37804a(T t10) throws Throwable {
        Throwable th2;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(this.f30838b);
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream2.writeObject(t10);
                    C6663h.m37901a(fileOutputStream);
                    C6663h.m37901a(objectOutputStream2);
                    return true;
                } catch (IOException unused) {
                    objectOutputStream = objectOutputStream2;
                    try {
                        C6659d.m37881b(f30837a, "read file error ", true);
                        C6663h.m37901a(fileOutputStream);
                        C6663h.m37901a(objectOutputStream);
                        return false;
                    } catch (Throwable th3) {
                        th2 = th3;
                        C6663h.m37901a(fileOutputStream);
                        C6663h.m37901a(objectOutputStream);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    objectOutputStream = objectOutputStream2;
                    C6663h.m37901a(fileOutputStream);
                    C6663h.m37901a(objectOutputStream);
                    throw th2;
                }
            } catch (IOException unused2) {
            } catch (Throwable th5) {
                th2 = th5;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
        } catch (Throwable th6) {
            th2 = th6;
            fileOutputStream = null;
        }
    }
}
