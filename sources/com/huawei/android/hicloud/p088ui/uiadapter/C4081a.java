package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackSpaceHeaderBean;
import com.huawei.android.hicloud.cloudbackup.bean.OverdueBackupRecordsPolicy;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.hisync.model.BackupDetailItem;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupRecordsActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupDetailActivity;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupSpaceDetailAdapter;
import com.huawei.android.hicloud.p088ui.views.ManagerBackupDataBasicView;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0241z;
import p336he.C10153d;
import p514o9.C11839m;
import p514o9.C11842p;
import p550pb.C12126b;
import p617rl.C12526j;
import p684un.C13223b;
import p684un.C13225d;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p815ym.AbstractC14026a;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.uiadapter.a */
/* loaded from: classes3.dex */
public class C4081a extends RecyclerView.AbstractC0833c0 {

    /* renamed from: A */
    public TextView f18945A;

    /* renamed from: B */
    public RelativeLayout f18946B;

    /* renamed from: C */
    public LinearLayout f18947C;

    /* renamed from: D */
    public LinearLayout f18948D;

    /* renamed from: E */
    public TextView f18949E;

    /* renamed from: F */
    public TextView f18950F;

    /* renamed from: G */
    public TextView f18951G;

    /* renamed from: H */
    public TextView f18952H;

    /* renamed from: I */
    public LinearLayout f18953I;

    /* renamed from: J */
    public SpanClickText f18954J;

    /* renamed from: K */
    public TextView f18955K;

    /* renamed from: L */
    public TextView f18956L;

    /* renamed from: M */
    public ViewGroup f18957M;

    /* renamed from: N */
    public View f18958N;

    /* renamed from: O */
    public final ViewGroup f18959O;

    /* renamed from: P */
    public View f18960P;

    /* renamed from: Q */
    public ManagerBackupDataBasicView f18961Q;

    /* renamed from: R */
    public TextView f18962R;

    /* renamed from: S */
    public TextView f18963S;

    /* renamed from: T */
    public SpanClickText f18964T;

    /* renamed from: U */
    public RelativeLayout f18965U;

    /* renamed from: V */
    public Context f18966V;

    /* renamed from: W */
    public CloudBackSpaceHeaderBean f18967W;

    /* renamed from: X */
    public AccessibilityManager f18968X;

    /* renamed from: Y */
    public OverdueBackupRecordsPolicy f18969Y;

    /* renamed from: Z */
    public OverdueBackupRecordsPolicy.PHASE f18970Z;

    /* renamed from: a0 */
    public String f18971a0;

    /* renamed from: b0 */
    public AccessibilityManager.TouchExplorationStateChangeListener f18972b0;

    /* renamed from: c0 */
    public final Runnable f18973c0;

    /* renamed from: d0 */
    public final Resources f18974d0;

    /* renamed from: u */
    public BackupSpaceDetailAdapter.DeleteBackupModuleListener f18975u;

    /* renamed from: v */
    public View.OnClickListener f18976v;

    /* renamed from: w */
    public boolean f18977w;

    /* renamed from: x */
    public TextView f18978x;

    /* renamed from: y */
    public ImageView f18979y;

    /* renamed from: z */
    public TextView f18980z;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.a$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C4081a.this.f18968X == null || C4081a.this.f18972b0 == null) {
                return;
            }
            C4081a.this.f18968X.removeTouchExplorationStateChangeListener(C4081a.this.f18972b0);
        }
    }

    public C4081a(View view, List<Object> list) {
        super(view);
        this.f18970Z = OverdueBackupRecordsPolicy.PHASE.PHASE1;
        this.f18972b0 = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: ae.h
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z10) {
                this.f477a.m25336i0(z10);
            }
        };
        this.f18973c0 = new a();
        Context context = view.getContext();
        this.f18966V = context;
        this.f18974d0 = context.getResources();
        this.f18947C = (LinearLayout) C12809f.m76831d(view, R$id.backups_detail_main_layout);
        this.f18978x = (TextView) C12809f.m76831d(view, R$id.tv_device_name);
        this.f18948D = (LinearLayout) C12809f.m76831d(view, R$id.cloudbackup_switch_closed_tips_layout);
        this.f18979y = (ImageView) C12809f.m76831d(view, R$id.general_detail_page_icon);
        this.f18980z = (TextView) C12809f.m76831d(view, R$id.backup_already_size_title);
        this.f18945A = (TextView) C12809f.m76831d(view, R$id.data_size_used);
        this.f18949E = (TextView) C12809f.m76831d(view, R$id.device_title);
        this.f18946B = (RelativeLayout) C12809f.m76831d(view, R$id.backups_request_loading);
        this.f18951G = (TextView) C12809f.m76831d(view, R$id.backup_record_last_time);
        this.f18952H = (TextView) C12809f.m76831d(view, R$id.backup_record_in_incompatible_systems);
        this.f18950F = (TextView) C12809f.m76831d(view, R$id.data_size_title);
        this.f18953I = (LinearLayout) C12809f.m76831d(view, R$id.title_layout);
        this.f18954J = (SpanClickText) C12809f.m76831d(view, R$id.cloudbackup_switch_closed_tips);
        this.f18955K = (TextView) C12809f.m76831d(view, R$id.last_backup_title);
        this.f18956L = (TextView) C12809f.m76831d(view, R$id.last_backup_time);
        this.f18957M = (ViewGroup) C12809f.m76831d(view, R$id.last_backup_parent);
        this.f18958N = C12809f.m76831d(view, R$id.last_backup_divider);
        this.f18959O = (ViewGroup) C12809f.m76831d(view, R$id.backup_already_size_parent);
        this.f18960P = C12809f.m76831d(view, R$id.backup_already_size_divider);
        this.f18961Q = (ManagerBackupDataBasicView) C12809f.m76831d(view, R$id.basic_data_card_view);
        this.f18962R = (TextView) C12809f.m76831d(view, R$id.tv_this_device);
        this.f18963S = (TextView) C12809f.m76831d(view, R$id.delete_warning);
        this.f18964T = (SpanClickText) C12809f.m76831d(view, R$id.expired_device_tips);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(view, R$id.rl_backup_detail_restore_view);
        this.f18965U = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: ae.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f486a.m25337j0(view2);
            }
        });
        if (list != null && list.size() > 1) {
            m25339l0(true);
        }
        this.f18969Y = new C12526j().m75420t0();
        m25343p0();
    }

    /* renamed from: X */
    public final boolean m25325X(int i10) {
        OverdueBackupRecordsPolicy overdueBackupRecordsPolicy = this.f18969Y;
        if (overdueBackupRecordsPolicy == null) {
            C11839m.m70689w("BackupManagerDataHeaderHolder", "checkPolicyValid, overdueBackupRecordsPolicy is null");
            return false;
        }
        List<OverdueBackupRecordsPolicy.RecordsDeletePhases> recordsDeletePhases = overdueBackupRecordsPolicy.getRecordsDeletePhases();
        if (AbstractC14026a.m84159a(recordsDeletePhases)) {
            C11839m.m70689w("BackupManagerDataHeaderHolder", "checkPolicyValid, recordsDeletePhases is empty");
            return false;
        }
        if (i10 > this.f18969Y.getRecordsDeletePhaseTime()) {
            this.f18970Z = OverdueBackupRecordsPolicy.PHASE.PHASE1;
        } else {
            this.f18970Z = OverdueBackupRecordsPolicy.PHASE.PHASE2;
        }
        for (OverdueBackupRecordsPolicy.RecordsDeletePhases recordsDeletePhases2 : recordsDeletePhases) {
            if (recordsDeletePhases2 == null) {
                C11839m.m70689w("BackupManagerDataHeaderHolder", "checkPolicyValid, recordsDeletePhasesItem is null");
                return false;
            }
            String subscribeUri = recordsDeletePhases2.getSubscribeUri();
            if (TextUtils.isEmpty(subscribeUri)) {
                C11839m.m70689w("BackupManagerDataHeaderHolder", "checkPolicyValid, subscribeUriStr is empty");
                return false;
            }
            String phase = recordsDeletePhases2.getPhase();
            if (TextUtils.isEmpty(phase)) {
                C11839m.m70689w("BackupManagerDataHeaderHolder", "checkPolicyValid, phaseStr is empty");
                return false;
            }
            if (this.f18970Z == OverdueBackupRecordsPolicy.PHASE.getPhase(phase)) {
                this.f18971a0 = subscribeUri;
            }
        }
        return true;
    }

    /* renamed from: Y */
    public final void m25326Y() {
        CloudBackSpaceHeaderBean cloudBackSpaceHeaderBean = this.f18967W;
        if (!cloudBackSpaceHeaderBean.isCurrentDeviceHasData && !cloudBackSpaceHeaderBean.isTempBackup) {
            C11839m.m70688i("BackupManagerDataHeaderHolder", "has no data, no jump");
            return;
        }
        Intent intent = new Intent(this.f18966V, (Class<?>) CloudBackupRecordsActivity.class);
        C13225d.m79490f1().m79585f0("mecloud_backupdetail_click_backup_restore", C13452e.m80781L().m80971t0());
        C13230i.m79525e1(intent, "1", "39");
        UBAAnalyze.m29954O("PVC", "mecloud_backupdetail_click_backup_restore", "1", "39");
        BackupDetailItem backupDetailItem = this.f18967W.detailItem;
        if (backupDetailItem != null) {
            intent.putExtra("backup_device_id", backupDetailItem.m16374c());
            intent.putExtra("backup_device_new", this.f18967W.detailItem.m16381j());
            intent.putExtra("backup_data_size", this.f18967W.detailItem.m16382l());
            intent.putExtra("backup_device_category", this.f18967W.detailItem.m16378g());
            intent.putExtra("is_current_device", this.f18967W.detailItem.m16376e() == 1);
        }
        if (this.f18967W.isTempBackup) {
            intent.putExtra("backup_is_temp_backup_type", true);
        }
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 2);
        ((CloudSpaceBackupDetailActivity) this.f18966V).startActivityForResult(intent, 10047);
    }

    /* renamed from: Z */
    public final void m25327Z() throws Resources.NotFoundException {
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("BackupManagerDataHeaderHolder", "link click to fast");
            return;
        }
        C11839m.m70688i("BackupManagerDataHeaderHolder", "click save to user Space");
        Context context = this.f18954J.getContext();
        if (context instanceof CloudSpaceBackupDetailActivity) {
            ((CloudSpaceBackupDetailActivity) context).m20096K4(this.f18967W.occupySpaceType);
        }
    }

    /* renamed from: a0 */
    public ManagerBackupDataBasicView m25328a0() {
        return this.f18961Q;
    }

    /* renamed from: b0 */
    public void m25329b0() {
        long jM1689g = C0241z.m1689g(this.f18967W.detailItem.m16380i(), 0L);
        if (this.f18967W.isOnlyRefurbish) {
            this.f18951G.setVisibility(0);
            this.f18951G.setText(this.f18966V.getString(R$string.backup_only_refurbish_text, 3));
            this.f18959O.setVisibility(8);
            this.f18960P.setVisibility(8);
            this.f18946B.setVisibility(8);
            this.f18953I.setVisibility(8);
            this.f18957M.setVisibility(8);
            this.f18958N.setVisibility(8);
        } else if (jM1689g != 0) {
            this.f18956L.setVisibility(0);
            this.f18956L.setText(C10153d.m63240d(this.f18966V, jM1689g));
            this.f18957M.setVisibility(0);
            this.f18958N.setVisibility(0);
        } else {
            this.f18956L.setVisibility(8);
            this.f18957M.setVisibility(8);
            this.f18958N.setVisibility(8);
        }
        String strM16381j = this.f18967W.detailItem.m16381j();
        boolean z10 = this.f18967W.detailItem.m16376e() == 1;
        Boolean bool = C10153d.m63237a().get(this.f18967W.detailItem.m16374c());
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        this.f18979y.setImageDrawable(DeviceIconManager.getInstance().getDeviceIconFromCache(this.f18967W.detailItem.m16383m(), this.f18967W.detailItem.m16378g()));
        if (zBooleanValue) {
            this.f18949E.setText(R$string.full_data_new);
        }
        if (!z10) {
            this.f18962R.setVisibility(8);
            this.f18978x.setText(strM16381j);
            return;
        }
        this.f18962R.setVisibility(0);
        this.f18978x.setText(strM16381j);
        CloudBackSpaceHeaderBean cloudBackSpaceHeaderBean = this.f18967W;
        if (cloudBackSpaceHeaderBean.isBackupSwitchOpen || cloudBackSpaceHeaderBean.isOnlyRefurbish) {
            return;
        }
        this.f18954J.setVisibility(0);
        this.f18948D.setVisibility(0);
    }

    /* renamed from: c0 */
    public final void m25330c0() throws Resources.NotFoundException {
        CloudBackSpaceHeaderBean cloudBackSpaceHeaderBean = this.f18967W;
        if (cloudBackSpaceHeaderBean.isTempBackup) {
            long jM1689g = C0241z.m1689g(cloudBackSpaceHeaderBean.detailItem.m16380i(), 0L);
            if (jM1689g != 0) {
                this.f18956L.setVisibility(0);
                this.f18956L.setText(C10153d.m63240d(this.f18966V, jM1689g));
                this.f18957M.setVisibility(0);
                this.f18958N.setVisibility(0);
            } else {
                this.f18956L.setVisibility(8);
                this.f18957M.setVisibility(8);
                this.f18958N.setVisibility(8);
            }
            this.f18979y.setImageDrawable(DeviceIconManager.getInstance().getDeviceIconFromCache(this.f18967W.detailItem.m16383m(), this.f18967W.detailItem.m16378g()));
            boolean z10 = this.f18967W.detailItem.m16376e() == 1;
            String strM16381j = this.f18967W.detailItem.m16381j();
            if (z10) {
                this.f18978x.setText(strM16381j);
                this.f18962R.setVisibility(0);
            } else {
                this.f18962R.setVisibility(8);
                this.f18978x.setText(strM16381j);
            }
            this.f18947C.setVisibility(0);
            m25348u0(this.f18967W.occupySpaceType);
            m25346s0(this.f18967W.isOnlyHarmonyNext);
        }
    }

    /* renamed from: d0 */
    public final void m25331d0(CloudBackSpaceHeaderBean cloudBackSpaceHeaderBean) throws Resources.NotFoundException {
        int iM16377f = cloudBackSpaceHeaderBean.detailItem.m16377f();
        if (iM16377f <= -1) {
            this.f18963S.setVisibility(8);
            this.f18964T.setVisibility(8);
            return;
        }
        this.f18963S.setText(this.f18974d0.getQuantityString(R$plurals.will_be_deleted, 180, 180));
        this.f18963S.setVisibility(0);
        String string = this.f18974d0.getString(R$string.user_agreement);
        String string2 = (!m25325X(iM16377f) || this.f18970Z == OverdueBackupRecordsPolicy.PHASE.PHASE1) ? this.f18974d0.getString(R$string.upgrade_to_cloud_space) : this.f18974d0.getString(R$string.free_trial_cloud_space_membership_service);
        String quantityString = iM16377f == 0 ? this.f18974d0.getQuantityString(R$plurals.manager_expired_backup_records_top_tips_less_than_one_day, 180, 180, string, string2) : this.f18974d0.getQuantityString(R$plurals.manager_expired_backup_records_top_tips, iM16377f, 180, string, Integer.valueOf(iM16377f), string2);
        this.f18964T.m15931c(string2, new SpanClickText.ISpanClickListener() { // from class: ae.l
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.f520a.m25334g0();
            }
        });
        this.f18964T.m15934g(quantityString, false);
        this.f18964T.setVisibility(0);
    }

    /* renamed from: e0 */
    public final void m25332e0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Bundle bundle = new Bundle();
        bundle.putInt("from_where", 18);
        bundle.putInt("nav_source", 21);
        C13230i.m79522d1(bundle, "1", "7");
        C12126b.m72707c("2", bundle);
        new HwAnimationReflection(this.f18966V).m15927c(1);
        String strM80790C = C13452e.m80781L().m80790C();
        C13223b.m79478f("expired_backup_records", "1", C13452e.m80781L().m80971t0(), "2", strM80790C);
        UBAAnalyze.m29960U("PVC", "expired_backup_records", "1", "7", "1", "2", strM80790C);
    }

    /* renamed from: f0 */
    public final void m25333f0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (TextUtils.isEmpty(this.f18971a0)) {
            m25332e0();
            return;
        }
        try {
            Intent commonGotoIntent = GeneralRedirectUtil.getCommonGotoIntent(this.f18971a0.startsWith("hicloud") ? NotifyConstants.TYPE_DEEPLINK : "web", this.f18971a0, false);
            commonGotoIntent.putExtra("from_where", 18);
            commonGotoIntent.putExtra("nav_source", 20);
            this.f18966V.startActivity(new HiCloudSafeIntent(commonGotoIntent));
        } catch (Exception e10) {
            C11839m.m70687e("BackupManagerDataHeaderHolder", "startActivity error: " + e10.getMessage());
            m25332e0();
        }
    }

    /* renamed from: g0 */
    public final /* synthetic */ void m25334g0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("key_event", "manager_page_top_tips_hyperlinks_click_jump_upgrade_page");
        C13227f.m79492i1().m79567R("event_overdue_backup_records", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "event_overdue_backup_records", linkedHashMapM79497A);
        m25333f0();
    }

    /* renamed from: h0 */
    public final /* synthetic */ void m25335h0(View view) throws Resources.NotFoundException {
        m25327Z();
    }

    /* renamed from: i0 */
    public final /* synthetic */ void m25336i0(boolean z10) {
        LinearLayout linearLayout = this.f18948D;
        if (linearLayout == null) {
            return;
        }
        if (z10) {
            linearLayout.setClickable(true);
            this.f18948D.setOnClickListener(new View.OnClickListener() { // from class: ae.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    this.f530a.m25335h0(view);
                }
            });
        } else {
            linearLayout.setClickable(false);
            this.f18948D.setOnClickListener(null);
        }
    }

    /* renamed from: j0 */
    public final /* synthetic */ void m25337j0(View view) {
        m25326Y();
    }

    /* renamed from: k0 */
    public final /* synthetic */ void m25338k0(View view) throws Resources.NotFoundException {
        m25327Z();
    }

    /* renamed from: l0 */
    public void m25339l0(boolean z10) {
        C11839m.m70688i("BackupManagerDataHeaderHolder", "loadingDone:hasData," + z10);
        this.f18946B.setVisibility(8);
        if (!z10) {
            this.f18949E.setVisibility(8);
            return;
        }
        this.f18949E.setVisibility(0);
        CloudBackSpaceHeaderBean cloudBackSpaceHeaderBean = this.f18967W;
        if (cloudBackSpaceHeaderBean != null) {
            if (cloudBackSpaceHeaderBean.isTempBackup) {
                this.f18949E.setText(R$string.backed_up_data);
                return;
            }
            Boolean bool = C10153d.m63237a().get(this.f18967W.detailItem.m16374c());
            if (bool == null || !bool.booleanValue()) {
                this.f18949E.setText(R$string.backed_up_data);
            } else {
                this.f18949E.setText(R$string.full_data_new);
            }
        }
    }

    /* renamed from: m0 */
    public final void m25340m0(long j10) {
        if (j10 > 0 || this.f18945A == null) {
            this.f18959O.setVisibility(0);
            this.f18960P.setVisibility(0);
        } else {
            this.f18959O.setVisibility(8);
            this.f18960P.setVisibility(8);
        }
    }

    /* renamed from: n0 */
    public void m25341n0(BackupSpaceDetailAdapter.DeleteBackupModuleListener deleteBackupModuleListener) {
        this.f18975u = deleteBackupModuleListener;
    }

    /* renamed from: o0 */
    public void m25342o0(boolean z10) {
        this.f18977w = z10;
    }

    /* renamed from: p0 */
    public final void m25343p0() {
        DisplayMetrics displayMetricsM70876w;
        int i10;
        int iM70840n;
        if (C0209d.m1195O(this.f18966V) >= 1.75f || (displayMetricsM70876w = C11842p.m70876w(this.f18966V)) == null || (i10 = displayMetricsM70876w.widthPixels) <= 0 || (iM70840n = i10 - C11842p.m70840n(this.f18966V, 64)) <= 0) {
            return;
        }
        int i11 = (iM70840n * 2) / 3;
        this.f18955K.setMaxWidth(i11);
        this.f18980z.setMaxWidth(i11);
    }

    /* renamed from: q0 */
    public void m25344q0(View.OnClickListener onClickListener) {
        this.f18976v = onClickListener;
    }

    /* renamed from: r0 */
    public final void m25345r0() {
        List<AppDetailsInfo> list = this.f18967W.basicItemList;
        C12809f.m76843p(this.f18961Q, false);
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70687e("BackupManagerDataHeaderHolder", "baseDataAll is null");
            return;
        }
        Boolean bool = C10153d.m63237a().get(this.f18967W.detailItem.m16374c());
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        this.f18961Q.setDeleteBackupModuleListener(this.f18975u);
        this.f18961Q.setClickListener(this.f18976v);
        this.f18961Q.m25780e(list, this.f18977w);
        C12809f.m76843p(this.f18961Q, true);
        this.f18949E.setText(R$string.full_data_new);
    }

    /* renamed from: s0 */
    public final void m25346s0(boolean z10) {
        if (z10) {
            this.f18965U.setOnClickListener(null);
            this.f18950F.setAlpha(0.62f);
            TextView textView = this.f18950F;
            textView.setPadding(textView.getPaddingLeft(), this.f18966V.getResources().getDimensionPixelSize(R$dimen.cloud_space_13_dp), this.f18950F.getPaddingRight(), this.f18966V.getResources().getDimensionPixelSize(R$dimen.cloud_space_14_dp));
            C11839m.m70688i("BackupManagerDataHeaderHolder", "left:" + this.f18950F.getPaddingLeft() + "right:" + this.f18950F.getPaddingRight());
            this.f18952H.setVisibility(0);
        }
    }

    /* renamed from: t0 */
    public final void m25347t0() throws Resources.NotFoundException {
        if (this.f18968X == null) {
            this.f18968X = (AccessibilityManager) this.f18966V.getSystemService("accessibility");
        }
        AccessibilityManager accessibilityManager = this.f18968X;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            C11839m.m70688i("BackupManagerDataHeaderHolder", "showSaveTempTips accessibilityManager.isTouchExplorationEnabled");
            this.f18948D.setClickable(true);
            this.f18948D.setOnClickListener(new View.OnClickListener() { // from class: ae.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    this.f496a.m25338k0(view);
                }
            });
        }
        AccessibilityManager accessibilityManager2 = this.f18968X;
        if (accessibilityManager2 != null) {
            accessibilityManager2.addTouchExplorationStateChangeListener(this.f18972b0);
        }
        Context context = this.f18954J.getContext();
        if (context instanceof CloudSpaceBackupDetailActivity) {
            ((CloudSpaceBackupDetailActivity) context).m20108V3(this.f18973c0);
        }
        String string = context.getString(R$string.temp_backup_save_to_user_space);
        SpanClickText.ISpanClickListener iSpanClickListener = new SpanClickText.ISpanClickListener() { // from class: ae.k
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() throws Resources.NotFoundException {
                this.f502a.m25327Z();
            }
        };
        int i10 = this.f18967W.expiratoryInDays;
        String quantityString = this.f18974d0.getQuantityString(R$plurals.temp_backup_save_to_user_space_new_tip, i10, Integer.valueOf(i10), string);
        this.f18954J.m15931c(string, iSpanClickListener);
        this.f18954J.setVisibility(0);
        this.f18948D.setVisibility(0);
        this.f18954J.m15934g(quantityString, false);
    }

    /* renamed from: u0 */
    public final void m25348u0(Integer num) throws Resources.NotFoundException {
        if (num == null) {
            C11839m.m70689w("BackupManagerDataHeaderHolder", "showOccupySpaceTypeTips occupySpaceType is null");
            return;
        }
        this.f18948D.setClickable(false);
        this.f18948D.setOnClickListener(null);
        C11839m.m70688i("BackupManagerDataHeaderHolder", "showOccupySpaceTypeTips occupySpaceType is:" + num);
        if (num.intValue() == 0) {
            m25347t0();
        } else if (num.intValue() == 1) {
            this.f18948D.setVisibility(8);
            this.f18954J.setVisibility(8);
        }
    }

    /* renamed from: v0 */
    public void m25349v0(CloudBackSpaceHeaderBean cloudBackSpaceHeaderBean, List<Object> list) throws Resources.NotFoundException {
        this.f18967W = cloudBackSpaceHeaderBean;
        C11839m.m70688i("BackupManagerDataHeaderHolder", "updateView:detailItem.getSize" + cloudBackSpaceHeaderBean.detailItem.m16382l());
        m25340m0(cloudBackSpaceHeaderBean.detailItem.m16382l());
        this.f18945A.setText(C0223k.m1524g(this.f18966V, cloudBackSpaceHeaderBean.detailItem.m16382l()));
        C11839m.m70688i("BackupManagerDataHeaderHolder", "isOnlyHarmonyNext:" + cloudBackSpaceHeaderBean.isOnlyHarmonyNext);
        if (cloudBackSpaceHeaderBean.isTempBackup) {
            m25330c0();
        } else {
            m25329b0();
            m25345r0();
        }
        m25331d0(cloudBackSpaceHeaderBean);
        if (list == null || list.size() <= 1) {
            return;
        }
        m25339l0(true);
    }
}
