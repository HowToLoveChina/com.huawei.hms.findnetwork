package com.huawei.fastengine.fastview.download.download;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.fastengine.C4683R;
import com.huawei.fastengine.fastview.Config;
import com.huawei.fastengine.fastview.StartFastAPPEngine;
import com.huawei.fastengine.fastview.download.download.GuideDownloadDlg;
import com.huawei.fastengine.fastview.download.download.bean.DownloadRequest;
import com.huawei.fastengine.fastview.download.install.InstallProcess;
import com.huawei.fastengine.fastview.download.install.ManagerTask;
import com.huawei.fastengine.fastview.download.utils.ActivityUtil;
import com.huawei.fastengine.fastview.download.utils.CommonUtils;
import com.huawei.fastengine.fastview.download.utils.PackageUtils;
import com.huawei.fastengine.fastview.download.utils.SettingUtil;
import com.huawei.fastengine.fastview.download.utils.UiHelper;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.startfastappengine.appmarket.DetailBean;
import com.huawei.fastengine.fastview.startfastappengine.appmarket.IQueryDetailHandler;
import com.huawei.fastengine.fastview.startfastappengine.appmarket.IQueryDetailResult;
import com.huawei.fastengine.fastview.startfastappengine.appmarket.QueryDetailHanlderRegister;
import com.huawei.fastengine.fastview.startfastappengine.bean.RpkInfo;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import p664u0.C13108a;

@SuppressLint({"InflateParams"})
/* loaded from: classes5.dex */
public class HiappDownloadActivity extends Activity implements View.OnClickListener {
    public static final String ACTION_INSTALL_INFO_FAIL = "action_install_info_fail";
    private static final String TAG = "HiappDownloadActivity";
    private AlertDialog dlCancelDialog;
    private AlertDialog dlProgressDialog;
    private DownloadAppHandler downloadAppHandler;
    private ProgressBar downloadProgressbar;
    private TextView downloadText;
    private Bundle mBundle;
    private File mDownLoadFile;
    private InstallInfoReceiver mInstallInfoReceiver;
    private MyInstalledReceiver mInstalledReceiver;
    private DownloadManager mInstance;
    private RpkInfo mRpkinfo;
    private String mDetailUrl = "";
    private final String PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
    private GuideDownloadDlg guideDownloadDlg = new GuideDownloadDlg();

    public class DialogOnKeyListener implements DialogInterface.OnKeyListener {
        private DialogOnKeyListener() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 == 4 && keyEvent.getAction() == 0) {
                if (HiappDownloadActivity.this.dlCancelDialog != null && HiappDownloadActivity.this.dlCancelDialog.isShowing()) {
                    FastViewLogUtils.m28726i(HiappDownloadActivity.TAG, "click key back, cancel down dialog dismiss.");
                    HiappDownloadActivity.this.dlCancelDialog.dismiss();
                    return true;
                }
                if (HiappDownloadActivity.this.dlProgressDialog != null && HiappDownloadActivity.this.dlProgressDialog.isShowing()) {
                    FastViewLogUtils.m28726i(HiappDownloadActivity.TAG, "click key back, down dialog dismiss.");
                    HiappDownloadActivity.this.showCancelDownloadDialog();
                    return true;
                }
                FastViewLogUtils.m28726i(HiappDownloadActivity.TAG, "click key back, other case.");
            }
            return false;
        }
    }

    public class DownloadAppHandler extends Handler {
        private DownloadAppHandler() {
        }

        private void dealDownload(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 3) {
                    HiappDownloadActivity.this.downloadProgressbar.setProgress(100);
                    HiappDownloadActivity.this.downloadText.setText(NumberFormat.getPercentInstance().format(1.0d));
                    Log.i(HiappDownloadActivity.TAG, "has downloaded");
                    InstallProcess.installProcess(HiappDownloadActivity.this.getApplicationContext(), new ManagerTask(Config.getPackageName(), message.getData().getString("path")));
                    return;
                }
                if (i10 != 4) {
                    FastViewLogUtils.m28724e(HiappDownloadActivity.TAG, "Unkonw message " + message.what);
                    return;
                }
                if (ActivityUtil.isActivityDestroyed(HiappDownloadActivity.this)) {
                    return;
                }
                HiappDownloadActivity hiappDownloadActivity = HiappDownloadActivity.this;
                Toast.makeText(hiappDownloadActivity, hiappDownloadActivity.getString(C4683R.string.fastapp_dl_install_failed), 0).show();
                try {
                    HiappDownloadActivity.this.dlProgressDialog.dismiss();
                } catch (IllegalArgumentException unused) {
                    Log.e(HiappDownloadActivity.TAG, "dlProgressDialog dismiss IllegalArgumentException");
                }
                HiappDownloadActivity.this.finish();
                Log.e(HiappDownloadActivity.TAG, "download activity on download failed.");
                return;
            }
            int i11 = message.arg2;
            if (i11 == 0) {
                FastViewLogUtils.m28723e("msg.arg2==0  ");
                return;
            }
            int i12 = message.arg1;
            int i13 = (int) (((i12 * 1.0d) / i11) * 100.0d);
            long j10 = i12;
            if (i13 > 0) {
                HiappDownloadActivity.this.downloadProgressbar.setProgress(i13);
                float progress = (HiappDownloadActivity.this.downloadProgressbar.getProgress() * 1.0f) / HiappDownloadActivity.this.downloadProgressbar.getMax();
                String str = NumberFormat.getPercentInstance().format(progress);
                FastViewLogUtils.m28724e("download,", "" + i13 + "/" + j10 + "/" + progress + "/" + ((int) (100.0f * progress)));
                HiappDownloadActivity.this.downloadText.setText(str);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            dealDownload(message);
        }
    }

    public class InstallInfoReceiver extends BroadcastReceiver {
        private InstallInfoReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.e(HiappDownloadActivity.TAG, "InstallInfoReceiver onReceive ");
            if (intent == null || CommonUtils.hasParseException(intent) || !"action_install_info_fail".equals(intent.getAction())) {
                return;
            }
            HiappDownloadActivity.this.onInstallFailed();
        }
    }

    public class MyInstalledReceiver extends BroadcastReceiver {
        public MyInstalledReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || CommonUtils.hasParseException(intent)) {
                return;
            }
            Log.i(HiappDownloadActivity.TAG, "MyInstalledReceiver onReceive");
            if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                String dataString = intent.getDataString();
                Log.i(HiappDownloadActivity.TAG, "instal :" + dataString);
                if (Config.getInstallPackageName().equals(dataString)) {
                    HiappDownloadActivity.this.onInstallSuccessed();
                }
            }
        }
    }

    private void registerReceiver() {
        this.mInstalledReceiver = new MyInstalledReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.mInstalledReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCancelDownloadDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(C4683R.string.fastapp_dl_cancel_download_prompt_ex);
        builder.setPositiveButton(C4683R.string.fastapp_dl_sure_cancel_download, new DialogInterface.OnClickListener() { // from class: com.huawei.fastengine.fastview.download.download.HiappDownloadActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                HiappDownloadActivity.this.downloadProgressbar.setProgress(0);
                HiappDownloadActivity.this.downloadProgressbar.setMax(0);
                HiappDownloadActivity.this.downloadText.setText("");
                HiappDownloadActivity.this.dlCancelDialog.dismiss();
                HiappDownloadActivity.this.dlProgressDialog.dismiss();
                HiappDownloadActivity.this.mInstance.stopDownload();
                HiappDownloadActivity.this.finish();
            }
        });
        builder.setNegativeButton(C4683R.string.fastapp_exit_cancel, new DialogInterface.OnClickListener() { // from class: com.huawei.fastengine.fastview.download.download.HiappDownloadActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                HiappDownloadActivity.this.dlCancelDialog.dismiss();
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        this.dlCancelDialog = alertDialogCreate;
        alertDialogCreate.setOnKeyListener(new DialogOnKeyListener());
        this.dlCancelDialog.setCanceledOnTouchOutside(false);
        this.dlCancelDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDlProgressDialog() {
        FastViewLogUtils.m28725i("showDlProgressDialog");
        this.dlProgressDialog = new AlertDialog.Builder(this).create();
        View viewInflate = LayoutInflater.from(this).inflate(C4683R.layout.fastapp_progress_dialog, (ViewGroup) null);
        this.downloadProgressbar = (ProgressBar) viewInflate.findViewById(C4683R.id.fastapp_third_app_dl_progressbar);
        this.downloadText = (TextView) viewInflate.findViewById(C4683R.id.fastapp_third_app_dl_progress_text);
        viewInflate.findViewById(C4683R.id.fastap_cancel_imageview).setOnClickListener(this);
        int iDp2px = UiHelper.dp2px(this, 24);
        this.dlProgressDialog.setView(viewInflate, iDp2px, iDp2px, iDp2px, iDp2px);
        this.dlProgressDialog.setOnKeyListener(new DialogOnKeyListener());
        this.dlProgressDialog.setCanceledOnTouchOutside(false);
        this.dlProgressDialog.show();
        this.downloadText.setText(NumberFormat.getPercentInstance().format(0.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownload(String str, String str2) {
        FastViewLogUtils.m28722d(TAG, RpkInfo.DOWNLOAD_URL + str + " / " + str2);
        DownloadRequest downloadRequest = new DownloadRequest();
        this.mInstance = DownloadManager.getInstance();
        downloadRequest.setUrl(str);
        downloadRequest.setNeedCheck(true);
        if (!TextUtils.isEmpty(str2)) {
            downloadRequest.setHash(str2);
        }
        this.mInstance.downloadAsync(downloadRequest, getApplicationContext(), new DownloadListener() { // from class: com.huawei.fastengine.fastview.download.download.HiappDownloadActivity.2
            @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
            public void failure(int i10) {
                Log.e(HiappDownloadActivity.TAG, "DownloadManager failure code " + i10);
                if (4 == i10) {
                    return;
                }
                Message message = new Message();
                message.what = 4;
                HiappDownloadActivity.this.downloadAppHandler.sendMessage(message);
            }

            @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
            public void progress(int i10, int i11) {
                FastViewLogUtils.m28724e("DownloadManager progress,", i10 + "/" + i11);
                Message message = new Message();
                message.what = 1;
                message.arg1 = i10;
                message.arg2 = i11;
                HiappDownloadActivity.this.downloadAppHandler.sendMessage(message);
            }

            @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
            public void success(File file) throws IOException {
                String canonicalPath;
                Log.i(HiappDownloadActivity.TAG, "DownloadManager success");
                HiappDownloadActivity.this.mDownLoadFile = file;
                Message message = new Message();
                message.what = 3;
                Bundle bundle = new Bundle();
                try {
                    canonicalPath = file.getCanonicalPath();
                } catch (IOException unused) {
                    FastViewLogUtils.m28724e(HiappDownloadActivity.TAG, "getCanonicalPath exception");
                    canonicalPath = null;
                }
                if (canonicalPath == null) {
                    canonicalPath = "";
                }
                bundle.putString("path", canonicalPath);
                message.setData(bundle);
                HiappDownloadActivity.this.downloadAppHandler.sendMessage(message);
            }
        });
    }

    private void unregisterReceiver() {
        MyInstalledReceiver myInstalledReceiver = this.mInstalledReceiver;
        if (myInstalledReceiver != null) {
            unregisterReceiver(myInstalledReceiver);
            this.mInstalledReceiver = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        if (view.getId() == C4683R.id.fastap_cancel_imageview && (alertDialog = this.dlProgressDialog) != null && alertDialog.isShowing()) {
            FastViewLogUtils.m28726i(TAG, "click key back, down dialog dismiss.");
            showCancelDownloadDialog();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, InstantiationException {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || CommonUtils.hasParseException(intent)) {
            return;
        }
        RpkInfo rpkInfo = new RpkInfo();
        this.mRpkinfo = rpkInfo;
        rpkInfo.parse(intent);
        this.mBundle = intent.getBundleExtra("Management");
        IQueryDetailHandler handler = QueryDetailHanlderRegister.getHandler();
        if (handler == null) {
            Log.e(TAG, "detailHandler is null");
            CommonUtils.safeFinish(this);
        } else {
            handler.queryDetail(Config.getPackageName(), new IQueryDetailResult() { // from class: com.huawei.fastengine.fastview.download.download.HiappDownloadActivity.1
                @Override // com.huawei.fastengine.fastview.startfastappengine.appmarket.IQueryDetailResult
                public void onResult(final DetailBean detailBean) {
                    FastViewLogUtils.m28722d(HiappDownloadActivity.TAG, "bean=" + detailBean);
                    if (ActivityUtil.isActivityDestroyed(HiappDownloadActivity.this)) {
                        Log.e(HiappDownloadActivity.TAG, "queryDetail onResult activity is finished or destroyed");
                        return;
                    }
                    if (detailBean == null || TextUtils.isEmpty(detailBean.getDownloadUrl())) {
                        Log.e(HiappDownloadActivity.TAG, "bean is null or downloadUrl is null");
                        int i10 = SettingUtil.isNetworkAvailable(HiappDownloadActivity.this) ? C4683R.string.fastapp_dl_install_failed : C4683R.string.fastapp_no_network;
                        HiappDownloadActivity hiappDownloadActivity = HiappDownloadActivity.this;
                        Toast.makeText(hiappDownloadActivity, hiappDownloadActivity.getString(i10), 0).show();
                        CommonUtils.safeFinish(HiappDownloadActivity.this);
                        return;
                    }
                    FastViewLogUtils.m28722d(HiappDownloadActivity.TAG, "bean=" + detailBean);
                    Log.i(HiappDownloadActivity.TAG, "queryDetail OK");
                    HiappDownloadActivity.this.guideDownloadDlg.showGuideDownloadDlg(HiappDownloadActivity.this, new GuideDownloadDlg.Callback() { // from class: com.huawei.fastengine.fastview.download.download.HiappDownloadActivity.1.1
                        @Override // com.huawei.fastengine.fastview.download.download.GuideDownloadDlg.Callback
                        public void onNegative() {
                            CommonUtils.safeFinish(HiappDownloadActivity.this);
                        }

                        @Override // com.huawei.fastengine.fastview.download.download.GuideDownloadDlg.Callback
                        public void onPositive() {
                            HiappDownloadActivity.this.mDetailUrl = detailBean.getDownloadUrl();
                            HiappDownloadActivity.this.downloadAppHandler = new DownloadAppHandler();
                            HiappDownloadActivity hiappDownloadActivity2 = HiappDownloadActivity.this;
                            hiappDownloadActivity2.startDownload(hiappDownloadActivity2.mDetailUrl, detailBean.getSha256());
                            HiappDownloadActivity.this.showDlProgressDialog();
                        }
                    });
                }
            });
            registerReceiver();
            this.mInstallInfoReceiver = new InstallInfoReceiver();
            C13108a.m78878b(this).m78880c(this.mInstallInfoReceiver, new IntentFilter("action_install_info_fail"));
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        FastViewLogUtils.m28724e(TAG, "onDestroy");
        unregisterReceiver();
        C13108a.m78878b(this).m78883f(this.mInstallInfoReceiver);
        DownloadManager downloadManager = this.mInstance;
        if (downloadManager != null) {
            downloadManager.resetDownload();
        }
        this.guideDownloadDlg.dismissGuideDownloadDlg();
        super.onDestroy();
    }

    public void onInstallFailed() {
        Log.e(TAG, "install failed.");
        Toast.makeText(this, getString(C4683R.string.fastapp_dl_install_failed), 0).show();
        AlertDialog alertDialog = this.dlProgressDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (this.mInstance != null) {
            DownloadManager.deleteFile(this.mDownLoadFile);
        }
        finish();
    }

    public void onInstallSuccessed() {
        Log.i(TAG, "onInstallSuccessed :");
        if (ActivityUtil.isActivityDestroyed(this)) {
            return;
        }
        if (this.mInstance != null) {
            DownloadManager.deleteFile(this.mDownLoadFile);
        }
        AlertDialog alertDialog = this.dlProgressDialog;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (IllegalArgumentException unused) {
                FastViewLogUtils.m28722d(TAG, "dlProgressDialog dismiss IllegalArgumentException");
            }
        }
        AlertDialog alertDialog2 = this.dlCancelDialog;
        if (alertDialog2 != null) {
            try {
                alertDialog2.dismiss();
            } catch (IllegalArgumentException unused2) {
                FastViewLogUtils.m28722d(TAG, "dlCancelDialog dismiss IllegalArgumentException");
            }
        }
        if (this.mBundle != null) {
            Log.i(TAG, "openFastappManagementFromDownload");
            StartFastAPPEngine.getInstance().openFastappManagementFromDownload(this.mBundle);
        } else {
            Log.i(TAG, "openFastAppFromDownload");
            StartFastAPPEngine.getInstance().openFastAppFromDownload(this.mRpkinfo);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (PackageUtils.HWGAMEBOX_PACKAGE_NAME.equals(getApplicationInfo().packageName)) {
            if (!PackageUtils.isEngineInstalledforGameBox(this)) {
                return;
            }
        } else if (!PackageUtils.isEngineInstalled(this)) {
            return;
        }
        onInstallSuccessed();
    }
}
