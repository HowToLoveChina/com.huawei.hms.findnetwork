package com.huawei.android.hicloud.p088ui.activity;

import ae.C0180x0;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.dynamicfeature.plugin.language.LanguagePlugin;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceGuideForSpaceShareActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.HiCloudTextView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudSpaceShareUsageMemberAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.SpaceShareLinkClickListener;
import com.huawei.android.hicloud.p088ui.uiextend.TipPopupLayout;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.JoinShareCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.JoinSpaceShareDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceShareUpgradeCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceShareUpgradePackageDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.StopShareCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.StopShareDialog;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CalRefundFeeResp;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.base.bean.FamilyDetailInfoResult;
import com.huawei.hicloud.base.bean.FamilyShareInfoAndDetailResult;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.base.bean.RetResult;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.p103ui.uiextend.ScrollDisabledListView;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import dj.C9158a;
import fk.C9721b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0234s;
import p254eb.C9440a;
import p284fb.C9681b;
import p364ib.C10465b;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p664u0.C13108a;
import p732w8.C13553d;
import p732w8.C13572w;
import p737wd.ViewOnClickListenerC13589b;
import p783xp.C13843a;
import sk.C12809f;
import tm.C13040c;

/* loaded from: classes3.dex */
public class CloudSpaceShareActivity extends CloudSpaceShareBaseActivity implements View.OnClickListener, JoinShareCallback, StopShareCallback, SpaceShareUpgradeCallback {

    /* renamed from: A0 */
    public AutoSizeButton f14529A0;

    /* renamed from: B0 */
    public AutoSizeButton f14530B0;

    /* renamed from: C0 */
    public TextView f14531C0;

    /* renamed from: D0 */
    public TextView f14532D0;

    /* renamed from: E0 */
    public NotchFitLinearLayout f14533E0;

    /* renamed from: F0 */
    public AutoSizeButton f14534F0;

    /* renamed from: G0 */
    public AutoSizeButton f14535G0;

    /* renamed from: H0 */
    public AutoSizeButton f14536H0;

    /* renamed from: I0 */
    public AutoSizeButton f14537I0;

    /* renamed from: J0 */
    public HwProgressBar f14538J0;

    /* renamed from: K0 */
    public HwProgressBar f14539K0;

    /* renamed from: L0 */
    public AutoSizeButton f14540L0;

    /* renamed from: M0 */
    public TipPopupLayout f14541M0;

    /* renamed from: P0 */
    public JoinSpaceShareDialog f14544P0;

    /* renamed from: Q0 */
    public String f14545Q0;

    /* renamed from: R0 */
    public int f14546R0;

    /* renamed from: S */
    public Context f14547S;

    /* renamed from: S0 */
    public int f14548S0;

    /* renamed from: T */
    public NotchFitLinearLayout f14549T;

    /* renamed from: T0 */
    public long f14550T0;

    /* renamed from: U */
    public LinearLayout f14551U;

    /* renamed from: U0 */
    public int f14552U0;

    /* renamed from: V */
    public View f14553V;

    /* renamed from: V0 */
    public FamilyDetailInfoResult f14554V0;

    /* renamed from: W */
    public View f14555W;

    /* renamed from: W0 */
    public GetFamilySharOmConfigReceiver f14556W0;

    /* renamed from: X */
    public ImageView f14557X;

    /* renamed from: Y */
    public ImageView f14559Y;

    /* renamed from: Y0 */
    public FamilyShareInfoAndDetailResult f14560Y0;

    /* renamed from: Z */
    public View f14561Z;

    /* renamed from: a0 */
    public View f14563a0;

    /* renamed from: b0 */
    public ImageView f14565b0;

    /* renamed from: b1 */
    public SpaceShareUpgradePackageDialog f14566b1;

    /* renamed from: c0 */
    public ImageView f14567c0;

    /* renamed from: d0 */
    public RelativeLayout f14569d0;

    /* renamed from: e0 */
    public RelativeLayout f14571e0;

    /* renamed from: f0 */
    public RelativeLayout f14573f0;

    /* renamed from: g0 */
    public NotchFitRelativeLayout f14574g0;

    /* renamed from: h0 */
    public LinearLayout f14575h0;

    /* renamed from: i0 */
    public NotchFitRelativeLayout f14576i0;

    /* renamed from: j0 */
    public LinearLayout f14577j0;

    /* renamed from: k0 */
    public RelativeLayout f14578k0;

    /* renamed from: l0 */
    public RelativeLayout f14579l0;

    /* renamed from: m0 */
    public NotchFitLinearLayout f14580m0;

    /* renamed from: n0 */
    public NotchFitRelativeLayout f14581n0;

    /* renamed from: o0 */
    public TextView f14582o0;

    /* renamed from: p0 */
    public TextView f14583p0;

    /* renamed from: q0 */
    public SpanClickText f14584q0;

    /* renamed from: r0 */
    public SpanClickText f14585r0;

    /* renamed from: s0 */
    public SpanClickText f14586s0;

    /* renamed from: t0 */
    public SpanClickText f14587t0;

    /* renamed from: u0 */
    public LinearLayout f14588u0;

    /* renamed from: v0 */
    public LinearLayout f14589v0;

    /* renamed from: w0 */
    public HiCloudTextView f14590w0;

    /* renamed from: x0 */
    public HiCloudTextView f14591x0;

    /* renamed from: y0 */
    public LinearLayout f14592y0;

    /* renamed from: z0 */
    public LinearLayout f14593z0;

    /* renamed from: N0 */
    public int f14542N0 = 1;

    /* renamed from: O0 */
    public FamilyShareInfoResult f14543O0 = new FamilyShareInfoResult();

    /* renamed from: X0 */
    public boolean f14558X0 = false;

    /* renamed from: Z0 */
    public boolean f14562Z0 = false;

    /* renamed from: a1 */
    public long f14564a1 = -1;

    /* renamed from: c1 */
    public boolean f14568c1 = false;

    /* renamed from: d1 */
    public boolean f14570d1 = false;

    /* renamed from: e1 */
    public Handler f14572e1 = new HandlerC3251a();

    public class GetFamilySharOmConfigReceiver extends BroadcastReceiver {
        public GetFamilySharOmConfigReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && FamilyShareConstants.BroadCast.FAMILY_SHARE_OM_CONFIG_DOWNLOAD_FINISHED_ACTION.equals(new SafeIntent(intent).getAction()) && CloudSpaceShareActivity.this.f14558X0) {
                C11839m.m70688i("CloudSpaceShareActivity", "familyshare string download finish");
                CloudSpaceShareActivity.this.f14558X0 = false;
                if (CloudSpaceShareActivity.this.f14572e1 != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 2015;
                    CloudSpaceShareActivity.this.f14572e1.sendMessage(messageObtain);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudSpaceShareActivity$a */
    public class HandlerC3251a extends Handler {
        public HandlerC3251a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (CloudSpaceShareActivity.this.isFinishing() || CloudSpaceShareActivity.this.isDestroyed()) {
                C11839m.m70687e("CloudSpaceShareActivity", "the activity is not avaiable");
                return;
            }
            int i10 = message.what;
            if (i10 == 2010 || i10 == 2011) {
                CloudSpaceShareActivity.this.m20167N2(message);
                return;
            }
            if (i10 == 6013) {
                CloudSpaceShareActivity.this.m20166M2(message.obj);
                return;
            }
            if (i10 == 6014) {
                CloudSpaceShareActivity.this.m20165L2(message);
                return;
            }
            if (i10 == 2012) {
                C11839m.m70687e("CloudSpaceShareActivity", "destroy family share image");
                if (CloudSpaceShareActivity.this.m20177X2()) {
                    CloudSpaceShareActivity.this.finish();
                    return;
                }
                return;
            }
            if (i10 == 2001) {
                C11839m.m70688i("CloudSpaceShareActivity", "get userpackage success");
                CloudSpaceShareActivity.this.mo20172S2(message);
            } else {
                if (i10 == 2101) {
                    CloudSpaceShareActivity.this.mo20171R2(message);
                    return;
                }
                if (i10 == 2013) {
                    CloudSpaceShareActivity.this.m20168O2(message);
                } else if (i10 == 2015) {
                    CloudSpaceShareActivity.this.m20169P2();
                } else {
                    CloudSpaceShareActivity.this.m20179Z2(i10, message);
                }
            }
        }
    }

    /* renamed from: f3 */
    private void m20160f3() {
        this.f14549T = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.port_family_share_loading_frame);
        this.f14551U = (LinearLayout) C12809f.m76829b(this, R$id.land_family_share_loading_frame);
        this.f14553V = C12809f.m76829b(this, R$id.port_family_share_bg_frame);
        this.f14555W = C12809f.m76829b(this, R$id.land_family_share_bg_frame);
        this.f14557X = (ImageView) C12809f.m76829b(this, R$id.port_family_share_bg);
        this.f14559Y = (ImageView) C12809f.m76829b(this, R$id.land_family_share_bg);
        this.f14561Z = C12809f.m76829b(this, R$id.port_iv_open_family_share_frame);
        this.f14563a0 = C12809f.m76829b(this, R$id.land_iv_open_family_share_frame);
        this.f14565b0 = (ImageView) C12809f.m76829b(this, R$id.port_iv_open_family_share);
        this.f14567c0 = (ImageView) C12809f.m76829b(this, R$id.land_iv_open_family_share);
        this.f14569d0 = (RelativeLayout) C12809f.m76829b(this, R$id.space_share_info_content);
        this.f14571e0 = (RelativeLayout) C12809f.m76829b(this, R$id.port_loading_button);
        this.f14573f0 = (RelativeLayout) C12809f.m76829b(this, R$id.land_loading_button);
        this.f14533E0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.loading_layout);
        this.f14578k0 = (RelativeLayout) C12809f.m76829b(this, R$id.port_cloud_space_share_status_frame);
        this.f14579l0 = (RelativeLayout) C12809f.m76829b(this, R$id.land_cloud_space_share_status_frame);
        this.f14580m0 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.port_btn_open_space_share_frame);
        this.f14581n0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.port_top_describe_frame);
        this.f14582o0 = (TextView) C12809f.m76829b(this, R$id.port_cloud_space_share_top_title);
        this.f14583p0 = (TextView) C12809f.m76829b(this, R$id.land_cloud_space_share_top_title);
        this.f14584q0 = (SpanClickText) C12809f.m76829b(this, R$id.port_space_share_info_desc);
        this.f14585r0 = (SpanClickText) C12809f.m76829b(this, R$id.land_space_share_info_desc);
        this.f14586s0 = (SpanClickText) C12809f.m76829b(this, R$id.port_learn_more);
        this.f14587t0 = (SpanClickText) C12809f.m76829b(this, R$id.land_learn_more);
        this.f14588u0 = (LinearLayout) C12809f.m76829b(this, R$id.port_open_space_share_frame);
        this.f14589v0 = (LinearLayout) C12809f.m76829b(this, R$id.land_open_space_share_frame);
        this.f14590w0 = (HiCloudTextView) C12809f.m76829b(this, R$id.port_open_later);
        this.f14591x0 = (HiCloudTextView) C12809f.m76829b(this, R$id.land_open_later);
        this.f14592y0 = (LinearLayout) C12809f.m76829b(this, R$id.port_join_or_not_frame);
        this.f14593z0 = (LinearLayout) C12809f.m76829b(this, R$id.land_join_or_not_frame);
        this.f14529A0 = (AutoSizeButton) C12809f.m76829b(this, R$id.port_join_space_share_button);
        this.f14530B0 = (AutoSizeButton) C12809f.m76829b(this, R$id.land_join_space_share_button);
        this.f14531C0 = (TextView) C12809f.m76829b(this, R$id.port_no_join);
        this.f14532D0 = (TextView) C12809f.m76829b(this, R$id.land_no_join);
        this.f14534F0 = (AutoSizeButton) C12809f.m76829b(this, R$id.port_continue_button);
        this.f14535G0 = (AutoSizeButton) C12809f.m76829b(this, R$id.land_continue_button);
        this.f14538J0 = (HwProgressBar) C12809f.m76829b(this, R$id.port_continue_progress);
        this.f14539K0 = (HwProgressBar) C12809f.m76829b(this, R$id.land_continue_progress);
        this.f14536H0 = (AutoSizeButton) C12809f.m76829b(this, R$id.port_btn_finish_open_space_share);
        this.f14537I0 = (AutoSizeButton) C12809f.m76829b(this, R$id.land_btn_finish_open_space_share);
        this.f14574g0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_no_net);
        this.f14575h0 = (LinearLayout) C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f14576i0 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_unable_link_server);
        this.f14577j0 = (LinearLayout) C12809f.m76829b(this, R$id.layout_nodata);
        this.f14540L0 = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f14614p = (RelativeLayout) C12809f.m76829b(this, R$id.cloud_space_share_usage_frame);
        this.f14615q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.btn_use_space_share_frame);
        this.f14616r = (AutoSizeButton) C12809f.m76829b(this, R$id.continue_button);
        this.f14617s = (AutoSizeButton) C12809f.m76829b(this, R$id.stop_button);
        this.f14618t = (HwProgressBar) C12809f.m76829b(this, R$id.continue_progress);
        C11842p.m70874v1(this, this.f14616r);
        C11842p.m70874v1(this, this.f14617s);
        this.f14619u = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.usage_detail_frame);
        this.f14623y = (TextView) C12809f.m76829b(this, R$id.space_usage_amount);
        this.f14596A = (TextView) C12809f.m76829b(this, R$id.who_space_share);
        this.f14620v = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.family_member_num_frame);
        this.f14624z = (TextView) C12809f.m76829b(this, R$id.family_member_num);
        this.f14621w = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.notch_family_member_detail_frame);
        this.f14622x = (ScrollDisabledListView) C12809f.m76829b(this, R$id.space_share_member_list);
        C11842p.m70891z2(this, this.f14614p);
        C11842p.m70891z2(this, this.f14533E0);
        m20187i3();
        m20195p3();
        CloudSpaceShareUsageMemberAdapter cloudSpaceShareUsageMemberAdapter = new CloudSpaceShareUsageMemberAdapter(this);
        this.f14605J = cloudSpaceShareUsageMemberAdapter;
        this.f14622x.setAdapter((ListAdapter) cloudSpaceShareUsageMemberAdapter);
        TipPopupLayout tipPopupLayout = (TipPopupLayout) C12809f.m76829b(this, R$id.family_share_num_not_enough);
        this.f14541M0 = tipPopupLayout;
        tipPopupLayout.setOnClickListener(this);
        this.f14541M0.setVisibility(8);
    }

    /* renamed from: A3 */
    public final void m20161A3(String str) {
        if (this.f14547S == null) {
            return;
        }
        SpaceShareUpgradePackageDialog spaceShareUpgradePackageDialog = this.f14566b1;
        if (spaceShareUpgradePackageDialog != null) {
            spaceShareUpgradePackageDialog.dismiss();
            this.f14566b1 = null;
        }
        SpaceShareUpgradePackageDialog spaceShareUpgradePackageDialog2 = new SpaceShareUpgradePackageDialog(this.f14547S, this, getString(R$string.upgrade_now), getString(R$string.cloudbackup_btn_cancel));
        this.f14566b1 = spaceShareUpgradePackageDialog2;
        spaceShareUpgradePackageDialog2.showDialog(str);
    }

    /* renamed from: B3 */
    public final void m20162B3() {
        if (this.f14556W0 != null) {
            C13108a.m78878b(this).m78883f(this.f14556W0);
        }
    }

    /* renamed from: J2 */
    public void m20163J2() {
        FamilyDetailInfoResult familyDetailInfoResult = this.f14554V0;
        if (familyDetailInfoResult == null || familyDetailInfoResult.getRetBody() == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "familydetailinforesult or retBody is null");
            m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.GET_FAMILY_DETAIL_INFO, FamilyShareConstants.Report.SPACE_SHARE_RESULT_FAILED, -1);
            m20204x3(8, 8, 8, 8, 0, 8);
        } else {
            m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.GET_FAMILY_DETAIL_INFO, FamilyShareConstants.Report.SPACE_SHARE_RESULT_SUCCESS, 0);
            if (m20217U1()) {
                return;
            }
            m20225c2(this.f14554V0.getRetBody(), this.f14572e1);
        }
    }

    /* renamed from: K2 */
    public final void m20164K2(String str) {
        if (this.f14547S == null) {
            return;
        }
        JoinSpaceShareDialog joinSpaceShareDialog = this.f14544P0;
        if (joinSpaceShareDialog != null) {
            joinSpaceShareDialog.dismiss();
            this.f14544P0 = null;
        }
        JoinSpaceShareDialog joinSpaceShareDialog2 = new JoinSpaceShareDialog(this.f14547S, this, getString(R$string.cloudbackup_btn_ok), getString(R$string.cloudbackup_btn_cancel));
        this.f14544P0 = joinSpaceShareDialog2;
        joinSpaceShareDialog2.showDialog(str, getString(R$string.confirm_join_family_cloud_space));
    }

    /* renamed from: L2 */
    public final void m20165L2(Message message) {
        m20206y3(true);
        if (message == null) {
            return;
        }
        m20234l2();
        C11839m.m70688i("CloudSpaceShareActivity", "calRefundFee fail code = " + message.arg1);
    }

    /* renamed from: M2 */
    public final void m20166M2(Object obj) {
        C11839m.m70688i("CloudSpaceShareActivity", "calRefundFee success");
        m20206y3(true);
        if (obj == null || !(obj instanceof CalRefundFeeResp)) {
            C11839m.m70687e("CloudSpaceShareActivity", "dealCalRefundFeeSuccess object invalid.");
            return;
        }
        int calResult = ((CalRefundFeeResp) obj).getCalResult();
        if (calResult == 2 || calResult == 3 || calResult == 4) {
            m20164K2(getString(R$string.family_share_refund_content));
        }
        if (calResult == 1) {
            C11839m.m70688i("CloudSpaceShareActivity", "calrefundfee no order.");
            onConfirmed();
        }
    }

    /* renamed from: N2 */
    public final void m20167N2(Message message) {
        int i10 = message.what;
        if (i10 != 2010) {
            m20207z3(true);
            m20234l2();
            C11839m.m70688i("CloudSpaceShareActivity", "enable Space Share failed " + i10);
            m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.ENABLE_FAMILY_SHARE, FamilyShareConstants.Report.SPACE_SHARE_RESULT_FAILED, -1);
            return;
        }
        RetResult retResult = (RetResult) message.obj;
        if (retResult == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "enable space share failed,response null");
            return;
        }
        int retCode = retResult.getRetCode();
        C11839m.m70688i("CloudSpaceShareActivity", "enable Space Share,retcode:" + retCode);
        m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.ENABLE_FAMILY_SHARE, FamilyShareConstants.Report.SPACE_SHARE_RESULT_SUCCESS, retCode);
        if (retCode == 0) {
            C11839m.m70688i("CloudSpaceShareActivity", "enable Space Share success ");
            m20202w3();
            if (m20200u3(3)) {
                m20204x3(8, 8, 0, 8, 8, 8);
                return;
            }
            return;
        }
        if (1011 == retCode) {
            m20207z3(true);
            m20204x3(8, 0, 8, 8, 8, 8);
            m20226d2(this.f14572e1);
            return;
        }
        if (1010 == retCode) {
            setResult(101);
            if (this.f14607L == 4) {
                C10465b.m64300j(this);
            }
            finish();
            return;
        }
        if (1013 == retCode) {
            m20207z3(true);
            m20204x3(8, 0, 8, 8, 8, 8);
            m20226d2(this.f14572e1);
        } else {
            if (1008 == retCode) {
                finish();
                return;
            }
            if (1014 != retCode) {
                m20207z3(true);
                m20234l2();
            } else {
                m20207z3(true);
                ViewOnClickListenerC13589b viewOnClickListenerC13589b = new ViewOnClickListenerC13589b(this, this.f14572e1, 2010);
                viewOnClickListenerC13589b.setCancelable(false);
                viewOnClickListenerC13589b.show();
            }
        }
    }

    /* renamed from: O2 */
    public final void m20168O2(Message message) {
        FamilyShareInfoAndDetailResult familyShareInfoAndDetailResult = (FamilyShareInfoAndDetailResult) message.obj;
        this.f14560Y0 = familyShareInfoAndDetailResult;
        if (familyShareInfoAndDetailResult != null) {
            m20169P2();
            return;
        }
        C11839m.m70688i("CloudSpaceShareActivity", "get space share info and detail failed,response null");
        mo20189k3();
        m20204x3(8, 8, 8, 8, 0, 8);
        m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.GET_FAMILY_SHARE_INFO, FamilyShareConstants.Report.SPACE_SHARE_RESULT_FAILED, -1);
        m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.GET_FAMILY_DETAIL_INFO, FamilyShareConstants.Report.SPACE_SHARE_RESULT_FAILED, -1);
    }

    /* renamed from: P2 */
    public final void m20169P2() {
        FamilyShareInfoAndDetailResult familyShareInfoAndDetailResult = this.f14560Y0;
        if (familyShareInfoAndDetailResult == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "space share info and detail is null");
        } else {
            this.f14554V0 = familyShareInfoAndDetailResult.getFamilyDetailInfoResult();
            mo20170Q2(this.f14560Y0.getFamilyShareInfoResult());
        }
    }

    /* renamed from: Q2 */
    public void mo20170Q2(FamilyShareInfoResult familyShareInfoResult) {
        if (familyShareInfoResult == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "get space share info failed,response null");
            m20204x3(8, 8, 8, 8, 0, 8);
            m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.GET_FAMILY_SHARE_INFO, FamilyShareConstants.Report.SPACE_SHARE_RESULT_FAILED, -1);
            return;
        }
        int retCode = familyShareInfoResult.getRetCode();
        C11839m.m70688i("CloudSpaceShareActivity", "getshareinfo,retcode:" + retCode);
        if (retCode != 0) {
            m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.GET_FAMILY_SHARE_INFO, FamilyShareConstants.Report.SPACE_SHARE_RESULT_FAILED, retCode);
            m20204x3(8, 8, 8, 8, 0, 8);
            return;
        }
        C11839m.m70688i("CloudSpaceShareActivity", "getshareinfo success");
        m20227e2(this.f14607L, this.f14608M, FamilyShareConstants.Report.GET_FAMILY_SHARE_INFO, FamilyShareConstants.Report.SPACE_SHARE_RESULT_SUCCESS, retCode);
        this.f14543O0 = familyShareInfoResult;
        this.f14597B = familyShareInfoResult.getFamilyShareEnable();
        this.f14598C = this.f14543O0.getSpaceShareEnable();
        this.f14599D = this.f14543O0.getSpaceShareRole();
        this.f14600E = this.f14543O0.getCanSpaceShareEnable();
        this.f14602G = this.f14543O0.getSpaceShareOwner();
        this.f14601F = this.f14543O0.getPurchased();
        C11839m.m70688i("CloudSpaceShareActivity", "space share status, familyShareEnable: " + this.f14597B + " spaceShareEnable: " + this.f14598C + " spaceShareRole: " + this.f14599D + " canSpaceShareEnable: " + this.f14600E);
        C10465b.m64309s(familyShareInfoResult);
        if (this.f14597B == 0) {
            if (this.f14607L == 4) {
                C10465b.m64300j(this);
            }
            C11839m.m70688i("CloudSpaceShareActivity", "familyshareenable not open");
            Toast.makeText(this, R$string.space_share_has_quited, 1).show();
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
            finish();
            return;
        }
        if (this.f14598C == 1) {
            this.f14606K = false;
            if (this.f14599D == 1) {
                this.f14605J = new C0180x0(this, this.f14572e1);
            } else {
                this.f14605J = new CloudSpaceShareUsageMemberAdapter(this);
            }
            this.f14622x.setAdapter((ListAdapter) this.f14605J);
            m20163J2();
        } else {
            m20192n3();
        }
        if (familyShareInfoResult.getLimitationTip() >= 0) {
            this.f14541M0.setImageViewPic(R$drawable.ic_about_option);
            this.f14541M0.setFamliyShareNumNotEnough(true);
            this.f14541M0.setFamliyShareMaxNum(familyShareInfoResult.getShareLimit());
            this.f14541M0.setVisibility(0);
        }
    }

    /* renamed from: R2 */
    public void mo20171R2(Message message) {
        m20204x3(8, 8, 8, 8, 0, 8);
        C11839m.m70688i("CloudSpaceShareActivity", "calRefundFee fail code = " + message.arg1);
    }

    /* renamed from: S2 */
    public void mo20172S2(Message message) {
        Object obj = message.obj;
        if (obj == null || !(obj instanceof UserPackage)) {
            m20204x3(8, 8, 8, 8, 0, 8);
            return;
        }
        UserPackage userPackage = (UserPackage) obj;
        int userPayType = userPackage.getUserPayType();
        C11839m.m70686d("CloudSpaceShareActivity", "getuserpackage,userPayType:" + userPayType);
        if (this.f14562Z0) {
            if (userPayType != 0 || C11293p.m67770n(userPackage)) {
                C12515a.m75110o().m75175e(new C13572w(this.f14572e1, new long[]{this.f14564a1}), false);
                return;
            } else {
                m20161A3(getString(R$string.need_to_upgrade_space_for_family, 200));
                return;
            }
        }
        this.f14550T0 = userPackage.getTotalCapacity();
        C11839m.m70688i("CloudSpaceShareActivity", "getuserpackage,capacity:" + this.f14550T0);
        if (m20200u3(4)) {
            m20204x3(8, 8, 0, 8, 8, 8);
        }
    }

    /* renamed from: T2 */
    public final void m20173T2() {
        C11839m.m70688i("CloudSpaceShareActivity", "enableSpaceShare");
        C12515a.m75110o().m75172d(new C13553d(this.f14572e1));
    }

    /* renamed from: U2 */
    public final void m20174U2() {
        if (1 == this.f14542N0) {
            C11839m.m70688i("CloudSpaceShareActivity", "space satisfaction");
            if (m20186h3()) {
                return;
            }
            m20207z3(false);
            m20173T2();
        }
    }

    /* renamed from: V2 */
    public final void m20175V2(Message message) {
        Object obj = message.obj;
        if (obj != null) {
            this.f14564a1 = ((Long) obj).longValue();
        }
        C11060c c11060c = new C11060c();
        c11060c.m66664t("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        C9158a.m57503F().m57516N(this.f14572e1, c11060c, false, "CloudSpaceShareActivity");
    }

    /* renamed from: W2 */
    public final boolean m20176W2() {
        if (this.f14607L != 6) {
            return false;
        }
        C10465b.m64301k(this, 0);
        C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_SPACE_SHARE_STOP_NOTICE);
        finish();
        return true;
    }

    /* renamed from: X2 */
    public final boolean m20177X2() throws Throwable {
        C9440a c9440aM60496q = C9681b.m60470l().m60496q();
        String strM59209a = c9440aM60496q.m59209a();
        String strM59214f = c9440aM60496q.m59214f();
        String strM59211c = c9440aM60496q.m59211c();
        if (m20209M1(strM59209a) || m20209M1(strM59214f) || m20209M1(strM59211c)) {
            C11839m.m70687e("CloudSpaceShareActivity", "gotoCloudSpaceGuide setViewStringByType title or content or btntext is null");
            mo20203x2();
            return false;
        }
        Intent intent = new Intent();
        RecommendNeedData recommendNeedData = new RecommendNeedData();
        recommendNeedData.setTitle(strM59214f);
        recommendNeedData.setMainText(strM59209a);
        recommendNeedData.setChooseOtherCaseText(strM59211c);
        recommendNeedData.setRecommendType("family_share");
        intent.putExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY, recommendNeedData);
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, this.f14607L);
        intent.putExtra(FamilyShareConstants.EXTRA_KEY, this.f14608M);
        intent.setClass(this, CloudSpaceGuideForSpaceShareActivity.class);
        startActivity(intent);
        return true;
    }

    /* renamed from: Y2 */
    public final void m20178Y2() {
        C10465b.m64301k(this, this.f14608M);
    }

    /* renamed from: Z2 */
    public final void m20179Z2(int i10, Message message) {
        if (i10 == 2004 || i10 == 2005) {
            m20211O1(message, FamilyShareConstants.Report.DISABLE_FAMILY_SHARE, this.f14572e1);
            return;
        }
        if (i10 == 2006 || i10 == 2007) {
            m20216T1(message, FamilyShareConstants.Report.QUIT_FAMILY_SHARE, this.f14572e1);
            C11296s.m67820i0(C0213f.m1377a());
            return;
        }
        if (i10 == 2000 || i10 == 2001 || i10 == 2020) {
            mo20215S1(message, this.f14572e1);
            C11296s.m67820i0(C0213f.m1377a());
            return;
        }
        if (i10 == 2016 || i10 == 2017) {
            C11839m.m70688i("CloudSpaceShareActivity", "INVITE_FAMILY_MEMBER status:" + i10);
            m20212P1(message, this.f14572e1);
            return;
        }
        if (i10 == 2019) {
            this.f14562Z0 = true;
            m20175V2(message);
            return;
        }
        if (i10 != 2021) {
            C11839m.m70688i("CloudSpaceShareActivity", "other status:" + i10);
            return;
        }
        if (this.f14607L == 2) {
            finish();
        } else {
            startActivity(new Intent(this, (Class<?>) HisyncSpaceDetailActivity.class));
            finish();
        }
    }

    /* renamed from: a3 */
    public final void m20180a3() {
        if (this.f14556W0 == null) {
            this.f14556W0 = new GetFamilySharOmConfigReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(FamilyShareConstants.BroadCast.FAMILY_SHARE_OM_CONFIG_DOWNLOAD_FINISHED_ACTION);
            C13108a.m78878b(this).m78880c(this.f14556W0, intentFilter);
        }
    }

    /* renamed from: b3 */
    public void m20181b3() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(displayMetrics);
        C11842p.m70851p2(this, this.f14553V, displayMetrics);
        C11842p.m70851p2(this, this.f14555W, displayMetrics);
        C11842p.m70859r2(this, this.f14557X, displayMetrics);
        C11842p.m70859r2(this, this.f14559Y, displayMetrics);
        C11842p.m70851p2(this, this.f14561Z, displayMetrics);
        C11842p.m70851p2(this, this.f14563a0, displayMetrics);
        C11842p.m70859r2(this, this.f14565b0, displayMetrics);
        C11842p.m70859r2(this, this.f14567c0, displayMetrics);
        RelativeLayout relativeLayout = this.f14569d0;
        if (relativeLayout != null) {
            C11842p.m70827j2(relativeLayout, C11842p.m70852q(this));
        }
    }

    /* renamed from: c3 */
    public final void m20182c3() {
        this.f14534F0.setOnClickListener(this);
        this.f14535G0.setOnClickListener(this);
        this.f14590w0.setOnClickListener(this);
        this.f14591x0.setOnClickListener(this);
        this.f14529A0.setOnClickListener(this);
        this.f14530B0.setOnClickListener(this);
        this.f14531C0.setOnClickListener(this);
        this.f14532D0.setOnClickListener(this);
        this.f14536H0.setOnClickListener(this);
        this.f14537I0.setOnClickListener(this);
        this.f14574g0.setOnClickListener(this);
        this.f14576i0.setOnClickListener(this);
        this.f14540L0.setOnClickListener(this);
        this.f14616r.setOnClickListener(this);
        this.f14617s.setOnClickListener(this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14549T);
        arrayList.add(this.f14533E0);
        arrayList.add(this.f14581n0);
        arrayList.add(this.f14580m0);
        arrayList.add(this.f14574g0);
        arrayList.add(this.f14576i0);
        arrayList.add(this.f14615q);
        arrayList.add(this.f14619u);
        arrayList.add(this.f14620v);
        arrayList.add(this.f14621w);
        return arrayList;
    }

    /* renamed from: d3 */
    public final void m20183d3() {
        C11839m.m70688i("CloudSpaceShareActivity", "layoutImageview:port or foldablescreenexpand");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        C11842p.m70871u2(this, this.f14557X, displayMetrics);
        C11842p.m70871u2(this, this.f14559Y, displayMetrics);
        C11842p.m70871u2(this, this.f14565b0, displayMetrics);
        C11842p.m70871u2(this, this.f14567c0, displayMetrics);
        if (C11842p.m70774V0(this)) {
            return;
        }
        C11842p.m70847o2(this, this.f14553V, displayMetrics);
        C11842p.m70847o2(this, this.f14555W, displayMetrics);
        C11842p.m70847o2(this, this.f14561Z, displayMetrics);
        C11842p.m70847o2(this, this.f14563a0, displayMetrics);
    }

    /* renamed from: e3 */
    public final void m20184e3(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(str);
        }
    }

    /* renamed from: g3 */
    public final void m20185g3() {
        C11839m.m70688i("CloudSpaceShareActivity", "initdata");
        m20180a3();
        m20204x3(8, 0, 8, 8, 8, 8);
        if (C10465b.m64303m()) {
            C11839m.m70688i("CloudSpaceShareActivity", "familyshare string is loading");
            this.f14558X0 = true;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f14607L = hiCloudSafeIntent.getIntExtra(FamilyShareConstants.ENTRY_TYPE, 1);
        this.f14608M = hiCloudSafeIntent.getIntExtra(FamilyShareConstants.EXTRA_KEY, -1);
        C11839m.m70688i("CloudSpaceShareActivity", "entry type:" + this.f14607L);
        if (m20176W2()) {
            return;
        }
        m20226d2(this.f14572e1);
    }

    /* renamed from: h3 */
    public boolean m20186h3() {
        if (C0209d.m1333z1(this)) {
            return false;
        }
        C11839m.m70688i("CloudSpaceShareActivity", "network no connected");
        m20204x3(8, 8, 8, 0, 8, 8);
        return true;
    }

    /* renamed from: i3 */
    public final void m20187i3() {
        if (!C11842p.m70753O0(this) || C11842p.m70747M0(this)) {
            m20183d3();
            return;
        }
        C11839m.m70688i("CloudSpaceShareActivity", "layoutImageview:land");
        if (C11842p.m70762R0()) {
            m20183d3();
        } else {
            m20181b3();
        }
    }

    /* renamed from: j3 */
    public final void m20188j3(int i10) {
        if (i10 == R$id.port_btn_finish_open_space_share || i10 == R$id.land_btn_finish_open_space_share) {
            m20193o3();
            return;
        }
        if (i10 == R$id.notch_fit_unable_link_server || i10 == R$id.notch_fit_no_net) {
            m20204x3(8, 0, 8, 8, 8, 8);
            m20226d2(this.f14572e1);
            return;
        }
        if (i10 == R$id.set_no_net_btn) {
            C11829c.m70612r1(this);
            return;
        }
        if (i10 != R$id.continue_button) {
            if (i10 == R$id.stop_button) {
                C11839m.m70688i("CloudSpaceShareActivity", "stop space share");
                if (m20186h3()) {
                    return;
                }
                m20243v2(this);
                return;
            }
            return;
        }
        C11839m.m70688i("CloudSpaceShareActivity", "join space share");
        C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_JOIN_BUTTON);
        C11839m.m70688i("CloudSpaceShareActivity", "purchased status :" + this.f14601F);
        if (m20186h3()) {
            return;
        }
        C11839m.m70688i("CloudSpaceShareActivity", "purchased status no");
        m20239r2(false);
        m20245z2(this.f14572e1);
    }

    /* renamed from: k3 */
    public void mo20189k3() {
    }

    /* renamed from: l3 */
    public void mo20190l3() {
        C11839m.m70688i("CloudSpaceShareActivity", "not join space share,finish");
        C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_NOT_JOIN_HAS_PURCHASED_BUTTON);
        finish();
    }

    /* renamed from: m3 */
    public void m20191m3(int i10, String str) {
        Intent intentM64291a = C10465b.m64291a(i10, str);
        int i11 = this.f14552U0 == 0 ? 1 : 2;
        C11839m.m70689w("CloudSpaceShareActivity", "onResultAndFinish, resultCode: " + i11 + ", errorCode: " + i10 + ", errorDesc: " + str);
        setResult(i11, intentM64291a);
        finish();
    }

    /* renamed from: n3 */
    public final void m20192n3() {
        if (this.f14602G == -1) {
            if (this.f14600E == 0) {
                C11839m.m70688i("CloudSpaceShareActivity", "space not satisfaction,first open cloudspace share ");
                this.f14542N0 = 2;
                m20204x3(0, 8, 8, 8, 8, 8);
                this.f14572e1.sendEmptyMessageDelayed(2012, 500L);
                return;
            }
            C11839m.m70688i("CloudSpaceShareActivity", "space satisfaction,first open cloudspace share ");
            m20201v3(true);
            this.f14542N0 = 1;
            if (m20200u3(2)) {
                m20204x3(8, 8, 0, 8, 8, 8);
                return;
            }
            return;
        }
        if (this.f14570d1) {
            this.f14570d1 = false;
            C9158a.m57503F().m57533c(this.f14572e1, 1);
            return;
        }
        if (this.f14606K) {
            m20163J2();
            return;
        }
        if (this.f14601F == 0) {
            C11839m.m70688i("CloudSpaceShareActivity", "no purchased,use cloudspace share ");
            this.f14606K = false;
            m20163J2();
            return;
        }
        C11839m.m70688i("CloudSpaceShareActivity", "purchased,use cloudspace share ");
        m20201v3(false);
        this.f14562Z0 = false;
        C11060c c11060c = new C11060c();
        c11060c.m66664t("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        C9158a.m57503F().m57516N(this.f14572e1, c11060c, false, "CloudSpaceShareActivity");
    }

    /* renamed from: o3 */
    public final void m20193o3() {
        int i10 = this.f14607L;
        if (i10 == 2 || i10 == 7) {
            C11839m.m70688i("CloudSpaceShareActivity", "from manage cloud space");
            setResult(101);
        } else if (i10 == 1) {
            setResult(-1);
            C11839m.m70688i("CloudSpaceShareActivity", "invite family members extrakey:" + this.f14608M);
            if (this.f14608M == 1) {
                m20178Y2();
            }
        } else {
            C11839m.m70688i("CloudSpaceShareActivity", "other enery_type:" + this.f14607L);
        }
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        C11839m.m70686d("CloudSpaceShareActivity", "onActivityResult: requestCode: " + i10 + " resultCode: " + i11);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.JoinShareCallback
    public void onCanceled() {
        m20206y3(true);
        C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_CANCEL_JOIN_HAS_PURCHASED_DIALOG_BUTTON);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.StopShareCallback
    public void onCanceledStop() {
        m20208L1();
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceShareUpgradeCallback
    public void onCanceledUpgrade() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.port_continue_button || id2 == R$id.land_continue_button) {
            m20174U2();
            C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_ENABLE_BUTTON);
            return;
        }
        if (id2 == R$id.port_join_space_share_button || id2 == R$id.land_join_space_share_button) {
            C11839m.m70688i("CloudSpaceShareActivity", "join space share notice");
            m20206y3(false);
            this.f14570d1 = true;
            m20226d2(this.f14572e1);
            C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_JOIN_HAS_PURCHASED_BUTTON);
            return;
        }
        if (id2 == R$id.port_no_join || id2 == R$id.land_no_join) {
            mo20190l3();
            return;
        }
        if (id2 != R$id.port_open_later && id2 != R$id.land_open_later) {
            if (id2 == R$id.family_share_num_not_enough) {
                this.f14541M0.onClick(view);
                return;
            } else {
                m20188j3(id2);
                return;
            }
        }
        C11839m.m70688i("CloudSpaceShareActivity", "open later,finish");
        C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_ENABLE_LATER_BUTTON);
        if (this.f14607L == 1) {
            setResult(1);
        }
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        new LanguagePlugin().activityInit(this);
        super.onConfigurationChanged(configuration);
        C11839m.m70688i("CloudSpaceShareActivity", "onConfigurationChanged");
        C11842p.m70822i1(this);
        m20187i3();
        if (!C11842p.m70753O0(this.f14547S) || C11842p.m70747M0(this)) {
            this.f14549T.setVisibility(this.f14546R0);
            this.f14578k0.setVisibility(this.f14548S0);
            this.f14551U.setVisibility(8);
            this.f14579l0.setVisibility(8);
        } else if (C11842p.m70762R0()) {
            this.f14551U.setVisibility(8);
            this.f14579l0.setVisibility(8);
            this.f14549T.setVisibility(this.f14546R0);
            this.f14578k0.setVisibility(this.f14548S0);
        } else {
            this.f14551U.setVisibility(this.f14546R0);
            this.f14579l0.setVisibility(this.f14548S0);
            this.f14549T.setVisibility(8);
            this.f14578k0.setVisibility(8);
        }
        m20195p3();
        C11842p.m70891z2(this, this.f14614p);
        C11842p.m70891z2(this, this.f14533E0);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.JoinShareCallback
    public void onConfirmed() {
        C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_JOIN_HAS_PURCHASED_DIALOG_BUTTON);
        this.f14606K = true;
        m20204x3(8, 0, 8, 8, 8, 8);
        m20226d2(this.f14572e1);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.StopShareCallback
    public void onConfirmedStop() {
        m20210N1(this.f14572e1);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceShareUpgradeCallback
    public void onConfirmedUpgrade() throws Throwable {
        this.f14568c1 = true;
        m20177X2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m29137U0();
        super.onCreate(bundle);
        C11839m.m70688i("CloudSpaceShareActivity", "onCreate");
        C11842p.m70889z0(this);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.activity_cloud_space_share);
        this.f14547S = this;
        m20160f3();
        m20182c3();
        mo19005p1();
        m20185g3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m20162B3();
        Handler handler = this.f14572e1;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        JoinSpaceShareDialog joinSpaceShareDialog = this.f14544P0;
        if (joinSpaceShareDialog != null) {
            joinSpaceShareDialog.dismiss();
            this.f14544P0 = null;
        }
        AlertDialog alertDialog = this.f14609N;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f14609N = null;
        }
        StopShareDialog stopShareDialog = this.f14610O;
        if (stopShareDialog != null) {
            stopShareDialog.dismiss();
            this.f14610O = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f14568c1) {
            this.f14568c1 = false;
            m20226d2(this.f14572e1);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareBaseActivity
    /* renamed from: p2 */
    public void mo20194p2() {
        m20204x3(8, 8, 8, 0, 8, 8);
    }

    /* renamed from: p3 */
    public final void m20195p3() {
        if (!C11842p.m70753O0(this) || C11842p.m70747M0(this) || C11842p.m70762R0()) {
            C11842p.m70874v1(this, this.f14534F0);
            C11842p.m70874v1(this, this.f14529A0);
            C11842p.m70874v1(this, this.f14536H0);
        } else {
            C11842p.m70878w1(this, this.f14535G0);
            C11842p.m70878w1(this, this.f14530B0);
            C11842p.m70878w1(this, this.f14537I0);
        }
        C11842p.m70874v1(this, this.f14616r);
        C11842p.m70874v1(this, this.f14617s);
        C11842p.m70874v1(this, this.f14540L0);
    }

    /* renamed from: q3 */
    public final void m20196q3(C9440a c9440a) {
        String str = "";
        try {
            str = C13040c.m78609F().m78625Q() + "/staticpage/wap/refund?lang=" + C0234s.m1627e();
            C11839m.m70686d("CloudSpaceShareActivity", "getRefundFee: " + str);
            String strM59209a = c9440a.m59209a();
            int i10 = R$string.refund_rule;
            m20198s3(C10465b.m64293c(strM59209a, C0223k.m1524g(this.f14547S, this.f14550T0), getString(i10)), getString(i10), str);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudSpaceShareActivity", "getRefundFee: " + e10.toString());
            String strM59209a2 = c9440a.m59209a();
            String strM1524g = C0223k.m1524g(this.f14547S, this.f14550T0);
            int i11 = R$string.refund_rule;
            m20198s3(C10465b.m64293c(strM59209a2, strM1524g, getString(i11)), getString(i11), str);
        }
    }

    /* renamed from: r3 */
    public final void m20197r3(String str, String str2) {
        String string = getString(R$string.learn_more_backup);
        m20199t3(this.f14586s0, str + string, string, str2);
        m20199t3(this.f14587t0, str + string, string, str2);
    }

    /* renamed from: s3 */
    public final void m20198s3(String str, String str2, String str3) {
        m20199t3(this.f14584q0, str, str2, str3);
        m20199t3(this.f14585r0, str, str2, str3);
    }

    /* renamed from: t3 */
    public final void m20199t3(SpanClickText spanClickText, String str, String str2, String str3) {
        spanClickText.m15931c(str2, new SpaceShareLinkClickListener(this, spanClickText, str3));
        spanClickText.m15934g(str, false);
    }

    /* renamed from: u3 */
    public boolean m20200u3(int i10) {
        C11839m.m70688i("CloudSpaceShareActivity", "setViewStringByType type:" + i10);
        C9440a c9440aM60499t = C9681b.m60470l().m60499t(i10);
        if (c9440aM60499t == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "setViewStringByType shareSpaceDetail is null");
            return false;
        }
        String strM59214f = c9440aM60499t.m59214f();
        String strM59209a = c9440aM60499t.m59209a();
        this.f14582o0.setText(strM59214f);
        this.f14583p0.setText(strM59214f);
        this.f14545Q0 = c9440aM60499t.m59212d();
        C11839m.m70686d("CloudSpaceShareActivity", "setViewStringByType title:" + strM59214f + " ,content: " + strM59209a + " ,url:" + this.f14545Q0);
        if (m20209M1(strM59209a) || m20209M1(strM59214f)) {
            C11839m.m70687e("CloudSpaceShareActivity", "setViewStringByType title or content is null");
            return false;
        }
        if (i10 == 4) {
            m20196q3(c9440aM60499t);
        } else {
            this.f14584q0.setText(strM59209a);
            this.f14585r0.setText(strM59209a);
            if (!TextUtils.equals(c9440aM60499t.m59210b(), "Y") || TextUtils.isEmpty(this.f14545Q0)) {
                this.f14586s0.setVisibility(8);
                this.f14587t0.setVisibility(8);
            } else {
                this.f14586s0.setVisibility(0);
                this.f14587t0.setVisibility(0);
                m20197r3("", this.f14545Q0);
            }
        }
        String strM59211c = c9440aM60499t.m59211c();
        String strM59213e = c9440aM60499t.m59213e();
        C11839m.m70686d("CloudSpaceShareActivity", "setViewStringByType mainBtnText:" + strM59211c + " ,subBtnText: " + strM59213e);
        if (m20209M1(strM59211c)) {
            C11839m.m70687e("CloudSpaceShareActivity", "setViewStringByType mainBtnText is null");
            return false;
        }
        if (i10 == 4) {
            this.f14529A0.setText(strM59211c);
            this.f14530B0.setText(strM59211c);
            this.f14531C0.setText(strM59213e);
            this.f14532D0.setText(strM59213e);
            return true;
        }
        if (i10 == 3) {
            this.f14536H0.setText(strM59211c);
            this.f14537I0.setText(strM59211c);
            return true;
        }
        if (m20209M1(strM59213e)) {
            C11839m.m70687e("CloudSpaceShareActivity", "setViewStringByType subBtnText is null");
            return false;
        }
        this.f14534F0.setText(strM59211c);
        this.f14535G0.setText(strM59211c);
        this.f14590w0.setText(strM59213e);
        this.f14591x0.setText(strM59213e);
        return true;
    }

    /* renamed from: v3 */
    public void m20201v3(boolean z10) {
        LinearLayout linearLayout = this.f14589v0;
        if (linearLayout == null || this.f14593z0 == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "mOpenSpaceShare_Land or mJoinOrNotFrame_Land is null");
            return;
        }
        if (z10) {
            linearLayout.setVisibility(0);
            this.f14593z0.setVisibility(8);
        } else {
            linearLayout.setVisibility(8);
            this.f14593z0.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.f14588u0;
        if (linearLayout2 == null || this.f14592y0 == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "mOpenSpaceSharePort or mJoinOrNotFramePort is null");
        } else if (z10) {
            linearLayout2.setVisibility(0);
            this.f14592y0.setVisibility(8);
        } else {
            linearLayout2.setVisibility(8);
            this.f14592y0.setVisibility(0);
        }
    }

    /* renamed from: w3 */
    public final void m20202w3() {
        LinearLayout linearLayout = this.f14589v0;
        if (linearLayout == null || this.f14539K0 == null || this.f14537I0 == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "continueBtn or continueProgress or finishBtn is null");
            return;
        }
        linearLayout.setVisibility(4);
        this.f14539K0.setVisibility(8);
        this.f14537I0.setVisibility(0);
        LinearLayout linearLayout2 = this.f14588u0;
        if (linearLayout2 == null || this.f14538J0 == null || this.f14536H0 == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "continueBtn or continueProgress or finishBtn is null");
            return;
        }
        linearLayout2.setVisibility(8);
        this.f14538J0.setVisibility(8);
        this.f14536H0.setVisibility(0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareBaseActivity
    /* renamed from: x2 */
    public void mo20203x2() {
        m20204x3(8, 8, 8, 8, 0, 8);
    }

    /* renamed from: x3 */
    public void m20204x3(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f14546R0 = i10;
        this.f14548S0 = i12;
        if (!C11842p.m70753O0(this.f14547S) || C11842p.m70747M0(this)) {
            this.f14549T.setVisibility(i10);
            this.f14578k0.setVisibility(i12);
            this.f14551U.setVisibility(8);
            this.f14579l0.setVisibility(8);
        } else if (C11842p.m70762R0()) {
            this.f14551U.setVisibility(8);
            this.f14579l0.setVisibility(8);
            this.f14549T.setVisibility(i10);
            this.f14578k0.setVisibility(i12);
            m20195p3();
        } else {
            this.f14551U.setVisibility(i10);
            this.f14579l0.setVisibility(i12);
            this.f14549T.setVisibility(8);
            this.f14578k0.setVisibility(8);
        }
        this.f14533E0.setVisibility(i11);
        this.f14614p.setVisibility(i15);
        this.f14574g0.setVisibility(i13);
        this.f14575h0.setVisibility(i13);
        this.f14576i0.setVisibility(i14);
        this.f14577j0.setVisibility(i14);
        if (i11 == 0 || i13 == 0 || i14 == 0 || i15 == 0) {
            m20184e3(getString(R$string.cloud_space_share));
        } else {
            m20184e3("");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareBaseActivity
    /* renamed from: y2 */
    public void mo20205y2() {
        m20204x3(8, 8, 8, 8, 8, 0);
    }

    /* renamed from: y3 */
    public final void m20206y3(boolean z10) {
        C11839m.m70688i("CloudSpaceShareActivity", "showOrHideJoinBtn:" + z10);
        LinearLayout linearLayout = this.f14593z0;
        if (linearLayout == null || this.f14539K0 == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "continueBtn or continueProgress is null");
            return;
        }
        if (z10) {
            linearLayout.setVisibility(0);
            this.f14539K0.setVisibility(8);
        } else {
            linearLayout.setVisibility(4);
            this.f14539K0.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.f14592y0;
        if (linearLayout2 == null || this.f14538J0 == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "continueBtn or continueProgress is null");
        } else if (z10) {
            linearLayout2.setVisibility(0);
            this.f14538J0.setVisibility(8);
        } else {
            linearLayout2.setVisibility(8);
            this.f14538J0.setVisibility(0);
        }
    }

    /* renamed from: z3 */
    public final void m20207z3(boolean z10) {
        LinearLayout linearLayout = this.f14589v0;
        if (linearLayout == null || this.f14539K0 == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "continueBtn or continueProgress is null");
            return;
        }
        if (z10) {
            linearLayout.setVisibility(0);
            this.f14539K0.setVisibility(8);
        } else {
            linearLayout.setVisibility(4);
            this.f14539K0.setVisibility(0);
        }
        LinearLayout linearLayout2 = this.f14588u0;
        if (linearLayout2 == null || this.f14538J0 == null) {
            C11839m.m70688i("CloudSpaceShareActivity", "continueBtn or continueProgress is null");
        } else if (z10) {
            linearLayout2.setVisibility(0);
            this.f14538J0.setVisibility(8);
        } else {
            linearLayout2.setVisibility(8);
            this.f14538J0.setVisibility(0);
        }
    }
}
