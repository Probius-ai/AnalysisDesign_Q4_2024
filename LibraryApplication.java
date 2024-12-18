import java.util.ArrayList;
import java.util.Map;

public class LibraryApplication {
    private Library library = new Library("Library");
       
    // 대출자 등록
    public boolean registerBorrower(String name, String birthDate) {
        Borrower br = new Borrower(name, birthDate);
        boolean isDuplicate = library.isDuplicateBorrower(br);

        if (!isDuplicate) {
            library.addBorrower(br);
        } 

        return !isDuplicate;
    }

    // 도서 등록
    public boolean registerBook(String title, String author, int uniqueNumber) {
        Book book = new Book(title, author, uniqueNumber);
        boolean isDuplicate = library.isDuplicateBook(book);
        
        if (!isDuplicate) {
            library.addBook(book);
        } 

        return !isDuplicate;
    }
    
    // 대출 가능한 도서 목록 표시
    public boolean displayLoanableBooks() {
        System.out.println("=== 대출 가능한 도서 목록 ===");
        boolean hasAvailableBooks = false;
        
        for (Book b : library.getBookCollection()) {
            if (b.isAvailable()) { 
                System.out.println(b.toString());
                hasAvailableBooks = true;
            }
        }

        return hasAvailableBooks;
    }

    // 대출중인 도서 목록 표시
    public boolean displayOnLoanBooks() {
        System.out.println("=== 대출중인 도서 목록 ===");
        boolean hasBorrowedBooks = false;

        for (Book book : library.getBookCollection()) {
            if (!book.isAvailable()) {
                System.out.println(book.toString());
                hasBorrowedBooks = true;
            }
        }

        return hasBorrowedBooks;
    }

    // 도서 대출
    public boolean borrowBook(int uniqueNumber, String name, String birthDate) {
        Book b = library.findBookByUniqueNumber(uniqueNumber);
        Borrower br = library.findBorrowerByNameAndBirthDate(name, birthDate);

        if (b != null && br != null && b.isAvailable() && br.isAvailable()) {
            Loan loanForHistory = new Loan(b, br); // 대출 기록용 객체 생성
            Loan loanForSystem = new Loan(b, br); // 시스템용 객체 생성
            library.addLoanToHistory(br, loanForHistory);

            b.setOnLoan(true);
            br.incrementBorrowedBooks();
            library.addLoan(loanForSystem);
            return true;
        }  else {
            return false;
        }
    }
    
    // 도서 반납
    public boolean returnBook(int uniqueNumber, String name, String birthDate) {
        Book b = library.findBookByUniqueNumber(uniqueNumber);
        Borrower br = library.findBorrowerByNameAndBirthDate(name, birthDate);
        Loan loan = library.findLoanByBookAndBorrower(b, br);

        if (loan != null) {
            loan.deleteLink();
            return true;
        } else {
            return false;
        }
    }

    // LibraryApplication 클래스
    public boolean displayLoanHistory(String name, String birthDate) {
        Borrower br = library.findBorrowerByNameAndBirthDate(name, birthDate);

        if (br == null) {
            System.out.println("해당 대출자를 찾을 수 없습니다.");
            return false;
        }

        ArrayList<Loan> loanHistory = library.getLoanHistory(br);

        if (loanHistory == null || loanHistory.isEmpty()) {
            System.out.println("대출 기록이 없습니다.");
            return false;
        }

        System.out.println("=== Loan History Collection ===");
        System.out.println("Borrower: " + br.toString());
        for (Loan loan : loanHistory) {
            System.out.println("  - Loan Details:");
            System.out.println("      Book: " + loan.getBook().toString());
            System.out.println("      Loan Date: " + loan.getLoanDateTime());
            System.out.println("      Due Date: " + loan.getDueDateTime());
        }
        return true;
    }

}
