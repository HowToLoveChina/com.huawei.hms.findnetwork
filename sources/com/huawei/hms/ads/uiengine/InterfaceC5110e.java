package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.ads.uiengine.e */
/* loaded from: classes8.dex */
public interface InterfaceC5110e extends IInterface {

    /* renamed from: com.huawei.hms.ads.uiengine.e$a */
    public static abstract class a extends Binder implements InterfaceC5110e {

        /* renamed from: com.huawei.hms.ads.uiengine.e$a$a, reason: collision with other inner class name */
        public static class C14436a implements InterfaceC5110e {

            /* renamed from: a */
            public static InterfaceC5110e f23308a;

            /* renamed from: b */
            private IBinder f23309b;

            public C14436a(IBinder iBinder) {
                this.f23309b = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5110e
            /* renamed from: a */
            public IObjectWrapper mo30520a(IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.f23309b.transact(4, parcelObtain, parcelObtain2, 0) && a.m30530a() != null) {
                        IObjectWrapper iObjectWrapperMo30520a = a.m30530a().mo30520a(iObjectWrapper);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return iObjectWrapperMo30520a;
                    }
                    parcelObtain2.readException();
                    IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iObjectWrapperAsInterface;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23309b;
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5110e
            /* renamed from: b */
            public void mo30526b(int i10, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    parcelObtain.writeInt(i10);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23309b.transact(8, parcelObtain, parcelObtain2, 0) || a.m30530a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30530a().mo30526b(i10, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5110e
            /* renamed from: c */
            public void mo30528c(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23309b.transact(9, parcelObtain, parcelObtain2, 0) || a.m30530a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30530a().mo30528c(iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5110e
            /* renamed from: d */
            public void mo30529d(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23309b.transact(10, parcelObtain, parcelObtain2, 0) || a.m30530a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30530a().mo30529d(iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5110e
            /* renamed from: a */
            public List<String> mo30521a(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f23309b.transact(1, parcelObtain, parcelObtain2, 0) && a.m30530a() != null) {
                        List<String> listMo30521a = a.m30530a().mo30521a(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return listMo30521a;
                    }
                    parcelObtain2.readException();
                    ArrayList<String> arrayListCreateStringArrayList = parcelObtain2.createStringArrayList();
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return arrayListCreateStringArrayList;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5110e
            /* renamed from: b */
            public void mo30527b(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23309b.transact(6, parcelObtain, parcelObtain2, 0) || a.m30530a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30530a().mo30527b(iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5110e
            /* renamed from: a */
            public void mo30522a(int i10, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    parcelObtain.writeInt(i10);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23309b.transact(7, parcelObtain, parcelObtain2, 0) || a.m30530a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30530a().mo30522a(i10, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5110e
            /* renamed from: a */
            public void mo30523a(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23309b.transact(5, parcelObtain, parcelObtain2, 0) || a.m30530a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30530a().mo30523a(iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5110e
            /* renamed from: a */
            public void mo30524a(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23309b.transact(2, parcelObtain, parcelObtain2, 0) || a.m30530a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30530a().mo30524a(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5110e
            /* renamed from: a */
            public boolean mo30525a(String str, int i10, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f23309b.transact(3, parcelObtain, parcelObtain2, 0) && a.m30530a() != null) {
                        boolean zMo30525a = a.m30530a().mo30525a(str, i10, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return zMo30525a;
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
        }

        /* renamed from: a */
        public static InterfaceC5110e m30530a() {
            return C14436a.f23308a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    List<String> listMo30521a = mo30521a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStringList(listMo30521a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    mo30524a(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    boolean zMo30525a = mo30525a(parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zMo30525a ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    IObjectWrapper iObjectWrapperMo30520a = mo30520a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iObjectWrapperMo30520a != null ? iObjectWrapperMo30520a.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    mo30523a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    mo30527b(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    mo30522a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    mo30526b(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    mo30528c(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.IUiEngineUtil");
                    mo30529d(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        /* renamed from: a */
        public static InterfaceC5110e m30531a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.ads.uiengine.IUiEngineUtil");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC5110e)) ? new C14436a(iBinder) : (InterfaceC5110e) iInterfaceQueryLocalInterface;
        }
    }

    /* renamed from: a */
    IObjectWrapper mo30520a(IObjectWrapper iObjectWrapper);

    /* renamed from: a */
    List<String> mo30521a(Bundle bundle);

    /* renamed from: a */
    void mo30522a(int i10, Bundle bundle);

    /* renamed from: a */
    void mo30523a(IObjectWrapper iObjectWrapper, Bundle bundle);

    /* renamed from: a */
    void mo30524a(String str, Bundle bundle);

    /* renamed from: a */
    boolean mo30525a(String str, int i10, Bundle bundle);

    /* renamed from: b */
    void mo30526b(int i10, Bundle bundle);

    /* renamed from: b */
    void mo30527b(IObjectWrapper iObjectWrapper, Bundle bundle);

    /* renamed from: c */
    void mo30528c(IObjectWrapper iObjectWrapper, Bundle bundle);

    /* renamed from: d */
    void mo30529d(IObjectWrapper iObjectWrapper, Bundle bundle);
}
