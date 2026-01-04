package ht;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* renamed from: ht.c */
/* loaded from: classes8.dex */
public class C10340c {

    /* renamed from: a */
    public static IBinder f50024a;

    /* renamed from: c */
    public static String f50026c;

    /* renamed from: b */
    public static final Object f50025b = new Object();

    /* renamed from: d */
    public static final Object f50027d = new Object();

    /* renamed from: e */
    public static IBinder.DeathRecipient f50028e = new a();

    /* renamed from: ht.c$a */
    public class a implements IBinder.DeathRecipient {
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (C10340c.f50025b) {
                C10340c.f50024a = null;
            }
        }
    }

    /* renamed from: a */
    public static IBinder m63672a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        IBinder iBinder = f50024a;
        if (iBinder != null) {
            return iBinder;
        }
        IBinder iBinderM63673b = m63673b("SamgrService");
        if (iBinderM63673b == null) {
            Log.e("CommonUtils", "samgr is null");
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        parcelObtain.writeInt(401);
        try {
            try {
                iBinderM63673b.transact(2, parcelObtain, parcelObtain2, 0);
                IBinder strongBinder = parcelObtain2.readStrongBinder();
                f50024a = strongBinder;
                if (strongBinder != null) {
                    strongBinder.linkToDeath(f50028e, 0);
                }
                IBinder iBinder2 = f50024a;
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
    public static IBinder m63673b(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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
    public static String m63674c() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f50026c == null) {
            IBinder iBinderM63672a = m63672a();
            if (iBinderM63672a == null) {
                Log.e("CommonUtils", "getBmsProxy return null");
            } else {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain.writeInterfaceToken("OHOS.AppExecFwk.IBundleMgr");
                parcelObtain.writeInt(0);
                try {
                    try {
                        parcelObtain.writeInt(0);
                        parcelObtain.writeInt(0);
                        iBinderM63672a.transact(54, parcelObtain, parcelObtain2, 0);
                    } catch (RemoteException e10) {
                        Log.e("CommonUtils", "getBmsProxy transact accur exception:" + e10);
                    }
                    if (parcelObtain2.readInt() != 0) {
                        Log.e("CommonUtils", "get bundle manager version code error");
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                    } else {
                        String string = parcelObtain2.readString();
                        f50026c = string;
                        if (string == null) {
                            f50026c = "";
                        }
                        Log.i("CommonUtils", "get bundle manager version code: " + f50026c);
                        parcelObtain.recycle();
                        parcelObtain2.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    throw th2;
                }
            }
            return "";
        }
        return f50026c;
    }
}
