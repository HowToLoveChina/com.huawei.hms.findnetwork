package com.huawei.openalliance.p169ad;

import android.content.ComponentName;
import android.content.Intent;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;

/* renamed from: com.huawei.openalliance.ad.tn */
/* loaded from: classes8.dex */
public class C7692tn {

    /* renamed from: a */
    private String f35706a;

    /* renamed from: b */
    private String f35707b;

    /* renamed from: c */
    private String f35708c;

    /* renamed from: d */
    private String f35709d;

    /* renamed from: e */
    private int f35710e;

    /* renamed from: com.huawei.openalliance.ad.tn$a */
    public static class a {

        /* renamed from: a */
        private String f35711a;

        /* renamed from: b */
        private String f35712b;

        /* renamed from: c */
        private String f35713c;

        /* renamed from: d */
        private String f35714d;

        /* renamed from: e */
        private int f35715e;

        /* renamed from: a */
        public a m47271a(int i10) {
            this.f35715e = i10;
            return this;
        }

        /* renamed from: b */
        public a m47278b(String str) {
            this.f35712b = str;
            return this;
        }

        /* renamed from: c */
        public a m47279c(String str) {
            this.f35713c = str;
            return this;
        }

        /* renamed from: a */
        public a m47272a(Intent intent) {
            if (intent == null) {
                return this;
            }
            if (AbstractC7806cz.m48165b(this.f35713c)) {
                this.f35713c = intent.getPackage();
            }
            ComponentName component = intent.getComponent();
            if (component != null && AbstractC7806cz.m48165b(this.f35714d)) {
                this.f35714d = component.getClassName();
            }
            return this;
        }

        /* renamed from: a */
        public a m47273a(ApkInfo apkInfo) {
            if (apkInfo == null) {
                return this;
            }
            String strM39626a = apkInfo.m39626a();
            String strM39616Q = apkInfo.m39616Q();
            if (!AbstractC7806cz.m48165b(strM39626a)) {
                this.f35713c = strM39626a;
            }
            if (!AbstractC7806cz.m48165b(strM39616Q)) {
                this.f35714d = strM39616Q;
            }
            return this;
        }

        /* renamed from: a */
        public a m47274a(ContentRecord contentRecord) {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("RedirectionMatchParam.Builder", "send param by content record,record is null.");
                return this;
            }
            this.f35711a = contentRecord.m41588n();
            this.f35712b = contentRecord.m41591o();
            this.f35715e = contentRecord.m41552f();
            return this;
        }

        /* renamed from: a */
        public a m47275a(AppInfo appInfo) {
            if (appInfo == null) {
                return this;
            }
            String packageName = appInfo.getPackageName();
            String strM44340A = appInfo.m44340A();
            if (!AbstractC7806cz.m48165b(packageName)) {
                this.f35713c = packageName;
            }
            if (!AbstractC7806cz.m48165b(strM44340A)) {
                this.f35714d = strM44340A;
            }
            return this;
        }

        /* renamed from: a */
        public a m47276a(String str) {
            this.f35711a = str;
            return this;
        }

        /* renamed from: a */
        public C7692tn m47277a() {
            return new C7692tn(this);
        }
    }

    public C7692tn(a aVar) {
        this.f35708c = aVar.f35713c;
        this.f35709d = aVar.f35714d;
        this.f35706a = aVar.f35711a;
        this.f35707b = aVar.f35712b;
        this.f35710e = aVar.f35715e;
    }

    /* renamed from: a */
    public int m47258a() {
        return this.f35710e;
    }

    /* renamed from: b */
    public String m47261b() {
        return this.f35706a;
    }

    /* renamed from: c */
    public String m47263c() {
        return this.f35707b;
    }

    /* renamed from: d */
    public String m47264d() {
        return this.f35708c;
    }

    /* renamed from: e */
    public String m47265e() {
        return this.f35709d;
    }

    /* renamed from: a */
    public void m47259a(Intent intent) {
        if (intent == null) {
            return;
        }
        if (this.f35708c == null) {
            this.f35708c = intent.getPackage();
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            m47262b(component.getClassName());
        }
    }

    /* renamed from: b */
    public void m47262b(String str) {
        this.f35709d = str;
    }

    /* renamed from: a */
    public void m47260a(String str) {
        this.f35708c = str;
    }
}
