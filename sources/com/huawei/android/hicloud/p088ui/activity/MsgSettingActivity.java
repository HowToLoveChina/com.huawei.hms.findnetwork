package com.huawei.android.hicloud.p088ui.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.android.hicloud.p088ui.dialog.ClearMsgAlertDialog;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemCheckedChangeListener;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class MsgSettingActivity extends HMSTermsProcessBaseActivity implements View.OnClickListener, HiCloudItemCheckedChangeListener {

    /* renamed from: p */
    public NotchTopFitLinearLayout f15584p;

    /* renamed from: q */
    public NotchFitLinearLayout f15585q;

    /* renamed from: r */
    public LinearLayout f15586r;

    /* renamed from: s */
    public HiCloudItemView f15587s;

    /* renamed from: t */
    public HiCloudItemView f15588t;

    /* renamed from: u */
    public ClearMsgAlertDialog f15589u;

    /* renamed from: M1 */
    private void m21638M1() {
        LinearLayout linearLayout = this.f15586r;
        if (linearLayout != null) {
            C11842p.m70882x1(this, linearLayout);
        }
    }

    /* renamed from: N1 */
    private void m21639N1() {
        ClearMsgAlertDialog clearMsgAlertDialog = this.f15589u;
        if (clearMsgAlertDialog != null) {
            clearMsgAlertDialog.dismiss();
        }
    }

    /* renamed from: O1 */
    private void m21640O1() {
        this.f15584p = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.msg_setting_main_layout);
        this.f15585q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.item_notchfit_layout);
        this.f15586r = (LinearLayout) C12809f.m76829b(this, R$id.item_layout);
        HiCloudItemView hiCloudItemView = (HiCloudItemView) C12809f.m76829b(this, R$id.no_disturb_item);
        this.f15587s = hiCloudItemView;
        hiCloudItemView.setItemOnCheckedChangeListener(this);
        this.f15587s.setCheckedProgrammatically(MessageCenterManager.getInstance().getNoDisturbStatus());
        HiCloudItemView hiCloudItemView2 = (HiCloudItemView) C12809f.m76829b(this, R$id.clear_msg_item);
        this.f15588t = hiCloudItemView2;
        hiCloudItemView2.setOnClickListener(this);
        mo19005p1();
        m21638M1();
    }

    /* renamed from: P1 */
    public final void m21641P1() {
        NotifyLogger.m29915i("MsgSettingActivity", "onClickClearMsg");
        ClearMsgAlertDialog clearMsgAlertDialog = new ClearMsgAlertDialog(this);
        this.f15589u = clearMsgAlertDialog;
        clearMsgAlertDialog.show();
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.HiCloudItemCheckedChangeListener
    /* renamed from: d0 */
    public void mo21351d0(HiCloudItemView hiCloudItemView, boolean z10) {
        NotifyLogger.m29915i("MsgSettingActivity", "onCheckedChanged, is checked: " + z10);
        MessageCenterManager.getInstance().setNoDisturbStatus(z10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15584p);
        arrayList.add(this.f15585q);
        arrayList.add(this.f15586r);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: n1 */
    public void mo13327n1() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.mo13327n1();
        m22365E1(R$string.message_setting);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R$id.clear_msg_item != view.getId() || C0209d.m1226Y0()) {
            return;
        }
        m21641P1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.activity_msg_setting);
        m21640O1();
        mo13327n1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m21639N1();
    }
}
