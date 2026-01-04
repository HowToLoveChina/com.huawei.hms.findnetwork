package com.huawei.remoteLoader.client;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;
import com.huawei.arengine.remoteLoader.ILoaderProducer;
import com.huawei.hiar.C4847e;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes5.dex */
public class ARRemoteLibraryLoader {
    private static final String CREATOR_NAME = "com.huawei.arengine.service.LoaderProducer";
    private static final String TAG = "ARRemoteLibraryLoader";
    private ILoaderProducer loaderProducer;
    private Context remoteContext;
    private final C8675a targetLibrary;

    public ARRemoteLibraryLoader(C8675a c8675a) {
        this.targetLibrary = c8675a;
    }

    private static IBinder newBinderInstance(ClassLoader classLoader, String str) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = classLoader.loadClass(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (objNewInstance instanceof IBinder) {
                return (IBinder) objNewInstance;
            }
            Log.w(TAG, "Binder new instance fail!");
            return null;
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException(str.length() != 0 ? "Find dynamic class error".concat(str) : "Find dynamic class error");
        } catch (IllegalAccessException unused2) {
            throw new IllegalStateException(str.length() != 0 ? "Call the default constructor error".concat(str) : "Call the default constructor error");
        } catch (InstantiationException unused3) {
            throw new IllegalStateException(str.length() != 0 ? "Instantiate the remote class error".concat(str) : "Instantiate the remote class error");
        } catch (NoSuchMethodException unused4) {
            throw new IllegalStateException(str.length() != 0 ? "No constructor ".concat(str) : "No constructor");
        } catch (InvocationTargetException unused5) {
            throw new IllegalStateException(str.length() != 0 ? "Invoke constructor of dynamic class error".concat(str) : "Invoke constructor of dynamic class error");
        }
    }

    public synchronized Context getRemoteContext(Context context) {
        try {
            if (this.remoteContext == null) {
                try {
                    if (!C4847e.m29089a(context, this.targetLibrary.m53564b())) {
                        Log.e(TAG, "getRemoteContext PackageName:" + this.targetLibrary.m53564b() + " isValidServiceApk failed!");
                        throw new ARLoaderException(1);
                    }
                    this.remoteContext = context.createPackageContext(this.targetLibrary.m53564b(), 3);
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new ARLoaderException(1);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.remoteContext;
    }

    public synchronized ILoaderProducer getRemoteCreator(Context context) {
        try {
            if (this.loaderProducer == null) {
                ClassLoader classLoader = getRemoteContext(context).getClassLoader();
                if (classLoader == null) {
                    throw new ARLoaderException(1);
                }
                this.loaderProducer = ILoaderProducer.AbstractBinderC4591a.m28130h(newBinderInstance(classLoader, CREATOR_NAME));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.loaderProducer;
    }

    public static Context getRemoteContext(Context context, String str) throws ARLoaderException {
        try {
            return context.createPackageContext(str, 3);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new ARLoaderException(1);
        }
    }
}
