package com.huawei.remoteLoader.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes5.dex */
public abstract class ARBaseStub extends Binder implements IInterface {
    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public boolean routeToSuperOrEnforceInterface(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 > 16777215) {
            return super.onTransact(i10, parcel, parcel2, i11);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }
}
