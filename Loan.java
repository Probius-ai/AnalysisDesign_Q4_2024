package LibraryApplication;

public class Loan {
    private Book book;
    private Borrower borrower;
    // 추후 구현 예정: 대출 날짜와 반납 예정일 필드
    // private String loanDate;
    // private String dueDate;
    
    // 생성자
    public Loan(Book book, Borrower borrower, String loanDate, String dueDate) {
        this.book = book;
        this.borrower = borrower;
        // 추후 구현 예정: 대출 날짜와 반납 예정일 설정
        // this.loanDate = loanDate;
        // this.dueDate = dueDate;
    }
    
    // Getter와 Setter 메소드들
    public Book getBook() {
        return book;
    }
    
    public Borrower getBorrower() {
        return borrower;
    }
    
    /*
     * 추후 구현 예정: 대출 날짜 조회 기능
     * public String getLoanDate() {
     *     return loanDate;
     * }
     */
    
    /*
     * 추후 구현 예정: 반납 예정일 조회 기능
     * public String getDueDate() {
     *     return dueDate;
     * }
     */
}
