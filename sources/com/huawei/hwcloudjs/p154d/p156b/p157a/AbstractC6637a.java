package com.huawei.hwcloudjs.p154d.p156b.p157a;

import android.text.TextUtils;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6639c;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.http.annotation.RequestField;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

/* renamed from: com.huawei.hwcloudjs.d.b.a.a */
/* loaded from: classes8.dex */
public abstract class AbstractC6637a<T extends AbstractC6639c> extends AbstractC6638b<T> {

    /* renamed from: a */
    private static final String f30845a = "FormBean";

    @Override // com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6638b
    /* renamed from: a */
    public String mo37811a() throws SecurityException, IllegalArgumentException {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        Field[] declaredFields = getClass().getDeclaredFields();
        C6659d.m37882c(f30845a, "genBody fs:" + declaredFields, false);
        int length = declaredFields.length;
        for (int i10 = 0; i10 < length; i10++) {
            Field field = declaredFields[i10];
            C6659d.m37882c(f30845a, "genBody isAnnotationPresent:" + field.isAnnotationPresent(RequestField.class), false);
            if (field.isAnnotationPresent(RequestField.class)) {
                try {
                    m37810a(field, stringBuffer);
                } catch (UnsupportedEncodingException unused) {
                    str = "setField UnsupportedEncodingException";
                    C6659d.m37881b(f30845a, str, true);
                } catch (IllegalAccessException unused2) {
                    str = "setField IllegalAccessException";
                    C6659d.m37881b(f30845a, str, true);
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6638b
    /* renamed from: b */
    public String mo37812b() {
        return RequestBody.HEAD_VALUE_CONTENT_TYPE_URLENCODED;
    }

    @Override // com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6638b
    /* renamed from: f */
    public String mo37813f() {
        return "POST";
    }

    /* renamed from: a */
    private void m37810a(Field field, StringBuffer stringBuffer) throws IllegalAccessException, SecurityException, IllegalArgumentException, UnsupportedEncodingException {
        C6659d.m37882c(f30845a, "setField field:" + field, false);
        String strValue = ((RequestField) field.getAnnotation(RequestField.class)).value();
        if (TextUtils.isEmpty(strValue)) {
            strValue = field.getName();
        }
        C6659d.m37882c(f30845a, "setField key:" + strValue, false);
        boolean zIsAccessible = field.isAccessible();
        field.setAccessible(true);
        Object obj = field.get(this);
        if (obj != null) {
            String str = strValue + "=" + URLEncoder.encode(obj.toString(), Constants.UTF_8);
            if (stringBuffer.length() != 0) {
                str = "&" + str;
            }
            stringBuffer.append(str);
        }
        C6659d.m37882c(f30845a, "setField sb:" + ((Object) stringBuffer), false);
        field.setAccessible(zIsAccessible);
    }
}
