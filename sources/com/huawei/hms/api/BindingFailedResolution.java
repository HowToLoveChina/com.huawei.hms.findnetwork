package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.p148ui.AbstractDialog;
import com.huawei.hms.p148ui.AbstractPromptDialog;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;

/* loaded from: classes8.dex */
public class BindingFailedResolution implements IBridgeActivityDelegate, ServiceConnection {
    private static final Object LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
    private static final int MSG_CONN_TIMEOUT = 2;
    private static final int MSG_SELF_DESTROY_TIMEOUT = 3;
    private static final int REQUEST_CODE = 2003;
    private static final String TAG = "BindingFailedResolution";
    private FailedBinderCallBack.BinderCallBack callBack;
    private Activity curActivity;
    private C5115d promptdlg;
    private boolean isStarting = true;
    private Handler mConnectTimeoutHandler = null;
    private Handler selfDestroyHandler = null;

    /* renamed from: com.huawei.hms.api.BindingFailedResolution$a */
    public class C5112a implements Handler.Callback {
        public C5112a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            HMSLog.m36988i(BindingFailedResolution.TAG, "selfDestroyHandle：MSG_SELF_DESTROY_TIMEOUT");
            BindingFailedResolution.this.noticeBindFailed();
            BindingFailedResolution.this.finishBridgeActivity(8);
            return true;
        }
    }

    /* renamed from: com.huawei.hms.api.BindingFailedResolution$b */
    public class C5113b implements Handler.Callback {
        public C5113b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.m36986e(BindingFailedResolution.TAG, "In connect, bind core try timeout");
            BindingFailedResolution.this.fireStartResult(false);
            return true;
        }
    }

    /* renamed from: com.huawei.hms.api.BindingFailedResolution$c */
    public class C5114c implements AbstractDialog.Callback {
        public C5114c() {
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(AbstractDialog abstractDialog) {
            BindingFailedResolution.this.promptdlg = null;
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.this.finishBridgeActivity(8);
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(AbstractDialog abstractDialog) {
            BindingFailedResolution.this.promptdlg = null;
            BindResolveClients.getInstance().unRegisterAll();
            BindingFailedResolution.this.finishBridgeActivity(8);
        }
    }

    /* renamed from: com.huawei.hms.api.BindingFailedResolution$d */
    public static class C5115d extends AbstractPromptDialog {
        private C5115d() {
        }

        @Override // com.huawei.hms.p148ui.AbstractDialog
        public String onGetMessageString(Context context) {
            String appName = Util.getAppName(context, null);
            String appName2 = Util.getAppName(context, HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService());
            Object[] objArr = new Object[2];
            objArr[0] = appName;
            if (TextUtils.isEmpty(appName2)) {
                appName2 = "com.huawei.hwid";
            }
            objArr[1] = appName2;
            return ResourceLoaderUtil.getString("hms_bindfaildlg_message", objArr);
        }

        @Override // com.huawei.hms.p148ui.AbstractDialog
        public String onGetPositiveButtonString(Context context) {
            return ResourceLoaderUtil.getString("hms_confirm");
        }

        public /* synthetic */ C5115d(C5112a c5112a) {
            this();
        }
    }

    private void bindCoreService(boolean z10) {
        Activity activity = getActivity();
        if (activity == null) {
            HMSLog.m36986e(TAG, "In connect, bind core try fail");
            fireStartResult(false);
            noticeBindResult(z10, 8);
            return;
        }
        Intent intent = new Intent(HMSPackageManager.getInstance(activity.getApplicationContext()).getServiceAction());
        try {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                HMSLog.m36986e(TAG, "servicePackageName is empty, Service is invalid.");
                fireStartResult(false);
                noticeBindResult(z10, 1);
                return;
            }
            intent.setPackage(hMSPackageNameForMultiService);
            synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
                try {
                    if (activity.bindService(intent, this, 1)) {
                        postConnDelayHandle();
                        return;
                    }
                    HMSLog.m36986e(TAG, "In connect, bind core try fail");
                    fireStartResult(false);
                    noticeBindResult(z10, 8);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (IllegalArgumentException unused) {
            HMSLog.m36986e(TAG, "IllegalArgumentException when bindCoreService intent.setPackage");
            fireStartResult(false);
            noticeBindResult(z10, 8);
        }
    }

    private void cancelConnDelayHandle() {
        synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
            try {
                Handler handler = this.mConnectTimeoutHandler;
                if (handler != null) {
                    handler.removeMessages(2);
                    this.mConnectTimeoutHandler = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void finishBridgeActivity(int i10) {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        HMSLog.m36988i(TAG, "finishBridgeActivity：" + i10);
        Intent intent = new Intent();
        intent.putExtra(BridgeActivity.EXTRA_RESULT, i10);
        activity.setResult(-1, intent);
        Util.unBindServiceCatchException(activity, this);
        activity.finish();
    }

    public void fireStartResult(boolean z10) {
        if (this.isStarting) {
            this.isStarting = false;
            onStartResult(z10);
        }
    }

    public void noticeBindFailed() {
        FailedBinderCallBack.BinderCallBack binderCallBack = this.callBack;
        if (binderCallBack != null) {
            binderCallBack.binderCallBack(8);
        }
    }

    private void noticeBindResult(boolean z10, int i10) {
        FailedBinderCallBack.BinderCallBack binderCallBack;
        if (!z10 || (binderCallBack = this.callBack) == null) {
            return;
        }
        binderCallBack.binderCallBack(i10);
    }

    private void postConnDelayHandle() {
        Handler handler = this.mConnectTimeoutHandler;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.mConnectTimeoutHandler = new Handler(Looper.getMainLooper(), new C5113b());
        }
        this.mConnectTimeoutHandler.sendEmptyMessageDelayed(2, 5000L);
    }

    private void selfDestroyHandle() {
        Handler handler = this.selfDestroyHandler;
        if (handler != null) {
            handler.removeMessages(3);
        } else {
            this.selfDestroyHandler = new Handler(Looper.getMainLooper(), new C5112a());
        }
        this.selfDestroyHandler.sendEmptyMessageDelayed(3, 4000L);
    }

    private void showPromptdlg() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        C5115d c5115d = this.promptdlg;
        if (c5115d == null) {
            this.promptdlg = new C5115d(null);
        } else {
            c5115d.dismiss();
        }
        HMSLog.m36988i(TAG, "showPromptdlg to resolve conn error");
        this.promptdlg.show(activity, new C5114c());
    }

    private void tryStartHmsActivity(Activity activity) {
        String hMSPackageNameForMultiService = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService();
        if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
            HMSLog.m36989w(TAG, "servicePackageName is empty, Service is invalid.");
            Handler handler = this.selfDestroyHandler;
            if (handler != null) {
                handler.removeMessages(3);
                this.selfDestroyHandler = null;
            }
            bindCoreService(false);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(activity));
        intent.setClassName(hMSPackageNameForMultiService, HuaweiApiAvailability.ACTIVITY_NAME);
        HMSLog.m36988i(TAG, "onBridgeActivityCreate：try to start HMS");
        try {
            activity.startActivityForResult(intent, getRequestCode());
        } catch (Throwable th2) {
            HMSLog.m36986e(TAG, "ActivityNotFoundException：" + th2.getMessage());
            Handler handler2 = this.selfDestroyHandler;
            if (handler2 != null) {
                handler2.removeMessages(3);
                this.selfDestroyHandler = null;
            }
            bindCoreService(false);
        }
    }

    public Activity getActivity() {
        return this.curActivity;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 2003;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.m36986e(TAG, "activity is null");
            selfDestroyHandle();
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.m36986e(TAG, "activity is finishing");
            return;
        }
        Intent intent = activity.getIntent();
        if (intent != null && intent.hasExtra(FailedBinderCallBack.CALLER_ID)) {
            long longExtra = 0;
            try {
                longExtra = intent.getLongExtra(FailedBinderCallBack.CALLER_ID, 0L);
            } catch (Exception e10) {
                HMSLog.m36986e(TAG, "getExtras for callId exception:" + e10.getMessage());
            }
            this.callBack = FailedBinderCallBack.getInstance().getCallBack(Long.valueOf(longExtra));
        }
        this.curActivity = activity;
        BindingFailedResolveMgr.f23328b.m30561a(activity);
        selfDestroyHandle();
        tryStartHmsActivity(activity);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        cancelConnDelayHandle();
        BindingFailedResolveMgr.f23328b.m30562b(this.curActivity);
        this.curActivity = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i10, int i11, Intent intent) {
        if (i10 != getRequestCode()) {
            return false;
        }
        HMSLog.m36988i(TAG, "onBridgeActivityResult");
        Handler handler = this.selfDestroyHandler;
        if (handler != null) {
            handler.removeMessages(3);
            this.selfDestroyHandler = null;
        }
        bindCoreService(true);
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        if (this.promptdlg == null) {
            return;
        }
        HMSLog.m36988i(TAG, "re show prompt dialog");
        showPromptdlg();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i10, KeyEvent keyEvent) {
        HMSLog.m36988i(TAG, "On key up when resolve conn error");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        cancelConnDelayHandle();
        fireStartResult(true);
        if (getActivity() == null) {
            return;
        }
        HMSLog.m36988i(TAG, "test connect success, try to reConnect and reply message");
        BindResolveClients.getInstance().notifyClientReconnect();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    public void onStartResult(boolean z10) {
        if (getActivity() == null) {
            return;
        }
        if (z10) {
            finishBridgeActivity(0);
        } else {
            showPromptdlg();
        }
    }
}
