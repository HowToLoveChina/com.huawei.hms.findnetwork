package p308g4;

import java.lang.reflect.Field;
import p326h4.InterfaceC10097g;
import p405jt.AbstractC10915a;

/* renamed from: g4.g */
/* loaded from: classes.dex */
public class C9883g implements InterfaceC9879c<InterfaceC10097g> {
    @Override // p308g4.InterfaceC9879c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo61328a(Object obj, Field field, InterfaceC10097g interfaceC10097g) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        if (interfaceC10097g.value()) {
            Class clsConstraintClass = interfaceC10097g.constraintClass();
            if (clsConstraintClass != Void.class) {
                m61334b(obj, field, interfaceC10097g, clsConstraintClass);
            } else {
                m61335c(obj, field, interfaceC10097g);
            }
        }
    }

    /* renamed from: b */
    public final void m61334b(Object obj, Field field, InterfaceC10097g interfaceC10097g, Class cls) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        Object objValueOf;
        Field[] fields = cls.getFields();
        Object obj2 = field.get(obj);
        if (fields.length <= 0) {
            AbstractC10915a.m65979k("ValueConstraintProcessor", "fields of %s is empty, don't check json field value for [%s#%s]", cls, obj.getClass().getSimpleName(), field.getName());
            return;
        }
        for (Field field2 : fields) {
            Object obj3 = field2.get(null);
            if (obj3 != null && (obj3 == obj2 || obj3.equals(obj2))) {
                return;
            }
            if (obj3 == null && obj2 == null) {
                return;
            }
        }
        AbstractC10915a.m65979k("ValueConstraintProcessor", "%s - field %s not in constraint values, set default value", obj.getClass().getSimpleName(), field.getName());
        Class<?> type = field.getType();
        if (String.class == type) {
            objValueOf = interfaceC10097g.defaultStringValueForClass();
        } else if (Integer.TYPE != type && Integer.class != type) {
            return;
        } else {
            objValueOf = Integer.valueOf(interfaceC10097g.defaultIntValueForClass());
        }
        field.set(obj, objValueOf);
    }

    /* renamed from: c */
    public final void m61335c(Object obj, Field field, InterfaceC10097g interfaceC10097g) throws IllegalAccessException, IllegalArgumentException {
        int[] iArrConstraintRange = interfaceC10097g.constraintRange();
        if (iArrConstraintRange.length != 2) {
            AbstractC10915a.m65979k("ValueConstraintProcessor", "%s - field %s the length of range constraint must be 2", obj.getClass().getSimpleName(), field.getName());
            return;
        }
        int i10 = iArrConstraintRange[0];
        int i11 = iArrConstraintRange[1];
        if (i11 < i10) {
            i10 = i11;
            i11 = i10;
        }
        Object obj2 = field.get(obj);
        if (obj2 instanceof Number) {
            int iIntValue = ((Number) obj2).intValue();
            if (iIntValue < i10 || iIntValue > i11) {
                AbstractC10915a.m65979k("ValueConstraintProcessor", "%s - field %s not in constraint range, set default value", obj.getClass().getSimpleName(), field.getName());
                field.set(obj, Integer.valueOf(interfaceC10097g.defaultValueForRange()));
            }
        }
    }
}
