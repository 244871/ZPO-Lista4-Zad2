import java.util.ArrayList;

public class Koszyk {

    private ArrayList<Produkt> order;

    public Koszyk(ArrayList<Produkt> order) {
        this.order = order;
    }

    public Koszyk() {
        order = new ArrayList<>();
    }

    public void add(Produkt produkt) {
        order.add(produkt);
    }

    public void remove(Produkt produkt) throws ProductNotFoundException {
        if (produkt.getQuantity() <= 0) {
            throw new ProductNotFoundException(String.format("Illegal quantity", produkt.getQuantity()));
        }
        else {
            order.remove(produkt);
        }
    }

    public void removeAll(){
        order = new ArrayList<>();
    }

    public double value(){
        double value=0;
        for(Produkt produkt:order){
            value+=produkt.getPrice()*produkt.getQuantity();
        }
        return value;
    }


    public int getNumberOfElements() {
        return order.size();
    }

    public boolean contains(Produkt produktSprawdzany){
        return order.contains(produktSprawdzany);
    }

    public boolean isEmpty() {
        int numberOfElements = order.size();
        return numberOfElements == 0;
    }



}
