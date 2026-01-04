package p458lo;

import android.content.Context;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import ck.C1443a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.util.CheckAppStatus;
import com.huawei.hicloud.request.cbs.bean.CBSApkDownloadUrlReq;
import com.huawei.hicloud.request.cbs.bean.CBSAppBaseReq;
import com.huawei.hicloud.request.cbs.bean.CBSAppInfo;
import com.huawei.hicloud.request.cbs.bean.CBSAppMkFileReq;
import com.huawei.hicloud.request.cbs.bean.CBSAppResp;
import com.huawei.hicloud.request.cbs.bean.CBSBackupRecord;
import com.huawei.hicloud.request.cbs.bean.CBSBackupReq;
import com.huawei.hicloud.request.cbs.bean.CBSBaseIdReq;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hicloud.request.cbs.bean.CBSBaseResp;
import com.huawei.hicloud.request.cbs.bean.CBSCheckApkExistReq;
import com.huawei.hicloud.request.cbs.bean.CBSCheckFileExistReq;
import com.huawei.hicloud.request.cbs.bean.CBSCountByDeviceReq;
import com.huawei.hicloud.request.cbs.bean.CBSCreateAppBackupRecordReq;
import com.huawei.hicloud.request.cbs.bean.CBSCreateBackupRecordReq;
import com.huawei.hicloud.request.cbs.bean.CBSDeleteAllBackupReq;
import com.huawei.hicloud.request.cbs.bean.CBSDeleteBackupReq;
import com.huawei.hicloud.request.cbs.bean.CBSDeleteSingleBackupRecordReq;
import com.huawei.hicloud.request.cbs.bean.CBSDevCalllogSmsCount;
import com.huawei.hicloud.request.cbs.bean.CBSDevCount;
import com.huawei.hicloud.request.cbs.bean.CBSDevCountResp;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceOperation;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceRecordsReq;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceRecordsRsp;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceResp;
import com.huawei.hicloud.request.cbs.bean.CBSFileInfo;
import com.huawei.hicloud.request.cbs.bean.CBSFullBackup;
import com.huawei.hicloud.request.cbs.bean.CBSLockAndFlowControlReq;
import com.huawei.hicloud.request.cbs.bean.CBSLockAndFlowControlResp;
import com.huawei.hicloud.request.cbs.bean.CBSLockDeviceBackupReq;
import com.huawei.hicloud.request.cbs.bean.CBSOperation;
import com.huawei.hicloud.request.cbs.bean.CBSQueryAllBackupRecordReq;
import com.huawei.hicloud.request.cbs.bean.CBSQueryAllDevicesBackupRecordReq;
import com.huawei.hicloud.request.cbs.bean.CBSQueryDownLoadParamReq;
import com.huawei.hicloud.request.cbs.bean.CBSQueryRecordDetailCursorReq;
import com.huawei.hicloud.request.cbs.bean.CBSQueryRecordDetailReq;
import com.huawei.hicloud.request.cbs.bean.CBSQueryRecordsResp;
import com.huawei.hicloud.request.cbs.bean.CBSRecoverSmsAndCallReq;
import com.huawei.hicloud.request.cbs.bean.CBSRecoverSmsAndCallResp;
import com.huawei.hicloud.request.cbs.bean.CBSSmsCalllogCountResp;
import com.huawei.hicloud.request.cbs.bean.CBSSmsCalllogReq;
import com.huawei.hicloud.request.cbs.bean.CBSTermsAgreeReq;
import com.huawei.hicloud.request.cbs.bean.CBSUpdateBackupRecordReq;
import com.huawei.hicloud.request.cbs.bean.CBSUpdateFullBackupRecordReq;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import com.huawei.hicloud.request.cbs.bean.CallLogBean;
import com.huawei.hicloud.request.cbs.bean.SmsBean;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mo.C11501a;
import mo.C11502b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p746wn.C13622a;
import p837z9.C14163d;
import pk.C12158a;
import ro.C12612a;
import tm.C13040c;

/* renamed from: lo.a */
/* loaded from: classes6.dex */
public class C11322a {

    /* renamed from: c */
    public static final Gson f53013c = new Gson();

    /* renamed from: a */
    public String f53014a;

    /* renamed from: b */
    public boolean f53015b = false;

    public C11322a() {
    }

    /* renamed from: q */
    public static String m67990q(String str, Object... objArr) {
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

    /* renamed from: r */
    public static <T> T m67991r(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f53013c.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = " + str, "CBSService_fromJson");
        }
    }

    /* renamed from: s */
    public static String m67992s() throws C9721b {
        if (C10028c.m62182c0().m62221H1()) {
            return C13040c.m78609F().m78665r();
        }
        throw new C9721b(1101, "terms is not confirmed.");
    }

    /* renamed from: u */
    public static Context m67993u() {
        return C0213f.m1377a();
    }

    /* renamed from: A */
    public final CBSBackupRecord m67994A(ArrayList<CBSBackupRecord> arrayList) throws C9721b {
        if (arrayList == null) {
            throw new C9721b(3107, "query backupRecordDetailReq return null.", "mergeRecords");
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        CBSBackupRecord cBSBackupRecord = arrayList.get(0);
        HashMap map = new HashMap();
        Iterator<CBSBackupRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            for (CBSAppInfo cBSAppInfo : it.next().getAppIdInfos()) {
                String appId = cBSAppInfo.getAppId();
                if (map.containsKey(appId)) {
                    CBSAppInfo cBSAppInfo2 = (CBSAppInfo) map.get(appId);
                    if (cBSAppInfo.getFileInfos() != null) {
                        if (cBSAppInfo2.getFileInfos() != null) {
                            cBSAppInfo2.getFileInfos().addAll(cBSAppInfo.getFileInfos());
                        } else {
                            cBSAppInfo2.setFileInfos(cBSAppInfo.getFileInfos());
                        }
                    }
                } else {
                    map.put(appId, cBSAppInfo);
                }
            }
        }
        cBSBackupRecord.getAppIdInfos().clear();
        cBSBackupRecord.getAppIdInfos().addAll(map.values());
        return cBSBackupRecord;
    }

    /* renamed from: B */
    public final String m67995B(String str) throws C9721b {
        try {
            return C13195l.m79272J().m79344y("CBS1", str);
        } catch (C13194k e10) {
            C11839m.m70687e("CBSService", "onAccessToken error: " + e10.toString());
            if (e10.m79269b() == 1199) {
                throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
            }
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            C11839m.m70687e("CBSService", "onAccessToken error: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: C */
    public final String m67996C(String str, String str2) throws C9721b {
        try {
            return C13195l.m79272J().m79290C(str2, "CBS2", str);
        } catch (C13194k e10) {
            C11839m.m70687e("CBSService", "onAccessTokenWithId error: " + e10.toString());
            if (e10.m79269b() == 1199) {
                throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
            }
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            C11839m.m70687e("CBSService", "onAccessTokenWithId error: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: D */
    public List<CBSBackupRecord> m67997D(boolean z10, boolean z11) throws C9721b {
        return m67998E(z10, z11, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [int] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* renamed from: E */
    public List<CBSBackupRecord> m67998E(boolean z10, boolean z11, boolean z12) throws C9721b {
        ?? r62 = z12;
        if (C9733f.m60705z().m60720O("backupContainOhInterimRecords")) {
            r62 = z12 ? 3 : 0;
        }
        try {
            List<CBSBackupRecord> backupRecords = ((CBSQueryRecordsResp) m67991r(m68035w(z10 ? new CBSQueryAllDevicesBackupRecordReq(36, "QueryAllDevicesBackupRecordReq", z11, r62) : new CBSQueryAllBackupRecordReq(22, "QueryAllBackupRecordReq", z11, r62)), CBSQueryRecordsResp.class)).getBackupRecords();
            if (backupRecords == null) {
                throw new C9721b(3101, "query record details is empty.", "CBSService_queryAllBackupRecordReq");
            }
            for (CBSBackupRecord cBSBackupRecord : backupRecords) {
                CBSDevice device = cBSBackupRecord.getDevice();
                if (device != null) {
                    String terminalType = device.getTerminalType();
                    if (terminalType != null && "LON-AL00-PD".equals(terminalType.trim())) {
                        terminalType = "LON-AL00";
                    }
                    if ("LON-L29-PD".equals(terminalType)) {
                        terminalType = "LON-L29";
                    }
                    device.setTerminalType(terminalType);
                    cBSBackupRecord.setDevice(device);
                }
            }
            return backupRecords;
        } catch (JsonSyntaxException e10) {
            C11839m.m70688i("CBSService", "queryAllBackupRecordReq, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err");
        }
    }

    /* renamed from: F */
    public String m67999F(String str) throws C9721b {
        if (str == null || str.isEmpty()) {
            throw new C9721b(3101, "query apk downloadFile url path is null.", "CBSService_queryApkDownloadUrlReq");
        }
        try {
            return new JSONObject(m68035w(new CBSApkDownloadUrlReq(m68033t(), String.valueOf(C13452e.m80781L().m80947n0()), str))).getString("url");
        } catch (JSONException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "query apk downloadFile url json error. " + e10.getMessage(), "CBSService_queryApkDownloadUrlReq");
        }
    }

    /* renamed from: G */
    public final CBSBackupRecord m68000G(String str, int i10, String str2) throws C9721b {
        CBSQueryRecordDetailReq cBSQueryRecordDetailReq = new CBSQueryRecordDetailReq(str, i10, str2);
        cBSQueryRecordDetailReq.setConvertUrl(false);
        cBSQueryRecordDetailReq.setQueryFiles(false);
        cBSQueryRecordDetailReq.setClientIp(m68033t());
        cBSQueryRecordDetailReq.setIncludeArk(true);
        cBSQueryRecordDetailReq.setSiteID(String.valueOf(C13452e.m80781L().m80947n0()));
        try {
            List<CBSBackupRecord> backupRecords = ((CBSQueryRecordsResp) m67991r(m68035w(cBSQueryRecordDetailReq), CBSQueryRecordsResp.class)).getBackupRecords();
            if (backupRecords.isEmpty()) {
                throw new C9721b(3101, "query record details is empty.", "CBSService_queryBackupRecordDetailReq");
            }
            CBSBackupRecord cBSBackupRecord = backupRecords.get(0);
            CBSDevice device = cBSBackupRecord.getDevice();
            if (device != null) {
                String terminalType = device.getTerminalType();
                if (terminalType != null && "LON-AL00-PD".equals(terminalType.trim())) {
                    terminalType = "LON-AL00";
                }
                if ("LON-L29-PD".equals(terminalType)) {
                    terminalType = "LON-L29";
                }
                device.setTerminalType(terminalType);
                cBSBackupRecord.setDevice(device);
            }
            return cBSBackupRecord;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "queryBackupRecordDetailReq, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = ");
        }
    }

    /* renamed from: H */
    public CBSBackupRecord m68001H(String str, int i10, String str2, boolean z10, boolean z11) throws C9721b {
        List<CBSAppInfo> list;
        if (!z10) {
            return m68000G(str, i10, str2);
        }
        Iterator<CBSBackupRecord> it = m67997D(false, z11).iterator();
        while (true) {
            if (!it.hasNext()) {
                list = null;
                break;
            }
            CBSBackupRecord next = it.next();
            if (next.getDevice().getDeviceId().equals(str) && str2.equals(next.getBackupId())) {
                List<CBSAppInfo> appIdInfos = next.getAppIdInfos();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("appIdInfos.size = ");
                sb2.append(appIdInfos != null ? Integer.valueOf(appIdInfos.size()) : null);
                C11839m.m70688i("CBSService", sb2.toString());
                list = appIdInfos;
            }
        }
        ArrayList<CBSBackupRecord> arrayList = new ArrayList<>();
        HashMap map = new HashMap();
        int i11 = 0;
        int i12 = 0;
        while (list != null && i12 < list.size()) {
            map.put(list.get(i12).getAppId(), 0);
            int i13 = i11;
            while (map.size() == 30) {
                m68002I(str, i10, str2, map, arrayList);
                i13++;
            }
            i12++;
            i11 = i13;
        }
        if (map.size() < 30) {
            int i14 = i11;
            while (map.size() > 0) {
                m68002I(str, i10, str2, map, arrayList);
                i14++;
            }
            i11 = i14;
        }
        C11839m.m70688i("CBSService", "queryBackupRecordDetailReqCursor times " + i11);
        return m67994A(arrayList);
    }

    /* renamed from: I */
    public final void m68002I(String str, int i10, String str2, Map<String, Integer> map, ArrayList<CBSBackupRecord> arrayList) throws C9721b {
        int iM80947n0 = C13452e.m80781L().m80947n0();
        CBSQueryRecordDetailCursorReq cBSQueryRecordDetailCursorReq = new CBSQueryRecordDetailCursorReq(str, i10, str2, map);
        cBSQueryRecordDetailCursorReq.setQueryFiles(true);
        cBSQueryRecordDetailCursorReq.setClientIp(m68033t());
        cBSQueryRecordDetailCursorReq.setSiteID(String.valueOf(iM80947n0));
        try {
            CBSBackupRecord cBSBackupRecord = ((CBSQueryRecordsResp) m67991r(m68035w(cBSQueryRecordDetailCursorReq), CBSQueryRecordsResp.class)).getBackupRecords().get(0);
            CBSDevice device = cBSBackupRecord.getDevice();
            if (device != null) {
                String terminalType = device.getTerminalType();
                if (terminalType != null && "LON-AL00-PD".equals(terminalType.trim())) {
                    terminalType = "LON-AL00";
                }
                if ("LON-L29-PD".equals(terminalType)) {
                    terminalType = "LON-L29";
                }
                device.setTerminalType(terminalType);
                cBSBackupRecord.setDevice(device);
            }
            arrayList.add(cBSBackupRecord);
            for (CBSAppInfo cBSAppInfo : cBSBackupRecord.getAppIdInfos()) {
                if (cBSAppInfo.getCursor() == -1) {
                    map.remove(cBSAppInfo.getAppId());
                } else {
                    map.put(cBSAppInfo.getAppId(), Integer.valueOf(cBSAppInfo.getCursor()));
                }
            }
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "queryBackupRecordDetailReqCursor, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = ");
        }
    }

    /* renamed from: J */
    public CBSDeviceRecordsRsp m68003J() throws JSONException, C9721b {
        CBSDeviceRecordsReq cBSDeviceRecordsReq = new CBSDeviceRecordsReq("1.0");
        CBSDeviceRecordsRsp cBSDeviceRecordsRsp = new CBSDeviceRecordsRsp();
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(m68035w(cBSDeviceRecordsReq));
            cBSDeviceRecordsRsp.setResult(jSONObject.getInt("result"));
            JSONArray jSONArray = jSONObject.getJSONArray("deviceOperations");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                CBSDeviceOperation cBSDeviceOperationM68034v = m68034v(jSONArray.getJSONObject(i10));
                if (cBSDeviceOperationM68034v != null) {
                    arrayList.add(cBSDeviceOperationM68034v);
                }
            }
            C11839m.m70688i("CBSService", "deviceOperations size :" + arrayList.size());
            cBSDeviceRecordsRsp.setDeviceOperations(arrayList);
            return cBSDeviceRecordsRsp;
        } catch (JSONException e10) {
            C11839m.m70687e("CBSService", "queryDeviceOperationRecords json exception :" + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "queryDeviceOperationRecords json error. " + e10.getMessage(), "CBSService_queryDeviceOperationRecords");
        }
    }

    /* renamed from: K */
    public List<CBSDevice> m68004K() throws C9721b {
        try {
            List<CBSDevice> deviceList = ((CBSDeviceResp) m67991r(m68035w(new CBSBaseReq(6, "QueryDeviceReq")), CBSDeviceResp.class)).getDeviceList();
            for (CBSDevice cBSDevice : deviceList) {
                String terminalType = cBSDevice.getTerminalType();
                if ("LON-AL00-PD".equals(terminalType)) {
                    terminalType = "LON-AL00";
                }
                if ("LON-L29-PD".equals(terminalType)) {
                    terminalType = "LON-L29";
                }
                cBSDevice.setTerminalType(terminalType);
            }
            return deviceList;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "queryDeviceReq, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = ");
        }
    }

    /* renamed from: L */
    public String m68005L(String str) throws C9721b {
        try {
            CBSQueryDownLoadParamReq cBSQueryDownLoadParamReq = new CBSQueryDownLoadParamReq(str);
            C11839m.m70686d("CBSService", "queryDownloadParamReq req: " + cBSQueryDownLoadParamReq.toString());
            return new JSONObject(m68035w(cBSQueryDownLoadParamReq)).getString("url");
        } catch (JSONException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, e10.getMessage(), " queryDownloadParamReq err. ");
        }
    }

    /* renamed from: M */
    public CBSAppResp m68006M(CBSAppBaseReq cBSAppBaseReq) throws C9721b {
        cBSAppBaseReq.setCmd(46);
        cBSAppBaseReq.setInfo("QueryUploadParamReq");
        cBSAppBaseReq.setUserAgent(C1443a.f6213a);
        try {
            return (CBSAppResp) m67991r(m68035w(cBSAppBaseReq), CBSAppResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "queryUploadParamReq, json exception is: " + e10.toString());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err");
        }
    }

    /* renamed from: N */
    public CBSRecoverSmsAndCallResp m68007N(String str, int i10, Long l10, int i11, String str2) throws C9721b {
        try {
            return (CBSRecoverSmsAndCallResp) m67991r(m68035w(new CBSRecoverSmsAndCallReq(str, i10, l10, str2, 100, i11, 8, "RecoverReq")), CBSRecoverSmsAndCallResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "recoverSmsAndCall, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = ");
        }
    }

    /* renamed from: O */
    public final String m68008O(String str, C11060c c11060c, String str2) throws C9721b {
        try {
            CBSBaseResp cBSBaseResp = (CBSBaseResp) m67991r(str, CBSBaseResp.class);
            int result = cBSBaseResp.getResult();
            if (c11060c != null) {
                c11060c.m66665u("102_" + result);
                c11060c.m66635A(cBSBaseResp.toString());
            }
            String strM67992s = m67992s();
            if (result != 0) {
                if (result == 611) {
                    if (!this.f53015b) {
                        C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
                        throw new C9721b(3110, result, cBSBaseResp.toString(), str2);
                    }
                    C11839m.m70688i("CBSService", "ignore 611 errCode cmd: " + str2);
                    return str;
                }
                if (result == 708) {
                    C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
                    throw new C9721b(3111, result, cBSBaseResp.toString(), str2);
                }
                if (result == 999) {
                    C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
                    if ("QueryRecordDetailReq".equals(str2)) {
                        throw new C9721b(3109, result, cBSBaseResp.toString(), str2);
                    }
                    throw new C9721b(3107, result, cBSBaseResp.toString(), str2);
                }
                if (result == 401) {
                    C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
                    m68009P();
                    throw new C9721b(3100, cBSBaseResp.toString(), str2);
                }
                if (result == 402) {
                    throw new C9721b(1202, cBSBaseResp.toString(), str2);
                }
                if (result == 601) {
                    C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
                    throw new C9721b(3109, result, cBSBaseResp.toString(), str2);
                }
                if (result != 602 && result != 604 && result != 605 && result != 701 && result != 702) {
                    if (result != 800 && result != 801) {
                        C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
                        throw new C9721b(3107, result, cBSBaseResp.toString(), str2);
                    }
                    C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
                    C14163d.m84990g().m85019y(result);
                    throw new C9721b(3309, cBSBaseResp.toString(), str2);
                }
            }
            return str;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "result, json exception is: " + e10.toString());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err");
        }
    }

    /* renamed from: P */
    public final void m68009P() {
        C13452e.m80781L().m80980v1();
        C13452e.m80781L().m80972t1();
    }

    /* renamed from: Q */
    public final String m68010Q(int i10, String str, String str2, C11060c c11060c) throws C9721b {
        String strM67992s = m67992s();
        int i11 = 1;
        while (true) {
            String cmdServicIdName = CBSBaseReq.getCmdServicIdName(i10);
            String strM67995B = TextUtils.isEmpty(cmdServicIdName) ? m67995B(str) : m67996C(str, cmdServicIdName);
            try {
                C11839m.m70688i("CBSService", m67990q(strM67992s, str, "x-hw-trace-id = ", c11060c.m66661q()));
                C11839m.m70686d("CBSService", m67990q(str, str2));
                String str3 = (String) C12612a.m76107g(strM67992s, new C11501a(strM67995B, str, str2, c11060c.m66661q()), c11060c);
                C11839m.m70686d("CBSService", m67990q(str, str3));
                if (str3 == null || str3.isEmpty()) {
                    throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null", str);
                }
                return m68008O(str3, c11060c, str);
            } catch (C9721b e10) {
                if (1202 != e10.m60659c()) {
                    break;
                }
                int i12 = i11 + 1;
                if (i11 >= 3) {
                    break;
                }
                C11839m.m70687e("CBSService", " [AT OPERATION] at invalid retry: " + i12);
                C13195l.m79272J().m79325o0(strM67995B);
                i11 = i12;
                throw e10;
            } catch (Exception e11) {
                C11839m.m70687e("CBSService", m67990q(str, e11));
                throw new C9721b(4001, e11.getMessage(), str);
            }
        }
    }

    /* renamed from: R */
    public void m68011R(boolean z10) {
        this.f53015b = z10;
    }

    /* renamed from: S */
    public CBSSmsCalllogCountResp m68012S() throws C9721b {
        ArrayList arrayList = new ArrayList();
        arrayList.add(NavigationUtils.SMS_SCHEMA_PREF);
        arrayList.add("callLog");
        try {
            return (CBSSmsCalllogCountResp) m67991r(m68035w(new CBSSmsCalllogReq(4, "QueryRecoverCountReq", arrayList, System.currentTimeMillis())), CBSSmsCalllogCountResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "smsAndCalllogCountReq, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = ");
        }
    }

    /* renamed from: T */
    public void m68013T(String str, String str2, int i10, int i11) throws Throwable {
        CBSLockDeviceBackupReq cBSLockDeviceBackupReq = new CBSLockDeviceBackupReq(30, "UnLockDeviceBackupReq ", i11);
        cBSLockDeviceBackupReq.setDeviceId(str);
        cBSLockDeviceBackupReq.setDeviceType(i10);
        if (str2 == null) {
            str2 = "";
        }
        cBSLockDeviceBackupReq.setBackupId(str2);
        m68035w(cBSLockDeviceBackupReq);
    }

    /* renamed from: U */
    public void m68014U(String str, String str2, int i10, int i11, List<String> list, int i12, String str3) throws Throwable {
        CBSUpdateBackupRecordReq cBSUpdateBackupRecordReq = new CBSUpdateBackupRecordReq(str, str2, i10, i11, i12, str3);
        cBSUpdateBackupRecordReq.setClientActions(list);
        m68035w(cBSUpdateBackupRecordReq);
    }

    /* renamed from: V */
    public void m68015V(String str, String str2, int i10, int i11, int i12, String str3) throws Throwable {
        m68035w(new CBSUpdateBackupRecordReq(str, str2, i10, i11, i12, str3));
    }

    /* renamed from: W */
    public void m68016W(String str, String str2, int i10, int i11, int i12, List<String> list, int i13, String str3) throws Throwable {
        CBSUpdateFullBackupRecordReq cBSUpdateFullBackupRecordReq = new CBSUpdateFullBackupRecordReq(str, str2, i10, i11, i12, i13, str3);
        cBSUpdateFullBackupRecordReq.setClientActions(list);
        m68035w(cBSUpdateFullBackupRecordReq);
    }

    /* renamed from: a */
    public boolean m68017a(Map<String, String> map) throws Throwable {
        C11839m.m70688i("CBSService", "Agree to terms report");
        CBSTermsAgreeReq cBSTermsAgreeReq = new CBSTermsAgreeReq();
        String strM80942m = C13452e.m80781L().m80942m();
        if (!TextUtils.isEmpty(strM80942m) && !map.isEmpty()) {
            cBSTermsAgreeReq.setAgrType(map);
            cBSTermsAgreeReq.setCountry(strM80942m);
            try {
                m68035w(cBSTermsAgreeReq);
                return true;
            } catch (C9721b e10) {
                C11839m.m70687e("CBSService", "agree to terms error: " + e10.getMessage());
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m68018b(CBSAppMkFileReq cBSAppMkFileReq) throws Throwable {
        m68035w(cBSAppMkFileReq);
    }

    /* renamed from: c */
    public void m68019c(List<CallLogBean> list) throws Throwable {
        m68035w(new CBSBackupReq(2, "BackupReq", list));
    }

    /* renamed from: d */
    public CBSBaseResp m68020d(List<SmsBean> list) throws C9721b {
        try {
            return (CBSBaseResp) m67991r(m68035w(new CBSBackupReq(list, 2, "BackupReq")), CBSBaseResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "backupSmsReq, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = ");
        }
    }

    /* renamed from: e */
    public String m68021e(String str, String str2, String str3, String str4, String str5) throws C9721b {
        CBSCheckApkExistReq cBSCheckApkExistReq = new CBSCheckApkExistReq();
        cBSCheckApkExistReq.setFilePath(str);
        cBSCheckApkExistReq.setApkHash(str2);
        cBSCheckApkExistReq.setApkMd5(str3);
        cBSCheckApkExistReq.setClientIp(m68033t());
        cBSCheckApkExistReq.setPackageName(str4);
        cBSCheckApkExistReq.setVersionCode(str5);
        cBSCheckApkExistReq.setSiteID(String.valueOf(C13452e.m80781L().m80947n0()));
        cBSCheckApkExistReq.setEmuiVer(C0209d.m1186L());
        cBSCheckApkExistReq.setAndroidVer(C0209d.m1284n0());
        try {
            JSONObject jSONObject = new JSONObject(m68035w(cBSCheckApkExistReq));
            return jSONObject.getInt("apkType") == 1 ? !jSONObject.getBoolean("exist") ? C12158a.m72864a(jSONObject.getString("upUrl"), Constants.UTF_8) : FaqConstants.DISABLE_HA_REPORT : "false";
        } catch (JSONException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, e10.getMessage(), "CBSService_checkApkExist");
        }
    }

    /* renamed from: f */
    public String m68022f(String str, String str2) throws C9721b {
        CBSCheckFileExistReq cBSCheckFileExistReq = new CBSCheckFileExistReq(str, str2);
        cBSCheckFileExistReq.setClientIp(m68033t());
        cBSCheckFileExistReq.setUserID(String.valueOf(C13452e.m80781L().m80947n0()));
        try {
            JSONObject jSONObject = new JSONObject(m68035w(cBSCheckFileExistReq));
            return !jSONObject.getBoolean("exist") ? C12158a.m72864a(jSONObject.getString("upUrl"), Constants.UTF_8) : FaqConstants.DISABLE_HA_REPORT;
        } catch (JSONException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, e10.getMessage(), "CBSService_checkFileExist");
        }
    }

    /* renamed from: g */
    public boolean m68023g(CBSAppBaseReq cBSAppBaseReq) throws C9721b {
        try {
            cBSAppBaseReq.setCmd(45);
            cBSAppBaseReq.setInfo("CheckFileExistV2Req");
            return new JSONObject(m68035w(cBSAppBaseReq)).getBoolean("exist");
        } catch (JSONException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, e10.getMessage(), " checkFileExistV2Req err. ");
        }
    }

    /* renamed from: h */
    public final C9721b m68024h(String str, C9721b c9721b) {
        int iM60659c = c9721b.m60659c();
        if (iM60659c == 404) {
            return new C9721b(404, c9721b.getMessage(), str);
        }
        if (iM60659c != 1102 && iM60659c != 1107) {
            if (iM60659c == 1199) {
                return new C9721b(1104, c9721b.getMessage(), str);
            }
            if (iM60659c != 3009) {
                if (iM60659c == 3012) {
                    return new C9721b(3101, c9721b.getMessage(), str);
                }
                if (iM60659c != 3100 && iM60659c != 3107 && iM60659c != 3309) {
                    if (iM60659c == 9005) {
                        return new C9721b(3105, c9721b.getMessage(), str);
                    }
                    if (iM60659c != 1201 && iM60659c != 1202) {
                        if (iM60659c == 4000 || iM60659c == 4001) {
                            return new C9721b(3107, c9721b.m60663g(), m67990q(str, Integer.valueOf(c9721b.m60663g()), c9721b.getMessage()));
                        }
                        switch (iM60659c) {
                            case 3109:
                            case 3110:
                            case 3111:
                                break;
                            default:
                                switch (iM60659c) {
                                    case ConnectionResult.NETWORK_ERROR /* 9000 */:
                                        return new C9721b(3106, c9721b.m60663g(), m67990q(str, Integer.valueOf(c9721b.m60663g()), c9721b.getMessage()));
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
            }
        }
        return c9721b;
    }

    /* renamed from: i */
    public CBSDevCalllogSmsCount m68025i(String str, List<CBSDevice> list) throws C9721b {
        try {
            CBSDevCountResp cBSDevCountResp = (CBSDevCountResp) m67991r(m68035w(new CBSCountByDeviceReq(str, 9, "CountByDeviceReq", list)), CBSDevCountResp.class);
            CBSDevCalllogSmsCount cBSDevCalllogSmsCount = new CBSDevCalllogSmsCount();
            List<CBSDevCount> countRet = cBSDevCountResp.getCountRet();
            List<CBSDevice> notQuaryDeviceList = cBSDevCountResp.getNotQuaryDeviceList();
            Iterator<CBSDevCount> it = countRet.iterator();
            while (it.hasNext()) {
                CBSDevice device = it.next().getDevice();
                if (device != null) {
                    String terminalType = device.getTerminalType();
                    if ("LON-AL00-PD".equals(terminalType)) {
                        terminalType = "LON-AL00";
                    }
                    if ("LON-L29-PD".equals(terminalType)) {
                        terminalType = "LON-L29";
                    }
                    device.setTerminalType(terminalType);
                }
            }
            cBSDevCalllogSmsCount.setCountRet(countRet);
            cBSDevCalllogSmsCount.setNotQuaryDeviceList(notQuaryDeviceList);
            cBSDevCalllogSmsCount.setInfo(cBSDevCountResp.getInfo());
            cBSDevCalllogSmsCount.setResult(cBSDevCountResp.getResult());
            return cBSDevCalllogSmsCount;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "countByCalllogSmsDeviceReq, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = ");
        }
    }

    /* renamed from: j */
    public List<CBSDevCount> m68026j(String str) throws C9721b {
        try {
            List<CBSDevCount> countRet = ((CBSDevCountResp) m67991r(m68035w(new CBSCountByDeviceReq(str, 9, "CountByDeviceReq")), CBSDevCountResp.class)).getCountRet();
            Iterator<CBSDevCount> it = countRet.iterator();
            while (it.hasNext()) {
                CBSDevice device = it.next().getDevice();
                if (device != null) {
                    String terminalType = device.getTerminalType();
                    if ("LON-AL00-PD".equals(terminalType)) {
                        terminalType = "LON-AL00";
                    }
                    if ("LON-L29-PD".equals(terminalType)) {
                        terminalType = "LON-L29";
                    }
                    device.setTerminalType(terminalType);
                }
            }
            return countRet;
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "countByDeviceReq, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err");
        }
    }

    /* renamed from: k */
    public void m68027k(CBSCreateAppBackupRecordReq cBSCreateAppBackupRecordReq) throws Throwable {
        C11839m.m70688i("CBSService", "createAppBackupRecordReq begin");
        List<CBSAppInfo> appIdInfos = cBSCreateAppBackupRecordReq.getAppIdInfos();
        String backupId = cBSCreateAppBackupRecordReq.getBackupId();
        String deviceId = cBSCreateAppBackupRecordReq.getDeviceId();
        int deviceType = cBSCreateAppBackupRecordReq.getDeviceType();
        CBSCreateAppBackupRecordReq cBSCreateAppBackupRecordReq2 = new CBSCreateAppBackupRecordReq(backupId, deviceId, deviceType);
        int size = 0;
        int i10 = 1;
        for (int i11 = 0; i11 < appIdInfos.size(); i11++) {
            CBSAppInfo cBSAppInfo = appIdInfos.get(i11);
            List<CBSFileInfo> fileInfos = cBSAppInfo.getFileInfos();
            while (fileInfos.size() + size > 100) {
                int i12 = 100 - size;
                cBSAppInfo.setFileInfos(fileInfos.subList(0, i12));
                fileInfos = fileInfos.subList(i12, fileInfos.size());
                cBSCreateAppBackupRecordReq2.addAppIdInfos(cBSAppInfo);
                C11839m.m70688i("CBSService", "createAppBackupRecordReq batch " + i10);
                m68035w(cBSCreateAppBackupRecordReq2);
                cBSCreateAppBackupRecordReq2 = new CBSCreateAppBackupRecordReq(backupId, deviceId, deviceType);
                i10++;
                size = 0;
            }
            cBSAppInfo.setFileInfos(fileInfos);
            cBSCreateAppBackupRecordReq2.addAppIdInfos(cBSAppInfo);
            size += fileInfos.size();
            if (size == 100 || i11 == appIdInfos.size() - 1) {
                C11839m.m70688i("CBSService", "createAppBackupRecordReq batch " + i10);
                m68035w(cBSCreateAppBackupRecordReq2);
                cBSCreateAppBackupRecordReq2 = new CBSCreateAppBackupRecordReq(backupId, deviceId, deviceType);
                i10++;
                size = 0;
            }
        }
    }

    /* renamed from: l */
    public String m68028l(String str, int i10, String str2) throws C9721b {
        CBSCreateBackupRecordReq cBSCreateBackupRecordReq = new CBSCreateBackupRecordReq();
        cBSCreateBackupRecordReq.setCBSDeviceID(str);
        cBSCreateBackupRecordReq.setDeviceType(i10);
        cBSCreateBackupRecordReq.setExtend(str2);
        try {
            return new JSONObject(m68035w(cBSCreateBackupRecordReq)).getString("backupId");
        } catch (JSONException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "create backup record json error. " + e10.getMessage(), "CBSService_createBackupRecordReq");
        }
    }

    /* renamed from: m */
    public CBSBaseResp m68029m(String str) throws C9721b {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        try {
            return (CBSBaseResp) m67991r(m68035w(new CBSDeleteAllBackupReq(arrayList, 5, "DeleteBackupReq")), CBSBaseResp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "deleteAllBackupReq, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = ");
        }
    }

    /* renamed from: n */
    public void m68030n(String str, int i10, String str2) throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        m68035w(new CBSDeleteBackupReq(str, i10, arrayList, 5, "DeleteBackupReq"));
    }

    /* renamed from: o */
    public void m68031o(String str, int i10) throws C9721b {
        CBSBaseIdReq cBSBaseIdReq = new CBSBaseIdReq(27, "DeleteDeviceBackupRecordReq ");
        cBSBaseIdReq.setDeviceId(str);
        cBSBaseIdReq.setDeviceType(i10);
        m68035w(cBSBaseIdReq);
    }

    /* renamed from: p */
    public void m68032p(String str, int i10, String str2) throws C9721b {
        m68035w(new CBSDeleteSingleBackupRecordReq(str, i10, str2));
    }

    /* renamed from: t */
    public final String m68033t() {
        WifiManager wifiManager = (WifiManager) C0213f.m1377a().getSystemService(C6661f.f30885g);
        WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
        StringBuilder sb2 = new StringBuilder();
        if (connectionInfo != null) {
            int ipAddress = connectionInfo.getIpAddress();
            sb2.append(ipAddress & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            sb2.append(".");
            sb2.append((ipAddress >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            sb2.append(".");
            sb2.append((ipAddress >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            sb2.append(".");
            sb2.append((ipAddress >> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        }
        return sb2.toString();
    }

    /* renamed from: v */
    public final CBSDeviceOperation m68034v(JSONObject jSONObject) throws JSONException {
        CBSDeviceOperation cBSDeviceOperation = new CBSDeviceOperation();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("device");
            if (!jSONObject.has("operations")) {
                return null;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("operations");
            if (jSONArray.length() <= 0) {
                return null;
            }
            CBSDevice cBSDevice = new CBSDevice();
            cBSDevice.setAliasName(jSONObject2.getString("aliasName"));
            cBSDevice.setDeviceId(jSONObject2.getString("deviceId"));
            String string = jSONObject2.getString("terminalType");
            if (string != null && "LON-AL00-PD".equals(string.trim())) {
                string = "LON-AL00";
            }
            if ("LON-L29-PD".equals(string)) {
                string = "LON-L29";
            }
            cBSDevice.setTerminalType(string);
            cBSDevice.setDeviceCategory(jSONObject2.getString("deviceCategory"));
            cBSDeviceOperation.setDevice(cBSDevice);
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                CBSOperation cBSOperation = new CBSOperation();
                JSONObject jSONObject3 = jSONArray.getJSONObject(i10);
                cBSOperation.setCreateTime(jSONObject3.getLong("createTime"));
                cBSOperation.setDataType(jSONObject3.getInt("dataType"));
                cBSOperation.setOperationType(jSONObject3.getInt("operationType"));
                arrayList.add(cBSOperation);
            }
            cBSDeviceOperation.setOprations(arrayList);
            return cBSDeviceOperation;
        } catch (JSONException e10) {
            C11839m.m70687e("CBSService", "getDeviceOperation json error. " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: w */
    public final String m68035w(CBSBaseReq cBSBaseReq) throws Throwable {
        new CheckAppStatus().checkAllSendToFile();
        String str = this.f53014a;
        C11060c c11060cM66626a = C11058a.m66626a((str == null || str.isEmpty()) ? C11058a.m66627b("00000") : this.f53014a, cBSBaseReq.getInfo(), C13452e.m80781L().m80971t0());
        try {
            return m68010Q(cBSBaseReq.getCmd(), cBSBaseReq.getInfo(), cBSBaseReq.toString(), c11060cM66626a);
        } catch (C9721b e10) {
            C9721b c9721bM68024h = this.m68024h(cBSBaseReq.getInfo(), e10);
            C11839m.m70687e("CBSService", m67990q(cBSBaseReq.getInfo(), c9721bM68024h));
            c11060cM66626a.m66665u("102_" + c9721bM68024h.m60659c());
            c11060cM66626a.m66635A(e10.getMessage());
            C13622a.m81968n(m67993u(), c11060cM66626a);
            throw c9721bM68024h;
        }
    }

    /* renamed from: x */
    public CBSLockAndFlowControlResp m68036x(CBSbkFlowHead cBSbkFlowHead, CBSLockAndFlowControlReq cBSLockAndFlowControlReq) throws C9721b {
        new CheckAppStatus().checkAllSendToFile();
        String str = this.f53014a;
        C11060c c11060cM66626a = C11058a.m66626a((str == null || str.isEmpty()) ? C11058a.m66627b("00000") : this.f53014a, "keepLock", C13452e.m80781L().m80971t0());
        String strM67992s = m67992s();
        if (TextUtils.isEmpty(strM67992s)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getCBSAdress cbs url is empty");
        }
        Uri uri = Uri.parse(strM67992s);
        String str2 = uri.getScheme() + "://" + uri.getAuthority() + CBSbkFlowHead.FLOW_CONTROL_PATH;
        int i10 = 1;
        while (true) {
            try {
                String strM67996C = m67996C(CBSbkFlowHead.FLOW_CONTROL_PATH, "com.huawei.hidisk.backup");
                try {
                    C11839m.m70688i("CBSService", m67990q(str2, CBSbkFlowHead.FLOW_CONTROL_PATH, "x-hw-trace-id = ", c11060cM66626a.m66661q()));
                    cBSbkFlowHead.setTraceID(this.f53014a);
                    cBSbkFlowHead.setAccessToken(strM67996C);
                    String str3 = (String) C12612a.m76107g(str2, new C11502b(cBSbkFlowHead, CBSbkFlowHead.FLOW_CONTROL_PATH, cBSLockAndFlowControlReq), c11060cM66626a);
                    C11839m.m70686d("CBSService", m67990q(CBSbkFlowHead.FLOW_CONTROL_PATH, str3));
                    if (str3 == null || str3.isEmpty()) {
                        throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null", CBSbkFlowHead.FLOW_CONTROL_PATH);
                    }
                    return (CBSLockAndFlowControlResp) m67991r(m68037y(str3, c11060cM66626a, CBSbkFlowHead.FLOW_CONTROL_PATH), CBSLockAndFlowControlResp.class);
                } catch (C9721b e10) {
                    if (1202 != e10.m60659c()) {
                        break;
                    }
                    int i11 = i10 + 1;
                    if (i10 >= 3) {
                        break;
                    }
                    C11839m.m70687e("CBSService", " [AT OPERATION] at invalid retry: " + i11);
                    C13195l.m79272J().m79325o0(strM67996C);
                    i10 = i11;
                    throw e10;
                } catch (Exception e11) {
                    C11839m.m70687e("CBSService", m67990q(CBSbkFlowHead.FLOW_CONTROL_PATH, e11));
                    throw new C9721b(4001, e11.getMessage(), CBSbkFlowHead.FLOW_CONTROL_PATH);
                }
            } catch (C9721b e12) {
                C9721b c9721bM68024h = m68024h(CBSbkFlowHead.FLOW_CONTROL_PATH, e12);
                c11060cM66626a.m66665u("102_" + c9721bM68024h.m60659c());
                c11060cM66626a.m66635A(e12.getMessage());
                C13622a.m81968n(m67993u(), c11060cM66626a);
                throw c9721bM68024h;
            }
        }
        throw e10;
    }

    /* renamed from: y */
    public final String m68037y(String str, C11060c c11060c, String str2) throws C9721b {
        try {
            CBSBaseResp cBSBaseResp = (CBSBaseResp) m67991r(str, CBSBaseResp.class);
            int result = cBSBaseResp.getResult();
            if (c11060c != null) {
                c11060c.m66665u("102_" + result);
                c11060c.m66635A(cBSBaseResp.toString());
            }
            String strM67992s = m67992s();
            if (result == 0 || result == 503 || result == 506 || result == 601) {
                return str;
            }
            if (result == 611) {
                C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
                throw new C9721b(3110, result, cBSBaseResp.toString(), str2);
            }
            if (result == 708) {
                C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
                throw new C9721b(3111, result, cBSBaseResp.toString(), str2);
            }
            if (result == 401) {
                C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
                m68009P();
                throw new C9721b(3100, cBSBaseResp.toString(), str2);
            }
            if (result == 402) {
                throw new C9721b(1202, cBSBaseResp.toString(), str2);
            }
            if (result != 800 && result != 801) {
                C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
                throw new C9721b(3107, result, cBSBaseResp.toString(), str2);
            }
            C11839m.m70687e("CBSService", m67990q(strM67992s, cBSBaseResp.toString()));
            C14163d.m84990g().m85019y(result);
            throw new C9721b(3309, cBSBaseResp.toString(), str2);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "keeplockResult, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err");
        }
    }

    /* renamed from: z */
    public CBSFullBackup m68038z(String str, int i10, int i11) throws C9721b {
        CBSLockDeviceBackupReq cBSLockDeviceBackupReq = new CBSLockDeviceBackupReq(29, "LockDeviceBackupReq", i11);
        cBSLockDeviceBackupReq.setDeviceId(str);
        cBSLockDeviceBackupReq.setDeviceType(i10);
        try {
            return (CBSFullBackup) m67991r(m68035w(cBSLockDeviceBackupReq), CBSFullBackup.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CBSService", "lockDeviceBackupReq, json exception is: " + e10.getMessage());
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = ");
        }
    }

    public C11322a(String str) {
        this.f53014a = str;
    }
}
