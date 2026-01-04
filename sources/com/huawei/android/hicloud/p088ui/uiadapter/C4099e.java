package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.BackupOptionHeaderDataBean;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupOptionAdapter;
import com.huawei.android.hicloud.p088ui.views.BackupOptionBasicDataView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p514o9.C11839m;
import p514o9.C11842p;
import p550pb.C12126b;
import p618rm.C12590s0;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.uiadapter.e */
/* loaded from: classes3.dex */
public class C4099e extends RecyclerView.AbstractC0833c0 {

    /* renamed from: A */
    public TextView f19111A;

    /* renamed from: B */
    public TextView f19112B;

    /* renamed from: C */
    public LinearLayout f19113C;

    /* renamed from: D */
    public LinearLayout f19114D;

    /* renamed from: E */
    public TextView f19115E;

    /* renamed from: F */
    public TextView f19116F;

    /* renamed from: G */
    public TextView f19117G;

    /* renamed from: H */
    public TextView f19118H;

    /* renamed from: I */
    public LinearLayout f19119I;

    /* renamed from: J */
    public LinearLayout f19120J;

    /* renamed from: K */
    public BackupOptionBasicDataView f19121K;

    /* renamed from: L */
    public SpanClickText f19122L;

    /* renamed from: u */
    public Context f19123u;

    /* renamed from: v */
    public Resources f19124v;

    /* renamed from: w */
    public HwProgressBar f19125w;

    /* renamed from: x */
    public TextView f19126x;

    /* renamed from: y */
    public TextView f19127y;

    /* renamed from: z */
    public ImageView f19128z;

    public C4099e(View view, BackupOptionAdapter.UpdateOptionStatusListener updateOptionStatusListener) throws Resources.NotFoundException {
        super(view);
        this.f19124v = null;
        Context context = view.getContext();
        this.f19123u = context;
        if (context != null) {
            this.f19124v = context.getResources();
        }
        m25467T(updateOptionStatusListener);
        m25464Q();
        m25466S();
        m25465R();
        m25473Z();
    }

    /* renamed from: Q */
    public final void m25464Q() {
        boolean zM80887a1 = C13452e.m80781L().m80887a1();
        this.f19121K.setVisibility(zM80887a1 ? 0 : 8);
        if (!zM80887a1) {
            this.f19120J.setBackground(null);
            this.f19120J.setPadding(0, (int) C11842p.m70844o(this.f19123u, 4), 0, (int) C11842p.m70844o(this.f19123u, 10));
        }
        m25476c0();
    }

    /* renamed from: R */
    public final void m25465R() {
        Resources resources = this.f19124v;
        if (resources == null) {
            return;
        }
        TextView textView = this.f19111A;
        int i10 = R$string.backup_loading;
        textView.setText(resources.getString(i10));
        this.f19115E.setText(this.f19124v.getString(R$string.backup_already_size));
        this.f19112B.setText(this.f19124v.getString(i10));
        this.f19117G.setText(this.f19124v.getString(R$string.backup_wait_size));
        this.f19116F.setText(this.f19124v.getString(i10));
        this.f19127y.setText(this.f19124v.getString(i10));
    }

    /* renamed from: S */
    public final void m25466S() {
        if (C13452e.m80781L().m80887a1()) {
            this.f19119I.setVisibility(8);
            this.f19113C.setVisibility(8);
            this.f19114D.setVisibility(8);
            this.f19118H.setText(R$string.full_data_new);
            this.f19111A.setVisibility(8);
            return;
        }
        this.f19119I.setVisibility(0);
        this.f19113C.setVisibility(0);
        this.f19114D.setVisibility(0);
        this.f19118H.setText(R$string.backup_choose_backup_data);
        this.f19111A.setVisibility(0);
    }

    /* renamed from: T */
    public final void m25467T(BackupOptionAdapter.UpdateOptionStatusListener updateOptionStatusListener) {
        this.f19125w = (HwProgressBar) C12809f.m76831d(this.f4327a, R$id.progress_loading);
        this.f19126x = (TextView) C12809f.m76831d(this.f4327a, R$id.tv_loading_tip);
        this.f19127y = (TextView) C12809f.m76831d(this.f4327a, R$id.current_title);
        this.f19128z = (ImageView) C12809f.m76831d(this.f4327a, R$id.general_device_icon);
        this.f19111A = (TextView) C12809f.m76831d(this.f4327a, R$id.tv_last_successful_backup_time);
        this.f19113C = (LinearLayout) C12809f.m76831d(this.f4327a, R$id.tv_backuped_size_view);
        this.f19114D = (LinearLayout) C12809f.m76831d(this.f4327a, R$id.tv_backuped_size_view_split_line);
        this.f19115E = (TextView) C12809f.m76831d(this.f4327a, R$id.tv_backuped_size_value_title);
        this.f19112B = (TextView) C12809f.m76831d(this.f4327a, R$id.tv_backuped_size_value);
        this.f19117G = (TextView) C12809f.m76831d(this.f4327a, R$id.wait_datasize_title);
        this.f19116F = (TextView) C12809f.m76831d(this.f4327a, R$id.wait_datasize_value);
        this.f19118H = (TextView) C12809f.m76831d(this.f4327a, R$id.tv_full_data_title);
        this.f19119I = (LinearLayout) C12809f.m76831d(this.f4327a, R$id.ll_top_line);
        BackupOptionBasicDataView backupOptionBasicDataView = (BackupOptionBasicDataView) C12809f.m76831d(this.f4327a, R$id.basic_data_card_view);
        this.f19121K = backupOptionBasicDataView;
        backupOptionBasicDataView.m25672e(updateOptionStatusListener);
        this.f19120J = (LinearLayout) C12809f.m76831d(this.f4327a, R$id.member_choice_title_layout);
        this.f19122L = (SpanClickText) C12809f.m76831d(this.f4327a, R$id.tv_backup_option_guide_subscribe_tip);
    }

    /* renamed from: U */
    public final /* synthetic */ void m25468U() {
        if (C0209d.m1226Y0() || this.f19122L == null) {
            return;
        }
        C11839m.m70688i("BackupOptionDataHeaderHolder", "set setGuideSubscribeTipLink on click");
        Bundle bundle = new Bundle();
        bundle.putInt("nav_source", 22);
        C12126b.m72706b(this.f19123u, "2", bundle, true, 1000);
        m25469V("basic_service_guide_click");
    }

    /* renamed from: V */
    public final void m25469V(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("basic_service_click_type", str);
        C13225d.m79490f1().m79567R("action_code_backup_appdata_basic_service_guide", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "action_code_backup_appdata_basic_service_guide", linkedHashMapM79497A);
    }

    /* renamed from: W */
    public final void m25470W() {
        this.f19126x.setVisibility(8);
        SpanClickText.ISpanClickListener iSpanClickListener = new SpanClickText.ISpanClickListener() { // from class: ae.u
            @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
            public final void onClick() {
                this.f627a.m25468U();
            }
        };
        String string = this.f19123u.getString(R$string.get_premium);
        String string2 = this.f19123u.getString(R$string.backup_option_guide_subscribe_tips, string);
        this.f19122L.m15931c(string, iSpanClickListener);
        this.f19122L.m15934g(string2, false);
        this.f19122L.setVisibility(0);
        this.f19122L.setContentDescription(string2);
        this.f19122L.setAccessibilityDelegate(new View.AccessibilityDelegate());
    }

    /* renamed from: X */
    public final void m25471X(String str) {
        this.f19116F.setText(str);
        this.f19126x.setVisibility(8);
        this.f19125w.setVisibility(8);
    }

    /* renamed from: Y */
    public final void m25472Y(long j10) {
        if (j10 >= 0) {
            this.f19112B.setText(C0223k.m1524g(C0213f.m1377a(), j10));
        }
    }

    /* renamed from: Z */
    public final void m25473Z() throws Resources.NotFoundException {
        if (this.f19124v == null) {
            return;
        }
        this.f19127y.setText(this.f19124v.getString(R$string.cloudbackup_self_device_new_update, C12590s0.m75814X()));
    }

    /* renamed from: a0 */
    public final void m25474a0(boolean z10) {
        TextView textView = this.f19126x;
        if (textView == null) {
            return;
        }
        textView.setVisibility(z10 ? 0 : 8);
    }

    /* renamed from: b0 */
    public final void m25475b0(Drawable drawable) {
        if (drawable != null) {
            this.f19128z.setImageDrawable(drawable);
        } else {
            this.f19128z.setImageResource(C11842p.m70762R0() ? R$drawable.ic_public_pad : R$drawable.ic_agr_phone);
        }
    }

    /* renamed from: c0 */
    public final void m25476c0() {
        if (C13452e.m80781L().m80791C0()) {
            m25470W();
        } else {
            this.f19122L.setVisibility(8);
        }
    }

    /* renamed from: d0 */
    public final void m25477d0(long j10) {
        if (this.f19124v == null) {
            return;
        }
        if (j10 != 0) {
            this.f19111A.setText(this.f19124v.getString(R$string.backup_time1, DateUtils.formatDateTime(this.f19123u, j10, C11842p.m70824j())));
        } else {
            String strM1524g = C0223k.m1524g(this.f19123u, 0L);
            if (strM1524g != null) {
                this.f19112B.setText(strM1524g);
            }
            this.f19111A.setVisibility(8);
        }
    }

    /* renamed from: e0 */
    public void m25478e0(BackupOptionHeaderDataBean backupOptionHeaderDataBean) {
        C11839m.m70688i("BackupOptionDataHeaderHolder", "basic header updateview");
        if (backupOptionHeaderDataBean != null) {
            if (backupOptionHeaderDataBean.getBaseDataList() != null) {
                this.f19121K.m25673f(backupOptionHeaderDataBean.getBaseDataList(), true);
            }
            if (!TextUtils.isEmpty(backupOptionHeaderDataBean.getWaitBackupSize())) {
                m25471X(backupOptionHeaderDataBean.getWaitBackupSize());
            }
            m25474a0(backupOptionHeaderDataBean.isShowLoading());
            if (backupOptionHeaderDataBean.getAlreadyBackupSize() > 0) {
                m25472Y(backupOptionHeaderDataBean.getAlreadyBackupSize());
            }
            m25477d0(backupOptionHeaderDataBean.getLastBackupTime());
            m25475b0(backupOptionHeaderDataBean.getDeviceIcon());
            m25476c0();
        }
    }
}
