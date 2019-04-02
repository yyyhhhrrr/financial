package com.yhr.api.events;

import com.yhr.entity.enums.ProductStatus;

import java.io.Serializable;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.api.events
 * @Author: yang
 * @CreateTime: 2019-03-28 10:44
 * @Description: 产品状态事件
 */
public class ProductStatusEvent implements Serializable {


    private String id;
    private ProductStatus status;

    public ProductStatusEvent(String id, ProductStatus status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "ProductStatusEvent{" +
                "id='" + id + '\'' +
                ", status=" + status +
                '}';
    }
}
