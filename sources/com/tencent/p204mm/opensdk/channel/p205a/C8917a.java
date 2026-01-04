package com.tencent.p204mm.opensdk.channel.p205a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.p204mm.opensdk.constants.Build;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import com.tencent.p204mm.opensdk.utils.C8931d;
import com.tencent.p204mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.channel.a.a */
/* loaded from: classes9.dex */
public final class C8917a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a */
    public static class a {

        /* renamed from: a */
        public String f45397a;
        public String action;

        /* renamed from: b */
        public long f45398b;
        public Bundle bundle;
        public String content;
    }

    /* renamed from: a */
    public static boolean m56624a(Context context, a aVar) {
        String str;
        String str2;
        if (context == null) {
            str2 = "send fail, invalid argument";
        } else {
            if (!C8931d.m56649b(aVar.action)) {
                if (C8931d.m56649b(aVar.f45397a)) {
                    str = null;
                } else {
                    str = aVar.f45397a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(aVar.action);
                Bundle bundle = aVar.bundle;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, aVar.content);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, aVar.f45398b);
                intent.putExtra(ConstantsAPI.CHECK_SUM, C8918b.m56625a(aVar.content, Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str);
                Log.m56638d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
                return true;
            }
            str2 = "send fail, action is null";
        }
        Log.m56639e("MicroMsg.SDK.MMessage", str2);
        return false;
    }
}
