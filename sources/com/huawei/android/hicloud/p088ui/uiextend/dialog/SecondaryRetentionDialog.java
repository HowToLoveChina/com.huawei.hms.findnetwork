package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5;
import com.huawei.android.hicloud.p088ui.uiextend.bean.SecondaryRetentionContent;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import hu.C10342a;
import java.util.LinkedHashMap;
import je.C10811y;
import p015ak.C0209d;
import p015ak.C0216g0;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SecondaryRetentionDialog extends AlertDialogC13154a {
    private TextView descTv;
    LinkedHashMap<String, String> extendReportMap;
    private Button negativeButton;
    private Button positiveButton;
    private TextView titleTv;

    public SecondaryRetentionDialog(Activity activity, SecondaryRetentionContent secondaryRetentionContent) {
        super(activity);
        this.extendReportMap = new LinkedHashMap<>();
        initView(activity);
        initData(activity, secondaryRetentionContent);
        this.extendReportMap.put("v5_dialog_version_key", InterfaceC5323b.f24693t);
    }

    private void initData(final Activity activity, final SecondaryRetentionContent secondaryRetentionContent) {
        this.titleTv.setText(secondaryRetentionContent.getTitle());
        this.descTv.setText(secondaryRetentionContent.getMessage());
        this.negativeButton.setText(secondaryRetentionContent.getNegativeText());
        this.positiveButton.setText(secondaryRetentionContent.getPositiveText());
        this.negativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19244a.lambda$initData$0(activity, secondaryRetentionContent, view);
            }
        });
        this.positiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19248a.lambda$initData$1(activity, secondaryRetentionContent, view);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.t0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                activity.finish();
            }
        });
    }

    private void initView(Context context) {
        View viewInflate = getLayoutInflater().inflate(R$layout.second_confirm_dialog, (ViewGroup) null);
        if (C0209d.m1195O(context) >= 1.75f) {
            viewInflate = getLayoutInflater().inflate(R$layout.second_confirm_dialog_scale, (ViewGroup) null);
        }
        setView(viewInflate);
        this.titleTv = (TextView) C12809f.m76831d(viewInflate, R$id.title);
        this.descTv = (TextView) C12809f.m76831d(viewInflate, R$id.description);
        this.negativeButton = (Button) C12809f.m76831d(viewInflate, R$id.negtive_btn);
        this.positiveButton = (Button) C12809f.m76831d(viewInflate, R$id.positive_btn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$0(Activity activity, SecondaryRetentionContent secondaryRetentionContent, View view) {
        onButtonClick(activity, secondaryRetentionContent.getNegativeGoto());
        C10811y.m65829m("1", this.extendReportMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$1(Activity activity, SecondaryRetentionContent secondaryRetentionContent, View view) {
        onButtonClick(activity, secondaryRetentionContent.getPositiveGoto());
        C10811y.m65829m("2", this.extendReportMap);
    }

    private void onButtonClick(Context context, NotEnoughDialogDataV5.DialogGoto dialogGoto) {
        if (C0209d.m1226Y0()) {
            return;
        }
        if (dialogGoto != null) {
            Intent commonGotoIntent = GeneralRedirectUtil.getCommonGotoIntent(dialogGoto.getPopupType(), dialogGoto.getPopupUri(), false);
            C0216g0.m1402e(getContext()).m1407E(commonGotoIntent, "SOURCE_ID_BACKUP_SPACE_NOT_ENOUGH_DIALOG_V5");
            if (commonGotoIntent != null) {
                C10342a.m63676b(context, commonGotoIntent);
            }
        }
        dismiss();
    }

    public void onDestroy() {
        if (isShowing()) {
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        setCanceledOnTouchOutside(false);
        super.show();
    }
}
