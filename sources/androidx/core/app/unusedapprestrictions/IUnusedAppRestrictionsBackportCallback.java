package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IUnusedAppRestrictionsBackportCallback extends IInterface {

    /* renamed from: androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback$a */
    public static abstract class AbstractBinderC0612a extends Binder implements IUnusedAppRestrictionsBackportCallback {
        static final int TRANSACTION_onIsPermissionRevocationEnabledForAppResult = 1;

        /* renamed from: androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback$a$a */
        public static class a implements IUnusedAppRestrictionsBackportCallback {

            /* renamed from: a */
            public IBinder f3409a;

            public a(IBinder iBinder) {
                this.f3409a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3409a;
            }

            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void onIsPermissionRevocationEnabledForAppResult(boolean z10, boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.f3409a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0612a() {
            attachInterface(this, "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
        }

        public static IUnusedAppRestrictionsBackportCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IUnusedAppRestrictionsBackportCallback)) ? new a(iBinder) : (IUnusedAppRestrictionsBackportCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            onIsPermissionRevocationEnabledForAppResult(parcel.readInt() != 0, parcel.readInt() != 0);
            return true;
        }
    }

    void onIsPermissionRevocationEnabledForAppResult(boolean z10, boolean z11) throws RemoteException;
}
