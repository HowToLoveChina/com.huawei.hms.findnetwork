package com.huawei.hms.feature.dynamic;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

/* loaded from: classes8.dex */
public interface IDynamicInstall extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.feature.dynamic.IDynamicInstall";

    public static class Default implements IDynamicInstall {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.feature.dynamic.IDynamicInstall
        public Bundle install(IObjectWrapper iObjectWrapper, Bundle bundle) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IDynamicInstall {

        /* renamed from: a */
        public static final int f24640a = 1;

        public static class Proxy implements IDynamicInstall {
            public static IDynamicInstall sDefaultImpl;

            /* renamed from: a */
            public IBinder f24641a;

            public Proxy(IBinder iBinder) {
                this.f24641a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24641a;
            }

            public String getInterfaceDescriptor() {
                return IDynamicInstall.DESCRIPTOR;
            }

            @Override // com.huawei.hms.feature.dynamic.IDynamicInstall
            public Bundle install(IObjectWrapper iObjectWrapper, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDynamicInstall.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f24641a.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Bundle bundleInstall = Stub.getDefaultImpl().install(iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return bundleInstall;
                    }
                    parcelObtain2.readException();
                    Bundle bundle2 = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundle2;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }
        }

        public Stub() {
            attachInterface(this, IDynamicInstall.DESCRIPTOR);
        }

        public static IDynamicInstall asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDynamicInstall.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDynamicInstall)) ? new Proxy(iBinder) : (IDynamicInstall) iInterfaceQueryLocalInterface;
        }

        public static IDynamicInstall getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDynamicInstall iDynamicInstall) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDynamicInstall == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDynamicInstall;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(IDynamicInstall.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface(IDynamicInstall.DESCRIPTOR);
            Bundle bundleInstall = install(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            if (bundleInstall != null) {
                parcel2.writeInt(1);
                bundleInstall.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    Bundle install(IObjectWrapper iObjectWrapper, Bundle bundle) throws RemoteException;
}
