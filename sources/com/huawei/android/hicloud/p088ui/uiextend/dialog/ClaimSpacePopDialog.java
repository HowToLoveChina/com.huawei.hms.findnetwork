package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.p073ds.R$style;
import com.huawei.cloud.pay.model.PayActivityInfo;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.SpaceNoticeCommonSpUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import je.C10804r;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0223k;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ClaimSpacePopDialog extends Dialog implements View.OnClickListener {
    private static final String TAG = "ClaimSpacePopDialog";
    private AutoSizeButton checkNowButton;
    private ImageView closeButton;
    private TextView descriptTextView;
    private C10804r dialogManager;
    private RelativeLayout displayLayout;
    private Context mContext;
    private PayActivityInfo mPayActivityInfo;
    private String reportCapacity;
    private Resources resources;
    private TextView titleTextView;

    public ClaimSpacePopDialog(Context context, PayActivityInfo payActivityInfo, C10804r c10804r) throws IllegalAccessException, IllegalArgumentException {
        super(context, R$style.full_screen_dialog);
        this.mContext = context;
        this.mPayActivityInfo = payActivityInfo;
        if (context == null || payActivityInfo == null) {
            C11839m.m70687e(TAG, "init claim space dialog failed, context is null, or payActivityInfo is null");
            return;
        }
        this.resources = context.getResources();
        this.dialogManager = c10804r;
        initView();
    }

    private void drewLayoutView() {
        this.displayLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.ClaimSpacePopDialog.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ClaimSpacePopDialog.this.displayLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                ClaimSpacePopDialog.this.setDisplayLayoutParameter();
                return false;
            }
        });
    }

    private String getAlertContent() {
        int i10 = this.mPayActivityInfo.getcType();
        long capacity = this.mPayActivityInfo.getCapacity();
        String strM1524g = C0223k.m1524g(this.mContext, capacity);
        this.reportCapacity = strM1524g;
        Resources resources = this.resources;
        String string = resources != null ? resources.getString(R$string.to_receive_space_tips, strM1524g) : "";
        C11839m.m70688i(TAG, "claim activity type = " + i10 + ", capacity = " + capacity);
        return string;
    }

    private JSONObject getBiObject(String str) throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(C0213f.m1377a(), str, "1", C13452e.m80781L().m80971t0(), "2");
        try {
            jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, this.mPayActivityInfo.getcType());
            jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_ID, this.mPayActivityInfo.getcId());
            jSONObjectM79482j.put("capacity_value", this.reportCapacity);
        } catch (JSONException e10) {
            C11839m.m70687e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        return jSONObjectM79482j;
    }

    private LinkedHashMap getPageEventKeyValue() {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, Integer.valueOf(this.mPayActivityInfo.getcType()));
        linkedHashMapM79499C.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_ID, this.mPayActivityInfo.getcId());
        linkedHashMapM79499C.put("capacity_value", this.reportCapacity);
        return linkedHashMapM79499C;
    }

    private void initView() throws IllegalAccessException, IllegalArgumentException {
        C11829c.m70594l1(this.mContext, this);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(this.mContext.getColor(R$color.translucent_background)));
            window.setGravity(17);
        }
        View viewM76832e = C12809f.m76832e(getLayoutInflater(), R$layout.to_recive_space_free_dialog);
        setContentView(viewM76832e);
        this.descriptTextView = (TextView) C12809f.m76831d(viewM76832e, R$id.recive_space_description_text);
        this.titleTextView = (TextView) C12809f.m76831d(viewM76832e, R$id.recive_space_title_text);
        this.checkNowButton = (AutoSizeButton) C12809f.m76831d(viewM76832e, R$id.check_recieve_now_button);
        this.closeButton = (ImageView) C12809f.m76831d(viewM76832e, R$id.close_recieve_space_button);
        this.displayLayout = (RelativeLayout) C12809f.m76831d(viewM76832e, R$id.main_recieve_space_display_layout);
        drewLayoutView();
        this.titleTextView.setText(R$string.to_receive_space_title);
        this.checkNowButton.setText(R$string.to_receive_space_button);
        this.descriptTextView.setText(getAlertContent());
        this.checkNowButton.setOnClickListener(this);
        this.closeButton.setOnClickListener(this);
    }

    public void dialogClaimClickReport() throws JSONException {
        JSONObject biObject = getBiObject("CLAIM_SPACE_POP_CLAIM_BUTTON_CLICK");
        C13227f.m79492i1().m79602z(biObject);
        UBAAnalyze.m29963X("PVC", "CLAIM_SPACE_POP_CLAIM_BUTTON_CLICK", "4", "46", biObject);
        LinkedHashMap pageEventKeyValue = getPageEventKeyValue();
        C13227f.m79492i1().m79591l0("mecloud_claimspacedialog_claim_now", pageEventKeyValue);
        UBAAnalyze.m29958S("PVC", "mecloud_claimspacedialog_claim_now", "4", "46", pageEventKeyValue);
    }

    public void dialogOffClickReport() throws JSONException {
        JSONObject biObject = getBiObject("CLAIM_SPACE_POP_OFF_BUTTON_CLICK");
        C13227f.m79492i1().m79602z(biObject);
        UBAAnalyze.m29963X("PVC", "CLAIM_SPACE_POP_OFF_BUTTON_CLICK", "4", "46", biObject);
        LinkedHashMap pageEventKeyValue = getPageEventKeyValue();
        C13227f.m79492i1().m79591l0("mecloud_claimspacedialog_off", pageEventKeyValue);
        UBAAnalyze.m29958S("PVC", "mecloud_claimspacedialog_off", "4", "46", pageEventKeyValue);
    }

    public void dialogShowReport() {
        JSONObject biObject = getBiObject("CLAIM_SPACE_POP_SHOW");
        C13227f.m79492i1().m79602z(biObject);
        UBAAnalyze.m29963X("PVC", "CLAIM_SPACE_POP_SHOW", "4", "46", biObject);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        if (R$id.check_recieve_now_button == view.getId()) {
            C11839m.m70688i(TAG, "claim button clicked");
            Intent intent = new Intent();
            C13222a.m79471m(intent, 8);
            intent.setClass(this.mContext, CloudSpaceUpgradeActivity.class);
            this.mContext.startActivity(intent);
            SpaceNoticeCommonSpUtil.getInstance().setShownAlready(true);
            dialogClaimClickReport();
            dismiss();
        } else if (R$id.close_recieve_space_button == view.getId()) {
            C11839m.m70688i(TAG, "off button clicked");
            dialogOffClickReport();
            SpaceNoticeCommonSpUtil.getInstance().setShownAlready(true);
            dismiss();
        }
        C10804r c10804r = this.dialogManager;
        if (c10804r != null) {
            c10804r.m65759f("CLAM_POP");
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) throws JSONException {
        if (i10 == 4) {
            C11839m.m70688i(TAG, "onkeydown");
            SpaceNoticeCommonSpUtil.getInstance().setShownAlready(true);
            dialogOffClickReport();
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public void setDisplayLayoutParameter() {
        try {
            int iM70752O = C11842p.m70752O(this.mContext);
            int iM70789a0 = C11842p.m70789a0(this.mContext);
            int height = this.displayLayout.getHeight();
            ViewGroup.LayoutParams layoutParams = this.displayLayout.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (!C11842p.m70753O0(getContext())) {
                    layoutParams2.topMargin = ((iM70752O / 2) - (height / 2)) - (iM70789a0 / 2);
                } else if (C11842p.m70771U0() || C11842p.m70747M0(this.mContext)) {
                    layoutParams2.topMargin = C11842p.m70840n(getContext(), 96);
                } else {
                    layoutParams2.topMargin = C11842p.m70840n(getContext(), 24);
                }
                this.displayLayout.setLayoutParams(layoutParams2);
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "set layout param error, e = " + e10.toString());
        }
    }
}
