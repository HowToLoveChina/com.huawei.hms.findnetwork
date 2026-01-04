package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface ICDRemoteService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService";

    public static class Default implements ICDRemoteService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void doAbort(int i10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void doBackupCalllog() throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void doBackupPhoneManager() throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void doBackupRecording() throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void doBackupSms() throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void processBattery(int i10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICDRemoteService {
        static final int TRANSACTION_doAbort = 5;
        static final int TRANSACTION_doBackupCalllog = 1;
        static final int TRANSACTION_doBackupPhoneManager = 4;
        static final int TRANSACTION_doBackupRecording = 3;
        static final int TRANSACTION_doBackupSms = 2;
        static final int TRANSACTION_processBattery = 6;

        public static class Proxy implements ICDRemoteService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
            public void doAbort(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICDRemoteService.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
            public void doBackupCalllog() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICDRemoteService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
            public void doBackupPhoneManager() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICDRemoteService.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
            public void doBackupRecording() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICDRemoteService.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
            public void doBackupSms() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICDRemoteService.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ICDRemoteService.DESCRIPTOR;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
            public void processBattery(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICDRemoteService.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ICDRemoteService.DESCRIPTOR);
        }

        public static ICDRemoteService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICDRemoteService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICDRemoteService)) ? new Proxy(iBinder) : (ICDRemoteService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ICDRemoteService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ICDRemoteService.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    doBackupCalllog();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    doBackupSms();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    doBackupRecording();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    doBackupPhoneManager();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    doAbort(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    processBattery(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void doAbort(int i10) throws RemoteException;

    void doBackupCalllog() throws RemoteException;

    void doBackupPhoneManager() throws RemoteException;

    void doBackupRecording() throws RemoteException;

    void doBackupSms() throws RemoteException;

    void processBattery(int i10) throws RemoteException;
}
