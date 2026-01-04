package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import java.net.URISyntaxException;

/* renamed from: com.huawei.hms.push.p */
/* loaded from: classes8.dex */
public class C6297p extends Thread {

    /* renamed from: a */
    private Context f29710a;

    /* renamed from: b */
    private C6296o f29711b;

    public C6297p(Context context, C6296o c6296o) {
        this.f29710a = context;
        this.f29711b = c6296o;
    }

    /* renamed from: a */
    private static Intent m36590a(Context context, C6296o c6296o) throws URISyntaxException {
        if (c6296o == null) {
            return null;
        }
        Intent intentM36520b = C6286e.m36520b(context, c6296o.m36569c());
        if (c6296o.m36579m() == null) {
            if (c6296o.m36566a() != null) {
                Intent intent = new Intent(c6296o.m36566a());
                if (C6286e.m36517a(context, c6296o.m36569c(), intent).booleanValue()) {
                    intentM36520b = intent;
                }
            }
            intentM36520b.setPackage(c6296o.m36569c());
            return intentM36520b;
        }
        try {
            Intent uri = Intent.parseUri(c6296o.m36579m(), 0);
            uri.setSelector(null);
            if (uri.getClipData() == null) {
                uri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
            }
            HMSLog.m36983d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + uri.getAction());
            return C6286e.m36517a(context, c6296o.m36569c(), uri).booleanValue() ? uri : intentM36520b;
        } catch (Exception e10) {
            HMSLog.m36989w("PushSelfShowLog", "intentUri error," + e10.toString());
            return intentM36520b;
        }
    }

    /* renamed from: b */
    private boolean m36592b(Context context) {
        if ("cosa".equals(this.f29711b.m36574h())) {
            return m36591a(context);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.m36988i("PushSelfShowLog", "enter run()");
        try {
            if (!m36592b(this.f29710a) || m36593b(this.f29710a, this.f29711b)) {
                return;
            }
            C6295n.m36541a(this.f29710a, this.f29711b);
        } catch (Exception e10) {
            HMSLog.m36986e("PushSelfShowLog", e10.toString());
        }
    }

    /* renamed from: b */
    private boolean m36593b(Context context, C6296o c6296o) {
        if (!"cosa".equals(c6296o.m36574h()) || m36590a(context, c6296o) != null) {
            return false;
        }
        HMSLog.m36983d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    /* renamed from: a */
    private boolean m36591a(Context context) {
        return C6286e.m36523c(context, this.f29711b.m36569c());
    }
}
