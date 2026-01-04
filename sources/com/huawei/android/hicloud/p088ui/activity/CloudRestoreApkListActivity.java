package com.huawei.android.hicloud.p088ui.activity;

import com.huawei.android.hicloud.p088ui.uiadapter.CloudRestoreApkListAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.RestoreModuleListAdapter;

/* loaded from: classes3.dex */
public class CloudRestoreApkListActivity extends RestoreModuleListActivity {
    @Override // com.huawei.android.hicloud.p088ui.activity.RestoreModuleListActivity
    /* renamed from: O1 */
    public RestoreModuleListAdapter mo19768O1() {
        return new CloudRestoreApkListAdapter(this);
    }
}
