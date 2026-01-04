package com.huawei.hms.network.file.p130a.p133k.p134b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.network.file.api.RequestConfig;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.huawei.hms.network.file.a.k.b.f */
/* loaded from: classes8.dex */
public class C6204f {

    /* renamed from: com.huawei.hms.network.file.a.k.b.f$a */
    public static final class a extends ObjectInputStream {

        /* renamed from: a */
        static final Set<String> f29335a = new C14443a();

        /* renamed from: com.huawei.hms.network.file.a.k.b.f$a$a, reason: collision with other inner class name */
        public class C14443a extends HashSet<String> {
            public C14443a() {
                add(Collections.unmodifiableMap(Collections.emptyMap()).getClass().getName());
                add(HashMap.class.getName());
                add(RequestConfig.class.getName());
            }
        }

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
            if (f29335a.contains(objectStreamClass.getName())) {
                return super.resolveClass(objectStreamClass);
            }
            String str = "resolveClass forbidden for:" + objectStreamClass.getName();
            FLogger.m36351e("IOUtils", str);
            throw new ClassNotFoundException(str);
        }
    }

    /* renamed from: a */
    public static Object m36106a(byte[] bArr) throws Throwable {
        Throwable th2;
        a aVar;
        Exception e10;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayInputStream byteArrayInputStream3 = null;
        Object object = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
        } catch (Exception e11) {
            e10 = e11;
            aVar = null;
            byteArrayInputStream = null;
        } catch (Throwable th3) {
            th2 = th3;
            aVar = null;
            m36109a((Closeable) aVar);
            m36109a((Closeable) byteArrayInputStream3);
            throw th2;
        }
        try {
            aVar = new a(byteArrayInputStream);
        } catch (Exception e12) {
            e10 = e12;
            aVar = null;
        } catch (Throwable th4) {
            byteArrayInputStream2 = byteArrayInputStream;
            th2 = th4;
            aVar = null;
            byteArrayInputStream3 = byteArrayInputStream2;
            m36109a((Closeable) aVar);
            m36109a((Closeable) byteArrayInputStream3);
            throw th2;
        }
        try {
            try {
                object = aVar.readObject();
            } catch (Throwable th5) {
                byteArrayInputStream2 = byteArrayInputStream;
                th2 = th5;
                byteArrayInputStream3 = byteArrayInputStream2;
                m36109a((Closeable) aVar);
                m36109a((Closeable) byteArrayInputStream3);
                throw th2;
            }
        } catch (Exception e13) {
            e10 = e13;
            FLogger.logException(e10);
            m36109a((Closeable) aVar);
            m36109a((Closeable) byteArrayInputStream);
            return object;
        }
        m36109a((Closeable) aVar);
        m36109a((Closeable) byteArrayInputStream);
        return object;
    }

    /* renamed from: a */
    public static void m36107a(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        try {
            IoUtils.close(cursor);
        } catch (RuntimeException | Exception e10) {
            FLogger.logException(e10);
        }
    }

    /* renamed from: a */
    public static void m36108a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
                return;
            }
            FLogger.m36355w("IOUtils", "db is null for:" + str, new Object[0]);
        } catch (SQLiteException e10) {
            FLogger.m36355w("IOUtils", "SqliteException for:" + str, e10);
        } catch (RuntimeException e11) {
            FLogger.m36355w("IOUtils", "RuntimeException for:" + str, e11);
        }
    }

    /* renamed from: a */
    public static void m36109a(Closeable closeable) throws IOException {
        Utils.close(closeable);
    }

    /* renamed from: a */
    public static byte[] m36110a(Object obj) throws Throwable {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream2);
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    m36109a((Closeable) objectOutputStream);
                    m36109a((Closeable) byteArrayOutputStream2);
                    return byteArray;
                } catch (IOException e10) {
                    e = e10;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        FLogger.logException(e);
                        m36109a((Closeable) objectOutputStream);
                        m36109a((Closeable) byteArrayOutputStream);
                        return new byte[0];
                    } catch (Throwable th2) {
                        th = th2;
                        m36109a((Closeable) objectOutputStream);
                        m36109a((Closeable) byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    m36109a((Closeable) objectOutputStream);
                    m36109a((Closeable) byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
                objectOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream = null;
            }
        } catch (IOException e12) {
            e = e12;
            objectOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            objectOutputStream = null;
        }
    }
}
