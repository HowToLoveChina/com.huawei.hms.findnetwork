package p625rx;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* renamed from: rx.m */
/* loaded from: classes9.dex */
public class C12646m {

    /* renamed from: a */
    public static IBinder f58108a;

    /* renamed from: c */
    public static String f58110c;

    /* renamed from: d */
    public static IBinder f58111d;

    /* renamed from: b */
    public static final Object f58109b = new Object();

    /* renamed from: e */
    public static final Object f58112e = new Object();

    /* renamed from: f */
    public static IBinder.DeathRecipient f58113f = new a();

    /* renamed from: g */
    public static IBinder.DeathRecipient f58114g = new b();

    /* renamed from: rx.m$a */
    public static class a implements IBinder.DeathRecipient {
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (C12646m.f58112e) {
                Log.e("CommonUtils", "device info binder dead");
                C12646m.f58111d = null;
            }
        }
    }

    /* renamed from: rx.m$b */
    public static class b implements IBinder.DeathRecipient {
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (C12646m.f58109b) {
                C12646m.f58108a = null;
            }
        }
    }

    /* renamed from: a */
    public static IBinder m76173a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        IBinder iBinder = f58108a;
        if (iBinder != null) {
            return iBinder;
        }
        IBinder iBinderM76174b = m76174b("SamgrService");
        if (iBinderM76174b == null) {
            Log.e("CommonUtils", "samgr is null");
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInt(401);
        try {
            try {
                iBinderM76174b.transact(2, parcelObtain, parcelObtain2, 0);
                IBinder strongBinder = parcelObtain2.readStrongBinder();
                f58108a = strongBinder;
                if (strongBinder != null) {
                    strongBinder.linkToDeath(f58114g, 0);
                }
                IBinder iBinder2 = f58108a;
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return iBinder2;
            } catch (RemoteException e10) {
                Log.e("CommonUtils", "get dmsproxy accur exception" + e10);
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return null;
            }
        } catch (Throwable th2) {
            parcelObtain.recycle();
            parcelObtain2.recycle();
            throw th2;
        }
    }

    /* renamed from: b */
    public static IBinder m76174b(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, str);
            if (objInvoke instanceof IBinder) {
                return (IBinder) objInvoke;
            }
            return null;
        } catch (ReflectiveOperationException e10) {
            Log.e("CommonUtils", "getService exception" + e10);
            return null;
        }
    }

    /* renamed from: c */
    public static void m76175c(IBinder.DeathRecipient deathRecipient) throws IllegalAccessException, RemoteException, IllegalArgumentException, InvocationTargetException {
        IBinder iBinderM76173a = m76173a();
        if (iBinderM76173a != null) {
            try {
                iBinderM76173a.linkToDeath(deathRecipient, 0);
            } catch (RemoteException unused) {
                Log.e("CommonUtils", "linkToBmsDeath failed");
            }
        }
    }

    /* renamed from: d */
    public static String m76176d() {
        return !m76177e() ? "" : f58110c;
    }

    /* renamed from: e */
    public static boolean m76177e() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f58110c != null) {
            return true;
        }
        IBinder iBinderM76173a = m76173a();
        if (iBinderM76173a == null) {
            Log.e("CommonUtils", "getBmsProxy return null");
            return false;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
        parcelObtain.writeInt(0);
        try {
            parcelObtain.writeInt(0);
            parcelObtain.writeInt(0);
            iBinderM76173a.transact(54, parcelObtain, parcelObtain2, 0);
            if (parcelObtain2.readInt() != 0) {
                Log.e("CommonUtils", "get bundle manager version code error");
                return false;
            }
            String string = parcelObtain2.readString();
            f58110c = string;
            if (string == null) {
                f58110c = "";
            }
            Log.i("CommonUtils", "get bundle manager version code: " + f58110c);
            return true;
        } catch (RemoteException e10) {
            Log.e("CommonUtils", "getBmsProxy transact accur exception:" + e10);
            return false;
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* renamed from: f */
    public static boolean m76178f() {
        if (m76177e()) {
            return !f58110c.isEmpty();
        }
        return false;
    }
}
