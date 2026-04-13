package com.example.Revision.Repository;

import com.example.Revision.Entities.Order;
import com.example.Revision.Entities.PK.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
