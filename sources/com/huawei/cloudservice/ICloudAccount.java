package com.huawei.cloudservice;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.cloudservice.IHwIDCallback;

/* loaded from: classes5.dex */
public interface ICloudAccount extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.cloudservice.ICloudAccount";

    public static class Default implements ICloudAccount {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.cloudservice.ICloudAccount
        public void getIntent(String str, String str2, String str3, IHwIDCallback iHwIDCallback) throws RemoteException {
        }

        @Override // com.huawei.cloudservice.ICloudAccount
        public void getRealNameInfo(String str, String str2, Bundle bundle, IHwIDCallback iHwIDCallback) throws RemoteException {
        }

        @Override // com.huawei.cloudservice.ICloudAccount
        public void login(String str, Bundle bundle, IHwIDCallback iHwIDCallback) throws RemoteException {
        }

        @Override // com.huawei.cloudservice.ICloudAccount
        public void logout(String str, String str2, Bundle bundle, IHwIDCallback iHwIDCallback) throws RemoteException {
        }

        @Override // com.huawei.cloudservice.ICloudAccount
        public void setLogoutEnable(String str, boolean z10, IHwIDCallback iHwIDCallback) throws RemoteException {
        }

        @Override // com.huawei.cloudservice.ICloudAccount
        public int setLogoutIntent(Intent intent, int i10) throws RemoteException {
            return 0;
        }

        @Override // com.huawei.cloudservice.ICloudAccount
        public int setLogoutIntent2(Intent intent, int i10, int i11) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ICloudAccount {
        static final int TRANSACTION_getIntent = 3;
        static final int TRANSACTION_getRealNameInfo = 5;
        static final int TRANSACTION_login = 1;
        static final int TRANSACTION_logout = 4;
        static final int TRANSACTION_setLogoutEnable = 7;
        static final int TRANSACTION_setLogoutIntent = 2;
        static final int TRANSACTION_setLogoutIntent2 = 6;

        public static class Proxy implements ICloudAccount {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.cloudservice.ICloudAccount
            public void getIntent(String str, String str2, String str3, IHwIDCallback iHwIDCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICloudAccount.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongInterface(iHwIDCallback);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ICloudAccount.DESCRIPTOR;
            }

            @Override // com.huawei.cloudservice.ICloudAccount
            public void getRealNameInfo(String str, String str2, Bundle bundle, IHwIDCallback iHwIDCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICloudAccount.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iHwIDCallback);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.cloudservice.ICloudAccount
            public void login(String str, Bundle bundle, IHwIDCallback iHwIDCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICloudAccount.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iHwIDCallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.cloudservice.ICloudAccount
            public void logout(String str, String str2, Bundle bundle, IHwIDCallback iHwIDCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICloudAccount.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeStrongInterface(iHwIDCallback);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.cloudservice.ICloudAccount
            public void setLogoutEnable(String str, boolean z10, IHwIDCallback iHwIDCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICloudAccount.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeStrongInterface(iHwIDCallback);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.cloudservice.ICloudAccount
            public int setLogoutIntent(Intent intent, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICloudAccount.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, intent, 0);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.cloudservice.ICloudAccount
            public int setLogoutIntent2(Intent intent, int i10, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ICloudAccount.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, intent, 0);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ICloudAccount.DESCRIPTOR);
        }

        public static ICloudAccount asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ICloudAccount.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ICloudAccount)) ? new Proxy(iBinder) : (ICloudAccount) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ICloudAccount.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ICloudAccount.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    login(parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), IHwIDCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    int logoutIntent = setLogoutIntent((Intent) _Parcel.readTypedObject(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(logoutIntent);
                    return true;
                case 3:
                    getIntent(parcel.readString(), parcel.readString(), parcel.readString(), IHwIDCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    logout(parcel.readString(), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), IHwIDCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    getRealNameInfo(parcel.readString(), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), IHwIDCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    int logoutIntent2 = setLogoutIntent2((Intent) _Parcel.readTypedObject(parcel, Intent.CREATOR), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(logoutIntent2);
                    return true;
                case 7:
                    setLogoutEnable(parcel.readString(), parcel.readInt() != 0, IHwIDCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void getIntent(String str, String str2, String str3, IHwIDCallback iHwIDCallback) throws RemoteException;

    void getRealNameInfo(String str, String str2, Bundle bundle, IHwIDCallback iHwIDCallback) throws RemoteException;

    void login(String str, Bundle bundle, IHwIDCallback iHwIDCallback) throws RemoteException;

    void logout(String str, String str2, Bundle bundle, IHwIDCallback iHwIDCallback) throws RemoteException;

    void setLogoutEnable(String str, boolean z10, IHwIDCallback iHwIDCallback) throws RemoteException;

    int setLogoutIntent(Intent intent, int i10) throws RemoteException;

    int setLogoutIntent2(Intent intent, int i10, int i11) throws RemoteException;
}
