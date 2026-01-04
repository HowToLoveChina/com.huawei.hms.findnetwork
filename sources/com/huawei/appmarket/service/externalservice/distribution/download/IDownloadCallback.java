package com.huawei.appmarket.service.externalservice.distribution.download;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface IDownloadCallback extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadCallback {
        private static final String DESCRIPTOR = "com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback";
        static final int TRANSACTION_getDownloadRegisterKey = 1;
        static final int TRANSACTION_refreshAppStatus = 2;

        /* renamed from: com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback$Stub$a */
        public static class C4589a implements IDownloadCallback {

            /* renamed from: b */
            public static IDownloadCallback f21108b;

            /* renamed from: a */
            public IBinder f21109a;

            public C4589a(IBinder iBinder) {
                this.f21109a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21109a;
            }

            @Override // com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback
            public String getDownloadRegisterKey() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.f21109a.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = Stub.getDefaultImpl().getDownloadRegisterKey();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.appmarket.service.externalservice.distribution.download.IDownloadCallback
            public void refreshAppStatus(String str, int i10, int i11, int i12) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    if (this.f21109a.transact(2, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().refreshAppStatus(str, i10, i11, i12);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDownloadCallback)) ? new C4589a(iBinder) : (IDownloadCallback) iInterfaceQueryLocalInterface;
        }

        public static IDownloadCallback getDefaultImpl() {
            return C4589a.f21108b;
        }

        public static boolean setDefaultImpl(IDownloadCallback iDownloadCallback) {
            if (C4589a.f21108b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDownloadCallback == null) {
                return false;
            }
            C4589a.f21108b = iDownloadCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                String downloadRegisterKey = getDownloadRegisterKey();
                parcel2.writeNoException();
                parcel2.writeString(downloadRegisterKey);
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            refreshAppStatus(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    String getDownloadRegisterKey() throws RemoteException;

    void refreshAppStatus(String str, int i10, int i11, int i12) throws RemoteException;
}
