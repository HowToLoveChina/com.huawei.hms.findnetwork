package p336he;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import com.huawei.hicloud.sync.R$drawable;
import com.huawei.hicloud.sync.R$string;
import java.lang.reflect.InvocationTargetException;
import p514o9.C11839m;

/* renamed from: he.h */
/* loaded from: classes3.dex */
public class C10157h {
    /* renamed from: a */
    public void m63312a(Context context, Class cls) {
        String string = context.getString(R$string.hisync_name);
        Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(R$drawable.icon_cloud_space_share)).getBitmap();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClass(context, cls);
        intent.addCategory("android.intent.category.LAUNCHER");
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        C11839m.m70688i("DesktopIconUtil", "isRequestPinShortcutSupported : " + m63313b(shortcutManager));
        if (m63313b(shortcutManager)) {
            ShortcutInfo.Builder builderM63316e = m63316e(new ShortcutInfo.Builder(context, "Create desktop icon").setIcon(Icon.createWithBitmap(bitmap)).setActivity(new ComponentName("com.huawei.hidisk", cls.getName())).setIntent(intent), string);
            if (builderM63316e == null) {
                C11839m.m70687e("DesktopIconUtil", "ShortcutInfo.Builder is null, Shortcut creation failed ");
                return;
            } else {
                m63315d(builderM63316e.build(), null, shortcutManager);
                return;
            }
        }
        if (m63314c(context, "com.android.launcher.action.INSTALL_SHORTCUT")) {
            Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent2.putExtra("android.intent.extra.shortcut.NAME", string);
            intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
            context.sendBroadcast(intent2);
        }
    }

    /* renamed from: b */
    public final boolean m63313b(ShortcutManager shortcutManager) {
        try {
            return ((Boolean) ShortcutManager.class.getMethod("isRequestPinShortcutSupported", new Class[0]).invoke(shortcutManager, new Object[0])).booleanValue();
        } catch (IllegalAccessException e10) {
            C11839m.m70687e("DesktopIconUtil", "IllegalAccessException isRequestPinShortcutSupported: " + e10.toString());
            return false;
        } catch (IllegalArgumentException e11) {
            C11839m.m70687e("DesktopIconUtil", "IllegalArgumentException isRequestPinShortcutSupported: " + e11.toString());
            return false;
        } catch (NoSuchMethodException e12) {
            C11839m.m70687e("DesktopIconUtil", "NoSuchMethodException isRequestPinShortcutSupported: " + e12.toString());
            return false;
        } catch (InvocationTargetException e13) {
            C11839m.m70687e("DesktopIconUtil", "InvocationTargetException isRequestPinShortcutSupported: " + e13.toString());
            return false;
        }
    }

    /* renamed from: c */
    public boolean m63314c(Context context, String str) {
        boolean z10 = context.getPackageManager().queryBroadcastReceivers(new Intent(str), 0) != null ? !r0.isEmpty() : false;
        C11839m.m70687e("DesktopIconUtil", "bFlag is: " + Boolean.toString(z10));
        return z10;
    }

    /* renamed from: d */
    public final Boolean m63315d(ShortcutInfo shortcutInfo, IntentSender intentSender, ShortcutManager shortcutManager) {
        try {
            Boolean bool = (Boolean) ShortcutManager.class.getMethod("requestPinShortcut", ShortcutInfo.class, IntentSender.class).invoke(shortcutManager, shortcutInfo, intentSender);
            if (bool != null) {
                return bool;
            }
        } catch (IllegalAccessException e10) {
            C11839m.m70687e("DesktopIconUtil", "IllegalAccessException requestPinShortcut: " + e10.toString());
        } catch (IllegalArgumentException e11) {
            C11839m.m70687e("DesktopIconUtil", "IllegalArgumentException requestPinShortcut: " + e11.toString());
        } catch (NoSuchMethodException e12) {
            C11839m.m70687e("DesktopIconUtil", "NoSuchMethodException requestPinShortcut: " + e12.toString());
        } catch (InvocationTargetException e13) {
            C11839m.m70687e("DesktopIconUtil", "InvocationTargetException requestPinShortcut: " + e13.toString());
        }
        return Boolean.FALSE;
    }

    /* renamed from: e */
    public ShortcutInfo.Builder m63316e(ShortcutInfo.Builder builder, String str) {
        try {
            return (ShortcutInfo.Builder) ShortcutInfo.Builder.class.getMethod("setShortLabel", CharSequence.class).invoke(builder, str);
        } catch (IllegalAccessException e10) {
            C11839m.m70687e("DesktopIconUtil", "IllegalAccessException setShortLabel: " + e10.toString());
            return null;
        } catch (IllegalArgumentException e11) {
            C11839m.m70687e("DesktopIconUtil", "IllegalArgumentException setShortLabel: " + e11.toString());
            return null;
        } catch (NoSuchMethodException e12) {
            C11839m.m70687e("DesktopIconUtil", "NoSuchMethodException setShortLabel: " + e12.toString());
            return null;
        } catch (InvocationTargetException e13) {
            C11839m.m70687e("DesktopIconUtil", "InvocationTargetException setShortLabel: " + e13.toString());
            return null;
        }
    }
}
