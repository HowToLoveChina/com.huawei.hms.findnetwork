package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.net.URISyntaxException;

/* renamed from: com.huawei.hms.push.u */
/* loaded from: classes8.dex */
public class C6302u {

    /* renamed from: c */
    private static final String[] f29725c = {"url", "app", "cosa", "rp"};

    /* renamed from: a */
    private Context f29726a;

    /* renamed from: b */
    private C6296o f29727b;

    public C6302u(Context context, C6296o c6296o) {
        this.f29726a = context;
        this.f29727b = c6296o;
    }

    /* renamed from: a */
    public static boolean m36609a(String str) {
        for (String str2 : f29725c) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m36610b() throws URISyntaxException {
        Intent uri;
        HMSLog.m36988i("PushSelfShowLog", "run into launchCosaApp");
        try {
            HMSLog.m36988i("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.f29727b.m36569c() + ",and msg.intentUri is " + this.f29727b.m36579m());
            Intent intentM36520b = C6286e.m36520b(this.f29726a, this.f29727b.m36569c());
            boolean zBooleanValue = false;
            if (this.f29727b.m36579m() != null) {
                try {
                    uri = Intent.parseUri(this.f29727b.m36579m(), 0);
                    uri.setSelector(null);
                    if (uri.getClipData() == null) {
                        uri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
                    }
                    HMSLog.m36988i("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + uri.getAction());
                    zBooleanValue = C6286e.m36517a(this.f29726a, this.f29727b.m36569c(), uri).booleanValue();
                    if (zBooleanValue) {
                        intentM36520b = uri;
                    }
                } catch (Exception e10) {
                    HMSLog.m36989w("PushSelfShowLog", "intentUri error." + e10.toString());
                }
            } else if (this.f29727b.m36566a() != null) {
                uri = new Intent(this.f29727b.m36566a());
                if (C6286e.m36517a(this.f29726a, this.f29727b.m36569c(), uri).booleanValue()) {
                    intentM36520b = uri;
                }
            }
            if (intentM36520b == null) {
                HMSLog.m36988i("PushSelfShowLog", "launchCosaApp,intent == null");
                return;
            }
            intentM36520b.setPackage(this.f29727b.m36569c());
            if (zBooleanValue) {
                intentM36520b.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            } else {
                intentM36520b.setFlags(805437440);
            }
            this.f29726a.startActivity(intentM36520b);
        } catch (Exception e11) {
            HMSLog.m36986e("PushSelfShowLog", "launch Cosa App exception." + e11.toString());
        }
    }

    /* renamed from: c */
    public void m36611c() throws URISyntaxException {
        C6296o c6296o;
        HMSLog.m36983d("PushSelfShowLog", "enter launchNotify()");
        if (this.f29726a == null || (c6296o = this.f29727b) == null) {
            HMSLog.m36983d("PushSelfShowLog", "launchNotify  context or msg is null");
            return;
        }
        if ("app".equals(c6296o.m36574h())) {
            m36608a();
            return;
        }
        if ("cosa".equals(this.f29727b.m36574h())) {
            m36610b();
            return;
        }
        if ("rp".equals(this.f29727b.m36574h())) {
            HMSLog.m36989w("PushSelfShowLog", this.f29727b.m36574h() + " not support rich message.");
            return;
        }
        if ("url".equals(this.f29727b.m36574h())) {
            HMSLog.m36989w("PushSelfShowLog", this.f29727b.m36574h() + " not support URL.");
            return;
        }
        HMSLog.m36983d("PushSelfShowLog", this.f29727b.m36574h() + " is not exist in hShowType");
    }

    /* renamed from: a */
    private void m36608a() {
        try {
            HMSLog.m36988i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.f29727b.m36569c());
            if (C6286e.m36523c(this.f29726a, this.f29727b.m36569c())) {
                m36610b();
            }
        } catch (Exception e10) {
            HMSLog.m36986e("PushSelfShowLog", "launchApp error:" + e10.toString());
        }
    }
}
