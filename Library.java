import java.util.*;

public class Library {
    private TreeSet<Book> booksCollection;
    private HashSet<Borrower> borrowersCollection;
    private LinkedList<Loan> loansCollection;

    public Library() { // 생성자
        booksCollection = new TreeSet<>();
        borrowersCollection = new HashSet<>();
        loansCollection = new LinkedList<>();
    }

    // 도서 관리 메소드
    public boolean addBook(Book book) { // 도서 추가
        return booksCollection.add(book);
    }

    public boolean removeBook(Book book) { // 도서 삭제
        return booksCollection.remove(book);
    }

    public Book findBookByCatalogueNumber(int catalogueNumber) { // 도서 찾기
        for (Book book : booksCollection) {
            if (book.getBookUniqueNumber() == catalogueNumber) {
                return book;
            }
        }
        return null;
    }

    // 대출자 관리 메소드
    public boolean addBorrower(Borrower borrower) { // 대출자 추가
        return borrowersCollection.add(borrower);
    }

    public boolean removeBorrower(Borrower borrower) { // 대출자 삭제
        return borrowersCollection.remove(borrower);
    }

    public Borrower findBorrowerByName(String name) { // 대출자 찾기
        for (Borrower borrower : borrowersCollection) {
            if (borrower.getName().equals(name)) {
                return borrower;
            }
        }
        return null;
    }

    // // 대출 관리 메소드
    // public boolean addLoan(Loan loan) { // 대출 추가
    //     if (loansCollection.add(loan)) {
    //         loanHistory.addLoanRecord(loan);
    //         return true;
    //     }
    //     return false;
    // }

    // public boolean removeLoan(Loan loan) {
    //     return loansCollection.remove(loan);
    // }

    public Loan findLoanByBook(Book book) {
        for (Loan loan : loansCollection) {
            if (loan.getBook().equals(book)) {
                return loan;
            }
        }
        return null;
    }
}
