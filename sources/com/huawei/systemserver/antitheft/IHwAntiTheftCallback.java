package com.huawei.systemserver.antitheft;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public interface IHwAntiTheftCallback extends IInterface {

    /* renamed from: com.huawei.systemserver.antitheft.IHwAntiTheftCallback$a */
    public static abstract class AbstractBinderC8691a extends Binder implements IHwAntiTheftCallback {

        /* renamed from: com.huawei.systemserver.antitheft.IHwAntiTheftCallback$a$a */
        public static class a implements IHwAntiTheftCallback {

            /* renamed from: a */
            public IBinder f40681a;

            public a(IBinder iBinder) {
                this.f40681a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f40681a;
            }

            @Override // com.huawei.systemserver.antitheft.IHwAntiTheftCallback
            public int onTokenRequested(String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.systemserver.antitheft.IHwAntiTheftCallback");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.f40681a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static IHwAntiTheftCallback m53597a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.systemserver.antitheft.IHwAntiTheftCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IHwAntiTheftCallback)) ? new a(iBinder) : (IHwAntiTheftCallback) iInterfaceQueryLocalInterface;
        }
    }

    int onTokenRequested(String str, int i10) throws RemoteException;
}
