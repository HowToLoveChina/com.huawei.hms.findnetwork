package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupManageThirdIconAdapter;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.AppDetailsInfo;
import java.util.List;
import p514o9.C11839m;
import p848zl.C14333b;

/* loaded from: classes3.dex */
public class ThirdIconAdapter extends BackupManageThirdIconAdapter {
    public ThirdIconAdapter(Context context) {
        super(context);
    }

    /* renamed from: D */
    public void m25306D(List<AppDetailsInfo> list) {
        if (list == null || list.size() <= 0) {
            this.f18510e.clear();
            m5213j();
        } else {
            this.f18510e.clear();
            this.f18510e.addAll(list);
            m5213j();
        }
    }

    /* renamed from: E */
    public int m25307E(String str) {
        for (int i10 = 0; i10 < this.f18510e.size(); i10++) {
            if (this.f18510e.get(i10).getBackupAppName().equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: F */
    public void m25308F(RecyclerView recyclerView, String str) {
        int iM25307E;
        BackupManageThirdIconAdapter.C4023a c4023a;
        if (TextUtils.isEmpty(str) || this.f18510e == null || recyclerView == null || (iM25307E = m25307E(str)) == -1) {
            return;
        }
        AppDetailsInfo appDetailsInfo = this.f18510e.get(iM25307E);
        View childAt = recyclerView.getChildAt(iM25307E);
        if (childAt == null || (c4023a = (BackupManageThirdIconAdapter.C4023a) recyclerView.getChildViewHolder(childAt)) == null) {
            return;
        }
        if (appDetailsInfo.isVirtualApp()) {
            c4023a.f18511u.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str, null));
        } else if (C14333b.m85483r().containsKey(str)) {
            c4023a.f18511u.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(str));
        } else {
            c4023a.f18511u.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(str));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.BackupManageThirdIconAdapter, androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        List<AppDetailsInfo> list = this.f18510e;
        if (list == null || i10 >= list.size() || this.f18510e.get(i10) == null) {
            return;
        }
        String backupAppName = this.f18510e.get(i10).getBackupAppName();
        C11839m.m70686d("ThirdIconAdapter", "appId: " + backupAppName + ", position: " + i10);
        if (TextUtils.isEmpty(backupAppName)) {
            return;
        }
        ((BackupManageThirdIconAdapter.C4023a) abstractC0833c0).f18511u.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(backupAppName));
    }
}
