package com.huawei.fastengine.fastview.download.install;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.fastengine.fastview.download.utils.CommonUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import p664u0.C13108a;

/* loaded from: classes5.dex */
public class PackageInstallerActivity extends Activity {
    public static final String INSTALL_CHANGE_PATH_TIMES = "install_change_path_times";
    public static final String INSTALL_EXISTING = "install_existing";
    public static final String INSTALL_PACKAGENAME = "install_packagename";
    public static final String INSTALL_PATH = "install_path";
    private static final int REQUEST_INSTALL_CODE = 100;
    private static final String TAG = "PackageInstallerActivity";
    private String filePath = "";
    private String packageName = "";

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        FastViewLogUtils.m28726i(TAG, " onActivityResult requestCode:" + i10 + ",resultCode:" + i11);
        if (100 != i10 || i11 != 0) {
            FastViewLogUtils.m28726i(TAG, " onActivityResult finish");
            finish();
        } else {
            FastViewLogUtils.m28726i(TAG, "userCancel");
            C13108a.m78878b(this).m78881d(new Intent("action_install_info_fail"));
            finishAndRemoveTask();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        FastViewLogUtils.m28726i(TAG, " onCreate.");
        Intent intent = getIntent();
        if (intent == null || CommonUtils.hasParseException(intent)) {
            CommonUtils.safeFinish(this);
            str = " error intent";
        } else {
            this.filePath = intent.getStringExtra(INSTALL_PATH);
            this.packageName = intent.getStringExtra(INSTALL_PACKAGENAME);
            if (!TextUtils.isEmpty(this.filePath)) {
                Intent nomalInstallIntent = InstallProcessSdk24.getNomalInstallIntent(this, this.filePath);
                nomalInstallIntent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                nomalInstallIntent.putExtra("android.intent.extra.RETURN_RESULT", true);
                FastViewLogUtils.m28726i(TAG, " onCreate packageName:" + this.packageName + ",taskId:" + getTaskId());
                try {
                    startActivityForResult(nomalInstallIntent, 100);
                    return;
                } catch (ActivityNotFoundException unused) {
                    str2 = "can not start install action";
                    FastViewLogUtils.m28724e(TAG, str2);
                    CommonUtils.safeFinish(this);
                    return;
                } catch (SecurityException unused2) {
                    str2 = " startActivity failed, have no read uri permission";
                    FastViewLogUtils.m28724e(TAG, str2);
                    CommonUtils.safeFinish(this);
                    return;
                }
            }
            CommonUtils.safeFinish(this);
            str = " can not find filePath.";
        }
        FastViewLogUtils.m28724e(TAG, str);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FastViewLogUtils.m28726i(TAG, " onDestroy");
    }

    @Override // android.app.Activity
    public void onPause() {
        FastViewLogUtils.m28726i(TAG, " onPause.");
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        FastViewLogUtils.m28726i(TAG, " onResume.");
        super.onResume();
    }
}
