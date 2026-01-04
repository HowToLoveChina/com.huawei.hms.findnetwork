package com.huawei.wearengine.p2p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes9.dex */
public interface P2pSendCallback extends IInterface {

    /* renamed from: com.huawei.wearengine.p2p.P2pSendCallback$a */
    public static abstract class AbstractBinderC8900a extends Binder implements P2pSendCallback {
        public AbstractBinderC8900a() {
            attachInterface(this, "com.huawei.wearengine.p2p.P2pSendCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* renamed from: e */
        public abstract /* synthetic */ void mo56583e(String str);

        /* renamed from: f */
        public abstract /* synthetic */ void mo56584f(long j10);

        /* renamed from: g */
        public abstract /* synthetic */ void mo56585g(int i10);

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.wearengine.p2p.P2pSendCallback");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.wearengine.p2p.P2pSendCallback");
                return true;
            }
            if (i10 == 1) {
                mo56585g(parcel.readInt());
            } else if (i10 == 2) {
                mo56584f(parcel.readLong());
            } else {
                if (i10 != 3) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                mo56583e(parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
