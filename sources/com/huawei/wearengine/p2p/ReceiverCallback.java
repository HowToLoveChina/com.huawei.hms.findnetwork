package com.huawei.wearengine.p2p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes9.dex */
public interface ReceiverCallback extends IInterface {

    /* renamed from: com.huawei.wearengine.p2p.ReceiverCallback$a */
    public static abstract class AbstractBinderC8901a extends Binder implements ReceiverCallback {
        public AbstractBinderC8901a() {
            attachInterface(this, "com.huawei.wearengine.p2p.ReceiverCallback");
        }

        /* renamed from: a */
        public abstract /* synthetic */ void mo56586a(MessageParcel messageParcel);

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* renamed from: b */
        public abstract /* synthetic */ void mo56587b(byte[] bArr);

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.wearengine.p2p.ReceiverCallback");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.wearengine.p2p.ReceiverCallback");
                return true;
            }
            if (i10 == 1) {
                byte[] bArrCreateByteArray = parcel.createByteArray();
                mo56587b(bArrCreateByteArray);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrCreateByteArray);
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                mo56586a(parcel.readInt() != 0 ? MessageParcel.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
            }
            return true;
        }
    }
}
