public class Ticket {

    private int raw;
    private int seat;
    private double price;
    Person person;

    public Ticket(int raw,int seat,double price,Person person){
        this.raw=raw;
        this.seat=seat;
        this.price=price;
        this.person=person;
    }
    public void get_ticket() {
        System.out.println(this.raw);
        System.out.println(this.seat);
        System.out.println(this.price);
        System.out.println(person.getName());
        System.out.println(person.getSurname());
        System.out.println(person.getEmail());
    }
    public Person getPerson(){
        return person;
    }
    public int getRow(){
        return raw;
    }
    public int getSeat(){
        return seat;
    }
    public double getPrice() {
        return price;
    }
}






