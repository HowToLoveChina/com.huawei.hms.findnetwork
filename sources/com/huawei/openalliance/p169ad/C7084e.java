package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.huawei.hms.ads.dynamic.DynamicModule;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.InterfaceC5110e;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.BinderC7289d;
import com.huawei.openalliance.p169ad.utils.AbstractC7791ck;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.e */
/* loaded from: classes8.dex */
public class C7084e {

    /* renamed from: a */
    private static volatile Context f32623a;

    /* renamed from: b */
    private static IRemoteCreator f32624b;

    /* renamed from: c */
    private static String f32625c;

    /* renamed from: d */
    private static InterfaceC5110e f32626d;

    /* renamed from: e */
    private static final List<String> f32627e;

    static {
        ArrayList arrayList = new ArrayList();
        f32627e = arrayList;
        arrayList.add(Constants.HW_INTELLIEGNT_PACKAGE);
    }

    /* renamed from: a */
    public static synchronized IRemoteCreator m42835a(Context context) {
        Context contextM42837b;
        AbstractC7185ho.m43820b("RemoteSdkInitializer", "newCreator: ");
        if (f32624b != null) {
            AbstractC7185ho.m43820b("RemoteSdkInitializer", "newCreator: mRemoteCreator != null return");
            return f32624b;
        }
        try {
            contextM42837b = m42837b(context);
        } catch (Throwable th2) {
            AbstractC7185ho.m43826d("RemoteSdkInitializer", "newCreator failed " + th2.getLocalizedMessage());
        }
        if (contextM42837b == null) {
            Log.i("RemoteSdkInitializer", "newCreator: remoteContext= null");
            return null;
        }
        IRemoteCreator iRemoteCreatorM30460a = IRemoteCreator.AbstractBinderC5103a.m30460a((IBinder) contextM42837b.getClassLoader().loadClass("com.huawei.hms.ads.uiengine.remote.RemoteCreator").newInstance());
        f32624b = iRemoteCreatorM30460a;
        f32625c = iRemoteCreatorM30460a.getVersion();
        f32624b.setGlobalUtil(BinderC7289d.m44236a(context));
        f32624b.setSdkInfo(AbstractC7807d.m48190A(context).intValue(), 30476300, null);
        f32626d = f32624b.getUiEngineUtil();
        Log.i("RemoteSdkInitializer", "newRemoteContext: mRemoteCreator :" + f32624b);
        return f32624b;
    }

    /* renamed from: b */
    private static Context m42837b(Context context) {
        AbstractC7185ho.m43820b("RemoteSdkInitializer", "newRemoteContext: ");
        if (f32623a != null) {
            return f32623a;
        }
        try {
            if (AbstractC7791ck.m48066a("com.huawei.hms.ads.common.inter.LoaderSpHandlerInter")) {
                DynamicModule.setSpHandler(C7117fa.m43188a(context));
            } else {
                AbstractC7185ho.m43826d("RemoteSdkInitializer", "LoaderSpHandler is not available");
            }
            if (AbstractC7791ck.m48066a("com.huawei.hms.ads.common.inter.LoaderCommonInter")) {
                DynamicModule.setCommonInter(C7115ez.m43186a(context));
            } else {
                AbstractC7185ho.m43826d("RemoteSdkInitializer", "LoaderCommonHandler is not available");
            }
            f32623a = DynamicModule.load(context, m42839c(context), "adsuiengine", "").getModuleContext();
        } catch (Throwable th2) {
            AbstractC7185ho.m43826d("RemoteSdkInitializer", "newRemoteContext failed: " + th2.getLocalizedMessage());
        }
        return f32623a;
    }

    /* renamed from: c */
    private static Integer m42839c(Context context) {
        return Integer.valueOf(f32627e.contains(context.getPackageName()) ? 2 : 1);
    }

    /* renamed from: a */
    public static synchronized String m42836a() {
        return f32625c;
    }

    /* renamed from: b */
    public static InterfaceC5110e m42838b() {
        return f32626d;
    }
}
