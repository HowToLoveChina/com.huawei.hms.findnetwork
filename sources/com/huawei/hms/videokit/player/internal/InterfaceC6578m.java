package com.huawei.hms.videokit.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

/* renamed from: com.huawei.hms.videokit.player.internal.m */
/* loaded from: classes8.dex */
public interface InterfaceC6578m extends IInterface {

    /* renamed from: com.huawei.hms.videokit.player.internal.m$a */
    public static abstract class a extends Binder implements InterfaceC6578m {

        /* renamed from: com.huawei.hms.videokit.player.internal.m$a$a, reason: collision with other inner class name */
        public static class C14448a implements InterfaceC6578m {

            /* renamed from: b */
            public static InterfaceC6578m f30530b;

            /* renamed from: a */
            private IBinder f30531a;

            public C14448a(IBinder iBinder) {
                this.f30531a = iBinder;
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6578m
            /* renamed from: a */
            public int mo37426a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, String str2, InterfaceC6579n interfaceC6579n) throws RemoteException {
                int iMo37426a;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IVideoInit");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeStrongBinder(iObjectWrapper2 != null ? iObjectWrapper2.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(interfaceC6579n != null ? interfaceC6579n.asBinder() : null);
                    if (this.f30531a.transact(5, parcelObtain, parcelObtain2, 0) || a.m37435g() == null) {
                        parcelObtain2.readException();
                        iMo37426a = parcelObtain2.readInt();
                    } else {
                        iMo37426a = a.m37435g().mo37426a(iObjectWrapper, iObjectWrapper2, str, str2, interfaceC6579n);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iMo37426a;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30531a;
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6578m
            /* renamed from: b */
            public void mo37430b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IVideoInit");
                    parcelObtain.writeString(str);
                    if (this.f30531a.transact(11, parcelObtain, parcelObtain2, 0) || a.m37435g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37435g().mo37430b(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6578m
            /* renamed from: d */
            public void mo37431d(boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IVideoInit");
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f30531a.transact(3, parcelObtain, parcelObtain2, 0) || a.m37435g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37435g().mo37431d(z10);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6578m
            /* renamed from: e */
            public String mo37432e() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IVideoInit");
                    if (this.f30531a.transact(6, parcelObtain, parcelObtain2, 0) || a.m37435g() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = a.m37435g().mo37432e();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6578m
            /* renamed from: f */
            public String mo37433f() throws RemoteException {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IVideoInit");
                    if (this.f30531a.transact(4, parcelObtain, parcelObtain2, 0) || a.m37435g() == null) {
                        parcelObtain2.readException();
                        string = parcelObtain2.readString();
                    } else {
                        string = a.m37435g().mo37433f();
                    }
                    return string;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6578m
            /* renamed from: a */
            public void mo37427a(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IVideoInit");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.f30531a.transact(9, parcelObtain, parcelObtain2, 0) || a.m37435g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37435g().mo37427a(iObjectWrapper);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6578m
            /* renamed from: a */
            public void mo37428a(IObjectWrapper iObjectWrapper, int i10, String str, int i11, int i12) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IVideoInit");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    if (this.f30531a.transact(8, parcelObtain, parcelObtain2, 0) || a.m37435g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37435g().mo37428a(iObjectWrapper, i10, str, i11, i12);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6578m
            /* renamed from: a */
            public void mo37429a(IObjectWrapper iObjectWrapper, boolean z10) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.hms.videokit.player.internal.IVideoInit");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    if (this.f30531a.transact(10, parcelObtain, parcelObtain2, 0) || a.m37435g() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.m37435g().mo37429a(iObjectWrapper, z10);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }
        }

        /* renamed from: a */
        public static InterfaceC6578m m37434a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.videokit.player.internal.IVideoInit");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC6578m)) ? new C14448a(iBinder) : (InterfaceC6578m) iInterfaceQueryLocalInterface;
        }

        /* renamed from: g */
        public static InterfaceC6578m m37435g() {
            return C14448a.f30530b;
        }
    }

    /* renamed from: a */
    int mo37426a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, String str2, InterfaceC6579n interfaceC6579n) throws RemoteException;

    /* renamed from: a */
    void mo37427a(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: a */
    void mo37428a(IObjectWrapper iObjectWrapper, int i10, String str, int i11, int i12) throws RemoteException;

    /* renamed from: a */
    void mo37429a(IObjectWrapper iObjectWrapper, boolean z10) throws RemoteException;

    /* renamed from: b */
    void mo37430b(String str) throws RemoteException;

    /* renamed from: d */
    void mo37431d(boolean z10) throws RemoteException;

    /* renamed from: e */
    String mo37432e() throws RemoteException;

    /* renamed from: f */
    String mo37433f() throws RemoteException;
}
