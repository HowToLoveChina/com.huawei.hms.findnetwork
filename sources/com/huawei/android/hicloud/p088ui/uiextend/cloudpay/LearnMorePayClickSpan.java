package com.huawei.android.hicloud.p088ui.uiextend.cloudpay;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.cloud.pay.R$color;
import dj.C9158a;
import java.lang.ref.WeakReference;
import p015ak.C0234s;
import p054cj.C1442a;

/* loaded from: classes3.dex */
public class LearnMorePayClickSpan extends ClickableSpan {
    private static final String TAG = "LearnMorePayClickSpan";
    private boolean isPressed;
    private Context mContext;
    private LearnMorePayClickSpanHandler mHandler = new LearnMorePayClickSpanHandler();
    private String suffix;
    private String tag;

    public static class LearnMorePayClickSpanHandler extends Handler {
        private WeakReference<LearnMorePayClickSpan> weakReference;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LearnMorePayClickSpan learnMorePayClickSpan = this.weakReference.get();
            if (learnMorePayClickSpan != null && message.what == 2128) {
                learnMorePayClickSpan.handleGetUrlHost(message.obj.toString());
            }
        }

        private LearnMorePayClickSpanHandler(LearnMorePayClickSpan learnMorePayClickSpan) {
            this.weakReference = new WeakReference<>(learnMorePayClickSpan);
        }
    }

    public LearnMorePayClickSpan(Context context, String str) {
        this.mContext = context;
        this.suffix = str;
    }

    private void getUrlHost() {
        C9158a.m57503F().m57527Y(this.mHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetUrlHost(String str) {
        if (this.mContext == null) {
            return;
        }
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e(TAG, "handleGetUrlHost host is empty set default suffix = " + this.suffix);
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

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        getUrlHost();
    }

    public void setPressed(boolean z10) {
        this.isPressed = z10;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.mContext.getResources().getColor(R$color.emui_functional_blue));
        textPaint.setUnderlineText(false);
    }

    public LearnMorePayClickSpan(Context context, String str, String str2) {
        this.mContext = context;
        this.suffix = str;
        this.tag = str2;
    }
}
