package p703v8;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudspace.bean.HDSpaceDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import com.huawei.hicloud.bean.DriveConfigService;
import fk.C9721b;
import java.util.Arrays;
import java.util.LinkedHashMap;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import p746wn.C13622a;
import to.C13049a;

/* renamed from: v8.k */
/* loaded from: classes2.dex */
public class C13374k {

    /* renamed from: a */
    public Context f60291a;

    /* renamed from: b */
    public String f60292b;

    /* renamed from: c */
    public DriveConfigService f60293c;

    public C13374k(Context context, String str, DriveConfigService driveConfigService) {
        this.f60291a = context;
        this.f60292b = str;
        this.f60293c = driveConfigService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [v8.k] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [v8.k] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.huawei.hicloud.bean.DriveConfigService] */
    /* renamed from: a */
    public HDSpaceDetail m80298a() throws Throwable {
        int iM60659c;
        String message;
        LinkedHashMap linkedHashMap;
        String[] appId;
        ?? r12 = this;
        ?? r22 = "extra";
        C11839m.m70688i("QuotaInfoApplicationDataRequestor", "QuotaInfoApplicationDataRequestor start, service = " + r12.f60293c.getId() + ", traceId = " + r12.f60292b);
        HDSpaceDetail hDSpaceDetail = new HDSpaceDetail();
        String string = "";
        String str = "";
        int i10 = 0;
        try {
            try {
                try {
                    appId = r12.f60293c.getAppId();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (C9721b e10) {
                e = e10;
            }
            if (appId != null && appId.length > 0) {
                QuotaUsedInfoRsp quotaUsedInfoRspM80299b = r12.m80299b(appId);
                iM60659c = quotaUsedInfoRspM80299b.getRetCode();
                try {
                    message = quotaUsedInfoRspM80299b.getRetDesc();
                    try {
                        string = Arrays.toString(quotaUsedInfoRspM80299b.getQuotaDetails());
                        if (quotaUsedInfoRspM80299b.getRetCode() == 0) {
                            C11839m.m70688i("QuotaInfoApplicationDataRequestor", "driveConfig getQuotaSyncSpaceInfo request success");
                            QuotaDetail[] quotaDetails = quotaUsedInfoRspM80299b.getQuotaDetails();
                            int i11 = 0;
                            long j10 = 0;
                            if (quotaDetails.length > 0) {
                                int length = quotaDetails.length;
                                long assetsQuotadSpace = 0;
                                int recordsCount = 0;
                                long recordsQuotadSpace = 0;
                                while (i11 < length) {
                                    QuotaDetail quotaDetail = quotaDetails[i11];
                                    if (quotaDetail != null) {
                                        recordsQuotadSpace += quotaDetail.getRecordsQuotadSpace();
                                        assetsQuotadSpace += quotaDetail.getAssetsQuotadSpace();
                                        recordsCount += quotaDetail.getRecordsCount();
                                    }
                                    i11++;
                                }
                                hDSpaceDetail.setFsize(assetsQuotadSpace + recordsQuotadSpace);
                                hDSpaceDetail.setDcount(recordsCount);
                                hDSpaceDetail.setServiceId(r12.f60293c.getId());
                                hDSpaceDetail.setModuleName("driveConfig");
                                hDSpaceDetail.setFromDriveConfig(true);
                                i11 = recordsCount;
                                j10 = recordsQuotadSpace;
                            }
                            C11839m.m70688i("QuotaInfoApplicationDataRequestor", "driveConfig getQuotaSyncSpaceInfo serviceId :" + r12.f60293c.getId() + ",recordsQuotadSpace:" + j10 + ",recordsCount:" + i11);
                        } else {
                            C11839m.m70688i("QuotaInfoApplicationDataRequestor", "driveConfig getQuotaSyncSpaceInfo request fail, errCode = " + iM60659c + ", errMsg = " + message);
                        }
                        linkedHashMap = new LinkedHashMap();
                    } catch (C9721b e11) {
                        e = e11;
                        str = message;
                        C11839m.m70687e("QuotaInfoApplicationDataRequestor", "driveConfig getQuotaSyncSpaceInfo failed :" + e.getMessage());
                        iM60659c = e.m60659c();
                        message = e.getMessage();
                        linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("extra", string);
                        Context context = r12.f60291a;
                        r22 = r12.f60293c;
                        String id2 = r22.getId();
                        r12 = r12.f60292b;
                        C13622a.m81966l(context, id2, iM60659c, message, message, "03001", "get_space_size", r12, linkedHashMap, false);
                        return hDSpaceDetail;
                    } catch (Throwable th3) {
                        th = th3;
                        i10 = iM60659c;
                        str = message;
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.put(r22, string);
                        C13622a.m81966l(r12.f60291a, r12.f60293c.getId(), i10, str, str, "03001", "get_space_size", r12.f60292b, linkedHashMap2, false);
                        throw th;
                    }
                } catch (C9721b e12) {
                    e = e12;
                }
                linkedHashMap.put("extra", string);
                Context context2 = r12.f60291a;
                r22 = r12.f60293c;
                String id22 = r22.getId();
                r12 = r12.f60292b;
                C13622a.m81966l(context2, id22, iM60659c, message, message, "03001", "get_space_size", r12, linkedHashMap, false);
                return hDSpaceDetail;
            }
            C11839m.m70688i("QuotaInfoApplicationDataRequestor", "driveConfig getQuotaDriveSpaceInfo appIds is empty");
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put("extra", "");
            C13622a.m81966l(r12.f60291a, r12.f60293c.getId(), 0, "", "", "03001", "get_space_size", r12.f60292b, linkedHashMap3, false);
            return null;
        } catch (Throwable th4) {
            th = th4;
            i10 = iM60659c;
        }
    }

    /* renamed from: b */
    public QuotaUsedInfoRsp m80299b(String[] strArr) throws C9721b {
        String strM78703B = new C13049a(EnumC12999a.CLOUD_SYNC, this.f60292b).m78703B(strArr);
        C11839m.m70686d("QuotaInfoApplicationDataRequestor", "driveConfig requestCarryParams response=" + strM78703B);
        try {
            return (QuotaUsedInfoRsp) new Gson().fromJson(strM78703B, QuotaUsedInfoRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("QuotaInfoApplicationDataRequestor", "requestCarryParams json exception is: " + e10.toString());
            throw new C9721b(1, "json err ");
        }
    }
}
