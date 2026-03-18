package assignments.assignment16_03.onlineOrderProcessingAndDispatchManager;

public class PriorityOrder extends Order{
    private int deliveryDays;
    private double deliveryCharge;

    public PriorityOrder(int id, String name, double amount, int days, double charge) {
        amount += charge;
//        System.out.println(amount);
        super(id, name, amount);
        this.deliveryDays = days;
        this.deliveryCharge = charge;
    }

    @Override
    public String displayOrder() {
        return super.displayOrder() + ", Delivered in " + deliveryDays + " days, Extra Charge: " + deliveryCharge;
    }
}
