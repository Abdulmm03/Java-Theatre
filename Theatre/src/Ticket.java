public class Ticket {
    private int row;
    private int seat;
    private int price;
    private Person person;





    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Ticket(int row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public Ticket(int row, int seat) {
        this.row = row;
        this.seat = seat;
    }

    public void print(){
        System.out.println("Name : " + person.getName());
        System.out.println("Surname : " + person.getSurname());
        System.out.println("E-mail :" + person.getEmail());
        System.out.println("Rownumber : " + row);
        System.out.println("Seatnumber :" + seat);
        System.out.println("Price : $ " + price);
    }

}
