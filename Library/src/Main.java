public class Main {
    public static void main(String[] args) {
        AdministratorLibraryImp admin = new AdministratorLibraryImp("Ksenia", 1996);
        Supplier supplier = new SupplierImp("Justin", 1991);
        Reader reader = new ReaderImp("Max", 1994);

        admin.orderBook(supplier);
        supplier.supplyingBook(100);
        reader.takeBook(1);
        reader.takeBook(2);
        reader.takeBook(3);
//        Supplier sp1 = new SupplierImp();
//        Supplier sp2 = new SupplierImp();
//        sp1.supplyingBook(21);
//        sp2.supplyingBook(2);

    }
}
