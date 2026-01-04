package com.huawei.android.hicloud.p088ui.uiadapter;

import ae.C0167t;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.BackupOptionFooterDataBean;
import com.huawei.android.hicloud.cloudbackup.bean.BackupOptionHeaderDataBean;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupOptionAdapter;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import p015ak.C0209d;
import p292fn.C9733f;
import p514o9.C11839m;
import tl.C13026e;

/* loaded from: classes3.dex */
public class BackupOptionAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: e */
    public Context f18514e;

    /* renamed from: h */
    public UpdateOptionStatusListener f18517h;

    /* renamed from: f */
    public final List<Object> f18515f = new ArrayList();

    /* renamed from: g */
    public List<BackupOptionItem> f18516g = new ArrayList();

    /* renamed from: i */
    public C13026e f18518i = new C13026e();

    /* renamed from: d */
    public boolean f18513d = C9733f.m60705z().m60720O("cloudBackupHiddenAlbum");

    public interface UpdateOptionStatusListener {
        /* renamed from: c0 */
        void mo18979c0(int i10, String str, boolean z10, BackupOptionItem backupOptionItem);

        /* renamed from: e0 */
        void mo18983e0();

        void onSystemItemClick(View view);

        /* renamed from: x */
        void mo19019x(int i10, String str, boolean z10, BackupOptionItem backupOptionItem);
    }

    public BackupOptionAdapter(Context context) {
        this.f18514e = context;
        C11839m.m70688i("BackupOptionAdapter", "isBackupHideGallery: " + this.f18513d);
    }

    /* renamed from: L */
    public static /* synthetic */ boolean m24755L(String str, Object obj) {
        if (obj instanceof BackupOptionItem) {
            return TextUtils.equals(((BackupOptionItem) obj).getAppId(), str);
        }
        return false;
    }

    /* renamed from: M */
    public static /* synthetic */ void m24756M(List list, Object obj) {
        if (obj instanceof BackupOptionItem) {
            list.add((BackupOptionItem) obj);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    /* renamed from: F */
    public void m24757F(List<Object> list) {
        this.f18515f.clear();
        this.f18515f.addAll(list);
        m5213j();
    }

    /* renamed from: G */
    public BackupOptionItem m24758G(final String str) {
        return (BackupOptionItem) this.f18515f.stream().filter(new Predicate() { // from class: ae.o
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BackupOptionAdapter.m24755L(str, obj);
            }
        }).findFirst().orElse(new BackupOptionItem());
    }

    /* renamed from: H */
    public List<Object> m24759H() {
        return this.f18515f;
    }

    /* renamed from: I */
    public List<BackupOptionItem> m24760I() {
        return this.f18516g;
    }

    /* renamed from: J */
    public List<BackupOptionItem> m24761J() {
        final ArrayList arrayList = new ArrayList();
        this.f18515f.forEach(new Consumer() { // from class: ae.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                BackupOptionAdapter.m24756M(arrayList, obj);
            }
        });
        return arrayList;
    }

    /* renamed from: K */
    public int m24762K(String str) {
        for (int i10 = 0; i10 < this.f18515f.size(); i10++) {
            if ((this.f18515f.get(i10) instanceof BackupOptionItem) && ((BackupOptionItem) this.f18515f.get(i10)).getAppId().equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: N */
    public void m24763N(UpdateOptionStatusListener updateOptionStatusListener) {
        this.f18517h = updateOptionStatusListener;
    }

    /* renamed from: O */
    public void m24764O(String str, boolean z10) {
        BackupOptionHeaderDataBean backupOptionHeaderDataBean;
        List<BackupOptionItem> baseDataList;
        if (!TextUtils.isEmpty(str) && this.f18515f.size() > 0) {
            int i10 = 0;
            if (!(this.f18515f.get(0) instanceof BackupOptionHeaderDataBean) || (backupOptionHeaderDataBean = (BackupOptionHeaderDataBean) this.f18515f.get(0)) == null || backupOptionHeaderDataBean.getBaseDataList() == null || (baseDataList = backupOptionHeaderDataBean.getBaseDataList()) == null) {
                return;
            }
            int i11 = 0;
            while (true) {
                if (i11 >= baseDataList.size()) {
                    break;
                }
                if (baseDataList.get(i11) instanceof BackupOptionItem) {
                    BackupOptionItem backupOptionItem = baseDataList.get(i11);
                    if (backupOptionItem != null && str.equals(backupOptionItem.getAppId())) {
                        backupOptionItem.setBackupSwitch(z10);
                        backupOptionItem.setOperateType(1);
                        i10 = i11;
                        break;
                    }
                } else {
                    C11839m.m70689w("BackupOptionAdapter", "not option: , position: " + i11);
                }
                i11++;
            }
            C11839m.m70688i("BackupOptionAdapter", "appId: " + str + ", switchStatus: " + z10 + ", position: " + i10);
        }
    }

    /* renamed from: P */
    public void m24765P(String str) {
        int iM24762K;
        if (TextUtils.isEmpty(str) || (iM24762K = m24762K(str)) == -1) {
            return;
        }
        m5214k(iM24762K);
    }

    /* renamed from: Q */
    public void m24766Q(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= this.f18515f.size()) {
                break;
            }
            if (this.f18515f.get(i11) instanceof BackupOptionItem) {
                BackupOptionItem backupOptionItem = (BackupOptionItem) this.f18515f.get(i11);
                if (backupOptionItem != null && str.equals(backupOptionItem.getAppId())) {
                    backupOptionItem.setBackupSwitch(z10);
                    backupOptionItem.setOperateType(1);
                    i10 = i11;
                    break;
                }
            } else {
                C11839m.m70686d("BackupOptionAdapter", "not option: , position: " + i11);
            }
            i11++;
        }
        C11839m.m70686d("BackupOptionAdapter", "appId: " + str + ", switchStatus: " + z10 + ", position: " + i10);
        m5214k(i10);
    }

    /* renamed from: R */
    public void m24767R(BackupOptionItem backupOptionItem) {
        int i10 = 0;
        while (true) {
            if (i10 >= this.f18515f.size()) {
                i10 = -1;
                break;
            }
            if (this.f18515f.get(i10) instanceof BackupOptionItem) {
                BackupOptionItem backupOptionItem2 = (BackupOptionItem) this.f18515f.get(i10);
                if (backupOptionItem2.getAppId().equals(backupOptionItem.getAppId())) {
                    backupOptionItem2.setAppName(backupOptionItem.getAppName());
                    backupOptionItem2.setParent(backupOptionItem.getParent());
                    backupOptionItem2.setDisable(backupOptionItem.isDisable());
                    backupOptionItem2.setBackupData(backupOptionItem.isBackupData());
                    backupOptionItem2.setIsDataEnable(backupOptionItem.getIsDataEnable());
                    backupOptionItem2.setCodeBytes(backupOptionItem.getCodeBytes());
                    backupOptionItem2.setDataBytes(backupOptionItem.getDataBytes());
                    backupOptionItem2.setSwitchCount(backupOptionItem.getSwitchCount());
                    backupOptionItem2.setItemTotal(backupOptionItem.getItemTotal());
                    backupOptionItem2.setTotalIncrease(backupOptionItem.getTotalIncrease());
                    backupOptionItem2.setCurrentIncrease(backupOptionItem.getCurrentIncrease());
                    backupOptionItem2.setData1(backupOptionItem.getData1());
                    break;
                }
            }
            i10++;
        }
        if (this.f18515f.isEmpty() && i10 == -1) {
            C11839m.m70686d("BackupOptionAdapter", "update one module : " + backupOptionItem.getAppId() + " , itemList isEmpty ");
            this.f18516g.add(backupOptionItem);
        }
        C11839m.m70686d("BackupOptionAdapter", "update one module: " + backupOptionItem.getAppId() + ", position: " + i10);
        m24768S(i10);
    }

    /* renamed from: S */
    public void m24768S(int i10) {
        if (i10 < 0) {
            return;
        }
        m5214k(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f18515f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        if (this.f18515f.get(i10) == null) {
            return 0;
        }
        Object obj = this.f18515f.get(i10);
        if (obj instanceof BackupOptionHeaderDataBean) {
            return 0;
        }
        if (obj instanceof BackupOptionItem) {
            return 1;
        }
        return obj instanceof BackupOptionFooterDataBean ? 2 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException {
        if (i10 >= this.f18515f.size()) {
            return;
        }
        Object obj = this.f18515f.get(i10);
        if (abstractC0833c0 instanceof C4099e) {
            C4099e c4099e = (C4099e) abstractC0833c0;
            if (obj instanceof BackupOptionHeaderDataBean) {
                c4099e.m25478e0((BackupOptionHeaderDataBean) obj);
                return;
            } else {
                C11839m.m70688i("BackupOptionAdapter", "bind type error");
                return;
            }
        }
        if (abstractC0833c0 instanceof C4100f) {
            C4100f c4100f = (C4100f) abstractC0833c0;
            c4100f.m25484U(mo721e() - 2, this.f18518i);
            c4100f.m25496g0((BackupOptionItem) obj, i10 - 1, this.f18513d);
        } else if (abstractC0833c0 instanceof C0167t) {
            ((C0167t) abstractC0833c0).m901U((BackupOptionFooterDataBean) obj);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        float fM1195O = C0209d.m1195O(this.f18514e);
        if (i10 == 0) {
            return new C4099e(fM1195O < 1.75f ? LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.activity_backup_option_header, (ViewGroup) null) : Math.abs(fM1195O - 1.75f) < 1.0E-4f ? LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.activity_backup_option_header_one_font_scale, (ViewGroup) null) : (fM1195O <= 1.75f || fM1195O > 2.0f) ? LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.activity_backup_option_header_three_font_scale, (ViewGroup) null) : LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.activity_backup_option_header_two_font_scale, (ViewGroup) null), this.f18517h);
        }
        if (i10 == 1) {
            return new C4100f(this.f18514e, LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.backup_option_list_item, viewGroup, false), this.f18517h);
        }
        return new C0167t(this.f18514e, LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.activity_backup_option_footer, (ViewGroup) null));
    }
}
