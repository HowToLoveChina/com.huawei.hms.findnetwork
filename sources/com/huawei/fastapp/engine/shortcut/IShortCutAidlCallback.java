package com.huawei.fastapp.engine.shortcut;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public interface IShortCutAidlCallback extends IInterface {

    public static class Default implements IShortCutAidlCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.fastapp.engine.shortcut.IShortCutAidlCallback
        public void onCreateShortCut(int i10, String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IShortCutAidlCallback {
        private static final String DESCRIPTOR = "com.huawei.fastapp.engine.shortcut.IShortCutAidlCallback";
        static final int TRANSACTION_onCreateShortCut = 1;

        public static class Proxy implements IShortCutAidlCallback {

            /* renamed from: b */
            public static IShortCutAidlCallback f21587b;

            /* renamed from: a */
            public IBinder f21588a;

            public Proxy(IBinder iBinder) {
                this.f21588a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21588a;
            }

            @Override // com.huawei.fastapp.engine.shortcut.IShortCutAidlCallback
            public void onCreateShortCut(int i10, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    if (this.f21588a.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onCreateShortCut(i10, str);
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

        public static IShortCutAidlCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IShortCutAidlCallback)) ? new Proxy(iBinder) : (IShortCutAidlCallback) iInterfaceQueryLocalInterface;
        }

        public static IShortCutAidlCallback getDefaultImpl() {
            return Proxy.f21587b;
        }

        public static boolean setDefaultImpl(IShortCutAidlCallback iShortCutAidlCallback) {
            if (Proxy.f21587b != null || iShortCutAidlCallback == null) {
                return false;
            }
            Proxy.f21587b = iShortCutAidlCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onCreateShortCut(parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void onCreateShortCut(int i10, String str) throws RemoteException;
}
