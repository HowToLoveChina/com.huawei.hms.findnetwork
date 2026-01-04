package p229di;

import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import p229di.C9142g;

/* renamed from: di.p */
/* loaded from: classes4.dex */
public class C9151p {
    /* renamed from: a */
    public static StorageVolume[] m57491a(StorageManager storageManager, int i10) {
        try {
            Class cls = Integer.TYPE;
            return (StorageVolume[]) C9142g.a.m57467b(storageManager, cls, cls).m57470d("getVolumeList", Integer.valueOf(i10), C9142g.a.m57467b(storageManager, new Class[0]).m57473h("FLAG_REAL_STATE").m57472f()).m57472f();
        } catch (Exception unused) {
            return null;
        }
    }
}
