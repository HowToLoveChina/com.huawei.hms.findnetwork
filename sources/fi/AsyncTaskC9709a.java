package fi;

import android.os.AsyncTask;
import p258ei.C9492a;

/* renamed from: fi.a */
/* loaded from: classes.dex */
public class AsyncTaskC9709a extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    public static AsyncTaskC9709a f47918a;

    /* renamed from: b */
    public static AsyncTaskC9709a m60560b() {
        if (f47918a == null || AsyncTask.Status.FINISHED.equals(f47918a.getStatus())) {
            f47918a = new AsyncTaskC9709a();
        }
        return f47918a;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        C9492a.m59357h().m59361e();
        return null;
    }
}
