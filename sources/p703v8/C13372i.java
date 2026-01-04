package p703v8;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudspace.bean.DiskStorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.HDSpaceDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.manager.DriveModuleConfigManager;
import com.huawei.hicloud.notification.manager.SyncModuleConfigManager;
import com.huawei.hicloud.request.opengw.bean.LsRequest;
import com.huawei.hicloud.request.opengw.bean.Result;
import dk.C9161b;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0241z;
import p514o9.C11829c;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p746wn.C13622a;
import to.C13049a;

/* renamed from: v8.i */
/* loaded from: classes2.dex */
public class C13372i {

    /* renamed from: e */
    public DiskStorageInfo f60284e;

    /* renamed from: a */
    public List<String> f60280a = new ArrayList();

    /* renamed from: b */
    public List<Map<String, Object>> f60281b = new ArrayList();

    /* renamed from: c */
    public Map<String, HDSpaceDetail> f60282c = new HashMap();

    /* renamed from: d */
    public List<HDSpaceDetail> f60283d = new ArrayList();

    /* renamed from: f */
    public long f60285f = -1;

    /* renamed from: a */
    public final void m80272a(Context context) throws Throwable {
        String strM81958d = C13622a.m81958d("03007");
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, strM81958d);
        this.f60280a.remove("/Sync/contact");
        m80281j("1000", HNConstants.DataType.CONTACT, c13049a, strM81958d, context);
        this.f60280a.remove("/NoteBackup");
        this.f60280a.remove("/Sync/note");
        m80281j("1001", "notepad", c13049a, strM81958d, context);
        m80281j("1002", "calendar", c13049a, strM81958d, context);
    }

    /* renamed from: b */
    public final void m80273b() {
        this.f60280a.clear();
        this.f60281b.clear();
        this.f60282c.clear();
        this.f60283d.clear();
        this.f60285f = -1L;
    }

    /* renamed from: c */
    public final boolean m80274c(String str, Map<String, Object> map) {
        if (!str.equals("/Recycle")) {
            return false;
        }
        String str2 = (String) map.get("space");
        long jM1688f = str2 != null ? C0241z.m1688f(str2) : 0L;
        DiskStorageInfo diskStorageInfo = this.f60284e;
        if (diskStorageInfo != null) {
            diskStorageInfo.setRecycleSize(jM1688f);
        }
        return true;
    }

    /* renamed from: d */
    public final void m80275d() throws C9721b {
        for (Map<String, Object> map : this.f60281b) {
            String str = (String) map.get("name");
            String strM80276e = m80276e(str);
            C11839m.m70688i("ModuleStorageRequestor", "getAllModule module = " + strM80276e);
            if (!m80274c(str, map)) {
                HDSpaceDetail hDSpaceDetailBuildHDSpaceDetail = HDSpaceDetail.buildHDSpaceDetail(map, strM80276e, this.f60282c.get(strM80276e));
                if (TextUtils.isEmpty(strM80276e)) {
                    hDSpaceDetailBuildHDSpaceDetail.setFromSyncConfig(true);
                    hDSpaceDetailBuildHDSpaceDetail.setPath(str);
                    hDSpaceDetailBuildHDSpaceDetail.setModuleName("syncConfig");
                    if (hDSpaceDetailBuildHDSpaceDetail.getFsize() > 0) {
                        this.f60283d.add(hDSpaceDetailBuildHDSpaceDetail);
                    }
                } else {
                    this.f60282c.put(strM80276e, hDSpaceDetailBuildHDSpaceDetail);
                }
            }
        }
    }

    /* renamed from: e */
    public final String m80276e(String str) {
        if (!C10028c.m62182c0().m62420y1()) {
            return C9161b.f45955b.get(str.substring(str.lastIndexOf(File.separator)));
        }
        return C9161b.f45954a.get(m80277f(str));
    }

    /* renamed from: f */
    public final String m80277f(String str) {
        String str2 = File.separator;
        String strSubstring = str.substring(0, str.lastIndexOf(str2));
        String strSubstring2 = str.substring(str.lastIndexOf(str2));
        if (TextUtils.isEmpty(strSubstring) || !"/Sync".equals(strSubstring.substring(strSubstring.lastIndexOf(str2)))) {
            return strSubstring2;
        }
        return "/Sync" + strSubstring2;
    }

    /* renamed from: g */
    public final String m80278g(String str, StringBuffer stringBuffer) {
        str.hashCode();
        switch (str) {
            case "1000":
                stringBuffer.append(HNConstants.DataType.CONTACT);
                stringBuffer.append(",");
                stringBuffer.append("group");
                stringBuffer.append(",");
                stringBuffer.append("blocklist");
                stringBuffer.append("] and (trashed=true or trashed=false)");
                break;
            case "1001":
                stringBuffer.append("note");
                stringBuffer.append(",shorthand");
                stringBuffer.append(",memocategory");
                stringBuffer.append(",memonote");
                stringBuffer.append(",memopage");
                stringBuffer.append(",memotag");
                stringBuffer.append(",newnote");
                stringBuffer.append(",notetag");
                stringBuffer.append(",noteattachment");
                stringBuffer.append("] and (trashed=true or trashed=false)");
                break;
            case "1002":
                stringBuffer.append("calendareventarc");
                stringBuffer.append(",");
                stringBuffer.append("eventattach");
                stringBuffer.append(",");
                stringBuffer.append("calendar");
                stringBuffer.append(",");
                stringBuffer.append("calendaraccount");
                stringBuffer.append(",");
                stringBuffer.append("calendarmeta");
                stringBuffer.append(",");
                stringBuffer.append("course");
                stringBuffer.append(",");
                stringBuffer.append("coursetime");
                stringBuffer.append(",");
                stringBuffer.append("schedule");
                stringBuffer.append("] and (trashed=true or trashed=false)");
                break;
        }
        return new String(stringBuffer);
    }

    /* renamed from: h */
    public final String m80279h(SyncConfigService syncConfigService) {
        return !C10028c.m62182c0().m62420y1() ? syncConfigService.getUnstructedPathObs() : syncConfigService.getUnstructedPath();
    }

    /* renamed from: i */
    public final void m80280i(DriveConfigService driveConfigService, String str, Context context) throws Throwable {
        long fsize;
        C11839m.m70688i("ModuleStorageRequestor", "driveConfig getQuotaDriveSpaceInfo start service = " + driveConfigService.getId());
        HDSpaceDetail hDSpaceDetailM80298a = new C13374k(context, str, driveConfigService).m80298a();
        if (hDSpaceDetailM80298a != null) {
            fsize = hDSpaceDetailM80298a.getFsize();
        } else {
            C11839m.m70687e("ModuleStorageRequestor", "getQuotaDriveSpaceInfo hdSpaceDetail is null");
            fsize = 0;
        }
        if (fsize > 0) {
            C11839m.m70688i("ModuleStorageRequestor", "driveConfig add spaceDetail to detals");
            this.f60283d.add(hDSpaceDetailM80298a);
        }
    }

    /* renamed from: j */
    public final void m80281j(String str, String str2, C13049a c13049a, String str3, Context context) throws Throwable {
        Throwable th2;
        String str4;
        int retCode;
        String str5;
        boolean z10;
        LinkedHashMap linkedHashMap;
        String str6;
        String str7;
        String str8;
        String str9;
        int i10;
        String str10;
        Context context2;
        String string = "";
        try {
            QuotaUsedInfoRsp quotaUsedInfoRsp = (QuotaUsedInfoRsp) new Gson().fromJson(c13049a.m78761z(str, m80278g(str, new StringBuffer("collection=private and kind in ["))), QuotaUsedInfoRsp.class);
            retCode = quotaUsedInfoRsp.getRetCode();
            try {
                String retDesc = quotaUsedInfoRsp.getRetDesc();
                try {
                    try {
                        string = Arrays.toString(quotaUsedInfoRsp.getQuotaDetails());
                        C11839m.m70686d("ModuleStorageRequestor", "getQuotaUsedInfo quotaRsp =" + quotaUsedInfoRsp.toString());
                        if (quotaUsedInfoRsp.getRetCode() == 0) {
                            C11839m.m70688i("ModuleStorageRequestor", "getQuotaUsedInfo request success");
                            QuotaDetail[] quotaDetails = quotaUsedInfoRsp.getQuotaDetails();
                            try {
                                if (quotaDetails.length > 0) {
                                    long assetsQuotadSpace = 0;
                                    int recordsCount = 0;
                                    long recordsQuotadSpace = 0;
                                    for (QuotaDetail quotaDetail : quotaDetails) {
                                        try {
                                            if (quotaDetail != null) {
                                                recordsQuotadSpace += quotaDetail.getRecordsQuotadSpace();
                                                assetsQuotadSpace += quotaDetail.getAssetsQuotadSpace();
                                                recordsCount += quotaDetail.getRecordsCount();
                                            }
                                        } catch (JsonSyntaxException | C9721b e10) {
                                            e = e10;
                                            str5 = string;
                                            string = retDesc;
                                            try {
                                                C11839m.m70687e("ModuleStorageRequestor", "getQuotaUsedInfo failed :" + e.getMessage());
                                                linkedHashMap = new LinkedHashMap();
                                                linkedHashMap.put("extra", str5);
                                                z10 = false;
                                                context2 = context;
                                                str10 = str2;
                                                i10 = retCode;
                                                str9 = string;
                                                str8 = string;
                                                str7 = "03001";
                                                str6 = "get_space_size";
                                                C13622a.m81966l(context2, str10, i10, str9, str8, str7, str6, str3, linkedHashMap, z10);
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                str4 = string;
                                                string = str5;
                                                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                                linkedHashMap2.put("extra", string);
                                                C13622a.m81966l(context, str2, retCode, str4, str4, "03001", "get_space_size", str3, linkedHashMap2, false);
                                                throw th2;
                                            }
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            str4 = retDesc;
                                            LinkedHashMap linkedHashMap22 = new LinkedHashMap();
                                            linkedHashMap22.put("extra", string);
                                            C13622a.m81966l(context, str2, retCode, str4, str4, "03001", "get_space_size", str3, linkedHashMap22, false);
                                            throw th2;
                                        }
                                    }
                                    HDSpaceDetail hDSpaceDetail = new HDSpaceDetail();
                                    hDSpaceDetail.setDelete(true);
                                    str = retDesc;
                                    hDSpaceDetail.setFsize(recordsQuotadSpace + assetsQuotadSpace);
                                    hDSpaceDetail.setDcount(recordsCount);
                                    hDSpaceDetail.setModuleName(str2);
                                    C11839m.m70688i("ModuleStorageRequestor", "mapKey :" + str2 + "recordsQuotadSpace:" + recordsQuotadSpace + ",assetsQuotadSpace:" + assetsQuotadSpace + ",recordsCount:" + recordsCount);
                                    this.f60282c.put(str2, hDSpaceDetail);
                                } else {
                                    str = retDesc;
                                    C11839m.m70689w("ModuleStorageRequestor", "getQuotaUsedInfo recycleContact request failed");
                                }
                            } catch (JsonSyntaxException | C9721b e11) {
                                e = e11;
                                str5 = string;
                                string = str;
                                C11839m.m70687e("ModuleStorageRequestor", "getQuotaUsedInfo failed :" + e.getMessage());
                                linkedHashMap = new LinkedHashMap();
                                linkedHashMap.put("extra", str5);
                                z10 = false;
                                context2 = context;
                                str10 = str2;
                                i10 = retCode;
                                str9 = string;
                                str8 = string;
                                str7 = "03001";
                                str6 = "get_space_size";
                                C13622a.m81966l(context2, str10, i10, str9, str8, str7, str6, str3, linkedHashMap, z10);
                            } catch (Throwable th5) {
                                th = th5;
                                str4 = str;
                                th2 = th;
                                LinkedHashMap linkedHashMap222 = new LinkedHashMap();
                                linkedHashMap222.put("extra", string);
                                C13622a.m81966l(context, str2, retCode, str4, str4, "03001", "get_space_size", str3, linkedHashMap222, false);
                                throw th2;
                            }
                        } else {
                            str = retDesc;
                        }
                        linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("extra", string);
                        str6 = "get_space_size";
                        z10 = false;
                        context2 = context;
                        str10 = str2;
                        i10 = retCode;
                        str9 = str;
                        str8 = str;
                        str7 = "03001";
                    } catch (Throwable th6) {
                        th = th6;
                        str = retDesc;
                    }
                } catch (JsonSyntaxException | C9721b e12) {
                    e = e12;
                    str = retDesc;
                }
            } catch (JsonSyntaxException | C9721b e13) {
                e = e13;
                str5 = "";
            } catch (Throwable th7) {
                th2 = th7;
                str4 = "";
            }
        } catch (JsonSyntaxException | C9721b e14) {
            e = e14;
            str5 = "";
            retCode = 0;
        } catch (Throwable th8) {
            th2 = th8;
            str4 = "";
            retCode = 0;
        }
        C13622a.m81966l(context2, str10, i10, str9, str8, str7, str6, str3, linkedHashMap, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0022  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m80282k(com.huawei.hicloud.bean.SyncConfigService r21, to.C13049a r22, java.lang.String r23, android.content.Context r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p703v8.C13372i.m80282k(com.huawei.hicloud.bean.SyncConfigService, to.a, java.lang.String, android.content.Context, java.lang.String):void");
    }

    /* renamed from: l */
    public final void m80283l(Context context) throws Throwable {
        String strM81958d = C13622a.m81958d("03007");
        Iterator<DriveConfigService> it = DriveModuleConfigManager.getInstance().getDriveServicesFromDb().iterator();
        while (it.hasNext()) {
            m80280i(it.next(), strM81958d, context);
        }
    }

    /* renamed from: m */
    public final void m80284m() {
        this.f60280a.add("/BlockedBackup");
        this.f60280a.add("/RecordBackup");
        this.f60280a.add("/NoteBackup");
        this.f60280a.add("/Recycle");
    }

    /* renamed from: n */
    public final void m80285n(Context context) throws Throwable {
        String strM81958d = C13622a.m81958d("03007");
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, strM81958d);
        for (SyncConfigService syncConfigService : SyncModuleConfigManager.getInstance().getSyncServicesFromDb()) {
            String strM80279h = m80279h(syncConfigService);
            if (!TextUtils.isEmpty(strM80279h)) {
                this.f60280a.remove(strM80279h);
            }
            m80282k(syncConfigService, c13049a, strM81958d, context, strM80279h);
        }
    }

    /* renamed from: o */
    public final void m80286o(C13049a c13049a) throws C9721b {
        LsRequest lsRequest = new LsRequest();
        lsRequest.setServerPath("/Hicloud");
        lsRequest.setFields(new String[]{"name"});
        lsRequest.setType(2);
        lsRequest.setRecursive(1);
        List<String> listM70568d = C11829c.m70568d(c13049a.m78718T(lsRequest), this.f60280a);
        this.f60280a = listM70568d;
        listM70568d.add("/Recycle");
    }

    /* renamed from: p */
    public final void m80287p(Context context) throws Throwable {
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
        if (C10028c.m62182c0().m62420y1()) {
            m80286o(c13049a);
        } else {
            m80284m();
        }
        m80285n(context);
        m80272a(context);
        m80283l(context);
        List<String> list = this.f60280a;
        Result resultM78709H = c13049a.m78709H((String[]) list.toArray(new String[list.size()]), new String[]{"name", "space", "size", "fileCount", "dirCount"});
        if (resultM78709H.getSuccessList() == null) {
            return;
        }
        C11839m.m70686d("ModuleStorageRequestor", "nsBaseResp = " + resultM78709H.toString());
        List<Result.ErrMsg> failList = resultM78709H.getFailList();
        if (!C10028c.m62182c0().m62420y1() && !failList.isEmpty()) {
            for (Result.ErrMsg errMsg : failList) {
                if (errMsg.getErrCode() != 401) {
                    C11839m.m70687e("ModuleStorageRequestor", "query module space error " + resultM78709H.toString());
                    throw new C9721b(errMsg.getErrCode(), "query module space error " + resultM78709H.toString());
                }
            }
            C11839m.m70689w("ModuleStorageRequestor", "query module space, errorCode = 401, failList size = " + failList.size());
        }
        this.f60281b = resultM78709H.getSuccessList();
        m80275d();
    }

    /* renamed from: q */
    public DiskStorageInfo m80288q(Context context, long j10, long j11) throws Throwable {
        m80273b();
        this.f60284e = new DiskStorageInfo();
        try {
            m80287p(context);
            m80289r(j10, j11);
            this.f60284e.setDiskDetails(this.f60283d);
            C11839m.m70688i("ModuleStorageRequestor", "module detail size = " + this.f60283d.size());
            long j12 = j10 - j11;
            this.f60285f = j12;
            if (j12 < 0) {
                j12 = 0;
            }
            this.f60285f = j12;
            C11839m.m70688i("ModuleStorageRequestor", "moduleUsedSize = " + this.f60285f);
            this.f60284e.setDiskUsedSize(this.f60285f);
        } catch (C9721b e10) {
            C11839m.m70689w("ModuleStorageRequestor", "get user modules space failed. errorCode = " + e10.m60659c());
            this.f60284e = null;
        }
        return this.f60284e;
    }

    /* renamed from: r */
    public final void m80289r(long j10, long j11) {
        for (Map.Entry<String, HDSpaceDetail> entry : this.f60282c.entrySet()) {
            if (entry.getValue().getFsize() > 0) {
                this.f60283d.add(entry.getValue());
            }
        }
        long fsize = 0;
        for (int i10 = 0; i10 < this.f60283d.size(); i10++) {
            HDSpaceDetail hDSpaceDetail = this.f60283d.get(i10);
            if (hDSpaceDetail.getFsize() > 0) {
                fsize += hDSpaceDetail.getFsize();
            }
        }
        long j12 = (j10 - j11) - fsize;
        C11839m.m70688i("ModuleStorageRequestor", "other " + j12);
        if (j12 > 0) {
            HDSpaceDetail hDSpaceDetail2 = new HDSpaceDetail();
            hDSpaceDetail2.setModuleName("clouddrive");
            hDSpaceDetail2.setFsize(j12);
            DiskStorageInfo diskStorageInfo = this.f60284e;
            if (diskStorageInfo != null) {
                diskStorageInfo.setCloudDriveSize(j12);
            }
            this.f60283d.add(hDSpaceDetail2);
        }
        if (this.f60283d.isEmpty()) {
            return;
        }
        Collections.sort(this.f60283d);
    }
}
