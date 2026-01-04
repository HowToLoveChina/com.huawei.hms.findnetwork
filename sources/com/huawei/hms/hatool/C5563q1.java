package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.UserManager;

/* renamed from: com.huawei.hms.hatool.q1 */
/* loaded from: classes8.dex */
public class C5563q1 {

    /* renamed from: c */
    private static C5563q1 f25281c = new C5563q1();

    /* renamed from: a */
    private boolean f25282a = false;

    /* renamed from: b */
    private Context f25283b = AbstractC5562q0.m32718i();

    private C5563q1() {
    }

    /* renamed from: b */
    public static C5563q1 m32725b() {
        return f25281c;
    }

    @TargetApi(24)
    /* renamed from: a */
    public boolean m32726a() {
        if (!this.f25282a) {
            Context context = this.f25283b;
            if (context == null) {
                return false;
            }
            UserManager userManager = (UserManager) context.getSystemService("user");
            if (userManager != null) {
                this.f25282a = userManager.isUserUnlocked();
            } else {
                this.f25282a = false;
            }
        }
        return this.f25282a;
    }
}
