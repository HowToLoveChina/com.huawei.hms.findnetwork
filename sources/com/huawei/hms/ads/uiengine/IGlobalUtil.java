package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.InterfaceC5107b;

/* loaded from: classes8.dex */
public interface IGlobalUtil extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.IGlobalUtil";

    /* renamed from: com.huawei.hms.ads.uiengine.IGlobalUtil$a */
    public static abstract class AbstractBinderC5101a extends Binder implements IGlobalUtil {

        /* renamed from: com.huawei.hms.ads.uiengine.IGlobalUtil$a$a */
        public static class a implements IGlobalUtil {

            /* renamed from: a */
            public static IGlobalUtil f23290a;

            /* renamed from: b */
            private IBinder f23291b;

            public a(IBinder iBinder) {
                this.f23291b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23291b;
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f23291b.transact(8, parcelObtain, parcelObtain2, 0) && AbstractBinderC5101a.m30455a() != null) {
                        Bundle bundleCallMethod = AbstractBinderC5101a.m30455a().callMethod(str, iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return bundleCallMethod;
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

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.f23291b.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC5101a.m30455a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5101a.m30455a().getFilePath(str, iPPSUiEngineCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public String getFilePathDirect(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.f23291b.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC5101a.m30455a() != null) {
                        return AbstractBinderC5101a.m30455a().getFilePathDirect(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public String getFilePathDirectByCacheType(String str, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    if (!this.f23291b.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC5101a.m30455a() != null) {
                        return AbstractBinderC5101a.m30455a().getFilePathDirectByCacheType(str, i10);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public InterfaceC5107b getMultiMediaPlayingManager() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    if (!this.f23291b.transact(6, parcelObtain, parcelObtain2, 0) && AbstractBinderC5101a.m30455a() != null) {
                        return AbstractBinderC5101a.m30455a().getMultiMediaPlayingManager();
                    }
                    parcelObtain2.readException();
                    return InterfaceC5107b.a.m30483a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.f23291b.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC5101a.m30455a() != null) {
                        boolean zIsFreedomWindowMode = AbstractBinderC5101a.m30455a().isFreedomWindowMode(iObjectWrapper);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return zIsFreedomWindowMode;
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

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.f23291b.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC5101a.m30455a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5101a.m30455a().registerActivityStartCallBack(iPPSUiEngineCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IGlobalUtil.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.f23291b.transact(3, parcelObtain, parcelObtain2, 0) || AbstractBinderC5101a.m30455a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5101a.m30455a().unregisterActivityStartCallBack(iPPSUiEngineCallback);
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

        public AbstractBinderC5101a() {
            attachInterface(this, IGlobalUtil.DESCRIPTOR);
        }

        /* renamed from: a */
        public static IGlobalUtil m30455a() {
            return a.f23290a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(IGlobalUtil.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    getFilePath(parcel.readString(), IPPSUiEngineCallback.AbstractBinderC5102a.m30458a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    registerActivityStartCallBack(IPPSUiEngineCallback.AbstractBinderC5102a.m30458a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    unregisterActivityStartCallBack(IPPSUiEngineCallback.AbstractBinderC5102a.m30458a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    String filePathDirect = getFilePathDirect(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(filePathDirect);
                    return true;
                case 5:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    String filePathDirectByCacheType = getFilePathDirectByCacheType(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(filePathDirectByCacheType);
                    return true;
                case 6:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    InterfaceC5107b multiMediaPlayingManager = getMultiMediaPlayingManager();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(multiMediaPlayingManager != null ? multiMediaPlayingManager.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    boolean zIsFreedomWindowMode = isFreedomWindowMode(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsFreedomWindowMode ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(IGlobalUtil.DESCRIPTOR);
                    Bundle bundleCallMethod = callMethod(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleCallMethod != null) {
                        parcel2.writeInt(1);
                        bundleCallMethod.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        /* renamed from: a */
        public static IGlobalUtil m30456a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IGlobalUtil.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGlobalUtil)) ? new a(iBinder) : (IGlobalUtil) iInterfaceQueryLocalInterface;
        }
    }

    Bundle callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback);

    String getFilePathDirect(String str);

    String getFilePathDirectByCacheType(String str, int i10);

    InterfaceC5107b getMultiMediaPlayingManager();

    boolean isFreedomWindowMode(IObjectWrapper iObjectWrapper);

    void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback);

    void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback);
}
