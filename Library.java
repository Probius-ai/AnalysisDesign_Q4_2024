import java.util.*;

public class Library {
    private String name;
    private TreeSet<Book> bookCollection;
    private HashSet<Borrower> borrowerCollection;
    private LinkedList<Loan> loanCollection;

    public Library(String name) {
        this.name = name; 
        bookCollection = new TreeSet<>();
        borrowerCollection = new HashSet<>();
        loanCollection = new LinkedList<>();
    }


    // 컬렉션 추가 관련 메소드들
    public void addBook(Book book) { // 도서 추가
        bookCollection.add(book);
    }
    
    public void addBorrower(Borrower borrower) { // 대출자 추가
        borrowerCollection.add(borrower);
    }

    public void addLoan(Loan loan) { // 대출 객체 추가
        loanCollection.add(loan);
    }


    // 컬렉션 getter 메소드들
    public TreeSet<Book> getBookCollection() {
        return bookCollection;
    }
    
    public HashSet<Borrower> getBorrowerCollection() {
        return borrowerCollection;
    }

    public LinkedList<Loan> getLoanCollection() {
        return loanCollection;
    }


    // 중복 체크 관련 메소드들
    public boolean isDuplicateBook(Book book) {
        return bookCollection.contains(book);
    }

    public boolean isDuplicateBorrower(Borrower borrower) {
        return borrowerCollection.contains(borrower);
    }


    // 검색 관련 메소드들
    public Book findBookByUniqueNumber(int uniqueNumber) {
        for (Book book : bookCollection) {
            if (book.getBookUniqueNumber() == uniqueNumber) {
                return book;
            }
        }
        return null;
    }

    public Borrower findBorrowerByNameAndBirthDate(String name, String birthDate) {
        for (Borrower borrower : borrowerCollection) {
            if (borrower.getBorrowerName().equals(name) && borrower.getBirthDate().equals(birthDate)) {
                return borrower;
            }
        }
        return null;
    }

    public Loan findLoanByBookAndBorrower(Book book, Borrower borrower) {
        for (Loan loan : loanCollection) {
            if (loan.getBook().equals(book) && loan.getBorrower().equals(borrower)) {
                return loan;
            }
        }
        return null;
    }
}
