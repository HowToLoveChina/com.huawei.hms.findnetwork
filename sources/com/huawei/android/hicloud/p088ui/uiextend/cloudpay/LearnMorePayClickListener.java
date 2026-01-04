package com.huawei.android.hicloud.p088ui.uiextend.cloudpay;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import dj.C9158a;
import java.lang.ref.WeakReference;
import p015ak.C0234s;
import p054cj.C1442a;

/* loaded from: classes3.dex */
public class LearnMorePayClickListener implements SpanClickText.ISpanClickListener {
    private static final String TAG = "LearnMorePayClickListener";
    private Context mContext;
    private LearnMorePayClick mHandler = new LearnMorePayClick();
    private String suffix;
    private String tag;

    public static class LearnMorePayClick extends Handler {
        private WeakReference<LearnMorePayClickListener> weakReference;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LearnMorePayClickListener learnMorePayClickListener = this.weakReference.get();
            if (learnMorePayClickListener != null && message.what == 2128) {
                learnMorePayClickListener.handlGetUrlHost(message.obj.toString());
            }
        }

        private LearnMorePayClick(LearnMorePayClickListener learnMorePayClickListener) {
            this.weakReference = new WeakReference<>(learnMorePayClickListener);
        }
    }

    public LearnMorePayClickListener(Context context, String str) {
        this.mContext = context;
        this.suffix = str;
    }

    private void getUrlHost() {
        C9158a.m57503F().m57527Y(this.mHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlGetUrlHost(String str) {
        if (this.mContext == null) {
            return;
        }
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e(TAG, "handlGetUrlHost host is empty set default suffix = " + this.suffix);
            str = "";
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this.suffix);
        sb2.append(C0234s.m1627e());
        String str3 = this.tag;
        if (str3 != null && !"".equals(str3)) {
            str2 = this.tag;
        }
        sb2.append(str2);
        intent.setData(Uri.parse(sb2.toString()));
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager == null || intent.resolveActivity(packageManager) == null) {
            return;
        }
        this.mContext.startActivity(intent);
    }

    @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
    public void onClick() {
        getUrlHost();
    }

    public LearnMorePayClickListener(Context context, String str, String str2) {
        this.mContext = context;
        this.suffix = str;
        this.tag = str2;
    }
}
