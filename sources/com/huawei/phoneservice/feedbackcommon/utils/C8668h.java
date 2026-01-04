package com.huawei.phoneservice.feedbackcommon.utils;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.h */
/* loaded from: classes5.dex */
public class C8668h {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m53438a(java.lang.String r7, java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "?"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 512(0x200, float:7.17E-43)
            r1.<init>(r2)
            java.lang.String r2 = ""
            r3 = 0
            boolean r4 = r7.contains(r0)     // Catch: java.lang.Exception -> L3b
            if (r4 == 0) goto L43
            r4 = 63
            int r4 = r7.indexOf(r4)     // Catch: java.lang.Exception -> L3b
            r5 = 0
            java.lang.String r2 = r7.substring(r5, r4)     // Catch: java.lang.Exception -> L3b
            int r4 = r7.indexOf(r0)     // Catch: java.lang.Exception -> L3b
            java.lang.String r4 = r7.substring(r4)     // Catch: java.lang.Exception -> L3b
            int r4 = r4.length()     // Catch: java.lang.Exception -> L3b
            r5 = 1
            if (r4 <= r5) goto L3d
            com.huawei.phoneservice.feedbackcommon.utils.a r4 = new com.huawei.phoneservice.feedbackcommon.utils.a     // Catch: java.lang.Exception -> L3b
            int r0 = r7.indexOf(r0)     // Catch: java.lang.Exception -> L3b
            int r0 = r0 + r5
            java.lang.String r0 = r7.substring(r0)     // Catch: java.lang.Exception -> L3b
            r4.<init>(r0)     // Catch: java.lang.Exception -> L3b
            goto L67
        L3b:
            r0 = move-exception
            goto L4c
        L3d:
            com.huawei.phoneservice.feedbackcommon.utils.a r4 = new com.huawei.phoneservice.feedbackcommon.utils.a     // Catch: java.lang.Exception -> L3b
            r4.<init>(r3)     // Catch: java.lang.Exception -> L3b
            goto L67
        L43:
            com.huawei.phoneservice.feedbackcommon.utils.a r4 = new com.huawei.phoneservice.feedbackcommon.utils.a     // Catch: java.lang.Exception -> L4a
            r4.<init>(r3)     // Catch: java.lang.Exception -> L4a
            r2 = r7
            goto L67
        L4a:
            r0 = move-exception
            r2 = r7
        L4c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getAuthorizationHeader failed because of request format error. "
            r4.append(r5)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r4 = "HeaderUtils"
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51836d(r4, r0)
            r4 = r3
        L67:
            java.lang.String r0 = "POST"
            r1.append(r0)
            java.lang.String r0 = "&"
            r1.append(r0)
            java.lang.String r5 = "/platform"
            boolean r7 = r7.contains(r5)
            if (r7 == 0) goto Lbf
            if (r4 != 0) goto L7c
            goto L82
        L7c:
            java.lang.String r7 = "channelID"
            java.lang.String r3 = r4.m53381a(r7)
        L82:
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = java.lang.String.valueOf(r5)
            r1.append(r2)
            r1.append(r0)
            r1.append(r4)
            r1.append(r0)
            r1.append(r8)
            java.lang.String r8 = "&channelID="
            r1.append(r8)
            r1.append(r3)
            r1.append(r0)
            java.lang.String r8 = "timestamp="
            r1.append(r8)
            r1.append(r7)
            java.lang.String r8 = r1.toString()
            java.lang.String r8 = com.huawei.phoneservice.feedbackcommon.utils.C8667g.m53436a(r8, r9)
            java.lang.Object[] r7 = new java.lang.Object[]{r3, r7, r8}
            java.lang.String r8 = "HMAC-SHA256 channelID={0}, timestamp={1}, signature=\"{2}\""
            java.lang.String r7 = java.text.MessageFormat.format(r8, r7)
            return r7
        Lbf:
            if (r4 != 0) goto Lc2
            goto Lc8
        Lc2:
            java.lang.String r7 = "appID"
            java.lang.String r3 = r4.m53381a(r7)
        Lc8:
            java.lang.String r7 = "/"
            int r7 = r2.indexOf(r7)
            java.lang.String r7 = r2.substring(r7)
            r1.append(r7)
            r1.append(r0)
            r1.append(r4)
            r1.append(r0)
            r1.append(r8)
            java.lang.String r7 = "&appID="
            r1.append(r7)
            r1.append(r3)
            java.lang.String r7 = r1.toString()
            java.lang.String r7 = com.huawei.phoneservice.feedbackcommon.utils.C8667g.m53436a(r7, r9)
            java.lang.String r8 = "FeedBackPresenter1"
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51836d(r8, r7)
            java.lang.Object[] r7 = new java.lang.Object[]{r3, r7}
            java.lang.String r8 = "HMAC-SHA256 appID={0}, signature=\"{1}\""
            java.lang.String r7 = java.text.MessageFormat.format(r8, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.C8668h.m53438a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
