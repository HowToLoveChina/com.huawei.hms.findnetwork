package com.huawei.openalliance.p169ad;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.huawei.openalliance.ad.a */
/* loaded from: classes8.dex */
public interface InterfaceC6850a extends IInterface {

    /* renamed from: com.huawei.openalliance.ad.a$a */
    public static abstract class a extends Binder implements InterfaceC6850a {
        public a() {
            attachInterface(this, "com.huawei.appmarket.service.externalservice.activityresult.IActivityResult");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.appmarket.service.externalservice.activityresult.IActivityResult");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface("com.huawei.appmarket.service.externalservice.activityresult.IActivityResult");
            mo38572a(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo38572a(int i10);
}
