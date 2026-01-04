package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.p088ui.UpgradeEmptyActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.p106db.bean.UpgradeDetailContent;
import com.huawei.hicloud.notification.p106db.bean.UpgradeJumpObject;
import com.huawei.hicloud.notification.p106db.bean.UpgradeSecondButton;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$drawable;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11839m;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import sk.C12809f;
import tj.C13019a;

/* loaded from: classes3.dex */
public class ForcedUpgradeActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: C */
    public Context f14806C;

    /* renamed from: p */
    public NotchTopFitRelativeLayout f14807p;

    /* renamed from: q */
    public NotchFitRelativeLayout f14808q;

    /* renamed from: r */
    public TextView f14809r;

    /* renamed from: s */
    public TextView f14810s;

    /* renamed from: t */
    public AutoSizeButton f14811t;

    /* renamed from: u */
    public AutoSizeButton f14812u;

    /* renamed from: v */
    public UpgradeDetailContent f14813v;

    /* renamed from: w */
    public UpgradeJumpObject f14814w;

    /* renamed from: x */
    public ActionBar f14815x;

    /* renamed from: y */
    public String f14816y = "";

    /* renamed from: z */
    public String f14817z = "";

    /* renamed from: A */
    public String f14804A = "";

    /* renamed from: B */
    public String f14805B = "";

    /* renamed from: com.huawei.android.hicloud.ui.activity.ForcedUpgradeActivity$a */
    public class RunnableC3284a implements Runnable {
        public RunnableC3284a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ForcedUpgradeActivity.this.finish();
            new HwAnimationReflection(ForcedUpgradeActivity.this.f14806C).m15927c(2);
        }
    }

    /* renamed from: P1 */
    private void m20446P1() {
        C11839m.m70686d(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "initView");
        this.f14807p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.forced_detail_topfit);
        this.f14808q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.forced_detail);
        if (TextUtils.isEmpty(this.f14816y) || TextUtils.isEmpty(this.f14817z) || TextUtils.isEmpty(this.f14804A)) {
            C11839m.m70687e(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "showUpgradeDetail text is null");
            finish();
            return;
        }
        this.f14809r = (TextView) C12809f.m76829b(this, R$id.forced_update_title);
        this.f14810s = (TextView) C12809f.m76829b(this, R$id.forced_update_content);
        this.f14811t = (AutoSizeButton) C12809f.m76829b(this, R$id.update_btn);
        this.f14812u = (AutoSizeButton) C12809f.m76829b(this, R$id.cancel_btn);
        ActionBar actionBar = getActionBar();
        this.f14815x = actionBar;
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            this.f14815x.setHomeAsUpIndicator(R$drawable.cloud_space_guide_back_icon);
        }
        try {
            this.f14813v = (UpgradeDetailContent) new HiCloudSafeIntent(getIntent()).getSerializableExtra("upgrade_notify_detail_key");
            this.f14809r.setText(this.f14816y);
            this.f14810s.setText(this.f14817z);
            this.f14811t.setText(this.f14804A);
            String str = this.f14805B;
            if (str != null) {
                this.f14812u.setText(str);
            } else {
                this.f14812u.setVisibility(8);
            }
            this.f14811t.setOnClickListener(this);
            this.f14812u.setOnClickListener(this);
        } catch (Exception unused) {
            C11839m.m70687e(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "get detailContent error");
            finish();
        }
    }

    /* renamed from: M1 */
    public void m20447M1(String str) {
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("forced_upgrade_type", Integer.valueOf(C10028c.m62182c0().m62278U()));
        C13227f.m79492i1().m79591l0(str, linkedHashMapM79499C);
        UBAAnalyze.m29957R("PVC", str, "1", "30", "forced_upgrade_type", String.valueOf(C10028c.m62182c0().m62278U()));
    }

    /* renamed from: N1 */
    public final void m20448N1(int i10, Intent intent) {
        ErrorStatus errorStatus;
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07009"), "termProcessHMSResult", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        map.put("hms_agreement_result_code", String.valueOf(i10));
        map.put("hms_current_activity", getClass().getName());
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        if (i10 == 0) {
            C11839m.m70687e(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "agreement update result cancel");
            if (intent != null) {
                try {
                    errorStatus = (ErrorStatus) intent.getParcelableExtra("parce");
                } catch (Exception e10) {
                    C11839m.m70687e(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "class ErrorStatus pkg path hms apk sdk not match  " + e10.getMessage());
                    errorStatus = null;
                }
                if (errorStatus != null) {
                    int errorCode = errorStatus.getErrorCode();
                    C11839m.m70687e(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "error code = " + errorCode + ", error reason = " + errorStatus.getErrorReason());
                    map.put("hms_agreement_result_error_code", String.valueOf(errorCode));
                    if (errorCode == 10002) {
                        c10028cM62183d0.m62377p3("hms_agr_force_query", false);
                    }
                }
            }
        } else {
            C11839m.m70688i(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "agreement update success");
            c10028cM62183d0.m62377p3("hms_agr_force_query", false);
            c10028cM62183d0.m62377p3("is_hicloud_terms_confirm", true);
            C11829c.m70604p();
        }
        C13622a.m81969o(this, c11060cM66626a, map);
    }

    /* renamed from: O1 */
    public void m20449O1() {
        C11839m.m70688i(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "exitAPP");
        C13019a.m78347n().m78354q(this);
        new Handler().postDelayed(new RunnableC3284a(), 200L);
        C13019a.m78347n().m78355r();
    }

    /* renamed from: Q1 */
    public final void m20450Q1() {
        C11839m.m70688i(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "parseUpgradeView");
        try {
            UpgradeDetailContent upgradeDetailContent = (UpgradeDetailContent) new HiCloudSafeIntent(getIntent()).getSerializableExtra("upgrade_notify_detail_key");
            this.f14813v = upgradeDetailContent;
            if (upgradeDetailContent == null) {
                C11839m.m70687e(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "detailContent is null");
                finish();
                return;
            }
            ForcedUpgradeUtil forcedUpgradeUtil = ForcedUpgradeUtil.getInstance();
            UpgradeSecondButton upgradeSecondButton = this.f14813v.getUpgradeSecondButton();
            if (upgradeSecondButton != null) {
                this.f14814w = this.f14813v.getUpgradeSecondButton().getUpgradeJumpObject();
                this.f14805B = forcedUpgradeUtil.getContentString(upgradeSecondButton.getBtnName());
            }
            this.f14816y = forcedUpgradeUtil.getContentString(this.f14813v.getUpgradeDetailTitle());
            this.f14817z = forcedUpgradeUtil.getContentString(this.f14813v.getUpgradeDetailText());
            this.f14804A = forcedUpgradeUtil.getContentString(this.f14813v.getUpgradeFirstButton().getBtnName());
        } catch (Exception unused) {
            C11839m.m70687e(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "get detailContent error");
            finish();
        }
    }

    /* renamed from: R1 */
    public final void m20451R1() {
        if (C10028c.m62182c0().m62320e1()) {
            C11839m.m70688i(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "is cancel hicloud");
            m20449O1();
        } else if (!C10028c.m62182c0().m62226I1()) {
            C11839m.m70688i(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "finish activity");
            finish();
        } else {
            C11839m.m70688i(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "is upgrade action");
            finish();
            startActivity(new Intent(this, (Class<?>) UpgradeEmptyActivity.class));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14807p);
        arrayList.add(this.f14808q);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        super.onActivityResult(i10, i11, hiCloudSafeIntent);
        C11839m.m70688i(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "onActivityResult, requestCode = " + i10 + ", resultCode = " + i11);
        if (i10 == 10028) {
            m20448N1(i11, hiCloudSafeIntent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        if (view.getId() == R$id.update_btn) {
            m20447M1("upgrade_detail_click_upgrade");
            m20451R1();
            return;
        }
        m20447M1("upgrade_detail_click_cancel");
        try {
            startActivity(ForcedUpgradeUtil.getInstance().parseUpgradeGoto(this, this.f14814w, this.f14813v));
        } catch (Exception e10) {
            C11839m.m70687e(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "goto fail, exception: " + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m20450Q1();
        setContentView(R$layout.forced_upgrade);
        m20446P1();
        mo19005p1();
        this.f14806C = this;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11839m.m70688i(NotifyConstants.ActivityName.FORCED_UPGRADE_ACTIVITY, "onDestroy");
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        m20447M1("upgrade_detail_clicl_x");
        m20449O1();
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m20449O1();
        return true;
    }
}
