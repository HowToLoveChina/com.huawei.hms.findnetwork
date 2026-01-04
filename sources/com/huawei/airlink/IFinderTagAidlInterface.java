package com.huawei.airlink;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.airlink.IFinderTagCallback;

/* loaded from: classes.dex */
public interface IFinderTagAidlInterface extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.airlink.IFinderTagAidlInterface";

    public static class Default implements IFinderTagAidlInterface {
        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public void antiStalkingNotify(int i10) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public boolean isSupportAlarm() throws RemoteException {
            return false;
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public void notifyTagBinded(Bundle bundle, IFinderTagCallback iFinderTagCallback) throws RemoteException {
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public void notifyTagStatusChange(String str, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public boolean queryOfflineLocateStatus() throws RemoteException {
            return false;
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public void startAlarm(IFinderTagCallback iFinderTagCallback) throws RemoteException {
        }

        @Override // com.huawei.airlink.IFinderTagAidlInterface
        public void stopAlarm(IFinderTagCallback iFinderTagCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFinderTagAidlInterface {
        static final int TRANSACTION_antiStalkingNotify = 4;
        static final int TRANSACTION_isSupportAlarm = 7;
        static final int TRANSACTION_notifyTagBinded = 2;
        static final int TRANSACTION_notifyTagStatusChange = 3;
        static final int TRANSACTION_queryOfflineLocateStatus = 1;
        static final int TRANSACTION_startAlarm = 5;
        static final int TRANSACTION_stopAlarm = 6;

        public static class Proxy implements IFinderTagAidlInterface {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.huawei.airlink.IFinderTagAidlInterface
            public void antiStalkingNotify(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFinderTagAidlInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IFinderTagAidlInterface.DESCRIPTOR;
            }

            @Override // com.huawei.airlink.IFinderTagAidlInterface
            public boolean isSupportAlarm() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFinderTagAidlInterface.DESCRIPTOR);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.airlink.IFinderTagAidlInterface
            public void notifyTagBinded(Bundle bundle, IFinderTagCallback iFinderTagCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFinderTagAidlInterface.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iFinderTagCallback);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.airlink.IFinderTagAidlInterface
            public void notifyTagStatusChange(String str, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFinderTagAidlInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.airlink.IFinderTagAidlInterface
            public boolean queryOfflineLocateStatus() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFinderTagAidlInterface.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.airlink.IFinderTagAidlInterface
            public void startAlarm(IFinderTagCallback iFinderTagCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFinderTagAidlInterface.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iFinderTagCallback);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.airlink.IFinderTagAidlInterface
            public void stopAlarm(IFinderTagCallback iFinderTagCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFinderTagAidlInterface.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iFinderTagCallback);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IFinderTagAidlInterface.DESCRIPTOR);
        }

        public static IFinderTagAidlInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IFinderTagAidlInterface.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IFinderTagAidlInterface)) ? new Proxy(iBinder) : (IFinderTagAidlInterface) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IFinderTagAidlInterface.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IFinderTagAidlInterface.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    boolean zQueryOfflineLocateStatus = queryOfflineLocateStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(zQueryOfflineLocateStatus ? 1 : 0);
                    return true;
                case 2:
                    notifyTagBinded((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), IFinderTagCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    notifyTagStatusChange(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    antiStalkingNotify(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    startAlarm(IFinderTagCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    stopAlarm(IFinderTagCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    boolean zIsSupportAlarm = isSupportAlarm();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsSupportAlarm ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
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

    void antiStalkingNotify(int i10) throws RemoteException;

    boolean isSupportAlarm() throws RemoteException;

    void notifyTagBinded(Bundle bundle, IFinderTagCallback iFinderTagCallback) throws RemoteException;

    void notifyTagStatusChange(String str, boolean z10) throws RemoteException;

    boolean queryOfflineLocateStatus() throws RemoteException;

    void startAlarm(IFinderTagCallback iFinderTagCallback) throws RemoteException;

    void stopAlarm(IFinderTagCallback iFinderTagCallback) throws RemoteException;
}
