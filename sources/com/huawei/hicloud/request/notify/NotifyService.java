package com.huawei.hicloud.request.notify;

import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.SpaceSwitchSuggestDialog;
import com.huawei.hicloud.bean.NotifyExtend;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.CheckAppStatus;
import com.huawei.hicloud.request.notify.bean.DynamicDataRequest;
import com.huawei.hicloud.request.notify.bean.DynamicDataResponse;
import com.huawei.hicloud.request.notify.bean.EventReq;
import com.huawei.hicloud.request.notify.bean.EventResp;
import com.huawei.hicloud.request.notify.bean.ExposureReportData;
import com.huawei.hicloud.request.notify.bean.ExposureReportRequest;
import com.huawei.hicloud.request.notify.bean.ExposureReportResp;
import com.huawei.hicloud.request.notify.bean.NotifyBaseReq;
import com.huawei.hicloud.request.notify.callback.NotifyCallback;
import com.huawei.hicloud.request.notify.constant.NotifyCmd;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hicloud.request.notify.constant.NotifyUrl;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p015ak.C0213f;
import p015ak.C0234s;
import p429kk.C11058a;
import p429kk.C11060c;
import p527on.C11976a;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p742wj.C13612b;
import p746wn.C13622a;
import tm.C13040c;

/* loaded from: classes6.dex */
public class NotifyService {
    private static final HashMap<String, String> NOTIFY_URLS = new HashMap<String, String>() { // from class: com.huawei.hicloud.request.notify.NotifyService.1
        {
            put(NotifyCmd.EVENT, NotifyUrl.EVENT);
            put(NotifyCmd.OBTAIN, NotifyUrl.OBTAIN);
            put(NotifyCmd.EXPOSURE_REPORT, NotifyUrl.EXPOSURE_REPORT);
        }
    };
    private static final String TAG = "NotifyService";

    private static String formatMessage(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
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

    private static <T> T fromJson(String str, Class<T> cls) throws C9721b {
        try {
            return (T) new Gson().fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = " + str, "CBSService_fromJson");
        }
    }

    private static String getNotifyAddress(String str) throws C9721b {
        try {
            String str2 = NOTIFY_URLS.get(str);
            if (TextUtils.isEmpty(str2)) {
                throw new C9721b(4002, "the command is not correct.", str);
            }
            return C13040c.m78609F().m78617I() + str2;
        } catch (C9721b e10) {
            throw new C9721b(NotifyErr.NOTIFY_MALFORMEDURL, e10.getMessage(), str);
        }
    }

    private String invoke(NotifyBaseReq notifyBaseReq) throws C9721b {
        return invoke(notifyBaseReq, "");
    }

    private String onAccessToken(String str) throws C9721b {
        try {
            return C13195l.m79272J().m79344y(SpaceSwitchSuggestDialog.SCENE_ID_NOTIFY, str);
        } catch (C13194k e10) {
            NotifyLogger.m29914e(TAG, "onAccessToken error: " + e10.toString());
            if (e10.m79269b() == 1199) {
                throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
            }
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            NotifyLogger.m29914e(TAG, "onAccessToken error: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1201, e11.toString(), str);
        }
    }

    private String onAccessTokenWithId(String str, String str2) throws C9721b {
        try {
            return C13195l.m79272J().m79290C(str2, SpaceSwitchSuggestDialog.SCENE_ID_NOTIFY, str);
        } catch (C13194k e10) {
            NotifyLogger.m29914e(TAG, "AccessToken error: " + e10.toString());
            if (e10.m79269b() != 1199) {
                throw new C9721b(1201, e10.toString(), str);
            }
            NotifyLogger.m29914e(TAG, "HTTP_DISABLE");
            throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
        } catch (C13199p e11) {
            NotifyLogger.m29914e(TAG, "AccessToken error: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1201, e11.toString(), str);
        }
    }

    private String result(String str, C11060c c11060c) throws C9721b {
        if (c11060c != null) {
            c11060c.m66665u("124_");
            c11060c.m66635A(str);
        }
        return str;
    }

    private String sendMessage(String str, String str2, C11060c c11060c, String str3) throws C9721b {
        String notifyAddress = getNotifyAddress(str);
        NotifyLogger.m29913d(TAG, "====================url: " + notifyAddress);
        NotifyLogger.m29913d(TAG, "====================body: " + str2);
        int i10 = 1;
        while (true) {
            String strOnAccessToken = TextUtils.isEmpty(str3) ? onAccessToken(str) : onAccessTokenWithId(str, str3);
            try {
                NotifyLogger.m29915i(TAG, formatMessage(notifyAddress, str, "x-hw-trace-id = ", c11060c.m66661q()));
                String str4 = (String) C11976a.m72086g(notifyAddress, new NotifyCallback(strOnAccessToken, str, str2, c11060c.m66661q()), c11060c);
                NotifyLogger.m29913d(TAG, formatMessage(str, str4));
                if (str4 == null || str4.isEmpty()) {
                    throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null", str);
                }
                return result(str4, c11060c);
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "NotifyService error, Cmd: " + str + ", exception: " + e10.toString());
                if (9000 != e10.m60659c() || 401 != e10.m60663g()) {
                    break;
                }
                int i11 = i10 + 1;
                if (i10 >= 3) {
                    break;
                }
                NotifyLogger.m29914e(TAG, " [AT OPERATION] at invalid retry: " + i11);
                C13195l.m79272J().m79325o0(strOnAccessToken);
                i10 = i11;
                throw e10;
            } catch (Exception e11) {
                NotifyLogger.m29914e(TAG, formatMessage(str, e11));
                throw new C9721b(4001, e11.getMessage(), str);
            }
        }
    }

    public boolean exposureReport(String str, String str2) {
        NotifyLogger.m29915i(TAG, "exposureReport");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            NotifyLogger.m29915i(TAG, "exposureReport fail, messageId or cfgInstanceId is null");
            return false;
        }
        ExposureReportData exposureReportData = new ExposureReportData();
        exposureReportData.setId(str2);
        exposureReportData.setMessageId(str);
        exposureReportData.setChannel("deskTopPopup");
        ArrayList arrayList = new ArrayList();
        arrayList.add(exposureReportData);
        ExposureReportRequest exposureReportRequest = new ExposureReportRequest(NotifyCmd.EXPOSURE_REPORT);
        exposureReportRequest.setData(arrayList);
        try {
            return ((ExposureReportResp) fromJson(sendMessage(exposureReportRequest.getInfo(), exposureReportRequest.toString(), C11058a.m66626a(C11058a.m66627b("07072"), exposureReportRequest.getInfo(), C13452e.m80781L().m80971t0()), ""), ExposureReportResp.class)).getCode() == 200;
        } catch (JsonSyntaxException | C9721b e10) {
            NotifyLogger.m29914e(TAG, "exposureReport Exception" + e10.getMessage());
            return false;
        }
    }

    public EventResp queryEvent(String str, String str2, int i10, List<String> list, String str3, List<NotifyWay> list2, String str4, NotifyExtend notifyExtend) throws C9721b {
        NotifyLogger.m29915i(TAG, "queryEvent");
        EventReq eventReq = new EventReq(NotifyCmd.EVENT);
        eventReq.setAppId("10055832");
        eventReq.setAppVersion(C1443a.f6213a);
        eventReq.setCfgInstanceId(str);
        eventReq.setCfgKey(str2);
        eventReq.setCfgResourceId(i10);
        eventReq.setCountryCode(C13452e.m80781L().m80942m());
        eventReq.setModel(Build.MODEL);
        eventReq.setNotifyPurposes(list);
        eventReq.setNotifyType(str3);
        eventReq.setNotifyWays(list2);
        if (TextUtils.isEmpty(C13612b.m81829B().m81845H(C0213f.m1377a()))) {
            NotifyLogger.m29914e(TAG, "queryEvent, pushToken is null or empty.");
            return null;
        }
        eventReq.setPushToken(C13612b.m81829B().m81845H(C0213f.m1377a()));
        eventReq.setUserData(str4);
        eventReq.setUserId(C13452e.m80781L().m80971t0());
        eventReq.setExtend(notifyExtend);
        try {
            return (EventResp) fromJson(invoke(eventReq), EventResp.class);
        } catch (JsonSyntaxException e10) {
            NotifyLogger.m29915i(TAG, " queryEvent is err : " + e10.getMessage());
            throw e10;
        }
    }

    public EventResp queryEventV2(String str, String str2) throws C9721b {
        NotifyLogger.m29915i(TAG, "queryEventV2");
        EventReq eventReq = new EventReq(NotifyCmd.EVENT);
        eventReq.setAppId("10055832");
        eventReq.setAppVersion(C1443a.f6213a);
        eventReq.setCountryCode(C13452e.m80781L().m80942m());
        eventReq.setModel(Build.MODEL);
        eventReq.setNotifyType(str);
        if (TextUtils.isEmpty(C13612b.m81829B().m81845H(C0213f.m1377a()))) {
            NotifyLogger.m29914e(TAG, "queryEventV2, pushToken is null or empty.");
            return null;
        }
        eventReq.setPushToken(C13612b.m81829B().m81845H(C0213f.m1377a()));
        eventReq.setUserData(str2);
        eventReq.setUserId(C13452e.m80781L().m80971t0());
        try {
            return (EventResp) fromJson(invoke(eventReq), EventResp.class);
        } catch (JsonSyntaxException e10) {
            NotifyLogger.m29915i(TAG, " queryEventV2 is err : " + e10.getMessage());
            throw e10;
        }
    }

    public DynamicDataResponse queryObtain(String str) {
        NotifyLogger.m29915i(TAG, "queryObtain");
        DynamicDataRequest dynamicDataRequest = new DynamicDataRequest(NotifyCmd.OBTAIN);
        dynamicDataRequest.setSrcChannel("512");
        dynamicDataRequest.setSceneId(str);
        dynamicDataRequest.setCountryCode(C0234s.m1626d());
        dynamicDataRequest.setLang(C0234s.m1636n());
        try {
            return (DynamicDataResponse) fromJson(sendMessage(dynamicDataRequest.getInfo(), dynamicDataRequest.toString(), C11058a.m66626a(C11058a.m66627b("04023"), dynamicDataRequest.getInfo(), C13452e.m80781L().m80971t0()), ""), DynamicDataResponse.class);
        } catch (JsonSyntaxException | C9721b e10) {
            NotifyLogger.m29914e(TAG, "queryObtain Exception" + e10.getMessage());
            return null;
        }
    }

    private String invoke(NotifyBaseReq notifyBaseReq, String str) throws Throwable {
        NotifyLogger.m29915i(TAG, " requestInfo is " + notifyBaseReq.getInfo());
        new CheckAppStatus().checkAllSendToFile();
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07008"), notifyBaseReq.getInfo(), C13452e.m80781L().m80971t0());
        try {
            return sendMessage(notifyBaseReq.getInfo(), notifyBaseReq.toString(), c11060cM66626a, str);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, formatMessage(notifyBaseReq.getInfo(), e10));
            c11060cM66626a.m66665u("124_" + e10.m60659c());
            c11060cM66626a.m66635A(e10.getMessage());
            C13622a.m81970p(c11060cM66626a, null, false);
            throw e10;
        }
    }
}
