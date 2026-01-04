package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.videokit.player.internal.InterfaceC6571f;

/* renamed from: com.huawei.hms.videokit.player.internal.a */
/* loaded from: classes8.dex */
public interface InterfaceC6566a extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.a$a */
    public static abstract class a extends Binder implements InterfaceC6566a {
        public a() {
            attachInterface(this, "com.huawei.hms.videokit.player.internal.IErrorListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.videokit.player.internal.IErrorListener");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface("com.huawei.hms.videokit.player.internal.IErrorListener");
            boolean zMo37404a = mo37404a(InterfaceC6571f.a.m37411a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(zMo37404a ? 1 : 0);
            return true;
        }
    }

    /* renamed from: a */
    boolean mo37404a(InterfaceC6571f interfaceC6571f, int i10, int i11, String str) throws RemoteException;
}
