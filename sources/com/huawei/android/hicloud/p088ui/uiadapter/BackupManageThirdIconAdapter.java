package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import java.util.ArrayList;
import java.util.List;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupManageThirdIconAdapter extends RecyclerView.AbstractC0838h {

    /* renamed from: d */
    public Context f18509d;

    /* renamed from: e */
    public List<AppDetailsInfo> f18510e = new ArrayList();

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupManageThirdIconAdapter$a */
    public class C4023a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ImageView f18511u;

        public C4023a(View view) {
            super(view);
            this.f18511u = (ImageView) C12809f.m76831d(view, R$id.backup_option_list_item_icon);
        }
    }

    public BackupManageThirdIconAdapter(Context context) {
        this.f18509d = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<AppDetailsInfo> list = this.f18510e;
        if (list == null) {
            return 0;
        }
        if (list.size() < 7) {
            return this.f18510e.size();
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
        AppDetailsInfo appDetailsInfo;
        List<AppDetailsInfo> list = this.f18510e;
        if (list == null || i10 >= list.size() || (appDetailsInfo = this.f18510e.get(i10)) == null || appDetailsInfo.getTotalSize() <= 0) {
            return;
        }
        String backupAppName = this.f18510e.get(i10).getBackupAppName();
        C11839m.m70686d("BackupOptionThirdIconAdapter", "appId: " + backupAppName + ", position: " + i10);
        if (TextUtils.isEmpty(backupAppName)) {
            return;
        }
        ((C4023a) abstractC0833c0).f18511u.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(backupAppName));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new C4023a(LayoutInflater.from(this.f18509d).inflate(R$layout.backup_option_third_icon_list_item, viewGroup, false));
    }
}
