package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.ScaleRoundRectImageView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import gp.C10028c;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p020ap.C1010e;
import p336he.C10155f;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p846zj.C14306d;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PhoneFinderView extends FrameLayout implements View.OnClickListener {
    private static final float DISABLE_ALPHA = 0.6f;
    private static final int IMAGE_ALPHA_VALUE = 92;
    private static final String TAG = "PhoneFinderView";
    private Context context;
    private ScaleRoundRectImageView defaultMapBg;
    private View inflateView;
    private C10028c mSettingMgr;
    private HwTextView phoneFinderTitle;
    private View phoneFinderTitleLayout;
    private AutoSizeButton startNowButton;
    private TextView switchOffText;
    private TextView switchOffTitle;
    private View switchOffView;
    private ImageView switchOnDeviceIcon;
    private RelativeLayout switchOnLayout;
    private ScaleRoundRectImageView switchOnMapView;
    private View switchOnView;
    private View swithOffLayout;

    public PhoneFinderView(Context context) {
        super(context);
        this.mSettingMgr = null;
        this.context = context;
    }

    private ViewStub findViewStubById(View view, int i10) {
        if (view == null) {
            return null;
        }
        View viewFindViewById = view.findViewById(i10);
        if (viewFindViewById instanceof ViewStub) {
            return (ViewStub) viewFindViewById;
        }
        return null;
    }

    private void initPhoneFinderView() {
        this.phoneFinderTitle = (HwTextView) C12809f.m76831d(this.inflateView, R$id.phone_finder_title);
        View viewM76831d = C12809f.m76831d(this.inflateView, R$id.phone_finder_title_layout);
        this.phoneFinderTitleLayout = viewM76831d;
        viewM76831d.setOnClickListener(this);
        View viewInflate = findViewStubById(this.inflateView, R$id.phone_finder_state_search).inflate();
        this.switchOnView = viewInflate;
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.phone_finder_start_search_layout);
        this.switchOnLayout = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.defaultMapBg = (ScaleRoundRectImageView) C12809f.m76831d(this.switchOnView, R$id.phonefind_map_bg);
        this.switchOnMapView = (ScaleRoundRectImageView) C12809f.m76831d(this.switchOnView, R$id.phonefind_map_view);
        this.switchOnDeviceIcon = (ImageView) C12809f.m76831d(this.switchOnView, R$id.phonefind_device_icon);
        View viewInflate2 = findViewStubById(this.inflateView, R$id.phone_finder_state_switch_off).inflate();
        this.switchOffView = viewInflate2;
        C11842p.m70796c(this.context, C12809f.m76831d(viewInflate2, R$id.rlay_swith_off_container));
        this.switchOffTitle = (TextView) C12809f.m76831d(this.switchOffView, R$id.swith_off_banner_title);
        this.switchOffText = (TextView) C12809f.m76831d(this.switchOffView, R$id.swith_off_banner_text);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76831d(this.switchOffView, R$id.swith_off_start_now);
        this.startNowButton = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        C11842p.m70796c(this.context, this.startNowButton);
        View viewM76831d2 = C12809f.m76831d(this.switchOffView, R$id.swith_off_layout);
        this.swithOffLayout = viewM76831d2;
        viewM76831d2.setOnClickListener(this);
        setSwitchOffText();
        setMaxLines();
    }

    private void initView() {
        if (C0209d.m1195O(this.context) >= 1.75f) {
            this.inflateView = View.inflate(this.context, R$layout.phone_finder_state_scale, this);
        } else {
            this.inflateView = View.inflate(this.context, R$layout.phone_finder_state, this);
        }
        initPhoneFinderView();
        if (!C0209d.m1166E1()) {
            refreshStatus(false);
            setSubUserStatus();
            return;
        }
        if (!C10155f.m63253F()) {
            setVisibility(8);
        }
        if (this.context != null) {
            C12809f.m76843p(this.switchOnView, true);
            C12809f.m76843p(this.defaultMapBg, true);
            C12809f.m76843p(this.switchOnDeviceIcon, true);
            if (C0209d.m1293p1()) {
                this.defaultMapBg.setBackground(this.context.getDrawable(R$drawable.card_view_item_bg_ink));
                this.switchOnDeviceIcon.setImageDrawable(this.context.getDrawable(R$drawable.pf_pad_ink));
            } else {
                if (C0209d.m1333z1(this.context)) {
                    this.switchOnDeviceIcon.setImageDrawable(this.context.getDrawable(C11842p.m70762R0() ? R$drawable.pf_pad_online : R$drawable.pf_phone_online));
                } else {
                    this.switchOnDeviceIcon.setImageDrawable(this.context.getDrawable(C11842p.m70762R0() ? R$drawable.pf_pad_offline : R$drawable.pf_phone_offline));
                }
                this.defaultMapBg.setImageDrawable(this.context.getDrawable(R$drawable.map_bg_new));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMaxLines$0() {
        if (this.switchOffTitle.getLineCount() == 1) {
            this.switchOffText.setMaxLines(3);
        } else {
            this.switchOffText.setSingleLine();
        }
    }

    private void reportBI(String str, LinkedHashMap<String, String> linkedHashMap) {
        C13225d.m79490f1().m79567R(str, linkedHashMap);
        UBAAnalyze.m29947H("CKC", str, linkedHashMap);
    }

    private void setEnterTimesAndDate(String str, String str2) {
        if (this.mSettingMgr == null) {
            this.mSettingMgr = C10028c.m62183d0(this.context);
        }
        int iM62252O = this.mSettingMgr.m62252O(str);
        if (iM62252O <= 2) {
            iM62252O++;
        }
        this.mSettingMgr.m62202D2(str, iM62252O);
        this.mSettingMgr.m62197C2(str2, System.currentTimeMillis());
    }

    private void setMaxLines() {
        TextView textView = this.switchOffTitle;
        if (textView == null || this.switchOffText == null) {
            return;
        }
        textView.post(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f19292a.lambda$setMaxLines$0();
            }
        });
    }

    private void setSubUserStatus() {
        setEnabled(false);
        setAlpha(0.6f);
        View view = this.phoneFinderTitleLayout;
        if (view != null) {
            view.setEnabled(false);
            this.phoneFinderTitleLayout.setAlpha(0.6f);
        }
        ScaleRoundRectImageView scaleRoundRectImageView = this.switchOnMapView;
        if (scaleRoundRectImageView != null) {
            scaleRoundRectImageView.setImageAlpha(92);
        }
        ImageView imageView = this.switchOnDeviceIcon;
        if (imageView != null) {
            imageView.setImageAlpha(92);
        }
        AutoSizeButton autoSizeButton = this.startNowButton;
        if (autoSizeButton != null) {
            autoSizeButton.setEnabled(false);
            this.startNowButton.setAlpha(0.6f);
        }
        View view2 = this.swithOffLayout;
        if (view2 != null) {
            view2.setEnabled(false);
            this.swithOffLayout.setAlpha(0.6f);
        }
        RelativeLayout relativeLayout = this.switchOnLayout;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(false);
            this.switchOnLayout.setAlpha(0.6f);
        }
    }

    private void setSwitchOffText() {
        if (this.switchOffText == null) {
            return;
        }
        if (C14306d.m85207h()) {
            this.switchOffText.setText(R$string.phonefinder_banner_switch_off_content);
        } else {
            this.switchOffText.setText(R$string.phonefinder_banner_switch_off_oversea);
        }
        if (C0209d.m1195O(this.context) >= 1.75f) {
            this.switchOffText.setVisibility(8);
        }
    }

    private void startPhoneFinderActivity(boolean z10) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this.context, "com.huawei.android.remotecontrol.ui.PhoneFinderActivity"));
        C13230i.m79525e1(intent, "1", "2");
        intent.putExtra(RemoteMessageConst.FROM, this.context.getPackageName());
        intent.putExtra("openPhoneFinder", z10);
        intent.putExtra("fromMainActivityCard", true);
        this.context.startActivity(intent);
    }

    private void startWapFindPhoneActivity() {
        Context context = this.context;
        if (context == null) {
            return;
        }
        if (!C0209d.m1333z1(context)) {
            Context context2 = this.context;
            Toast.makeText(context2, context2.getString(R$string.cloudpay_net_disconnect_alert), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this.context, "com.huawei.android.remotecontrol.ui.webview.WapFindPhoneActivity"));
        intent.putExtra(RemoteMessageConst.FROM, "fromMainActivityFindPhoneBanner");
        intent.putExtra("isFromInner", true);
        intent.putExtra("isSystemAcc", true);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("needShowLoading", true);
        intent.putExtra("isAutoLogin", true);
        intent.putExtra("isSupportPicker", true);
        ((Activity) this.context).startActivity(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        if (R$id.phone_finder_title_layout == view.getId()) {
            C11839m.m70686d(TAG, "report mecloud_main_click_findmyphone");
            startPhoneFinderActivity(false);
            reportBI("mecloud_main_click_findmyphone", linkedHashMapM79499C);
        } else if (R$id.swith_off_start_now == view.getId()) {
            C11839m.m70686d(TAG, "report mecloud_main_click_open_findmyphone");
            startPhoneFinderActivity(true);
            reportBI("mecloud_main_click_open_findmyphone", linkedHashMapM79499C);
        } else {
            if (C0209d.m1293p1()) {
                return;
            }
            boolean zM6139e = C1010e.m6125b().m6139e(this.context);
            linkedHashMapM79499C.put("isMapCard", Boolean.toString(zM6139e));
            C11839m.m70686d(TAG, "report mecloud_findmyphone_click_jump_slave isMapCard:" + zM6139e);
            startWapFindPhoneActivity();
            reportBI("mecloud_findmyphone_click_jump_slave", linkedHashMapM79499C);
        }
        setEnterTimesAndDate("EnterPhoneFinderTimes", "EnterPhoneFinderDate");
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C1010e.m6125b().m6139e(this.context)) {
            return;
        }
        setMaxLines();
    }

    public void refreshStatus(boolean z10) {
        C11839m.m70687e(TAG, "refreshStatus :" + z10);
        if (z10) {
            C12809f.m76842o(this.switchOnView, this.switchOffView);
        } else {
            C12809f.m76842o(this.switchOffView, this.switchOnView);
        }
        if (C0209d.m1166E1()) {
            return;
        }
        setSubUserStatus();
    }

    public void setMapBitmap(Bitmap bitmap) {
        C12809f.m76842o(this.switchOnMapView, this.switchOnDeviceIcon);
        ScaleRoundRectImageView scaleRoundRectImageView = this.switchOnMapView;
        if (scaleRoundRectImageView != null) {
            scaleRoundRectImageView.setImageBitmap(bitmap);
        }
    }

    public void showDefaultMap() {
        if (this.context == null) {
            return;
        }
        C12809f.m76842o(this.switchOnView, this.switchOffView);
        C12809f.m76843p(this.switchOnMapView, false);
        C12809f.m76843p(this.switchOnDeviceIcon, true);
        C12809f.m76843p(this.defaultMapBg, true);
        if (C0209d.m1293p1()) {
            this.switchOnDeviceIcon.setImageDrawable(this.context.getDrawable(R$drawable.pf_pad_ink));
            this.defaultMapBg.setBackground(this.context.getDrawable(R$drawable.card_view_item_bg_ink));
        } else {
            if (C0209d.m1333z1(this.context)) {
                this.switchOnDeviceIcon.setImageDrawable(this.context.getDrawable(C11842p.m70762R0() ? R$drawable.pf_pad_online : R$drawable.pf_phone_online));
            } else {
                this.switchOnDeviceIcon.setImageDrawable(this.context.getDrawable(C11842p.m70762R0() ? R$drawable.pf_pad_offline : R$drawable.pf_phone_offline));
            }
            this.defaultMapBg.setImageDrawable(this.context.getDrawable(R$drawable.map_bg_new));
        }
    }

    public PhoneFinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSettingMgr = null;
        this.context = context;
        initView();
    }
}
