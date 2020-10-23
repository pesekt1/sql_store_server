package db_demo.db_demo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Orders {
    private int orderId;
    private Date orderDate;
    private String comments;
    private Date shippedDate;
    private Customers customersByCustomerId;
    private OrderStatuses orderStatusesByStatus;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "shipped_date")
    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (orderId != orders.orderId) return false;
        if (orderDate != null ? !orderDate.equals(orders.orderDate) : orders.orderDate != null) return false;
        if (comments != null ? !comments.equals(orders.comments) : orders.comments != null) return false;
        if (shippedDate != null ? !shippedDate.equals(orders.shippedDate) : orders.shippedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (shippedDate != null ? shippedDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public Customers getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    public void setCustomersByCustomerId(Customers customersByCustomerId) {
        this.customersByCustomerId = customersByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "order_status_id", nullable = false)
    public OrderStatuses getOrderStatusesByStatus() {
        return orderStatusesByStatus;
    }

    public void setOrderStatusesByStatus(OrderStatuses orderStatusesByStatus) {
        this.orderStatusesByStatus = orderStatusesByStatus;
    }
}
