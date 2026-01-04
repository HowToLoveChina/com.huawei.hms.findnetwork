package com.huawei.fastengine.fastview.download.download;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.huawei.fastengine.C4683R;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;

/* loaded from: classes5.dex */
public class GuideDownloadDlg {
    private static final String TAG = "GuideDownloadDlg";
    private AlertDialog dlg = null;

    public interface Callback {
        void onNegative();

        void onPositive();
    }

    public void dismissGuideDownloadDlg() {
        AlertDialog alertDialog = this.dlg;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.dlg.dismiss();
        this.dlg = null;
    }

    public void showGuideDownloadDlg(Context context, final Callback callback) {
        AlertDialog alertDialog = this.dlg;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.dlg.dismiss();
            this.dlg = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(C4683R.string.fastapp_guide_download_apk_v2);
        builder.setPositiveButton(C4683R.string.fastapp_guide_download_next_step, new DialogInterface.OnClickListener() { // from class: com.huawei.fastengine.fastview.download.download.GuideDownloadDlg.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onPositive();
                }
            }
        });
        builder.setNegativeButton(C4683R.string.fastapp_exit_cancel, new DialogInterface.OnClickListener() { // from class: com.huawei.fastengine.fastview.download.download.GuideDownloadDlg.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                if (GuideDownloadDlg.this.dlg != null) {
                    GuideDownloadDlg.this.dlg.dismiss();
                    GuideDownloadDlg.this.dlg = null;
                }
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onNegative();
                }
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        this.dlg = alertDialogCreate;
        alertDialogCreate.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.huawei.fastengine.fastview.download.download.GuideDownloadDlg.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                if (GuideDownloadDlg.this.dlg == null || !GuideDownloadDlg.this.dlg.isShowing()) {
                    FastViewLogUtils.m28726i(GuideDownloadDlg.TAG, "click key back, other case.");
                    return false;
                }
                FastViewLogUtils.m28726i(GuideDownloadDlg.TAG, "click key back, cancel guide down dialog dismiss.");
                GuideDownloadDlg.this.dlg.dismiss();
                GuideDownloadDlg.this.dlg = null;
                Callback callback2 = callback;
                if (callback2 == null) {
                    return true;
                }
                callback2.onNegative();
                return true;
            }
        });
        this.dlg.show();
    }
}
