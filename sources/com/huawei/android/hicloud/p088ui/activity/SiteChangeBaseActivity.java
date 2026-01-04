package com.huawei.android.hicloud.p088ui.activity;

import android.content.Context;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0213f;
import tj.C13019a;

/* loaded from: classes3.dex */
public class SiteChangeBaseActivity extends UIActivity {

    /* renamed from: com.huawei.android.hicloud.ui.activity.SiteChangeBaseActivity$a */
    public class RunnableC3469a implements Runnable {
        public RunnableC3469a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SiteChangeBaseActivity.this.finish();
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a != null) {
                new HwAnimationReflection(contextM1377a).m15927c(2);
            }
        }
    }

    /* renamed from: L1 */
    public void m22157L1() {
        C13019a.m78347n().m78354q(this);
        new Handler().postDelayed(new RunnableC3469a(), 200L);
        C13019a.m78347n().m78355r();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        m22157L1();
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        m22157L1();
        return true;
    }
}
