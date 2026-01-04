package com.huawei.location.lite.common.http;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.lite.common.http.response.BaseResponse;
import es.C9542g;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import p688ur.C13241a;
import p688ur.C13243c;
import p688ur.C13244d;
import p688ur.C13245e;
import p716vr.C13483d;
import p785xr.C13851a;
import tr.AbstractC13057a;
import tr.C13063g;
import tr.C13065i;
import tr.InterfaceC13059c;
import tr.InterfaceC13061e;
import tr.InterfaceC13062f;

/* loaded from: classes8.dex */
public class SubmitEx implements InterfaceC13061e {

    /* renamed from: a */
    public final C13851a f31370a;

    /* renamed from: b */
    public final InterfaceC13059c f31371b;

    /* renamed from: c */
    public C6786c f31372c;

    public class TempResponse extends BaseResponse {
        private TempResponse() {
        }

        @Override // com.huawei.location.lite.common.http.response.BaseResponse
        public String getApiCode() {
            return this.code;
        }

        @Override // com.huawei.location.lite.common.http.response.BaseResponse
        public boolean isSuccess() {
            return TextUtils.isEmpty(this.code) || "0".equals(this.code);
        }
    }

    public SubmitEx(C13851a c13851a, InterfaceC13059c interfaceC13059c) {
        this.f31371b = interfaceC13059c;
        this.f31370a = c13851a;
        this.f31372c = new C6786c(interfaceC13059c instanceof AbstractC13057a ? ((AbstractC13057a) interfaceC13059c).m78784d() : null);
    }

    @Override // tr.InterfaceC13061e
    /* renamed from: a */
    public byte[] mo38438a() throws C13245e, C13244d {
        byte[] bArrM78818a = m38441d().m78798h().m78818a();
        if (bArrM78818a != null && bArrM78818a.length > 0) {
            this.f31372c.m38450c(this.f31370a, String.valueOf(200), C13243c.m79630b(200));
        }
        return bArrM78818a;
    }

    @Override // tr.InterfaceC13061e
    /* renamed from: b */
    public <T extends BaseResponse> T mo38439b(Class<T> cls) throws C13245e, C13244d {
        return (T) m38440c(m38442e(), cls);
    }

    /* renamed from: c */
    public <T extends BaseResponse> T m38440c(String str, Class<T> cls) throws C13245e, C13244d {
        try {
            T t10 = (T) C9542g.m59588a().fromJson(str, (Class) cls);
            if (t10 == null) {
                C1016d.m6183c("SubmitEx", "param exception");
                this.f31372c.m38450c(this.f31370a, String.valueOf(10304), C13243c.m79630b(10304));
                throw new C13245e(C13243c.m79629a(10304));
            }
            if (t10.isSuccess()) {
                this.f31372c.m38450c(this.f31370a, String.valueOf(200), C13243c.m79630b(200));
                return t10;
            }
            this.f31372c.m38450c(this.f31370a, t10.getApiCode(), t10.getMsg());
            throw new C13244d(t10.getApiCode(), t10.getMsg());
        } catch (Exception unused) {
            C1016d.m6183c("SubmitEx", "getEntity exception body is :" + str);
            this.f31372c.m38450c(this.f31370a, String.valueOf(10304), C13243c.m79630b(10304));
            throw new C13245e(C13243c.m79629a(10304));
        }
    }

    /* renamed from: d */
    public C13065i m38441d() throws C13245e, C13244d {
        C13243c c13243c;
        C1016d.m6186f("SubmitEx", "fetch info from server by network start...");
        C13243c c13243c2 = null;
        try {
            try {
                try {
                    InterfaceC13062f interfaceC13062fM38447a = C6785b.m38447a(this.f31370a.m83127g());
                    if (interfaceC13062fM38447a != null) {
                        this.f31371b.mo38444b().add(0, interfaceC13062fM38447a);
                    }
                    this.f31371b.mo38444b().add(new C13483d());
                    InterfaceC13059c interfaceC13059c = this.f31371b;
                    C13065i c13065iMo78789a = new C13063g(interfaceC13059c, this.f31370a, interfaceC13059c.mo38444b(), 0, this.f31371b.mo38443a()).mo78789a(this.f31370a);
                    if (c13065iMo78789a == null || c13065iMo78789a.m78798h() == null) {
                        throw new C13245e(C13243c.m79629a(10307));
                    }
                    long jM78800j = c13065iMo78789a.m78800j();
                    if (!c13065iMo78789a.m78801k()) {
                        throw new C13245e(C13243c.m79629a(c13065iMo78789a.m78799i()));
                    }
                    C1016d.m6186f("SubmitEx", "fetch info from server by network end...");
                    this.f31372c.m38451d(jM78800j);
                    return c13065iMo78789a;
                } catch (C13244d | C13245e e10) {
                    e10.m79628b();
                    throw e10;
                }
            } catch (IOException e11) {
                if (e11 instanceof C13241a) {
                    c13243c = ((C13241a) e11).m79627b();
                } else {
                    c13243c = new C13243c(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED, C13243c.m79630b(ActivityErrorCode.ENABLE_CONVERSION_EVENT_FAILED) + ":" + e11.getClass().getSimpleName());
                }
                throw new C13245e(c13243c);
            }
        } catch (Throwable th2) {
            C1016d.m6186f("SubmitEx", "fetch info from server by network end...");
            this.f31372c.m38451d(-1L);
            if (0 != 0) {
                this.f31372c.m38450c(this.f31370a, String.valueOf(c13243c2.f59923a), String.valueOf(c13243c2.f59924b));
            }
            throw th2;
        }
    }

    /* renamed from: e */
    public final String m38442e() throws C13245e, C13244d {
        return new String(m38441d().m78798h().m78818a(), StandardCharsets.UTF_8);
    }
}
