package com.huawei.wearengine.p2p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes9.dex */
public interface P2pPingCallback extends IInterface {

    /* renamed from: com.huawei.wearengine.p2p.P2pPingCallback$a */
    public static abstract class AbstractBinderC8899a extends Binder implements P2pPingCallback {
        public AbstractBinderC8899a() {
            attachInterface(this, "com.huawei.wearengine.p2p.P2pPingCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* renamed from: f */
        public abstract /* synthetic */ void mo56582f(int i10);

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.wearengine.p2p.P2pPingCallback");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.wearengine.p2p.P2pPingCallback");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            mo56582f(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }
}
