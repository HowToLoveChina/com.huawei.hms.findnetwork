package com.huawei.android.hicloud.p088ui.uiadapter;

import ae.C0144l0;
import ae.C0147m0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ck.C1443a;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import java.util.List;
import om.C11965e;
import p015ak.C0209d;
import p015ak.C0223k;
import p514o9.C11839m;
import p848zl.C14333b;

/* loaded from: classes3.dex */
public class CloudBackupDetailAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public final Context f18636d;

    /* renamed from: e */
    public List<Object> f18637e;

    /* renamed from: f */
    public IRecyclerViewOnListener f18638f;

    /* renamed from: g */
    public String f18639g = "auto";

    /* renamed from: h */
    public boolean f18640h;

    public interface IRecyclerViewOnListener {
        /* renamed from: g0 */
        void mo19305g0(int i10, BackupItem backupItem, boolean z10);
    }

    public CloudBackupDetailAdapter(Context context) {
        this.f18636d = context;
    }

    /* renamed from: E */
    public final void m24880E(BackupItem backupItem, C0144l0 c0144l0) throws Resources.NotFoundException {
        int iM29860M = backupItem.m29860M();
        boolean zM29863P = backupItem.m29863P();
        boolean zM29862O = backupItem.m29862O();
        boolean z10 = false;
        switch (iM29860M) {
            case 1:
            case 2:
            case 3:
                m24899X(backupItem, c0144l0);
                m24884I(c0144l0);
                m24883H(c0144l0);
                m24902a0(c0144l0, backupItem);
                m24900Y(c0144l0, backupItem, false);
                break;
            case 4:
                if (zM29863P && !zM29862O && !"thirdApp".equals(backupItem.m29870d())) {
                    z10 = true;
                }
                m24886K(c0144l0);
                m24885J(c0144l0);
                m24893R(backupItem, c0144l0);
                m24884I(c0144l0);
                m24883H(c0144l0);
                m24900Y(c0144l0, backupItem, true ^ z10);
                break;
            case 5:
                if (zM29863P && !zM29862O) {
                    m24901Z(backupItem, c0144l0);
                    break;
                } else {
                    m24885J(c0144l0);
                    m24886K(c0144l0);
                    m24905d0(backupItem, c0144l0);
                    m24884I(c0144l0);
                    m24896U(c0144l0);
                    m24900Y(c0144l0, backupItem, false);
                    break;
                }
            case 6:
                m24885J(c0144l0);
                m24886K(c0144l0);
                m24905d0(backupItem, c0144l0);
                m24896U(c0144l0);
                m24884I(c0144l0);
                m24900Y(c0144l0, backupItem, false);
                break;
            case 7:
                m24885J(c0144l0);
                m24886K(c0144l0);
                m24904c0(backupItem, c0144l0);
                m24883H(c0144l0);
                m24898W(c0144l0, backupItem);
                m24903b0(backupItem, c0144l0);
                m24900Y(c0144l0, backupItem, false);
                break;
            default:
                m24885J(c0144l0);
                m24895T(backupItem, c0144l0);
                m24883H(c0144l0);
                m24884I(c0144l0);
                m24886K(c0144l0);
                m24900Y(c0144l0, backupItem, false);
                break;
        }
    }

    /* renamed from: F */
    public final String m24881F(BackupItem backupItem, String str) {
        int iM29877l = (!backupItem.m29867U() || backupItem.m29828M0() > 0 || "music".equals(str)) ? backupItem.m29877l() : 0;
        long jM29875i = backupItem.m29875i();
        long jM29873g = backupItem.m29873g();
        if (7 == backupItem.m29860M()) {
            C11839m.m70688i("CloudBackupDetailAdapter", "getBackupIngText dataBytes = " + jM29875i + " attachBytes = " + jM29873g + " appId " + backupItem.m29870d() + " type = " + backupItem.m29860M());
            jM29875i += jM29873g;
        }
        if (!"thirdApp".equals(str) && backupItem.m29828M0() != 1) {
            if (jM29875i <= 0 || iM29877l <= 0) {
                return jM29875i > 0 ? C0223k.m1524g(this.f18636d, backupItem.m29875i()) : iM29877l > 0 ? this.f18636d.getResources().getQuantityString(R$plurals.backup_item_number, iM29877l, Integer.valueOf(iM29877l)) : this.f18636d.getString(R$string.backup_option_no_app_data);
            }
            return this.f18636d.getResources().getQuantityString(R$plurals.backup_backing_state, iM29877l, Integer.valueOf(iM29877l), C0223k.m1524g(this.f18636d, jM29875i));
        }
        return this.f18636d.getResources().getQuantityString(R$plurals.backup_item_number, iM29877l, Integer.valueOf(iM29877l));
    }

    /* renamed from: G */
    public final String m24882G(BackupItem backupItem, String str) {
        C11839m.m70686d("CloudBackupDetailAdapter", "getItemText backupItem = " + backupItem.toString());
        if (!C14333b.m85482q().contains(str) && !backupItem.m29863P()) {
            return m24881F(backupItem, str);
        }
        long jM29875i = backupItem.m29875i();
        if (backupItem.m29863P()) {
            long jM29873g = backupItem.m29873g();
            if (7 == backupItem.m29860M()) {
                C11839m.m70688i("CloudBackupDetailAdapter", "getItemText dataBytes = " + jM29875i + " attachBytes = " + jM29873g + " appId " + backupItem.m29870d());
                jM29875i += jM29873g;
            }
        }
        return "thirdApp".equals(backupItem.m29826K0()) ? "" : backupItem.m29875i() == 0 ? this.f18636d.getString(R$string.backup_option_no_app_data) : C0223k.m1524g(this.f18636d, jM29875i);
    }

    /* renamed from: H */
    public final void m24883H(C0144l0 c0144l0) {
        c0144l0.f521u.m25651c();
    }

    /* renamed from: I */
    public final void m24884I(C0144l0 c0144l0) {
        c0144l0.f521u.m25654f();
    }

    /* renamed from: J */
    public final void m24885J(C0144l0 c0144l0) {
        c0144l0.f521u.m25655g();
    }

    /* renamed from: K */
    public final void m24886K(C0144l0 c0144l0) {
        c0144l0.f521u.m25653e();
    }

    /* renamed from: L */
    public final /* synthetic */ void m24887L(BackupItem backupItem, int i10, View view) {
        if (C0209d.m1226Y0() || !backupItem.m29864R()) {
            C11839m.m70689w("CloudBackupDetailAdapter", "click too fast or childList is null");
            return;
        }
        boolean zM29829N0 = backupItem.m29829N0();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("click secondChild show setShow:");
        sb2.append(!zM29829N0);
        sb2.append(" AppName:");
        sb2.append(backupItem.m29871e());
        C11839m.m70689w("CloudBackupDetailAdapter", sb2.toString());
        IRecyclerViewOnListener iRecyclerViewOnListener = this.f18638f;
        if (iRecyclerViewOnListener != null) {
            iRecyclerViewOnListener.mo19305g0(i10, backupItem, !zM29829N0);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: M */
    public final void m24888M(C0144l0 c0144l0, int i10) {
        if (i10 == 1) {
            if (mo721e() == 2) {
                c0144l0.m822P(this.f18636d.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
                return;
            } else {
                c0144l0.m822P(this.f18636d.getDrawable(R$drawable.cardview_list_top_shape_white));
                return;
            }
        }
        if (i10 == mo721e() - 1) {
            c0144l0.m822P(this.f18636d.getDrawable(R$drawable.cardview_list_bottom_shape_white));
        } else {
            c0144l0.m823Q(this.f18636d.getColor(R$color.storage_manager_card_bg));
        }
    }

    /* renamed from: N */
    public void m24889N(String str) {
        this.f18639g = str;
    }

    /* renamed from: O */
    public void m24890O(List<Object> list) {
        this.f18637e = list;
        m5213j();
    }

    /* renamed from: P */
    public void m24891P(IRecyclerViewOnListener iRecyclerViewOnListener) {
        this.f18638f = iRecyclerViewOnListener;
    }

    /* renamed from: Q */
    public void m24892Q(boolean z10) {
        this.f18640h = z10;
    }

    /* renamed from: R */
    public final void m24893R(BackupItem backupItem, C0144l0 c0144l0) {
        String strM29870d = backupItem.m29870d();
        boolean zM29864R = backupItem.m29864R();
        String quantityString = CBAccess.hasTaskWorking() ? (zM29864R || "thirdApp".equals(backupItem.m29870d())) ? this.f18636d.getResources().getQuantityString(R$plurals.backup_backing_total, backupItem.m29876j(), Integer.valueOf(backupItem.m29869c()), Integer.valueOf(backupItem.m29876j())) : m24882G(backupItem, strM29870d) : (zM29864R || "thirdApp".equals(backupItem.m29870d())) ? this.f18636d.getResources().getQuantityString(R$plurals.backup_backed_total, backupItem.m29876j(), Integer.valueOf(backupItem.m29869c()), Integer.valueOf(backupItem.m29876j())) : this.f18636d.getString(R$string.backup_fail);
        C11839m.m70688i("CloudBackupDetailAdapter", "showBackIngStateText text " + quantityString);
        c0144l0.f521u.setBackUpState(quantityString);
    }

    /* renamed from: S */
    public void m24894S(C0147m0 c0147m0, int i10) {
        List<Object> list = this.f18637e;
        if (list == null) {
            return;
        }
        Object obj = list.get(i10);
        if (obj instanceof CloudBackupState) {
            c0147m0.m836S((CloudBackupState) obj, this.f18637e.size());
        }
    }

    /* renamed from: T */
    public final void m24895T(BackupItem backupItem, C0144l0 c0144l0) throws Resources.NotFoundException {
        String string;
        if ("baseData".equals(backupItem.m29870d())) {
            string = this.f18636d.getResources().getQuantityString(R$plurals.backup_backing_total, backupItem.m29876j(), Integer.valueOf(backupItem.m29869c()), Integer.valueOf(backupItem.m29876j()));
            if (!CBAccess.hasTaskWorking()) {
                string = this.f18636d.getResources().getQuantityString(R$plurals.backup_backed_total, backupItem.m29876j(), Integer.valueOf(backupItem.m29869c()), Integer.valueOf(backupItem.m29876j()));
            }
        } else {
            string = this.f18636d.getString(R$string.backup_wait);
            if (!CBAccess.hasTaskWorking()) {
                string = this.f18636d.getString(R$string.backup_wait_backup);
            }
        }
        c0144l0.f521u.setBackUpState(string);
    }

    /* renamed from: U */
    public final void m24896U(C0144l0 c0144l0) {
        if (CBAccess.hasTaskWorking()) {
            c0144l0.f521u.m25664p();
        } else {
            m24883H(c0144l0);
        }
    }

    /* renamed from: V */
    public final void m24897V(C0144l0 c0144l0, final int i10) throws Resources.NotFoundException {
        List<Object> list = this.f18637e;
        if (list == null) {
            return;
        }
        Object obj = list.get(i10);
        if (obj instanceof BackupItem) {
            final BackupItem backupItem = (BackupItem) obj;
            if (C1443a.f6214b.booleanValue()) {
                C11839m.m70688i("CloudBackupDetailAdapter", "onBindViewHolder appId:" + backupItem + " pro" + C11965e.m71974f().m71978g(backupItem));
            }
            m24888M(c0144l0, i10);
            String strM29870d = backupItem.m29870d();
            c0144l0.f521u.m25649a(strM29870d);
            if (SplitAppUtil.hasSplitAppSuffix(strM29870d)) {
                strM29870d = SplitAppUtil.getSplitOriAppId(strM29870d);
            }
            c0144l0.f521u.setBackUpItemIcon(backupItem.m29867U() ? CloudBackup3rdIconUtil.getDrawable(strM29870d, null) : C14333b.m85483r().containsKey(strM29870d) ? CloudBackup3rdIconUtil.getDrawable(strM29870d) : CloudBackup3rdIconUtil.get3rdDrawable(strM29870d));
            if (backupItem.m29864R()) {
                c0144l0.f521u.m25650b(backupItem.m29829N0());
                c0144l0.f521u.m25659k();
            } else {
                c0144l0.f521u.m25652d();
            }
            c0144l0.f521u.m25661m(i10 + 1 != mo721e());
            c0144l0.f521u.setBackupAppName(backupItem.m29871e());
            m24880E(backupItem, c0144l0);
            c0144l0.f521u.setTag(Integer.valueOf(i10));
            c0144l0.f521u.setOnClickListener(new View.OnClickListener() { // from class: ae.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f503a.m24887L(backupItem, i10, view);
                }
            });
        }
    }

    /* renamed from: W */
    public final void m24898W(C0144l0 c0144l0, BackupItem backupItem) {
        boolean zM29864R = backupItem.m29864R();
        if (!CBAccess.hasTaskWorking() && backupItem.m29860M() != 7) {
            c0144l0.f521u.m25654f();
        } else if (zM29864R) {
            c0144l0.f521u.m25654f();
        } else {
            c0144l0.f521u.setMakeFileProgress(100);
        }
    }

    /* renamed from: X */
    public final void m24899X(BackupItem backupItem, C0144l0 c0144l0) {
        boolean zM29864R = backupItem.m29864R();
        c0144l0.f521u.setBackUpState(CBAccess.hasTaskWorking() ? (zM29864R || "thirdApp".equals(backupItem.m29870d())) ? this.f18636d.getResources().getQuantityString(R$plurals.backup_backing_total, backupItem.m29876j(), Integer.valueOf(backupItem.m29869c()), Integer.valueOf(backupItem.m29876j())) : this.f18636d.getString(R$string.backup_prepareing_state_tip) : zM29864R ? this.f18636d.getResources().getQuantityString(R$plurals.backup_backing_total, backupItem.m29876j(), Integer.valueOf(backupItem.m29869c()), Integer.valueOf(backupItem.m29876j())) : this.f18636d.getString(R$string.backup_fail));
    }

    /* renamed from: Y */
    public final void m24900Y(C0144l0 c0144l0, BackupItem backupItem, boolean z10) {
        float fM71978g = C11965e.m71974f().m71978g(backupItem);
        String strM29870d = backupItem.m29870d();
        float fM29827L0 = backupItem.m29827L0();
        C11839m.m70686d("CloudBackupDetailAdapter", "checkShowView :" + backupItem.toString() + "progress = " + fM71978g + " show = " + z10 + " pro = " + fM29827L0);
        if (fM71978g > fM29827L0 || backupItem.m29860M() == -1) {
            backupItem.m29846e1(fM71978g);
        } else {
            fM71978g = fM29827L0;
        }
        boolean zM29864R = backupItem.m29864R();
        if (z10 && CBAccess.hasTaskWorking() && !zM29864R) {
            c0144l0.f521u.m25658j(strM29870d, fM71978g);
        } else {
            c0144l0.f521u.m25656h();
        }
    }

    /* renamed from: Z */
    public final void m24901Z(BackupItem backupItem, C0144l0 c0144l0) {
        m24886K(c0144l0);
        m24885J(c0144l0);
        m24893R(backupItem, c0144l0);
        m24884I(c0144l0);
        m24883H(c0144l0);
        m24900Y(c0144l0, backupItem, true);
    }

    /* renamed from: a0 */
    public final void m24902a0(C0144l0 c0144l0, BackupItem backupItem) {
        boolean zM29864R = backupItem.m29864R();
        if (!CBAccess.hasTaskWorking() || zM29864R) {
            m24885J(c0144l0);
            c0144l0.f521u.m25653e();
            return;
        }
        long jM29868a = backupItem.m29868a();
        String strM29826K0 = backupItem.m29826K0();
        if (jM29868a <= 0 || "thirdApp".equals(strM29826K0)) {
            c0144l0.f521u.m25653e();
            c0144l0.f521u.m25662n();
        } else {
            String strM1524g = C0223k.m1524g(this.f18636d, backupItem.m29868a());
            m24885J(c0144l0);
            c0144l0.f521u.m25660l(strM1524g);
        }
    }

    /* renamed from: b0 */
    public final void m24903b0(BackupItem backupItem, C0144l0 c0144l0) {
        if (backupItem.m29864R()) {
            return;
        }
        c0144l0.f521u.m25663o();
    }

    /* renamed from: c0 */
    public final void m24904c0(BackupItem backupItem, C0144l0 c0144l0) {
        c0144l0.f521u.setBackUpState((backupItem.m29864R() || "thirdApp".equals(backupItem.m29870d())) ? m24881F(backupItem, backupItem.m29870d()) : m24882G(backupItem, backupItem.m29870d()));
    }

    /* renamed from: d0 */
    public final void m24905d0(BackupItem backupItem, C0144l0 c0144l0) {
        String strM24882G = CBAccess.hasTaskWorking() ? m24882G(backupItem, backupItem.m29870d()) : (backupItem.m29864R() || "thirdApp".equals(backupItem.m29870d())) ? this.f18636d.getResources().getQuantityString(R$plurals.backup_backed_total, backupItem.m29876j(), Integer.valueOf(backupItem.m29869c())) : this.f18636d.getString(R$string.backup_fail);
        C11839m.m70686d("CloudBackupDetailAdapter", "showUploadAndCreateStateText appId = " + backupItem.m29870d() + " parentId = " + backupItem.m29826K0() + " text =" + strM24882G);
        c0144l0.f521u.setBackUpState(strM24882G);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<Object> list = this.f18637e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        List<Object> list = this.f18637e;
        if (list != null && list.get(i10) != null) {
            Object obj = this.f18637e.get(i10);
            if (obj instanceof CloudBackupState) {
                return 4;
            }
            if (obj instanceof BackupItem) {
                return ((BackupItem) obj).m29825J0();
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException {
        List<Object> list = this.f18637e;
        if (list == null || list.isEmpty()) {
            C11839m.m70687e("CloudBackupDetailAdapter", "backupItemList is null");
        } else if (abstractC0833c0 instanceof C0147m0) {
            m24894S((C0147m0) abstractC0833c0, i10);
        } else if (abstractC0833c0 instanceof C0144l0) {
            m24897V((C0144l0) abstractC0833c0, i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        C11839m.m70686d("CloudBackupDetailAdapter", "start update item onCreateViewHolder start");
        return i10 != 2 ? i10 != 3 ? i10 != 4 ? new C0144l0(LayoutInflater.from(this.f18636d).inflate(R$layout.backup_detail_item, viewGroup, false), i10) : new C0147m0(LayoutInflater.from(this.f18636d).inflate(R$layout.item_backup_state_view, viewGroup, false), this.f18636d, this.f18639g, this.f18640h) : new C0144l0(LayoutInflater.from(this.f18636d).inflate(R$layout.backup_subitem_thirdapp_view, viewGroup, false), i10) : new C0144l0(LayoutInflater.from(this.f18636d).inflate(R$layout.backup_subitem_view, viewGroup, false), i10);
    }
}
