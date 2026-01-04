package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.uiengine.InterfaceC5106a;

/* renamed from: com.huawei.hms.ads.uiengine.b */
/* loaded from: classes8.dex */
public interface InterfaceC5107b extends IInterface {

    /* renamed from: com.huawei.hms.ads.uiengine.b$a */
    public static abstract class a extends Binder implements InterfaceC5107b {

        /* renamed from: com.huawei.hms.ads.uiengine.b$a$a, reason: collision with other inner class name */
        public static class C14433a implements InterfaceC5107b {

            /* renamed from: a */
            public static InterfaceC5107b f23302a;

            /* renamed from: b */
            private IBinder f23303b;

            public C14433a(IBinder iBinder) {
                this.f23303b = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
            /* renamed from: a */
            public void mo30476a(InterfaceC5106a interfaceC5106a) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    parcelObtain.writeStrongBinder(interfaceC5106a != null ? interfaceC5106a.asBinder() : null);
                    if (this.f23303b.transact(5, parcelObtain, parcelObtain2, 0) || a.m30482a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30482a().mo30476a(interfaceC5106a);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23303b;
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
            /* renamed from: b */
            public void mo30478b(InterfaceC5106a interfaceC5106a) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    parcelObtain.writeStrongBinder(interfaceC5106a != null ? interfaceC5106a.asBinder() : null);
                    if (this.f23303b.transact(6, parcelObtain, parcelObtain2, 0) || a.m30482a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30482a().mo30478b(interfaceC5106a);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
            /* renamed from: c */
            public void mo30480c(String str, InterfaceC5106a interfaceC5106a) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(interfaceC5106a != null ? interfaceC5106a.asBinder() : null);
                    if (this.f23303b.transact(3, parcelObtain, parcelObtain2, 0) || a.m30482a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30482a().mo30480c(str, interfaceC5106a);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
            /* renamed from: d */
            public void mo30481d(String str, InterfaceC5106a interfaceC5106a) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(interfaceC5106a != null ? interfaceC5106a.asBinder() : null);
                    if (this.f23303b.transact(4, parcelObtain, parcelObtain2, 0) || a.m30482a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30482a().mo30481d(str, interfaceC5106a);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
            /* renamed from: a */
            public void mo30477a(String str, InterfaceC5106a interfaceC5106a) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(interfaceC5106a != null ? interfaceC5106a.asBinder() : null);
                    if (this.f23303b.transact(1, parcelObtain, parcelObtain2, 0) || a.m30482a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30482a().mo30477a(str, interfaceC5106a);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5107b
            /* renamed from: b */
            public void mo30479b(String str, InterfaceC5106a interfaceC5106a) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(interfaceC5106a != null ? interfaceC5106a.asBinder() : null);
                    if (this.f23303b.transact(2, parcelObtain, parcelObtain2, 0) || a.m30482a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30482a().mo30479b(str, interfaceC5106a);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }
        }

        public a() {
            attachInterface(this, "com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
        }

        /* renamed from: a */
        public static InterfaceC5107b m30482a() {
            return C14433a.f23302a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    mo30477a(parcel.readString(), InterfaceC5106a.a.m30474a(parcel.readStrongBinder()));
                    break;
                case 2:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    mo30479b(parcel.readString(), InterfaceC5106a.a.m30474a(parcel.readStrongBinder()));
                    break;
                case 3:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    mo30480c(parcel.readString(), InterfaceC5106a.a.m30474a(parcel.readStrongBinder()));
                    break;
                case 4:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    mo30481d(parcel.readString(), InterfaceC5106a.a.m30474a(parcel.readStrongBinder()));
                    break;
                case 5:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    mo30476a(InterfaceC5106a.a.m30474a(parcel.readStrongBinder()));
                    break;
                case 6:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
                    mo30478b(InterfaceC5106a.a.m30474a(parcel.readStrongBinder()));
                    break;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: a */
        public static InterfaceC5107b m30483a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.ads.uiengine.IMultiMPlayingManager");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC5107b)) ? new C14433a(iBinder) : (InterfaceC5107b) iInterfaceQueryLocalInterface;
        }
    }

    /* renamed from: a */
    void mo30476a(InterfaceC5106a interfaceC5106a);

    /* renamed from: a */
    void mo30477a(String str, InterfaceC5106a interfaceC5106a);

    /* renamed from: b */
    void mo30478b(InterfaceC5106a interfaceC5106a);

    /* renamed from: b */
    void mo30479b(String str, InterfaceC5106a interfaceC5106a);

    /* renamed from: c */
    void mo30480c(String str, InterfaceC5106a interfaceC5106a);

    /* renamed from: d */
    void mo30481d(String str, InterfaceC5106a interfaceC5106a);
}
