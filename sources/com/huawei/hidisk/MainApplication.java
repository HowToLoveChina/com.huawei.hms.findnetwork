package com.huawei.hidisk;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.SQLException;
import com.huawei.android.dynamicfeature.plugin.language.C2399g;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.common.account.C2744a;
import com.huawei.android.hicloud.common.exiter.CloudSyncExitProcessor;
import com.huawei.android.hicloud.manager.C2810a;
import com.huawei.android.hicloud.router.impl.C2873a;
import com.huawei.android.hicloud.router.impl.CloudSyncRouterImpl;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import il.C10542o;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0233r;
import p037bp.C1270a;
import p052cb.C1405b;
import p223db.C9062b;
import p226df.C9093a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9283b;
import p232dp.InterfaceC9284c;
import p232dp.InterfaceC9285d;
import p232dp.InterfaceC9287f;
import p311g7.C9889b;
import p487n7.C11652a;
import p514o9.C11839m;
import p572qb.C12301c;
import p575qe.C12347f;
import p800y6.C13912b;
import p835z7.C14151a;
import p847zk.C14311d;
import tf.C13010a;
import tj.C13019a;

/* loaded from: classes8.dex */
public class MainApplication extends Application {

    /* renamed from: com.huawei.hidisk.MainApplication$b */
    public static class C5034b extends BroadcastReceiver {
        public C5034b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C2399g.m15001a(context, intent);
        }
    }

    /* renamed from: a */
    public final void m30066a() {
        new LanguagePlugin().appOnCreate(this);
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacksM78348j = C13019a.m78347n().m78348j();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacksM69580d = C11652a.m69579e().m69580d();
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacksM8111c = C1405b.m8109e().m8111c();
        registerActivityLifecycleCallbacks(activityLifecycleCallbacksM78348j);
        registerActivityLifecycleCallbacks(activityLifecycleCallbacksM69580d);
        registerActivityLifecycleCallbacks(activityLifecycleCallbacksM8111c);
        SdkFaqManager.getSdk().init(this);
        m30067b();
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        C11839m.m70688i("MainApplication", "attachBaseContext");
        C0213f.m1380d(this);
        context.registerReceiver(new C5034b(), new IntentFilter("android.intent.action.LOCALE_CHANGED"));
    }

    /* renamed from: b */
    public final void m30067b() {
        C9062b.m57146k().m57161q(new C9889b());
        C9062b.m57146k().m57161q(new CloudSyncExitProcessor());
        C9062b.m57146k().m57161q(new C2744a());
        C9062b.m57146k().m57161q(new C14151a());
        C9062b.m57146k().m57161q(new C9093a());
    }

    /* renamed from: c */
    public final void m30068c() throws JSONException, IllegalAccessException, IOException, SQLException, IllegalArgumentException, InvocationTargetException {
        C2810a.m16477m().m16505r(getApplicationContext());
        C12301c.m73945b().m73948d(getApplicationContext());
        C12347f.m74285n().m74302o(getApplicationContext());
        CloudAlbumManager.m14456v().m14457A(getApplicationContext());
        C14311d.m85230g().m85237h(getApplicationContext());
    }

    /* renamed from: d */
    public final void m30069d() {
        C2873a c2873a = new C2873a();
        C13912b c13912b = new C13912b();
        CloudSyncRouterImpl cloudSyncRouterImpl = new CloudSyncRouterImpl();
        C10542o c10542o = new C10542o();
        C13010a c13010a = new C13010a();
        C1270a.m7534b().m7536c(InterfaceC9285d.class, c2873a);
        C1270a.m7534b().m7536c(InterfaceC9282a.class, c13912b);
        C1270a.m7534b().m7536c(InterfaceC9284c.class, cloudSyncRouterImpl);
        C1270a.m7534b().m7536c(InterfaceC9283b.class, c10542o);
        C1270a.m7534b().m7536c(InterfaceC9287f.class, c13010a);
    }

    @Override // android.app.Application
    public void onCreate() throws JSONException, IllegalAccessException, IOException, SQLException, IllegalArgumentException, InvocationTargetException {
        super.onCreate();
        C11839m.m70688i("MainApplication", "Rom Version: " + C0219i.m1463a());
        m30066a();
        m30069d();
        m30068c();
        C0233r.m1618b().m1620d();
    }
}
