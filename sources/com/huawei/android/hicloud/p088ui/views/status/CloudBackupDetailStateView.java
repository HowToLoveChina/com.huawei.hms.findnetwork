package com.huawei.android.hicloud.p088ui.views.status;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.TextBannerSwitcher;
import com.huawei.android.hicloud.p088ui.extend.TextBannerView;
import com.huawei.android.hicloud.p088ui.temporarybackup.C4012a;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupSelectSpaceView;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12590s0;
import p618rm.C12600v1;
import p684un.C13225d;
import p709vj.C13452e;
import p848zl.C14339h;
import sk.C12809f;
import tl.C13029h;

/* loaded from: classes3.dex */
public class CloudBackupDetailStateView extends CloudBackupStateView {

    /* renamed from: A */
    public boolean f19565A;

    /* renamed from: f */
    public CloudBackupPrepareStateView f19566f;

    /* renamed from: g */
    public CloudBackupBackingStateView f19567g;

    /* renamed from: h */
    public CloudBackupPauseStateView f19568h;

    /* renamed from: i */
    public CloudBackupCompleteStateView f19569i;

    /* renamed from: j */
    public TextView f19570j;

    /* renamed from: k */
    public TextView f19571k;

    /* renamed from: l */
    public TextBannerView f19572l;

    /* renamed from: m */
    public TextView f19573m;

    /* renamed from: n */
    public TextBannerSwitcher f19574n;

    /* renamed from: o */
    public RelativeLayout f19575o;

    /* renamed from: p */
    public SpanClickText f19576p;

    /* renamed from: q */
    public View f19577q;

    /* renamed from: r */
    public ImageView f19578r;

    /* renamed from: s */
    public PopupWindow f19579s;

    /* renamed from: t */
    public PopupWindow f19580t;

    /* renamed from: u */
    public boolean f19581u;

    /* renamed from: v */
    public boolean f19582v;

    /* renamed from: w */
    public boolean f19583w;

    /* renamed from: x */
    public TempBackupSelectSpaceView f19584x;

    /* renamed from: y */
    public RelativeLayout f19585y;

    /* renamed from: z */
    public boolean f19586z;

    public interface BackupDetailStateType {
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.status.CloudBackupDetailStateView$a */
    public class ViewOnClickListenerC4292a implements View.OnClickListener {
        public ViewOnClickListenerC4292a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CloudBackupDetailStateView.this.m25824F(view);
        }
    }

    public CloudBackupDetailStateView(Context context) {
        this(context, null);
    }

    private void setShowPrepareingBanner(String... strArr) {
        if (this.f19583w) {
            return;
        }
        this.f19583w = true;
        List<CharSequence> listAsList = Arrays.asList(strArr);
        if (!this.f19586z) {
            this.f19575o.setVisibility(0);
            this.f19576p.setVisibility(8);
            this.f19574n.setDataIfNotNull(listAsList);
            this.f19574n.setVisibility(0);
            return;
        }
        this.f19575o.setVisibility(8);
        this.f19576p.setVisibility(0);
        boolean zM1354d = C0212e0.m1354d(C0213f.m1377a(), "tempBackupSpFile", "key_backup_start_or_resume", true);
        String string = this.f19594b.getString(R$string.temp_backup_special_instructions);
        String strM24662s = zM1354d ? C4012a.m24662s("temp_backup_prepare_all_data_tip", null, 1, 2, string) : C4012a.m24662s("temp_backup_prepare_resume_data_tip", null, string);
        C0212e0.m1374x(C0213f.m1377a(), "tempBackupSpFile", "key_backup_start_or_resume");
        C11839m.m70688i("BackupDetailStateView", "setShowPrepareingBanner = " + strM24662s + " ; " + zM1354d);
        if (TextUtils.isEmpty(strM24662s)) {
            C4012a.m24633Q(this.f19576p, this.f19584x.getType());
        } else {
            C4012a.m24634R(this.f19576p, strM24662s);
        }
    }

    /* renamed from: v */
    private void m25818v() {
        View viewInflate = View.inflate(getContext(), R$layout.backup_detail_state_layout, this);
        this.f19577q = viewInflate;
        ImageView imageView = (ImageView) C12809f.m76831d(viewInflate, R$id.iv_detail_pause_tip);
        this.f19578r = imageView;
        imageView.setOnClickListener(new ViewOnClickListenerC4292a());
        this.f19566f = (CloudBackupPrepareStateView) C12809f.m76831d(this.f19577q, R$id.backup_prepare_state);
        this.f19567g = (CloudBackupBackingStateView) C12809f.m76831d(this.f19577q, R$id.backup_backing_state);
        this.f19568h = (CloudBackupPauseStateView) C12809f.m76831d(this.f19577q, R$id.backup_pause_state);
        this.f19569i = (CloudBackupCompleteStateView) C12809f.m76831d(this.f19577q, R$id.backup_complete_state);
        this.f19570j = (TextView) C12809f.m76831d(this.f19577q, R$id.backup_state_tv);
        this.f19574n = (TextBannerSwitcher) C12809f.m76831d(this.f19577q, R$id.backup_detail_tbv);
        this.f19575o = (RelativeLayout) C12809f.m76831d(this.f19577q, R$id.backup_detail_banner_layout);
        this.f19571k = (TextView) C12809f.m76831d(this.f19577q, R$id.backup_detail_tv2);
        this.f19572l = (TextBannerView) C12809f.m76831d(this.f19577q, R$id.backup_detail_tv2_banner);
        this.f19573m = (TextView) C12809f.m76831d(this.f19577q, R$id.tv_detail_pause_tip_three);
        TempBackupSelectSpaceView tempBackupSelectSpaceView = (TempBackupSelectSpaceView) C12809f.m76831d(this.f19577q, R$id.temp_select_space_view);
        this.f19584x = tempBackupSelectSpaceView;
        tempBackupSelectSpaceView.setVisibility(8);
        SpanClickText spanClickText = (SpanClickText) C12809f.m76831d(this.f19577q, R$id.temp_tips);
        this.f19576p = spanClickText;
        C4012a.m24633Q(spanClickText, this.f19584x.getType());
        this.f19572l.setVisibility(8);
        this.f19585y = (RelativeLayout) C12809f.m76831d(this.f19577q, R$id.backups_loading);
    }

    /* renamed from: A */
    public void m25819A(int i10, String str, String... strArr) {
        C11839m.m70686d("BackupDetailStateView", "onPrepareState showPop = " + this.f19581u);
        if (this.f19581u) {
            PopupWindow popupWindow = this.f19579s;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.f19579s.dismiss();
            }
            PopupWindow popupWindow2 = this.f19580t;
            if (popupWindow2 != null && popupWindow2.isShowing()) {
                this.f19580t.dismiss();
            }
        }
        if (this.f19586z) {
            this.f19570j.setText(C4012a.m24662s("temp_backup_prepare_all_data_state", getResources().getString(R$string.backup_preparing_notification_content), new Object[0]));
        } else {
            this.f19570j.setText(str);
        }
        m25823E(0);
        setShowPrepareingBanner(strArr);
        m25820B(0, i10);
    }

    /* renamed from: B */
    public void m25820B(int i10, int i11) {
        if (!this.f19586z) {
            C11839m.m70686d("BackupDetailStateView", "isTempBackup is false");
            return;
        }
        C11839m.m70686d("BackupDetailStateView", "state:" + i10 + ",itemSize:" + i11);
        if (i10 != 0) {
            this.f19585y.setVisibility(8);
            if (this.f19565A || i11 <= 1) {
                return;
            }
            this.f19565A = true;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            return;
        }
        this.f19585y.setVisibility(i11 <= 1 ? 0 : 8);
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (i11 > 1) {
            this.f19565A = true;
            layoutParams2.width = -1;
            layoutParams2.height = -2;
        } else {
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            if (!C11842p.m70753O0(getContext()) || C11842p.m70771U0()) {
                return;
            }
            layoutParams2.height = -2;
        }
    }

    /* renamed from: C */
    public void m25821C() {
        if (this.f19586z && C13452e.m80781L().m80907e1()) {
            this.f19584x.setVisibility(0);
        }
    }

    /* renamed from: D */
    public final void m25822D() {
        if (this.f19582v) {
            return;
        }
        this.f19582v = true;
        ArrayList arrayList = new ArrayList();
        String string = this.f19594b.getString(R$string.backup_keep_connect_tip);
        String string2 = this.f19594b.getString(R$string.backup_loading_tip_background_run);
        arrayList.add(string);
        arrayList.add(string2);
        this.f19572l.setDatas(arrayList);
        this.f19572l.setVisibility(0);
    }

    /* renamed from: E */
    public final void m25823E(int i10) {
        String strM25826u = m25826u(i10);
        if (i10 != 2) {
            this.f19573m.setVisibility(8);
        }
        if (i10 != 1) {
            this.f19582v = false;
            this.f19572l.m24041i();
        }
        if (i10 != 0) {
            this.f19583w = false;
            this.f19574n.m24030m();
        }
        if (this.f19586z) {
            this.f19575o.setVisibility(8);
            this.f19576p.setVisibility(0);
            if (i10 != 0) {
                if (TextUtils.isEmpty(strM25826u)) {
                    C4012a.m24633Q(this.f19576p, this.f19584x.getType());
                } else {
                    C4012a.m24634R(this.f19576p, strM25826u);
                }
            }
            this.f19584x.setClickable(i10 == 2);
        } else {
            this.f19575o.setVisibility(0);
            this.f19576p.setVisibility(8);
            this.f19574n.setVisibility(i10 == 0 ? 0 : 8);
        }
        this.f19571k.setVisibility(i10 == 0 ? 8 : 0);
        this.f19578r.setVisibility(i10 == 2 ? 0 : 8);
        this.f19566f.setVisibility(i10 == 0 ? 0 : 8);
        this.f19567g.setVisibility(i10 == 1 ? 0 : 8);
        this.f19568h.setVisibility(i10 == 2 ? 0 : 8);
        this.f19569i.setVisibility(i10 == 3 ? 0 : 8);
    }

    /* renamed from: F */
    public final void m25824F(View view) {
        PopupWindow popupWindow = new PopupWindow(LayoutInflater.from(getContext()).inflate(R$layout.detail_pause_tip_arrow, (ViewGroup) null), -2, -2);
        this.f19580t = popupWindow;
        popupWindow.setOutsideTouchable(true);
        PopupWindow popupWindow2 = new PopupWindow(C0209d.m1195O(this.f19594b) >= 1.75f ? LayoutInflater.from(getContext()).inflate(R$layout.detail_pause_tip_scale, (ViewGroup) null) : LayoutInflater.from(getContext()).inflate(R$layout.detail_pause_tip, (ViewGroup) null), -2, -2);
        this.f19579s = popupWindow2;
        popupWindow2.setOutsideTouchable(true);
        this.f19580t.showAsDropDown(view);
        this.f19579s.showAsDropDown(view, -C11842p.m70840n(getContext(), (int) getResources().getDimension(R$dimen.cloud_space_16_dp)), 0);
        this.f19581u = true;
        this.f19579s.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ee.a
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f47200a.m25827w();
            }
        });
        C11839m.m70686d("BackupDetailStateView", "showPopTip showPop = " + this.f19581u);
        C13225d.m79490f1().m79585f0("action_code_backup_detail_latest_data", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_backup_detail_latest_data", "1", "77");
    }

    public TempBackupSelectSpaceView getTempSelectSpaceView() {
        return this.f19584x;
    }

    @Override // com.huawei.android.hicloud.p088ui.views.status.CloudBackupStateView
    /* renamed from: q */
    public void mo25825q(String str, boolean z10) {
        super.mo25825q(str, z10);
        this.f19586z = z10;
        m25821C();
    }

    public void setBackingProgress(int i10) throws Resources.NotFoundException {
        this.f19567g.setProgress(i10);
    }

    public void setPauseProgress(float f10) throws Resources.NotFoundException {
        this.f19568h.setProgress(f10);
    }

    /* renamed from: u */
    public final String m25826u(int i10) {
        if (this.f19586z && i10 == 1) {
            return C4012a.m24662s("temp_backup_backing_tip", null, getResources().getString(R$string.temp_backup_special_instructions));
        }
        return null;
    }

    /* renamed from: w */
    public final /* synthetic */ void m25827w() {
        this.f19581u = false;
    }

    /* renamed from: x */
    public void m25828x(float f10, String str, int i10) throws Resources.NotFoundException {
        C11839m.m70686d("BackupDetailStateView", "onBackingState showPop = " + this.f19581u);
        m25823E(1);
        this.f19567g.setProgress(f10);
        this.f19574n.m24030m();
        this.f19572l.setVisibility(0);
        this.f19571k.setVisibility(8);
        this.f19570j.setText(str);
        m25822D();
        m25820B(1, i10);
    }

    /* renamed from: y */
    public void m25829y(String str, int i10) {
        m25823E(3);
        this.f19572l.setVisibility(8);
        C12809f.m76843p(this.f19571k, !C13452e.m80781L().m80887a1());
        this.f19574n.m24030m();
        this.f19571k.setText(str);
        this.f19570j.setText(getContext().getString(R$string.backup_success));
        m25820B(3, i10);
    }

    /* renamed from: z */
    public void m25830z(String str, CloudBackupState cloudBackupState, int i10) {
        m25823E(2);
        this.f19574n.m24030m();
        C13029h c13029hM75882n2 = C12590s0.m75882n2();
        String strM25841h = m25841h(null, cloudBackupState, c13029hM75882n2);
        int i11 = 0;
        if (this.f19586z) {
            str = C4012a.m24662s("temp_backup_pause_due_to_error_state", str, new Object[0]);
            if (C14339h.m85503b().contains(Integer.valueOf(cloudBackupState.getReturnCode()))) {
                this.f19576p.setText(C4012a.m24662s("temp_backup_pause_due_to_screen_lock_tip", getResources().getString(R$string.auto_backup_failed_screen), new Object[0]));
            } else if (C14339h.m85517p().contains(Integer.valueOf(cloudBackupState.getReturnCode()))) {
                String strM24662s = C4012a.m24662s("temp_backup_pause_due_to_space_tip", null, new Object[0]);
                if (TextUtils.isEmpty(strM24662s)) {
                    C4012a.m24637U(this.f19576p, R$string.temp_backup_not_enough_space);
                } else {
                    this.f19576p.setText(strM24662s);
                }
            } else if (3939 == cloudBackupState.getReturnCode()) {
                Resources resources = getResources();
                int i12 = R$plurals.temp_backup_limit_times_content;
                int i13 = C12600v1.f57997g;
                this.f19576p.setText(C4012a.m24662s("temp_backup_pause_due_to_limit_times_tip", resources.getQuantityString(i12, i13, Integer.valueOf(i13)), Integer.valueOf(C12600v1.f57997g)));
            } else if (3940 == cloudBackupState.getReturnCode()) {
                this.f19578r.setVisibility(8);
                str = C4012a.m24662s("temp_backup_pause_due_to_busy_state", str, new Object[0]);
                this.f19576p.setText(C4012a.m24662s("temp_backup_pause_due_to_busy_tip", getResources().getString(R$string.temp_backup_too_many_people_content), new Object[0]));
            } else if (C14339h.m85514m().contains(Integer.valueOf(cloudBackupState.getReturnCode()))) {
                C4012a.m24636T(this.f19576p, "temp_backup_pause_due_to_network_tip");
            } else if (C14339h.m85502a().contains(Integer.valueOf(cloudBackupState.getReturnCode()))) {
                this.f19576p.setText(C4012a.m24662s("temp_backup_pause_due_to_power_tip", getResources().getString(R$string.auto_backup_failed_power), new Object[0]));
            } else if (C14339h.m85505d().contains(Integer.valueOf(cloudBackupState.getReturnCode()))) {
                String strM16144h = C2783d.m16144h(10);
                this.f19576p.setText(C4012a.m24662s("temp_backup_pause_due_to_battery_tip", getResources().getString(R$string.cloud_backup_failed_battery2, strM16144h), strM16144h));
            } else if (TextUtils.isEmpty(strM25841h)) {
                String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("temp_backup_pause_tips");
                if (!TextUtils.isEmpty(spaceMultLanguage)) {
                    str = spaceMultLanguage;
                    i11 = 8;
                }
            } else {
                m25850r(this.f19576p, strM25841h);
            }
            this.f19576p.setVisibility(i11);
            this.f19571k.setVisibility(8);
        } else {
            m25850r(this.f19571k, strM25841h);
            this.f19571k.setVisibility(0);
        }
        this.f19572l.setVisibility(8);
        m25840g(this.f19573m, cloudBackupState, c13029hM75882n2);
        this.f19570j.setText(str);
        this.f19570j.requestLayout();
        m25820B(2, i10);
    }

    public CloudBackupDetailStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloudBackupDetailStateView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m25818v();
    }
}
