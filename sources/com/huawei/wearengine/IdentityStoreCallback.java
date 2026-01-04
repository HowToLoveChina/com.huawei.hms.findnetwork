package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes9.dex */
public interface IdentityStoreCallback extends IInterface {

    /* renamed from: com.huawei.wearengine.IdentityStoreCallback$a */
    public static abstract class AbstractBinderC8878a extends Binder implements IdentityStoreCallback {
        public AbstractBinderC8878a() {
            attachInterface(this, "com.huawei.wearengine.IdentityStoreCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* renamed from: e */
        public abstract /* synthetic */ void mo56494e(String str);

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.wearengine.IdentityStoreCallback");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.wearengine.IdentityStoreCallback");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            mo56494e(parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }
}
