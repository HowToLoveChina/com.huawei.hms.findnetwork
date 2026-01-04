package com.huawei.openalliance.p169ad.activity;

import android.view.MenuItem;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8124q;

/* loaded from: classes8.dex */
public class OpenPrivacyPerActivity extends AbstractActivityC6903c {

    /* renamed from: a */
    private InterfaceC8124q f31676a;

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        AbstractC7185ho.m43820b("PriPerActivity", "initLayout");
        setContentView(C6849R.layout.pure_web_activity_layout);
        String stringExtra = new SafeIntent(getIntent()).getStringExtra("url");
        this.f31676a = (InterfaceC8124q) findViewById(C6849R.id.webview);
        if (AbstractC7806cz.m48165b(stringExtra)) {
            AbstractC7185ho.m43826d("PriPerActivity", "param err");
        } else {
            this.f31676a.mo50323a(stringExtra);
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        InterfaceC8124q interfaceC8124q = this.f31676a;
        if (interfaceC8124q != null) {
            interfaceC8124q.mo50324d();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return false;
    }
}
