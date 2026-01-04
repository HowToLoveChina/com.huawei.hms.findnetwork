package p486n6;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.common.BuyMoreSpaceSpan;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.dialog.RetryAsyncSpan;
import com.huawei.android.p069cg.dialog.SaveBatteryAsyncSpan;
import com.huawei.android.p069cg.dialog.SaveBatteryUploadSpan;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p336he.C10159j;
import p676ud.AbstractC13158e;

/* renamed from: n6.l */
/* loaded from: classes2.dex */
public class C11647l extends AbstractC13158e {

    /* renamed from: b */
    public TextView f54032b;

    /* renamed from: c */
    public TextView f54033c;

    public C11647l(TextView textView, TextView textView2) {
        this.f54032b = textView;
        this.f54033c = textView2;
    }

    /* renamed from: w */
    public static int m69535w(int i10, int i11) {
        return C0209d.m1262h2() ? i10 : i11;
    }

    @Override // p676ud.AbstractC13155b
    /* renamed from: c */
    public boolean mo69536c(Context context) {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            return interfaceC9282a.mo58394T(context) == 1;
        }
        C1120a.m6677i("GalleryMainSdkTipHelper", "cloudAlbumRouterImpl is null");
        return false;
    }

    @Override // p676ud.AbstractC13155b
    /* renamed from: d */
    public boolean mo69537d() {
        return true;
    }

    @Override // p676ud.AbstractC13155b
    /* renamed from: f */
    public void mo69538f() {
        this.f54032b.setVisibility(8);
        this.f54033c.setVisibility(8);
    }

    @Override // p676ud.AbstractC13155b
    /* renamed from: g */
    public void mo69539g(Context context, long j10) {
        TextView textView;
        if (context == null || (textView = this.f54032b) == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "uploadStatusSuccess context or uploadTipText is null");
        } else if (j10 != 0) {
            m69552t(C10159j.m63327c(context, j10));
        } else {
            textView.setVisibility(8);
            this.f54033c.setVisibility(8);
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: h */
    public void mo69540h(Context context, int i10) {
        if (context == null || this.f54032b == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "showNoNetworkStatus context null");
        } else {
            m69552t(2 == i10 ? context.getString(R$string.sdk_item_no_network_upload_paused) : context.getString(R$string.sdk_item_no_network_sync_paused));
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: i */
    public void mo69541i(Context context) {
        if (context == null || this.f54032b == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "showSdkTipAsyncFailedStatus context null");
            return;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            C1120a.m6675d("GalleryMainSdkTipHelper", "showSdkTipAsyncFailedStatus resources null");
        } else {
            String string = context.getString(R$string.upload_failed_pause_retry);
            m69550r(context, resources.getString(R$string.sdk_tip_async_failed_pause, string), string, new RetryAsyncSpan(context));
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: j */
    public void mo69542j(Context context) {
        TextView textView = this.f54032b;
        if (textView == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "showSdkTipDefaultStatus uploadTipText null");
        } else {
            textView.setVisibility(8);
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: k */
    public void mo69543k(Context context, int i10) {
        String string;
        if (context == null || this.f54032b == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "showLowBatteryPauseStatus context null");
            return;
        }
        if (2 != i10) {
            string = context.getString(R$string.sdk_item_save_battery_update_paused);
        } else {
            if (mo69536c(context)) {
                this.f54032b.setVisibility(8);
                this.f54033c.setVisibility(8);
                return;
            }
            string = context.getString(R$string.sdk_item_save_battery_upload_paused);
        }
        m69552t(string);
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: l */
    public void mo69544l(Context context) {
        if (context == null || this.f54032b == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "showLowSpaceStatus context null");
            return;
        }
        if (mo69536c(context)) {
            this.f54032b.setVisibility(8);
            this.f54033c.setVisibility(8);
            return;
        }
        String string = context.getString(R$string.low_space_tip_buy);
        Resources resources = context.getResources();
        if (resources == null) {
            C1120a.m6675d("GalleryMainSdkTipHelper", "showLowSpaceStatus resources null");
        } else {
            m69550r(context, resources.getString(R$string.sdk_tip_no_storage_upload_paused, string), string, new BuyMoreSpaceSpan(context));
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: m */
    public void mo69545m(Context context, int i10) {
        String string;
        if (context == null || this.f54032b == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "showWlanDisconnectedStatus context null");
            return;
        }
        if (2 != i10) {
            string = context.getString(m69535w(R$string.sdk_tip_no_wlan_async_paused, R$string.sdk_tip_no_wifi_async_paused));
        } else {
            if (mo69536c(context)) {
                this.f54032b.setVisibility(8);
                this.f54033c.setVisibility(8);
                return;
            }
            string = context.getString(m69535w(R$string.sdk_tip_no_wlan_upload_paused, R$string.sdk_tip_no_wifi_upload_paused));
        }
        m69552t(string);
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: n */
    public void mo69546n(Context context, int i10) throws Resources.NotFoundException {
        String string;
        if (context == null || this.f54032b == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "showPauseTips context null");
            return;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            C1120a.m6675d("GalleryMainSdkTipHelper", "showAsyncFailedStatus resources null");
            return;
        }
        String string2 = context.getString(R$string.upload_failed_pause_retry);
        if (2 != i10) {
            string = resources.getString(R$string.sdk_tip_async_pause, string2);
        } else {
            if (mo69536c(context)) {
                this.f54032b.setVisibility(8);
                this.f54033c.setVisibility(8);
                return;
            }
            string = resources.getString(R$string.sdk_tip_upload_pause, string2);
        }
        m69550r(context, string, string2, new RetryAsyncSpan(context));
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: o */
    public void mo69547o(Context context, int i10) {
        if (2 == i10) {
            m69554v(context);
        } else {
            m69553u(context);
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: p */
    public void mo69548p(Context context) {
        if (context == null || this.f54032b == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "showSyncThumbStatus context null");
        } else if (context.getResources() == null) {
            C1120a.m6675d("GalleryMainSdkTipHelper", "showSyncThumbStatus resources null");
        } else {
            m69551s(context.getString(R$string.sdk_tip_updating));
        }
    }

    @Override // p676ud.AbstractC13158e
    /* renamed from: q */
    public void mo69549q(Context context) {
        if (context == null || this.f54032b == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "showSdkTipUploadingStatus context null");
            return;
        }
        if (mo69536c(context)) {
            this.f54032b.setVisibility(8);
            this.f54033c.setVisibility(8);
        } else if (context.getResources() == null) {
            C1120a.m6675d("GalleryMainSdkTipHelper", "showSdkTipUploadingStatus resources null");
        } else {
            m69551s(context.getString(R$string.sdk_tip_uploading));
        }
    }

    /* renamed from: r */
    public final void m69550r(Context context, String str, String str2, ClickableSpan clickableSpan) {
        int iIndexOf = str.indexOf(str2);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(clickableSpan, iIndexOf, str2.length() + iIndexOf, 33);
        this.f54032b.setVisibility(0);
        this.f54032b.setText(spannableString);
        this.f54032b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f54032b.setHighlightColor(context.getColor(R$color.transparent));
        this.f54033c.setVisibility(8);
    }

    /* renamed from: s */
    public final void m69551s(String str) {
        this.f54032b.setVisibility(0);
        this.f54032b.setText(str);
        this.f54032b.append(C0213f.m1377a().getString(R$string.general_append_handling));
    }

    /* renamed from: t */
    public final void m69552t(String str) {
        this.f54032b.setVisibility(0);
        this.f54032b.setText(str);
        this.f54033c.setVisibility(8);
    }

    /* renamed from: u */
    public void m69553u(Context context) {
        if (context == null || this.f54032b == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "showSaveBatteryAsyncPauseStatus context null");
            return;
        }
        String string = context.getString(R$string.save_bettary_tip_continue);
        Resources resources = context.getResources();
        if (resources == null) {
            C1120a.m6675d("GalleryMainSdkTipHelper", "showSaveBatteryAsyncPauseStatus resources null");
        } else {
            m69550r(context, resources.getString(R$string.sdk_tip_save_battery_async_paused, string), string, new SaveBatteryAsyncSpan(context));
        }
    }

    /* renamed from: v */
    public void m69554v(Context context) {
        if (context == null || this.f54032b == null) {
            C1120a.m6676e("GalleryMainSdkTipHelper", "showSaveBatteryUploadPauseStatus context null");
            return;
        }
        if (mo69536c(context)) {
            this.f54032b.setVisibility(8);
            this.f54033c.setVisibility(8);
            return;
        }
        String string = context.getString(R$string.save_bettary_tip_continue);
        Resources resources = context.getResources();
        if (resources == null) {
            C1120a.m6675d("GalleryMainSdkTipHelper", "showSaveBatteryUploadPauseStatus resources null");
        } else {
            m69550r(context, resources.getString(R$string.sdk_tip_save_battery_upload_paused, string), string, new SaveBatteryUploadSpan(context));
        }
    }
}
