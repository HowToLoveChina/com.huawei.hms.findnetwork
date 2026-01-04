package com.huawei.android.backup.backupremoteservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback;

/* loaded from: classes.dex */
public interface IRemoteService extends IInterface {

    /* renamed from: com.huawei.android.backup.backupremoteservice.IRemoteService$a */
    public static abstract class AbstractBinderC2101a extends Binder implements IRemoteService {

        /* renamed from: com.huawei.android.backup.backupremoteservice.IRemoteService$a$a */
        public static class a implements IRemoteService {

            /* renamed from: a */
            public IBinder f9511a;

            public a(IBinder iBinder) {
                this.f9511a = iBinder;
            }

            @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
            public int abortDoing(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.backup.backupremoteservice.IRemoteService");
                    parcelObtain.writeInt(i10);
                    this.f9511a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9511a;
            }

            @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
            public int checkAppRiskInfo(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.backup.backupremoteservice.IRemoteService");
                    parcelObtain.writeInt(i10);
                    C2102b.m12580d(parcelObtain, bundle, 0);
                    this.f9511a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
            public int doBackupOneModule(int i10, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.backup.backupremoteservice.IRemoteService");
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    C2102b.m12580d(parcelObtain, bundle, 0);
                    this.f9511a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
            public int doRestoreOneModule(int i10, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.backup.backupremoteservice.IRemoteService");
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    C2102b.m12580d(parcelObtain, bundle, 0);
                    this.f9511a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
            public int getBackupModuleInfo(int i10, String[] strArr, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.backup.backupremoteservice.IRemoteService");
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeStringArray(strArr);
                    C2102b.m12580d(parcelObtain, bundle, 0);
                    this.f9511a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
            public int getNewDeviceInfo(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.backup.backupremoteservice.IRemoteService");
                    parcelObtain.writeInt(i10);
                    C2102b.m12580d(parcelObtain, bundle, 0);
                    this.f9511a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
            public int registerCallback(int i10, int i11, IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.backup.backupremoteservice.IRemoteService");
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeStrongInterface(iRemoteServiceCallback);
                    this.f9511a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.backup.backupremoteservice.IRemoteService
            public int unregisterCallback(int i10, IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.backup.backupremoteservice.IRemoteService");
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeStrongInterface(iRemoteServiceCallback);
                    this.f9511a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC2101a() {
            attachInterface(this, "com.huawei.android.backup.backupremoteservice.IRemoteService");
        }

        /* renamed from: a */
        public static IRemoteService m12576a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.backup.backupremoteservice.IRemoteService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteService)) ? new a(iBinder) : (IRemoteService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.android.backup.backupremoteservice.IRemoteService");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.android.backup.backupremoteservice.IRemoteService");
                return true;
            }
            switch (i10) {
                case 1:
                    int iRegisterCallback = registerCallback(parcel.readInt(), parcel.readInt(), IRemoteServiceCallback.AbstractBinderC2103a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRegisterCallback);
                    return true;
                case 2:
                    int iUnregisterCallback = unregisterCallback(parcel.readInt(), IRemoteServiceCallback.AbstractBinderC2103a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iUnregisterCallback);
                    return true;
                case 3:
                    int iAbortDoing = abortDoing(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iAbortDoing);
                    return true;
                case 4:
                    int iDoBackup = doBackup(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), (Bundle) C2102b.m12579c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iDoBackup);
                    return true;
                case 5:
                    int iDoBackupOneModule = doBackupOneModule(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), (Bundle) C2102b.m12579c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iDoBackupOneModule);
                    return true;
                case 6:
                    int iDoRestore = doRestore(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.createStringArray(), (Bundle) C2102b.m12579c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iDoRestore);
                    return true;
                case 7:
                    int iDoRestoreOneModule = doRestoreOneModule(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), (Bundle) C2102b.m12579c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iDoRestoreOneModule);
                    return true;
                case 8:
                    int backupModuleInfo = getBackupModuleInfo(parcel.readInt(), parcel.createStringArray(), (Bundle) C2102b.m12579c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(backupModuleInfo);
                    return true;
                case 9:
                    int appsSize = getAppsSize(parcel.readInt(), parcel.createStringArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(appsSize);
                    return true;
                case 10:
                    int newDeviceInfo = getNewDeviceInfo(parcel.readInt(), (Bundle) C2102b.m12579c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(newDeviceInfo);
                    return true;
                case 11:
                    int iCheckAppRiskInfo = checkAppRiskInfo(parcel.readInt(), (Bundle) C2102b.m12579c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iCheckAppRiskInfo);
                    return true;
                case 12:
                    startPreloadModuleInfo(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    stopPreloadModuleInfo();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    stopLoadModuleData();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    /* renamed from: com.huawei.android.backup.backupremoteservice.IRemoteService$b */
    public static class C2102b {
        /* renamed from: c */
        public static <T> T m12579c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* renamed from: d */
        public static <T extends Parcelable> void m12580d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    int abortDoing(int i10) throws RemoteException;

    int checkAppRiskInfo(int i10, Bundle bundle) throws RemoteException;

    int doBackup(int i10, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException;

    int doBackupOneModule(int i10, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    int doRestore(int i10, String str, String str2, String[] strArr, Bundle bundle) throws RemoteException;

    int doRestoreOneModule(int i10, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    int getAppsSize(int i10, String[] strArr) throws RemoteException;

    int getBackupModuleInfo(int i10, String[] strArr, Bundle bundle) throws RemoteException;

    int getNewDeviceInfo(int i10, Bundle bundle) throws RemoteException;

    int registerCallback(int i10, int i11, IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException;

    void startPreloadModuleInfo(int i10) throws RemoteException;

    void stopLoadModuleData() throws RemoteException;

    void stopPreloadModuleInfo() throws RemoteException;

    int unregisterCallback(int i10, IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException;
}
