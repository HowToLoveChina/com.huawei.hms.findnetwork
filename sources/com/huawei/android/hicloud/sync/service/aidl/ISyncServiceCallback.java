package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface ISyncServiceCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.android.hicloud.sync.service.aidl.ISyncServiceCallback";

    public static class Default implements ISyncServiceCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncServiceCallback
        public void handlerEventMsg(int i10, int i11, int i12, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISyncServiceCallback {
        static final int TRANSACTION_handlerEventMsg = 1;

        public static class Proxy implements ISyncServiceCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISyncServiceCallback.DESCRIPTOR;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncServiceCallback
            public void handlerEventMsg(int i10, int i11, int i12, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncServiceCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISyncServiceCallback.DESCRIPTOR);
        }

        public static ISyncServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISyncServiceCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISyncServiceCallback)) ? new Proxy(iBinder) : (ISyncServiceCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ISyncServiceCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ISyncServiceCallback.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            handlerEventMsg(parcel.readInt(), parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
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

    void handlerEventMsg(int i10, int i11, int i12, Bundle bundle) throws RemoteException;
}
