package com.huawei.android.hicloud.p088ui.uiadapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupSpaceDetailAdapter;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p514o9.C11839m;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.uiadapter.h */
/* loaded from: classes3.dex */
public class C4102h extends RecyclerView.AbstractC0838h<C4103i> {

    /* renamed from: e */
    public BackupSpaceDetailAdapter.DeleteBackupModuleListener f19157e;

    /* renamed from: f */
    public View.OnClickListener f19158f;

    /* renamed from: d */
    public List<AppDetailsInfo> f19156d = new ArrayList();

    /* renamed from: g */
    public final AtomicBoolean f19159g = new AtomicBoolean(false);

    /* renamed from: D */
    private AppDetailsInfo m25518D(int i10) {
        return this.f19156d.get(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void mo723s(C4103i c4103i, int i10) {
        AppDetailsInfo appDetailsInfoM25518D = m25518D(i10);
        if (appDetailsInfoM25518D == null) {
            C11839m.m70687e("ManagerBackupDataBasicItemAdapter", "item is null");
            c4103i.f4327a.setVisibility(8);
        } else {
            if (TextUtils.isEmpty(appDetailsInfoM25518D.getBackupAppName())) {
                return;
            }
            c4103i.m25532T(c4103i, appDetailsInfoM25518D, i10, this.f19156d.size());
            c4103i.f4327a.setVisibility(0);
            if (this.f19159g.get() || i10 != 1) {
                return;
            }
            C12809f.m76843p(c4103i.f19162C, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public C4103i mo724u(ViewGroup viewGroup, int i10) {
        C4103i c4103i = new C4103i(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.manager_backup_module_basic_data_item, viewGroup, false));
        c4103i.m25534W(this.f19157e);
        c4103i.m25535X(this.f19158f);
        return c4103i;
    }

    /* renamed from: G */
    public void m25521G(BackupSpaceDetailAdapter.DeleteBackupModuleListener deleteBackupModuleListener) {
        this.f19157e = deleteBackupModuleListener;
    }

    /* renamed from: H */
    public void m25522H(boolean z10) {
        this.f19159g.set(z10);
        m5213j();
    }

    /* renamed from: I */
    public void m25523I(List<AppDetailsInfo> list) {
        C11839m.m70688i("ManagerBackupDataBasicItemAdapter", "setItemList items " + list.size());
        if (this.f19156d == null) {
            this.f19156d = new ArrayList();
        }
        this.f19156d.clear();
        this.f19156d.addAll(list);
        m5213j();
    }

    /* renamed from: J */
    public void m25524J(View.OnClickListener onClickListener) {
        this.f19158f = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<AppDetailsInfo> list = this.f19156d;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        if (this.f19156d.size() > 3 && !this.f19159g.get()) {
            return Math.min(this.f19156d.size(), 2);
        }
        return this.f19156d.size();
    }
}
