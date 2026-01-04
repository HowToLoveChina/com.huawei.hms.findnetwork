package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;

/* renamed from: com.huawei.hms.ads.uiengine.d */
/* loaded from: classes8.dex */
public interface InterfaceC5109d extends IInterface {

    /* renamed from: com.huawei.hms.ads.uiengine.d$a */
    public static abstract class a extends Binder implements InterfaceC5109d {

        /* renamed from: com.huawei.hms.ads.uiengine.d$a$a, reason: collision with other inner class name */
        public static class C14435a implements InterfaceC5109d {

            /* renamed from: a */
            public static InterfaceC5109d f23306a;

            /* renamed from: b */
            private IBinder f23307b;

            public C14435a(IBinder iBinder) {
                this.f23307b = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: a */
            public void mo30506a(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23307b.transact(7, parcelObtain, parcelObtain2, 0) || a.m30519c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30519c().mo30506a(bundle);
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
                return this.f23307b;
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: b */
            public Bundle mo30512b(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f23307b.transact(12, parcelObtain, parcelObtain2, 0) && a.m30519c() != null) {
                        Bundle bundleMo30512b = a.m30519c().mo30512b(str, iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return bundleMo30512b;
                    }
                    parcelObtain2.readException();
                    Bundle bundle2 = parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return bundle2;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: c */
            public void mo30515c(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23307b.transact(5, parcelObtain, parcelObtain2, 0) || a.m30519c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30519c().mo30515c(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: d */
            public void mo30516d(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23307b.transact(8, parcelObtain, parcelObtain2, 0) || a.m30519c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30519c().mo30516d(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: e */
            public void mo30517e(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23307b.transact(6, parcelObtain, parcelObtain2, 0) || a.m30519c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30519c().mo30517e(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: a */
            public void mo30507a(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23307b.transact(4, parcelObtain, parcelObtain2, 0) || a.m30519c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30519c().mo30507a(iObjectWrapper, str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: b */
            public void mo30513b(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23307b.transact(3, parcelObtain, parcelObtain2, 0) || a.m30519c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30519c().mo30513b(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: a */
            public void mo30508a(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.f23307b.transact(10, parcelObtain, parcelObtain2, 0) || a.m30519c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30519c().mo30508a(iPPSUiEngineCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: b */
            public boolean mo30514b(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f23307b.transact(9, parcelObtain, parcelObtain2, 0) && a.m30519c() != null) {
                        boolean zMo30514b = a.m30519c().mo30514b(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return zMo30514b;
                    }
                    parcelObtain2.readException();
                    boolean z10 = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return z10;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: a */
            public void mo30509a(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23307b.transact(2, parcelObtain, parcelObtain2, 0) || a.m30519c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30519c().mo30509a(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: a */
            public void mo30510a(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23307b.transact(1, parcelObtain, parcelObtain2, 0) || a.m30519c() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30519c().mo30510a(str, iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5109d
            /* renamed from: a */
            public boolean mo30511a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IRewardApi");
                    if (!this.f23307b.transact(11, parcelObtain, parcelObtain2, 0) && a.m30519c() != null) {
                        return a.m30519c().mo30511a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.huawei.hms.ads.uiengine.IRewardApi");
        }

        /* renamed from: a */
        public static InterfaceC5109d m30518a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.ads.uiengine.IRewardApi");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC5109d)) ? new C14435a(iBinder) : (InterfaceC5109d) iInterfaceQueryLocalInterface;
        }

        /* renamed from: c */
        public static InterfaceC5109d m30519c() {
            return C14435a.f23306a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.ads.uiengine.IRewardApi");
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    mo30510a(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 2:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    mo30509a(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 3:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    mo30513b(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 4:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    mo30507a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 5:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    mo30515c(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 6:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    mo30517e(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 7:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    mo30506a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 8:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    mo30516d(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 9:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    boolean zMo30514b = mo30514b(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zMo30514b ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    mo30508a(IPPSUiEngineCallback.AbstractBinderC5102a.m30458a(parcel.readStrongBinder()));
                    break;
                case 11:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    boolean zMo30511a = mo30511a();
                    parcel2.writeNoException();
                    parcel2.writeInt(zMo30511a ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IRewardApi");
                    Bundle bundleMo30512b = mo30512b(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleMo30512b != null) {
                        parcel2.writeInt(1);
                        bundleMo30512b.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo30506a(Bundle bundle);

    /* renamed from: a */
    void mo30507a(IObjectWrapper iObjectWrapper, String str, Bundle bundle);

    /* renamed from: a */
    void mo30508a(IPPSUiEngineCallback iPPSUiEngineCallback);

    /* renamed from: a */
    void mo30509a(String str, Bundle bundle);

    /* renamed from: a */
    void mo30510a(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    /* renamed from: a */
    boolean mo30511a();

    /* renamed from: b */
    Bundle mo30512b(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    /* renamed from: b */
    void mo30513b(String str, Bundle bundle);

    /* renamed from: b */
    boolean mo30514b(Bundle bundle);

    /* renamed from: c */
    void mo30515c(String str, Bundle bundle);

    /* renamed from: d */
    void mo30516d(String str, Bundle bundle);

    /* renamed from: e */
    void mo30517e(String str, Bundle bundle);
}
