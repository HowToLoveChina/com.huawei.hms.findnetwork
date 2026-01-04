package com.huawei.hicloud.cloudbackup.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes6.dex */
public interface ICoreCallback extends IInterface {

    /* renamed from: com.huawei.hicloud.cloudbackup.service.ICoreCallback$a */
    public static abstract class AbstractBinderC4874a extends Binder implements ICoreCallback {

        /* renamed from: com.huawei.hicloud.cloudbackup.service.ICoreCallback$a$a */
        public static class a implements ICoreCallback {

            /* renamed from: a */
            public IBinder f22298a;

            public a(IBinder iBinder) {
                this.f22298a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f22298a;
            }

            @Override // com.huawei.hicloud.cloudbackup.service.ICoreCallback
            public void callback(int i10, int i11, int i12, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hicloud.cloudbackup.service.ICoreCallback");
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    C4875b.m29272d(parcelObtain, bundle, 0);
                    this.f22298a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC4874a() {
            attachInterface(this, "com.huawei.hicloud.cloudbackup.service.ICoreCallback");
        }

        /* renamed from: a */
        public static ICoreCallback m29268a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hicloud.cloudbackup.service.ICoreCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICoreCallback)) ? new a(iBinder) : (ICoreCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.hicloud.cloudbackup.service.ICoreCallback");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hicloud.cloudbackup.service.ICoreCallback");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            callback(parcel.readInt(), parcel.readInt(), parcel.readInt(), (Bundle) C4875b.m29271c(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: com.huawei.hicloud.cloudbackup.service.ICoreCallback$b */
    public static class C4875b {
        /* renamed from: c */
        public static <T> T m29271c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* renamed from: d */
        public static <T extends Parcelable> void m29272d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void callback(int i10, int i11, int i12, Bundle bundle) throws RemoteException;
}
