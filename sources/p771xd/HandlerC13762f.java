package p771xd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.p088ui.activity.GuideWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11829c;
import p514o9.C11839m;
import p709vj.C13452e;

/* renamed from: xd.f */
/* loaded from: classes3.dex */
public class HandlerC13762f extends Handler {

    /* renamed from: a */
    public Activity f61866a;

    public HandlerC13762f(Activity activity) {
        this.f61866a = activity;
    }

    /* renamed from: a */
    public void mo82659a(Object obj) {
        if (!(obj instanceof Bundle)) {
            C11839m.m70688i("GuideInfoHandler", "QueryGuideH5Task parseGuidQueryH5Ok  !(object instanceof Bundle)");
            return;
        }
        if (!C11829c.m70581h0(MainActivity.class, this.f61866a)) {
            C11839m.m70688i("GuideInfoHandler", "QueryGuideH5Task MainActivity not at top of the stack, no need to show");
            return;
        }
        C11839m.m70688i("GuideInfoHandler", "QueryGuideH5Task MainActivity at top of the stack, need to show");
        Bundle bundle = (Bundle) obj;
        int i10 = bundle.getInt("queryh5oknum");
        C11839m.m70688i("GuideInfoHandler", "QueryGuideH5Task parseGuidQueryH5Ok  queryH5OkNum: " + i10);
        String string = bundle.getString("packageId");
        String string2 = bundle.getString(NotifyConstants.Keys.NOTIFY_TYPE);
        String string3 = bundle.getString(NotifyConstants.Keys.NOTIFY_URI);
        String string4 = bundle.getString("h5Uri");
        String string5 = bundle.getString("activeUri");
        String string6 = bundle.getString("gradeCode");
        String string7 = bundle.getString("expireTime");
        C11839m.m70688i("GuideInfoHandler", "QueryGuideH5Task viewWeb h5Url: " + string4);
        if (this.f61866a == null) {
            C11839m.m70687e("GuideInfoHandler", "parseGuidQueryH5Ok mActivity is null.");
            return;
        }
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70688i("GuideInfoHandler", "parseGuidQueryH5Ok child account, return!");
            return;
        }
        if (i10 == 0) {
            m82660b(string4, string, "", "", i10, "", "", "");
            return;
        }
        if (i10 == 1) {
            m82660b(string4, "", "", string3, i10, string5, "", "");
            return;
        }
        if (i10 == 2) {
            m82660b(string4, "", string2, string3, i10, "", "", "");
        } else if (i10 == 3 || i10 == 4) {
            m82660b(string4, string, string2, string3, i10, string5, string6, string7);
        }
    }

    /* renamed from: b */
    public void m82660b(String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7) {
        try {
            Intent intent = new Intent(C0213f.m1377a(), (Class<?>) GuideWebViewActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("fromwhichactivity", RecommendCardConstants.Entrance.HOMEPAGE);
            intent.putExtra("notifyAction", i10);
            intent.putExtra("isEnableJs", true);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_TYPE, str3);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_URI, str4);
            intent.putExtra("packageId", str2);
            intent.putExtra("activeUri", str5);
            intent.putExtra("gradeCode", str6);
            intent.putExtra("expireTime", str7);
            this.f61866a.startActivity(intent);
            long jCurrentTimeMillis = System.currentTimeMillis();
            C0212e0.m1370t(this.f61866a, FrequencyManager.CHECK_GUID_H5_DIALOG_SP, FrequencyManager.CHECK_GUID_H5_DIALOG_TIME, jCurrentTimeMillis);
            C11839m.m70688i("GuideInfoHandler", " QueryGuideH5Task parseGuidQueryH5Ok System.currentTimeMillis(): " + jCurrentTimeMillis);
        } catch (Exception e10) {
            C11839m.m70687e("GuideInfoHandler", "viewWeb Exception: " + e10.toString());
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C11839m.m70688i("GuideInfoHandler", "msg.what: " + message.what);
        int i10 = message.what;
        if (i10 == 0) {
            C11839m.m70688i("GuideInfoHandler", "QUERY_H5_FAIL");
        } else if (i10 == 1) {
            mo82659a(message.obj);
        }
    }
}
