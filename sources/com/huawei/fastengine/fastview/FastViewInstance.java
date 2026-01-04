package com.huawei.fastengine.fastview;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.widget.FrameLayout;
import com.huawei.fastengine.internal.fastview.FastViewInstanceImpl;
import com.huawei.fastsdk.IQuickCardListener;
import com.huawei.fastsdk.IUiConfiguration;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class FastViewInstance {

    public static class FastViewInstanceBuilder {
        private String accessType;
        private ICardMessage iCardMessage;
        private Context mContext;
        private FastViewInstanceGroup mGroup;
        private JSBundleLoader mJSBundleLoader;
        private RenderListener mRenderListener;
        private int mWidth;
        private IQuickCardListener quickCardListener;
        private boolean patchRes = true;
        private boolean destroySync = true;

        public FastViewInstance build() {
            Log.i("FastSDKEngine", "FastViewInstance build");
            FastviewInstanceInfo fastviewInstanceInfo = new FastviewInstanceInfo();
            fastviewInstanceInfo.setAccessType(this.accessType);
            fastviewInstanceInfo.setiCardMessage(this.iCardMessage);
            fastviewInstanceInfo.setmJSBundleLoader(this.mJSBundleLoader);
            fastviewInstanceInfo.setmRenderListener(this.mRenderListener);
            fastviewInstanceInfo.setmWidth(this.mWidth);
            fastviewInstanceInfo.setPatchRes(this.patchRes);
            fastviewInstanceInfo.setQuickCardListener(this.quickCardListener);
            fastviewInstanceInfo.setDestroySync(this.destroySync);
            FastViewInstanceImpl fastViewInstanceImpl = new FastViewInstanceImpl(this.mContext, fastviewInstanceInfo);
            FastViewInstanceGroup fastViewInstanceGroup = this.mGroup;
            if (fastViewInstanceGroup != null) {
                fastViewInstanceGroup.add(fastViewInstanceImpl);
            }
            return fastViewInstanceImpl;
        }

        public FastViewInstanceBuilder registerCardMessage(ICardMessage iCardMessage) {
            this.iCardMessage = iCardMessage;
            return this;
        }

        public FastViewInstanceBuilder registerQuickCardListener(IQuickCardListener iQuickCardListener) {
            this.quickCardListener = iQuickCardListener;
            return this;
        }

        public FastViewInstanceBuilder setAccessType(String str) {
            this.accessType = str;
            return this;
        }

        public FastViewInstanceBuilder setContext(Context context) {
            this.mContext = context;
            return this;
        }

        public FastViewInstanceBuilder setDestroySync(boolean z10) {
            this.destroySync = z10;
            return this;
        }

        public FastViewInstanceBuilder setGroup(FastViewInstanceGroup fastViewInstanceGroup) {
            this.mGroup = fastViewInstanceGroup;
            return this;
        }

        public FastViewInstanceBuilder setJSBundleLoader(JSBundleLoader jSBundleLoader) {
            this.mJSBundleLoader = jSBundleLoader;
            return this;
        }

        public FastViewInstanceBuilder setPatchRes(boolean z10) {
            this.patchRes = z10;
            return this;
        }

        public FastViewInstanceBuilder setRenderListener(RenderListener renderListener) {
            this.mRenderListener = renderListener;
            return this;
        }

        public FastViewInstanceBuilder setViewWidth(int i10) {
            this.mWidth = i10;
            return this;
        }
    }

    public static FastViewInstanceBuilder builder() {
        return new FastViewInstanceBuilder();
    }

    public abstract void attachRootView(FrameLayout frameLayout);

    public abstract int bindData(String str);

    public abstract int bindData(Map<String, Object> map);

    public abstract void evaluateExpression(String str);

    public abstract boolean onBack();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr);

    public abstract void onResume();

    public abstract void onStart();

    public abstract void onStop();

    public abstract void registerQuickCardListener(IQuickCardListener iQuickCardListener);

    public abstract void registerUiConfiguration(IUiConfiguration iUiConfiguration);

    public abstract void render(String str);

    public abstract int renderQuickCard(String str, Map<String, Object> map);

    public abstract void sendMessageToCard(String str);
}
