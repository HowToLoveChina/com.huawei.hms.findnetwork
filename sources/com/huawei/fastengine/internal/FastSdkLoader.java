package com.huawei.fastengine.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import com.huawei.fastengine.fastview.Config;
import com.huawei.fastengine.fastview.FastSDKEngine;
import com.huawei.fastengine.fastview.download.utils.CheckUtils;
import com.huawei.fastengine.fastview.download.utils.CommonUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.util.QuickAppFrescoConfig;
import com.huawei.fastsdk.AbsQuickCardAction;
import com.huawei.fastsdk.ICardRepository;
import com.huawei.fastsdk.IFastSDKProxy;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class FastSdkLoader {
    private static final int CBGCERT_MIN_VERSION = 20500000;
    private static final int INITNEW_MIN_VERSION = 30001000;
    private static final int QUICK_CARD_SERVICE_VERSION = 30102001;
    private static final int QUICK_CARD_SUPPORT_VERSION = 30002300;
    private static final String TAG = "FastSDKEngine";
    private static FastSdkLoader instance;
    private boolean addRes;
    private int featureLevel;
    AssetManager mAssetManager;
    private BaseDexClassLoader mFastSDKDex;
    private IFastSDKProxy mFastSDKProxy;
    private HostMode mHostMode;
    private boolean mSupportQuickCard;
    private boolean mSupportQuickCardService;

    public static class FastSdkClassLoader extends ClassLoader {
        private static final Set<String> CLASS_SET;
        private static final String[] CLASS_VALUES;
        private static final String TAG = "FastSdkClassLoader";
        private ClassLoader mAppClassLoader;

        static {
            String[] strArr = {"com.huawei.fastsdk.IFastSDKProxy", "com.huawei.fastsdk.IFastSDKInstance", "com.huawei.fastsdk.IFastRenderListener", "com.huawei.fastsdk.IFastCardMessage", "com.huawei.fastsdk.AbsQuickCardAction", "com.huawei.fastsdk.IUiConfiguration", "com.huawei.fastsdk.IQuickCardListener", "com.alibaba.fastjson.JSONArray", "com.alibaba.fastjson.JSONObject", "com.alibaba.fastjson.JSON", "com.alibaba.fastjson.JSONException", "com.huawei.fastsdk.ICardRepository", "com.huawei.fastsdk.CardServerConfig", "com.huawei.fastsdk.FastSDKRunMode", "com.huawei.fastsdk.QuickCardCode", "com.huawei.fastsdk.ICardServerUrl", "com.huawei.fastsdk.HASDKManager", "com.huawei.fastsdk.HASDKUtils", "com.huawei.fastsdk.IElement"};
            CLASS_VALUES = strArr;
            CLASS_SET = new HashSet(Arrays.asList(strArr));
        }

        public FastSdkClassLoader(ClassLoader classLoader, ClassLoader classLoader2) {
            super(classLoader);
            this.mAppClassLoader = classLoader2;
        }

        @Override // java.lang.ClassLoader
        public Class<?> findClass(String str) throws ClassNotFoundException {
            Class<?> clsLoadClass;
            if (str == null || this.mAppClassLoader == null || !CLASS_SET.contains(str)) {
                clsLoadClass = null;
            } else {
                clsLoadClass = this.mAppClassLoader.loadClass(str);
                if (clsLoadClass == null) {
                    Log.e(TAG, "ERROR,Class is missing in host app: " + str);
                }
            }
            return clsLoadClass == null ? super.findClass(str) : clsLoadClass;
        }
    }

    public enum HostMode {
        Full,
        Lite,
        ShareLibrary,
        QuickCard
    }

    private FastSdkLoader(Application application, HostMode hostMode, ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z10, boolean z11) throws IllegalAccessException, PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        String str;
        int i10;
        HostMode hostMode2 = HostMode.Full;
        this.addRes = false;
        try {
            this.mHostMode = hostMode;
            HostMode hostMode3 = HostMode.Lite;
            if (hostMode == hostMode3 || hostMode == HostMode.ShareLibrary) {
                PackageInfo packageInfo = application.getPackageManager().getPackageInfo(Config.getPackageName(), 128);
                applicationInfo = packageInfo.applicationInfo;
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    this.featureLevel = bundle.getInt(QuickAppFrescoConfig.META_KEY_FEATURE);
                }
                Log.i(TAG, "fast app feature " + this.featureLevel);
                String str2 = applicationInfo.sourceDir;
                str = applicationInfo.nativeLibraryDir;
                i10 = packageInfo.versionCode;
                if (hostMode == hostMode3) {
                    if (!CheckUtils.isCorrectSign(application, Config.getPackageName())) {
                        throw new IllegalAccessException("FastAPP signature illegal");
                    }
                    this.mFastSDKDex = new PathClassLoader(str2, applicationInfo.nativeLibraryDir, new FastSdkClassLoader(getBootClassLoader(application), application.getClassLoader()));
                    if (i10 < INITNEW_MIN_VERSION || z11) {
                        FastViewLogUtils.m28725i("addResourcesPath");
                        addResourcesPath(application, str2);
                    }
                }
            } else {
                applicationInfo = null;
                str = null;
                i10 = CBGCERT_MIN_VERSION;
            }
            IFastSDKProxy iFastSDKProxy = (IFastSDKProxy) CommonUtils.cast(createObject("com.huawei.fastsdk.FastSDKProxy", null, new Object[0]), IFastSDKProxy.class, true);
            this.mFastSDKProxy = iFastSDKProxy;
            if (iFastSDKProxy == null) {
                throw new IllegalAccessException("Instantiate the FastSDK failed");
            }
            boolean z12 = FastSDKEngine.getRunMode() == 1 || FastSDKEngine.getRunMode() == 2;
            this.mSupportQuickCard = z12;
            if (hostMode == hostMode3) {
                this.mSupportQuickCard = z12 && i10 >= 30002300;
                this.mSupportQuickCardService = i10 >= QUICK_CARD_SERVICE_VERSION;
            } else {
                this.mSupportQuickCardService = true;
            }
            if (this.mSupportQuickCard) {
                initQuickCard();
            }
            if (hostMode != hostMode3 && hostMode != HostMode.ShareLibrary) {
                this.mFastSDKProxy.setMaxFrescoMemoryCacheSize(QuickAppFrescoConfig.getMaxFrescoMemoryCacheSize());
            } else if (this.featureLevel >= 1) {
                this.mFastSDKProxy.setMaxFrescoMemoryCacheSize(QuickAppFrescoConfig.getMaxFrescoMemoryCacheSize());
            }
            FastViewLogUtils.m28724e(TAG, "dong libraryDir " + str);
            if (i10 <= INITNEW_MIN_VERSION) {
                if (i10 < CBGCERT_MIN_VERSION) {
                    this.mFastSDKProxy.init(application, str, arrayList, arrayList2);
                    return;
                } else {
                    this.mFastSDKProxy.init(application, str, arrayList, arrayList2, z10);
                    return;
                }
            }
            FastViewLogUtils.m28724e(TAG, "initnew needShowDialog " + z11);
            this.mFastSDKProxy.init(application, applicationInfo, arrayList, arrayList2, z10, z11);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new PackageManager.NameNotFoundException("FastEngine is not installed");
        } catch (UnsatisfiedLinkError unused2) {
            throw new UnsatisfiedLinkError();
        }
    }

    private void addResourcesPath(Context context, String str) {
        try {
            this.addRes = true;
            this.mAssetManager = context.getAssets();
            AssetManager.class.getDeclaredMethod("addAssetPath", String.class).invoke(context.getAssets(), str);
        } catch (Throwable unused) {
            FastViewLogUtils.m28724e("FastSdkLoader", "addResourcesPath Exception!");
        }
    }

    private Object createObject(String str, Class<?>[] clsArr, Object... objArr) throws ClassNotFoundException {
        String str2;
        Class<?> cls;
        try {
            if (this.mHostMode == HostMode.Lite) {
                BaseDexClassLoader baseDexClassLoader = this.mFastSDKDex;
                if (baseDexClassLoader == null) {
                    return null;
                }
                cls = baseDexClassLoader.loadClass(str);
            } else {
                cls = Class.forName(str);
            }
            return cls.getDeclaredConstructor(clsArr).newInstance(objArr);
        } catch (ClassNotFoundException unused) {
            str2 = "ClassNotFoundException!";
            FastViewLogUtils.m28724e("FastSdkLoader", str2);
            return null;
        } catch (IllegalAccessException unused2) {
            str2 = "IllegalAccessException!";
            FastViewLogUtils.m28724e("FastSdkLoader", str2);
            return null;
        } catch (InstantiationException unused3) {
            str2 = "InstantiationException!";
            FastViewLogUtils.m28724e("FastSdkLoader", str2);
            return null;
        } catch (NoSuchMethodException unused4) {
            str2 = "NoSuchMethodException!";
            FastViewLogUtils.m28724e("FastSdkLoader", str2);
            return null;
        } catch (InvocationTargetException unused5) {
            str2 = "InvocationTargetException!";
            FastViewLogUtils.m28724e("FastSdkLoader", str2);
            return null;
        }
    }

    public static synchronized void destroy(boolean z10) {
        FastSdkLoader fastSdkLoader = instance;
        if (fastSdkLoader == null) {
            return;
        }
        fastSdkLoader.destroyInternal(z10);
        instance = null;
    }

    private ClassLoader getBootClassLoader(Context context) {
        ClassLoader classLoader = context.getClassLoader();
        do {
            classLoader = classLoader.getParent();
            if (classLoader == null) {
                break;
            }
        } while (classLoader.getParent() != null);
        return classLoader;
    }

    public static synchronized FastSdkLoader getInstance() {
        return instance;
    }

    private Field getResources(Class cls) throws NoSuchFieldException {
        Field declaredField = null;
        while (cls != null && declaredField == null) {
            try {
                declaredField = cls.getDeclaredField("mResources");
            } catch (NoSuchFieldException unused) {
                FastViewLogUtils.m28724e("FastSdkLoader", "NoSuchFieldException!");
            }
            cls = cls.getSuperclass();
        }
        return declaredField;
    }

    public static synchronized void init(Application application, HostMode hostMode, ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z10, boolean z11) throws IllegalAccessException, PackageManager.NameNotFoundException, UnsatisfiedLinkError {
        if (instance == null) {
            instance = new FastSdkLoader(application, hostMode, arrayList, arrayList2, z10, z11);
        }
    }

    private void initQuickCard() {
        this.mFastSDKProxy.setRunMode(FastSDKEngine.getRunMode());
        Map<String, Class<? extends AbsQuickCardAction>> actionsMap = FastSDKEngine.getActionsMap();
        if (actionsMap.size() > 0) {
            this.mFastSDKProxy.registerActions(actionsMap);
        }
    }

    public void clearFrescoMemoryCache() {
        HostMode hostMode = this.mHostMode;
        if ((hostMode == HostMode.Lite || hostMode == HostMode.ShareLibrary) && this.featureLevel < 1) {
            return;
        }
        this.mFastSDKProxy.clearFrescoMemoryCache();
    }

    public void destroyInternal(boolean z10) {
        IFastSDKProxy iFastSDKProxy = this.mFastSDKProxy;
        if (iFastSDKProxy == null) {
            return;
        }
        iFastSDKProxy.destroy(z10);
        this.mFastSDKProxy = null;
    }

    public ICardRepository getCardRepository() {
        IFastSDKProxy iFastSDKProxy;
        if (!this.mSupportQuickCardService || (iFastSDKProxy = this.mFastSDKProxy) == null) {
            return null;
        }
        return iFastSDKProxy.getCardRepository();
    }

    public IFastSDKProxy getFastSDKProxy() {
        return this.mFastSDKProxy;
    }

    public HostMode getHostMode() {
        return this.mHostMode;
    }

    public boolean isSupportQuickCardService() {
        return this.mSupportQuickCardService;
    }

    public void patchResources(Context context) throws IllegalAccessException, IllegalArgumentException {
        String str;
        if (this.mHostMode == HostMode.Lite && this.addRes) {
            FastViewLogUtils.m28726i("FastSdkLoader", "do patchResources");
            try {
                final Field resources = getResources(context.getClass());
                AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: com.huawei.fastengine.internal.FastSdkLoader.1
                    @Override // java.security.PrivilegedAction
                    public Object run() throws SecurityException {
                        resources.setAccessible(true);
                        return null;
                    }
                });
                Resources resources2 = new Resources(this.mAssetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
                resources2.newTheme().setTo(context.getTheme());
                resources.set(context, resources2);
            } catch (IllegalAccessException unused) {
                str = "IllegalAccessException!";
                FastViewLogUtils.m28724e("FastSdkLoader", str);
            } catch (Exception unused2) {
                str = "Exception!";
                FastViewLogUtils.m28724e("FastSdkLoader", str);
            }
        }
    }

    public boolean supportQuickCard() {
        return this.mSupportQuickCard;
    }
}
