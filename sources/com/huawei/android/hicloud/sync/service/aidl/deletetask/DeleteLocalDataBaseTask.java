package com.huawei.android.hicloud.sync.service.aidl.deletetask;

import android.content.Context;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p609rc.C12487a;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes3.dex */
public abstract class DeleteLocalDataBaseTask extends AbstractC12367d {
    private static final String TAG = "DeleteLocalDataBaseTask";
    private String bussinessId;
    protected Context mContext;
    protected int mOption;

    public DeleteLocalDataBaseTask(Context context, int i10, String str) {
        this.mContext = context;
        this.mOption = i10;
        this.bussinessId = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            if (this.mContext == null) {
                C11839m.m70689w(TAG, "doInBackground: mContext is null");
                this.mContext = C0213f.m1377a();
            }
            C12487a.m74966b(this.mContext);
            deleteSyncData(this.bussinessId);
            deleteTag();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "doInBackground: " + e10.toString());
        }
    }

    public abstract void deleteSyncData(String str);

    public abstract void deleteTag();

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_FIX;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }
}
