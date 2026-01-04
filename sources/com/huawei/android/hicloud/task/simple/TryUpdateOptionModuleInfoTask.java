package com.huawei.android.hicloud.task.simple;

import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p581qk.AbstractC12367d;

/* loaded from: classes3.dex */
public class TryUpdateOptionModuleInfoTask extends AbstractC12367d {

    /* renamed from: a */
    public List<BackupOptionItem> f13127a;

    /* renamed from: b */
    public UpdateOptionInfoCallback f13128b;

    public interface UpdateOptionInfoCallback {
        /* renamed from: a */
        void mo18127a(List<BackupOptionItem> list);
    }

    public TryUpdateOptionModuleInfoTask(List<BackupOptionItem> list, UpdateOptionInfoCallback updateOptionInfoCallback) {
        this.f13127a = list;
        this.f13128b = updateOptionInfoCallback;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        UpdateOptionInfoCallback updateOptionInfoCallback;
        List<BackupOptionItem> list = this.f13127a;
        if (list == null || list.isEmpty() || (updateOptionInfoCallback = this.f13128b) == null) {
            return;
        }
        updateOptionInfoCallback.mo18127a(new ArrayList(this.f13127a));
    }
}
