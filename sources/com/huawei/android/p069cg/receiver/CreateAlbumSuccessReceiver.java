package com.huawei.android.p069cg.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import p031b7.C1120a;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class CreateAlbumSuccessReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public Activity f11048a;

    public CreateAlbumSuccessReceiver(Activity activity) {
        this.f11048a = activity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Activity activity;
        C11839m.m70688i("CreateAlbumSuccessReceiver", "CreateAlbumSuccessReceiver");
        if (intent == null || context == null) {
            C1120a.m6677i("CreateAlbumSuccessReceiver", "CreateAlbumSuccessReceiver intent is null");
            return;
        }
        String action = new HiCloudSafeIntent(intent).getAction();
        C1120a.m6675d("CreateAlbumSuccessReceiver", "CreateAlbumSuccessReceiver  action " + action);
        if (!"com.huawei.hicloud.intent.action.create.album.success".equals(action) || (activity = this.f11048a) == null || activity.isFinishing()) {
            return;
        }
        this.f11048a.finish();
        C1120a.m6677i("CreateAlbumSuccessReceiver", "CreateAlbumSuccessReceiver  finish activity success.");
    }
}
