package com.huawei.airlink;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.airlink.IAirLinkAidlCallBack;

/* loaded from: classes.dex */
public interface IAirLinkAidlInterface extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.airlink.IAirLinkAidlInterface";

    public static class Default implements IAirLinkAidlInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.airlink.IAirLinkAidlInterface
        public void commonOperation(String str, Bundle bundle) throws RemoteException {
        }

        @Override // com.huawei.airlink.IAirLinkAidlInterface
        public boolean registerCallback(IAirLinkAidlCallBack iAirLinkAidlCallBack) throws RemoteException {
            return false;
        }

        @Override // com.huawei.airlink.IAirLinkAidlInterface
        public boolean unRegisterCallback() throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IAirLinkAidlInterface {
        static final int TRANSACTION_commonOperation = 3;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unRegisterCallback = 2;

        public static class Proxy implements IAirLinkAidlInterface {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.airlink.IAirLinkAidlInterface
            public void commonOperation(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAirLinkAidlInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAirLinkAidlInterface.DESCRIPTOR;
            }

            @Override // com.huawei.airlink.IAirLinkAidlInterface
            public boolean registerCallback(IAirLinkAidlCallBack iAirLinkAidlCallBack) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAirLinkAidlInterface.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iAirLinkAidlCallBack);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.airlink.IAirLinkAidlInterface
            public boolean unRegisterCallback() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAirLinkAidlInterface.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAirLinkAidlInterface.DESCRIPTOR);
        }

        public static IAirLinkAidlInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAirLinkAidlInterface.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAirLinkAidlInterface)) ? new Proxy(iBinder) : (IAirLinkAidlInterface) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAirLinkAidlInterface.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAirLinkAidlInterface.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                boolean zRegisterCallback = registerCallback(IAirLinkAidlCallBack.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(zRegisterCallback ? 1 : 0);
            } else if (i10 == 2) {
                boolean zUnRegisterCallback = unRegisterCallback();
                parcel2.writeNoException();
                parcel2.writeInt(zUnRegisterCallback ? 1 : 0);
            } else {
                if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                commonOperation(parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
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

    void commonOperation(String str, Bundle bundle) throws RemoteException;

    boolean registerCallback(IAirLinkAidlCallBack iAirLinkAidlCallBack) throws RemoteException;

    boolean unRegisterCallback() throws RemoteException;
}
