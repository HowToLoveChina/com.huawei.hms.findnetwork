package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class OuterBinderAdapter extends BinderAdapter {

    /* renamed from: j */
    private static final Object f23116j = new Object();

    /* renamed from: k */
    private static BinderAdapter f23117k;

    /* renamed from: l */
    private static String f23118l;

    /* renamed from: m */
    private static String f23119m;

    private OuterBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.m36988i("OuterBinderAdapter", "OuterBinderAdapter getInstance.");
        synchronized (f23116j) {
            try {
                if (f23117k == null) {
                    f23118l = str;
                    f23119m = str2;
                    f23117k = new OuterBinderAdapter(context, str, str2);
                } else if (!Objects.equal(f23118l, str) || !Objects.equal(f23119m, str2)) {
                    HMSLog.m36988i("OuterBinderAdapter", "OuterBinderAdapter getInstance refresh adapter");
                    f23118l = str;
                    f23119m = str2;
                    f23117k.unBind();
                    f23117k = new OuterBinderAdapter(context, str, str2);
                }
                binderAdapter = f23117k;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getConnTimeOut() {
        return 1001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getMsgDelayDisconnect() {
        return 1002;
    }
}
