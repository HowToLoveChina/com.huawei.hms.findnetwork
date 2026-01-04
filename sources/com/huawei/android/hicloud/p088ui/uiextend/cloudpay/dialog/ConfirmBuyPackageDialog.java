package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.LearnMorePayClickListener;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.ConvertInfo;
import com.huawei.cloud.pay.model.CurPkgInfo;
import com.huawei.cloud.pay.model.EstimateResp;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.PackageGrades;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import ne.C11667a;
import p015ak.C0219i;
import p015ak.C0223k;
import p054cj.C1442a;
import p364ib.C10465b;
import p454lj.C11296s;
import p676ud.AlertDialogC13154a;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ConfirmBuyPackageDialog extends AlertDialogC13154a {
    private static final String TAG = "ConfirmBuyPackageDialog";
    private SpanClickText agreement;
    private SpanClickText detail;
    private boolean isAopPay;
    private ChannelInfo mChannelInfo;
    private Context mContext;
    private BtnOnClickListner mOnClicklistner;
    private View userAgreementView;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                if (ConfirmBuyPackageDialog.this.mContext instanceof BuyPackageBaseActivity) {
                    if (!C11296s.m67798V()) {
                        ((BuyPackageBaseActivity) ConfirmBuyPackageDialog.this.mContext).m22894y2(ConfirmBuyPackageDialog.this.mChannelInfo);
                    } else if (ConfirmBuyPackageDialog.this.isAopPay) {
                        ((BuyPackageBaseActivity) ConfirmBuyPackageDialog.this.mContext).m22752C5();
                    } else {
                        ((BuyPackageBaseActivity) ConfirmBuyPackageDialog.this.mContext).m22744A5();
                    }
                    ((BuyPackageBaseActivity) ConfirmBuyPackageDialog.this.mContext).m22861p4();
                } else if (ConfirmBuyPackageDialog.this.mContext instanceof OperationWebViewActivity) {
                    ((OperationWebViewActivity) ConfirmBuyPackageDialog.this.mContext).m21822M2();
                }
            } else if (-2 == i10) {
                if (ConfirmBuyPackageDialog.this.mContext instanceof BuyPackageBaseActivity) {
                    ((BuyPackageBaseActivity) ConfirmBuyPackageDialog.this.mContext).m22857o4();
                    if (ConfirmBuyPackageDialog.this.isAopPay) {
                        ((BuyPackageBaseActivity) ConfirmBuyPackageDialog.this.mContext).m22863q2();
                    } else {
                        ((BuyPackageBaseActivity) ConfirmBuyPackageDialog.this.mContext).mo22901z5();
                    }
                } else if (ConfirmBuyPackageDialog.this.mContext instanceof OperationWebViewActivity) {
                    ((OperationWebViewActivity) ConfirmBuyPackageDialog.this.mContext).m21823N2();
                }
            }
            ConfirmBuyPackageDialog.this.dismiss();
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ConfirmBuyPackageDialog.this.dismiss();
        }
    }

    public ConfirmBuyPackageDialog(Context context) {
        super(context);
        this.mOnClicklistner = new BtnOnClickListner();
        this.mContext = context;
        initView();
    }

    private String getAgreementSuffix() {
        if (C11296s.m67797U()) {
            C1442a.m8290i(TAG, "getAgreementSuffix deduct suffix");
            return C13452e.m80781L().m80887a1() ? "/changespace4?lang=" : "/changespace2?lang=";
        }
        C1442a.m8290i(TAG, "getAgreementSuffix no deduct suffix");
        return C13452e.m80781L().m80887a1() ? "/changespace3?lang=" : "/changespace?lang=";
    }

    private String getPayChangeSpaceAgreement() {
        return C13452e.m80781L().m80887a1() ? "/changespace3?lang=" : "/changespace?lang=";
    }

    private void initView() {
        setOnCancelListener(new DialogOnCancelListener());
        View viewInflate = LayoutInflater.from(this.mContext).inflate(C0219i.m1463a() >= 17 ? R$layout.pay_upgradepackage_dialog_emui9 : R$layout.pay_upgradepackage_dialog, (ViewGroup) null);
        this.userAgreementView = viewInflate;
        this.detail = (SpanClickText) C12809f.m76831d(viewInflate, R$id.package_detail);
        this.agreement = (SpanClickText) C12809f.m76831d(this.userAgreementView, R$id.dialog_message);
    }

    private void setSpannableString(LearnMorePayClickListener learnMorePayClickListener, String str, String str2) {
        this.detail.m15931c(str, learnMorePayClickListener);
        this.detail.m15934g(str2, false);
    }

    private void showEstimateDialog(String str, String str2, ChannelInfo channelInfo) {
        this.mChannelInfo = channelInfo;
        setButton(-2, this.mContext.getString(R$string.package_info_dialog_cancel), this.mOnClicklistner);
        this.detail.setVisibility(0);
        this.agreement.setVisibility(8);
        setButton(-1, this.mContext.getString(R$string.cloudpay_estimate_dialog_positive).toUpperCase(Locale.getDefault()), this.mOnClicklistner);
        setTitle(this.mContext.getString(R$string.cloudpay_estimate_dialog_title));
        setSpannableString(new LearnMorePayClickListener(this.mContext, getAgreementSuffix()), str, str2);
        setView(this.userAgreementView, 0, 0, 0, 0);
        Context context = this.mContext;
        if (context instanceof BuyPackageBaseActivity) {
            ((BuyPackageBaseActivity) context).m22879u4();
        }
        show();
    }

    public String getDefaultContent(GetClientUIConfigResp getClientUIConfigResp, String str, String str2) {
        String upgradeDialogNewDefaultText = getClientUIConfigResp.getUpgradeDialogNewDefaultText();
        if (TextUtils.isEmpty(upgradeDialogNewDefaultText)) {
            upgradeDialogNewDefaultText = this.mContext.getString(R$string.dialog_nodeduction_upgrade_confirmed_has_worry_free);
        }
        return C10465b.m64293c(upgradeDialogNewDefaultText, str, str2);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (!this.isAopPay) {
            Context context = this.mContext;
            if (context instanceof OperationWebViewActivity) {
                ((OperationWebViewActivity) context).m21823N2();
                return;
            }
            return;
        }
        C1442a.m8290i(TAG, "onBackPressed is Aop");
        Context context2 = this.mContext;
        if (context2 instanceof BuyPackageBaseActivity) {
            ((BuyPackageBaseActivity) context2).m22857o4();
            ((BuyPackageBaseActivity) this.mContext).m22863q2();
        }
    }

    public void showBasic(String str, String str2, ChannelInfo channelInfo) {
        setButton(-2, this.mContext.getString(R$string.package_info_dialog_cancel), this.mOnClicklistner);
        this.detail.setVisibility(0);
        this.agreement.setVisibility(8);
        LearnMorePayClickListener learnMorePayClickListener = new LearnMorePayClickListener(this.mContext, getPayChangeSpaceAgreement());
        String string = this.mContext.getString(R$string.cloudpay_upgrade_instruction_new);
        setButton(-1, this.mContext.getString(R$string.cloudpay_package_sure).toUpperCase(Locale.getDefault()), this.mOnClicklistner);
        setTitle(this.mContext.getString(R$string.cloudpay_package_order_first));
        setSpannableString(learnMorePayClickListener, string, this.mContext.getString(R$string.cloudpay_package_estimate_dialog_monthly_small_buy_monthly_big, str, str2, string));
        setView(this.userAgreementView, 0, 0, 0, 0);
        Context context = this.mContext;
        if (context instanceof BuyPackageBaseActivity) {
            ((BuyPackageBaseActivity) context).m22879u4();
        }
        show();
    }

    public void showBasicBigBuyBasicSmall(String str, String str2, ChannelInfo channelInfo, String str3) {
        String string = this.mContext.getString(R$string.cloudpay_upgrade_instruction_new);
        showEstimateDialog(string, C10465b.m64293c(str3, str, str2, string), channelInfo);
    }

    public void showBasicSmallBuyBasicBig(String str, String str2, ChannelInfo channelInfo) {
        String string = this.mContext.getString(R$string.cloudpay_upgrade_instruction_new);
        showEstimateDialog(string, this.mContext.getString(R$string.cloudpay_package_estimate_dialog_small_buy_big, str, str2, string), channelInfo);
    }

    public void showConvertDialog(int i10, Long l10, boolean z10, boolean z11, String str, ChannelInfo channelInfo) {
        if (this.mContext == null) {
            C1442a.m8289e(TAG, "showDeductConvertDialog mContext is null.");
            return;
        }
        this.mChannelInfo = channelInfo;
        setTitle(R$string.cloudpay_confirm_buy);
        this.detail.setVisibility(0);
        this.agreement.setVisibility(8);
        LearnMorePayClickListener learnMorePayClickListener = new LearnMorePayClickListener(this.mContext, getAgreementSuffix());
        String string = this.mContext.getString(R$string.cloudpay_upgrade_instruction_new);
        String strM69668j = C11667a.m69668j(l10, this.mContext);
        setSpannableString(learnMorePayClickListener, string, z11 ? C10465b.m64293c(str, strM69668j, string) : z10 ? C10465b.m64293c(str, this.mContext.getResources().getQuantityString(R$plurals.common_days, i10, Integer.valueOf(i10)), strM69668j, string) : C10465b.m64293c(str, "2", "2", strM69668j, string));
        setView(this.userAgreementView, 0, 0, 0, 0);
        setButton(-1, this.mContext.getString(R$string.cloudpay_package_sure).toUpperCase(Locale.getDefault()), this.mOnClicklistner);
        setButton(-2, this.mContext.getString(R$string.package_info_dialog_cancel), this.mOnClicklistner);
        show();
        Context context = this.mContext;
        if (context instanceof BuyPackageBaseActivity) {
            ((BuyPackageBaseActivity) context).m22900z4();
        }
    }

    public void showDeductConvertDialog(int i10, String str, ChannelInfo channelInfo) {
        if (this.mContext == null) {
            C1442a.m8289e(TAG, "showDeductConvertDialog mContext is null.");
            return;
        }
        this.mChannelInfo = channelInfo;
        setTitle(R$string.cloudpay_deduct_discount_dialog_title);
        this.detail.setVisibility(0);
        this.agreement.setVisibility(8);
        LearnMorePayClickListener learnMorePayClickListener = new LearnMorePayClickListener(this.mContext, getAgreementSuffix());
        String string = this.mContext.getString(R$string.cloudpay_upgrade_instruction_new);
        setSpannableString(learnMorePayClickListener, string, C10465b.m64293c(str, this.mContext.getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_day, i10, NumberFormat.getInstance().format(i10)), string));
        setButton(-1, this.mContext.getString(R$string.cloudpay_package_sure).toUpperCase(Locale.getDefault()), this.mOnClicklistner);
        setButton(-2, this.mContext.getString(R$string.package_info_dialog_cancel), this.mOnClicklistner);
        setView(this.userAgreementView, 0, 0, 0, 0);
        show();
        Context context = this.mContext;
        if (context instanceof BuyPackageBaseActivity) {
            ((BuyPackageBaseActivity) context).m22875t4();
        }
    }

    public void showMonthBigBuyBasicSmall(String str, String str2, ChannelInfo channelInfo, String str3) {
        String string = this.mContext.getString(R$string.cloudpay_upgrade_instruction_new);
        showEstimateDialog(string, C10465b.m64293c(str3, str, str2, string), channelInfo);
    }

    public void showMonthSmallBuyBasicBig(String str, String str2, String str3, ChannelInfo channelInfo) {
        String string = this.mContext.getString(R$string.cloudpay_upgrade_instruction_new);
        showEstimateDialog(string, this.mContext.getString(R$string.cloudpay_package_estimate_dialog_monthly_small_buy_big, str, str2, str3, string), channelInfo);
    }

    public void showMonthSmallBuyMonthBig(String str, String str2) {
    }

    public ConfirmBuyPackageDialog(Context context, boolean z10) {
        super(context);
        this.mOnClicklistner = new BtnOnClickListner();
        this.mContext = context;
        this.isAopPay = z10;
        initView();
    }

    public void showConvertDialog(EstimateResp estimateResp, GetClientUIConfigResp getClientUIConfigResp, ChannelInfo channelInfo) {
        String defaultContent;
        if (this.mContext == null) {
            C1442a.m8289e(TAG, "showDeductConvertDialog mContext is null.");
            return;
        }
        this.mChannelInfo = channelInfo;
        String convertDialogTitle = getClientUIConfigResp.getConvertDialogTitle();
        if (TextUtils.isEmpty(convertDialogTitle)) {
            convertDialogTitle = this.mContext.getString(R$string.cloudpay_confirm_buy);
        }
        setTitle(convertDialogTitle);
        this.detail.setVisibility(0);
        this.agreement.setVisibility(8);
        ConvertInfo convertInfo = estimateResp.getConvertInfo();
        int convertPopType = convertInfo.getConvertPopType();
        C1442a.m8290i(TAG, "convertPopType = " + convertPopType);
        String convertionDialogNewText = getClientUIConfigResp.getConvertionDialogNewText(convertPopType);
        LearnMorePayClickListener learnMorePayClickListener = new LearnMorePayClickListener(this.mContext, getAgreementSuffix());
        String string = this.mContext.getString(R$string.cloudpay_upgrade_instruction_new);
        String strM69668j = C11667a.m69668j(estimateResp.getEndtime(), this.mContext);
        if (TextUtils.isEmpty(convertionDialogNewText)) {
            defaultContent = getDefaultContent(getClientUIConfigResp, strM69668j, string);
        } else if (convertPopType == 0) {
            List<CurPkgInfo> curPkgsInfo = estimateResp.getCurPkgsInfo();
            if (curPkgsInfo != null && !curPkgsInfo.isEmpty()) {
                int remainDays = curPkgsInfo.get(0).getRemainDays();
                defaultContent = C10465b.m64293c(convertionDialogNewText, this.mContext.getResources().getQuantityString(R$plurals.common_days, remainDays, Integer.valueOf(remainDays)), strM69668j, string);
            } else {
                C1442a.m8289e(TAG, "showConvertDialog curPkgInfoList is null or empty.");
                defaultContent = getDefaultContent(getClientUIConfigResp, strM69668j, string);
            }
        } else if (convertPopType == 1) {
            defaultContent = C10465b.m64293c(convertionDialogNewText, "2", "2", strM69668j, string);
        } else if (convertPopType == 2 || convertPopType == 3) {
            defaultContent = C10465b.m64293c(convertionDialogNewText, convertInfo.getProductName(), "2", strM69668j, string);
        } else if (convertPopType != 4) {
            C1442a.m8289e(TAG, "showConvertDialog invalid convertPopType = " + convertPopType);
            defaultContent = getDefaultContent(getClientUIConfigResp, strM69668j, string);
        } else {
            PackageGrades packageGrade = estimateResp.getPackageGrade();
            if (packageGrade == null) {
                C1442a.m8289e(TAG, "showConvertDialog packageGrade is null");
                defaultContent = getDefaultContent(getClientUIConfigResp, strM69668j, string);
            } else {
                defaultContent = C10465b.m64293c(convertionDialogNewText, convertInfo.getProductName(), C0223k.m1524g(this.mContext, packageGrade.getCapacity()), strM69668j, string);
            }
        }
        setSpannableString(learnMorePayClickListener, string, defaultContent);
        setView(this.userAgreementView, 0, 0, 0, 0);
        setButton(-1, this.mContext.getString(R$string.cloudpay_package_sure).toUpperCase(Locale.getDefault()), this.mOnClicklistner);
        setButton(-2, this.mContext.getString(R$string.package_info_dialog_cancel), this.mOnClicklistner);
        show();
        Context context = this.mContext;
        if (context instanceof BuyPackageBaseActivity) {
            if (this.isAopPay) {
                ((BuyPackageBaseActivity) context).m22845k4();
                return;
            } else {
                ((BuyPackageBaseActivity) context).m22900z4();
                return;
            }
        }
        if (context instanceof OperationWebViewActivity) {
            ((OperationWebViewActivity) context).m21843i3();
        }
    }
}
