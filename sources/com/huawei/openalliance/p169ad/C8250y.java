package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.hms.ads.jsb.inner.data.DeviceInfo;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.y */
/* loaded from: classes8.dex */
public class C8250y extends AbstractC7326j {
    public C8250y() {
        super("pps.settings");
    }

    /* renamed from: b */
    private String m51545b(Context context) {
        Resources resources = context.getResources();
        Map<String, String> mapM47729a = AbstractC7758be.m47729a(resources.getString(C6849R.string.hiad_jssdk_i18n));
        if (mapM47729a == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : mapM47729a.entrySet()) {
            int iM51546c = m51546c(entry.getValue());
            if (iM51546c > 0) {
                sb2.append(entry.getKey());
                sb2.append(":");
                sb2.append(resources.getString(iM51546c));
                sb2.append(",");
            }
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return sb2.toString();
    }

    /* renamed from: c */
    private int m51546c(String str) {
        try {
            return C6849R.string.class.getField(str).getInt(null);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("JsbReqSettings", "getResourceId err, " + th2.getClass().getSimpleName());
            return 0;
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.m30366a(C6982bz.m41148a(context).mo41175d());
        deviceInfo.m30365a(AbstractC7807d.m48204a());
        deviceInfo.m30367b(m51545b(context));
        AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, 1000, AbstractC7758be.m47727a(deviceInfo), true);
    }
}
