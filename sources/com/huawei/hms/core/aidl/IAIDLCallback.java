package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes8.dex */
public interface IAIDLCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLCallback";

    public static abstract class Stub extends Binder implements IAIDLCallback {
        static final int TRANSACTION_call = 1;

        /* renamed from: com.huawei.hms.core.aidl.IAIDLCallback$Stub$a */
        public static class C5161a implements IAIDLCallback {

            /* renamed from: a */
            private IBinder f23565a;

            public C5161a(IBinder iBinder) {
                this.f23565a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23565a;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLCallback
            public void call(DataBuffer dataBuffer) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IAIDLCallback.DESCRIPTOR);
                    C5162a.m30765b(parcelObtain, dataBuffer, 0);
                    this.f23565a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAIDLCallback.DESCRIPTOR);
        }

        public static IAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IAIDLCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IAIDLCallback)) ? new C5161a(iBinder) : (IAIDLCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IAIDLCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IAIDLCallback.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            call((DataBuffer) C5162a.m30764b(parcel, DataBuffer.CREATOR));
            return true;
        }
    }

    /* renamed from: com.huawei.hms.core.aidl.IAIDLCallback$a */
    public static class C5162a {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static <T> T m30764b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static <T extends Parcelable> void m30765b(Parcel parcel, T t10, int i10) {
            if (t10 != null) {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    void call(DataBuffer dataBuffer) throws RemoteException;
}
