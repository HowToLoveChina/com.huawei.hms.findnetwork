package android.p018os;

import android.os.Parcelable;

/* loaded from: classes.dex */
public interface IBackupSessionCallback extends IInterface {
    public static final String DESCRIPTOR = "android.os.IBackupSessionCallback";

    public static class Default implements IBackupSessionCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.p018os.IBackupSessionCallback
        public void onTaskFileDescriptorCreated(int i10, int i11, long j10, long j11, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        }

        @Override // android.p018os.IBackupSessionCallback
        public void onTaskStatusChanged(int i10, int i11, int i12, String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IBackupSessionCallback {
        static final int TRANSACTION_onTaskFileDescriptorCreated = 2;
        static final int TRANSACTION_onTaskStatusChanged = 1;

        public static class Proxy implements IBackupSessionCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IBackupSessionCallback.DESCRIPTOR;
            }

            @Override // android.p018os.IBackupSessionCallback
            public void onTaskFileDescriptorCreated(int i10, int i11, long j10, long j11, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IBackupSessionCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeLong(j11);
                    _Parcel.writeTypedObject(parcelObtain, parcelFileDescriptor, 0);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.p018os.IBackupSessionCallback
            public void onTaskStatusChanged(int i10, int i11, int i12, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IBackupSessionCallback.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IBackupSessionCallback.DESCRIPTOR);
        }

        public static IBackupSessionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IBackupSessionCallback.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IBackupSessionCallback)) ? new Proxy(iBinder) : (IBackupSessionCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IBackupSessionCallback.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IBackupSessionCallback.DESCRIPTOR);
                return true;
            }
            if (i10 == 1) {
                onTaskStatusChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                onTaskFileDescriptorCreated(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), (ParcelFileDescriptor) _Parcel.readTypedObject(parcel, ParcelFileDescriptor.CREATOR));
            }
            return true;
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

    void onTaskFileDescriptorCreated(int i10, int i11, long j10, long j11, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void onTaskStatusChanged(int i10, int i11, int i12, String str) throws RemoteException;
}
