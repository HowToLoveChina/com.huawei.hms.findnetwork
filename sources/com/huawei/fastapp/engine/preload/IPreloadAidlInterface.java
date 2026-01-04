package com.huawei.fastapp.engine.preload;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public interface IPreloadAidlInterface extends IInterface {

    public static class Default implements IPreloadAidlInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.fastapp.engine.preload.IPreloadAidlInterface
        /* renamed from: b */
        public void mo28715b(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IPreloadAidlInterface {

        public static class Proxy implements IPreloadAidlInterface {

            /* renamed from: b */
            public static IPreloadAidlInterface f21585b;

            /* renamed from: a */
            public IBinder f21586a;

            public Proxy(IBinder iBinder) {
                this.f21586a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21586a;
            }

            @Override // com.huawei.fastapp.engine.preload.IPreloadAidlInterface
            /* renamed from: b */
            public void mo28715b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.fastapp.engine.preload.IPreloadAidlInterface");
                    parcelObtain.writeString(str);
                    if (this.f21586a.transact(1, parcelObtain, parcelObtain2, 0) || Stub.m28716g() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.m28716g().mo28715b(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.fastapp.engine.preload.IPreloadAidlInterface");
        }

        /* renamed from: g */
        public static IPreloadAidlInterface m28716g() {
            return Proxy.f21585b;
        }

        /* renamed from: h */
        public static IPreloadAidlInterface m28717h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.fastapp.engine.preload.IPreloadAidlInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPreloadAidlInterface)) ? new Proxy(iBinder) : (IPreloadAidlInterface) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.huawei.fastapp.engine.preload.IPreloadAidlInterface");
                return true;
            }
            parcel.enforceInterface("com.huawei.fastapp.engine.preload.IPreloadAidlInterface");
            mo28715b(parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: b */
    void mo28715b(String str) throws RemoteException;
}
