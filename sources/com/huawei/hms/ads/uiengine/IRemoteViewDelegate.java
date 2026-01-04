package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;

/* loaded from: classes8.dex */
public interface IRemoteViewDelegate extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.IRemoteViewDelegate";

    /* renamed from: com.huawei.hms.ads.uiengine.IRemoteViewDelegate$a */
    public static abstract class AbstractBinderC5104a extends Binder implements IRemoteViewDelegate {

        /* renamed from: com.huawei.hms.ads.uiengine.IRemoteViewDelegate$a$a */
        public static class a implements IRemoteViewDelegate {

            /* renamed from: a */
            public static IRemoteViewDelegate f23296a;

            /* renamed from: b */
            private IBinder f23297b;

            public a(IBinder iBinder) {
                this.f23297b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23297b;
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public IObjectWrapper getView() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (!this.f23297b.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC5104a.m30461a() != null) {
                        return AbstractBinderC5104a.m30461a().getView();
                    }
                    parcelObtain2.readException();
                    return IObjectWrapper.Stub.asInterface(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onCreate(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23297b.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC5104a.m30461a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5104a.m30461a().onCreate(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onDestroy() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.f23297b.transact(3, parcelObtain, parcelObtain2, 0) || AbstractBinderC5104a.m30461a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5104a.m30461a().onDestroy();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onPause() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.f23297b.transact(4, parcelObtain, parcelObtain2, 0) || AbstractBinderC5104a.m30461a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5104a.m30461a().onPause();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onRestart() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.f23297b.transact(8, parcelObtain, parcelObtain2, 0) || AbstractBinderC5104a.m30461a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5104a.m30461a().onRestart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onResume() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.f23297b.transact(5, parcelObtain, parcelObtain2, 0) || AbstractBinderC5104a.m30461a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5104a.m30461a().onResume();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onStart() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.f23297b.transact(6, parcelObtain, parcelObtain2, 0) || AbstractBinderC5104a.m30461a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5104a.m30461a().onStart();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onStop() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    if (this.f23297b.transact(7, parcelObtain, parcelObtain2, 0) || AbstractBinderC5104a.m30461a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5104a.m30461a().onStop();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public Bundle sendCommand(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f23297b.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC5104a.m30461a() != null) {
                        Bundle bundleSendCommand = AbstractBinderC5104a.m30461a().sendCommand(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return bundleSendCommand;
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

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteViewDelegate.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.f23297b.transact(9, parcelObtain, parcelObtain2, 0) || AbstractBinderC5104a.m30461a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5104a.m30461a().setCallback(iPPSUiEngineCallback);
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

        /* renamed from: a */
        public static IRemoteViewDelegate m30461a() {
            return a.f23296a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(IRemoteViewDelegate.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    IObjectWrapper view = getView();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(view != null ? view.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onCreate(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    break;
                case 3:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onDestroy();
                    break;
                case 4:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onPause();
                    break;
                case 5:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onResume();
                    break;
                case 6:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onStart();
                    break;
                case 7:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onStop();
                    break;
                case 8:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    onRestart();
                    break;
                case 9:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    setCallback(IPPSUiEngineCallback.AbstractBinderC5102a.m30458a(parcel.readStrongBinder()));
                    break;
                case 10:
                    parcel.enforceInterface(IRemoteViewDelegate.DESCRIPTOR);
                    Bundle bundleSendCommand = sendCommand(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleSendCommand != null) {
                        parcel2.writeInt(1);
                        bundleSendCommand.writeToParcel(parcel2, 1);
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

        /* renamed from: a */
        public static IRemoteViewDelegate m30462a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteViewDelegate.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteViewDelegate)) ? new a(iBinder) : (IRemoteViewDelegate) iInterfaceQueryLocalInterface;
        }
    }

    IObjectWrapper getView();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onRestart();

    void onResume();

    void onStart();

    void onStop();

    Bundle sendCommand(String str, Bundle bundle);

    void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback);
}
