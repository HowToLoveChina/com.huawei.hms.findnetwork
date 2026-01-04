package com.huawei.android.hicloud.p088ui;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0234s;
import p514o9.C11839m;
import p572qb.C12314i0;
import p737wd.ViewOnClickListenerC13593f;
import sk.C12808e;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class StockActivePopupGuideActivity extends Activity {

    /* renamed from: a */
    public ViewOnClickListenerC13593f f13429a;

    /* renamed from: a */
    public final void m18482a() {
        if (this.f13429a == null) {
            this.f13429a = new ViewOnClickListenerC13593f(this);
        }
        this.f13429a.setCancelable(false);
        this.f13429a.show();
        C12314i0.m74036h().m74056v(this);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i(NotifyConstants.ActivityName.STOCK_ACTIVE_POPUP_GUIDE_ACTIVITY, "onCreate");
        super.onCreate(bundle);
        C12808e.m76822a(this);
        m18482a();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        C11839m.m70688i(NotifyConstants.ActivityName.STOCK_ACTIVE_POPUP_GUIDE_ACTIVITY, "onDestroy");
        super.onDestroy();
        ViewOnClickListenerC13593f viewOnClickListenerC13593f = this.f13429a;
        if (viewOnClickListenerC13593f != null) {
            viewOnClickListenerC13593f.cancel();
        }
    }
}
