package com.huawei.openalliance.p169ad.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.download.app.AlertDialogC7042a;
import com.huawei.openalliance.p169ad.download.app.C7046e;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8114g;

/* loaded from: classes8.dex */
public class PPSInstallAuthorActivity extends AbstractActivityC6905e {

    /* renamed from: a */
    private static InterfaceC8114g f31741a;

    /* renamed from: b */
    private static int f31742b;

    /* renamed from: c */
    public static /* synthetic */ int m38728c() {
        int i10 = f31742b;
        f31742b = i10 - 1;
        return i10;
    }

    /* renamed from: e */
    private static void m38730e() {
        f31741a = null;
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        AbstractC7185ho.m43820b("PPSInstallAuthorActivity", "onCreate");
        m38725a(getIntent());
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onDestroy() {
        m38730e();
        super.onDestroy();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onNewIntent(Intent intent) throws Resources.NotFoundException {
        AbstractC7185ho.m43820b("PPSInstallAuthorActivity", "onNewIntent");
        super.onNewIntent(intent);
        m38725a(intent);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e
    /* renamed from: a */
    public void mo38587a() {
        setContentView(C6849R.layout.hiad_activity_install_author);
    }

    /* renamed from: a */
    private void m38725a(Intent intent) throws Resources.NotFoundException {
        final ContentRecord contentRecord = (ContentRecord) AbstractC7758be.m47739b(new SafeIntent(intent).getStringExtra(Constants.CONTENT_KEY), ContentRecord.class, new Class[0]);
        if (contentRecord == null) {
            AbstractC7185ho.m43823c("PPSInstallAuthorActivity", "init failed! contentRecord is null");
            finish();
            return;
        }
        f31742b++;
        AbstractC7185ho.m43817a("PPSInstallAuthorActivity", "showDialogCnt is:" + f31742b);
        AbstractC7846y.m48619a(this, contentRecord, new AlertDialogC7042a.a() { // from class: com.huawei.openalliance.ad.activity.PPSInstallAuthorActivity.1
            @Override // com.huawei.openalliance.p169ad.download.app.AlertDialogC7042a.a
            /* renamed from: a */
            public void mo38731a() {
                AbstractC7185ho.m43820b("PPSInstallAuthorActivity", "continue install");
                if (PPSInstallAuthorActivity.f31741a != null) {
                    PPSInstallAuthorActivity.f31741a.mo42335a(C7046e.m42377h().mo42385a(contentRecord.m41484af().getPackageName()));
                }
            }

            @Override // com.huawei.openalliance.p169ad.download.app.AlertDialogC7042a.a
            /* renamed from: b */
            public void mo38732b() {
                PPSInstallAuthorActivity.m38728c();
                if (PPSInstallAuthorActivity.f31742b <= 0) {
                    int unused = PPSInstallAuthorActivity.f31742b = 0;
                    AbstractC7185ho.m43817a("PPSInstallAuthorActivity", "close activity");
                    PPSInstallAuthorActivity.this.finish();
                }
            }
        });
    }

    /* renamed from: a */
    public static void m38726a(InterfaceC8114g interfaceC8114g) {
        if (interfaceC8114g == null) {
            AbstractC7185ho.m43823c("PPSInstallAuthorActivity", "registerInstallListener is null");
        } else {
            f31741a = interfaceC8114g;
        }
    }
}
