package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.huawei.hms.videokit.player.internal.n */
/* loaded from: classes8.dex */
public interface InterfaceC6579n extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.n$a */
    public static abstract class a extends Binder implements InterfaceC6579n {
        public a() {
            attachInterface(this, "com.huawei.hms.videokit.player.internal.InitCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.videokit.player.internal.InitCallback");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface("com.huawei.hms.videokit.player.internal.InitCallback");
            mo37131a(parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo37131a(int i10, String str) throws RemoteException;
}
