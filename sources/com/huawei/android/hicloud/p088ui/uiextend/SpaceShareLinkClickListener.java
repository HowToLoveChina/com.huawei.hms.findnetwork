package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class SpaceShareLinkClickListener implements SpanClickText.ISpanClickListener {
    private static final String TAG = "SpaceShareLinkClickListener";
    private Context mContext;
    private TextView textView;
    private String url;

    public SpaceShareLinkClickListener(Context context, TextView textView, String str) {
        this.mContext = context;
        this.textView = textView;
        this.url = str;
    }

    private void gotoMore(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "url is empty");
            return;
        }
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "context is null");
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
            this.mContext.startActivity(intent);
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
    public void onClick() {
        if (this.textView == null) {
            return;
        }
        gotoMore(this.url);
    }
}
