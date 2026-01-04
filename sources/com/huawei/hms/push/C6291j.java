package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;

/* renamed from: com.huawei.hms.push.j */
/* loaded from: classes8.dex */
public class C6291j {
    /* renamed from: a */
    public static EnumC6292k m36532a(C6296o c6296o) {
        EnumC6292k enumC6292k = EnumC6292k.STYLE_DEFAULT;
        return (c6296o.m36586v() < 0 || c6296o.m36586v() >= EnumC6292k.values().length) ? enumC6292k : EnumC6292k.values()[c6296o.m36586v()];
    }

    /* renamed from: a */
    public static void m36533a(Notification.Builder builder, String str, C6296o c6296o) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        if (!TextUtils.isEmpty(c6296o.m36573g())) {
            bigTextStyle.setBigContentTitle(c6296o.m36573g());
        }
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            bigTextStyle.bigText(str);
        }
        builder.setStyle(bigTextStyle);
    }
}
