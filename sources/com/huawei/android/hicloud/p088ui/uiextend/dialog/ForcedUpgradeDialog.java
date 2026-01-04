package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import java.util.LinkedHashMap;
import p514o9.C11839m;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import sk.AlertDialogC12804a;

/* loaded from: classes3.dex */
public class ForcedUpgradeDialog extends AlertDialogC12804a {
    private static final String TAG = "ForcedUpgradeDialog";
    private Activity mContext;
    private BtnOnClicListener mOnClicklistner;

    public class BtnOnClicListener implements DialogInterface.OnClickListener {
        public BtnOnClicListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(ForcedUpgradeDialog.this.mContext, MainActivity.class);
                    intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                    ForcedUpgradeDialog.this.mContext.startActivity(intent);
                } catch (Exception e10) {
                    C11839m.m70687e(ForcedUpgradeDialog.TAG, "goto fail, exception: " + e10.getMessage());
                }
                ForcedUpgradeDialog.this.biReport("upgrade_popup_click_upgrade");
            } else {
                ForcedUpgradeDialog.this.biReport("upgrade_popup_click_cancel");
            }
            ForcedUpgradeDialog.this.dismiss();
            ForcedUpgradeDialog.this.mContext.finish();
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ForcedUpgradeDialog.this.dismiss();
            ForcedUpgradeDialog.this.mContext.finish();
        }
    }

    public ForcedUpgradeDialog(Activity activity) {
        super(activity);
        this.mOnClicklistner = new BtnOnClicListener();
        this.mContext = activity;
        initView();
    }

    private void initView() {
        setOnCancelListener(new DialogOnCancelListener());
    }

    public void biReport(String str) {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("forced_upgrade_type", Integer.valueOf(C10028c.m62182c0().m62278U()));
        C13225d.m79490f1().m79591l0(str, linkedHashMapM79499C);
        UBAAnalyze.m29957R("PVC", str, "1", "30", "forced_upgrade_type", String.valueOf(C10028c.m62182c0().m62278U()));
    }

    public void showDialog(String str, String str2, String str3, String str4) {
        setButton(-1, str4, this.mOnClicklistner);
        setButton(-2, str3, this.mOnClicklistner);
        setTitle(str);
        setMessage(str2);
        show();
    }
}
