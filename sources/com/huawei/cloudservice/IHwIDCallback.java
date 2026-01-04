package com.huawei.cloudservice;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public interface IHwIDCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.cloudservice.IHwIDCallback";

    public static class Default implements IHwIDCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.cloudservice.IHwIDCallback
        public void getIntentResult(int i10, Intent intent) throws RemoteException {
        }

        @Override // com.huawei.cloudservice.IHwIDCallback
        public void getQrContentResult(int i10, String str) throws RemoteException {
        }

        @Override // com.huawei.cloudservice.IHwIDCallback
        public void getRealNameInfoResult(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // com.huawei.cloudservice.IHwIDCallback
        public void loginResult(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // com.huawei.cloudservice.IHwIDCallback
        public void logoutResult(int i10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IHwIDCallback {
        static final int TRANSACTION_getIntentResult = 2;
        static final int TRANSACTION_getQrContentResult = 5;
        static final int TRANSACTION_getRealNameInfoResult = 4;
        static final int TRANSACTION_loginResult = 1;
        static final int TRANSACTION_logoutResult = 3;

        public static class Proxy implements IHwIDCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.cloudservice.IHwIDCallback
            public void getIntentResult(int i10, Intent intent) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwIDCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    _Parcel.writeTypedObject(parcelObtain, intent, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IHwIDCallback.DESCRIPTOR;
            }

            @Override // com.huawei.cloudservice.IHwIDCallback
            public void getQrContentResult(int i10, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwIDCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.cloudservice.IHwIDCallback
            public void getRealNameInfoResult(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwIDCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.cloudservice.IHwIDCallback
            public void loginResult(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwIDCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.cloudservice.IHwIDCallback
            public void logoutResult(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IHwIDCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IHwIDCallback.DESCRIPTOR);
        }

        public static IHwIDCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IHwIDCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IHwIDCallback)) ? new Proxy(iBinder) : (IHwIDCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IHwIDCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IHwIDCallback.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                loginResult(parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else if (i10 == 2) {
                getIntentResult(parcel.readInt(), (Intent) _Parcel.readTypedObject(parcel, Intent.CREATOR));
                parcel2.writeNoException();
            } else if (i10 == 3) {
                logoutResult(parcel.readInt());
                parcel2.writeNoException();
            } else if (i10 == 4) {
                getRealNameInfoResult(parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else {
                if (i10 != 5) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                getQrContentResult(parcel.readInt(), parcel.readString());
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

    void getIntentResult(int i10, Intent intent) throws RemoteException;

    void getQrContentResult(int i10, String str) throws RemoteException;

    void getRealNameInfoResult(int i10, Bundle bundle) throws RemoteException;

    void loginResult(int i10, Bundle bundle) throws RemoteException;

    void logoutResult(int i10) throws RemoteException;
}
