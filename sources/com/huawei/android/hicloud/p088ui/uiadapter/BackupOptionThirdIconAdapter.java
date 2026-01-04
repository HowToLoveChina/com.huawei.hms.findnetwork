package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupOptionThirdIconAdapter;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import p514o9.C11839m;
import p514o9.C11842p;
import p709vj.C13452e;
import p848zl.C14333b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupOptionThirdIconAdapter extends RecyclerView.AbstractC0838h {

    /* renamed from: d */
    public Context f18551d;

    /* renamed from: e */
    public List<BackupOptionItem> f18552e = new ArrayList();

    /* renamed from: f */
    public boolean f18553f;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupOptionThirdIconAdapter$a */
    public class C4028a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ImageView f18554u;

        /* renamed from: v */
        public ImageView f18555v;

        public C4028a(View view) {
            super(view);
            this.f18554u = (ImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon);
            this.f18555v = (ImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon_badge);
        }
    }

    public BackupOptionThirdIconAdapter(Context context) {
        this.f18551d = context;
    }

    /* renamed from: F */
    public static /* synthetic */ boolean m24796F(BackupOptionItem backupOptionItem) {
        return TextUtils.equals("baseData", backupOptionItem.getAppId());
    }

    /* renamed from: E */
    public void m24797E(List<BackupOptionItem> list) {
        if (list == null || list.size() <= 0) {
            this.f18552e.clear();
            m5213j();
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((BackupOptionItem) it.next()).getBackupSwitch()) {
                it.remove();
            }
        }
        if (C13452e.m80781L().m80887a1()) {
            arrayList.removeIf(new Predicate() { // from class: ae.a0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return BackupOptionThirdIconAdapter.m24796F((BackupOptionItem) obj);
                }
            });
        }
        this.f18552e.clear();
        this.f18552e.addAll(arrayList);
        m5213j();
    }

    /* renamed from: G */
    public void m24798G(boolean z10) {
        this.f18553f = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<BackupOptionItem> list = this.f18552e;
        if (list == null) {
            return 0;
        }
        if (list.size() < 7) {
            return this.f18552e.size();
        }
        return 7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: f */
    public long mo722f(int i10) {
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        BackupOptionItem backupOptionItem;
        List<BackupOptionItem> list = this.f18552e;
        if (list == null || i10 >= list.size() || (backupOptionItem = this.f18552e.get(i10)) == null || !backupOptionItem.getBackupSwitch()) {
            return;
        }
        String appId = this.f18552e.get(i10).getAppId();
        C11839m.m70686d("BackupOptionThirdIconAdapter", "appId: " + appId + ", position: " + i10);
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        C4028a c4028a = (C4028a) abstractC0833c0;
        ImageView imageView = c4028a.f18554u;
        if (this.f18551d != null && this.f18553f) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int iM70844o = (int) C11842p.m70844o(this.f18551d, 14);
                layoutParams2.width = iM70844o;
                layoutParams2.height = iM70844o;
                imageView.setLayoutParams(layoutParams2);
            }
        }
        if (SplitAppUtil.hasSplitAppSuffix(appId)) {
            c4028a.f18555v.setVisibility(0);
            appId = SplitAppUtil.getSplitOriAppId(appId);
        } else {
            c4028a.f18555v.setVisibility(8);
        }
        if (backupOptionItem.getParent().equals("virtualApp")) {
            imageView.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(appId, null));
        } else if (C14333b.m85483r().containsKey(appId)) {
            imageView.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(appId));
        } else {
            imageView.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(appId));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new C4028a(LayoutInflater.from(this.f18551d).inflate(R$layout.backup_option_third_icon_list_item_new, viewGroup, false));
    }
}
