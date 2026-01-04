package com.huawei.airlink;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAirLinkAidlCallBack extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.airlink.IAirLinkAidlCallBack";

    public static class Default implements IAirLinkAidlCallBack {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.airlink.IAirLinkAidlCallBack
        public void onEventReceived(String str, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAirLinkAidlCallBack {
        static final int TRANSACTION_onEventReceived = 1;

        public static class Proxy implements IAirLinkAidlCallBack {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAirLinkAidlCallBack.DESCRIPTOR;
            }

            @Override // com.huawei.airlink.IAirLinkAidlCallBack
            public void onEventReceived(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAirLinkAidlCallBack.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAirLinkAidlCallBack.DESCRIPTOR);
        }

        public static IAirLinkAidlCallBack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAirLinkAidlCallBack.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAirLinkAidlCallBack)) ? new Proxy(iBinder) : (IAirLinkAidlCallBack) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAirLinkAidlCallBack.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAirLinkAidlCallBack.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            onEventReceived(parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
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

    void onEventReceived(String str, Bundle bundle) throws RemoteException;
}
