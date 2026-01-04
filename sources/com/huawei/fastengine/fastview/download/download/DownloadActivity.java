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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.fastengine.C4683R;
import com.huawei.fastengine.fastview.Config;
import com.huawei.fastengine.fastview.OpenFastAppEngine;
import com.huawei.fastengine.fastview.download.download.GuideDownloadDlg;
import com.huawei.fastengine.fastview.download.download.bean.DownloadRequest;
import com.huawei.fastengine.fastview.download.install.InstallProcess;
import com.huawei.fastengine.fastview.download.install.ManagerTask;
import com.huawei.fastengine.fastview.download.utils.ActivityUtil;
import com.huawei.fastengine.fastview.download.utils.CommonUtils;
import com.huawei.fastengine.fastview.download.utils.UiHelper;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.startfastappengine.bean.RpkInfo;
import com.huawei.fastengine.fastview.startfastappengine.bean.RpkPageInfo;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import p664u0.C13108a;

@SuppressLint({"InflateParams"})
/* loaded from: classes5.dex */
public class DownloadActivity extends Activity implements View.OnClickListener {
    public static final String ACTION_INSTALL_INFO_FAIL = "action_install_info_fail";
    private static final Map<String, String> DOWNLOAD_URL_MAP = new HashMap();
    public static final String INTENT_BUNDLE_KEY_RPK_LOADER_PAGE = "rpk_load_page";
    private static final String TAG = "DownloadActivity";
    private Bundle bundleInstall;
    private AlertDialog dlCancelDialog;
    private AlertDialog dlProgressDialog;
    private DownloadAppHandler downloadAppHandler;
    private ProgressBar downloadProgressbar;
    private TextView downloadPromText;
    private TextView downloadText;
    private File mDownLoadFile;
    private InstallInfoReceiver mInstallInfoReceiver;
    private MyInstalledReceiver mInstalledReceiver;
    private DownloadManager mInstance;
    private RpkPageInfo mRpkpageinfo;
    private String mDetailUrl = "";
    private final String PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
    private GuideDownloadDlg guideDownloadDlg = new GuideDownloadDlg();
    private String callbackId = "";
    private boolean isFront = true;

    public class DialogOnKeyListener implements DialogInterface.OnKeyListener {
        private DialogOnKeyListener() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 == 4 && keyEvent.getAction() == 0) {
                if (DownloadActivity.this.dlCancelDialog != null && DownloadActivity.this.dlCancelDialog.isShowing()) {
                    FastViewLogUtils.m28726i(DownloadActivity.TAG, "click key back, cancel down dialog dismiss.");
                    DownloadActivity.this.dlCancelDialog.dismiss();
                    return true;
                }
                if (DownloadActivity.this.dlProgressDialog != null && DownloadActivity.this.dlProgressDialog.isShowing()) {
                    FastViewLogUtils.m28726i(DownloadActivity.TAG, "click key back, down dialog dismiss.");
                    DownloadActivity.this.showCancelDownloadDialog();
                    return true;
                }
                FastViewLogUtils.m28726i(DownloadActivity.TAG, "click key back, other case.");
            }
            return false;
        }
    }

    public class DownloadAppHandler extends Handler {
        private DownloadAppHandler() {
        }

        private void dealDownload(Message message) {
            String str;
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 3) {
                    DownloadActivity.this.downloadProgressbar.setProgress(100);
                    String str2 = NumberFormat.getPercentInstance().format(1.0d);
                    FastViewLogUtils.m28726i("download,", "DOWNLOADED");
                    DownloadActivity.this.downloadText.setText(str2);
                    DownloadActivity.this.bundleInstall = message.getData();
                    if (!DownloadActivity.this.isFront || DownloadActivity.this.bundleInstall == null) {
                        return;
                    }
                    InstallProcess.installProcess(DownloadActivity.this.getApplicationContext(), new ManagerTask(Config.getPackageName(), DownloadActivity.this.bundleInstall.getString("path")));
                    DownloadActivity.this.bundleInstall = null;
                    return;
                }
                if (i10 != 4) {
                    str = "Unkonw message " + message.what;
                } else {
                    if (ActivityUtil.isActivityDestroyed(DownloadActivity.this)) {
                        return;
                    }
                    DownloadActivity downloadActivity = DownloadActivity.this;
                    Toast.makeText(downloadActivity, downloadActivity.getString(C4683R.string.fastapp_dl_install_failed), 0).show();
                    try {
                        DownloadActivity.this.dlProgressDialog.dismiss();
                    } catch (IllegalArgumentException unused) {
                        FastViewLogUtils.m28724e(DownloadActivity.TAG, "dlProgressDialog dismiss IllegalArgumentException");
                    }
                    DownloadActivity.this.finish();
                    str = "download activity on download failed.";
                }
                FastViewLogUtils.m28724e(DownloadActivity.TAG, str);
                return;
            }
            int i11 = message.arg2;
            if (i11 == 0) {
                FastViewLogUtils.m28725i("msg.arg2==0  ");
                return;
            }
            int i12 = message.arg1;
            int i13 = (int) (((i12 * 1.0d) / i11) * 100.0d);
            long j10 = i12;
            if (i13 > 0) {
                DownloadActivity.this.downloadProgressbar.setProgress(i13);
                float progress = (DownloadActivity.this.downloadProgressbar.getProgress() * 1.0f) / DownloadActivity.this.downloadProgressbar.getMax();
                String str3 = NumberFormat.getPercentInstance().format(progress);
                FastViewLogUtils.m28726i("download,", "progressStr " + str3);
                FastViewLogUtils.m28726i("download,", "" + i13 + "/" + j10 + "/" + progress + "/" + ((int) (100.0f * progress)));
                DownloadActivity.this.downloadText.setText(str3);
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
            if (intent == null || CommonUtils.hasParseException(intent)) {
                return;
            }
            String action = intent.getAction();
            FastViewLogUtils.m28722d(DownloadActivity.TAG, "action " + action);
            if ("action_install_info_fail".equals(action)) {
                DownloadActivity.this.onInstallFailed();
            }
        }
    }

    public class MyInstalledReceiver extends BroadcastReceiver {
        public MyInstalledReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || CommonUtils.hasParseException(intent) || !"android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                return;
            }
            String dataString = intent.getDataString();
            FastViewLogUtils.m28726i(DownloadActivity.TAG, "instal :" + dataString);
            if (Config.getInstallPackageName().equals(dataString)) {
                DownloadActivity.this.onInstallSuccessed();
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

    public static void setDownloadUrl(String str, String str2) {
        DOWNLOAD_URL_MAP.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCancelDownloadDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(C4683R.string.fastapp_dl_cancel_download_prompt_ex);
        builder.setPositiveButton(C4683R.string.fastapp_dl_sure_cancel_download, new DialogInterface.OnClickListener() { // from class: com.huawei.fastengine.fastview.download.download.DownloadActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                DownloadActivity.this.downloadProgressbar.setProgress(0);
                DownloadActivity.this.downloadProgressbar.setMax(0);
                DownloadActivity.this.downloadText.setText("");
                DownloadActivity.this.dlCancelDialog.dismiss();
                DownloadActivity.this.dlProgressDialog.dismiss();
                DownloadActivity.this.mInstance.stopDownload();
                if (!TextUtils.isEmpty(DownloadActivity.this.callbackId)) {
                    DownloadCallbackManager.getInstance().consume(DownloadActivity.this.callbackId, 1);
                }
                DownloadActivity.this.finish();
            }
        });
        builder.setNegativeButton(C4683R.string.fastapp_exit_cancel, new DialogInterface.OnClickListener() { // from class: com.huawei.fastengine.fastview.download.download.DownloadActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                DownloadActivity.this.dlCancelDialog.dismiss();
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
        FastViewLogUtils.m28726i(TAG, "showDlProgressDialog");
        this.dlProgressDialog = new AlertDialog.Builder(this).create();
        View viewInflate = LayoutInflater.from(this).inflate(C4683R.layout.fastapp_progress_dialog, (ViewGroup) null);
        this.downloadProgressbar = (ProgressBar) viewInflate.findViewById(C4683R.id.fastapp_third_app_dl_progressbar);
        this.downloadText = (TextView) viewInflate.findViewById(C4683R.id.fastapp_third_app_dl_progress_text);
        this.downloadPromText = (TextView) viewInflate.findViewById(C4683R.id.fastapp_third_app_warn_text);
        viewInflate.findViewById(C4683R.id.fastap_cancel_imageview).setOnClickListener(this);
        int iDp2px = UiHelper.dp2px(this, 24);
        this.dlProgressDialog.setView(viewInflate, iDp2px, iDp2px, iDp2px, iDp2px);
        this.dlProgressDialog.setOnKeyListener(new DialogOnKeyListener());
        this.dlProgressDialog.setCanceledOnTouchOutside(false);
        FastViewLogUtils.m28726i(TAG, "dlProgressDialog show");
        this.dlProgressDialog.show();
        this.downloadText.setText(NumberFormat.getPercentInstance().format(0.0d));
        this.downloadText.setTextColor(CommonUtils.getIsDarkTheme(this) ? -1 : -16777216);
        this.downloadPromText.setTextColor(CommonUtils.getIsDarkTheme(this) ? -1 : -16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownload(String str, String str2) {
        FastViewLogUtils.m28722d(TAG, RpkInfo.DOWNLOAD_URL + str + " / " + str2);
        DownloadRequest downloadRequest = new DownloadRequest();
        DownloadManager downloadManager = DownloadManager.getInstance();
        this.mInstance = downloadManager;
        downloadManager.resetDownload();
        downloadRequest.setUrl(str);
        downloadRequest.setNeedCheck(false);
        if (!TextUtils.isEmpty(str2)) {
            downloadRequest.setHash(str2);
        }
        this.mInstance.downloadAsyncOKHttp(downloadRequest, getApplicationContext(), new DownloadListener() { // from class: com.huawei.fastengine.fastview.download.download.DownloadActivity.2
            @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
            public void failure(int i10) {
                FastViewLogUtils.m28724e("DownloadManager failure,", i10 + "");
                if (4 == i10) {
                    if (TextUtils.isEmpty(DownloadActivity.this.callbackId)) {
                        return;
                    }
                    DownloadCallbackManager.getInstance().consume(DownloadActivity.this.callbackId, 1);
                } else {
                    if (!TextUtils.isEmpty(DownloadActivity.this.callbackId)) {
                        DownloadCallbackManager.getInstance().consume(DownloadActivity.this.callbackId, 2);
                    }
                    Message message = new Message();
                    message.what = 4;
                    DownloadActivity.this.downloadAppHandler.sendMessage(message);
                }
            }

            @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
            public void progress(int i10, int i11) {
                FastViewLogUtils.m28726i("DownloadManager progress,", i10 + "/" + i11);
                Message message = new Message();
                message.what = 1;
                message.arg1 = i10;
                message.arg2 = i11;
                DownloadActivity.this.downloadAppHandler.sendMessage(message);
            }

            @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
            public void success(File file) throws IOException {
                String canonicalPath;
                DownloadActivity.this.mDownLoadFile = file;
                Message message = new Message();
                message.what = 3;
                Bundle bundle = new Bundle();
                try {
                    canonicalPath = file.getCanonicalPath();
                } catch (IOException unused) {
                    FastViewLogUtils.m28724e(DownloadActivity.TAG, "getCanonicalPath exception");
                    canonicalPath = null;
                }
                if (canonicalPath == null) {
                    canonicalPath = "";
                }
                bundle.putString("path", canonicalPath);
                message.setData(bundle);
                DownloadActivity.this.downloadAppHandler.sendMessage(message);
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
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || CommonUtils.hasParseException(intent)) {
            return;
        }
        try {
            Serializable serializableExtra = intent.getSerializableExtra(INTENT_BUNDLE_KEY_RPK_LOADER_PAGE);
            if (serializableExtra != null && (serializableExtra instanceof RpkPageInfo)) {
                this.mRpkpageinfo = (RpkPageInfo) serializableExtra;
            }
        } catch (Exception unused) {
            FastViewLogUtils.m28724e(TAG, "get value from intent exception");
        }
        String stringExtra = intent.getStringExtra("callbackId");
        this.callbackId = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mDetailUrl = DOWNLOAD_URL_MAP.remove(this.callbackId);
        }
        if (TextUtils.isEmpty(this.mDetailUrl)) {
            if (!TextUtils.isEmpty(this.callbackId)) {
                DownloadCallbackManager.getInstance().consume(this.callbackId, 2);
            }
            CommonUtils.safeFinish(this);
        } else {
            this.guideDownloadDlg.showGuideDownloadDlg(this, new GuideDownloadDlg.Callback() { // from class: com.huawei.fastengine.fastview.download.download.DownloadActivity.1
                @Override // com.huawei.fastengine.fastview.download.download.GuideDownloadDlg.Callback
                public void onNegative() {
                    DownloadActivity.this.finish();
                    if (TextUtils.isEmpty(DownloadActivity.this.callbackId)) {
                        return;
                    }
                    DownloadCallbackManager.getInstance().consume(DownloadActivity.this.callbackId, 1);
                }

                @Override // com.huawei.fastengine.fastview.download.download.GuideDownloadDlg.Callback
                public void onPositive() {
                    DownloadActivity.this.downloadAppHandler = new DownloadAppHandler();
                    DownloadActivity downloadActivity = DownloadActivity.this;
                    downloadActivity.startDownload(downloadActivity.mDetailUrl, "");
                    DownloadActivity.this.showDlProgressDialog();
                }
            });
            registerReceiver();
            this.mInstallInfoReceiver = new InstallInfoReceiver();
            C13108a.m78878b(this).m78880c(this.mInstallInfoReceiver, new IntentFilter("action_install_info_fail"));
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        FastViewLogUtils.m28726i(TAG, "onDestroy");
        unregisterReceiver();
        C13108a.m78878b(this).m78883f(this.mInstallInfoReceiver);
        this.guideDownloadDlg.dismissGuideDownloadDlg();
        this.bundleInstall = null;
        super.onDestroy();
    }

    public void onInstallFailed() {
        FastViewLogUtils.m28726i(TAG, "install failed.");
        Toast.makeText(this, getString(C4683R.string.fastapp_dl_install_failed), 0).show();
        AlertDialog alertDialog = this.dlProgressDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (this.mInstance != null) {
            DownloadManager.deleteFile(this.mDownLoadFile);
        }
        finish();
        if (TextUtils.isEmpty(this.callbackId)) {
            return;
        }
        DownloadCallbackManager.getInstance().consume(this.callbackId, 2);
    }

    public void onInstallSuccessed() {
        FastViewLogUtils.m28726i(TAG, "onInstallSuccessed :");
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
                FastViewLogUtils.m28724e(TAG, "dlProgressDialog dismiss IllegalArgumentException");
            }
        }
        AlertDialog alertDialog2 = this.dlCancelDialog;
        if (alertDialog2 != null) {
            try {
                alertDialog2.dismiss();
            } catch (IllegalArgumentException unused2) {
                FastViewLogUtils.m28724e(TAG, "dlCancelDialog dismiss IllegalArgumentException");
            }
        }
        if (this.mRpkpageinfo != null) {
            FastViewLogUtils.m28726i(TAG, "openFastAppFromDownload");
            OpenFastAppEngine.getInstance().openFastAppFromDownload(this.mRpkpageinfo);
        }
        finish();
        if (TextUtils.isEmpty(this.callbackId)) {
            return;
        }
        DownloadCallbackManager.getInstance().consume(this.callbackId, 0);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        FastViewLogUtils.m28726i(TAG, "onPause");
        this.isFront = false;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        FastViewLogUtils.m28726i(TAG, "onResume");
        this.isFront = true;
        if (this.bundleInstall != null) {
            FastViewLogUtils.m28726i(TAG, "onResume installProcess");
            InstallProcess.installProcess(getApplicationContext(), new ManagerTask(Config.getPackageName(), this.bundleInstall.getString("path")));
            this.bundleInstall = null;
        }
    }
}
