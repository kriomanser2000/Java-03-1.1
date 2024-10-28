import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxDatabase
{
    private Map<String, Person> database = new HashMap<>();
    public void printAll()
    {
        database.forEach((id, person) -> System.out.println("ID: " + id + " " + person));
    }
    public void printByCode(String code)
    {
        if (database.containsKey(code))
        {
            System.out.println("ID: " + code + " " + database.get(code));
        }
        else
        {
            System.out.println("No record found for code: " + code);
        }
    }
    public void printByFineType(String type)
    {
        database.values().stream()
                .filter(person -> person.getFines().stream().anyMatch(fine -> fine.getType().equals(type)))
                .forEach(System.out::println);
    }
    public void printByCity(String city)
    {
        database.values().stream()
                .filter(person -> person.getFines().stream().anyMatch(fine -> fine.getCity().equals(city)))
                .forEach(System.out::println);
    }
    public void addPerson(String code, String name)
    {
        database.putIfAbsent(code, new Person(name));
    }
    public void addFine(String code, Fine fine)
    {
        Person person = database.get(code);
        if (person != null)
        {
            person.addFine(fine);
        }
        else
        {
            System.out.println("No person found with code: " + code);
        }
    }
    public void removeFine(String code, Fine fine)
    {
        Person person = database.get(code);
        if (person != null)
        {
            person.getFines().remove(fine);
        }
        else
        {
            System.out.println("No person found with code: " + code);
        }
    }
    public void updatePerson(String code, String newName, List<Fine> newFines)
    {
        Person person = database.get(code);
        if (person != null)
        {
            person = new Person(newName);
            newFines.forEach(person::addFine);
            database.put(code, person);
        }
        else
        {
            System.out.println("No person found with code: " + code);
        }
    }
    public static void main(String[] args)
    {
        TaxDatabase db = new TaxDatabase();
        db.addPerson("12345", "John Doe");
        db.addFine("12345", new Fine("Speeding", "Kyiv", 500.0));
        db.addFine("12345", new Fine("Parking", "Lviv", 200.0));
        db.addPerson("67890", "Jane Smith");
        db.addFine("67890", new Fine("Speeding", "Kyiv", 300.0));
        db.printAll();
        db.printByCode("12345");
        db.printByFineType("Speeding");
        db.printByCity("Kyiv");
    }
}
