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
public interface IGenSyncService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.android.hicloud.sync.service.aidl.IGenSyncService";

    public static class Default implements IGenSyncService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void downUnstructFile(String str, String str2, List<UnstructData> list, int i10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, int i10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void endSync(String str, String str2, List<String> list, List<String> list2) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public int getHisyncNewVersion() throws RemoteException {
            return 0;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void getStructData(String str, String str2, List<String> list) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void getStructDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void getStructDataNum(String str, List<String> list) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void getSyncLostList(String str, String str2) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void notifyMsg(String str, String str2, String str3) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException {
            return false;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void reportInfo(String str, String str2) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void reportSyncInfo(String str, String str2, String str3, String str4, String str5) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void saveSyncResult(String str, String str2, List<SyncData> list, List<String> list2, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void saveSyncResultForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void startSync(String str, String str2, String str3, List<CtagInfoCompatible> list, int i10, int i11, int i12) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void uploadData(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void uploadDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void uploadDataWithLost(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<String> list3, List<SyncDataCompatible> list4, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
        public void uploadDataWithLostForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IGenSyncService {
        static final int TRANSACTION_downUnstructFile = 12;
        static final int TRANSACTION_downUnstructFileForTransTooLarge = 13;
        static final int TRANSACTION_endSync = 14;
        static final int TRANSACTION_getHisyncNewVersion = 3;
        static final int TRANSACTION_getStructData = 5;
        static final int TRANSACTION_getStructDataForTransTooLarge = 8;
        static final int TRANSACTION_getStructDataNum = 15;
        static final int TRANSACTION_getSyncLostList = 16;
        static final int TRANSACTION_notifyMsg = 20;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_reportInfo = 9;
        static final int TRANSACTION_reportSyncInfo = 19;
        static final int TRANSACTION_saveSyncResult = 6;
        static final int TRANSACTION_saveSyncResultForTransTooLarge = 7;
        static final int TRANSACTION_startSync = 4;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_uploadData = 10;
        static final int TRANSACTION_uploadDataForTransTooLarge = 11;
        static final int TRANSACTION_uploadDataWithLost = 17;
        static final int TRANSACTION_uploadDataWithLostForTransTooLarge = 18;

        public static class Proxy implements IGenSyncService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void downUnstructFile(String str, String str2, List<UnstructData> list, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void endSync(String str, String str2, List<String> list, List<String> list2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStringList(list2);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public int getHisyncNewVersion() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IGenSyncService.DESCRIPTOR;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void getStructData(String str, String str2, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringList(list);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void getStructDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void getStructDataNum(String str, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void getSyncLostList(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void notifyMsg(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSyncServiceCallback);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void reportInfo(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void reportSyncInfo(String str, String str2, String str3, String str4, String str5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void saveSyncResult(String str, String str2, List<SyncData> list, List<String> list2, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeStringList(list2);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void saveSyncResultForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void startSync(String str, String str2, String str3, List<CtagInfoCompatible> list, int i10, int i11, int i12) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSyncServiceCallback);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void uploadData(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    _Parcel.writeTypedList(parcelObtain, list2, 0);
                    _Parcel.writeTypedList(parcelObtain, list3, 0);
                    parcelObtain.writeStringList(list4);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void uploadDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void uploadDataWithLost(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<String> list3, List<SyncDataCompatible> list4, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    _Parcel.writeTypedList(parcelObtain, list2, 0);
                    parcelObtain.writeStringList(list3);
                    _Parcel.writeTypedList(parcelObtain, list4, 0);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.IGenSyncService
            public void uploadDataWithLostForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGenSyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IGenSyncService.DESCRIPTOR);
        }

        public static IGenSyncService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IGenSyncService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGenSyncService)) ? new Proxy(iBinder) : (IGenSyncService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IGenSyncService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IGenSyncService.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    boolean zRegisterCallback = registerCallback(ISyncServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterCallback ? 1 : 0);
                    return true;
                case 2:
                    unregisterCallback(ISyncServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    int hisyncNewVersion = getHisyncNewVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(hisyncNewVersion);
                    return true;
                case 4:
                    startSync(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createTypedArrayList(CtagInfoCompatible.CREATOR), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    getStructData(parcel.readString(), parcel.readString(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    saveSyncResult(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(SyncData.CREATOR), parcel.createStringArrayList(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    saveSyncResultForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    getStructDataForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    reportInfo(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    String string = parcel.readString();
                    String string2 = parcel.readString();
                    Parcelable.Creator<SyncDataCompatible> creator = SyncDataCompatible.CREATOR;
                    uploadData(string, string2, parcel.createTypedArrayList(creator), parcel.createTypedArrayList(creator), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.createStringArrayList(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    uploadDataForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    downUnstructFile(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    downUnstructFileForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    endSync(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    getStructDataNum(parcel.readString(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    getSyncLostList(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    String string3 = parcel.readString();
                    String string4 = parcel.readString();
                    Parcelable.Creator<SyncDataCompatible> creator2 = SyncDataCompatible.CREATOR;
                    uploadDataWithLost(string3, string4, parcel.createTypedArrayList(creator2), parcel.createTypedArrayList(creator2), parcel.createStringArrayList(), parcel.createTypedArrayList(creator2), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    uploadDataWithLostForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    reportSyncInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    notifyMsg(parcel.readString(), parcel.readString(), parcel.readString());
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

    void downUnstructFile(String str, String str2, List<UnstructData> list, int i10) throws RemoteException;

    void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, int i10) throws RemoteException;

    void endSync(String str, String str2, List<String> list, List<String> list2) throws RemoteException;

    int getHisyncNewVersion() throws RemoteException;

    void getStructData(String str, String str2, List<String> list) throws RemoteException;

    void getStructDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException;

    void getStructDataNum(String str, List<String> list) throws RemoteException;

    void getSyncLostList(String str, String str2) throws RemoteException;

    void notifyMsg(String str, String str2, String str3) throws RemoteException;

    boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException;

    void reportInfo(String str, String str2) throws RemoteException;

    void reportSyncInfo(String str, String str2, String str3, String str4, String str5) throws RemoteException;

    void saveSyncResult(String str, String str2, List<SyncData> list, List<String> list2, boolean z10) throws RemoteException;

    void saveSyncResultForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException;

    void startSync(String str, String str2, String str3, List<CtagInfoCompatible> list, int i10, int i11, int i12) throws RemoteException;

    void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException;

    void uploadData(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException;

    void uploadDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException;

    void uploadDataWithLost(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<String> list3, List<SyncDataCompatible> list4, boolean z10) throws RemoteException;

    void uploadDataWithLostForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException;
}
