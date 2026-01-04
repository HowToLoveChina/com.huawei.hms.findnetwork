package p587qq;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import p640sq.C12836o;
import p640sq.C12839r;

/* renamed from: qq.a */
/* loaded from: classes8.dex */
public class AsyncTaskC12383a extends AsyncTask<Integer, Integer, Boolean> {

    /* renamed from: a */
    public InterfaceC12384b f57204a;

    /* renamed from: b */
    public Context f57205b;

    /* renamed from: c */
    public Uri f57206c;

    public AsyncTaskC12383a(Context context, Uri uri, InterfaceC12384b interfaceC12384b) {
        this.f57205b = context;
        this.f57206c = uri;
        this.f57204a = interfaceC12384b;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Integer... numArr) throws Throwable {
        C12836o.m77097b("CompressPictureCase", "startCompressPic", true);
        if (this.f57206c == null) {
            this.f57204a.mo38147b(new Bundle());
            return Boolean.FALSE;
        }
        C12836o.m77097b("CompressPictureCase", "startCompressPic mFromUri = " + this.f57206c, false);
        Uri uriM77107e = C12839r.m77107e(this.f57205b);
        if (uriM77107e == null) {
            this.f57204a.mo38147b(new Bundle());
            return Boolean.FALSE;
        }
        C12836o.m77097b("CompressPictureCase", "startCompressPic tmpUri = " + uriM77107e, false);
        C12839r.m77110h(this.f57205b, this.f57206c, uriM77107e, false);
        if (!C12839r.m77111i(this.f57205b, uriM77107e.getPath(), 4096, uriM77107e.getPath())) {
            this.f57204a.mo38147b(new Bundle());
            C12836o.m77097b("CompressPictureCase", "startCompressPic onError", true);
            return Boolean.FALSE;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("request_pic_uri_tag", uriM77107e);
        this.f57204a.mo38146a(bundle);
        C12836o.m77097b("CompressPictureCase", "startCompressPic onSuccess", true);
        return Boolean.TRUE;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        C12836o.m77097b("CompressPictureCase", "onPostExecute", true);
        super.onPostExecute(bool);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }
}
