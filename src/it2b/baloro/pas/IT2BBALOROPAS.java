
package it2b.baloro.pas;

import java.util.Scanner;

public class IT2BBALOROPAS {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String response; 
      
      do{
          System.out.println("1. ADD");
          System.out.println("2. VIEW");
          System.out.println("3. UPDATE");
          System.out.println("4. DELETE");
          System.out.println("5. EXIT");
          
          System.out.println("Enter Action: ");
          int action = sc.nextInt();
          IT2BBALOROPAS animals = new IT2BBALOROPAS();
          switch(action){
              case 1:
                  animals.addAnimals();
              break;
              case 2:
                  animals.viewAnimals();
              break;
              case 3:
                  animals.viewAnimals();
                  animals.updateAnimals();
                  animals.viewAnimals();
              break;
              case 4:
                  animals.viewAnimals();
                  animals.deleteAnimals();
                  animals.viewAnimals();
              break;
              
          }
          System.out.println("Do you want to continue? (yes/no): ");
          response = sc.next();
      }while(response.equalsIgnoreCase("yes"));
        System.out.println("Thank you, see you soon!");
    }
    public void addAnimals(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Animal Name: ");
        String aname = sc.next();
        System.out.print("Species: ");
        String aspecies = sc.next();
        System.out.print("Breed: ");
        String abreed = sc.next();
        System.out.print("Animal Size: ");
        String asize = sc.next();

        String sql = "INSERT INTO tbl_animals (a_name, a_species, a_breed, a_size) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, aname, aspecies, abreed, asize);


    }
    private void viewAnimals() {
        config conf = new config();
        String animalsQuery = "SELECT * FROM tbl_animals";
        String[] animalsHeaders = {"Name", "Species", "Breed", "Size"};
        String[] animalsColumns = {"a_name", "a_species", "a_breed", "a_size"};

        conf.viewRecords(animalsQuery, animalsHeaders, animalsColumns);
    }
    private void  updateAnimals(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to update: ");
        int id = sc.nextInt();
        
        System.out.println("New Name: ");
        String naname = sc.next();
        System.out.println("New Species: ");
        String naspecies = sc.next();
        System.out.println("New Breed: ");
        String nabreed = sc.next();
        System.out.println("New Size: ");
        String nasize = sc.next();
        
        String qry = "UPDATE tbl_animals set a_name = ?, a_species = ?, a_breed = ?, a_size = ? WHERE a_id = ?";
        config conf = new config();
        conf.updateRecord(qry, naname, naspecies, nabreed, nasize, id);
        
    }
    private void deleteAnimals(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to Delete: ");
        int id = sc.nextInt();
     
        String qry = "DELETE FROM tbl_animals WHERE a_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
}
    
}
