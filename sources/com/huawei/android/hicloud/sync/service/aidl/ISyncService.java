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
public interface ISyncService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.android.hicloud.sync.service.aidl.ISyncService";

    public static class Default implements ISyncService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void checkRisk(String str, String str2, int i10, int i11, int i12) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public int doAutoSyncContact(SyncType syncType) throws RemoteException {
            return 0;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public int doAutoSyncWlan(int i10) throws RemoteException {
            return 0;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void downUnstructFile(String str, String str2, List<UnstructData> list) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void endSync(String str, List<String> list, List<String> list2) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void endSyncForTransTooLarge(String str, byte[] bArr, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void endSyncV100(String str, List<String> list, List<String> list2, List<String> list3) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void getExceedLimitNum(String str, List<String> list) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public int getHisyncNewVersion() throws RemoteException {
            return 0;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public int getHisyncVersionCode() throws RemoteException {
            return 0;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void getStructData(String str, String str2, List<String> list) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void getStructDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void getSyncLostList(String str, String str2) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void notifyMsg(String str, String str2, String str3) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void notifySyncModel(String str, String str2, int i10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException {
            return false;
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void reportEvent(String str, String str2) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void reportInfo(String str, String str2) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void reportSDKVersionCode(int i10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void reportSyncInfo(String str, String str2, String str3, String str4, String str5) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void reportSyncRsn(String str, String str2, String str3, String str4) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void saveSyncResult(String str, String str2, List<SyncData> list, List<String> list2, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void saveSyncResultForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void startSync(String str, String str2, List<LocalId> list, int i10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void startSyncForTransTooLarge(String str, String str2, byte[] bArr, int i10, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void startSyncV100(String str, String str2, String str3, int i10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void startSyncV101(String str, String str2, List<CtagInfoCompatible> list, int i10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void updateCtag(String str, String str2) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadData(String str, String str2, List<SyncData> list, List<SyncData> list2, List<String> list3, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataV102(String str, String str2, List<SyncData> list, List<SyncData> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataV102ForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataV104(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataWithLost(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<String> list3, List<SyncDataCompatible> list4, boolean z10) throws RemoteException {
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
        public void uploadDataWithLostForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISyncService {
        static final int TRANSACTION_checkRisk = 27;
        static final int TRANSACTION_doAutoSyncContact = 1;
        static final int TRANSACTION_doAutoSyncWlan = 2;
        static final int TRANSACTION_downUnstructFile = 10;
        static final int TRANSACTION_downUnstructFileForTransTooLarge = 18;
        static final int TRANSACTION_endSync = 9;
        static final int TRANSACTION_endSyncForTransTooLarge = 17;
        static final int TRANSACTION_endSyncV100 = 21;
        static final int TRANSACTION_getExceedLimitNum = 31;
        static final int TRANSACTION_getHisyncNewVersion = 20;
        static final int TRANSACTION_getHisyncVersionCode = 19;
        static final int TRANSACTION_getStructData = 5;
        static final int TRANSACTION_getStructDataForTransTooLarge = 15;
        static final int TRANSACTION_getSyncLostList = 32;
        static final int TRANSACTION_notifyMsg = 37;
        static final int TRANSACTION_notifySyncModel = 36;
        static final int TRANSACTION_registerCallback = 3;
        static final int TRANSACTION_reportEvent = 26;
        static final int TRANSACTION_reportInfo = 29;
        static final int TRANSACTION_reportSDKVersionCode = 12;
        static final int TRANSACTION_reportSyncInfo = 35;
        static final int TRANSACTION_reportSyncRsn = 28;
        static final int TRANSACTION_saveSyncResult = 7;
        static final int TRANSACTION_saveSyncResultForTransTooLarge = 14;
        static final int TRANSACTION_startSync = 6;
        static final int TRANSACTION_startSyncForTransTooLarge = 16;
        static final int TRANSACTION_startSyncV100 = 22;
        static final int TRANSACTION_startSyncV101 = 23;
        static final int TRANSACTION_unregisterCallback = 4;
        static final int TRANSACTION_updateCtag = 11;
        static final int TRANSACTION_uploadData = 8;
        static final int TRANSACTION_uploadDataForTransTooLarge = 13;
        static final int TRANSACTION_uploadDataV102 = 24;
        static final int TRANSACTION_uploadDataV102ForTransTooLarge = 25;
        static final int TRANSACTION_uploadDataV104 = 30;
        static final int TRANSACTION_uploadDataWithLost = 33;
        static final int TRANSACTION_uploadDataWithLostForTransTooLarge = 34;

        public static class Proxy implements ISyncService {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void checkRisk(String str, String str2, int i10, int i11, int i12) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    this.mRemote.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public int doAutoSyncContact(SyncType syncType) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, syncType, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public int doAutoSyncWlan(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void downUnstructFile(String str, String str2, List<UnstructData> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void endSync(String str, List<String> list, List<String> list2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStringList(list2);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void endSyncForTransTooLarge(String str, byte[] bArr, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void endSyncV100(String str, List<String> list, List<String> list2, List<String> list3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStringList(list2);
                    parcelObtain.writeStringList(list3);
                    this.mRemote.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void getExceedLimitNum(String str, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    this.mRemote.transact(31, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public int getHisyncNewVersion() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public int getHisyncVersionCode() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ISyncService.DESCRIPTOR;
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void getStructData(String str, String str2, List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
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

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void getStructDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void getSyncLostList(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(32, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void notifyMsg(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    this.mRemote.transact(37, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void notifySyncModel(String str, String str2, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(36, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSyncServiceCallback);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void reportEvent(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void reportInfo(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(29, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void reportSDKVersionCode(int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void reportSyncInfo(String str, String str2, String str3, String str4, String str5) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    this.mRemote.transact(35, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void reportSyncRsn(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    this.mRemote.transact(28, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void saveSyncResult(String str, String str2, List<SyncData> list, List<String> list2, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeStringList(list2);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void saveSyncResultForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void startSync(String str, String str2, List<LocalId> list, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void startSyncForTransTooLarge(String str, String str2, byte[] bArr, int i10, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void startSyncV100(String str, String str2, String str3, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void startSyncV101(String str, String str2, List<CtagInfoCompatible> list, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iSyncServiceCallback);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void updateCtag(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void uploadData(String str, String str2, List<SyncData> list, List<SyncData> list2, List<String> list3, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    _Parcel.writeTypedList(parcelObtain, list2, 0);
                    parcelObtain.writeStringList(list3);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void uploadDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void uploadDataV102(String str, String str2, List<SyncData> list, List<SyncData> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    _Parcel.writeTypedList(parcelObtain, list2, 0);
                    _Parcel.writeTypedList(parcelObtain, list3, 0);
                    parcelObtain.writeStringList(list4);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void uploadDataV102ForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.mRemote.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void uploadDataV104(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    _Parcel.writeTypedList(parcelObtain, list2, 0);
                    _Parcel.writeTypedList(parcelObtain, list3, 0);
                    parcelObtain.writeStringList(list4);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(30, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void uploadDataWithLost(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<String> list3, List<SyncDataCompatible> list4, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    _Parcel.writeTypedList(parcelObtain, list, 0);
                    _Parcel.writeTypedList(parcelObtain, list2, 0);
                    parcelObtain.writeStringList(list3);
                    _Parcel.writeTypedList(parcelObtain, list4, 0);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(33, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.android.hicloud.sync.service.aidl.ISyncService
            public void uploadDataWithLostForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISyncService.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.mRemote.transact(34, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ISyncService.DESCRIPTOR);
        }

        public static ISyncService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISyncService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISyncService)) ? new Proxy(iBinder) : (ISyncService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(ISyncService.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(ISyncService.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    int iDoAutoSyncContact = doAutoSyncContact((SyncType) _Parcel.readTypedObject(parcel, SyncType.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iDoAutoSyncContact);
                    return true;
                case 2:
                    int iDoAutoSyncWlan = doAutoSyncWlan(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDoAutoSyncWlan);
                    return true;
                case 3:
                    boolean zRegisterCallback = registerCallback(ISyncServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRegisterCallback ? 1 : 0);
                    return true;
                case 4:
                    unregisterCallback(ISyncServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    getStructData(parcel.readString(), parcel.readString(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    startSync(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(LocalId.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    saveSyncResult(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(SyncData.CREATOR), parcel.createStringArrayList(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    String string = parcel.readString();
                    String string2 = parcel.readString();
                    Parcelable.Creator<SyncData> creator = SyncData.CREATOR;
                    uploadData(string, string2, parcel.createTypedArrayList(creator), parcel.createTypedArrayList(creator), parcel.createStringArrayList(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    endSync(parcel.readString(), parcel.createStringArrayList(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    downUnstructFile(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(UnstructData.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    updateCtag(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    reportSDKVersionCode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    uploadDataForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    saveSyncResultForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    getStructDataForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 16:
                    startSyncForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    endSyncForTransTooLarge(parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    downUnstructFileForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    int hisyncVersionCode = getHisyncVersionCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(hisyncVersionCode);
                    return true;
                case 20:
                    int hisyncNewVersion = getHisyncNewVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(hisyncNewVersion);
                    return true;
                case 21:
                    endSyncV100(parcel.readString(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    startSyncV100(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    startSyncV101(parcel.readString(), parcel.readString(), parcel.createTypedArrayList(CtagInfoCompatible.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 24:
                    String string3 = parcel.readString();
                    String string4 = parcel.readString();
                    Parcelable.Creator<SyncData> creator2 = SyncData.CREATOR;
                    uploadDataV102(string3, string4, parcel.createTypedArrayList(creator2), parcel.createTypedArrayList(creator2), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.createStringArrayList(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    uploadDataV102ForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    reportEvent(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    checkRisk(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 28:
                    reportSyncRsn(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 29:
                    reportInfo(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 30:
                    String string5 = parcel.readString();
                    String string6 = parcel.readString();
                    Parcelable.Creator<SyncDataCompatible> creator3 = SyncDataCompatible.CREATOR;
                    uploadDataV104(string5, string6, parcel.createTypedArrayList(creator3), parcel.createTypedArrayList(creator3), parcel.createTypedArrayList(UnstructData.CREATOR), parcel.createStringArrayList(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 31:
                    getExceedLimitNum(parcel.readString(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 32:
                    getSyncLostList(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    String string7 = parcel.readString();
                    String string8 = parcel.readString();
                    Parcelable.Creator<SyncDataCompatible> creator4 = SyncDataCompatible.CREATOR;
                    uploadDataWithLost(string7, string8, parcel.createTypedArrayList(creator4), parcel.createTypedArrayList(creator4), parcel.createStringArrayList(), parcel.createTypedArrayList(creator4), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    uploadDataWithLostForTransTooLarge(parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 35:
                    reportSyncInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 36:
                    notifySyncModel(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 37:
                    notifyMsg(parcel.readString(), parcel.readString(), parcel.readString());
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

    void checkRisk(String str, String str2, int i10, int i11, int i12) throws RemoteException;

    int doAutoSyncContact(SyncType syncType) throws RemoteException;

    int doAutoSyncWlan(int i10) throws RemoteException;

    void downUnstructFile(String str, String str2, List<UnstructData> list) throws RemoteException;

    void downUnstructFileForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException;

    void endSync(String str, List<String> list, List<String> list2) throws RemoteException;

    void endSyncForTransTooLarge(String str, byte[] bArr, boolean z10) throws RemoteException;

    void endSyncV100(String str, List<String> list, List<String> list2, List<String> list3) throws RemoteException;

    void getExceedLimitNum(String str, List<String> list) throws RemoteException;

    int getHisyncNewVersion() throws RemoteException;

    int getHisyncVersionCode() throws RemoteException;

    void getStructData(String str, String str2, List<String> list) throws RemoteException;

    void getStructDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10) throws RemoteException;

    void getSyncLostList(String str, String str2) throws RemoteException;

    void notifyMsg(String str, String str2, String str3) throws RemoteException;

    void notifySyncModel(String str, String str2, int i10) throws RemoteException;

    boolean registerCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException;

    void reportEvent(String str, String str2) throws RemoteException;

    void reportInfo(String str, String str2) throws RemoteException;

    void reportSDKVersionCode(int i10) throws RemoteException;

    void reportSyncInfo(String str, String str2, String str3, String str4, String str5) throws RemoteException;

    void reportSyncRsn(String str, String str2, String str3, String str4) throws RemoteException;

    void saveSyncResult(String str, String str2, List<SyncData> list, List<String> list2, boolean z10) throws RemoteException;

    void saveSyncResultForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException;

    void startSync(String str, String str2, List<LocalId> list, int i10) throws RemoteException;

    void startSyncForTransTooLarge(String str, String str2, byte[] bArr, int i10, boolean z10) throws RemoteException;

    void startSyncV100(String str, String str2, String str3, int i10) throws RemoteException;

    void startSyncV101(String str, String str2, List<CtagInfoCompatible> list, int i10) throws RemoteException;

    void unregisterCallback(ISyncServiceCallback iSyncServiceCallback, String str) throws RemoteException;

    void updateCtag(String str, String str2) throws RemoteException;

    void uploadData(String str, String str2, List<SyncData> list, List<SyncData> list2, List<String> list3, boolean z10) throws RemoteException;

    void uploadDataForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException;

    void uploadDataV102(String str, String str2, List<SyncData> list, List<SyncData> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException;

    void uploadDataV102ForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException;

    void uploadDataV104(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<UnstructData> list3, List<String> list4, boolean z10) throws RemoteException;

    void uploadDataWithLost(String str, String str2, List<SyncDataCompatible> list, List<SyncDataCompatible> list2, List<String> list3, List<SyncDataCompatible> list4, boolean z10) throws RemoteException;

    void uploadDataWithLostForTransTooLarge(String str, String str2, byte[] bArr, boolean z10, boolean z11) throws RemoteException;
}
