package p732w8;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;

/* renamed from: w8.g */
/* loaded from: classes2.dex */
public class AsyncTaskC13556g extends AsyncTaskC13557h {

    /* renamed from: g */
    public static AsyncTaskC13556g f60966g;

    public AsyncTaskC13556g(Context context, CloudStorageTaskCallback cloudStorageTaskCallback) {
        super(context, cloudStorageTaskCallback);
        this.f60968a = cloudStorageTaskCallback;
    }

    /* renamed from: h */
    public static AsyncTaskC13556g m81497h(Context context, CloudStorageTaskCallback cloudStorageTaskCallback) {
        if (f60966g == null || AsyncTask.Status.FINISHED.equals(f60966g.getStatus())) {
            f60966g = new AsyncTaskC13556g(context, cloudStorageTaskCallback);
        } else {
            AsyncTaskC13556g asyncTaskC13556g = f60966g;
            if (cloudStorageTaskCallback != asyncTaskC13556g.f60968a) {
                asyncTaskC13556g.f60968a = cloudStorageTaskCallback;
            }
        }
        return f60966g;
    }
}
