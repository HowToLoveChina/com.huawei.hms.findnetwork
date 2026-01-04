package com.huawei.fastengine.fastview;

import com.huawei.fastsdk.IQuickCardListener;

/* loaded from: classes5.dex */
public class FastviewInstanceInfo {
    private String accessType;
    private ICardMessage iCardMessage;
    private JSBundleLoader mJSBundleLoader;
    private RenderListener mRenderListener;
    private int mWidth;
    private IQuickCardListener quickCardListener;
    private boolean patchRes = true;
    private boolean destroySync = true;

    public String getAccessType() {
        return this.accessType;
    }

    public IQuickCardListener getQuickCardListener() {
        return this.quickCardListener;
    }

    public ICardMessage getiCardMessage() {
        return this.iCardMessage;
    }

    public JSBundleLoader getmJSBundleLoader() {
        return this.mJSBundleLoader;
    }

    public RenderListener getmRenderListener() {
        return this.mRenderListener;
    }

    public int getmWidth() {
        return this.mWidth;
    }

    public boolean isDestroySync() {
        return this.destroySync;
    }

    public boolean isPatchRes() {
        return this.patchRes;
    }

    public void setAccessType(String str) {
        this.accessType = str;
    }

    public void setDestroySync(boolean z10) {
        this.destroySync = z10;
    }

    public void setPatchRes(boolean z10) {
        this.patchRes = z10;
    }

    public void setQuickCardListener(IQuickCardListener iQuickCardListener) {
        this.quickCardListener = iQuickCardListener;
    }

    public void setiCardMessage(ICardMessage iCardMessage) {
        this.iCardMessage = iCardMessage;
    }

    public void setmJSBundleLoader(JSBundleLoader jSBundleLoader) {
        this.mJSBundleLoader = jSBundleLoader;
    }

    public void setmRenderListener(RenderListener renderListener) {
        this.mRenderListener = renderListener;
    }

    public void setmWidth(int i10) {
        this.mWidth = i10;
    }
}
