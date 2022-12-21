import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Drug> drugs = new ArrayList<>();
    static ArrayList<SoldDrug> soldDrugs =  new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        System.out.println("a. Sold Drug");
        System.out.println("b. Drug");
        System.out.println("c. Display");
        System.out.println("d. Exit\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print(">> ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "a":
                System.out.println("\ta. sell drug");
                System.out.println("\tb. display sold drugs");
                System.out.println("\tc. Exit\n");
                System.out.print(">> ");
                String cho = scanner.nextLine();
                switch (cho) {
                    case "a":
                        sellDrug();
                        break;
                    case "b":
                        listSoldDrugs();
                        break;
                    case "c":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please Enter valid choice!");
                        menu();
                }
                break;
            case "b":
                System.out.println("\ta. new drug");
                System.out.println("\tb. display drugs");
                System.out.println("\tc. search drugs");
                System.out.println("\td. Get drug information");
                System.out.println("\te. Exit\n");
                System.out.print(">> ");
                String ch1 = scanner.nextLine();
                switch (ch1) {
                    case "a":
                        addNewDrug();
                        break;
                    case "b":
                        listDrugs();
                        break;
                    case "c":
                        searchDrug("drug");
                        break;
                    case "d":
                        getDrugInfo("drug");
                        break;
                    case "e":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please Enter valid choice!");
                        menu();
                }
                break;
            case "c":
                System.out.println("\ta. Display drug");
                System.out.println("\tb. display sold drugs");
                System.out.println("\tc. Remove sold drugs");
                System.out.println("\td. search sold drugs");
                System.out.println("\te. get sold drugs info");
                System.out.println("\tf. Show Total Quantity");
                System.out.println("\tg. Exit\n");
                System.out.print(">> ");
                String ch2 = scanner.nextLine();
                switch (ch2) {
                    case "a":
                        listDrugs();
                        break;
                    case "b":
                        listSoldDrugs();
                        break;
                    case "c":
                        removeSoldDrug();
                        break;
                    case "d":
                        searchDrug("soldDrug");
                        break;
                    case "e":
                        getDrugInfo("soldDrug");
                        break;
                    case "f":
                        showTotalQuantity();
                        break;
                    case "g":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please Enter valid choice!");
                        menu();
                }
                break;
            case "d":
                System.exit(0);
                break;
            default:
                System.out.println("Please Enter valid choice!");
                menu();
        }
    }

    static void addNewDrug() {
        Drug drug = new Drug();
        System.out.println("Enter Drug's Information to add new ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Drug Name >> ");
        drug.setDrugName(scanner.nextLine());
        System.out.print("Chemical Name >> ");
        drug.setChemicalName(scanner.nextLine());
        System.out.print("Chemical Composition >> ");
        drug.setChemicalComposition(scanner.nextLine());
        System.out.print("Manufacture Date >> ");
        drug.setManufactureDate(scanner.nextLine());
        System.out.print("Expire Date >> ");
        drug.setExpireDate(scanner.nextLine());
        System.out.print("Quantity >> ");
        drug.setQuantity(scanner.nextLine());
        System.out.print("Category >> ");
        drug.setCategory(scanner.nextLine());

        drugs.add(drug);

        menu();
    }
    static void getNewDrug() {}
    static void getSoldDrug() {

    }
    static void sellDrug() {
        SoldDrug soldDrug = new SoldDrug();
        System.out.println("Enter Drug's Information to be sold ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Chemical Name >> ");
        soldDrug.setChemicalName(scanner.nextLine());
        System.out.print("Country of Origin >> ");
        soldDrug.setCountryOfOrigin(scanner.nextLine());
        System.out.print("Sold Date >> ");
        soldDrug.setSoldDate(scanner.nextLine());
        System.out.print("Quantity >> ");
        soldDrug.setQuantity(scanner.nextLine());
        System.out.print("Unit Price >> ");
        soldDrug.setUnitPrice(scanner.nextLine());

        soldDrugs.add(soldDrug);

        menu();
    }
    static void searchDrug(String type) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nType to search drugs ....");
        String query = scanner.nextLine();

        if(type.equals("drug")) {
            //search for drug array list and display
        } else {
//            search for sold drug array list
        }

        menu();
    }
    static void removeSoldDrug() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Sell no of sold drugs to be removed ....");
        String sellno = scanner.nextLine();
        try {
            Integer.parseInt(sellno);
        } catch (Exception e) {
            System.out.println("Please enter valid Number");
        }

        //search for sold drugs based on sellNo and remove it
//        soldDrugs.remove(sellNO);

        menu();
    }
    static void listDrugs() {
        System.out.println("==========List of Available Drugs=========\n");
        System.out.print("Name\tChemical Name\tChamical Composition\tManufacture Date\t");
        System.out.println("Expire Date\tQuantity\tCategory\n");

        for (Drug drug: drugs) {
            System.out.println(drug.getDrugName()+"\t"+
                    drug.getChemicalName()+"\t"+
                    drug.getChemicalComposition()+"\t"+
                    drug.getManufactureDate()+"\t"+
                    drug.getExpireDate()+"\t"+
                    drug.getQuantity()+"\t"+
                    drug.getCategory()+"\t"
            );
        }

    }
    static void listSoldDrugs() {
        System.out.println("==========List of Available Drugs=========\n");
        System.out.print("Sell N0\tChemical Name\tCountry of Origin\t");
        System.out.println("Sold Date\tQuantity\tUnit Price\n");

        for (SoldDrug soldDrug: soldDrugs) {
            System.out.println(soldDrug.getSellNo()+"\t"+
                    soldDrug.getChemicalName()+"\t"+
                    soldDrug.getCountryOfOrigin()+"\t"+
                    soldDrug.getSoldDate()+"\t"+
                    soldDrug.getQuantity()+"\t"+
                    soldDrug.getUnitPrice()+"\t"
            );
        }
    }
    static void showTotalQuantity() {
        int sum = 0;
        for(Drug drug: drugs) {
            sum += drug.getQuantity();
        }

        System.out.println("Total Quantity : "+sum);
    }
    static void getDrugInfo(String type) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nType to search drugs ....");
        String query = scanner.nextLine();

        if(type.equals("drug")) {
            //search for drug array list and display
        } else {
//            search for sold drug array list
        }

        menu();
    }

}


class Drug {
    private String drugName;
    private String chemicalName;
    private String chemicalComposition;
    private Date manufactureDate;
    private Date expireDate;
    private int quantity;
    private String category;

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public String getChemicalComposition() {
        return chemicalComposition;
    }

    public void setChemicalComposition(String chemicalComposition) {
        this.chemicalComposition = chemicalComposition;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        Date date = SoldDrug.parseToDate(manufactureDate);
        this.manufactureDate = date;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        Date date = SoldDrug.parseToDate(expireDate);
        this.expireDate = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {

        try {
            Integer.parseInt(quantity);
        } catch (Exception e) {
            try {
                throw new Exception("Please Enter a valid quantity!");
            } catch (Exception e1) {
                e.printStackTrace();
            }
        }
        if(Integer.parseInt(quantity) < 0) {
            try {
                throw new Exception("Quantity Cannot be less than 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.quantity = Integer.parseInt(quantity);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

class SoldDrug {
    static private int sellNo = 1;
    private String chemicalName;
    private String countryOfOrigin;
    private Date soldDate;
    private int quantity;
    private float unitPrice;

    public SoldDrug() {
        this.sellNo++;
    }

    public int getSellNo() {
        return sellNo;
    }

    public void setSellNo(int sellNo) {
        this.sellNo = sellNo;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(String soldDate) {
        parseToDate(soldDate);
        Date date = null;
        this.soldDate = date;
    }

    static Date parseToDate(String soldDate) {
        int day = Integer.parseInt(soldDate.substring(0, 2)); //22-05-2012
        int month = Integer.parseInt(soldDate.substring(3, 5)); //22-05-2012
        int year = Integer.parseInt(soldDate.substring(6, soldDate.length())); //22-05-2012
        Date date = null;
        try {
            date = new Date(day, month, year);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        try {
            Integer.parseInt(quantity);
        } catch (Exception e) {
            try {
                throw new Exception("Please Enter a valid quantity!");
            } catch (Exception e1) {
                e.printStackTrace();
            }
        }
        if (Integer.parseInt(quantity) < 0) {
            try {
                throw new Exception("Quantity Cannot be less than 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.quantity = Integer.parseInt(quantity);
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        try {
            Float.parseFloat(unitPrice);
        } catch (Exception e) {
            try {
                throw new Exception("Please Enter a valid quantity!");
            } catch (Exception e1) {
                e.printStackTrace();
            }
        }
        if (Integer.parseInt(unitPrice) < 0) {
            try {
                throw new Exception("Quantity Cannot be less than 0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.unitPrice = Integer.parseInt(unitPrice);
    }
}

