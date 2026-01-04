package com.huawei.openalliance.p169ad.activity;

import android.R;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.huawei.appgallery.agd.api.PendingResult;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.InterfaceC6850a;
import com.huawei.openalliance.p169ad.InterfaceC7615qq;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.download.p172ag.C7036d;
import com.huawei.openalliance.p169ad.download.p172ag.C7038f;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class AgProtocolActivity extends AbstractActivityC6906f {

    /* renamed from: d */
    private static final List<String> f31627d;

    /* renamed from: a */
    String f31628a;

    /* renamed from: b */
    int f31629b;

    /* renamed from: c */
    String f31630c;

    /* renamed from: e */
    private final InterfaceC6850a f31631e = new BinderC6855a(this);

    /* renamed from: com.huawei.openalliance.ad.activity.AgProtocolActivity$a */
    public static class BinderC6855a extends InterfaceC6850a.a {

        /* renamed from: a */
        private WeakReference<AgProtocolActivity> f31633a;

        public BinderC6855a(AgProtocolActivity agProtocolActivity) {
            this.f31633a = new WeakReference<>(agProtocolActivity);
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC6850a
        /* renamed from: a */
        public void mo38572a(final int i10) {
            AbstractC7185ho.m43820b("resolution", "onActivityCancel requestCode=" + i10);
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.activity.AgProtocolActivity.a.1
                @Override // java.lang.Runnable
                public void run() throws JSONException {
                    AgProtocolActivity agProtocolActivity = BinderC6855a.this.f31633a == null ? null : (AgProtocolActivity) BinderC6855a.this.f31633a.get();
                    if (agProtocolActivity != null) {
                        agProtocolActivity.onActivityResult(i10, 0, null);
                    }
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f31627d = arrayList;
        arrayList.add(Constants.HW_INTELLIEGNT_PACKAGE);
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws JSONException {
        String str;
        String str2;
        int i12;
        super.onActivityResult(i10, i11, intent);
        AbstractC7185ho.m43820b("resolution", "requestCode=" + i10 + "resultCode=" + i11);
        if (100 != i10) {
            if (101 == i10) {
                str = this.f31628a;
                str2 = this.f31630c;
                i12 = 1003;
            } else if (102 == i10) {
                if (i11 == -1) {
                    AbstractC7185ho.m43820b("resolution", "install hiapp");
                    str = this.f31628a;
                    str2 = this.f31630c;
                    i12 = 1004;
                } else {
                    str = this.f31628a;
                    str2 = this.f31630c;
                    i12 = 1005;
                }
            }
            C7038f.m42202a(this, i12, str, str2, null);
        } else if (1001 == i11) {
            AbstractC7185ho.m43820b("resolution", "AG agree protocol");
            C7038f.m42202a(this, 1001, this.f31628a, this.f31630c, null);
        } else {
            AbstractC7185ho.m43820b("resolution", "AG disagree protocol");
            str = this.f31628a;
            str2 = this.f31630c;
            i12 = 1002;
            C7038f.m42202a(this, i12, str, str2, null);
        }
        finish();
    }

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            if (HiAd.getInstance(this).getCurActivity() != null) {
                AbstractC7185ho.m43820b("resolution", "current activity not null, inherit activity attributes.");
                AbstractC7811dd.m48291a(this, HiAd.getInstance(this).getCurActivity());
            } else {
                AbstractC7185ho.m43820b("resolution", "current activity is null, skip inherit activity attributes.");
            }
            AbstractC7811dd.m48295a(getWindow().getDecorView().findViewById(R.id.content), this);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("resolution", "adaptRingScreen err: %s", th2.getClass().getSimpleName());
        }
        super.onCreate(bundle);
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.activity.AgProtocolActivity.1
            @Override // java.lang.Runnable
            public void run() throws IntentSender.SendIntentException {
                Intent intent = AgProtocolActivity.this.getIntent();
                try {
                    PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pendingIntent");
                    AgProtocolActivity.this.f31629b = intent.getIntExtra("pendingIntent.type", 6);
                    AgProtocolActivity.this.f31628a = intent.getStringExtra("task.pkg");
                    AgProtocolActivity.this.f31630c = intent.getStringExtra(MapKeyNames.AG_ACTION_NAME);
                    AgProtocolActivity.this.m38593b();
                    int i10 = AgProtocolActivity.this.f31629b;
                    int i11 = i10 == 6 ? 101 : i10 == 8888 ? 102 : 100;
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putBinder(PendingResult.RESOLUTION_EXTRA_BUNDLE_BINDER, AgProtocolActivity.this.f31631e.asBinder());
                    bundle2.putInt(PendingResult.RESOLUTION_EXTRA_BUNDLE_REQUESTCODE, i11);
                    intent2.putExtra(PendingResult.RESOLUTION_EXTRA_BUNDLE, bundle2);
                    if (AgProtocolActivity.f31627d.contains(AgProtocolActivity.this.getPackageName())) {
                        intent2.putExtra(PendingResult.RESOLUTION_EXTRA_AUTOFINISH, 1);
                    }
                    AbstractC7185ho.m43820b("resolution", "resolution type=" + AgProtocolActivity.this.f31629b);
                    AgProtocolActivity.this.startIntentSenderForResult(pendingIntent.getIntentSender(), i11, intent2, 0, 0, 0);
                } catch (Exception e10) {
                    AbstractC7185ho.m43820b("resolution", " startIntentSenderForResult error:e=" + e10.getClass().getName());
                    AgProtocolActivity.this.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m38593b() {
        InterfaceC7615qq interfaceC7615qqM42223C;
        Context applicationContext = getApplicationContext();
        AppDownloadTask appDownloadTaskMo42105a = C7036d.m42166a(applicationContext).mo42105a(this.f31628a);
        new C6922c(applicationContext).m39100a(this.f31628a, (appDownloadTaskMo42105a == null || (interfaceC7615qqM42223C = appDownloadTaskMo42105a.m42223C()) == null) ? null : interfaceC7615qqM42223C.mo46574a(), this.f31629b, this.f31630c, "openAgProtocolActivity");
    }
}
