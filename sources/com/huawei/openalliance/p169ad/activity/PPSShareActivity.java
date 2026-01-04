package com.huawei.openalliance.p169ad.activity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7698tt;
import com.huawei.openalliance.p169ad.C7706ua;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;

/* loaded from: classes8.dex */
public class PPSShareActivity extends AbstractActivityC6905e {

    /* renamed from: b */
    private C7698tt f31772b;

    /* renamed from: a */
    private boolean f31771a = true;

    /* renamed from: c */
    private final DialogInterface.OnDismissListener f31773c = new DialogInterface.OnDismissListener() { // from class: com.huawei.openalliance.ad.activity.PPSShareActivity.1
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PPSShareActivity.this.finish();
        }
    };

    /* renamed from: b */
    private C7706ua m38755b() {
        SafeIntent safeIntent = (SafeIntent) getIntent();
        try {
            C7706ua c7706ua = new C7706ua(safeIntent.getStringExtra("title"), safeIntent.getStringExtra("description"), safeIntent.getStringExtra("imageUrl"), safeIntent.getStringExtra(JsbMapKeyNames.H5_CSHARE_URL));
            c7706ua.m47342a(getPackageManager().getApplicationInfo(getPackageName(), 0).icon);
            c7706ua.m47343a((ContentRecord) AbstractC7758be.m47739b(safeIntent.getStringExtra(MapKeyNames.CONTENT_RECORD), ContentRecord.class, new Class[0]));
            return c7706ua;
        } catch (RuntimeException e10) {
            AbstractC7185ho.m43824c("PPSShareActivity", "getIntentParams runtime exception: %s", e10.getClass().getSimpleName());
            return null;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSShareActivity", "getIntentParams error: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        setContentView(C6849R.layout.hiad_activity_share);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C7698tt c7698tt = this.f31772b;
        if (c7698tt != null) {
            c7698tt.m47326b();
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        AbstractC7185ho.m43820b("PPSShareActivity", "onCreate");
        super.onCreate(bundle);
        C7706ua c7706uaM38755b = m38755b();
        if (c7706uaM38755b == null) {
            finish();
            return;
        }
        C7698tt c7698tt = new C7698tt(this, c7706uaM38755b);
        this.f31772b = c7698tt;
        c7698tt.m47324a();
        this.f31772b.m47325a(this.f31773c);
        new C6922c(getApplicationContext()).m39099a("shareClick", c7706uaM38755b.m47349f());
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C7698tt c7698tt = this.f31772b;
        if (c7698tt != null) {
            c7698tt.m47326b();
        }
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onResume() {
        super.onResume();
        AbstractC7185ho.m43820b("PPSShareActivity", "onResume");
        if (this.f31771a) {
            this.f31771a = false;
            return;
        }
        C7698tt c7698tt = this.f31772b;
        if (c7698tt != null) {
            c7698tt.m47326b();
        }
    }
}
