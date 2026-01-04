package com.huawei.cloud.services.drive;

import android.os.Build;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.hms.drive.C5284g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import p579qi.AbstractC12361b;
import p579qi.InterfaceC12362c;
import p811yi.C13986a;

/* loaded from: classes5.dex */
public class DriveRequestInitializer implements InterfaceC12362c {

    /* renamed from: a */
    private Map<String, Object> f21487a = new HashMap();

    @Override // p579qi.InterfaceC12362c
    public void initialize(AbstractC12361b<?> abstractC12361b) throws IOException {
        String strM31721b = C5284g.m31721b(abstractC12361b.getClass().getName());
        abstractC12361b.getHeaders().set("x-hw-terminal", Build.MODEL);
        abstractC12361b.getHeaders().set("x-hw-os", Build.DISPLAY);
        abstractC12361b.getHeaders().set("x-hw-app-id", C13986a.f62675b);
        abstractC12361b.getHeaders().set("version", "5.2.0.100");
        abstractC12361b.getHeaders().m28228T(C13986a.f62676c + "/" + C13986a.f62677d);
        if (!abstractC12361b.getHeaders().containsKey("x-hw-trace-id")) {
            abstractC12361b.getHeaders().set("x-hw-trace-id", C5284g.m31720a(strM31721b));
        }
        if (this.f21487a.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f21487a.entrySet()) {
            abstractC12361b.put(entry.getKey(), entry.getValue());
        }
    }

    public void setParams(String str, Object obj) {
        C4627a0.m28391d(str);
        C4627a0.m28391d(obj);
        this.f21487a.put(str, obj);
    }
}
