package com.huawei.hicloud.cloudbackup.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hicloud.cloudbackup.service.ICoreCallback;

/* loaded from: classes6.dex */
public interface ICoreService extends IInterface {

    /* renamed from: com.huawei.hicloud.cloudbackup.service.ICoreService$a */
    public static abstract class AbstractBinderC4876a extends Binder implements ICoreService {

        /* renamed from: com.huawei.hicloud.cloudbackup.service.ICoreService$a$a */
        public static class a implements ICoreService {

            /* renamed from: a */
            public IBinder f22299a;

            public a(IBinder iBinder) {
                this.f22299a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f22299a;
            }

            @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
            public void registerCallback(ICoreCallback iCoreCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hicloud.cloudbackup.service.ICoreService");
                    parcelObtain.writeStrongInterface(iCoreCallback);
                    this.f22299a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
            public int restore(String str, String str2, int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hicloud.cloudbackup.service.ICoreService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    this.f22299a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
            public int restoreRetry(boolean z10, boolean z11, boolean z12) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hicloud.cloudbackup.service.ICoreService");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    parcelObtain.writeInt(z12 ? 1 : 0);
                    this.f22299a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
            public int restoreRetryV3(boolean z10, boolean z11, boolean z12) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hicloud.cloudbackup.service.ICoreService");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    parcelObtain.writeInt(z12 ? 1 : 0);
                    this.f22299a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
            public int restoreV3(String str, String str2, String str3, int i10, String str4, String str5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hicloud.cloudbackup.service.ICoreService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    this.f22299a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
            public void unregisterCallback(ICoreCallback iCoreCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hicloud.cloudbackup.service.ICoreService");
                    parcelObtain.writeStrongInterface(iCoreCallback);
                    this.f22299a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC4876a() {
            attachInterface(this, "com.huawei.hicloud.cloudbackup.service.ICoreService");
        }

        /* renamed from: a */
        public static ICoreService m29273a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hicloud.cloudbackup.service.ICoreService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICoreService)) ? new a(iBinder) : (ICoreService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.hicloud.cloudbackup.service.ICoreService");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hicloud.cloudbackup.service.ICoreService");
                return true;
            }
            switch (i10) {
                case 1:
                    registerCallback(ICoreCallback.AbstractBinderC4874a.m29268a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    unregisterCallback(ICoreCallback.AbstractBinderC4874a.m29268a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    int iBackup = backup();
                    parcel2.writeNoException();
                    parcel2.writeInt(iBackup);
                    return true;
                case 4:
                    int iRestore = restore(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iRestore);
                    return true;
                case 5:
                    int iRestoreV3 = restoreV3(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iRestoreV3);
                    return true;
                case 6:
                    int iRestoreRetry = restoreRetry(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(iRestoreRetry);
                    return true;
                case 7:
                    int iRestoreRetryV3 = restoreRetryV3(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(iRestoreRetryV3);
                    return true;
                case 8:
                    int iDoBackupOptions = doBackupOptions();
                    parcel2.writeNoException();
                    parcel2.writeInt(iDoBackupOptions);
                    return true;
                case 9:
                    abort(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    int iStartRefurbish = startRefurbish(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iStartRefurbish);
                    return true;
                case 11:
                    int iResumeRefurbish = resumeRefurbish(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iResumeRefurbish);
                    return true;
                case 12:
                    int iPauseRefurbish = pauseRefurbish(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iPauseRefurbish);
                    return true;
                case 13:
                    int iCancelRefurbish = cancelRefurbish(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iCancelRefurbish);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void abort(int i10) throws RemoteException;

    int backup() throws RemoteException;

    int cancelRefurbish(int i10) throws RemoteException;

    int doBackupOptions() throws RemoteException;

    int pauseRefurbish(int i10) throws RemoteException;

    void registerCallback(ICoreCallback iCoreCallback) throws RemoteException;

    int restore(String str, String str2, int i10, int i11) throws RemoteException;

    int restoreRetry(boolean z10, boolean z11, boolean z12) throws RemoteException;

    int restoreRetryV3(boolean z10, boolean z11, boolean z12) throws RemoteException;

    int restoreV3(String str, String str2, String str3, int i10, String str4, String str5) throws RemoteException;

    int resumeRefurbish(int i10) throws RemoteException;

    int startRefurbish(int i10) throws RemoteException;

    void unregisterCallback(ICoreCallback iCoreCallback) throws RemoteException;
}
