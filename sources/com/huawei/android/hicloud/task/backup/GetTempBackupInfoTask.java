package com.huawei.android.hicloud.task.backup;

import android.text.TextUtils;
import com.huawei.android.hicloud.task.backup.GetTempBackupInfoTask;
import com.huawei.hicloud.router.data.UserBackupInfo;
import fk.C9721b;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0226l0;
import p292fn.C9733f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p709vj.C13452e;
import p815ym.AbstractC14026a;
import tl.C13036o;

/* loaded from: classes3.dex */
public class GetTempBackupInfoTask extends AbstractC12367d {

    /* renamed from: a */
    public Callback f13052a;

    public interface Callback {
        /* renamed from: a */
        void mo18021a(List<UserBackupInfo.UserDeviceInfo> list);
    }

    public GetTempBackupInfoTask(Callback callback) {
        this.f13052a = callback;
    }

    /* renamed from: e */
    public static /* synthetic */ int m18019e(UserBackupInfo.UserDeviceInfo userDeviceInfo, UserBackupInfo.UserDeviceInfo userDeviceInfo2) {
        if (userDeviceInfo2.getLastbackupTime() > userDeviceInfo.getLastbackupTime()) {
            return 1;
        }
        if (userDeviceInfo2.getLastbackupTime() < userDeviceInfo.getLastbackupTime()) {
            return -1;
        }
        if (userDeviceInfo2.getSize() > userDeviceInfo.getSize()) {
            return 1;
        }
        return userDeviceInfo2.getSize() < userDeviceInfo.getSize() ? -1 : 0;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("GetTempBackupInfoTask", "GetTempBackupInfoTask begin ");
        C13036o c13036o = new C13036o();
        final LinkedList linkedList = new LinkedList();
        List<UserBackupInfo.UserDeviceInfo> listM78572l = c13036o.m78572l();
        if (!AbstractC14026a.m84159a(listM78572l)) {
            UserBackupInfo.UserDeviceInfo userDeviceInfo = listM78572l.get(0);
            userDeviceInfo.setDevDisplayName((!userDeviceInfo.isCurrent() || C9733f.m60705z().m60720O("cloudBackupDeviceNameManagement") || C13452e.m80781L().m80887a1()) ? C11477c.m68633c(userDeviceInfo.getDevDisplayName()) : C0209d.m1174H());
            String strM68633c = C11477c.m68633c(userDeviceInfo.getDeviceName());
            if (TextUtils.isEmpty(strM68633c)) {
                strM68633c = userDeviceInfo.getDeviceName();
            }
            userDeviceInfo.setDeviceName(strM68633c);
            String strM68633c2 = C11477c.m68633c(userDeviceInfo.getDeviceID());
            if (TextUtils.isEmpty(strM68633c2)) {
                strM68633c2 = userDeviceInfo.getDeviceID();
            }
            userDeviceInfo.setDeviceID(strM68633c2);
            linkedList.add(0, userDeviceInfo);
        }
        List<UserBackupInfo.UserDeviceInfo> listM78570j = c13036o.m78570j(c13036o.m78571k() + linkedList.size());
        if (!AbstractC14026a.m84159a(listM78570j)) {
            listM78570j.sort(new Comparator() { // from class: id.f
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return GetTempBackupInfoTask.m18019e((UserBackupInfo.UserDeviceInfo) obj, (UserBackupInfo.UserDeviceInfo) obj2);
                }
            });
            for (UserBackupInfo.UserDeviceInfo userDeviceInfo2 : listM78570j) {
                String strM68633c3 = C11477c.m68633c(userDeviceInfo2.getDevDisplayName());
                if (TextUtils.isEmpty(strM68633c3)) {
                    strM68633c3 = userDeviceInfo2.getDevDisplayName();
                }
                userDeviceInfo2.setDevDisplayName(strM68633c3);
                String strM68633c4 = C11477c.m68633c(userDeviceInfo2.getDeviceName());
                if (TextUtils.isEmpty(strM68633c4)) {
                    strM68633c4 = userDeviceInfo2.getDeviceName();
                }
                userDeviceInfo2.setDeviceName(strM68633c4);
                String strM68633c5 = C11477c.m68633c(userDeviceInfo2.getDeviceID());
                if (TextUtils.isEmpty(strM68633c5)) {
                    strM68633c5 = userDeviceInfo2.getDeviceID();
                }
                userDeviceInfo2.setDeviceID(strM68633c5);
                if (!linkedList.contains(userDeviceInfo2)) {
                    linkedList.add(userDeviceInfo2);
                }
            }
            C11839m.m70688i("GetTempBackupInfoTask", "sortOtherDevicePolicy tempDeviceInfoList completed, other device size = " + linkedList.size());
        }
        C11839m.m70688i("GetTempBackupInfoTask", "GetTempBackupInfoTask end " + linkedList.size());
        if (this.f13052a != null) {
            C0226l0.m1586f(new Runnable() { // from class: id.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f50461a.m18020f(linkedList);
                }
            });
        }
    }

    /* renamed from: f */
    public final /* synthetic */ void m18020f(List list) {
        this.f13052a.mo18021a(list);
    }
}
