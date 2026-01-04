package com.huawei.fastengine.fastview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.huawei.fastapp.engine.IFastAPPAidlInterface;
import com.huawei.fastengine.C4683R;
import com.huawei.fastengine.fastview.download.download.DownloadActivity;
import com.huawei.fastengine.fastview.download.utils.CheckUtils;
import com.huawei.fastengine.fastview.download.utils.CommonUtils;
import com.huawei.fastengine.fastview.download.utils.PackageUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.startfastappengine.JumpActivity;
import com.huawei.fastengine.fastview.startfastappengine.bean.Options;
import com.huawei.fastengine.fastview.startfastappengine.bean.RpkPageInfo;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class OpenFastAppEngine {
    public static final String ACTION_AIDL_FASTAPP = "com.huawei.fastapp.engine.action.AIDL_SERVICE";
    private static final String TAG = "OpenFastAppEngine";
    private static OpenFastAppEngine mInstance = new OpenFastAppEngine();
    private AlertDialog dialog;
    private IFastAPPAidlInterface fastappService;
    private WeakReference<Context> mContextWr;
    private RpkPageInfo mRpkinfo;
    private boolean isNeedStartActivity = false;
    private boolean mTimeOut = false;
    private boolean mNeedDownload = false;
    private int retryNum = 1;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.huawei.fastengine.fastview.OpenFastAppEngine.1
        public HandlerC46861(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Context context;
            String str;
            FastViewLogUtils.m28726i(OpenFastAppEngine.TAG, "handleMessage: " + message.what);
            switch (message.what) {
                case 1001:
                    Value value = (Value) CommonUtils.cast(message.obj, Value.class, false);
                    OpenFastAppEngine.this.mRpkinfo = value.mRpkInfoValue;
                    OpenFastAppEngine.this.mContextWr = new WeakReference(value.mContext);
                    if (PackageUtils.isEngineInstalled(value.mContext)) {
                        OpenFastAppEngine.this.bindService(value.mContext);
                        return;
                    }
                    if (OpenFastAppEngine.this.mNeedDownload) {
                        FastViewLogUtils.m28726i(OpenFastAppEngine.TAG, "download engine");
                        Intent intent = new Intent(value.mContext, (Class<?>) DownloadActivity.class);
                        if (OpenFastAppEngine.this.mRpkinfo != null) {
                            intent.putExtra(DownloadActivity.INTENT_BUNDLE_KEY_RPK_LOADER_PAGE, OpenFastAppEngine.this.mRpkinfo);
                        }
                        value.mContext.startActivity(intent);
                        return;
                    }
                    return;
                case 1002:
                    return;
                case 1003:
                    FastViewLogUtils.m28724e(OpenFastAppEngine.TAG, "BIND_FAILED: startActivity");
                    if (OpenFastAppEngine.this.mContextWr != null && (context = (Context) OpenFastAppEngine.this.mContextWr.get()) != null) {
                        Intent intent2 = new Intent();
                        intent2.setClass(context, JumpActivity.class);
                        intent2.putExtra("isfromold", false);
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
                        } catch (ActivityNotFoundException unused) {
                            str = "ActivityNotFoundException：";
                            break;
                        }
                    } else {
                        return;
                    }
                    break;
                case 1004:
                    OpenFastAppEngine.this.mTimeOut = false;
                    return;
                default:
                    str = "error default ";
                    break;
            }
            FastViewLogUtils.m28724e(OpenFastAppEngine.TAG, str);
        }
    };
    private ServiceConnection conn = new ServiceConnection() { // from class: com.huawei.fastengine.fastview.OpenFastAppEngine.2
        public ServiceConnectionC46872() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            Message messageObtain = Message.obtain(OpenFastAppEngine.this.mHandler);
            messageObtain.what = 1002;
            OpenFastAppEngine.this.mHandler.sendMessage(messageObtain);
            OpenFastAppEngine.this.fastappService = IFastAPPAidlInterface.Stub.m28714h(iBinder);
            if (OpenFastAppEngine.this.mContextWr != null) {
                Context context = (Context) OpenFastAppEngine.this.mContextWr.get();
                try {
                    FastViewLogUtils.m28726i(OpenFastAppEngine.TAG, " onServiceConnected bind success");
                    if (OpenFastAppEngine.this.mRpkinfo != null) {
                        String pageParam = OpenFastAppEngine.this.mRpkinfo.getPageParam();
                        if (!FastSDKEngine.canUseRpkPageNew(context, Config.getPackageName())) {
                            OpenFastAppEngine.this.fastappService.mo28712a(OpenFastAppEngine.this.mRpkinfo.getPackageName(), OpenFastAppEngine.this.mRpkinfo.getPageUri(), pageParam, OpenFastAppEngine.this.mRpkinfo.isLatestNeed(), OpenFastAppEngine.this.mRpkinfo.isCreateShortCut() == 1, (String) null, OpenFastAppEngine.this.mRpkinfo.getSourcePackage(), OpenFastAppEngine.this.mRpkinfo.getAppName(), OpenFastAppEngine.this.mRpkinfo.getInterruptedUri());
                        } else if (FastSDKEngine.supportUserExp(context, Config.getPackageName())) {
                            if (OpenFastAppEngine.this.mRpkinfo.getOptions() == null) {
                                OpenFastAppEngine.this.mRpkinfo.setOptions(new Options());
                            }
                            OpenFastAppEngine.this.fastappService.mo28711a(OpenFastAppEngine.this.mRpkinfo.getPackageName(), OpenFastAppEngine.this.mRpkinfo.getPageUri(), pageParam, OpenFastAppEngine.this.mRpkinfo.isLatestNeed(), OpenFastAppEngine.this.mRpkinfo.isCreateShortCut(), null, OpenFastAppEngine.this.mRpkinfo.getSourcePackage(), OpenFastAppEngine.this.mRpkinfo.getAppName(), OpenFastAppEngine.this.mRpkinfo.getInterruptedUri(), null, OpenFastAppEngine.this.mRpkinfo.getOptions().getActionbarLockCustomize(), OpenFastAppEngine.this.mRpkinfo.getOptions().isActionbarLockStatus(), OpenFastAppEngine.this.mRpkinfo.getOptions().getLoadingPolicy());
                        } else {
                            OpenFastAppEngine.this.fastappService.mo28710a(OpenFastAppEngine.this.mRpkinfo.getPackageName(), OpenFastAppEngine.this.mRpkinfo.getPageUri(), pageParam, OpenFastAppEngine.this.mRpkinfo.isLatestNeed(), OpenFastAppEngine.this.mRpkinfo.isCreateShortCut(), (String) null, OpenFastAppEngine.this.mRpkinfo.getSourcePackage(), OpenFastAppEngine.this.mRpkinfo.getAppName(), OpenFastAppEngine.this.mRpkinfo.getInterruptedUri());
                        }
                    }
                    OpenFastAppEngine.this.unbindService();
                    return;
                } catch (RemoteException unused) {
                    str = " ERROR RemoteException";
                }
            } else {
                str = " mContextWr null";
            }
            FastViewLogUtils.m28724e(OpenFastAppEngine.TAG, str);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            FastViewLogUtils.m28726i(OpenFastAppEngine.TAG, "onServiceDisconnected");
            OpenFastAppEngine.this.fastappService = null;
        }
    };

    /* renamed from: com.huawei.fastengine.fastview.OpenFastAppEngine$1 */
    public class HandlerC46861 extends Handler {
        public HandlerC46861(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Context context;
            String str;
            FastViewLogUtils.m28726i(OpenFastAppEngine.TAG, "handleMessage: " + message.what);
            switch (message.what) {
                case 1001:
                    Value value = (Value) CommonUtils.cast(message.obj, Value.class, false);
                    OpenFastAppEngine.this.mRpkinfo = value.mRpkInfoValue;
                    OpenFastAppEngine.this.mContextWr = new WeakReference(value.mContext);
                    if (PackageUtils.isEngineInstalled(value.mContext)) {
                        OpenFastAppEngine.this.bindService(value.mContext);
                        return;
                    }
                    if (OpenFastAppEngine.this.mNeedDownload) {
                        FastViewLogUtils.m28726i(OpenFastAppEngine.TAG, "download engine");
                        Intent intent = new Intent(value.mContext, (Class<?>) DownloadActivity.class);
                        if (OpenFastAppEngine.this.mRpkinfo != null) {
                            intent.putExtra(DownloadActivity.INTENT_BUNDLE_KEY_RPK_LOADER_PAGE, OpenFastAppEngine.this.mRpkinfo);
                        }
                        value.mContext.startActivity(intent);
                        return;
                    }
                    return;
                case 1002:
                    return;
                case 1003:
                    FastViewLogUtils.m28724e(OpenFastAppEngine.TAG, "BIND_FAILED: startActivity");
                    if (OpenFastAppEngine.this.mContextWr != null && (context = (Context) OpenFastAppEngine.this.mContextWr.get()) != null) {
                        Intent intent2 = new Intent();
                        intent2.setClass(context, JumpActivity.class);
                        intent2.putExtra("isfromold", false);
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
                        } catch (ActivityNotFoundException unused) {
                            str = "ActivityNotFoundException：";
                            break;
                        }
                    } else {
                        return;
                    }
                    break;
                case 1004:
                    OpenFastAppEngine.this.mTimeOut = false;
                    return;
                default:
                    str = "error default ";
                    break;
            }
            FastViewLogUtils.m28724e(OpenFastAppEngine.TAG, str);
        }
    }

    /* renamed from: com.huawei.fastengine.fastview.OpenFastAppEngine$2 */
    public class ServiceConnectionC46872 implements ServiceConnection {
        public ServiceConnectionC46872() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            Message messageObtain = Message.obtain(OpenFastAppEngine.this.mHandler);
            messageObtain.what = 1002;
            OpenFastAppEngine.this.mHandler.sendMessage(messageObtain);
            OpenFastAppEngine.this.fastappService = IFastAPPAidlInterface.Stub.m28714h(iBinder);
            if (OpenFastAppEngine.this.mContextWr != null) {
                Context context = (Context) OpenFastAppEngine.this.mContextWr.get();
                try {
                    FastViewLogUtils.m28726i(OpenFastAppEngine.TAG, " onServiceConnected bind success");
                    if (OpenFastAppEngine.this.mRpkinfo != null) {
                        String pageParam = OpenFastAppEngine.this.mRpkinfo.getPageParam();
                        if (!FastSDKEngine.canUseRpkPageNew(context, Config.getPackageName())) {
                            OpenFastAppEngine.this.fastappService.mo28712a(OpenFastAppEngine.this.mRpkinfo.getPackageName(), OpenFastAppEngine.this.mRpkinfo.getPageUri(), pageParam, OpenFastAppEngine.this.mRpkinfo.isLatestNeed(), OpenFastAppEngine.this.mRpkinfo.isCreateShortCut() == 1, (String) null, OpenFastAppEngine.this.mRpkinfo.getSourcePackage(), OpenFastAppEngine.this.mRpkinfo.getAppName(), OpenFastAppEngine.this.mRpkinfo.getInterruptedUri());
                        } else if (FastSDKEngine.supportUserExp(context, Config.getPackageName())) {
                            if (OpenFastAppEngine.this.mRpkinfo.getOptions() == null) {
                                OpenFastAppEngine.this.mRpkinfo.setOptions(new Options());
                            }
                            OpenFastAppEngine.this.fastappService.mo28711a(OpenFastAppEngine.this.mRpkinfo.getPackageName(), OpenFastAppEngine.this.mRpkinfo.getPageUri(), pageParam, OpenFastAppEngine.this.mRpkinfo.isLatestNeed(), OpenFastAppEngine.this.mRpkinfo.isCreateShortCut(), null, OpenFastAppEngine.this.mRpkinfo.getSourcePackage(), OpenFastAppEngine.this.mRpkinfo.getAppName(), OpenFastAppEngine.this.mRpkinfo.getInterruptedUri(), null, OpenFastAppEngine.this.mRpkinfo.getOptions().getActionbarLockCustomize(), OpenFastAppEngine.this.mRpkinfo.getOptions().isActionbarLockStatus(), OpenFastAppEngine.this.mRpkinfo.getOptions().getLoadingPolicy());
                        } else {
                            OpenFastAppEngine.this.fastappService.mo28710a(OpenFastAppEngine.this.mRpkinfo.getPackageName(), OpenFastAppEngine.this.mRpkinfo.getPageUri(), pageParam, OpenFastAppEngine.this.mRpkinfo.isLatestNeed(), OpenFastAppEngine.this.mRpkinfo.isCreateShortCut(), (String) null, OpenFastAppEngine.this.mRpkinfo.getSourcePackage(), OpenFastAppEngine.this.mRpkinfo.getAppName(), OpenFastAppEngine.this.mRpkinfo.getInterruptedUri());
                        }
                    }
                    OpenFastAppEngine.this.unbindService();
                    return;
                } catch (RemoteException unused) {
                    str = " ERROR RemoteException";
                }
            } else {
                str = " mContextWr null";
            }
            FastViewLogUtils.m28724e(OpenFastAppEngine.TAG, str);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            FastViewLogUtils.m28726i(OpenFastAppEngine.TAG, "onServiceDisconnected");
            OpenFastAppEngine.this.fastappService = null;
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
        public RpkPageInfo mRpkInfoValue;

        public Value(Context context, RpkPageInfo rpkPageInfo) {
            this.mContext = context;
            this.mRpkInfoValue = rpkPageInfo;
        }
    }

    private OpenFastAppEngine() {
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
        try {
            intent.setPackage(Config.getPackageName());
        } catch (IllegalArgumentException unused) {
            FastViewLogUtils.m28724e(TAG, "setPackage error");
        }
        if (context.bindService(intent, this.conn, 1)) {
            return;
        }
        FastViewLogUtils.m28724e(TAG, "bind service failed");
        Message messageObtain2 = Message.obtain(this.mHandler);
        messageObtain2.what = 1003;
        this.mHandler.sendMessage(messageObtain2);
    }

    public static OpenFastAppEngine getInstance() {
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

    public void openFastApp(Context context, RpkPageInfo rpkPageInfo, boolean z10) {
        if (rpkPageInfo == null || this.mTimeOut) {
            return;
        }
        this.mTimeOut = true;
        this.mNeedDownload = z10;
        this.isNeedStartActivity = false;
        FastViewLogUtils.m28726i(TAG, "openFastApp");
        Value value = new Value(context, rpkPageInfo);
        Message messageObtain = Message.obtain(this.mHandler);
        messageObtain.what = 1001;
        messageObtain.obj = value;
        this.mHandler.removeMessages(1001);
        this.mHandler.sendMessage(messageObtain);
        Message messageObtain2 = Message.obtain(this.mHandler);
        messageObtain2.what = 1004;
        this.mHandler.sendMessageDelayed(messageObtain2, 500L);
    }

    public void openFastAppFromDownload(RpkPageInfo rpkPageInfo) {
        WeakReference<Context> weakReference = this.mContextWr;
        if (weakReference == null) {
            FastViewLogUtils.m28724e(TAG, "null == mContext");
            return;
        }
        Context context = weakReference.get();
        if (context == null) {
            FastViewLogUtils.m28724e(TAG, "null == mContext");
            return;
        }
        this.isNeedStartActivity = true;
        FastViewLogUtils.m28726i(TAG, "openFastApp first");
        Value value = new Value(context, rpkPageInfo);
        Message messageObtain = Message.obtain(this.mHandler);
        messageObtain.what = 1001;
        messageObtain.obj = value;
        this.mHandler.sendMessage(messageObtain);
    }

    public void setJumpActivityStatus(boolean z10) {
        FastViewLogUtils.m28726i(TAG, "setActivityStatus: " + z10);
        if (this.mContextWr == null) {
            return;
        }
        if (z10 && this.retryNum == 1) {
            this.retryNum = 0;
            FastViewLogUtils.m28726i(TAG, "rebindService ");
            bindService(this.mContextWr.get());
            return;
        }
        this.retryNum = 1;
        FastViewLogUtils.m28726i(TAG, "rebindService fail");
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            FastViewLogUtils.m28726i(TAG, "setJumpActivityStatus Other cases.");
        } else {
            showNormalDialog(this.mContextWr.get());
        }
    }
}
