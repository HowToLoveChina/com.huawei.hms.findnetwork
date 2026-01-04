package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.HisyncSpaceDetailActivity;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import com.huawei.hicloud.base.bean.FamilyDetailInfo;
import com.huawei.hicloud.base.bean.FamilyDetailInfoResult;
import com.huawei.hicloud.base.bean.FamilyDetailInfoRetBody;
import com.huawei.hicloud.base.bean.QuotaInfo;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.p106db.bean.MemberShareDetail;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0223k;
import p054cj.C1442a;
import p364ib.C10465b;
import p514o9.C11839m;
import p616rk.C12515a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p732w8.C13560k;
import sk.C12808e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudSpaceMemberShareActivity extends BasePayActivity {

    /* renamed from: C */
    public TextView f16803C;

    /* renamed from: D */
    public TextView f16804D;

    /* renamed from: E */
    public TextView f16805E;

    /* renamed from: F */
    public LinearLayout f16806F;

    /* renamed from: G */
    public LinearLayout f16807G;

    /* renamed from: H */
    public LinearLayout f16808H;

    /* renamed from: I */
    public Handler f16809I = new HandlerC3608a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceMemberShareActivity$a */
    public class HandlerC3608a extends Handler {
        public HandlerC3608a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 2002) {
                CloudSpaceMemberShareActivity.this.m23224T1(message.obj);
                return;
            }
            if (i10 == 2003) {
                CloudSpaceMemberShareActivity.this.m23223S1();
                return;
            }
            C1442a.m8290i("CloudSpaceMemberShareActivity", "invalid resultCode = " + i10);
            CloudSpaceMemberShareActivity.this.m23226V1();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceMemberShareActivity$b */
    public class ViewOnClickListenerC3609b implements View.OnClickListener {
        public ViewOnClickListenerC3609b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1442a.m8290i("CloudSpaceMemberShareActivity", "click jump btn.");
            CloudSpaceMemberShareActivity.this.m23226V1();
            CloudSpaceMemberShareActivity.this.m23228Z1();
        }
    }

    /* renamed from: W1 */
    private void m23219W1() {
        C1442a.m8290i("CloudSpaceMemberShareActivity", "initData");
        m23221a2();
        C12515a.m75110o().m75172d(new C13560k(this.f16809I));
    }

    /* renamed from: X1 */
    private void m23220X1() {
        this.f16808H = (LinearLayout) C12809f.m76829b(this, R$id.member_base_layout);
        this.f16806F = (LinearLayout) C12809f.m76829b(this, R$id.member_layout_loading);
        this.f16807G = (LinearLayout) C12809f.m76829b(this, R$id.member_main_layout);
        this.f16803C = (TextView) C12809f.m76829b(this, R$id.member_share_title);
        this.f16804D = (TextView) C12809f.m76829b(this, R$id.member_share_main_text);
        this.f16805E = (TextView) C12809f.m76829b(this, R$id.member_share_btn);
    }

    /* renamed from: a2 */
    private void m23221a2() {
        LinearLayout linearLayout = this.f16806F;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.f16807G;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    /* renamed from: b2 */
    private void m23222b2() {
        LinearLayout linearLayout = this.f16807G;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.f16806F;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    /* renamed from: S1 */
    public final void m23223S1() {
        C1442a.m8289e("CloudSpaceMemberShareActivity", "dealGetFamilyDetailInfoFailed");
        m23226V1();
    }

    /* renamed from: T1 */
    public final void m23224T1(Object obj) {
        if (obj == null) {
            C1442a.m8289e("CloudSpaceMemberShareActivity", "dealGetFamilyDetailInfoSuccess object is null.");
            m23226V1();
            return;
        }
        if (!(obj instanceof FamilyDetailInfoResult)) {
            C1442a.m8289e("CloudSpaceMemberShareActivity", "dealGetFamilyDetailInfoSuccess object is invalid.");
            m23226V1();
            return;
        }
        FamilyDetailInfoResult familyDetailInfoResult = (FamilyDetailInfoResult) obj;
        int retCode = familyDetailInfoResult.getRetCode();
        if (retCode == 0) {
            m23229c2(familyDetailInfoResult.getRetBody());
            return;
        }
        C1442a.m8289e("CloudSpaceMemberShareActivity", "dealGetFamilyDetailInfoSuccess err code = " + retCode + " , err description : " + familyDetailInfoResult.getRetDesc());
        m23226V1();
    }

    /* renamed from: U1 */
    public final String m23225U1(List<FamilyDetailInfo> list) {
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("CloudSpaceMemberShareActivity", "getOwnerName familyDetailInfoList is null.");
            return "";
        }
        for (FamilyDetailInfo familyDetailInfo : list) {
            if (familyDetailInfo.getOwner()) {
                return familyDetailInfo.getName();
            }
        }
        C1442a.m8289e("CloudSpaceMemberShareActivity", "getOwnerName no owner.");
        return "";
    }

    /* renamed from: V1 */
    public final void m23226V1() {
        startActivity(new Intent(this, (Class<?>) HisyncSpaceDetailActivity.class));
        finish();
    }

    /* renamed from: Y1 */
    public final void m23227Y1() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            C13227f.m79492i1().m79567R("UNIFORM_MEMBER_MANAGE_ENTER_INFO", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_MEMBER_MANAGE_ENTER_INFO", "1", "36", linkedHashMapM79497A);
            m28575A1("UNIFORM_MEMBER_MANAGE_ENTER_INFO", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpaceMemberShareActivity", "reportEnterGuideActivity error occur:" + e10.getMessage());
        }
    }

    /* renamed from: Z1 */
    public final void m23228Z1() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            C13227f.m79492i1().m79567R("UNIFORM_MEMBER_MANAGE_CLICK_BTN", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_MEMBER_MANAGE_CLICK_BTN", "1", "7", linkedHashMapM79497A);
            m28575A1("UNIFORM_MEMBER_MANAGE_CLICK_BTN", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpaceMemberShareActivity", "reportEnterUpgradeActivity error occur:" + e10.getMessage());
        }
    }

    /* renamed from: c2 */
    public final void m23229c2(FamilyDetailInfoRetBody familyDetailInfoRetBody) {
        MemberShareDetail memberShareDetail;
        String notifyType;
        String strM64293c;
        if (this.f16803C == null || this.f16804D == null || this.f16805E == null || familyDetailInfoRetBody == null) {
            C11839m.m70687e("CloudSpaceMemberShareActivity", "showView view is null.");
            m23226V1();
            return;
        }
        C1442a.m8290i("CloudSpaceMemberShareActivity", "showview start.");
        try {
            memberShareDetail = (MemberShareDetail) new HiCloudSafeIntent(getIntent()).getSerializableExtra(FamilyShareConstants.NOTIFY_MEMBER_SHARE_DETAIL);
        } catch (Exception e10) {
            C1442a.m8289e("CloudSpaceMemberShareActivity", "showView get member share detail error " + e10.getMessage());
            memberShareDetail = null;
        }
        if (memberShareDetail == null) {
            C1442a.m8289e("CloudSpaceMemberShareActivity", "memberShareDetail is null.");
            m23226V1();
            return;
        }
        this.f16803C.setText(memberShareDetail.getTitle());
        notifyType = memberShareDetail.getNotifyType();
        notifyType.hashCode();
        switch (notifyType) {
            case "cloudphoto_sync_space_insufficient":
            case "space_available_size":
            case "space_available_ratio":
            case "thirdApp_space_insufficient":
            case "space_used_size":
            case "cloud_backup_space_insufficient":
                QuotaInfo quotaInfo = familyDetailInfoRetBody.getQuotaInfo();
                if (quotaInfo != null) {
                    QuotaSpaceInfo quotaSpaceInfo = quotaInfo.getQuotaSpaceInfo();
                    if (quotaSpaceInfo != null) {
                        long available = quotaSpaceInfo.getAvailable();
                        if (available < 0) {
                            available = 0;
                        }
                        strM64293c = C10465b.m64293c(memberShareDetail.getMainText(), C0223k.m1524g(this, available), m23225U1(familyDetailInfoRetBody.getUsedSpaceInfoList()));
                        break;
                    } else {
                        C1442a.m8289e("CloudSpaceMemberShareActivity", "showView quotaSpaceInfo is null.");
                        strM64293c = memberShareDetail.getMainText();
                        break;
                    }
                } else {
                    C1442a.m8289e("CloudSpaceMemberShareActivity", "showView quotaInfo is null.");
                    strM64293c = memberShareDetail.getMainText();
                    break;
                }
            case "space_available_days_v3":
                strM64293c = C10465b.m64293c(memberShareDetail.getMainText(), m23225U1(familyDetailInfoRetBody.getUsedSpaceInfoList()));
                break;
            default:
                C1442a.m8289e("CloudSpaceMemberShareActivity", "invalid notifyType = " + notifyType);
                strM64293c = memberShareDetail.getMainText();
                break;
        }
        this.f16804D.setText(strM64293c);
        this.f16805E.setText(memberShareDetail.getButtonText());
        this.f16805E.setOnClickListener(new ViewOnClickListenerC3609b());
        m23222b2();
        C1442a.m8290i("CloudSpaceMemberShareActivity", "showview finish.");
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16808H);
        arrayList.add(this.f16806F);
        arrayList.add(this.f16807G);
        return arrayList;
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: i1 */
    public String mo23018i1() {
        return "CloudSpaceMemberShareActivity";
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.activity_cloud_space_member_share);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R$drawable.cloud_space_guide_back_icon);
        }
        m23220X1();
        m28587n1();
        m23219W1();
        C12808e.m76822a(this);
        m23227Y1();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.f16809I;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f16809I = null;
        }
    }
}
