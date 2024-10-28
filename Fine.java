import java.util.ArrayList;
import java.util.List;

class Fine
{
    private String type;
    private String city;
    private double amount;
    public Fine(String type, String city, double amount)
    {
        this.type = type;
        this.city = city;
        this.amount = amount;
    }
    public String getType()
    {
        return type;
    }
    public String getCity()
    {
        return city;
    }
    public double getAmount()
    {
        return amount;
    }
    @Override
    public String toString()
    {
        return "Fine{" +
                "type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", amount=" + amount +
                '}';
    }
}
class Person
{
    private String name;
    private List<Fine> fines;
    public Person(String name)
    {
        this.name = name;
        this.fines = new ArrayList<>();
    }
    public String getName()
    {
        return name;
    }
    public List<Fine> getFines()
    {
        return fines;
    }
    public void addFine(Fine fine)
    {
        fines.add(fine);
    }
    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", fines=" + fines +
                '}';
    }
}
