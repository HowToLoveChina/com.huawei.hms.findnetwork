package com.huawei.fastengine.fastview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.huawei.fastapp.engine.IFastAPPAidlInterface;
import com.huawei.fastengine.C4683R;
import com.huawei.fastengine.fastview.download.download.HiappDownloadActivity;
import com.huawei.fastengine.fastview.download.utils.CheckUtils;
import com.huawei.fastengine.fastview.download.utils.CommonUtils;
import com.huawei.fastengine.fastview.download.utils.PackageUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.startfastappengine.JumpActivity;
import com.huawei.fastengine.fastview.startfastappengine.bean.RpkInfo;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class StartFastAPPEngine {
    public static final String ACTION_AIDL_FASTAPP = "com.huawei.fastapp.engine.action.AIDL_SERVICE";
    private static final String ACTION_MANAGEMENT_FASTAPP = "com.huawei.fastapp.ACTION_MANAGER";
    private static final String TAG = "StartFastAPPEngine";
    private static StartFastAPPEngine mInstance = new StartFastAPPEngine();
    private AlertDialog dialog;
    private IFastAPPAidlInterface fastappService;
    private Bundle mBundle;
    private WeakReference<Context> mContextWr;
    private RpkInfo mRpkinfo;
    private boolean isNeedStartActivity = false;
    private boolean mTimeOut = false;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.huawei.fastengine.fastview.StartFastAPPEngine.1
        public HandlerC46931(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Context context;
            String str;
            FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, "handleMessage: " + message.what);
            switch (message.what) {
                case 1001:
                    Value value = (Value) CommonUtils.cast(message.obj, Value.class, false);
                    StartFastAPPEngine.this.mRpkinfo = value.mRpkInfoValue;
                    StartFastAPPEngine.this.mContextWr = new WeakReference(value.mContext);
                    if (PackageUtils.isInstallByPackage(value.mContext, Config.getPackageName())) {
                        StartFastAPPEngine.this.bindService(value.mContext);
                        return;
                    }
                    Intent intent = new Intent(value.mContext, (Class<?>) HiappDownloadActivity.class);
                    intent.putExtra("packageName", StartFastAPPEngine.this.mRpkinfo.getPackageName());
                    value.mContext.startActivity(intent);
                    return;
                case 1002:
                    return;
                case 1003:
                    FastViewLogUtils.m28724e(StartFastAPPEngine.TAG, "BIND_FAILED: startActivity");
                    if (StartFastAPPEngine.this.mContextWr != null && (context = (Context) StartFastAPPEngine.this.mContextWr.get()) != null) {
                        Intent intent2 = new Intent();
                        intent2.setClass(context, JumpActivity.class);
                        intent2.putExtra("isfromold", true);
                        if (!(context instanceof Activity)) {
                            intent2.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                        }
                        try {
                            context.startActivity(intent2);
                            if (context instanceof Activity) {
                                ((Activity) context).overridePendingTransition(0, 0);
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            str = "ActivityNotFoundException：";
                            break;
                        }
                    } else {
                        return;
                    }
                    break;
                case 1004:
                    StartFastAPPEngine.this.mTimeOut = false;
                    return;
                default:
                    str = "error default ";
                    break;
            }
            FastViewLogUtils.m28724e(StartFastAPPEngine.TAG, str);
        }
    };
    private ServiceConnection conn = new ServiceConnection() { // from class: com.huawei.fastengine.fastview.StartFastAPPEngine.2
        public ServiceConnectionC46942() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Message messageObtain = Message.obtain(StartFastAPPEngine.this.mHandler);
            messageObtain.what = 1002;
            StartFastAPPEngine.this.mHandler.sendMessage(messageObtain);
            StartFastAPPEngine.this.fastappService = IFastAPPAidlInterface.Stub.m28714h(iBinder);
            try {
                FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, " onServiceConnected bind success");
                if (StartFastAPPEngine.this.mBundle != null) {
                    FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, " onServiceConnected startManagerment");
                    StartFastAPPEngine.this.fastappService.mo28706a(StartFastAPPEngine.this.mBundle.getString(FaqConstants.FAQ_CHANNEL), StartFastAPPEngine.this.mBundle.getString("target"), null);
                } else if (StartFastAPPEngine.this.mRpkinfo != null) {
                    FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, " onServiceConnected startRpk");
                    StartFastAPPEngine.this.fastappService.mo28708a(StartFastAPPEngine.this.mRpkinfo.getPackageName(), StartFastAPPEngine.this.mRpkinfo.getAppid(), StartFastAPPEngine.this.mRpkinfo.getDownloadUrl(), StartFastAPPEngine.this.mRpkinfo.getVersionCode(), StartFastAPPEngine.this.mRpkinfo.getDigest(), null);
                } else {
                    FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, "Other cases.");
                }
                StartFastAPPEngine.this.unbindService();
            } catch (RemoteException unused) {
                FastViewLogUtils.m28724e(StartFastAPPEngine.TAG, " ERROR RemoteException");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, "onServiceDisconnected");
            StartFastAPPEngine.this.fastappService = null;
        }
    };

    /* renamed from: com.huawei.fastengine.fastview.StartFastAPPEngine$1 */
    public class HandlerC46931 extends Handler {
        public HandlerC46931(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Context context;
            String str;
            FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, "handleMessage: " + message.what);
            switch (message.what) {
                case 1001:
                    Value value = (Value) CommonUtils.cast(message.obj, Value.class, false);
                    StartFastAPPEngine.this.mRpkinfo = value.mRpkInfoValue;
                    StartFastAPPEngine.this.mContextWr = new WeakReference(value.mContext);
                    if (PackageUtils.isInstallByPackage(value.mContext, Config.getPackageName())) {
                        StartFastAPPEngine.this.bindService(value.mContext);
                        return;
                    }
                    Intent intent = new Intent(value.mContext, (Class<?>) HiappDownloadActivity.class);
                    intent.putExtra("packageName", StartFastAPPEngine.this.mRpkinfo.getPackageName());
                    value.mContext.startActivity(intent);
                    return;
                case 1002:
                    return;
                case 1003:
                    FastViewLogUtils.m28724e(StartFastAPPEngine.TAG, "BIND_FAILED: startActivity");
                    if (StartFastAPPEngine.this.mContextWr != null && (context = (Context) StartFastAPPEngine.this.mContextWr.get()) != null) {
                        Intent intent2 = new Intent();
                        intent2.setClass(context, JumpActivity.class);
                        intent2.putExtra("isfromold", true);
                        if (!(context instanceof Activity)) {
                            intent2.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                        }
                        try {
                            context.startActivity(intent2);
                            if (context instanceof Activity) {
                                ((Activity) context).overridePendingTransition(0, 0);
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            str = "ActivityNotFoundException：";
                            break;
                        }
                    } else {
                        return;
                    }
                    break;
                case 1004:
                    StartFastAPPEngine.this.mTimeOut = false;
                    return;
                default:
                    str = "error default ";
                    break;
            }
            FastViewLogUtils.m28724e(StartFastAPPEngine.TAG, str);
        }
    }

    /* renamed from: com.huawei.fastengine.fastview.StartFastAPPEngine$2 */
    public class ServiceConnectionC46942 implements ServiceConnection {
        public ServiceConnectionC46942() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Message messageObtain = Message.obtain(StartFastAPPEngine.this.mHandler);
            messageObtain.what = 1002;
            StartFastAPPEngine.this.mHandler.sendMessage(messageObtain);
            StartFastAPPEngine.this.fastappService = IFastAPPAidlInterface.Stub.m28714h(iBinder);
            try {
                FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, " onServiceConnected bind success");
                if (StartFastAPPEngine.this.mBundle != null) {
                    FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, " onServiceConnected startManagerment");
                    StartFastAPPEngine.this.fastappService.mo28706a(StartFastAPPEngine.this.mBundle.getString(FaqConstants.FAQ_CHANNEL), StartFastAPPEngine.this.mBundle.getString("target"), null);
                } else if (StartFastAPPEngine.this.mRpkinfo != null) {
                    FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, " onServiceConnected startRpk");
                    StartFastAPPEngine.this.fastappService.mo28708a(StartFastAPPEngine.this.mRpkinfo.getPackageName(), StartFastAPPEngine.this.mRpkinfo.getAppid(), StartFastAPPEngine.this.mRpkinfo.getDownloadUrl(), StartFastAPPEngine.this.mRpkinfo.getVersionCode(), StartFastAPPEngine.this.mRpkinfo.getDigest(), null);
                } else {
                    FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, "Other cases.");
                }
                StartFastAPPEngine.this.unbindService();
            } catch (RemoteException unused) {
                FastViewLogUtils.m28724e(StartFastAPPEngine.TAG, " ERROR RemoteException");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            FastViewLogUtils.m28726i(StartFastAPPEngine.TAG, "onServiceDisconnected");
            StartFastAPPEngine.this.fastappService = null;
        }
    }

    public interface MSG {
        public static final int BIND_FAILED = 1003;
        public static final int BIND_SUCCESS = 1002;
        public static final int START_ENGINE = 1001;
        public static final int TIME_OUT = 1004;
    }

    public static class Value {
        public Context mContext;
        public RpkInfo mRpkInfoValue;

        public Value(Context context, RpkInfo rpkInfo) {
            this.mContext = context;
            this.mRpkInfoValue = rpkInfo;
        }
    }

    private StartFastAPPEngine() {
    }

    public void bindService(Context context) {
        FastViewLogUtils.m28726i(TAG, "begin to bindService");
        if (context == null) {
            FastViewLogUtils.m28724e(TAG, "bindService context is null");
            return;
        }
        if (!CheckUtils.isCorrectSign(context, Config.getPackageName())) {
            FastViewLogUtils.m28724e(TAG, "FastAPP sign is Wrong");
            return;
        }
        if (this.isNeedStartActivity) {
            this.isNeedStartActivity = false;
            FastViewLogUtils.m28726i(TAG, "firstStart");
            Message messageObtain = Message.obtain(this.mHandler);
            messageObtain.what = 1003;
            this.mHandler.sendMessage(messageObtain);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.fastapp.engine.action.AIDL_SERVICE");
        intent.setPackage(Config.getPackageName());
        if (context.bindService(intent, this.conn, 1)) {
            return;
        }
        FastViewLogUtils.m28724e(TAG, "bind service failed");
        Message messageObtain2 = Message.obtain(this.mHandler);
        messageObtain2.what = 1003;
        this.mHandler.sendMessage(messageObtain2);
    }

    public static StartFastAPPEngine getInstance() {
        return mInstance;
    }

    private void showNormalDialog(Context context) {
        if (context == null) {
            return;
        }
        String string = context.getString(C4683R.string.fastview_sdk_fastapp_noopen_msg_v2);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(string);
        builder.setPositiveButton(context.getString(C4683R.string.fastview_sdk_fastapp_aidl_confirm), (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        this.dialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            this.dialog.show();
        }
    }

    private void startManagermentActivity(Context context, Bundle bundle) {
        Intent intent = new Intent();
        String string = bundle.getString(FaqConstants.FAQ_CHANNEL);
        String string2 = bundle.getString("target");
        intent.setAction(ACTION_MANAGEMENT_FASTAPP);
        intent.setPackage(Config.getPackageName());
        intent.putExtra(FaqConstants.FAQ_CHANNEL, string);
        intent.putExtra("target", string2);
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivity(intent);
            } else {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                context.startActivity(intent);
            }
        } catch (Exception unused) {
            FastViewLogUtils.m28724e(TAG, "openFastappManagement Exception!");
        }
    }

    public void unbindService() {
        Context context;
        FastViewLogUtils.m28726i("", "unbind Service");
        try {
            WeakReference<Context> weakReference = this.mContextWr;
            if (weakReference == null || (context = weakReference.get()) == null) {
                return;
            }
            context.unbindService(this.conn);
        } catch (Exception unused) {
            FastViewLogUtils.m28724e("", "unbind service error");
        }
    }

    public void openFastApp(Context context, RpkInfo rpkInfo) {
        if (rpkInfo == null || this.mTimeOut) {
            return;
        }
        this.mTimeOut = true;
        this.isNeedStartActivity = false;
        this.mBundle = null;
        FastViewLogUtils.m28726i(TAG, "openFastApp");
        Value value = new Value(context, rpkInfo);
        Message messageObtain = Message.obtain(this.mHandler);
        messageObtain.what = 1001;
        messageObtain.obj = value;
        this.mHandler.removeMessages(1001);
        this.mHandler.sendMessage(messageObtain);
        Message messageObtain2 = Message.obtain(this.mHandler);
        messageObtain2.what = 1004;
        this.mHandler.sendMessageDelayed(messageObtain2, 500L);
    }

    public void openFastAppFromDownload(RpkInfo rpkInfo) {
        Context context;
        WeakReference<Context> weakReference = this.mContextWr;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        this.isNeedStartActivity = true;
        this.mBundle = null;
        FastViewLogUtils.m28726i(TAG, "openFastApp first");
        Value value = new Value(context, rpkInfo);
        Message messageObtain = Message.obtain(this.mHandler);
        messageObtain.what = 1001;
        messageObtain.obj = value;
        this.mHandler.sendMessage(messageObtain);
    }

    public void openFastappManagement(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            FastViewLogUtils.m28724e(TAG, "openFastappManagement input null!");
            return;
        }
        this.mContextWr = new WeakReference<>(context);
        this.mBundle = bundle;
        this.isNeedStartActivity = false;
        if (PackageUtils.isEngineInstalled(context)) {
            startManagermentActivity(context, bundle);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) HiappDownloadActivity.class);
        intent.putExtra("Management", bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivity(intent);
        } else {
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(intent);
        }
    }

    public void openFastappManagementFromDownload(Bundle bundle) {
        WeakReference<Context> weakReference = this.mContextWr;
        if (weakReference == null) {
            return;
        }
        Context context = weakReference.get();
        if (context == null || bundle == null) {
            FastViewLogUtils.m28724e(TAG, "openFastappManagementFromDownload null!");
        } else {
            this.mBundle = bundle;
            bindService(context);
        }
    }

    public void setJumpActivityStatus(boolean z10) {
        Context context;
        FastViewLogUtils.m28726i(TAG, "setActivityStatus: " + z10);
        WeakReference<Context> weakReference = this.mContextWr;
        if (weakReference == null) {
            return;
        }
        if (z10) {
            bindService(weakReference.get());
            return;
        }
        AlertDialog alertDialog = this.dialog;
        if (alertDialog == null) {
            context = weakReference.get();
        } else {
            if (alertDialog.isShowing()) {
                FastViewLogUtils.m28726i(TAG, "Other cases.");
                return;
            }
            context = this.mContextWr.get();
        }
        showNormalDialog(context);
    }
}
