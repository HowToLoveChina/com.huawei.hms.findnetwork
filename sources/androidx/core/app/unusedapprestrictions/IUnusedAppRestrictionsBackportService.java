package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* loaded from: classes.dex */
public interface IUnusedAppRestrictionsBackportService extends IInterface {

    /* renamed from: androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService$a */
    public static abstract class AbstractBinderC0613a extends Binder implements IUnusedAppRestrictionsBackportService {
        static final int TRANSACTION_isPermissionRevocationEnabledForApp = 1;

        /* renamed from: androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService$a$a */
        public static class a implements IUnusedAppRestrictionsBackportService {

            /* renamed from: a */
            public IBinder f3410a;

            public a(IBinder iBinder) {
                this.f3410a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3410a;
            }

            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
            public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
                    parcelObtain.writeStrongInterface(iUnusedAppRestrictionsBackportCallback);
                    this.f3410a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0613a() {
            attachInterface(this, "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
        }

        public static IUnusedAppRestrictionsBackportService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IUnusedAppRestrictionsBackportService)) ? new a(iBinder) : (IUnusedAppRestrictionsBackportService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback.AbstractBinderC0612a.asInterface(parcel.readStrongBinder()));
            return true;
        }
    }

    void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException;
}
