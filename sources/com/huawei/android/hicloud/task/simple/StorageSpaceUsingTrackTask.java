package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;
import com.huawei.android.hicloud.cloudspace.bean.HDSpaceDetail;
import com.huawei.android.hicloud.cloudspace.bean.StorageInfo;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import dj.C9158a;
import gp.C10028c;
import hu.C10343b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p020ap.C1008c;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11293p;
import p514o9.C11839m;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p684un.C13222a;
import p709vj.C13452e;
import p850zo.InterfaceC14351b;

/* loaded from: classes3.dex */
public class StorageSpaceUsingTrackTask extends AbstractC12368e {

    /* renamed from: t */
    public static int f13104t;

    /* renamed from: a */
    public Context f13105a;

    /* renamed from: b */
    public UserPackage f13106b = null;

    /* renamed from: c */
    public long f13107c = -1;

    /* renamed from: d */
    public long f13108d = -1;

    /* renamed from: e */
    public long f13109e = -1;

    /* renamed from: f */
    public long f13110f = -1;

    /* renamed from: g */
    public long f13111g = -1;

    /* renamed from: h */
    public long f13112h = -1;

    /* renamed from: i */
    public long f13113i = -1;

    /* renamed from: j */
    public long f13114j = -1;

    /* renamed from: k */
    public long f13115k = 0;

    /* renamed from: l */
    public long f13116l = 0;

    /* renamed from: m */
    public long f13117m = 0;

    /* renamed from: n */
    public String f13118n = "";

    /* renamed from: o */
    public StorageInfo f13119o = null;

    /* renamed from: p */
    public boolean f13120p = false;

    /* renamed from: q */
    public InterfaceC14351b f13121q = new C3006a();

    /* renamed from: r */
    public Handler.Callback f13122r = new C3007b();

    /* renamed from: s */
    public Handler f13123s = new HandlerC3008c();

    public static class SimpleCBSpaceDetailBean {
        private String deviceId;
        private long size;

        public SimpleCBSpaceDetailBean(String str, long j10) {
            this.deviceId = str;
            this.size = j10;
        }

        public String getDeviceId() {
            return this.deviceId;
        }

        public long getSize() {
            return this.size;
        }

        public void setDeviceId(String str) {
            this.deviceId = str;
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.simple.StorageSpaceUsingTrackTask$a */
    public class C3006a implements InterfaceC14351b {
        public C3006a() {
        }

        @Override // p850zo.InterfaceC14351b
        public void onResult(Bundle bundle) {
            if (bundle == null) {
                StorageSpaceUsingTrackTask.this.f13110f = -1L;
                return;
            }
            C10343b c10343b = new C10343b(bundle);
            StorageSpaceUsingTrackTask.this.f13110f = c10343b.m63688j("cloudPicCount") + c10343b.m63688j("cloudVideoCount");
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.simple.StorageSpaceUsingTrackTask$b */
    public class C3007b implements Handler.Callback {
        public C3007b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Object obj;
            C11839m.m70686d("StorageSpaceUsingTrackTask", "mBackupServcieCallback handleMessage: " + message.what);
            int i10 = message.what;
            if (i10 == 32317) {
                Object obj2 = message.obj;
                if (obj2 == null) {
                    return false;
                }
                StorageSpaceUsingTrackTask.this.f13107c = ((Long) obj2).longValue();
            } else if (i10 == 32319) {
                StorageSpaceUsingTrackTask.this.f13119o = UserSpaceUtil.getStorageInfo();
            } else if (i10 == 32324) {
                Object obj3 = message.obj;
                if (obj3 == null) {
                    return false;
                }
                StorageSpaceUsingTrackTask.this.f13108d = ((Long) obj3).longValue();
            } else {
                if (i10 != 32337 || (obj = message.obj) == null) {
                    return false;
                }
                StorageSpaceUsingTrackTask.this.f13109e = ((Long) obj).longValue();
            }
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.simple.StorageSpaceUsingTrackTask$c */
    public class HandlerC3008c extends Handler {
        public HandlerC3008c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C11839m.m70686d("StorageSpaceUsingTrackTask", "mHandler handleMessage: " + message.what);
            if (message.what != 2001) {
                return;
            }
            StorageSpaceUsingTrackTask.this.f13106b = (UserPackage) message.obj;
        }
    }

    public StorageSpaceUsingTrackTask(Context context) {
        this.f13105a = context;
    }

    /* renamed from: r */
    public static void m18112r(Context context) {
        C11839m.m70688i("StorageSpaceUsingTrackTask", "begin report");
        StorageSpaceUsingTrackTask storageSpaceUsingTrackTask = new StorageSpaceUsingTrackTask(context);
        storageSpaceUsingTrackTask.m18125u();
        C12515a.m75110o().m75172d(storageSpaceUsingTrackTask);
    }

    /* renamed from: v */
    public static void m18113v(int i10) {
        f13104t = i10;
    }

    /* renamed from: y */
    public static void m18114y(Context context) {
        C11839m.m70688i("StorageSpaceUsingTrackTask", "begin tryReport");
        StorageSpaceUsingTrackTask storageSpaceUsingTrackTask = new StorageSpaceUsingTrackTask(context);
        if (storageSpaceUsingTrackTask.m18122q()) {
            C12515a.m75110o().m75172d(storageSpaceUsingTrackTask);
        } else {
            C11839m.m70688i("StorageSpaceUsingTrackTask", "no need report so exit");
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws JSONException {
        C11839m.m70688i("StorageSpaceUsingTrackTask", "call");
        if (!m18122q()) {
            C11839m.m70688i("StorageSpaceUsingTrackTask", "no need report");
            return;
        }
        if (!C0209d.m1254f2(this.f13105a)) {
            C11839m.m70688i("StorageSpaceUsingTrackTask", "wlan is not active.");
            return;
        }
        m18124t();
        CloudBackupService.getInstance().register(this.f13122r);
        CloudBackupService.getInstance().spaceManager();
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58432i(this.f13105a, this.f13121q);
        } else {
            C11839m.m70688i("StorageSpaceUsingTrackTask", "cloudAlbumRouterImpl is null");
        }
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        C9158a.m57503F().m57516N(this.f13123s, c11060c, false, "StorageSpaceUsingTrackTask");
        m18113v(0);
        while (!m18121p() && f13104t < 10) {
            C11839m.m70686d("StorageSpaceUsingTrackTask", "Thread sleep");
            m18113v(f13104t + 1);
            SystemClock.sleep(10000L);
        }
        if (m18121p()) {
            C11839m.m70688i("StorageSpaceUsingTrackTask", "userPackage is finished, begin get sync ino");
            m18118m();
            m18116k();
            m18119n();
            m18117l();
            m18120o();
            m18123s();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("userPackage: ");
            sb2.append(this.f13106b == null);
            sb2.append(" totalBackupSize: ");
            sb2.append(this.f13107c);
            sb2.append(" gallerySize: ");
            sb2.append(this.f13108d);
            sb2.append(" picNum: ");
            sb2.append(this.f13110f);
            sb2.append(" cloudDriveSize: ");
            sb2.append(this.f13109e);
            sb2.append(" storageInfo: ");
            sb2.append(this.f13119o == null);
            C11839m.m70689w("StorageSpaceUsingTrackTask", sb2.toString());
            C11839m.m70689w("StorageSpaceUsingTrackTask", "time out, some data is not finished");
        }
        CloudBackupService.getInstance().unregister(this.f13122r);
    }

    /* renamed from: j */
    public final long m18115j() {
        return C0212e0.m1359i(this.f13105a, "common_config", "time_stamp_storage_space_using_track_update", 0L);
    }

    /* renamed from: k */
    public final void m18116k() {
        List<CBSpaceDetail> backupDetails = this.f13119o.getBackupDetails();
        ArrayList arrayList = new ArrayList();
        for (CBSpaceDetail cBSpaceDetail : backupDetails) {
            arrayList.add(new SimpleCBSpaceDetailBean(cBSpaceDetail.getDeviceID(), cBSpaceDetail.getSize()));
        }
        this.f13118n = new Gson().toJson(arrayList);
    }

    /* renamed from: l */
    public final void m18117l() {
        this.f13111g = C1008c.m6035v().m6105w(this.f13105a, null, "StorageSpaceUsingTrackTask");
    }

    /* renamed from: m */
    public final void m18118m() {
        for (HDSpaceDetail hDSpaceDetail : this.f13119o.getDiskDetails()) {
            if ("phonemanager".equals(hDSpaceDetail.getModuleName())) {
                this.f13117m = hDSpaceDetail.getFsize();
            }
            if ("record".equals(hDSpaceDetail.getModuleName())) {
                this.f13116l = hDSpaceDetail.getFsize();
            }
            if ("notepad".equals(hDSpaceDetail.getModuleName())) {
                this.f13115k += hDSpaceDetail.getFsize();
            }
            if ("sync".equals(hDSpaceDetail.getModuleName())) {
                this.f13115k += hDSpaceDetail.getFsize();
            }
        }
    }

    /* renamed from: n */
    public final void m18119n() {
        this.f13112h = C1008c.m6035v().m6039D(this.f13105a, null);
    }

    /* renamed from: o */
    public final void m18120o() {
        if (!C10028c.m62182c0().m62315d1() && !C10028c.m62182c0().m62390s1()) {
            C11839m.m70688i("StorageSpaceUsingTrackTask", "calllog and message disabled");
        } else {
            this.f13114j = C1008c.m6035v().m6102u(this.f13105a, null);
            this.f13113i = C1008c.m6035v().m6107y(this.f13105a, null);
        }
    }

    /* renamed from: p */
    public final boolean m18121p() {
        return (this.f13106b == null || this.f13107c == -1 || this.f13108d == -1 || this.f13109e == -1 || this.f13110f == -1 || this.f13119o == null) ? false : true;
    }

    /* renamed from: q */
    public final boolean m18122q() {
        if (this.f13120p) {
            return true;
        }
        try {
            return System.currentTimeMillis() - m18115j() >= 86400000;
        } catch (IllegalStateException e10) {
            C11839m.m70687e("StorageSpaceUsingTrackTask", "getUpdateTimeStamp() error:" + e10.toString());
            return false;
        }
    }

    /* renamed from: s */
    public final void m18123s() throws JSONException {
        UserPackage userPackage;
        C11839m.m70688i("StorageSpaceUsingTrackTask", "report storge space using data to bi server");
        CloudSpace cloudSpaceM67757a = C11293p.m67757a(this.f13106b);
        if (cloudSpaceM67757a == null && (userPackage = this.f13106b) != null) {
            cloudSpaceM67757a = userPackage.getToBeEffectivePackage();
        }
        if (cloudSpaceM67757a == null) {
            C11839m.m70687e("StorageSpaceUsingTrackTask", "cloudSpace is invalid.");
            return;
        }
        long baseCapacity = cloudSpaceM67757a.getBaseCapacity();
        long totalCapacity = cloudSpaceM67757a.getTotalCapacity();
        long endTime = cloudSpaceM67757a.getEndTime();
        String id2 = cloudSpaceM67757a.getId();
        StorageInfo storageInfo = this.f13119o;
        if (storageInfo == null) {
            return;
        }
        long galleryDeleteSize = storageInfo.getGalleryDeleteSize();
        long diskUsedSize = this.f13119o.getDiskUsedSize() + this.f13119o.getBackupUsedSize() + this.f13119o.getGalleryUsedSize() + this.f13119o.getGalleryDeleteSize();
        this.f13108d += galleryDeleteSize;
        JSONObject jSONObjectM79464f = C13222a.m79464f(this.f13105a, "CLOUDBACKUP_STORAGESPACE_USING", "1", C13452e.m80781L().m80971t0(), "null");
        try {
            jSONObjectM79464f.put("package_id", id2);
            jSONObjectM79464f.put("base_cap", baseCapacity);
            jSONObjectM79464f.put("total_cap", totalCapacity);
            jSONObjectM79464f.put("end_time", endTime);
            jSONObjectM79464f.put("used", diskUsedSize);
            jSONObjectM79464f.put("used_backup", this.f13107c);
            jSONObjectM79464f.put("used_gallery", this.f13108d);
            jSONObjectM79464f.put("used_drive", this.f13109e);
            jSONObjectM79464f.put("notepad_size", this.f13115k);
            jSONObjectM79464f.put("record_size", this.f13116l);
            jSONObjectM79464f.put("phonemanage_size", this.f13117m);
            jSONObjectM79464f.put("pic_num", this.f13110f);
            jSONObjectM79464f.put("notepad_num", this.f13111g);
            jSONObjectM79464f.put("record_num", this.f13112h);
            jSONObjectM79464f.put("sms_num", this.f13113i);
            jSONObjectM79464f.put("calllog_num", this.f13114j);
            jSONObjectM79464f.put("backup_details", this.f13118n);
        } catch (JSONException e10) {
            C11839m.m70687e("StorageSpaceUsingTrackTask", "ERROR OCCUR:" + e10.getMessage());
        }
        C13222a.m79461c(this.f13105a, jSONObjectM79464f);
        UBAAnalyze.m29952M("CKC", "CLOUDBACKUP_STORAGESPACE_USING", jSONObjectM79464f);
        try {
            m18126z(System.currentTimeMillis());
        } catch (IllegalStateException e11) {
            C11839m.m70687e("StorageSpaceUsingTrackTask", "writeUpdateTimeStamp() error:" + e11.getMessage());
        }
    }

    /* renamed from: t */
    public final void m18124t() {
        this.f13106b = null;
        this.f13119o = null;
        this.f13107c = -1L;
        this.f13108d = -1L;
        this.f13109e = -1L;
    }

    /* renamed from: u */
    public void m18125u() {
        this.f13120p = true;
    }

    /* renamed from: z */
    public final void m18126z(long j10) {
        C0212e0.m1370t(this.f13105a, "common_config", "time_stamp_storage_space_using_track_update", j10);
    }
}
