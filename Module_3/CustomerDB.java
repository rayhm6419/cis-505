package Module_3;

public class CustomerDB {
    public static Customer getCustomer(Integer id){
        if (id == 1007){
            return new Customer("Coco", "Alameda Home", "Alameda", "98004");
        }
        else if(id == 1008){
            return new Customer("Cici", "San Loleandro Home", "San Loleandro", "98005");
        }
        else if (id == 1009){
            return new Customer("Caca", "Bellevue Home", "Bellevue", "98006");
        }
        else{
            return new Customer();
        }

    }
}