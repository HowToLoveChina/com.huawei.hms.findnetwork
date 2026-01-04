package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.huawei.hms.findnetwork.FindNetworkEngine;
import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;
import com.huawei.hms.findnetwork.comm.request.bean.HeartBeatBean;
import com.huawei.hms.findnetwork.comm.util.MaskUtil;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/* renamed from: com.huawei.hms.findnetwork.sdk.t */
/* loaded from: classes8.dex */
public class C5399t {

    /* renamed from: d */
    public static volatile C5399t f24852d = null;

    /* renamed from: e */
    public static final Object f24853e = new Object();

    /* renamed from: f */
    public static volatile boolean f24854f = false;

    /* renamed from: a */
    public FindNetworkEngine f24855a;

    /* renamed from: b */
    public Timer f24856b = new Timer();

    /* renamed from: c */
    public a f24857c;

    /* renamed from: com.huawei.hms.findnetwork.sdk.t$a */
    public static class a extends TimerTask {

        /* renamed from: a */
        public FindNetworkEngine f24858a;

        /* renamed from: b */
        public String f24859b = UUID.randomUUID().toString();

        /* renamed from: c */
        public HeartBeatBean f24860c;

        public a(FindNetworkEngine findNetworkEngine) {
            this.f24858a = findNetworkEngine;
        }

        /* renamed from: a */
        public void m32107a(String str, int i10) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "addTask, the sn is empty";
            } else {
                if (this.f24860c == null) {
                    this.f24860c = new HeartBeatBean(str, new ArrayList());
                }
                if (!str.equals(this.f24860c.getSn())) {
                    HmsFindSDKLog.m32127i("HeartbeatSender", "sn not equals, sn: " + MaskUtil.maskSn(str) + ", getSn(): " + MaskUtil.maskSn(this.f24860c.getSn()));
                    m32108a(true);
                    this.f24860c.setSn(str);
                    this.f24860c.getBusinessIdList().clear();
                    this.f24860c.getBusinessIdList().add(Integer.valueOf(i10));
                    return;
                }
                if (!this.f24860c.getBusinessIdList().contains(Integer.valueOf(i10))) {
                    this.f24860c.getBusinessIdList().add(Integer.valueOf(i10));
                    HmsFindSDKLog.m32127i("HeartbeatSender", "add task heartBeat is success" + MaskUtil.maskSn(C5399t.m32102b(str, i10)));
                    return;
                }
                str2 = "the task heartBeat is already in task" + MaskUtil.maskSn(C5399t.m32102b(str, i10));
            }
            HmsFindSDKLog.m32127i("HeartbeatSender", str2);
        }

        /* renamed from: b */
        public void m32110b() {
            cancel();
            C5399t.m32101a(false);
            this.f24860c = null;
            HmsFindSDKLog.m32127i("HeartbeatSender", "stopTask is success");
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.f24858a == null) {
                HmsFindSDKLog.m32127i("HeartbeatSender", "FindNetworkEngine is null");
                return;
            }
            HeartBeatBean heartBeatBean = this.f24860c;
            if (heartBeatBean != null && !TextUtils.isEmpty(heartBeatBean.getSn()) && this.f24860c.getBusinessIdList() != null && this.f24860c.getBusinessIdList().size() != 0) {
                m32108a(false);
                return;
            }
            HmsFindSDKLog.m32127i("HeartbeatSender", "not heartBeat Task is null, cancel timer");
            cancel();
            C5399t.m32101a(false);
        }

        /* renamed from: a */
        public final void m32108a(boolean z10) {
            try {
                FindNetworkEngine findNetworkEngine = this.f24858a;
                if (findNetworkEngine == null) {
                    HmsFindSDKLog.m32127i("HeartbeatSender", "engine is null");
                } else {
                    findNetworkEngine.sendHeartBeat(this.f24860c.getSn(), this.f24859b, m32109a(), z10, "");
                }
            } catch (FindNetworkException e10) {
                HmsFindSDKLog.m32126e("HeartbeatSender", "sendHeartBeat error " + e10.getMessage());
            }
        }

        /* renamed from: b */
        public void m32111b(String str, int i10) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "removeTask: the sn is empty";
            } else {
                HeartBeatBean heartBeatBean = this.f24860c;
                if (heartBeatBean != null && heartBeatBean.getBusinessIdList() != null) {
                    Iterator<Integer> it = this.f24860c.getBusinessIdList().iterator();
                    while (it.hasNext()) {
                        if (it.next().intValue() == i10) {
                            it.remove();
                            try {
                                FindNetworkEngine findNetworkEngine = this.f24858a;
                                if (findNetworkEngine != null) {
                                    findNetworkEngine.sendHeartBeat(str, i10, true);
                                }
                            } catch (FindNetworkException e10) {
                                HmsFindSDKLog.m32126e("HeartbeatSender", "removeTask: " + e10.getMessage());
                            }
                            HmsFindSDKLog.m32127i("HeartbeatSender", "removeTask: " + MaskUtil.maskSn(C5399t.m32102b(str, i10)));
                            return;
                        }
                    }
                    return;
                }
                str2 = "removeTask: taskCashBean is null or taskList is null";
            }
            HmsFindSDKLog.m32127i("HeartbeatSender", str2);
        }

        /* renamed from: a */
        public final int[] m32109a() {
            if (this.f24860c.getBusinessIdList() == null || this.f24860c.getBusinessIdList().size() == 0) {
                return new int[0];
            }
            int[] iArr = new int[this.f24860c.getBusinessIdList().size()];
            for (int i10 = 0; i10 < this.f24860c.getBusinessIdList().size(); i10++) {
                iArr[i10] = this.f24860c.getBusinessIdList().get(i10).intValue();
            }
            return iArr;
        }
    }

    /* renamed from: a */
    public static C5399t m32099a() {
        if (f24852d == null) {
            synchronized (C5399t.class) {
                try {
                    if (f24852d == null) {
                        f24852d = new C5399t();
                    }
                } finally {
                }
            }
        }
        return f24852d;
    }

    /* renamed from: b */
    public static String m32102b(String str, int i10) {
        return str + "_" + i10;
    }

    /* renamed from: c */
    public void m32105c(String str, int i10) {
        HmsFindSDKLog.m32127i("HeartbeatSender", "call startHeartbeatSender");
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("HeartbeatSender", "Sn is empty.");
            return;
        }
        synchronized (f24853e) {
            try {
                if (f24854f) {
                    a aVar = this.f24857c;
                    if (aVar == null) {
                        HmsFindSDKLog.m32126e("HeartbeatSender", "heartBeatTask is null");
                        return;
                    }
                    aVar.m32107a(str, i10);
                } else {
                    this.f24857c = null;
                    this.f24857c = new a(this.f24855a);
                    HmsFindSDKLog.m32127i("HeartbeatSender", "start schedule heartBeatTask");
                    this.f24857c.m32107a(str, i10);
                    this.f24856b.schedule(this.f24857c, 0L, 5000L);
                    m32101a(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public void m32106d(String str, int i10) {
        HmsFindSDKLog.m32127i("HeartbeatSender", "stopHeartbeatSender");
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("HeartbeatSender", "Sn is empty.");
            return;
        }
        synchronized (f24853e) {
            try {
                HmsFindSDKLog.m32127i("HeartbeatSender", "Stop heartbeat sender for sn: " + MaskUtil.maskSn(str) + "_" + i10);
                a aVar = this.f24857c;
                if (aVar != null) {
                    aVar.m32111b(str, i10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m32104b() {
        a aVar = this.f24857c;
        if (aVar != null) {
            aVar.m32110b();
        }
    }

    /* renamed from: a */
    public void m32103a(FindNetworkEngine findNetworkEngine) {
        this.f24855a = findNetworkEngine;
    }

    /* renamed from: a */
    public static void m32101a(boolean z10) {
        f24854f = z10;
    }
}
