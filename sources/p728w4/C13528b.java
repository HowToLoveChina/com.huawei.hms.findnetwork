package p728w4;

import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: w4.b */
/* loaded from: classes.dex */
public class C13528b {
    /* renamed from: a */
    public static C13527a m81416a(StorageManager storageManager, String str) {
        try {
            return C13527a.m81405k(storageManager).m81409b("findVolumeByUuid", str);
        } catch (C13530d unused) {
            C2111d.m12648d("InnerReflectStorageVolume", "err Reflect findVolumeByUuid");
            return null;
        }
    }

    /* renamed from: b */
    public static C13527a m81417b(C13527a c13527a) {
        if (c13527a == null) {
            return c13527a;
        }
        try {
            return C13527a.m81405k(c13527a.m81413g()).m81409b("getDisk", new Object[0]);
        } catch (C13530d unused) {
            C2111d.m12648d("InnerReflectStorageVolume", "err Reflect getDisk");
            return null;
        }
    }

    /* renamed from: c */
    public static String m81418c(StorageVolume storageVolume) {
        try {
            return (String) C13527a.m81405k(storageVolume).m81409b("getPath", new Object[0]).m81413g();
        } catch (C13530d unused) {
            C2111d.m12648d("InnerReflectStorageVolume", "err Reflect getPath");
            return null;
        }
    }

    /* renamed from: d */
    public static StorageVolume[] m81419d(StorageManager storageManager) {
        try {
            return (StorageVolume[]) C13527a.m81405k(storageManager).m81409b("getVolumeList", new Object[0]).m81413g();
        } catch (C13530d unused) {
            C2111d.m12648d("InnerReflectStorageVolume", "err Reflect getVolumeList");
            return null;
        }
    }

    /* renamed from: e */
    public static String m81420e(StorageManager storageManager, String str) {
        try {
            return (String) C13527a.m81405k(storageManager).m81409b("getVolumeState", str).m81413g();
        } catch (C13530d unused) {
            C2111d.m12648d("InnerReflectStorageVolume", "err Reflect getVolumeState");
            return null;
        }
    }

    /* renamed from: f */
    public static boolean m81421f(C13527a c13527a) {
        if (c13527a == null) {
            return false;
        }
        try {
            return ((Boolean) C13527a.m81405k(c13527a.m81413g()).m81409b("isSd", new Object[0]).m81413g()).booleanValue();
        } catch (C13530d unused) {
            C2111d.m12648d("InnerReflectStorageVolume", "err Reflect isSd");
            return false;
        }
    }

    /* renamed from: g */
    public static boolean m81422g(C13527a c13527a) {
        if (c13527a == null) {
            return false;
        }
        try {
            return ((Boolean) C13527a.m81405k(c13527a.m81413g()).m81409b("isUsb", new Object[0]).m81413g()).booleanValue();
        } catch (C13530d unused) {
            C2111d.m12648d("InnerReflectStorageVolume", "err Reflect isSd");
            return false;
        }
    }
}
