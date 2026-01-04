package com.huawei.hwcloudjs.p150a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.huawei.hwcloudjs.a.a */
/* loaded from: classes8.dex */
public interface InterfaceC6615a extends IInterface {

    /* renamed from: com.huawei.hwcloudjs.a.a$a */
    public static class a implements InterfaceC6615a {
        @Override // com.huawei.hwcloudjs.p150a.InterfaceC6615a
        /* renamed from: a */
        public int mo37747a(Bundle bundle) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: com.huawei.hwcloudjs.a.a$b */
    public static abstract class b extends Binder implements InterfaceC6615a {

        /* renamed from: a */
        private static final String f30745a = "com.huawei.hwcloudjs.aidl.IConnectionSdk";

        /* renamed from: b */
        static final int f30746b = 1;

        /* renamed from: com.huawei.hwcloudjs.a.a$b$a */
        public static class a implements InterfaceC6615a {

            /* renamed from: a */
            public static InterfaceC6615a f30747a;

            /* renamed from: b */
            private IBinder f30748b;

            public a(IBinder iBinder) {
                this.f30748b = iBinder;
            }

            @Override // com.huawei.hwcloudjs.p150a.InterfaceC6615a
            /* renamed from: a */
            public int mo37747a(Bundle bundle) throws RemoteException {
                int iMo37747a;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f30745a);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f30748b.transact(1, parcelObtain, parcelObtain2, 0) || b.m37748a() == null) {
                        parcelObtain2.readException();
                        iMo37747a = parcelObtain2.readInt();
                    } else {
                        iMo37747a = b.m37748a().mo37747a(bundle);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iMo37747a;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30748b;
            }

            /* renamed from: a */
            public String m37751a() {
                return b.f30745a;
            }
        }

        public b() {
            attachInterface(this, f30745a);
        }

        /* renamed from: a */
        public static InterfaceC6615a m37748a() {
            return a.f30747a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f30745a);
                return true;
            }
            parcel.enforceInterface(f30745a);
            int iMo37747a = mo37747a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(iMo37747a);
            return true;
        }

        /* renamed from: a */
        public static InterfaceC6615a m37749a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f30745a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC6615a)) ? new a(iBinder) : (InterfaceC6615a) iInterfaceQueryLocalInterface;
        }

        /* renamed from: a */
        public static boolean m37750a(InterfaceC6615a interfaceC6615a) {
            if (a.f30747a != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (interfaceC6615a == null) {
                return false;
            }
            a.f30747a = interfaceC6615a;
            return true;
        }
    }

    /* renamed from: a */
    int mo37747a(Bundle bundle) throws RemoteException;
}
