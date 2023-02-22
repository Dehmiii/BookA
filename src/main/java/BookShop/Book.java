
package BookShop;


import java.util.ArrayList;
import java.util.Scanner;

public class Book {

    static ArrayList<Book> booksList = new ArrayList();  
    private String name;
    private String author;
    private double price;

    Book() {

    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) { 
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static void displayBooks() { 
        ArrayList<Book> listBook = Book.booksList;
        if (!listBook.isEmpty()) { 
            System.out.println("\n  ---- Books Storage ----");
            for (Book book : listBook) {

                System.out.println("   Book   : " + book.getName());
                System.out.println("   Author : " + book.getAuthor());
                System.out.println("   Price  : " + book.getPrice());
                System.out.println("  -----------------------");
            }
            System.out.println();

        } else {

            System.out.println("\n  ---- Books Storage ----");
            System.out.println("There Is No Books To Display!");
            System.out.println("  -----------------------\n");

        }
    }

    public static void addBooks(Scanner scan) { 
        System.out.print("* Enter The Count Of Book : ");
        int countBook = scan.nextInt();
        System.out.println();
        if (countBook < 0) {
            System.out.println("Not Valid, the count must be > 0");
        } else {
            for (int i = 1; i <= countBook; i++) {
                System.out.println("   -------Book " + (i) + "-------"); 
                System.out.print("* Enter Book Name : ");
                String nameBook = scan.next();  
                System.out.print("* Enter Book Author : ");
                String authorBook = scan.next();
                System.out.print("* Enter Book Price : ");
                double priceBook = scan.nextDouble();

                Book b = new Book();
                b.setName(nameBook);
                b.setAuthor(authorBook);
                b.setPrice(priceBook);

                Book.booksList.add(b);
                System.out.println("   -------------------\n");
            }
        }

    }

    public static boolean editBook(Book newBook, Book oldBook) {
        if (booksList.size() > 0) {
            int index = -1;
            for (int i = 0; i < booksList.size(); i++) {
                if (booksList.get(i).getName().equals(oldBook.getName())) { 
                    index = i;
                    break;
                }
            }

            if (index != -1) {  
                booksList.get(index).setName(newBook.getName()); 
                booksList.get(index).setAuthor(newBook.getAuthor());
                booksList.get(index).setPrice(newBook.getPrice());

                return true;
            }
        }

        return false;
    }

    public static void editBooks(Scanner scan) { 
        boolean Menu = true;
        while (Menu) {
            System.out.println();
            System.out.println("   ---- Update Menu ----");
            System.out.println("(1) Update Book Name");
            System.out.println("(2) Update Book Author");
            System.out.println("(3) Update Book price");
            System.out.println("(4) Back To Main Menu");
            System.out.println("   -------------------");
            System.out.print("* Enter Your Choice : ");
            int choiceNum1 = scan.nextInt();
            System.out.println("   --------------------\n");

            switch (choiceNum1) {
                case 1:  
                    System.out.println("   --------------------");
                    System.out.print("* Enter Book Name : ");
                    String bookName = scan.next();
                    System.out.println("   --------------------");
                    Book oldBook = Book.getBookByName(bookName);
                    Book newBook = Book.getBookByName(bookName);
                    if (oldBook == null) {
                        System.out.println("   --------------------");
                        System.out.println("  No Book With This Name !");
                        System.out.println("   --------------------");
                    } else {
                        System.out.print("* Enter Book New Name : ");
                        String newName = scan.next();
                        System.out.println("   --------------------\n");

                        newBook.setName(newName);
                        if (Book.editBook(newBook, oldBook)) {
                            System.out.println("   --------------------");
                            System.out.println("       Updated Done ");
                            System.out.println("   --------------------");
                        } else {
                            System.out.println("   --------------------");
                            System.out.println("       Updated Fails ");
                            System.out.println("   --------------------");

                        }

                    }

                    break;

                case 2: 
                    System.out.println("   --------------------");
                    System.out.print("* Enter book name : ");
                    String bookName1 = scan.next();
                    System.out.println("   --------------------");
                    Book oldBook1 = Book.getBookByName(bookName1);
                    Book newBook1 = Book.getBookByName(bookName1);
                    if (oldBook1 == null) {
                        System.out.println("   --------------------");
                        System.out.println("  No Book With This Name !");
                        System.out.println("   --------------------");
                    } else {
                        System.out.print("* Enter Book New Author : ");
                        String newAuthor = scan.next();
                        System.out.println("   --------------------\n");

                        newBook1.setAuthor(newAuthor);
                        if (Book.editBook(newBook1, oldBook1)) {
                            System.out.println("   --------------------");
                            System.out.println("       Updated Done ");
                            System.out.println("   --------------------");
                        } else {
                            System.out.println("   --------------------");
                            System.out.println("       Updated Fails ");
                            System.out.println("   --------------------");

                        }

                    }

                    break;
                case 3: 
                    System.out.println("   --------------------");
                    System.out.print("* Enter Book Name : ");
                    String bookName2 = scan.next();
                    System.out.println("   --------------------");
                    Book oldBook2 = Book.getBookByName(bookName2);
                    Book newBook2 = Book.getBookByName(bookName2);
                    if (oldBook2 == null) {
                        System.out.println("   --------------------");
                        System.out.println("  No Book With This Name !");
                        System.out.println("   --------------------");
                    } else {
                        System.out.print("* Enter Book New Price : ");
                        double newPrice = scan.nextDouble();
                        System.out.println("   --------------------\n");

                        newBook2.setPrice(newPrice);
                        if (Book.editBook(newBook2, oldBook2)) {
                            System.out.println("   --------------------");
                            System.out.println("       Updated Done ");
                            System.out.println("   --------------------");
                        } else {
                            System.out.println("   --------------------");
                            System.out.println("       Updated Fails ");
                            System.out.println("   --------------------");

                        }

                    }

                    break;

                case 4: 
                    Menu = false;

                    break;
            }
        }
    }

    public static Book getBookByAuthor(String author) { 

        for (Book book : booksList) {
            if (book.author.equals(author)) {
                return book;
            }
        }

        return null;

    }

    public static Book getBookByName(String name) { 

        for (Book book : booksList) {
            if (book.name.equals(name)) {
                return book;
            }
        }

        return null;

    }


    public static boolean deleteBook(Book book) {  
        if (!booksList.isEmpty()) {
            booksList.remove(book);
            return true;
        }
        return false;
    }

    public static void deleteThisBook(Scanner scanner) {   
        System.out.print("* Enter Book Name : ");
        String bookName = scanner.next();
        System.out.println("   --------------------");
        Book book = Book.getBookByName(bookName);
        if (book == null) {
            System.out.println();
            System.out.println("   --------------------");
            System.out.println("     No Book Founded ! ");
            System.out.println("   --------------------\n");

        } else {
            // delete
            if (Book.deleteBook(book)) {
                System.out.println();
                System.out.println("   --------------------");
                System.out.println("       Deleted Done ");
                System.out.println("   --------------------");
                System.out.println();

            } else {
                System.out.println("   --------------------");
                System.out.println("       Deleted Fails ");
                System.out.println("   --------------------");
                System.out.println();

            }
        }
    }

    public static void searchBook(Scanner scanner) { 

        Scanner x = new Scanner(System.in);

        boolean Menu = true;
        while (Menu) {
            System.out.println();
            System.out.println("   ---- Search Menu ----");
            System.out.println("(1) Search By Book Name");
            System.out.println("(2) Search By Author Name");
            System.out.println("(3) Back To Main Menu");
            System.out.println("   ---------------------");
            System.out.print("* Enter your choice: ");
            int choiceNum = x.nextInt();
            System.out.println("   ---------------------");

            switch (choiceNum) {

                case 1: 

                    System.out.print("* Enter Book Name : ");
                    String bookName = scanner.next();
                    System.out.println("   ---------------------");
                    Book searchBook = Book.getBookByName(bookName);
                    if (searchBook == null) {
                        // System.out.println();
                        System.out.println("\n   --------------------");
                        System.out.println("     No Book Founded ! ");
                        System.out.println("   --------------------");
                    } else {
                        System.out.println("\n   ------ Result -----");
                        System.out.println("   Book   : " + searchBook.getName());
                        System.out.println("   Author : " + searchBook.getAuthor());
                        System.out.println("   Price  : " + searchBook.getPrice());
                        System.out.println("   --------------------");
                    }
                    break;
                case 2: 
                    System.out.print("- Enter Author Name : ");
                    String bookName2 = scanner.next();
                    System.out.println("   ---------------------");
                    Book searchBook2 = Book.getBookByAuthor(bookName2);
                    if (searchBook2 == null) {
                        // System.out.println();
                        System.out.println("\n   --------------------");
                        System.out.println("     No Book Founded ! ");
                        System.out.println("   --------------------\n");
                    } else {
                        System.out.println("\n   ------ Result -----");
                        System.out.println("   Book   : " + searchBook2.getName());
                        System.out.println("   Author : " + searchBook2.getAuthor());
                        System.out.println("   Price  : " + searchBook2.getPrice());
                        System.out.println("   --------------------");
                    }
                    break;

                case 3: 
                    Menu = false;
                    System.out.println();

                    break;
            }

        }

    }

    public static void existApp() {
        System.out.println("\n   ---- Finsh Program ----");
        System.exit(0);
    }

}
