package com.huawei.cloud.pay.model.reward;

import com.huawei.cloud.pay.model.Response;
import java.util.List;

/* loaded from: classes5.dex */
public class GetRewardsResp extends Response {
    private String cursor;
    private List<Reward> rewards;

    public String getCursor() {
        return this.cursor;
    }

    public List<Reward> getRewards() {
        return this.rewards;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setRewards(List<Reward> list) {
        this.rewards = list;
    }
}
