package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.C3765j1;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0223k;
import p292fn.C9733f;
import p514o9.C11839m;
import p618rm.C12590s0;
import p848zl.C14333b;
import sk.C12809f;
import tl.C13026e;

/* loaded from: classes3.dex */
public class BackupOptionRefurbishAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public final boolean f18519d;

    /* renamed from: e */
    public Context f18520e;

    /* renamed from: f */
    public Resources f18521f;

    /* renamed from: h */
    public UpdateOptionStatusListener f18523h;

    /* renamed from: i */
    public View.OnClickListener f18524i;

    /* renamed from: o */
    public boolean f18530o;

    /* renamed from: g */
    public List<BackupOptionItem> f18522g = new ArrayList();

    /* renamed from: k */
    public RecyclerView.AbstractC0833c0 f18526k = null;

    /* renamed from: l */
    public boolean f18527l = false;

    /* renamed from: m */
    public boolean f18528m = true;

    /* renamed from: n */
    public Map<String, C4027d> f18529n = new HashMap();

    /* renamed from: j */
    public C13026e f18525j = new C13026e(true);

    public interface UpdateOptionStatusListener {
        /* renamed from: A */
        default void mo19119A(int i10) {
        }

        /* renamed from: c */
        void mo19144c(int i10, String str, boolean z10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupOptionRefurbishAdapter$a */
    public class C4024a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f18531u;

        public C4024a(View view) {
            super(view);
            this.f18531u = (TextView) C12809f.m76831d(view, R$id.showAll);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupOptionRefurbishAdapter$b */
    public class C4025b extends RecyclerView.AbstractC0833c0 {
        public C4025b(View view) {
            super(view);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupOptionRefurbishAdapter$c */
    public class C4026c extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public HwProgressBar f18534u;

        /* renamed from: v */
        public TextView f18535v;

        public C4026c(View view) {
            super(view);
            HwProgressBar hwProgressBar = (HwProgressBar) C12809f.m76831d(view, R$id.wait_data_progress_loading);
            this.f18534u = hwProgressBar;
            hwProgressBar.setEnabled(true);
            this.f18535v = (TextView) C12809f.m76831d(view, R$id.wait_data_size_value);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupOptionRefurbishAdapter$d */
    public class C4027d extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public UnionSwitch f18537A;

        /* renamed from: B */
        public View f18538B;

        /* renamed from: C */
        public ImageView f18539C;

        /* renamed from: D */
        public ImageView f18540D;

        /* renamed from: E */
        public ImageView f18541E;

        /* renamed from: F */
        public ImageView f18542F;

        /* renamed from: G */
        public TextView f18543G;

        /* renamed from: u */
        public RelativeLayout f18545u;

        /* renamed from: v */
        public RelativeLayout f18546v;

        /* renamed from: w */
        public ImageView f18547w;

        /* renamed from: x */
        public TextView f18548x;

        /* renamed from: y */
        public TextView f18549y;

        /* renamed from: z */
        public TextView f18550z;

        public C4027d(View view) {
            super(view);
            this.f18546v = (RelativeLayout) C12809f.m76831d(view, R$id.backup_option_list_item_content);
            this.f18547w = (ImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon);
            this.f18548x = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_title);
            this.f18549y = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_value);
            this.f18550z = (TextView) C12809f.m76831d(view, R$id.backup_option_list_item_tip);
            this.f18537A = (UnionSwitch) C12809f.m76831d(view, R$id.backup_main_switch_btn);
            this.f18538B = C12809f.m76831d(view, R$id.backup_option_item_divider);
            this.f18539C = (ImageView) C12809f.m76831d(view, R$id.detail_iv);
            this.f18540D = (ImageView) C12809f.m76831d(view, R$id.expandable_iv);
            this.f18543G = (TextView) C12809f.m76831d(view, R$id.reconmend);
            this.f18541E = (ImageView) C12809f.m76831d(view, R$id.backup_options_down_arrow_image);
            this.f18542F = (ImageView) C12809f.m76831d(view, R$id.backup_options_up_arrow_image);
            this.f18545u = (RelativeLayout) C12809f.m76831d(view, R$id.backup_option_list_item);
        }
    }

    public BackupOptionRefurbishAdapter(Context context, View.OnClickListener onClickListener) {
        this.f18520e = context;
        this.f18521f = context.getResources();
        this.f18524i = onClickListener;
        boolean zM60720O = C9733f.m60705z().m60720O("cloudBackupRefurbishHiddenAlbum");
        this.f18519d = zM60720O;
        C11839m.m70688i("BackupOptionRefurbishAdapter", "isBackupHideGallery: " + zM60720O);
    }

    /* renamed from: G */
    public void m24772G(List<BackupOptionItem> list) {
        this.f18522g.clear();
        list.sort(new C3765j1());
        this.f18522g.addAll(list);
        C11839m.m70686d("BackupOptionRefurbishAdapter", "item list size: " + this.f18522g.size());
        m5213j();
    }

    /* renamed from: H */
    public final void m24773H(C4027d c4027d, BackupOptionItem backupOptionItem) throws Resources.NotFoundException {
        String appId = backupOptionItem.getAppId();
        ArrayList arrayList = new ArrayList(C14333b.m85452H());
        arrayList.add("thirdAppData");
        if (C14333b.m85448D().contains(appId)) {
            if (backupOptionItem.getDataBytes() == 0) {
                c4027d.f18549y.setText(this.f18520e.getString(R$string.backup_option_no_data));
                return;
            } else {
                c4027d.f18549y.setText(C0223k.m1524g(this.f18520e, backupOptionItem.getDataBytes()));
                return;
            }
        }
        if (arrayList.contains(appId)) {
            if (backupOptionItem.getItemTotal() <= 0) {
                c4027d.f18549y.setText(this.f18520e.getString(R$string.backup_option_no_data));
                return;
            }
            C11839m.m70688i("BackupOptionRefurbishAdapter", "deal item appId: " + backupOptionItem.getAppId() + ", data size: " + backupOptionItem.getDataBytes());
            c4027d.f18549y.setText(this.f18520e.getString(R$string.payment_renewal_package_size, C0223k.m1524g(this.f18520e, backupOptionItem.getDataBytes()), m24775J(backupOptionItem)));
            return;
        }
        if (backupOptionItem.getShowType() <= 0) {
            if (backupOptionItem.getDataBytes() == 0) {
                c4027d.f18549y.setText(this.f18520e.getString(R$string.backup_option_no_data));
                return;
            } else {
                c4027d.f18549y.setText(C0223k.m1524g(this.f18520e, backupOptionItem.getDataBytes()));
                return;
            }
        }
        if (backupOptionItem.getItemTotal() <= 0 || backupOptionItem.getDataBytes() <= 0) {
            c4027d.f18549y.setText(this.f18520e.getString(R$string.backup_option_no_data));
            return;
        }
        if (backupOptionItem.getShowType() == 1) {
            c4027d.f18549y.setText(this.f18521f.getQuantityString(R$plurals.backup_detail_gallery_num, backupOptionItem.getItemTotal(), Integer.valueOf(backupOptionItem.getItemTotal())));
        } else {
            c4027d.f18549y.setText(this.f18520e.getString(R$string.payment_renewal_package_size, C0223k.m1524g(this.f18520e, backupOptionItem.getDataBytes()), this.f18521f.getQuantityString(R$plurals.backup_detail_gallery_num, backupOptionItem.getItemTotal(), Integer.valueOf(backupOptionItem.getItemTotal()))));
        }
    }

    /* renamed from: I */
    public String m24774I(BackupOptionItem backupOptionItem) {
        return C12590s0.m75884o0(backupOptionItem, this.f18525j, this.f18520e);
    }

    /* renamed from: J */
    public final String m24775J(BackupOptionItem backupOptionItem) {
        if (backupOptionItem != null) {
            return "thirdAppData".equals(backupOptionItem.getAppId()) ? this.f18521f.getQuantityString(R$plurals.backup_detail_gallery_num, backupOptionItem.getSwitchCount(), Integer.valueOf(backupOptionItem.getSwitchCount())) : this.f18521f.getQuantityString(R$plurals.backup_detail_gallery_num, backupOptionItem.getItemTotal(), Integer.valueOf(backupOptionItem.getItemTotal()));
        }
        C11839m.m70687e("BackupOptionRefurbishAdapter", "getCountValue, item is null");
        return "";
    }

    /* renamed from: K */
    public List<BackupOptionItem> m24776K() {
        return this.f18522g;
    }

    /* renamed from: L */
    public int m24777L(String str) {
        for (int i10 = 0; i10 < this.f18522g.size(); i10++) {
            String appId = this.f18522g.get(i10).getAppId();
            if (!TextUtils.isEmpty(appId) && appId.equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: M */
    public final void m24778M(C4027d c4027d, BackupOptionItem backupOptionItem) throws Resources.NotFoundException {
        if (this.f18521f == null) {
            C11839m.m70688i("BackupOptionRefurbishAdapter", "resources is null.");
            return;
        }
        int isDataEnable = backupOptionItem.getIsDataEnable();
        C11839m.m70686d("BackupOptionRefurbishAdapter", "deal item data enable: " + isDataEnable + ", data size: " + backupOptionItem.getDataBytes() + ", appId: " + backupOptionItem.getAppId());
        if (isDataEnable == 0 || isDataEnable == 1) {
            c4027d.f18549y.setText(this.f18520e.getString(R$string.backup_loading));
        } else if (isDataEnable == -1) {
            c4027d.f18549y.setText(this.f18520e.getString(R$string.backup_option_not_support_clone));
        } else {
            m24773H(c4027d, backupOptionItem);
        }
    }

    /* renamed from: N */
    public final void m24779N(C4027d c4027d, BackupOptionItem backupOptionItem, int i10) {
        String appId = backupOptionItem.getAppId();
        m24780O(c4027d, appId, backupOptionItem);
        m24781P(c4027d, appId, i10, backupOptionItem);
        if ("baseData".equals(appId)) {
            m24789X(c4027d);
        } else {
            c4027d.f18539C.setVisibility(8);
            c4027d.f18540D.setVisibility(8);
            c4027d.f18537A.setVisibility(0);
            if (2 == c4027d.m5167n()) {
                if ("thirdAppData".equals(backupOptionItem.getAppId())) {
                    c4027d.f18542F.setVisibility(this.f18528m ? 8 : 0);
                    c4027d.f18541E.setVisibility(this.f18528m ? 0 : 8);
                    c4027d.f18537A.setVisibility(8);
                } else {
                    c4027d.f18542F.setVisibility(8);
                    c4027d.f18541E.setVisibility(8);
                    c4027d.f18537A.setVisibility(0);
                }
            }
            c4027d.f18550z.setVisibility(8);
            if ("com.tencent.mm".equals(appId)) {
                c4027d.f18550z.setVisibility(0);
                c4027d.f18550z.setText(this.f18520e.getString(R$string.backup_wechat_tip));
            } else if (!HNConstants.DataType.MEDIA.equals(appId) || this.f18519d) {
                c4027d.f18550z.setVisibility(8);
            } else {
                c4027d.f18550z.setVisibility(0);
                c4027d.f18550z.setText(this.f18520e.getString(R$string.backup_gallery_tip));
            }
        }
        if ("thirdAppData".equals(backupOptionItem.getAppId())) {
            c4027d.f18546v.setOnClickListener(new View.OnClickListener() { // from class: ae.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f725a.m24782Q(view);
                }
            });
        }
        m24790Y(c4027d, i10);
    }

    /* renamed from: O */
    public final void m24780O(C4027d c4027d, String str, BackupOptionItem backupOptionItem) {
        if (backupOptionItem.getParent().equals("virtualApp")) {
            c4027d.f18548x.setText(CloudBackupLanguageUtil.getVirtualName(str));
            c4027d.f18547w.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str, null));
        } else if (C14333b.m85483r().containsKey(str)) {
            c4027d.f18548x.setText(C2783d.m16079E(this.f18520e, str));
            c4027d.f18547w.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str));
        } else {
            c4027d.f18548x.setText(C14333b.f63653e.containsKey(str) ? C2783d.m16079E(this.f18520e, str) : m24774I(backupOptionItem));
            c4027d.f18547w.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(str));
        }
    }

    /* renamed from: P */
    public final void m24781P(C4027d c4027d, final String str, final int i10, BackupOptionItem backupOptionItem) {
        c4027d.f18537A.setListIndex(i10);
        c4027d.f18537A.setCheckedProgrammatically(backupOptionItem.getBackupSwitch());
        if (backupOptionItem.getIsDisable()) {
            c4027d.f18537A.setEnabled(false);
        } else {
            c4027d.f18537A.setEnabled(true);
        }
        c4027d.f18537A.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ae.z
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f737a.m24783R(i10, str, compoundButton, z10);
            }
        });
        if (!HNConstants.DataType.MEDIA.equals(str) && !"com.tencent.mm".equals(str)) {
            c4027d.f18543G.setVisibility(8);
        } else if (C12590s0.m75823Z0() || backupOptionItem.getBackupSwitch()) {
            c4027d.f18543G.setVisibility(8);
        } else {
            c4027d.f18543G.setVisibility(0);
        }
    }

    /* renamed from: Q */
    public final /* synthetic */ void m24782Q(View view) {
        UpdateOptionStatusListener updateOptionStatusListener = this.f18523h;
        if (updateOptionStatusListener == null) {
            C11839m.m70688i("BackupOptionRefurbishAdapter", "listener is null");
        } else if (this.f18530o) {
            this.f18530o = false;
            updateOptionStatusListener.mo19119A(2);
        } else {
            this.f18530o = true;
            updateOptionStatusListener.mo19119A(1);
        }
    }

    /* renamed from: R */
    public final /* synthetic */ void m24783R(int i10, String str, CompoundButton compoundButton, boolean z10) {
        UpdateOptionStatusListener updateOptionStatusListener = this.f18523h;
        if (updateOptionStatusListener != null) {
            updateOptionStatusListener.mo19144c(i10, str, z10);
        } else {
            C11839m.m70688i("BackupOptionRefurbishAdapter", "listener is null");
        }
    }

    /* renamed from: S */
    public final /* synthetic */ void m24784S(View view) {
        UpdateOptionStatusListener updateOptionStatusListener = this.f18523h;
        if (updateOptionStatusListener != null) {
            updateOptionStatusListener.mo19119A(0);
        } else {
            C11839m.m70688i("BackupOptionRefurbishAdapter", "footer view holder listener is null.");
        }
    }

    /* renamed from: T */
    public void m24785T(boolean z10) {
        this.f18528m = z10;
    }

    /* renamed from: U */
    public final void m24786U(C4027d c4027d, Drawable drawable) {
        if (c4027d == null) {
            C11839m.m70687e("BackupOptionRefurbishAdapter", "backHolderView is null");
            return;
        }
        RelativeLayout relativeLayout = c4027d.f18545u;
        if (relativeLayout != null) {
            relativeLayout.setBackground(drawable);
            return;
        }
        RelativeLayout relativeLayout2 = c4027d.f18546v;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackground(drawable);
        }
    }

    /* renamed from: V */
    public void m24787V(UpdateOptionStatusListener updateOptionStatusListener) {
        this.f18523h = updateOptionStatusListener;
    }

    /* renamed from: W */
    public void m24788W(boolean z10) {
        this.f18527l = z10;
    }

    /* renamed from: X */
    public final void m24789X(C4027d c4027d) {
        c4027d.f18539C.setVisibility(0);
        c4027d.f18539C.setOnClickListener(this.f18524i);
        c4027d.f18537A.setVisibility(8);
        c4027d.f18541E.setVisibility(8);
        c4027d.f18542F.setVisibility(8);
        c4027d.f18539C.setAlpha(0.6f);
        c4027d.f18550z.setVisibility(0);
        c4027d.f18550z.setText(this.f18520e.getString(R$string.cloudbackup_base_data_tip));
    }

    /* renamed from: Y */
    public final void m24790Y(C4027d c4027d, int i10) {
        if (!this.f18527l) {
            m24786U(c4027d, this.f18520e.getDrawable(R$color.storage_manager_card_bg));
            return;
        }
        if (i10 != mo721e() - 1) {
            c4027d.f18538B.setVisibility(0);
            if (i10 == 0) {
                Context context = this.f18520e;
                if (!(context instanceof BackupOptionsDetailActivity)) {
                    m24786U(c4027d, context.getDrawable(R$drawable.cardview_list_top_shape_white));
                    return;
                }
            }
            m24786U(c4027d, this.f18520e.getDrawable(R$color.storage_manager_card_bg));
            return;
        }
        c4027d.f18538B.setVisibility(8);
        if (i10 != 0) {
            m24786U(c4027d, this.f18520e.getDrawable(R$drawable.cardview_list_bottom_shape_white));
            return;
        }
        Context context2 = this.f18520e;
        if (context2 instanceof BackupOptionsDetailActivity) {
            m24786U(c4027d, context2.getDrawable(R$drawable.cardview_list_bottom_shape_white));
        } else {
            m24786U(c4027d, context2.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
        }
    }

    /* renamed from: Z */
    public void m24791Z(RecyclerView recyclerView, String str) {
        int iM24777L;
        if (TextUtils.isEmpty(str) || this.f18522g == null || recyclerView == null || this.f18521f == null || (iM24777L = m24777L(str)) == -1) {
            return;
        }
        BackupOptionItem backupOptionItem = this.f18522g.get(iM24777L);
        RecyclerView.AbstractC0833c0 abstractC0833c0FindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(iM24777L);
        if (!(abstractC0833c0FindViewHolderForAdapterPosition instanceof C4027d) || backupOptionItem == null) {
            return;
        }
        C4027d c4027d = (C4027d) abstractC0833c0FindViewHolderForAdapterPosition;
        if (backupOptionItem.getParent().equals("virtualApp")) {
            c4027d.f18547w.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str, null));
        } else if (C14333b.m85483r().containsKey(str)) {
            c4027d.f18547w.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str));
        } else {
            c4027d.f18547w.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(str));
        }
    }

    /* renamed from: a0 */
    public void m24792a0(RecyclerView recyclerView, String str, boolean z10) {
        if (TextUtils.isEmpty(str) || this.f18522g == null || recyclerView == null || this.f18521f == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= this.f18522g.size()) {
                i10 = -1;
                break;
            } else {
                if (this.f18522g.get(i10) != null && this.f18522g.get(i10).getAppId() != null && this.f18522g.get(i10).getAppId().equals(str)) {
                    this.f18522g.get(i10).setBackupSwitch(z10);
                    this.f18522g.get(i10).setOperateType(1);
                    break;
                }
                i10++;
            }
        }
        C11839m.m70686d("BackupOptionRefurbishAdapter", "appId: " + str + ", switchStatus: " + z10 + ", position: " + i10);
        if (i10 != -1) {
            RecyclerView.AbstractC0833c0 abstractC0833c0FindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i10);
            if (!(abstractC0833c0FindViewHolderForAdapterPosition instanceof C4027d)) {
                C11839m.m70688i("BackupOptionRefurbishAdapter", "update module switch holder is null, position is: " + i10);
                return;
            }
            C4027d c4027d = (C4027d) abstractC0833c0FindViewHolderForAdapterPosition;
            c4027d.f18537A.setCheckedProgrammatically(z10);
            if (!HNConstants.DataType.MEDIA.equals(str) && !"com.tencent.mm".equals(str)) {
                c4027d.f18543G.setVisibility(8);
            } else if (C12590s0.m75823Z0() || z10) {
                c4027d.f18543G.setVisibility(8);
            } else {
                c4027d.f18543G.setVisibility(0);
            }
        }
    }

    /* renamed from: b0 */
    public void m24793b0(BackupOptionItem backupOptionItem) {
        C11839m.m70688i("BackupOptionRefurbishAdapter", "updateOneModule start: " + backupOptionItem.getAppId());
        for (int i10 = 0; i10 < this.f18522g.size(); i10++) {
            if (this.f18522g.get(i10) != null && this.f18522g.get(i10).getAppId() != null && this.f18522g.get(i10).getAppId().equals(backupOptionItem.getAppId())) {
                this.f18522g.get(i10).setAppName(backupOptionItem.getAppName());
                this.f18522g.get(i10).setParent(backupOptionItem.getParent());
                this.f18522g.get(i10).setDisable(backupOptionItem.isDisable());
                this.f18522g.get(i10).setBackupData(backupOptionItem.isBackupData());
                this.f18522g.get(i10).setIsDataEnable(backupOptionItem.getIsDataEnable());
                this.f18522g.get(i10).setCodeBytes(backupOptionItem.getCodeBytes());
                this.f18522g.get(i10).setDataBytes(backupOptionItem.getDataBytes());
                this.f18522g.get(i10).setSwitchCount(backupOptionItem.getSwitchCount());
                this.f18522g.get(i10).setItemTotal(backupOptionItem.getItemTotal());
                this.f18522g.get(i10).setTotalIncrease(backupOptionItem.getTotalIncrease());
                this.f18522g.get(i10).setCurrentIncrease(backupOptionItem.getCurrentIncrease());
                this.f18522g.get(i10).setData1(backupOptionItem.getData1());
                m5214k(i10);
                return;
            }
        }
    }

    /* renamed from: c0 */
    public void m24794c0(String str) {
        RecyclerView.AbstractC0833c0 abstractC0833c0 = this.f18526k;
        if (abstractC0833c0 == null) {
            C11839m.m70688i("BackupOptionRefurbishAdapter", "current header view holder is null.");
            return;
        }
        C4026c c4026c = (C4026c) abstractC0833c0;
        c4026c.f18535v.setVisibility(0);
        c4026c.f18534u.setVisibility(8);
        c4026c.f18535v.setText(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        if (this.f18527l) {
            return this.f18522g.size();
        }
        return 6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: f */
    public long mo722f(int i10) {
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i10 != mo721e() - 1 || this.f18527l) {
            return this.f18522g.size() <= i10 ? -1 : 2;
        }
        return 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException {
        List<BackupOptionItem> list;
        C11839m.m70688i("BackupOptionRefurbishAdapter", "onBindViewHolder start, position: " + i10);
        if (this.f18521f == null || (list = this.f18522g) == null || i10 >= list.size()) {
            return;
        }
        BackupOptionItem backupOptionItem = this.f18522g.get(i10);
        if (backupOptionItem == null) {
            C11839m.m70688i("BackupOptionRefurbishAdapter", "item is null.");
            return;
        }
        if (abstractC0833c0 instanceof C4026c) {
            C11839m.m70688i("BackupOptionRefurbishAdapter", "header view holder no need bind");
            return;
        }
        if (abstractC0833c0 instanceof C4025b) {
            C11839m.m70688i("BackupOptionRefurbishAdapter", "header pic view holder no need bind");
            return;
        }
        if (abstractC0833c0 instanceof C4024a) {
            ((C4024a) abstractC0833c0).f18531u.setOnClickListener(new View.OnClickListener() { // from class: ae.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f696a.m24784S(view);
                }
            });
        }
        if (abstractC0833c0 instanceof C4027d) {
            C4027d c4027d = (C4027d) abstractC0833c0;
            m24779N(c4027d, backupOptionItem, i10);
            m24778M(c4027d, backupOptionItem);
            this.f18529n.put(backupOptionItem.getAppId(), c4027d);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        C11839m.m70686d("BackupOptionRefurbishAdapter", "start update item onCreateViewHolder start");
        if (i10 == 0) {
            return new C4025b(LayoutInflater.from(this.f18520e).inflate(R$layout.activity_backup_option_refurbish_headpic, viewGroup, false));
        }
        if (i10 != 1) {
            return i10 != 3 ? i10 != 4 ? new C4027d(LayoutInflater.from(this.f18520e).inflate(R$layout.backup_option_list_item, viewGroup, false)) : new C4024a(LayoutInflater.from(this.f18520e).inflate(R$layout.activity_backup_option_refurbish_footer, viewGroup, false)) : new C4027d(LayoutInflater.from(this.f18520e).inflate(R$layout.backup_option_3rd_list_item, viewGroup, false));
        }
        C4026c c4026c = new C4026c(LayoutInflater.from(this.f18520e).inflate(R$layout.activity_backup_option_refurbish_header, viewGroup, false));
        this.f18526k = c4026c;
        return c4026c;
    }
}
