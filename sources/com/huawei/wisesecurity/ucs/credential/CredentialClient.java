package com.huawei.wisesecurity.ucs.credential;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import aw.C1029b;
import aw.InterfaceC1028a;
import bw.EnumC1292b;
import com.huawei.hms.network.embedded.C6158y;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs.credential.outer.GrsCapability;
import com.huawei.wisesecurity.ucs.credential.outer.HACapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.Selector;
import java.util.UUID;
import p239dw.C9320b;
import p239dw.C9332h;
import p239dw.C9344n;
import p239dw.C9348p;
import p239dw.C9351s;
import p239dw.InterfaceC9323c0;
import p374iv.C10626e;
import p436kv.AbstractLinkHashMap;
import p500nv.C11756a;
import p535ov.InterfaceC12042i;
import p857zv.Exception_C14389c;
import p857zv.C14391e;

/* loaded from: classes9.dex */
public class CredentialClient {
    private static final String TAG = "CredentialClient";
    private String appId;
    private Context context;
    private C9351s credentialManager;
    private HACapability haCapability;

    public static class Builder {
        private String appId;

        @InterfaceC12042i
        private Context context;
        private GrsCapability grsCapability;
        private HACapability haCapability;
        private NetworkCapability networkCapability;
        private String serCountry;
        private int networkTimeOut = C6158y.f29108c;
        private int networkRetryTime = 2;
        private EnumC1292b reportOption = EnumC1292b.REPORT_NORMAL;

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public CredentialClient build() throws Exception_C14389c {
            try {
                String str = this.appId;
                if (str != null && str.length() > 30) {
                    throw new C14391e("appId length is too long");
                }
                C11756a.m70079b(this);
                InterfaceC9323c0 interfaceC9323c0SelectGrsCapability = Selector.selectGrsCapability(this.grsCapability, this.context, this.serCountry);
                return new CredentialClient(this.context, this.appId, interfaceC9323c0SelectGrsCapability, Selector.selectNetWorkCapability(this.networkCapability, this.context, this.networkTimeOut, this.networkRetryTime), Selector.selectHACapability(this.haCapability, interfaceC9323c0SelectGrsCapability, this.reportOption));
            } catch (C10626e e10) {
                StringBuilder sbM58651a = C9320b.m58651a("CredentialClient check param error : ");
                sbM58651a.append(e10.getMessage());
                throw new C14391e(sbM58651a.toString());
            } catch (Exception_C14389c e11) {
                C1029b.m6231b(CredentialClient.TAG, "CredentialClient build get UCS exception : errorCode : {0} errorMsg : {1}", Long.valueOf(e11.getErrorCode()), e11.getMessage());
                throw e11;
            } catch (Throwable th2) {
                StringBuilder sbM58651a2 = C9320b.m58651a("CredentialClient build get exception : ");
                sbM58651a2.append(th2.getMessage());
                String string = sbM58651a2.toString();
                throw C9344n.m58700a(CredentialClient.TAG, string, new Object[0], 2001L, string);
            }
        }

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder grsCapability(GrsCapability grsCapability) {
            this.grsCapability = grsCapability;
            return this;
        }

        public Builder haCapability(HACapability hACapability) {
            this.haCapability = hACapability;
            return this;
        }

        public Builder logInstance(InterfaceC1028a interfaceC1028a) {
            C1029b.m6235f(interfaceC1028a);
            return this;
        }

        public Builder networkCapability(NetworkCapability networkCapability) {
            this.networkCapability = networkCapability;
            return this;
        }

        public Builder networkRetryTime(int i10) {
            this.networkRetryTime = i10;
            return this;
        }

        public Builder networkTimeOut(int i10) {
            this.networkTimeOut = i10;
            return this;
        }

        public Builder reportOption(EnumC1292b enumC1292b) {
            this.reportOption = enumC1292b;
            return this;
        }

        public Builder serCountry(String str) {
            this.serCountry = str;
            return this;
        }
    }

    private CredentialClient(Context context, String str, InterfaceC9323c0 interfaceC9323c0, NetworkCapability networkCapability, HACapability hACapability) throws Exception_C14389c {
        this.context = context;
        this.appId = str;
        this.haCapability = hACapability;
        this.credentialManager = new C9351s(this, context, networkCapability, interfaceC9323c0, str);
        UcsLib.checkNativeLibrary();
    }

    private void checkParams(String str) throws Exception_C14389c {
        if (TextUtils.isEmpty(str)) {
            throw new Exception_C14389c(1001L, "serviceName illegal...");
        }
    }

    private void checkThread() throws Exception_C14389c {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new Exception_C14389c(1015L, "can not apply in main looper...");
        }
    }

    private C9332h createReportMsgBuilder(String str, String str2) {
        return (C9332h) new C9332h().m58674k().m58675l(str).putTransId(str2).putApiName("appAuth.applyCredential").putCallTime();
    }

    public Credential applyCredential(String str) throws Exception_C14389c {
        return applyCredential(str, UUID.randomUUID().toString());
    }

    public Credential applyCredentialByEC(String str) throws Exception_C14389c {
        return applyCredentialByEC(str, UUID.randomUUID().toString());
    }

    public Credential genCredentialFromString(String str) throws Exception_C14389c {
        C9348p c9348p = (C9348p) new C9348p().m58701k().putApiName("appAuth.credentialFromString").putCallTime();
        try {
            try {
                try {
                    Credential credentialFromString = Credential.fromString(this.context, str, c9348p);
                    c9348p.putStatusCode(0);
                    return credentialFromString;
                } catch (Exception e10) {
                    String str2 = "credential from string get exception : " + e10.getMessage();
                    C1029b.m6231b(TAG, "{0}", str2);
                    c9348p.putStatusCode(2001).putErrorMessageInfo(str2);
                    throw new Exception_C14389c(2001L, str2);
                }
            } catch (Exception_C14389c e11) {
                C1029b.m6231b(TAG, "credential from string get UcsException : {0}", e11.getMessage());
                c9348p.putStatusCode((int) e11.getErrorCode()).putErrorMessageInfo(e11.getMessage());
                throw e11;
            }
        } finally {
            reportLogs(c9348p);
        }
    }

    public void reportLogs(AbstractLinkHashMap AbstractLinkHashMap) {
        AbstractLinkHashMap.putAppId(this.appId).putPackageName(this.context.getPackageName()).putVersion("1.0.4.315");
        Context context = this.context;
        try {
            this.haCapability.onEvent(context, AbstractLinkHashMap.getName(), AbstractLinkHashMap.putUnionCostTime());
        } catch (Throwable th2) {
            StringBuilder sbM58651a = C9320b.m58651a("onEvent get exception : ");
            sbM58651a.append(th2.getMessage());
            C1029b.m6234e("ReportUtil", sbM58651a.toString(), new Object[0]);
        }
    }

    public /* synthetic */ CredentialClient(Context context, String str, InterfaceC9323c0 interfaceC9323c0, NetworkCapability networkCapability, HACapability hACapability, C8912a c8912a) throws Exception_C14389c {
        this(context, str, interfaceC9323c0, networkCapability, hACapability);
    }

    public Credential applyCredential(String str, String str2) throws Exception_C14389c {
        checkParams(str);
        checkThread();
        C9332h c9332hCreateReportMsgBuilder = createReportMsgBuilder(str, str2);
        C1029b.m6234e(TAG, "start apply credential for {0} , appId is {1},", str, this.appId);
        try {
            try {
                Credential credentialM58707a = this.credentialManager.m58707a(1, str, str2);
                C1029b.m6234e(TAG, "finish apply credential for {0} , appId is {1}", str, this.appId);
                c9332hCreateReportMsgBuilder.m58676m(this.credentialManager.f46758g).putStatusCode(0);
                return credentialM58707a;
            } catch (Exception_C14389c e10) {
                C1029b.m6231b(TAG, "get Credential get UcsException : " + e10.getMessage(), new Object[0]);
                c9332hCreateReportMsgBuilder.putStatusCode((int) e10.getErrorCode()).putErrorMessageInfo(e10.getMessage());
                throw e10;
            } catch (Exception e11) {
                String str3 = "get Credential get exception : " + e11.getMessage();
                C1029b.m6231b(TAG, str3, new Object[0]);
                c9332hCreateReportMsgBuilder.putStatusCode(2001).putErrorMessageInfo(str3);
                throw new Exception_C14389c(2001L, str3);
            }
        } finally {
            reportLogs(c9332hCreateReportMsgBuilder);
        }
    }

    public Credential applyCredentialByEC(String str, String str2) throws Exception_C14389c {
        checkParams(str);
        checkThread();
        C9332h c9332hCreateReportMsgBuilder = createReportMsgBuilder(str, str2);
        C1029b.m6234e(TAG, "start apply credential by EC for {0} , appId is {1}", str, this.appId);
        try {
            try {
                Credential credentialM58707a = this.credentialManager.m58707a(2, str, str2);
                C1029b.m6234e(TAG, "finish apply credential by EC for {0} , appId is {1}", str, this.appId);
                c9332hCreateReportMsgBuilder.m58676m(this.credentialManager.f46758g).putStatusCode(0);
                return credentialM58707a;
            } catch (Exception_C14389c e10) {
                C1029b.m6231b(TAG, "get Credential by EC get UcsException : " + e10.getMessage(), new Object[0]);
                c9332hCreateReportMsgBuilder.putStatusCode((int) e10.getErrorCode()).putErrorMessageInfo(e10.getMessage());
                throw e10;
            } catch (Exception e11) {
                String str3 = "get Credential by EC get exception : " + e11.getMessage();
                C1029b.m6231b(TAG, str3, new Object[0]);
                c9332hCreateReportMsgBuilder.putStatusCode(2001).putErrorMessageInfo(str3);
                throw new Exception_C14389c(2001L, str3);
            }
        } finally {
            reportLogs(c9332hCreateReportMsgBuilder);
        }
    }
}
