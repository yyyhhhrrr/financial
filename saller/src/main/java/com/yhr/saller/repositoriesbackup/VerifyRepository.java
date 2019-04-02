package com.yhr.saller.repositoriesbackup;

import com.yhr.entity.VerificationOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: financial
 * @BelongsPackage: com.yhr.saller.repositories
 * @Author: yang
 * @CreateTime: 2019-03-28 16:36
 * @Description: ${Description}
 */
public interface VerifyRepository extends JpaRepository<VerificationOrder,String>, JpaSpecificationExecutor<VerificationOrder> {

    /**
     * 查询某段时间[start,end) 内的某个渠道chanid 的对账数据
     * @param chanId
     * @param start
     * @param end
     * @return 对账数据列表
     */
    @Query(value = "select CONCAT_WS(\"|\",order_id,outer_order_id,chan_id,chan_user_id,product_id,order_type,amount,DATE_FORMAT(create_at,'%Y-%m-%d %H:%i:%s'))\n" +
            "from order_t where order_status='success' and chan_id=?1 and create_at >=?2 and create_at<?3",nativeQuery = true)
    List<String> queryVerificationOrders(String chanId, Date start, Date end);

    /**
     * 长款 （在order_t 有 在 verification_order 没有）
     * @param chanId
     * @param start
     * @param end
     * @return
     */
    @Query(value = "select t.order_id from order_t t left join verification_order v on t.chan_id=?1 and t.outer_order_id=v.order_id where v.order_id is null and t.create_at>=?2 and t.create_at<?3",nativeQuery = true)
    List<String> queryExcessOrders(String chanId, Date start, Date end);

    /**
     * 漏单 （在verification_order 有 在order_t没有）
     * @param chanId
     * @param start
     * @param end
     * @return
     */
    @Query(value = "select v.order_id from verification_order v left join  order_t  t on t.chan_id=?1 and v.outer_order_id=t.order_id where t.order_id is null and v.create_at>=?2 and v.create_at<?3",nativeQuery = true)
    List<String> queryMissOrders(String chanId, Date start, Date end);

    /**
     * 不一致 比较两个concat_was
     * @param chanId
     * @param start
     * @param end
     * @return
     */
    @Query(value = "select t.order_id from order_t t  join verification_order v on t.chan_id=?1 and t.outer_order_id=v.order_id where \n" +
            "CONCAT_WS('|',t.chan_id,t.chan_user_id,t.product_id,t.order_type,t.amount,DATE_FORMAT(t.create_at,'%Y-%m-%d %H:%i:%s')) !=CONCAT_WS('|',v.chan_id,v.chan_user_id,v.product_id,v.order_type,v.amount,DATE_FORMAT(v.create_at,'%Y-%m-%d %H:%i:%s'))and t.create_at>=?2 and t.create_at<?3",nativeQuery = true)
    List<String> queryDifferentOrders(String chanId, Date start, Date end);
}
