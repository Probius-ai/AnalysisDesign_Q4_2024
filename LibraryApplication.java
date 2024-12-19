import java.util.ArrayList;
import java.util.Iterator;

public class LibraryApplication {
    private Library library = new Library("Library");

    // 대출자 등록
    public boolean registerBorrower(String name, String birthDate) {
        Borrower borrower = new Borrower(name, birthDate);
        boolean isDuplicate = library.isDuplicateBorrower(borrower);

        if (!isDuplicate) {
            library.addBorrower(borrower);
        }

        return !isDuplicate;
    }

    // 도서 등록
    public boolean registerBook(String title, String author, int uniqueNumber) {
        Book book = new Book(title, author, uniqueNumber);
        boolean isDuplicate = library.isDuplicateBook(book);

        if (!isDuplicate) {
            library.addBook(book);
        }

        return !isDuplicate;
    }

    // 대출 가능한 도서 목록 표시
    public String displayLoanableBooks() {
        StringBuilder result = new StringBuilder("=== 대출 가능한 도서 목록 ===\n\n");
        boolean hasAvailableBooks = false;

        Iterator<Book> iter = library.getBookCollection().iterator();
        while (iter.hasNext() == true) {
            Book book = (Book)iter.next();
            if (book.isAvailable()) {
                String[] bookInfo = book.returnBookInfo();
                result.append(String.format("제목: %s\n저자: %s\n고유번호: %s\n\n",
                        bookInfo[0], bookInfo[1], bookInfo[2]));
                hasAvailableBooks = true;
            }
        }
        return hasAvailableBooks ? result.toString() : "";
    }

    // 대출중인 도서 목록 표시
    public String displayOnLoanBooks() {
        StringBuilder result = new StringBuilder("=== 대출중인 도서 목록 ===\n\n");
        boolean hasBorrowedBooks = false;

        Iterator<Book> iter = library.getBookCollection().iterator();
        while (iter.hasNext() == true) {
            Book book = (Book) iter.next();
            if (!book.isAvailable()) {
                String[] bookInfo = book.returnBookInfo();
                result.append(String.format("제목: %s\n저자: %s\n고유번호: %s\n\n",
                        bookInfo[0], bookInfo[1], bookInfo[2]));
                hasBorrowedBooks = true;
            }
        }
        return hasBorrowedBooks ? result.toString() : "";
    }

    // 도서 대출
    public boolean borrowBook(int uniqueNumber, String name, String birthDate) {
        Book book = library.findBookByUniqueNumber(uniqueNumber);
        Borrower borrower = library.findBorrowerByNameAndBirthDate(name, birthDate);

        if (book != null && borrower != null && book.isAvailable() && borrower.isAvailable()) {
            Loan loan = new Loan(book, borrower);
            library.addLoanToHistory(borrower, book);

            book.setOnLoan(true);
            borrower.incrementBorrowedBooks();
            library.addLoan(loan);
            return true;
        } else {
            return false;
        }
    }

    // 도서 반납
    public boolean returnBook(int uniqueNumber, String name, String birthDate) {
        Book book = library.findBookByUniqueNumber(uniqueNumber);
        Borrower borrower = library.findBorrowerByNameAndBirthDate(name, birthDate);
        Loan loan = library.findLoanByBookAndBorrower(book, borrower);

        if (loan != null) {
            loan.deleteLink();
            return true;
        } else {
            return false;
        }
    }

    // LibraryApplication 클래스
    public ArrayList<LoanHistory> displayLoanHistory(String name, String birthDate) {
        Borrower borrower = library.findBorrowerByNameAndBirthDate(name, birthDate);

        if (borrower == null) {
            return null;
        }

        ArrayList<LoanHistory> loanHistory = library.getLoanHistory(borrower);

        if (loanHistory == null || loanHistory.isEmpty()) {
            return new ArrayList<>();
        }

        return loanHistory;
    }
}