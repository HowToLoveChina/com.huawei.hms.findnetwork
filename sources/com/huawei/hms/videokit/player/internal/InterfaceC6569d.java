package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.videokit.player.OperationData;

/* renamed from: com.huawei.hms.videokit.player.internal.d */
/* loaded from: classes8.dex */
public interface InterfaceC6569d extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.d$a */
    public static abstract class a extends Binder implements InterfaceC6569d {
        public a() {
            attachInterface(this, "com.huawei.hms.videokit.player.internal.IOMReporter");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.videokit.player.internal.IOMReporter");
                return true;
            }
            if (i10 == 1) {
                parcel.enforceInterface("com.huawei.hms.videokit.player.internal.IOMReporter");
                mo37409b(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel.enforceInterface("com.huawei.hms.videokit.player.internal.IOMReporter");
                mo37408a(parcel.readInt() != 0 ? OperationData.CREATOR.createFromParcel(parcel) : null);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo37408a(OperationData operationData) throws RemoteException;

    /* renamed from: b */
    void mo37409b(IObjectWrapper iObjectWrapper) throws RemoteException;
}
