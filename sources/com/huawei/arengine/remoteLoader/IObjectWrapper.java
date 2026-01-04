package com.huawei.arengine.remoteLoader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public interface IObjectWrapper extends IInterface {

    /* renamed from: com.huawei.arengine.remoteLoader.IObjectWrapper$a */
    public static abstract class AbstractBinderC4592a extends Binder implements IObjectWrapper {
        private static final String DESCRIPTOR = "com.huawei.arengine.remoteLoader.IObjectWrapper";

        /* renamed from: com.huawei.arengine.remoteLoader.IObjectWrapper$a$a */
        public static class a implements IObjectWrapper {

            /* renamed from: b */
            public static IObjectWrapper f21115b;

            /* renamed from: a */
            public IBinder f21116a;

            public a(IBinder iBinder) {
                this.f21116a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21116a;
            }
        }

        public AbstractBinderC4592a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IObjectWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IObjectWrapper)) ? new a(iBinder) : (IObjectWrapper) iInterfaceQueryLocalInterface;
        }

        public static IObjectWrapper getDefaultImpl() {
            return a.f21115b;
        }

        public static boolean setDefaultImpl(IObjectWrapper iObjectWrapper) {
            if (a.f21115b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iObjectWrapper == null) {
                return false;
            }
            a.f21115b = iObjectWrapper;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }
}
