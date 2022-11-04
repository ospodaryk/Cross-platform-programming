import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {
    private int idOrder;
    private LocalTime time_delivery;
    private List<Pizza> orderList = new ArrayList<>();
    private boolean done;

    public Customer(int idOrder, LocalTime time_delivery, List<Pizza> orderList, boolean done) {
        this.idOrder = idOrder;
        this.time_delivery = time_delivery;
        this.orderList = orderList;
        this.done = done;
    }
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
    public LocalTime getTime_delivery() {
        return time_delivery;
    }

    public void setTime_delivery(LocalTime time_delivery) {
        this.time_delivery = time_delivery;
    }

    public List<Pizza> getOrderList() {
        return orderList;
    }
    public int getOrderListSize() {
        return orderList.size();
    }
    public boolean existName(String name) {
        for (int i = 0; i < orderList.size(); i++) {
            if(orderList.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void setOrderList(List<Pizza> orderList) {
        this.orderList = orderList;
    }


    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "idOrder=" + idOrder +
                ", time_delivery=" + time_delivery +
                ", orderList=" + orderList +
                ", done=" + done +
                '}';
    }
}
