package com.huawei.hms.hatool;

import java.util.Calendar;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.p0 */
/* loaded from: classes8.dex */
public class C5559p0 {

    /* renamed from: a */
    private long f25271a = 1800000;

    /* renamed from: b */
    private volatile boolean f25272b = false;

    /* renamed from: c */
    private a f25273c = null;

    /* renamed from: com.huawei.hms.hatool.p0$a */
    public class a {

        /* renamed from: a */
        String f25274a = UUID.randomUUID().toString().replace("-", "");

        /* renamed from: b */
        boolean f25275b;

        /* renamed from: c */
        private long f25276c;

        public a(long j10) {
            this.f25274a += "_" + j10;
            this.f25276c = j10;
            this.f25275b = true;
            C5559p0.this.f25272b = false;
        }

        /* renamed from: b */
        private void m32691b(long j10) {
            C5571v.m32792c("hmsSdk", "getNewSession() session is flush!");
            String string = UUID.randomUUID().toString();
            this.f25274a = string;
            this.f25274a = string.replace("-", "");
            this.f25274a += "_" + j10;
            this.f25276c = j10;
            this.f25275b = true;
        }

        /* renamed from: a */
        public void m32693a(long j10) {
            if (C5559p0.this.f25272b) {
                C5559p0.this.f25272b = false;
                m32691b(j10);
            } else if (m32692b(this.f25276c, j10) || m32690a(this.f25276c, j10)) {
                m32691b(j10);
            } else {
                this.f25276c = j10;
                this.f25275b = false;
            }
        }

        /* renamed from: a */
        private boolean m32690a(long j10, long j11) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j10);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j11);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        /* renamed from: b */
        private boolean m32692b(long j10, long j11) {
            return j11 - j10 >= C5559p0.this.f25271a;
        }
    }

    /* renamed from: a */
    public String m32687a() {
        a aVar = this.f25273c;
        if (aVar != null) {
            return aVar.f25274a;
        }
        C5571v.m32797f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    /* renamed from: a */
    public void m32688a(long j10) {
        a aVar = this.f25273c;
        if (aVar != null) {
            aVar.m32693a(j10);
        } else {
            C5571v.m32792c("hmsSdk", "Session is first flush");
            this.f25273c = new a(j10);
        }
    }

    /* renamed from: b */
    public boolean m32689b() {
        a aVar = this.f25273c;
        if (aVar != null) {
            return aVar.f25275b;
        }
        C5571v.m32797f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
