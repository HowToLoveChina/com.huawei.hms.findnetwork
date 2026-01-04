package com.huawei.android.backup.backupremoteservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.android.backup.backupremoteservice.IRemoteClientCallback;

/* loaded from: classes.dex */
public interface IRemoteServiceCallback extends IInterface {

    /* renamed from: com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback$a */
    public static abstract class AbstractBinderC2103a extends Binder implements IRemoteServiceCallback {
        static final int TRANSACTION_callback = 1;

        /* renamed from: com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback$a$a */
        public static class a implements IRemoteServiceCallback {

            /* renamed from: a */
            public IBinder f9512a;

            public a(IBinder iBinder) {
                this.f9512a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f9512a;
            }

            @Override // com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback
            public void callback(int i10, int i11, int i12, String str, Bundle bundle, IRemoteClientCallback iRemoteClientCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback");
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    parcelObtain.writeString(str);
                    C2104b.m12584d(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iRemoteClientCallback);
                    this.f9512a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC2103a() {
            attachInterface(this, "com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback");
        }

        public static IRemoteServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteServiceCallback)) ? new a(iBinder) : (IRemoteServiceCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            callback(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), (Bundle) C2104b.m12583c(parcel, Bundle.CREATOR), IRemoteClientCallback.AbstractBinderC2100a.m12575a(parcel.readStrongBinder()));
            return true;
        }
    }

    /* renamed from: com.huawei.android.backup.backupremoteservice.IRemoteServiceCallback$b */
    public static class C2104b {
        /* renamed from: c */
        public static <T> T m12583c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* renamed from: d */
        public static <T extends Parcelable> void m12584d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void callback(int i10, int i11, int i12, String str, Bundle bundle, IRemoteClientCallback iRemoteClientCallback) throws RemoteException;
}
