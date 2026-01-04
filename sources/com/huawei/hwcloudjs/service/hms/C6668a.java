package com.huawei.hwcloudjs.service.hms;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.huawei.hwcloudjs.p160e.p163b.AbstractC6654c;
import com.huawei.hwcloudjs.p160e.p163b.AbstractC6655d;
import com.huawei.hwcloudjs.p160e.p163b.InterfaceC6653b;
import com.huawei.hwcloudjs.p164f.C6659d;

/* renamed from: com.huawei.hwcloudjs.service.hms.a */
/* loaded from: classes8.dex */
public class C6668a extends AbstractC6654c<b> {

    /* renamed from: b */
    private static final String f30928b = "ActivityResultNotifier";

    /* renamed from: c */
    private static C6668a f30929c = new C6668a();

    /* renamed from: com.huawei.hwcloudjs.service.hms.a$a */
    public static final class a implements InterfaceC6653b<b> {

        /* renamed from: a */
        private int f30930a;

        /* renamed from: b */
        private c f30931b;

        public a(int i10, c cVar) {
            this.f30930a = i10;
            this.f30931b = cVar;
        }

        @Override // com.huawei.hwcloudjs.p160e.p163b.InterfaceC6653b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onReceive(b bVar) {
            if (this.f30930a != bVar.f30934c) {
                return true;
            }
            this.f30931b.mo37934a(bVar);
            return false;
        }
    }

    /* renamed from: com.huawei.hwcloudjs.service.hms.a$b */
    public static final class b extends AbstractC6655d {

        /* renamed from: a */
        private Intent f30932a;

        /* renamed from: b */
        private int f30933b;

        /* renamed from: c */
        private int f30934c;

        /* renamed from: b */
        public int m37952b() {
            return this.f30934c;
        }

        /* renamed from: c */
        public int m37954c() {
            return this.f30933b;
        }

        /* renamed from: a */
        public Intent m37949a() {
            return this.f30932a;
        }

        /* renamed from: b */
        public void m37953b(int i10) {
            this.f30933b = i10;
        }

        /* renamed from: a */
        public void m37950a(int i10) {
            this.f30934c = i10;
        }

        /* renamed from: a */
        public void m37951a(Intent intent) {
            this.f30932a = intent;
        }
    }

    /* renamed from: com.huawei.hwcloudjs.service.hms.a$c */
    public interface c {
        /* renamed from: a */
        void mo37934a(b bVar);
    }

    /* renamed from: a */
    public static C6668a m37944a() {
        return f30929c;
    }

    /* renamed from: a */
    public void m37945a(int i10, c cVar) {
        m37944a().mo37870b(new a(i10, cVar));
    }

    /* renamed from: a */
    public void m37946a(Activity activity, Intent intent, int i10, c cVar) {
        m37944a().mo37870b(new a(i10, cVar));
        try {
            activity.startActivityForResult(intent, i10);
        } catch (ActivityNotFoundException unused) {
            C6659d.m37881b(f30928b, "ActivityNotFoundException .. ", true);
        }
    }
}
