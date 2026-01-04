package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.hicloud.notification.p106db.bean.UrgencyOnTopParams;

/* loaded from: classes3.dex */
public class UrgencyScrollUpView extends ScrollUpUrgencyView<UrgencyOnTopParams> {
    public UrgencyScrollUpView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.ScrollUpUrgencyView
    public int getUrgencyViewHeight() {
        return 40;
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.AutoScrollUrgencyData
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public String mo23935a(UrgencyOnTopParams urgencyOnTopParams) {
        if (urgencyOnTopParams != null) {
            return urgencyOnTopParams.getUrgencyContent();
        }
        return null;
    }

    public UrgencyScrollUpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UrgencyScrollUpView(Context context) {
        super(context);
    }
}
