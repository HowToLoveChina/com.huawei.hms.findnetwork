package com.huawei.hicloud.messagecenter.richmessage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes6.dex */
public abstract class BaseItem {

    /* renamed from: DP */
    private static final String f22619DP = "dp";
    private static final String TAG = "BaseItem";
    protected String marginBottom;
    protected String marginLeft;
    protected String marginRight;
    protected String marginTop;

    private int getMargin(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return dip2px(context, Float.valueOf(str.split("dp")[0]).floatValue());
        } catch (NumberFormatException unused) {
            NotifyLogger.m29914e(TAG, "getMargin NumberFormatException.");
            return 0;
        }
    }

    public int dip2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public abstract View onCreateView(Context context, ViewGroup viewGroup);

    public abstract void parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException;

    public abstract void setAttributes(XmlPullParser xmlPullParser);

    public void setMargin(Context context, LinearLayout.LayoutParams layoutParams) {
        layoutParams.leftMargin = getMargin(context, this.marginLeft);
        layoutParams.topMargin = getMargin(context, this.marginTop);
        layoutParams.rightMargin = getMargin(context, this.marginRight);
        layoutParams.bottomMargin = getMargin(context, this.marginBottom);
    }
}
