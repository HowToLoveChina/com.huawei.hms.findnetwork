package p771xd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.activity.GuideWebViewActivity;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11839m;
import p709vj.C13452e;

/* renamed from: xd.g */
/* loaded from: classes3.dex */
public class HandlerC13763g extends HandlerC13762f {

    /* renamed from: b */
    public Activity f61867b;

    public HandlerC13763g(Activity activity) {
        super(activity);
        this.f61867b = activity;
    }

    @Override // p771xd.HandlerC13762f
    /* renamed from: a */
    public void mo82659a(Object obj) {
        if (!(obj instanceof Bundle)) {
            C11839m.m70688i("H5DialogHandler", "QueryGuideH5Task parseGuidQueryH5Ok  !(object instanceof Bundle)");
            return;
        }
        Bundle bundle = (Bundle) obj;
        int i10 = bundle.getInt("queryh5oknum");
        C11839m.m70688i("H5DialogHandler", "QueryGuideH5Task parseGuidQueryH5Ok  queryH5OkNum: " + i10);
        String string = bundle.getString("packageId");
        String string2 = bundle.getString(NotifyConstants.Keys.NOTIFY_TYPE);
        String string3 = bundle.getString(NotifyConstants.Keys.NOTIFY_URI);
        String string4 = bundle.getString("h5Uri");
        String string5 = bundle.getString("activeUri");
        String string6 = bundle.getString("gradeCode");
        String string7 = bundle.getString("expireTime");
        C11839m.m70688i("H5DialogHandler", "QueryGuideH5Task viewWeb h5Url: " + string4);
        if (this.f61867b == null) {
            C11839m.m70687e("H5DialogHandler", "parseGuidQueryH5Ok mActivity is null.");
            return;
        }
        String string8 = bundle.getString(FrequencyManager.H5DialogConstant.FROM_WHICH_ACTIVITY);
        if (m82661c(string8)) {
            C11839m.m70686d("H5DialogHandler", "can not start Activity for other apps, only save sp");
            return;
        }
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70688i("H5DialogHandler", "parseGuidQueryH5Ok child account, return!");
        } else if (i10 == 3 || i10 == 4) {
            m82662d(string4, string, string2, string3, i10, string5, string8, string6, string7);
        }
    }

    /* renamed from: c */
    public final boolean m82661c(String str) {
        return (CloudBackupConstant.Command.PMS_CMD_BACKUP.equals(str) || "clean".equals(str)) ? false : true;
    }

    /* renamed from: d */
    public void m82662d(String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7, String str8) {
        try {
            Intent intent = new Intent(C0213f.m1377a(), (Class<?>) GuideWebViewActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("fromwhichactivity", str6);
            intent.putExtra("notifyAction", i10);
            intent.putExtra("isEnableJs", true);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_TYPE, str3);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_URI, str4);
            intent.putExtra("packageId", str2);
            intent.putExtra("activeUri", str5);
            intent.putExtra("gradeCode", str7);
            intent.putExtra("expireTime", str8);
            this.f61867b.startActivity(intent);
            long jCurrentTimeMillis = System.currentTimeMillis();
            C0212e0.m1370t(this.f61867b, FrequencyManager.CHECK_GUID_H5_DIALOG_SP, FrequencyManager.CHECK_GUID_H5_DIALOG_TIME, jCurrentTimeMillis);
            C11839m.m70688i("H5DialogHandler", " QueryGuideH5Task parseGuidQueryH5Ok System.currentTimeMillis(): " + jCurrentTimeMillis);
        } catch (Exception e10) {
            C11839m.m70687e("H5DialogHandler", "viewWeb Exception: " + e10.toString());
        }
    }
}
