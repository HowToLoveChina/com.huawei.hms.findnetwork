package com.huawei.android.hicloud.album.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface ICloudAlbumSdkServiceCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.android.hicloud.album.service.ICloudAlbumSdkServiceCallback";

    public static abstract class Stub extends Binder implements ICloudAlbumSdkServiceCallback {
        static final int TRANSACTION_onApplyBatch = 2;
        static final int TRANSACTION_onResult = 1;

        /* renamed from: com.huawei.android.hicloud.album.service.ICloudAlbumSdkServiceCallback$Stub$a */
        public static class C2412a implements ICloudAlbumSdkServiceCallback {

            /* renamed from: a */
            public IBinder f11512a;

            public C2412a(IBinder iBinder) {
                this.f11512a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11512a;
            }

            @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkServiceCallback
            public void onApplyBatch(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICloudAlbumSdkServiceCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    C2413a.m15044d(parcelObtain, bundle, 0);
                    this.f11512a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.album.service.ICloudAlbumSdkServiceCallback
            public void onResult(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICloudAlbumSdkServiceCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    C2413a.m15044d(parcelObtain, bundle, 0);
                    this.f11512a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ICloudAlbumSdkServiceCallback.DESCRIPTOR);
        }

        public static ICloudAlbumSdkServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICloudAlbumSdkServiceCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICloudAlbumSdkServiceCallback)) ? new C2412a(iBinder) : (ICloudAlbumSdkServiceCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ICloudAlbumSdkServiceCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ICloudAlbumSdkServiceCallback.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                onResult(parcel.readInt(), (Bundle) C2413a.m15043c(parcel, Bundle.CREATOR));
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onApplyBatch(parcel.readInt(), (Bundle) C2413a.m15043c(parcel, Bundle.CREATOR));
            }
            return true;
        }
    }

    /* renamed from: com.huawei.android.hicloud.album.service.ICloudAlbumSdkServiceCallback$a */
    public static class C2413a {
        /* renamed from: c */
        public static <T> T m15043c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* renamed from: d */
        public static <T extends Parcelable> void m15044d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void onApplyBatch(int i10, Bundle bundle) throws RemoteException;

    void onResult(int i10, Bundle bundle) throws RemoteException;
}
