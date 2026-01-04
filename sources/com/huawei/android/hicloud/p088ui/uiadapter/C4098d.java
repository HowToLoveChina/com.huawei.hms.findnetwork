package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupOptionAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.RoundRectImageView;
import com.huawei.android.hicloud.p088ui.uiextend.TipPopupLayout;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import p514o9.C11839m;
import p848zl.C14333b;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.uiadapter.d */
/* loaded from: classes3.dex */
public class C4098d extends RecyclerView.AbstractC0833c0 {

    /* renamed from: A */
    public final Context f19103A;

    /* renamed from: B */
    public BackupOptionAdapter.UpdateOptionStatusListener f19104B;

    /* renamed from: u */
    public RelativeLayout f19105u;

    /* renamed from: v */
    public RoundRectImageView f19106v;

    /* renamed from: w */
    public TextView f19107w;

    /* renamed from: x */
    public UnionSwitch f19108x;

    /* renamed from: y */
    public View f19109y;

    /* renamed from: z */
    public TipPopupLayout f19110z;

    public C4098d(View view) {
        super(view);
        this.f19103A = view.getContext();
        this.f19105u = (RelativeLayout) C12809f.m76831d(view, R$id.backup_option_list_item_content);
        this.f19106v = (RoundRectImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon);
        this.f19107w = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_title);
        this.f19108x = (UnionSwitch) C12809f.m76831d(view, R$id.item_checkbox);
        this.f19109y = C12809f.m76831d(view, R$id.backup_option_item_divider);
        TipPopupLayout tipPopupLayout = (TipPopupLayout) C12809f.m76831d(view, R$id.detail_iv);
        this.f19110z = tipPopupLayout;
        tipPopupLayout.setImageViewPic(R$drawable.ic_about_option);
    }

    /* renamed from: R */
    private void m25455R() {
        this.f19105u.setMinimumHeight((int) TypedValue.applyDimension(1, 72.0f, this.f19103A.getResources().getDisplayMetrics()));
    }

    /* renamed from: X */
    private void m25456X(int i10, int i11) {
        if (i10 == i11 - 1) {
            this.f19109y.setVisibility(8);
        } else {
            this.f19109y.setVisibility(0);
        }
    }

    /* renamed from: S */
    public void m25457S(BackupOptionItem backupOptionItem, int i10, int i11) {
        if (backupOptionItem == null) {
            C11839m.m70689w("BackupOptionBasicDataViewHolder", "initItemView, item is null");
            return;
        }
        if (this.f19103A == null) {
            C11839m.m70689w("BackupOptionBasicDataViewHolder", "initItemView, context is null");
            return;
        }
        C11839m.m70688i("BackupOptionBasicDataViewHolder", "basic data changed, appId:" + backupOptionItem.getAppId() + ";switch:" + backupOptionItem.getBackupSwitch());
        String appId = backupOptionItem.getAppId();
        m25458T(appId, backupOptionItem);
        m25462Y(backupOptionItem, i10, appId);
        m25456X(i10, i11);
        m25455R();
    }

    /* renamed from: T */
    public final void m25458T(String str, BackupOptionItem backupOptionItem) {
        if (SplitAppUtil.hasSplitAppSuffix(str)) {
            str = SplitAppUtil.getSplitOriAppId(str);
        }
        if (C14333b.m85483r().containsKey(str)) {
            this.f19107w.setText(C2783d.m16079E(this.f19103A, str));
            this.f19106v.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str), false);
        } else {
            this.f19107w.setText(C14333b.f63653e.containsKey(str) ? C2783d.m16079E(this.f19103A, str) : backupOptionItem.getAppName());
            this.f19106v.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(str), false);
        }
    }

    /* renamed from: U */
    public final /* synthetic */ void m25459U(View view) {
        BackupOptionAdapter.UpdateOptionStatusListener updateOptionStatusListener = this.f19104B;
        if (updateOptionStatusListener != null) {
            updateOptionStatusListener.onSystemItemClick(view);
        }
    }

    /* renamed from: V */
    public final /* synthetic */ void m25460V(int i10, String str, BackupOptionItem backupOptionItem, CompoundButton compoundButton, boolean z10) {
        BackupOptionAdapter.UpdateOptionStatusListener updateOptionStatusListener = this.f19104B;
        if (updateOptionStatusListener != null) {
            updateOptionStatusListener.mo19019x(i10, str, z10, backupOptionItem);
        } else {
            C11839m.m70688i("BackupOptionBasicDataViewHolder", "listener is null");
        }
    }

    /* renamed from: W */
    public void m25461W(BackupOptionAdapter.UpdateOptionStatusListener updateOptionStatusListener) {
        this.f19104B = updateOptionStatusListener;
    }

    /* renamed from: Y */
    public final void m25462Y(final BackupOptionItem backupOptionItem, final int i10, final String str) {
        if ("basic_system_data".equals(str)) {
            this.f19110z.setVisibility(0);
            this.f19110z.setOnClickListener(new View.OnClickListener() { // from class: ae.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f609a.m25459U(view);
                }
            });
            this.f19108x.setVisibility(8);
            this.f19110z.setAlpha(0.6f);
            return;
        }
        this.f19110z.setVisibility(8);
        C11839m.m70688i("BackupOptionBasicDataViewHolder", "refresh switch, appId:" + str + ";position:" + i10 + ";switch:" + backupOptionItem.getBackupSwitch());
        this.f19108x.setCheckedProgrammatically(backupOptionItem.getBackupSwitch());
        this.f19108x.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ae.r
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f614a.m25460V(i10, str, backupOptionItem, compoundButton, z10);
            }
        });
    }
}
