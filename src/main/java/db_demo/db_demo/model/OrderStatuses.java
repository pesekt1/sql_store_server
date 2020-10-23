package db_demo.db_demo.model;

import javax.persistence.*;

@Entity
@Table(name = "order_statuses", schema = "sql_store")
public class OrderStatuses {
    private byte orderStatusId;
    private String name;

    @Id
    @Column(name = "order_status_id")
    public byte getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(byte orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderStatuses that = (OrderStatuses) o;

        if (orderStatusId != that.orderStatusId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) orderStatusId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
