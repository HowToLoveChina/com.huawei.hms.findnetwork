package com.huawei.android.hicloud.task.simple;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import p015ak.C0209d;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: com.huawei.android.hicloud.task.simple.o1 */
/* loaded from: classes3.dex */
public class C3067o1 extends AbstractC12367d {

    /* renamed from: a */
    public int f13345a;

    /* renamed from: b */
    public boolean f13346b;

    /* renamed from: c */
    public int f13347c;

    /* renamed from: d */
    public Context f13348d;

    /* renamed from: e */
    public boolean f13349e;

    /* renamed from: f */
    public boolean f13350f;

    /* renamed from: g */
    public int f13351g;

    public C3067o1(Context context, int i10, boolean z10, int i11, boolean z11, boolean z12, int i12) {
        this.f13348d = context;
        this.f13345a = i10;
        this.f13346b = z10;
        this.f13347c = i11;
        this.f13349e = z11;
        this.f13350f = z12;
        this.f13351g = i12;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        C11839m.m70688i("NotifyFileManagerConfigTask", "call");
        ContentProviderClient contentProviderClient = null;
        try {
            try {
                Context context = this.f13348d;
                if (context == null) {
                    C11839m.m70687e("NotifyFileManagerConfigTask", "NotifyFileManagerConfigTask context null");
                    return;
                }
                if (!C0209d.m1227Y1(context, Uri.parse("content://com.huawei.filemanager.accountexit"))) {
                    C11839m.m70687e("NotifyFileManagerConfigTask", "is not Target App or System App");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("configStatus", this.f13345a);
                bundle.putBoolean("isDbankEnable", this.f13346b);
                bundle.putInt("encryptStatus", this.f13347c);
                bundle.putBoolean("isAllModuleDisabled", this.f13349e);
                bundle.putBoolean("key_param_header", this.f13350f);
                bundle.putInt("dbankEnableStatus", this.f13351g);
                ContentResolver contentResolver = this.f13348d.getContentResolver();
                if (contentResolver == null) {
                    C11839m.m70688i("NotifyFileManagerConfigTask", "notify fa contentResolver is null.");
                    return;
                }
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(Uri.parse("content://com.huawei.filemanager.accountexit"));
                try {
                    if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                        C11839m.m70688i("NotifyFileManagerConfigTask", "notify fa client is null.");
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                            return;
                        }
                        return;
                    }
                    Bundle bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("hicloud_query_config_finish", null, bundle);
                    if (bundleCall != null) {
                        C11839m.m70688i("NotifyFileManagerConfigTask", "NotifyFileManagerConfigTask: " + bundleCall.getBoolean("isSaveConfigFinish"));
                    }
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                } catch (Exception e10) {
                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                    e = e10;
                    C11839m.m70687e("NotifyFileManagerConfigTask", "NotifyFileManagerConfigTask task exception:" + e.toString());
                    if (contentProviderClient != null) {
                        contentProviderClient.close();
                    }
                } catch (Throwable th2) {
                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                    th = th2;
                    if (contentProviderClient != null) {
                        contentProviderClient.close();
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.NOTIFY_FILEMANAGER_CONFIG;
    }
}
