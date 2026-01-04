package p387j7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hicloud.request.agreement.request.ConsentRecord;
import com.huawei.hicloud.request.agreement.request.ConsentRecordWithStatus;
import com.huawei.hicloud.request.agreement.request.QueryPushGuideRsp;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0212e0;
import p446l7.C11255c;
import p446l7.C11256d;
import p514o9.C11839m;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: j7.n */
/* loaded from: classes2.dex */
public class C10731n {

    /* renamed from: a */
    public final Context f51385a;

    /* renamed from: b */
    public Consumer<Boolean> f51386b;

    /* renamed from: c */
    public final Handler f51387c = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: j7.h
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f51383a.m65467y(message);
        }
    });

    public C10731n(Context context, Consumer<Boolean> consumer) {
        this.f51386b = null;
        this.f51385a = context;
        this.f51386b = consumer;
    }

    /* renamed from: A */
    public static /* synthetic */ void m65440A(Consumer consumer) {
        consumer.accept(Boolean.FALSE);
    }

    /* renamed from: p */
    public static /* synthetic */ void m65453p(boolean z10, Consumer consumer) {
        consumer.accept(Boolean.valueOf(z10));
    }

    /* renamed from: r */
    public static /* synthetic */ void m65454r(Consumer consumer) {
        consumer.accept(Boolean.FALSE);
    }

    /* renamed from: s */
    public static /* synthetic */ void m65455s(Consumer consumer) {
        consumer.accept(Boolean.FALSE);
    }

    /* renamed from: t */
    public static /* synthetic */ void m65456t(Consumer consumer) {
        consumer.accept(Boolean.FALSE);
    }

    /* renamed from: u */
    public static /* synthetic */ void m65457u(Consumer consumer) {
        consumer.accept(Boolean.FALSE);
    }

    /* renamed from: v */
    public static /* synthetic */ void m65458v(Consumer consumer) {
        consumer.accept(Boolean.FALSE);
    }

    /* renamed from: w */
    public static /* synthetic */ void m65459w(Consumer consumer) {
        consumer.accept(Boolean.FALSE);
    }

    /* renamed from: x */
    public static /* synthetic */ void m65460x(Consumer consumer) {
        consumer.accept(Boolean.FALSE);
    }

    /* renamed from: z */
    public static /* synthetic */ void m65461z(Consumer consumer) {
        consumer.accept(Boolean.FALSE);
    }

    /* renamed from: B */
    public final void m65462B(Object obj) {
        if (obj instanceof QueryPushGuideRsp) {
            List<ConsentRecordWithStatus> recordWithStatusArrayList = ((QueryPushGuideRsp) obj).getRecordWithStatusArrayList();
            if (recordWithStatusArrayList != null) {
                boolean z10 = false;
                ConsentRecordWithStatus consentRecordWithStatus = recordWithStatusArrayList.get(0);
                if (consentRecordWithStatus != null) {
                    boolean zIsNeedSign = consentRecordWithStatus.isNeedSign();
                    ConsentRecord latestSignRecord = consentRecordWithStatus.getLatestSignRecord();
                    if (latestSignRecord != null && latestSignRecord.isAgree()) {
                        z10 = true;
                    }
                    if (zIsNeedSign || !z10) {
                        m65463m();
                        return;
                    } else {
                        C11839m.m70688i("CheckPushPolicyHelper", "push policy not need sign");
                        Optional.ofNullable(this.f51386b).ifPresent(new Consumer() { // from class: j7.l
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj2) {
                                C10731n.m65440A((Consumer) obj2);
                            }
                        });
                        return;
                    }
                }
            }
            C11839m.m70689w("CheckPushPolicyHelper", "consent record status rsp is null");
            Optional.ofNullable(this.f51386b).ifPresent(new Consumer() { // from class: j7.k
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    C10731n.m65461z((Consumer) obj2);
                }
            });
        }
    }

    /* renamed from: m */
    public final void m65463m() {
        C11839m.m70688i("CheckPushPolicyHelper", "checkProtocolOpenRegions");
        C12515a.m75110o().m75172d(new C11255c(new Consumer() { // from class: j7.m
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f51384a.m65466q((List) obj);
            }
        }));
    }

    /* renamed from: n */
    public final void m65464n() {
        C12515a.m75110o().m75172d(new C11256d(new WeakReference(this.f51387c)));
    }

    /* renamed from: o */
    public void m65465o() {
        if (!C0209d.m1333z1(this.f51385a)) {
            C11839m.m70687e("CheckPushPolicyHelper", "network isn't available");
            Optional.ofNullable(this.f51386b).ifPresent(new Consumer() { // from class: j7.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C10731n.m65455s((Consumer) obj);
                }
            });
            return;
        }
        if (C0212e0.m1354d(this.f51385a, "checkbox_push_guide_sp", "key_push_guide_checkbox_showed", false)) {
            C11839m.m70687e("CheckPushPolicyHelper", "has show push protocol view");
            Optional.ofNullable(this.f51386b).ifPresent(new Consumer() { // from class: j7.e
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C10731n.m65456t((Consumer) obj);
                }
            });
        } else if (C13452e.m80781L().m80803F0().booleanValue()) {
            C11839m.m70688i("CheckPushPolicyHelper", "cn region not need check push policy");
            Optional.ofNullable(this.f51386b).ifPresent(new Consumer() { // from class: j7.f
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C10731n.m65457u((Consumer) obj);
                }
            });
        } else if (!C13452e.m80781L().m80795D0()) {
            m65464n();
        } else {
            C11839m.m70688i("CheckPushPolicyHelper", "child Account not need check push policy");
            Optional.ofNullable(this.f51386b).ifPresent(new Consumer() { // from class: j7.g
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C10731n.m65458v((Consumer) obj);
                }
            });
        }
    }

    /* renamed from: q */
    public final /* synthetic */ void m65466q(List list) {
        if (list == null || list.isEmpty()) {
            C11839m.m70689w("CheckPushPolicyHelper", "query regions list is empty");
            Optional.ofNullable(this.f51386b).ifPresent(new Consumer() { // from class: j7.c
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C10731n.m65454r((Consumer) obj);
                }
            });
            return;
        }
        String strM80942m = C13452e.m80781L().m80942m();
        final boolean z10 = strM80942m != null && list.contains(strM80942m.toLowerCase(Locale.ROOT));
        C11839m.m70686d("CheckPushPolicyHelper", "account country code:" + strM80942m + ",isInOpenRegions:" + z10);
        Optional.ofNullable(this.f51386b).ifPresent(new Consumer() { // from class: j7.d
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C10731n.m65453p(z10, (Consumer) obj);
            }
        });
    }

    /* renamed from: y */
    public final /* synthetic */ boolean m65467y(Message message) {
        int i10 = message.what;
        if (i10 == 31003) {
            m65462B(message.obj);
            return false;
        }
        if (i10 != 31004) {
            C11839m.m70688i("CheckPushPolicyHelper", "query push guide task error");
            Optional.ofNullable(this.f51386b).ifPresent(new Consumer() { // from class: j7.j
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C10731n.m65460x((Consumer) obj);
                }
            });
            return false;
        }
        C11839m.m70688i("CheckPushPolicyHelper", "query push guide task failed");
        Optional.ofNullable(this.f51386b).ifPresent(new Consumer() { // from class: j7.i
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C10731n.m65459w((Consumer) obj);
            }
        });
        return false;
    }
}
