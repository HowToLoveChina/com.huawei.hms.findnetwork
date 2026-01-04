package com.huawei.hwcloudjs.p154d.p155a;

import com.huawei.hwcloudjs.service.auth.bean.AuthBean;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hwcloudjs.d.a.e */
/* loaded from: classes8.dex */
public final class C6634e extends ObjectInputStream {

    /* renamed from: a */
    private static List<String> f30836a;

    static {
        ArrayList arrayList = new ArrayList();
        f30836a = arrayList;
        arrayList.add(AuthBean.class.getName());
    }

    public C6634e() throws SecurityException, IOException {
    }

    public C6634e(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        if (f30836a.contains(objectStreamClass.getName())) {
            return super.resolveClass(objectStreamClass);
        }
        throw new ClassNotFoundException(objectStreamClass.getName() + " not find");
    }
}
