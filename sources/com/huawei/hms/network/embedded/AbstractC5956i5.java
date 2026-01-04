package com.huawei.hms.network.embedded;

import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import java.io.IOException;
import java.net.URL;

/* renamed from: com.huawei.hms.network.embedded.i5 */
/* loaded from: classes8.dex */
public abstract class AbstractC5956i5 {

    /* renamed from: d */
    public static final String f27010d = "DetectEventListener";

    /* renamed from: e */
    public static final AbstractC5956i5 f27011e = new a();

    /* renamed from: a */
    public C5995l5 f27012a;

    /* renamed from: b */
    public C6150x4 f27013b;

    /* renamed from: c */
    public long f27014c;

    /* renamed from: com.huawei.hms.network.embedded.i5$a */
    public class a extends AbstractC5956i5 {
    }

    /* renamed from: com.huawei.hms.network.embedded.i5$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC6163y4 f27015a;

        public b(InterfaceC6163y4 interfaceC6163y4) {
            this.f27015a = interfaceC6163y4;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5943h5 c5943h5 = new C5943h5();
            c5943h5.put("domain", this.f27015a.mo35772a()).put("req_start_time", this.f27015a.mo35776b()).put("req_total_time", this.f27015a.mo35780e()).put("error_code", this.f27015a.mo35778c());
            Logger.m32143v(AbstractC5956i5.f27010d, "the detect date :" + c5943h5.get());
            HianalyticsHelper.getInstance().onEvent(c5943h5.get(), "netdiag");
        }
    }

    /* renamed from: a */
    public void m34375a(int i10) {
        mo34376a(i10, "");
    }

    /* renamed from: b */
    public void mo34380b(int i10) {
        C6150x4 c6150x4 = this.f27013b;
        if (c6150x4 != null) {
            c6150x4.m35773a(i10);
        }
    }

    /* renamed from: a */
    public void mo34376a(int i10, String str) {
        C6150x4 c6150x4 = this.f27013b;
        if (c6150x4 != null) {
            c6150x4.m35777b(i10);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                this.f27013b.m35775a(new URL(str).getHost());
            } catch (IOException unused) {
                Logger.m32145w(f27010d, "obtain host has error");
            }
        }
    }

    /* renamed from: b */
    public void mo34381b(C6138w5 c6138w5) {
        this.f27013b = new C6150x4();
        this.f27014c = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    public <T extends AbstractC6137w4> void m34377a(C5995l5 c5995l5, AbstractC6137w4 abstractC6137w4, int i10) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i10;
        messageObtain.obj = abstractC6137w4;
        c5995l5.m34659a(messageObtain);
    }

    /* renamed from: a */
    public void mo34378a(C6138w5 c6138w5) {
        if (this.f27013b != null) {
            this.f27013b.m35774a(SystemClock.elapsedRealtime() - this.f27014c);
            if (c6138w5 == null || !(c6138w5.m35723b() instanceof AbstractC6137w4)) {
                return;
            }
            ((C6124v4) c6138w5.m35723b()).mo35555a(this.f27013b);
            m34377a(this.f27012a, (C6124v4) c6138w5.m35723b(), 1003);
        }
    }

    /* renamed from: a */
    public <T extends InterfaceC6163y4> void m34379a(T t10) {
        if (!HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getResourceContext())) {
            Logger.m32141i(f27010d, "HianalyticsHelper report disable, and return!");
        } else if (t10 == null) {
            Logger.m32141i(f27010d, "the detect data has error! detect == null");
        } else {
            HianalyticsHelper.getInstance().getReportExecutor().execute(new b(t10));
        }
    }
}
