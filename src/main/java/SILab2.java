import java.util.List;

class Item {
    String name;
    String barcode; //numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){
        if (allItems == null)//A{
            throw new RuntimeException("allItems list can't be null!");//B
        }

        float sum = 0;//C

        for (int i = 0; i < allItems.size(); i++){//C
            Item item = allItems.get(i);//D
            if (item.getName() == null || item.getName().length() == 0)//E{
                item.setName("unknown");//F
            }
            if (item.getBarcode() != null){//G
                String allowed = "0123456789";//G
                char chars[] = item.getBarcode().toCharArray();//G
                for (int j = 0; j < item.getBarcode().length(); j++){//H
                    char c = item.getBarcode().charAt(j);//H
                    if (allowed.indexOf(c) == -1){//I
                        throw new RuntimeException("Invalid character in item barcode!");//J
                    }
                }
                if (item.getDiscount() > 0)//K{
                    sum += item.getPrice()*item.getDiscount()//M;
                }
                else {//N
                    sum += item.getPrice();
                }
            }
            else {//O
                throw new RuntimeException("No barcode!");
            }
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//p
                sum -= 30;//Q
            }
        }
        //kraj ba for
        if (sum <= payment){//R
            return true;//S
        }
        else {//M
            return false;
        }
    }
}
