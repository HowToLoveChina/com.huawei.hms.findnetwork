package com.huawei.fastengine.fastview.startfastappengine.appmarket;

import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;

/* loaded from: classes5.dex */
public class QueryDetailHanlderRegister {
    private static final String TAG = "QueryDHRegister";
    private static Class<?> handlerCls;

    public static IQueryDetailHandler getHandler() throws IllegalAccessException, InstantiationException {
        String str;
        try {
            Class<?> cls = handlerCls;
            if (cls != null) {
                Object objNewInstance = cls.newInstance();
                if (objNewInstance instanceof IQueryDetailHandler) {
                    return (IQueryDetailHandler) objNewInstance;
                }
                FastViewLogUtils.m28724e(TAG, "getHandler can not get IQueryDetailHandler");
                return null;
            }
        } catch (IllegalAccessException unused) {
            str = "getHandler IllegalAccessException:";
            FastViewLogUtils.m28722d(TAG, str);
            return null;
        } catch (InstantiationException unused2) {
            str = "getHandler InstantiationException:";
            FastViewLogUtils.m28722d(TAG, str);
            return null;
        }
        return null;
    }

    public static void registerHanlder(Class<? extends IQueryDetailHandler> cls) {
        handlerCls = cls;
    }
}
