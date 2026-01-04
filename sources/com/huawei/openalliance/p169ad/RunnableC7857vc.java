package com.huawei.openalliance.p169ad;

import android.app.Dialog;
import android.content.res.Resources;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k;

/* renamed from: com.huawei.openalliance.ad.vc */
/* loaded from: classes8.dex */
public class RunnableC7857vc implements Runnable {

    /* renamed from: a */
    private final InterfaceC8118k f36238a;

    public RunnableC7857vc(InterfaceC8118k interfaceC8118k) {
        this.f36238a = interfaceC8118k;
    }

    /* renamed from: a */
    public static boolean m48635a(Dialog dialog) {
        return dialog != null && dialog.isShowing();
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        if (m48635a(this.f36238a.getNonwifiDialog())) {
            AbstractC7185ho.m43817a("RewardViewNonWifiDlgR", "NonWifiDialog already shown.");
            return;
        }
        AbstractC7185ho.m43820b("RewardViewNonWifiDlgR", "pop up dialog");
        Resources resources = this.f36238a.getResources();
        String string = resources.getString(C6849R.string.hiad_consume_data_to_play_video_no_data_size);
        String string2 = resources.getString(C6849R.string.hiad_reward_close_dialog_continue);
        String string3 = resources.getString(C6849R.string.hiad_reward_close_dialog_close);
        InterfaceC8118k interfaceC8118k = this.f36238a;
        interfaceC8118k.setNonwifiDialog(AbstractC7846y.m48620a(interfaceC8118k.getContext(), "", string, string2, string3, new C7856vb(this.f36238a)));
        this.f36238a.getNonwifiDialog().setCancelable(false);
        this.f36238a.pauseView();
    }
}
