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
public interface IToolSyncService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.android.hicloud.sync.service.aidl.IToolSyncService";

    public static class Default implements IToolSyncService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public void downUnstructFile(String str, String str2, List<UnstructData> list, String str3) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, String str3) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public void getExceedLimitNum(String str, List<String> list, String str2) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
            return false;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public void reportInfo(String str, String str2, String str3) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
        public void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IToolSyncService {
        static final int TRANSACTION_downUnstructFile = 5;
        static final int TRANSACTION_downUnstructFileForTransTooLarge = 6;
        static final int TRANSACTION_getExceedLimitNum = 4;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_reportInfo = 3;
        static final int TRANSACTION_unregisterCallback = 2;

        public static class Proxy implements IToolSyncService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
            public void downUnstructFile(String str, String str2, List<UnstructData> list, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToolSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
            public void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToolSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
            public void getExceedLimitNum(String str, List<String> list, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToolSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IToolSyncService.DESCRIPTOR;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
            public boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToolSyncService.DESCRIPTOR);
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

            @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
            public void reportInfo(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToolSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IToolSyncService
            public void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IToolSyncService.DESCRIPTOR);
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
            attachInterface(this, IToolSyncService.DESCRIPTOR);
        }

        public static IToolSyncService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IToolSyncService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IToolSyncService)) ? new Proxy(iBinder) : (IToolSyncService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IToolSyncService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IToolSyncService.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    boolean zRegisterCallback = registerCallback(ISyncServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterCallback ? 1 : 0);
                    return true;
                case 2:
                    unregisterCallback(ISyncServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    reportInfo(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    getExceedLimitNum(parcel.readString(), parcel.createStringArrayList(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    downUnstructFile(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    downUnstructFileForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readString());
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

    void downUnstructFile(String str, String str2, List<UnstructData> list, String str3) throws RemoteException;

    void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, String str3) throws RemoteException;

    void getExceedLimitNum(String str, List<String> list, String str2) throws RemoteException;

    boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException;

    void reportInfo(String str, String str2, String str3) throws RemoteException;

    void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str, String str2) throws RemoteException;
}
