package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface ICSRemoteService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService";

    public static class Default implements ICSRemoteService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService
        public void doAbort() throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService
        public void doSyncContact(SyncType syncType) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService
        public void doSyncWlan(SyncType syncType) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICSRemoteService {
        static final int TRANSACTION_doAbort = 3;
        static final int TRANSACTION_doSyncContact = 1;
        static final int TRANSACTION_doSyncWlan = 2;

        public static class Proxy implements ICSRemoteService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService
            public void doAbort() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICSRemoteService.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService
            public void doSyncContact(SyncType syncType) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICSRemoteService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, syncType, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService
            public void doSyncWlan(SyncType syncType) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICSRemoteService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, syncType, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ICSRemoteService.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, ICSRemoteService.DESCRIPTOR);
        }

        public static ICSRemoteService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICSRemoteService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICSRemoteService)) ? new Proxy(iBinder) : (ICSRemoteService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ICSRemoteService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ICSRemoteService.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                doSyncContact((SyncType) _Parcel.readTypedObject(parcel, SyncType.CREATOR));
                parcel2.writeNoException();
            } else if (i10 == 2) {
                doSyncWlan((SyncType) _Parcel.readTypedObject(parcel, SyncType.CREATOR));
                parcel2.writeNoException();
            } else {
                if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                doAbort();
                parcel2.writeNoException();
            }
            return true;
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void doAbort() throws RemoteException;

    void doSyncContact(SyncType syncType) throws RemoteException;

    void doSyncWlan(SyncType syncType) throws RemoteException;
}
