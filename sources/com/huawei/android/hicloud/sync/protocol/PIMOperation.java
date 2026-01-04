package com.huawei.android.hicloud.sync.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.sync.syncutil.C2984m;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import fk.C9721b;
import fk.C9722c;
import gp.C10028c;
import je.C10812z;
import org.json.JSONException;
import org.json.JSONObject;
import p514o9.C11839m;
import p709vj.C13452e;
import ro.C12612a;

/* loaded from: classes3.dex */
public class PIMOperation {

    /* renamed from: a */
    public final Context f12935a;

    /* renamed from: b */
    public String f12936b;

    /* renamed from: c */
    public String f12937c;

    public enum Operation {
        PIM,
        OPEN_SYNC_SERVICE
    }

    public PIMOperation(Context context, String str, String str2) {
        this.f12935a = context;
        this.f12936b = str;
        this.f12937c = str2;
    }

    /* renamed from: a */
    public final void m17701a() throws Throwable {
        new C2984m().m17927e(this.f12935a);
        new C2933l().checkAll();
        if (TextUtils.isEmpty(C13452e.m80781L().m80971t0())) {
            C11839m.m70687e("PIMOperation", "sendRequest: local uid is empty");
            throw new C9722c(2001, "PIMOperation sendRequest: local uid is empty");
        }
    }

    /* renamed from: b */
    public int m17702b(String str, String str2) throws Throwable {
        String message;
        Context context;
        String str3;
        String str4;
        String str5;
        int i10;
        String strM60667d;
        String str6 = ", errorReason: ";
        int iM60666c = 0;
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cmd", str);
                iM60666c = new JSONObject(m17704d("/ClientRest", jSONObject.toString(), C2929h.m17766a(), C10028c.m62182c0().m62373p(), Operation.PIM)).getJSONObject("result").getInt("code");
                strM60667d = iM60666c != 0 ? "103" : "";
                C11839m.m70688i("PIMOperation", "clearCloudData, syncModule: " + str2 + ", returnCode: " + iM60666c + ", errorReason: ");
                context = this.f12935a;
                str3 = this.f12936b;
                str4 = "ClientRest";
                str6 = this.f12937c;
                str5 = str2;
                i10 = iM60666c;
                message = "";
            } catch (C9722c e10) {
                iM60666c = e10.m60666c();
                strM60667d = e10.m60667d();
                try {
                    message = e10.getMessage();
                    C11839m.m70688i("PIMOperation", "clearCloudData, syncModule: " + str2 + ", returnCode: " + iM60666c + ", errorReason: " + message);
                    context = this.f12935a;
                    str3 = this.f12936b;
                    str4 = "ClientRest";
                    str6 = this.f12937c;
                    str5 = str2;
                    i10 = iM60666c;
                } catch (Throwable th2) {
                    th = th2;
                    int i11 = iM60666c;
                    C11839m.m70688i("PIMOperation", "clearCloudData, syncModule: " + str2 + ", returnCode: " + i11 + str6 + "");
                    C10812z.m65838g(this.f12935a, str2, i11, strM60667d, "", this.f12936b, "ClientRest", this.f12937c);
                    throw th;
                }
            } catch (JSONException unused) {
                iM60666c = 2107;
                message = "PIMOperationclearCloudData JSONException";
                C11839m.m70688i("PIMOperation", "clearCloudData, syncModule: " + str2 + ", returnCode: 2107, errorReason: PIMOperationclearCloudData JSONException");
                context = this.f12935a;
                str3 = this.f12936b;
                str4 = "ClientRest";
                str6 = this.f12937c;
                str5 = str2;
                i10 = 2107;
                strM60667d = "";
            }
            C10812z.m65838g(context, str5, i10, strM60667d, message, str3, str4, str6);
            return iM60666c;
        } catch (Throwable th3) {
            th = th3;
            strM60667d = "";
            int i112 = iM60666c;
            C11839m.m70688i("PIMOperation", "clearCloudData, syncModule: " + str2 + ", returnCode: " + i112 + str6 + "");
            C10812z.m65838g(this.f12935a, str2, i112, strM60667d, "", this.f12936b, "ClientRest", this.f12937c);
            throw th;
        }
    }

    /* renamed from: c */
    public final void m17703c(C9721b c9721b) throws C9722c {
        int iM60659c = c9721b.m60659c();
        if (iM60659c == 1199) {
            throw new C9722c(2028, c9721b.getMessage());
        }
        if (iM60659c == 9000) {
            throw new C9722c(c9721b.m60663g(), "103", c9721b.getMessage());
        }
        if (iM60659c == 9006) {
            throw new C9722c(2104, c9721b.getMessage());
        }
        switch (iM60659c) {
            case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 9002 */:
                throw new C9722c(2103, c9721b.getMessage());
            case 9003:
                throw new C9722c(2101, c9721b.getMessage());
            case ConnectionResult.SERVICE_UPDATING /* 9004 */:
                throw new C9722c(2105, c9721b.getMessage());
            default:
                throw new C9722c(HwConstants.LUNAR_YEAR_MAX, c9721b.getMessage());
        }
    }

    /* renamed from: d */
    public final String m17704d(String str, String str2, String str3, int i10, Operation operation) throws Throwable {
        String str4;
        String str5 = "";
        m17701a();
        C11839m.m70686d("PIMOperation", "Request: " + str2);
        try {
            str4 = (String) C12612a.m76107g(str, operation == Operation.OPEN_SYNC_SERVICE ? new C2927f(str3, this.f12936b, str2, this.f12937c, i10) : new C2928g(str3, this.f12936b, str2, this.f12937c, i10), null);
            try {
            } catch (C9721b e10) {
                e = e10;
                str5 = str4;
                m17703c(e);
                str4 = str5;
                C11839m.m70686d("PIMOperation", "Response: " + str4);
                return str4;
            }
        } catch (C9721b e11) {
            e = e11;
        }
        if (TextUtils.isEmpty(str4)) {
            throw new C9722c(2106, "server response is null or empty");
        }
        C11839m.m70686d("PIMOperation", "Response: " + str4);
        return str4;
    }
}
