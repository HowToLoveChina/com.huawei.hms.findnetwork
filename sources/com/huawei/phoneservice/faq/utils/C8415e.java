package com.huawei.phoneservice.faq.utils;

import com.huawei.phoneservice.faq.base.util.FaqLogger;

/* renamed from: com.huawei.phoneservice.faq.utils.e */
/* loaded from: classes4.dex */
public class C8415e {
    /* renamed from: a */
    public static void m52388a(Runnable runnable) throws Throwable {
        StringBuilder sb2;
        String str;
        try {
            new Thread(runnable).start();
        } catch (Error e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "error : ";
            sb2.append(str);
            sb2.append(e.getMessage());
            FaqLogger.m51840e("x.task()", sb2.toString());
        } catch (IllegalThreadStateException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "IllegalThreadState : ";
            sb2.append(str);
            sb2.append(e.getMessage());
            FaqLogger.m51840e("x.task()", sb2.toString());
        } catch (Exception e12) {
            e = e12;
            sb2 = new StringBuilder();
            str = "Exception : ";
            sb2.append(str);
            sb2.append(e.getMessage());
            FaqLogger.m51840e("x.task()", sb2.toString());
        }
    }
}
