package com.huawei.android.hicloud.common.sns;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import com.huawei.hms.support.api.entity.sns.json.SnsOutIntent;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.ref.WeakReference;
import p208cq.InterfaceC8939g;
import p514o9.C11839m;

/* loaded from: classes3.dex */
class HmsSnsHelper$GetUiIntentSuccessListener implements InterfaceC8939g<SnsOutIntent> {

    /* renamed from: a */
    public WeakReference<Context> f11991a;

    public HmsSnsHelper$GetUiIntentSuccessListener(Context context) {
        this.f11991a = new WeakReference<>(context);
    }

    @Override // p208cq.InterfaceC8939g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(SnsOutIntent snsOutIntent) {
        SafeIntent safeIntent = new SafeIntent(snsOutIntent.getIntent());
        WeakReference<Context> weakReference = this.f11991a;
        if (weakReference == null) {
            C11839m.m70687e("HmsSnsHelper", "GetUiIntentSuccessListener contextWeakReference is null.");
            return;
        }
        Context context = weakReference.get();
        if (context == null) {
            C11839m.m70687e("HmsSnsHelper", "GetUiIntentSuccessListener context is null.");
            return;
        }
        try {
            ((Activity) context).startActivityForResult(safeIntent, 1006);
        } catch (ActivityNotFoundException e10) {
            C11839m.m70687e("HmsSnsHelper", "GetUiIntentSuccessListener ActivityNotFoundException: " + e10.getMessage());
        }
    }
}
