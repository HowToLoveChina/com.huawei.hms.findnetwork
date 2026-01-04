package com.huawei.common.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* loaded from: classes5.dex */
public interface IDecisionCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.common.service.IDecisionCallback";

    public static class Default implements IDecisionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.common.service.IDecisionCallback
        public void onResult(Map map) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDecisionCallback {
        static final int TRANSACTION_onResult = 1;

        public static class Proxy implements IDecisionCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDecisionCallback.DESCRIPTOR;
            }

            @Override // com.huawei.common.service.IDecisionCallback
            public void onResult(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDecisionCallback.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDecisionCallback.DESCRIPTOR);
        }

        public static IDecisionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDecisionCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDecisionCallback)) ? new Proxy(iBinder) : (IDecisionCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IDecisionCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IDecisionCallback.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            onResult(parcel.readHashMap(getClass().getClassLoader()));
            parcel2.writeNoException();
            return true;
        }
    }

    void onResult(Map map) throws RemoteException;
}
