package p342hl;

import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.clean.BackupCleanRecordsManager;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.PushCmd;
import java.io.IOException;
import java.util.Objects;
import mk.C11476b;
import p020ap.C1007b;
import p514o9.C11839m;
import p523oi.C11903a;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12598v;
import p709vj.C13452e;
import p711vl.C13466f;
import p847zk.C14329v;
import pm.C12199z;

/* renamed from: hl.a */
/* loaded from: classes6.dex */
public class C10281a {

    /* renamed from: hl.a$a */
    public class a extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C12598v.m76041i();
        }
    }

    /* renamed from: a */
    public static void m63460a(PushCmd.Delete delete, String str, String str2) {
        String originDeviceIdSha256 = delete.getOriginDeviceIdSha256();
        if (TextUtils.isEmpty(originDeviceIdSha256)) {
            return;
        }
        if (!str.equals(str2)) {
            str = originDeviceIdSha256.equals(str2) ? originDeviceIdSha256 : "";
        }
        C11839m.m70688i("SubscribeReceiver", "handleMessage notifyAppDelete size: " + delete.getDelSpaceSize());
        C14329v.m85349e0().m85396N0(str);
        Message messageObtain = Message.obtain();
        messageObtain.what = 33039;
        messageObtain.obj = delete.getDelSpaceSize();
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    /* renamed from: b */
    public static void m63461b(PushCmd.Delete delete, String str, String str2) {
        C11839m.m70688i("SubscribeReceiver", "deleteOriginDevice.");
        String originDeviceIdSha256 = delete.getOriginDeviceIdSha256();
        if (str == null || str.isEmpty()) {
            C11839m.m70688i("SubscribeReceiver", "deleteOriginDevice sha256 is null");
            return;
        }
        if (originDeviceIdSha256.equals(str2)) {
            long jM81078f = C13466f.m81073d().m81078f("backup_key_active_time", 0L);
            C11839m.m70688i("SubscribeReceiver", "deleteOriginDevice, the local active time is:" + jM81078f + ", the serverExeTime is :" + delete.getServerExeTime());
            if (delete.getServerExeTime() != 0 && delete.getServerExeTime() < jM81078f) {
                C11839m.m70688i("SubscribeReceiver", "deleteOriginDevice, The push message delay, do nothing.");
                return;
            }
            CloudBackupService.getInstance().cloudbackupOpr(false);
            C11839m.m70688i("SubscribeReceiver", "deleteOriginDevice cloudbackupOpr");
            Message message = new Message();
            message.what = 33036;
            CBCallBack.getInstance().sendMessage(message);
        }
    }

    /* renamed from: c */
    public static void m63462c(PushCmd pushCmd) {
        C11839m.m70688i("SubscribeReceiver", "cloud backup data delete.");
        try {
            if (Objects.equals(pushCmd.getUserId(), C13452e.m80781L().m80971t0())) {
                PushCmd.Delete delete = (PushCmd.Delete) C11903a.m71435l().mo69832e(pushCmd.getBody()).m69886u(PushCmd.Delete.class);
                String deviceIdSha256 = delete.getDeviceIdSha256();
                if (deviceIdSha256 != null && !deviceIdSha256.isEmpty()) {
                    String strM68626h = C11476b.m68626h(C13452e.m80781L().m80950o());
                    if (delete.getSceneId().intValue() == 2) {
                        if (deviceIdSha256.equals(strM68626h)) {
                            C11839m.m70688i("SubscribeReceiver", "cloud backup data delete matched.");
                            BackupCleanRecordsManager.getInstance().notifyDeleteBackupRecordSucceed(delete);
                        }
                    } else if (delete.getSceneId().intValue() == 3) {
                        m63460a(delete, deviceIdSha256, strM68626h);
                    } else if (delete.getSceneId().intValue() == 1) {
                        m63461b(delete, deviceIdSha256, strM68626h);
                    }
                    if (C13452e.m80781L().m80887a1()) {
                        C12515a.m75110o().m75172d(new C12199z(1));
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("SubscribeReceiver", "cloud backup data delete error." + e10.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m63463d(java.lang.String r5) {
        /*
            oi.a r0 = p523oi.C11903a.m71435l()     // Catch: java.lang.Exception -> L34
            ni.e r5 = r0.mo69832e(r5)     // Catch: java.lang.Exception -> L34
            java.lang.Class<com.huawei.hicloud.cloudbackup.v3.server.model.PushCmd> r0 = com.huawei.hicloud.cloudbackup.p104v3.server.model.PushCmd.class
            java.lang.Object r5 = r5.m69886u(r0)     // Catch: java.lang.Exception -> L34
            com.huawei.hicloud.cloudbackup.v3.server.model.PushCmd r5 = (com.huawei.hicloud.cloudbackup.p104v3.server.model.PushCmd) r5     // Catch: java.lang.Exception -> L34
            java.lang.String r0 = r5.getCommand()     // Catch: java.lang.Exception -> L34
            int r1 = r0.hashCode()     // Catch: java.lang.Exception -> L34
            r2 = 50550(0xc576, float:7.0836E-41)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L40
            r2 = 50579(0xc593, float:7.0876E-41)
            if (r1 == r2) goto L36
            r2 = 50581(0xc595, float:7.0879E-41)
            if (r1 == r2) goto L2a
            goto L4a
        L2a:
            java.lang.String r1 = "313"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L34
            if (r0 == 0) goto L4a
            r0 = r4
            goto L4b
        L34:
            r5 = move-exception
            goto L5e
        L36:
            java.lang.String r1 = "311"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L34
            if (r0 == 0) goto L4a
            r0 = 0
            goto L4b
        L40:
            java.lang.String r1 = "303"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L34
            if (r0 == 0) goto L4a
            r0 = r3
            goto L4b
        L4a:
            r0 = -1
        L4b:
            if (r0 == 0) goto L5a
            if (r0 == r4) goto L56
            if (r0 == r3) goto L52
            goto L78
        L52:
            m63464e(r5)     // Catch: java.lang.Exception -> L34
            goto L78
        L56:
            m63462c(r5)     // Catch: java.lang.Exception -> L34
            goto L78
        L5a:
            m63465f(r5)     // Catch: java.lang.Exception -> L34
            goto L78
        L5e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "msg error."
            r0.append(r1)
            java.lang.String r5 = r5.toString()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "SubscribeReceiver"
            p514o9.C11839m.m70687e(r0, r5)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p342hl.C10281a.m63463d(java.lang.String):void");
    }

    /* renamed from: e */
    public static void m63464e(PushCmd pushCmd) {
        C11839m.m70688i("SubscribeReceiver", "cloud backup onSpaceChange.");
        try {
            C1007b.m5980s().m5982B(((PushCmd.Grade) C11903a.m71435l().mo69832e(pushCmd.getBody()).m69886u(PushCmd.Grade.class)).getGrade(), false);
            C12515a.m75110o().m75172d(new a());
        } catch (IOException e10) {
            C11839m.m70687e("SubscribeReceiver", "cloud backup data onSpaceChange error." + e10.toString());
        }
    }

    /* renamed from: f */
    public static void m63465f(PushCmd pushCmd) {
        C11839m.m70688i("SubscribeReceiver", "cloud backup option switch changed.");
        try {
            if (Objects.equals(pushCmd.getUserId(), C13452e.m80781L().m80971t0())) {
                String disableDeviceIdSha256 = ((PushCmd.SwitchChange) C11903a.m71435l().mo69832e(pushCmd.getBody()).m69886u(PushCmd.SwitchChange.class)).getDisableDeviceIdSha256();
                if (disableDeviceIdSha256 == null || disableDeviceIdSha256.isEmpty() || !disableDeviceIdSha256.equals(C11476b.m68626h(C13452e.m80781L().m80950o()))) {
                    return;
                }
                CloudBackupService.getInstance().refreshSwitchStatusAsync(true);
                C11839m.m70688i("SubscribeReceiver", "cloud backup option switch change matched.");
            }
        } catch (Exception e10) {
            C11839m.m70687e("SubscribeReceiver", "onSwitchChange body error." + e10.toString());
        }
    }
}
