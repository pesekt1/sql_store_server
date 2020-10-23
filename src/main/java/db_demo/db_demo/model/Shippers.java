package db_demo.db_demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shippers {
    private short shipperId;
    private String name;

    @Id
    @Column(name = "shipper_id")
    public short getShipperId() {
        return shipperId;
    }

    public void setShipperId(short shipperId) {
        this.shipperId = shipperId;
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

        Shippers shippers = (Shippers) o;

        if (shipperId != shippers.shipperId) return false;
        if (name != null ? !name.equals(shippers.name) : shippers.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) shipperId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
