package com.huawei.android.hicloud.p088ui.uiadapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupOptionAdapter;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p514o9.C11839m;
import sk.C12809f;

/* renamed from: com.huawei.android.hicloud.ui.uiadapter.c */
/* loaded from: classes3.dex */
public class C4083c extends RecyclerView.AbstractC0838h<C4098d> {

    /* renamed from: d */
    public List<BackupOptionItem> f19000d = new ArrayList();

    /* renamed from: e */
    public final AtomicBoolean f19001e = new AtomicBoolean(false);

    /* renamed from: f */
    public BackupOptionAdapter.UpdateOptionStatusListener f19002f;

    /* renamed from: D */
    private BackupOptionItem m25363D(int i10) {
        return this.f19000d.get(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void mo723s(C4098d c4098d, int i10) {
        BackupOptionItem backupOptionItemM25363D = m25363D(i10);
        if (backupOptionItemM25363D == null) {
            C11839m.m70687e("BackupOptionBasicDataAdapter", "item is null");
            c4098d.f4327a.setVisibility(8);
        } else {
            if (TextUtils.isEmpty(backupOptionItemM25363D.getAppId())) {
                return;
            }
            c4098d.m25457S(backupOptionItemM25363D, i10, this.f19000d.size());
            c4098d.f4327a.setVisibility(0);
            if (this.f19001e.get() || i10 != 2) {
                return;
            }
            C12809f.m76843p(c4098d.f19109y, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public C4098d mo724u(ViewGroup viewGroup, int i10) {
        C4098d c4098d = new C4098d(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.backup_option_basic_data_item, viewGroup, false));
        c4098d.m25461W(this.f19002f);
        return c4098d;
    }

    /* renamed from: G */
    public void m25366G(BackupOptionAdapter.UpdateOptionStatusListener updateOptionStatusListener) {
        this.f19002f = updateOptionStatusListener;
    }

    /* renamed from: H */
    public void m25367H(boolean z10) {
        this.f19001e.set(z10);
        BackupOptionAdapter.UpdateOptionStatusListener updateOptionStatusListener = this.f19002f;
        if (updateOptionStatusListener != null) {
            updateOptionStatusListener.mo18983e0();
        }
    }

    /* renamed from: I */
    public void m25368I(List<BackupOptionItem> list) {
        C11839m.m70688i("BackupOptionBasicDataAdapter", "setItemList items " + list.size());
        if (this.f19000d == null) {
            this.f19000d = new ArrayList();
        }
        this.f19000d.clear();
        this.f19000d.addAll(list);
        m5213j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<BackupOptionItem> list = this.f19000d;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        if (this.f19000d.size() > 4 && !this.f19001e.get()) {
            return Math.min(this.f19000d.size(), 3);
        }
        return this.f19000d.size();
    }
}
