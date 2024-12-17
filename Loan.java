import java.time.LocalDateTime;

public class Loan {
    private Book book;
    private Borrower borrower;
    private LocalDateTime loanDateTime; // 대출 시작 시간
    private LocalDateTime dueDateTime;  // 반납 기한 시간
    
    // 상수: 대출 기한 (15일 -> 시간 단위로 변환: 15 * 24)
    private static final int DEFAULT_LOAN_PERIOD_HOURS = 15 * 24;

    // 생성자
    public Loan(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
        this.loanDateTime = LocalDateTime.now(); // 현재 날짜 및 시간
        this.dueDateTime = loanDateTime.plusHours(DEFAULT_LOAN_PERIOD_HOURS); // 15일 후 날짜 및 시간
    }

    // 반납 기한 조회
    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    // 대출 시작 시간 조회
    public LocalDateTime getLoanDateTime() {
        return loanDateTime;
    }
    
    // Getter와 Setter 메소드들
    public Book getBook() {
        return book;
    }
    
    public Borrower getBorrower() {
        return borrower;
    }

    public void deleteLink() {
        book.setOnLoan(false);
        borrower.decrementBorrowedBooks();

        this.book = null;
        this.borrower = null;
    }
}
