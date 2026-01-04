package com.huawei.android.remotecontrol.http;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bf.C1175a;
import com.huawei.android.remotecontrol.config.ParamConfig;
import com.huawei.android.remotecontrol.phonefinder.C4381b;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import eg.AbstractC9473b;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import org.json.JSONObject;
import p013ah.AbstractC0200e;
import p015ak.C0213f;
import p015ak.C0241z;
import p394jf.C10813a;
import p520of.C11852b;
import p520of.C11860j;
import p520of.C11866p;
import p521og.C11877j;
import p521og.C11881n;
import p575qe.C12347f;
import p577qg.C12354d;
import p611rf.C12495c;
import p611rf.C12505m;
import p616rk.C12515a;
import p664u0.C13108a;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sg.C12796a;
import sg.C12797b;

/* renamed from: com.huawei.android.remotecontrol.http.b */
/* loaded from: classes4.dex */
public class C4344b implements Handler.Callback {

    /* renamed from: a */
    public final Context f19817a;

    /* renamed from: b */
    public final int f19818b;

    /* renamed from: c */
    public int f19819c;

    /* renamed from: d */
    public int f19820d;

    /* renamed from: e */
    public String f19821e;

    /* renamed from: com.huawei.android.remotecontrol.http.b$a */
    public class a extends AbstractC9473b {

        /* renamed from: a */
        public final /* synthetic */ Context f19822a;

        /* renamed from: b */
        public final /* synthetic */ Message f19823b;

        public a(Context context, Message message) {
            this.f19822a = context;
            this.f19823b = message;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C11852b.m70957b().m70959d(this.f19822a)) {
                C4344b.this.m26215f(this.f19823b);
            } else {
                C13981a.m83988e("HttpCallBack", "getPushSignPK fail");
                new C12796a().m76773f(C0213f.m1377a(), "-1", "getPushSignPK fail", "-1", "01012", null, "activeUnbind", null);
            }
        }
    }

    public C4344b(int i10, Context context) {
        this.f19818b = i10;
        this.f19817a = context;
    }

    /* renamed from: a */
    public final void m26210a(Context context, Message message) {
        C13981a.m83989i("HttpCallBack", "getPushPkAndRetry");
        C12515a.m75110o().m75175e(new a(context, message), false);
    }

    /* renamed from: b */
    public void m26211b(Message message) throws JSONException, IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("HttpCallBack", "handleHttpCallbackMsg");
        int i10 = this.f19818b;
        if (i10 == 3008) {
            m26214e(message);
            return;
        }
        if (i10 == 3009) {
            m26212c(message, this.f19819c);
            return;
        }
        if (i10 == 3015) {
            m26216g(message);
            return;
        }
        if (i10 == 3016) {
            m26215f(message);
            return;
        }
        if (i10 == 3019) {
            m26217h(message);
        } else if (i10 == 3020) {
            C10813a.m65855g(message, this.f19817a);
        } else {
            if (i10 != 3114) {
                return;
            }
            m26213d(message);
        }
    }

    /* renamed from: c */
    public void m26212c(Message message, int i10) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("HttpCallBack", "HttpCallback->handleMessage->handleMsgLogoffDeregistration");
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83990w("HttpCallBack", "result:" + iM1685c);
        C12797b c12797b = new C12797b();
        C12796a c12796a = new C12796a();
        if (200 == iM1685c) {
            String string = message.getData().getString("response_info");
            int iM26233d = C4347e.m26233d(string);
            C13981a.m83989i("HttpCallBack", "handleMsg Logoff Deregistration resultCode=" + iM26233d);
            if (iM26233d == 0) {
                C1175a.m7398t(false, this.f19817a);
                C12347f.m74285n().m74300l(this.f19817a);
                C11860j.m71090w0();
                C12354d.m74326B(string);
                c12797b.m76784j(this.f19817a, "HttpCallBack", "0", "handleMsgLogoffDeregistration is success", null, "01012", null, "inActive", true);
                return;
            }
            if (401 == iM26233d) {
                C11860j.m71070m0();
                c12797b.m76782h(this.f19817a, "HttpCallBack", "001_3004", iM26233d, "handleMsgLogoffDeregistration is fail,resultCode" + iM26233d, null, "01012", null, "inActive", true);
                c12796a.m76773f(this.f19817a, String.valueOf(iM26233d), "close switch auth fail:" + iM26233d, "01012", "inActive", null, "close switch responseInfo", null);
                return;
            }
            C13981a.m83988e("HttpCallBack", "handleMsgLogoffDeregistration fail");
            c12797b.m76782h(this.f19817a, "HttpCallBack", "001_3004", iM26233d, "handleMsgLogoffDeregistration is fail,resultCode" + iM26233d, null, "01012", null, "inActive", true);
            c12796a.m76773f(this.f19817a, String.valueOf(iM26233d), "close switch fail:" + iM26233d, "01012", "inActive", null, "close switch responseInfo", null);
            iM1685c = iM26233d;
        } else {
            C13981a.m83988e("HttpCallBack", "report error=" + iM1685c);
            c12797b.m76784j(this.f19817a, "HttpCallBack", "001_3003", "handleMsgLogoffDeregistration is fail,result" + iM1685c, null, "01012", null, "inActive", true);
            c12796a.m76773f(this.f19817a, String.valueOf(iM1685c), "close switch other fail, result:" + iM1685c, "01012", "inActive", null, "close switch responseInfo", null);
        }
        if (101 == i10) {
            C4381b.m26441d().m26439b(this.f19817a);
        }
        C11860j.m71072n0(iM1685c);
    }

    /* renamed from: d */
    public final void m26213d(Message message) {
        C13981a.m83989i("HttpCallBack", "handlePushResultReport");
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        if (200 == iM1685c) {
            C13981a.m83989i("HttpCallBack", "handlePushResultReport resultCode =" + C4347e.m26233d(message.getData().getString("response_info")));
            if ("openLostPattern".equals(this.f19821e)) {
                C13981a.m83989i("HttpCallBack", "setNeedReportLostMode false");
                C11877j.m71203D0(this.f19817a, false);
                C11877j.m71201C0(this.f19817a, -1);
                return;
            }
            return;
        }
        C13981a.m83988e("HttpCallBack", "handlePushResultReport error = " + iM1685c);
        if ("openLostPattern".equals(this.f19821e)) {
            C13981a.m83989i("HttpCallBack", "setNeedReportLostMode true");
            C11877j.m71203D0(this.f19817a, true);
            C11877j.m71201C0(this.f19817a, this.f19820d);
        }
        new C12797b().m76782h(this.f19817a, "HttpCallBack", "001_3003", this.f19820d, "handlePushResultReport failed, result:" + this.f19820d, null, this.f19821e, null, "pushLossMode", true);
    }

    /* renamed from: e */
    public void m26214e(Message message) throws JSONException, IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("HttpCallBack", "HttpCallback->handleMessage->MSG_QUERY_DEVICE_ACTIVE");
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        if (200 != iM1685c) {
            C13981a.m83989i("HttpCallBack", "handleMessage->phoneFinderActivationConnectFail:" + iM1685c);
            C13108a.m78878b(this.f19817a).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_CONNET_FAIL"));
            C11860j.m71002J0("query_active_status", "QUERY_ACTIVATION_PAGE", "handleQueryDeviceActive fail, result is not 200 ", null);
            return;
        }
        String string = message.getData().getString("response_info");
        C13981a.m83987d("HttpCallBack", "handleQueryDeviceActive--responseInfo=" + string);
        int iM26233d = C4347e.m26233d(string);
        C13981a.m83989i("HttpCallBack", "report code = " + iM26233d);
        if (iM26233d == 0 || 3001 == iM26233d) {
            m26218i(string, iM26233d);
        } else if (401 == iM26233d) {
            C13108a.m78878b(this.f19817a).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_CONNET_FAIL"));
            C13108a.m78878b(this.f19817a).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_QUERY_ACTIVE_AUTH_FAILE"));
            C13981a.m83989i("HttpCallBack", "updateDeviceTicket: queryActive");
            new C12505m().m75087f();
        } else if (14 == iM26233d) {
            Bundle bundle = new Bundle();
            bundle.putString(HwPayConstant.KEY_SITE_ID, C11881n.m71367q(string));
            C11860j.m71063j0(bundle);
        } else if (15 == iM26233d) {
            C13981a.m83989i("HttpCallBack", "handleMessage->phoneFinderQueryStatusInMigrating");
            C13108a.m78878b(this.f19817a).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_DATA_MIGRATING"));
        } else if (3005 == iM26233d || 3004 == iM26233d) {
            Intent intent = new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_QUERY_RESULT_CODE");
            intent.putExtra(MapKeyNames.RESULT_CODE, iM26233d);
            C13108a.m78878b(C12347f.m74285n().m74301m()).m78881d(intent);
        } else {
            C13981a.m83989i("HttpCallBack", "handleMessage->phoneFinderActivationConnectFail:" + iM1685c);
            C13108a.m78878b(this.f19817a).m78881d(new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_CONNET_FAIL"));
        }
        C11860j.m71002J0("query_active_status", "QUERY_ACTIVATION_PAGE", "handleQueryDeviceActive, resultCode: " + iM26233d + ", resultDesc: " + C4347e.m26234e(string), null);
    }

    /* renamed from: f */
    public void m26215f(Message message) {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i("HttpCallBack", "HttpCallback->handleMessage->handleUnbind,result:" + iM1685c);
        C12797b c12797b = new C12797b();
        if (200 != iM1685c) {
            C13981a.m83988e("HttpCallBack", "report error3=" + iM1685c);
            C11860j.m71086u0(995);
            c12797b.m76784j(this.f19817a, "HttpCallBack", "001_3003", "handleUnbind RSA is fail,result" + iM1685c, null, "01012", null, "activeUnbind", true);
            return;
        }
        String string = message.getData().getString("response_info");
        int iM26233d = C4347e.m26233d(string);
        C13981a.m83989i("HttpCallBack", "report code = " + iM26233d);
        if (iM26233d == 0) {
            String challengeString = AbstractC12139d.m72766e(this.f19817a).getChallengeString();
            String deviceTicket = AbstractC12139d.m72766e(this.f19817a).getDeviceTicket();
            String strM74996b = C12495c.m74996b(string);
            String strM74995a = C12495c.m74995a(string);
            String strM74997c = C12495c.m74997c(string);
            if (!C11852b.m70957b().m70960e(C0213f.m1377a())) {
                m26210a(C0213f.m1377a(), message);
                return;
            }
            if (AbstractC0200e.m1105d(challengeString, deviceTicket, strM74996b, strM74995a, strM74997c)) {
                C11860j.m70999I(3019);
                new C12796a().m76773f(C0213f.m1377a(), "0", "checkResult success", "0", "01012", null, "activeUnbind", null);
                c12797b.m76784j(this.f19817a, "HttpCallBack", "0", "handleUnbind RSA is success", null, "01012", null, "activeUnbind", false);
                return;
            }
            C11860j.m71086u0(996);
            new C12796a().m76773f(C0213f.m1377a(), "001_3004", "checkResult error=" + TextUtils.isEmpty(challengeString) + TextUtils.isEmpty(deviceTicket) + TextUtils.isEmpty(strM74996b) + strM74997c, "001_3004", "01012", null, "activeUnbind", null);
            Context context = this.f19817a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("handleUnbind RSA is fail,resultCode");
            sb2.append(iM26233d);
            c12797b.m76782h(context, "HttpCallBack", "001_3004", iM26233d, sb2.toString(), null, "01012", null, "activeUnbind", true);
            return;
        }
        if (401 == iM26233d) {
            C11860j.m71086u0(401);
            c12797b.m76782h(this.f19817a, "HttpCallBack", "001_3004", iM26233d, "handleUnbind is fail,resultCode" + iM26233d, null, "01012", null, "activeUnbind", true);
            return;
        }
        if (2 == iM26233d) {
            C11860j.m71086u0(2);
            c12797b.m76782h(this.f19817a, "HttpCallBack", "001_3004", iM26233d, "handleUnbind RSA is fail,resultCode" + iM26233d, null, "01012", null, "activeUnbind", true);
            return;
        }
        if (991 == iM26233d) {
            C11860j.m71086u0(991);
            c12797b.m76782h(this.f19817a, "HttpCallBack", "001_3004", iM26233d, "handleUnbind RSA is fail,resultCode" + iM26233d, null, "01012", null, "activeUnbind", true);
            return;
        }
        if (992 == iM26233d) {
            C11860j.m71086u0(992);
            c12797b.m76782h(this.f19817a, "HttpCallBack", "001_3004", iM26233d, "handleUnbind RSA is fail,resultCode" + iM26233d, null, "01012", null, "activeUnbind", true);
            return;
        }
        if (994 == iM26233d) {
            C11860j.m71086u0(994);
            c12797b.m76782h(this.f19817a, "HttpCallBack", "001_3004", iM26233d, "handleUnbind RSA is fail,resultCode" + iM26233d, null, "01012", null, "activeUnbind", true);
            return;
        }
        C11860j.m71086u0(996);
        c12797b.m76782h(this.f19817a, "HttpCallBack", "001_3004", iM26233d, "handleUnbind RSA is fail,resultCode" + iM26233d, null, "01012", null, "activeUnbind", true);
    }

    /* renamed from: g */
    public void m26216g(Message message) throws JSONException {
        String string;
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i("HttpCallBack", "HttpCallback->handleMessage->handleUnbindReport,result:" + iM1685c);
        C12797b c12797b = new C12797b();
        if (200 != iM1685c) {
            C13981a.m83988e("HttpCallBack", "report error5=" + iM1685c);
            C11860j.m71094y0();
            c12797b.m76784j(this.f19817a, "HttpCallBack", "001_3003", "handleUnbindReport is fail,result" + iM1685c, null, "01012", null, "activeUnbind", true);
            return;
        }
        String string2 = message.getData().getString("response_info");
        int iM26233d = C4347e.m26233d(string2);
        C13981a.m83989i("HttpCallBack", "HttpCallback->handleMessage->handleUnbindReport,report:" + iM26233d);
        if (iM26233d != 0) {
            C11860j.m71094y0();
            c12797b.m76782h(this.f19817a, "HttpCallBack", "001_3004", iM26233d, "handleUnbindReport is fail,resultCode" + iM26233d, null, "01012", null, "activeUnbind", true);
            return;
        }
        C13981a.m83987d("HttpCallBack", "HttpCallback->handleMessage->handleUnbindReport,responseInfo=" + string2);
        try {
            string = new JSONObject(string2).getString("unbandingCode");
        } catch (JSONException unused) {
            C13981a.m83988e("HttpCallBack", "handle MSG_REMOTE_UNBINDREPORT JSONException");
            string = null;
        }
        if (string == null) {
            C13981a.m83988e("HttpCallBack", "handleUnbindReport--code == null");
            C11860j.m71094y0();
            c12797b.m76784j(this.f19817a, "HttpCallBack", "001_3003", "handleUnbindReport is fail,get unbancode error", null, "01012", null, "activeUnbind", true);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("unbandingCode", string);
            C11877j.m71310u1(C12347f.m74285n().m74301m(), string);
            C11860j.m71096z0(bundle);
            c12797b.m76784j(this.f19817a, "HttpCallBack", "0", "handleUnbindReport is success", null, "01012", null, "activeUnbind", true);
        }
    }

    /* renamed from: h */
    public void m26217h(Message message) {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        C13981a.m83989i("HttpCallBack", "HttpCallback->handleUnbindResultReport->result=" + iM1685c);
        C12797b c12797b = new C12797b();
        if (200 != iM1685c) {
            C13981a.m83988e("HttpCallBack", "report error1=" + iM1685c);
            C11860j.m71086u0(995);
            c12797b.m76784j(this.f19817a, "HttpCallBack", "001_3003", "handleUnbindResultReport is fail,result" + iM1685c, null, "01012", null, "activeUnbind", true);
            return;
        }
        String string = message.getData().getString("response_info");
        int iM26233d = C4347e.m26233d(string);
        C13981a.m83989i("HttpCallBack", "HttpCallback->handleUnbindResultReport->resultCode=" + iM26233d);
        if (iM26233d == 0) {
            C12354d.m74326B(string);
            C11860j.m70984A0();
            C12347f.m74285n().m74300l(this.f19817a);
            c12797b.m76784j(this.f19817a, "HttpCallBack", "0", "handleUnbindResultReport is success", null, "01012", null, "activeUnbind", true);
            return;
        }
        C11860j.m71086u0(996);
        c12797b.m76782h(this.f19817a, "HttpCallBack", "001_3004", iM26233d, "handleUnbindResultReport is fail,resultCode" + iM26233d, null, "01012", null, "activeUnbind", true);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws JSONException, IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m26211b(message);
        return true;
    }

    /* renamed from: i */
    public final void m26218i(String str, int i10) throws IllegalAccessException, JSONException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (!jSONObject2.has("params")) {
                C13981a.m83987d("HttpCallBack", "json has no params");
                return;
            }
            JSONObject jSONObject3 = (JSONObject) jSONObject2.get("params");
            C13981a.m83987d("HttpCallBack", "handleQueryDeviceActive--jsonParams=" + jSONObject3);
            if (jSONObject3 == null) {
                C13981a.m83987d("HttpCallBack", "jsonParams is null");
                return;
            }
            C11866p.m71123v(jSONObject3);
            ParamConfig.getInstance().upDateParam(jSONObject3);
            if (jSONObject3.getInt("active") == 0) {
                C13981a.m83987d("HttpCallBack", "query result: device is not active");
                C11860j.m71088v0(this.f19819c);
                C11877j.m71306t0(this.f19817a, C11860j.m71023U() ? 2 : 4);
                C12354d.m74327C(jSONObject3, "proactive");
                return;
            }
            int i11 = this.f19819c;
            if (3 != i11 && 5 != i11 && 9 != i11) {
                C13981a.m83989i("HttpCallBack", "scene code is not active");
                return;
            }
            if (5 == i11 || 9 == i11) {
                Intent intent = new Intent("com.huawei.android.hicloud.intent.PHONEFINDER_ACTIVATION_QUERY_INFO_SUCCESS");
                intent.putExtra("params", jSONObject3.toString());
                intent.putExtra(MapKeyNames.RESULT_CODE, i10);
                C13108a.m78878b(C12347f.m74285n().m74301m()).m78881d(intent);
            }
            int i12 = jSONObject3.getInt("xyFlag");
            String string = jSONObject3.getString("unbandingCode");
            Bundle bundle = new Bundle();
            bundle.putString("unbandingCode", string);
            if (TextUtils.isEmpty(string) || "null".equals(string)) {
                C13981a.m83989i("HttpCallBack", "unbindCode is empty");
                bundle.putString("unbandingCode", "");
                C11860j.m71096z0(bundle);
            } else if (TextUtils.isEmpty(AbstractC12139d.m72766e(this.f19817a).getChallengeString())) {
                C13981a.m83989i("HttpCallBack", "challenge is empty");
                bundle.putString("unbandingCode", "");
                C11860j.m71096z0(bundle);
            } else if (i12 == 1) {
                C13981a.m83989i("HttpCallBack", "xyFlag pass");
                bundle.putString("unbandingCode", string);
                C11860j.m71060i0(bundle);
            } else {
                C13981a.m83989i("HttpCallBack", "return unbindCode");
                bundle.putString("unbandingCode", string);
                C11860j.m71096z0(bundle);
            }
            if (!jSONObject3.has("accountInfo") || (jSONObject = (JSONObject) jSONObject3.get("accountInfo")) == null) {
                return;
            }
            String string2 = jSONObject.has("mobile") ? jSONObject.getString("mobile") : "";
            String string3 = jSONObject.has("email") ? jSONObject.getString("email") : "";
            String string4 = jSONObject.has("petalMail") ? jSONObject.getString("petalMail") : "";
            bundle.putString("mobile", string2);
            bundle.putString("email", string3);
            bundle.putString("petalMail", string4);
            C11860j.m71057h0(bundle);
        } catch (JSONException unused) {
            C13981a.m83988e("HttpCallBack", "handle MSG_QUERY_DEVICE_ACTIVE JSONException");
        }
    }

    public C4344b(int i10, int i11, Context context) {
        this.f19818b = i10;
        this.f19819c = i11;
        this.f19817a = context;
    }

    public C4344b(int i10, int i11, String str, Context context) {
        this.f19818b = i10;
        this.f19820d = i11;
        this.f19821e = str;
        this.f19817a = context;
    }
}
