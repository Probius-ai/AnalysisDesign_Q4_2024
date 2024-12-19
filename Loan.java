public class Loan {
    private Book book;
    private Borrower borrower;

    // 생성자
    public Loan(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
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