package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.videokit.player.CacheInfo;

/* renamed from: com.huawei.hms.videokit.player.internal.g */
/* loaded from: classes8.dex */
public interface InterfaceC6572g extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.g$a */
    public static abstract class a extends Binder implements InterfaceC6572g {

        /* renamed from: com.huawei.hms.videokit.player.internal.g$a$a, reason: collision with other inner class name */
        public static class C14446a implements InterfaceC6572g {

            /* renamed from: b */
            public static InterfaceC6572g f30526b;

            /* renamed from: a */
            private IBinder f30527a;

            public C14446a(IBinder iBinder) {
                this.f30527a = iBinder;
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6572g
            /* renamed from: a */
            public int mo37413a(IObjectWrapper iObjectWrapper, String str, int i10) throws RemoteException {
                int iMo37413a;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPreloader");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    if (this.f30527a.transact(1, parcelObtain, parcelObtain2, 0) || a.m37417g() == null) {
                        parcelObtain2.readException();
                        iMo37413a = parcelObtain2.readInt();
                    } else {
                        iMo37413a = a.m37417g().mo37413a(iObjectWrapper, str, i10);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iMo37413a;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30527a;
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6572g
            public int pauseAllTasks() throws RemoteException {
                int iPauseAllTasks;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPreloader");
                    if (this.f30527a.transact(4, parcelObtain, parcelObtain2, 0) || a.m37417g() == null) {
                        parcelObtain2.readException();
                        iPauseAllTasks = parcelObtain2.readInt();
                    } else {
                        iPauseAllTasks = a.m37417g().pauseAllTasks();
                    }
                    return iPauseAllTasks;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6572g
            public int removeAllCache() throws RemoteException {
                int iRemoveAllCache;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPreloader");
                    if (this.f30527a.transact(6, parcelObtain, parcelObtain2, 0) || a.m37417g() == null) {
                        parcelObtain2.readException();
                        iRemoveAllCache = parcelObtain2.readInt();
                    } else {
                        iRemoveAllCache = a.m37417g().removeAllCache();
                    }
                    return iRemoveAllCache;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6572g
            public int removeAllTasks() throws RemoteException {
                int iRemoveAllTasks;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPreloader");
                    if (this.f30527a.transact(7, parcelObtain, parcelObtain2, 0) || a.m37417g() == null) {
                        parcelObtain2.readException();
                        iRemoveAllTasks = parcelObtain2.readInt();
                    } else {
                        iRemoveAllTasks = a.m37417g().removeAllTasks();
                    }
                    return iRemoveAllTasks;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6572g
            public int resumeAllTasks() throws RemoteException {
                int iResumeAllTasks;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPreloader");
                    if (this.f30527a.transact(5, parcelObtain, parcelObtain2, 0) || a.m37417g() == null) {
                        parcelObtain2.readException();
                        iResumeAllTasks = parcelObtain2.readInt();
                    } else {
                        iResumeAllTasks = a.m37417g().resumeAllTasks();
                    }
                    return iResumeAllTasks;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6572g
            /* renamed from: a */
            public int mo37414a(CacheInfo cacheInfo, int i10) throws RemoteException {
                int iMo37414a;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPreloader");
                    if (cacheInfo != null) {
                        parcelObtain.writeInt(1);
                        cacheInfo.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i10);
                    if (this.f30527a.transact(3, parcelObtain, parcelObtain2, 0) || a.m37417g() == null) {
                        parcelObtain2.readException();
                        iMo37414a = parcelObtain2.readInt();
                    } else {
                        iMo37414a = a.m37417g().mo37414a(cacheInfo, i10);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iMo37414a;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6572g
            /* renamed from: a */
            public void mo37415a(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IPreloader");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    if (this.f30527a.transact(8, parcelObtain, parcelObtain2, 0) || a.m37417g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37417g().mo37415a(str, str2, str3, str4);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static InterfaceC6572g m37416a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.videokit.player.internal.IPreloader");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC6572g)) ? new C14446a(iBinder) : (InterfaceC6572g) iInterfaceQueryLocalInterface;
        }

        /* renamed from: g */
        public static InterfaceC6572g m37417g() {
            return C14446a.f30526b;
        }
    }

    /* renamed from: a */
    int mo37413a(IObjectWrapper iObjectWrapper, String str, int i10) throws RemoteException;

    /* renamed from: a */
    int mo37414a(CacheInfo cacheInfo, int i10) throws RemoteException;

    /* renamed from: a */
    void mo37415a(String str, String str2, String str3, String str4) throws RemoteException;

    int pauseAllTasks() throws RemoteException;

    int removeAllCache() throws RemoteException;

    int removeAllTasks() throws RemoteException;

    int resumeAllTasks() throws RemoteException;
}
