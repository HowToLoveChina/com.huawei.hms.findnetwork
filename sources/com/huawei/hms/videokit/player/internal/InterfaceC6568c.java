package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.videokit.player.internal.InterfaceC6571f;

/* renamed from: com.huawei.hms.videokit.player.internal.c */
/* loaded from: classes8.dex */
public interface InterfaceC6568c extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.c$a */
    public static abstract class a extends Binder implements InterfaceC6568c {
        public a() {
            attachInterface(this, "com.huawei.hms.videokit.player.internal.ILoadingListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.videokit.player.internal.ILoadingListener");
                return true;
            }
            if (i10 == 1) {
                parcel.enforceInterface("com.huawei.hms.videokit.player.internal.ILoadingListener");
                mo37407a(InterfaceC6571f.a.m37411a(parcel.readStrongBinder()), parcel.readInt());
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel.enforceInterface("com.huawei.hms.videokit.player.internal.ILoadingListener");
                mo37406a(InterfaceC6571f.a.m37411a(parcel.readStrongBinder()));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo37406a(InterfaceC6571f interfaceC6571f) throws RemoteException;

    /* renamed from: a */
    void mo37407a(InterfaceC6571f interfaceC6571f, int i10) throws RemoteException;
}
