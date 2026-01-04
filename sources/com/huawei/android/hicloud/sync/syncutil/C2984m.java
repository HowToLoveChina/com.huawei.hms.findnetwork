package com.huawei.android.hicloud.sync.syncutil;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import fk.C9721b;
import fk.C9722c;
import gp.C10028c;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p551pc.C12127a;
import p551pc.C12128b;
import p664u0.C13108a;
import p837z9.C14163d;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.m */
/* loaded from: classes3.dex */
public class C2984m {
    /* renamed from: g */
    public static String m17913g(int i10, String str) {
        try {
            return UserKeyUtils.getInstance().getSyncUser(i10, str).getUserKeyGuid();
        } catch (C9721b e10) {
            C11839m.m70687e("SyncLogicUtil", "get user key guid error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: h */
    public static boolean m17914h() {
        return !C10028c.m62182c0().m62420y1();
    }

    /* renamed from: i */
    public static boolean m17915i(int i10) {
        return m17918l(i10) || m17921o(i10) || m17917k(i10) || m17919m(i10) || m17916j(i10) || m17920n(i10) || m17922p(i10);
    }

    /* renamed from: j */
    public static boolean m17916j(int i10) {
        return i10 == 50001;
    }

    /* renamed from: k */
    public static boolean m17917k(int i10) {
        return i10 < 30100 && i10 >= 30001;
    }

    /* renamed from: l */
    public static boolean m17918l(int i10) {
        return i10 < 10100 && i10 >= 10001;
    }

    /* renamed from: m */
    public static boolean m17919m(int i10) {
        return i10 < 40100 && i10 >= 40001;
    }

    /* renamed from: n */
    public static boolean m17920n(int i10) {
        return i10 == 70001;
    }

    /* renamed from: o */
    public static boolean m17921o(int i10) {
        return i10 < 20100 && i10 >= 20001;
    }

    /* renamed from: p */
    public static boolean m17922p(int i10) {
        return i10 == 90001;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m17923a(fk.C9722c r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof p551pc.C12128b
            if (r0 == 0) goto Lb
            pc.b r4 = (p551pc.C12128b) r4
            int r3 = r3.m17926d(r4)
            return r3
        Lb:
            boolean r0 = r4 instanceof p551pc.C12127a
            if (r0 == 0) goto L16
            pc.a r4 = (p551pc.C12127a) r4
            int r3 = r3.m17925c(r4)
            return r3
        L16:
            int r3 = r4.m60666c()
            r0 = 404(0x194, float:5.66E-43)
            r1 = 10
            if (r3 == r0) goto L40
            r0 = 406(0x196, float:5.69E-43)
            if (r3 == r0) goto L40
            r0 = 409(0x199, float:5.73E-43)
            if (r3 == r0) goto L3e
            r0 = 411(0x19b, float:5.76E-43)
            r2 = 8
            if (r3 == r0) goto L3c
            r0 = 500(0x1f4, float:7.0E-43)
            if (r3 == r0) goto L40
            r0 = 2010(0x7da, float:2.817E-42)
            if (r3 == r0) goto L3c
            r0 = 2028(0x7ec, float:2.842E-42)
            if (r3 == r0) goto L40
            r1 = 5
            goto L40
        L3c:
            r1 = r2
            goto L40
        L3e:
            r1 = 17
        L40:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "[run] syncV1/syncV2 catch SyncException , error code:"
            r3.append(r0)
            int r0 = r4.m60666c()
            r3.append(r0)
            java.lang.String r0 = ", exception content:"
            r3.append(r0)
            java.lang.String r4 = r4.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "SyncLogicUtil"
            p514o9.C11839m.m70687e(r4, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.syncutil.C2984m.m17923a(fk.c):int");
    }

    /* renamed from: b */
    public int m17924b(C9722c c9722c) {
        if (c9722c instanceof C12128b) {
            return m17926d((C12128b) c9722c);
        }
        if (c9722c instanceof C12127a) {
            return m17925c((C12127a) c9722c);
        }
        int i10 = 10;
        switch (c9722c.m60666c()) {
            case 404:
            case 406:
            case 500:
            case 2028:
                break;
            case 409:
                i10 = 17;
                break;
            case NotifyConstants.MarketingConstant.CSOURCE_VALUE_BACKUP_FAIL_NOTIFICATION_POPUP /* 411 */:
            case 2010:
                i10 = 8;
                break;
            case 1001:
                i10 = 13;
                break;
            case 2001:
            case FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED /* 2017 */:
                i10 = 16;
                break;
            case 2013:
            case 2014:
            case 4312:
                i10 = 4312;
                break;
            default:
                i10 = 5;
                break;
        }
        C11839m.m70687e("SyncLogicUtil", "[run] syncV2 catch SyncException , error code:" + c9722c.m60666c() + ", exception content:" + c9722c.toString());
        return i10;
    }

    /* renamed from: c */
    public final int m17925c(C12127a c12127a) {
        int iM60666c = c12127a.m60666c();
        int i10 = 13;
        if (1001 != iM60666c && 901 != iM60666c) {
            if (m17915i(iM60666c)) {
                i10 = 14;
            } else if (401 == iM60666c || 1102 == iM60666c) {
                m17929q();
                i10 = 16;
            } else if (801 == iM60666c || 800 == iM60666c) {
                m17930r(iM60666c);
                i10 = 22;
            } else {
                i10 = 5;
            }
        }
        C11839m.m70687e("SyncLogicUtil", "[run] syncV1 catch SyncProtocolException , error code:" + iM60666c + ", exception content:" + c12127a.toString());
        return i10;
    }

    /* renamed from: d */
    public final int m17926d(C12128b c12128b) {
        C11839m.m70687e("SyncLogicUtil", "[run] catch SyncTransportException , error code:" + c12128b.m60666c() + ", exception content:" + c12128b.toString());
        return 10;
    }

    /* renamed from: e */
    public void m17927e(Context context) throws C9722c {
        if (context == null || !C0209d.m1173G1(context)) {
            return;
        }
        C11839m.m70688i("SyncLogicUtil", "Sync check isPrivacyUser, now exit Cloud!");
        CloudSyncUtil.m16055w(context);
        throw new C9722c(FamilyShareConstants.MessageCode.ENABLE_SPACE_SHARE_FAILED, "Send request, private space mode");
    }

    /* renamed from: f */
    public String m17928f(String str) {
        return (str == null || str.isEmpty()) ? "" : str;
    }

    /* renamed from: q */
    public final void m17929q() {
        C11839m.m70689w("SyncLogicUtil", "sync server auth failed.");
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
    }

    /* renamed from: r */
    public final void m17930r(int i10) {
        C11839m.m70687e("SyncLogicUtil", "Migration error, code =  " + i10);
        C14163d.m84990g().m85019y(i10);
    }
}
