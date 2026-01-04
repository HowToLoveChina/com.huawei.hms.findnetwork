package com.huawei.arengine.remoteLoader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.arengine.remoteLoader.IDynamicLoader;

/* loaded from: classes4.dex */
public interface ILoaderProducer extends IInterface {

    /* renamed from: com.huawei.arengine.remoteLoader.ILoaderProducer$a */
    public static abstract class AbstractBinderC4591a extends Binder implements ILoaderProducer {

        /* renamed from: com.huawei.arengine.remoteLoader.ILoaderProducer$a$a */
        public static class a implements ILoaderProducer {

            /* renamed from: b */
            public static ILoaderProducer f21113b;

            /* renamed from: a */
            public IBinder f21114a;

            public a(IBinder iBinder) {
                this.f21114a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21114a;
            }

            @Override // com.huawei.arengine.remoteLoader.ILoaderProducer
            public IDynamicLoader newDynamicLoader(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
                IDynamicLoader iDynamicLoaderM28128h;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.huawei.arengine.remoteLoader.ILoaderProducer");
                    parcelObtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    parcelObtain.writeStrongBinder(iObjectWrapper2 != null ? iObjectWrapper2.asBinder() : null);
                    if (this.f21114a.transact(1, parcelObtain, parcelObtain2, 0) || AbstractBinderC4591a.m28129g() == null) {
                        parcelObtain2.readException();
                        iDynamicLoaderM28128h = IDynamicLoader.AbstractBinderC4590a.m28128h(parcelObtain2.readStrongBinder());
                    } else {
                        iDynamicLoaderM28128h = AbstractBinderC4591a.m28129g().newDynamicLoader(iObjectWrapper, iObjectWrapper2);
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return iDynamicLoaderM28128h;
                } catch (Throwable th2) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th2;
                }
            }
        }

        /* renamed from: g */
        public static ILoaderProducer m28129g() {
            return a.f21113b;
        }

        /* renamed from: h */
        public static ILoaderProducer m28130h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.huawei.arengine.remoteLoader.ILoaderProducer");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILoaderProducer)) ? new a(iBinder) : (ILoaderProducer) iInterfaceQueryLocalInterface;
        }
    }

    IDynamicLoader newDynamicLoader(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2);
}
