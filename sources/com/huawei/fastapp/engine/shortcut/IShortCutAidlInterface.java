package com.huawei.fastapp.engine.shortcut;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.fastapp.engine.shortcut.IShortCutAidlCallback;

/* loaded from: classes5.dex */
public interface IShortCutAidlInterface extends IInterface {

    public static class Default implements IShortCutAidlInterface {
        @Override // com.huawei.fastapp.engine.shortcut.IShortCutAidlInterface
        /* renamed from: a */
        public void mo28718a(String str, String str2, String str3, IShortCutAidlCallback iShortCutAidlCallback) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IShortCutAidlInterface {

        public static class Proxy implements IShortCutAidlInterface {

            /* renamed from: b */
            public static IShortCutAidlInterface f21589b;

            /* renamed from: a */
            public IBinder f21590a;

            public Proxy(IBinder iBinder) {
                this.f21590a = iBinder;
            }

            @Override // com.huawei.fastapp.engine.shortcut.IShortCutAidlInterface
            /* renamed from: a */
            public void mo28718a(String str, String str2, String str3, IShortCutAidlCallback iShortCutAidlCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.fastapp.engine.shortcut.IShortCutAidlInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iShortCutAidlCallback != null ? iShortCutAidlCallback.asBinder() : null);
                    if (this.f21590a.transact(1, parcelObtain, parcelObtain2, 0) || Stub.m28719g() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.m28719g().mo28718a(str, str2, str3, iShortCutAidlCallback);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21590a;
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.fastapp.engine.shortcut.IShortCutAidlInterface");
        }

        /* renamed from: g */
        public static IShortCutAidlInterface m28719g() {
            return Proxy.f21589b;
        }

        /* renamed from: h */
        public static IShortCutAidlInterface m28720h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.fastapp.engine.shortcut.IShortCutAidlInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IShortCutAidlInterface)) ? new Proxy(iBinder) : (IShortCutAidlInterface) iInterfaceQueryLocalInterface;
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
                parcel2.writeString("com.huawei.fastapp.engine.shortcut.IShortCutAidlInterface");
                return true;
            }
            parcel.enforceInterface("com.huawei.fastapp.engine.shortcut.IShortCutAidlInterface");
            mo28718a(parcel.readString(), parcel.readString(), parcel.readString(), IShortCutAidlCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo28718a(String str, String str2, String str3, IShortCutAidlCallback iShortCutAidlCallback) throws RemoteException;
}
