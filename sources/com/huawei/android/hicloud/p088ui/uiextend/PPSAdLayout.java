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
public class PPSAdLayout extends RelativeLayout {
    private static final String DIVIDER = "|";
    private static final String FRONT_APP_ICON_PATH = "/frontappicon/";
    private static final String SPLIT = " | ";
    private static final String TAG = "PPSAdLayout";
    public static final long TIP_SHOW_TIME = 3000;
    private WeakReference<Context> contextWRef;
    private final DownloadBtnListener listener;
    private TextView mClickableZone;
    private TextView mDeveloper;
    private AppDownloadButton mDownloadButton;
    private ImageView mIcon;
    private TextView mName;
    private PPSNativeView mNativeView;
    private TextView mPrizeText;
    private StatusChangeListener statusChangeListener;
    private C13164k tipBubbleView;
    private UserCancelListener userCancelListener;

    public class DownloadBtnListener implements AppDownloadButton.OnDownloadStatusChangedListener {
        private AppStatus mAppStatus;

        private DownloadBtnListener() {
        }

        public AppStatus getAppStatus() {
            return this.mAppStatus;
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onStatusChanged(AppStatus appStatus) {
            C11839m.m70686d(PPSAdLayout.TAG, "onStatusChanged: " + appStatus);
            if (PPSAdLayout.this.statusChangeListener != null) {
                PPSAdLayout.this.statusChangeListener.onStatusChanged(appStatus);
            }
            this.mAppStatus = appStatus;
        }

        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.OnDownloadStatusChangedListener
        public void onUserCancel(AppInfo appInfo) {
            C11839m.m70686d(PPSAdLayout.TAG, "onUserCancel: " + appInfo);
            if (PPSAdLayout.this.userCancelListener != null) {
                PPSAdLayout.this.userCancelListener.onUserCancel(appInfo);
            }
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

    public PPSAdLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.listener = new DownloadBtnListener();
        initView(context);
        this.contextWRef = new WeakReference<>(context);
    }

    private void createAppDownloadWrapper() {
        this.mDownloadButton.setAppDownloadButtonStyle(new FrontAppDownloadButtonStyle(C0213f.m1377a()));
        this.mDownloadButton.setOnDownloadStatusChangedListener(this.listener);
        this.mDownloadButton.refreshStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissTipView() {
        C13164k c13164k = this.tipBubbleView;
        if (c13164k == null || !c13164k.m79161l()) {
            return;
        }
        C11839m.m70686d(TAG, "tipView showing, dismiss");
        this.tipBubbleView.m79155f();
        this.tipBubbleView = null;
    }

    private ClickableSpan getClickableSpan(final Consumer<View> consumer) {
        return new ClickableSpan() { // from class: com.huawei.android.hicloud.ui.uiextend.PPSAdLayout.1
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

    private static String getFrontAppIconPath() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return "";
        }
        return contextM1377a.getFilesDir() + FRONT_APP_ICON_PATH;
    }

    private void initClickableZone(INativeAd iNativeAd, final AppInfo appInfo) {
        String strM1303s = C0209d.m1303s(C0213f.m1377a().getString(R$string.version_number), appInfo.getVersionName());
        String string = C0213f.m1377a().getString(R$string.introduce);
        String string2 = C0213f.m1377a().getString(R$string.privacy);
        String string3 = C0213f.m1377a().getString(R$string.permission);
        StringBuilder sb2 = new StringBuilder(strM1303s);
        ArrayList arrayList = new ArrayList();
        final String appDetailUrl = iNativeAd.getAppInfo().getAppDetailUrl();
        C11839m.m70686d(TAG, "AppDetailUrl: " + appDetailUrl);
        final String privacyLink = iNativeAd.getAppInfo().getPrivacyLink();
        C11839m.m70686d(TAG, "PrivacyLink: " + privacyLink);
        final String permissionUrl = iNativeAd.getAppInfo().getPermissionUrl();
        C11839m.m70686d(TAG, "PermissionUrl: " + permissionUrl);
        if (!TextUtils.isEmpty(appDetailUrl)) {
            ClickableSpan clickableSpan = getClickableSpan(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.n
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f19276a.lambda$initClickableZone$2(appDetailUrl, appInfo, (View) obj);
                }
            });
            int length = sb2.length();
            sb2.append(SPLIT);
            sb2.append(string);
            arrayList.add(new SpanClickObj(clickableSpan, new int[]{length, sb2.length()}));
        }
        if (!TextUtils.isEmpty(privacyLink)) {
            ClickableSpan clickableSpan2 = getClickableSpan(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.o
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f19279a.lambda$initClickableZone$3(privacyLink, appInfo, (View) obj);
                }
            });
            int length2 = sb2.length();
            sb2.append(SPLIT);
            sb2.append(string2);
            arrayList.add(new SpanClickObj(clickableSpan2, new int[]{length2, sb2.length()}));
        }
        if (!TextUtils.isEmpty(permissionUrl)) {
            ClickableSpan clickableSpan3 = getClickableSpan(new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.p
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f19282a.lambda$initClickableZone$4(permissionUrl, appInfo, (View) obj);
                }
            });
            int length3 = sb2.length();
            sb2.append(SPLIT);
            sb2.append(string3);
            arrayList.add(new SpanClickObj(clickableSpan3, new int[]{length3, sb2.length()}));
        }
        SpannableString spannableString = new SpannableString(sb2.toString());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            SpanClickObj spanClickObj = (SpanClickObj) arrayList.get(i10);
            spannableString.setSpan(spanClickObj.getClickableSpan(), spanClickObj.getPosition()[0], spanClickObj.getPosition()[1], 33);
        }
        this.mClickableZone.setText(spannableString);
        this.mClickableZone.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initView(Context context) {
        View.inflate(context, R$layout.pps_nativead_view_layout, this);
        this.mNativeView = (PPSNativeView) C12809f.m76831d(this, R$id.pps_app_root_layout);
        this.mDownloadButton = (AppDownloadButton) C12809f.m76831d(this, R$id.pps_app_download_btn);
        this.mName = (TextView) C12809f.m76831d(this, R$id.pps_app_name);
        this.mDeveloper = (TextView) C12809f.m76831d(this, R$id.pps_app_developer);
        this.mIcon = (ImageView) C12809f.m76831d(this, R$id.pps_app_icon);
        this.mPrizeText = (TextView) C12809f.m76831d(this, R$id.prize_text);
        createAppDownloadWrapper();
        this.mClickableZone = (TextView) C12809f.m76831d(this, R$id.pps_app_clickable_zone);
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
        Context context = this.contextWRef.get();
        if (context == null) {
            return;
        }
        jumpToStaticWebView(context, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(INativeAd iNativeAd, View view) {
        C11839m.m70686d(TAG, "icon triggerClick");
        iNativeAd.triggerClick(this.contextWRef.get(), null);
        C9494c.m59390r().m59408V(true);
        reportClick("mecloud_front_app_introduction");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view) throws Resources.NotFoundException {
        Layout layout = this.mDeveloper.getLayout();
        if (layout == null || layout.getEllipsisCount(0) <= 0) {
            return;
        }
        TextView textView = this.mDeveloper;
        showTipPopupWindow(textView, (String) textView.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickableZone$2(String str, AppInfo appInfo, View view) {
        C11839m.m70686d(TAG, "showAppDetailPage");
        jumpToStaticWebViewPage(str, appInfo.getAppName());
        C9494c.m59390r().m59408V(true);
        reportClick("mecloud_front_app_introduction");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickableZone$3(String str, AppInfo appInfo, View view) {
        C11839m.m70686d(TAG, "showPrivacyPolicy");
        jumpToStaticWebViewPage(str, appInfo.getAppName());
        reportClick("mecloud_front_app_privacy");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClickableZone$4(String str, AppInfo appInfo, View view) {
        C11839m.m70686d(TAG, "showPermissionPage");
        jumpToStaticWebViewPage(str, appInfo.getAppName());
        reportClick("mecloud_front_app_permission");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showIcon$5(Object obj) {
        this.mIcon.setImageBitmap((Bitmap) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showIcon$6(final Object obj) {
        if (obj instanceof Bitmap) {
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19289a.lambda$showIcon$5(obj);
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
        this.mIcon.setImageResource(R$drawable.ic_front_app);
        String str2 = getFrontAppIconPath() + C0227m.m1593f(str);
        C13843a.m83085g(getFrontAppIconPath());
        C12515a.m75110o().m75175e(new C11666d(str, str2, (String) null, (Consumer<Object>) new Consumer() { // from class: com.huawei.android.hicloud.ui.uiextend.u
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f19291a.lambda$showIcon$6(obj);
            }
        }), false);
    }

    private void showTipPopupWindow(View view, String str) throws Resources.NotFoundException {
        C11839m.m70686d(TAG, "showTipPopupWindow");
        dismissTipView();
        Context context = this.contextWRef.get();
        if (context instanceof Activity) {
            C13164k c13164k = new C13164k((Activity) context);
            this.tipBubbleView = c13164k;
            c13164k.m79172w(view, str, 0, -context.getResources().getDimensionPixelOffset(R$dimen.cs_4_dp));
        }
        postDelayed(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f19285a.dismissTipView();
            }
        }, 3000L);
    }

    public AppStatus getAppStatus() {
        return this.listener.getAppStatus();
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
        this.mIcon.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19286a.lambda$init$0(iNativeAd, view);
            }
        });
        this.mPrizeText.setText(str);
        this.mName.setText(appInfo.getAppName());
        this.mDeveloper.setText(appInfo.getDeveloperName());
        this.mDeveloper.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.f19288a.lambda$init$1(view);
            }
        });
        initClickableZone(iNativeAd, appInfo);
        this.mNativeView.register(iNativeAd);
        this.mDownloadButton.setNativeAd(iNativeAd);
        this.mNativeView.setClickable(false);
        this.mNativeView.register(this.mDownloadButton);
        this.mDownloadButton.refreshStatus();
        return true;
    }

    public void setStatusChangeListener(StatusChangeListener statusChangeListener) {
        this.statusChangeListener = statusChangeListener;
    }

    public void setUserCancelListener(UserCancelListener userCancelListener) {
        this.userCancelListener = userCancelListener;
    }
}
