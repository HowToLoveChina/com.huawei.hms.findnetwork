package p357i4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.p171db.bean.C7013a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import p308g4.AbstractC9881e;
import p326h4.InterfaceC10092b;
import p326h4.InterfaceC10093c;
import p326h4.InterfaceC10095e;
import p384j4.AbstractC10705d;
import p405jt.AbstractC10915a;

/* renamed from: i4.e */
/* loaded from: classes.dex */
public abstract class AbstractC10440e implements InterfaceC10441f, Cloneable {

    /* renamed from: a */
    private static final Map<Class, String> f50393a;

    static {
        HashMap map = new HashMap(4);
        f50393a = map;
        map.put(String.class, "TEXT");
        map.put(Long.TYPE, "INTEGER");
        map.put(Integer.TYPE, "INTEGER");
        map.put(Float.TYPE, "REAL");
        map.put(Double.TYPE, "REAL");
        map.put(Boolean.TYPE, "BOOLEAN");
    }

    /* renamed from: a */
    public final String m64203a(String str) {
        return str.endsWith("_") ? str.substring(0, str.length() - 1) : str;
    }

    /* renamed from: b */
    public final String m64204b(Field field) {
        InterfaceC10092b interfaceC10092b = (InterfaceC10092b) field.getAnnotation(InterfaceC10092b.class);
        return (interfaceC10092b == null || TextUtils.isEmpty(interfaceC10092b.value())) ? m64203a(field.getName()) : interfaceC10092b.value();
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: c */
    public String mo64205c() {
        return m64209k(mo64206d());
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: d */
    public String mo64206d() {
        return getClass().getSimpleName();
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: g */
    public String[] mo64207g() {
        return new String[]{String.valueOf(System.currentTimeMillis() - mo12454f())};
    }

    /* renamed from: j */
    public final void m64208j(String str, Field field, Class cls) throws IllegalAccessException, IllegalArgumentException {
        try {
            field.set(this, AbstractC10705d.m65339E(str, cls, AbstractC9881e.m61329a(field)));
        } catch (JSONException unused) {
        } catch (Exception unused2) {
            AbstractC10915a.m65978j(C7013a.TAG, "toBean - other field injection Exception");
        }
    }

    /* renamed from: k */
    public final String m64209k(String str) {
        Field[] fieldArrM61332d = AbstractC9881e.m61332d(getClass());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("create table ");
        sb2.append(str);
        sb2.append(" ( ");
        sb2.append("_id INTEGER primary key autoincrement ");
        int length = fieldArrM61332d.length;
        for (int i10 = 0; i10 < length; i10++) {
            Field fieldM61331c = AbstractC9881e.m61331c(fieldArrM61332d[i10], true);
            fieldArrM61332d[i10] = fieldM61331c;
            if (!m64213o(fieldM61331c)) {
                String str2 = f50393a.get(fieldArrM61332d[i10].getType());
                if (str2 == null) {
                    str2 = "TEXT";
                }
                String strM64204b = m64204b(fieldArrM61332d[i10]);
                sb2.append(" , ");
                sb2.append(strM64204b);
                sb2.append(' ');
                sb2.append(str2);
                if (m64214p() != null && m64214p().equals(strM64204b)) {
                    sb2.append(" unique");
                }
            }
        }
        sb2.append(" ) ");
        return sb2.toString();
    }

    /* renamed from: l */
    public final boolean m64210l(Field field) {
        if (field == null) {
            return false;
        }
        String name = field.getName();
        return (Modifier.isStatic(field.getModifiers()) || name == null || name.contains("$") || field.isAnnotationPresent(InterfaceC10095e.class)) ? false : true;
    }

    /* renamed from: m */
    public final boolean m64211m(Field field) {
        if (field == null) {
            return false;
        }
        String name = field.getName();
        return (Modifier.isStatic(field.getModifiers()) || name == null || name.contains("$") || !field.isAnnotationPresent(InterfaceC10093c.class)) ? false : true;
    }

    /* renamed from: n */
    public AbstractC10440e m64212n() {
        try {
            return (AbstractC10440e) super.clone();
        } catch (CloneNotSupportedException unused) {
            AbstractC10915a.m65970b(C7013a.TAG, "copy failed");
            return null;
        }
    }

    /* renamed from: o */
    public final boolean m64213o(Field field) {
        return !m64210l(field) || m64211m(field);
    }

    /* renamed from: p */
    public String m64214p() {
        return "";
    }

    /* renamed from: q */
    public void m64215q(Cursor cursor) {
        Field field;
        Object objValueOf;
        Field field2;
        String string;
        Field[] fieldArrM61332d = AbstractC9881e.m61332d(getClass());
        int length = fieldArrM61332d.length;
        for (int i10 = 0; i10 < length; i10++) {
            try {
                boolean z10 = true;
                Field fieldM61331c = AbstractC9881e.m61331c(fieldArrM61332d[i10], true);
                fieldArrM61332d[i10] = fieldM61331c;
                String name = fieldM61331c.getName();
                if (!Modifier.isStatic(fieldArrM61332d[i10].getModifiers()) && "_id".equals(name)) {
                    int columnIndex = cursor.getColumnIndex(name);
                    if (columnIndex != -1) {
                        field2 = fieldArrM61332d[i10];
                        string = cursor.getString(columnIndex);
                        field2.set(this, string);
                    }
                } else if (m64210l(fieldArrM61332d[i10])) {
                    Class<?> type = fieldArrM61332d[i10].getType();
                    int columnIndex2 = cursor.getColumnIndex(m64204b(fieldArrM61332d[i10]));
                    if (columnIndex2 != -1) {
                        if (String.class == type) {
                            field2 = fieldArrM61332d[i10];
                            string = cursor.getString(columnIndex2);
                            field2.set(this, string);
                        } else {
                            if (Integer.TYPE == type) {
                                field = fieldArrM61332d[i10];
                                objValueOf = Integer.valueOf(cursor.getInt(columnIndex2));
                            } else if (Long.TYPE == type) {
                                field = fieldArrM61332d[i10];
                                objValueOf = Long.valueOf(cursor.getLong(columnIndex2));
                            } else if (Float.TYPE == type) {
                                field = fieldArrM61332d[i10];
                                objValueOf = Float.valueOf(cursor.getFloat(columnIndex2));
                            } else if (Double.TYPE == type) {
                                field = fieldArrM61332d[i10];
                                objValueOf = Double.valueOf(cursor.getDouble(columnIndex2));
                            } else if (Boolean.class == type) {
                                field = fieldArrM61332d[i10];
                                if (cursor.getInt(columnIndex2) == 0) {
                                    z10 = false;
                                }
                                objValueOf = Boolean.valueOf(z10);
                            } else {
                                m64208j(cursor.getString(columnIndex2), fieldArrM61332d[i10], type);
                            }
                            field.set(this, objValueOf);
                        }
                    }
                }
            } catch (Throwable th2) {
                AbstractC10915a.m65978j(C7013a.TAG, "toBean " + th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: r */
    public ContentValues m64216r() {
        return m64217s(null);
    }

    /* renamed from: s */
    public ContentValues m64217s(Context context) throws IllegalAccessException, IllegalArgumentException {
        String strM65338D;
        Field[] fieldArrM61332d = AbstractC9881e.m61332d(getClass());
        ContentValues contentValues = new ContentValues();
        int length = fieldArrM61332d.length;
        for (int i10 = 0; i10 < length; i10++) {
            try {
                Field fieldM61331c = AbstractC9881e.m61331c(fieldArrM61332d[i10], true);
                fieldArrM61332d[i10] = fieldM61331c;
                if (!m64213o(fieldM61331c)) {
                    Object obj = fieldArrM61332d[i10].get(this);
                    String strM64204b = m64204b(fieldArrM61332d[i10]);
                    if (obj instanceof String) {
                        strM65338D = (String) obj;
                    } else if (obj instanceof Integer) {
                        contentValues.put(strM64204b, (Integer) obj);
                    } else if (obj instanceof Long) {
                        contentValues.put(strM64204b, (Long) obj);
                    } else if (obj instanceof Float) {
                        contentValues.put(strM64204b, (Float) obj);
                    } else if (obj instanceof Double) {
                        contentValues.put(strM64204b, (Double) obj);
                    } else if (obj instanceof Boolean) {
                        contentValues.put(strM64204b, (Boolean) obj);
                    } else {
                        strM65338D = AbstractC10705d.m65338D(obj);
                    }
                    contentValues.put(strM64204b, strM65338D);
                }
            } catch (IllegalAccessException unused) {
                AbstractC10915a.m65978j(C7013a.TAG, "toRecord IllegalAccessException");
            }
        }
        return contentValues;
    }
}
