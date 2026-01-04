package com.huawei.android.hicloud.common.task;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CardNumConfirmActivity;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.QueryO2OActivityResp;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0209d;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p550pb.C12126b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import uk.C13206d;

/* loaded from: classes3.dex */
public class ClickExchangeTask extends AbstractC12367d {

    /* renamed from: a */
    public Context f11992a;

    /* renamed from: b */
    public QueryO2OActivityResp f11993b;

    /* renamed from: c */
    public GetClientUIConfigResp f11994c;

    /* renamed from: d */
    public UserPackage f11995d;

    /* renamed from: e */
    public int f11996e;

    /* renamed from: f */
    public int f11997f;

    /* renamed from: g */
    public String f11998g;

    /* renamed from: h */
    public String f11999h;

    /* renamed from: i */
    public String f12000i;

    /* renamed from: j */
    public Bundle f12001j;

    public interface QueryO2OCallback {
        /* renamed from: a */
        void mo15793a(QueryO2OActivityResp queryO2OActivityResp, GetClientUIConfigResp getClientUIConfigResp, UserPackage userPackage);
    }

    /* renamed from: com.huawei.android.hicloud.common.task.ClickExchangeTask$a */
    public class C2762a implements QueryO2OCallback {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f12002a;

        public C2762a(CountDownLatch countDownLatch) {
            this.f12002a = countDownLatch;
        }

        @Override // com.huawei.android.hicloud.common.task.ClickExchangeTask.QueryO2OCallback
        /* renamed from: a */
        public void mo15793a(QueryO2OActivityResp queryO2OActivityResp, GetClientUIConfigResp getClientUIConfigResp, UserPackage userPackage) {
            C11839m.m70687e("ClickExchangeTask", "QueryO2OActivityTask queryFinish");
            ClickExchangeTask clickExchangeTask = ClickExchangeTask.this;
            clickExchangeTask.f11993b = queryO2OActivityResp;
            clickExchangeTask.f11994c = getClientUIConfigResp;
            ClickExchangeTask.this.f11995d = userPackage;
            this.f12002a.countDown();
        }
    }

    public ClickExchangeTask(Context context, GetClientUIConfigResp getClientUIConfigResp, UserPackage userPackage, int i10) {
        this.f11992a = context;
        this.f11994c = getClientUIConfigResp;
        this.f11995d = userPackage;
        this.f11996e = i10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws InterruptedException {
        boolean zAwait;
        QueryO2OActivityResp queryO2OActivityResp;
        C11839m.m70688i("ClickExchangeTask", "ClickExchangeTask");
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        if (this.f11992a == null) {
            C11839m.m70687e("ClickExchangeTask", "call context is null.");
            m15791e("ExchangeContextNull", linkedHashMapM79497A);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C12515a.m75110o().m75172d(new C2763a(new C2762a(countDownLatch), this.f11994c, this.f11995d, this.f11996e));
        try {
            zAwait = countDownLatch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e10) {
            C11839m.m70687e("ClickExchangeTask", "queryO2OActivityTask e = " + e10.getMessage());
            zAwait = true;
        }
        C11839m.m70688i("ClickExchangeTask", "notTimeOut = " + zAwait);
        if (!zAwait || (queryO2OActivityResp = this.f11993b) == null || TextUtils.isEmpty(queryO2OActivityResp.getActivityLinkUrl())) {
            m15790d(linkedHashMapM79497A);
            return;
        }
        m15791e("goto_aop_h5", linkedHashMapM79497A);
        String strM79403c = C13206d.m79403c(C13206d.m79403c(this.f11993b.getActivityLinkUrl(), "darkmode", "0"), "actionbar", String.valueOf(2));
        Intent intent = new Intent(this.f11992a, (Class<?>) OperationWebViewActivity.class);
        intent.putExtra("channel_refer", "2");
        intent.putExtra("nav_source", 0);
        intent.putExtra("is_activity_need_back_to_main", false);
        intent.putExtra("url", strM79403c);
        intent.putExtra("is_support_orientation", false);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("launch_web_type", 9);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.putExtra("is_support_dark_mode", true);
        intent.putExtra("actionbar_background", true);
        if (!TextUtils.isEmpty(this.f11998g)) {
            intent.putExtra("srcChannel", this.f11998g);
        }
        if (!TextUtils.isEmpty(this.f11999h)) {
            intent.putExtra("activityCode", this.f11999h);
        }
        intent.putExtra("aop_from_where", this.f11996e);
        this.f11992a.startActivity(intent);
    }

    /* renamed from: d */
    public final void m15790d(LinkedHashMap<String, String> linkedHashMap) {
        try {
            m15791e("goto_native_exchange", linkedHashMap);
            if (this.f11996e == 3) {
                C12126b.m72707c(this.f12000i, this.f12001j);
                return;
            }
            Intent intent = new Intent(this.f11992a, (Class<?>) CardNumConfirmActivity.class);
            intent.putExtra("params", this.f11994c);
            intent.putExtra("user", this.f11995d);
            intent.putExtra("from_where", this.f11996e);
            if (this.f11996e == 1) {
                intent.putExtra("chosen_backup_frequency", this.f11997f);
            }
            ((Activity) this.f11992a).startActivityForResult(intent, 10004);
        } catch (Exception e10) {
            C11839m.m70687e("ClickExchangeTask", "gotoExchangeActivity err : " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public void m15791e(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap != null) {
            try {
                linkedHashMap.put("from_where", String.valueOf(this.f11996e));
                if (!TextUtils.isEmpty(this.f11998g)) {
                    linkedHashMap.put("pay_src_channel", this.f11998g);
                }
                if (!TextUtils.isEmpty(this.f11999h)) {
                    linkedHashMap.put("pay_activity_code", this.f11999h);
                }
                C13230i.m79504I().m79567R(str, linkedHashMap);
                UBAAnalyze.m29958S("PVC", str, "1", "31", linkedHashMap);
                m15792f(str, linkedHashMap);
            } catch (Exception e10) {
                C11839m.m70687e("ClickExchangeTask", "reportActivityBaseEvent occur:" + e10.getMessage());
            }
        }
    }

    /* renamed from: f */
    public void m15792f(String str, LinkedHashMap<String, String> linkedHashMap) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06030"), "06030", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B(str);
        c11060cM66626a.m66665u("0");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    public ClickExchangeTask(Context context, GetClientUIConfigResp getClientUIConfigResp, UserPackage userPackage, int i10, int i11) {
        this.f11992a = context;
        this.f11994c = getClientUIConfigResp;
        this.f11995d = userPackage;
        this.f11996e = i10;
        this.f11997f = i11;
    }

    public ClickExchangeTask(Context context, int i10, String str, String str2, String str3, Bundle bundle) {
        this.f11992a = context;
        this.f11996e = i10;
        this.f11998g = str;
        this.f11999h = str2;
        this.f12000i = str3;
        this.f12001j = bundle;
    }
}
