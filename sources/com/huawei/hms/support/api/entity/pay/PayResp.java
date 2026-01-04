package com.huawei.hms.support.api.entity.pay;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.security.SecureRandom;

/* loaded from: classes8.dex */
public class PayResp extends AbstractMessageEntity {

    @Packed
    public Intent intent;

    @Packed
    public PendingIntent pendingIntent;

    @Packed
    public int retCode;

    public PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public void setPendingIntent(Context context, Intent intent) {
        this.pendingIntent = PendingIntent.getActivity(context, new SecureRandom().nextInt(), intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }
}
