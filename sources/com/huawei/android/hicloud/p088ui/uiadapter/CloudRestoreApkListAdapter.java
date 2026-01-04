package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import com.huawei.android.hicloud.p088ui.uiadapter.RestoreModuleListAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;

/* loaded from: classes3.dex */
public class CloudRestoreApkListAdapter extends RestoreModuleListAdapter {
    public CloudRestoreApkListAdapter(Context context) {
        super(context);
    }

    /* renamed from: J */
    public void m24914J(RestoreModuleListAdapter.C4065a c4065a, RestoreStatus restoreStatus) {
        mo24917x(c4065a, restoreStatus);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.RestoreModuleListAdapter
    /* renamed from: s */
    public void mo24915s(RestoreModuleListAdapter.C4065a c4065a, RestoreStatus restoreStatus) {
        if (7 == restoreStatus.getStatus()) {
            m24914J(c4065a, restoreStatus);
        } else {
            super.mo24915s(c4065a, restoreStatus);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.RestoreModuleListAdapter
    /* renamed from: u */
    public void mo24916u(RestoreModuleListAdapter.C4065a c4065a, RestoreStatus restoreStatus) {
        if (restoreStatus.getDoneStatus() == 1) {
            m24914J(c4065a, restoreStatus);
        } else {
            super.mo24916u(c4065a, restoreStatus);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.RestoreModuleListAdapter
    /* renamed from: x */
    public void mo24917x(RestoreModuleListAdapter.C4065a c4065a, RestoreStatus restoreStatus) {
        c4065a.f18844e.setText(this.f18835a.getString(R$string.restore_new_completed));
        c4065a.f18851l.setVisibility(0);
        c4065a.f18844e.setTextColor(this.f18836b.getColor(R$color.emui_color_gray_7));
        m25178G(c4065a);
        c4065a.f18849j.setVisibility(8);
        c4065a.f18845f.setVisibility(8);
    }
}
