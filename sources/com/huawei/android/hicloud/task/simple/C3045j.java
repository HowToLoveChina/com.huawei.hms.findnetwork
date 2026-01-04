package com.huawei.android.hicloud.task.simple;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.App;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.ThinAppStatus;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import p015ak.C0241z;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p814yl.C13998b0;

/* renamed from: com.huawei.android.hicloud.task.simple.j */
/* loaded from: classes3.dex */
public class C3045j extends AbstractC12367d {

    /* renamed from: a */
    public final int f13289a;

    /* renamed from: b */
    public final String f13290b;

    /* renamed from: c */
    public final String f13291c = C11058a.m66627b("02021");

    /* renamed from: d */
    public ArrayList<String> f13292d;

    public C3045j(int i10, String str) {
        this.f13289a = i10;
        this.f13290b = str;
    }

    /* renamed from: c */
    public final ArrayList<ThinAppStatus> m18334c(List<App> list) {
        ArrayList<ThinAppStatus> arrayList = new ArrayList<>();
        for (App app : list) {
            ThinAppStatus thinAppStatus = new ThinAppStatus();
            Map<String, String> properties = app.getProperties();
            String backupAppName = app.getBackupAppName();
            long jM1688f = C0241z.m1688f(properties.get("iconsize"));
            long jM1688f2 = C0241z.m1688f(properties.get("apksize"));
            thinAppStatus.setAction(0).setType(0).setIconSize(jM1688f).setApkSize(jM1688f2).setAppDelTotalSize(jM1688f + jM1688f2).setAppName(properties.get(SnapshotBackupMeta.KEY_STRING_APP_NAME)).setBackupAppName(backupAppName);
            arrayList.add(thinAppStatus);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        int i10 = this.f13289a;
        if (i10 == 1) {
            m18337f();
        } else if (i10 == 2) {
            m18335d();
        } else {
            if (i10 != 3) {
                return;
            }
            m18336e();
        }
    }

    /* renamed from: d */
    public final void m18335d() {
        try {
            List<App> apps = new C13998b0().m84097D(this.f13290b, this.f13291c).getApps();
            Message messageObtain = Message.obtain();
            messageObtain.what = 20012;
            if (apps == null || apps.size() <= 0) {
                messageObtain.arg1 = PayStatusCodes.PAY_STATE_TIME_OUT;
            } else {
                messageObtain.arg1 = PayStatusCodes.PAY_STATE_PARAM_ERROR;
                ArrayList<ThinAppStatus> arrayListM18334c = m18334c(apps);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("thinAppList", arrayListM18334c);
                bundle.putLong("totalSize", r0.getDelSpaceSize().intValue());
                messageObtain.setData(bundle);
            }
            CBCallBack.getInstance().sendMessage(messageObtain);
        } catch (C9721b e10) {
            CBCallBack.getInstance().sendMessage(Message.obtain(null, 20013, Integer.valueOf(e10.m60659c())));
            C11839m.m70689w("CloudAppThinTask", "getAppAnalysis error = " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public final void m18336e() {
        try {
            new C13998b0().m84104I(this.f13290b, this.f13292d, this.f13291c);
            CBCallBack.getInstance().sendMessageDelayed(Message.obtain((Handler) null, 20014), 5000L);
            C11839m.m70688i("CloudAppThinTask", "postAppTransfer success");
        } catch (C9721b e10) {
            CBCallBack.getInstance().sendMessageDelayed(Message.obtain((Handler) null, 20015), 500L);
            C11839m.m70689w("CloudAppThinTask", "postAppTransfer error = " + e10.getMessage());
        }
    }

    /* renamed from: f */
    public final void m18337f() {
        try {
            new C13998b0().m84096C(this.f13290b, this.f13291c);
            CBCallBack.getInstance().sendMessageDelayed(Message.obtain((Handler) null, 20011), RippleView.SINGLE_RIPPLE_TIME);
        } catch (C9721b e10) {
            CBCallBack.getInstance().sendMessage(Message.obtain(null, 20013, Integer.valueOf(e10.m60659c())));
            C11839m.m70689w("CloudAppThinTask", "preAppAnalysis error = " + e10.getMessage());
        }
    }

    public C3045j(int i10, String str, ArrayList<String> arrayList) {
        this.f13289a = i10;
        this.f13290b = str;
        this.f13292d = arrayList;
    }
}
