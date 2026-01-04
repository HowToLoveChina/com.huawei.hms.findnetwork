package com.huawei.ohos.localability.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes8.dex */
public interface IInstallerCallback extends IInterface {

    /* renamed from: com.huawei.ohos.localability.base.IInstallerCallback$a */
    public static abstract class AbstractBinderC6841a extends Binder implements IInstallerCallback {
        public AbstractBinderC6841a() {
            attachInterface(this, "StatusReceiver");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 0) {
                parcel.enforceInterface("OHOS.Appexecfwk.IStatusReceiver");
                onFinished(parcel.readInt(), parcel.readString());
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString("StatusReceiver");
            return true;
        }
    }

    void onFinished(int i10, String str);
}
