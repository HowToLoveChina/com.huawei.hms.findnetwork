package com.huawei.android.hicloud.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.tencent.p204mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p204mm.opensdk.modelmsg.WXTextObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import je.C10808v;
import p015ak.C0209d;
import p035bk.C1248a;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class ThirdAppShareUtil {

    /* renamed from: a */
    public static final HashMap<String, String> f19612a = new C4297a();

    public interface PackageName {
    }

    public interface ThridAppId {
    }

    /* renamed from: com.huawei.android.hicloud.utils.ThirdAppShareUtil$a */
    public class C4297a extends HashMap<String, String> {
        public C4297a() {
            put("qq_friend", "com.tencent.mobileqq");
            put("wechat_friend", "com.tencent.mm");
            put("wechat_moments", "com.tencent.mm");
            put("weibo_post", "com.sina.weibo");
            put("facebook_post", "com.facebook.katana");
            put("twitter_tweet", "com.twitter.android");
            put("instagram_friend", "com.instagram.android");
        }
    }

    /* renamed from: a */
    public static String m25855a(String str) {
        return (str == null || str.length() <= 1024) ? str : str.substring(0, 1024);
    }

    /* renamed from: b */
    public static String m25856b(String str) {
        return TextUtils.isEmpty(str) ? " " : str.length() > 10240 ? str.substring(0, 10240) : str;
    }

    /* renamed from: c */
    public static Intent m25857c(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        C0209d.m1302r2(intent, str);
        intent.setType(str3);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("android.intent.extra.TEXT", str2);
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (C0209d.m1205R0(listQueryIntentActivities)) {
            C11839m.m70687e("ThirdAppShareUtil", "share link infoList is empty");
            return null;
        }
        intent.setClassName(str, listQueryIntentActivities.get(0).activityInfo.name);
        Intent intentCreateChooser = Intent.createChooser(intent, "");
        intentCreateChooser.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        return intentCreateChooser;
    }

    /* renamed from: d */
    public static HashMap<String, String> m25858d() {
        return f19612a;
    }

    /* renamed from: e */
    public static byte[] m25859e(Bitmap bitmap, boolean z10) throws IOException {
        if (bitmap == null) {
            C11839m.m70689w("ThirdAppShareUtil", "bitmap is null! return zero length byte array!");
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        if (z10) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e10) {
            BaseLogger.m28732e("ThirdAppShareUtil", "getWechatByteArray failed.", e10.getMessage());
        }
        return byteArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m25860f(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "launchThirdApp"
            java.lang.String r1 = "ThirdAppShareUtil"
            p514o9.C11839m.m70688i(r1, r0)
            r0 = 0
            if (r4 != 0) goto L10
            java.lang.String r4 = "launchThirdApp context is null"
            p514o9.C11839m.m70688i(r1, r4)
            return r0
        L10:
            java.util.HashMap<java.lang.String, java.lang.String> r2 = com.huawei.android.hicloud.utils.ThirdAppShareUtil.f19612a
            java.lang.String r3 = ""
            java.lang.Object r2 = r2.getOrDefault(r5, r3)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = p015ak.C0209d.m1184K0(r4, r2)
            if (r2 != 0) goto L21
            return r0
        L21:
            int r2 = r5.hashCode()     // Catch: java.lang.Exception -> L34
            r3 = 1
            switch(r2) {
                case -1567631971: goto L69;
                case -1418021481: goto L5f;
                case -870485595: goto L55;
                case 82334667: goto L4b;
                case 594307674: goto L41;
                case 1345439191: goto L37;
                case 1620935289: goto L2a;
                default: goto L29;
            }     // Catch: java.lang.Exception -> L34
        L29:
            goto L73
        L2a:
            java.lang.String r2 = "facebook_post"
            boolean r5 = r5.equals(r2)     // Catch: java.lang.Exception -> L34
            if (r5 == 0) goto L73
            r5 = 4
            goto L74
        L34:
            r4 = move-exception
            goto Lb8
        L37:
            java.lang.String r2 = "wechat_friend"
            boolean r5 = r5.equals(r2)     // Catch: java.lang.Exception -> L34
            if (r5 == 0) goto L73
            r5 = r3
            goto L74
        L41:
            java.lang.String r2 = "wechat_moments"
            boolean r5 = r5.equals(r2)     // Catch: java.lang.Exception -> L34
            if (r5 == 0) goto L73
            r5 = 2
            goto L74
        L4b:
            java.lang.String r2 = "instagram_friend"
            boolean r5 = r5.equals(r2)     // Catch: java.lang.Exception -> L34
            if (r5 == 0) goto L73
            r5 = 6
            goto L74
        L55:
            java.lang.String r2 = "twitter_tweet"
            boolean r5 = r5.equals(r2)     // Catch: java.lang.Exception -> L34
            if (r5 == 0) goto L73
            r5 = 5
            goto L74
        L5f:
            java.lang.String r2 = "weibo_post"
            boolean r5 = r5.equals(r2)     // Catch: java.lang.Exception -> L34
            if (r5 == 0) goto L73
            r5 = 3
            goto L74
        L69:
            java.lang.String r2 = "qq_friend"
            boolean r5 = r5.equals(r2)     // Catch: java.lang.Exception -> L34
            if (r5 == 0) goto L73
            r5 = r0
            goto L74
        L73:
            r5 = -1
        L74:
            switch(r5) {
                case 0: goto Lae;
                case 1: goto La4;
                case 2: goto La0;
                case 3: goto L96;
                case 4: goto L8c;
                case 5: goto L82;
                case 6: goto L78;
                default: goto L77;
            }     // Catch: java.lang.Exception -> L34
        L77:
            return r0
        L78:
            java.lang.String r5 = "com.instagram.android"
            android.content.Intent r5 = m25857c(r4, r5, r6, r7)     // Catch: java.lang.Exception -> L34
            r4.startActivity(r5)     // Catch: java.lang.Exception -> L34
            return r3
        L82:
            java.lang.String r5 = "com.twitter.android"
            android.content.Intent r5 = m25857c(r4, r5, r6, r7)     // Catch: java.lang.Exception -> L34
            r4.startActivity(r5)     // Catch: java.lang.Exception -> L34
            return r3
        L8c:
            java.lang.String r5 = "com.facebook.katana"
            android.content.Intent r5 = m25857c(r4, r5, r6, r7)     // Catch: java.lang.Exception -> L34
            r4.startActivity(r5)     // Catch: java.lang.Exception -> L34
            return r3
        L96:
            java.lang.String r5 = "com.sina.weibo"
            android.content.Intent r5 = m25857c(r4, r5, r6, r7)     // Catch: java.lang.Exception -> L34
            r4.startActivity(r5)     // Catch: java.lang.Exception -> L34
            return r3
        La0:
            m25862h(r4, r6)     // Catch: java.lang.Exception -> L34
            return r3
        La4:
            java.lang.String r5 = "com.tencent.mm"
            android.content.Intent r5 = m25857c(r4, r5, r6, r7)     // Catch: java.lang.Exception -> L34
            r4.startActivity(r5)     // Catch: java.lang.Exception -> L34
            return r3
        Lae:
            java.lang.String r5 = "com.tencent.mobileqq"
            android.content.Intent r5 = m25857c(r4, r5, r6, r7)     // Catch: java.lang.Exception -> L34
            r4.startActivity(r5)     // Catch: java.lang.Exception -> L34
            return r3
        Lb8:
            java.lang.String r4 = r4.getMessage()
            p514o9.C11839m.m70687e(r1, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.utils.ThirdAppShareUtil.m25860f(android.content.Context, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m25861g(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "launchUrlCardWechat"
            java.lang.String r1 = "ThirdAppShareUtil"
            p514o9.C11839m.m70688i(r1, r0)
            r0 = 0
            if (r5 != 0) goto L10
            java.lang.String r5 = "launchUrlCardWechat context is null"
            p514o9.C11839m.m70688i(r1, r5)
            return r0
        L10:
            java.util.HashMap<java.lang.String, java.lang.String> r2 = com.huawei.android.hicloud.utils.ThirdAppShareUtil.f19612a
            java.lang.String r3 = ""
            java.lang.Object r2 = r2.getOrDefault(r6, r3)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = p015ak.C0209d.m1184K0(r5, r2)
            if (r2 != 0) goto L21
            return r0
        L21:
            int r2 = r6.hashCode()     // Catch: java.lang.Exception -> L3b
            r3 = 594307674(0x236c6a5a, float:1.28161065E-17)
            r4 = 1
            if (r2 == r3) goto L3d
            r3 = 1345439191(0x5031c5d7, float:1.1930131E10)
            if (r2 == r3) goto L31
            goto L47
        L31:
            java.lang.String r2 = "wechat_friend"
            boolean r6 = r6.equals(r2)     // Catch: java.lang.Exception -> L3b
            if (r6 == 0) goto L47
            r6 = r0
            goto L48
        L3b:
            r5 = move-exception
            goto L55
        L3d:
            java.lang.String r2 = "wechat_moments"
            boolean r6 = r6.equals(r2)     // Catch: java.lang.Exception -> L3b
            if (r6 == 0) goto L47
            r6 = r4
            goto L48
        L47:
            r6 = -1
        L48:
            if (r6 == 0) goto L51
            if (r6 == r4) goto L4d
            return r0
        L4d:
            m25864j(r5, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L3b
            return r4
        L51:
            m25863i(r5, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L3b
            return r4
        L55:
            java.lang.String r5 = r5.getMessage()
            p514o9.C11839m.m70687e(r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.utils.ThirdAppShareUtil.m25861g(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: h */
    public static void m25862h(Context context, String str) {
        C10808v.m65796c(context, "wx50a006ee9dc22259");
        m25866l(str, 1);
        C10808v.m65794a();
    }

    /* renamed from: i */
    public static void m25863i(Context context, String str, String str2, String str3, String str4) {
        C10808v.m65796c(context, "wx50a006ee9dc22259");
        m25867m(str, str2, str3, str4, 0);
        C10808v.m65794a();
    }

    /* renamed from: j */
    public static void m25864j(Context context, String str, String str2, String str3, String str4) {
        C10808v.m65796c(context, "wx50a006ee9dc22259");
        m25867m(str, str2, str3, str4, 1);
        C10808v.m65794a();
    }

    /* renamed from: k */
    public static void m25865k(Resources resources, WXMediaMessage wXMediaMessage) {
        wXMediaMessage.thumbData = m25859e(C1248a.m7477h(resources, R$drawable.default_cloud_thumb), true);
    }

    /* renamed from: l */
    public static void m25866l(String str, int i10) {
        C11839m.m70688i("ThirdAppShareUtil", "shareTextToWeChat");
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = m25856b(str);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = m25855a(str);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = System.currentTimeMillis() + "text";
        req.message = wXMediaMessage;
        req.scene = i10;
        try {
            if (C10808v.m65795b() != null) {
                C10808v.m65795b().sendReq(req);
            } else {
                C11839m.m70687e("ThirdAppShareUtil", "shareTextToWeChat getWXApi is null!");
            }
        } catch (Exception e10) {
            BaseLogger.m28732e("ThirdAppShareUtil", "share to Wechat failed.", e10.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b3 A[Catch: Exception -> 0x0070, TRY_LEAVE, TryCatch #0 {Exception -> 0x0070, blocks: (B:24:0x0057, B:26:0x005d, B:27:0x0063, B:29:0x0066, B:31:0x006a, B:34:0x0072, B:35:0x0075, B:37:0x007c, B:39:0x0083, B:40:0x0087, B:41:0x0098, B:43:0x00a1, B:44:0x00ac, B:45:0x00b3), top: B:58:0x0057 }] */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m25867m(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.utils.ThirdAppShareUtil.m25867m(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int):void");
    }
}
