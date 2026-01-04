package com.huawei.hms.feature.dynamic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.IDynamicInstall;
import com.huawei.hms.feature.dynamic.IDynamicLoader;
import com.huawei.hms.feature.dynamic.p118e.C5326a;
import com.huawei.hms.feature.dynamic.p118e.C5328c;
import com.huawei.hms.feature.dynamic.p118e.C5329d;
import com.huawei.hms.feature.dynamic.p118e.C5330e;
import com.huawei.hms.feature.dynamic.p119f.C5333c;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes8.dex */
public class DynamicModule {
    public static final int MODULE_INTER_ERROR = 3;
    public static final int MODULE_NEED_UPDATE = 2;
    public static final int MODULE_NORMAL = 0;
    public static final int MODULE_NOT_EXIST = 1;
    public static final int MODULE_NOT_PRESET_HSF = 5;
    public static final int MODULE_NOT_READY = 4;

    /* renamed from: c */
    public static final int f24614c = 256;

    /* renamed from: d */
    public static final int f24615d = -100;

    /* renamed from: i */
    public static int f24620i = 0;

    /* renamed from: j */
    public static final int f24621j = 1;

    /* renamed from: k */
    public static final int f24622k = 2;

    /* renamed from: l */
    public static int f24623l;

    /* renamed from: a */
    public Context f24626a;
    public static final VersionPolicy PREFER_REMOTE = new C5330e();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new C5328c();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new C5329d();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new C5330e();

    /* renamed from: b */
    public static final String f24613b = DynamicModule.class.getSimpleName();

    /* renamed from: e */
    public static final ThreadLocal<HashMap<String, Boolean>> f24616e = new ThreadLocal<>();

    /* renamed from: f */
    public static final ThreadLocal<HashMap<String, String>> f24617f = new ThreadLocal<>();

    /* renamed from: g */
    public static final ThreadLocal<HashMap<String, IDynamicLoader>> f24618g = new ThreadLocal<>();

    /* renamed from: h */
    public static final ThreadLocal<HashMap<String, ClassLoader>> f24619h = new ThreadLocal<>();

    /* renamed from: m */
    public static HashMap<String, Boolean> f24624m = new HashMap<>();

    /* renamed from: n */
    public static HashMap<String, Boolean> f24625n = new HashMap<>();

    public static class DynamicLoaderClassLoader {

        /* renamed from: a */
        public static HashMap<String, ClassLoader> f24627a = new HashMap<>();

        public static ClassLoader getsClassLoader(String str) {
            return f24627a.get(str);
        }

        public static void setsClassLoader(String str, ClassLoader classLoader) {
            f24627a.put(str, classLoader);
        }
    }

    public static class LoadingException extends Exception {

        /* renamed from: a */
        public Bundle f24628a;

        public LoadingException(String str) {
            super(str);
        }

        public Bundle getBundle() {
            return this.f24628a;
        }

        public LoadingException(String str, Bundle bundle) {
            super(str);
            this.f24628a = bundle;
        }
    }

    public interface VersionPolicy {
        Bundle getModuleInfo(Context context, String str) throws LoadingException;
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DynamicModule$a */
    public static class C5312a extends HashMap<String, ClassLoader> {

        /* renamed from: a */
        public final /* synthetic */ String f24629a;

        /* renamed from: b */
        public final /* synthetic */ ClassLoader f24630b;

        public C5312a(String str, ClassLoader classLoader) {
            this.f24629a = str;
            this.f24630b = classLoader;
            put(str, classLoader);
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DynamicModule$b */
    public static class C5313b extends HashMap<String, ClassLoader> {

        /* renamed from: a */
        public final /* synthetic */ String f24631a;

        /* renamed from: b */
        public final /* synthetic */ ClassLoader f24632b;

        public C5313b(String str, ClassLoader classLoader) {
            this.f24631a = str;
            this.f24632b = classLoader;
            put(str, classLoader);
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DynamicModule$c */
    public static class CallableC5314c implements Callable<Bundle> {

        /* renamed from: a */
        public final /* synthetic */ Context f24633a;

        /* renamed from: b */
        public final /* synthetic */ Bundle f24634b;

        public CallableC5314c(Context context, Bundle bundle) {
            this.f24633a = context;
            this.f24634b = bundle;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Bundle call() {
            try {
                return DynamicModule.queryHMSModuleBundle(this.f24633a, InterfaceC5323b.f24678e, this.f24634b);
            } catch (Exception e10) {
                Logger.m30745w(DynamicModule.f24613b, "Query provider error.", e10);
                return new Bundle();
            }
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DynamicModule$d */
    public static class C5315d extends HashMap<String, Boolean> {

        /* renamed from: a */
        public final /* synthetic */ String f24635a;

        public C5315d(String str) {
            this.f24635a = str;
            put(str, Boolean.TRUE);
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DynamicModule$e */
    public static class C5316e extends HashMap<String, String> {

        /* renamed from: a */
        public final /* synthetic */ String f24636a;

        /* renamed from: b */
        public final /* synthetic */ String f24637b;

        public C5316e(String str, String str2) {
            this.f24636a = str;
            this.f24637b = str2;
            put(str, str2);
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DynamicModule$f */
    public static class C5317f extends HashMap<String, IDynamicLoader> {

        /* renamed from: a */
        public final /* synthetic */ String f24638a;

        /* renamed from: b */
        public final /* synthetic */ IBinder f24639b;

        public C5317f(String str, IBinder iBinder) {
            this.f24638a = str;
            this.f24639b = iBinder;
            put(str, IDynamicLoader.Stub.asInterface(iBinder));
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.DynamicModule$g */
    public static class C5318g extends Exception {
        public C5318g(String str) {
            super(str);
        }

        public /* synthetic */ C5318g(String str, C5312a c5312a) {
            this(str);
        }
    }

    public DynamicModule(Context context) {
        this.f24626a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0106  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m31853a(android.content.Context r9, java.lang.String r10, android.os.Bundle r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.DynamicModule.m31853a(android.content.Context, java.lang.String, android.os.Bundle):int");
    }

    /* renamed from: b */
    public static Bundle m31867b(Context context, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, LoadingException, InvocationTargetException {
        boolean z10 = false;
        try {
            try {
                Class<?> clsM31862a = m31862a(context);
                Method declaredMethod = clsM31862a.getDeclaredMethod("getsClassLoader", String.class);
                Method declaredMethod2 = clsM31862a.getDeclaredMethod("setsClassLoader", String.class, ClassLoader.class);
                ClassLoader classLoader = (ClassLoader) declaredMethod.invoke(null, str);
                if (classLoader == null) {
                    try {
                        String str2 = f24613b;
                        Logger.m30740i(str2, "No available cached loader, query remote.");
                        Bundle bundleM31871c = m31871c(context, str);
                        synchronized (DynamicModule.class) {
                            try {
                                HashMap<String, String> map = f24617f.get();
                                Objects.requireNonNull(map);
                                String str3 = map.get(str);
                                if (TextUtils.isEmpty(str3)) {
                                    return bundleM31871c;
                                }
                                if (!C5333c.m31893a(context, str3)) {
                                    Logger.m30744w(str2, "The loaderPath is invalid.");
                                    throw new LoadingException("getHMSModuleInfo: checkPathValidity failed.");
                                }
                                C5326a c5326a = new C5326a(str3, ClassLoader.getSystemClassLoader());
                                m31865a(str, c5326a);
                                declaredMethod2.invoke(null, str, c5326a);
                                f24616e.set(new C5315d(str));
                                return bundleM31871c;
                            } finally {
                            }
                        }
                    } catch (C5318g unused) {
                    }
                } else if (classLoader != ClassLoader.getSystemClassLoader()) {
                    Logger.m30740i(f24613b, "Cached loader is available, ready to use it.");
                    try {
                        m31865a(str, classLoader);
                    } catch (LoadingException e10) {
                        Logger.m30745w(f24613b, "Get loader interface failed.", e10);
                    }
                    z10 = true;
                }
            } catch (LoadingException e11) {
                throw e11;
            }
        } catch (Exception e12) {
            Logger.m30745w(f24613b, "failed to load.", e12);
        }
        HashMap<String, Boolean> map2 = new HashMap<>();
        map2.put(str, Boolean.valueOf(z10));
        f24616e.set(map2);
        return new Bundle();
    }

    /* renamed from: c */
    public static Bundle m31871c(Context context, String str) throws C5318g, LoadingException {
        try {
            Bundle bundleQueryHMSModuleBundle = queryHMSModuleBundle(context, str);
            String string = bundleQueryHMSModuleBundle.getString(InterfaceC5323b.f24691r);
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                f24617f.set(new C5316e(str, string));
                Logger.m30740i(f24613b, "Query remote version by module name:" + str + " success.");
                return bundleQueryHMSModuleBundle;
            }
            Logger.m30744w(f24613b, "The loader_path:" + string + " in query bundle is not available,change the module version to:-100");
            bundleQueryHMSModuleBundle.putInt(InterfaceC5323b.f24684k, -100);
            return bundleQueryHMSModuleBundle;
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception unused) {
            throw new C5318g("failed to Query remote version.", null);
        }
    }

    public static void enable3rdPhone(String str, boolean z10) {
        f24624m.put(str, Boolean.valueOf(z10));
    }

    public static void enableLowEMUI(String str, boolean z10) {
        f24625n.put(str, Boolean.valueOf(z10));
    }

    public static Set<String> getInstalledModuleInfo() {
        return C5325d.m31884a().f24707a;
    }

    public static Bundle getLocalModuleInfo(Context context, String str) {
        int localVersion = getLocalVersion(context, str);
        Bundle bundle = new Bundle();
        bundle.putString("module_name", str);
        bundle.putInt(InterfaceC5323b.f24685l, localVersion);
        return bundle;
    }

    public static int getLocalVersion(Context context, String str) {
        if (context == null || str.length() == 0 || str.length() > 256) {
            Logger.m30737e(f24613b, "Invalid context or moduleName.");
            return 0;
        }
        try {
            String str2 = AssetLoadManager.f24592d + str + ".ModuleDescriptor";
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return context.getClassLoader().loadClass(str2).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            Logger.m30744w(f24613b, "Cannot find the class of module descriptor for " + str);
            return 0;
        } catch (Exception e10) {
            Logger.m30745w(f24613b, "Get local module info failed.", e10);
            return 0;
        }
    }

    public static Bundle getRemoteModuleInfo(Context context, String str) throws LoadingException {
        try {
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception e11) {
            Logger.m30745w(f24613b, "Get remote module info for " + str + " failed.", e11);
        }
        synchronized (DynamicModule.class) {
            try {
                ThreadLocal<HashMap<String, Boolean>> threadLocal = f24616e;
                if (threadLocal.get() == null || threadLocal.get().get(str) == null || !threadLocal.get().get(str).booleanValue()) {
                    Bundle bundleM31867b = m31867b(context, str);
                    if (bundleM31867b.getInt(InterfaceC5323b.f24684k) > 0) {
                        return bundleM31867b;
                    }
                }
                if (threadLocal.get().get(str).booleanValue()) {
                    try {
                        return m31871c(context, str);
                    } catch (C5318g e12) {
                        Logger.m30745w(f24613b, "Query remote module info in HMS failed.", e12);
                    }
                }
                return new Bundle();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static int getRemoteVersion(Context context, String str) throws LoadingException {
        try {
            Bundle bundleM31871c = m31871c(context, str);
            if (bundleM31871c != null && !bundleM31871c.isEmpty()) {
                return bundleM31871c.getInt(InterfaceC5323b.f24684k);
            }
            Logger.m30744w(f24613b, "Query remote module:" + str + " info failed.");
            throw new LoadingException("Query remote module info failed: null or empty.");
        } catch (C5318g e10) {
            Logger.m30744w(f24613b, "Query remote module:" + str + " exception:" + e10);
            return 0;
        }
    }

    public static void install(Context context, int i10) throws LoadingException {
        String str = f24613b;
        Logger.m30740i(str, "dynamic-api version: 10024300");
        if (context == null) {
            Logger.m30737e(str, "The input context is null.");
            return;
        }
        try {
            f24623l = i10;
            Logger.m30740i(str, "Query HMS provider timeOut is set to:" + f24623l + " ms.");
            IDynamicInstall iDynamicInstallM31870b = m31870b(context);
            if (iDynamicInstallM31870b == null) {
                throw new LoadingException("Get dynamicInstaller failed.");
            }
            Bundle bundleInstall = iDynamicInstallM31870b.install(ObjectWrapper.wrap(context), new Bundle());
            if (bundleInstall == null) {
                throw new LoadingException("Get install info failed: moduleBundle is null.");
            }
            C5325d.m31884a().m31885a(bundleInstall);
            Logger.m30740i(str, "Install module success.");
        } catch (RemoteException | LoadingException | NullPointerException e10) {
            if (f24620i == 2 || getLocalVersion(context, InterfaceC5323b.f24678e) <= 0) {
                Logger.m30745w(f24613b, "Install module failed.", e10);
                return;
            }
            String str2 = f24613b;
            Logger.m30740i(str2, "Ready to use local loader-fallback to retry:");
            try {
                Bundle bundleInstall2 = m31873c(context).install(ObjectWrapper.wrap(context), new Bundle());
                if (bundleInstall2 == null) {
                    throw new LoadingException("Retry: get install info failed: moduleBundle is null.");
                }
                C5325d.m31884a().m31885a(bundleInstall2);
                Logger.m30740i(str2, "Retry install module with local loader-fallback success.");
            } catch (RemoteException | LoadingException | NullPointerException e11) {
                Logger.m30745w(f24613b, "Retry failed with local loader-fallback.", e11);
            }
        }
    }

    public static DynamicModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return m31868b(context, versionPolicy, str, new Bundle());
    }

    public static DynamicModule loadV2(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        Bundle bundle = new Bundle();
        bundle.putString(InterfaceC5323b.f24692s, InterfaceC5323b.f24693t);
        return m31868b(context, versionPolicy, str, bundle);
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return loadV3(context, versionPolicy, str, new Bundle());
    }

    public static Bundle queryHMSModuleBundle(Context context, String str) throws C5318g, LoadingException {
        return queryHMSModuleBundle(context, str, null);
    }

    public final Context getModuleContext() {
        return this.f24626a;
    }

    /* renamed from: a */
    public static int m31854a(VersionPolicy versionPolicy) {
        if (versionPolicy instanceof C5330e) {
            return 1;
        }
        if (versionPolicy instanceof C5329d) {
            return 2;
        }
        return versionPolicy instanceof C5328c ? 3 : 0;
    }

    /* renamed from: b */
    public static DynamicModule m31868b(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws Throwable {
        String str2 = f24613b;
        Logger.m30740i(str2, "dynamic-api version: 10024300");
        m31864a(context, versionPolicy, str, bundle);
        try {
            int iM31853a = m31853a(context, str, bundle);
            if (iM31853a >= 10015300) {
                Logger.m30740i(str2, "Load start in new-version-policy.");
                return m31859a(context, str, versionPolicy, bundle);
            }
            if (iM31853a <= 0) {
                throw new LoadingException("Cannot find a valid dynamicLoader in HMS and local.");
            }
            Logger.m30740i(str2, "Load start in old-version-policy.");
            return m31858a(context, str, versionPolicy);
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception e11) {
            Logger.m30737e(f24613b, "Other exception:" + e11);
            throw new LoadingException("Load failed.");
        }
    }

    /* renamed from: c */
    public static DynamicModule m31872c(Context context, String str, Bundle bundle) throws LoadingException {
        Boolean bool;
        IDynamicLoader iDynamicLoader;
        try {
            synchronized (DynamicModule.class) {
                HashMap<String, Boolean> map = f24616e.get();
                Objects.requireNonNull(map);
                bool = map.get(str);
                HashMap<String, IDynamicLoader> map2 = f24618g.get();
                Objects.requireNonNull(map2);
                iDynamicLoader = map2.get(str);
            }
            if (bool == null || iDynamicLoader == null) {
                throw new LoadingException("The loader for " + str + " was not prepared.");
            }
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Context contextM31855a = m31855a(context, str, bundle, iDynamicLoader);
            if (contextM31855a != null) {
                return new DynamicModule(contextM31855a);
            }
            throw new LoadingException("Failed to get remote module context: null");
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception unused) {
            throw new LoadingException("Load Module Error.");
        }
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        bundle.putString(InterfaceC5323b.f24692s, InterfaceC5323b.f24694u);
        return m31868b(context, versionPolicy, str, bundle);
    }

    public static Bundle queryHMSModuleBundle(Context context, String str, Bundle bundle) throws C5318g, LoadingException {
        C5312a c5312a = null;
        try {
            if (!C5333c.m31892a(context)) {
                Logger.m30744w(f24613b, "No valid HMS Core in this device.");
                throw new C5318g("HMS Core is not installed.", c5312a);
            }
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                throw new C5318g("Query remote version failed: null contentResolver.", c5312a);
            }
            Bundle bundleCall = contentResolver.call(Uri.parse(InterfaceC5323b.f24674a), str, (String) null, bundle);
            if (bundleCall == null) {
                Logger.m30744w(f24613b, "Failed to get bundle info:null.");
                throw new C5318g("Query remote version failed: null bundle info.", c5312a);
            }
            int i10 = bundleCall.getInt(InterfaceC5323b.f24681h);
            String string = bundleCall.getString(InterfaceC5323b.f24691r);
            String str2 = f24613b;
            Logger.m30740i(str2, "bundle info: errorCode:" + i10 + ", moduleVersion:" + bundleCall.getInt(InterfaceC5323b.f24684k) + ", modulePath:" + bundleCall.getString(InterfaceC5323b.f24687n) + ", loader_version:" + bundleCall.getInt(InterfaceC5323b.f24690q) + ", loaderPath:" + string + ", armeabiType:" + bundleCall.getInt(InterfaceC5323b.f24695v));
            if (i10 == 0) {
                return bundleCall;
            }
            Logger.m30744w(str2, "Failed to get " + str + " bundle info, errcode:" + i10);
            throw new LoadingException("Query " + str + " unavailable, errorCode:" + i10, bundleCall);
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception unused) {
            throw new C5318g("failed to get :" + str + " info from HMS Core.", c5312a);
        }
    }

    /* renamed from: a */
    public static Context m31855a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) throws LoadingException {
        try {
            IObjectWrapper iObjectWrapperLoad = iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt(InterfaceC5323b.f24684k), ObjectWrapper.wrap(bundle));
            Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapperLoad);
            if (objUnwrap == null) {
                Logger.m30744w(f24613b, "Get remote context is null, module:" + str);
                return null;
            }
            if (objUnwrap instanceof Context) {
                Logger.m30740i(f24613b, "Get context for module:" + str + " success.");
                return (Context) objUnwrap;
            }
            if (objUnwrap instanceof Bundle) {
                Logger.m30740i(f24613b, "Get module info bundle for " + str);
                return m31856a(context, str, bundle, iDynamicLoader, (Bundle) objUnwrap);
            }
            if (objUnwrap.getClass().getName().equals(LoadingException.class.getName())) {
                Bundle bundle2 = (Bundle) ObjectWrapper.unwrap(iObjectWrapperLoad).getClass().getDeclaredMethod("getBundle", new Class[0]).invoke(ObjectWrapper.unwrap(iObjectWrapperLoad), new Object[0]);
                Logger.m30744w(f24613b, "Successfully get the bundle in exception.");
                throw new LoadingException("Failed to load, please check the bundle in exception.", bundle2);
            }
            Logger.m30744w(f24613b, "Get remote context is null, module:" + str);
            return null;
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception e11) {
            Logger.m30745w(f24613b, "Failed to get module context for:" + str, e11);
            return null;
        }
    }

    /* renamed from: b */
    public static DynamicModule m31869b(Context context, String str, Bundle bundle) throws LoadingException {
        ClassLoader classLoader;
        synchronized (DynamicModule.class) {
            try {
                ThreadLocal<HashMap<String, ClassLoader>> threadLocal = f24619h;
                if (threadLocal.get() == null || threadLocal.get().get(str) == null) {
                    Logger.m30740i(f24613b, "No available cached loader for module:" + str);
                    classLoader = null;
                } else {
                    Logger.m30740i(f24613b, "Cached loader for module is available, ready to use it.");
                    classLoader = threadLocal.get().get(str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        IDynamicLoader iDynamicLoaderM31861a = m31861a(context, str, bundle.getString(InterfaceC5323b.f24691r), classLoader);
        if (iDynamicLoaderM31861a == null) {
            throw new LoadingException("Failed to get iDynamicLoader: null.");
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Context contextM31855a = m31855a(context, str, bundle, iDynamicLoaderM31861a);
        if (contextM31855a != null) {
            return new DynamicModule(contextM31855a);
        }
        throw new LoadingException("New version policy: Failed to get module context: null.");
    }

    /* renamed from: c */
    public static IDynamicInstall m31873c(Context context) throws LoadingException {
        try {
            return (IDynamicInstall) context.getClassLoader().loadClass(InterfaceC5323b.f24680g).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new LoadingException("getLocalLoaderFallback: failed to instantiate dynamic loader: " + e10.getMessage());
        }
    }

    /* renamed from: a */
    public static Context m31856a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader, Bundle bundle2) throws SecurityException, LoadingException {
        Object objUnwrap;
        bundle.putInt(InterfaceC5323b.f24696w, 4);
        if (AssetLoadManager.getAssetModuleInfo(context, str).getInt(InterfaceC5323b.f24686m, 0) <= 0) {
            Logger.m30740i(f24613b, "No fallback module in assets.");
            throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
        }
        try {
            objUnwrap = ObjectWrapper.unwrap(iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt(InterfaceC5323b.f24684k), ObjectWrapper.wrap(bundle)));
        } catch (RemoteException e10) {
            Logger.m30745w(f24613b, "tryWithAssetsModule RemoteException.", e10);
            objUnwrap = null;
        }
        if (!(objUnwrap instanceof Context)) {
            Logger.m30744w(f24613b, "tryWithAssetsModule get dynamicContext failed: null or wrong type.");
            throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
        }
        Logger.m30740i(f24613b, "get dynamic module context for:" + str + " from assets fallback success.");
        return (Context) objUnwrap;
    }

    /* renamed from: b */
    public static IDynamicInstall m31870b(Context context) throws LoadingException {
        int i10;
        String string = null;
        int localVersion = 0;
        try {
            Bundle bundleM31857a = m31857a(context, (Bundle) null);
            string = bundleM31857a.getString(InterfaceC5323b.f24691r);
            i10 = bundleM31857a.getInt(InterfaceC5323b.f24690q);
        } catch (Exception e10) {
            Logger.m30745w(f24613b, "Cannot get remote HMS dynamicLoader.", e10);
            i10 = 0;
        }
        try {
            localVersion = getLocalVersion(context, InterfaceC5323b.f24678e);
        } catch (Exception e11) {
            Logger.m30745w(f24613b, "Cannot find local dynamicLoader fallback.", e11);
        }
        String str = f24613b;
        Logger.m30740i(str, "DynamicLoader remoteHMSVersion:" + i10 + ", hmsLoaderPath:" + string + ", localLoaderVersion:" + localVersion);
        int iMax = Math.max(i10, localVersion);
        if (iMax > 10009300) {
            if (i10 <= localVersion) {
                Logger.m30740i(str, "Choose local dynamicLoader fallback: ");
                f24620i = 2;
                return m31873c(context);
            }
            Logger.m30740i(str, "Choose hms dynamicLoader: " + string);
            f24620i = 1;
            return m31860a(context, string);
        }
        Logger.m30744w(str, "The current version:" + iMax + " is too low.");
        throw new LoadingException("The loader version:" + iMax + " is too low to support HFF.");
    }

    /* renamed from: a */
    public static Bundle m31857a(Context context, Bundle bundle) throws C5318g {
        C5312a c5312a = null;
        try {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            FutureTask futureTask = new FutureTask(new CallableC5314c(context, bundle));
            executorServiceNewSingleThreadExecutor.execute(futureTask);
            Bundle bundle2 = (Bundle) futureTask.get(f24623l, TimeUnit.MILLISECONDS);
            String string = bundle2.getString(InterfaceC5323b.f24691r);
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                Logger.m30740i(f24613b, "Query HMS module:huawei_module_dynamicloader info success.");
                return bundle2;
            }
            Logger.m30744w(f24613b, "The loader_path:" + string + " is not available.");
            throw new C5318g("The loader_path in queryBundle is empty or not exist.", c5312a);
        } catch (TimeoutException unused) {
            Logger.m30744w(f24613b, "Query hms provider timeout: over " + f24623l + " ms, choose the local loader fallback.");
            return new Bundle();
        } catch (Exception e10) {
            Logger.m30745w(f24613b, "FutureTask: query provider exception.", e10);
            throw new C5318g("failed to get :huawei_module_dynamicloader info.", c5312a);
        }
    }

    /* renamed from: a */
    public static DynamicModule m31858a(Context context, String str, VersionPolicy versionPolicy) throws LoadingException {
        Bundle moduleInfo = versionPolicy.getModuleInfo(context, str);
        if (moduleInfo.getInt(InterfaceC5323b.f24684k) <= 0) {
            if (moduleInfo.getInt(InterfaceC5323b.f24685l) <= 0) {
                throw new LoadingException("Query remote version and local version failed.");
            }
            Logger.m30740i(f24613b, "Remote version is invalid, use local context.");
            return new DynamicModule(context.getApplicationContext());
        }
        try {
            return m31872c(context, str, moduleInfo);
        } catch (LoadingException e10) {
            Logger.m30745w(f24613b, "Failed to load remote module.", e10);
            if (getLocalVersion(context, str) <= 0) {
                throw e10;
            }
            Logger.m30735d(f24613b, "Local module version is valid, use local fallback.");
            return new DynamicModule(context.getApplicationContext());
        }
    }

    /* renamed from: a */
    public static DynamicModule m31859a(Context context, String str, VersionPolicy versionPolicy, Bundle bundle) throws LoadingException {
        int iM31854a = m31854a(versionPolicy);
        String string = bundle.getString(InterfaceC5323b.f24691r);
        Logger.m30740i(f24613b, "The loader path for module:" + str + " is:" + string + ", and versionType is:" + iM31854a);
        if (TextUtils.isEmpty(string)) {
            throw new LoadingException("Cannot find a valid dynamic loader in HMS or local.");
        }
        Boolean bool = f24625n.get(str);
        Boolean bool2 = f24624m.get(str);
        bundle.putString("module_name", str);
        bundle.putInt(InterfaceC5323b.f24696w, iM31854a);
        bundle.putBoolean(InterfaceC5323b.f24697x, bool != null ? bool.booleanValue() : false);
        bundle.putBoolean(InterfaceC5323b.f24698y, bool2 != null ? bool2.booleanValue() : false);
        try {
            return m31869b(context, str, bundle);
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception e11) {
            Logger.m30738e(f24613b, "Other exception,", e11);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return new DynamicModule(context);
        }
    }

    /* renamed from: a */
    public static IDynamicInstall m31860a(Context context, String str) throws LoadingException {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (C5333c.m31893a(context, str)) {
                        return IDynamicInstall.Stub.asInterface((IBinder) new C5326a(str, ClassLoader.getSystemClassLoader()).loadClass(InterfaceC5323b.f24680g).getConstructor(new Class[0]).newInstance(new Object[0]));
                    }
                    Logger.m30744w(f24613b, "check path failed: invalid.");
                    throw new LoadingException("getHMSDynamicInstaller: checkPathValidity failed.");
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
                throw new LoadingException("getHMSDynamicInstaller: failed to instantiate dynamic loader:" + e10.getMessage());
            }
        }
        throw new LoadingException("Failed to get dynamicLoader path.");
    }

    /* renamed from: a */
    public static IDynamicLoader m31861a(Context context, String str, String str2, ClassLoader classLoader) {
        if (classLoader == null) {
            try {
                classLoader = new C5326a(str2, ClassLoader.getSystemClassLoader());
                f24619h.set(new C5313b(str, classLoader));
            } catch (Exception e10) {
                Logger.m30745w(f24613b, "Get iDynamicLoader failed.", e10);
                return null;
            }
        }
        return IDynamicLoader.Stub.asInterface((IBinder) classLoader.loadClass(InterfaceC5323b.f24679f).getConstructor(new Class[0]).newInstance(new Object[0]));
    }

    /* renamed from: a */
    public static Class<?> m31862a(Context context) throws ClassNotFoundException, LoadingException {
        Class<?> clsLoadClass;
        try {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            clsLoadClass = context.getClassLoader().loadClass(DynamicLoaderClassLoader.class.getName());
        } catch (ClassNotFoundException unused) {
            Logger.m30744w(f24613b, "ClassLoader class not found when use client context.");
            clsLoadClass = null;
        }
        if (clsLoadClass == null) {
            try {
                ClassLoader classLoader = DynamicModule.class.getClassLoader();
                Objects.requireNonNull(classLoader);
                clsLoadClass = classLoader.loadClass(DynamicLoaderClassLoader.class.getName());
                if (clsLoadClass == null) {
                    throw new LoadingException("ClassLoader class is null.");
                }
            } catch (ClassNotFoundException unused2) {
                throw new LoadingException("ClassLoader class not found when use DynamicModule's classLoader.");
            }
        }
        return clsLoadClass;
    }

    /* renamed from: a */
    public static void m31864a(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        if (context == null || versionPolicy == null || str == null || str.length() == 0 || str.length() > 256 || bundle == null) {
            throw new LoadingException("Null param, please check it.");
        }
    }

    /* renamed from: a */
    public static void m31865a(String str, ClassLoader classLoader) throws LoadingException {
        try {
            f24618g.set(new C5317f(str, (IBinder) classLoader.loadClass(InterfaceC5323b.f24679f).getConstructor(new Class[0]).newInstance(new Object[0])));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            throw new LoadingException("Failed to get loader interface:" + e10.getMessage());
        }
    }

    /* renamed from: a */
    public static boolean m31866a(String str, int i10) {
        if (i10 == 1) {
            Boolean bool = f24625n.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        if (i10 != 2) {
            return i10 == 3 || i10 == 4;
        }
        Boolean bool2 = f24624m.get(str);
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return false;
    }
}
