package com.huawei.android.hicloud.album.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.android.hicloud.album.service.ICloudAlbumSdkServiceCallback;

/* loaded from: classes2.dex */
public interface ICallbackHelper extends IInterface {

    /* renamed from: com.huawei.android.hicloud.album.service.ICallbackHelper$a */
    public static abstract class AbstractBinderC2408a extends Binder implements ICallbackHelper {

        /* renamed from: com.huawei.android.hicloud.album.service.ICallbackHelper$a$a */
        public static class a implements ICallbackHelper {

            /* renamed from: a */
            public IBinder f11510a;

            public a(IBinder iBinder) {
                this.f11510a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f11510a;
            }

            @Override // com.huawei.android.hicloud.album.service.ICallbackHelper
            public void invokeEvent(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hicloud.album.service.ICallbackHelper");
                    parcelObtain.writeInt(i10);
                    C2409b.m15034d(parcelObtain, bundle, 0);
                    this.f11510a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.album.service.ICallbackHelper
            public boolean registerCallback(ICloudAlbumSdkServiceCallback iCloudAlbumSdkServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hicloud.album.service.ICallbackHelper");
                    parcelObtain.writeStrongInterface(iCloudAlbumSdkServiceCallback);
                    this.f11510a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.album.service.ICallbackHelper
            public void sendMessage(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hicloud.album.service.ICallbackHelper");
                    parcelObtain.writeInt(i10);
                    C2409b.m15034d(parcelObtain, bundle, 0);
                    this.f11510a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.album.service.ICallbackHelper
            public void unregisterCallback(ICloudAlbumSdkServiceCallback iCloudAlbumSdkServiceCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.hicloud.album.service.ICallbackHelper");
                    parcelObtain.writeStrongInterface(iCloudAlbumSdkServiceCallback);
                    this.f11510a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC2408a() {
            attachInterface(this, "com.huawei.android.hicloud.album.service.ICallbackHelper");
        }

        /* renamed from: a */
        public static ICallbackHelper m15030a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.hicloud.album.service.ICallbackHelper");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICallbackHelper)) ? new a(iBinder) : (ICallbackHelper) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.android.hicloud.album.service.ICallbackHelper");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.android.hicloud.album.service.ICallbackHelper");
                return true;
            }
            if (i10 == 1) {
                sendMessage(parcel.readInt(), (Bundle) C2409b.m15033c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else if (i10 == 2) {
                invokeEvent(parcel.readInt(), (Bundle) C2409b.m15033c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else if (i10 == 3) {
                boolean zRegisterCallback = registerCallback(ICloudAlbumSdkServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(zRegisterCallback ? 1 : 0);
            } else {
                if (i10 != 4) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                unregisterCallback(ICloudAlbumSdkServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
            }
            return true;
        }
    }

    /* renamed from: com.huawei.android.hicloud.album.service.ICallbackHelper$b */
    public static class C2409b {
        /* renamed from: c */
        public static <T> T m15033c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* renamed from: d */
        public static <T extends Parcelable> void m15034d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void invokeEvent(int i10, Bundle bundle) throws RemoteException;

    boolean registerCallback(ICloudAlbumSdkServiceCallback iCloudAlbumSdkServiceCallback) throws RemoteException;

    void sendMessage(int i10, Bundle bundle) throws RemoteException;

    void unregisterCallback(ICloudAlbumSdkServiceCallback iCloudAlbumSdkServiceCallback) throws RemoteException;
}
