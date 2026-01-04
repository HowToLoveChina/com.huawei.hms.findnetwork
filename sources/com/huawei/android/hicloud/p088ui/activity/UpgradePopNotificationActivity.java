package com.huawei.android.hicloud.p088ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ForcedUpgradeDialog;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.p106db.bean.UpgradeJumpObject;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0234s;
import p514o9.C11839m;
import sk.C12808e;

/* loaded from: classes3.dex */
public class UpgradePopNotificationActivity extends Activity {

    /* renamed from: a */
    public String f16312a = "";

    /* renamed from: b */
    public String f16313b = "";

    /* renamed from: c */
    public String f16314c = "";

    /* renamed from: d */
    public String f16315d = "";

    /* renamed from: e */
    public UpgradeJumpObject f16316e = null;

    /* renamed from: f */
    public ForcedUpgradeDialog f16317f;

    /* renamed from: a */
    public final void m22542a() {
        if (this.f16317f == null) {
            this.f16317f = new ForcedUpgradeDialog(this);
        }
        if (!TextUtils.isEmpty(this.f16312a) && !TextUtils.isEmpty(this.f16313b) && !TextUtils.isEmpty(this.f16314c) && !TextUtils.isEmpty(this.f16315d) && this.f16316e != null) {
            this.f16317f.showDialog(this.f16312a, this.f16313b, this.f16314c, this.f16315d);
        } else {
            C11839m.m70687e(NotifyConstants.ActivityName.UPGRADE_POP_NOTIFICATION_ACTIVITY, "show popupNotification text is null");
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent;
        C11839m.m70688i(NotifyConstants.ActivityName.UPGRADE_POP_NOTIFICATION_ACTIVITY, "onCreate");
        super.onCreate(bundle);
        C12808e.m76822a(this);
        try {
            intent = getIntent();
        } catch (Exception unused) {
            C11839m.m70687e(NotifyConstants.ActivityName.UPGRADE_POP_NOTIFICATION_ACTIVITY, "getIntent error");
        }
        if (intent == null) {
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        this.f16312a = safeIntent.getStringExtra("upgrade_notify_title_key");
        this.f16313b = safeIntent.getStringExtra("upgrade_notify_maintext_key");
        this.f16314c = safeIntent.getStringExtra("upgrade_notify_button_first_key");
        this.f16315d = safeIntent.getStringExtra("upgrade_notify_button_second_key");
        this.f16316e = (UpgradeJumpObject) safeIntent.getSerializableExtra("upgrade_notify_jump_key");
        m22542a();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        C11839m.m70688i(NotifyConstants.ActivityName.UPGRADE_POP_NOTIFICATION_ACTIVITY, "onDestroy");
        super.onDestroy();
        ForcedUpgradeDialog forcedUpgradeDialog = this.f16317f;
        if (forcedUpgradeDialog != null) {
            forcedUpgradeDialog.cancel();
        }
    }
}
