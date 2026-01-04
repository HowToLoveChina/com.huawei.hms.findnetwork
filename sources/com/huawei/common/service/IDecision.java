package com.huawei.common.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.common.service.IDecisionCallback;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public interface IDecision extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.common.service.IDecision";

    public static class Default implements IDecision {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.common.service.IDecision
        public int batchLog(String str, List list, List list2) throws RemoteException {
            return 0;
        }

        @Override // com.huawei.common.service.IDecision
        public void executeEvent(Map map, IDecisionCallback iDecisionCallback) throws RemoteException {
        }

        @Override // com.huawei.common.service.IDecision
        public int insertBusinessData(Map map) throws RemoteException {
            return 0;
        }

        @Override // com.huawei.common.service.IDecision
        public int log(String str, String str2, int i10) throws RemoteException {
            return 0;
        }

        @Override // com.huawei.common.service.IDecision
        public int register(String str, int i10, Map map, Map map2) throws RemoteException {
            return 0;
        }

        @Override // com.huawei.common.service.IDecision
        public int removeBusinessData(String str, String str2) throws RemoteException {
            return 0;
        }

        @Override // com.huawei.common.service.IDecision
        public int unRegister(String str) throws RemoteException {
            return 0;
        }

        @Override // com.huawei.common.service.IDecision
        public int update(String str, String str2) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IDecision {
        static final int TRANSACTION_batchLog = 8;
        static final int TRANSACTION_executeEvent = 1;
        static final int TRANSACTION_insertBusinessData = 2;
        static final int TRANSACTION_log = 7;
        static final int TRANSACTION_register = 4;
        static final int TRANSACTION_removeBusinessData = 3;
        static final int TRANSACTION_unRegister = 5;
        static final int TRANSACTION_update = 6;

        public static class Proxy implements IDecision {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.common.service.IDecision
            public int batchLog(String str, List list, List list2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDecision.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeList(list);
                    parcelObtain.writeList(list2);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.common.service.IDecision
            public void executeEvent(Map map, IDecisionCallback iDecisionCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDecision.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    parcelObtain.writeStrongInterface(iDecisionCallback);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDecision.DESCRIPTOR;
            }

            @Override // com.huawei.common.service.IDecision
            public int insertBusinessData(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDecision.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.common.service.IDecision
            public int log(String str, String str2, int i10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDecision.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i10);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.common.service.IDecision
            public int register(String str, int i10, Map map, Map map2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDecision.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeMap(map);
                    parcelObtain.writeMap(map2);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.common.service.IDecision
            public int removeBusinessData(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDecision.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.common.service.IDecision
            public int unRegister(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDecision.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.common.service.IDecision
            public int update(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDecision.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
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
            attachInterface(this, IDecision.DESCRIPTOR);
        }

        public static IDecision asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDecision.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDecision)) ? new Proxy(iBinder) : (IDecision) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IDecision.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IDecision.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    executeEvent(parcel.readHashMap(getClass().getClassLoader()), IDecisionCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    int iInsertBusinessData = insertBusinessData(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeInt(iInsertBusinessData);
                    return true;
                case 3:
                    int iRemoveBusinessData = removeBusinessData(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iRemoveBusinessData);
                    return true;
                case 4:
                    String string = parcel.readString();
                    int i12 = parcel.readInt();
                    ClassLoader classLoader = getClass().getClassLoader();
                    int iRegister = register(string, i12, parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
                    parcel2.writeNoException();
                    parcel2.writeInt(iRegister);
                    return true;
                case 5:
                    int iUnRegister = unRegister(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iUnRegister);
                    return true;
                case 6:
                    int iUpdate = update(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iUpdate);
                    return true;
                case 7:
                    int iLog = log(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(iLog);
                    return true;
                case 8:
                    String string2 = parcel.readString();
                    ClassLoader classLoader2 = getClass().getClassLoader();
                    int iBatchLog = batchLog(string2, parcel.readArrayList(classLoader2), parcel.readArrayList(classLoader2));
                    parcel2.writeNoException();
                    parcel2.writeInt(iBatchLog);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    int batchLog(String str, List list, List list2) throws RemoteException;

    void executeEvent(Map map, IDecisionCallback iDecisionCallback) throws RemoteException;

    int insertBusinessData(Map map) throws RemoteException;

    int log(String str, String str2, int i10) throws RemoteException;

    int register(String str, int i10, Map map, Map map2) throws RemoteException;

    int removeBusinessData(String str, String str2) throws RemoteException;

    int unRegister(String str) throws RemoteException;

    int update(String str, String str2) throws RemoteException;
}
