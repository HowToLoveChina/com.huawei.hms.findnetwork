package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes9.dex */
public interface ClientToken extends IInterface {

    /* renamed from: com.huawei.wearengine.ClientToken$a */
    public static abstract class AbstractBinderC8876a extends Binder implements ClientToken {
        public AbstractBinderC8876a() {
            attachInterface(this, "com.huawei.wearengine.ClientToken");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString("com.huawei.wearengine.ClientToken");
            return true;
        }
    }
}
