package com.huawei.openalliance.p169ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gt.C10045a;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.tj */
/* loaded from: classes8.dex */
public class C7688tj {
    /* renamed from: a */
    public List<Intent> m47251a(String str) {
        return C10045a.m62451a(str);
    }

    /* renamed from: a */
    public void m47252a(Context context, Intent intent) {
        C10045a.m62452b(context, intent);
    }

    /* renamed from: a */
    public void m47253a(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.putExtra("ohos.extra.param.key.INSTALL_ON_DEMAND", true);
        C10045a.m62452b(context, intent);
    }
}
