package p732w8;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import com.huawei.android.hicloud.commonlib.space.QuotaDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import je.C10812z;
import ke.C11046a;
import p015ak.C0209d;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p783xp.C13843a;
import to.C13049a;

/* renamed from: w8.o */
/* loaded from: classes2.dex */
public class AsyncTaskC13564o extends AsyncTask<Void, Void, Map<String, Integer>> {

    /* renamed from: f */
    public static AsyncTaskC13564o f61001f;

    /* renamed from: a */
    public Context f61002a;

    /* renamed from: b */
    public Messenger f61003b;

    /* renamed from: c */
    public CloudStorageTaskCallback f61004c;

    /* renamed from: d */
    public CountDownLatch f61005d;

    /* renamed from: e */
    public ConcurrentHashMap<String, Integer> f61006e = new ConcurrentHashMap<>();

    /* renamed from: w8.o$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final CountDownLatch f61007a;

        public a(CountDownLatch countDownLatch) {
            this.f61007a = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            ArrayList arrayList = new ArrayList();
            arrayList.add("bookmark");
            arrayList.add("browserhistory");
            arrayList.add("infoflow");
            HashMap map = new HashMap();
            map.put("bookmark", "bookmark");
            map.put("browserhistory", "browserhistory");
            map.put("infoflow", "infoflow");
            AsyncTaskC13564o.this.m81531i("browser", arrayList, false, map, null);
            this.f61007a.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.QUERY_CLOUD_SPACE;
        }
    }

    /* renamed from: w8.o$b */
    public class b extends AbstractC12367d {

        /* renamed from: a */
        public final CountDownLatch f61009a;

        public b(CountDownLatch countDownLatch) {
            this.f61009a = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            AsyncTaskC13564o.this.m81530h("calendar", "calendar", false, "calendar", null);
            AsyncTaskC13564o.this.m81530h("calendar", "calendareventarc", false, "calendarEventArc", null);
            this.f61009a.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.QUERY_CLOUD_SPACE;
        }
    }

    /* renamed from: w8.o$c */
    public class c extends AbstractC12367d {

        /* renamed from: a */
        public final CountDownLatch f61011a;

        public c(CountDownLatch countDownLatch) {
            this.f61011a = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            AsyncTaskC13564o.this.m81530h("addressbook", HNConstants.DataType.CONTACT, true, HNConstants.DataType.CONTACT, "recycleContact");
            int iIntValue = AsyncTaskC13564o.this.f61006e.get(HNConstants.DataType.CONTACT) != null ? ((Integer) AsyncTaskC13564o.this.f61006e.get(HNConstants.DataType.CONTACT)).intValue() : 0;
            int iIntValue2 = AsyncTaskC13564o.this.f61006e.get("recycleContact") != null ? ((Integer) AsyncTaskC13564o.this.f61006e.get("recycleContact")).intValue() : 0;
            CloudSyncUtil.m16035o1(iIntValue);
            CloudSyncUtil.m16038p1(iIntValue2);
            C11839m.m70688i("GetQuotaOrPimNumTask", "normal = " + iIntValue + ", recycle = " + iIntValue2);
            this.f61011a.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.QUERY_CLOUD_SPACE;
        }
    }

    /* renamed from: w8.o$d */
    public class d extends AbstractC12367d {

        /* renamed from: a */
        public final CountDownLatch f61013a;

        public d(CountDownLatch countDownLatch) {
            this.f61013a = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            AsyncTaskC13564o.this.m81529g("notepad", C0209d.m1240c0(AsyncTaskC13564o.this.f61002a, C13843a.m83050B(AsyncTaskC13564o.this.f61002a)), "notepad", "recycleNotepad");
            this.f61013a.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.QUERY_CLOUD_SPACE;
        }
    }

    /* renamed from: w8.o$e */
    public class e extends AbstractC12367d {

        /* renamed from: a */
        public final CountDownLatch f61015a;

        public e(CountDownLatch countDownLatch) {
            this.f61015a = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            AsyncTaskC13564o.this.m81530h("wlan", "wlan", false, "wlan", null);
            this.f61015a.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.QUERY_CLOUD_SPACE;
        }
    }

    public AsyncTaskC13564o(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback, CountDownLatch countDownLatch) {
        this.f61002a = context;
        this.f61003b = messenger;
        this.f61004c = cloudStorageTaskCallback;
        this.f61005d = countDownLatch;
    }

    /* renamed from: f */
    public static AsyncTaskC13564o m81527f(Context context, Messenger messenger, CloudStorageTaskCallback cloudStorageTaskCallback, CountDownLatch countDownLatch) {
        if (f61001f == null || AsyncTask.Status.FINISHED.equals(f61001f.getStatus())) {
            f61001f = new AsyncTaskC13564o(context, messenger, cloudStorageTaskCallback, countDownLatch);
        } else {
            AsyncTaskC13564o asyncTaskC13564o = f61001f;
            if (messenger != asyncTaskC13564o.f61003b || cloudStorageTaskCallback != asyncTaskC13564o.f61004c) {
                if (cloudStorageTaskCallback != asyncTaskC13564o.f61004c) {
                    asyncTaskC13564o.f61004c = cloudStorageTaskCallback;
                }
                asyncTaskC13564o.f61003b = messenger;
            }
        }
        return f61001f;
    }

    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Map<String, Integer> doInBackground(Void... voidArr) {
        C11839m.m70688i("GetQuotaOrPimNumTask", "doInBackground");
        try {
            if (!CloudSyncUtil.m15960K0()) {
                C11839m.m70688i("GetQuotaOrPimNumTask", "structure disabled");
                return null;
            }
            CountDownLatch countDownLatch = new CountDownLatch(5);
            C12515a.m75110o().m75172d(new c(countDownLatch));
            C12515a.m75110o().m75172d(new d(countDownLatch));
            C12515a.m75110o().m75172d(new b(countDownLatch));
            C12515a.m75110o().m75172d(new a(countDownLatch));
            C12515a.m75110o().m75172d(new e(countDownLatch));
            try {
                if (countDownLatch.await(20000L, TimeUnit.MILLISECONDS)) {
                    C11839m.m70688i("GetQuotaOrPimNumTask", "GetQuotaOrPimNumTask all task success");
                } else {
                    C11839m.m70688i("GetQuotaOrPimNumTask", "GetQuotaOrPimNumTask request timeout");
                }
            } catch (InterruptedException e10) {
                C11839m.m70688i("GetQuotaOrPimNumTask", "GetQuotaOrPimNumTask await exception: " + e10.toString());
            }
            return this.f61006e;
        } catch (Exception e11) {
            C11839m.m70687e("GetQuotaOrPimNumTask", "GetQuotaOrPimNumTask error:" + e11.toString());
            return null;
        }
    }

    /* renamed from: g */
    public final void m81529g(String str, String str2, String str3, String str4) {
        String str5;
        C11839m.m70688i("GetQuotaOrPimNumTask", "getQuotaNotepadNum :" + str2);
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_SYNC, C10812z.m65832a("03007"));
        StringBuffer stringBuffer = new StringBuffer("collection=private and kind in [");
        try {
            if (TextUtils.isEmpty(str2)) {
                stringBuffer.append("note");
                stringBuffer.append("] and (trashed=true or trashed=false)");
                str5 = new String(stringBuffer);
            } else {
                stringBuffer.append(str2);
                stringBuffer.append("] and (trashed=true or trashed=false)");
                str5 = new String(stringBuffer);
            }
            String strM78761z = c13049a.m78761z(DriveSyncUtil.m17958C(str), str5);
            C11839m.m70686d("GetQuotaOrPimNumTask", "getQuotaNotepadNum notepad response =" + strM78761z);
            m81533k(str3, (QuotaUsedInfoRsp) new Gson().fromJson(strM78761z, QuotaUsedInfoRsp.class), str4);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("GetQuotaOrPimNumTask", "getQuotaNotepadNum exception:" + e10.toString());
        } catch (C9721b e11) {
            C11839m.m70687e("GetQuotaOrPimNumTask", "getQuotaNotepadNum exception:" + e11.toString());
        }
    }

    /* renamed from: h */
    public final void m81530h(String str, String str2, boolean z10, String str3, String str4) {
        String str5;
        C11839m.m70688i("GetQuotaOrPimNumTask", "getQuotaUsedInfo :" + str2);
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_SYNC, C10812z.m65832a("03007"));
        StringBuffer stringBuffer = new StringBuffer("collection=private and kind in [");
        try {
            if (z10) {
                stringBuffer.append(str2);
                stringBuffer.append("] and (trashed=true or trashed=false)");
                str5 = new String(stringBuffer);
            } else {
                stringBuffer.append(str2);
                stringBuffer.append("] and (trashed=false)");
                str5 = new String(stringBuffer);
            }
            String strM78761z = c13049a.m78761z(DriveSyncUtil.m17958C(str), str5);
            C11839m.m70686d("GetQuotaOrPimNumTask", "getQuotaUsedInfo response=" + strM78761z);
            m81533k(str3, (QuotaUsedInfoRsp) new Gson().fromJson(strM78761z, QuotaUsedInfoRsp.class), str4);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("GetQuotaOrPimNumTask", "getQuotaNum JsonSyntaxException:" + e10.toString());
        } catch (C9721b e11) {
            C11839m.m70687e("GetQuotaOrPimNumTask", "getQuotaNum exception:" + e11.toString());
        }
    }

    /* renamed from: i */
    public void m81531i(String str, List<String> list, boolean z10, Map<String, String> map, Map<String, String> map2) {
        String str2;
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < list.size(); i10++) {
            stringBuffer.append(list.get(i10));
            if (i10 != list.size() - 1) {
                stringBuffer.append(",");
            }
        }
        C13049a c13049a = new C13049a(EnumC12999a.CLOUD_SYNC, C10812z.m65832a("03007"));
        StringBuffer stringBuffer2 = new StringBuffer("collection=private and kind in [");
        try {
            if (z10) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append("] and (trashed=true or trashed=false)");
                str2 = new String(stringBuffer2);
            } else {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append("] and (trashed=false)");
                str2 = new String(stringBuffer2);
            }
            String strM78761z = c13049a.m78761z(DriveSyncUtil.m17958C(str), str2);
            C11839m.m70686d("GetQuotaOrPimNumTask", "getQuotaNumCommon response: " + strM78761z);
            m81534l(list, (QuotaUsedInfoRsp) new Gson().fromJson(strM78761z, QuotaUsedInfoRsp.class), map, map2);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("GetQuotaOrPimNumTask", "getQuotaNumCommon JsonSyntaxException:" + e10.toString());
        } catch (C9721b e11) {
            C11839m.m70687e("GetQuotaOrPimNumTask", "getQuotaNumCommon exception:" + e11.toString());
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Map<String, Integer> map) throws RemoteException {
        C11839m.m70688i("GetQuotaOrPimNumTask", "onPostExecute");
        Message message = new Message();
        message.what = 1033;
        if (map == null) {
            C11839m.m70687e("GetQuotaOrPimNumTask", "NUM_TASK_EXECUTE_FAIL");
            message.arg1 = -5;
        } else {
            message.arg1 = 0;
            message.obj = map;
        }
        Messenger messenger = this.f61003b;
        if (messenger != null) {
            C11046a.m66596d(messenger, message);
        }
        CloudStorageTaskCallback cloudStorageTaskCallback = this.f61004c;
        if (cloudStorageTaskCallback != null) {
            cloudStorageTaskCallback.mo15484a("pim_num", map, 0);
            CountDownLatch countDownLatch = this.f61005d;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            } else {
                C11839m.m70687e("GetQuotaOrPimNumTask", "mLatch is null");
            }
        }
    }

    /* renamed from: k */
    public final void m81533k(String str, QuotaUsedInfoRsp quotaUsedInfoRsp, String str2) {
        QuotaDetail[] quotaDetails = quotaUsedInfoRsp.getQuotaDetails();
        if (quotaUsedInfoRsp.getRetCode() != 0) {
            C11839m.m70688i("GetQuotaOrPimNumTask", "quotausedinfo request failed");
            this.f61006e.put(str, 0);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f61006e.put(str2, 0);
            return;
        }
        C11839m.m70688i("GetQuotaOrPimNumTask", "getQuotaUsedInfo: " + str + " request success");
        if (quotaDetails.length > 0) {
            int recordsCount = 0;
            int recordsCount2 = 0;
            for (QuotaDetail quotaDetail : quotaDetails) {
                if (quotaDetail != null) {
                    if (quotaDetail.isTrashed()) {
                        recordsCount += quotaDetail.getRecordsCount();
                    } else {
                        recordsCount2 += quotaDetail.getRecordsCount();
                    }
                }
            }
            C11839m.m70686d("GetQuotaOrPimNumTask", str2 + " recyclerecordsCount :" + recordsCount);
            C11839m.m70686d("GetQuotaOrPimNumTask", str + " recordsCount :" + recordsCount2);
            if (str2 != null) {
                this.f61006e.put(str2, Integer.valueOf(recordsCount));
            }
            if (str != null) {
                this.f61006e.put(str, Integer.valueOf(recordsCount2));
            }
        }
    }

    /* renamed from: l */
    public final void m81534l(List<String> list, QuotaUsedInfoRsp quotaUsedInfoRsp, Map<String, String> map, Map<String, String> map2) {
        String str;
        if (quotaUsedInfoRsp.getRetCode() == 0) {
            C11839m.m70688i("GetQuotaOrPimNumTask", "getQuotaNumCommon request success");
            m81535m(list, quotaUsedInfoRsp.getQuotaDetails(), map, map2);
            return;
        }
        C11839m.m70688i("GetQuotaOrPimNumTask", "getQuotaNumCommon request failed");
        for (String str2 : list) {
            String str3 = map.get(str2);
            if (str3 != null) {
                this.f61006e.put(str3, 0);
            }
            if (map2 != null && (str = map2.get(str2)) != null) {
                this.f61006e.put(str, 0);
            }
        }
    }

    /* renamed from: m */
    public final void m81535m(List<String> list, QuotaDetail[] quotaDetailArr, Map<String, String> map, Map<String, String> map2) {
        String str;
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        if (quotaDetailArr.length > 0) {
            for (QuotaDetail quotaDetail : quotaDetailArr) {
                String kind = quotaDetail.getKind();
                if (!TextUtils.isEmpty(kind)) {
                    if (quotaDetail.isTrashed()) {
                        if (map4.containsKey(kind)) {
                            map4.put(kind, Integer.valueOf(((Integer) map4.get(kind)).intValue() + quotaDetail.getRecordsCount()));
                        } else {
                            map4.put(kind, Integer.valueOf(quotaDetail.getRecordsCount()));
                        }
                    } else if (map3.containsKey(kind)) {
                        map3.put(kind, Integer.valueOf(((Integer) map3.get(kind)).intValue() + quotaDetail.getRecordsCount()));
                    } else {
                        map3.put(kind, Integer.valueOf(quotaDetail.getRecordsCount()));
                    }
                }
            }
        }
        for (String str2 : list) {
            String str3 = map.get(str2);
            if (str3 != null) {
                this.f61006e.put(str3, (Integer) map3.get(str2));
            }
            if (map2 != null && (str = map2.get(str2)) != null) {
                this.f61006e.put(str, (Integer) map4.get(str2));
            }
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
    }
}
