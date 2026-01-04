package com.huawei.fastengine.fastview.preload;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.fastapp.engine.preload.IPreloadAidlInterface;
import com.huawei.fastengine.fastview.Config;
import com.huawei.fastengine.fastview.download.utils.CheckUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.startfastappengine.JumpActivity;
import com.huawei.fastengine.fastview.util.PackageUtil;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* loaded from: classes5.dex */
public class PreloadManager {
    private static final String ACTION_AIDL_PRELOAD = "com.huawei.fastapp.engine.action.PRELOAD_AIDL_SERVICE";
    private static final int AIDL_CALL_TIMEOUT_DELAY = 8000;
    private static final String INTENT_CALL_PKG_NAME = "callPkgName";
    private static final String INTENT_CALL_SIGN = "callSign";
    public static final String INTENT_IS_FROM_PRELOAD = "isfromPreload";
    private static final String TAG = "PreloadManager";
    private static volatile PreloadManager preloadManager;
    private String mPackageName;
    private static final Object SHORT_CUT_LOCKER = new Object();
    private static volatile Handler aidlCallTimeoutHandler = new Handler(Looper.getMainLooper());
    private IPreloadAidlInterface myBinder = null;
    private Context mContext = null;
    private boolean isBound = false;
    private String sign = "";
    private String callPkgName = "";
    private ServiceConnection conn = new ServiceConnection() { // from class: com.huawei.fastengine.fastview.preload.PreloadManager.1
        public ServiceConnectionC47091() {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            FastViewLogUtils.m28724e(PreloadManager.TAG, "init| onNullBinding: connect failed, _UNTRUSTED_CALLING");
            PreloadManager.this.unbindService();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            FastViewLogUtils.m28726i(PreloadManager.TAG, "onServiceConnected");
            PreloadManager.this.myBinder = IPreloadAidlInterface.Stub.m28717h(iBinder);
            if (PreloadManager.this.myBinder != null) {
                try {
                    FastViewLogUtils.m28726i(PreloadManager.TAG, "onServiceConnected: connect success");
                    PreloadManager.this.isBound = true;
                    PreloadManager preloadManager2 = PreloadManager.this;
                    preloadManager2.setAidlCallTimeout(preloadManager2.mPackageName);
                    PreloadManager.this.myBinder.mo28715b(PreloadManager.this.mPackageName);
                    return;
                } catch (RemoteException unused) {
                    str = "onServiceConnected create error: RemoteException";
                }
            } else {
                str = "onServiceConnected: connect fail";
            }
            FastViewLogUtils.m28724e(PreloadManager.TAG, str);
            PreloadManager.this.unbindService();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            FastViewLogUtils.m28728w(PreloadManager.TAG, "onServiceDisconnected");
        }
    };

    /* renamed from: com.huawei.fastengine.fastview.preload.PreloadManager$1 */
    public class ServiceConnectionC47091 implements ServiceConnection {
        public ServiceConnectionC47091() {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            FastViewLogUtils.m28724e(PreloadManager.TAG, "init| onNullBinding: connect failed, _UNTRUSTED_CALLING");
            PreloadManager.this.unbindService();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            FastViewLogUtils.m28726i(PreloadManager.TAG, "onServiceConnected");
            PreloadManager.this.myBinder = IPreloadAidlInterface.Stub.m28717h(iBinder);
            if (PreloadManager.this.myBinder != null) {
                try {
                    FastViewLogUtils.m28726i(PreloadManager.TAG, "onServiceConnected: connect success");
                    PreloadManager.this.isBound = true;
                    PreloadManager preloadManager2 = PreloadManager.this;
                    preloadManager2.setAidlCallTimeout(preloadManager2.mPackageName);
                    PreloadManager.this.myBinder.mo28715b(PreloadManager.this.mPackageName);
                    return;
                } catch (RemoteException unused) {
                    str = "onServiceConnected create error: RemoteException";
                }
            } else {
                str = "onServiceConnected: connect fail";
            }
            FastViewLogUtils.m28724e(PreloadManager.TAG, str);
            PreloadManager.this.unbindService();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            FastViewLogUtils.m28728w(PreloadManager.TAG, "onServiceDisconnected");
        }
    }

    /* renamed from: com.huawei.fastengine.fastview.preload.PreloadManager$2 */
    public class RunnableC47102 implements Runnable {
        final /* synthetic */ String val$packageName;

        public RunnableC47102(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            FastViewLogUtils.m28726i(PreloadManager.TAG, "aidlCallTimeoutHandler| " + str);
            PreloadManager.this.unbindService();
        }
    }

    private void bindServiceByJumpActivity(Context context) {
        FastViewLogUtils.m28726i(TAG, "bindServiceByJumpActivity");
        Intent intent = new Intent();
        intent.setClass(context, JumpActivity.class);
        intent.putExtra(INTENT_IS_FROM_PRELOAD, true);
        if (!(context instanceof Activity)) {
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        try {
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        } catch (ActivityNotFoundException unused) {
            FastViewLogUtils.m28724e(TAG, "ActivityNotFoundException");
        }
    }

    public static PreloadManager getInstance() {
        if (preloadManager == null) {
            synchronized (SHORT_CUT_LOCKER) {
                try {
                    if (preloadManager == null) {
                        preloadManager = new PreloadManager();
                    }
                } finally {
                }
            }
        }
        return preloadManager;
    }

    private boolean isServiceConnected() {
        return this.isBound && this.myBinder != null;
    }

    public void setAidlCallTimeout(String str) {
        FastViewLogUtils.m28726i(TAG, "setAidlCallTimeout: packageName=" + str + ", delayTime=8000ms");
        aidlCallTimeoutHandler.postDelayed(new Runnable() { // from class: com.huawei.fastengine.fastview.preload.PreloadManager.2
            final /* synthetic */ String val$packageName;

            public RunnableC47102(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                FastViewLogUtils.m28726i(PreloadManager.TAG, "aidlCallTimeoutHandler| " + str);
                PreloadManager.this.unbindService();
            }
        }, 8000L);
    }

    public void unbindService() {
        ServiceConnection serviceConnection;
        FastViewLogUtils.m28726i(TAG, "unbind Service");
        Context context = this.mContext;
        if (context != null && (serviceConnection = this.conn) != null) {
            try {
                context.unbindService(serviceConnection);
                FastViewLogUtils.m28726i(TAG, "unbind Service success");
            } catch (IllegalArgumentException unused) {
                FastViewLogUtils.m28724e(TAG, "unbind Service error: service is not registered");
            }
        }
        this.isBound = false;
        this.myBinder = null;
    }

    public void jumpActivityCallback(boolean z10) {
        String str;
        FastViewLogUtils.m28726i(TAG, "jumpActivityCallback: " + z10);
        if (!z10 || this.mContext == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(ACTION_AIDL_PRELOAD);
        intent.putExtra(INTENT_CALL_SIGN, this.sign);
        intent.putExtra(INTENT_CALL_PKG_NAME, this.callPkgName);
        try {
            intent.setPackage(Config.getPackageName());
            if (this.mContext.bindService(intent, this.conn, 1)) {
                return;
            }
            FastViewLogUtils.m28724e(TAG, "jumpActivityCallback bind service failed");
        } catch (IllegalArgumentException unused) {
            str = "setPackage exception";
            FastViewLogUtils.m28724e(TAG, str);
        } catch (SecurityException unused2) {
            str = "no permission bind service";
            FastViewLogUtils.m28724e(TAG, str);
        }
    }

    public void preloadQuickApp(Context context, String str) {
        String str2;
        FastViewLogUtils.m28726i(TAG, "preloadQuickApp");
        if (context == null || str == null) {
            FastViewLogUtils.m28724e(TAG, "preloadQuickApp fail, parameter is null");
            return;
        }
        if (!CheckUtils.isCorrectSign(context, Config.getPackageName())) {
            FastViewLogUtils.m28724e(TAG, "FastAPP sign is Wrong");
            return;
        }
        int callingUid = Binder.getCallingUid();
        PackageManager packageManager = context.getPackageManager();
        String[] packagesForUid = packageManager.getPackagesForUid(callingUid);
        if (packagesForUid == null || packagesForUid.length != 1) {
            FastViewLogUtils.m28726i(TAG, "get calling packageName error");
            return;
        }
        FastViewLogUtils.m28726i(TAG, "get calling packageName :" + packagesForUid[0]);
        String str3 = packagesForUid[0];
        this.callPkgName = str3;
        String appSignSha256 = PackageUtil.getAppSignSha256(packageManager, str3);
        this.sign = appSignSha256;
        if (TextUtils.isEmpty(appSignSha256)) {
            FastViewLogUtils.m28724e(TAG, "sign is Wrong");
            return;
        }
        if (isServiceConnected()) {
            try {
                setAidlCallTimeout(str);
                this.myBinder.mo28715b(str);
                return;
            } catch (RemoteException unused) {
                FastViewLogUtils.m28724e(TAG, "preloadManager error: RemoteException");
                return;
            }
        }
        this.mContext = context;
        this.mPackageName = str;
        Intent intent = new Intent();
        intent.setAction(ACTION_AIDL_PRELOAD);
        intent.putExtra(INTENT_CALL_SIGN, this.sign);
        intent.putExtra(INTENT_CALL_PKG_NAME, this.callPkgName);
        try {
            intent.setPackage(Config.getPackageName());
            if (this.mContext.bindService(intent, this.conn, 1)) {
                return;
            }
            FastViewLogUtils.m28724e(TAG, "bind service failed");
            bindServiceByJumpActivity(this.mContext);
        } catch (IllegalArgumentException unused2) {
            str2 = "setPackage exception";
            FastViewLogUtils.m28724e(TAG, str2);
        } catch (SecurityException unused3) {
            str2 = "no permission bind service";
            FastViewLogUtils.m28724e(TAG, str2);
        }
    }
}
