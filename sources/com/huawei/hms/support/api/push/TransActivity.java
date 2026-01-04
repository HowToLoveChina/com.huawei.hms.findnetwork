package com.huawei.hms.support.api.push;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.android.hms.push.R$layout;
import com.huawei.hms.push.C6301t;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* loaded from: classes8.dex */
public class TransActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.hwpush_trans_activity);
        getWindow().addFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
        C6301t.m36601a(this, getIntent());
        finish();
    }
}
