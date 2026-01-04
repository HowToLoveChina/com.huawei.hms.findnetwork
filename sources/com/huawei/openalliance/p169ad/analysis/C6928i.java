package com.huawei.openalliance.p169ad.analysis;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.consent.bean.network.ApiStatisticsReq;
import com.huawei.hms.ads.consent.bean.network.ConfirmResultReq;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7655sd;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.InterfaceC7004cu;
import com.huawei.openalliance.p169ad.InterfaceC7623qy;
import com.huawei.openalliance.p169ad.beans.metadata.OaidRecord;
import com.huawei.openalliance.p169ad.beans.metadata.TouchPoint;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.opendevice.open.C8262e;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.analysis.i */
/* loaded from: classes8.dex */
public class C6928i extends AbstractC6925f implements InterfaceC7004cu {
    public C6928i(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void m39197a(int i10, int i11, ContentRecord contentRecord) {
        String str;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onDownloadClick, contentRecord is null");
                return;
            }
            String strM41585m = contentRecord.m41585m();
            String strM41588n = contentRecord.m41588n();
            int iM41552f = contentRecord.m41552f();
            C6921b c6921bM39153a = m39153a(contentRecord.m41492an());
            if (c6921bM39153a == null) {
                return;
            }
            c6921bM39153a.m38827ak("14");
            c6921bM39153a.m39031o(strM41585m);
            c6921bM39153a.m39033p(strM41588n);
            c6921bM39153a.m38936a(iM41552f);
            c6921bM39153a.m39037r(AbstractC7758be.m47742b(new TouchPoint(i10, i11, contentRecord.m41591o())));
            Context context = this.f31973a;
            C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, iM41552f));
            c7560ou.mo46590a(contentRecord);
            c7560ou.mo46609b(c6921bM39153a, false, true);
        } catch (RuntimeException unused) {
            str = "onDownloadClick RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        } catch (Exception unused2) {
            str = "onDownloadClick Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        }
    }

    /* renamed from: b */
    public void m39209b(ContentRecord contentRecord) {
        m39195a("116", contentRecord, (String) null);
    }

    /* renamed from: c */
    public void m39214c(ContentRecord contentRecord) {
        m39195a("117", contentRecord, (String) null);
    }

    /* renamed from: d */
    public void m39218d(ContentRecord contentRecord) {
        m39195a("18", contentRecord, (String) null);
    }

    /* renamed from: e */
    public void m39220e(ContentRecord contentRecord) {
        m39195a("17", contentRecord, (String) null);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7004cu
    /* renamed from: f */
    public void mo39222f(ContentRecord contentRecord, String str) {
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onFeedbackAction, contentRecord is null.");
                return;
            }
            C6921b c6921bM39153a = m39153a(contentRecord.m41492an());
            if (c6921bM39153a == null) {
                return;
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "onFeedbackAction, extraStr1: %s", str);
            }
            c6921bM39153a.m38827ak("157");
            c6921bM39153a.m38936a(contentRecord.m41552f());
            c6921bM39153a.m39031o(contentRecord.m41585m());
            c6921bM39153a.m39033p(contentRecord.m41588n());
            c6921bM39153a.m38898H(contentRecord.m41591o());
            c6921bM39153a.m38828al(str);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())).mo46609b(c6921bM39153a, false, false);
        } catch (Exception e10) {
            AbstractC7185ho.m43823c("AnalysisReport", "onFeedbackAction Exception:" + e10.getClass().getSimpleName());
        }
    }

    /* renamed from: g */
    public void m39223g(ContentRecord contentRecord) {
        StringBuilder sb2;
        String str;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onAppointSuccess, contentRecord is null.");
                return;
            }
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("93");
            c6921bM39159a.m38936a(contentRecord.m41552f());
            c6921bM39159a.m39031o(contentRecord.m41585m());
            c6921bM39159a.m39033p(contentRecord.m41588n());
            c6921bM39159a.m38898H(contentRecord.m41591o());
            c6921bM39159a.m38828al(contentRecord.m41483ae());
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())).mo46609b(c6921bM39159a, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onAppointSuccess RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onAppointSuccess Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39198a(ContentRecord contentRecord) {
        m39195a("115", contentRecord, (String) null);
    }

    /* renamed from: b */
    public void m39210b(ContentRecord contentRecord, int i10) {
        StringBuilder sb2;
        String str;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onCancelAppointmentSuccess, contentRecord is null.");
                return;
            }
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("95");
            c6921bM39159a.m38936a(contentRecord.m41552f());
            c6921bM39159a.m39031o(contentRecord.m41585m());
            c6921bM39159a.m39033p(contentRecord.m41588n());
            c6921bM39159a.m38898H(contentRecord.m41591o());
            c6921bM39159a.m38998c(i10);
            c6921bM39159a.m38828al(contentRecord.m41483ae());
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())).mo46609b(c6921bM39159a, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onCancelAppointmentSuccess RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onCancelAppointmentSuccess Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: c */
    public void m39215c(ContentRecord contentRecord, int i10) {
        StringBuilder sb2;
        String str;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onCancelAppointmentFailed, contentRecord is null.");
                return;
            }
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("96");
            c6921bM39159a.m38936a(contentRecord.m41552f());
            c6921bM39159a.m39031o(contentRecord.m41585m());
            c6921bM39159a.m39033p(contentRecord.m41588n());
            c6921bM39159a.m38898H(contentRecord.m41591o());
            c6921bM39159a.m38998c(i10);
            c6921bM39159a.m38828al(contentRecord.m41483ae());
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())).mo46609b(c6921bM39159a, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onCancelAppointmentFailed RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onCancelAppointmentFailed Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m39219d(com.huawei.openalliance.p169ad.p171db.bean.ContentRecord r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "AnalysisReport"
            com.huawei.openalliance.ad.analysis.b r1 = r12.m39167f(r13)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            if (r1 != 0) goto L14
            java.lang.String r12 = "onRewardAdPopUpReport get analysisInfo failed"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43826d(r0, r12)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            return
        Le:
            r12 = move-exception
            goto L95
        L11:
            r12 = move-exception
            goto Lb2
        L14:
            int r2 = r14.hashCode()     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            r3 = 48718(0xbe4e, float:6.8268E-41)
            r4 = 0
            java.lang.String r5 = "127"
            java.lang.String r6 = "128"
            r7 = 2
            java.lang.String r8 = "129"
            r9 = 3
            java.lang.String r10 = "130"
            r11 = 1
            if (r2 == r3) goto L45
            switch(r2) {
                case 48694: goto L3d;
                case 48695: goto L35;
                case 48696: goto L2d;
                default: goto L2c;
            }
        L2c:
            goto L4d
        L2d:
            boolean r14 = r14.equals(r8)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            if (r14 == 0) goto L4d
            r14 = r7
            goto L4e
        L35:
            boolean r14 = r14.equals(r6)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            if (r14 == 0) goto L4d
            r14 = r11
            goto L4e
        L3d:
            boolean r14 = r14.equals(r5)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            if (r14 == 0) goto L4d
            r14 = r4
            goto L4e
        L45:
            boolean r14 = r14.equals(r10)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            if (r14 == 0) goto L4d
            r14 = r9
            goto L4e
        L4d:
            r14 = -1
        L4e:
            if (r14 == 0) goto L63
            if (r14 == r11) goto L5f
            if (r14 == r7) goto L5b
            if (r14 == r9) goto L57
            goto L66
        L57:
            r1.m38827ak(r10)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            goto L66
        L5b:
            r1.m38827ak(r8)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            goto L66
        L5f:
            r1.m38827ak(r6)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            goto L66
        L63:
            r1.m38827ak(r5)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
        L66:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            r14.<init>()     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            java.lang.String r2 = "adType is "
            r14.append(r2)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            java.lang.Integer r2 = r1.m39040t()     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            r14.append(r2)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            java.lang.String r14 = r14.toString()     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r0, r14)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            com.huawei.openalliance.ad.ou r14 = new com.huawei.openalliance.ad.ou     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            android.content.Context r12 = r12.f31973a     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            java.lang.Integer r2 = r1.m39040t()     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            int r2 = r2.intValue()     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            com.huawei.openalliance.ad.st r2 = com.huawei.openalliance.p169ad.C7662sk.m47225a(r12, r2)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            r14.<init>(r12, r2, r13)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            r14.mo46609b(r1, r4, r11)     // Catch: java.lang.Exception -> Le java.lang.RuntimeException -> L11
            goto Lba
        L95:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "onRewardAdPopUpReport Exception:"
        L9c:
            r13.append(r14)
            java.lang.Class r12 = r12.getClass()
            java.lang.String r12 = r12.getSimpleName()
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43823c(r0, r12)
            goto Lba
        Lb2:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "onRewardAdPopUpReport RuntimeException:"
            goto L9c
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.analysis.C6928i.m39219d(com.huawei.openalliance.ad.db.bean.ContentRecord, java.lang.String):void");
    }

    /* renamed from: e */
    public void m39221e(ContentRecord contentRecord, String str) {
        String str2;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "reportInstallPopUpEvent, data is null");
                return;
            }
            C6921b c6921bM39167f = m39167f(contentRecord);
            if (c6921bM39167f == null) {
                return;
            }
            c6921bM39167f.m38827ak(str);
            c6921bM39167f.m38898H(contentRecord.m41591o());
            c6921bM39167f.m39033p(contentRecord.m41588n());
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())).mo46609b(c6921bM39167f, false, true);
        } catch (RuntimeException unused) {
            str2 = "reportInstallPopUpEvent RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        } catch (Exception unused2) {
            str2 = "reportInstallPopUpEvent Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        }
    }

    /* renamed from: d */
    private boolean m39196d(String str) {
        if (str == null) {
            return false;
        }
        switch (str) {
            case "127":
            case "128":
            case "129":
            case "130":
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public void m39199a(ContentRecord contentRecord, int i10) {
        StringBuilder sb2;
        String str;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onAppointFailed, contentRecord is null.");
                return;
            }
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("94");
            c6921bM39159a.m38936a(contentRecord.m41552f());
            c6921bM39159a.m39031o(contentRecord.m41585m());
            c6921bM39159a.m39033p(contentRecord.m41588n());
            c6921bM39159a.m38898H(contentRecord.m41591o());
            c6921bM39159a.m38998c(i10);
            c6921bM39159a.m38828al(contentRecord.m41483ae());
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f())).mo46609b(c6921bM39159a, false, false);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "onAppointSuccess RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "onAppointSuccess Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: b */
    public void m39211b(ContentRecord contentRecord, String str) {
        m39195a("64", contentRecord, str);
    }

    /* renamed from: c */
    public void m39216c(ContentRecord contentRecord, String str) {
        String str2;
        try {
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onAppNotificationOperateAction, contentRecord is null");
                return;
            }
            String strM41585m = contentRecord.m41585m();
            String strM41588n = contentRecord.m41588n();
            int iM41552f = contentRecord.m41552f();
            C6921b c6921bM39153a = m39153a(contentRecord.m41492an());
            if (c6921bM39153a == null) {
                return;
            }
            c6921bM39153a.m38827ak("70");
            c6921bM39153a.m39031o(strM41585m);
            c6921bM39153a.m39033p(strM41588n);
            c6921bM39153a.m38936a(iM41552f);
            if (!TextUtils.isEmpty(str)) {
                c6921bM39153a.m39037r(str);
            }
            Context context = this.f31973a;
            C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, iM41552f));
            c7560ou.mo46590a(contentRecord);
            c7560ou.mo46609b(c6921bM39153a, false, true);
        } catch (RuntimeException unused) {
            str2 = "onAppNotificationOperateAction RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        } catch (Exception unused2) {
            str2 = "onAppNotificationOperateAction Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        }
    }

    /* renamed from: a */
    public void m39200a(ContentRecord contentRecord, String str) {
        m39195a("63", contentRecord, str);
    }

    /* renamed from: b */
    public void m39212b(AdLandingPageData adLandingPageData) {
        String str;
        try {
            if (adLandingPageData == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onLandingOpenAppDialogCancel, data is null");
                return;
            }
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("62");
            C6921b c6921bM39155a = m39155a(c6921bM39152a, adLandingPageData);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, adLandingPageData.getAdType())).mo46609b(c6921bM39155a, false, true);
        } catch (RuntimeException unused) {
            str = "onLandingOpenAppDialogCancelError RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        } catch (Exception unused2) {
            str = "onLandingOpenAppDialogCancelError Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7004cu
    /* renamed from: c */
    public void mo39217c(String str) {
        String str2;
        try {
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("69");
            if (!TextUtils.isEmpty(str)) {
                c6921bM39152a.m39037r(str);
            }
            new C7560ou(this.f31973a, null).mo46609b(c6921bM39152a, false, true);
        } catch (RuntimeException unused) {
            str2 = "onActiveAppFromBackBtn RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        } catch (Exception unused2) {
            str2 = "onActiveAppFromBackBtn Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        }
    }

    /* renamed from: a */
    public void m39201a(AdLandingPageData adLandingPageData) {
        String str;
        try {
            if (adLandingPageData == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onLandingOpenAppDialogAccept, data is null");
                return;
            }
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            c6921bM39152a.m38827ak("61");
            C6921b c6921bM39155a = m39155a(c6921bM39152a, adLandingPageData);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, adLandingPageData.getAdType())).mo46609b(c6921bM39155a, false, true);
        } catch (RuntimeException unused) {
            str = "onLandingOpenAppDialogAcceptError RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        } catch (Exception unused2) {
            str = "onLandingOpenAppDialogAcceptError Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str);
        }
    }

    /* renamed from: b */
    public void m39213b(String str) {
        StringBuilder sb2;
        String str2;
        try {
            C6921b c6921bM39152a = m39152a();
            if (c6921bM39152a == null) {
                return;
            }
            AbstractC7185ho.m43820b("AnalysisReport", "onConsentConfirm");
            c6921bM39152a.m38827ak("66");
            c6921bM39152a.m38888C(OaidRecord.LIMIT_OAID_OPEN_KEY.equalsIgnoreCase(str) ? "0" : "1");
            AbstractC6925f.m39149a(this.f31973a, c6921bM39152a);
            AbstractC6925f.m39151b(this.f31973a, c6921bM39152a);
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, -1)).mo46609b(c6921bM39152a, false, true);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "onConsentConfirm RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "onConsentConfirm Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39202a(AdLandingPageData adLandingPageData, String str) {
        String str2;
        try {
            if (m39196d(str)) {
                if (adLandingPageData == null) {
                    AbstractC7185ho.m43823c("AnalysisReport", "onLandingOpenAppDialogCancel, data is null");
                    return;
                }
                C6921b c6921bM39152a = m39152a();
                if (c6921bM39152a == null) {
                    return;
                }
                c6921bM39152a.m38827ak(str);
                C6921b c6921bM39155a = m39155a(c6921bM39152a, adLandingPageData);
                c6921bM39155a.m38828al("1");
                Context context = this.f31973a;
                new C7560ou(context, C7662sk.m47225a(context, adLandingPageData.getAdType())).mo46609b(c6921bM39155a, false, true);
            }
        } catch (RuntimeException unused) {
            str2 = "onLandPagePopUpReport RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        } catch (Exception unused2) {
            str2 = "onLandPagePopUpReport Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str2);
        }
    }

    /* renamed from: a */
    public void m39203a(C8262e c8262e) {
        try {
            if (c8262e == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "onPrivacyStatementOpen, privacyInfo is null");
                return;
            }
            C6921b c6921bM39158a = m39158a(this.f31973a.getPackageName(), true);
            if (c6921bM39158a == null) {
                return;
            }
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("AnalysisReport", "onPrivacyStatementOpen, type: %s", c8262e.m51593a());
            }
            c6921bM39158a.m38827ak("120");
            c6921bM39158a.m38961ad(c8262e.m51593a());
            c6921bM39158a.m38963ae(c8262e.m51597e());
            c6921bM39158a.m38937a(c8262e.m51600h());
            c6921bM39158a.m38992b(c8262e.m51602j());
            c6921bM39158a.m38965af(c8262e.m51604l());
            c6921bM39158a.m38967ag(c8262e.m51605m());
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39158a, true, true);
        } catch (RuntimeException e10) {
            AbstractC7185ho.m43824c("AnalysisReport", "onPrivacyStatementOpen RuntimeException： %s", e10.getClass().getSimpleName());
        } catch (Exception e11) {
            AbstractC7185ho.m43824c("AnalysisReport", "onPrivacyStatementOpen Exception： %s", e11.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7004cu
    /* renamed from: a */
    public void mo39204a(String str, ConfirmResultReq confirmResultReq, InterfaceC7623qy interfaceC7623qy) {
        StringBuilder sb2;
        String str2;
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<ApiStatisticsReq> it = confirmResultReq.getCaches().iterator();
            while (it.hasNext()) {
                com.huawei.openalliance.p169ad.beans.inner.ApiStatisticsReq apiStatisticsReqConvert = it.next().convert();
                C6921b c6921bM39158a = m39158a(str, true);
                if (c6921bM39158a == null) {
                    return;
                }
                c6921bM39158a.m38827ak("66");
                c6921bM39158a.m38941a(AbstractC7741ao.m47545a("yyyy-MM-dd HH:mm:ss.SSSZ").format(new Date(apiStatisticsReqConvert.m39372e())));
                c6921bM39158a.m39037r(AbstractC7806cz.m48170d(apiStatisticsReqConvert.m39374g()));
                c6921bM39158a.m39053z(Config.SDK_VERSION);
                c6921bM39158a.m38884A(apiStatisticsReqConvert.m39357a());
                c6921bM39158a.m38886B(apiStatisticsReqConvert.m39362b());
                c6921bM39158a.m38991b(apiStatisticsReqConvert.m39366c());
                c6921bM39158a.m38998c(apiStatisticsReqConvert.m39369d());
                c6921bM39158a.m38888C(apiStatisticsReqConvert.m39376i());
                if (apiStatisticsReqConvert.m39375h() != null) {
                    c6921bM39158a.m38896G(apiStatisticsReqConvert.m39375h());
                }
                c6921bM39158a.m38894F(AbstractC7807d.m48241h(this.f31973a));
                arrayList.add(c6921bM39158a);
            }
            Context context = this.f31973a;
            new C7560ou(context, C7662sk.m47225a(context, -1)).m46603a(str, arrayList, interfaceC7623qy);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str2 = "onApiStatisticsReport RuntimeException:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str2 = "onApiStatisticsReport Exception:";
            sb2.append(str2);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    private void m39195a(String str, ContentRecord contentRecord, String str2) {
        String str3;
        try {
            AbstractC7185ho.m43820b("AnalysisReport", "report dialog action:" + str);
            if (contentRecord == null) {
                AbstractC7185ho.m43823c("AnalysisReport", "reportDialogActionEvent, contentRecord is null");
                return;
            }
            C6921b c6921bM39153a = m39153a(contentRecord.m41492an());
            if (c6921bM39153a == null) {
                return;
            }
            c6921bM39153a.m38827ak(str);
            c6921bM39153a.m39031o(contentRecord.m41585m());
            c6921bM39153a.m39033p(contentRecord.m41588n());
            c6921bM39153a.m38936a(contentRecord.m41552f());
            if (!TextUtils.isEmpty(str2)) {
                c6921bM39153a.m39037r(str2);
            }
            Context context = this.f31973a;
            C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, contentRecord.m41552f()));
            c7560ou.mo46590a(contentRecord);
            c7560ou.mo46609b(c6921bM39153a, false, true);
        } catch (RuntimeException unused) {
            str3 = "reportDialogActionEvent RuntimeException";
            AbstractC7185ho.m43823c("AnalysisReport", str3);
        } catch (Exception unused2) {
            str3 = "reportDialogActionEvent Exception";
            AbstractC7185ho.m43823c("AnalysisReport", str3);
        }
    }

    /* renamed from: a */
    public void m39205a(String str, String str2) throws JSONException {
        StringBuilder sb2;
        String str3;
        try {
            if (OaidRecord.LIMIT_OAID_OPEN_KEY.equalsIgnoreCase(str2) || OaidRecord.LIMIT_OAID_CLOSE_KEY.equalsIgnoreCase(str2)) {
                m39213b(str2);
            }
            OaidRecord oaidRecordMo43483q = C7124fh.m43316b(this.f31973a).mo43483q(str2);
            if (oaidRecordMo43483q == null) {
                oaidRecordMo43483q = new OaidRecord();
            }
            AbstractC7185ho.m43820b("AnalysisReport", "onOaidSettingReport");
            oaidRecordMo43483q.m40365c();
            if (C7124fh.m43316b(this.f31973a).mo43050a(oaidRecordMo43483q.m40364b())) {
                AbstractC7185ho.m43820b("AnalysisReport", "report oaid setting event");
                C6921b c6921bM39159a = m39159a(false);
                if (c6921bM39159a == null) {
                    return;
                }
                AbstractC6925f.m39149a(this.f31973a, c6921bM39159a);
                AbstractC6925f.m39151b(this.f31973a, c6921bM39159a);
                c6921bM39159a.m38827ak(str);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("count", oaidRecordMo43483q.m40361a());
                c6921bM39159a.m39037r(AbstractC7806cz.m48170d(jSONObject.toString()));
                Context context = this.f31973a;
                new C7560ou(context, C7662sk.m47225a(context, -1)).mo46609b(c6921bM39159a, true, true);
                oaidRecordMo43483q.m40363a(System.currentTimeMillis());
                oaidRecordMo43483q.m40362a(0);
            }
            C7124fh.m43316b(this.f31973a).mo43327a(str2, oaidRecordMo43483q);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str3 = "onOaidSettingReport RuntimeException:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str3 = "onOaidSettingReport Exception:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("AnalysisReport", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m39206a(String str, String str2, int i10, String str3) {
        try {
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("161");
            c6921bM39159a.m38998c(i10);
            c6921bM39159a.m38828al(str);
            c6921bM39159a.m38829am(str2);
            c6921bM39159a.m38830an(str3);
            new C7560ou(this.f31973a, null).mo46609b(c6921bM39159a, false, true);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("AnalysisReport", "onDynamicLoaderException Exception");
        }
    }

    /* renamed from: a */
    public void m39207a(String str, String str2, long j10) {
        try {
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38827ak("161");
            c6921bM39159a.m38850c(j10);
            c6921bM39159a.m38828al(str);
            c6921bM39159a.m38829am(str2);
            c6921bM39159a.m38998c(0);
            new C7560ou(this.f31973a, null).mo46609b(c6921bM39159a, false, true);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("AnalysisReport", "onDynamicLoaderSuccess Exception");
        }
    }

    /* renamed from: a */
    public void m39208a(String str, String str2, String str3, String str4) {
        try {
            C6921b c6921bM39159a = m39159a(true);
            if (c6921bM39159a == null) {
                return;
            }
            c6921bM39159a.m38936a(1);
            c6921bM39159a.m38827ak(str);
            c6921bM39159a.m38828al(str2);
            c6921bM39159a.m38829am(str3);
            c6921bM39159a.m38830an(str4);
            Context context = this.f31973a;
            new C7560ou(context, new C7655sd(context)).mo46609b(c6921bM39159a, true, true);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("AnalysisReport", "onDbSizeReport ex: %s", th2.getClass().getSimpleName());
        }
    }
}
