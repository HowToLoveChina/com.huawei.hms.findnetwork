package p841ze;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import java.lang.reflect.InvocationTargetException;
import p035bk.C1249b;
import p809yg.C13981a;
import p841ze.C14288b;

/* renamed from: ze.e */
/* loaded from: classes4.dex */
public class C14291e extends Thread {

    /* renamed from: f */
    public static final String f63529f = "e";

    /* renamed from: b */
    public Context f63531b;

    /* renamed from: e */
    public C14288b.c f63534e;

    /* renamed from: a */
    public StorageManager f63530a = null;

    /* renamed from: c */
    public Object f63532c = null;

    /* renamed from: d */
    public Object f63533d = null;

    public C14291e(Context context, C14288b.c cVar) {
        this.f63531b = context;
        this.f63534e = cVar;
    }

    /* renamed from: a */
    public static Object m85145a(Context context) throws RemoteException {
        Object objM7478a;
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        for (StorageVolume storageVolume : C1249b.m7483f(storageManager)) {
            if (storageVolume.getUuid() != null && (objM7478a = C1249b.m7478a(storageManager, storageVolume.getUuid())) != null) {
                Object objM7479b = C1249b.m7479b(objM7478a);
                if (!storageVolume.isPrimary() && objM7479b != null && C1249b.m7485h(objM7479b)) {
                    return objM7478a;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public void m85146c() {
        String str = f63529f;
        C13981a.m83989i(str, "resetFactory");
        Intent intent = new Intent("android.intent.action.MASTER_CLEAR");
        intent.putExtra("masterClearWipeDataFactoryLowlevel", true);
        intent.addFlags(16777216);
        Context context = this.f63531b;
        if (context != null) {
            context.sendBroadcast(intent);
        } else {
            C13981a.m83988e(str, "mContext is null");
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f63530a = (StorageManager) this.f63531b.getSystemService("storage");
        try {
            this.f63532c = m85145a(this.f63531b);
        } catch (RemoteException e10) {
            C13981a.m83988e(f63529f, "ExistSDCard RemoteException" + e10.getMessage());
        }
        Object obj = this.f63532c;
        if (obj != null) {
            this.f63533d = C1249b.m7479b(obj);
        }
        String str = f63529f;
        C13981a.m83987d(str, "mDisk=" + this.f63533d);
        if (this.f63533d != null) {
            C13981a.m83989i(str, "partitionPublic begin");
            C1249b.m7487j(this.f63530a, this.f63533d);
            C13981a.m83989i(str, "partitionPublic end");
            C14288b.c cVar = this.f63534e;
            if (cVar != null) {
                cVar.mo85099a(true);
            }
        } else {
            this.f63534e.mo85099a(false);
        }
        m85146c();
    }
}
