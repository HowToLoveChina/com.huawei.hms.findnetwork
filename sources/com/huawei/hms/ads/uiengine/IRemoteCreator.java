package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IGlobalUtil;
import com.huawei.hms.ads.uiengine.IRemoteViewDelegate;
import com.huawei.hms.ads.uiengine.ISplashApi;
import com.huawei.hms.ads.uiengine.InterfaceC5108c;
import com.huawei.hms.ads.uiengine.InterfaceC5109d;
import com.huawei.hms.ads.uiengine.InterfaceC5110e;

/* loaded from: classes8.dex */
public interface IRemoteCreator extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.IRemoteCreator";

    /* renamed from: com.huawei.hms.ads.uiengine.IRemoteCreator$a */
    public static abstract class AbstractBinderC5103a extends Binder implements IRemoteCreator {

        /* renamed from: com.huawei.hms.ads.uiengine.IRemoteCreator$a$a */
        public static class a implements IRemoteCreator {

            /* renamed from: a */
            public static IRemoteCreator f23294a;

            /* renamed from: b */
            private IBinder f23295b;

            public a(IBinder iBinder) {
                this.f23295b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23295b;
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void bindData(IObjectWrapper iObjectWrapper, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (this.f23295b.transact(6, parcelObtain, parcelObtain2, 0) || AbstractBinderC5103a.m30459a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5103a.m30459a().bindData(iObjectWrapper, str);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void destroyView(IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.f23295b.transact(8, parcelObtain, parcelObtain2, 0) || AbstractBinderC5103a.m30459a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5103a.m30459a().destroyView(iObjectWrapper);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public InterfaceC5110e getUiEngineUtil() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (!this.f23295b.transact(9, parcelObtain, parcelObtain2, 0) && AbstractBinderC5103a.m30459a() != null) {
                        return AbstractBinderC5103a.m30459a().getUiEngineUtil();
                    }
                    parcelObtain2.readException();
                    return InterfaceC5110e.a.m30531a(parcelObtain2.readStrongBinder());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public String getVersion() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (!this.f23295b.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC5103a.m30459a() != null) {
                        return AbstractBinderC5103a.m30459a().getVersion();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newBannerTemplateView(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f23295b.transact(5, parcelObtain, parcelObtain2, 0) && AbstractBinderC5103a.m30459a() != null) {
                        IObjectWrapper iObjectWrapperNewBannerTemplateView = AbstractBinderC5103a.m30459a().newBannerTemplateView(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return iObjectWrapperNewBannerTemplateView;
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

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newInterstitialTemplateView(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f23295b.transact(12, parcelObtain, parcelObtain2, 0) && AbstractBinderC5103a.m30459a() != null) {
                        IObjectWrapper iObjectWrapperNewInterstitialTemplateView = AbstractBinderC5103a.m30459a().newInterstitialTemplateView(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return iObjectWrapperNewInterstitialTemplateView;
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

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newNativeTemplateView(Bundle bundle, InterfaceC5108c interfaceC5108c) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(interfaceC5108c != null ? interfaceC5108c.asBinder() : null);
                    if (!this.f23295b.transact(4, parcelObtain, parcelObtain2, 0) && AbstractBinderC5103a.m30459a() != null) {
                        IObjectWrapper iObjectWrapperNewNativeTemplateView = AbstractBinderC5103a.m30459a().newNativeTemplateView(bundle, interfaceC5108c);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return iObjectWrapperNewNativeTemplateView;
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

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f23295b.transact(7, parcelObtain, parcelObtain2, 0) && AbstractBinderC5103a.m30459a() != null) {
                        IRemoteViewDelegate iRemoteViewDelegateNewRemoteViewDelegate = AbstractBinderC5103a.m30459a().newRemoteViewDelegate(iObjectWrapper, str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return iRemoteViewDelegateNewRemoteViewDelegate;
                    }
                    parcelObtain2.readException();
                    IRemoteViewDelegate iRemoteViewDelegateM30462a = IRemoteViewDelegate.AbstractBinderC5104a.m30462a(parcelObtain2.readStrongBinder());
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iRemoteViewDelegateM30462a;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newRewardTemplateView(Bundle bundle, InterfaceC5109d interfaceC5109d) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(interfaceC5109d != null ? interfaceC5109d.asBinder() : null);
                    if (!this.f23295b.transact(10, parcelObtain, parcelObtain2, 0) && AbstractBinderC5103a.m30459a() != null) {
                        IObjectWrapper iObjectWrapperNewRewardTemplateView = AbstractBinderC5103a.m30459a().newRewardTemplateView(bundle, interfaceC5109d);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return iObjectWrapperNewRewardTemplateView;
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

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newSplashTemplateView(Bundle bundle, ISplashApi iSplashApi) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSplashApi != null ? iSplashApi.asBinder() : null);
                    if (!this.f23295b.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC5103a.m30459a() != null) {
                        IObjectWrapper iObjectWrapperNewSplashTemplateView = AbstractBinderC5103a.m30459a().newSplashTemplateView(bundle, iSplashApi);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return iObjectWrapperNewSplashTemplateView;
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

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void setGlobalUtil(IGlobalUtil iGlobalUtil) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iGlobalUtil != null ? iGlobalUtil.asBinder() : null);
                    if (this.f23295b.transact(2, parcelObtain, parcelObtain2, 0) || AbstractBinderC5103a.m30459a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5103a.m30459a().setGlobalUtil(iGlobalUtil);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void setSdkInfo(int i10, int i11, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IRemoteCreator.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23295b.transact(11, parcelObtain, parcelObtain2, 0) || AbstractBinderC5103a.m30459a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5103a.m30459a().setSdkInfo(i10, i11, bundle);
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
        public static IRemoteCreator m30459a() {
            return a.f23294a;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(IRemoteCreator.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    String version = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(version);
                    return true;
                case 2:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    setGlobalUtil(IGlobalUtil.AbstractBinderC5101a.m30456a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    IObjectWrapper iObjectWrapperNewSplashTemplateView = newSplashTemplateView(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, ISplashApi.AbstractBinderC5105a.m30464a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iObjectWrapperNewSplashTemplateView != null ? iObjectWrapperNewSplashTemplateView.asBinder() : null);
                    return true;
                case 4:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    IObjectWrapper iObjectWrapperNewNativeTemplateView = newNativeTemplateView(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, InterfaceC5108c.a.m30504a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iObjectWrapperNewNativeTemplateView != null ? iObjectWrapperNewNativeTemplateView.asBinder() : null);
                    return true;
                case 5:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    IObjectWrapper iObjectWrapperNewBannerTemplateView = newBannerTemplateView(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iObjectWrapperNewBannerTemplateView != null ? iObjectWrapperNewBannerTemplateView.asBinder() : null);
                    return true;
                case 6:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    bindData(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    IRemoteViewDelegate iRemoteViewDelegateNewRemoteViewDelegate = newRemoteViewDelegate(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iRemoteViewDelegateNewRemoteViewDelegate != null ? iRemoteViewDelegateNewRemoteViewDelegate.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    destroyView(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    InterfaceC5110e uiEngineUtil = getUiEngineUtil();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(uiEngineUtil != null ? uiEngineUtil.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    IObjectWrapper iObjectWrapperNewRewardTemplateView = newRewardTemplateView(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, InterfaceC5109d.a.m30518a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iObjectWrapperNewRewardTemplateView != null ? iObjectWrapperNewRewardTemplateView.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    setSdkInfo(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(IRemoteCreator.DESCRIPTOR);
                    IObjectWrapper iObjectWrapperNewInterstitialTemplateView = newInterstitialTemplateView(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(iObjectWrapperNewInterstitialTemplateView != null ? iObjectWrapperNewInterstitialTemplateView.asBinder() : null);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        /* renamed from: a */
        public static IRemoteCreator m30460a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IRemoteCreator.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IRemoteCreator)) ? new a(iBinder) : (IRemoteCreator) iInterfaceQueryLocalInterface;
        }
    }

    void bindData(IObjectWrapper iObjectWrapper, String str);

    void destroyView(IObjectWrapper iObjectWrapper);

    InterfaceC5110e getUiEngineUtil();

    String getVersion();

    IObjectWrapper newBannerTemplateView(Bundle bundle);

    IObjectWrapper newInterstitialTemplateView(Bundle bundle);

    IObjectWrapper newNativeTemplateView(Bundle bundle, InterfaceC5108c interfaceC5108c);

    IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, String str, Bundle bundle);

    IObjectWrapper newRewardTemplateView(Bundle bundle, InterfaceC5109d interfaceC5109d);

    IObjectWrapper newSplashTemplateView(Bundle bundle, ISplashApi iSplashApi);

    void setGlobalUtil(IGlobalUtil iGlobalUtil);

    void setSdkInfo(int i10, int i11, Bundle bundle);
}
