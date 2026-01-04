package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.ReduceDisturbRule;
import com.huawei.openalliance.p169ad.beans.metadata.Rule;
import com.huawei.openalliance.p169ad.p171db.bean.UserCloseRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.util.Date;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.se */
/* loaded from: classes8.dex */
public class C7656se implements InterfaceC7670ss {

    /* renamed from: a */
    private InterfaceC7150gg f35666a;

    /* renamed from: b */
    private InterfaceC7146gc f35667b;

    /* renamed from: com.huawei.openalliance.ad.se$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ UserCloseRecord f35668a;

        /* renamed from: b */
        final /* synthetic */ long f35669b;

        public AnonymousClass1(UserCloseRecord userCloseRecord, long j10) {
            userCloseRecord = userCloseRecord;
            j = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7656se.this.f35666a.mo43546a(userCloseRecord);
            C7656se.this.f35666a.mo43545a(j);
            C7656se.this.m47218c();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.se$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strM47561b = AbstractC7741ao.m47561b("yyyy-MM-dd");
            if (!strM47561b.equals(C7656se.this.f35667b.mo43344aK())) {
                C7656se.this.f35667b.mo43450e(strM47561b);
                C7656se.this.f35667b.mo43448e(0);
            }
            C7656se.this.f35667b.mo43448e(C7656se.this.f35667b.mo43343aJ() + 1);
        }
    }

    public C7656se(Context context) {
        this.f35667b = null;
        this.f35667b = C7124fh.m43316b(context);
        this.f35666a = C7130fn.m43543a(context);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7670ss
    /* renamed from: b */
    public void mo47220b() {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.se.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String strM47561b = AbstractC7741ao.m47561b("yyyy-MM-dd");
                if (!strM47561b.equals(C7656se.this.f35667b.mo43344aK())) {
                    C7656se.this.f35667b.mo43450e(strM47561b);
                    C7656se.this.f35667b.mo43448e(0);
                }
                C7656se.this.f35667b.mo43448e(C7656se.this.f35667b.mo43343aJ() + 1);
            }
        });
    }

    /* renamed from: c */
    public void m47218c() {
        ReduceDisturbRule reduceDisturbRule;
        List<Rule> listM40437a;
        String strMo43009a = this.f35667b.mo43009a();
        if (AbstractC7806cz.m48165b(strMo43009a) || (reduceDisturbRule = (ReduceDisturbRule) AbstractC7758be.m47739b(strMo43009a, ReduceDisturbRule.class, new Class[0])) == null || (listM40437a = reduceDisturbRule.m40437a()) == null) {
            return;
        }
        long jM47566c = AbstractC7741ao.m47566c();
        long jM40441d = 0;
        for (Rule rule : listM40437a) {
            if (m47215a(rule)) {
                int size = this.f35666a.mo43544a(AbstractC7741ao.m47546a(new Date(), rule.m40438a()).getTime(), jM47566c).size();
                if (size >= rule.m40439b() && size <= rule.m40440c() && jM40441d <= rule.m40441d()) {
                    jM40441d = rule.m40441d();
                }
            }
        }
        this.f35667b.mo43446d(jM40441d + jM47566c);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7670ss
    /* renamed from: a */
    public void mo47219a() {
        UserCloseRecord userCloseRecord = new UserCloseRecord();
        userCloseRecord.m41847a(AbstractC7741ao.m47566c());
        userCloseRecord.m41848a(AbstractC7741ao.m47561b("yyyy-MM-dd HH:mm:ss"));
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.se.1

            /* renamed from: a */
            final /* synthetic */ UserCloseRecord f35668a;

            /* renamed from: b */
            final /* synthetic */ long f35669b;

            public AnonymousClass1(UserCloseRecord userCloseRecord2, long j10) {
                userCloseRecord = userCloseRecord2;
                j = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7656se.this.f35666a.mo43546a(userCloseRecord);
                C7656se.this.f35666a.mo43545a(j);
                C7656se.this.m47218c();
            }
        });
    }

    /* renamed from: a */
    private boolean m47215a(Rule rule) {
        return rule != null && rule.m40438a() <= this.f35667b.mo43356aW() && rule.m40438a() >= 1 && rule.m40439b() > 0 && rule.m40440c() > 0 && rule.m40441d() > 0;
    }
}
