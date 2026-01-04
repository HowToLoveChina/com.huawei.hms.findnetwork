package com.huawei.hms.ads.installreferrer.api;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.huawei.hms.ads.installreferrer.commons.C5082a;
import com.huawei.hms.ads.installreferrer.commons.C5085d;
import com.huawei.hms.ads.installreferrer.commons.InterfaceC5084c;
import com.huawei.hms.ads.installreferrer.commons.LogUtil;
import com.huawei.hms.ads.installreferrer.commons.ThreadFactoryC5083b;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Keep
/* loaded from: classes8.dex */
public class DeeplinkClient {
    private static final int BLOCKING_QUEUE_CAPACITY = 2048;
    private static final int KEEP_ALIVE_TIME = 60;
    private static final String TAG = "DeeplinkClient";
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadFactoryC5083b("Deeplink"));
    private Context context;
    private OnDeeplinkAcquiredListener deepLinkListener;
    private Uri deeplinkUrl;

    @Keep
    public DeeplinkClient(Context context, OnDeeplinkAcquiredListener onDeeplinkAcquiredListener) {
        this.deepLinkListener = onDeeplinkAcquiredListener;
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchDeeplink(Uri uri) {
        try {
            Intent andCheckIntent = parseAndCheckIntent(this.context, uri.toString(), this.context.getPackageName());
            if (andCheckIntent == null) {
                LogUtil.logWarn(TAG, "cannot find target activity");
                return;
            }
            if (!(this.context instanceof Activity)) {
                andCheckIntent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            andCheckIntent.setClipData(ClipData.newPlainText("l", "t"));
            this.context.startActivity(andCheckIntent);
        } catch (Throwable unused) {
            LogUtil.logWarn(TAG, "handle intent url fail");
        }
    }

    private Intent parseAndCheckIntent(Context context, String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && context.getPackageManager() != null) {
                Intent uri = Intent.parseUri(Uri.decode(str), 1);
                if (!TextUtils.isEmpty(str2)) {
                    uri.setPackage(str2);
                }
                return uri.getData() != null ? uri.setDataAndTypeAndNormalize(uri.getData(), uri.getType()) : uri;
            }
        } catch (Throwable th2) {
            LogUtil.logWarn(TAG, "handle intent url fail! Exception is: " + th2.getClass().getSimpleName());
        }
        return null;
    }

    @Keep
    public void request() {
        try {
            THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.huawei.hms.ads.installreferrer.api.DeeplinkClient.1
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    String str;
                    InterfaceC5084c interfaceC5084cM30332a = C5085d.m30332a(DeeplinkClient.this.context);
                    if (interfaceC5084cM30332a.mo30331a()) {
                        str = "deeplink has request";
                    } else {
                        interfaceC5084cM30332a.mo30330a(true);
                        String strM30327a = C5082a.m30327a(DeeplinkClient.this.context);
                        DeeplinkClient.this.deeplinkUrl = C5082a.m30326a(strM30327a);
                        if (DeeplinkClient.this.deeplinkUrl != null) {
                            if (DeeplinkClient.this.deepLinkListener == null || DeeplinkClient.this.deepLinkListener.launchDeeplink(DeeplinkClient.this.deeplinkUrl)) {
                                return;
                            }
                            LogUtil.logInfo(DeeplinkClient.TAG, "start deeplink activity");
                            DeeplinkClient deeplinkClient = DeeplinkClient.this;
                            deeplinkClient.launchDeeplink(deeplinkClient.deeplinkUrl);
                            return;
                        }
                        str = "deeplink Url is empty";
                    }
                    LogUtil.logInfo(DeeplinkClient.TAG, str);
                }
            });
        } catch (Throwable unused) {
            LogUtil.logError(TAG, "request deeplink exception");
        }
    }
}
