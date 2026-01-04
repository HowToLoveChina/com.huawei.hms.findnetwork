package com.huawei.hidisk.common.kvdb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.huawei.kvdb.KVDatabase;
import com.huawei.kvdb.KVFullException;
import hk.C10278a;
import hk.C10280c;
import java.io.File;
import java.io.IOException;
import p035bk.C1248a;
import p399jk.AbstractC10896a;
import p783xp.C13843a;

/* loaded from: classes8.dex */
public class KvDatabaseWrapper {

    /* renamed from: a */
    public String f23020a;

    /* renamed from: b */
    public KVDatabase f23021b;

    public KvDatabaseWrapper(Context context) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append("thumbs");
        sb2.append(str);
        this.f23020a = sb2.toString();
        this.f23021b = new KVDatabase(context.getApplicationContext(), this.f23020a + "hicloud_thumbs.db");
    }

    /* renamed from: a */
    public boolean m30070a() {
        return C10280c.m63454b(C10278a.m63442h(this.f23020a));
    }

    /* renamed from: b */
    public Bitmap m30071b(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        byte[] bArrM30072c = m30072c(str);
        if (bArrM30072c == null) {
            AbstractC10896a.m65885d("KvDatabaseWrapper", "getBitmap, bytes is null");
            return null;
        }
        Bitmap bitmapM7471b = C1248a.m7471b(bArrM30072c, 0, bArrM30072c.length, options);
        AbstractC10896a.m65885d("KvDatabaseWrapper", "kvdb bitmapSize = " + (bitmapM7471b.getRowBytes() * bitmapM7471b.getHeight()));
        return bitmapM7471b;
    }

    /* renamed from: c */
    public byte[] m30072c(String str) {
        return m30073d().get(str);
    }

    /* renamed from: d */
    public final KVDatabase m30073d() {
        return this.f23021b;
    }

    /* renamed from: e */
    public boolean m30074e(String str, Bitmap bitmap) {
        if (bitmap == null) {
            AbstractC10896a.m65885d("KvDatabaseWrapper", "invalid data");
            return false;
        }
        try {
            Bitmap bitmapM30071b = m30071b(str);
            if (bitmapM30071b != null && bitmapM30071b.getAllocationByteCount() > bitmap.getAllocationByteCount()) {
                AbstractC10896a.m65885d("KvDatabaseWrapper", "cache bigger than bitmap, already saved LCD pic.");
                return false;
            }
            KVDatabase kVDatabaseM30073d = m30073d();
            byte[] bArrM83079c = C13843a.m83079c(bitmap, -1);
            return kVDatabaseM30073d.put(str, bArrM83079c, bArrM83079c.length);
        } catch (KVFullException unused) {
            AbstractC10896a.m65886e("KvDatabaseWrapper", "Failed to put key as kv is full!!");
            return false;
        }
    }

    /* renamed from: f */
    public boolean m30075f(String str) {
        try {
            return m30073d().remove(str);
        } catch (KVFullException unused) {
            AbstractC10896a.m65886e("KvDatabaseWrapper", "Failed to remove key as kv is full!!");
            return false;
        }
    }
}
