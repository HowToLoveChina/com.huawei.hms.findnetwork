package je;

import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.constant.CommonBase;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11829c;
import p514o9.C11839m;

/* renamed from: je.r */
/* loaded from: classes3.dex */
public class C10804r {

    /* renamed from: a */
    public a f51566a = new a("CLAM_POP", null, -1);

    /* renamed from: b */
    public a f51567b = new a("SPACE_FULL", null, -1);

    /* renamed from: c */
    public a f51568c = new a("POLICY_SERVICE", null, -1);

    /* renamed from: d */
    public a f51569d = new a("GET_SPACE_OK_H5_DIALOG", null, -1);

    /* renamed from: e */
    public a f51570e = new a("PUSH_MARKETING_NOTICE", null, -1);

    /* renamed from: f */
    public a f51571f = new a("GUIDE_H5_WEBVIEW_DAILOG", null, -1);

    /* renamed from: g */
    public a f51572g = new a("GUIDE_BACKUP_SWITCH", null, -1);

    /* renamed from: h */
    public a f51573h = new a("ADD_ICON_DIALOG_ID", null, -1);

    /* renamed from: i */
    public a f51574i = new a("BACKUP_OPTION_ALERT_DIALOG_ID", null, -1);

    /* renamed from: j */
    public Handler f51575j;

    /* renamed from: je.r$a */
    public static class a {

        /* renamed from: a */
        public String f51576a;

        /* renamed from: b */
        public Dialog f51577b;

        /* renamed from: c */
        public int f51578c;

        public a(String str, Dialog dialog, int i10) {
            this.f51576a = str;
            this.f51577b = dialog;
            this.f51578c = i10;
        }

        /* renamed from: a */
        public Dialog m65766a() {
            return this.f51577b;
        }

        /* renamed from: b */
        public int m65767b() {
            return this.f51578c;
        }

        /* renamed from: c */
        public void m65768c(Dialog dialog) {
            this.f51577b = dialog;
        }

        /* renamed from: d */
        public void m65769d(int i10) {
            this.f51578c = i10;
        }
    }

    public C10804r(Handler handler) {
        this.f51575j = handler;
    }

    /* renamed from: a */
    public void m65754a(String str) {
        C11839m.m70688i("MainDialogManager", "canShowDialog start dialogId : " + str);
        if (!m65755b()) {
            C11839m.m70688i("MainDialogManager", "canShowDialog checkStatesOk = false");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!C0209d.m1245d1(C0213f.m1377a(), MainActivity.class.getName())) {
            C11839m.m70687e("MainDialogManager", "canShowDialog, MainActivity is not foreground");
            return;
        }
        List<String> listM16239a = CommonBase.m16239a();
        int iIndexOf = listM16239a.indexOf(str);
        int i10 = 0;
        for (String str2 : listM16239a) {
            if (i10 > iIndexOf) {
                C11839m.m70688i("MainDialogManager", str + "before are all not satify");
            }
            i10++;
            a aVarM65757d = m65757d(str2);
            if (aVarM65757d != null) {
                int iM65767b = aVarM65757d.m65767b();
                Dialog dialogM65766a = aVarM65757d.m65766a();
                if (iM65767b == -1) {
                    return;
                }
                if (TextUtils.equals(str2, "POLICY_SERVICE") && iM65767b == 0 && dialogM65766a == null) {
                    C11839m.m70688i("MainDialogManager", "canShowDialog dialog is HMS update");
                    return;
                }
                if ("GET_SPACE_OK_H5_DIALOG".equals(str2) && iM65767b == 0 && dialogM65766a == null) {
                    C11839m.m70688i("MainDialogManager", "canShowDialog dialog is get free space");
                    m65761h(str2);
                    return;
                }
                if ("SPACE_FULL".equals(str2) && iM65767b == 0) {
                    C11839m.m70688i("MainDialogManager", "canShowDialog dialog is space full dialog");
                    m65761h(str2);
                    return;
                }
                if (iM65767b == 0 && dialogM65766a != null) {
                    C11839m.m70688i("MainDialogManager", "canShowDialog dialog will be shown, id = " + str2);
                    m65761h(str2);
                    return;
                }
                C11839m.m70688i("MainDialogManager", "canShowDialog can not show," + str2 + " status = " + iM65767b);
            }
        }
    }

    /* renamed from: b */
    public final boolean m65755b() {
        boolean z10 = this.f51568c.m65767b() != -1;
        boolean z11 = (this.f51567b.m65767b() == -1 || this.f51567b.m65767b() == 2) ? false : true;
        boolean z12 = (this.f51566a.m65767b() == -1 || this.f51566a.m65767b() == 2) ? false : true;
        boolean z13 = this.f51570e.m65767b() != -1;
        boolean z14 = (this.f51571f.m65767b() == -1 || this.f51571f.m65767b() == 2) ? false : true;
        boolean z15 = (this.f51569d.m65767b() == -1 || this.f51571f.m65767b() == 2) ? false : true;
        boolean z16 = (this.f51572g.m65767b() == -1 || this.f51572g.m65767b() == 2) ? false : true;
        boolean z17 = (this.f51573h.m65767b() == -1 || this.f51573h.m65767b() == 2) ? false : true;
        if (!C11829c.m70528K0()) {
            C11839m.m70688i("MainDialogManager", "checkStatesOk is not support storageRegion, dialog Id = SPACE_FULL_DAILOG, status = 1");
            this.f51567b.m65769d(1);
            this.f51567b.m65768c(null);
            z11 = true;
        }
        if (z10 && z11 && z12 && z13 && z14 && z15 && z16 && z17) {
            C11839m.m70688i("MainDialogManager", "checkStatesOk dialog all ready");
            return true;
        }
        C11839m.m70688i("MainDialogManager", "checkStatesOk dialog not all ready  policyDialogPrepareOk is " + z10 + ",pushGuideDialogPrepareOk is " + z13 + ",claimSpaceDialogPrepareOk is " + z12 + ",spaceFullDialogPrepareOk is " + z11 + ",guideH5DialogPrepareOk is " + z14 + ",isGuideBackupDialogOk is " + z16 + ",getSpaceOkH5DialogOk is " + z15 + ",isAddIconDialogOk is " + z17);
        return z10 && z13 && this.f51569d.m65767b() == 0;
    }

    /* renamed from: c */
    public Dialog m65756c(String str) {
        a aVarM65757d = m65757d(str);
        if (aVarM65757d == null) {
            return null;
        }
        return aVarM65757d.m65766a();
    }

    /* renamed from: d */
    public a m65757d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
        }
        return null;
    }

    /* renamed from: e */
    public boolean m65758e() {
        a aVar = this.f51569d;
        boolean z10 = aVar != null && (aVar.m65767b() == 2 || this.f51569d.m65767b() == 6);
        a aVar2 = this.f51571f;
        return z10 || (aVar2 != null && (aVar2.m65767b() == 2 || this.f51571f.m65767b() == 6));
    }

    /* renamed from: f */
    public void m65759f(String str) {
        C11839m.m70688i("MainDialogManager", "resetDialogInfoById dialog Id = " + str);
        a aVarM65757d = m65757d(str);
        if (aVarM65757d == null) {
            return;
        }
        aVarM65757d.m65768c(null);
        aVarM65757d.m65769d(6);
    }

    /* renamed from: g */
    public final void m65760g(Message message) {
        Handler handler = this.f51575j;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    /* renamed from: h */
    public final void m65761h(String str) {
        Handler handler = this.f51575j;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.obj = str;
            messageObtainMessage.what = 4;
            m65760g(messageObtainMessage);
        }
    }

    /* renamed from: i */
    public void m65762i(String str) {
        C11839m.m70688i("MainDialogManager", "setDialogInfoAlReadyById dialog Id = " + str);
        a aVarM65757d = m65757d(str);
        if (aVarM65757d == null) {
            return;
        }
        aVarM65757d.m65768c(null);
        aVarM65757d.m65769d(2);
    }

    /* renamed from: j */
    public void m65763j(String str) {
        C11839m.m70688i("MainDialogManager", "setDialogPopDefult dialog Id = " + str);
        a aVarM65757d = m65757d(str);
        if (aVarM65757d == null) {
            return;
        }
        aVarM65757d.m65768c(null);
        aVarM65757d.m65769d(-1);
    }

    /* renamed from: k */
    public void m65764k(String str) {
        C11839m.m70688i("MainDialogManager", "setDialogPopFail dialog Id = " + str);
        a aVarM65757d = m65757d(str);
        if (aVarM65757d == null) {
            return;
        }
        aVarM65757d.m65768c(null);
        aVarM65757d.m65769d(1);
        m65754a(str);
    }

    /* renamed from: l */
    public void m65765l(String str, Dialog dialog) {
        C11839m.m70688i("MainDialogManager", "setDialogPopSuc dialog Id = " + str);
        a aVarM65757d = m65757d(str);
        if (aVarM65757d == null) {
            return;
        }
        aVarM65757d.m65768c(dialog);
        aVarM65757d.m65769d(0);
    }
}
