package com.yhr.api.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.api.domain
 * @Author: yang
 * @CreateTime: 2019-03-27 10:21
 * @Description: 产品相关 rpc 请求对象
 */
public class ProductRpcReq {

    private List<String> idList;
    private BigDecimal minRewardRate;
    private BigDecimal maxRewardRate;
    private List<String> statusList;
    /**
     * 注意 不能使用pageable 因为jsonrpc不能传复杂对象
     * 所以这里就把pageable 分为
     * page,pageSize,direction,orderyBy
     * 但又因为不能传复杂对象 我们让接口返回List
     * 然后在实现端给它写构造方法
     *
     */


    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public BigDecimal getMinRewardRate() {
        return minRewardRate;
    }

    public void setMinRewardRate(BigDecimal minRewardRate) {
        this.minRewardRate = minRewardRate;
    }

    public BigDecimal getMaxRewardRate() {
        return maxRewardRate;
    }

    public void setMaxRewardRate(BigDecimal maxRewardRate) {
        this.maxRewardRate = maxRewardRate;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    @Override
    public String toString() {
        return "ProductRpcReq{" +
                "idList=" + idList +
                ", minRewardRate=" + minRewardRate +
                ", maxRewardRate=" + maxRewardRate +
                ", statusList=" + statusList +
                '}';
    }
}
