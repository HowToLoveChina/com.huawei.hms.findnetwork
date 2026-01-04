package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class InnerBinderAdapter extends BinderAdapter {

    /* renamed from: j */
    private static final Object f23114j = new Object();

    /* renamed from: k */
    private static BinderAdapter f23115k;

    private InnerBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.m36988i("InnerBinderAdapter", "InnerBinderAdapter getInstance.");
        synchronized (f23114j) {
            try {
                if (f23115k == null) {
                    f23115k = new InnerBinderAdapter(context, str, str2);
                }
                binderAdapter = f23115k;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getConnTimeOut() {
        return 2001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getMsgDelayDisconnect() {
        return 2002;
    }
}
