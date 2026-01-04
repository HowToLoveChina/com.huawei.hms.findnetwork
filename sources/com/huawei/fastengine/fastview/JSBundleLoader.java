package com.huawei.fastengine.fastview;

/* loaded from: classes5.dex */
public abstract class JSBundleLoader {
    protected String mUri;

    public JSBundleLoader(String str) {
        this.mUri = str;
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }

    public abstract String getScript(WidgetInfo widgetInfo);

    public String getUri() {
        return this.mUri;
    }

    public abstract WidgetInfo loadWidget();
}
