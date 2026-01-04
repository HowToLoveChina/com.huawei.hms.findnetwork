package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.annotations.InterfaceC6936h;
import com.huawei.openalliance.p169ad.utils.AbstractC7791ck;
import java.lang.reflect.Field;

/* renamed from: com.huawei.openalliance.ad.cx */
/* loaded from: classes8.dex */
public class C7007cx implements InterfaceC7006cw<InterfaceC6936h> {
    /* renamed from: b */
    private void m41235b(Object obj, Field field, InterfaceC6936h interfaceC6936h) throws IllegalAccessException, IllegalArgumentException {
        int[] iArrM39230e = interfaceC6936h.m39230e();
        if (iArrM39230e.length != 2) {
            AbstractC7185ho.m43824c("ValueConstraintProcessor", "%s - field %s the length of range constraint must be 2", obj.getClass().getSimpleName(), field.getName());
            return;
        }
        int i10 = iArrM39230e[0];
        int i11 = iArrM39230e[1];
        if (i11 < i10) {
            i10 = i11;
            i11 = i10;
        }
        Object obj2 = field.get(obj);
        if (obj2 instanceof Number) {
            int iIntValue = ((Number) obj2).intValue();
            if (iIntValue < i10 || iIntValue > i11) {
                AbstractC7185ho.m43824c("ValueConstraintProcessor", "%s - field %s not in constraint range, set default value", obj.getClass().getSimpleName(), field.getName());
                field.set(obj, Integer.valueOf(interfaceC6936h.m39231f()));
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7006cw
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo41233a(Object obj, Field field, InterfaceC6936h interfaceC6936h) throws IllegalAccessException, IllegalArgumentException {
        if (interfaceC6936h.m39226a()) {
            Class clsM39227b = interfaceC6936h.m39227b();
            if (clsM39227b != Void.class) {
                m41234a(obj, field, interfaceC6936h, clsM39227b);
            } else {
                m41235b(obj, field, interfaceC6936h);
            }
        }
    }

    /* renamed from: a */
    private void m41234a(Object obj, Field field, InterfaceC6936h interfaceC6936h, Class cls) throws IllegalAccessException, IllegalArgumentException {
        Object objValueOf;
        Field[] fieldArrM48068a = AbstractC7791ck.m48068a(cls);
        Object obj2 = field.get(obj);
        for (Field field2 : fieldArrM48068a) {
            Object obj3 = field2.get(null);
            if (obj3 != null && (obj3 == obj2 || obj3.equals(obj2))) {
                return;
            }
            if (obj3 == null && obj2 == null) {
                return;
            }
        }
        AbstractC7185ho.m43824c("ValueConstraintProcessor", "%s - field %s not in constraint values, set default value", obj.getClass().getSimpleName(), field.getName());
        Class<?> type = field.getType();
        if (String.class == type) {
            objValueOf = interfaceC6936h.m39229d();
        } else if (Integer.TYPE != type && Integer.class != type) {
            return;
        } else {
            objValueOf = Integer.valueOf(interfaceC6936h.m39228c());
        }
        field.set(obj, objValueOf);
    }
}
