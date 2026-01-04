package com.huawei.fastapp.engine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public interface IFastAPPAidlInterface extends IInterface {

    public static class Default implements IFastAPPAidlInterface {
        @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
        /* renamed from: a */
        public void mo28705a(String str) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
        /* renamed from: a */
        public void mo28706a(String str, String str2, String str3) throws RemoteException {
        }

        @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
        /* renamed from: a */
        public void mo28707a(String str, String str2, String str3, String str4) throws RemoteException {
        }

        @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
        /* renamed from: a */
        public void mo28708a(String str, String str2, String str3, String str4, String str5, String str6) throws RemoteException {
        }

        @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
        /* renamed from: a */
        public void mo28709a(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws RemoteException {
        }

        @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
        /* renamed from: a */
        public void mo28710a(String str, String str2, String str3, boolean z10, int i10, String str4, String str5, String str6, String str7) throws RemoteException {
        }

        @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
        /* renamed from: a */
        public void mo28711a(String str, String str2, String str3, boolean z10, int i10, String str4, String str5, String str6, String str7, String str8, String str9, boolean z11, int i11) throws RemoteException {
        }

        @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
        /* renamed from: a */
        public void mo28712a(String str, String str2, String str3, boolean z10, boolean z11, String str4, String str5, String str6, String str7) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFastAPPAidlInterface {

        public static class Proxy implements IFastAPPAidlInterface {

            /* renamed from: b */
            public static IFastAPPAidlInterface f21583b;

            /* renamed from: a */
            public IBinder f21584a;

            public Proxy(IBinder iBinder) {
                this.f21584a = iBinder;
            }

            @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
            /* renamed from: a */
            public void mo28705a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    parcelObtain.writeString(str);
                    if (this.f21584a.transact(5, parcelObtain, parcelObtain2, 0) || Stub.m28713g() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.m28713g().mo28705a(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21584a;
            }

            @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
            /* renamed from: a */
            public void mo28706a(String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (this.f21584a.transact(4, parcelObtain, parcelObtain2, 0) || Stub.m28713g() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.m28713g().mo28706a(str, str2, str3);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
            /* renamed from: a */
            public void mo28707a(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    if (this.f21584a.transact(7, parcelObtain, parcelObtain2, 0) || Stub.m28713g() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.m28713g().mo28707a(str, str2, str3, str4);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
            /* renamed from: a */
            public void mo28708a(String str, String str2, String str3, String str4, String str5, String str6) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeString(str6);
                    if (this.f21584a.transact(1, parcelObtain, parcelObtain2, 0) || Stub.m28713g() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.m28713g().mo28708a(str, str2, str3, str4, str5, str6);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
            /* renamed from: a */
            public void mo28709a(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeString(str6);
                    parcelObtain.writeString(str7);
                    if (this.f21584a.transact(6, parcelObtain, parcelObtain2, 0) || Stub.m28713g() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.m28713g().mo28709a(str, str2, str3, str4, str5, str6, str7);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
            /* renamed from: a */
            public void mo28710a(String str, String str2, String str3, boolean z10, int i10, String str4, String str5, String str6, String str7) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeString(str6);
                    parcelObtain.writeString(str7);
                    if (this.f21584a.transact(3, parcelObtain, parcelObtain2, 0) || Stub.m28713g() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.m28713g().mo28710a(str, str2, str3, z10, i10, str4, str5, str6, str7);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
            /* renamed from: a */
            public void mo28711a(String str, String str2, String str3, boolean z10, int i10, String str4, String str5, String str6, String str7, String str8, String str9, boolean z11, int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeString(str6);
                    parcelObtain.writeString(str7);
                    parcelObtain.writeString(str8);
                    parcelObtain.writeString(str9);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    parcelObtain.writeInt(i11);
                    if (this.f21584a.transact(8, parcelObtain, parcelObtain2, 0) || Stub.m28713g() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.m28713g().mo28711a(str, str2, str3, z10, i10, str4, str5, str6, str7, str8, str9, z11, i11);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.fastapp.engine.IFastAPPAidlInterface
            /* renamed from: a */
            public void mo28712a(String str, String str2, String str3, boolean z10, boolean z11, String str4, String str5, String str6, String str7) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeString(str6);
                    parcelObtain.writeString(str7);
                    if (this.f21584a.transact(2, parcelObtain, parcelObtain2, 0) || Stub.m28713g() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.m28713g().mo28712a(str, str2, str3, z10, z11, str4, str5, str6, str7);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.fastapp.engine.IFastAPPAidlInterface");
        }

        /* renamed from: g */
        public static IFastAPPAidlInterface m28713g() {
            return Proxy.f21583b;
        }

        /* renamed from: h */
        public static IFastAPPAidlInterface m28714h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.fastapp.engine.IFastAPPAidlInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IFastAPPAidlInterface)) ? new Proxy(iBinder) : (IFastAPPAidlInterface) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    mo28708a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    mo28712a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    mo28710a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    mo28706a(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    mo28705a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    mo28709a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    mo28707a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.huawei.fastapp.engine.IFastAPPAidlInterface");
                    mo28711a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    /* renamed from: a */
    void mo28705a(String str) throws RemoteException;

    /* renamed from: a */
    void mo28706a(String str, String str2, String str3) throws RemoteException;

    /* renamed from: a */
    void mo28707a(String str, String str2, String str3, String str4) throws RemoteException;

    /* renamed from: a */
    void mo28708a(String str, String str2, String str3, String str4, String str5, String str6) throws RemoteException;

    /* renamed from: a */
    void mo28709a(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws RemoteException;

    /* renamed from: a */
    void mo28710a(String str, String str2, String str3, boolean z10, int i10, String str4, String str5, String str6, String str7) throws RemoteException;

    /* renamed from: a */
    void mo28711a(String str, String str2, String str3, boolean z10, int i10, String str4, String str5, String str6, String str7, String str8, String str9, boolean z11, int i11) throws RemoteException;

    /* renamed from: a */
    void mo28712a(String str, String str2, String str3, boolean z10, boolean z11, String str4, String str5, String str6, String str7) throws RemoteException;
}
