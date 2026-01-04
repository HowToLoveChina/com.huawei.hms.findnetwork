package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;

/* renamed from: com.huawei.hms.ads.uiengine.c */
/* loaded from: classes8.dex */
public interface InterfaceC5108c extends IInterface {

    /* renamed from: com.huawei.hms.ads.uiengine.c$a */
    public static abstract class a extends Binder implements InterfaceC5108c {

        /* renamed from: com.huawei.hms.ads.uiengine.c$a$a, reason: collision with other inner class name */
        public static class C14434a implements InterfaceC5108c {

            /* renamed from: a */
            public static InterfaceC5108c f23304a;

            /* renamed from: b */
            private IBinder f23305b;

            public C14434a(IBinder iBinder) {
                this.f23305b = iBinder;
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30484a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (this.f23305b.transact(19, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30505g().mo30484a();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23305b;
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: b */
            public String mo30498b() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (!this.f23305b.transact(17, parcelObtain, parcelObtain2, 0) && a.m30505g() != null) {
                        return a.m30505g().mo30498b();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: c */
            public void mo30501c() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (this.f23305b.transact(15, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30505g().mo30501c();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: d */
            public boolean mo30502d() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (!this.f23305b.transact(8, parcelObtain, parcelObtain2, 0) && a.m30505g() != null) {
                        return a.m30505g().mo30502d();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: e */
            public boolean mo30503e() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (!this.f23305b.transact(10, parcelObtain, parcelObtain2, 0) && a.m30505g() != null) {
                        return a.m30505g().mo30503e();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30485a(int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeInt(i10);
                    if (this.f23305b.transact(13, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30505g().mo30485a(i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: b */
            public void mo30499b(String str, long j10, long j11, int i10, int i11) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeLong(j11);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    if (this.f23305b.transact(3, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30505g().mo30499b(str, j10, j11, i10, i11);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30486a(long j10, long j11) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeLong(j11);
                    if (this.f23305b.transact(5, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30505g().mo30486a(j10, j11);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: b */
            public void mo30500b(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23305b.transact(18, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30505g().mo30500b(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30487a(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23305b.transact(16, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30505g().mo30487a(bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30488a(IObjectWrapper iObjectWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.f23305b.transact(6, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30505g().mo30488a(iObjectWrapper);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30489a(IObjectWrapper iObjectWrapper, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeInt(i10);
                    if (this.f23305b.transact(7, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30505g().mo30489a(iObjectWrapper, i10);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30490a(IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23305b.transact(12, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30505g().mo30490a(iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30491a(IObjectWrapper iObjectWrapper, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (this.f23305b.transact(9, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30505g().mo30491a(iObjectWrapper, str);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30492a(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23305b.transact(11, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30505g().mo30492a(iObjectWrapper, str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30493a(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.f23305b.transact(14, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30505g().mo30493a(iPPSUiEngineCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30494a(String str, int i10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    if (this.f23305b.transact(1, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30505g().mo30494a(str, i10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30495a(String str, long j10, long j11, int i10, int i11) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j10);
                    parcelObtain.writeLong(j11);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    if (this.f23305b.transact(2, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30505g().mo30495a(str, j10, j11, i10, i11);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30496a(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.f23305b.transact(20, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        a.m30505g().mo30496a(str, iObjectWrapper, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.InterfaceC5108c
            /* renamed from: a */
            public void mo30497a(boolean z10) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.ads.uiengine.INativeApi");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f23305b.transact(4, parcelObtain, parcelObtain2, 0) || a.m30505g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m30505g().mo30497a(z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.huawei.hms.ads.uiengine.INativeApi");
        }

        /* renamed from: a */
        public static InterfaceC5108c m30504a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.ads.uiengine.INativeApi");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC5108c)) ? new C14434a(iBinder) : (InterfaceC5108c) iInterfaceQueryLocalInterface;
        }

        /* renamed from: g */
        public static InterfaceC5108c m30505g() {
            return C14434a.f23304a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString("com.huawei.hms.ads.uiengine.INativeApi");
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30494a(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30495a(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30499b(parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30497a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30486a(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30488a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30489a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    boolean zMo30502d = mo30502d();
                    parcel2.writeNoException();
                    parcel2.writeInt(zMo30502d ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30491a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    boolean zMo30503e = mo30503e();
                    parcel2.writeNoException();
                    parcel2.writeInt(zMo30503e ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30492a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30490a(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30485a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30493a(IPPSUiEngineCallback.AbstractBinderC5102a.m30458a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30501c();
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30487a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    String strMo30498b = mo30498b();
                    parcel2.writeNoException();
                    parcel2.writeString(strMo30498b);
                    return true;
                case 18:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30500b(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30484a();
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.huawei.hms.ads.uiengine.INativeApi");
                    mo30496a(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    /* renamed from: a */
    void mo30484a();

    /* renamed from: a */
    void mo30485a(int i10);

    /* renamed from: a */
    void mo30486a(long j10, long j11);

    /* renamed from: a */
    void mo30487a(Bundle bundle);

    /* renamed from: a */
    void mo30488a(IObjectWrapper iObjectWrapper);

    /* renamed from: a */
    void mo30489a(IObjectWrapper iObjectWrapper, int i10);

    /* renamed from: a */
    void mo30490a(IObjectWrapper iObjectWrapper, Bundle bundle);

    /* renamed from: a */
    void mo30491a(IObjectWrapper iObjectWrapper, String str);

    /* renamed from: a */
    void mo30492a(IObjectWrapper iObjectWrapper, String str, Bundle bundle);

    /* renamed from: a */
    void mo30493a(IPPSUiEngineCallback iPPSUiEngineCallback);

    /* renamed from: a */
    void mo30494a(String str, int i10);

    /* renamed from: a */
    void mo30495a(String str, long j10, long j11, int i10, int i11);

    /* renamed from: a */
    void mo30496a(String str, IObjectWrapper iObjectWrapper, Bundle bundle);

    /* renamed from: a */
    void mo30497a(boolean z10);

    /* renamed from: b */
    String mo30498b();

    /* renamed from: b */
    void mo30499b(String str, long j10, long j11, int i10, int i11);

    /* renamed from: b */
    void mo30500b(String str, Bundle bundle);

    /* renamed from: c */
    void mo30501c();

    /* renamed from: d */
    boolean mo30502d();

    /* renamed from: e */
    boolean mo30503e();
}
