package com.huawei.fastengine.internal.fastview;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.fastengine.fastview.Config;
import com.huawei.fastengine.fastview.FastAppInfo;
import com.huawei.fastengine.fastview.FastSDKEngine;
import com.huawei.fastengine.fastview.FastViewInstance;
import com.huawei.fastengine.fastview.FastviewInstanceInfo;
import com.huawei.fastengine.fastview.ICardMessage;
import com.huawei.fastengine.fastview.JSBundleLoader;
import com.huawei.fastengine.fastview.QuickCardAnalytic;
import com.huawei.fastengine.fastview.RenderListener;
import com.huawei.fastengine.fastview.RouterEventReceiver;
import com.huawei.fastengine.fastview.WidgetInfo;
import com.huawei.fastengine.fastview.download.utils.CommonUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.util.FastSDKProfile;
import com.huawei.fastengine.internal.FastSdkLoader;
import com.huawei.fastsdk.IFastCardMessage;
import com.huawei.fastsdk.IFastRenderListener;
import com.huawei.fastsdk.IFastSDKInstance;
import com.huawei.fastsdk.IFastSDKProxy;
import com.huawei.fastsdk.IQuickCardListener;
import com.huawei.fastsdk.IUiConfiguration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes5.dex */
public class FastViewInstanceImpl extends FastViewInstance implements IFastRenderListener, IFastCardMessage {
    private static final int SUPPORT_VERSION_DESTROY_ASYNC = 30201000;
    private static final int SUPPORT_VERSION_EVALUATE_EXPRESSION = 30102000;
    private static final int SUPPORT_VERSION_MAP_DATA = 30101000;
    private static final String TAG = "FastSDKEngine";
    private String accessType;
    private boolean destroySync;
    private ICardMessage iCardMessage;
    private boolean isDestroyed = false;
    private FrameLayout mAttachedRootView;
    private JSBundleLoader mBundleLoader;
    private Context mContext;
    private IFastSDKInstance mInstance;
    private String mQuickCardUri;
    private RenderListener mRenderListener;
    private int mWidth;
    private boolean patchRes;
    private IQuickCardListener quickCardListener;
    private IUiConfiguration uiInfo;

    public static class CardRenderInfo {

        /* renamed from: js */
        String f21614js;
        String jsonParam;
        String uri;
        WidgetInfo widgetInfo;

        private CardRenderInfo() {
        }
    }

    public FastViewInstanceImpl(Context context, FastviewInstanceInfo fastviewInstanceInfo) {
        this.mContext = context;
        this.mBundleLoader = fastviewInstanceInfo.getmJSBundleLoader();
        this.mRenderListener = fastviewInstanceInfo.getmRenderListener();
        this.iCardMessage = fastviewInstanceInfo.getiCardMessage();
        this.mWidth = fastviewInstanceInfo.getmWidth();
        this.accessType = fastviewInstanceInfo.getAccessType();
        this.patchRes = fastviewInstanceInfo.isPatchRes();
        this.quickCardListener = fastviewInstanceInfo.getQuickCardListener();
        this.destroySync = fastviewInstanceInfo.isDestroySync();
    }

    private boolean canRenderQuickCard() {
        FastSdkLoader fastSdkLoader = FastSdkLoader.getInstance();
        if (fastSdkLoader != null) {
            return fastSdkLoader.supportQuickCard();
        }
        FastViewLogUtils.m28724e(TAG, "sdkLoader == null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getUIRender(final CardRenderInfo cardRenderInfo) {
        return new Runnable() { // from class: com.huawei.fastengine.internal.fastview.FastViewInstanceImpl.2
            @Override // java.lang.Runnable
            public void run() throws IllegalAccessException, IllegalArgumentException {
                ViewGroup viewGroup;
                ViewGroup.LayoutParams layoutParams;
                if (FastViewInstanceImpl.this.isDestroyed) {
                    FastSDKProfile.log("render cancel, destroyed.");
                    return;
                }
                FastSDKProfile.begin("createInstance:" + cardRenderInfo.widgetInfo.getName());
                FastViewInstanceImpl.this.createInstance();
                if (FastViewInstanceImpl.this.mInstance == null) {
                    FastViewLogUtils.m28724e(FastViewInstanceImpl.TAG, "mInstance == null");
                    return;
                }
                FastViewInstanceImpl.this.mInstance.setPackageInfo(FastViewInstanceImpl.this.makePackageInfo(cardRenderInfo.widgetInfo));
                FastViewInstanceImpl.this.mInstance.setTrackComponent(true);
                FastViewInstanceImpl.this.mInstance.setBundleUrl(cardRenderInfo.uri);
                HashMap map = new HashMap(2);
                map.put("cardCreate", Boolean.TRUE);
                if (FastViewInstanceImpl.this.mAttachedRootView != null && (viewGroup = (ViewGroup) CommonUtils.cast(FastViewInstanceImpl.this.mAttachedRootView.getParent(), ViewGroup.class, true)) != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
                    map.put("width", Integer.valueOf(layoutParams.width));
                }
                FastSDKProfile.end("createInstance:" + cardRenderInfo.widgetInfo.getName());
                IFastSDKInstance iFastSDKInstance = FastViewInstanceImpl.this.mInstance;
                String name = cardRenderInfo.widgetInfo.getName();
                CardRenderInfo cardRenderInfo2 = cardRenderInfo;
                iFastSDKInstance.render(name, cardRenderInfo2.f21614js, map, cardRenderInfo2.jsonParam);
            }
        };
    }

    private boolean hasScreenLocked(Context context) {
        Object systemService = context.getSystemService("keyguard");
        boolean zIsKeyguardLocked = (systemService == null || !(systemService instanceof KeyguardManager)) ? false : ((KeyguardManager) systemService).isKeyguardLocked();
        Log.e(TAG, "hasScreenLocked " + zIsKeyguardLocked);
        return zIsKeyguardLocked;
    }

    private boolean isSupport(int i10) {
        FastSdkLoader fastSdkLoader = FastSdkLoader.getInstance();
        if (fastSdkLoader != null) {
            return fastSdkLoader.getHostMode() != FastSdkLoader.HostMode.Lite || FastSDKEngine.getVersionCode(this.mContext, Config.getPackageName()) >= i10;
        }
        FastViewLogUtils.m28724e("FastViewInstanceImpl", "sdkLoader == null in supportJSONObjectDataInBindDataMethod");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle makePackageInfo(WidgetInfo widgetInfo) {
        Bundle bundle = new Bundle();
        FastAppInfo fastAppInfo = widgetInfo.getFastAppInfo();
        bundle.putString("packageName", widgetInfo.getId());
        bundle.putString("name", widgetInfo.getName());
        if (fastAppInfo != null) {
            setBundleValueIfNotEmpty(bundle, "packageName", fastAppInfo.getPackageName());
            setBundleValueIfNotEmpty(bundle, "name", fastAppInfo.getName());
            setBundleValueIfNotEmpty(bundle, "icon", fastAppInfo.getIcon());
            setBundleValueIfNotEmpty(bundle, "versionName", fastAppInfo.getVersionName());
            setBundleValueIfNotEmpty(bundle, "certificate", fastAppInfo.getCertificate());
            bundle.putInt("versionCode", fastAppInfo.getVersionCode());
            bundle.putInt("minPlatformVersion", fastAppInfo.getMinPlatformVersion());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnUIThread(Runnable runnable) {
        new Handler(this.mContext.getMainLooper()).post(runnable);
    }

    private void setBundleValueIfNotEmpty(Bundle bundle, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        bundle.putString(str, str2);
    }

    private boolean supportQuickCardService() {
        FastSdkLoader fastSdkLoader = FastSdkLoader.getInstance();
        if (fastSdkLoader != null) {
            return fastSdkLoader.isSupportQuickCardService();
        }
        FastViewLogUtils.m28724e(TAG, "sdkLoader == null");
        return false;
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void attachRootView(FrameLayout frameLayout) {
        this.mAttachedRootView = frameLayout;
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public int bindData(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!canRenderQuickCard()) {
            FastViewLogUtils.m28728w(TAG, "bindData, quick card not support.");
            QuickCardAnalytic.reportBindData(this.mContext, jCurrentTimeMillis, System.currentTimeMillis(), 9, this.mQuickCardUri);
            return 9;
        }
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance == null) {
            QuickCardAnalytic.reportBindData(this.mContext, jCurrentTimeMillis, System.currentTimeMillis(), 13, this.mQuickCardUri);
            return 13;
        }
        int iBindData = iFastSDKInstance.bindData(str);
        QuickCardAnalytic.reportBindData(this.mContext, jCurrentTimeMillis, System.currentTimeMillis(), iBindData, this.mQuickCardUri);
        return iBindData;
    }

    public void createInstance() throws IllegalAccessException, IllegalArgumentException {
        destroyInstance();
        FastViewLogUtils.m28726i(TAG, "createInstance");
        FastSdkLoader fastSdkLoader = FastSdkLoader.getInstance();
        if (fastSdkLoader == null) {
            FastViewLogUtils.m28724e(TAG, "sdkLoader == null");
            return;
        }
        IFastSDKProxy fastSDKProxy = fastSdkLoader.getFastSDKProxy();
        if (fastSDKProxy == null) {
            FastViewLogUtils.m28724e(TAG, "sdkProxy == null");
            return;
        }
        FastViewLogUtils.m28726i(TAG, "patchRes " + this.patchRes);
        if (this.patchRes) {
            fastSdkLoader.patchResources(this.mContext);
        }
        int i10 = this.mWidth;
        if (i10 > 0) {
            fastSDKProxy.setViewWidth(i10);
        }
        this.mInstance = fastSDKProxy.createFastSDKInstance(this.mContext);
        if (!TextUtils.isEmpty(this.accessType)) {
            this.mInstance.setAccessType(this.accessType);
        }
        this.mInstance.registerFastRenderListener(this);
        this.mInstance.registerFastCardMessageToHost(this);
        this.mInstance.onActivityCreate();
    }

    public void destroyInstance() {
        if (this.mInstance != null) {
            FastViewLogUtils.m28726i(TAG, "destroyInstance");
            this.mInstance.registerFastRenderListener(null);
            this.mInstance.registerFastCardMessageToHost(null);
            this.mInstance.destroy();
            this.mInstance = null;
        }
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void evaluateExpression(String str) {
        if (!canRenderQuickCard() || !isSupport(SUPPORT_VERSION_EVALUATE_EXPRESSION)) {
            FastViewLogUtils.m28728w(TAG, "evaluateExpression, quick card not support.");
            return;
        }
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance != null) {
            iFastSDKInstance.evaluateExpression(str);
        }
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public boolean onBack() {
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance != null) {
            return iFastSDKInstance.onActivityBack();
        }
        return false;
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void onConfigurationChanged(Configuration configuration) {
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance != null) {
            iFastSDKInstance.onActivityConfigurationChanged(configuration);
        }
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void onDestroy() {
        FastViewLogUtils.m28726i(TAG, "onDestroy");
        this.isDestroyed = true;
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance != null) {
            iFastSDKInstance.registerFastRenderListener(null);
            this.mInstance.registerFastCardMessageToHost(null);
            if (isSupport(SUPPORT_VERSION_DESTROY_ASYNC)) {
                this.mInstance.setActivityDestroySync(this.destroySync);
            }
            this.mInstance.onActivityDestroy();
            this.mInstance.clearResource();
        }
    }

    @Override // com.huawei.fastsdk.IFastRenderListener
    public void onException(String str, String str2) {
        FastViewLogUtils.m28724e(TAG, "onException " + str);
        RenderListener renderListener = this.mRenderListener;
        if (renderListener != null) {
            renderListener.onException(this, str, str2);
        }
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void onPause() {
        FastViewLogUtils.m28726i(TAG, "onPause");
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance != null) {
            iFastSDKInstance.onActivityPause();
        }
    }

    @Override // com.huawei.fastsdk.IFastRenderListener
    public void onRefreshSuccess(int i10, int i11) {
        RenderListener renderListener = this.mRenderListener;
        if (renderListener != null) {
            renderListener.onRefreshSuccess(this);
        }
    }

    @Override // com.huawei.fastsdk.IFastRenderListener
    public void onRenderSuccess() {
        FastViewLogUtils.m28726i(TAG, "Render| onRenderSuccess()");
        FastSDKProfile.log("onRenderSuccess");
        RenderListener renderListener = this.mRenderListener;
        if (renderListener != null) {
            renderListener.onRenderSuccess(this);
        }
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance != null) {
            iFastSDKInstance.onRequestPermissionsResult(i10, strArr, iArr);
        }
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void onResume() {
        FastViewLogUtils.m28726i(TAG, "onResume");
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance != null) {
            iFastSDKInstance.onActivityResume();
        }
    }

    @Override // com.huawei.fastsdk.IFastRenderListener
    public void onRoute(Object... objArr) throws JSONException {
        Context context;
        RouterEventReceiver routerEventReceiver;
        RenderListener renderListener;
        FastViewLogUtils.m28726i("FastViewInstanceImpl", "receive on route");
        if (objArr == null) {
            return;
        }
        Object obj = objArr[0];
        if (objArr.length > 0 && (obj instanceof String) && (renderListener = this.mRenderListener) != null) {
            renderListener.onRoute(this, (String) obj);
        }
        FastSdkLoader fastSdkLoader = FastSdkLoader.getInstance();
        if (fastSdkLoader == null) {
            FastViewLogUtils.m28724e("FastViewInstanceImpl", "sdkLoader == null");
            return;
        }
        final Object obj2 = objArr[1];
        if (fastSdkLoader.getHostMode() != FastSdkLoader.HostMode.Lite || (context = this.mContext) == null || objArr.length <= 1 || !(obj2 instanceof Intent)) {
            return;
        }
        if (hasScreenLocked(context)) {
            Context context2 = this.mContext;
            if (context2 instanceof Activity) {
                Object systemService = context2.getSystemService("keyguard");
                if (systemService == null || !(systemService instanceof KeyguardManager)) {
                    return;
                }
                ((KeyguardManager) systemService).requestDismissKeyguard((Activity) this.mContext, new KeyguardManager.KeyguardDismissCallback() { // from class: com.huawei.fastengine.internal.fastview.FastViewInstanceImpl.3
                    @Override // android.app.KeyguardManager.KeyguardDismissCallback
                    public void onDismissCancelled() {
                        super.onDismissCancelled();
                        Log.e(FastViewInstanceImpl.TAG, "requestDismissKeyguard onDismissCancelled");
                    }

                    @Override // android.app.KeyguardManager.KeyguardDismissCallback
                    public void onDismissError() {
                        super.onDismissError();
                        Log.e(FastViewInstanceImpl.TAG, "requestDismissKeyguard onDismissError");
                    }

                    @Override // android.app.KeyguardManager.KeyguardDismissCallback
                    public void onDismissSucceeded() throws JSONException {
                        super.onDismissSucceeded();
                        Log.i(FastViewInstanceImpl.TAG, "requestDismissKeyguard onDismissSucceeded");
                        new RouterEventReceiver().onReceive(FastViewInstanceImpl.this.mContext, (Intent) obj2);
                    }
                });
                return;
            }
            Log.i(TAG, "requestDismissKeyguard not support.");
            routerEventReceiver = new RouterEventReceiver();
        } else {
            routerEventReceiver = new RouterEventReceiver();
        }
        routerEventReceiver.onReceive(this.mContext, (Intent) obj2);
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void onStart() {
        FastViewLogUtils.m28726i(TAG, "onStart");
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance != null) {
            iFastSDKInstance.onActivityStart();
        }
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void onStop() {
        FastViewLogUtils.m28726i(TAG, "onStop");
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance != null) {
            iFastSDKInstance.onActivityStop();
        }
    }

    @Override // com.huawei.fastsdk.IFastRenderListener
    public void onViewCreated(View view) {
        FastViewLogUtils.m28726i(TAG, "onViewCreated");
        FrameLayout frameLayout = this.mAttachedRootView;
        if (frameLayout == null) {
            FastViewLogUtils.m28724e(TAG, "mAttachedRootView null!");
            return;
        }
        if (frameLayout.getLayoutParams() == null) {
            this.mAttachedRootView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        } else {
            this.mAttachedRootView.getLayoutParams().height = -2;
        }
        View childAt = ((ViewGroup) CommonUtils.cast(view, ViewGroup.class, false)).getChildAt(0);
        View childAt2 = ((ViewGroup) CommonUtils.cast(childAt, ViewGroup.class, false)).getChildAt(0);
        View childAt3 = ((ViewGroup) CommonUtils.cast(childAt2, ViewGroup.class, false)).getChildAt(0);
        childAt.getLayoutParams().height = -2;
        childAt2.getLayoutParams().height = -2;
        childAt3.getLayoutParams().height = -2;
        this.mAttachedRootView.removeView(view);
        this.mAttachedRootView.addView(view);
        RenderListener renderListener = this.mRenderListener;
        if (renderListener != null) {
            renderListener.onViewCreated(this, view);
        }
    }

    @Override // com.huawei.fastsdk.IFastCardMessage
    public void ondCardMessage(String str) {
        ICardMessage iCardMessage = this.iCardMessage;
        if (iCardMessage != null) {
            iCardMessage.onCardMessage(this, str);
        } else {
            FastViewLogUtils.m28722d("FastSDKInstance", "Render| iCardMessage is null");
        }
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void registerQuickCardListener(IQuickCardListener iQuickCardListener) {
        this.quickCardListener = iQuickCardListener;
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void registerUiConfiguration(IUiConfiguration iUiConfiguration) {
        this.uiInfo = iUiConfiguration;
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void render(final String str) {
        this.mBundleLoader.execute(new Runnable() { // from class: com.huawei.fastengine.internal.fastview.FastViewInstanceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                FastViewLogUtils.m28726i(FastViewInstanceImpl.TAG, "render begin");
                CardRenderInfo cardRenderInfo = new CardRenderInfo();
                FastSDKProfile.begin("loadWidget");
                cardRenderInfo.widgetInfo = FastViewInstanceImpl.this.mBundleLoader.loadWidget();
                FastSDKProfile.end("loadWidget");
                FastSDKProfile.begin("getScript");
                cardRenderInfo.f21614js = FastViewInstanceImpl.this.mBundleLoader.getScript(cardRenderInfo.widgetInfo);
                FastSDKProfile.end("getScript");
                cardRenderInfo.jsonParam = str;
                cardRenderInfo.uri = FastViewInstanceImpl.this.mBundleLoader.getUri();
                FastViewLogUtils.m28722d(FastViewInstanceImpl.TAG, "widget name:" + cardRenderInfo.widgetInfo.getName());
                if (TextUtils.isEmpty(cardRenderInfo.f21614js)) {
                    FastViewLogUtils.m28724e(FastViewInstanceImpl.TAG, "card js is null, render failed.");
                    return;
                }
                FastViewLogUtils.m28726i(FastViewInstanceImpl.TAG, "begin render on UI thread.");
                FastSDKProfile.log("beginRender");
                FastViewInstanceImpl fastViewInstanceImpl = FastViewInstanceImpl.this;
                fastViewInstanceImpl.runOnUIThread(fastViewInstanceImpl.getUIRender(cardRenderInfo));
            }
        });
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public int renderQuickCard(String str, Map<String, Object> map) throws IllegalAccessException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mQuickCardUri = str;
        if (!supportQuickCardService()) {
            FastViewLogUtils.m28728w(TAG, "quick card service not support.");
            QuickCardAnalytic.reportRenderCard(this.mContext, jCurrentTimeMillis, System.currentTimeMillis(), 9, str);
            return 9;
        }
        CardRenderInfo cardRenderInfo = new CardRenderInfo();
        WidgetInfo widgetInfo = new WidgetInfo();
        cardRenderInfo.widgetInfo = widgetInfo;
        widgetInfo.setName(str);
        if (this.isDestroyed) {
            FastSDKProfile.log("render cancel, destroyed.");
            QuickCardAnalytic.reportRenderCard(this.mContext, jCurrentTimeMillis, System.currentTimeMillis(), 10, str);
            return 10;
        }
        FastSDKProfile.begin("createInstance:" + cardRenderInfo.widgetInfo.getName());
        createInstance();
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance == null) {
            FastViewLogUtils.m28724e(TAG, "mInstance == null");
            QuickCardAnalytic.reportRenderCard(this.mContext, jCurrentTimeMillis, System.currentTimeMillis(), 11, str);
            return 11;
        }
        iFastSDKInstance.setPackageInfo(makePackageInfo(cardRenderInfo.widgetInfo));
        this.mInstance.setTrackComponent(true);
        this.mInstance.setBundleUrl(cardRenderInfo.uri);
        FastSDKProfile.end("createInstance:" + cardRenderInfo.widgetInfo.getName());
        IQuickCardListener iQuickCardListener = this.quickCardListener;
        if (iQuickCardListener != null) {
            this.mInstance.registerQuickCardListener(iQuickCardListener);
        }
        this.mInstance.registerUiConfiguration(this.uiInfo);
        int iRenderQuickCard = this.mInstance.renderQuickCard(str, map);
        QuickCardAnalytic.reportRenderCard(this.mContext, jCurrentTimeMillis, System.currentTimeMillis(), iRenderQuickCard, str);
        return iRenderQuickCard;
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public void sendMessageToCard(String str) {
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance != null) {
            iFastSDKInstance.sendMessageToCard(str);
        }
    }

    @Override // com.huawei.fastengine.fastview.FastViewInstance
    public int bindData(Map<String, Object> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!canRenderQuickCard() || !isSupport(SUPPORT_VERSION_MAP_DATA)) {
            FastViewLogUtils.m28728w(TAG, "bindData, quick card not support.");
            QuickCardAnalytic.reportBindData(this.mContext, jCurrentTimeMillis, System.currentTimeMillis(), 9, this.mQuickCardUri);
            return 9;
        }
        IFastSDKInstance iFastSDKInstance = this.mInstance;
        if (iFastSDKInstance == null) {
            QuickCardAnalytic.reportBindData(this.mContext, jCurrentTimeMillis, System.currentTimeMillis(), 13, this.mQuickCardUri);
            return 13;
        }
        int iBindData = iFastSDKInstance.bindData(map);
        QuickCardAnalytic.reportBindData(this.mContext, jCurrentTimeMillis, System.currentTimeMillis(), iBindData, this.mQuickCardUri);
        return iBindData;
    }
}
