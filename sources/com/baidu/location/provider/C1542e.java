package com.baidu.location.provider;

import com.baidu.location.LocationClient;
import com.baidu.location.data.ScreenMan;
import com.baidu.location.p065a.C1534f;

/* renamed from: com.baidu.location.provider.e */
/* loaded from: classes.dex */
public class C1542e {

    /* renamed from: a */
    private boolean f6788a;

    /* renamed from: com.baidu.location.provider.e$a */
    public static class a {

        /* renamed from: a */
        private static C1542e f6789a = new C1542e();

        private a() {
        }
    }

    private C1542e() {
        this.f6788a = false;
    }

    /* renamed from: a */
    public static C1542e m8851a() {
        return a.f6789a;
    }

    /* renamed from: b */
    public void m8852b() {
        try {
            if (this.f6788a) {
                C1534f.m8725c("already inited");
                return;
            }
            C1534f.m8725c("init");
            Battery.m8741a().m8744a(LocationClient.mContext);
            C1539b.m8784a().m8794a(LocationClient.mContext);
            WifiMan.m8749a().m8755a(LocationClient.mContext);
            ScreenMan.m8733a().m8735a(LocationClient.mContext);
            C1541d.m8837a().m8846a(LocationClient.mContext);
            this.f6788a = true;
        } catch (Exception e10) {
            C1534f.m8725c("init exception" + e10.getMessage());
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public void m8853c() {
        try {
            if (!this.f6788a) {
                C1534f.m8725c("not inited");
                return;
            }
            C1534f.m8725c("uninit");
            Battery.m8741a().m8745b();
            C1539b.m8784a().m8796b();
            WifiMan.m8749a().m8758c();
            ScreenMan.m8733a().m8736b(LocationClient.mContext);
            C1541d.m8837a().m8849c();
            this.f6788a = false;
        } catch (Exception e10) {
            C1534f.m8725c("uninit exception" + e10.getMessage());
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
        }
    }
}
