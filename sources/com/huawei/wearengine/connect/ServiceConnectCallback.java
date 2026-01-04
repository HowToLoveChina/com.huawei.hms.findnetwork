package com.huawei.wearengine.connect;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes9.dex */
public interface ServiceConnectCallback extends IInterface {

    /* renamed from: com.huawei.wearengine.connect.ServiceConnectCallback$a */
    public static abstract class AbstractBinderC8886a extends Binder implements ServiceConnectCallback {
        public AbstractBinderC8886a() {
            attachInterface(this, "com.huawei.wearengine.connect.ServiceConnectCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* renamed from: g */
        public abstract /* synthetic */ void mo56500g();

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.wearengine.connect.ServiceConnectCallback");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.wearengine.connect.ServiceConnectCallback");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            mo56500g();
            parcel2.writeNoException();
            return true;
        }
    }
}
