package com.huawei.remoteLoader.client;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;
import com.huawei.arengine.remoteLoader.IDynamicLoader;
import com.huawei.arengine.remoteLoader.ILoaderProducer;
import com.huawei.hiar.annotations.UsedByNative;
import dalvik.system.DexClassLoader;
import java.io.File;

@UsedByNative("dynamite_client.cpp")
@TargetApi(19)
/* loaded from: classes5.dex */
public final class ARDynamiteClient {
    private static final String LIB32_DIR_NAME = "lib";
    private static final String LIB64_DIR_NAME = "lib64";
    private static final String TAG = "ARDynamiteClient";

    /* renamed from: cl */
    private static DexClassLoader f40456cl;
    protected static Object syncObject = new Object();
    private static final ArrayMap<C8675a, ARRemoteLibraryLoader> TARGET_LIBRARIES = new ArrayMap<>();
    private static ARRemoteLibraryLoader remoteLibLoader = null;
    private static C8675a info = null;
    private static ILoaderProducer loaderProducer = null;
    private static IDynamicLoader loader = null;
    private static String fileName = null;
    private static Context loaderContext = null;

    private ARDynamiteClient() {
    }

    public static synchronized boolean CheckUpdate(Context context, String str, String str2, boolean z10) {
        if (info != null) {
            return false;
        }
        C8675a c8675a = new C8675a(str, str2);
        info = c8675a;
        ARRemoteLibraryLoader remoteLibraryLoaderFromInfo = getRemoteLibraryLoaderFromInfo(c8675a);
        remoteLibLoader = remoteLibraryLoaderFromInfo;
        try {
            loaderProducer = remoteLibraryLoaderFromInfo.getRemoteCreator(context);
            IDynamicLoader iDynamicLoaderNewDynamicLoader = loaderProducer.newDynamicLoader(ARObjectWrapper.wrap(remoteLibLoader.getRemoteContext(context)), ARObjectWrapper.wrap(context));
            loader = iDynamicLoaderNewDynamicLoader;
            return iDynamicLoaderNewDynamicLoader.checkUpdate(158L, z10);
        } catch (RemoteException | ARLoaderException | IllegalStateException unused) {
            loader = null;
            info = null;
            remoteLibLoader = null;
            loaderProducer = null;
            return false;
        }
    }

    private static void deleteCachedFile(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str);
        File file = new File(sb2.toString());
        if (!file.exists()) {
            Log.i(TAG, "No cached jar file!");
        } else if (!file.isFile()) {
            Log.e(TAG, "Path is invalid!");
        } else if (file.delete()) {
            Log.w(TAG, "Cached jar file is deleted!");
        } else {
            Log.e(TAG, "Delete failed!");
        }
        File file2 = new File(str2 + str3 + "hmsrootcas.bks");
        if (!file2.exists()) {
            Log.i(TAG, "No cached ca file!");
            return;
        }
        if (!file2.isFile()) {
            Log.e(TAG, "Path is invalid!");
        } else if (file2.delete()) {
            Log.w(TAG, "Cached ca file is deleted!");
        } else {
            Log.e(TAG, "Delete failed!");
        }
    }

    public static Class<?> getLoadClass(String str) {
        if (str == null) {
            Log.e(TAG, "Input is null!");
            return null;
        }
        synchronized (syncObject) {
            try {
                if (f40456cl == null) {
                    String str2 = TAG;
                    Log.i(str2, "Need to init Loader");
                    if (fileName == null) {
                        Log.e(str2, "FileName is null,failed to init loader!");
                        return null;
                    }
                    if (loaderContext == null) {
                        Log.e(str2, "LoaderContext is null,failed to init loader!");
                        return null;
                    }
                    Log.i(str2, "Start init Loader");
                    initDexLoader(loaderContext, fileName);
                }
                try {
                    return f40456cl.loadClass(str);
                } catch (ClassNotFoundException unused) {
                    Log.w(TAG, "getLoadClass class not found: " + str);
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @UsedByNative("dynamite_client.cpp")
    public static synchronized ClassLoader getRemoteClassLoader(Context context, String str, String str2) {
        ARRemoteLibraryLoader remoteLibraryLoaderFromInfo = getRemoteLibraryLoaderFromInfo(new C8675a(str, str2));
        Log.d(TAG, "getRemoteClassLoader[" + str2 + "]");
        try {
            Context remoteContext = remoteLibraryLoaderFromInfo.getRemoteContext(context);
            if (remoteContext == null) {
                return null;
            }
            return remoteContext.getClassLoader();
        } catch (ARLoaderException e10) {
            Log.e(TAG, "getRemoteClassLoader error: ", e10);
            return null;
        }
    }

    private static synchronized ARRemoteLibraryLoader getRemoteLibraryLoaderFromInfo(C8675a c8675a) {
        ARRemoteLibraryLoader aRRemoteLibraryLoader;
        ArrayMap<C8675a, ARRemoteLibraryLoader> arrayMap = TARGET_LIBRARIES;
        aRRemoteLibraryLoader = arrayMap.get(c8675a);
        if (aRRemoteLibraryLoader == null) {
            aRRemoteLibraryLoader = new ARRemoteLibraryLoader(c8675a);
            arrayMap.put(c8675a, aRRemoteLibraryLoader);
        }
        return aRRemoteLibraryLoader;
    }

    private static void initDexLoader(Context context, String str) {
        f40456cl = new DexClassLoader(context.getFilesDir().getAbsolutePath() + File.separator + str, context.getCacheDir().getAbsolutePath(), null, context.getClassLoader());
        Log.i(TAG, "initDexLoader");
    }

    @UsedByNative("dynamite_client.cpp")
    public static synchronized long loadNativeRemoteLibrary(Context context, String str, String str2) {
        String str3;
        String str4;
        if (loader != null) {
            return loader.openLibrary(str2);
        }
        C8675a c8675a = new C8675a(str, str2);
        info = c8675a;
        ARRemoteLibraryLoader remoteLibraryLoaderFromInfo = getRemoteLibraryLoaderFromInfo(c8675a);
        remoteLibLoader = remoteLibraryLoaderFromInfo;
        try {
            loaderProducer = remoteLibraryLoaderFromInfo.getRemoteCreator(context);
            loader = loaderProducer.newDynamicLoader(ARObjectWrapper.wrap(remoteLibLoader.getRemoteContext(context)), ARObjectWrapper.wrap(context));
            try {
                try {
                    return loader.openLibrary(str2);
                } catch (UnsatisfiedLinkError unused) {
                    str3 = TAG;
                    str4 = "UnsatisfiedLinkError";
                    Log.e(str3, str4);
                    return 0L;
                }
            } catch (RemoteException unused2) {
                str3 = TAG;
                str4 = "Exception";
                Log.e(str3, str4);
                return 0L;
            }
        } catch (RemoteException | ARLoaderException | IllegalStateException unused3) {
            Log.e(TAG, "Failed to load native Remote library!");
            loader = null;
            info = null;
            remoteLibLoader = null;
            loaderProducer = null;
            return 0L;
        }
    }

    @UsedByNative("HuaweiArapk.cpp")
    public static String unzipBaseApkGetDex(Context context, String str) {
        Log.i(TAG, "SDK version name is :[4.0.0.5],version code is :[158]");
        String absolutePath = context.getFilesDir().getAbsolutePath();
        deleteCachedFile(str, absolutePath);
        synchronized (syncObject) {
            fileName = str;
            loaderContext = context;
        }
        return absolutePath;
    }

    @UsedByNative("dynamite_client.cpp")
    public static synchronized boolean updateResourceFromRemote(String str, String str2) {
        IDynamicLoader iDynamicLoader = loader;
        if (iDynamicLoader != null) {
            try {
                return iDynamicLoader.updateResourceFromRemote(str, str2);
            } catch (RemoteException unused) {
                Log.e(TAG, "updateResourceFromRemote Exception");
                return false;
            }
        }
        Log.e(TAG, "Failed to load native library " + info + " from remote package: no loader available.");
        return false;
    }
}
