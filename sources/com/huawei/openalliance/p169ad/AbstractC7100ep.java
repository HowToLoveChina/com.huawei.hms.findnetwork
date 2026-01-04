package com.huawei.openalliance.p169ad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.openalliance.p169ad.p171db.bean.C7013a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ep */
/* loaded from: classes8.dex */
public abstract class AbstractC7100ep {

    /* renamed from: a */
    protected Context f32709a;

    /* renamed from: b */
    protected InterfaceC7146gc f32710b;

    public AbstractC7100ep(Context context) {
        this.f32709a = context.getApplicationContext();
        this.f32710b = C7124fh.m43316b(context);
    }

    /* renamed from: a */
    public <T extends C7013a> int m42977a(Class<T> cls, ContentValues contentValues, EnumC7125fi enumC7125fi, String[] strArr) {
        if (!this.f32710b.mo43345aL()) {
            return 0;
        }
        C7015dd c7015ddM41894a = C7015dd.m41894a(this.f32709a);
        try {
            return c7015ddM41894a.m41903a(cls.getSimpleName(), contentValues, enumC7125fi.m43493a(), strArr);
        } finally {
            m42987a(c7015ddM41894a);
        }
    }

    /* renamed from: c */
    public <T extends C7013a> void m42989c(List<C7016de> list) {
        C7015dd c7015ddM41894a = C7015dd.m41894a(this.f32709a);
        try {
            c7015ddM41894a.m41913a(list);
        } finally {
            m42987a(c7015ddM41894a);
        }
    }

    /* renamed from: e */
    public void mo42990e() {
    }

    /* renamed from: a */
    public <T extends C7013a> int m42978a(Class<T> cls, EnumC7125fi enumC7125fi, List<String> list) {
        C7015dd c7015ddM41894a = C7015dd.m41894a(this.f32709a);
        try {
            return c7015ddM41894a.m41904a(cls.getSimpleName(), enumC7125fi.m43493a(), list);
        } finally {
            m42987a(c7015ddM41894a);
        }
    }

    /* renamed from: a */
    public <T extends C7013a> int m42979a(Class<T> cls, EnumC7125fi enumC7125fi, String[] strArr) {
        C7015dd c7015ddM41894a = C7015dd.m41894a(this.f32709a);
        try {
            return c7015ddM41894a.m41905a(cls.getSimpleName(), enumC7125fi == null ? null : enumC7125fi.m43493a(), strArr);
        } finally {
            m42987a(c7015ddM41894a);
        }
    }

    /* renamed from: a */
    public long m42980a(Class cls) {
        C7015dd c7015ddM41894a = null;
        try {
            c7015ddM41894a = C7015dd.m41894a(this.f32709a);
            return c7015ddM41894a.m41919g(cls.getSimpleName());
        } finally {
            m42987a(c7015ddM41894a);
        }
    }

    /* renamed from: a */
    public <T extends C7013a> long m42981a(Class<T> cls, ContentValues contentValues) {
        if (!this.f32710b.mo43345aL()) {
            return 0L;
        }
        C7015dd c7015ddM41894a = C7015dd.m41894a(this.f32709a);
        try {
            return c7015ddM41894a.m41906a(cls.getSimpleName(), contentValues);
        } finally {
            m42987a(c7015ddM41894a);
        }
    }

    /* renamed from: a */
    public <T extends C7013a> long m42982a(Class<T> cls, List<ContentValues> list) {
        C7015dd c7015ddM41894a = C7015dd.m41894a(this.f32709a);
        try {
            return c7015ddM41894a.m41907a(cls.getSimpleName(), list);
        } finally {
            m42987a(c7015ddM41894a);
        }
    }

    /* renamed from: a */
    public <T extends C7013a> List<T> m42983a(Class<T> cls, String str, String[] strArr) {
        Cursor cursor;
        C7015dd c7015ddM41894a;
        ArrayList arrayList = new ArrayList();
        C7015dd c7015dd = null;
        Cursor cursorM41908a = null;
        try {
            c7015ddM41894a = C7015dd.m41894a(this.f32709a);
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        try {
            cursorM41908a = c7015ddM41894a.m41908a(str, strArr);
            m42976a(cls, arrayList, cursorM41908a);
            m42986a(cursorM41908a);
            m42987a(c7015ddM41894a);
        } catch (Throwable th3) {
            th = th3;
            cursor = cursorM41908a;
            c7015dd = c7015ddM41894a;
            try {
                AbstractC7185ho.m43827d("BaseDao", "query db exception: %s", th.getClass().getSimpleName());
                return arrayList;
            } finally {
                m42986a(cursor);
                m42987a(c7015dd);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public <T extends C7013a> List<T> m42984a(Class<T> cls, String[] strArr, EnumC7125fi enumC7125fi, String[] strArr2, String str, String str2) {
        C7015dd c7015ddM41894a;
        ArrayList arrayList = new ArrayList();
        Cursor cursorM41909a = null;
        String strM43493a = enumC7125fi == null ? null : enumC7125fi.m43493a();
        try {
            c7015ddM41894a = C7015dd.m41894a(this.f32709a);
        } catch (Throwable th2) {
            th = th2;
            c7015ddM41894a = null;
        }
        try {
            cursorM41909a = c7015ddM41894a.m41909a(cls.getSimpleName(), strArr, strM43493a, strArr2, str, str2);
            m42976a(cls, arrayList, cursorM41909a);
            m42986a(cursorM41909a);
            m42987a(c7015ddM41894a);
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            m42986a(cursorM41909a);
            m42987a(c7015ddM41894a);
            throw th;
        }
    }

    /* renamed from: a */
    public List<String> m42985a(String str, String[] strArr, String str2) {
        Cursor cursor;
        C7015dd c7015ddM41894a;
        ArrayList arrayList = new ArrayList();
        C7015dd c7015dd = null;
        Cursor cursorM41908a = null;
        try {
            c7015ddM41894a = C7015dd.m41894a(this.f32709a);
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        try {
            cursorM41908a = c7015ddM41894a.m41908a(str, strArr);
            if (cursorM41908a != null) {
                while (cursorM41908a.moveToNext()) {
                    try {
                        arrayList.add(cursorM41908a.getString(cursorM41908a.getColumnIndex(str2)));
                    } catch (Exception unused) {
                        AbstractC7185ho.m43826d("BaseDao", "query exception");
                    }
                }
            }
            m42986a(cursorM41908a);
            m42987a(c7015ddM41894a);
        } catch (Throwable th3) {
            th = th3;
            cursor = cursorM41908a;
            c7015dd = c7015ddM41894a;
            try {
                AbstractC7185ho.m43827d("BaseDao", "query db exception: %s", th.getClass().getSimpleName());
                return arrayList;
            } finally {
                m42986a(cursor);
                m42987a(c7015dd);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m42986a(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        try {
            cursor.close();
        } catch (Throwable unused) {
            AbstractC7185ho.m43826d("BaseDao", "closeCursor exception");
        }
    }

    /* renamed from: a */
    public void m42987a(C7015dd c7015dd) {
        if (c7015dd != null) {
            c7015dd.m41910a();
        }
    }

    /* renamed from: a */
    public <T extends C7013a> void m42988a(Class<T> cls, ContentValues contentValues, EnumC7125fi enumC7125fi, List<String> list) {
        if (this.f32710b.mo43345aL()) {
            C7015dd c7015ddM41894a = C7015dd.m41894a(this.f32709a);
            try {
                c7015ddM41894a.m41912a(cls.getSimpleName(), contentValues, enumC7125fi.m43493a(), list);
            } finally {
                m42987a(c7015ddM41894a);
            }
        }
    }

    /* renamed from: a */
    private <T extends C7013a> void m42976a(Class<T> cls, List<T> list, Cursor cursor) throws IllegalAccessException, InstantiationException {
        String str;
        if (cursor != null) {
            while (cursor.moveToNext()) {
                try {
                    T tNewInstance = cls.newInstance();
                    tNewInstance.m41856a(cursor);
                    list.add(tNewInstance);
                } catch (IllegalAccessException unused) {
                    str = "query IllegalAccessException";
                    AbstractC7185ho.m43826d("BaseDao", str);
                } catch (InstantiationException unused2) {
                    str = "query InstantiationException";
                    AbstractC7185ho.m43826d("BaseDao", str);
                } catch (Exception unused3) {
                    str = "query exception";
                    AbstractC7185ho.m43826d("BaseDao", str);
                }
            }
        }
    }
}
