package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.videokit.player.internal.InterfaceC6571f;

/* renamed from: com.huawei.hms.videokit.player.internal.l */
/* loaded from: classes8.dex */
public interface InterfaceC6577l extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.l$a */
    public static abstract class a extends Binder implements InterfaceC6577l {
        public a() {
            attachInterface(this, "com.huawei.hms.videokit.player.internal.ISubtitleUpdateListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.videokit.player.internal.ISubtitleUpdateListener");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface("com.huawei.hms.videokit.player.internal.ISubtitleUpdateListener");
            mo37425a(InterfaceC6571f.a.m37411a(parcel.readStrongBinder()), (SubtitleInfo[]) parcel.createTypedArray(SubtitleInfo.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo37425a(InterfaceC6571f interfaceC6571f, SubtitleInfo[] subtitleInfoArr) throws RemoteException;
}
