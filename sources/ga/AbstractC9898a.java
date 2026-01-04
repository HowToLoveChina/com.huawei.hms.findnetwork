package ga;

import android.content.Context;
import android.os.Environment;
import hk.C10278a;
import java.io.File;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1124e;

/* renamed from: ga.a */
/* loaded from: classes3.dex */
public abstract class AbstractC9898a {
    /* renamed from: a */
    public File m61410a() {
        File fileM63441g = C10278a.m63441g(m61413d(), ".core_asset");
        if (!fileM63441g.exists()) {
            if (fileM63441g.mkdirs()) {
                C1120a.m6677i("AssetBase", "external parent create success.");
            } else {
                C1120a.m6677i("AssetBase", "external parent create failed， user PhotoShareDownload cache directory");
                fileM63441g = C10278a.m63443i(C1124e.m6869m(m61412c()), ".core_asset");
                if (!fileM63441g.exists() && fileM63441g.mkdirs()) {
                    C1120a.m6677i("AssetBase", "PhotoShareDownload cache parent create success.");
                }
            }
        }
        return fileM63441g;
    }

    /* renamed from: b */
    public File m61411b(int i10) {
        File fileM63441g = C10278a.m63441g(m61414e(i10), ".core_asset");
        if (!fileM63441g.exists()) {
            if (fileM63441g.mkdirs()) {
                C1120a.m6677i("AssetBase", "external parent create success.");
            } else {
                C1120a.m6677i("AssetBase", "external parent create failed， user PhotoShareDownload cache directory");
                fileM63441g = C10278a.m63443i(C1124e.m6869m(m61412c()), ".core_asset");
                if (!fileM63441g.exists() && fileM63441g.mkdirs()) {
                    C1120a.m6677i("AssetBase", "PhotoShareDownload cache parent create success.");
                }
            }
        }
        return fileM63441g;
    }

    /* renamed from: c */
    public Context m61412c() {
        return C0213f.m1377a();
    }

    /* renamed from: d */
    public final File m61413d() {
        return ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? m61412c().getExternalFilesDir("") : m61412c().getFilesDir();
    }

    /* renamed from: e */
    public final File m61414e(int i10) {
        if (i10 != 4) {
            return ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? m61412c().getExternalFilesDir("") : m61412c().getFilesDir();
        }
        C1120a.m6677i("AssetBase", "otype is :" + i10);
        return m61412c().getFilesDir();
    }
}
