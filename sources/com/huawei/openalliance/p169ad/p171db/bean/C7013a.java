package com.huawei.openalliance.p169ad.p171db.bean;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6930b;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6931c;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6933e;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7791ck;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

@SuppressLint({"NewApi"})
/* renamed from: com.huawei.openalliance.ad.db.bean.a */
/* loaded from: classes2.dex */
public class C7013a {
    private static final boolean DEBUG = false;

    /* renamed from: ID */
    public static final String f32165ID = "_id";
    public static final String TAG = "RecordBean";
    private static Map<Class, String> dbTypeMap;

    @InterfaceC6934f
    @InterfaceC6933e
    private byte[] key;

    static {
        HashMap map = new HashMap(4);
        dbTypeMap = map;
        map.put(String.class, "TEXT");
        dbTypeMap.put(Long.TYPE, "INTEGER");
        dbTypeMap.put(Integer.TYPE, "INTEGER");
        dbTypeMap.put(Float.TYPE, "REAL");
        dbTypeMap.put(EncryptionField.class, "TEXT");
    }

    /* renamed from: a */
    private String m41849a(String str) {
        return str.endsWith("_") ? str.substring(0, str.length() - 1) : str;
    }

    /* renamed from: b */
    private boolean m41853b(Field field) {
        if (field == null) {
            return false;
        }
        String name = field.getName();
        return (Modifier.isStatic(field.getModifiers()) || name == null || name.contains("$") || field.isAnnotationPresent(InterfaceC6933e.class)) ? false : true;
    }

    /* renamed from: c */
    private boolean m41854c(Field field) {
        if (field == null) {
            return false;
        }
        String name = field.getName();
        return (Modifier.isStatic(field.getModifiers()) || name == null || name.contains("$") || !field.isAnnotationPresent(InterfaceC6931c.class)) ? false : true;
    }

    /* renamed from: a_ */
    public String mo41475a_() {
        return "";
    }

    /* renamed from: aj */
    public String m41858aj(String str) throws SecurityException {
        Field[] fieldArrM48068a = AbstractC7791ck.m48068a((Class) getClass());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("create table ");
        sb2.append(str);
        sb2.append(" ( ");
        sb2.append("_id INTEGER primary key autoincrement ");
        int length = fieldArrM48068a.length;
        for (int i10 = 0; i10 < length; i10++) {
            Field fieldM48058a = AbstractC7791ck.m48058a(fieldArrM48068a[i10], true);
            fieldArrM48068a[i10] = fieldM48058a;
            if (!m41852a(fieldM48058a)) {
                String str2 = dbTypeMap.get(fieldArrM48068a[i10].getType());
                if (str2 == null) {
                    str2 = "TEXT";
                }
                String strM41855d = m41855d(fieldArrM48068a[i10]);
                sb2.append(" , ");
                sb2.append(strM41855d);
                sb2.append(' ');
                sb2.append(str2);
                if (mo41475a_() != null && mo41475a_().equals(strM41855d)) {
                    sb2.append(" unique");
                }
            }
        }
        sb2.append(" ) ");
        return sb2.toString();
    }

    /* renamed from: br */
    public byte[] m41859br() {
        return this.key;
    }

    /* renamed from: bs */
    public List<String> m41860bs() throws SecurityException {
        Field[] fieldArrM48068a = AbstractC7791ck.m48068a((Class) getClass());
        ArrayList arrayList = new ArrayList();
        int length = fieldArrM48068a.length;
        for (int i10 = 0; i10 < length; i10++) {
            Field fieldM48058a = AbstractC7791ck.m48058a(fieldArrM48068a[i10], true);
            fieldArrM48068a[i10] = fieldM48058a;
            if (!m41852a(fieldM48058a)) {
                arrayList.add(m41855d(fieldArrM48068a[i10]));
            }
        }
        return arrayList;
    }

    /* renamed from: bt */
    public String m41861bt() {
        return m41858aj(m41862bu());
    }

    /* renamed from: bu */
    public String m41862bu() {
        return getClass().getSimpleName();
    }

    /* renamed from: d */
    public ContentValues m41863d(Context context) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        String strM47742b;
        Field[] fieldArrM48068a = AbstractC7791ck.m48068a((Class) getClass());
        ContentValues contentValues = new ContentValues();
        int length = fieldArrM48068a.length;
        for (int i10 = 0; i10 < length; i10++) {
            try {
                Field fieldM48058a = AbstractC7791ck.m48058a(fieldArrM48068a[i10], true);
                fieldArrM48068a[i10] = fieldM48058a;
                if (!m41852a(fieldM48058a)) {
                    Object obj = fieldArrM48068a[i10].get(this);
                    String strM41855d = m41855d(fieldArrM48068a[i10]);
                    if (obj instanceof String) {
                        strM47742b = (String) obj;
                    } else if (obj instanceof Integer) {
                        contentValues.put(strM41855d, (Integer) obj);
                    } else if (obj instanceof Long) {
                        contentValues.put(strM41855d, (Long) obj);
                    } else if (obj instanceof Float) {
                        contentValues.put(strM41855d, (Float) obj);
                    } else if (obj instanceof EncryptionField) {
                        EncryptionField encryptionField = (EncryptionField) obj;
                        if (this.key == null) {
                            this.key = AbstractC7796cp.m48089b(context);
                        }
                        strM47742b = encryptionField.m41657b(this.key);
                    } else {
                        strM47742b = AbstractC7758be.m47742b(obj);
                    }
                    contentValues.put(strM41855d, strM47742b);
                }
            } catch (IllegalAccessException unused) {
                AbstractC7185ho.m43823c(TAG, "toRecord IllegalAccessException");
            }
        }
        return contentValues;
    }

    /* renamed from: d */
    private String m41855d(Field field) {
        InterfaceC6930b interfaceC6930b = (InterfaceC6930b) field.getAnnotation(InterfaceC6930b.class);
        return (interfaceC6930b == null || TextUtils.isEmpty(interfaceC6930b.m39224a())) ? m41849a(field.getName()) : interfaceC6930b.m39224a();
    }

    /* renamed from: a */
    public void m41856a(Cursor cursor) throws IllegalAccessException, IllegalArgumentException {
        String str;
        Field field;
        Object objValueOf;
        Field[] fieldArrM48068a = AbstractC7791ck.m48068a((Class) getClass());
        int length = fieldArrM48068a.length;
        for (int i10 = 0; i10 < length; i10++) {
            try {
                Field fieldM48058a = AbstractC7791ck.m48058a(fieldArrM48068a[i10], true);
                fieldArrM48068a[i10] = fieldM48058a;
                String name = fieldM48058a.getName();
                if (!Modifier.isStatic(fieldArrM48068a[i10].getModifiers()) && "_id".equals(name)) {
                    int columnIndex = cursor.getColumnIndex(name);
                    if (columnIndex != -1) {
                        fieldArrM48068a[i10].set(this, cursor.getString(columnIndex));
                    }
                } else if (m41853b(fieldArrM48068a[i10])) {
                    Class<?> type = fieldArrM48068a[i10].getType();
                    int columnIndex2 = cursor.getColumnIndex(m41855d(fieldArrM48068a[i10]));
                    if (columnIndex2 != -1) {
                        if (String.class == type) {
                            field = fieldArrM48068a[i10];
                            objValueOf = cursor.getString(columnIndex2);
                        } else if (Integer.TYPE == type) {
                            field = fieldArrM48068a[i10];
                            objValueOf = Integer.valueOf(cursor.getInt(columnIndex2));
                        } else if (Long.TYPE == type) {
                            field = fieldArrM48068a[i10];
                            objValueOf = Long.valueOf(cursor.getLong(columnIndex2));
                        } else if (Float.TYPE == type) {
                            field = fieldArrM48068a[i10];
                            objValueOf = Float.valueOf(cursor.getFloat(columnIndex2));
                        } else if (EncryptionField.class == type) {
                            m41850a(cursor.getString(columnIndex2), fieldArrM48068a[i10]);
                        } else {
                            m41851a(cursor.getString(columnIndex2), fieldArrM48068a[i10], type);
                        }
                        field.set(this, objValueOf);
                    }
                }
            } catch (IllegalAccessException unused) {
                str = "toBean IllegalAccessException";
                AbstractC7185ho.m43823c(TAG, str);
            } catch (Exception e10) {
                str = "toBean " + e10.getClass().getSimpleName();
                AbstractC7185ho.m43823c(TAG, str);
            }
        }
    }

    /* renamed from: a */
    private void m41850a(String str, Field field) throws IllegalAccessException, IllegalArgumentException {
        Class<?> clsM48056a;
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            Type typeM48059a = AbstractC7791ck.m48059a(0, (ParameterizedType) genericType);
            Class<?> clsM48056a2 = AbstractC7791ck.m48056a(typeM48059a);
            clsM48056a = typeM48059a instanceof ParameterizedType ? AbstractC7791ck.m48056a(AbstractC7791ck.m48059a(0, (ParameterizedType) typeM48059a)) : null;
            cls = clsM48056a2;
        } else {
            clsM48056a = null;
        }
        if (cls != null) {
            EncryptionField encryptionField = new EncryptionField(cls, clsM48056a);
            encryptionField.m41656a(str);
            field.set(this, encryptionField);
        } else {
            AbstractC7185ho.m43823c(TAG, "Cannot find member class from " + field);
        }
    }

    /* renamed from: a */
    private void m41851a(String str, Field field, Class cls) throws IllegalAccessException, IllegalArgumentException {
        try {
            field.set(this, AbstractC7758be.m47722a(str, cls, AbstractC7791ck.m48054a(field)));
        } catch (JSONException unused) {
        } catch (Exception unused2) {
            AbstractC7185ho.m43823c(TAG, "toBean - other field injection Exception");
        }
    }

    /* renamed from: a */
    public void m41857a(byte[] bArr) {
        if (bArr == null) {
            this.key = null;
            return;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.key = bArr2;
    }

    /* renamed from: a */
    private boolean m41852a(Field field) {
        return !m41853b(field) || m41854c(field);
    }
}
