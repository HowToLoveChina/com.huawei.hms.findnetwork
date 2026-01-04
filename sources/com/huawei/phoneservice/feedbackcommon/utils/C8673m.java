package com.huawei.phoneservice.feedbackcommon.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.tracker.HiAnalyticsUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.feedbackcommon.entity.C8615c;
import com.huawei.phoneservice.feedbackcommon.entity.C8618d0;
import com.huawei.phoneservice.feedbackcommon.entity.C8619e;
import com.huawei.phoneservice.feedbackcommon.entity.C8620f;
import com.huawei.phoneservice.feedbackcommon.entity.C8623i;
import com.huawei.phoneservice.feedbackcommon.entity.C8624j;
import com.huawei.phoneservice.feedbackcommon.entity.C8625k;
import com.huawei.phoneservice.feedbackcommon.entity.C8626l;
import com.huawei.phoneservice.feedbackcommon.entity.C8628n;
import com.huawei.phoneservice.feedbackcommon.entity.C8629o;
import com.huawei.phoneservice.feedbackcommon.entity.C8632r;
import com.huawei.phoneservice.feedbackcommon.entity.C8633s;
import com.huawei.phoneservice.feedbackcommon.entity.C8634t;
import com.huawei.phoneservice.feedbackcommon.entity.C8635u;
import com.huawei.phoneservice.feedbackcommon.entity.C8636v;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackZipBean;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import com.huawei.phoneservice.feedbackcommon.utils.encrypt.C8664a;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.crypto.signer.CredentialSigner;
import cw.C8957b;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p857zv.C14387a;
import p857zv.C14389c;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.m */
/* loaded from: classes5.dex */
public final class C8673m extends AbstractC8662d {

    /* renamed from: h */
    public String f40411h;

    /* renamed from: k */
    public String f40414k;

    /* renamed from: l */
    public WeakReference<NotifyUploadZipListener> f40415l;

    /* renamed from: q */
    public String f40420q;

    /* renamed from: r */
    public long f40421r;

    /* renamed from: s */
    public String f40422s;

    /* renamed from: u */
    public CredentialClient f40424u;

    /* renamed from: v */
    public Credential f40425v;

    /* renamed from: i */
    public String f40412i = "";

    /* renamed from: j */
    public String f40413j = "";

    /* renamed from: m */
    public int f40416m = 0;

    /* renamed from: n */
    public long f40417n = 0;

    /* renamed from: o */
    public int f40418o = 0;

    /* renamed from: p */
    public int f40419p = 0;

    /* renamed from: t */
    public boolean f40423t = false;

    /* renamed from: w */
    public boolean f40426w = false;

    /* renamed from: x */
    public boolean f40427x = false;

    /* renamed from: y */
    public boolean f40428y = false;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.m$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f40429a;

        /* renamed from: b */
        public final /* synthetic */ File f40430b;

        /* renamed from: c */
        public final /* synthetic */ int f40431c;

        public a(int i10, File file, int i11) {
            this.f40429a = i10;
            this.f40430b = file;
            this.f40431c = i11;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                C8673m.this.f40424u = new CredentialClient.Builder().context(C8673m.this.f40346e).serCountry(FaqSdk.getSdk().getSdk("country")).build();
                if (C8673m.this.f40424u == null) {
                    C8673m.this.m53538K(false);
                    return;
                }
                C8673m c8673m = C8673m.this;
                c8673m.f40425v = c8673m.f40424u.applyCredential("com.huawei.wisesupport.feedback");
                if (C8673m.this.f40425v == null) {
                    C8673m.this.m53538K(false);
                    return;
                }
                C8957b.m56708g("ucs_entity_key", C8673m.this.f40425v.toString(), C8673m.this.f40346e);
                int i10 = this.f40429a;
                if (i10 == 2) {
                    C8673m.this.m53534G(this.f40430b, this.f40431c);
                } else if (i10 == 3) {
                    C8673m.this.m53539M();
                } else {
                    C8673m.this.m53515V();
                }
            } catch (C14389c e10) {
                C8673m.this.m53538K(false);
                FaqLogger.m51840e("UploadZipTask", e10.getMessage());
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.m$b */
    public class b implements Callback {

        /* renamed from: a */
        public final /* synthetic */ File f40433a;

        public b(File file) {
            this.f40433a = file;
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onFailure(Submit submit, Throwable th2) throws Throwable {
            C8673m.this.m53543T("getUploadInfo", "400", "failure");
            C8673m.this.m53538K(false);
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onResponse(Submit submit, Response response) throws Throwable {
            try {
                C8673m.this.m53558r((C8629o) new Gson().fromJson(StringUtils.byte2Str(response.getBody().bytes()), C8629o.class), this.f40433a);
            } catch (JsonSyntaxException unused) {
                C8673m.this.m53543T("getUploadInfo", "400", "JsonSyntaxException");
                C8673m.this.m53538K(false);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.m$c */
    public class c implements Callback {
        public c() {
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onFailure(Submit submit, Throwable th2) throws Throwable {
            C8673m.this.m53543T("getServerDomain", "400", "failure");
            C8673m.this.m53538K(false);
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onResponse(Submit submit, Response response) throws Throwable {
            C8673m.this.m53540N(response);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.m$d */
    public class d implements Callback {

        /* renamed from: a */
        public final /* synthetic */ File f40436a;

        public d(File file) {
            this.f40436a = file;
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onFailure(Submit submit, Throwable th2) throws Throwable {
            C8673m.this.m53543T("getUploadInfo", "400", "failure");
            C8673m.this.m53538K(false);
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onResponse(Submit submit, Response response) throws Throwable {
            try {
                C8619e c8619e = (C8619e) new Gson().fromJson(StringUtils.byte2Str(response.getBody().bytes()), C8619e.class);
                if (c8619e != null && c8619e.m53229d() == 0) {
                    C8673m.this.m53543T("getUploadInfo", "200", "success");
                    C8673m.this.f40414k = c8619e.m53226a();
                    C8673m.this.m53555o(c8619e, c8619e.m53230e().size(), this.f40436a);
                    return;
                }
                if (c8619e != null && c8619e.m53229d() == 200002) {
                    try {
                        int i10 = Integer.parseInt(c8619e.m53227b().m53231a());
                        if (C8673m.this.f40416m > i10) {
                            C8673m.this.f40417n = ((long) Math.ceil(r0.f40421r / i10)) + 1048576;
                            ZipUtil.deleteFile(new File(FeedbackWebConstants.getZipFilePath(C8673m.this.f40346e)));
                            C8673m c8673m = C8673m.this;
                            c8673m.m53551k(c8673m.f40417n);
                        } else {
                            C8673m.this.m53555o(c8619e, c8619e.m53230e().size(), this.f40436a);
                        }
                        return;
                    } catch (Exception unused) {
                    }
                }
                C8673m.this.m53554n(c8619e);
            } catch (JsonSyntaxException unused2) {
                C8673m.this.m53543T("getUploadInfo", "400", "JsonSyntaxException");
                C8673m.this.m53538K(false);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.m$e */
    public class e implements Callback {

        /* renamed from: a */
        public final /* synthetic */ File f40438a;

        /* renamed from: b */
        public final /* synthetic */ String f40439b;

        /* renamed from: c */
        public final /* synthetic */ int f40440c;

        /* renamed from: d */
        public final /* synthetic */ int f40441d;

        public e(File file, String str, int i10, int i11) {
            this.f40438a = file;
            this.f40439b = str;
            this.f40440c = i10;
            this.f40441d = i11;
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onFailure(Submit submit, Throwable th2) throws Throwable {
            C8673m.this.m53543T("uploadFile", "failure", th2 == null ? "" : th2.getMessage());
            int i10 = this.f40441d;
            if (i10 == 0) {
                C8673m.m53518a0(C8673m.this);
                if (C8673m.this.f40423t) {
                    C8673m.this.m53534G(this.f40438a, this.f40440c);
                } else {
                    C8673m.this.m53542S(this.f40438a, this.f40440c);
                }
            } else if (1 == i10) {
                C8673m.m53518a0(C8673m.this);
            }
            C8673m.this.m53549i(this.f40440c, submit);
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onResponse(Submit submit, Response response) throws Throwable {
            int code = response == null ? 0 : response.getCode();
            if (200 == code) {
                C8673m.this.f40347f.add(new FeedbackZipBean(this.f40438a.getName(), this.f40439b));
                C8673m.m53517Y(C8673m.this);
                C8673m.this.m53549i(this.f40440c, submit);
                return;
            }
            int i10 = this.f40441d;
            if (i10 == 0) {
                C8673m.m53518a0(C8673m.this);
                C8673m.this.m53542S(this.f40438a, this.f40440c);
            } else if (1 == i10) {
                C8673m.m53518a0(C8673m.this);
            }
            C8673m.this.m53549i(this.f40440c, submit);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" uploadFile ");
            sb2.append(code);
            sb2.append(" ");
            sb2.append(response == null ? "" : response.getMessage());
            FaqLogger.print("UploadZipTask", sb2.toString());
            C8673m.this.m53543T("uploadFile", "failure", String.valueOf(code));
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.m$f */
    public class f implements Callback {
        public f() {
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onFailure(Submit submit, Throwable th2) throws Throwable {
            C8673m c8673m = C8673m.this;
            c8673m.m53538K(c8673m.f40345d);
            C8673m.this.m53543T("notifyUploadSuccess", "400", "failure");
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onResponse(Submit submit, Response response) throws Throwable {
            C8673m.this.m53552l(response);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.m$g */
    public class g implements Callback {
        public g() {
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onFailure(Submit submit, Throwable th2) throws Throwable {
            C8673m.this.m53538K(false);
            C8673m.this.m53543T("notifyUploadSuccess", "400", "failure");
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onResponse(Submit submit, Response response) throws Throwable {
            try {
                C8673m.this.m53557q((C8626l) new Gson().fromJson(StringUtils.byte2Str(response.getBody().bytes()), C8626l.class));
            } catch (JsonSyntaxException unused) {
                C8673m.this.m53538K(false);
                C8673m.this.m53543T("notifyUploadSuccess", "400", "JsonSyntaxException");
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.m$h */
    public class h implements Callback {

        /* renamed from: a */
        public final /* synthetic */ File f40445a;

        /* renamed from: b */
        public final /* synthetic */ int f40446b;

        public h(File file, int i10) {
            this.f40445a = file;
            this.f40446b = i10;
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onFailure(Submit submit, Throwable th2) {
            C8673m.this.m53553m(submit, this.f40446b);
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onResponse(Submit submit, Response response) throws Throwable {
            try {
                C8673m.this.m53556p((C8624j) new Gson().fromJson(StringUtils.byte2Str(response.getBody().bytes()), C8624j.class), this.f40445a, this.f40446b, submit);
            } catch (JsonSyntaxException unused) {
                C8673m.this.m53543T("getNewUploadInfo", "400", "JsonSyntaxException");
                C8673m.this.m53538K(false);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.m$i */
    public class i implements Callback {

        /* renamed from: a */
        public final /* synthetic */ File f40448a;

        /* renamed from: b */
        public final /* synthetic */ int f40449b;

        public i(File file, int i10) {
            this.f40448a = file;
            this.f40449b = i10;
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onFailure(Submit submit, Throwable th2) {
            C8673m.this.m53553m(submit, this.f40449b);
        }

        @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
        public void onResponse(Submit submit, Response response) throws Throwable {
            try {
                C8634t c8634t = (C8634t) new Gson().fromJson(StringUtils.byte2Str(response.getBody().bytes()), C8634t.class);
                if (c8634t != null && c8634t.m53261c() == 0) {
                    C8673m.this.m53559s(c8634t, this.f40448a, this.f40449b);
                    return;
                }
                if (c8634t != null) {
                    C8673m.this.m53543T("getNewUploadInfo", String.valueOf(c8634t.m53261c()), c8634t.m53260b());
                }
                C8673m.this.m53553m(submit, this.f40449b);
            } catch (JsonSyntaxException unused) {
                C8673m.this.m53543T("getNewUploadInfo", "400", "JsonSyntaxException");
                C8673m.this.m53538K(false);
            }
        }
    }

    public C8673m(Context context, String str, String str2) {
        this.f40346e = context;
        this.f40420q = str;
        this.f40422s = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m53515V() throws Throwable {
        File file = new File(this.f40420q);
        C8628n c8628n = new C8628n();
        c8628n.m53244d(this.f40422s);
        long j10 = this.f40417n;
        if (j10 <= 0) {
            j10 = 33554432;
        }
        c8628n.m53246f(j10);
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            m53538K(false);
            return;
        }
        this.f40416m = fileArrListFiles.length;
        this.f40421r = 0L;
        for (File file2 : fileArrListFiles) {
            C8618d0 c8618d0 = new C8618d0();
            c8618d0.m53225c(ZipUtil.fileSha256(file2));
            c8618d0.m53224b(file2.length());
            arrayList.add(c8618d0);
            this.f40421r += file2.length();
        }
        m53543T("getFeedbackUploadInfo", "zipFileSize:" + this.f40421r, "");
        c8628n.m53243c(this.f40421r);
        c8628n.m53242b(fileArrListFiles.length);
        c8628n.m53245e(arrayList);
        String json = new Gson().toJson(c8628n);
        this.f40342a = new WeakReference<>(FeedbackCommonManager.INSTANCE.getFeedbackUploadInfo(this.f40346e, m53548h("POST", FeedbackWebConstants.FEEDBACK_UPLOAD_INFO, json), json, new b(file)));
    }

    /* renamed from: Y */
    public static /* synthetic */ int m53517Y(C8673m c8673m) {
        int i10 = c8673m.f40418o;
        c8673m.f40418o = i10 + 1;
        return i10;
    }

    /* renamed from: a0 */
    public static /* synthetic */ int m53518a0(C8673m c8673m) {
        int i10 = c8673m.f40419p;
        c8673m.f40419p = i10 + 1;
        return i10;
    }

    /* renamed from: G */
    public final void m53534G(File file, int i10) throws Throwable {
        C8623i c8623i = new C8623i();
        c8623i.m53232b(this.f40414k);
        String json = new Gson().toJson(c8623i);
        Map<String, String> mapM53548h = m53548h("POST", FeedbackWebConstants.FEEDBACK_NEW_UPLOAD_INFO, json);
        WeakReference<Submit> weakReference = this.f40342a;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f40342a = new WeakReference<>(FeedbackCommonManager.INSTANCE.getFeedbackNewUploadInfo(this.f40346e, mapM53548h, json, new h(file, i10)));
    }

    /* renamed from: H */
    public final void m53535H(File file, int i10, Submit submit) {
        if (submit == null) {
            return;
        }
        submit.enqueue(new i(file, i10));
    }

    /* renamed from: I */
    public final void m53536I(String str) throws Throwable {
        String strM53438a;
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN);
        String sdk2 = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID);
        this.f40411h = FaqSdk.getSdk().getSdk("country");
        String strMapToString = ZipUtil.mapToString(new Gson().toJson(new C8620f(sdk, this.f40411h)));
        try {
            strM53438a = C8668h.m53438a(FeedbackWebConstants.SERVER_DOMAIN + sdk2, strMapToString, str);
        } catch (UnsupportedEncodingException e10) {
            FaqLogger.m51840e("UploadZipTask", e10.getMessage());
            strM53438a = "";
        }
        Map<String, String> commonHeaderParameter = ZipUtil.getCommonHeaderParameter(strM53438a);
        WeakReference<Submit> weakReference = this.f40342a;
        if (weakReference != null) {
            weakReference.clear();
        }
        m53543T("getServerDomain", "0", "start");
        this.f40342a = new WeakReference<>(FeedbackCommonManager.INSTANCE.getServerDomain(this.f40346e, commonHeaderParameter, strMapToString, sdk2, new c()));
    }

    /* renamed from: J */
    public final void m53537J(String str, Map<String, String> map, File file, int i10, String str2, String str3, int i11) throws Throwable {
        WeakReference<Submit> weakReference = this.f40342a;
        if (weakReference != null) {
            weakReference.clear();
        }
        Submit fileUploadToService = FeedbackCommonManager.INSTANCE.getFileUploadToService(this.f40346e, str, map, file, str2, str3);
        e eVar = new e(file, str, i10, i11);
        m53543T("uploadFile", "0", "start");
        if (fileUploadToService != null) {
            fileUploadToService.enqueue(eVar);
            this.f40342a = new WeakReference<>(fileUploadToService);
        }
    }

    /* renamed from: K */
    public final void m53538K(boolean z10) {
        NotifyUploadZipListener notifyUploadZipListenerM53544X = m53544X();
        if (notifyUploadZipListenerM53544X != null) {
            notifyUploadZipListenerM53544X.notifyUpload(this.f40347f, z10);
        }
    }

    /* renamed from: M */
    public final void m53539M() throws Throwable {
        C8625k c8625k = new C8625k();
        c8625k.m53236c(new SimpleDateFormat(FeedbackWebConstants.TIME_FORMATS, Locale.US).format(new Date()));
        c8625k.m53235b(this.f40414k);
        String json = new Gson().toJson(c8625k);
        Map<String, String> mapM53548h = m53548h("POST", FeedbackWebConstants.FEEDBACK_NOTIFY_SUCCESS, json);
        m53543T("notifyUploadSuccess", "0", "start");
        Submit submitFeedbackNotifySuccess = FeedbackCommonManager.INSTANCE.feedbackNotifySuccess(this.f40346e, mapM53548h, json, new g());
        WeakReference<Submit> weakReference = this.f40342a;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f40342a = new WeakReference<>(submitFeedbackNotifySuccess);
    }

    /* renamed from: N */
    public final void m53540N(Response response) throws Throwable {
        String strM53255b;
        String strValueOf = "400";
        try {
            C8632r c8632r = (C8632r) new Gson().fromJson(StringUtils.byte2Str(response.getBody().bytes()), C8632r.class);
            if (c8632r == null || c8632r.m53256c() != 0) {
                if (c8632r != null) {
                    strValueOf = String.valueOf(c8632r.m53256c());
                    strM53255b = c8632r.m53255b();
                } else {
                    strM53255b = "failure";
                }
                m53543T("getServerDomain", strValueOf, strM53255b);
                m53538K(false);
                return;
            }
            m53543T("getServerDomain", "200", "success");
            this.f40412i = c8632r.m53254a();
            this.f40413j = "https://" + c8632r.m53257d();
            m53545Z();
        } catch (JsonSyntaxException unused) {
            m53543T("getServerDomain", "400", "JsonSyntaxException");
            m53538K(false);
        }
    }

    /* renamed from: O */
    public void m53541O(NotifyUploadZipListener notifyUploadZipListener) {
        if (notifyUploadZipListener != null) {
            this.f40415l = new WeakReference<>(notifyUploadZipListener);
        }
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_SECRET_KEY);
        if (!TextUtils.isEmpty(sdk)) {
            this.f40423t = false;
            m53536I(sdk);
            return;
        }
        this.f40423t = true;
        String strM56705d = C8957b.m56705d("ucs_entity_key", "", this.f40346e);
        if (!TextUtils.isEmpty(strM56705d)) {
            try {
                CredentialClient credentialClientBuild = new CredentialClient.Builder().context(this.f40346e).serCountry(FaqSdk.getSdk().getSdk("country")).build();
                this.f40424u = credentialClientBuild;
                if (credentialClientBuild == null) {
                    m53538K(false);
                    return;
                }
                Credential credentialGenCredentialFromString = credentialClientBuild.genCredentialFromString(strM56705d);
                this.f40425v = credentialGenCredentialFromString;
                if (credentialGenCredentialFromString == null) {
                    m53538K(false);
                    return;
                } else if (System.currentTimeMillis() + C5863b6.g.f26453g > this.f40425v.getExpireTime()) {
                    m53550j(1, null, 0);
                    return;
                } else {
                    m53515V();
                    return;
                }
            } catch (C14389c unused) {
            }
        }
        m53550j(1, null, 0);
    }

    /* renamed from: S */
    public final void m53542S(File file, int i10) throws Throwable {
        String strM53438a;
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN);
        String sdk2 = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID);
        C8633s c8633s = new C8633s(sdk, this.f40411h);
        c8633s.m53258a(this.f40414k);
        String strMapToString = ZipUtil.mapToString(new Gson().toJson(c8633s));
        try {
            strM53438a = C8668h.m53438a(FeedbackWebConstants.NEW_UPLOAD_INFO + sdk2, strMapToString, this.f40412i);
        } catch (UnsupportedEncodingException e10) {
            FaqLogger.m51840e("UploadZipTask", e10.getMessage());
            strM53438a = "";
        }
        Map<String, String> commonHeaderParameter = ZipUtil.getCommonHeaderParameter(strM53438a);
        WeakReference<Submit> weakReference = this.f40342a;
        if (weakReference != null) {
            weakReference.clear();
        }
        Submit newUploadInfo = FeedbackCommonManager.INSTANCE.getNewUploadInfo(this.f40346e, commonHeaderParameter, strMapToString, sdk2, this.f40413j);
        m53535H(file, i10, newUploadInfo);
        this.f40342a = new WeakReference<>(newUploadInfo);
    }

    /* renamed from: T */
    public final void m53543T(String str, String str2, String str3) throws Throwable {
        FaqLogger.print("UploadZipTask", "Request Error in " + str + " resCode is " + str2 + " reason is " + str3);
        HiAnalyticsUtils.trackSdkWebApi(str2, str3, str);
    }

    /* renamed from: X */
    public final NotifyUploadZipListener m53544X() {
        WeakReference<NotifyUploadZipListener> weakReference = this.f40415l;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: Z */
    public final void m53545Z() throws Throwable {
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN);
        String sdk2 = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID);
        File file = new File(this.f40420q);
        C8615c c8615c = new C8615c(sdk, this.f40411h);
        c8615c.m53216b(0);
        c8615c.m53222h(this.f40422s);
        c8615c.m53218d(C8664a.m53417a(this.f40346e));
        long j10 = this.f40417n;
        if (j10 <= 0) {
            j10 = 33554432;
        }
        c8615c.m53221g(j10);
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            m53538K(false);
            return;
        }
        this.f40416m = fileArrListFiles.length;
        this.f40421r = 0L;
        for (File file2 : fileArrListFiles) {
            C8618d0 c8618d0 = new C8618d0();
            c8618d0.m53225c(ZipUtil.fileSha256(file2));
            c8618d0.m53224b(file2.length());
            arrayList.add(c8618d0);
            this.f40421r += file2.length();
        }
        String strM53438a = "";
        m53543T("getUploadInfo", "zipFileSize:" + this.f40421r, "");
        c8615c.m53217c(this.f40421r);
        c8615c.m53220f(fileArrListFiles.length);
        c8615c.m53219e(arrayList);
        String strMapToString = ZipUtil.mapToString(new Gson().toJson(c8615c));
        try {
            strM53438a = C8668h.m53438a(FeedbackWebConstants.UPLOAD_INFO + sdk2, strMapToString, this.f40412i);
        } catch (UnsupportedEncodingException e10) {
            FaqLogger.m51840e("UploadZipTask", e10.getMessage());
        }
        Map<String, String> commonHeaderParameter = ZipUtil.getCommonHeaderParameter(strM53438a);
        WeakReference<Submit> weakReference = this.f40342a;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f40342a = new WeakReference<>(m53547c(sdk2, file, strMapToString, commonHeaderParameter));
    }

    /* renamed from: b0 */
    public final void m53546b0() throws Throwable {
        String strM53438a;
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN);
        String sdk2 = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID);
        C8635u c8635u = new C8635u(sdk, this.f40411h);
        String str = new SimpleDateFormat(FeedbackWebConstants.TIME_FORMATS, Locale.US).format(new Date());
        c8635u.m53263a(this.f40414k);
        c8635u.m53264b(str);
        String strMapToString = ZipUtil.mapToString(new Gson().toJson(c8635u));
        try {
            strM53438a = C8668h.m53438a(FeedbackWebConstants.NOTIFY_UPLOAD_SUCC + sdk2, strMapToString, this.f40412i);
        } catch (UnsupportedEncodingException e10) {
            FaqLogger.m51840e("UploadZipTask", e10.getMessage());
            strM53438a = "";
        }
        Map<String, String> commonHeaderParameter = ZipUtil.getCommonHeaderParameter(strM53438a);
        m53543T("notifyUploadSuccess", "0", "start");
        Submit notifyUploadSucc = FeedbackCommonManager.INSTANCE.getNotifyUploadSucc(this.f40346e, commonHeaderParameter, strMapToString, sdk2, this.f40413j, new f());
        WeakReference<Submit> weakReference = this.f40342a;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f40342a = new WeakReference<>(notifyUploadSucc);
    }

    /* renamed from: c */
    public final Submit m53547c(String str, File file, String str2, Map<String, String> map) throws Throwable {
        m53543T("getUploadInfo", "0", "start");
        return FeedbackCommonManager.INSTANCE.getUploadInfo(this.f40346e, map, str2, str, this.f40413j, new d(file));
    }

    /* renamed from: h */
    public final Map<String, String> m53548h(String str, String str2, String str3) throws Throwable {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str3) && this.f40425v != null && this.f40424u != null) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_CHANNEL);
                String strSignBase64 = new CredentialSigner.Builder().withCredential(this.f40425v).withCredentialClient(this.f40424u).build().getSignHandler().from((str + '&' + str2 + "&&" + str3 + "&appid=" + sdk + "&timestamp=" + jCurrentTimeMillis).getBytes(StandardCharsets.UTF_8)).signBase64();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CLOUDSOA-HMAC-SHA256 ");
                sb2.append("appid=");
                sb2.append(sdk);
                sb2.append(", timestamp=");
                sb2.append(jCurrentTimeMillis);
                sb2.append(", signature=\"");
                sb2.append(strSignBase64);
                sb2.append('\"');
                map.put(FeedbackWebConstants.AUTHORIZATION, sb2.toString());
                String accessKey = this.f40425v.getAccessKey();
                if (accessKey != null) {
                    map.put("X-UCS-AK", accessKey);
                }
                if (sdk != null) {
                    map.put("channelId", sdk);
                }
                String sdkVersion = FaqSdk.getSdk().getSdkVersion();
                if (sdkVersion != null) {
                    map.put(ParamConstants.Param.SDK_VERSION, sdkVersion);
                }
            } catch (C14387a | C14389c e10) {
                FaqLogger.m51840e("UploadZipTask", e10.getMessage());
            }
        }
        return map;
    }

    /* renamed from: i */
    public final void m53549i(int i10, Submit submit) throws Throwable {
        int i11 = this.f40418o;
        if (i11 == i10) {
            m53543T("uploadFile", "200", "success");
            if (this.f40423t) {
                m53539M();
                return;
            } else {
                m53546b0();
                return;
            }
        }
        if (this.f40419p + i11 > i10) {
            WeakReference<Submit> weakReference = this.f40342a;
            if (weakReference != null && weakReference.get() != null && this.f40342a.get().equals(submit)) {
                this.f40342a.get().cancel();
                this.f40342a.clear();
            }
            m53543T("uploadFile", "400", "failure");
            m53538K(false);
        }
    }

    /* renamed from: j */
    public final void m53550j(int i10, File file, int i11) {
        new Thread(new a(i10, file, i11)).start();
    }

    /* renamed from: k */
    public final void m53551k(long j10) {
        NotifyUploadZipListener notifyUploadZipListenerM53544X = m53544X();
        if (notifyUploadZipListenerM53544X != null) {
            notifyUploadZipListenerM53544X.notifyUploadAgain(j10);
        }
    }

    /* renamed from: l */
    public final void m53552l(Response response) throws Throwable {
        boolean z10;
        String strM53265a;
        String strValueOf = "400";
        try {
            C8636v c8636v = (C8636v) new Gson().fromJson(StringUtils.byte2Str(response.getBody().bytes()), C8636v.class);
            if (c8636v == null || c8636v.m53266b() != 0) {
                if (c8636v != null) {
                    strValueOf = String.valueOf(c8636v.m53266b());
                    strM53265a = c8636v.m53265a();
                } else {
                    strM53265a = "failure";
                }
                m53543T("notifyUploadSuccess", strValueOf, strM53265a);
            } else {
                this.f40345d = true;
                m53543T("notifyUploadSuccess", "200", "success");
            }
            z10 = this.f40345d;
        } catch (JsonSyntaxException unused) {
            m53543T("notifyUploadSuccess", "400", "JsonSyntaxException");
            z10 = false;
        }
        m53538K(z10);
    }

    /* renamed from: m */
    public final void m53553m(Submit submit, int i10) {
        int i11 = this.f40419p + 1;
        this.f40419p = i11;
        if (this.f40418o + i11 > i10) {
            WeakReference<Submit> weakReference = this.f40342a;
            if (weakReference != null && weakReference.get() != null && submit.equals(this.f40342a.get())) {
                this.f40342a.get().cancel();
                this.f40342a.clear();
            }
            m53538K(false);
        }
    }

    /* renamed from: n */
    public final void m53554n(C8619e c8619e) throws Throwable {
        if (c8619e != null) {
            m53543T("getUploadInfo", String.valueOf(c8619e.m53229d()), c8619e.m53228c());
        } else {
            m53543T("getUploadInfo", "400", "failure");
        }
        m53538K(false);
    }

    /* renamed from: o */
    public final void m53555o(C8619e c8619e, int i10, File file) throws Throwable {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || i10 != fileArrListFiles.length) {
            m53538K(false);
            return;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            HashMap map = new HashMap(16);
            for (Map.Entry<String, String> entry : c8619e.m53230e().get(i11).m53190a().entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
            m53537J(c8619e.m53230e().get(i11).m53192c(), map, fileArrListFiles[i11], i10, c8619e.m53230e().get(i11).m53191b(), c8619e.m53230e().get(i11).m53190a().get("Content-Type"), 0);
        }
    }

    /* renamed from: p */
    public final void m53556p(C8624j c8624j, File file, int i10, Submit submit) throws Throwable {
        if (c8624j == null) {
            m53543T("getNewUploadInfo", "400", "failure");
            m53538K(false);
            return;
        }
        String strM53233b = c8624j.m53233b();
        C8634t c8634tM53234c = c8624j.m53234c();
        if ("200".equals(strM53233b) && c8634tM53234c != null) {
            if (c8634tM53234c.m53261c() == 0) {
                m53559s(c8634tM53234c, file, i10);
                return;
            }
            m53543T("getNewUploadInfo", String.valueOf(c8634tM53234c.m53261c()), c8634tM53234c.m53260b());
            int i11 = this.f40419p + 1;
            this.f40419p = i11;
            if (this.f40418o + i11 > i10) {
                WeakReference<Submit> weakReference = this.f40342a;
                if (weakReference != null && weakReference.get() != null && submit.equals(this.f40342a.get())) {
                    this.f40342a.get().cancel();
                    this.f40342a.clear();
                }
                m53538K(false);
                return;
            }
        }
        if (!"tsms.auth.token.expired.60006".equals(strM53233b) && !"tsms.ak.restore.failed.60009".equals(strM53233b) && !"tsms.critical.exipred.60010".equals(strM53233b)) {
            m53554n(null);
        } else if (this.f40428y) {
            m53554n(null);
            this.f40428y = false;
        } else {
            m53550j(2, file, i10);
            this.f40428y = true;
        }
    }

    /* renamed from: q */
    public final void m53557q(C8626l c8626l) throws Throwable {
        if (c8626l == null) {
            m53543T("notifyUploadSuccess", "400", "failure");
        } else {
            String strM53237b = c8626l.m53237b();
            C8636v c8636vM53238c = c8626l.m53238c();
            if ("200".equals(strM53237b) && c8636vM53238c != null) {
                if (c8636vM53238c.m53266b() == 0) {
                    this.f40345d = true;
                    m53543T("notifyUploadSuccess", "200", "success");
                } else {
                    m53543T("notifyUploadSuccess", c8626l.m53237b(), c8626l.m53239d());
                }
            }
            if ("tsms.auth.token.expired.60006".equals(strM53237b) || "tsms.ak.restore.failed.60009".equals(strM53237b) || "tsms.critical.exipred.60010".equals(strM53237b)) {
                if (!this.f40427x) {
                    m53550j(3, null, 0);
                    this.f40427x = true;
                    return;
                } else {
                    m53543T("notifyUploadSuccess", c8626l.m53237b(), c8626l.m53239d());
                    this.f40427x = false;
                }
            }
        }
        m53538K(this.f40345d);
    }

    /* renamed from: r */
    public final void m53558r(C8629o c8629o, File file) throws Throwable {
        if (c8629o == null) {
            m53554n(null);
            return;
        }
        String strM53247b = c8629o.m53247b();
        C8619e c8619eM53248c = c8629o.m53248c();
        if (!"200".equals(strM53247b) || c8619eM53248c == null) {
            if (!"tsms.auth.token.expired.60006".equals(strM53247b) && !"tsms.ak.restore.failed.60009".equals(strM53247b) && !"tsms.critical.exipred.60010".equals(strM53247b)) {
                m53554n(null);
                return;
            } else if (this.f40426w) {
                m53554n(null);
                this.f40426w = false;
                return;
            } else {
                m53550j(1, null, 0);
                this.f40426w = true;
                return;
            }
        }
        if (c8619eM53248c.m53229d() == 0) {
            m53543T("getUploadInfo", "200", "success");
            this.f40414k = c8619eM53248c.m53226a();
            m53555o(c8619eM53248c, c8619eM53248c.m53230e().size(), file);
            return;
        }
        if (c8619eM53248c.m53229d() == 200002) {
            try {
                int i10 = Integer.parseInt(c8619eM53248c.m53227b().m53231a());
                if (this.f40416m > i10) {
                    this.f40417n = ((long) Math.ceil(this.f40421r / i10)) + 1048576;
                    ZipUtil.deleteFile(new File(FeedbackWebConstants.getZipFilePath(this.f40346e)));
                    m53551k(this.f40417n);
                } else {
                    m53555o(c8619eM53248c, c8619eM53248c.m53230e().size(), file);
                }
                return;
            } catch (Exception unused) {
            }
        }
        m53554n(c8619eM53248c);
    }

    /* renamed from: s */
    public final void m53559s(C8634t c8634t, File file, int i10) throws Throwable {
        this.f40414k = c8634t.m53259a();
        HashMap map = new HashMap(16);
        for (int i11 = 0; i11 < c8634t.m53262d().size(); i11++) {
            try {
                for (Map.Entry<String, String> entry : c8634t.m53262d().get(i11).m53190a().entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
                m53537J(c8634t.m53262d().get(i11).m53192c(), map, file, i10, c8634t.m53262d().get(i11).m53191b(), c8634t.m53262d().get(i11).m53190a().get("Content-Type"), 1);
            } catch (NumberFormatException e10) {
                FaqLogger.m51840e("UploadZipTask", e10.getMessage());
                return;
            }
        }
    }

    /* renamed from: t */
    public void m53560t(NotifyUploadZipListener notifyUploadZipListener) {
        if (notifyUploadZipListener != null) {
            this.f40415l = new WeakReference<>(notifyUploadZipListener);
        }
        m53545Z();
    }
}
