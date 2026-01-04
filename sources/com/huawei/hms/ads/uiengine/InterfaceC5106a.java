package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.huawei.hms.ads.uiengine.a */
/* loaded from: classes8.dex */
public interface InterfaceC5106a extends IInterface {

    /* renamed from: com.huawei.hms.ads.uiengine.a$a */
    public static abstract class a extends Binder implements InterfaceC5106a {

        /* renamed from: com.huawei.hms.ads.uiengine.a$a$a, reason: collision with other inner class name */
        public static class C14432a implements InterfaceC5106a {

            /* renamed from: a */
            public static InterfaceC5106a f23300a;

            /* renamed from: b */
            private IBinder f23301b;

            public C14432a(IBinder iBinder) {
                this.f23301b = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5106a
            /* renamed from: a */
            public long mo30465a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    if (!this.f23301b.transact(1, parcelObtain, parcelObtain2, 0) && a.m30475c() != null) {
                        return a.m30475c().mo30465a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23301b;
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5106a
            /* renamed from: b */
            public void mo30468b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    if (this.f23301b.transact(7, parcelObtain, parcelObtain2, 0) || a.m30475c() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30475c().mo30468b();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5106a
            /* renamed from: c */
            public void mo30471c(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23301b.transact(4, parcelObtain, parcelObtain2, 0) || a.m30475c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30475c().mo30471c(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5106a
            /* renamed from: d */
            public void mo30473d(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23301b.transact(5, parcelObtain, parcelObtain2, 0) || a.m30475c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30475c().mo30473d(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5106a
            /* renamed from: a */
            public void mo30466a(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23301b.transact(2, parcelObtain, parcelObtain2, 0) || a.m30475c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30475c().mo30466a(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5106a
            /* renamed from: b */
            public void mo30469b(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23301b.transact(3, parcelObtain, parcelObtain2, 0) || a.m30475c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30475c().mo30469b(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5106a
            /* renamed from: c */
            public void mo30472c(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    parcelObtain.writeString(str);
                    if (this.f23301b.transact(9, parcelObtain, parcelObtain2, 0) || a.m30475c() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30475c().mo30472c(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5106a
            /* renamed from: a */
            public void mo30467a(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    parcelObtain.writeString(str);
                    if (this.f23301b.transact(6, parcelObtain, parcelObtain2, 0) || a.m30475c() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30475c().mo30467a(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5106a
            /* renamed from: b */
            public void mo30470b(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    parcelObtain.writeString(str);
                    if (this.f23301b.transact(8, parcelObtain, parcelObtain2, 0) || a.m30475c() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30475c().mo30470b(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static InterfaceC5106a m30474a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC5106a)) ? new C14432a(iBinder) : (InterfaceC5106a) iInterfaceQueryLocalInterface;
        }

        /* renamed from: c */
        public static InterfaceC5106a m30475c() {
            return C14432a.f23300a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    long jMo30465a = mo30465a();
                    parcel2.writeNoException();
                    parcel2.writeLong(jMo30465a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    mo30466a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    mo30469b(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    mo30471c(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    mo30473d(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    mo30467a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    mo30468b();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    mo30470b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IMediaplayerAgent");
                    mo30472c(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    /* renamed from: a */
    long mo30465a();

    /* renamed from: a */
    void mo30466a(Bundle bundle);

    /* renamed from: a */
    void mo30467a(String str);

    /* renamed from: b */
    void mo30468b();

    /* renamed from: b */
    void mo30469b(Bundle bundle);

    /* renamed from: b */
    void mo30470b(String str);

    /* renamed from: c */
    void mo30471c(Bundle bundle);

    /* renamed from: c */
    void mo30472c(String str);

    /* renamed from: d */
    void mo30473d(Bundle bundle);
}
