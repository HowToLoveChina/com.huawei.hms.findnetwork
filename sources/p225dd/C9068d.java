package p225dd;

import android.database.sqlite.SQLiteDatabase;
import fk.C9721b;

/* renamed from: dd.d */
/* loaded from: classes3.dex */
public class C9068d extends AbstractC9069e<C9067c> {
    public C9068d(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
    }

    @Override // p225dd.AbstractC9069e
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String[] mo57233e(C9067c c9067c) {
        return new String[]{String.valueOf(c9067c.m57218l()), String.valueOf(c9067c.m57212f()), c9067c.m57220n(), c9067c.m57222p(), String.valueOf(c9067c.m57221o()), c9067c.m57214h(), c9067c.m57223q(), String.valueOf(c9067c.m57224r()), c9067c.m57215i(), c9067c.m57216j(), c9067c.m57217k(), c9067c.m57213g(), c9067c.m57219m(), String.valueOf(c9067c.m57225s()), String.valueOf(c9067c.m57227u()), String.valueOf(c9067c.m57226t()), c9067c.m57207a(), c9067c.m57228v(), c9067c.m57208b(), c9067c.m57209c(), c9067c.m57210d(), c9067c.m57211e()};
    }

    /* renamed from: g */
    public void m57235g(C9067c c9067c) throws C9721b {
        m57238c("replace into t_sync_asset_status(id, databaseId, kind, recordId, length, hash, sha256, size, hash1, hash2, hmac, efek, iv, sliceSize, version, status, assetId, versionId, bucket, data1, data2, data3) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", mo57233e(c9067c));
    }
}
