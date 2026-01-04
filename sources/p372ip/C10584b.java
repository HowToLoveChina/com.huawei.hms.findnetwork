package p372ip;

import android.content.Context;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import fk.C9721b;
import p015ak.C0209d;
import p581qk.AbstractC12367d;

/* renamed from: ip.b */
/* loaded from: classes7.dex */
public class C10584b extends AbstractC12367d {

    /* renamed from: a */
    public Context f50934a;

    /* renamed from: b */
    public String f50935b;

    /* renamed from: c */
    public boolean f50936c;

    public C10584b(Context context, String str, boolean z10) {
        this.f50934a = context;
        this.f50935b = str;
        this.f50936c = z10;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        if ("backup_key".equals(this.f50935b)) {
            C0209d.m1151A2(this.f50934a, NotifyConstants.HICLOUD_BACKUP, this.f50936c);
            return;
        }
        C0209d.m1151A2(this.f50934a, "hicloud_sync_" + this.f50935b, this.f50936c);
    }
}
