package com.huawei.hms.hquic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.hms.framework.common.ExecutorsUtils;
import java.util.concurrent.ExecutorService;
import org.chromium.net.ApiVersion;

/* loaded from: classes8.dex */
public class HQUICManager {
    public static final String BUNDLE_CODE = "code";
    public static final String BUNDLE_MESSAGE = "message";
    public static final String HQUIC_MODULE_NAME = "huawei_module_quic";
    public static final String HQUIC_MODULE_NAME_PRO = "huawei_module_quic_pro";
    public static final String INTENT_VALUE = "resolution";

    /* renamed from: a */
    private static final String f25330a = "HQUICManager";

    /* renamed from: b */
    private static Context f25331b = null;

    /* renamed from: c */
    private static int f25332c = 0;

    /* renamed from: d */
    private static String f25333d = "0";

    /* renamed from: e */
    private static String f25334e = "";

    /* renamed from: f */
    private static String f25335f = "0";

    /* renamed from: g */
    private static String f25336g = "huawei_module_quic_pro";

    /* renamed from: h */
    private static String f25337h = "";

    /* renamed from: i */
    private static final ExecutorService f25338i = ExecutorsUtils.newSingleThreadExecutor("HQUICManager");

    public interface HQUICInitCallback {
        void onFail(Exception exc);

        void onSuccess();
    }

    /* renamed from: com.huawei.hms.hquic.HQUICManager$a */
    public static class RunnableC5581a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ HQUICInitCallback f25339a;

        /* renamed from: b */
        final /* synthetic */ Context f25340b;

        public RunnableC5581a(HQUICInitCallback hQUICInitCallback, Context context) {
            this.f25339a = hQUICInitCallback;
            this.f25340b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (HQUICManager.isAvailable()) {
                    this.f25339a.onSuccess();
                } else {
                    HQUICManager.m32855b(this.f25340b, this.f25339a);
                }
            } catch (Throwable th2) {
                Logger.m30744w(HQUICManager.f25330a, "load kit fail throwable :" + th2.getMessage());
                this.f25339a.onFail(new HQUICException(th2.getMessage()));
            }
        }
    }

    /* renamed from: a */
    private static Bundle m32847a(int i10, String str, Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putInt("code", i10);
        bundle.putString("message", str);
        if (i10 == 1 && intent != null) {
            bundle.putParcelable("resolution", intent);
        }
        return bundle;
    }

    public static void asyncInit(Context context, HQUICInitCallback hQUICInitCallback) {
        asyncInit(context, "huawei_module_quic", hQUICInitCallback);
    }

    /* renamed from: b */
    public static Context m32854b() {
        return f25331b;
    }

    /* renamed from: c */
    private static boolean m32856c() throws ClassNotFoundException {
        StringBuilder sb2;
        String str;
        ClassLoader classLoader;
        Class<?> clsLoadClass;
        if (f25331b == null) {
            return false;
        }
        int maximumAvailableApiLevel = ApiVersion.getMaximumAvailableApiLevel();
        String cronetVersion = ApiVersion.getCronetVersion();
        String lastChange = ApiVersion.getLastChange();
        try {
            classLoader = HQUICManager.class.getClassLoader();
        } catch (Exception e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "loadClass org.chromium.net.ApiVersion from cronet-api failure. Exception: ";
        }
        if (classLoader == null) {
            f25337h = "fail to get HQUICManager classLoader.";
            return false;
        }
        if (classLoader.loadClass("org.chromium.net.ApiVersion") == null) {
            f25337h = "fail to get ApiVersion classLoader.";
            return false;
        }
        try {
            clsLoadClass = f25331b.getClassLoader().loadClass("org.chromium.net.impl.ImplVersion");
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "getApiLevel OR getCronetVersion fail in the hQUIC, ";
        }
        if (clsLoadClass == null || classLoader == clsLoadClass.getClassLoader()) {
            f25337h = "implVersion is null OR Local hQUIC implVersion  is defaultClassLoader.";
            return false;
        }
        String str2 = (String) clsLoadClass.getMethod("getCronetVersion", new Class[0]).invoke(null, new Object[0]);
        String str3 = (String) clsLoadClass.getMethod("getLastChange", new Class[0]).invoke(null, new Object[0]);
        int iIntValue = ((Integer) clsLoadClass.getMethod("getApiLevel", new Class[0]).invoke(null, new Object[0])).intValue();
        if (maximumAvailableApiLevel > iIntValue) {
            sb2 = new StringBuilder();
            sb2.append("localApiLevel ");
            sb2.append(maximumAvailableApiLevel);
            sb2.append(" > dynamicApiLevel ");
            sb2.append(iIntValue);
            f25337h = sb2.toString();
            return false;
        }
        try {
            String str4 = (String) clsLoadClass.getMethod("getHwhttpVersion", new Class[0]).invoke(null, new Object[0]);
            Logger.m30742v(f25330a, "hQUIC verifyVersion successful: LocalApiLevel:" + maximumAvailableApiLevel + ", Local CronetVersion:" + cronetVersion + ", Local LastChange:" + lastChange + ", RemoteApiLevel:" + iIntValue + ", Remote CronetVersion:" + str2 + " ,remoteLastChange =" + str3 + " ,HwhttpVersion =" + str4);
            f25332c = iIntValue;
            f25333d = str2;
            f25334e = str3;
            f25335f = str4;
            return true;
        } catch (Exception e12) {
            e = e12;
            sb2 = new StringBuilder();
            str = "getHwhttpVersion fail in the hQUIC, ";
            sb2.append(str);
            sb2.append(e.getMessage());
            f25337h = sb2.toString();
            return false;
        }
    }

    public static int getRemoteCronetApiVersion() {
        return f25332c;
    }

    public static String getRemoteCronetVersion() {
        return f25333d;
    }

    public static String getRemoteHwhttpVersion() {
        return f25335f;
    }

    public static String getRemoteLastChange() {
        return f25334e;
    }

    public static boolean isAvailable() {
        return f25332c != 0;
    }

    public static synchronized Bundle upgradeKit(Context context) {
        try {
        } catch (Throwable th2) {
            Logger.m30744w(f25330a, "upgradeKit fail " + th2.getMessage());
            return m32847a(0, th2.getMessage(), (Intent) null);
        }
        return m32850a(context, true);
    }

    /* renamed from: a */
    private static Bundle m32848a(Context context) throws InterruptedException {
        try {
            Thread.sleep(500L);
            m32853a(DynamicModule.load(context, DynamicModule.PREFER_REMOTE, f25336g));
        } catch (DynamicModule.LoadingException | InterruptedException e10) {
            f25337h = "Try to reload hQUIC failed. " + e10.getMessage();
        }
        return m32847a(0, f25337h, (Intent) null);
    }

    public static void asyncInit(Context context, String str, HQUICInitCallback hQUICInitCallback) {
        f25336g = str;
        if (context == null || hQUICInitCallback == null) {
            Logger.m30744w(f25330a, "invalid argument :context == null || callBack == null");
            hQUICInitCallback.onFail(new IllegalArgumentException("invalid argument"));
        }
        f25338i.execute(new RunnableC5581a(hQUICInitCallback, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m32855b(Context context, HQUICInitCallback hQUICInitCallback) {
        m32850a(context, false);
        if (f25331b == null || !m32856c()) {
            hQUICInitCallback.onFail(new HQUICException(f25337h));
        } else {
            hQUICInitCallback.onSuccess();
        }
    }

    /* renamed from: a */
    private static Bundle m32849a(Context context, DynamicModule.LoadingException loadingException, boolean z10) {
        String str;
        Bundle bundle = loadingException.getBundle();
        if (bundle == null) {
            f25337h = "Load hQUIC failed, and no available bundle info.";
            return m32847a(0, "Load hQUIC failed, and no available bundle info.", (Intent) null);
        }
        int i10 = bundle.getInt(InterfaceC5323b.f24681h);
        if (z10 && i10 == 2) {
            Logger.m30740i(f25330a, "kit need upgrade");
            return m32847a(1, "kit need upgrade", (Intent) bundle.getParcelable("resolution"));
        }
        if (!z10 && i10 == 4) {
            Logger.m30740i(f25330a, "lazy reload kit");
            return m32848a(context);
        }
        if (i10 == 5) {
            str = "The HSF is not found on this device, could not load";
        } else {
            str = "errcode is:" + bundle.getInt(InterfaceC5323b.f24681h);
        }
        f25337h = str;
        Logger.m30740i(f25330a, f25337h);
        return m32847a(0, f25337h, (Intent) null);
    }

    /* renamed from: a */
    private static synchronized Bundle m32850a(Context context, boolean z10) {
        try {
            if (f25331b != null) {
                f25337h = "kit already load success";
                return m32847a(0, "kit already load success", (Intent) null);
            }
            Logger.m30740i(f25330a, "Start to load hQUIC :");
            DynamicModule.enable3rdPhone(f25336g, true);
            DynamicModule.enableLowEMUI(f25336g, true);
            m32853a(DynamicModule.loadV2(context, DynamicModule.PREFER_REMOTE, f25336g));
            return m32847a(0, "load kit success", (Intent) null);
        } catch (DynamicModule.LoadingException e10) {
            f25337h = e10.getMessage();
            return m32849a(context, e10, z10);
        }
    }

    /* renamed from: a */
    private static void m32853a(DynamicModule dynamicModule) {
        if (dynamicModule == null) {
            f25337h = "The hQUIC dynamicModule is null.";
        } else {
            f25331b = dynamicModule.getModuleContext();
        }
    }
}
