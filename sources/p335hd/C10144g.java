package p335hd;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.notification.manager.LocalSyncAndBackupMsgProcessor;
import com.huawei.hicloud.sync.R$string;
import fk.C9721b;
import gp.C10028c;
import java.util.Locale;
import p015ak.C0213f;
import p292fn.C9733f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p709vj.C13452e;
import tm.C13040c;

/* renamed from: hd.g */
/* loaded from: classes3.dex */
public class C10144g extends AbstractC12367d {

    /* renamed from: a */
    public String f49439a;

    public C10144g(String str) {
        this.f49439a = str;
    }

    /* renamed from: c */
    public final String m63206c() {
        Locale locale = Locale.getDefault();
        if (locale == null || locale.getLanguage() == null) {
            return "";
        }
        if ("zh".equals(locale.getLanguage())) {
            return locale.toLanguageTag();
        }
        return locale.getLanguage().toLowerCase(locale) + "-" + locale.getCountry().toLowerCase(locale);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        boolean zM60720O = C9733f.m60705z().m60720O("cloudBackupSyncAppExclusive");
        if (!zM62221H1 || !zM60720O) {
            C11839m.m70688i("NotifyBackupUpTask", "not notify, isTermAgreed = " + zM62221H1 + " , isSyncAppExclusiveSupport = " + zM60720O);
            return;
        }
        String strM78625Q = C13040c.m78609F().m78625Q();
        if (TextUtils.isEmpty(strM78625Q)) {
            C11839m.m70687e("NotifyBackupUpTask", "NotifyBackupUpTask, host is null");
            return;
        }
        String str = (strM78625Q + "/cloudbackup?lang=") + m63206c();
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("NotifyBackupUpTask", "NotifyBackupUpTask, context is null");
            return;
        }
        C11839m.m70688i("NotifyBackupUpTask", "processLocalTextMessage");
        new LocalSyncAndBackupMsgProcessor().processLocalTextMessage(this.f49439a, contextM1377a.getString(R$string.message_backup_title), contextM1377a.getString(R$string.message_backup_text), System.currentTimeMillis(), str);
        C13452e.m80781L().m80785A2(this.f49439a);
    }
}
