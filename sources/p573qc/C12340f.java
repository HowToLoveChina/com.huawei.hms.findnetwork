package p573qc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.bean.CloudSyncRetryInfo;
import com.huawei.android.hicloud.sync.service.aidl.ServiceSyncLogicUtil;
import com.huawei.android.hicloud.sync.syncutil.C2973b;
import com.huawei.hicloud.bean.RetryPolicy;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: qc.f */
/* loaded from: classes3.dex */
public class C12340f {

    /* renamed from: c */
    public static final C12340f f57121c = new C12340f();

    /* renamed from: a */
    public ServiceSyncLogicUtil f57122a;

    /* renamed from: b */
    public final Handler f57123b = new a(Looper.getMainLooper());

    /* renamed from: qc.f$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1001) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                String str = (String) obj;
                C11839m.m70688i("SyncRetryObserverManager", str + " accept  DELAY_START_SYNC ");
                if (C12340f.this.f57122a == null) {
                    C12340f.this.f57122a = new ServiceSyncLogicUtil(C0213f.m1377a());
                }
                C2973b.m17826n(str, Boolean.TRUE);
                C12340f.this.f57122a.startSyncForSyncRetry(str, 9, "");
            }
        }
    }

    /* renamed from: d */
    public static final C12340f m74268d() {
        return f57121c;
    }

    /* renamed from: c */
    public final void m74269c(int i10, CloudSyncRetryInfo cloudSyncRetryInfo, Map<String, RetryPolicy> map, String str) {
        C11839m.m70688i("SyncRetryObserverManager", str + " opportunity  :" + i10);
        RetryPolicy retryPolicy = map.get(cloudSyncRetryInfo.getSyncType());
        if (retryPolicy != null) {
            C11839m.m70686d("SyncRetryObserverManager", str + " use OM syncType");
            m74276k(i10, cloudSyncRetryInfo, retryPolicy, str);
            return;
        }
        RetryPolicy retryPolicy2 = map.get("default");
        if (retryPolicy2 != null) {
            C11839m.m70686d("SyncRetryObserverManager", str + " use OM default");
            m74276k(i10, cloudSyncRetryInfo, retryPolicy2, str);
            return;
        }
        RetryPolicy retryPolicy3 = new RetryPolicy(str, 3, 120, 3);
        C11839m.m70686d("SyncRetryObserverManager", str + " use local default");
        m74276k(i10, cloudSyncRetryInfo, retryPolicy3, str);
    }

    /* renamed from: e */
    public final boolean m74270e(String str) {
        CloudSyncRetryInfo cloudSyncRetryInfoM17817e = C2973b.m17817e(C0213f.m1377a(), str);
        if (cloudSyncRetryInfoM17817e == null) {
            return false;
        }
        boolean zIsRetry = cloudSyncRetryInfoM17817e.isRetry();
        C11839m.m70686d("SyncRetryObserverManager", str + ", isRetry :" + zIsRetry);
        return zIsRetry;
    }

    /* renamed from: f */
    public final boolean m74271f(int i10, int i11, String str) {
        if (i11 == 0) {
            C11839m.m70689w("SyncRetryObserverManager", str + "opportunityOM is 0 no retry, isSatisfyMoment flag  :false");
            return false;
        }
        if (i11 == 1) {
            return true;
        }
        if (i11 == 2) {
            C11839m.m70689w("SyncRetryObserverManager", str + "opportunityOM is only Charging triggering no retry:, isSatisfyMoment flag  :false");
            return false;
        }
        boolean zM15941B = i11 == 3 ? CloudSyncUtil.m15941B(C0213f.m1377a()) : false;
        C11839m.m70686d("SyncRetryObserverManager", str + ", opportunityOM :" + i11 + ", opportunity :" + i10 + ", isSatisfyMoment flag  :" + zM15941B);
        return zM15941B;
    }

    /* renamed from: g */
    public final boolean m74272g(int i10, long j10, String str, long j11) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j12 = j10 > 0 ? jCurrentTimeMillis - j10 : jCurrentTimeMillis - j11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(", periodOM :");
        sb2.append(i10);
        sb2.append(", periodOMlong :");
        long j13 = i10 * 60000;
        sb2.append(j13);
        sb2.append(",retrytimeFromSp :");
        sb2.append(j10);
        sb2.append(",syncTimeFromSp :");
        sb2.append(j11);
        sb2.append(",time :");
        sb2.append(j12);
        C11839m.m70686d("SyncRetryObserverManager", sb2.toString());
        return j12 > j13;
    }

    /* renamed from: h */
    public final boolean m74273h(int i10, int i11, String str) {
        C11839m.m70686d("SyncRetryObserverManager", str + ", timesOM :" + i10 + ", timesFormSp :" + i11);
        return i11 < i10;
    }

    /* renamed from: i */
    public final void m74274i(String str) {
        if (!C0209d.m1208S0(C0213f.m1377a())) {
            C11839m.m70689w("SyncRetryObserverManager", "startSyncRetry network not connect error no retey");
            return;
        }
        Message message = new Message();
        message.what = 1001;
        message.obj = str;
        int iNextInt = new SecureRandom().nextInt(300);
        C11839m.m70688i("SyncRetryObserverManager", str + " delay  startSyncRetry sleepTime :" + iNextInt);
        this.f57123b.sendMessageDelayed(message, (long) iNextInt);
    }

    /* renamed from: j */
    public void m74275j(int i10) {
        if (!C0209d.m1208S0(C0213f.m1377a())) {
            C11839m.m70689w("SyncRetryObserverManager", "syncRetry network not connect error no retey");
            return;
        }
        Map<String, RetryPolicy> mapM17816d = C2973b.m17816d();
        if (mapM17816d == null) {
            C11839m.m70689w("SyncRetryObserverManager", "retryOMParam is null no retry");
            return;
        }
        String[] strArrM17818f = C2973b.m17818f(C0213f.m1377a());
        if (strArrM17818f == null) {
            C11839m.m70689w("SyncRetryObserverManager", "syncTypes is null no retry");
            return;
        }
        C11839m.m70688i("SyncRetryObserverManager", "syncRetry start syncTypes form sp  :" + Arrays.toString(strArrM17818f));
        for (String str : strArrM17818f) {
            if (TextUtils.isEmpty(str)) {
                C11839m.m70689w("SyncRetryObserverManager", "syncType is null or empty");
            } else {
                CloudSyncRetryInfo cloudSyncRetryInfoM17817e = C2973b.m17817e(C0213f.m1377a(), str);
                if (cloudSyncRetryInfoM17817e == null) {
                    C11839m.m70689w("SyncRetryObserverManager", str + "retryInfo is null");
                } else if (cloudSyncRetryInfoM17817e.getSyncStatus() == 0) {
                    C11839m.m70689w("SyncRetryObserverManager", str + "getSyncStatus is 0 not retry");
                } else {
                    m74269c(i10, cloudSyncRetryInfoM17817e, mapM17816d, str);
                }
            }
        }
    }

    /* renamed from: k */
    public final void m74276k(int i10, CloudSyncRetryInfo cloudSyncRetryInfo, RetryPolicy retryPolicy, String str) {
        if (retryPolicy == null) {
            C11839m.m70688i("SyncRetryObserverManager", str + "retryPolicy is null");
            return;
        }
        if (cloudSyncRetryInfo == null) {
            C11839m.m70688i("SyncRetryObserverManager", str + "retryInfo is null");
            return;
        }
        int moment = retryPolicy.getMoment();
        int period = retryPolicy.getPeriod();
        int retryTimes = retryPolicy.getRetryTimes();
        long retryTime = cloudSyncRetryInfo.getRetryTime();
        int retryTimes2 = cloudSyncRetryInfo.getRetryTimes();
        long syncTime = cloudSyncRetryInfo.getSyncTime();
        if (!m74271f(i10, moment, str)) {
            C11839m.m70689w("SyncRetryObserverManager", str + ",opportunityOM  :" + moment + ",opportunity " + i10 + " not Satisfy Moment");
            return;
        }
        if (!m74272g(period, retryTime, str, syncTime)) {
            C11839m.m70689w("SyncRetryObserverManager", str + ",periodOM  :" + period + " not Satisfy period ");
            return;
        }
        if (m74273h(retryTimes, retryTimes2, str)) {
            if (!m74270e(str)) {
                m74274i(str);
                return;
            }
            C11839m.m70689w("SyncRetryObserverManager", str + " is have RetryTask no retry");
            return;
        }
        C11839m.m70689w("SyncRetryObserverManager", str + ",retryTimesOM  :" + retryTimes + ",retryTimesSp :" + retryTimes2 + " not Satisfy period ");
    }
}
