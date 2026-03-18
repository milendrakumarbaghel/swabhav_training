package assignments.assignment16_03.onlineOrderProcessingAndDispatchManager;

public class RegularOrder extends Order{
    private int deliveryDays;

    public RegularOrder(int id, String name, double amount, int days) {
        super(id, name,  amount);
        this.deliveryDays = days;
    }

    @Override
    public String displayOrder() {
        return super.displayOrder() + ", Delivered in " + deliveryDays + " days";
    }
}
