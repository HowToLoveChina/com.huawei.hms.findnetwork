package com.huawei.android.hicloud.cloudbackup.process.clone;

import android.text.TextUtils;
import com.huawei.android.backup.service.utils.BackupConstant;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import p514o9.C11839m;
import p848zl.C14333b;

/* loaded from: classes2.dex */
public class DefaultLiveKeeper extends BaseLiveKeeper implements ILiveKeeper {
    private static final Set<String> MODULE_NAMES = new HashSet(C14333b.m85477l());
    private static final String TAG = "DefaultLiveKeeper";

    public DefaultLiveKeeper(long j10) {
        super(j10);
    }

    private void keepOrReleaseModule(String str, Consumer<String> consumer) {
        String str2 = BackupConstant.m13146t().get(str);
        if (!TextUtils.isEmpty(str2)) {
            consumer.accept(str2);
            return;
        }
        C11839m.m70688i(TAG, "packageName is empty moduleName: " + str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.clone.ILiveKeeper
    public boolean isMatched(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return MODULE_NAMES.contains(str);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.clone.ILiveKeeper
    public void keepAlive(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        keepOrReleaseModule(str, new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.clone.f
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f11691a.applyForResourceUse((String) obj);
            }
        });
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.clone.ILiveKeeper
    public void keepAllAlive() {
        C11839m.m70688i(TAG, "keepAllAlive");
        Iterator<String> it = MODULE_NAMES.iterator();
        while (it.hasNext()) {
            keepAlive(it.next());
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.clone.ILiveKeeper
    public void release(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        keepOrReleaseModule(str, new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.process.clone.g
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f11692a.unApplyForResourceUse((String) obj);
            }
        });
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.clone.ILiveKeeper
    public void releaseAll() {
        C11839m.m70688i(TAG, "releaseAll");
        Iterator<String> it = MODULE_NAMES.iterator();
        while (it.hasNext()) {
            release(it.next());
        }
    }
}
