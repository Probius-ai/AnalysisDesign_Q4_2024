import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoanHistory {
    private Book book;
    private LocalDateTime loanDateTime; // 대출 시작 시간
    private LocalDateTime dueDateTime; // 반납 기한 시간

    // 생성자
    public LoanHistory(Book book) {
        this.book = book;
        this.loanDateTime = LocalDateTime.now();
        this.dueDateTime = loanDateTime.plusDays(15); // 반납 기한: 15일 후
    }

    // Getter
    public Book getBook() {
        return book;
    }

    public LocalDateTime getLoanDateTime() {
        return loanDateTime;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    @Override
    public String toString() {
        return "Book: " + book.getBookAuthor() +
                ", Loan Date: " + loanDateTime +
                ", Due Date: " + dueDateTime;
    }

    // public String[] returnLoanInfo() {
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시 mm분");

    //     return new String[] {
    //         book.returnBookInfo()[0],
    //         book.returnBookInfo()[1],
    //         book.returnBookInfo()[2],
    //         borrower.returnBorrowerInfo()[0],
    //         borrower.returnBorrowerInfo()[1],
    //         borrower.returnBorrowerInfo()[2],
    //         loanDateTime.format(formatter),
    //         dueDateTime.format(formatter)
    //     };
    // }
}
