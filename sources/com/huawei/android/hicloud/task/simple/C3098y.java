package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudspace.bean.TotalStorageInfo;
import com.huawei.hicloud.notification.constants.BackUpOverMonthRecordConstants;
import fk.C9721b;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0214f0;
import p015ak.C0223k;
import p015ak.C0241z;
import p514o9.C11836j;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p652t9.EnumC12999a;
import p703v8.C13368e;
import to.C13049a;

/* renamed from: com.huawei.android.hicloud.task.simple.y */
/* loaded from: classes3.dex */
public final class C3098y extends AbstractC12367d {

    /* renamed from: a */
    public Handler f13409a;

    /* renamed from: b */
    public Context f13410b;

    public C3098y(Context context, Handler handler) {
        this.f13410b = context.getApplicationContext();
        this.f13409a = handler;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Message messageObtain = Message.obtain(this.f13409a);
        messageObtain.what = 17034;
        try {
            JSONObject jSONObject = new JSONObject(new C13049a(EnumC12999a.CLOUD_MORE, null).m78708G(new String[]{"profile.usedspacecapacity", "product.spacecapacity", "profile.spaceextcapacity"}));
            long jM1688f = C0241z.m1688f(jSONObject.getString("profile.usedspacecapacity"));
            long jM1688f2 = C0241z.m1688f(jSONObject.getString("product.spacecapacity")) + C0241z.m1688f(jSONObject.getString("profile.spaceextcapacity"));
            long j10 = jM1688f2 - jM1688f;
            if (j10 < 0) {
                j10 = 0;
            }
            float f10 = j10 / jM1688f2;
            String strM1524g = C0223k.m1524g(this.f13410b, jM1688f2);
            String strM1524g2 = C0223k.m1524g(this.f13410b, jM1688f);
            String strM1524g3 = C0223k.m1524g(this.f13410b, j10);
            Bundle bundle = new Bundle();
            bundle.putString("total_space", strM1524g);
            bundle.putLong("total_space_value", jM1688f2);
            bundle.putString(BackUpOverMonthRecordConstants.Report.AVAILABLE_SPACE, strM1524g3);
            bundle.putString("used_space", strM1524g2);
            bundle.putLong("used_space_value", jM1688f);
            bundle.putLong("available_space_value", j10);
            bundle.putFloat("available_percentage", f10);
            C11836j.m70658k().m70661c(strM1524g, strM1524g3, f10, j10);
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(this.f13410b, "com.huawei.android.ds_spcace_detail_cache", 0);
            sharedPreferencesM1382b.edit().putString("cloudSpaceTotalSize", strM1524g).commit();
            sharedPreferencesM1382b.edit().putString("cloudSpaceAvailableSize", strM1524g3).commit();
            sharedPreferencesM1382b.edit().putLong("cloudSpaceAvailableSizeValue", j10).commit();
            sharedPreferencesM1382b.edit().putString("cloudSpaceUsedSize", strM1524g2).commit();
            messageObtain.setData(bundle);
            TotalStorageInfo totalStorageInfo = new TotalStorageInfo();
            totalStorageInfo.setUsedSize(jM1688f);
            totalStorageInfo.setTotalSize(jM1688f2);
            totalStorageInfo.setAvailableSize(j10);
            C13368e.m80184F().m80214E0(totalStorageInfo);
        } catch (C9721b e10) {
            C11839m.m70687e("GetCloudSpaceTask", "get cloud space error" + e10.getMessage());
        } catch (JSONException unused) {
            C11839m.m70687e("GetCloudSpaceTask", "get cloud space parse response error");
        }
        Handler handler = this.f13409a;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }
}
