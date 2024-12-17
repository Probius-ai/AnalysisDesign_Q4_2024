import java.util.*;

public class Library {
    private TreeSet<Book> bookCollection;
    private HashSet<Borrower> borrowerCollection;
    private LinkedList<Loan> loanCollection;

    public Library() { // 생성자
        bookCollection = new TreeSet<>();
        borrowerCollection = new HashSet<>();
        loanCollection = new LinkedList<>();
    }


    // 도서 관리 메소드
    public boolean addBook(Book book) { // 도서 추가
        return bookCollection.add(book);
    }

    public boolean removeBook(Book book) { // 도서 삭제
        return bookCollection.remove(book);
    }

    // public Book findBookByCatalogueNumber(int catalogueNumber) { // 도서 찾기
    //     for (Book book : booksCollection) {
    //         if (book.getBookUniqueNumber() == catalogueNumber) {
    //             return book;
    //         }
    //     }
    //     return null;
    // }

    // 대출자 관리 메소드
    public boolean addBorrower(Borrower borrower) { // 대출자 추가
        return borrowerCollection.add(borrower);
    }

    public boolean removeBorrower(Borrower borrower) { // 대출자 삭제
        return borrowerCollection.remove(borrower);
    }


    public TreeSet<Book> getBookCollection() {
        return bookCollection;
    }
    
    public HashSet<Borrower> getBorrowerCollection() {
        return borrowerCollection;
    }

    public LinkedList<Loan> getLoanCollection() {
        return loanCollection;
    }


    // public Borrower findBorrowerByName(String name) { // 대출자 찾기
    //     for (Borrower borrower : borrowersCollection) {
    //         if (borrower.getName().equals(name)) {
    //             return borrower;
    //         }
    //     }
    //     return null;
    // }

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

    // public Loan findLoanByBook(Book book) {
    //     for (Loan loan : loansCollection) {
    //         if (loan.getBook().equals(book)) {
    //             return loan;
    //         }
    //     }
    //     return null;
    // }

    public boolean isDuplicateBook(Book book) {
        return bookCollection.contains(book);
    }

    public boolean isDuplicateBorrower(Borrower borrower) {
        return borrowerCollection.contains(borrower);
    }

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

    public void addLoan(Loan loan) {
        loanCollection.add(loan);
    }
}
