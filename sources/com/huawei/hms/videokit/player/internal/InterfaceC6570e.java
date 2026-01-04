package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.videokit.player.internal.InterfaceC6571f;

/* renamed from: com.huawei.hms.videokit.player.internal.e */
/* loaded from: classes8.dex */
public interface InterfaceC6570e extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.e$a */
    public static abstract class a extends Binder implements InterfaceC6570e {
        public a() {
            attachInterface(this, "com.huawei.hms.videokit.player.internal.IPlayEndListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.videokit.player.internal.IPlayEndListener");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface("com.huawei.hms.videokit.player.internal.IPlayEndListener");
            mo37410c(InterfaceC6571f.a.m37411a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: c */
    void mo37410c(InterfaceC6571f interfaceC6571f) throws RemoteException;
}
