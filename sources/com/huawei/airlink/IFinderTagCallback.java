package com.huawei.airlink;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IFinderTagCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.airlink.IFinderTagCallback";

    public static class Default implements IFinderTagCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.airlink.IFinderTagCallback
        public void onTagBindResult(String str, int i10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFinderTagCallback {
        static final int TRANSACTION_onTagBindResult = 1;

        public static class Proxy implements IFinderTagCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IFinderTagCallback.DESCRIPTOR;
            }

            @Override // com.huawei.airlink.IFinderTagCallback
            public void onTagBindResult(String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IFinderTagCallback.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IFinderTagCallback.DESCRIPTOR);
        }

        public static IFinderTagCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IFinderTagCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IFinderTagCallback)) ? new Proxy(iBinder) : (IFinderTagCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IFinderTagCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IFinderTagCallback.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            onTagBindResult(parcel.readString(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onTagBindResult(String str, int i10) throws RemoteException;
}
