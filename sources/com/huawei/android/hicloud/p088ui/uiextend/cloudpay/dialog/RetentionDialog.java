package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.HisyncSpaceDetailActivity;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.TerminationRetentionData;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p054cj.C1442a;
import p211d.C8968a;
import p454lj.C11290m;
import p514o9.C11839m;
import p514o9.C11841o;
import p676ud.AlertDialogC13154a;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RetentionDialog extends AlertDialogC13154a implements View.OnClickListener {
    private static final String TAG = "RetentionDialog";
    private RelativeLayout cancelButton;
    private WelfarePickAndCancelRenewalInterface cancelInterface;
    private RelativeLayout confirmButton;
    private TextView confirmText;
    private boolean isWelfare;
    private Context mContext;
    private View retentionDialogView;
    private TextView retentionTitle;
    private TerminationRetentionData terminationRetentionData;

    public RetentionDialog(Context context, boolean z10, WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface, TerminationRetentionData terminationRetentionData) {
        super(context);
        this.mContext = context;
        this.isWelfare = z10;
        this.cancelInterface = welfarePickAndCancelRenewalInterface;
        this.terminationRetentionData = terminationRetentionData;
        initView(context);
    }

    private String getPackageEndTime(UserPackage userPackage) {
        C11839m.m70686d(TAG, "getPackageEndTime");
        List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
        if (effectivePackages == null || effectivePackages.isEmpty()) {
            C11839m.m70688i(TAG, "getPackageEndTime, effectivePackages is null!");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<CloudSpace> it = effectivePackages.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getEndTime()));
        }
        long jLongValue = ((Long) arrayList.stream().max(Comparator.comparing(new Function() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.dialog.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return RetentionDialog.lambda$getPackageEndTime$0((Long) obj);
            }
        })).orElse(0L)).longValue();
        return (C0209d.m1278l2(Constants.URDU_LANG) || C0209d.m1278l2("my-rZG") || C0209d.m1278l2("my")) ? C11290m.m67742c(this.mContext, jLongValue, "dd/MM/yyyy") : C11290m.m67743d(this.mContext, jLongValue);
    }

    @SuppressLint({"InflateParams"})
    private void initView(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "initView, context is null, initView Failed");
            return;
        }
        TerminationRetentionData terminationRetentionData = this.terminationRetentionData;
        if (terminationRetentionData == null) {
            C11839m.m70689w(TAG, "initView, terminationRetentionData is null, initView Failed");
            return;
        }
        UserPackage userPackage = terminationRetentionData.getUserPackage();
        GetClientUIConfigResp getClientUIConfigResp = this.terminationRetentionData.getGetClientUIConfigResp();
        if (userPackage == null || getClientUIConfigResp == null) {
            C11839m.m70689w(TAG, "initView, userPackage or configResp is null, initView Failed");
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.retention_dialog_layout, (ViewGroup) null);
        this.retentionDialogView = viewInflate;
        this.retentionTitle = (TextView) C12809f.m76831d(viewInflate, R$id.retention_dialog_title);
        long used = userPackage.getUsed();
        String packageEndTime = getPackageEndTime(userPackage);
        if (TextUtils.isEmpty(packageEndTime)) {
            C11839m.m70689w(TAG, "initView, maxPackageEndTime is null!");
            return;
        }
        this.retentionTitle.setText(used > 5368709120L ? C0209d.m1303s(getClientUIConfigResp.getUnSubreservedExceed5GB(), C0223k.m1529l(this.mContext.getString(R$string.hidisk_file_size_gb, String.valueOf(5))), packageEndTime) : C0209d.m1303s(getClientUIConfigResp.getUnSubreservedNotExceed5GB(), C0223k.m1529l(this.mContext.getString(R$string.hidisk_file_size_gb, String.valueOf(5))), packageEndTime));
        this.cancelButton = (RelativeLayout) C12809f.m76831d(this.retentionDialogView, R$id.cancel_btn);
        this.confirmButton = (RelativeLayout) C12809f.m76831d(this.retentionDialogView, R$id.confirm_btn);
        this.confirmText = (TextView) C12809f.m76831d(this.retentionDialogView, R$id.tv_confirm);
        if (C0209d.m1220W0()) {
            this.confirmText.setTextColor(context.getColor(R$color.welfare_cancel_text_color));
        } else {
            this.confirmButton.setBackground(C8968a.m56743b(context, R$drawable.welfare_dialog_button_bg));
            this.confirmText.setTextColor(context.getColor(R$color.white));
        }
        this.cancelButton.setOnClickListener(this);
        this.confirmButton.setOnClickListener(this);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.dialog.RetentionDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                if (i10 != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                if (RetentionDialog.this.terminationRetentionData == null) {
                    C1442a.m8289e(RetentionDialog.TAG, "initView, terminationRetentionData is null.");
                    RetentionDialog.this.dismiss();
                    return false;
                }
                if (RetentionDialog.this.cancelInterface == null) {
                    C1442a.m8289e(RetentionDialog.TAG, "initView, cancelInterface is null.");
                    RetentionDialog.this.dismiss();
                    return false;
                }
                RetentionDialog.this.cancelInterface.backPressEvent("DOUBLE_RETENTION_DIALOG_PRESS_BACK");
                if (!RetentionDialog.this.terminationRetentionData.isFromIAP()) {
                    RetentionDialog.this.dismiss();
                }
                return true;
            }
        });
        setView(this.retentionDialogView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$getPackageEndTime$0(Long l10) {
        return l10;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface;
        int id2 = view.getId();
        if (id2 == R$id.cancel_btn) {
            if (this.cancelInterface == null) {
                C11839m.m70688i(TAG, "onClick, cancelInterface is null");
                dismiss();
                return;
            }
            if (!C0209d.m1333z1(C0213f.m1377a())) {
                C11839m.m70688i(TAG, "onClick, cancel network error!");
                C11841o.m70708d(C0213f.m1377a(), C0213f.m1377a().getString(R$string.gallery_no_network_tips), 0);
                dismiss();
                return;
            }
            C11839m.m70688i(TAG, "onClick, isWelfare is: " + this.isWelfare);
            if (this.isWelfare) {
                this.cancelInterface.cancelRenewal();
            } else {
                this.cancelInterface.checkConfirmCancelPassword();
            }
            this.cancelInterface.reportEventByID("click_cancel_double_retention_btn", C13230i.m79497A(C13452e.m80781L().m80971t0()));
            dismiss();
            return;
        }
        if (id2 == R$id.confirm_btn) {
            if (!C0209d.m1333z1(C0213f.m1377a())) {
                C11839m.m70688i(TAG, "onClick, confirm network error!");
                C11841o.m70708d(C0213f.m1377a(), C0213f.m1377a().getString(R$string.gallery_no_network_tips), 0);
                return;
            }
            Intent intent = new Intent(this.mContext, (Class<?>) HisyncSpaceDetailActivity.class);
            C13230i.m79525e1(intent, "4", "79");
            intent.putExtra("is_activity_need_back_to_main", true);
            this.mContext.startActivity(intent);
            dismiss();
            TerminationRetentionData terminationRetentionData = this.terminationRetentionData;
            if (terminationRetentionData == null) {
                C1442a.m8289e(TAG, "onClick, terminationRetentionData is null.");
                return;
            }
            if (terminationRetentionData.isFromIAP() && (welfarePickAndCancelRenewalInterface = this.cancelInterface) != null) {
                welfarePickAndCancelRenewalInterface.retentionSuccessIAP();
            }
            this.cancelInterface.reportEventByID("click_manager_double_retention_btn", C13230i.m79497A(C13452e.m80781L().m80971t0()));
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.cancelInterface == null) {
            C1442a.m8289e(TAG, "show, cancelInterface is null.");
        } else {
            this.cancelInterface.reportEventByID("DOUBLE_RETENTION_BTN_SHOW", C13230i.m79497A(C13452e.m80781L().m80971t0()));
        }
    }
}
