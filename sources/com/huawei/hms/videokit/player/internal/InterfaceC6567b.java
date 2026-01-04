package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.videokit.player.internal.InterfaceC6571f;

/* renamed from: com.huawei.hms.videokit.player.internal.b */
/* loaded from: classes8.dex */
public interface InterfaceC6567b extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.b$a */
    public static abstract class a extends Binder implements InterfaceC6567b {
        public a() {
            attachInterface(this, "com.huawei.hms.videokit.player.internal.IEventListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.videokit.player.internal.IEventListener");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface("com.huawei.hms.videokit.player.internal.IEventListener");
            boolean zMo37405a = mo37405a(InterfaceC6571f.a.m37411a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? ObjectParameter.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(zMo37405a ? 1 : 0);
            return true;
        }
    }

    /* renamed from: a */
    boolean mo37405a(InterfaceC6571f interfaceC6571f, int i10, int i11, ObjectParameter objectParameter) throws RemoteException;
}
