
package BookShop;


import java.util.Scanner;

public class BookShopTest {

    public static void main(String[] args) {
        System.out.println("   -------------------");
        System.out.println("Welcome To Book Shop Program");
        System.out.println("   -------------------\n");
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("   ---- Main Menu ----");
            System.out.println("(1) Display Books");
            System.out.println("(2) Add New Book ");
            System.out.println("(3) Delete Book");
            System.out.println("(4) Update Book");
            System.out.println("(5) Search Book");
            System.out.println("(6) Exit");
            System.out.println("   -------------------");
            System.out.print("* Enter Your Choice : ");
            int choiceNum = scan.nextInt();
            System.out.println("   -------------------");
            switch (choiceNum) { 
                case 1: 
                    Book.displayBooks(); // يروح للمثيود هذي ويعرض الكتب
                    break;
                case 2: 
                    Book.addBooks(scan); // يروح للمثيود هذي ويخلي المستخدم يضيف كتب
                    break;
                case 3:
                    Book.deleteThisBook(scan); // يروح للمثيود هذي ويخلي المستخدم يحذف الكتاب
                    break;
                case 4:
                    Book.editBooks(scan); // يروح للميثود ويخلي المستخدم يجري تعديلات عالكتب
                    break;
                case 5:
                    Book.searchBook(scan); // يروح للمثيود ويخلي المستخد يبحث عن كتاب
                    break;
                case 6:
                    Book.existApp(); // ينهي البرنامج
                    break;
            }

        }

    }
}