package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.downloadapp.p083ui.uiextend.FrontAppDownloadButtonStyle;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$dimen;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.PPSNativeView;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import hu.C10342a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0226l0;
import p015ak.C0227m;
import p258ei.C9494c;
import p491nd.C11666d;
import p514o9.C11839m;
import p616rk.C12515a;
import p676ud.C13164k;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class V5FrontAppLayout extends RelativeLayout {
    private static final String TAG = "V5FrontAppLayout";
    private static final String V5_DIVIDER = "|";
    private static final String V5_FRONT_APP_ICON_PATH = "/frontappicon/";
    private static final String V5_SPLIT = " | ";
    public static final long V5_TIP_SHOW_TIME = 3000;
    private TextView v5ClickableZone;
    private WeakReference<Context> v5ContextWRef;
    private TextView v5Developer;
    private AppDownloadButton v5DownloadButton;
    private ImageView v5Icon;
    private TextView v5Name;
    private PPSNativeView v5NativeView;
    private TextView v5PrizeText;
    private StatusChangeListener v5StatusChangeListener;
    private C13164k v5TipBubbleView;
    private UserCancelListener v5UserCancelListener;
    private final DownloadBtnListener v5listener;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.V5FrontAppLayout$1 */
    public class C41311 extends ClickableSpan {
        final /* synthetic */ Consumer val$consumer;

        public C41311(Consumer consumer) {
            consumer = consumer;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            consumer.accept(view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    public class DownloadBtnListener implements AppDownloadButton.OnDownloadStatusChangedListener {
        private AppStatus mAppStatus;

        private DownloadBtnListener() {
        }

        public AppStatus getAppStatus() {
            return this.mAppStatus;
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onStatusChanged(AppStatus appStatus) {
            C11839m.m70686d(V5FrontAppLayout.TAG, "onStatusChanged: " + appStatus);
            if (V5FrontAppLayout.this.v5StatusChangeListener != null) {
                V5FrontAppLayout.this.v5StatusChangeListener.onStatusChanged(appStatus);
            }
            this.mAppStatus = appStatus;
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onUserCancel(AppInfo appInfo) {
            C11839m.m70686d(V5FrontAppLayout.TAG, "onUserCancel: " + appInfo);
            if (V5FrontAppLayout.this.v5UserCancelListener != null) {
                V5FrontAppLayout.this.v5UserCancelListener.onUserCancel(appInfo);
            }
        }

        public /* synthetic */ DownloadBtnListener(V5FrontAppLayout v5FrontAppLayout, C41311 c41311) {
            this();
        }
    }

    public static class SpanClickObj {
        private ClickableSpan clickableSpan;
        private int[] position;

        public SpanClickObj(ClickableSpan clickableSpan, int[] iArr) {
            this.clickableSpan = clickableSpan;
            this.position = iArr;
        }

        public ClickableSpan getClickableSpan() {
            return this.clickableSpan;
        }

        public int[] getPosition() {
            return this.position;
        }

        public void setClickableSpan(ClickableSpan clickableSpan) {
            this.clickableSpan = clickableSpan;
        }

        public void setPosition(int[] iArr) {
            this.position = iArr;
        }
    }

    @FunctionalInterface
    public interface StatusChangeListener {
        void onStatusChanged(AppStatus appStatus);
    }

    @FunctionalInterface
    public interface UserCancelListener {
        void onUserCancel(AppInfo appInfo);
    }

    public V5FrontAppLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v5listener = new DownloadBtnListener();
        initView(context);
        this.v5ContextWRef = new WeakReference<>(context);
    }

    private void createAppDownloadWrapper() {
        this.v5DownloadButton.setAppDownloadButtonStyle(new FrontAppDownloadButtonStyle(C0213f.m1377a()));
        this.v5DownloadButton.setOnDownloadStatusChangedListener(this.v5listener);
        this.v5DownloadButton.refreshStatus();
    }

    public void dismissTipView() {
        C13164k c13164k = this.v5TipBubbleView;
        if (c13164k == null || !c13164k.m79161l()) {
            return;
        }
        C11839m.m70686d(TAG, "tipView showing, dismiss");
        this.v5TipBubbleView.m79155f();
        this.v5TipBubbleView = null;
    }

    private ClickableSpan getClickableSpan(Consumer<View> consumer) {
        return new ClickableSpan() { // from class: com.huawei.android.hicloud.ui.uiextend.V5FrontAppLayout.1
            final /* synthetic */ Consumer val$consumer;

            public C41311(Consumer consumer2) {
                consumer = consumer2;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                consumer.accept(view);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
    }

    private int[] getPosition(StringBuilder sb2, String str) {
        int length = sb2.length();
        sb2.append(V5_SPLIT);
        sb2.append(str);
        return new int[]{length, sb2.length()};
    }

    private static String getV5FrontAppIconPath() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return "";
        }
        return contextM1377a.getFilesDir() + V5_FRONT_APP_ICON_PATH;
    }

    private void initClickableZone(INativeAd iNativeAd, final AppInfo appInfo) {
        String strM1303s = C0209d.m1303s(C0213f.m1377a().getString(R$string.version_number), appInfo.getVersionName());
        String string = C0213f.m1377a().getString(R$string.introduce);
        String string2 = C0213f.m1377a().getString(R$string.privacy);
        String string3 = C0213f.m1377a().getString(R$string.permission);
        StringBuilder sb2 = new StringBuilder(strM1303s);
        ArrayList arrayList = new ArrayList();
        final String appDetailUrl = iNativeAd.getAppInfo().getAppDetailUrl();
        final String privacyLink = iNativeAd.getAppInfo().getPrivacyLink();
        final String permissionUrl = iNativeAd.getAppInfo().getPermissionUrl();
        if (!TextUtils.isEmpty(appDetailUrl)) {
            arrayList.add(new SpanClickObj(getClickableSpan(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.c0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f19191a.lambda$initClickableZone$2(appDetailUrl, appInfo, (View) obj);
                }
            }), getPosition(sb2, string)));
        }
        if (!TextUtils.isEmpty(privacyLink)) {
            arrayList.add(new SpanClickObj(getClickableSpan(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.d0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f19200a.lambda$initClickableZone$3(privacyLink, appInfo, (View) obj);
                }
            }), getPosition(sb2, string2)));
        }
        if (!TextUtils.isEmpty(permissionUrl)) {
            arrayList.add(new SpanClickObj(getClickableSpan(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.e0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f19261a.lambda$initClickableZone$4(permissionUrl, appInfo, (View) obj);
                }
            }), getPosition(sb2, string3)));
        }
        SpannableString spannableString = new SpannableString(sb2.toString());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            SpanClickObj spanClickObj = (SpanClickObj) arrayList.get(i10);
            spannableString.setSpan(spanClickObj.getClickableSpan(), spanClickObj.getPosition()[0], spanClickObj.getPosition()[1], 33);
        }
        this.v5ClickableZone.setText(spannableString);
        this.v5ClickableZone.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initView(Context context) {
        View.inflate(context, R$layout.v5_front_app_layout, this);
        this.v5NativeView = (PPSNativeView) C12809f.m76831d(this, R$id.v5_pps_app_root_layout);
        this.v5DownloadButton = (AppDownloadButton) C12809f.m76831d(this, R$id.v5_pps_app_download_btn);
        this.v5Name = (TextView) C12809f.m76831d(this, R$id.v5_pps_app_name);
        this.v5Developer = (TextView) C12809f.m76831d(this, R$id.v5_pps_app_developer);
        this.v5Icon = (ImageView) C12809f.m76831d(this, R$id.v5_pps_app_icon);
        this.v5PrizeText = (TextView) C12809f.m76831d(this, R$id.v5_prize_text);
        createAppDownloadWrapper();
        this.v5ClickableZone = (TextView) C12809f.m76831d(this, R$id.v5_pps_app_clickable_zone);
    }

    public static void jumpToStaticWebView(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setAction(NotifyConstants.Action.HICLOUD_PURE_PAGE_WEBVIEW_ACTION);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        if (!(context instanceof Activity)) {
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        intent.putExtra("url", str2);
        intent.putExtra("title", str);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("return_page_name", BackupMainActivity.class.getName());
        C10342a.m63676b(context, intent);
    }

    private void jumpToStaticWebViewPage(String str, String str2) {
        Context context = this.v5ContextWRef.get();
        if (context == null) {
            return;
        }
        jumpToStaticWebView(context, str2, str);
    }

    public /* synthetic */ void lambda$init$0(INativeAd iNativeAd, View view) {
        C11839m.m70686d(TAG, "icon triggerClick");
        iNativeAd.triggerClick(this.v5ContextWRef.get(), null);
        C9494c.m59390r().m59408V(true);
        reportClick("mecloud_front_app_introduction");
    }

    public /* synthetic */ void lambda$init$1(View view) throws Resources.NotFoundException {
        Layout layout = this.v5Developer.getLayout();
        if (layout == null || layout.getEllipsisCount(0) <= 0) {
            return;
        }
        TextView textView = this.v5Developer;
        showTipPopupWindow(textView, (String) textView.getText());
    }

    public /* synthetic */ void lambda$initClickableZone$2(String str, AppInfo appInfo, View view) {
        C11839m.m70686d(TAG, "showAppDetailPage");
        jumpToStaticWebViewPage(str, appInfo.getAppName());
        C9494c.m59390r().m59408V(true);
        reportClick("mecloud_front_app_introduction");
    }

    public /* synthetic */ void lambda$initClickableZone$3(String str, AppInfo appInfo, View view) {
        C11839m.m70686d(TAG, "showPrivacyPolicy");
        jumpToStaticWebViewPage(str, appInfo.getAppName());
        reportClick("mecloud_front_app_privacy");
    }

    public /* synthetic */ void lambda$initClickableZone$4(String str, AppInfo appInfo, View view) {
        C11839m.m70686d(TAG, "showPermissionPage");
        jumpToStaticWebViewPage(str, appInfo.getAppName());
        reportClick("mecloud_front_app_permission");
    }

    public /* synthetic */ void lambda$showIcon$5(Object obj) {
        this.v5Icon.setImageBitmap((Bitmap) obj);
    }

    public /* synthetic */ void lambda$showIcon$6(final Object obj) {
        if (obj instanceof Bitmap) {
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.z
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19297a.lambda$showIcon$5(obj);
                }
            });
        }
    }

    private void reportClick(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        C13225d.m79490f1().m79591l0(str, linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", str, "4", "9", linkedHashMapM79497A);
    }

    private void showIcon(String str) {
        this.v5Icon.setImageResource(R$drawable.ic_front_app);
        String str2 = getV5FrontAppIconPath() + C0227m.m1593f(str);
        C13843a.m83085g(getV5FrontAppIconPath());
        C12515a.m75110o().m75175e(new C11666d(str, str2, (String) null, (Consumer<Object>) new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.f0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f19264a.lambda$showIcon$6(obj);
            }
        }), false);
    }

    private void showTipPopupWindow(View view, String str) throws Resources.NotFoundException {
        C11839m.m70686d(TAG, "showTipPopupWindow");
        dismissTipView();
        Context context = this.v5ContextWRef.get();
        if (context instanceof Activity) {
            C13164k c13164k = new C13164k((Activity) context);
            this.v5TipBubbleView = c13164k;
            c13164k.m79172w(view, str, 0, -context.getResources().getDimensionPixelOffset(R$dimen.cs_4_dp));
        }
        postDelayed(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f19270a.dismissTipView();
            }
        }, 3000L);
    }

    public AppStatus getAppStatus() {
        return this.v5listener.getAppStatus();
    }

    public boolean init(final INativeAd iNativeAd, String str) throws Resources.NotFoundException {
        if (iNativeAd == null) {
            C11839m.m70687e(TAG, "init ad is null");
            return false;
        }
        AppInfo appInfo = iNativeAd.getAppInfo();
        if (appInfo == null) {
            C11839m.m70687e(TAG, "init appInfo is null");
            return false;
        }
        showIcon(appInfo.getIconUrl());
        this.v5Icon.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19179a.lambda$init$0(iNativeAd, view);
            }
        });
        this.v5PrizeText.setText(str);
        this.v5Name.setText(appInfo.getAppName());
        this.v5Developer.setText(appInfo.getDeveloperName());
        this.v5Developer.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.f19183a.lambda$init$1(view);
            }
        });
        initClickableZone(iNativeAd, appInfo);
        this.v5NativeView.register(iNativeAd);
        this.v5DownloadButton.setNativeAd(iNativeAd);
        this.v5NativeView.setClickable(false);
        this.v5NativeView.register(this.v5DownloadButton);
        this.v5DownloadButton.refreshStatus();
        return true;
    }

    public void setV5StatusChangeListener(StatusChangeListener statusChangeListener) {
        this.v5StatusChangeListener = statusChangeListener;
    }

    public void setV5UserCancelListener(UserCancelListener userCancelListener) {
        this.v5UserCancelListener = userCancelListener;
    }
}
