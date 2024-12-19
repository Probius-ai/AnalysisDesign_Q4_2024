import java.time.LocalDateTime;

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
}