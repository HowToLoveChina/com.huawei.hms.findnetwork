package com.huawei.android.hicloud.task.simple;

import com.huawei.android.hicloud.cbs.bean.BasicDeviceSwitchInfo;
import com.huawei.android.hicloud.common.manager.DeviceSwitchQueryCallback;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import io.C10582a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: com.huawei.android.hicloud.task.simple.z */
/* loaded from: classes3.dex */
public class C3101z extends AbstractC12367d {

    /* renamed from: a */
    public DeviceSwitchQueryCallback f13411a;

    /* renamed from: b */
    public String f13412b;

    /* renamed from: c */
    public String f13413c;

    /* renamed from: d */
    public String f13414d;

    public C3101z(DeviceSwitchQueryCallback deviceSwitchQueryCallback) {
        this.f13411a = deviceSwitchQueryCallback;
    }

    /* renamed from: c */
    public void m18440c(String str, String str2, String str3) {
        this.f13413c = str;
        this.f13412b = str2;
        this.f13414d = str3;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        HashMap map = new HashMap();
        try {
            C10582a c10582a = new C10582a(null);
            ArrayList arrayList = new ArrayList();
            arrayList.add("backup.cloudbak");
            BasicDeviceSwitchInfo switchInfo = c10582a.m64920U(this.f13413c, Integer.parseInt(this.f13414d), arrayList).getSwitchInfo("backup.cloudbak");
            map.put("result_status", "query_success");
            m18441d(switchInfo, map);
            map.put("requestId", this.f13412b);
            map.put("deviceId", this.f13413c);
        } catch (Exception e10) {
            C11839m.m70687e("GetDeviceSwitchTask", "QueryAllDevicesTask failed, " + e10.toString());
            map.put("result_status", "query_failed");
        }
        this.f13411a.mo15609a(map);
    }

    /* renamed from: d */
    public final void m18441d(BasicDeviceSwitchInfo basicDeviceSwitchInfo, Map<String, String> map) {
        if (basicDeviceSwitchInfo == null) {
            C11839m.m70687e("GetDeviceSwitchTask", "setCloudBackupResult, mRequestId=" + this.f13412b + ", backupInfo is null");
            return;
        }
        String swStatus = basicDeviceSwitchInfo.getSwStatus();
        if (swStatus != null && swStatus.equals("AUTO")) {
            map.put("cloudbackup", JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN);
        } else if (swStatus != null && swStatus.equals("DISABLED")) {
            map.put("cloudbackup", "close");
        }
        C11839m.m70687e("GetDeviceSwitchTask", "setCloudBackupResult, mRequestId=" + this.f13412b + ", swStatus=" + swStatus);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }
}
