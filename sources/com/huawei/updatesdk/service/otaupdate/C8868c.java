package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p191b.p198e.C8826e;
import com.huawei.updatesdk.p191b.p200g.C8832c;
import com.huawei.updatesdk.p191b.p201h.C8836d;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.updatesdk.service.otaupdate.c */
/* loaded from: classes9.dex */
public class C8868c {

    /* renamed from: com.huawei.updatesdk.service.otaupdate.c$a */
    public interface a {
        /* renamed from: a */
        void mo56438a(Boolean bool);
    }

    /* renamed from: com.huawei.updatesdk.service.otaupdate.c$b */
    public static class b extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a */
        final a f45240a;

        /* renamed from: b */
        String f45241b;

        public b(a aVar) {
            this.f45240a = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            String str = "AutoUpdateUtil";
            Cursor cursorQuery = null;
            boolean z10 = false;
            try {
                try {
                    cursorQuery = C8793a.m56132c().m56133a().getContentResolver().query(Uri.parse(this.f45241b), null, null, null, null);
                    if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                        C8774a.m56008a("AutoUpdateUtil", "cursor = null");
                        str = str;
                    } else {
                        boolean z11 = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex("isagree")));
                        boolean z12 = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex("isopenautoupdate")));
                        boolean z13 = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex("isneverreminder")));
                        str = z13;
                        str = z13;
                        str = z13;
                        if (z11 && !z12 && z13 == 0) {
                            z10 = true;
                            str = z13;
                        }
                    }
                } catch (Exception e10) {
                    C8774a.m56008a(str, "query cursor error: " + e10.getMessage());
                }
                C8836d.m56339a(cursorQuery);
                return Boolean.valueOf(z10);
            } catch (Throwable th2) {
                C8836d.m56339a(cursorQuery);
                throw th2;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            a aVar = this.f45240a;
            if (aVar != null) {
                aVar.mo56438a(bool);
            }
        }

        /* renamed from: a */
        public void m56445a(String str) {
            this.f45241b = str;
        }
    }

    /* renamed from: a */
    public void m56442a(Context context, String str, a aVar, boolean z10) {
        if (C8826e.m56286a(z10).mo56280c(context) && C8871f.m56464e().m56471d()) {
            String str2 = String.format(Locale.ROOT, "content://%s.commondata/item/4", str);
            if (C8836d.m56341a(context, Uri.parse(str2), str)) {
                b bVar = new b(aVar);
                try {
                    bVar.m56445a(str2);
                    bVar.executeOnExecutor(C8832c.f45172a, new Void[0]);
                    bVar.get(500L, TimeUnit.MILLISECONDS);
                    return;
                } catch (Exception e10) {
                    bVar.cancel(true);
                    C8774a.m56008a("AutoUpdateUtil", "init AutoUpdateInfo error: " + e10.getMessage());
                    aVar.mo56438a(Boolean.FALSE);
                    return;
                }
            }
        }
        aVar.mo56438a(Boolean.FALSE);
    }
}
