package p457ln;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.BackupBeforeNotice;
import java.util.Iterator;
import java.util.List;
import kn.C11074k;
import p015ak.C0207c;
import p015ak.C0209d;
import p015ak.C0213f;
import p371ik.C10527a;
import p459lp.C11327e;

/* renamed from: ln.c */
/* loaded from: classes6.dex */
public class C11318c implements InterfaceC11317b {

    /* renamed from: a */
    public String f53011a;

    /* renamed from: ln.c$a */
    public class a extends TypeToken<List<String>> {
        public a() {
        }
    }

    public C11318c(String str) {
        this.f53011a = str;
    }

    /* renamed from: a */
    public final boolean m67987a(BackupBeforeNotice backupBeforeNotice) {
        NotifyLogger.m29915i("NoticeBeforeBackupNotify", "begin to callNotifyServer");
        if (backupBeforeNotice == null) {
            NotifyLogger.m29914e("NoticeBeforeBackupNotify", "callNotifyServer error,data is null");
            return false;
        }
        return MessageCenterManager.getInstance().invokeEvent(C11074k.m66709l(backupBeforeNotice), C11327e.m68061d(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE), NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE, C11074k.m66710m(backupBeforeNotice));
    }

    /* renamed from: b */
    public final void m67988b() {
        NotifyLogger.m29915i("NoticeBeforeBackupNotify", "begin to cancel notification bar.");
        new C0207c().m1136a(308, 22, "com.huawei.android.hicloud");
    }

    @Override // p457ln.InterfaceC11317b
    public void cancelNotify() {
        NotifyLogger.m29915i("NoticeBeforeBackupNotify", "cancelNotify enter.");
        if (TextUtils.isEmpty(this.f53011a)) {
            NotifyLogger.m29916w("NoticeBeforeBackupNotify", "mNotifyData is null or empty when cancelNotify");
            m67988b();
        }
        try {
            Iterator it = ((List) new Gson().fromJson(this.f53011a, new a().getType())).iterator();
            while (it.hasNext()) {
                if ("notification_bar".equals((String) it.next())) {
                    m67988b();
                }
            }
        } catch (JsonSyntaxException e10) {
            NotifyLogger.m29914e("NoticeBeforeBackupNotify", "getSpaceFullDialogInfo err : " + e10.getMessage());
        }
    }

    @Override // p457ln.InterfaceC11317b
    public void sendNotify() {
        if (TextUtils.isEmpty(this.f53011a)) {
            NotifyLogger.m29914e("NoticeBeforeBackupNotify", "mNotifyData is null or empty.");
            return;
        }
        BackupBeforeNotice backupBeforeNotice = (BackupBeforeNotice) C10527a.m64629g(this.f53011a, BackupBeforeNotice.class);
        if (C0209d.m1309t1(C0213f.m1377a())) {
            m67987a(backupBeforeNotice);
        } else if (C0209d.m1214U0(C0213f.m1377a())) {
            NotifyLogger.m29915i("NoticeBeforeBackupNotify", "in DS Process");
            CloudSpaceNotifyUtil.getInstance().getSpaceProxy().callNotifyServerInDs(this.f53011a);
        }
    }
}
