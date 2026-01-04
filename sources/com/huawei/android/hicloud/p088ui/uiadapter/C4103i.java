package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupSpaceDetailAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.RoundRectImageView;
import com.huawei.android.hicloud.p088ui.uiextend.TipPopupLayout;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import p848zl.C14333b;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.uiadapter.i */
/* loaded from: classes3.dex */
public class C4103i extends RecyclerView.AbstractC0833c0 {

    /* renamed from: A */
    public TextView f19160A;

    /* renamed from: B */
    public CheckBox f19161B;

    /* renamed from: C */
    public View f19162C;

    /* renamed from: D */
    public TipPopupLayout f19163D;

    /* renamed from: E */
    public ImageView f19164E;

    /* renamed from: F */
    public ImageButton f19165F;

    /* renamed from: G */
    public HwProgressBar f19166G;

    /* renamed from: H */
    public final Context f19167H;

    /* renamed from: I */
    public BackupSpaceDetailAdapter.DeleteBackupModuleListener f19168I;

    /* renamed from: J */
    public View.OnClickListener f19169J;

    /* renamed from: K */
    public final View f19170K;

    /* renamed from: u */
    public LinearLayout f19171u;

    /* renamed from: v */
    public RelativeLayout f19172v;

    /* renamed from: w */
    public RoundRectImageView f19173w;

    /* renamed from: x */
    public ImageView f19174x;

    /* renamed from: y */
    public TextView f19175y;

    /* renamed from: z */
    public TextView f19176z;

    public C4103i(View view) {
        super(view);
        this.f19167H = view.getContext();
        this.f19170K = view;
        this.f19172v = (RelativeLayout) C12809f.m76831d(view, R$id.backup_option_list_item_content);
        this.f19173w = (RoundRectImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon);
        this.f19174x = (ImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon_badge);
        this.f19175y = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_title);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_value);
        this.f19176z = textView;
        C12809f.m76843p(textView, false);
        this.f19160A = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_tip);
        this.f19161B = (CheckBox) C12809f.m76831d(view, R$id.item_checkbox);
        this.f19162C = C12809f.m76831d(view, R$id.backup_option_item_divider);
        TipPopupLayout tipPopupLayout = (TipPopupLayout) C12809f.m76831d(view, R$id.basic_detail_iv);
        this.f19163D = tipPopupLayout;
        tipPopupLayout.setImageViewPic(R$drawable.ic_about_option);
        this.f19164E = (ImageView) C12809f.m76831d(view, R$id.expandable_iv);
        this.f19165F = (ImageButton) C12809f.m76831d(view, R$id.backup_module_delete);
        this.f19166G = (HwProgressBar) C12809f.m76831d(view, R$id.delete_loading_progress);
        this.f19171u = (LinearLayout) C12809f.m76831d(view, R$id.backup_option_list_item);
    }

    /* renamed from: Q */
    private String m25526Q(AppDetailsInfo appDetailsInfo) {
        if (appDetailsInfo == null) {
            return "";
        }
        String str = appDetailsInfo.getProperties() != null ? appDetailsInfo.getProperties().get(SnapshotBackupMeta.KEY_STRING_APP_NAME) : "";
        return ("thirdAppData".equals(appDetailsInfo.getParentId()) && appDetailsInfo.getExistSplit().booleanValue()) ? this.f19167H.getString(R$string.item_contains_twin_label, str) : str;
    }

    /* renamed from: R */
    private void m25527R(final AppDetailsInfo appDetailsInfo, final int i10, final String str) {
        this.f19165F.setOnClickListener(new View.OnClickListener() { // from class: ae.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f534a.m25529V(appDetailsInfo, i10, str, view);
            }
        });
    }

    /* renamed from: S */
    private void m25528S() {
        this.f19172v.setMinimumHeight((int) TypedValue.applyDimension(1, this.f19160A.getVisibility() == 0 ? 96.0f : 72.0f, this.f19167H.getResources().getDisplayMetrics()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public /* synthetic */ void m25529V(AppDetailsInfo appDetailsInfo, int i10, String str, View view) {
        BackupSpaceDetailAdapter.DeleteBackupModuleListener deleteBackupModuleListener;
        if (appDetailsInfo == null || (deleteBackupModuleListener = this.f19168I) == null) {
            return;
        }
        deleteBackupModuleListener.mo20020r0(i10, str);
    }

    /* renamed from: Y */
    private void m25530Y(int i10, int i11) {
        if (i10 == i11 - 1) {
            this.f19162C.setVisibility(8);
        } else {
            this.f19162C.setVisibility(0);
        }
    }

    /* renamed from: Z */
    private void m25531Z(AppDetailsInfo appDetailsInfo, int i10, String str) {
        if ("baseData".equals(str) || TextUtils.equals("basic_system_data", appDetailsInfo.getBackupAppName())) {
            this.f19163D.setVisibility(0);
            this.f19163D.setOnClickListener(this.f19169J);
            this.f19161B.setVisibility(8);
            this.f19165F.setVisibility(8);
            this.f19160A.setVisibility(8);
            this.f19160A.setText(this.f19167H.getString(R$string.cloudbackup_base_data_tip));
            this.f19166G.setVisibility(8);
            return;
        }
        this.f19163D.setVisibility(8);
        this.f19164E.setVisibility(8);
        if (appDetailsInfo.getUiStyle() == 1) {
            this.f19161B.setVisibility(0);
            this.f19165F.setVisibility(8);
            this.f19166G.setVisibility(8);
            this.f19161B.setChecked(appDetailsInfo.isCheck());
        } else if (appDetailsInfo.getUiStyle() == 0) {
            this.f19161B.setChecked(false);
            this.f19165F.setVisibility(0);
            this.f19165F.setTag(Integer.valueOf(i10));
            this.f19166G.setVisibility(8);
            this.f19161B.setVisibility(8);
        } else {
            this.f19161B.setChecked(false);
            this.f19165F.setVisibility(8);
            this.f19166G.setVisibility(0);
            this.f19161B.setVisibility(8);
        }
        this.f19160A.setVisibility(8);
    }

    /* renamed from: T */
    public void m25532T(C4103i c4103i, AppDetailsInfo appDetailsInfo, int i10, int i11) {
        String backupAppName = appDetailsInfo.getBackupAppName();
        m25533U(c4103i, backupAppName, appDetailsInfo);
        m25527R(appDetailsInfo, i10, backupAppName);
        m25531Z(appDetailsInfo, i10, backupAppName);
        m25530Y(i10, i11);
        m25528S();
    }

    /* renamed from: U */
    public final void m25533U(C4103i c4103i, String str, AppDetailsInfo appDetailsInfo) {
        if (SplitAppUtil.hasSplitAppSuffix(str)) {
            this.f19174x.setVisibility(0);
        } else {
            this.f19174x.setVisibility(8);
        }
        if (SplitAppUtil.hasSplitAppSuffix(str)) {
            str = SplitAppUtil.getSplitOriAppId(str);
        }
        if (appDetailsInfo.isVirtualApp()) {
            String virtualName = CloudBackupLanguageUtil.getVirtualName(str);
            TextView textView = this.f19175y;
            if (TextUtils.isEmpty(virtualName)) {
                virtualName = m25526Q(appDetailsInfo);
            }
            textView.setText(virtualName);
            this.f19173w.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str, null), false);
            return;
        }
        if (C14333b.m85483r().containsKey(str)) {
            this.f19175y.setText(C2783d.m16079E(this.f19167H, str));
            this.f19173w.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str), false);
        } else {
            this.f19175y.setText(C14333b.f63653e.containsKey(str) ? C2783d.m16079E(this.f19167H, str) : m25526Q(appDetailsInfo));
            this.f19173w.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(str), false);
        }
    }

    /* renamed from: W */
    public void m25534W(BackupSpaceDetailAdapter.DeleteBackupModuleListener deleteBackupModuleListener) {
        this.f19168I = deleteBackupModuleListener;
    }

    /* renamed from: X */
    public void m25535X(View.OnClickListener onClickListener) {
        this.f19169J = onClickListener;
    }
}
