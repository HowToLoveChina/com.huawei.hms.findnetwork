package com.huawei.phoneservice.faq.base.util;

import android.os.Handler;
import android.view.View;
import androidx.annotation.Keep;

/* loaded from: classes4.dex */
public class FaqOnDoubleClickUtil {

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqOnDoubleClickUtil$a */
    public class RunnableC8317a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f38706a;

        public RunnableC8317a(View view) {
            this.f38706a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f38706a;
            if (view != null) {
                view.setEnabled(true);
            }
        }
    }

    @Keep
    public static void conClick(View view) {
        if (view != null) {
            view.setEnabled(false);
        }
        new Handler().postDelayed(new RunnableC8317a(view), 1000L);
    }
}
