import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LibraryApplication {
    private Library library = new Library("Library");
       
    // 대출자 등록
    public boolean registerBorrower(String name, String birthDate) {
        Borrower borrower = new Borrower(name, birthDate);
        boolean isDuplicate = library.isDuplicateBorrower(borrower);

        if (!isDuplicate) {
            library.addBorrower(borrower);
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
        
        for (Book book : library.getBookCollection()) {
            if (book.isAvailable()) { 
                book.display();
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
                book.display();
                hasBorrowedBooks = true;
            }
        }

        return hasBorrowedBooks;
    }

    // 도서 대출
    public boolean borrowBook(int uniqueNumber, String name, String birthDate) {
        Book book = library.findBookByUniqueNumber(uniqueNumber);
        Borrower borrower = library.findBorrowerByNameAndBirthDate(name, birthDate);

        if (book != null && borrower != null && book.isAvailable() && borrower.isAvailable()) {
            Loan loanForHistory = new Loan(book, borrower); // 대출 기록용 객체 생성
            Loan loanForSystem = new Loan(book, borrower); // 시스템용 객체 생성
            library.addLoanToHistory(borrower, loanForHistory);

            book.setOnLoan(true);
            borrower.incrementBorrowedBooks();
            library.addLoan(loanForSystem);
            return true;
        }  else {
            return false;
        }
    }
    
    // 도서 반납
    public boolean returnBook(int uniqueNumber, String name, String birthDate) {
        Book book = library.findBookByUniqueNumber(uniqueNumber);
        Borrower borrower = library.findBorrowerByNameAndBirthDate(name, birthDate);
        Loan loan = library.findLoanByBookAndBorrower(book, borrower);

        if (loan != null) {
            loan.deleteLink();
            return true;
        } else {
            return false;
        }
    }

    // LibraryApplication 클래스
    public boolean displayLoanHistory(String name, String birthDate) {
        Borrower borrower = library.findBorrowerByNameAndBirthDate(name, birthDate);

        if (borrower == null) {
            System.out.println("해당 대출자를 찾을 수 없습니다.");
            return false;
        }

        ArrayList<Loan> loanHistory = library.getLoanHistory(borrower);

        if (loanHistory == null || loanHistory.isEmpty()) {
            System.out.println("대출 기록이 없습니다.");
            return false;
        }

        // 날짜 및 시간 포맷터 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시 mm분");

        System.out.println("=== Loan History Collection ===");
        System.out.println("Borrower: " + borrower.toString());
        for (Loan loan : loanHistory) {
            System.out.println("  - Loan Details:");
            System.out.println("      Book: " + loan.getBook().toString());
            System.out.println("      대출일: " + loan.getLoanDateTime().format(formatter));
            System.out.println("      반납일: " + loan.getDueDateTime().format(formatter));
        }
        return true;
    }
}
