package io;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cbs.bean.BasicDeviceSwitchRsp;
import com.huawei.android.hicloud.cbs.bean.PersonalizedMarketingSwitchRsp;
import com.huawei.hicloud.base.bean.AgreementInfo;
import com.huawei.hicloud.base.bean.QueryDevConfAgreementRsp;
import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.bean.BasicModuleConfigV3Rsp;
import com.huawei.hicloud.bean.DriveConfig;
import com.huawei.hicloud.bean.SyncConfig;
import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import com.huawei.hicloud.notification.util.CheckAppStatus;
import com.huawei.hicloud.request.basic.bean.AgrInfo;
import com.huawei.hicloud.request.basic.bean.AllDevicesReq;
import com.huawei.hicloud.request.basic.bean.AssociateDevicesReq;
import com.huawei.hicloud.request.basic.bean.BasicBaseReq;
import com.huawei.hicloud.request.basic.bean.BasicDevConfInitReq;
import com.huawei.hicloud.request.basic.bean.BasicDeviceRegisterReq;
import com.huawei.hicloud.request.basic.bean.BasicModuleConfigReq;
import com.huawei.hicloud.request.basic.bean.BasicReportSwitchReq;
import com.huawei.hicloud.request.basic.bean.CBSAllDevicesRsp;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordDeviceInfo;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordsRsp;
import com.huawei.hicloud.request.basic.bean.ChangeUserStatusReq;
import com.huawei.hicloud.request.basic.bean.ChangeUserStatusResp;
import com.huawei.hicloud.request.basic.bean.DeviceSwitchInfo;
import com.huawei.hicloud.request.basic.bean.FollowPublicUserReq;
import com.huawei.hicloud.request.basic.bean.GetDeviceSwitchReq;
import com.huawei.hicloud.request.basic.bean.GetUserPropertiesReq;
import com.huawei.hicloud.request.basic.bean.GetUserPublicInfoReq;
import com.huawei.hicloud.request.basic.bean.GetUserPublicInfoResp;
import com.huawei.hicloud.request.basic.bean.GetUserRegisterReq;
import com.huawei.hicloud.request.basic.bean.GetUserRegisterResp;
import com.huawei.hicloud.request.basic.bean.PostOpDescReq;
import com.huawei.hicloud.request.basic.bean.PostUserPropertiesReq;
import com.huawei.hicloud.request.basic.bean.SyncRecordsReq;
import com.huawei.hicloud.request.basic.bean.UserOperationReportReq;
import com.huawei.hicloud.request.basic.bean.VisionDeviceReq;
import com.huawei.hicloud.request.basic.bean.VisionDeviceRsp;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import fk.C9720a;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import jo.C10902a;
import jo.C10903b;
import jo.C10904c;
import mk.C11477c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0239x;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p674ub.C13152i;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p746wn.C13622a;
import p837z9.C14162c;
import p837z9.C14163d;
import ro.C12612a;
import tm.C13040c;

/* renamed from: io.a */
/* loaded from: classes6.dex */
public class C10582a {

    /* renamed from: g */
    public static final HashMap<String, String> f50919g = new a();

    /* renamed from: a */
    public String f50920a;

    /* renamed from: b */
    public String f50921b;

    /* renamed from: c */
    public String f50922c;

    /* renamed from: d */
    public String f50923d;

    /* renamed from: e */
    public boolean f50924e = false;

    /* renamed from: f */
    public boolean f50925f = false;

    /* renamed from: io.a$a */
    public class a extends HashMap<String, String> {
        public a() {
            put("sysConfInit", "/HiCloudUserFoundationService/Client/sysConfInit");
            put("sysConfRefresh", "/HiCloudUserFoundationService/Client/sysConfRefresh");
            put("UserDeviceRegisterReq", "/HiCloudUserFoundationService/Client/userDeviceRegister");
            put("userDeviceUnRegisterReq", "/HiCloudUserFoundationService/Client/userDeviceUnRegister");
            put("GetUserRegisterReq", "/HiCloudUserFoundationService/Client/getUserRegister");
            put("GetOperationRecordReq", "/HiCloudUserFoundationService/Client/getOperationRecord");
            put("GetLastOperationRecord", "/HiCloudUserFoundationService/Client/getLastOperationRecord");
            put("GetUserDeviceInfoReq", "/HiCloudUserFoundationService/Client/getUserActiveDeviceInfo");
            put("getUserVisionDeviceInfoReq", "/HiCloudUserFoundationService/Client/getUserDeviceInfo");
            put("BasicSwitchRegisterReq", "/HiCloudUserFoundationService/Client/postDeviceSwitch");
            put("changeDeviceSwitchReq", "/HiCloudUserFoundationService/Client/changeDeviceSwitch");
            put("reportDeviceSwitchReq", "/HiCloudUserFoundationService/Client/reportDeviceSwitch");
            put("getDeviceSwitch", "/HiCloudUserFoundationService/Client/getDeviceSwitch");
            put("opDesc", "/HiCloudUserFoundationService/Client/postOpDesc");
            put("devConfInit", "/HiCloudUserFoundationService/Client/devConfInit");
            put("postUserOperation", "/HiCloudUserFoundationService/Client/postUserOperation");
            put("changeUserStatus", "/HiCloudUserFoundationService/Client/changeUserStatus");
            put("getUserProperties", "/HiCloudUserFoundationService/Client/getUserProperties");
            put("postUserProperties", "/HiCloudUserFoundationService/Client/postUserProperties");
            put("postOperationRecord", "/HiCloudUserFoundationService/Client/postOperationRecord");
        }
    }

    /* renamed from: io.a$b */
    public class b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Map f50926a;

        /* renamed from: b */
        public final /* synthetic */ String f50927b;

        /* renamed from: c */
        public final /* synthetic */ boolean f50928c;

        /* renamed from: d */
        public final /* synthetic */ c f50929d;

        public b(Map map, String str, boolean z10, c cVar) {
            this.f50926a = map;
            this.f50927b = str;
            this.f50928c = z10;
            this.f50929d = cVar;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            int result = 1;
            try {
                BasicReportSwitchReq basicReportSwitchReq = new BasicReportSwitchReq(this.f50926a, this.f50927b);
                if (this.f50928c) {
                    basicReportSwitchReq.setRefurbish(true);
                }
                result = ((BasicBaseResp) C14162c.m84970b(C10582a.this.m64903D(basicReportSwitchReq), BasicBaseResp.class)).getResult();
                C11839m.m70688i("BasicService", "registerSwitch resultcode = " + result);
            } catch (JsonSyntaxException | C9721b e10) {
                C11839m.m70686d("BasicService", "registerSwitch Fail!" + e10.getMessage());
            }
            c cVar = this.f50929d;
            if (cVar != null) {
                cVar.onResult(result);
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public String getTag() {
            return "BasicService.registerSwitch";
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    /* renamed from: io.a$c */
    public interface c {
        void onResult(int i10);
    }

    public C10582a(String str) {
        this.f50920a = str;
    }

    /* renamed from: f */
    public static String m64897f(String str, Object... objArr) {
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

    /* renamed from: g */
    public static String m64898g(String str) throws C9721b {
        try {
            String str2 = f50919g.get(str);
            if (TextUtils.isEmpty(str2)) {
                throw new C9721b(4002, "the command is not correct.", str);
            }
            return ((str.equals("sysConfInit") || str.equals("sysConfRefresh") || str.equals("devConfInit")) ? C13040c.m78609F().m78663p() : C13040c.m78609F().m78661n()) + str2;
        } catch (C9721b e10) {
            throw new C9721b(NotifyErr.NOTIFY_MALFORMEDURL, e10.getMessage(), str);
        }
    }

    /* renamed from: h */
    public static Context m64899h() {
        return C0213f.m1377a();
    }

    /* renamed from: A */
    public final void m64900A(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_messaging_up")) {
            basicModuleConfigV3Rsp.setSmsUpEnable(jSONObject.getBoolean("funcfg_messaging_up"));
            jSONObject.remove("funcfg_messaging_up");
        }
        if (jSONObject.has("funcfg_messaging_down")) {
            basicModuleConfigV3Rsp.setSmsDownEnable(jSONObject.getBoolean("funcfg_messaging_down"));
            jSONObject.remove("funcfg_messaging_down");
        }
    }

    /* renamed from: B */
    public final void m64901B(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_manage_storage")) {
            basicModuleConfigV3Rsp.setStorageManageEnable(jSONObject.getBoolean("funcfg_manage_storage"));
            jSONObject.remove("funcfg_manage_storage");
        }
    }

    /* renamed from: C */
    public final void m64902C(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_wlan")) {
            basicModuleConfigV3Rsp.setWlanEnable(jSONObject.getBoolean("funcfg_wlan"));
            jSONObject.remove("funcfg_wlan");
        }
    }

    /* renamed from: D */
    public final String m64903D(BasicBaseReq basicBaseReq) throws C9721b {
        return m64904E(basicBaseReq, "", false);
    }

    /* renamed from: E */
    public final String m64904E(BasicBaseReq basicBaseReq, String str, boolean z10) throws Throwable {
        String info = basicBaseReq.getInfo();
        C11839m.m70688i("BasicService", " requestInfo is " + info);
        boolean z11 = ("sysConfInit".equals(info) || "sysConfRefresh".equals(info)) ? false : true;
        C11839m.m70688i("BasicService", "needExecuteUpgrade: " + z11);
        new CheckAppStatus().checkAllSendToFileWithAvoid(true, z11, z11, true);
        String str2 = this.f50920a;
        C11060c c11060cM66626a = C11058a.m66626a((str2 == null || str2.isEmpty()) ? C11058a.m66627b("00000") : this.f50920a, basicBaseReq.getInfo(), C13452e.m80781L().m80971t0());
        try {
            return m64939i0(basicBaseReq, c11060cM66626a, str, z10);
        } catch (C9721b e10) {
            C9721b c9721bM64929c = this.m64929c(basicBaseReq.getInfo(), e10);
            C11839m.m70687e("BasicService", m64897f(basicBaseReq.getInfo(), c9721bM64929c));
            c11060cM66626a.m66665u("120_" + c9721bM64929c.m60659c());
            c11060cM66626a.m66635A(e10.getMessage());
            C13622a.m81970p(c11060cM66626a, null, this.f50924e);
            throw c9721bM64929c;
        }
    }

    /* renamed from: F */
    public final String m64905F(BasicBaseReq basicBaseReq, String str) throws C9721b {
        C11839m.m70688i("BasicService", " requestInfo is " + basicBaseReq.getInfo());
        String str2 = this.f50920a;
        C11060c c11060cM66626a = C11058a.m66626a((str2 == null || str2.isEmpty()) ? C11058a.m66627b("00000") : this.f50920a, basicBaseReq.getInfo(), C13452e.m80781L().m80971t0());
        try {
            return m64941j0(basicBaseReq.getInfo(), basicBaseReq.toString(), c11060cM66626a, str);
        } catch (C9721b e10) {
            C9721b c9721bM64929c = this.m64929c(basicBaseReq.getInfo(), e10);
            C11839m.m70687e("BasicService", m64897f(basicBaseReq.getInfo(), c9721bM64929c));
            c11060cM66626a.m66665u("120_" + c9721bM64929c.m60659c());
            c11060cM66626a.m66635A(e10.toString());
            C13622a.m81970p(c11060cM66626a, null, this.f50924e);
            throw c9721bM64929c;
        }
    }

    /* renamed from: G */
    public final String m64906G(BasicBaseReq basicBaseReq, boolean z10) throws C9721b {
        return m64904E(basicBaseReq, "", z10);
    }

    /* renamed from: H */
    public final void m64907H(boolean z10, BasicDevConfInitReq basicDevConfInitReq, String str) {
        AgrInfo agrInfo = new AgrInfo(125, str);
        AgrInfo agrInfo2 = new AgrInfo(RequestManager.NOTIFY_CONNECT_SUSPENDED, str);
        AgrInfo agrInfo3 = new AgrInfo(10000, str);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(agrInfo);
        arrayList.add(agrInfo2);
        if ("CN".equalsIgnoreCase(str)) {
            arrayList.add(agrInfo3);
        }
        m64943k0(basicDevConfInitReq, false);
        basicDevConfInitReq.setTermIsAgreed(z10);
        if (z10) {
            return;
        }
        basicDevConfInitReq.setAgrInfo(arrayList);
    }

    /* renamed from: I */
    public final String m64908I(String str) throws C9721b {
        try {
            return C13195l.m79272J().m79344y("BasicService", str);
        } catch (C13194k e10) {
            C11839m.m70687e("BasicService", "onAccessToken error: " + e10.toString());
            if (e10.m79269b() == 1199) {
                throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
            }
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            C11839m.m70687e("BasicService", "onAccessToken error: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: J */
    public final String m64909J(String str, String str2) throws C9721b {
        try {
            return C13195l.m79272J().m79290C(str2, "BaseService", str);
        } catch (C13194k e10) {
            C11839m.m70687e("BasicService", "AccessToken error: " + e10.toString());
            if (e10.m79269b() != 1199) {
                throw new C9721b(1201, e10.toString(), str);
            }
            C11839m.m70687e("BasicService", "HTTP_DISABLE");
            throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
        } catch (C13199p e11) {
            C11839m.m70687e("BasicService", "AccessToken error: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: K */
    public final void m64910K(BasicBaseResp basicBaseResp) {
        C11839m.m70688i("BasicService", "parseErrorByRsp");
        if (basicBaseResp != null) {
            try {
                if (basicBaseResp.getErrorNo() == 9999) {
                    String scenarioId = basicBaseResp.getScenarioId();
                    if (TextUtils.isEmpty(scenarioId)) {
                        return;
                    }
                    C11839m.m70688i("BasicService", "parseErrorByRsp scenarioId=" + scenarioId);
                    C13152i.m79070o().m79091a(scenarioId, "BasicService");
                }
            } catch (Exception e10) {
                C11839m.m70687e("BasicService", "parseUserStatus exception:" + e10.toString());
            }
        }
    }

    /* renamed from: L */
    public final void m64911L(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        C11839m.m70688i("BasicService", "parseUserStatus");
        if (jSONObject != null) {
            try {
                if (jSONObject.has("userStatus")) {
                    String string = jSONObject.getString("userStatus");
                    basicModuleConfigV3Rsp.setUserStatus(string);
                    C0212e0.m1372v(m64899h(), "slientUser", "userStatus", string);
                    C13452e.m80781L().m80813H2(string);
                    C11839m.m70688i("BasicService", "parseUserStatus userStatus=" + string);
                    C13152i.m79070o().m79095e(string, "BasicService");
                }
            } catch (Exception e10) {
                C11839m.m70687e("BasicService", "parseUserStatus exception:" + e10.toString());
            }
        }
    }

    /* renamed from: M */
    public final void m64912M(GetUserRegisterResp getUserRegisterResp) {
        C11839m.m70688i("BasicService", "parseUserStatus");
        if (getUserRegisterResp != null) {
            try {
                HashMap<String, String> resultMap = getUserRegisterResp.getResultMap();
                if (resultMap != null) {
                    String str = resultMap.get("userStatus");
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    C11839m.m70688i("BasicService", "parseUserStatus userStatus=" + str);
                    C13452e.m80781L().m80813H2(str);
                    C13152i.m79070o().m79095e(str, "GetUserRegisterResp");
                }
            } catch (Exception e10) {
                C11839m.m70687e("BasicService", "parseUserStatus exception:" + e10.toString());
            }
        }
    }

    /* renamed from: N */
    public final void m64913N(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("cloudbackup")) {
            basicModuleConfigV3Rsp.setCloudBackupDefaultToggle(jSONObject.getBoolean("cloudbackup"));
            jSONObject.remove("cloudbackup");
        }
        if (jSONObject.has("addressbook")) {
            basicModuleConfigV3Rsp.setAddressBookDefaultToggle(jSONObject.getBoolean("addressbook"));
            jSONObject.remove("addressbook");
        }
        if (jSONObject.has("cloudphoto")) {
            basicModuleConfigV3Rsp.setCloudPhotoDefaultToggle(jSONObject.getBoolean("cloudphoto"));
            jSONObject.remove("cloudphoto");
        }
        if (jSONObject.has("calendar")) {
            basicModuleConfigV3Rsp.setCalendarDefaultToggle(jSONObject.getBoolean("calendar"));
            jSONObject.remove("calendar");
        }
        if (jSONObject.has("notepad")) {
            basicModuleConfigV3Rsp.setNotepadDefaultToggle(jSONObject.getBoolean("notepad"));
            jSONObject.remove("notepad");
        }
        if (jSONObject.has("wlan")) {
            basicModuleConfigV3Rsp.setWlanDefaultToggle(jSONObject.getBoolean("wlan"));
            jSONObject.remove("wlan");
        }
        if (jSONObject.has("browser")) {
            basicModuleConfigV3Rsp.setBrowserDefaultToggle(jSONObject.getBoolean("browser"));
            jSONObject.remove("browser");
        }
        HashMap<String, Boolean> map = new HashMap<>();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next) && (next.startsWith("sync.") || next.startsWith("drive."))) {
                String[] strArrSplit = next.split("\\.");
                if (strArrSplit.length == 3) {
                    String str = strArrSplit[2] + "_toogle";
                    if (!TextUtils.isEmpty(str)) {
                        map.put(str, Boolean.valueOf(jSONObject.getBoolean(next)));
                    }
                } else {
                    C11839m.m70687e("BasicService", "parseV3ConfigToggleDefault Wrong toggle name: ");
                }
            }
        }
        basicModuleConfigV3Rsp.setSyncDynamicToggleFieldMap(map);
        C11839m.m70688i("BasicService", "parse ToggleDefault success");
    }

    /* renamed from: O */
    public final void m64914O(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        m64944l(jSONObject, basicModuleConfigV3Rsp);
        m64946m(jSONObject, basicModuleConfigV3Rsp);
        m64960y(jSONObject, basicModuleConfigV3Rsp);
        m64958w(jSONObject, basicModuleConfigV3Rsp);
        m64955t(jSONObject, basicModuleConfigV3Rsp);
        m64951p(jSONObject, basicModuleConfigV3Rsp);
        m64959x(jSONObject, basicModuleConfigV3Rsp);
        m64902C(jSONObject, basicModuleConfigV3Rsp);
        m64950o(jSONObject, basicModuleConfigV3Rsp);
        m64900A(jSONObject, basicModuleConfigV3Rsp);
        m64952q(jSONObject, basicModuleConfigV3Rsp);
        m64961z(jSONObject, basicModuleConfigV3Rsp);
        m64948n(jSONObject, basicModuleConfigV3Rsp);
        m64901B(jSONObject, basicModuleConfigV3Rsp);
        m64957v(jSONObject, basicModuleConfigV3Rsp);
        m64956u(jSONObject, basicModuleConfigV3Rsp);
        m64954s(jSONObject, basicModuleConfigV3Rsp);
        m64953r(jSONObject, basicModuleConfigV3Rsp);
        if (jSONObject.has("email_address")) {
            basicModuleConfigV3Rsp.setEmailAddress(jSONObject.getString("email_address"));
            jSONObject.remove("email_address");
        }
        if (jSONObject.has("user_in_red_list")) {
            basicModuleConfigV3Rsp.setInRedList(jSONObject.getBoolean("user_in_red_list"));
            jSONObject.remove("user_in_red_list");
        }
        if (jSONObject.has("data_status")) {
            basicModuleConfigV3Rsp.setDataState(jSONObject.getInt("data_status"));
            jSONObject.remove("data_status");
        }
        if (jSONObject.has("data_type")) {
            basicModuleConfigV3Rsp.setDataType(jSONObject.getInt("data_type"));
            jSONObject.remove("data_type");
        }
        if (jSONObject.has("cloudbackup_v2_status")) {
            C11839m.m70686d("BasicService", "has cloudbackup_v2_status : " + jSONObject.getInt("cloudbackup_v2_status"));
            basicModuleConfigV3Rsp.setCloudbackupV2Status(jSONObject.getInt("cloudbackup_v2_status"));
            jSONObject.remove("cloudbackup_v2_status");
        }
        if (jSONObject.has("key_param_header")) {
            C11839m.m70686d("BasicService", "has key_param_header : " + jSONObject.getBoolean("key_param_header"));
            basicModuleConfigV3Rsp.setKeyParamHeader(jSONObject.getBoolean("key_param_header"));
            jSONObject.remove("key_param_header");
        }
        if (basicModuleConfigV3Rsp.getDataState() > 0) {
            basicModuleConfigV3Rsp.setAllowStatus(1);
        } else if (jSONObject.has("allow_status")) {
            basicModuleConfigV3Rsp.setAllowStatus(jSONObject.getInt("allow_status"));
            jSONObject.remove("allow_status");
        }
        HashMap<String, Boolean> map = new HashMap<>();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next) && (next.startsWith("funcfg_") || next.startsWith("reccfg_"))) {
                map.put(next, Boolean.valueOf(jSONObject.getBoolean(next)));
            }
        }
        basicModuleConfigV3Rsp.setSyncDynamicFuncFieldMap(map);
        basicModuleConfigV3Rsp.setMatchResult(0);
        if (jSONObject.has("enable_bbr")) {
            jSONObject.remove("enable_bbr");
        }
    }

    /* renamed from: P */
    public BasicBaseResp m64915P(PostOpDescReq postOpDescReq) throws C9721b {
        try {
            return (BasicBaseResp) C14162c.m84970b(m64903D(postOpDescReq), BasicBaseResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "postOpDesc, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: Q */
    public BasicBaseResp m64916Q(Map map) throws C9721b {
        PostUserPropertiesReq postUserPropertiesReq = new PostUserPropertiesReq();
        postUserPropertiesReq.setUpdateType(1);
        postUserPropertiesReq.setProperties(map);
        try {
            return (BasicBaseResp) C14162c.m84970b(m64903D(postUserPropertiesReq), BasicBaseResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "postUserProperties, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: R */
    public CBSAllDevicesRsp m64917R(int i10) throws C9721b {
        try {
            return (CBSAllDevicesRsp) C14162c.m84970b(m64903D(new AllDevicesReq(i10)), CBSAllDevicesRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "queryAllDevice, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: S */
    public CBSSyncRecordsRsp m64918S() throws C9721b {
        try {
            return (CBSSyncRecordsRsp) C14162c.m84970b(m64903D(new AssociateDevicesReq("2.0")), CBSSyncRecordsRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "queryAssociateDevices, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: T */
    public BasicModuleConfigV3Rsp m64919T(boolean z10) throws JSONException, C9721b {
        C11839m.m70688i("BasicService", "queryDevInitVer3");
        BasicDevConfInitReq basicDevConfInitReq = new BasicDevConfInitReq("devConfInit");
        BasicModuleConfigV3Rsp basicModuleConfigV3Rsp = new BasicModuleConfigV3Rsp();
        String strM80942m = C13452e.m80781L().m80942m();
        C11060c c11060cM66626a = C11058a.m66626a(this.f50920a, basicDevConfInitReq.getInfo(), C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        String str = null;
        if (strM80942m == null || strM80942m.isEmpty()) {
            C11839m.m70687e("BasicService", "devconfinit,get null country code from hwid");
            basicModuleConfigV3Rsp.setMatchResult(2);
        } else {
            m64907H(z10, basicDevConfInitReq, TextUtils.isEmpty(strM80942m) ? "" : strM80942m.toLowerCase(Locale.US));
            try {
                String strM64903D = m64903D(basicDevConfInitReq);
                try {
                    JSONObject jSONObject = new JSONObject(strM64903D);
                    C11839m.m70686d("BasicService", "response success:" + strM64903D);
                    int i10 = jSONObject.getInt("result");
                    String string = jSONObject.getString("info");
                    m64911L(jSONObject, basicModuleConfigV3Rsp);
                    if (i10 == 0) {
                        C11839m.m70688i("BasicService", "queryDevConfInit success");
                        m64935f0(z10, basicModuleConfigV3Rsp, jSONObject, i10, string);
                    } else if (705 == i10 || 706 == i10) {
                        C11839m.m70687e("BasicService", "no country code match");
                        basicModuleConfigV3Rsp.setMatchResult(3);
                    } else if (701 == i10) {
                        C11839m.m70687e("BasicService", "country site changed");
                        basicModuleConfigV3Rsp.setMatchResult(5);
                    } else if (707 == i10) {
                        C11839m.m70687e("BasicService", "country offline");
                        basicModuleConfigV3Rsp.setMatchResult(6);
                    } else if (504 == i10) {
                        C11839m.m70687e("BasicService", "term server error");
                        m64936g0(jSONObject);
                        basicModuleConfigV3Rsp.setMatchResult(7);
                    } else if (505 == i10) {
                        m64936g0(jSONObject);
                        C11839m.m70687e("BasicService", "term no sign");
                        basicModuleConfigV3Rsp.setMatchResult(8);
                    } else {
                        C11839m.m70687e("BasicService", "queryModuleConfig error, error code=" + i10);
                    }
                    str = strM64903D;
                } catch (JSONException unused) {
                    str = strM64903D;
                    C11839m.m70687e("BasicService", "queryDevConfInit json format error");
                    basicModuleConfigV3Rsp.setMatchResult(4);
                    HashMap map = new HashMap();
                    map.put("config_info", str);
                    map.put("config_match_result", String.valueOf(basicModuleConfigV3Rsp.getMatchResult()));
                    C0239x.m1671c().m1672a(map);
                    C13622a.m81969o(m64899h(), c11060cM66626a, map);
                    C11839m.m70686d("BasicService", "queryDevInitVer3 resultcode: " + basicModuleConfigV3Rsp.getResult());
                    return basicModuleConfigV3Rsp;
                }
            } catch (JSONException unused2) {
            }
        }
        HashMap map2 = new HashMap();
        map2.put("config_info", str);
        map2.put("config_match_result", String.valueOf(basicModuleConfigV3Rsp.getMatchResult()));
        C0239x.m1671c().m1672a(map2);
        C13622a.m81969o(m64899h(), c11060cM66626a, map2);
        C11839m.m70686d("BasicService", "queryDevInitVer3 resultcode: " + basicModuleConfigV3Rsp.getResult());
        return basicModuleConfigV3Rsp;
    }

    /* renamed from: U */
    public BasicDeviceSwitchRsp m64920U(String str, int i10, List<String> list) throws C9721b {
        DeviceSwitchInfo deviceSwitchInfo = new DeviceSwitchInfo();
        deviceSwitchInfo.setDeviceID(str);
        deviceSwitchInfo.setDeviceType(i10);
        try {
            return (BasicDeviceSwitchRsp) C14162c.m84970b(m64903D(new GetDeviceSwitchReq(deviceSwitchInfo, list)), BasicDeviceSwitchRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "queryDeviceSwitch, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: V */
    public CBSSyncRecordsRsp m64921V(int i10, String str) throws C9721b {
        try {
            return (CBSSyncRecordsRsp) C14162c.m84970b(m64903D(new SyncRecordsReq(i10, str)), CBSSyncRecordsRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "querySyncRecords, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: W */
    public CBSSyncRecordsRsp m64922W(int i10, String str, CBSSyncRecordDeviceInfo cBSSyncRecordDeviceInfo) throws C9721b {
        try {
            return (CBSSyncRecordsRsp) C14162c.m84970b(m64903D(new SyncRecordsReq(i10, cBSSyncRecordDeviceInfo, str)), CBSSyncRecordsRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "querySyncRecordsByDeviceId, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: X */
    public BasicModuleConfigV3Rsp m64923X(boolean z10) throws JSONException, C9721b {
        C11839m.m70688i("BasicService", "querySysConfigInitVer3");
        BasicModuleConfigReq basicModuleConfigReq = new BasicModuleConfigReq("sysConfInit");
        BasicModuleConfigV3Rsp basicModuleConfigV3Rsp = new BasicModuleConfigV3Rsp();
        String strM80942m = C13452e.m80781L().m80942m();
        C11060c c11060cM66626a = C11058a.m66626a(this.f50920a, basicModuleConfigReq.getInfo(), C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        String strM64903D = null;
        if (strM80942m == null || strM80942m.isEmpty()) {
            C11839m.m70687e("BasicService", "get null country code from hwid");
            basicModuleConfigV3Rsp.setMatchResult(2);
        } else {
            basicModuleConfigReq.setCountry(strM80942m);
            m64945l0(basicModuleConfigReq, z10);
            try {
                strM64903D = m64903D(basicModuleConfigReq);
                JSONObject jSONObject = new JSONObject(strM64903D);
                int i10 = jSONObject.getInt("result");
                String string = jSONObject.getString("info");
                m64911L(jSONObject, basicModuleConfigV3Rsp);
                if (i10 == 0) {
                    C11839m.m70688i("BasicService", "queryModuleConfig success");
                    basicModuleConfigV3Rsp.setMatchResult(0);
                    basicModuleConfigV3Rsp.setResult(i10);
                    basicModuleConfigV3Rsp.setInfo(string);
                    m64914O(jSONObject.getJSONObject("params"), basicModuleConfigV3Rsp);
                    if (jSONObject.has("toggle_default")) {
                        C11839m.m70688i("BasicService", "parseToggleDefault");
                        basicModuleConfigV3Rsp.setGetToggleFromServer(true);
                        m64913N(jSONObject.getJSONObject("toggle_default"), basicModuleConfigV3Rsp);
                    }
                    if (jSONObject.has("newUser")) {
                        boolean z11 = jSONObject.getBoolean("newUser");
                        C11839m.m70688i("BasicService", "is new user:" + z11);
                        C13452e.m80781L().m80989x2(z11);
                        basicModuleConfigV3Rsp.setNewUser(z11);
                    }
                } else if (701 == i10 || 705 == i10 || 706 == i10 || 707 == i10) {
                    C11839m.m70687e("BasicService", "no country code match");
                    basicModuleConfigV3Rsp.setMatchResult(3);
                } else {
                    C11839m.m70687e("BasicService", "queryModuleConfig error, error code=" + i10);
                }
            } catch (JSONException unused) {
                C11839m.m70687e("BasicService", "queryModuleConfig json format error");
                basicModuleConfigV3Rsp.setMatchResult(4);
            }
        }
        HashMap map = new HashMap();
        map.put("config_info", strM64903D);
        map.put("config_match_result", String.valueOf(basicModuleConfigV3Rsp.getMatchResult()));
        C0239x.m1671c().m1672a(map);
        C13622a.m81969o(m64899h(), c11060cM66626a, map);
        C11839m.m70686d("BasicService", "querySysConfigInitVer3 resultcode: " + basicModuleConfigV3Rsp.getResult());
        return basicModuleConfigV3Rsp;
    }

    /* renamed from: Y */
    public BasicModuleConfigV3Rsp m64924Y(String str) throws Throwable {
        C11839m.m70688i("BasicService", "querySysConfigRefreshVer3");
        BasicModuleConfigReq basicModuleConfigReq = new BasicModuleConfigReq("sysConfRefresh");
        BasicModuleConfigV3Rsp basicModuleConfigV3Rsp = new BasicModuleConfigV3Rsp();
        String strM80942m = C13452e.m80781L().m80942m();
        if (!TextUtils.isEmpty(this.f50920a)) {
            this.f50920a = C11058a.m66627b("07004");
        }
        C11060c c11060cM66626a = C11058a.m66626a(this.f50920a, basicModuleConfigReq.getInfo(), C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        String strM64904E = null;
        if (strM80942m == null || strM80942m.isEmpty()) {
            C11839m.m70687e("BasicService", "get null country code from hwid");
            basicModuleConfigV3Rsp.setMatchResult(2);
        } else {
            basicModuleConfigReq.setCountry(strM80942m);
            basicModuleConfigReq.setClientCap("11");
            try {
                C11839m.m70688i("BasicService", "start sys conf refresh request");
                strM64904E = m64904E(basicModuleConfigReq, "com.huawei.hidisk.initparam", false);
                C11839m.m70688i("BasicService", "sys conf refresh end");
                JSONObject jSONObject = new JSONObject(strM64904E);
                int i10 = jSONObject.getInt("result");
                String string = jSONObject.getString("info");
                m64911L(jSONObject, basicModuleConfigV3Rsp);
                if (i10 == 0) {
                    C11839m.m70688i("BasicService", "queryModuleConfig success");
                    basicModuleConfigV3Rsp.setMatchResult(0);
                    basicModuleConfigV3Rsp.setResult(i10);
                    basicModuleConfigV3Rsp.setInfo(string);
                    m64914O(jSONObject.getJSONObject("params"), basicModuleConfigV3Rsp);
                    if (jSONObject.has("toggle_default")) {
                        C11839m.m70688i("BasicService", "parseToggleDefault");
                        basicModuleConfigV3Rsp.setGetToggleFromServer(true);
                        m64913N(jSONObject.getJSONObject("toggle_default"), basicModuleConfigV3Rsp);
                    }
                } else if (705 == i10 || 706 == i10) {
                    C11839m.m70687e("BasicService", "no country code match");
                    basicModuleConfigV3Rsp.setMatchResult(3);
                } else if (701 == i10) {
                    C11839m.m70687e("BasicService", "country site changed");
                    basicModuleConfigV3Rsp.setMatchResult(5);
                } else if (707 == i10) {
                    C11839m.m70687e("BasicService", "country offline");
                    basicModuleConfigV3Rsp.setMatchResult(6);
                } else {
                    C11839m.m70687e("BasicService", "queryModuleConfig error, error code=" + i10);
                }
            } catch (C9721b e10) {
                HashMap map = new HashMap();
                map.put("taskStartChannel", str);
                map.put("config_match_result", String.valueOf(e10.m60659c()));
                map.put("config_info", e10.toString());
                C0239x.m1671c().m1672a(map);
                C13622a.m81969o(m64899h(), c11060cM66626a, map);
                if (!HiCloudForceUpgradeConfigManager.getInstance().isValidityServerCode(e10.m60663g())) {
                    throw e10;
                }
                C11839m.m70687e("BasicService", "server force grade");
                basicModuleConfigV3Rsp.setForceGradeErrorCode(e10.m60663g());
                basicModuleConfigV3Rsp.setMatchResult(9);
                C11839m.m70686d("BasicService", "server force result code: " + basicModuleConfigV3Rsp.getResult());
                return basicModuleConfigV3Rsp;
            } catch (JSONException unused) {
                C11839m.m70687e("BasicService", "queryModuleConfig json format error");
                basicModuleConfigV3Rsp.setMatchResult(4);
            }
        }
        HashMap map2 = new HashMap();
        map2.put("config_info", strM64904E);
        map2.put("config_match_result", String.valueOf(basicModuleConfigV3Rsp.getMatchResult()));
        map2.put("taskStartChannel", str);
        C0239x.m1671c().m1672a(map2);
        C13622a.m81969o(m64899h(), c11060cM66626a, map2);
        C11839m.m70686d("BasicService", "querySysConfigInitVer3 resultcode: " + basicModuleConfigV3Rsp.getResult());
        return basicModuleConfigV3Rsp;
    }

    /* renamed from: Z */
    public PersonalizedMarketingSwitchRsp m64925Z() throws C9721b {
        try {
            return (PersonalizedMarketingSwitchRsp) C14162c.m84970b(m64903D(new GetUserPropertiesReq()), PersonalizedMarketingSwitchRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "queryUserProperties, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: a0 */
    public VisionDeviceRsp m64926a0(int i10, int i11) throws C9721b {
        try {
            return (VisionDeviceRsp) C14162c.m84970b(m64903D(new VisionDeviceReq(i10, i11)), VisionDeviceRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "queryVisionDevice, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: b */
    public ChangeUserStatusResp m64927b() {
        Throwable e10;
        ChangeUserStatusResp changeUserStatusResp;
        int result;
        try {
            changeUserStatusResp = (ChangeUserStatusResp) C14162c.m84970b(m64903D(new ChangeUserStatusReq()), ChangeUserStatusResp.class);
            try {
                result = changeUserStatusResp.getResult();
            } catch (JsonSyntaxException | C9721b e11) {
                e10 = e11;
                C11839m.m70687e("BasicService", "registerSwitch Fail!" + e10.getMessage());
                return changeUserStatusResp;
            }
        } catch (JsonSyntaxException | C9721b e12) {
            e10 = e12;
            changeUserStatusResp = null;
        }
        if (result != 0) {
            C11839m.m70687e("BasicService", "reponse code is not success, code is:" + result);
            return null;
        }
        C11839m.m70688i("BasicService", "ChangeUserStatus response:" + changeUserStatusResp);
        return changeUserStatusResp;
    }

    /* renamed from: b0 */
    public void m64928b0(Map<String, String> map, String str, c cVar) {
        m64930c0(map, str, cVar, false);
    }

    /* renamed from: c */
    public final C9721b m64929c(String str, C9721b c9721b) {
        switch (c9721b.m60659c()) {
            case 503:
            case 1102:
            case NotifyErr.NET_DISABLE_HMS_ERROR /* 1107 */:
            case 1201:
            case 1202:
            case SNSCode.Status.USER_NOT_FOUND /* 3009 */:
            case 3100:
            case NotifyErr.NOTIFY_MALFORMEDURL /* 3102 */:
            case 3107:
            case 3309:
                return c9721b;
            case PlayerConstants.ErrorCode.DEFAULT_ERROR /* 1199 */:
                return new C9721b(1104, c9721b.getMessage(), str);
            case SNSCode.Status.HW_ACCOUNT_FAILED /* 3012 */:
                return new C9721b(3101, c9721b.getMessage(), str);
            case 4000:
            case 4001:
                return new C9721b(3107, c9721b.m60663g(), c9721b.getMessage(), str);
            case ConnectionResult.RESOLUTION_REQUIRED /* 9001 */:
                return new C9721b(NotifyErr.NOTIFY_MALFORMEDURL, c9721b.getMessage(), str);
            case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 9002 */:
                return new C9721b(3103, c9721b.getMessage(), str);
            case 9003:
                return new C9721b(3104, c9721b.getMessage(), str);
            case ConnectionResult.SIGN_IN_FAILED /* 9005 */:
                return new C9721b(3105, c9721b.getMessage(), str);
            case 9100:
                return new C9721b(3108, c9721b.getMessage(), str);
            default:
                return new C9721b(3106, m64897f("response code = ", Integer.valueOf(c9721b.m60659c()), c9721b.getMessage()), str);
        }
    }

    /* renamed from: c0 */
    public void m64930c0(Map<String, String> map, String str, c cVar, boolean z10) {
        C12515a.m75110o().m75172d(new b(map, str, z10, cVar));
    }

    /* renamed from: d */
    public VisionDeviceRsp m64931d() throws C9721b {
        C11839m.m70688i("BasicService", "downloadCurrentDeviceInfo start");
        try {
            return (VisionDeviceRsp) C14162c.m84970b(m64903D(new VisionDeviceReq(0, "0", 0)), VisionDeviceRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "queryVisionDevice, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: d0 */
    public void m64932d0(String str, boolean z10) {
        try {
            BasicDeviceRegisterReq basicDeviceRegisterReq = new BasicDeviceRegisterReq(str);
            basicDeviceRegisterReq.setSignVersion(2);
            C11839m.m70688i("BasicService", "registerUserDevice resultcode = " + ((BasicBaseResp) C14162c.m84970b(m64906G(basicDeviceRegisterReq, z10), BasicBaseResp.class)).getResult());
        } catch (JsonSyntaxException | C9721b e10) {
            C11839m.m70686d("BasicService", "registerUserDevice Fail!" + e10.getMessage());
        }
    }

    /* renamed from: e */
    public BasicBaseResp m64933e(String str) throws C9721b {
        try {
            return (BasicBaseResp) C14162c.m84970b(m64903D(new FollowPublicUserReq(str)), BasicBaseResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "followPublicUser, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: e0 */
    public final String m64934e0(String str, C11060c c11060c, String str2) throws C9721b {
        try {
            BasicBaseResp basicBaseResp = (BasicBaseResp) C14162c.m84970b(str, BasicBaseResp.class);
            m64910K(basicBaseResp);
            int result = basicBaseResp.getResult();
            if (c11060c != null) {
                c11060c.m66665u("120_" + result);
                c11060c.m66635A(basicBaseResp.toString());
            }
            if (result != 0 && result != 505 && result != 701) {
                if (result == 401) {
                    m64937h0();
                    throw new C9721b(3100, basicBaseResp.toString(), str2);
                }
                if (result == 402) {
                    throw new C9721b(1202, basicBaseResp.toString(), str2);
                }
                if (result == 800 || result == 801) {
                    C14163d.m84990g().m85019y(result);
                    throw new C9721b(3309, basicBaseResp.toString(), str2);
                }
                switch (result) {
                    case 705:
                    case BasicBaseResp.COUNTRY_NO_SITE_MATCH /* 706 */:
                    case BasicBaseResp.COUNTRY_OFF_LINE /* 707 */:
                        break;
                    default:
                        throw new C9721b(3107, result, basicBaseResp.toString(), str2);
                }
            }
            return str;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "result, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: f0 */
    public final void m64935f0(boolean z10, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp, JSONObject jSONObject, int i10, String str) throws JSONException {
        basicModuleConfigV3Rsp.setMatchResult(0);
        basicModuleConfigV3Rsp.setResult(i10);
        basicModuleConfigV3Rsp.setInfo(str);
        boolean z11 = jSONObject.getBoolean("guideSwitch");
        C11839m.m70688i("BasicService", "guideSwitch :" + z11);
        basicModuleConfigV3Rsp.setGuideSwitch(z11);
        if (jSONObject.has("newUser")) {
            boolean z12 = jSONObject.getBoolean("newUser");
            C11839m.m70688i("BasicService", "is new user:" + z12);
            C13452e.m80781L().m80989x2(z12);
            basicModuleConfigV3Rsp.setNewUser(z12);
        }
        if (!z11) {
            C11839m.m70688i("BasicService", "guide end");
            return;
        }
        m64936g0(jSONObject);
        C10028c.m62182c0().m62377p3("urls_sp_version", true);
        m64914O(jSONObject.getJSONObject("params"), basicModuleConfigV3Rsp);
        if (jSONObject.has("toggle_default")) {
            C11839m.m70688i("BasicService", "parseToggleDefault");
            basicModuleConfigV3Rsp.setGetToggleFromServer(true);
            m64913N(jSONObject.getJSONObject("toggle_default"), basicModuleConfigV3Rsp);
        }
        if (!z10 && jSONObject.has("signInfo")) {
            C11839m.m70688i("BasicService", "parse signinfo");
            JSONArray jSONArray = jSONObject.getJSONArray("signInfo");
            ArrayList arrayList = new ArrayList(3);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                arrayList.add(new AgreementInfo(jSONObject2.getInt("agrType"), jSONObject2.getString("country"), jSONObject2.getString(FaqConstants.FAQ_EMUI_LANGUAGE), jSONObject2.getBoolean("isAgree")));
            }
            basicModuleConfigV3Rsp.setQueryDevConfAgreementRsp(new QueryDevConfAgreementRsp(arrayList));
        }
        try {
            if (jSONObject.has("syncConfig")) {
                C11839m.m70688i("BasicService", "parse syncConfig");
                basicModuleConfigV3Rsp.setSyncConfig((SyncConfig) new Gson().fromJson(jSONObject.getJSONObject("syncConfig").toString(), SyncConfig.class));
            }
            if (jSONObject.has("driveConfig")) {
                C11839m.m70688i("BasicService", "parse driveConfig");
                basicModuleConfigV3Rsp.setDriveConfig((DriveConfig) new Gson().fromJson(jSONObject.getJSONObject("driveConfig").toString(), DriveConfig.class));
            }
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "saveDevConfInitJsonInfo, json exception is: " + e10.toString());
        }
    }

    /* renamed from: g0 */
    public final void m64936g0(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("siteInfo");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        C13452e.m80781L().m80844P2(string);
    }

    /* renamed from: h0 */
    public final void m64937h0() {
        C13452e.m80781L().m80980v1();
        C13452e.m80781L().m80972t1();
    }

    /* renamed from: i */
    public GetUserRegisterResp m64938i() throws C9721b {
        C9720a.m60653b(C13452e.m80781L().m80971t0(), "userid is null.");
        GetUserRegisterReq getUserRegisterReq = new GetUserRegisterReq();
        getUserRegisterReq.addParams("clientLogReport");
        try {
            GetUserRegisterResp getUserRegisterResp = (GetUserRegisterResp) C14162c.m84970b(m64903D(getUserRegisterReq), GetUserRegisterResp.class);
            int result = getUserRegisterResp.getResult();
            if (result == 0) {
                return getUserRegisterResp;
            }
            throw new C9721b(result, "response code is not success.");
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "getHiCloudDataAnalyze, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: i0 */
    public final String m64939i0(BasicBaseReq basicBaseReq, C11060c c11060c, String str, boolean z10) throws C9721b {
        String str2;
        String info = basicBaseReq.getInfo();
        String string = basicBaseReq.toString();
        String strM64898g = m64898g(info);
        int i10 = 1;
        while (true) {
            String strM64908I = TextUtils.isEmpty(str) ? m64908I(info) : m64909J(info, str);
            try {
                C11839m.m70688i("BasicService", m64897f(strM64898g, info, "x-hw-trace-id = ", c11060c.m66661q()));
                C11839m.m70686d("BasicService", m64897f(info, string));
                if (z10) {
                    str2 = (String) C12612a.m76107g(strM64898g, new C10904c(strM64908I, info, string, c11060c.m66661q()), c11060c);
                } else {
                    C10902a c10902a = new C10902a(strM64908I, info, string, c11060c.m66661q());
                    if (basicBaseReq.isRefurbish()) {
                        c10902a.m65925c(true);
                    }
                    if (this.f50925f) {
                        c10902a.m65924b(this.f50921b, this.f50922c, this.f50923d);
                    }
                    str2 = (String) C12612a.m76107g(strM64898g, c10902a, c11060c);
                }
                C11839m.m70686d("BasicService", m64897f(info, str2));
                if (str2 == null || str2.isEmpty()) {
                    throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null", info);
                }
                return m64934e0(str2, c11060c, info);
            } catch (C9721b e10) {
                if (1202 != e10.m60659c()) {
                    break;
                }
                int i11 = i10 + 1;
                if (i10 >= 3) {
                    break;
                }
                C11839m.m70687e("BasicService", " [AT OPERATION] at invalid retry: " + i11);
                C13195l.m79272J().m79325o0(strM64908I);
                i10 = i11;
                throw e10;
            } catch (Exception e11) {
                C11839m.m70687e("BasicService", m64897f(info, e11));
                throw new C9721b(4001, e11.getMessage(), info);
            }
        }
    }

    /* renamed from: j */
    public GetUserPublicInfoResp m64940j(String str) throws C9721b {
        ArrayList arrayList = new ArrayList();
        arrayList.add("siteInfo");
        GetUserPublicInfoReq getUserPublicInfoReq = new GetUserPublicInfoReq(arrayList);
        try {
            GetUserPublicInfoResp getUserPublicInfoResp = (GetUserPublicInfoResp) C14162c.m84970b(m64905F(getUserPublicInfoReq, str), GetUserPublicInfoResp.class);
            if (!TextUtils.isEmpty(this.f50920a)) {
                this.f50920a = C11058a.m66627b("07012");
            }
            C11060c c11060cM66626a = C11058a.m66626a(this.f50920a, getUserPublicInfoReq.getInfo(), C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0");
            HashMap map = new HashMap();
            map.put(TrackConstants$Opers.RESPONSE, getUserPublicInfoResp.toString());
            C0239x.m1671c().m1672a(map);
            C13622a.m81969o(m64899h(), c11060cM66626a, map);
            C11839m.m70686d("BasicService", "getUserPublicInfo rsp: " + getUserPublicInfoResp.toString());
            return getUserPublicInfoResp;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "getUserPublicInfo, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: j0 */
    public final String m64941j0(String str, String str2, C11060c c11060c, String str3) throws C9721b {
        if (!str.equals("getUserPublicInfo")) {
            C11839m.m70687e("BasicService", "error function sendMessageForPublicInfo() call, this func is only used for GetUserPublicInfo");
            throw new C9721b(NotifyErr.NOTIFY_MALFORMEDURL, "error function sendMessageForPublicInfo() call, this func is only used for GetUserPublicInfo", str);
        }
        String str4 = str3 + "/HiCloudUserFoundationService/Client/getUserPublicInfo";
        int i10 = 1;
        while (true) {
            String strM64908I = m64908I(str);
            try {
                C11839m.m70688i("BasicService", m64897f(str4, str, "x-hw-trace-id = ", c11060c.m66661q()));
                C11839m.m70686d("BasicService", m64897f(str, str2));
                String str5 = (String) C12612a.m76107g(str4, new C10903b(strM64908I, str, str2, c11060c.m66661q()), c11060c);
                C11839m.m70686d("BasicService", m64897f(str, str5));
                if (str5 == null || str5.isEmpty()) {
                    throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null", str);
                }
                return m64934e0(str5, c11060c, str);
            } catch (C9721b e10) {
                if (1202 != e10.m60659c()) {
                    break;
                }
                int i11 = i10 + 1;
                if (i10 >= 3) {
                    break;
                }
                C11839m.m70687e("BasicService", " [AT OPERATION] at invalid retry: " + i11);
                C13195l.m79272J().m79325o0(strM64908I);
                i10 = i11;
                throw e10;
            } catch (Exception e11) {
                C11839m.m70687e("BasicService", m64897f(str, e11));
                throw new C9721b(4001, e11.getMessage(), str);
            }
        }
    }

    /* renamed from: k */
    public GetUserRegisterResp m64942k() throws C9721b {
        C9720a.m60653b(C13452e.m80781L().m80971t0(), "userid is null.");
        GetUserRegisterReq getUserRegisterReq = new GetUserRegisterReq();
        getUserRegisterReq.addParams("userTimeZone");
        getUserRegisterReq.addParams("userStatus");
        getUserRegisterReq.addParams("validToTime");
        getUserRegisterReq.addParams("lastUpdateTime");
        try {
            GetUserRegisterResp getUserRegisterResp = (GetUserRegisterResp) C14162c.m84970b(m64903D(getUserRegisterReq), GetUserRegisterResp.class);
            m64912M(getUserRegisterResp);
            int result = getUserRegisterResp.getResult();
            if (result != 0) {
                throw new C9721b(result, "reponse code is not success.");
            }
            HashMap<String, String> resultMap = getUserRegisterResp.getResultMap();
            if (resultMap != null) {
                String str = resultMap.get("userTimeZone");
                C11839m.m70686d("BasicService", "getUserRegister timeZone = " + str);
                if (TextUtils.isEmpty(str)) {
                    C11839m.m70689w("BasicService", "getUserRegister timeZone is null.");
                } else {
                    C13452e.m80781L().m80809G2(C11477c.m68636f(str));
                }
            }
            return getUserRegisterResp;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("BasicService", "getUserRegister, json exception is: " + e10.toString());
            throw new C9721b(4, "json err");
        }
    }

    /* renamed from: k0 */
    public final void m64943k0(BasicDevConfInitReq basicDevConfInitReq, boolean z10) {
        if (z10) {
            basicDevConfInitReq.setClientCap("10");
        } else {
            C11839m.m70688i("BasicService", "not from OOBE, query forced upgrade");
            basicDevConfInitReq.setClientCap("11");
        }
    }

    /* renamed from: l */
    public final void m64944l(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_cloud_backup")) {
            basicModuleConfigV3Rsp.setBackupEnable(jSONObject.getBoolean("funcfg_cloud_backup"));
            jSONObject.remove("funcfg_cloud_backup");
        }
    }

    /* renamed from: l0 */
    public final void m64945l0(BasicModuleConfigReq basicModuleConfigReq, boolean z10) {
        if (z10) {
            basicModuleConfigReq.setClientCap("10");
        } else {
            C11839m.m70688i("BasicService", "not from OOBE, query forced upgrade");
            basicModuleConfigReq.setClientCap("11");
        }
    }

    /* renamed from: m */
    public final void m64946m(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_huawei_drive")) {
            basicModuleConfigV3Rsp.setDbankEnable(jSONObject.getBoolean("funcfg_huawei_drive"));
            jSONObject.remove("funcfg_huawei_drive");
        }
    }

    /* renamed from: m0 */
    public void m64947m0(String str, String str2, String str3, boolean z10) {
        C11839m.m70686d("BasicService", "unregisterUserDevice");
        try {
            this.f50921b = str;
            this.f50922c = str2;
            this.f50923d = str3;
            this.f50924e = z10;
            this.f50925f = true;
            C11839m.m70688i("BasicService", "unregisterUserDevice resultcode = " + ((BasicBaseResp) C14162c.m84970b(m64903D(new BasicBaseReq("userDeviceUnRegisterReq")), BasicBaseResp.class)).getResult());
        } catch (JsonSyntaxException | C9721b e10) {
            C11839m.m70686d("BasicService", "unregisterUserDevice Fail!" + e10.getMessage() + ",isAgreedHiCloudTerms:" + z10);
        }
    }

    /* renamed from: n */
    public final void m64948n(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_blocked_up")) {
            basicModuleConfigV3Rsp.setBlockedUpEnable(jSONObject.getBoolean("funcfg_blocked_up"));
            jSONObject.remove("funcfg_blocked_up");
        }
        if (jSONObject.has("funcfg_blocked_down")) {
            basicModuleConfigV3Rsp.setBlockedDownEnable(jSONObject.getBoolean("funcfg_blocked_down"));
            jSONObject.remove("funcfg_blocked_down");
        }
    }

    /* renamed from: n0 */
    public BasicBaseResp m64949n0(UserOperationReportReq userOperationReportReq) {
        try {
            C11839m.m70688i("BasicService", "userOperationReport");
            String strM64903D = m64903D(userOperationReportReq);
            C11839m.m70688i("BasicService", "userOperationReport resp: " + strM64903D);
            return (BasicBaseResp) C14162c.m84970b(strM64903D, BasicBaseResp.class);
        } catch (Exception e10) {
            C11839m.m70688i("BasicService", "userOperationReport exception:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: o */
    public final void m64950o(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_browser")) {
            basicModuleConfigV3Rsp.setBrowserEnable(jSONObject.getBoolean("funcfg_browser"));
            jSONObject.remove("funcfg_browser");
        }
    }

    /* renamed from: p */
    public final void m64951p(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_calendar")) {
            basicModuleConfigV3Rsp.setCalendarEnable(jSONObject.getBoolean("funcfg_calendar"));
            jSONObject.remove("funcfg_calendar");
        }
    }

    /* renamed from: q */
    public final void m64952q(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_call_log_up")) {
            basicModuleConfigV3Rsp.setCallLogUpEnable(jSONObject.getBoolean("funcfg_call_log_up"));
            jSONObject.remove("funcfg_call_log_up");
        }
        if (jSONObject.has("funcfg_call_log_down")) {
            basicModuleConfigV3Rsp.setCallLogDownEnable(jSONObject.getBoolean("funcfg_call_log_down"));
            jSONObject.remove("funcfg_call_log_down");
        }
    }

    /* renamed from: r */
    public final void m64953r(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (!jSONObject.has("funcfg_cloudphoto_manager")) {
            basicModuleConfigV3Rsp.setCloudphotoManager(false);
        } else {
            basicModuleConfigV3Rsp.setCloudphotoManager(jSONObject.getBoolean("funcfg_cloudphoto_manager"));
            jSONObject.remove("funcfg_cloudphoto_manager");
        }
    }

    /* renamed from: s */
    public final void m64954s(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (!jSONObject.has("funcfg_cloudphoto_share")) {
            basicModuleConfigV3Rsp.setCloudphotoShare(false);
        } else {
            basicModuleConfigV3Rsp.setCloudphotoShare(jSONObject.getBoolean("funcfg_cloudphoto_share"));
            jSONObject.remove("funcfg_cloudphoto_share");
        }
    }

    /* renamed from: t */
    public final void m64955t(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_contacts")) {
            basicModuleConfigV3Rsp.setContactEnable(jSONObject.getBoolean("funcfg_contacts"));
            jSONObject.remove("funcfg_contacts");
        }
    }

    /* renamed from: u */
    public final void m64956u(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (!jSONObject.has("ds_start_sticky")) {
            basicModuleConfigV3Rsp.setDsStartSticky(false);
        } else {
            basicModuleConfigV3Rsp.setDsStartSticky(jSONObject.getBoolean("ds_start_sticky"));
            jSONObject.remove("ds_start_sticky");
        }
    }

    /* renamed from: v */
    public final void m64957v(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (!jSONObject.has("funcfg_familyShare")) {
            basicModuleConfigV3Rsp.setFamilyShareEnable(false);
        } else {
            basicModuleConfigV3Rsp.setFamilyShareEnable(jSONObject.getBoolean("funcfg_familyShare"));
            jSONObject.remove("funcfg_familyShare");
        }
    }

    /* renamed from: w */
    public final void m64958w(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_gallery")) {
            basicModuleConfigV3Rsp.setGalleryEnable(jSONObject.getBoolean("funcfg_gallery"));
            jSONObject.remove("funcfg_gallery");
        }
    }

    /* renamed from: x */
    public final void m64959x(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_notes")) {
            basicModuleConfigV3Rsp.setNotesEnable(jSONObject.getBoolean("funcfg_notes"));
            jSONObject.remove("funcfg_notes");
        }
    }

    /* renamed from: y */
    public final void m64960y(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_find_my_phone_globe")) {
            basicModuleConfigV3Rsp.setPhoneFinderEnable(jSONObject.getBoolean("funcfg_find_my_phone_globe"));
            jSONObject.remove("funcfg_find_my_phone_globe");
        }
    }

    /* renamed from: z */
    public final void m64961z(JSONObject jSONObject, BasicModuleConfigV3Rsp basicModuleConfigV3Rsp) throws JSONException {
        if (jSONObject.has("funcfg_recordings_up")) {
            basicModuleConfigV3Rsp.setRecordingUpEnable(jSONObject.getBoolean("funcfg_recordings_up"));
            jSONObject.remove("funcfg_recordings_up");
        }
        if (jSONObject.has("funcfg_recordings_down")) {
            basicModuleConfigV3Rsp.setRecordingDownEnable(jSONObject.getBoolean("funcfg_recordings_down"));
            jSONObject.remove("funcfg_recordings_down");
        }
    }
}
