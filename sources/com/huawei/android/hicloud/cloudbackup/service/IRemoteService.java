package com.huawei.android.hicloud.cloudbackup.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface IRemoteService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.android.hicloud.cloudbackup.service.IRemoteService";

    public static class Default implements IRemoteService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void callNotifyServer(String str) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doAbort(int i10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doBackup() throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doBackupNotify() throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doGetBackupOptions() throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public boolean doNewBackup(String str) throws RemoteException {
            return false;
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doNewBackupNotify(long j10, long j11) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doPause() throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
        public void doRestore(int i10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRemoteService {
        static final int TRANSACTION_callNotifyServer = 9;
        static final int TRANSACTION_doAbort = 5;
        static final int TRANSACTION_doBackup = 1;
        static final int TRANSACTION_doBackupNotify = 3;
        static final int TRANSACTION_doGetBackupOptions = 8;
        static final int TRANSACTION_doNewBackup = 2;
        static final int TRANSACTION_doNewBackupNotify = 4;
        static final int TRANSACTION_doPause = 7;
        static final int TRANSACTION_doRestore = 6;

        public static class Proxy implements IRemoteService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
            public void callNotifyServer(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
            public void doAbort(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteService.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
            public void doBackup() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
            public void doBackupNotify() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteService.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
            public void doGetBackupOptions() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteService.DESCRIPTOR);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
            public boolean doNewBackup(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
            public void doNewBackupNotify(long j10, long j11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteService.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeLong(j11);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
            public void doPause() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteService.DESCRIPTOR);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.cloudbackup.service.IRemoteService
            public void doRestore(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteService.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IRemoteService.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IRemoteService.DESCRIPTOR);
        }

        public static IRemoteService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteService)) ? new Proxy(iBinder) : (IRemoteService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IRemoteService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IRemoteService.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    doBackup();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    boolean zDoNewBackup = doNewBackup(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDoNewBackup ? 1 : 0);
                    return true;
                case 3:
                    doBackupNotify();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    doNewBackupNotify(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    doAbort(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    doRestore(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    doPause();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    doGetBackupOptions();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    callNotifyServer(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void callNotifyServer(String str) throws RemoteException;

    void doAbort(int i10) throws RemoteException;

    void doBackup() throws RemoteException;

    void doBackupNotify() throws RemoteException;

    void doGetBackupOptions() throws RemoteException;

    boolean doNewBackup(String str) throws RemoteException;

    void doNewBackupNotify(long j10, long j11) throws RemoteException;

    void doPause() throws RemoteException;

    void doRestore(int i10) throws RemoteException;
}
