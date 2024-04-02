public class CustomerDB {
    public Customer getCustoemr (int id){
        if (id == 1007){
            return new Customer("Raymond", "123st", "Bellevue", "98004");
        }
        else if(id == 1008){
            return new Customer("Aoshine", "456st", "Seattle", "98006");
        }else if (id == 1009){
            return new Customer("Karen", "333st", "Kent", "98704");
        }else{
            return new Customer();
        }
    }
}
