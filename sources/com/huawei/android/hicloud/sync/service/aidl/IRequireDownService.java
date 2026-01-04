package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.android.hicloud.sync.service.aidl.ISyncServiceCallback;
import java.util.List;

/* loaded from: classes3.dex */
public interface IRequireDownService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.android.hicloud.sync.service.aidl.IRequireDownService";

    public static class Default implements IRequireDownService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void cancelDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void cancelDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void downLoadFile(String str, String str2, List<UnstructData> list, boolean z10, boolean z11, String str3, String str4) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void downLoadFileForTransTooLarge(String str, String str2, boolean z10, boolean z11, String str3, byte[] bArr, boolean z12, String str4) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void pauseDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void pauseDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public boolean registerSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
            return false;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void startDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void startDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
        public void unregisterSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRequireDownService {
        static final int TRANSACTION_cancelDownloadFile = 6;
        static final int TRANSACTION_cancelDownloadFileForTransTooLarge = 10;
        static final int TRANSACTION_downLoadFile = 3;
        static final int TRANSACTION_downLoadFileForTransTooLarge = 7;
        static final int TRANSACTION_pauseDownloadFile = 5;
        static final int TRANSACTION_pauseDownloadFileForTransTooLarge = 9;
        static final int TRANSACTION_registerSingleCallback = 1;
        static final int TRANSACTION_startDownloadFile = 4;
        static final int TRANSACTION_startDownloadFileForTransTooLarge = 8;
        static final int TRANSACTION_unregisterSingleCallback = 2;

        public static class Proxy implements IRequireDownService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void cancelDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRequireDownService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void cancelDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRequireDownService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void downLoadFile(String str, String str2, List<UnstructData> list, boolean z10, boolean z11, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRequireDownService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void downLoadFileForTransTooLarge(String str, String str2, boolean z10, boolean z11, String str3, byte[] bArr, boolean z12, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRequireDownService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z12 ? 1 : 0);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IRequireDownService.DESCRIPTOR;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void pauseDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRequireDownService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void pauseDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRequireDownService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public boolean registerSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRequireDownService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSyncServiceCallback);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void startDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRequireDownService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void startDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRequireDownService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IRequireDownService
            public void unregisterSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRequireDownService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSyncServiceCallback);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IRequireDownService.DESCRIPTOR);
        }

        public static IRequireDownService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRequireDownService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRequireDownService)) ? new Proxy(iBinder) : (IRequireDownService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IRequireDownService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IRequireDownService.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    boolean zRegisterSingleCallback = registerSingleCallback(ISyncServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterSingleCallback ? 1 : 0);
                    return true;
                case 2:
                    unregisterSingleCallback(ISyncServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    downLoadFile(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    startDownloadFile(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    pauseDownloadFile(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    cancelDownloadFile(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    downLoadFileForTransTooLarge(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    startDownloadFileForTransTooLarge(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    pauseDownloadFileForTransTooLarge(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    cancelDownloadFileForTransTooLarge(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    public static class _Parcel {
        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i10) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                writeTypedObject(parcel, list.get(i11), i10);
            }
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void cancelDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException;

    void cancelDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException;

    void downLoadFile(String str, String str2, List<UnstructData> list, boolean z10, boolean z11, String str3, String str4) throws RemoteException;

    void downLoadFileForTransTooLarge(String str, String str2, boolean z10, boolean z11, String str3, byte[] bArr, boolean z12, String str4) throws RemoteException;

    void pauseDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException;

    void pauseDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException;

    boolean registerSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException;

    void startDownloadFile(String str, String str2, List<UnstructData> list, String str3, String str4) throws RemoteException;

    void startDownloadFileForTransTooLarge(String str, String str2, String str3, byte[] bArr, boolean z10, String str4) throws RemoteException;

    void unregisterSingleCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException;
}
