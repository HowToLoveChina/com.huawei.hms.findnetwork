package com.huawei.fastengine.fastview.shortcut;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.fastapp.engine.shortcut.IShortCutAidlCallback;
import com.huawei.fastapp.engine.shortcut.IShortCutAidlInterface;
import com.huawei.fastengine.fastview.Config;
import com.huawei.fastengine.fastview.download.utils.CheckUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.startfastappengine.JumpActivity;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class ShortCutManager {
    private static final String ACTION_AIDL_SHORTCUT = "com.huawei.fastapp.engine.action.SHORTCUT_AIDL_SERVICE";
    private static final int AIDL_CALL_TIMEOUT_DELAY = 2000;
    private static final String TAG = "ShortCutManager";
    private static volatile ShortCutManager shortCutManager;
    private String mIcon;
    private String mName;
    private String mPackageName;
    private ShortCutCallback mShortCutCallback;
    private static final Object SHORT_CUT_LOCKER = new Object();
    private static volatile ConcurrentHashMap<String, ShortCutCallback> callbackMap = new ConcurrentHashMap<>();
    private static volatile Handler aidlCallTimeoutHandler = new Handler(Looper.getMainLooper());
    private IShortCutAidlInterface myBinder = null;
    private Context mContext = null;
    private boolean isBound = false;
    private final IShortCutAidlCallback iFastAPPAidlCallback = new IShortCutAidlCallback.Stub() { // from class: com.huawei.fastengine.fastview.shortcut.ShortCutManager.1
        public BinderC47111() {
        }

        @Override // com.huawei.fastapp.engine.shortcut.IShortCutAidlCallback
        public void onCreateShortCut(int i10, String str) {
            FastViewLogUtils.m28726i(ShortCutManager.TAG, "onCreateShortCut result: " + i10 + ", packageName: " + str);
            if (TextUtils.isEmpty(str)) {
                FastViewLogUtils.m28724e(ShortCutManager.TAG, "onCreateShortCut, packageName is null");
                return;
            }
            ShortCutCallback shortCutCallback = (ShortCutCallback) ShortCutManager.callbackMap.remove(str);
            if (shortCutCallback != null) {
                shortCutCallback.onCreateShortCut(i10);
            }
            if (ShortCutManager.callbackMap.isEmpty()) {
                ShortCutManager.this.unbindService();
            }
        }
    };
    private ServiceConnection conn = new ServiceConnection() { // from class: com.huawei.fastengine.fastview.shortcut.ShortCutManager.2
        public ServiceConnectionC47122() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            FastViewLogUtils.m28726i(ShortCutManager.TAG, "onServiceConnected");
            ShortCutManager.this.myBinder = IShortCutAidlInterface.Stub.m28720h(iBinder);
            if (ShortCutManager.this.myBinder != null) {
                try {
                    FastViewLogUtils.m28726i(ShortCutManager.TAG, "onServiceConnected: connect success");
                    ShortCutManager.this.isBound = true;
                    ShortCutManager.callbackMap.put(ShortCutManager.this.mPackageName, ShortCutManager.this.mShortCutCallback);
                    ShortCutManager shortCutManager2 = ShortCutManager.this;
                    shortCutManager2.setAidlCallTimeout(shortCutManager2.mPackageName);
                    ShortCutManager.this.myBinder.mo28718a(ShortCutManager.this.mPackageName, ShortCutManager.this.mIcon, ShortCutManager.this.mName, ShortCutManager.this.iFastAPPAidlCallback);
                    return;
                } catch (RemoteException unused) {
                    str = "onServiceConnected create error: RemoteException";
                }
            } else {
                str = "onServiceConnected: connect fail";
            }
            FastViewLogUtils.m28724e(ShortCutManager.TAG, str);
            ShortCutManager.this.mShortCutCallback.onCreateShortCut(4);
            ShortCutManager.this.unbindService();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            FastViewLogUtils.m28728w(ShortCutManager.TAG, "onServiceDisconnected");
        }
    };

    /* renamed from: com.huawei.fastengine.fastview.shortcut.ShortCutManager$1 */
    public class BinderC47111 extends IShortCutAidlCallback.Stub {
        public BinderC47111() {
        }

        @Override // com.huawei.fastapp.engine.shortcut.IShortCutAidlCallback
        public void onCreateShortCut(int i10, String str) {
            FastViewLogUtils.m28726i(ShortCutManager.TAG, "onCreateShortCut result: " + i10 + ", packageName: " + str);
            if (TextUtils.isEmpty(str)) {
                FastViewLogUtils.m28724e(ShortCutManager.TAG, "onCreateShortCut, packageName is null");
                return;
            }
            ShortCutCallback shortCutCallback = (ShortCutCallback) ShortCutManager.callbackMap.remove(str);
            if (shortCutCallback != null) {
                shortCutCallback.onCreateShortCut(i10);
            }
            if (ShortCutManager.callbackMap.isEmpty()) {
                ShortCutManager.this.unbindService();
            }
        }
    }

    /* renamed from: com.huawei.fastengine.fastview.shortcut.ShortCutManager$2 */
    public class ServiceConnectionC47122 implements ServiceConnection {
        public ServiceConnectionC47122() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            FastViewLogUtils.m28726i(ShortCutManager.TAG, "onServiceConnected");
            ShortCutManager.this.myBinder = IShortCutAidlInterface.Stub.m28720h(iBinder);
            if (ShortCutManager.this.myBinder != null) {
                try {
                    FastViewLogUtils.m28726i(ShortCutManager.TAG, "onServiceConnected: connect success");
                    ShortCutManager.this.isBound = true;
                    ShortCutManager.callbackMap.put(ShortCutManager.this.mPackageName, ShortCutManager.this.mShortCutCallback);
                    ShortCutManager shortCutManager2 = ShortCutManager.this;
                    shortCutManager2.setAidlCallTimeout(shortCutManager2.mPackageName);
                    ShortCutManager.this.myBinder.mo28718a(ShortCutManager.this.mPackageName, ShortCutManager.this.mIcon, ShortCutManager.this.mName, ShortCutManager.this.iFastAPPAidlCallback);
                    return;
                } catch (RemoteException unused) {
                    str = "onServiceConnected create error: RemoteException";
                }
            } else {
                str = "onServiceConnected: connect fail";
            }
            FastViewLogUtils.m28724e(ShortCutManager.TAG, str);
            ShortCutManager.this.mShortCutCallback.onCreateShortCut(4);
            ShortCutManager.this.unbindService();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            FastViewLogUtils.m28728w(ShortCutManager.TAG, "onServiceDisconnected");
        }
    }

    /* renamed from: com.huawei.fastengine.fastview.shortcut.ShortCutManager$3 */
    public class RunnableC47133 implements Runnable {
        final /* synthetic */ String val$packageName;

        public RunnableC47133(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            FastViewLogUtils.m28726i(ShortCutManager.TAG, "aidlCallTimeoutHandler| " + str);
            if (((ShortCutCallback) ShortCutManager.callbackMap.remove(str)) != null) {
                FastViewLogUtils.m28726i(ShortCutManager.TAG, "aidlCallTimeoutHandler| timeout: packageName=" + str);
                ShortCutManager.this.mShortCutCallback.onCreateShortCut(6);
                if (ShortCutManager.callbackMap.isEmpty()) {
                    ShortCutManager.this.unbindService();
                }
            }
        }
    }

    private void bindServiceByJumpActivity(Context context) {
        FastViewLogUtils.m28726i(TAG, "bindServiceByJumpActivity");
        Intent intent = new Intent();
        intent.setClass(context, JumpActivity.class);
        intent.putExtra("isfromShortCut", true);
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

    public static ShortCutManager getInstance() {
        if (shortCutManager == null) {
            synchronized (SHORT_CUT_LOCKER) {
                try {
                    if (shortCutManager == null) {
                        shortCutManager = new ShortCutManager();
                    }
                } finally {
                }
            }
        }
        return shortCutManager;
    }

    private boolean isServiceConnected() {
        return this.isBound && this.myBinder != null;
    }

    public void setAidlCallTimeout(String str) {
        FastViewLogUtils.m28726i(TAG, "setAidlCallTimeout: packageName=" + str + ", delayTime=2000ms");
        aidlCallTimeoutHandler.postDelayed(new Runnable() { // from class: com.huawei.fastengine.fastview.shortcut.ShortCutManager.3
            final /* synthetic */ String val$packageName;

            public RunnableC47133(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                FastViewLogUtils.m28726i(ShortCutManager.TAG, "aidlCallTimeoutHandler| " + str);
                if (((ShortCutCallback) ShortCutManager.callbackMap.remove(str)) != null) {
                    FastViewLogUtils.m28726i(ShortCutManager.TAG, "aidlCallTimeoutHandler| timeout: packageName=" + str);
                    ShortCutManager.this.mShortCutCallback.onCreateShortCut(6);
                    if (ShortCutManager.callbackMap.isEmpty()) {
                        ShortCutManager.this.unbindService();
                    }
                }
            }
        }, RippleView.SINGLE_RIPPLE_TIME);
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

    public void createShortcut(Context context, String str, String str2, String str3, ShortCutCallback shortCutCallback) {
        FastViewLogUtils.m28726i(TAG, "createShortcut");
        if (shortCutCallback == null) {
            FastViewLogUtils.m28724e(TAG, "createShortcut fail, shortCutCallback is null");
            return;
        }
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            FastViewLogUtils.m28724e(TAG, "createShortcut fail, parameter is null");
            shortCutCallback.onCreateShortCut(1);
            return;
        }
        if (!CheckUtils.isCorrectSign(context, Config.getPackageName())) {
            FastViewLogUtils.m28724e(TAG, "FastAPP sign is Wrong");
            shortCutCallback.onCreateShortCut(2);
            return;
        }
        if (isServiceConnected()) {
            try {
                callbackMap.put(str, shortCutCallback);
                setAidlCallTimeout(str);
                this.myBinder.mo28718a(str, str3, str2, this.iFastAPPAidlCallback);
                return;
            } catch (RemoteException unused) {
                FastViewLogUtils.m28724e(TAG, "ShortCutManager error: RemoteException");
                shortCutCallback.onCreateShortCut(3);
                return;
            }
        }
        this.mContext = context;
        this.mPackageName = str;
        this.mIcon = str3;
        this.mName = str2;
        this.mShortCutCallback = shortCutCallback;
        Intent intent = new Intent();
        intent.setAction(ACTION_AIDL_SHORTCUT);
        try {
            intent.setPackage(Config.getPackageName());
            if (this.mContext.bindService(intent, this.conn, 1)) {
                return;
            }
            FastViewLogUtils.m28724e(TAG, "bind service failed");
            bindServiceByJumpActivity(this.mContext);
        } catch (IllegalArgumentException | SecurityException unused2) {
            FastViewLogUtils.m28724e(TAG, "no permission bind service");
            this.mShortCutCallback.onCreateShortCut(2);
        }
    }

    public void jumpActivityCallback(boolean z10) {
        FastViewLogUtils.m28726i(TAG, "jumpActivityCallback: " + z10);
        if (!z10 || this.mContext == null) {
            ShortCutCallback shortCutCallback = this.mShortCutCallback;
            if (shortCutCallback != null) {
                shortCutCallback.onCreateShortCut(4);
                return;
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction(ACTION_AIDL_SHORTCUT);
        try {
            intent.setPackage(Config.getPackageName());
            if (this.mContext.bindService(intent, this.conn, 1)) {
                return;
            }
            FastViewLogUtils.m28724e(TAG, "jumpActivityCallback bind service failed");
            ShortCutCallback shortCutCallback2 = this.mShortCutCallback;
            if (shortCutCallback2 != null) {
                shortCutCallback2.onCreateShortCut(4);
            }
        } catch (IllegalArgumentException | SecurityException unused) {
            FastViewLogUtils.m28724e(TAG, "no permission bind service");
            this.mShortCutCallback.onCreateShortCut(2);
        }
    }
}
