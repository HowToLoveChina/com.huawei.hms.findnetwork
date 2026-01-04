package com.huawei.hms.support.hwid.p140c;

import android.app.PendingIntent;
import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.common.p146e.C6472b;
import com.huawei.hms.support.hwid.common.p146e.C6477g;
import com.huawei.hms.support.hwid.p138a.C6445a;
import com.huawei.hms.utils.Util;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.support.hwid.c.b */
/* loaded from: classes8.dex */
public abstract class AbstractC6449b<T> extends TaskApiCall<C6445a, T> {

    /* renamed from: a */
    protected final String f30000a;

    /* renamed from: b */
    private int f30001b;

    /* renamed from: c */
    private String f30002c;

    public AbstractC6449b(String str, String str2, String str3) {
        super(str, str2, str3);
        this.f30000a = "[HUAWEIIDSDK]" + getClass().getSimpleName();
        this.f30001b = 40004300;
        this.f30002c = str;
    }

    /* renamed from: b */
    private ArrayList<String> m36827b(Class cls) {
        Type[] actualTypeArguments;
        ArrayList<String> arrayList = new ArrayList<>();
        if (cls == null) {
            return arrayList;
        }
        try {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass != null && (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) != null && actualTypeArguments.length >= 1) {
                for (Type type : actualTypeArguments) {
                    arrayList.add(type.toString().replace("class", "").trim());
                }
            }
            return arrayList;
        } catch (RuntimeException unused) {
            C6477g.m36903a(this.f30000a, "Generic names ：unknown runtimeException");
            return new ArrayList<>();
        } catch (Exception unused2) {
            C6477g.m36903a(this.f30000a, "Generic names ：unknown exception");
            return new ArrayList<>();
        }
    }

    /* renamed from: a */
    public boolean mo36830a() {
        return true;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    @Deprecated
    public int getMinApkVersion() {
        return this.f30001b;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C6445a c6445a, ResponseErrorCode responseErrorCode, String str, C8941i<T> c8941i) {
        m36825a(responseErrorCode, str);
        if (responseErrorCode.getErrorCode() != 0) {
            if (CommonCode.Resolution.HAS_RESOLUTION.equals(responseErrorCode.getResolution())) {
                C6477g.m36903a(this.f30000a, "hms apk version is low or is not exist.");
                c8941i.m56657c(new ResolvableApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), (PendingIntent) responseErrorCode.getParcelable())));
                m36826a(c6445a, responseErrorCode.getErrorCode());
                return;
            }
            if (mo36830a()) {
                C6477g.m36903a(this.f30000a, " error.");
                m36826a(c6445a, responseErrorCode.getErrorCode());
                c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                return;
            }
        }
        m36826a(c6445a, responseErrorCode.getErrorCode());
        mo36828a(responseErrorCode, str, c8941i);
    }

    public AbstractC6449b(String str, String str2, int i10) {
        this(str, str2, (String) null);
        this.f30001b = i10;
        this.f30002c = str;
    }

    /* renamed from: a */
    private String m36824a(Class cls) {
        try {
            ArrayList<String> arrayListM36827b = m36827b(cls);
            C6477g.m36903a(this.f30000a, "Generic names : " + arrayListM36827b.toString());
            if (arrayListM36827b.contains(C6445a.class.getName())) {
                arrayListM36827b.remove(C6445a.class.getName());
            }
            return arrayListM36827b.size() < 1 ? "" : arrayListM36827b.get(0);
        } catch (RuntimeException unused) {
            C6477g.m36903a(this.f30000a, "Generic name ：unknown runtimeException");
            return "";
        } catch (Exception unused2) {
            C6477g.m36903a(this.f30000a, "Generic name ：unknown exception");
            return "";
        }
    }

    /* renamed from: a */
    public void mo36828a(ResponseErrorCode responseErrorCode, String str, C8941i<T> c8941i) {
        if (TextUtils.isEmpty(str)) {
            C6477g.m36903a(this.f30000a, "body is null");
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            return;
        }
        String strM36824a = m36824a(getClass());
        C6477g.m36903a(this.f30000a, "Generic name  = " + strM36824a);
        if (strM36824a.contains(String.class.getName())) {
            c8941i.m56658d(str);
        } else if (strM36824a.contains(Void.class.getName())) {
            c8941i.m56658d(null);
        }
    }

    /* renamed from: a */
    private void m36825a(ResponseErrorCode responseErrorCode, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        sb2.append(",headerErrorReason:" + responseErrorCode.getErrorReason());
        C6477g.m36904a(this.f30000a, sb2.toString(), false);
    }

    /* renamed from: a */
    private void m36826a(C6445a c6445a, int i10) {
        if (c6445a != null) {
            HiAnalyticsClient.reportExit(c6445a.getContext(), this.f30002c, getTransactionId(), C6472b.m36869a(i10), i10);
            C6477g.m36903a(this.f30000a, "report:, apiName:" + this.f30002c + ", transId:" + getTransactionId() + ", statusCode:" + i10 + ", appId:" + Util.getAppId(c6445a.getContext()));
        }
    }
}
