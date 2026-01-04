package com.huawei.hianalytics.framework.datahandler;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.C4755b;
import com.huawei.hianalytics.framework.C4757d;
import com.huawei.hianalytics.framework.C4762i;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import java.util.List;

/* loaded from: classes5.dex */
public class ReportTask implements Runnable {

    /* renamed from: a */
    public final String f21754a;

    /* renamed from: b */
    public final String f21755b;

    /* renamed from: c */
    public String f21756c;

    /* renamed from: d */
    public final IMandatoryParameters f21757d = C4757d.m28846a().m28848b();

    /* renamed from: e */
    public final int f21758e;

    /* renamed from: f */
    public final int f21759f;

    /* renamed from: g */
    public boolean f21760g;

    public ReportTask(String str, String str2, String str3, int i10, int i11) {
        this.f21754a = str;
        this.f21755b = str2;
        this.f21756c = str3;
        this.f21758e = i10;
        this.f21759f = i11;
    }

    /* renamed from: a */
    public final void m28853a(String str, String str2) {
        IStorageHandler iStorageHandlerM28844c = C4755b.m28844c(str);
        if (iStorageHandlerM28844c == null) {
            HiLog.m28808e("ReportTask", "storage handler is null");
            return;
        }
        List<Event> oldEvents = this.f21760g ? iStorageHandlerM28844c.readOldEvents(str, str2) : iStorageHandlerM28844c.readEvents(str, str2);
        if (oldEvents != null && !oldEvents.isEmpty()) {
            new C4762i(str, str2, oldEvents, null, this.f21756c, this.f21758e, this.f21759f).m28860a();
            return;
        }
        HiLog.m28811sw("ReportTask", "events size is empty, tag: " + str);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f21754a) && TextUtils.isEmpty(this.f21755b)) {
            this.f21760g = true;
            for (String str : this.f21757d.getAllTags()) {
                m28853a(str, "oper");
                m28853a(str, "maint");
            }
            return;
        }
        if (!"_default_config_tag".equals(this.f21754a) || !"allType".equals(this.f21755b)) {
            m28853a(this.f21754a, this.f21755b);
            return;
        }
        String str2 = this.f21754a;
        m28853a(str2, "oper");
        m28853a(str2, "maint");
    }
}
