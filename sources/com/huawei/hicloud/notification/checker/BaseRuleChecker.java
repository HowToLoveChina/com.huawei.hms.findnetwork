package com.huawei.hicloud.notification.checker;

import android.os.Bundle;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import java.util.Objects;

/* loaded from: classes6.dex */
public abstract class BaseRuleChecker implements Comparable<BaseRuleChecker> {
    protected int mPriority = -1;

    public abstract boolean check(Bundle bundle);

    public abstract boolean check(String str);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mPriority == ((BaseRuleChecker) obj).mPriority;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mPriority));
    }

    public abstract void precheck(NotificationConfig notificationConfig);

    public void setPriority(int i10) {
        this.mPriority = i10;
    }

    @Override // java.lang.Comparable
    public int compareTo(BaseRuleChecker baseRuleChecker) {
        if (this.mPriority == baseRuleChecker.getPriority()) {
            return 0;
        }
        return this.mPriority > baseRuleChecker.getPriority() ? 1 : -1;
    }
}
