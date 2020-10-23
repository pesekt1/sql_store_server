package db_demo.db_demo.repository;

import db_demo.db_demo.model.OrderStatuses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusesRepository extends JpaRepository<OrderStatuses, Byte> {
}
