package org.chromium.net;

/* loaded from: classes9.dex */
public abstract class UploadDataSink {
    public abstract void onReadError(Exception exc);

    public abstract void onReadSucceeded(boolean z10);

    public abstract void onRewindError(Exception exc);

    public abstract void onRewindSucceeded();
}
