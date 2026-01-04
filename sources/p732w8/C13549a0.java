package p732w8;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudspace.manager.QuotaInfoCallback;
import com.huawei.android.hicloud.cloudspace.manager.QuotaInfoModuleCallback;
import com.huawei.android.hicloud.commonlib.space.FullQuotaInfo;
import com.huawei.android.hicloud.commonlib.space.QuotaInfoRsp;
import com.huawei.android.hicloud.commonlib.space.UsedSpaceInfo;
import com.huawei.hicloud.base.bean.QuotaInfo;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p618rm.C12540b1;
import p703v8.C13367d;
import p703v8.C13368e;
import p703v8.C13376m;
import p703v8.C13378o;
import p709vj.C13452e;

/* renamed from: w8.a0 */
/* loaded from: classes2.dex */
public class C13549a0 extends AbstractC12367d {

    /* renamed from: a */
    public QuotaInfoCallback f60944a;

    /* renamed from: b */
    public QuotaInfoRsp f60945b;

    /* renamed from: c */
    public FullQuotaInfo f60946c;

    /* renamed from: d */
    public CountDownLatch f60947d;

    /* renamed from: e */
    public boolean f60948e = true;

    /* renamed from: f */
    public int f60949f = C0209d.m1260h0(1, 10000);

    /* renamed from: w8.a0$a */
    public static class a implements QuotaInfoModuleCallback {

        /* renamed from: a */
        public C13549a0 f60950a;

        public a(C13549a0 c13549a0) {
            this.f60950a = c13549a0;
        }

        @Override // com.huawei.android.hicloud.cloudspace.manager.QuotaInfoModuleCallback
        /* renamed from: a */
        public void mo15492a(String str) {
            C13549a0 c13549a0 = this.f60950a;
            if (c13549a0 != null) {
                c13549a0.m81485k();
                this.f60950a.m81482f();
            }
        }

        @Override // com.huawei.android.hicloud.cloudspace.manager.QuotaInfoModuleCallback
        /* renamed from: b */
        public void mo15493b(String str, long j10) {
            C13549a0 c13549a0 = this.f60950a;
            if (c13549a0 != null) {
                c13549a0.m81488n(str, j10);
                this.f60950a.m81482f();
            }
        }
    }

    public C13549a0(QuotaInfoCallback quotaInfoCallback) {
        this.f60944a = quotaInfoCallback;
    }

    /* renamed from: h */
    public static boolean m81481h(long j10) {
        return j10 <= 0 && !(C13452e.m80781L().m80798E() == 0 && C13452e.m80781L().m80791C0());
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C13378o c13378o = new C13378o();
        HashMap map = new HashMap();
        map.put("operation", "QuotaInfoTask");
        map.put(MapKeyNames.REQUEST_ID, String.valueOf(this.f60949f));
        try {
            QuotaInfoRsp quotaInfoRspM80309e = c13378o.m80309e();
            this.f60945b = quotaInfoRspM80309e;
            if (this.f60944a == null) {
                C11839m.m70687e("QuotaInfoTask", "callback is null");
            } else {
                if (quotaInfoRspM80309e == null) {
                    C11839m.m70687e("QuotaInfoTask", "call,rsp is null");
                    this.f60944a.mo15490a();
                    map.put("result", "0");
                    map.put("error_reason", "001");
                    C13376m.m80302a().m80304c(map);
                    return;
                }
                if (quotaInfoRspM80309e.getRetCode() == 0 && m81486l(map)) {
                    C11839m.m70688i("QuotaInfoTask", "notifyQuerySuccess");
                    map.put("result", "1");
                    FullQuotaInfo fullQuotaInfo = this.f60946c;
                    if (fullQuotaInfo != null) {
                        map.put("brief", fullQuotaInfo.toString());
                    }
                    m81484j();
                } else {
                    C11839m.m70687e("QuotaInfoTask", "notifyQueryFailed");
                    map.put("result", "0");
                    this.f60944a.mo15490a();
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("QuotaInfoTask", "call exception:" + e10.toString());
            this.f60944a.mo15490a();
            map.put("result", "0");
            map.put("error_reason", "009");
        }
        C13376m.m80302a().m80304c(map);
    }

    /* renamed from: f */
    public final void m81482f() {
        CountDownLatch countDownLatch = this.f60947d;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* renamed from: g */
    public final boolean m81483g(Map<String, String> map) {
        try {
            FullQuotaInfo fullQuotaInfo = this.f60946c;
            if (fullQuotaInfo == null) {
                C11839m.m70687e("QuotaInfoTask", "getQuotaInfoSeperately,minfo is null");
                return false;
            }
            List<UsedSpaceInfo> usedInfos = fullQuotaInfo.getUsedInfos();
            if (usedInfos != null && usedInfos.size() > 0) {
                this.f60947d = new CountDownLatch(usedInfos.size());
                Iterator<UsedSpaceInfo> it = usedInfos.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    UsedSpaceInfo next = it.next();
                    if (next != null) {
                        C12515a.m75110o().m75175e(new C13575z(next.getService(), next.getUrl(), new a(this), this.f60949f), false);
                    } else if (this.f60944a != null) {
                        C11839m.m70687e("QuotaInfoTask", "hasException, return false");
                        map.put("result", "0");
                        map.put("error_reason", "005");
                        return false;
                    }
                }
                if (this.f60947d.await(30000L, TimeUnit.MILLISECONDS)) {
                    return this.f60948e;
                }
                C11839m.m70687e("QuotaInfoTask", "latch timeout, return false");
                map.put("result", "0");
                map.put("error_reason", "006");
                return false;
            }
            C11839m.m70687e("QuotaInfoTask", "getQuotaInfoSeperately,usedInfos is null");
            map.put("result", "0");
            map.put("error_reason", "004");
            return false;
        } catch (Exception e10) {
            String string = e10.toString();
            C11839m.m70687e("QuotaInfoTask", "getQuotaInfoSeperately exception:" + string);
            map.put("result", "0");
            map.put("error_reason", "007");
            map.put("brief", string);
            return false;
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.FAMILY_SHARE;
    }

    /* renamed from: j */
    public final void m81484j() throws JSONException {
        if (this.f60944a == null) {
            return;
        }
        C13368e.m80184F().m80210C0(this.f60946c);
        m81487m();
        this.f60944a.mo15491b();
    }

    /* renamed from: k */
    public final void m81485k() {
        this.f60948e = false;
    }

    /* renamed from: l */
    public final boolean m81486l(Map<String, String> map) {
        QuotaInfoRsp quotaInfoRsp = this.f60945b;
        if (quotaInfoRsp == null) {
            C11839m.m70687e("QuotaInfoTask", "processRetCodeSuccess,mRsp null");
            this.f60944a.mo15490a();
            return false;
        }
        FullQuotaInfo retBody = quotaInfoRsp.getRetBody();
        this.f60946c = retBody;
        if (retBody == null) {
            C11839m.m70687e("QuotaInfoTask", "processRetCodeSuccess,mInfo null");
            this.f60944a.mo15490a();
            map.put("result", "0");
            map.put("error_reason", "002");
            return false;
        }
        String retType = retBody.getRetType();
        if (TextUtils.isEmpty(retType)) {
            C11839m.m70687e("QuotaInfoTask", "quotaDetailType null");
            this.f60944a.mo15490a();
            map.put("result", "0");
            map.put("error_reason", "003");
            return false;
        }
        map.put("quota_detail_type", retType);
        if (retType.equals("val")) {
            return true;
        }
        if (retType.equals("url")) {
            return m81483g(map);
        }
        C11839m.m70687e("QuotaInfoTask", "quotaDetailType no match:" + retType);
        return false;
    }

    /* renamed from: m */
    public final void m81487m() throws JSONException {
        QuotaInfo quotaInfo;
        QuotaSpaceInfo quotaSpaceInfo;
        List<UsedSpaceInfo> usedInfos;
        try {
            C11839m.m70688i("QuotaInfoTask", "saveQuotaInfoToCache");
            FullQuotaInfo fullQuotaInfo = this.f60946c;
            if (fullQuotaInfo == null || (quotaInfo = fullQuotaInfo.getQuotaInfo()) == null || (quotaSpaceInfo = quotaInfo.getQuotaSpaceInfo()) == null) {
                return;
            }
            long total = quotaSpaceInfo.getTotal();
            long used = quotaSpaceInfo.getUsed();
            long available = quotaSpaceInfo.getAvailable();
            if (m81481h(total) || (usedInfos = this.f60946c.getUsedInfos()) == null) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (UsedSpaceInfo usedSpaceInfo : usedInfos) {
                JSONObject jSONObject = new JSONObject();
                String service = usedSpaceInfo.getService();
                String key = usedSpaceInfo.getKey();
                if (!TextUtils.isEmpty(service) && !TextUtils.isEmpty(key)) {
                    jSONObject.put("key", key);
                    jSONObject.put("service", service);
                    jSONObject.put("module_used_size", usedSpaceInfo.getUsed());
                    jSONArray.put(jSONObject);
                }
                return;
            }
            C0212e0.m1373w(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "used_space_info_list_json", C12540b1.m75485c(this.f60946c));
            C0212e0.m1373w(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "used_space_info_list", jSONArray.toString());
            C0212e0.m1371u(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "total_size", total);
            C0212e0.m1371u(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "used_size", used);
            C0212e0.m1371u(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "available_size", available);
            QuotaSpaceInfo quotaSpaceInfo2 = new QuotaSpaceInfo();
            quotaSpaceInfo2.setTotal(total);
            quotaSpaceInfo2.setUsed(used);
            quotaSpaceInfo2.setAvailable(available);
            C13367d.m80177a(quotaSpaceInfo2);
        } catch (Exception e10) {
            C11839m.m70687e("QuotaInfoTask", "saveQuotaInfoToCache exception: " + e10.toString());
        }
    }

    /* renamed from: n */
    public final void m81488n(String str, long j10) {
        List<UsedSpaceInfo> usedInfos;
        if (this.f60946c == null || TextUtils.isEmpty(str) || (usedInfos = this.f60946c.getUsedInfos()) == null || usedInfos.size() <= 0) {
            return;
        }
        for (UsedSpaceInfo usedSpaceInfo : usedInfos) {
            if (usedSpaceInfo != null && str.equals(usedSpaceInfo.getService())) {
                usedSpaceInfo.setUsed(j10);
            }
        }
    }
}
