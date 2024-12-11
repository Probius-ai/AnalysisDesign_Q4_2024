import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class LibraryApplication {
    private Library library = new Library();
       
    // 대출자 등록
    public boolean registerBorrower(String name) {
        Borrower borrower = new Borrower(name);
        boolean isDuplicate = borrower.check(name);

        if (!isDuplicate) {
            library.addBorrower(borrower);
            return true;
        } else {
            return false;
        }
    }

    // 도서 등록
    public boolean registerBook(String title, String author, int uniqueNumber) {
        Book book = new Book(title, author, uniqueNumber);
        boolean isDuplicate = book.check(uniqueNumber);
        
        if (!isDuplicate) {
            library.addBook(book);
            return true;
        } else {
            return false;
        }
    }
    
    // 대출 가능한 도서 목록 표시
    public boolean displayLoanableBooks() {
        System.out.println("=== 대출 가능한 도서 목록 ===");
        boolean hasAvailableBooks = false;
        
        for (Book book : library.getBookCollection()) {
            if (!book.isOnLoan()) {  // returnBook() 메소드와 동일한 방식으로 확인
                System.out.println(book.toString());
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
            if (book.isOnLoan()) {
                System.out.println(book.toString());
                hasBorrowedBooks = true;
            }
        }
        return hasBorrowedBooks;
    }

    // 도서 대출
    public boolean borrowBook(int uniqueNumber, String name) {
        TreeSet<Book> bookCollection = library.getBookCollection();
        HashSet<Borrower> borrowerCollection = library.getBorrowerCollection();
        Book book = new Book("", "", 0);
        Borrower borrower = new Borrower("");

        for (Book b : bookCollection) { // 검색
            if (b.getUniqueNumber() == uniqueNumber) {
                book = b;
                break;
            }
        }

        for (Borrower br : borrowerCollection) { // 검색
            if (br.getName() == name) {
                borrower = br;
                break;
            }
        }

        boolean isLoanableBook = book.isOnLoan();
        boolean isLoanableBorrower = borrower.isAvailable();
        
        Loan loan = new Loan(book, borrower); // 객체 생성
        


        // 추후 구현 예정: 날짜 관련 기능
        // 현재 날짜와 반납 예정일(2주 후) 설정
        // LocalDate now = LocalDate.now();
        // LocalDate dueDate = now.plusWeeks(2);
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // 추후 구현 예정: 날짜 정보는 임시로 null 처리

        if (isLoanableBook && isLoanableBorrower) {
            // -> 여기에 생성한 loan 객체를 처리하는 코드가 필요
            return true;
        }  else {
            return false;
        }
    }
    
    // 도서 반납
    public boolean returnBook(int uniqueNumber, String name) {
        TreeSet<Book> bookCollection = library.getBookCollection();
        HashSet<Borrower> borrowerCollection = library.getBorrowerCollection();
        LinkedList<Loan> loanCollection = library.getLoanCollection();
        Book book;
        Borrower borrower;
        Loan loan;

        for (Book b : bookCollection) {
            if (b.getUniqueNumber() == uniqueNumber) {
                book = b;
                break;
            }
        }

        for (Borrower br : borrowerCollection) {
            if (br.getName() == name) {
                borrower = br;
                break;
            }
        }
        
        for (Loan l : loanCollection) {
            if (l.get) // ... ???
        }




        // for (Loan loan : library.getLoans()) {
        //     if (loan.getBook().equals(book)) {
        //         book.setCurrentLoan(null);  // Book의 대출 상태만 초기화
        //         return true;
        //     }
        // }
        // return false;
    }
}
