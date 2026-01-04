package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.videokit.player.internal.InterfaceC6571f;

/* renamed from: com.huawei.hms.videokit.player.internal.i */
/* loaded from: classes8.dex */
public interface InterfaceC6574i extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.i$a */
    public static abstract class a extends Binder implements InterfaceC6574i {
        public a() {
            attachInterface(this, "com.huawei.hms.videokit.player.internal.IResolutionUpdatedListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.videokit.player.internal.IResolutionUpdatedListener");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface("com.huawei.hms.videokit.player.internal.IResolutionUpdatedListener");
            mo37419a(InterfaceC6571f.a.m37411a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo37419a(InterfaceC6571f interfaceC6571f, int i10, int i11) throws RemoteException;
}
