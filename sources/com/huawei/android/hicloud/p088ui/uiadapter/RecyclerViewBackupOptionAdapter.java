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
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsDetailActivity;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0223k;
import p514o9.C11839m;
import p514o9.C11842p;
import p618rm.C12590s0;
import p848zl.C14333b;
import sk.C12809f;
import tl.C13026e;

/* loaded from: classes3.dex */
public class RecyclerViewBackupOptionAdapter extends RecyclerView.AbstractC0838h {

    /* renamed from: d */
    public Context f18788d;

    /* renamed from: e */
    public List<BackupOptionItem> f18789e;

    /* renamed from: f */
    public List<BackupOptionItem> f18790f = new ArrayList();

    /* renamed from: g */
    public C13026e f18791g = new C13026e();

    /* renamed from: h */
    public Resources f18792h;

    /* renamed from: i */
    public List<String> f18793i;

    /* renamed from: j */
    public int f18794j;

    /* renamed from: k */
    public boolean f18795k;

    /* renamed from: l */
    public UpdateOptionStatusListener f18796l;

    /* renamed from: m */
    public int f18797m;

    public interface UpdateOptionStatusListener {
        /* renamed from: c */
        void mo19075c(int i10, String str, boolean z10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.RecyclerViewBackupOptionAdapter$a */
    public class C4058a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public UnionSwitch f18798u;

        public C4058a(View view) {
            super(view);
            this.f18798u = (UnionSwitch) C12809f.m76831d(view, R$id.backup_main_switch_btn);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.RecyclerViewBackupOptionAdapter$b */
    public class C4059b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public final RelativeLayout f18800A;

        /* renamed from: u */
        public ImageView f18802u;

        /* renamed from: v */
        public TextView f18803v;

        /* renamed from: w */
        public TextView f18804w;

        /* renamed from: x */
        public TextView f18805x;

        /* renamed from: y */
        public TextView f18806y;

        /* renamed from: z */
        public UnionSwitch f18807z;

        public C4059b(View view) {
            super(view);
            this.f18802u = (ImageView) C12809f.m76831d(view, R$id.iv_backup_option);
            this.f18803v = (TextView) C12809f.m76831d(view, R$id.tv_title);
            this.f18804w = (TextView) C12809f.m76831d(view, R$id.tv_recommend);
            this.f18805x = (TextView) C12809f.m76831d(view, R$id.tv_option_tip);
            this.f18806y = (TextView) C12809f.m76831d(view, R$id.tv_item_value);
            this.f18807z = (UnionSwitch) C12809f.m76831d(view, R$id.switch_option);
            this.f18800A = (RelativeLayout) C12809f.m76831d(view, R$id.backup_option_list_item_content);
        }

        /* renamed from: V */
        public void m25104V(Drawable drawable) {
            this.f18800A.setBackground(drawable);
        }

        /* renamed from: W */
        public void m25105W(int i10) {
            this.f18800A.setBackgroundColor(i10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.RecyclerViewBackupOptionAdapter$c */
    public class C4060c extends RecyclerView.AbstractC0833c0 {
        public C4060c(View view) {
            super(view);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.RecyclerViewBackupOptionAdapter$d */
    public class C4061d extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f18809u;

        public C4061d(View view) {
            super(view);
            this.f18809u = (TextView) C12809f.m76831d(view, R$id.cloudbackup_more_detail_tips);
        }
    }

    public RecyclerViewBackupOptionAdapter(Context context) {
        this.f18788d = context;
        this.f18792h = context.getResources();
        ArrayList arrayList = new ArrayList(C14333b.m85452H());
        this.f18793i = arrayList;
        arrayList.add("thirdAppData");
        this.f18794j = C11842p.m70840n(context, 14);
        this.f18797m = R$string.backup_option_detail_tip;
    }

    /* renamed from: F */
    public final void m25080F(C4059b c4059b, BackupOptionItem backupOptionItem) throws Resources.NotFoundException {
        String appId = backupOptionItem.getAppId();
        if (this.f18793i.contains(appId)) {
            if (backupOptionItem.getItemTotal() <= 0) {
                c4059b.f18806y.setText(R$string.backup_option_no_data);
                return;
            }
            String strM1524g = C0223k.m1524g(this.f18788d, backupOptionItem.getDataBytes());
            if (!"thirdAppData".equals(appId)) {
                c4059b.f18806y.setText(this.f18788d.getString(R$string.backup_option_value, this.f18792h.getQuantityString(R$plurals.backup_detail_gallery_num, backupOptionItem.getItemTotal(), Integer.valueOf(backupOptionItem.getItemTotal())), strM1524g));
                return;
            } else {
                c4059b.f18806y.setText(this.f18788d.getString(R$string.backup_option_value, this.f18788d.getString(R$string.backup_option_value_no_size, Integer.valueOf(backupOptionItem.getSwitchCount()), this.f18792h.getQuantityString(R$plurals.backup_app_data_count, backupOptionItem.getItemTotal(), Integer.valueOf(backupOptionItem.getItemTotal()))), strM1524g));
                return;
            }
        }
        if (backupOptionItem.getShowType() <= 0) {
            if (backupOptionItem.getDataBytes() == 0) {
                c4059b.f18806y.setText(R$string.backup_option_no_data);
                return;
            } else {
                c4059b.f18806y.setText(C0223k.m1524g(this.f18788d, backupOptionItem.getDataBytes()));
                return;
            }
        }
        if (backupOptionItem.getItemTotal() <= 0 || backupOptionItem.getDataBytes() <= 0) {
            c4059b.f18806y.setText(R$string.backup_option_no_data);
            return;
        }
        if (backupOptionItem.getShowType() == 1) {
            c4059b.f18806y.setText(this.f18792h.getQuantityString(R$plurals.backup_detail_gallery_num, backupOptionItem.getItemTotal(), Integer.valueOf(backupOptionItem.getItemTotal())));
        } else {
            String strM1524g2 = C0223k.m1524g(this.f18788d, backupOptionItem.getDataBytes());
            c4059b.f18806y.setText(this.f18788d.getString(R$string.backup_option_value, this.f18792h.getQuantityString(R$plurals.backup_detail_gallery_num, backupOptionItem.getItemTotal(), Integer.valueOf(backupOptionItem.getItemTotal())), strM1524g2));
        }
    }

    /* renamed from: G */
    public String m25081G(BackupOptionItem backupOptionItem) {
        return C12590s0.m75884o0(backupOptionItem, this.f18791g, this.f18788d);
    }

    /* renamed from: H */
    public List<BackupOptionItem> m25082H() {
        List<BackupOptionItem> list = this.f18789e;
        return list == null ? new ArrayList() : list;
    }

    /* renamed from: I */
    public final /* synthetic */ void m25083I(CompoundButton compoundButton, boolean z10) {
        Context context = this.f18788d;
        if (context instanceof BackupOptionsDetailActivity) {
            ((BackupOptionsDetailActivity) context).onCheckedChanged(compoundButton, z10);
        }
    }

    /* renamed from: J */
    public final /* synthetic */ void m25084J(int i10, String str, CompoundButton compoundButton, boolean z10) {
        UpdateOptionStatusListener updateOptionStatusListener = this.f18796l;
        if (updateOptionStatusListener != null) {
            updateOptionStatusListener.mo19075c(i10, str, z10);
        } else {
            C11839m.m70688i("RecyclerViewBackupOptionAdapter", "listener is null");
        }
    }

    /* renamed from: K */
    public void m25085K(boolean z10) {
        C11839m.m70688i("RecyclerViewBackupOptionAdapter", "");
        this.f18795k = z10;
        m5214k(1);
    }

    /* renamed from: L */
    public final void m25086L(C4059b c4059b, int i10) {
        if (i10 == 1) {
            c4059b.m25104V(this.f18788d.getDrawable(R$drawable.cardview_list_top_shape_white));
        } else if (i10 == mo721e() - 2) {
            c4059b.m25104V(this.f18788d.getDrawable(R$drawable.cardview_list_bottom_shape_white));
        } else {
            c4059b.m25105W(this.f18788d.getColor(R$color.storage_manager_card_bg));
        }
    }

    /* renamed from: M */
    public void m25087M(List<BackupOptionItem> list) {
        this.f18789e = list;
        m5213j();
    }

    /* renamed from: N */
    public void m25088N(List<BackupOptionItem> list, int i10) {
        this.f18797m = i10;
        this.f18789e = list;
        m5213j();
    }

    /* renamed from: O */
    public void m25089O(UpdateOptionStatusListener updateOptionStatusListener) {
        this.f18796l = updateOptionStatusListener;
    }

    /* renamed from: P */
    public final void m25090P(C4059b c4059b, int i10) throws Resources.NotFoundException {
        int i11 = i10 - 2;
        BackupOptionItem backupOptionItem = this.f18789e.get(i11);
        m25091Q(backupOptionItem, c4059b);
        m25093S(backupOptionItem, c4059b);
        m25094T(backupOptionItem, c4059b);
        m25092R(backupOptionItem, c4059b, i11);
        m25086L(c4059b, i10);
        c4059b.f18803v.requestLayout();
    }

    /* renamed from: Q */
    public final void m25091Q(BackupOptionItem backupOptionItem, C4059b c4059b) {
        String appId = backupOptionItem.getAppId();
        String strM25081G = m25081G(backupOptionItem);
        c4059b.f18803v.setText(strM25081G);
        c4059b.f18803v.setText(strM25081G);
        c4059b.f18802u.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(appId));
    }

    /* renamed from: R */
    public final void m25092R(BackupOptionItem backupOptionItem, C4059b c4059b, final int i10) {
        final String appId = backupOptionItem.getAppId();
        c4059b.f18807z.setCheckedProgrammatically(backupOptionItem.getBackupSwitch());
        if (backupOptionItem.isDisable()) {
            c4059b.f18807z.setEnabled(false);
        } else {
            c4059b.f18807z.setEnabled(true);
        }
        c4059b.f18807z.setVisibility(0);
        if ((!HNConstants.DataType.MEDIA.equals(appId) && !"com.tencent.mm".equals(appId)) || C12590s0.m75823Z0() || backupOptionItem.getBackupSwitch()) {
            c4059b.f18804w.setVisibility(8);
        } else {
            c4059b.f18804w.setVisibility(0);
        }
        c4059b.f18807z.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ae.z1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f748a.m25084J(i10, appId, compoundButton, z10);
            }
        });
    }

    /* renamed from: S */
    public final void m25093S(BackupOptionItem backupOptionItem, C4059b c4059b) {
        if (!"com.tencent.mm".equals(backupOptionItem.getAppId())) {
            c4059b.f18805x.setVisibility(8);
        } else {
            c4059b.f18805x.setVisibility(0);
            c4059b.f18805x.setText(R$string.backup_wechat_tip);
        }
    }

    /* renamed from: T */
    public final void m25094T(BackupOptionItem backupOptionItem, C4059b c4059b) throws Resources.NotFoundException {
        int isDataEnable = backupOptionItem.getIsDataEnable();
        if (isDataEnable == 0 || isDataEnable == 1) {
            c4059b.f18806y.setText(R$string.backup_loading);
        } else if (isDataEnable == -1) {
            c4059b.f18806y.setText(R$string.backup_option_not_support_clone);
        } else {
            m25080F(c4059b, backupOptionItem);
        }
    }

    /* renamed from: U */
    public void m25095U(String str, boolean z10) {
        int i10;
        if (TextUtils.isEmpty(str) || this.f18792h == null) {
            return;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= this.f18789e.size()) {
                i10 = -1;
                break;
            } else {
                if (this.f18789e.get(i11).getAppId().equals(str)) {
                    i10 = i11 + 2;
                    this.f18789e.get(i11).setBackupSwitch(z10);
                    this.f18789e.get(i11).setOperateType(1);
                    m5214k(i10);
                    break;
                }
                i11++;
            }
        }
        C11839m.m70686d("RecyclerViewBackupOptionAdapter", "appId: " + str + ", switchStatus: " + z10 + ", position: " + i10);
    }

    /* renamed from: V */
    public void m25096V(BackupOptionItem backupOptionItem) {
        if (this.f18789e == null) {
            C11839m.m70689w("RecyclerViewBackupOptionAdapter", "updateOneModule: list null appId = " + backupOptionItem.getAppId());
            this.f18790f.add(backupOptionItem);
            return;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= this.f18789e.size()) {
                i10 = -1;
                break;
            }
            if (this.f18789e.get(i10).getAppId().equals(backupOptionItem.getAppId())) {
                this.f18789e.get(i10).setAppName(backupOptionItem.getAppName());
                this.f18789e.get(i10).setParent(backupOptionItem.getParent());
                this.f18789e.get(i10).setDisable(backupOptionItem.isDisable());
                this.f18789e.get(i10).setBackupData(backupOptionItem.isBackupData());
                this.f18789e.get(i10).setIsDataEnable(backupOptionItem.getIsDataEnable());
                this.f18789e.get(i10).setCodeBytes(backupOptionItem.getCodeBytes());
                this.f18789e.get(i10).setDataBytes(backupOptionItem.getDataBytes());
                this.f18789e.get(i10).setSwitchCount(backupOptionItem.getSwitchCount());
                this.f18789e.get(i10).setItemTotal(backupOptionItem.getItemTotal());
                this.f18789e.get(i10).setTotalIncrease(backupOptionItem.getTotalIncrease());
                this.f18789e.get(i10).setCurrentIncrease(backupOptionItem.getCurrentIncrease());
                break;
            }
            i10++;
        }
        if (this.f18789e.isEmpty() && i10 == -1) {
            C11839m.m70686d("RecyclerViewBackupOptionAdapter", "update one module : " + backupOptionItem.getAppId() + " , itemList isEmpty ");
            this.f18790f.add(backupOptionItem);
        }
        C11839m.m70686d("RecyclerViewBackupOptionAdapter", "update one module: " + backupOptionItem.getAppId() + ", position: " + i10);
        m5214k(i10 + 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<BackupOptionItem> list = this.f18789e;
        if (list == null || list.isEmpty()) {
            return 1;
        }
        return this.f18789e.size() + 3;
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
        return i10 == mo721e() - 1 ? 3 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException {
        if (abstractC0833c0 instanceof C4061d) {
            C4061d c4061d = (C4061d) abstractC0833c0;
            View view = abstractC0833c0.f4327a;
            int i11 = this.f18794j;
            view.setPaddingRelative(i11, 0, i11, 0);
            c4061d.f18809u.setText(this.f18797m);
            return;
        }
        if (abstractC0833c0 instanceof C4058a) {
            C4058a c4058a = (C4058a) abstractC0833c0;
            c4058a.f18798u.setCheckedProgrammatically(this.f18795k);
            c4058a.f18798u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ae.y1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    this.f736a.m25083I(compoundButton, z10);
                }
            });
        } else if (abstractC0833c0 instanceof C4059b) {
            m25090P((C4059b) abstractC0833c0, i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return i10 == 0 ? new C4061d(LayoutInflater.from(this.f18788d).inflate(R$layout.cloudbackup_option_more_tips, viewGroup, false)) : i10 == 1 ? new C4058a(LayoutInflater.from(this.f18788d).inflate(R$layout.backup_option_allbtn, viewGroup, false)) : i10 == 3 ? new C4060c(LayoutInflater.from(this.f18788d).inflate(R$layout.cloudbackup_option_detail_footer, viewGroup, false)) : new C4059b(LayoutInflater.from(this.f18788d).inflate(R$layout.item_options, viewGroup, false));
    }
}
