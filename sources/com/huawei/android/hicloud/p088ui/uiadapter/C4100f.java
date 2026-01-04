package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsDetailActivity;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupOptionAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.ArrayList;
import p015ak.C0209d;
import p015ak.C0223k;
import p514o9.C11839m;
import p618rm.C12590s0;
import p709vj.C13452e;
import p848zl.C14333b;
import sk.C12809f;
import tl.C13026e;

/* renamed from: com.huawei.android.hicloud.ui.uiadapter.f */
/* loaded from: classes3.dex */
public class C4100f extends RecyclerView.AbstractC0833c0 {

    /* renamed from: A */
    public ImageView f19129A;

    /* renamed from: B */
    public ImageView f19130B;

    /* renamed from: C */
    public TextView f19131C;

    /* renamed from: D */
    public TextView f19132D;

    /* renamed from: E */
    public TextView f19133E;

    /* renamed from: F */
    public UnionSwitch f19134F;

    /* renamed from: G */
    public View f19135G;

    /* renamed from: H */
    public ImageView f19136H;

    /* renamed from: I */
    public ImageView f19137I;

    /* renamed from: J */
    public TextView f19138J;

    /* renamed from: K */
    public TextView f19139K;

    /* renamed from: L */
    public int f19140L;

    /* renamed from: M */
    public View f19141M;

    /* renamed from: u */
    public Context f19142u;

    /* renamed from: v */
    public C13026e f19143v;

    /* renamed from: w */
    public BackupOptionAdapter.UpdateOptionStatusListener f19144w;

    /* renamed from: x */
    public RelativeLayout f19145x;

    /* renamed from: y */
    public RelativeLayout f19146y;

    /* renamed from: z */
    public LinearLayout f19147z;

    public C4100f(Context context, View view, BackupOptionAdapter.UpdateOptionStatusListener updateOptionStatusListener) {
        super(view);
        this.f19142u = context;
        this.f19141M = view;
        this.f19146y = (RelativeLayout) C12809f.m76831d(view, R$id.backup_option_list_item_content);
        this.f19147z = (LinearLayout) C12809f.m76831d(view, R$id.rl_title);
        this.f19129A = (ImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon);
        this.f19130B = (ImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon_badge);
        this.f19131C = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_title);
        this.f19132D = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_value);
        this.f19133E = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_tip);
        this.f19134F = (UnionSwitch) C12809f.m76831d(view, R$id.backup_main_switch_btn);
        this.f19135G = C12809f.m76831d(view, R$id.backup_option_item_divider);
        this.f19136H = (ImageView) C12809f.m76831d(view, R$id.detail_iv);
        this.f19137I = (ImageView) C12809f.m76831d(view, R$id.expandable_iv);
        this.f19138J = (TextView) C12809f.m76831d(view, R$id.reconmend);
        this.f19145x = (RelativeLayout) C12809f.m76831d(view, R$id.backup_option_list_item);
        this.f19139K = (TextView) C12809f.m76831d(view, R$id.show_all_app);
        this.f19144w = updateOptionStatusListener;
    }

    /* renamed from: R */
    public final void m25481R(String str) {
        if (SplitAppUtil.hasSplitAppSuffix(str)) {
            this.f19130B.setVisibility(0);
        } else {
            this.f19130B.setVisibility(8);
        }
    }

    /* renamed from: S */
    public final void m25482S(BackupOptionItem backupOptionItem) throws Resources.NotFoundException {
        String appId = backupOptionItem.getAppId();
        ArrayList arrayList = new ArrayList(C14333b.m85452H());
        arrayList.add("thirdAppData");
        if (C14333b.m85448D().contains(appId)) {
            if (backupOptionItem.getDataBytes() == 0) {
                this.f19132D.setText(this.f19142u.getString(R$string.backup_option_no_data));
            } else {
                this.f19132D.setText(C0223k.m1524g(this.f19142u, backupOptionItem.getDataBytes()));
            }
        } else if (arrayList.contains(appId)) {
            if (backupOptionItem.getItemTotal() <= 0) {
                this.f19132D.setText(this.f19142u.getString(R$string.backup_option_no_data));
            } else {
                this.f19132D.setText(this.f19142u.getString(R$string.payment_renewal_package_size, C0223k.m1524g(this.f19142u, backupOptionItem.getDataBytes()), this.f19142u.getResources().getQuantityString(R$plurals.backup_detail_gallery_num, backupOptionItem.getItemTotal(), Integer.valueOf(backupOptionItem.getItemTotal()))));
            }
        } else if (backupOptionItem.getShowType() > 0) {
            if (backupOptionItem.getItemTotal() <= 0 || backupOptionItem.getDataBytes() <= 0) {
                this.f19132D.setText(this.f19142u.getString(R$string.backup_option_no_data));
            } else if (backupOptionItem.getShowType() == 1) {
                this.f19132D.setText(this.f19142u.getResources().getQuantityString(R$plurals.backup_detail_gallery_num, backupOptionItem.getItemTotal(), Integer.valueOf(backupOptionItem.getItemTotal())));
            } else {
                this.f19132D.setText(this.f19142u.getString(R$string.payment_renewal_package_size, C0223k.m1524g(this.f19142u, backupOptionItem.getDataBytes()), this.f19142u.getResources().getQuantityString(R$plurals.backup_detail_gallery_num, backupOptionItem.getItemTotal(), Integer.valueOf(backupOptionItem.getItemTotal()))));
            }
        } else if (backupOptionItem.getDataBytes() == 0) {
            this.f19132D.setText(this.f19142u.getString(R$string.backup_option_no_data));
        } else {
            this.f19132D.setText(C0223k.m1524g(this.f19142u, backupOptionItem.getDataBytes()));
        }
        m25494e0(appId, backupOptionItem);
    }

    /* renamed from: T */
    public final String m25483T(BackupOptionItem backupOptionItem) {
        C13026e c13026e = this.f19143v;
        return c13026e == null ? "" : C12590s0.m75884o0(backupOptionItem, c13026e, this.f19142u);
    }

    /* renamed from: U */
    public void m25484U(int i10, C13026e c13026e) {
        this.f19140L = i10;
        this.f19143v = c13026e;
    }

    /* renamed from: V */
    public final /* synthetic */ void m25485V(View view) {
        BackupOptionAdapter.UpdateOptionStatusListener updateOptionStatusListener = this.f19144w;
        if (updateOptionStatusListener != null) {
            updateOptionStatusListener.onSystemItemClick(view);
        }
    }

    /* renamed from: W */
    public final /* synthetic */ void m25486W(int i10, String str, BackupOptionItem backupOptionItem, CompoundButton compoundButton, boolean z10) {
        BackupOptionAdapter.UpdateOptionStatusListener updateOptionStatusListener = this.f19144w;
        if (updateOptionStatusListener != null) {
            updateOptionStatusListener.mo18979c0(i10, str, z10, backupOptionItem);
        } else {
            C11839m.m70688i("BackupOptionMemberDataViewHolder", "listener is null");
        }
    }

    /* renamed from: X */
    public final void m25487X() {
        this.f19145x.setPadding(0, (int) TypedValue.applyDimension(1, 4.0f, this.f19142u.getResources().getDisplayMetrics()), 0, 0);
    }

    /* renamed from: Y */
    public final void m25488Y() {
        this.f19145x.setPadding(0, 0, 0, (int) TypedValue.applyDimension(1, 4.0f, this.f19142u.getResources().getDisplayMetrics()));
    }

    /* renamed from: Z */
    public final void m25489Z(int i10) {
        if (this.f19140L <= 0) {
            return;
        }
        if (i10 == 0) {
            m25487X();
        }
        if (i10 == this.f19140L - 1) {
            m25488Y();
        }
    }

    /* renamed from: a0 */
    public final void m25490a0(int i10) {
        int i11 = this.f19140L;
        if (i11 <= 0) {
            return;
        }
        if (i10 == i11 - 1) {
            this.f19135G.setVisibility(8);
            if (i10 != 0) {
                this.f19145x.setBackground(this.f19142u.getDrawable(R$drawable.cardview_list_bottom_shape_white));
                return;
            }
            Context context = this.f19142u;
            if (context instanceof BackupOptionsDetailActivity) {
                this.f19145x.setBackground(context.getDrawable(R$drawable.cardview_list_bottom_shape_white));
                return;
            } else {
                this.f19145x.setBackground(context.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
                return;
            }
        }
        this.f19135G.setVisibility(0);
        if (i10 != 0) {
            this.f19145x.setBackground(this.f19142u.getDrawable(R$color.storage_manager_card_bg));
        } else {
            if (this.f19142u instanceof BackupOptionsDetailActivity) {
                return;
            }
            if (C13452e.m80781L().m80887a1()) {
                this.f19145x.setBackground(this.f19142u.getDrawable(R$color.storage_manager_card_bg));
            } else {
                this.f19145x.setBackground(this.f19142u.getDrawable(R$drawable.cardview_list_top_shape_white));
            }
        }
    }

    /* renamed from: b0 */
    public final void m25491b0() {
        this.f19146y.setMinimumHeight((int) TypedValue.applyDimension(1, this.f19133E.getVisibility() == 0 ? 96.0f : 72.0f, this.f19142u.getResources().getDisplayMetrics()));
    }

    /* renamed from: c0 */
    public final void m25492c0(BackupOptionItem backupOptionItem) throws Resources.NotFoundException {
        int isDataEnable = backupOptionItem.getIsDataEnable();
        if (isDataEnable == 0 || isDataEnable == 1) {
            this.f19132D.setText(this.f19142u.getString(R$string.backup_loading));
        } else if (isDataEnable == -1) {
            this.f19132D.setText(this.f19142u.getString(R$string.backup_option_not_support_clone));
        } else {
            m25482S(backupOptionItem);
        }
    }

    /* renamed from: d0 */
    public final void m25493d0(BackupOptionItem backupOptionItem, int i10, boolean z10) {
        String appId = backupOptionItem.getAppId();
        m25494e0(appId, backupOptionItem);
        m25495f0(appId, i10, backupOptionItem);
        if ("baseData".equals(appId)) {
            this.f19136H.setVisibility(0);
            this.f19136H.setOnClickListener(new View.OnClickListener() { // from class: ae.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f674a.m25485V(view);
                }
            });
            this.f19134F.setVisibility(8);
            this.f19136H.setAlpha(0.6f);
            this.f19133E.setVisibility(0);
            this.f19133E.setText(this.f19142u.getString(R$string.cloudbackup_base_data_tip));
        } else {
            this.f19136H.setVisibility(8);
            this.f19137I.setVisibility(8);
            this.f19134F.setVisibility(0);
            this.f19133E.setVisibility(8);
            if ("com.tencent.mm".equals(appId)) {
                this.f19133E.setVisibility(0);
                this.f19133E.setText(this.f19142u.getString(R$string.backup_wechat_tip));
            } else if (appId.contains("com.tencent.mm") && SplitAppUtil.hasSplitAppSuffix(appId)) {
                this.f19133E.setVisibility(0);
                this.f19133E.setText(this.f19142u.getString(R$string.backup_wechat_tip_split));
            } else if (!HNConstants.DataType.MEDIA.equals(appId) || z10) {
                this.f19133E.setVisibility(8);
            } else {
                this.f19133E.setVisibility(0);
                this.f19133E.setText(this.f19142u.getString(R$string.backup_gallery_tip));
            }
        }
        m25491b0();
        m25490a0(i10);
    }

    /* renamed from: e0 */
    public final void m25494e0(String str, BackupOptionItem backupOptionItem) {
        m25481R(str);
        String splitOriAppId = SplitAppUtil.getSplitOriAppId(str);
        if (backupOptionItem.getParent().equals("virtualApp")) {
            this.f19131C.setText(CloudBackupLanguageUtil.getVirtualName(splitOriAppId));
            this.f19129A.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(splitOriAppId, null));
        } else if (C14333b.m85483r().containsKey(splitOriAppId)) {
            this.f19131C.setText(C2783d.m16079E(this.f19142u, splitOriAppId));
            this.f19129A.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(splitOriAppId));
        } else {
            this.f19131C.setText(C14333b.f63653e.containsKey(splitOriAppId) ? C2783d.m16079E(this.f19142u, splitOriAppId) : m25483T(backupOptionItem));
            this.f19129A.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(splitOriAppId));
        }
    }

    /* renamed from: f0 */
    public final void m25495f0(final String str, final int i10, final BackupOptionItem backupOptionItem) {
        if (C13452e.m80781L().m80791C0()) {
            this.f19134F.setEnabled(false);
            this.f19134F.setCheckedProgrammatically(false);
            this.f19138J.setVisibility(8);
            return;
        }
        this.f19134F.setListIndex(i10);
        this.f19134F.setCheckedProgrammatically(backupOptionItem.getBackupSwitch());
        if (backupOptionItem.isDisable()) {
            this.f19134F.setEnabled(false);
        } else {
            this.f19134F.setEnabled(true);
        }
        this.f19134F.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ae.w
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f680a.m25486W(i10, str, backupOptionItem, compoundButton, z10);
            }
        });
        if (!HNConstants.DataType.MEDIA.equals(str) && !"com.tencent.mm".equals(str)) {
            this.f19138J.setVisibility(8);
        } else if (C12590s0.m75823Z0() || backupOptionItem.getBackupSwitch()) {
            this.f19138J.setVisibility(8);
        } else {
            this.f19138J.setVisibility(0);
        }
    }

    /* renamed from: g0 */
    public void m25496g0(BackupOptionItem backupOptionItem, int i10, boolean z10) throws Resources.NotFoundException {
        Context context = this.f19142u;
        if (context == null) {
            C11839m.m70689w("BackupOptionMemberDataViewHolder", "updateView, context is null");
            return;
        }
        if (C0209d.m1195O(context) >= 1.75f) {
            this.f19147z.setOrientation(1);
        } else {
            this.f19147z.setOrientation(0);
        }
        this.f19146y.setVisibility(0);
        m25493d0(backupOptionItem, i10, z10);
        m25492c0(backupOptionItem);
        m25489Z(i10);
        this.f19141M.setAccessibilityDelegate(C2783d.m16078D0());
    }
}
