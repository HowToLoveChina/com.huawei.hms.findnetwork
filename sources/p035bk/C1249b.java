package p035bk;

import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p399jk.AbstractC10896a;

/* renamed from: bk.b */
/* loaded from: classes6.dex */
public class C1249b {

    /* renamed from: a */
    public static volatile Method f5667a;

    /* renamed from: b */
    public static volatile Method f5668b;

    /* renamed from: c */
    public static volatile Method f5669c;

    /* renamed from: d */
    public static volatile Method f5670d;

    /* renamed from: e */
    public static volatile Method f5671e;

    /* renamed from: f */
    public static volatile Method f5672f;

    /* renamed from: a */
    public static Object m7478a(StorageManager storageManager, String str) {
        if (storageManager == null) {
            return null;
        }
        try {
            if (f5668b == null) {
                synchronized (C1249b.class) {
                    try {
                        if (f5668b == null) {
                            f5668b = StorageManager.class.getMethod("findVolumeByUuid", String.class);
                        }
                    } finally {
                    }
                }
            }
            return f5668b.invoke(storageManager, str);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("StorageInvoke", "findVolumeByUuid exception " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public static Object m7479b(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (f5669c == null) {
                synchronized (C1249b.class) {
                    try {
                        if (f5669c == null) {
                            f5669c = Class.forName("android.os.storage.VolumeInfo").getMethod("getDisk", new Class[0]);
                        }
                    } finally {
                    }
                }
            }
            return f5669c.invoke(obj, new Object[0]);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("StorageInvoke", "getDiskFromVolumeInfo exception " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static String m7480c(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (String) Class.forName("android.os.storage.DiskInfo").getMethod("getId", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("StorageInvoke", "getIdFromDiskInfo exception " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: d */
    public static String m7481d(StorageVolume storageVolume) {
        if (storageVolume == null) {
            return "";
        }
        try {
            if (f5672f == null) {
                synchronized (C1249b.class) {
                    try {
                        if (f5672f == null) {
                            f5672f = StorageVolume.class.getMethod("getPath", new Class[0]);
                        }
                    } finally {
                    }
                }
            }
            return (String) f5672f.invoke(storageVolume, new Object[0]);
        } catch (IllegalAccessException unused) {
            AbstractC10896a.m65886e("StorageInvoke", "illegal access exception when getPath");
            return "";
        } catch (NoSuchMethodException unused2) {
            AbstractC10896a.m65886e("StorageInvoke", "no such method exception when getPath");
            return "";
        } catch (InvocationTargetException unused3) {
            AbstractC10896a.m65886e("StorageInvoke", "invocation target exception when getPath");
            return "";
        }
    }

    /* renamed from: e */
    public static File m7482e(StorageVolume storageVolume) {
        try {
            return (File) StorageVolume.class.getMethod("getPathFile", new Class[0]).invoke(storageVolume, new Object[0]);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("StorageInvoke", "getPathFile: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: f */
    public static StorageVolume[] m7483f(StorageManager storageManager) {
        if (storageManager == null) {
            return new StorageVolume[0];
        }
        try {
            if (f5667a == null) {
                synchronized (C1249b.class) {
                    try {
                        if (f5667a == null) {
                            f5667a = StorageManager.class.getMethod("getVolumeList", new Class[0]);
                        }
                    } finally {
                    }
                }
            }
            return (StorageVolume[]) f5667a.invoke(storageManager, new Object[0]);
        } catch (IllegalAccessException unused) {
            AbstractC10896a.m65886e("StorageInvoke", "illegal access exception when getVolumeList");
            return new StorageVolume[0];
        } catch (NoSuchMethodException unused2) {
            AbstractC10896a.m65886e("StorageInvoke", "no such method exception when getVolumeList");
            return new StorageVolume[0];
        } catch (InvocationTargetException unused3) {
            AbstractC10896a.m65886e("StorageInvoke", "invocation target exception when getVolumeList");
            return new StorageVolume[0];
        }
    }

    /* renamed from: g */
    public static String m7484g(StorageManager storageManager, String str) {
        if (str == null) {
            return null;
        }
        try {
            return (String) StorageManager.class.getMethod("getVolumeState", String.class).invoke(storageManager, str);
        } catch (IllegalAccessException unused) {
            AbstractC10896a.m65886e("StorageInvoke", "illegal access exception when getVolumeState");
            return null;
        } catch (NoSuchMethodException unused2) {
            AbstractC10896a.m65886e("StorageInvoke", "no such method exception when getVolumeState");
            return null;
        } catch (InvocationTargetException unused3) {
            AbstractC10896a.m65886e("StorageInvoke", "invocation target exception when getVolumeState");
            return null;
        }
    }

    /* renamed from: h */
    public static boolean m7485h(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (f5670d == null) {
                synchronized (C1249b.class) {
                    try {
                        if (f5670d == null) {
                            f5670d = Class.forName("android.os.storage.DiskInfo").getMethod("isSd", new Class[0]);
                        }
                    } finally {
                    }
                }
            }
            return ((Boolean) f5670d.invoke(obj, new Object[0])).booleanValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("StorageInvoke", "isSdByDiskInfo exception " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: i */
    public static boolean m7486i(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (f5671e == null) {
                synchronized (C1249b.class) {
                    try {
                        if (f5671e == null) {
                            f5671e = Class.forName("android.os.storage.DiskInfo").getMethod("isUsb", new Class[0]);
                        }
                    } finally {
                    }
                }
            }
            return ((Boolean) f5671e.invoke(obj, new Object[0])).booleanValue();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("StorageInvoke", "isUsbByDiskInfo exception " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: j */
    public static void m7487j(StorageManager storageManager, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (storageManager == null) {
            return;
        }
        try {
            StorageManager.class.getMethod("partitionPublic", String.class).invoke(storageManager, m7480c(obj));
        } catch (Exception e10) {
            AbstractC10896a.m65886e("StorageInvoke", "partitionPublic exception " + e10.getMessage());
        }
    }
}
