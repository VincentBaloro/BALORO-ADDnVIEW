
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
          IT2BBALOROPAS sample = new IT2BBALOROPAS();
          switch(action){
              case 1:
                  sample.addAnimals();
              break;
              case 2:
                  sample.viewAnimals();
              break;
          }
          System.out.println("Doo you want to continue? (yes/no): ");
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
}
