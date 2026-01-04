package p400jl;

import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.hicloud.cloudbackup.server.model.BaseRequest;
import com.huawei.hicloud.cloudbackup.server.model.BaseResponse;
import com.huawei.hicloud.cloudbackup.server.model.DeviceDeleteListReq;
import com.huawei.hicloud.cloudbackup.server.model.DeviceDeleteListResp;
import com.huawei.hicloud.cloudbackup.server.model.QueryDeviceDeleteSwitchResp;
import com.huawei.hicloud.cloudbackup.server.model.UpdateDeleteSwitchReq;
import com.huawei.hicloud.notification.util.CheckAppStatus;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hicloud.request.cbs.bean.CBSDataBackup;
import com.huawei.hicloud.request.cbs.bean.CBSFilterModule;
import com.huawei.hicloud.request.cbs.bean.CBSInitParam;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import mo.C11501a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p618rm.C12590s0;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p711vl.C13466f;
import p711vl.C13467g;
import p746wn.C13622a;
import p837z9.C14163d;
import ro.C12612a;
import tm.C13040c;

/* renamed from: jl.a */
/* loaded from: classes6.dex */
public class C10897a {

    /* renamed from: a */
    public String f51731a;

    public C10897a(String str) {
        this.f51731a = str;
    }

    /* renamed from: b */
    public static <T> T m65889b(String str, Class<T> cls, String str2) throws C9721b {
        try {
            return (T) new Gson().fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            throw new C9721b(3107, "json err = " + str, str2);
        }
    }

    /* renamed from: a */
    public CBSInitParam m65890a(boolean z10) throws Throwable {
        String strReplace;
        BaseRequest baseRequest;
        String strM65902n = m65902n();
        if (z10) {
            strReplace = strM65902n.replace("/CloudBackup/ClientServlet", "/CloudBackup/clientService/autoBackupInit");
            baseRequest = new BaseRequest(0, "autoBackupInit");
        } else {
            strReplace = strM65902n.replace("/CloudBackup/ClientServlet", "/CloudBackup/clientService/manBackupInit");
            baseRequest = new BaseRequest(0, "manBackupInit");
        }
        String strM65897i = m65897i(strReplace, baseRequest);
        BaseResponse baseResponse = (BaseResponse) m65889b(strM65897i, BaseResponse.class, baseRequest.getInfo());
        int result = baseResponse.getResult();
        if (result != 703) {
            if (result == 0) {
                return m65901m(strM65897i, baseResponse, baseRequest);
            }
            throw new C9721b(3107, result, baseResponse.toString(), baseRequest.getInfo());
        }
        C11839m.m70687e("CloudBackupServer", strReplace + " " + baseResponse.toString());
        try {
            JSONObject jSONObject = new JSONObject(strM65897i).getJSONObject("params");
            if (!jSONObject.isNull("gradeCode")) {
                String string = jSONObject.getString("gradeCode");
                C13466f.m81073d().m81084l("gradeCode", string);
                C11839m.m70688i("CloudBackupServer", "backupInitReq user_frequency_unavailable  , gradeCode = " + string);
                C12590s0.m75926y2(this.f51731a, string, "backupInitReq user_frequency_unavailable");
                int gradeMinFrequency = CloudBackupUtil.getGradeMinFrequency(string);
                if (C13467g.m81086c().m81091f() < gradeMinFrequency) {
                    C11839m.m70688i("CloudBackupServer", "user member expires or degrade, reset user frequency: " + gradeMinFrequency);
                    C13467g.m81086c().m81098m(gradeMinFrequency);
                    Message message = new Message();
                    message.what = 33016;
                    CBCallBack.getInstance().sendMessage(message);
                }
            }
        } catch (JSONException unused) {
            C11839m.m70687e("CloudBackupServer", "parse gradeCode and frequency error");
        }
        throw new C9721b(3113, baseResponse.toString(), baseRequest.getInfo());
    }

    /* renamed from: c */
    public DeviceDeleteListResp m65891c(DeviceDeleteListReq deviceDeleteListReq) throws C9721b {
        DeviceDeleteListResp deviceDeleteListResp = (DeviceDeleteListResp) m65889b(m65897i(m65902n().replace("/CloudBackup/ClientServlet", "/CloudBackup/clientService/deviceDeleteList"), deviceDeleteListReq), DeviceDeleteListResp.class, deviceDeleteListReq.getInfo());
        int result = deviceDeleteListResp.getResult();
        if (result == 0) {
            return deviceDeleteListResp;
        }
        throw new C9721b(3107, result, deviceDeleteListResp.toString(), deviceDeleteListReq.getInfo());
    }

    /* renamed from: d */
    public QueryDeviceDeleteSwitchResp m65892d(BaseRequest baseRequest) throws C9721b {
        QueryDeviceDeleteSwitchResp queryDeviceDeleteSwitchResp = (QueryDeviceDeleteSwitchResp) m65889b(m65897i(m65902n().replace("/CloudBackup/ClientServlet", "/CloudBackup/clientService/deviceDeleteSwitchGet"), baseRequest), QueryDeviceDeleteSwitchResp.class, baseRequest.getInfo());
        int result = queryDeviceDeleteSwitchResp.getResult();
        if (result == 0) {
            return queryDeviceDeleteSwitchResp;
        }
        throw new C9721b(3107, result, queryDeviceDeleteSwitchResp.toString(), baseRequest.getInfo());
    }

    /* renamed from: e */
    public final void m65893e(CBSInitParam cBSInitParam, JSONObject jSONObject, String str) throws JSONException, C9721b {
        if (jSONObject.has("galleryLibBackup")) {
            JSONArray jSONArray = jSONObject.getJSONArray("galleryLibBackup");
            C11839m.m70688i("CloudBackupServer", "galleryLibBackup = " + jSONArray.toString());
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                CBSDataBackup cBSDataBackup = (CBSDataBackup) m65889b(jSONArray.getString(i10), CBSDataBackup.class, str);
                if (cBSDataBackup != null) {
                    cBSInitParam.addGalleryLibBackup(cBSDataBackup);
                }
            }
        }
    }

    /* renamed from: f */
    public final void m65894f(CBSInitParam cBSInitParam, JSONObject jSONObject, String str) throws JSONException, C9721b {
        if (jSONObject.has("mediaLibBackup")) {
            JSONArray jSONArray = jSONObject.getJSONArray("mediaLibBackup");
            C11839m.m70688i("CloudBackupServer", "mediaLibBackup = " + jSONArray.toString());
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                CBSDataBackup cBSDataBackup = (CBSDataBackup) m65889b(jSONArray.getString(i10), CBSDataBackup.class, str);
                if (cBSDataBackup != null) {
                    cBSInitParam.addMediaLibBackup(cBSDataBackup);
                }
            }
        }
    }

    /* renamed from: g */
    public final void m65895g(CBSInitParam cBSInitParam, JSONObject jSONObject, String str) throws JSONException, C9721b {
        if (jSONObject.has("dataBackupList")) {
            JSONArray jSONArray = jSONObject.getJSONArray("dataBackupList");
            C11839m.m70688i("CloudBackupServer", "dataBackupList = " + jSONArray.toString());
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                CBSDataBackup cBSDataBackup = (CBSDataBackup) m65889b(jSONArray.getString(i10), CBSDataBackup.class, str);
                if (cBSDataBackup != null) {
                    cBSInitParam.addDataBackupList(cBSDataBackup);
                }
            }
        }
    }

    /* renamed from: h */
    public final void m65896h(CBSInitParam cBSInitParam, JSONObject jSONObject, String str) throws JSONException, C9721b {
        if (jSONObject.has("apkDataBackupList")) {
            JSONArray jSONArray = jSONObject.getJSONArray("apkDataBackupList");
            C11839m.m70688i("CloudBackupServer", "apkDataBackupList = " + jSONArray.toString());
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                CBSDataBackup cBSDataBackup = (CBSDataBackup) m65889b(jSONArray.getString(i10), CBSDataBackup.class, str);
                if (cBSDataBackup != null) {
                    cBSInitParam.addApkDataBackupList(cBSDataBackup);
                }
            }
        }
    }

    /* renamed from: i */
    public final String m65897i(String str, BaseRequest baseRequest) throws Throwable {
        new CheckAppStatus().checkAll();
        String info = baseRequest.getInfo();
        String string = baseRequest.toString();
        C11839m.m70686d("CloudBackupServer", info + " " + string);
        C11060c c11060cM66626a = C11058a.m66626a(this.f51731a, info, C13452e.m80781L().m80971t0());
        try {
            String strM66661q = c11060cM66626a.m66661q();
            int i10 = 1;
            while (true) {
                String cmdServicIdName = CBSBaseReq.getCmdServicIdName(baseRequest.getCmd());
                String strM65899k = TextUtils.isEmpty(cmdServicIdName) ? m65899k(info) : m65900l(info, cmdServicIdName);
                try {
                    try {
                        C11839m.m70688i("CloudBackupServer", str + " " + info + " x-hw-trace-id = " + strM66661q);
                        String str2 = (String) C12612a.m76107g(str, new C11501a(strM65899k, info, string, strM66661q), c11060cM66626a);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(info);
                        sb2.append(" ");
                        sb2.append(str2);
                        C11839m.m70686d("CloudBackupServer", sb2.toString());
                        m65903o(str, info, str2);
                        return str2;
                    } catch (C9721b e10) {
                        if (1202 != e10.m60659c()) {
                            break;
                        }
                        int i11 = i10 + 1;
                        if (i10 >= 3) {
                            break;
                        }
                        C11839m.m70687e("CloudBackupServer", " [AT OPERATION] at invalid retry: " + i11);
                        C13195l.m79272J().m79325o0(strM65899k);
                        i10 = i11;
                        throw e10;
                    }
                } catch (Throwable th2) {
                    C11839m.m70687e("CloudBackupServer", info + " " + th2.getMessage());
                    throw new C9721b(4001, th2.getMessage(), info);
                }
            }
            throw e10;
        } catch (C9721b e11) {
            C9721b c9721bM65898j = m65898j(info, e11);
            C11839m.m70687e("CloudBackupServer", info + " " + c9721bM65898j.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("102_");
            sb3.append(c9721bM65898j.m60659c());
            c11060cM66626a.m66665u(sb3.toString());
            c11060cM66626a.m66635A(c9721bM65898j.toString());
            C13622a.m81970p(c11060cM66626a, null, false);
            throw c9721bM65898j;
        }
    }

    /* renamed from: j */
    public final C9721b m65898j(String str, C9721b c9721b) {
        int iM60659c = c9721b.m60659c();
        if (iM60659c != 1102 && iM60659c != 1107) {
            if (iM60659c == 1199) {
                return new C9721b(1104, c9721b.getMessage(), str);
            }
            if (iM60659c != 3107 && iM60659c != 3309) {
                if (iM60659c == 9005) {
                    return new C9721b(3105, c9721b.getMessage(), str);
                }
                if (iM60659c != 1201 && iM60659c != 1202 && iM60659c != 3100 && iM60659c != 3101) {
                    if (iM60659c == 4000 || iM60659c == 4001) {
                        return new C9721b(3107, c9721b.m60663g(), str + " " + c9721b.m60663g() + " " + c9721b.getMessage(), str);
                    }
                    switch (iM60659c) {
                        case ConnectionResult.NETWORK_ERROR /* 9000 */:
                            return new C9721b(3106, c9721b.m60663g(), str + " " + c9721b.m60663g() + " " + c9721b.getMessage(), str);
                        case ConnectionResult.RESOLUTION_REQUIRED /* 9001 */:
                            return new C9721b(NotifyErr.NOTIFY_MALFORMEDURL, c9721b.getMessage(), str);
                        case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 9002 */:
                            return new C9721b(3103, c9721b.getMessage(), str);
                        case 9003:
                            return new C9721b(3104, c9721b.getMessage(), str);
                        default:
                            return new C9721b(3108, c9721b.getMessage(), str);
                    }
                }
            }
        }
        return c9721b;
    }

    /* renamed from: k */
    public final String m65899k(String str) throws C9721b {
        try {
            return C13195l.m79272J().m79344y("CloudBackup1", str);
        } catch (C13194k e10) {
            C11839m.m70687e("CloudBackupServer", "onAccessToken error: " + e10.toString());
            if (e10.m79269b() == 1199) {
                throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
            }
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            C11839m.m70687e("CloudBackupServer", "onAccessToken error: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: l */
    public final String m65900l(String str, String str2) throws C9721b {
        try {
            return C13195l.m79272J().m79290C(str2, "CloudBackup2", str);
        } catch (C13194k e10) {
            C11839m.m70687e("CloudBackupServer", "onAccessTokenWithId error: " + e10.toString());
            if (e10.m79269b() == 1199) {
                throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
            }
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            C11839m.m70687e("CloudBackupServer", "onAccessTokenWithId error: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: m */
    public final CBSInitParam m65901m(String str, BaseResponse baseResponse, BaseRequest baseRequest) throws JSONException, C9721b {
        try {
            CBSInitParam cBSInitParam = new CBSInitParam();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("params");
            if (!jSONObject.isNull("gradeCode")) {
                cBSInitParam.setGradeCode(jSONObject.getString("gradeCode"));
            }
            if (!jSONObject.isNull("backupTimes")) {
                cBSInitParam.setBackupTimes(jSONObject.getString("backupTimes"));
            }
            cBSInitParam.setCycle(jSONObject.getInt("cycle"));
            cBSInitParam.setReminderCycle(jSONObject.getInt("reminderCycle"));
            cBSInitParam.setTimes(jSONObject.getInt("times"));
            if (!jSONObject.isNull("nextBackupTime")) {
                cBSInitParam.setNextBackupTime(jSONObject.getInt("nextBackupTime"));
            }
            if (!jSONObject.isNull("delayedStartTime")) {
                cBSInitParam.setDelayedStartTime(jSONObject.getInt("delayedStartTime"));
            }
            if (!jSONObject.isNull("breakedTime")) {
                cBSInitParam.setBreakedTime(jSONObject.getInt("breakedTime"));
            }
            JSONArray jSONArray = jSONObject.getJSONArray("appsWhiteList");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                String string = jSONObject2.getString("appPackageName");
                ArrayList arrayList = new ArrayList();
                if (!jSONObject2.isNull("bakFilePath")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("bakFilePath");
                    for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                        arrayList.add(jSONArray2.getString(i11));
                    }
                }
                cBSInitParam.addAppsWhiteList(string, arrayList);
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray("appsBlackList");
            C11839m.m70688i("CloudBackupServer", "appsBlacks = " + jSONArray3.toString());
            for (int i12 = 0; i12 < jSONArray3.length(); i12++) {
                cBSInitParam.addAppsBlackList(jSONArray3.getJSONObject(i12).getString("appPackageName"));
            }
            if (jSONObject.has("moduleBlackList")) {
                JSONArray jSONArray4 = jSONObject.getJSONArray("moduleBlackList");
                C11839m.m70688i("CloudBackupServer", "moduleBlackList = " + jSONArray4.toString());
                for (int i13 = 0; i13 < jSONArray4.length(); i13++) {
                    cBSInitParam.addModuleBlackList((CBSFilterModule) m65889b(jSONArray4.getString(i13), CBSFilterModule.class, baseRequest.getInfo()));
                }
            }
            m65896h(cBSInitParam, jSONObject, baseResponse.getInfo());
            m65895g(cBSInitParam, jSONObject, baseResponse.getInfo());
            m65894f(cBSInitParam, jSONObject, baseResponse.getInfo());
            m65893e(cBSInitParam, jSONObject, baseResponse.getInfo());
            return cBSInitParam;
        } catch (JSONException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, e10.getMessage(), "CBSService_initParamReq");
        }
    }

    /* renamed from: n */
    public final String m65902n() throws C9721b {
        if (C10028c.m62182c0().m62221H1()) {
            return C13040c.m78609F().m78665r();
        }
        throw new C9721b(1101, "terms is not confirmed.");
    }

    /* renamed from: o */
    public final void m65903o(String str, String str2, String str3) throws C9721b {
        if (str3 == null || str3.isEmpty()) {
            throw new C9721b(3101, "response is null", str2);
        }
        BaseResponse baseResponse = (BaseResponse) m65889b(str3, BaseResponse.class, str2);
        int result = baseResponse.getResult();
        if (result == 401) {
            C11839m.m70687e("CloudBackupServer", str2 + " " + baseResponse.toString());
            C13452e.m80781L().m80980v1();
            C13452e.m80781L().m80972t1();
            throw new C9721b(3100, baseResponse.toString(), str2);
        }
        if (result == 402) {
            throw new C9721b(1202, baseResponse.toString(), str2);
        }
        if (result == 701 || result == 702) {
            C11839m.m70687e("CloudBackupServer", str + " " + baseResponse.toString());
            throw new C9721b(3107, result, baseResponse.toString(), str2);
        }
        if (result == 708) {
            C11839m.m70687e("CloudBackupServer", str + " " + baseResponse.toString());
            UserKeyUtils.getInstance().clearUserKeyByBusinessType(1);
            throw new C9721b(3107, result, baseResponse.toString(), str2);
        }
        if (result == 800 || result == 801) {
            C11839m.m70687e("CloudBackupServer", str + " " + baseResponse.toString());
            C14163d.m84990g().m85019y(result);
            throw new C9721b(3309, baseResponse.toString(), str2);
        }
    }

    /* renamed from: p */
    public void m65904p(UpdateDeleteSwitchReq updateDeleteSwitchReq) throws C9721b {
        BaseResponse baseResponse = (BaseResponse) m65889b(m65897i(m65902n().replace("/CloudBackup/ClientServlet", "/CloudBackup/clientService/deviceDeleteSwitchSetting"), updateDeleteSwitchReq), BaseResponse.class, updateDeleteSwitchReq.getInfo());
        int result = baseResponse.getResult();
        if (result != 0) {
            throw new C9721b(3107, result, baseResponse.toString(), updateDeleteSwitchReq.getInfo());
        }
    }
}
