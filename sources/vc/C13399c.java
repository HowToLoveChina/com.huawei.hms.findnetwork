package vc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.sync.syncutil.C2984m;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Record;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9722c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import je.C10812z;
import p514o9.C11839m;
import p664u0.C13108a;

/* renamed from: vc.c */
/* loaded from: classes3.dex */
public class C13399c extends SyncProcessBase {

    /* renamed from: g */
    public static int f60418g = 20;

    /* renamed from: a */
    public List<String> f60419a;

    /* renamed from: b */
    public final List<Record> f60420b;

    /* renamed from: c */
    public final ArrayList<SyncData> f60421c;

    /* renamed from: d */
    public final HashMap<String, Integer> f60422d;

    /* renamed from: e */
    public C2984m f60423e;

    /* renamed from: f */
    public final boolean f60424f;

    public C13399c(Context context, String str, String str2, List<String> list, String str3, String str4, String str5, boolean z10, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f60419a = new ArrayList();
        this.f60420b = new ArrayList(10);
        this.f60421c = new ArrayList<>(10);
        this.f60422d = new HashMap<>(10);
        this.f60423e = null;
        if (list != null) {
            this.f60419a = list;
        }
        this.f60424f = z10;
        C11839m.m70688i("QueryCloudDataImpl", "Sync type = " + str + ", dataType = " + str2 + ", guid list size = " + this.f60419a.size());
    }

    /* renamed from: f */
    private void m80503f(int i10) {
        C11839m.m70688i("QueryCloudDataImpl", "CallBack, value = " + i10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10002);
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        bundle.putBoolean("is_increment_send_data", false);
        appendFailMapToQueryCloud(this.f60424f, bundle, this.f60422d);
        bundle.putParcelableArrayList("cdata", this.f60421c);
        C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 0, "", this.operationType, "batch_of_local_download_struct", this.traceId);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.mContext).m78881d(intent);
        CloudSyncUtil.m15993a1(this.mContext, this.mSyncType, i10);
    }

    /* renamed from: a */
    public final void m80504a(SyncData syncData, Record record) {
        Map<String, Object> attributes = record.getAttributes();
        if (attributes.get(SyncProtocol.Constant.LUID) != null) {
            syncData.setLuid((String) attributes.get(SyncProtocol.Constant.LUID));
        }
    }

    /* renamed from: b */
    public void m80505b(int i10, boolean z10, ArrayList<SyncData> arrayList) {
        C11839m.m70688i("QueryCloudDataImpl", "start send increment callBack end");
        Bundle bundle = new Bundle();
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("[");
            m80508e(bundle);
        }
        sb2.append(SyncLogicServiceUtil.parseIncrementQueryCloudData(arrayList, z10, true));
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putByteArray("batches_data_bytes_key", m80509g(sb2.toString()));
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        bundle.putBoolean("is_in_batches", true);
        bundle.putBoolean("is_send_over", false);
        bundle.putBoolean("increment_bundle", true);
        bundle.putBoolean("is_increment_send_data", true);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10002);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.mContext).m78881d(intent);
    }

    /* renamed from: c */
    public void m80506c(int i10, boolean z10, ArrayList<SyncData> arrayList) {
        C11839m.m70688i("QueryCloudDataImpl", "start send increment callBack middle");
        Bundle bundle = new Bundle();
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("[");
            m80508e(bundle);
        }
        sb2.append(SyncLogicServiceUtil.parseIncrementQueryCloudData(arrayList, z10, false));
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putByteArray("batches_data_bytes_key", m80509g(sb2.toString()));
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        bundle.putBoolean("is_in_batches", true);
        bundle.putBoolean("is_send_over", false);
        bundle.putBoolean("increment_bundle", true);
        bundle.putBoolean("is_increment_send_data", true);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10002);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.mContext).m78881d(intent);
    }

    /* renamed from: d */
    public void m80507d(int i10) {
        C11839m.m70688i("QueryCloudDataImpl", "start send increment callBack over");
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        bundle.putBoolean("is_send_over", true);
        bundle.putBoolean("increment_bundle", true);
        bundle.putBoolean("is_increment_send_data", true);
        appendFailMapToQueryCloud(this.f60424f, bundle, this.f60422d);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10002);
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.mContext).m78881d(intent);
        CloudSyncUtil.m15993a1(this.mContext, this.mSyncType, i10);
    }

    /* renamed from: e */
    public final void m80508e(Bundle bundle) {
        C11839m.m70688i("QueryCloudDataImpl", "start send increment callBack start");
        bundle.putString("traceId", this.traceId);
        bundle.putBoolean("is_incrementally_query", true);
    }

    /* renamed from: g */
    public final byte[] m80509g(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes(Constants.UTF_8);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    /* renamed from: h */
    public final boolean m80510h(ArrayList<SyncData> arrayList) {
        C11839m.m70688i("QueryCloudDataImpl", "isData2ByteTooLarge dataBytes size = " + SyncLogicServiceUtil.parseQueryCloudData(arrayList).length);
        if (r8.length <= 524288) {
            return false;
        }
        double size = arrayList.size() / ((r8.length * 1.0d) / 524288.0d);
        if (size % 1.0d >= 0.5d) {
            size += 1.0d;
        }
        int i10 = (int) size;
        if (i10 == 0) {
            f60418g = 1;
        } else {
            f60418g = i10;
        }
        C11839m.m70688i("QueryCloudDataImpl", "isData2ByteTooLarge batchIncrementSendNum = " + f60418g);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m80511i(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L1c
            r3.hashCode()
            java.lang.String r0 = "addressbook"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L1a
            java.lang.String r0 = "notepad"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L1a
            goto L1c
        L1a:
            r3 = 1
            goto L1d
        L1c:
            r3 = 0
        L1d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isSupportIncrement dataType = "
            r0.append(r1)
            java.lang.String r2 = r2.mDataType
            r0.append(r2)
            java.lang.String r2 = ", result = "
            r0.append(r2)
            r0.append(r3)
            java.lang.String r2 = r0.toString()
            java.lang.String r0 = "QueryCloudDataImpl"
            p514o9.C11839m.m70688i(r0, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.C13399c.m80511i(java.lang.String):boolean");
    }

    /* renamed from: j */
    public final void m80512j(int i10) {
        try {
            if (m80511i(this.mSyncType) && m80510h(this.f60421c)) {
                m80514l(i10);
            } else {
                m80503f(i10);
            }
        } catch (Throwable th2) {
            C11839m.m70689w("QueryCloudDataImpl", "procCallBack err, default callback, err: " + th2.getMessage() + ", default callback");
            m80503f(i10);
        }
        CloudSyncUtil.m16032n1(!this.f60421c.isEmpty());
    }

    /* renamed from: k */
    public int m80513k() {
        List<String> list;
        this.f60423e = new C2984m();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String message = "";
        int iM17923a = 0;
        try {
            try {
                list = this.f60419a;
            } catch (C9722c e10) {
                iM17923a = this.f60423e.m17923a(e10);
                if (SyncLogicService.cloudSyncSDKHasCollaborativeAbility(this.mSyncModulePackageName)) {
                    iM17923a = e10.m60666c();
                }
                message = e10.getMessage();
                C10812z.m65841j(this.mContext, e10.m60668e(), this.mDataType, e10.m60666c(), e10.m60667d(), e10.getMessage(), this.operationType, e10.m60665b(), this.traceId);
            } catch (Exception e11) {
                iM17923a = 5;
                message = e11.getMessage();
                C11839m.m70687e("QueryCloudDataImpl", "Exception occurred , e = " + e11.toString());
                C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 5, e11.toString(), this.operationType, "local_download_struct", this.traceId);
            }
            if (list != null && list.size() != 0) {
                C11839m.m70688i("QueryCloudDataImpl", "syncV2 cloudDataList dataType: " + this.mDataType);
                isCancel();
                queryCloudDataV2(this.mSyncType, this.mDataType, this.f60419a);
                C11839m.m70688i("QueryCloudDataImpl", "syncV2 cloudDataList dataType: " + this.mDataType + ", sucSize = " + this.f60421c.size() + ", failSize = " + this.f60422d.size());
                return iM17923a;
            }
            C11839m.m70689w("QueryCloudDataImpl", "Guid list is null or empty");
            return 0;
        } finally {
            m80512j(0);
            C2980i.m17879n(this.mReportEndInfo, 0, "");
            C2980i.m17872g(this.mReportEndInfo, this.mDataType, this.f60421c.size());
            C2980i.m17874i(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    /* renamed from: l */
    public final void m80514l(int i10) {
        C11839m.m70688i("QueryCloudDataImpl", "sendIncrementCallBack, value = " + i10);
        ArrayList<SyncData> arrayList = new ArrayList<>(this.f60421c);
        boolean z10 = false;
        int i11 = 0;
        while (arrayList.size() >= f60418g) {
            ArrayList<SyncData> arrayList2 = new ArrayList<>(arrayList.subList(0, f60418g));
            if (i11 == 0) {
                m80506c(i10, true, arrayList2);
            } else {
                m80506c(i10, false, arrayList2);
            }
            arrayList.removeAll(arrayList2);
            i11++;
            z10 = true;
        }
        if (z10) {
            m80505b(i10, false, arrayList);
        } else {
            m80505b(i10, true, arrayList);
        }
        m80507d(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void queryCloudDataV2(java.lang.String r33, java.lang.String r34, java.util.List<java.lang.String> r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 915
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.C13399c.queryCloudDataV2(java.lang.String, java.lang.String, java.util.List):void");
    }
}
