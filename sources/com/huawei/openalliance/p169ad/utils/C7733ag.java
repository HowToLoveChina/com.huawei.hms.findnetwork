package com.huawei.openalliance.p169ad.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.openalliance.ad.utils.ag */
/* loaded from: classes2.dex */
public class C7733ag {

    /* renamed from: com.huawei.openalliance.ad.utils.ag$a */
    public static final class a {

        /* renamed from: a */
        private final String f35805a;

        /* renamed from: b */
        private final boolean f35806b;

        public a(String str, boolean z10) {
            this.f35805a = str;
            this.f35806b = z10;
        }

        /* renamed from: a */
        public String m47479a() {
            return this.f35805a;
        }

        /* renamed from: b */
        public boolean m47480b() {
            return this.f35806b;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.ag$b */
    public static final class b implements ServiceConnection {

        /* renamed from: a */
        boolean f35807a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f35808b;

        private b() {
            this.f35807a = false;
            this.f35808b = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public IBinder m47481a() {
            if (this.f35807a) {
                throw new IllegalStateException();
            }
            this.f35807a = true;
            return this.f35808b.poll(100L, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws InterruptedException {
            try {
                AbstractC7185ho.m43818a("GaidUtil", "onServiceConnected %d", Long.valueOf(System.currentTimeMillis()));
                if (iBinder != null) {
                    this.f35808b.put(iBinder);
                }
            } catch (InterruptedException unused) {
                AbstractC7185ho.m43823c("GaidUtil", "onServiceConnected InterruptedException " + System.currentTimeMillis());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AbstractC7185ho.m43818a("GaidUtil", "onServiceDisconnected %d", Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: com.huawei.openalliance.ad.utils.ag$c */
    public static final class c implements IInterface {

        /* renamed from: a */
        private IBinder f35809a;

        public c(IBinder iBinder) {
            this.f35809a = iBinder;
        }

        /* renamed from: a */
        public String m47482a() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f35809a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f35809a;
        }

        /* renamed from: b */
        public boolean m47483b() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(1);
                this.f35809a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    /* renamed from: a */
    public static a m47474a(final Context context) {
        final C7787cg c7787cgM47900a = C7787cg.m47900a(context);
        if (c7787cgM47900a == null) {
            return null;
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ag.1
            @Override // java.lang.Runnable
            public void run() {
                a aVarM47477d = C7733ag.m47477d(context);
                if (aVarM47477d != null) {
                    c7787cgM47900a.m47921E(aVarM47477d.m47479a());
                    c7787cgM47900a.m47950a(Boolean.valueOf(aVarM47477d.m47480b()));
                }
            }
        });
        String strM47930J = c7787cgM47900a.m47930J();
        Boolean boolM47932K = c7787cgM47900a.m47932K();
        if (AbstractC7806cz.m48165b(strM47930J) || boolM47932K == null) {
            return null;
        }
        return new a(strM47930J, boolM47932K.booleanValue());
    }

    /* renamed from: b */
    public static boolean m47475b(Context context) {
        return !C6982bz.m41148a(context).mo41175d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static a m47477d(Context context) {
        String str;
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage(Constants.GMS_PGK);
        if (context.bindService(intent, bVar, 1)) {
            AbstractC7185ho.m43817a("GaidUtil", "bind ok");
            try {
                try {
                    IBinder iBinderM47481a = bVar.m47481a();
                    if (iBinderM47481a == null) {
                        return null;
                    }
                    c cVar = new c(iBinderM47481a);
                    a aVar = new a(cVar.m47482a(), cVar.m47483b());
                    AbstractC7185ho.m43818a("GaidUtil", "gaid: %s", AbstractC7806cz.m48176g(aVar.f35805a));
                    return aVar;
                } catch (RemoteException unused) {
                    str = "bind gms service RemoteException";
                    AbstractC7185ho.m43826d("GaidUtil", str);
                    return null;
                } catch (IllegalStateException unused2) {
                    str = "bind gms service IllegalStateException";
                    AbstractC7185ho.m43826d("GaidUtil", str);
                    return null;
                } catch (InterruptedException unused3) {
                    str = "bind gms service InterruptedException";
                    AbstractC7185ho.m43826d("GaidUtil", str);
                    return null;
                }
            } finally {
                context.unbindService(bVar);
            }
        }
        AbstractC7185ho.m43817a("GaidUtil", "bind failed");
        return null;
    }
}
