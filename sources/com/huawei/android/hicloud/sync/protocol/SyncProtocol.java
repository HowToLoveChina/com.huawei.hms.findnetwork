package com.huawei.android.hicloud.sync.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.Ctag;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfo;
import com.huawei.android.hicloud.sync.service.aidl.CtagInfoCompatible;
import com.huawei.android.hicloud.sync.service.aidl.Etag;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.syncutil.C2984m;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import fk.C9721b;
import fk.C9722c;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C10812z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0214f0;
import p514o9.C11839m;
import p551pc.C12127a;
import p551pc.C12128b;
import p709vj.C13452e;
import p837z9.C14163d;
import ro.C12612a;
import sb.C12767a;
import tc.C13007b;

/* loaded from: classes3.dex */
public class SyncProtocol {

    /* renamed from: a */
    public final Context f12938a;

    /* renamed from: b */
    public final String f12939b;

    /* renamed from: c */
    public final String f12940c;

    /* renamed from: d */
    public final String f12941d;

    /* renamed from: e */
    public final String f12942e;

    /* renamed from: f */
    public final C13007b f12943f;

    /* renamed from: g */
    public final String f12944g;

    public static class Constant {
        public static final String ADD = "add";
        public static final String ADDRSP = "addrsp";
        public static final String APPVER = "appVer";
        public static final String CALENDAR_UUID = "calendar_uuid";
        public static final String CODE = "code";
        public static final String CTAG = "ctag";
        public static final String CURSOR = "cursor";
        public static final String DATA = "data";
        public static final String DEK = "dek";
        public static final String ETAG = "etag";
        public static final String EXPIRED = "expired";
        public static final String FILE_DIR = "fileDir";
        public static final String GUID = "guid";
        public static final String INFO = "info";
        public static final String INTERVAL = "interval";
        public static final String LUID = "luid";
        public static final String MULTISTATUS = "multistatus";
        public static final String OTYPE = "otype";
        public static final String PROPS = "props";
        public static final String RECYCLE_STATUS = "status";
        public static final String RECYCLE_TIME = "recycleTime";
        public static final String REMOVE = "remove";
        public static final String REMOVERSP = "removersp";
        public static final String RESULT = "result";
        public static final String STATUS = "status";
        public static final String STR_DATA_VER = "strDataVer";
        public static final String STR_GUID = "strGuid";
        public static final String SYNC_TOKEN = "synctoken";
        public static final String UNSTR_DATA_VER = "unstrDataVer";
        public static final String UNSTR_GUID = "unstrGuid";
        public static final String UPDATE = "update";
        public static final String UPDATERSP = "updatersp";
        public static final String UUID = "uuid";
    }

    public class CtagResponse extends Response {
        public KeepLockResponse keepLockResponse;
        public Map<String, Ctag> mapCtag;

        public CtagResponse() {
            super();
            this.mapCtag = null;
            this.keepLockResponse = null;
        }
    }

    public class DataResponse extends Response {
        public Map<String, C2924c> mapData;

        public DataResponse() {
            super();
            this.mapData = null;
        }
    }

    public static class DataStatus {
        private static final int ENCRYPTED = 1;
        private static final int NON_ENCRYPTED = 0;
        private static final int NO_DATA = -1;

        private DataStatus() {
        }
    }

    public class EtagResponse extends Response {
        public String cursor;
        public Map<String, Etag> mapEtag;

        public EtagResponse() {
            super();
            this.mapEtag = new HashMap();
        }
    }

    public class KeepLockResponse extends Response {
        public int interval;

        public KeepLockResponse() {
            super();
            this.interval = -1;
        }
    }

    public static class Method {
        public static final String KEEPLOCK = "KEEPLOCK";
        public static final String LOCK = "LOCK";
        public static final String POST = "POST";
        public static final String REPORT = "REPORT";
        public static final String UNLOCK = "UNLOCK";
    }

    public class ModifyResponse extends Response {
        public Map<String, Map<String, C2926e>> mapModifyRsp;

        public ModifyResponse() {
            super();
            this.mapModifyRsp = null;
        }
    }

    public static class RecycleStatus {
        public static final int NORMAL = 2;
        public static final int RECYCLE = -1;
    }

    public class Response {
        public final C2930i result = new C2930i();

        public Response() {
        }
    }

    public static class Status {
        public static final int BAD_REQUEST = 400;
        public static final int DATA_TOO_LARGE = 413;
        public static final int INVALID = 203;
        public static final int NO_UPDATE = 210;
        public static final int SUCCESS = 200;
        public static final int USER_KEY_GUID_ERROR = 708;
    }

    public SyncProtocol(Context context, String str, String str2, String str3, String str4, String str5) {
        this.f12938a = context;
        this.f12939b = str;
        this.f12940c = str2;
        this.f12943f = C13007b.m78205Y(context);
        this.f12941d = str3;
        this.f12942e = str4;
        this.f12944g = str5;
    }

    /* renamed from: A */
    public final EtagResponse m17708A(String str, String str2, boolean z10, String str3) throws Throwable {
        String str4;
        EtagResponse etagResponse = new EtagResponse();
        do {
            C11839m.m70686d("SyncProtocol", "sendEtagRequestAndParseResponse cursor: " + etagResponse.cursor);
            if (!z10 || TextUtils.isEmpty(str3)) {
                String str5 = "\"etag\"";
                if (!CloudSyncUtil.m16056w0(str)) {
                    str5 = "\"etag\", \"uuid\"";
                }
                if (etagResponse.cursor == null) {
                    str4 = "{\"propname\":[" + str5 + "],\"limit\":5000,\"cursor\":null}";
                } else {
                    str4 = "{\"propname\":[" + str5 + "],\"limit\":5000,\"cursor\":\"" + etagResponse.cursor + "\"}";
                }
            } else {
                String str6 = "\"etag\", \"otype\"";
                if (!CloudSyncUtil.m16056w0(str)) {
                    str6 = "\"etag\", \"otype\", \"uuid\"";
                }
                if (etagResponse.cursor == null) {
                    str4 = "{\"propname\":[" + str6 + "],\"multistatus\":{\"synctoken\":\"" + str3 + "\"},\"limit\":5000,\"cursor\":null}";
                } else {
                    str4 = "{\"propname\":[" + str6 + "],\"multistatus\":{\"synctoken\":\"" + str3 + "\"},\"limit\":5000,\"cursor\":\"" + etagResponse.cursor + "\"}";
                }
            }
            m17710C("PROPFIND", str + "/" + str2, str4, etagResponse);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Paged query cloud eTag size: ");
            sb2.append(etagResponse.mapEtag.size());
            C11839m.m70688i("SyncProtocol", sb2.toString());
        } while (!TextUtils.isEmpty(etagResponse.cursor));
        return etagResponse;
    }

    /* renamed from: B */
    public final String m17709B(String str, String str2, String str3, String str4, String str5, int i10) throws Throwable {
        String str6;
        new C2984m().m17927e(this.f12938a);
        String str7 = "";
        try {
            if (TextUtils.isEmpty(str3)) {
                throw new C9722c(2003, "Send request, module is null or empty", str3, str2);
            }
            C2933l c2933l = new C2933l();
            if (!Method.UNLOCK.equals(str2)) {
                c2933l.checkUpgrade();
                c2933l.checkSyncRisk();
                c2933l.checkSiteNotMatch();
            }
            c2933l.checkStInvalidByServer();
            if (C14163d.m84990g().m85009o()) {
                C11839m.m70689w("SyncProtocol", "sendRequest: data migrate warn is true");
                throw new C9722c(FamilyShareConstants.MessageCode.GET_USERPACKAGE_FOR_INVITE_FAMILY_MEMBER, "SyncProtocol sendRequest: data migrate warn is true", str3, str2);
            }
            m17715g();
            String strM80971t0 = C13452e.m80781L().m80971t0();
            if (TextUtils.isEmpty(strM80971t0)) {
                throw new C9722c(2003, "Send Request, user id null or empty.", str3, str2);
            }
            if (CloudSyncUtil.m16056w0(str3)) {
                str6 = str + "/openhisync/" + str3 + "?method=" + str2;
            } else {
                str6 = str + "/hisync/" + strM80971t0 + "/" + str3 + "?method=" + str2;
            }
            C11839m.m70686d("SyncProtocol", "Url: " + str6);
            C11839m.m70686d("SyncProtocol", "Request: " + str4);
            C11839m.m70688i("SyncProtocol", "Method = " + str2 + ", module = " + str3 + ", traceId: " + this.f12942e);
            String str8 = (String) C12612a.m76106f(str6, new AbstractC2932k(str5, str2, str4, this.f12942e, i10) { // from class: com.huawei.android.hicloud.sync.protocol.SyncProtocol.1
                @Override // com.huawei.android.hicloud.sync.protocol.AbstractC2923b
                public String addLockTokenToHeader() {
                    String strM78224J = SyncProtocol.this.f12943f.m78224J(SyncProtocol.this.f12939b, SyncProtocol.this.f12944g);
                    C11839m.m70686d("SyncProtocol", "sendRequest, lockToken: " + strM78224J);
                    return strM78224J;
                }

                @Override // com.huawei.android.hicloud.sync.protocol.AbstractC2923b
                public void onReceiveLockToken(String str9) {
                    if (TextUtils.isEmpty(str9)) {
                        return;
                    }
                    C11839m.m70686d("SyncProtocol", "Lock token: " + str9);
                    SyncProtocol.this.f12943f.m78209B0(SyncProtocol.this.f12939b, SyncProtocol.this.f12944g, str9);
                }
            }, 0, null);
            try {
                C11839m.m70686d("SyncProtocol", "Response: " + str8);
                C12767a.m76619c().m76622d(this.f12939b);
                if (TextUtils.isEmpty(str8)) {
                    throw new C12128b(2106, "Send request, server response is null or empty", str3, str2);
                }
                return str8;
            } catch (C9721b e10) {
                e = e10;
                str7 = str8;
                m17729u(e, str3, str2);
                return str7;
            }
        } catch (C9721b e11) {
            e = e11;
        }
    }

    /* renamed from: C */
    public final void m17710C(String str, String str2, String str3, Response response) throws Throwable {
        m17711D(str, str2, str3, response, -1);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:6|(3:67|7|8)|(1:(6:11|70|45|46|83|59)(1:(5:63|13|65|14|(3:16|69|17)(3:76|22|23))(4:28|29|30|77)))(2:33|(4:35|36|(3:78|41|42)|43)(5:47|72|48|49|79))|18|70|45|46|83|59|3) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0132 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m17711D(java.lang.String r22, java.lang.String r23, java.lang.String r24, com.huawei.android.hicloud.sync.protocol.SyncProtocol.Response r25, int r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.protocol.SyncProtocol.m17711D(java.lang.String, java.lang.String, java.lang.String, com.huawei.android.hicloud.sync.protocol.SyncProtocol$Response, int):void");
    }

    /* renamed from: d */
    public CtagResponse m17712d(String str, boolean z10, ArrayList<CtagInfoCompatible> arrayList) throws Throwable {
        String str2;
        C11839m.m70688i("SyncProtocol", "acquireLock: " + str + ", isNeedParameter: " + z10);
        CtagResponse ctagResponse = new CtagResponse();
        if (!z10 || arrayList == null || arrayList.isEmpty()) {
            str2 = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                CtagInfoCompatible ctagInfoCompatible = arrayList.get(i10);
                sb2.append("{\"guid\":\"");
                sb2.append(ctagInfoCompatible.getCtagName());
                sb2.append("\",props:{\"synctoken\":\"");
                sb2.append(ctagInfoCompatible.getSyncToken());
                sb2.append("\"}}");
                if (i10 != arrayList.size() - 1) {
                    sb2.append(",");
                }
            }
            str2 = "{\"multistatus\":[" + sb2.toString() + "]}";
        }
        m17710C(Method.LOCK, str, str2, ctagResponse);
        C10812z.m65837f(this.f12938a, str, 0, "", this.f12941d, Method.LOCK, this.f12942e);
        return ctagResponse;
    }

    /* renamed from: e */
    public final void m17713e(StringBuilder sb2) {
        LinkedHashMap<String, String> linkedHashMapM65833b = C10812z.m65833b(this.f12944g);
        String str = linkedHashMapM65833b.get("packageName");
        String str2 = linkedHashMapM65833b.get("versionName");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            m17714f(sb2, Constant.APPVER, str + ":" + str2);
        }
        if (C2984m.m17914h()) {
            String strM17913g = C2984m.m17913g(0, this.f12942e);
            if (TextUtils.isEmpty(strM17913g)) {
                return;
            }
            m17714f(sb2, Constant.STR_GUID, strM17913g);
            m17714f(sb2, Constant.STR_DATA_VER, "1");
            if (SyncLogicServiceUtil.isSupportFileDir(this.f12939b, this.f12940c)) {
                m17714f(sb2, Constant.UNSTR_GUID, strM17913g);
                m17714f(sb2, Constant.UNSTR_DATA_VER, "1");
            }
        }
    }

    /* renamed from: f */
    public final void m17714f(StringBuilder sb2, String str, String str2) {
        sb2.append("\"");
        sb2.append(str);
        sb2.append("\":");
        sb2.append("\"");
        sb2.append(str2);
        sb2.append("\"");
        sb2.append(",");
    }

    /* renamed from: g */
    public final void m17715g() {
        if (C0214f0.m1382b(this.f12938a, "sync_contact_spfile", 0).getBoolean("register_switch_failed", false)) {
            C11839m.m70688i("SyncProtocol", "Last register switch failed, retry");
            ArrayList arrayList = new ArrayList(5);
            arrayList.add("addressbook");
            arrayList.add("wlan");
            arrayList.add("calendar");
            arrayList.add("notepad");
            arrayList.add("browser");
            arrayList.add("atlas");
            arrayList.addAll(NotifyUtil.getShownSyncServiceId(this.f12938a));
            CloudSyncUtil.m15996b1(this.f12938a, arrayList, "03003", this.f12942e);
        }
    }

    /* renamed from: h */
    public final String m17716h(Map<String, List<C2925d>> map, String str, String str2) throws C9722c {
        StringBuilder sb2 = new StringBuilder();
        String[] strArr = {Constant.ADD, Constant.UPDATE, Constant.REMOVE};
        boolean z10 = false;
        for (int i10 = 0; i10 < 3; i10++) {
            String str3 = strArr[i10];
            List<C2925d> list = map.get(str3);
            if (list != null) {
                if (Constant.ADD.equals(str3) || Constant.UPDATE.equals(str3)) {
                    z10 = true;
                }
                String strM17717i = m17717i(list, str3);
                if (!TextUtils.isEmpty(strM17717i)) {
                    sb2.append("\"");
                    sb2.append(str3);
                    sb2.append("\":[");
                    sb2.append(strM17717i);
                    sb2.append("]");
                    sb2.append(",");
                    if (Constant.REMOVE.equals(str3) && SyncLogicService.isSdkSupportRecycleProcess(this.f12944g) && SyncLogicService.isServiceSupportRecycleProcess(this.f12939b)) {
                        sb2.append("\"removeType\":1,");
                    }
                }
            }
        }
        if (TextUtils.isEmpty(sb2)) {
            throw new C9722c(2003, "SyncProtocol encapsulateModifyRequest, request is empty.", str, str2);
        }
        if (z10) {
            m17713e(sb2);
        }
        return "{" + sb2.substring(0, sb2.length() - 1) + "}";
    }

    /* renamed from: i */
    public final String m17717i(List<C2925d> list, String str) {
        StringBuilder sb2 = new StringBuilder(64);
        for (int i10 = 0; i10 < list.size(); i10++) {
            C2925d c2925d = list.get(i10);
            String str2 = TextUtils.isEmpty(c2925d.m17749b()) ? "" : Constant.REMOVE.equals(str) ? "\"" + c2925d.m17749b() + "\"," : "\"guid\":\"" + c2925d.m17749b() + "\",";
            if (!TextUtils.isEmpty(c2925d.m17750c())) {
                str2 = str2 + "\"luid\":" + new Gson().toJson(c2925d.m17750c()) + ",";
            }
            if (!TextUtils.isEmpty(c2925d.m17748a())) {
                str2 = str2 + "\"data\":" + new Gson().toJson(c2925d.m17748a()) + ",";
            }
            if (c2925d.m17751d() != null && !c2925d.m17751d().isEmpty()) {
                StringBuilder sb3 = new StringBuilder();
                for (Map.Entry<String, Object> entry : c2925d.m17751d().entrySet()) {
                    sb3.append("\"" + entry.getKey() + "\":\"" + entry.getValue() + "\",");
                }
                str2 = str2 + "\"props\":{" + sb3.substring(0, sb3.length() - 1) + "},";
            }
            if (!TextUtils.isEmpty(str2)) {
                String strSubstring = Constant.REMOVE.equals(str) ? str2.substring(0, str2.length() - 1) : "{" + str2.substring(0, str2.length() - 1) + "}";
                if (i10 != list.size() - 1) {
                    strSubstring = strSubstring + ",";
                }
                sb2.append(strSubstring);
            }
        }
        return sb2.toString();
    }

    /* renamed from: j */
    public final String m17718j(String str) throws C9722c {
        return C2929h.m17767b(str);
    }

    /* renamed from: k */
    public final int m17719k(List<C2925d> list) throws C9722c {
        if (list == null || list.isEmpty()) {
            return -1;
        }
        if (list.get(0).m17752e() == list.get(list.size() - 1).m17752e()) {
            return list.get(0).m17752e() ? 1 : 0;
        }
        C11839m.m70687e("SyncProtocol", "getDataEncrypted, data both has encrypted and non encrypted data");
        throw new C9722c(2020, "data both has encrypted and non encrypted data");
    }

    /* renamed from: l */
    public final int m17720l(Map<String, List<C2925d>> map) throws C9722c {
        int iM17719k = m17719k(map.get(Constant.ADD));
        int iM17719k2 = m17719k(map.get(Constant.UPDATE));
        if (iM17719k == -1) {
            return iM17719k2;
        }
        if (iM17719k2 == -1 || iM17719k == iM17719k2) {
            return iM17719k;
        }
        C11839m.m70687e("SyncProtocol", "getDataEncrypted, data both has encrypted and non encrypted data");
        throw new C9722c(2020, "data both has encrypted and non encrypted data");
    }

    /* renamed from: m */
    public final boolean m17721m(C2930i c2930i, String str) {
        if (c2930i.m17769b() == 200) {
            return false;
        }
        return (CloudSyncUtil.m16058x0(c2930i.m17769b()) && "POST".equals(str)) ? false : true;
    }

    /* renamed from: n */
    public ModifyResponse m17722n(String str, String str2, Map<String, List<C2925d>> map) throws C9722c {
        String str3 = str + "/" + str2;
        ModifyResponse modifyResponse = new ModifyResponse();
        m17711D("POST", str3, m17716h(map, str3, "POST"), modifyResponse, m17720l(map));
        StringBuilder sb2 = new StringBuilder();
        String[] strArr = {Constant.ADD, Constant.UPDATE, Constant.REMOVE};
        for (int i10 = 0; i10 < 3; i10++) {
            String str4 = strArr[i10];
            List<C2925d> list = map.get(str4);
            if (list != null) {
                sb2.append(str4);
                sb2.append(": ");
                sb2.append(list.size());
                sb2.append(" ");
            }
        }
        C10812z.m65837f(this.f12938a, str3, 0, sb2.toString(), this.f12941d, "POST", this.f12942e);
        C11839m.m70688i("SyncProtocol", "dataType: " + str2 + ", modifyData, " + sb2.toString());
        return modifyResponse;
    }

    /* renamed from: o */
    public final Map<String, CtagInfo> m17723o(ModifyResponse modifyResponse) {
        Map<String, C2926e> map;
        HashMap map2 = new HashMap();
        Map<String, Map<String, C2926e>> map3 = modifyResponse.mapModifyRsp;
        if (map3 != null && (map = map3.get(Constant.UPDATERSP)) != null) {
            for (Map.Entry<String, C2926e> entry : map.entrySet()) {
                C2926e value = entry.getValue();
                CtagInfo ctagInfo = new CtagInfo();
                ctagInfo.setCtagName(entry.getKey());
                ctagInfo.setCtagValue(value.m17756a());
                ctagInfo.setSyncToken(value.m17760e());
                ctagInfo.setStatus(value.m17759d());
                map2.put(entry.getKey(), ctagInfo);
            }
        }
        return map2;
    }

    /* renamed from: p */
    public final void m17724p(DataResponse dataResponse, JSONObject jSONObject) throws JSONException, C9722c {
        JSONArray jSONArray = jSONObject.getJSONArray(Constant.MULTISTATUS);
        dataResponse.mapData = new HashMap();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            C2924c c2924c = new C2924c();
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i10);
            c2924c.m17746f(jSONObject2.getInt("status"));
            if (jSONObject2.has(Constant.PROPS)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(Constant.PROPS);
                c2924c.m17743c(jSONObject3.optString(Constant.DEK));
                if (jSONObject3.has(Constant.FILE_DIR)) {
                    c2924c.m17747g(jSONObject3.getString(Constant.FILE_DIR));
                }
                if (jSONObject3.has("status")) {
                    c2924c.m17744d(jSONObject3.optInt("status"));
                }
                if (jSONObject3.has(Constant.RECYCLE_TIME)) {
                    c2924c.m17745e(jSONObject3.optLong(Constant.RECYCLE_TIME));
                }
            }
            if ("notepad".equals(this.f12939b) && jSONObject2.has(Constant.LUID)) {
                c2924c.m17747g(jSONObject2.getString(Constant.LUID));
            }
            if (jSONObject2.has("data")) {
                c2924c.m17742b(jSONObject2.getString("data"));
            }
            dataResponse.mapData.put(jSONObject2.getString(Constant.GUID), c2924c);
        }
    }

    /* renamed from: q */
    public final void m17725q(EtagResponse etagResponse, boolean z10, JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(Constant.MULTISTATUS);
        etagResponse.cursor = jSONObject.optString(Constant.CURSOR);
        C11839m.m70686d("SyncProtocol", "parseJsonToResponse, cursor: " + etagResponse.cursor);
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Etag etag = new Etag();
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i10);
            etag.setStatus(jSONObject2.getInt("status"));
            JSONObject jSONObject3 = jSONObject2.getJSONObject(Constant.PROPS);
            etag.setEtag(jSONObject3.optString(Constant.ETAG));
            if (jSONObject3.has("uuid")) {
                etag.setUuid(jSONObject3.getString("uuid"));
            }
            if (jSONObject3.has(Constant.OTYPE)) {
                etag.setOperation(jSONObject3.getInt(Constant.OTYPE));
            }
            if (z10) {
                if (jSONObject3.has("status")) {
                    etag.setRecycleStatus(jSONObject3.getInt("status"));
                }
                if (jSONObject3.has(Constant.RECYCLE_TIME)) {
                    etag.setRecycleTime(jSONObject3.getLong(Constant.RECYCLE_TIME));
                }
            }
            etagResponse.mapEtag.put(jSONObject2.getString(Constant.GUID), etag);
        }
    }

    /* renamed from: r */
    public final void m17726r(String str, Response response, String str2, String str3) throws JSONException, C9722c {
        boolean z10 = SyncLogicService.isSdkSupportRecycleProcess(this.f12944g) && SyncLogicService.isServiceSupportRecycleProcess(this.f12939b);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
            response.result.f12964a = jSONObject2.getInt("code");
            response.result.f12965b = jSONObject2.getString("info");
            if (m17721m(response.result, str3)) {
                int i10 = response.result.f12964a;
                if (i10 == 708) {
                    CloudSyncUtil.m16039q(0, i10);
                }
                throw new C12127a(response.result.f12964a, "103", "parseJsonToResponse: " + response.result.f12965b, str2, str3);
            }
            if (!(response instanceof CtagResponse)) {
                if (response instanceof EtagResponse) {
                    m17725q((EtagResponse) response, z10, jSONObject);
                    return;
                }
                if (response instanceof DataResponse) {
                    m17724p((DataResponse) response, jSONObject);
                    return;
                } else if (response instanceof ModifyResponse) {
                    m17728t(jSONObject, (ModifyResponse) response, str2, str3);
                    return;
                } else {
                    if (response instanceof KeepLockResponse) {
                        m17727s(jSONObject, (KeepLockResponse) response, str2, str3);
                        return;
                    }
                    return;
                }
            }
            JSONArray jSONArray = jSONObject.getJSONArray(Constant.MULTISTATUS);
            ((CtagResponse) response).mapCtag = new HashMap();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                Ctag ctag = new Ctag();
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i11);
                ctag.setStatus(jSONObject3.getInt("status"));
                ctag.setExpired(jSONObject3.optBoolean(Constant.EXPIRED, true));
                JSONObject jSONObject4 = jSONObject3.getJSONObject(Constant.PROPS);
                ctag.setCtag(jSONObject4.getString(Constant.CTAG));
                ctag.setSyncToken(jSONObject4.optString(Constant.SYNC_TOKEN));
                ((CtagResponse) response).mapCtag.put(jSONObject3.getString(Constant.GUID), ctag);
            }
            if (jSONObject.has("interval")) {
                ((CtagResponse) response).keepLockResponse = new KeepLockResponse();
                ((CtagResponse) response).keepLockResponse.interval = jSONObject.getInt("interval");
            }
        } catch (JSONException e10) {
            response.result.f12964a = 2107;
            throw new C12127a(2107, e10.toString(), str2, str3);
        }
    }

    /* renamed from: s */
    public final void m17727s(JSONObject jSONObject, KeepLockResponse keepLockResponse, String str, String str2) throws C12127a {
        try {
            if (jSONObject.has("interval")) {
                keepLockResponse.interval = jSONObject.getInt("interval");
                C11839m.m70688i("SyncProtocol", "parseKeepLockResponse: interval = " + keepLockResponse.interval);
            }
        } catch (JSONException e10) {
            keepLockResponse.result.f12964a = 2107;
            throw new C12127a(2107, e10.toString(), str, str2);
        }
    }

    /* renamed from: t */
    public final void m17728t(JSONObject jSONObject, ModifyResponse modifyResponse, String str, String str2) throws C12127a {
        try {
            String[] strArr = {Constant.ADDRSP, Constant.UPDATERSP, Constant.REMOVERSP};
            if (modifyResponse.mapModifyRsp == null) {
                modifyResponse.mapModifyRsp = new HashMap();
            }
            for (int i10 = 0; i10 < 3; i10++) {
                String str3 = strArr[i10];
                if (jSONObject.has(str3)) {
                    modifyResponse.mapModifyRsp.put(str3, m17730v(jSONObject, str3));
                }
            }
        } catch (JSONException e10) {
            modifyResponse.result.f12964a = 2107;
            throw new C12127a(2107, e10.toString(), str, str2);
        }
    }

    /* renamed from: u */
    public final void m17729u(C9721b c9721b, String str, String str2) throws C12128b {
        int iM60659c = c9721b.m60659c();
        if (iM60659c == 1199) {
            throw new C12128b(2028, c9721b.getMessage(), str, str2);
        }
        if (iM60659c == 9000) {
            throw new C12128b(c9721b.m60663g(), "103", c9721b.getMessage(), str, str2);
        }
        if (iM60659c == 9006) {
            throw new C12128b(2104, c9721b.getMessage(), str, str2);
        }
        switch (iM60659c) {
            case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 9002 */:
                throw new C12128b(2103, c9721b.getMessage(), str, str2);
            case 9003:
                throw new C12128b(2101, c9721b.getMessage(), str, str2);
            case ConnectionResult.SERVICE_UPDATING /* 9004 */:
                throw new C12128b(2105, c9721b.getMessage(), str, str2);
            default:
                throw new C12128b(HwConstants.LUNAR_YEAR_MAX, c9721b.getMessage(), str, str2);
        }
    }

    /* renamed from: v */
    public final Map<String, C2926e> m17730v(JSONObject jSONObject, String str) throws JSONException {
        HashMap map = new HashMap();
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        int i10 = 0;
        if (str.equalsIgnoreCase(Constant.ADDRSP)) {
            while (i10 < jSONArray.length()) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i10);
                C2926e c2926e = new C2926e();
                c2926e.m17764i(jSONObject2.getInt("status"));
                c2926e.m17763h(jSONObject2.getString(Constant.LUID));
                if (jSONObject2.has(Constant.PROPS)) {
                    c2926e.m17762g(jSONObject2.getJSONObject(Constant.PROPS).getString(Constant.ETAG));
                }
                if (jSONObject2.has(Constant.GUID)) {
                    map.put(jSONObject2.getString(Constant.GUID), c2926e);
                } else {
                    map.put(jSONObject2.getString(Constant.LUID), c2926e);
                }
                i10++;
            }
        } else if (str.equalsIgnoreCase(Constant.UPDATERSP)) {
            while (i10 < jSONArray.length()) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.get(i10);
                C2926e c2926e2 = new C2926e();
                c2926e2.m17764i(jSONObject3.getInt("status"));
                if (jSONObject3.has(Constant.PROPS)) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject(Constant.PROPS);
                    c2926e2.m17762g(jSONObject4.optString(Constant.ETAG));
                    c2926e2.m17761f(jSONObject4.optString(Constant.CTAG));
                    c2926e2.m17765j(jSONObject4.optString(Constant.SYNC_TOKEN));
                }
                map.put(jSONObject3.getString(Constant.GUID), c2926e2);
                i10++;
            }
        } else if (str.equalsIgnoreCase(Constant.REMOVERSP)) {
            while (i10 < jSONArray.length()) {
                JSONObject jSONObject5 = (JSONObject) jSONArray.get(i10);
                C2926e c2926e3 = new C2926e();
                c2926e3.m17764i(jSONObject5.getInt("status"));
                map.put(jSONObject5.getString(Constant.GUID), c2926e3);
                i10++;
            }
        }
        return map;
    }

    /* renamed from: w */
    public DataResponse m17731w(String str, String str2, List<String> list) throws Throwable {
        StringBuilder sb2;
        String str3 = str + "/" + str2;
        if (list == null || list.isEmpty()) {
            throw new C9722c(2003, "SyncProtocol Download data, guid list is null or empty.", str3, "local_download_struct");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\"");
        sb3.append(list.get(0));
        sb3.append("\"");
        for (int i10 = 1; i10 < list.size(); i10++) {
            sb3.append(",\"");
            sb3.append(list.get(i10));
            sb3.append("\"");
        }
        boolean z10 = SyncLogicService.isSdkSupportRecycleProcess(this.f12944g) && SyncLogicService.isServiceSupportRecycleProcess(this.f12939b);
        if (C10028c.m62182c0().m62420y1()) {
            sb2 = new StringBuilder("{\"guids\":[" + ((Object) sb3));
            if (SyncLogicServiceUtil.isSupportFileDir(str, str2)) {
                sb2.append("], \"propname\":[\"fileDir\"");
                if (z10) {
                    sb2.append(",\"status\"");
                    sb2.append(",\"recycleTime\"");
                }
            } else if (z10) {
                sb2.append("], \"propname\":[\"status\"");
                sb2.append(",\"recycleTime\"");
            }
        } else {
            sb2 = new StringBuilder("{\"guids\":[" + ((Object) sb3) + "], \"propname\":[\"dek\"");
            if (SyncLogicServiceUtil.isSupportFileDir(str, str2)) {
                sb2.append(",\"fileDir\"");
            }
            if (z10) {
                sb2.append(",\"status\"");
                sb2.append(",\"recycleTime\"");
            }
        }
        sb2.append("]}");
        DataResponse dataResponse = new DataResponse();
        m17710C(Method.REPORT, str3, sb2.toString(), dataResponse);
        Map<String, C2924c> map = dataResponse.mapData;
        String str4 = "dataType:" + str2 + ", request data size: " + list.size() + ", response size = " + (map != null ? map.size() : 0);
        C10812z.m65837f(this.f12938a, str3, 0, str4, this.f12941d, Method.REPORT, this.f12942e);
        C11839m.m70688i("SyncProtocol", "queryData, " + str4);
        return dataResponse;
    }

    /* renamed from: x */
    public EtagResponse m17732x(String str, String str2, boolean z10, String str3) throws C9722c {
        C11839m.m70688i("SyncProtocol", "query Etag: " + str2 + ", isQueryIncremental: " + z10);
        EtagResponse etagResponseM17708A = SyncProcessBase.isSyncTokenProcess(str) ? m17708A(str, str2, z10, str3) : m17734z(str, str2);
        Map<String, Etag> map = etagResponseM17708A.mapEtag;
        String str4 = "dataType: " + str2 + ", cloudEtag size: " + (map == null ? -1 : map.size()) + ", isQueryIncremental: " + z10 + ", syncToken: " + str3;
        C10812z.m65837f(this.f12938a, str, 0, str4, this.f12941d, "PROPFIND", this.f12942e);
        C11839m.m70688i("SyncProtocol", "queryEtags, " + str4);
        return etagResponseM17708A;
    }

    /* renamed from: y */
    public Map<String, CtagInfo> m17733y(String str, Map<String, List<C2925d>> map) throws Throwable {
        String strM17716h;
        ModifyResponse modifyResponse = new ModifyResponse();
        if (map == null || map.size() <= 0) {
            strM17716h = "";
        } else {
            strM17716h = m17716h(map, str, Method.UNLOCK);
            C11839m.m70688i("SyncProtocol", "releaseLock: " + str + ", request size = " + map.size());
        }
        if (TextUtils.isEmpty(this.f12943f.m78224J(this.f12939b, this.f12944g))) {
            C11839m.m70689w("SyncProtocol", "LockToken is null or empty, don't need unlock");
            return null;
        }
        m17710C(Method.UNLOCK, str, strM17716h, modifyResponse);
        C10812z.m65837f(this.f12938a, str, 0, "", this.f12941d, Method.UNLOCK, this.f12942e);
        return m17723o(modifyResponse);
    }

    /* renamed from: z */
    public final EtagResponse m17734z(String str, String str2) throws Throwable {
        String str3;
        EtagResponse etagResponse = new EtagResponse();
        boolean z10 = SyncLogicService.isSdkSupportRecycleProcess(this.f12944g) && SyncLogicService.isServiceSupportRecycleProcess(this.f12939b);
        if (z10) {
            str3 = "{\"propname\":[\"etag\", \"uuid\", \"status\", \"recycleTime\"], \"multistatus\":{\"status\":0}}";
        } else {
            str3 = "{\"propname\":[\"etag\", \"uuid\"]}";
        }
        m17710C("PROPFIND", str + "/" + str2, str3, etagResponse);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("queryEtags: isSdkSupportRecycleProcess = ");
        sb2.append(z10);
        C11839m.m70688i("SyncProtocol", sb2.toString());
        return etagResponse;
    }
}
