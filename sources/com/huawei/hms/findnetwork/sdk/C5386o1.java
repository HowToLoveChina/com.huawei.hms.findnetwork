package com.huawei.hms.findnetwork.sdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.findnetwork.comm.request.bean.NavigationInfo;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;

/* renamed from: com.huawei.hms.findnetwork.sdk.o1 */
/* loaded from: classes8.dex */
public class C5386o1 {

    /* renamed from: a */
    public final Handler f24814a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    public final b f24815b = new b();

    /* renamed from: com.huawei.hms.findnetwork.sdk.o1$b */
    public static class b implements Runnable {

        /* renamed from: a */
        public FindNetworkCallback f24816a;

        /* renamed from: b */
        public String f24817b;

        public b() {
        }

        /* renamed from: a */
        public void m32057a(FindNetworkCallback findNetworkCallback) {
            this.f24816a = findNetworkCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            m32058a(this.f24816a, this.f24817b);
        }

        /* renamed from: a */
        public final void m32058a(FindNetworkCallback findNetworkCallback, String str) {
            if (findNetworkCallback == null) {
                HmsFindSDKLog.m32128w("UltrasoundCallbackTask", "callback is null");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                HmsFindSDKLog.m32127i("UltrasoundCallbackTask", "callback.measureResult bodyStr is empty");
                return;
            }
            NavigationInfo navigationInfo = (NavigationInfo) JsonUtils.json2Object(str, NavigationInfo.class);
            if (navigationInfo == null) {
                HmsFindSDKLog.m32127i("UltrasoundCallbackTask", "json to NavigationInfo error, measureResult is null");
                return;
            }
            FindNetworkResult findNetworkResult = new FindNetworkResult();
            findNetworkResult.setData(navigationInfo);
            findNetworkCallback.onUpdate(findNetworkResult);
            HmsFindSDKLog.m32127i("UltrasoundCallbackTask", "callback.onUpdate() over");
        }

        /* renamed from: a */
        public void m32059a(String str) {
            this.f24817b = str;
        }
    }

    /* renamed from: c */
    public void m32055c(final FindNetworkCallback findNetworkCallback) {
        this.f24814a.post(new Runnable() { // from class: fq.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f48033a.m32049b(findNetworkCallback);
            }
        });
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void m32049b(FindNetworkCallback findNetworkCallback) {
        FindNetworkResult findNetworkResult = new FindNetworkResult();
        findNetworkResult.setRespCode(0);
        findNetworkResult.setData(null);
        findNetworkCallback.onSuccess(findNetworkResult);
        HmsFindSDKLog.m32127i("UltrasoundCallbackTask", "callback.onSuccess over");
    }

    /* renamed from: c */
    public void m32056c(final FindNetworkCallback findNetworkCallback, final int i10, final String str) {
        this.f24814a.post(new Runnable() { // from class: fq.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f48029a.m32050b(findNetworkCallback, i10, str);
            }
        });
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void m32050b(FindNetworkCallback findNetworkCallback, int i10, String str) {
        if (findNetworkCallback != null) {
            findNetworkCallback.onFail(new FindNetworkResult(i10, str, null));
        }
    }

    /* renamed from: a */
    public void m32054a(FindNetworkCallback findNetworkCallback, String str) {
        this.f24815b.m32057a(findNetworkCallback);
        this.f24815b.m32059a(str);
        this.f24814a.post(this.f24815b);
    }
}
