package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupDetailStateActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudGuideBackupActivity;
import com.huawei.android.hicloud.p088ui.extend.TextBannerSwitcher;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.android.hicloud.p088ui.views.status.CloudBackupBackingStateView;
import com.huawei.android.hicloud.p088ui.views.status.CloudBackupPauseStateView;
import com.huawei.android.hicloud.p088ui.views.status.CloudBackupStateView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.ArrayList;
import p015ak.C0209d;
import p514o9.C11839m;
import p618rm.C12590s0;
import p684un.C13225d;
import p709vj.C13452e;
import sk.C12809f;
import tl.C13029h;

/* loaded from: classes3.dex */
public class CloudBackupStateMainView extends CloudBackupStateView implements View.OnClickListener {

    /* renamed from: A */
    public CloudBackupPauseStateView f19390A;

    /* renamed from: B */
    public TextView f19391B;

    /* renamed from: C */
    public TextView f19392C;

    /* renamed from: D */
    public TextView f19393D;

    /* renamed from: E */
    public ImageView f19394E;

    /* renamed from: F */
    public TextView f19395F;

    /* renamed from: G */
    public RelativeLayout f19396G;

    /* renamed from: H */
    public TextView f19397H;

    /* renamed from: I */
    public TextView f19398I;

    /* renamed from: J */
    public TextView f19399J;

    /* renamed from: K */
    public TextBannerSwitcher f19400K;

    /* renamed from: L */
    public TextBannerSwitcher f19401L;

    /* renamed from: M */
    public boolean f19402M;

    /* renamed from: N */
    public boolean f19403N;

    /* renamed from: f */
    public int f19404f;

    /* renamed from: g */
    public RelativeLayout f19405g;

    /* renamed from: h */
    public RelativeLayout f19406h;

    /* renamed from: i */
    public ImageView f19407i;

    /* renamed from: j */
    public TextView f19408j;

    /* renamed from: k */
    public RelativeLayout f19409k;

    /* renamed from: l */
    public ImageView f19410l;

    /* renamed from: m */
    public RelativeLayout f19411m;

    /* renamed from: n */
    public RelativeLayout f19412n;

    /* renamed from: o */
    public TextView f19413o;

    /* renamed from: p */
    public RelativeLayout f19414p;

    /* renamed from: q */
    public CloudBackupBackingStateView f19415q;

    /* renamed from: r */
    public TextView f19416r;

    /* renamed from: s */
    public RelativeLayout f19417s;

    /* renamed from: t */
    public CloudBackupPauseStateView f19418t;

    /* renamed from: u */
    public TextView f19419u;

    /* renamed from: v */
    public TextView f19420v;

    /* renamed from: w */
    public ImageView f19421w;

    /* renamed from: x */
    public TextView f19422x;

    /* renamed from: y */
    public TextView f19423y;

    /* renamed from: z */
    public RelativeLayout f19424z;

    public CloudBackupStateMainView(Context context) {
        this(context, null);
    }

    /* renamed from: D */
    public static boolean m25696D(long j10) {
        return System.currentTimeMillis() - j10 >= 15552000000L;
    }

    private void setPrepareStatusBanner(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            str = this.f19594b.getString(R$string.cloudbackup_prepare_tip, 1, 2);
        }
        String string = this.f19594b.getString(R$string.backup_keep_connect_tip);
        String string2 = this.f19594b.getString(R$string.backup_loading_tip_background_run);
        arrayList.add(str);
        arrayList.add(string);
        arrayList.add(string2);
        this.f19401L.m24032o(arrayList);
        if (this.f19402M) {
            return;
        }
        this.f19402M = true;
        this.f19401L.setVisibility(0);
    }

    /* renamed from: A */
    public final void m25699A(View view) {
        this.f19424z = (RelativeLayout) C12809f.m76831d(view, R$id.cloudbackup_overdays);
        this.f19390A = (CloudBackupPauseStateView) C12809f.m76831d(view, R$id.rl_backup_overdays);
        this.f19391B = (TextView) C12809f.m76831d(view, R$id.tv_overdays_tip_one);
        this.f19392C = (TextView) C12809f.m76831d(view, R$id.tv_overdays_link);
        this.f19394E = (ImageView) C12809f.m76831d(view, R$id.iv_overdays_nospace_tip);
        this.f19393D = (TextView) C12809f.m76831d(view, R$id.tv_overdays_tip_two);
        this.f19395F = (TextView) C12809f.m76831d(view, R$id.tv_overdays_tip_three);
    }

    /* renamed from: B */
    public final void m25700B(View view) {
        this.f19417s = (RelativeLayout) C12809f.m76831d(view, R$id.cloudbackup_pause);
        this.f19418t = (CloudBackupPauseStateView) C12809f.m76831d(this, R$id.rl_backup_failed);
        this.f19419u = (TextView) C12809f.m76831d(this, R$id.tv_pause_tip_one);
        TextView textView = (TextView) C12809f.m76831d(this, R$id.tv_pause_link);
        this.f19423y = textView;
        textView.setOnClickListener(this);
        this.f19420v = (TextView) C12809f.m76831d(this, R$id.tv_pause_tip_two);
        this.f19421w = (ImageView) C12809f.m76831d(this, R$id.iv_local_nospace_tip);
        this.f19422x = (TextView) C12809f.m76831d(this, R$id.tv_pause_tip_three);
    }

    /* renamed from: C */
    public final void m25701C() {
        View viewInflate = View.inflate(getContext(), R$layout.cloudbackup_main_state_view, this);
        if (viewInflate instanceof RelativeLayout) {
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
            m25719y(relativeLayout);
            m25718x(relativeLayout);
            m25700B(relativeLayout);
            m25699A(relativeLayout);
            m25720z(relativeLayout);
        }
    }

    /* renamed from: E */
    public final /* synthetic */ void m25702E(View view) {
        m25717w();
    }

    /* renamed from: F */
    public final /* synthetic */ void m25703F(CloudBackupState cloudBackupState, View view) {
        m25716v(cloudBackupState);
    }

    /* renamed from: G */
    public void m25704G(int i10, boolean z10) {
        if (i10 == 8 || i10 == 9) {
            m25706I(this.f19398I, z10);
        } else if (i10 == 2) {
            m25706I(this.f19423y, z10);
        } else if (i10 == 5) {
            m25706I(this.f19399J, z10);
        }
    }

    /* renamed from: H */
    public final void m25705H() {
        this.f19401L.m24030m();
        if (this.f19403N) {
            return;
        }
        this.f19403N = true;
        ArrayList arrayList = new ArrayList();
        String string = this.f19594b.getString(R$string.backup_keep_connect_tip);
        String string2 = this.f19594b.getString(R$string.backup_loading_tip_background_run);
        arrayList.add(string);
        arrayList.add(string2);
        this.f19400K.setDataIfNotNull(arrayList);
        this.f19400K.setVisibility(0);
    }

    /* renamed from: I */
    public final void m25706I(View view, boolean z10) {
        if (view != null) {
            view.setVisibility((!z10 || C13452e.m80781L().m80791C0()) ? 8 : 0);
        }
    }

    /* renamed from: J */
    public void m25707J(float f10, String str, CloudBackupState cloudBackupState, boolean z10) {
        m25709L(3);
        this.f19418t.setProgress(f10);
        this.f19419u.setText(str);
        C13029h c13029hM75882n2 = C12590s0.m75882n2();
        m25850r(this.f19420v, m25841h(this.f19421w, cloudBackupState, c13029hM75882n2));
        this.f19420v.requestLayout();
        m25840g(this.f19422x, cloudBackupState, c13029hM75882n2);
        m25706I(this.f19423y, z10);
    }

    /* renamed from: K */
    public void m25708K(String str, String str2, boolean z10) {
        C11839m.m70686d("CloudBackupStateMainView", "showBackupScanning");
        m25709L(2);
        this.f19414p.setVisibility(8);
        this.f19412n.setVisibility(0);
        this.f19413o.setText(str);
        m25706I(this.f19399J, z10);
        setPrepareStatusBanner(str2);
    }

    /* renamed from: L */
    public final void m25709L(int i10) {
        this.f19404f = i10;
        if (i10 != 2) {
            this.f19402M = false;
            this.f19401L.m24030m();
            this.f19401L.setVisibility(8);
            this.f19403N = false;
            this.f19400K.m24030m();
            this.f19400K.setVisibility(8);
        }
        this.f19405g.setVisibility((i10 == 0 || i10 == 1) ? 0 : 8);
        this.f19411m.setVisibility(i10 == 2 ? 0 : 8);
        this.f19417s.setVisibility(i10 == 3 ? 0 : 8);
        this.f19424z.setVisibility(i10 == 4 ? 0 : 8);
        this.f19396G.setVisibility(i10 == 5 ? 0 : 8);
    }

    /* renamed from: M */
    public void m25710M(String str) {
        m25709L(5);
        C12809f.m76843p(this.f19397H, !C13452e.m80781L().m80887a1());
        this.f19397H.setText(str);
    }

    /* renamed from: N */
    public void m25711N(float f10, String str, String str2, boolean z10) {
        C11839m.m70686d("CloudBackupStateMainView", "showBackupingView progress = " + f10 + " tipOne = " + str + " tipTwo = " + str2);
        m25709L(2);
        this.f19414p.setVisibility(0);
        this.f19412n.setVisibility(8);
        this.f19415q.setProgress(f10);
        this.f19416r.setText(str);
        m25706I(this.f19398I, z10);
        m25705H();
    }

    /* renamed from: O */
    public void m25712O(final CloudBackupState cloudBackupState, boolean z10) {
        m25709L(4);
        this.f19390A.m25832b();
        if (m25696D(cloudBackupState.getLastSuccessTime())) {
            this.f19391B.setText(this.f19594b.getString(R$string.not_backup_morethan_six_months, 6));
        } else {
            int iM25715u = m25715u(cloudBackupState.getLastSuccessTime());
            this.f19391B.setText(this.f19594b.getResources().getQuantityString(R$plurals.no_backup_for_time, iM25715u, Integer.valueOf(iM25715u)));
        }
        if (z10) {
            this.f19392C.setVisibility(0);
            this.f19392C.setText(this.f19594b.getString(R$string.see_details));
            this.f19392C.setOnClickListener(new View.OnClickListener() { // from class: de.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f45838a.m25702E(view);
                }
            });
        } else {
            this.f19392C.setOnClickListener(null);
            this.f19392C.setVisibility(8);
        }
        C13029h c13029hM75882n2 = C12590s0.m75882n2();
        String strM25841h = m25841h(this.f19394E, cloudBackupState, c13029hM75882n2);
        if ((TextUtils.isEmpty(strM25841h) || cloudBackupState.isOverDayErrTipDismiss() || (cloudBackupState.getReturnCode() == 3001 && cloudBackupState.isCloudSpaceNotEnoughDismiss())) && !z10) {
            this.f19393D.setText(this.f19594b.getString(R$string.backup_not_complete_guide_tip_goto_handle));
            this.f19393D.setOnClickListener(new View.OnClickListener() { // from class: de.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f45839a.m25703F(cloudBackupState, view);
                }
            });
            this.f19393D.setTextColor(this.f19594b.getColor(R$color.stock_active_open_later_color_ff));
            this.f19393D.setBackground(getContext().getDrawable(R$drawable.attention_link_selector));
        } else {
            m25850r(this.f19393D, strM25841h);
            this.f19393D.setOnClickListener(null);
            this.f19393D.setTextColor(this.f19594b.getColor(R$color.emui_color_text_secondary));
            this.f19393D.requestLayout();
        }
        if (cloudBackupState.isOverDayErrTipDismiss() || (cloudBackupState.getReturnCode() == 3001 && cloudBackupState.isCloudSpaceNotEnoughDismiss())) {
            this.f19395F.setVisibility(8);
        } else {
            m25840g(this.f19395F, cloudBackupState, c13029hM75882n2);
        }
    }

    /* renamed from: P */
    public void m25713P() {
        if (1 == this.f19404f) {
            return;
        }
        C11839m.m70686d("CloudBackupStateMainView", "showCloseSwitchState");
        m25709L(1);
        this.f19406h.setVisibility(8);
        this.f19409k.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(RuleConfig.DEFAULT_BACKUP_RESTORE_TAR_COUNT);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        this.f19410l.startAnimation(rotateAnimation);
    }

    /* renamed from: Q */
    public void m25714Q(String str) {
        C11839m.m70686d("CloudBackupStateMainView", "showSwitchOpen switchOpenOneTip = " + str);
        m25709L(0);
        this.f19408j.setText(str);
        this.f19406h.setVisibility(0);
        this.f19409k.setVisibility(8);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(RuleConfig.DEFAULT_BACKUP_RESTORE_TAR_COUNT);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        this.f19407i.startAnimation(rotateAnimation);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.tv_backing_link || id2 == R$id.tv_pause_link || id2 == R$id.tv_back_link_one) {
            m25717w();
        }
    }

    /* renamed from: u */
    public final int m25715u(long j10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j10 > jCurrentTimeMillis) {
            jCurrentTimeMillis = j10;
        }
        long j11 = (jCurrentTimeMillis - j10) / 86400000;
        if (j11 == 0) {
            j11++;
        }
        return (int) j11;
    }

    /* renamed from: v */
    public final void m25716v(CloudBackupState cloudBackupState) {
        new BackupNotificationManager(this.f19594b).cancelNotification(24);
        C13225d.m79490f1().m79585f0("action_code_backupmain_go_to_handle", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_backupmain_go_to_handle", "1", "62");
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(new Intent(this.f19594b, (Class<?>) CloudGuideBackupActivity.class));
        if (cloudBackupState != null) {
            hiCloudSafeIntent.putExtra("backup_no_success_backup_state", new Gson().toJson(cloudBackupState));
        }
        this.f19594b.startActivity(hiCloudSafeIntent);
    }

    /* renamed from: w */
    public final void m25717w() {
        if (C13452e.m80781L().m80791C0()) {
            return;
        }
        Intent intent = new Intent(this.f19594b, (Class<?>) CloudBackupDetailStateActivity.class);
        intent.putExtra("entry_source", "entry_backup_main");
        this.f19594b.startActivity(intent);
    }

    /* renamed from: x */
    public final void m25718x(View view) {
        this.f19411m = (RelativeLayout) C12809f.m76831d(view, R$id.cloudbackup_backuping);
        this.f19412n = (RelativeLayout) C12809f.m76831d(view, R$id.rl_backup_scanning);
        this.f19413o = (TextView) C12809f.m76831d(this.f19411m, R$id.tv_backing_scanning_tip_one);
        this.f19399J = (TextView) C12809f.m76831d(this.f19411m, R$id.tv_back_link_one);
        this.f19401L = (TextBannerSwitcher) C12809f.m76831d(this.f19411m, R$id.tv_banner);
        setPrepareStatusBanner(null);
        this.f19414p = (RelativeLayout) C12809f.m76831d(view, R$id.rl_backing_state);
        this.f19415q = (CloudBackupBackingStateView) C12809f.m76831d(this.f19411m, R$id.bc_backing_animator_view);
        this.f19416r = (TextView) C12809f.m76831d(this.f19411m, R$id.tv_backing_tip_one);
        this.f19398I = (TextView) C12809f.m76831d(this.f19411m, R$id.tv_backing_link);
        this.f19400K = (TextBannerSwitcher) C12809f.m76831d(this.f19411m, R$id.tv_backipng_tip_two_banner);
        this.f19398I.setOnClickListener(this);
        this.f19399J.setOnClickListener(this);
    }

    /* renamed from: y */
    public final void m25719y(View view) {
        this.f19405g = (RelativeLayout) C12809f.m76831d(view, R$id.cloudbackup_default);
        this.f19406h = (RelativeLayout) C12809f.m76831d(this, R$id.rl_switch_open);
        this.f19407i = (ImageView) C12809f.m76831d(this, R$id.iv_open_out_circle);
        this.f19410l = (ImageView) C12809f.m76831d(this, R$id.iv_close_out_circle);
        TextView textView = (TextView) C12809f.m76831d(this, R$id.tv_switch_open_tip_one);
        this.f19408j = textView;
        textView.setText(R$string.backup_status_tip);
        BackupItemTipView backupItemTipView = (BackupItemTipView) C12809f.m76831d(this, R$id.ll_switch_open_tip_two);
        backupItemTipView.m25667c(R$string.backup_conditon_power, R$string.backup_conditon_lock, C2783d.m16179s1(R$string.backup_conditon_wlan, R$string.backup_conditon_wifi));
        backupItemTipView.m25666b(R$drawable.backup_condition_power, R$drawable.backup_condition_lock, R$drawable.backup_condition_wifi);
        this.f19409k = (RelativeLayout) C12809f.m76831d(this, R$id.rl_switch_close);
        TextView textView2 = (TextView) C12809f.m76831d(this, R$id.tv_switch_close_tip_one);
        textView2.setText(R$string.backup_status_close_tip);
        C12809f.m76843p(textView2, !C13452e.m80781L().m80858T0());
    }

    /* renamed from: z */
    public final void m25720z(View view) {
        this.f19396G = (RelativeLayout) C12809f.m76831d(view, R$id.cloudbackup_done);
        ((TextView) C12809f.m76831d(this, R$id.tv_backup_done_tip_one)).setText(R$string.backup_success);
        this.f19397H = (TextView) C12809f.m76831d(this, R$id.tv_backup_done_tip_two);
    }

    public CloudBackupStateMainView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloudBackupStateMainView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19594b = context;
        m25701C();
    }
}
