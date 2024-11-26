package LibraryApplication;

// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;

public class LibraryApplication {
    private Library library;
    
    public LibraryApplication() { // 생성자
        this.library = new Library();
    }
    
    // 도서 등록
    public boolean registerBook(String title, String author, int catalogueNumber) {
        Book newBook = new Book(title, author, catalogueNumber);
        return library.addBook(newBook);
    }
    
    // 대출자 등록
    public boolean registerBorrower(String name) {
        Borrower newBorrower = new Borrower(name);
        return library.addBorrower(newBorrower);
    }
    
    // 도서 대출
    public boolean borrowBook(Book book, Borrower borrower) {
        if (!library.getBooks().contains(book)) {
            return false;
        }
        
        // 추후 구현 예정: 날짜 관련 기능
        // 현재 날짜와 반납 예정일(2주 후) 설정
        // LocalDate now = LocalDate.now();
        // LocalDate dueDate = now.plusWeeks(2);
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // 추후 구현 예정: 날짜 정보는 임시로 null 처리
        Loan loan = new Loan(book, borrower, null, null);
        
        library.getLoans().add(loan);
        return true;
    }
    
    // 도서 반납
    public boolean returnBook(Book book) {
        if (!book.isOnLoan()) {  // 대출 중이 아닌 경우
            return false;
        }
        
        for (Loan loan : library.getLoans()) {
            if (loan.getBook().equals(book)) {
                book.setCurrentLoan(null);  // Book의 대출 상태만 초기화
                return true;
            }
        }
        return false;
    }
    
    // 대출 가능한 도서 목록 표시
    public void displayAvailableBooks() {
        System.out.println("=== 대출 가능한 도서 목록 ===");
        boolean hasAvailableBooks = false;
        
        for (Book book : library.getBooks()) {
            if (!book.isOnLoan()) {  // returnBook() 메소드와 동일한 방식으로 확인
                System.out.println(book.toString());
                hasAvailableBooks = true;
            }
        }
        
        if (!hasAvailableBooks) {
            System.out.println("현재 대출 가능한 도서가 없습니다.");
        }
    }

    // 대출중인 도서 목록 표시
    public void displayBorrowedBooks() {
        System.out.println("=== 대출중인 도서 목록 ===");
        boolean hasBorrowedBooks = false;

        for (Book book : library.getBooks()) {
            if (book.isOnLoan()) {
                System.out.println(book.toString());
                hasBorrowedBooks = true;
            }
        }

        if (!hasBorrowedBooks) {
            System.out.println("현재 대출중인 도서가 없습니다.");
        }
    }
}
