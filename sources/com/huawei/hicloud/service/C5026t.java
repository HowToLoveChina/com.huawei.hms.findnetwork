package com.huawei.hicloud.service;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.model.AccountConstant;
import com.huawei.hicloud.model.callback.HiCloudSMSCallback;
import com.huawei.hicloud.model.request.SMSLoginReq;
import com.huawei.hicloud.model.response.Response;
import com.huawei.hicloud.model.response.SMSLoginResp;
import com.huawei.hicloud.model.response.SMSRefreshResp;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9720a;
import fk.C9721b;
import mk.C11476b;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p523oi.C11903a;
import p527on.C11976a;
import p709vj.C13452e;
import tm.C13040c;
import tn.InterfaceC13043a;

/* renamed from: com.huawei.hicloud.service.t */
/* loaded from: classes.dex */
public class C5026t {

    /* renamed from: a */
    public static final Gson f22868a = new Gson();

    /* renamed from: com.huawei.hicloud.service.t$a */
    public static class a {

        /* renamed from: a */
        public static C5026t f22869a = new C5026t();
    }

    /* renamed from: d */
    public static C5026t m30056d() {
        return a.f22869a;
    }

    /* renamed from: a */
    public final String m30057a(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder(str);
        if (objArr != null) {
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = objArr[i10];
                sb2.append(" ");
                sb2.append(obj == null ? "" : obj.toString());
            }
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public <T> T m30058b(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f22868a.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10);
        }
    }

    /* renamed from: c */
    public final String m30059c(String str) throws C9721b {
        return C13040c.m78609F().m78646f0() + str;
    }

    /* renamed from: e */
    public SMSLoginResp m30060e(C11060c c11060c, String str) throws C9721b {
        String string = new SMSLoginReq(str).toString();
        m30065j(c11060c, AccountConstant.Cmd.SMS_LOGIN);
        try {
            try {
                return (SMSLoginResp) m30058b(m30062g(AccountConstant.Cmd.SMS_LOGIN, string, c11060c, "POST", null, null), SMSLoginResp.class);
            } catch (Exception e10) {
                BaseLogger.m28731e("HiCloudSMSService", "getSMSLoginResponse err. " + e10.getMessage());
                throw e10;
            }
        } finally {
            m30064i(C0213f.m1377a(), c11060c);
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07056"), AccountConstant.Cmd.AUTH_CODE_SHA256_REPORT, C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u(String.valueOf(0));
            c11060cM66626a.m66635A(C11476b.m68626h(str));
            m30064i(C0213f.m1377a(), c11060cM66626a);
        }
    }

    /* renamed from: f */
    public SMSRefreshResp m30061f(C11060c c11060c, String str, String str2) throws C9721b {
        m30065j(c11060c, AccountConstant.Cmd.SMS_REFRESH);
        try {
            try {
                return (SMSRefreshResp) m30058b(m30062g(AccountConstant.Cmd.SMS_REFRESH, "", c11060c, "POST", str, str2), SMSRefreshResp.class);
            } catch (Exception e10) {
                BaseLogger.m28731e("HiCloudSMSService", "getSMSRefreshResponse err. " + e10.getMessage());
                throw e10;
            }
        } finally {
            m30064i(C0213f.m1377a(), c11060c);
        }
    }

    /* renamed from: g */
    public final String m30062g(String str, String str2, C11060c c11060c, String str3, String str4, String str5) throws C9721b {
        int i10;
        String str6;
        int resultCode;
        String strM30059c = m30059c(str);
        char c10 = 1;
        int i11 = 1;
        while (true) {
            try {
                try {
                    Object[] objArr = new Object[3];
                    objArr[0] = str;
                    objArr[c10] = "x-hw-trace-id = ";
                    objArr[2] = c11060c.m66661q();
                    BaseLogger.m28733i("HiCloudSMSService", m30057a(strM30059c, objArr));
                    BaseLogger.m28729d("HiCloudSMSService", m30057a(str, str2));
                    try {
                        c11060c.m66665u(String.valueOf(0));
                        c11060c.m66635A("success");
                        i10 = 3;
                        try {
                            str6 = (String) C11976a.m72086g(strM30059c, new HiCloudSMSCallback(str, str2, c11060c.m66661q(), str3, str4, str5), c11060c);
                        } catch (C9721b e10) {
                            e = e10;
                            BaseLogger.m28731e("HiCloudSMSService", "invoke exception: " + m30057a(str, e));
                            m30063h(e);
                            str6 = null;
                            if (str6 == null) {
                                break;
                            }
                            break;
                            throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null");
                        }
                    } catch (C9721b e11) {
                        e = e11;
                        i10 = 3;
                    }
                    if (str6 == null || str6.isEmpty()) {
                        break;
                        break;
                    }
                    BaseLogger.m28729d("HiCloudSMSService", m30057a(str, str6));
                    Response response = (Response) m30058b(str6, Response.class);
                    resultCode = response.getResultCode();
                    if (resultCode == 0) {
                        return str6;
                    }
                    if (resultCode != i10) {
                        break;
                    }
                    int i12 = i11 + 1;
                    if (i11 >= i10) {
                        break;
                    }
                    BaseLogger.m28735w("HiCloudSMSService", " [AT OPERATION] " + m30057a(str, Integer.valueOf(resultCode), response.getResultDesc()));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" [AT OPERATION] ");
                    Object[] objArr2 = new Object[i10];
                    objArr2[0] = str;
                    objArr2[1] = Integer.valueOf(resultCode);
                    objArr2[2] = response.getResultDesc();
                    sb2.append(m30057a(strM30059c, objArr2));
                    BaseLogger.m28729d("HiCloudSMSService", sb2.toString());
                    i11 = i12;
                    c10 = 1;
                } catch (C9721b e12) {
                    c11060c.m66665u("125_" + e12.m60659c());
                    c11060c.m66635A(e12.getMessage());
                    BaseLogger.m28731e("HiCloudSMSService", m30057a(str, e12));
                    throw e12;
                }
            } catch (Exception e13) {
                BaseLogger.m28731e("HiCloudSMSService", m30057a(str, e13));
                c11060c.m66665u("125_4001");
                c11060c.m66635A(e13.getMessage());
                throw new C9721b(4001, e13.getMessage(), e13);
            }
        }
        BaseLogger.m28729d("HiCloudSMSService", "invoke body: " + str6);
        throw new C9721b(resultCode, str6);
    }

    /* renamed from: h */
    public final void m30063h(C9721b c9721b) throws C9721b {
        try {
            String errorCode = ((ErrorResp) C11903a.m71435l().mo69832e(c9721b.getMessage()).m69886u(ErrorResp.class)).getError().getErrorDetail().get(0).getErrorCode();
            int length = errorCode.length();
            throw new C9721b(Integer.parseInt(errorCode.substring(Math.max(0, length - 4), length)), c9721b.getMessage());
        } catch (C9721b e10) {
            throw e10;
        } catch (Exception e11) {
            BaseLogger.m28731e("HiCloudSMSService", "procAtCException json parse fail");
            throw new C9721b(4, c9721b.getMessage() + " " + e11);
        }
    }

    /* renamed from: i */
    public final void m30064i(Context context, C11060c c11060c) {
        InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
        if (interfaceC13043aM80810H != null) {
            interfaceC13043aM80810H.mo78693d(context, c11060c, null);
        }
    }

    /* renamed from: j */
    public final void m30065j(C11060c c11060c, String str) throws C9721b {
        C9720a.m60657f(c11060c, "stat is null.");
        C9720a.m60657f(str, "cmd is null.");
        C9720a.m60653b(c11060c.m66661q(), "x-hw-trace-id is null.");
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C9720a.m60653b(strM80971t0, "userid is null.");
        c11060c.m66644J(strM80971t0);
        c11060c.m66664t(str);
    }
}
