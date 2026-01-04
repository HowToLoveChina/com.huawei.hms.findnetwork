package com.huawei.ads.fund.p067db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import p357i4.AbstractC10436a;
import p357i4.AbstractC10440e;
import p357i4.C10438c;
import p357i4.InterfaceC10439d;
import p405jt.AbstractC10915a;

/* loaded from: classes.dex */
public abstract class BaseDao implements InterfaceC10439d {

    /* renamed from: a */
    public Context f9507a;

    public BaseDao(Context context) {
        this.f9507a = context.getApplicationContext();
    }

    /* renamed from: g */
    public void m12561g(String str, List<String[]> list) {
        AbstractC10436a abstractC10436aMo12533b = mo12533b();
        try {
            abstractC10436aMo12533b.m64184w(str, list);
        } finally {
            m12570p(abstractC10436aMo12533b);
        }
    }

    /* renamed from: h */
    public void m12562h() {
        AbstractC10436a abstractC10436aMo12533b = mo12533b();
        try {
            abstractC10436aMo12533b.m64186y();
        } finally {
            m12570p(abstractC10436aMo12533b);
        }
    }

    /* renamed from: i */
    public void m12563i(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        try {
            cursor.close();
        } catch (Throwable unused) {
            AbstractC10915a.m65970b(mo12528a(), "closeCursor exception");
        }
    }

    /* renamed from: j */
    public <T extends AbstractC10440e> int m12564j(Class<T> cls, String str, String[] strArr) {
        AbstractC10436a abstractC10436aMo12533b = mo12533b();
        try {
            return abstractC10436aMo12533b.m64169A(cls.getSimpleName(), str, strArr);
        } finally {
            m12570p(abstractC10436aMo12533b);
        }
    }

    /* renamed from: k */
    public <T extends AbstractC10440e> void m12565k(Class<T> cls, String str, List<String> list) {
        AbstractC10436a abstractC10436aMo12533b = mo12533b();
        try {
            abstractC10436aMo12533b.m64170B(cls.getSimpleName(), str, list);
        } finally {
            m12570p(abstractC10436aMo12533b);
        }
    }

    /* renamed from: l */
    public void m12566l(String str, Object[] objArr) {
        AbstractC10436a abstractC10436aMo12533b = mo12533b();
        try {
            abstractC10436aMo12533b.m64173E(str, objArr);
        } finally {
            m12570p(abstractC10436aMo12533b);
        }
    }

    /* renamed from: m */
    public <T extends AbstractC10440e> long m12567m(Class<T> cls, ContentValues contentValues) {
        AbstractC10436a abstractC10436aMo12533b = mo12533b();
        try {
            return abstractC10436aMo12533b.m64175I(cls.getSimpleName(), contentValues);
        } finally {
            m12570p(abstractC10436aMo12533b);
        }
    }

    /* renamed from: n */
    public void m12568n(List<C10438c> list) {
        AbstractC10436a abstractC10436aMo12533b = mo12533b();
        try {
            abstractC10436aMo12533b.m64176J(list);
        } finally {
            m12570p(abstractC10436aMo12533b);
        }
    }

    /* renamed from: o */
    public <T extends AbstractC10440e> List<T> m12569o(Class<T> cls, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        Cursor cursor;
        AbstractC10436a abstractC10436aMo12533b;
        ArrayList arrayList = new ArrayList();
        AbstractC10436a abstractC10436a = null;
        Cursor cursorM64177X = null;
        try {
            abstractC10436aMo12533b = mo12533b();
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        try {
            cursorM64177X = abstractC10436aMo12533b.m64177X(cls.getSimpleName(), strArr, str, strArr2, str2, str3);
            if (cursorM64177X != null) {
                while (cursorM64177X.moveToNext()) {
                    try {
                        T tNewInstance = cls.newInstance();
                        tNewInstance.m64215q(cursorM64177X);
                        arrayList.add(tNewInstance);
                    } catch (Throwable th3) {
                        AbstractC10915a.m65970b(mo12528a(), "query:" + th3.getClass().getSimpleName());
                    }
                }
            }
            m12563i(cursorM64177X);
            m12570p(abstractC10436aMo12533b);
        } catch (Throwable th4) {
            th = th4;
            cursor = cursorM64177X;
            abstractC10436a = abstractC10436aMo12533b;
            try {
                AbstractC10915a.m65971c(mo12528a(), "query db exception: %s", th.getClass().getSimpleName());
                return arrayList;
            } finally {
                m12563i(cursor);
                m12570p(abstractC10436a);
            }
        }
        return arrayList;
    }

    /* renamed from: p */
    public void m12570p(AbstractC10436a abstractC10436a) {
        if (abstractC10436a != null) {
            abstractC10436a.m64180s();
        }
    }

    /* renamed from: q */
    public <T extends AbstractC10440e> int m12571q(Class<T> cls, ContentValues contentValues, String str, String[] strArr) {
        AbstractC10436a abstractC10436aMo12533b = mo12533b();
        try {
            return abstractC10436aMo12533b.m64179Z(cls.getSimpleName(), contentValues, str, strArr);
        } finally {
            m12570p(abstractC10436aMo12533b);
        }
    }
}
