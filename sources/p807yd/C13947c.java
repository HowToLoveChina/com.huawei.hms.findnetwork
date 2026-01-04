package p807yd;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.huawei.android.hicloud.p088ui.uiextend.HiCloudItemView;
import com.huawei.android.sync.R$id;
import com.huawei.android.sync.R$string;
import gp.C10028c;
import md.C11440c;
import p015ak.C0214f0;
import p015ak.C0241z;
import p336he.C10159j;
import p488n8.C11653a;
import p514o9.C11839m;
import sk.C12809f;

/* renamed from: yd.c */
/* loaded from: classes3.dex */
public class C13947c {

    /* renamed from: a */
    public Activity f62534a;

    /* renamed from: b */
    public HiCloudItemView f62535b;

    /* renamed from: c */
    public HiCloudItemView f62536c;

    /* renamed from: d */
    public HiCloudItemView f62537d;

    /* renamed from: e */
    public HiCloudItemView f62538e;

    /* renamed from: f */
    public SharedPreferences f62539f;

    /* renamed from: g */
    public C10028c f62540g;

    /* renamed from: h */
    public C11653a f62541h = C11653a.m69582l();

    /* renamed from: i */
    public Handler f62542i = new a();

    /* renamed from: j */
    public Messenger f62543j = new Messenger(this.f62542i);

    /* renamed from: yd.c$a */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            C13947c.this.m83781c(message);
        }
    }

    public C13947c(Activity activity) {
        this.f62534a = activity;
    }

    /* renamed from: b */
    public void m83780b() {
        this.f62534a = null;
        this.f62541h.m69599r(this.f62543j);
    }

    /* renamed from: c */
    public final boolean m83781c(Message message) throws Resources.NotFoundException {
        int i10 = message.what;
        if (i10 != 11 && i10 != 67 && i10 != 1001 && i10 != 1003 && i10 != 1202 && i10 != 99001) {
            return false;
        }
        m83784f();
        m83783e();
        return false;
    }

    /* renamed from: d */
    public void m83782d() {
        C11839m.m70688i("CloudDiskStatusController", "initData");
        Activity activity = this.f62534a;
        if (activity == null) {
            C11839m.m70687e("CloudDiskStatusController", "mActivity is null");
        } else {
            this.f62540g = C10028c.m62183d0(activity);
            this.f62539f = C0214f0.m1382b(this.f62534a.getApplicationContext(), "deviceNameSp", 0);
        }
    }

    /* renamed from: e */
    public final void m83783e() {
        C11839m.m70688i("CloudDiskStatusController", "initItemBySwitchStatus");
        Activity activity = this.f62534a;
        if (activity == null) {
            C11839m.m70687e("CloudDiskStatusController", "mActivity is null");
            return;
        }
        if (!C10028c.m62183d0(activity).m62388s("autocallloglistkey")) {
            this.f62535b.setNoSubTitle();
        }
        if (!C10028c.m62183d0(this.f62534a).m62388s("autosmslistkey")) {
            this.f62538e.setNoSubTitle();
        }
        if (!C10028c.m62183d0(this.f62534a).m62388s("autorecordingkey")) {
            this.f62536c.setNoSubTitle();
        }
        if (C10028c.m62183d0(this.f62534a).m62388s("autophonemanagerkey")) {
            return;
        }
        this.f62537d.setNoSubTitle();
    }

    /* renamed from: f */
    public final void m83784f() throws Resources.NotFoundException {
        C11839m.m70688i("CloudDiskStatusController", "initItemTipText");
        if (this.f62534a == null) {
            C11839m.m70687e("CloudDiskStatusController", "mActivity is null");
            return;
        }
        m83787i("autosmslistkey", this.f62538e, null);
        m83787i("autocallloglistkey", this.f62535b, null);
        m83787i("autorecordingkey", this.f62536c, null);
        m83787i("autophonemanagerkey", this.f62537d, null);
    }

    /* renamed from: g */
    public void m83785g() {
        C11839m.m70688i("CloudDiskStatusController", "initView");
        Activity activity = this.f62534a;
        if (activity == null) {
            C11839m.m70687e("CloudDiskStatusController", "mActivity is null");
            return;
        }
        this.f62538e = (HiCloudItemView) C12809f.m76829b(activity, R$id.message_item_view);
        this.f62535b = (HiCloudItemView) C12809f.m76829b(this.f62534a, R$id.calllog_item_view);
        this.f62536c = (HiCloudItemView) C12809f.m76829b(this.f62534a, R$id.record_item_view);
        this.f62537d = (HiCloudItemView) C12809f.m76829b(this.f62534a, R$id.interception_item_view);
    }

    /* renamed from: h */
    public void m83786h() throws Resources.NotFoundException {
        m83784f();
        m83783e();
        this.f62541h.m69597n(this.f62543j, 2);
    }

    /* renamed from: i */
    public final void m83787i(String str, HiCloudItemView hiCloudItemView, String str2) throws Resources.NotFoundException {
        C11839m.m70688i("CloudDiskStatusController", "setModuleItemSubText");
        if (this.f62534a == null) {
            C11839m.m70687e("CloudDiskStatusController", "mActivity is null");
            return;
        }
        if (this.f62539f == null) {
            C11839m.m70687e("CloudDiskStatusController", "autoBackupSp is null");
            return;
        }
        if (C11440c.m68539r(str)) {
            C11839m.m70688i("CloudDiskStatusController", "setModuleItemSubText canceling");
            hiCloudItemView.setSubTitleLoadingText(this.f62534a.getResources().getString(R$string.autobackup_canceling));
            return;
        }
        String string = this.f62539f.getString(str + "_time", "0");
        int i10 = this.f62539f.getInt(str + "_retcode", -10);
        C11839m.m70688i("CloudDiskStatusController", "setModuleItemSubText autoBackupTime=" + string + ",autoBackupRetCode=" + i10);
        if (i10 == 4 && this.f62540g.m62388s(str)) {
            hiCloudItemView.setSubTitleLoadingText(this.f62534a.getResources().getString(R$string.autobackup_btn_running_new));
            return;
        }
        if (!"0".equals(string)) {
            hiCloudItemView.setSubTitleText(C10159j.m63327c(this.f62534a, C0241z.m1688f(string)));
        } else if (str2 != null) {
            hiCloudItemView.setDefaultSubTitle(str2);
        } else {
            hiCloudItemView.setNoSubTitle();
        }
    }
}
