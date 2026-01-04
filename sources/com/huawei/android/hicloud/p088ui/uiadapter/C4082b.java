package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import p015ak.C0223k;
import p848zl.C14333b;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.uiadapter.b */
/* loaded from: classes3.dex */
public class C4082b extends RecyclerView.AbstractC0833c0 {

    /* renamed from: A */
    public TextView f18982A;

    /* renamed from: B */
    public CheckBox f18983B;

    /* renamed from: C */
    public View f18984C;

    /* renamed from: D */
    public ImageView f18985D;

    /* renamed from: E */
    public ImageView f18986E;

    /* renamed from: F */
    public ImageButton f18987F;

    /* renamed from: G */
    public HwProgressBar f18988G;

    /* renamed from: H */
    public final Context f18989H;

    /* renamed from: I */
    public final boolean f18990I;

    /* renamed from: J */
    public BackupSpaceDetailAdapter.DeleteBackupModuleListener f18991J;

    /* renamed from: K */
    public View.OnClickListener f18992K;

    /* renamed from: L */
    public final View f18993L;

    /* renamed from: u */
    public LinearLayout f18994u;

    /* renamed from: v */
    public RelativeLayout f18995v;

    /* renamed from: w */
    public RoundRectImageView f18996w;

    /* renamed from: x */
    public ImageView f18997x;

    /* renamed from: y */
    public TextView f18998y;

    /* renamed from: z */
    public TextView f18999z;

    public C4082b(View view, boolean z10, View.OnClickListener onClickListener) {
        super(view);
        this.f18989H = view.getContext();
        this.f18990I = z10;
        this.f18992K = onClickListener;
        this.f18993L = view;
        this.f18995v = (RelativeLayout) C12809f.m76831d(view, R$id.backup_option_list_item_content);
        this.f18996w = (RoundRectImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon);
        this.f18997x = (ImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon_badge);
        this.f18998y = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_title);
        this.f18999z = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_value);
        this.f18982A = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_tip);
        this.f18983B = (CheckBox) C12809f.m76831d(view, R$id.item_checkbox);
        this.f18984C = C12809f.m76831d(view, R$id.backup_option_item_divider);
        this.f18985D = (ImageView) C12809f.m76831d(view, R$id.detail_iv);
        this.f18986E = (ImageView) C12809f.m76831d(view, R$id.expandable_iv);
        ImageButton imageButton = (ImageButton) C12809f.m76831d(view, R$id.backup_module_delete);
        this.f18987F = imageButton;
        if (z10) {
            imageButton.setVisibility(8);
        }
        this.f18988G = (HwProgressBar) C12809f.m76831d(view, R$id.delete_loading_progress);
        this.f18994u = (LinearLayout) C12809f.m76831d(view, R$id.backup_option_list_item);
    }

    /* renamed from: Q */
    public final String m25351Q(AppDetailsInfo appDetailsInfo) {
        if (appDetailsInfo == null) {
            return "";
        }
        String str = appDetailsInfo.getProperties() != null ? appDetailsInfo.getProperties().get(SnapshotBackupMeta.KEY_STRING_APP_NAME) : "";
        return ("thirdAppData".equals(appDetailsInfo.getParentId()) && appDetailsInfo.getExistSplit().booleanValue()) ? this.f18989H.getString(R$string.item_contains_twin_label, str) : str;
    }

    /* renamed from: R */
    public final void m25352R(final AppDetailsInfo appDetailsInfo, final int i10, final String str) {
        this.f18987F.setOnClickListener(new View.OnClickListener() { // from class: ae.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f538a.m25356V(appDetailsInfo, i10, str, view);
            }
        });
    }

    /* renamed from: S */
    public final void m25353S() {
        this.f18995v.setMinimumHeight((int) TypedValue.applyDimension(1, this.f18982A.getVisibility() == 0 ? 96.0f : 72.0f, this.f18989H.getResources().getDisplayMetrics()));
    }

    /* renamed from: T */
    public void m25354T(C4082b c4082b, AppDetailsInfo appDetailsInfo, int i10, int i11) {
        String backupAppName = appDetailsInfo.getBackupAppName();
        m25355U(c4082b, backupAppName, appDetailsInfo);
        m25352R(appDetailsInfo, i10, backupAppName);
        m25361a0(appDetailsInfo, i10, backupAppName);
        m25360Z(i10, i11);
        m25353S();
    }

    /* renamed from: U */
    public final void m25355U(C4082b c4082b, String str, AppDetailsInfo appDetailsInfo) {
        if (SplitAppUtil.hasSplitAppSuffix(str)) {
            this.f18997x.setVisibility(0);
        } else {
            this.f18997x.setVisibility(8);
        }
        if (SplitAppUtil.hasSplitAppSuffix(str)) {
            str = SplitAppUtil.getSplitOriAppId(str);
        }
        if (appDetailsInfo.isVirtualApp()) {
            String virtualName = CloudBackupLanguageUtil.getVirtualName(str);
            TextView textView = this.f18998y;
            if (TextUtils.isEmpty(virtualName)) {
                virtualName = m25351Q(appDetailsInfo);
            }
            textView.setText(virtualName);
            this.f18996w.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str, null), false);
            return;
        }
        if (C14333b.m85483r().containsKey(str)) {
            this.f18998y.setText(C2783d.m16079E(this.f18989H, str));
            this.f18996w.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str), false);
        } else {
            this.f18998y.setText(C14333b.f63653e.containsKey(str) ? C2783d.m16079E(this.f18989H, str) : m25351Q(appDetailsInfo));
            this.f18996w.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(str), false);
        }
    }

    /* renamed from: V */
    public final /* synthetic */ void m25356V(AppDetailsInfo appDetailsInfo, int i10, String str, View view) {
        BackupSpaceDetailAdapter.DeleteBackupModuleListener deleteBackupModuleListener;
        if (appDetailsInfo == null || (deleteBackupModuleListener = this.f18991J) == null) {
            return;
        }
        deleteBackupModuleListener.mo20013K(i10, str);
    }

    /* renamed from: W */
    public void m25357W(Drawable drawable) {
        this.f18993L.setBackground(drawable);
    }

    /* renamed from: X */
    public void m25358X(int i10) {
        this.f18993L.setBackgroundColor(i10);
    }

    /* renamed from: Y */
    public void m25359Y(BackupSpaceDetailAdapter.DeleteBackupModuleListener deleteBackupModuleListener) {
        this.f18991J = deleteBackupModuleListener;
    }

    /* renamed from: Z */
    public final void m25360Z(int i10, int i11) {
        if (i10 == i11 - 1) {
            this.f18984C.setVisibility(8);
        } else {
            this.f18984C.setVisibility(0);
        }
    }

    /* renamed from: a0 */
    public final void m25361a0(AppDetailsInfo appDetailsInfo, int i10, String str) {
        if ("baseData".equals(str)) {
            this.f18985D.setVisibility(0);
            this.f18985D.setOnClickListener(this.f18992K);
            this.f18983B.setVisibility(8);
            this.f18987F.setVisibility(8);
            this.f18985D.setAlpha(0.6f);
            this.f18982A.setVisibility(0);
            this.f18982A.setText(this.f18989H.getString(R$string.cloudbackup_base_data_tip));
            this.f18988G.setVisibility(8);
            return;
        }
        this.f18985D.setVisibility(8);
        this.f18986E.setVisibility(8);
        if (appDetailsInfo.getUiStyle() == 1) {
            this.f18983B.setVisibility(0);
            this.f18987F.setVisibility(8);
            this.f18988G.setVisibility(8);
            this.f18983B.setChecked(appDetailsInfo.isCheck());
        } else if (appDetailsInfo.getUiStyle() == 0) {
            this.f18983B.setChecked(false);
            this.f18987F.setVisibility(this.f18990I ? 8 : 0);
            this.f18987F.setTag(Integer.valueOf(i10));
            this.f18988G.setVisibility(8);
            this.f18983B.setVisibility(8);
        } else {
            this.f18983B.setChecked(false);
            this.f18987F.setVisibility(8);
            this.f18988G.setVisibility(0);
            this.f18983B.setVisibility(8);
        }
        this.f18982A.setVisibility(8);
    }

    /* renamed from: b0 */
    public void m25362b0(C4082b c4082b, AppDetailsInfo appDetailsInfo) {
        if (c4082b == null || appDetailsInfo == null) {
            return;
        }
        if (appDetailsInfo.isTemp()) {
            long totalSize = appDetailsInfo.getTotalSize();
            if (totalSize <= 0) {
                c4082b.f18999z.setText(this.f18989H.getString(R$string.backup_option_no_data));
                return;
            } else {
                c4082b.f18999z.setText(C0223k.m1524g(this.f18989H, totalSize));
                return;
            }
        }
        if (appDetailsInfo.isRequestLoading()) {
            c4082b.f18999z.setVisibility(0);
            c4082b.f18999z.setText(this.f18989H.getResources().getString(R$string.cloud_space_detail_list_loading_tip));
            return;
        }
        if (appDetailsInfo.isRequestFail()) {
            if (appDetailsInfo.getErrorCode() == 5009 || "baseData".equals(appDetailsInfo.getBackupAppName())) {
                c4082b.f18999z.setVisibility(8);
                return;
            } else {
                c4082b.f18999z.setVisibility(0);
                c4082b.f18999z.setText(this.f18989H.getResources().getString(R$string.backup_cleanup_loading_error_tip_1));
                return;
            }
        }
        c4082b.f18999z.setVisibility(0);
        long totalSize2 = appDetailsInfo.getTotalSize();
        if (totalSize2 <= 0) {
            c4082b.f18999z.setText(this.f18989H.getString(R$string.backup_option_no_data));
        } else {
            c4082b.f18999z.setText(C0223k.m1524g(this.f18989H, totalSize2));
        }
    }
}
