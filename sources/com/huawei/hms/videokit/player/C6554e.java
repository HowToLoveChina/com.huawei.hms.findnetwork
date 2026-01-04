package com.huawei.hms.videokit.player;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* renamed from: com.huawei.hms.videokit.player.e */
/* loaded from: classes8.dex */
public class C6554e {

    /* renamed from: d */
    private static int f30434d = 9999;

    /* renamed from: e */
    private static String f30435e = "dynamic load fail";

    /* renamed from: f */
    private static volatile C6554e f30436f;

    /* renamed from: g */
    private static DynamicModule f30437g;

    /* renamed from: a */
    private Context f30438a;

    /* renamed from: b */
    private boolean f30439b = false;

    /* renamed from: c */
    private boolean f30440c = true;

    private C6554e(Context context) {
        m37339b(context);
    }

    /* renamed from: a */
    public static int m37333a() {
        return f30434d;
    }

    /* renamed from: b */
    public static String m37338b() {
        return f30435e;
    }

    /* renamed from: c */
    public Context m37343c() {
        if (this.f30438a == null) {
            this.f30438a = f30437g.getModuleContext();
        }
        return this.f30438a;
    }

    /* renamed from: d */
    public boolean m37344d() {
        return this.f30440c;
    }

    /* renamed from: a */
    private Context m37334a(Context context, Bundle bundle) throws InterruptedException {
        String str;
        String str2;
        int i10 = bundle.getInt(InterfaceC5323b.f24681h);
        C6550c1.m37262b("LoadModule", "handleResultBundle errcode:" + i10);
        if (i10 != 1) {
            if (i10 == 2) {
                Intent intent = (Intent) bundle.getParcelable("resolution");
                if (intent == null) {
                    str2 = "null intent, please check it.";
                } else {
                    if (this.f30439b) {
                        return null;
                    }
                    this.f30439b = true;
                    C6550c1.m37264c("LoadModule", "get intent successfully.");
                    try {
                        Intent intent2 = new Intent(context, (Class<?>) UpdateActivity.class);
                        intent2.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
                        intent2.putExtras(bundle2);
                        context.startActivity(intent2);
                    } catch (Exception e10) {
                        C6550c1.m37258a("LoadModule", "startActivity error.ActivityNotFound :", e10);
                    }
                    this.f30440c = false;
                    m37336a(PlayerConstants.InitErrorCode.INIT_ERROR_DYNAMICLOADER_MODULE_NONE);
                    str = "dynamic loader module need update";
                }
            } else if (i10 == 4) {
                try {
                    Thread.sleep(3000L);
                    m37337a(DynamicModule.load(context, DynamicModule.PREFER_REMOTE, "huawei_module_videoplayer"));
                    DynamicModule dynamicModule = f30437g;
                    if (dynamicModule != null) {
                        return dynamicModule.getModuleContext();
                    }
                    C6550c1.m37262b("LoadModule", "the sDynamicModule is null.");
                    m37336a(PlayerConstants.InitErrorCode.INIT_ERROR_DYNAMICLOADER_FAILED);
                    return null;
                } catch (DynamicModule.LoadingException | InterruptedException e11) {
                    m37336a(PlayerConstants.InitErrorCode.INIT_ERROR_DYNAMICLOADER_FAILED);
                    C6550c1.m37258a("LoadModule", "try to reload failed.ex:", e11);
                }
            } else {
                if (i10 != 5) {
                    return null;
                }
                m37340b("device unsupport dynamic loader");
                str2 = "the DSF is not found on this device, could not load huawei_module_videoplayer";
            }
            C6550c1.m37262b("LoadModule", str2);
            return null;
        }
        m37336a(PlayerConstants.InitErrorCode.INIT_ERROR_DYNAMICLOADER_MODULE_NONE);
        str = "dynamic loader module don't exist";
        m37340b(str);
        return null;
    }

    /* renamed from: b */
    private void m37339b(Context context) {
        if (context == null) {
            m37336a(PlayerConstants.InitErrorCode.INIT_ERROR_PARAM_ILLEGAL);
            m37340b("init param illegal");
            C6550c1.m37262b("LoadModule", "context is null load fail");
            return;
        }
        try {
            C6550c1.m37264c("LoadModule", "ready to load dynamicModule");
            DynamicModule.enable3rdPhone("huawei_module_videoplayer", true);
            DynamicModule.enableLowEMUI("huawei_module_videoplayer", true);
            m37337a(DynamicModule.load(context.getApplicationContext(), DynamicModule.PREFER_HIGHEST_OR_REMOTE_VERSION, "huawei_module_videoplayer"));
            DynamicModule dynamicModule = f30437g;
            if (dynamicModule != null) {
                this.f30438a = dynamicModule.getModuleContext();
                C6550c1.m37264c("LoadModule", "remoteContext:" + this.f30438a);
            }
        } catch (DynamicModule.LoadingException e10) {
            Bundle bundle = e10.getBundle();
            if (bundle != null) {
                this.f30438a = m37334a(context, bundle);
                return;
            }
            C6550c1.m37262b("LoadModule", "load failed, and no available bundle info.");
            m37336a(PlayerConstants.InitErrorCode.INIT_ERROR_DYNAMICLOADER_MODULE_NONE);
            m37340b("dynamic loader module don't exist");
        } catch (Exception e11) {
            C6550c1.m37258a("LoadModule", "dynamicModule load error:", e11);
        }
    }

    /* renamed from: b */
    private static void m37340b(String str) {
        f30435e = str;
    }

    /* renamed from: a */
    public IBinder m37341a(String str) {
        try {
            return (IBinder) f30436f.m37343c().getClassLoader().loadClass(str).newInstance();
        } catch (Exception e10) {
            C6550c1.m37258a("LoadModule", "getIBinder fail ", e10);
            return null;
        }
    }

    /* renamed from: a */
    public static C6554e m37335a(Context context) {
        if (f30436f == null) {
            synchronized (C6554e.class) {
                try {
                    if (f30436f == null) {
                        f30436f = new C6554e(context);
                    }
                } finally {
                }
            }
        } else if (f30437g == null) {
            f30436f.m37339b(context);
        }
        return f30436f;
    }

    /* renamed from: a */
    private static void m37336a(int i10) {
        f30434d = i10;
    }

    /* renamed from: a */
    private static void m37337a(DynamicModule dynamicModule) {
        f30437g = dynamicModule;
    }

    /* renamed from: a */
    public void m37342a(boolean z10) {
        this.f30440c = z10;
    }
}
