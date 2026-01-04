package com.huawei.appmarket.framework.coreservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.huawei.appmarket.framework.coreservice.a */
/* loaded from: classes4.dex */
public interface InterfaceC4584a extends IInterface {

    /* renamed from: com.huawei.appmarket.framework.coreservice.a$a */
    public static abstract class a extends Binder implements InterfaceC4584a {

        /* renamed from: com.huawei.appmarket.framework.coreservice.a$a$a, reason: collision with other inner class name */
        public static class C14427a implements InterfaceC4584a {

            /* renamed from: b */
            public static InterfaceC4584a f21097b;

            /* renamed from: a */
            public IBinder f21098a;

            public C14427a(IBinder iBinder) {
                this.f21098a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21098a;
            }

            @Override // com.huawei.appmarket.framework.coreservice.InterfaceC4584a
            public void call(Status status) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
                    if (status != null) {
                        parcelObtain.writeInt(1);
                        status.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f21098a.transact(1, parcelObtain, parcelObtain2, 0) || a.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.getDefaultImpl().call(status);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }
        }

        public a() {
            attachInterface(this, "com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
        }

        public static InterfaceC4584a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC4584a)) ? new C14427a(iBinder) : (InterfaceC4584a) iInterfaceQueryLocalInterface;
        }

        public static InterfaceC4584a getDefaultImpl() {
            return C14427a.f21097b;
        }

        public static boolean setDefaultImpl(InterfaceC4584a interfaceC4584a) {
            if (C14427a.f21097b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (interfaceC4584a == null) {
                return false;
            }
            C14427a.f21097b = interfaceC4584a;
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
                parcel2.writeString("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
                return true;
            }
            parcel.enforceInterface("com.huawei.appmarket.framework.coreservice.IAppGalleryCallback");
            call(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void call(Status status) throws RemoteException;
}
