package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;

/* loaded from: classes8.dex */
public interface ISplashApi extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.ads.uiengine.ISplashApi";

    /* renamed from: com.huawei.hms.ads.uiengine.ISplashApi$a */
    public static abstract class AbstractBinderC5105a extends Binder implements ISplashApi {

        /* renamed from: com.huawei.hms.ads.uiengine.ISplashApi$a$a */
        public static class a implements ISplashApi {

            /* renamed from: a */
            public static ISplashApi f23298a;

            /* renamed from: b */
            private IBinder f23299b;

            public a(IBinder iBinder) {
                this.f23299b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23299b;
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23299b.transact(23, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5105a.m30463a().callMethod(str, iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public Bundle callMethodForResult(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f23299b.transact(24, parcelObtain, parcelObtain2, 0) && AbstractBinderC5105a.m30463a() != null) {
                        Bundle bundleCallMethodForResult = AbstractBinderC5105a.m30463a().callMethodForResult(str, iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return bundleCallMethodForResult;
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

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean isDestroyed() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (!this.f23299b.transact(19, parcelObtain, parcelObtain2, 0) && AbstractBinderC5105a.m30463a() != null) {
                        return AbstractBinderC5105a.m30463a().isDestroyed();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean isFinishing() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (!this.f23299b.transact(18, parcelObtain, parcelObtain2, 0) && AbstractBinderC5105a.m30463a() != null) {
                        return AbstractBinderC5105a.m30463a().isFinishing();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void notifyAdDismissed() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.f23299b.transact(7, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().notifyAdDismissed();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void notifyAdFailedToLoad(int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    if (this.f23299b.transact(9, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().notifyAdFailedToLoad(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public String notifyAdLoaded() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (!this.f23299b.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC5105a.m30463a() != null) {
                        return AbstractBinderC5105a.m30463a().notifyAdLoaded();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onAdFailToDisplay() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.f23299b.transact(6, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().onAdFailToDisplay();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onAdShowEnd(long j10, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeInt(i10);
                    if (this.f23299b.transact(15, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().onAdShowEnd(j10, i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onDisplayTimeUp() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.f23299b.transact(12, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().onDisplayTimeUp();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onEasterEggPrepare() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.f23299b.transact(20, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().onEasterEggPrepare();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onFeedback(int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    if (this.f23299b.transact(14, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().onFeedback(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onMaterialLoadFailed() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.f23299b.transact(11, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().onMaterialLoadFailed();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onMaterialLoaded() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.f23299b.transact(5, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().onMaterialLoaded();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onSkipAd(int i10, int i11) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    if (this.f23299b.transact(13, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().onSkipAd(i10, i11);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onStartEasterEggFailed(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23299b.transact(17, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5105a.m30463a().onStartEasterEggFailed(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean onTouch(int i10, int i11, long j10, String str, int i12) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i12);
                    if (!this.f23299b.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC5105a.m30463a() != null) {
                        return AbstractBinderC5105a.m30463a().onTouch(i10, i11, j10, str, i12);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean processWhyEventUnified() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (!this.f23299b.transact(21, parcelObtain, parcelObtain2, 0) && AbstractBinderC5105a.m30463a() != null) {
                        return AbstractBinderC5105a.m30463a().processWhyEventUnified();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void removeExSplashBlock() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.f23299b.transact(10, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().removeExSplashBlock();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void reportEvents(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23299b.transact(16, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5105a.m30463a().reportEvents(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void reportShowStartEvent() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (this.f23299b.transact(3, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().reportShowStartEvent();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void reportSplashEvent(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23299b.transact(22, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        AbstractBinderC5105a.m30463a().reportSplashEvent(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void toShowSpare(int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeInt(i10);
                    if (this.f23299b.transact(8, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().toShowSpare(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void updatePhyShowStart(long j10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ISplashApi.DESCRIPTOR);
                    parcelObtain.writeLong(j10);
                    if (this.f23299b.transact(4, parcelObtain, parcelObtain2, 0) || AbstractBinderC5105a.m30463a() == null) {
                        parcelObtain2.readException();
                    } else {
                        AbstractBinderC5105a.m30463a().updatePhyShowStart(j10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC5105a() {
            attachInterface(this, ISplashApi.DESCRIPTOR);
        }

        /* renamed from: a */
        public static ISplashApi m30463a() {
            return a.f23298a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(ISplashApi.DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    boolean zOnTouch = onTouch(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zOnTouch ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    String strNotifyAdLoaded = notifyAdLoaded();
                    parcel2.writeNoException();
                    parcel2.writeString(strNotifyAdLoaded);
                    return true;
                case 3:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    reportShowStartEvent();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    updatePhyShowStart(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onMaterialLoaded();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onAdFailToDisplay();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    notifyAdDismissed();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    toShowSpare(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    notifyAdFailedToLoad(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    removeExSplashBlock();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onMaterialLoadFailed();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onDisplayTimeUp();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onSkipAd(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onFeedback(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onAdShowEnd(parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    reportEvents(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onStartEasterEggFailed(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    boolean zIsFinishing = isFinishing();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsFinishing ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    boolean zIsDestroyed = isDestroyed();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsDestroyed ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    onEasterEggPrepare();
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    boolean zProcessWhyEventUnified = processWhyEventUnified();
                    parcel2.writeNoException();
                    parcel2.writeInt(zProcessWhyEventUnified ? 1 : 0);
                    return true;
                case 22:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    reportSplashEvent(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    callMethod(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(ISplashApi.DESCRIPTOR);
                    Bundle bundleCallMethodForResult = callMethodForResult(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (bundleCallMethodForResult != null) {
                        parcel2.writeInt(1);
                        bundleCallMethodForResult.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        /* renamed from: a */
        public static ISplashApi m30464a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ISplashApi.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISplashApi)) ? new a(iBinder) : (ISplashApi) iInterfaceQueryLocalInterface;
        }
    }

    void callMethod(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    Bundle callMethodForResult(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    boolean isDestroyed();

    boolean isFinishing();

    void notifyAdDismissed();

    void notifyAdFailedToLoad(int i10);

    String notifyAdLoaded();

    void onAdFailToDisplay();

    void onAdShowEnd(long j10, int i10);

    void onDisplayTimeUp();

    void onEasterEggPrepare();

    void onFeedback(int i10);

    void onMaterialLoadFailed();

    void onMaterialLoaded();

    void onSkipAd(int i10, int i11);

    void onStartEasterEggFailed(Bundle bundle);

    boolean onTouch(int i10, int i11, long j10, String str, int i12);

    boolean processWhyEventUnified();

    void removeExSplashBlock();

    void reportEvents(String str, Bundle bundle);

    void reportShowStartEvent();

    void reportSplashEvent(Bundle bundle);

    void toShowSpare(int i10);

    void updatePhyShowStart(long j10);
}
