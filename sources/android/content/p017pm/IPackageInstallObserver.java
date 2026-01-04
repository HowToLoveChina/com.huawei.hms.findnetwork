package android.content.p017pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPackageInstallObserver extends IInterface {
    public static final String DESCRIPTOR = "android.content.pm.IPackageInstallObserver";

    public static class Default implements IPackageInstallObserver {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.content.p017pm.IPackageInstallObserver
        public void packageInstalled(String str, int i10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IPackageInstallObserver {
        static final int TRANSACTION_packageInstalled = 1;

        public static class Proxy implements IPackageInstallObserver {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPackageInstallObserver.DESCRIPTOR;
            }

            @Override // android.content.p017pm.IPackageInstallObserver
            public void packageInstalled(String str, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IPackageInstallObserver.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IPackageInstallObserver.DESCRIPTOR);
        }

        public static IPackageInstallObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IPackageInstallObserver.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IPackageInstallObserver)) ? new Proxy(iBinder) : (IPackageInstallObserver) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IPackageInstallObserver.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IPackageInstallObserver.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            packageInstalled(parcel.readString(), parcel.readInt());
            return true;
        }
    }

    void packageInstalled(String str, int i10) throws RemoteException;
}
