package com.huawei.android.hicloud.p088ui.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupNotificationV5Util;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiextend.HotTitleTextView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.RecommendTipData;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.secure.android.common.intent.SafeIntent;
import dj.C9158a;
import fk.C9721b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0223k;
import p054cj.C1442a;
import p222da.C9060d;
import p341hj.C10221d1;
import p341hj.C10257p1;
import p364ib.C10465b;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import p709vj.C13452e;
import p742wj.C13612b;
import sk.C12809f;

/* loaded from: classes3.dex */
public abstract class CloudBackupSpaceGuideActivitty extends BuyPackageBaseActivity implements View.OnClickListener {

    /* renamed from: A1 */
    public int f14043A1;

    /* renamed from: B1 */
    public int f14044B1;

    /* renamed from: C1 */
    public Handler f14045C1;

    /* renamed from: D1 */
    public Handler f14046D1;

    /* renamed from: h1 */
    public NotchTopFitLinearLayout f14047h1;

    /* renamed from: i1 */
    public View f14048i1;

    /* renamed from: j1 */
    public View f14049j1;

    /* renamed from: k1 */
    public View f14050k1;

    /* renamed from: l1 */
    public View f14051l1;

    /* renamed from: m1 */
    public View f14052m1;

    /* renamed from: n1 */
    public AutoSizeButton f14053n1;

    /* renamed from: o1 */
    public TextView f14054o1;

    /* renamed from: p1 */
    public TextView f14055p1;

    /* renamed from: q1 */
    public HiCloudExceptionView f14056q1;

    /* renamed from: r1 */
    public RelativeLayout f14057r1;

    /* renamed from: s1 */
    public RelativeLayout f14058s1;

    /* renamed from: t1 */
    public RecommendNeedData f14059t1;

    /* renamed from: u1 */
    public HotTitleTextView f14060u1;

    /* renamed from: v1 */
    public RecommendTipData f14061v1;

    /* renamed from: w1 */
    public String f14062w1;

    /* renamed from: x1 */
    public boolean f14063x1;

    /* renamed from: y1 */
    public boolean f14064y1 = false;

    /* renamed from: z1 */
    public boolean f14065z1 = true;

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceGuideActivitty$a */
    public class C3186a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f14066a;

        public C3186a(String str) {
            this.f14066a = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            String noticeTextFromConfig = !TextUtils.isEmpty(this.f14066a) ? HicloudH5ConfigManager.getInstance().getNoticeTextFromConfig(this.f14066a, "recommend_detail_link1") : "";
            Message messageObtain = Message.obtain(CloudBackupSpaceGuideActivitty.this.f14046D1, 1005);
            messageObtain.obj = noticeTextFromConfig;
            messageObtain.sendToTarget();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceGuideActivitty$b */
    public static class HandlerC3187b extends Handler {

        /* renamed from: a */
        public final WeakReference<CloudBackupSpaceGuideActivitty> f14068a;

        public HandlerC3187b(CloudBackupSpaceGuideActivitty cloudBackupSpaceGuideActivitty) {
            this.f14068a = new WeakReference<>(cloudBackupSpaceGuideActivitty);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CloudBackupSpaceGuideActivitty cloudBackupSpaceGuideActivitty = this.f14068a.get();
            if (message == null) {
                C11839m.m70687e("CloudBackupSpaceGuideActivitty", "cloudBackupSpaceHandler msg is null");
                return;
            }
            if (CloudBackupSpaceGuideActivitty.m19439M5(cloudBackupSpaceGuideActivitty)) {
                C11839m.m70687e("CloudBackupSpaceGuideActivitty", "ad activity is null");
            } else {
                if (message.what != 1005) {
                    return;
                }
                Object obj = message.obj;
                if (obj instanceof String) {
                    cloudBackupSpaceGuideActivitty.m19470b6((String) obj);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudBackupSpaceGuideActivitty$c */
    public class HandlerC3188c extends Handler {

        /* renamed from: a */
        public final WeakReference<CloudBackupSpaceGuideActivitty> f14069a;

        public HandlerC3188c(CloudBackupSpaceGuideActivitty cloudBackupSpaceGuideActivitty) {
            this.f14069a = new WeakReference<>(cloudBackupSpaceGuideActivitty);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CloudBackupSpaceGuideActivitty cloudBackupSpaceGuideActivitty = this.f14069a.get();
            if (message == null) {
                C11839m.m70687e("CloudBackupSpaceGuideActivitty", "mLoaderHandler msg is null");
                return;
            }
            if (CloudBackupSpaceGuideActivitty.m19439M5(cloudBackupSpaceGuideActivitty)) {
                C11839m.m70687e("CloudBackupSpaceGuideActivitty", "ad activity is null");
                return;
            }
            Object obj = message.obj;
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            int i10 = message.what;
            if (i10 == 7014) {
                CloudBackupSpaceGuideActivitty.this.m19471d6(iIntValue, cloudBackupSpaceGuideActivitty);
            } else if (i10 != 7015) {
                cloudBackupSpaceGuideActivitty.f14064y1 = false;
                cloudBackupSpaceGuideActivitty.m19465X5();
            } else {
                cloudBackupSpaceGuideActivitty.f14064y1 = true;
                cloudBackupSpaceGuideActivitty.m19465X5();
            }
        }
    }

    /* renamed from: M5 */
    public static boolean m19439M5(CloudBackupSpaceGuideActivitty cloudBackupSpaceGuideActivitty) {
        return cloudBackupSpaceGuideActivitty == null || cloudBackupSpaceGuideActivitty.isFinishing();
    }

    /* renamed from: N5 */
    private void m19440N5() {
        if (C11829c.m70530L0()) {
            m22750C3(3);
        } else {
            C11839m.m70689w("CloudBackupSpaceGuideActivitty", "not support activity");
        }
    }

    /* renamed from: O5 */
    private void m19441O5() {
        long j10;
        RecommendNeedData recommendNeedData = this.f14059t1;
        if (recommendNeedData == null) {
            C11839m.m70687e("CloudBackupSpaceGuideActivitty", "getRecommedPackages recommendNeedData is null.");
            finish();
            return;
        }
        if (TextUtils.isEmpty(recommendNeedData.getRecommendType())) {
            C11839m.m70689w("CloudBackupSpaceGuideActivitty", "getRecommedPackages recommendType is null.");
            return;
        }
        if (this.f14059t1.isV5BackupNotEnoughDialog()) {
            Filter filter = new Filter();
            filter.setShowPlace(2);
            C9158a.m57503F().m57559x(this.f16524O, filter, null, m22882v2(), true, true, this.f14059t1.getTotalNeedSpace());
            return;
        }
        long totalNeedSpace = this.f14059t1.getTotalNeedSpace();
        if (totalNeedSpace < 5368709120L) {
            C11839m.m70689w("CloudBackupSpaceGuideActivitty", "getRecommedPackages totalNeedSpace = " + totalNeedSpace + " reset the value.");
            j10 = 5368709120L;
        } else {
            j10 = totalNeedSpace;
        }
        String recommendType = this.f14059t1.getRecommendType();
        ChannelInfo channelInfoM22882v2 = m22882v2();
        recommendType.hashCode();
        if (recommendType.equals(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT)) {
            C9158a.m57503F().m57513K(this.f16524O, this.f21448i, 0, j10, 2, channelInfoM22882v2, this.f14059t1.isWorryFreeExpire());
            return;
        }
        C11839m.m70689w("CloudBackupSpaceGuideActivitty", "getRecommedPackages default type : " + recommendType);
    }

    /* renamed from: Q5 */
    private void m19442Q5() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f14043A1);
        bundle.putInt(FamilyShareConstants.EXTRA_KEY, this.f14044B1);
        intent.putExtras(bundle);
        intent.setClass(this, CloudSpaceShareActivity.class);
        startActivity(intent);
    }

    /* renamed from: c6 */
    private void m19443c6() {
        this.f14052m1.setVisibility(0);
        this.f14050k1.setVisibility(8);
        this.f14051l1.setVisibility(8);
        this.f14049j1.setVisibility(8);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: B1 */
    public void mo19444B1() {
        m28577K1(540, this.f14049j1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: C1 */
    public void mo19445C1() {
        m28577K1(472, this.f14049j1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: D1 */
    public void mo19446D1() {
        Intent intent = new Intent();
        intent.setAction("android.settings.WIRELESS_SETTINGS");
        intent.putExtra("use_emui_ui", true);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            C11839m.m70687e("CloudBackupSpaceGuideActivitty", "startActivity: setNet failed");
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: E1 */
    public void mo19447E1() {
        m28577K1(ErrorCode.ERROR_SIGTOOL_FAIL, this.f14049j1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: F1 */
    public void mo19448F1() {
        m28577K1(466, this.f14049j1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: G1 */
    public void mo19449G1() {
        m28577K1(472, this.f14049j1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: H1 */
    public void mo19450H1() {
        m28576J1(this.f14049j1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) {
        C11839m.m70688i("CloudBackupSpaceGuideActivitty", "getSpaceInfo");
        C9158a.m57503F().m57505B(this.f16524O, this.f21448i, false);
        C9158a.m57503F().m57517O(this.f16524O, this.f21448i, false, true, "CloudBackupSpaceGuideActivitty");
        RecommendNeedData recommendNeedData = this.f14059t1;
        if (recommendNeedData == null) {
            C11839m.m70687e("CloudBackupSpaceGuideActivitty", "getSpaceInfo recommendNeedData is null.");
        } else {
            if ("family_share".equals(recommendNeedData.getRecommendType())) {
                return;
            }
            m19441O5();
            C11839m.m70686d("CloudBackupSpaceGuideActivitty", "get space info, not family share, check campaign");
            m19440N5();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: O3 */
    public void mo19452O3(Message message) {
        if (message == null) {
            C11839m.m70687e("CloudBackupSpaceGuideActivitty", "handleH5ConfigUpdate msg null");
        } else if (message.arg1 == 1002) {
            m19459S5();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: O4 */
    public void mo19453O4(int i10, Intent intent) throws JSONException {
        if (i10 != 10002) {
            super.mo19453O4(i10, intent);
            return;
        }
        RecommendNeedData recommendNeedData = this.f14059t1;
        if (recommendNeedData == null) {
            C11839m.m70687e("CloudBackupSpaceGuideActivitty", "handleErrorScene recommendNeedDacputa is null.");
            finish();
        } else {
            if ("family_share".equals(recommendNeedData.getRecommendType())) {
                C11839m.m70688i("CloudBackupSpaceGuideActivitty", "handleErrorScene family share finish.");
                setResult(103);
                m19442Q5();
                finish();
                return;
            }
            mo19474g5();
            C13108a.m78878b(getApplicationContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY"));
            m19462U5();
            finish();
        }
    }

    /* renamed from: P5 */
    public void m19454P5() {
        if (TextUtils.isEmpty(this.f16571r0)) {
            C11839m.m70687e("CloudBackupSpaceGuideActivitty", "gotoUri is empty");
            return;
        }
        try {
            C11839m.m70686d("CloudBackupSpaceGuideActivitty", "gotoUri: " + this.f16571r0);
            startActivityForResult(NotifyUtil.getDlAppWebViewIntent(this, this.f16571r0), NotifyConstants.RequestCode.REQUESTCODE_CAMPAIGN);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupSpaceGuideActivitty", "gotoDownloadApp Exception : " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: Q2 */
    public void mo19455Q2(int i10) {
        C1442a.m8289e("CloudBackupSpaceGuideActivitty", "errCode = " + i10);
        if (NotifyConstants.THRID_APP_SPACE_INSUFFICIENT.equals(this.f14059t1.getRecommendType())) {
            finish();
        } else {
            mo19477k5();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: R2 */
    public void mo19456R2(Object obj) {
        if (!(obj instanceof GetAvailableGradePackagesResp)) {
            C1442a.m8289e("CloudBackupSpaceGuideActivitty", "dealGetAvailableGradePackagesSuccess obj is invalid");
            mo19477k5();
            return;
        }
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleRespBuildSpaceRuleResp = BackupNotificationV5Util.buildSpaceRuleResp((GetAvailableGradePackagesResp) obj);
        if (getPackagesBySpaceRuleRespBuildSpaceRuleResp == null) {
            C1442a.m8289e("CloudBackupSpaceGuideActivitty", "getPackagesBySpaceRuleResp is null.");
            m19462U5();
            finish();
        } else {
            ArrayList<FilterAvailabalGradePackage> arrayListM67829n = C11296s.m67829n(getPackagesBySpaceRuleRespBuildSpaceRuleResp.getPackageGrades(), getPackagesBySpaceRuleRespBuildSpaceRuleResp.getSpacePackages());
            this.f16548a0 = arrayListM67829n;
            m22876t5(arrayListM67829n);
            if (this.f16548a0 == null) {
                this.f16548a0 = new ArrayList<>();
            }
            mo19479s5();
        }
    }

    /* renamed from: R5 */
    public final void m19457R5() {
        HotTitleTextView hotTitleTextView = this.f14060u1;
        if (hotTitleTextView != null) {
            hotTitleTextView.setVisibility(8);
            this.f14060u1.setRedDotVisibility(8);
            this.f14060u1.setText("");
            this.f14060u1.setOnClickListener(null);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        return false;
    }

    /* renamed from: S5 */
    public final void m19459S5() {
        C11839m.m70686d("CloudBackupSpaceGuideActivitty", "initTaskAdLoader");
        C12515a.m75110o().m75175e(new C9060d(this.f16570q0, this.f16572s0, this.f16573t0, this.f16574u0, this.f14045C1, 1002, false), false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        if (this.f14056q1.getVisibility() == 0) {
            this.f14056q1.m23914a();
        }
        if (C11296s.m67786J(this)) {
            this.f16538V = null;
            this.f21452m = null;
            this.f16548a0 = null;
            this.f16535T0 = null;
            mo19474g5();
            m28588o1("06008");
            C13612b.m81829B().m81848K(this.f16524O);
        } else {
            m19443c6();
        }
        SafeIntent safeIntent = new SafeIntent(getIntent());
        try {
            this.f14059t1 = (RecommendNeedData) safeIntent.getSerializableExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY);
            this.f14061v1 = (RecommendTipData) safeIntent.getSerializableExtra("recommend_tip_info_key");
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupSpaceGuideActivitty", e10.getMessage());
        }
        this.f14043A1 = safeIntent.getIntExtra(FamilyShareConstants.ENTRY_TYPE, -1);
        this.f14044B1 = safeIntent.getIntExtra(FamilyShareConstants.EXTRA_KEY, -1);
        RecommendTipData recommendTipData = this.f14061v1;
        if (recommendTipData != null) {
            this.f14062w1 = recommendTipData.getDialogPopTimesThreshold();
            C11839m.m70686d("CloudBackupSpaceGuideActivitty", "dialogPopTimesThreshold:" + this.f14062w1);
        } else {
            C11839m.m70688i("CloudBackupSpaceGuideActivitty", "recommendTipData is null");
        }
        m19469a6();
        m19467Y5(this.f14055p1);
    }

    /* renamed from: T5 */
    public void mo19461T5() {
        this.f14047h1 = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14048i1 = C12809f.m76829b(this, R$id.notch_fit_load_view);
        this.f14049j1 = C12809f.m76829b(this, R$id.cloud_space_guide_main_layout);
        this.f14050k1 = C12809f.m76829b(this, R$id.layout_loading);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nodata);
        this.f14051l1 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        View viewM76829b2 = C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f14052m1 = viewM76829b2;
        viewM76829b2.setOnClickListener(this);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f14053n1 = autoSizeButton;
        C11842p.m70874v1(this, autoSizeButton);
        this.f14053n1.setOnClickListener(this);
        this.f14054o1 = (TextView) C12809f.m76829b(this, R$id.cloud_space_guide_title);
        this.f14055p1 = (TextView) C12809f.m76829b(this, R$id.cloud_space_guide_main_text);
        this.f14060u1 = (HotTitleTextView) C12809f.m76829b(this, R$id.tv_free_space);
        this.f14057r1 = (RelativeLayout) C12809f.m76829b(this, R$id.rl_backup_option_content);
        this.f14058s1 = (RelativeLayout) C12809f.m76829b(this, R$id.rl_package_content);
        this.f14056q1 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        mo23770l1();
        m19468Z5();
    }

    /* renamed from: U5 */
    public void m19462U5() {
        startActivity(new Intent(this, (Class<?>) CloudSpaceUpgradeActivity.class));
    }

    /* renamed from: V5 */
    public final /* synthetic */ void m19463V5(CloudBackupSpaceGuideActivitty cloudBackupSpaceGuideActivitty, int i10, List list) {
        cloudBackupSpaceGuideActivitty.f14064y1 = (this.f16573t0 + i10) + list.size() >= this.f16572s0;
        cloudBackupSpaceGuideActivitty.m19465X5();
    }

    /* renamed from: W5 */
    public final void m19464W5(String str) {
        C12515a.m75110o().m75175e(new C3186a(str), false);
    }

    /* renamed from: X5 */
    public final void m19465X5() {
        if (!C0209d.m1166E1()) {
            C11839m.m70688i("CloudBackupSpaceGuideActivitty", "not owner user");
            return;
        }
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70688i("CloudBackupSpaceGuideActivitty", "refreshCampaignSuccess campagin can not show in child account");
            return;
        }
        if (!this.f14064y1) {
            C11839m.m70688i("CloudBackupSpaceGuideActivitty", "mAdsFlag false");
        } else if (TextUtils.isEmpty(this.f16570q0)) {
            C11839m.m70688i("CloudBackupSpaceGuideActivitty", "mResourceId is empty");
        } else {
            m19464W5(this.f16570q0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: Y2 */
    public void mo19466Y2() {
        C11839m.m70686d("CloudBackupSpaceGuideActivitty", "dealGetPackagesBySpaceRuleFail showView");
        this.f14063x1 = true;
        mo19479s5();
    }

    /* renamed from: Y5 */
    public void m19467Y5(TextView textView) {
        RecommendNeedData recommendNeedData = this.f14059t1;
        if (recommendNeedData == null) {
            C11839m.m70686d("CloudBackupSpaceGuideActivitty", " setDialogTextSecond recommendNeedData NULL");
            return;
        }
        String mainText = recommendNeedData.getMainText();
        long backupNeedSpace = this.f14059t1.getBackupNeedSpace();
        long notUsedSpace = this.f14059t1.getNotUsedSpace();
        C11839m.m70686d("CloudBackupSpaceGuideActivitty", "setDialogTextSecond backupNeedSpace =" + backupNeedSpace + " notUsedSpace=" + notUsedSpace);
        if (notUsedSpace < 0) {
            notUsedSpace = 0;
        }
        textView.setText(C10465b.m64293c(mainText, C0223k.m1524g(this, backupNeedSpace), getString(R$string.left_space, C0223k.m1524g(this, notUsedSpace))));
    }

    /* renamed from: Z5 */
    public void m19468Z5() {
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_nonet_icon));
        C11842p.m70760Q1(this, this.f14050k1);
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_no_service_icon));
    }

    /* renamed from: a6 */
    public final void m19469a6() throws Resources.NotFoundException {
        RecommendNeedData recommendNeedData = this.f14059t1;
        if (recommendNeedData == null) {
            C11839m.m70686d("CloudBackupSpaceGuideActivitty", " setDialogTextSecond recommendNeedData NULL");
            return;
        }
        String title = recommendNeedData.getTitle();
        Resources resources = getResources();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.cloud_space_22_sp);
        long jM16190y = C2783d.m16190y();
        String strValueOf = String.valueOf(jM16190y);
        if (TextUtils.isEmpty(title)) {
            this.f14054o1.setVisibility(8);
            return;
        }
        int i10 = (int) jM16190y;
        String strM64293c = C10465b.m64293c(title, resources.getQuantityString(R$plurals.cloud_backup_fail_days, i10, Integer.valueOf(i10)));
        int iIndexOf = strM64293c != null ? strM64293c.indexOf(strValueOf) : -1;
        if (iIndexOf < 0) {
            this.f14054o1.setText(strM64293c);
            return;
        }
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, dimensionPixelSize, ColorStateList.valueOf(resources.getColor(R$color.cloud_backup_fail_not_backup_days_color, null)), null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strM64293c);
        spannableStringBuilder.setSpan(textAppearanceSpan, iIndexOf, strValueOf.length() + iIndexOf, 34);
        this.f14054o1.setText(spannableStringBuilder);
    }

    /* renamed from: b6 */
    public final void m19470b6(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("CloudBackupSpaceGuideActivitty", "linkContent is empty");
            return;
        }
        C11839m.m70686d("CloudBackupSpaceGuideActivitty", "linkContent: " + str);
        HotTitleTextView hotTitleTextView = this.f14060u1;
        if (hotTitleTextView != null) {
            if (this.f14065z1) {
                hotTitleTextView.setRedDotVisibility(0);
            } else {
                hotTitleTextView.setRedDotVisibility(8);
            }
            this.f14060u1.setText(str);
            this.f14060u1.setOnClickListener(this);
        }
    }

    /* renamed from: d6 */
    public final void m19471d6(final int i10, final CloudBackupSpaceGuideActivitty cloudBackupSpaceGuideActivitty) {
        AdParametersExt adParametersExt = this.f16575v0;
        if (adParametersExt == null || !adParametersExt.isRequestAgdResource(0, null)) {
            cloudBackupSpaceGuideActivitty.f14064y1 = false;
            cloudBackupSpaceGuideActivitty.m19465X5();
        } else {
            C12515a.m75110o().m75175e(new C10221d1(new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.v2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f17770a.m19463V5(cloudBackupSpaceGuideActivitty, i10, (List) obj);
                }
            }, this.f16575v0.getAgdAdid()), false);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: e4 */
    public void mo19472e4(long j10) {
        if (HicloudH5ConfigManager.getInstance().getClientVersion() >= j10) {
            C11839m.m70688i("CloudBackupSpaceGuideActivitty", "preGetPpsAdsNum H5Config ClientVersion not updated ");
            m19459S5();
            return;
        }
        C11839m.m70686d("CloudBackupSpaceGuideActivitty", "preGetPpsAdsNum H5Config ClientVersion updated " + j10);
        C12515a.m75110o().m75172d(new C10257p1(this.f16524O, j10, 1002));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: f3 */
    public void mo19473f3(Object obj) {
        if (obj == null || !(obj instanceof UserPackage)) {
            C11839m.m70687e("CloudBackupSpaceGuideActivitty", "dealGetUserPackageSuccess obj is not UserPackage.");
            mo19477k5();
            return;
        }
        this.f21452m = (UserPackage) obj;
        RecommendNeedData recommendNeedData = this.f14059t1;
        if (recommendNeedData == null) {
            C11839m.m70687e("CloudBackupSpaceGuideActivitty", "dealGetUserPackageSuccess recommendNeedData is null.");
            return;
        }
        if (!"family_share".equals(recommendNeedData.getRecommendType())) {
            C11839m.m70686d("CloudBackupSpaceGuideActivitty", "dealGetUserPackageSuccess  showView");
            mo19479s5();
        } else {
            if (C11293p.m67757a(this.f21452m) == null) {
                C11839m.m70687e("CloudBackupSpaceGuideActivitty", "dealGetUserPackageSuccess effectivePackage is null.");
                return;
            }
            long jM67762f = C11293p.m67762f(this.f21452m);
            long used = this.f21452m.getUsed();
            if (jM67762f > used) {
                this.f14059t1.setTotalNeedSpace(jM67762f);
            } else {
                this.f14059t1.setTotalNeedSpace(used);
            }
            m19441O5();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        this.f14050k1.setVisibility(0);
        this.f14051l1.setVisibility(8);
        this.f14049j1.setVisibility(8);
        this.f14052m1.setVisibility(8);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14047h1);
        arrayList.add(this.f14049j1);
        arrayList.add(this.f14048i1);
        arrayList.add(this.f14056q1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() {
        this.f14049j1.setVisibility(0);
        this.f14050k1.setVisibility(8);
        this.f14051l1.setVisibility(8);
        this.f14052m1.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
        this.f14051l1.setVisibility(0);
        this.f14050k1.setVisibility(8);
        this.f14049j1.setVisibility(8);
        this.f14052m1.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
        this.f14050k1.setVisibility(0);
        this.f14051l1.setVisibility(8);
        this.f14049j1.setVisibility(8);
        this.f14052m1.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            com.huawei.hicloud.base.common.HiCloudSafeIntent r0 = new com.huawei.hicloud.base.common.HiCloudSafeIntent
            r0.<init>(r6)
            r6 = 10008(0x2718, float:1.4024E-41)
            if (r6 != r4) goto L15
            r6 = 0
            r3.f14065z1 = r6
            com.huawei.android.hicloud.ui.uiextend.HotTitleTextView r6 = r3.f14060u1
            if (r6 == 0) goto L15
            r1 = 8
            r6.setRedDotVisibility(r1)
        L15:
            r6 = -1
            if (r5 == r6) goto L6c
            java.lang.String r6 = "CloudBackupSpaceGuideActivitty"
            if (r5 == 0) goto L4f
            r1 = 1
            if (r5 == r1) goto L4f
            r1 = 201(0xc9, float:2.82E-43)
            if (r5 == r1) goto L2f
            r1 = 802(0x322, float:1.124E-42)
            if (r5 == r1) goto L2f
            switch(r5) {
                case 7101: goto L2f;
                case 7102: goto L2b;
                case 7103: goto L2f;
                default: goto L2a;
            }
        L2a:
            goto L6f
        L2b:
            r3.m19457R5()
            goto L6f
        L2f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "refresh data by requestCode:"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = ", resultCode:"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            p514o9.C11839m.m70686d(r6, r1)
            r3.mo19460T3()
            goto L6f
        L4f:
            r3.m28583a1()
            com.huawei.cloud.pay.model.GetClientUIConfigResp r1 = r3.f16538V
            if (r1 == 0) goto L63
            com.huawei.cloud.pay.model.UserPackage r1 = r3.f21452m
            if (r1 == 0) goto L63
            java.util.ArrayList<com.huawei.cloud.pay.model.FilterAvailabalGradePackage> r1 = r3.f16540W
            if (r1 != 0) goto L5f
            goto L63
        L5f:
            r3.mo19476h5()
            goto L6f
        L63:
            java.lang.String r4 = " data no prepare ok"
            p514o9.C11839m.m70686d(r6, r4)
            r3.mo19460T3()
            return
        L6c:
            r3.mo19453O4(r4, r0)
        L6f:
            super.onActivityResult(r4, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.CloudBackupSpaceGuideActivitty.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14046D1 = new HandlerC3187b(this);
        this.f14045C1 = new HandlerC3188c(this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public abstract void mo19479s5();
}
