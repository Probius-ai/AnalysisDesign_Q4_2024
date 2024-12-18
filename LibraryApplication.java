import java.util.ArrayList;

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
    public String getLoanableBooks() {
        StringBuilder result = new StringBuilder("=== 대출 가능한 도서 목록 ===\n\n");
        boolean hasAvailableBooks = false;
        
        for (Book book : library.getBookCollection()) {
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
    public String getOnLoanBooks() {
        StringBuilder result = new StringBuilder("=== 대출중인 도서 목록 ===\n\n");
        boolean hasBorrowedBooks = false;
        
        for (Book book : library.getBookCollection()) {
            if (!book.isAvailable()) {
                String[] bookInfo = book.returnBookInfo();
                result.append(String.format("제목: %s\n저자: %s\n고유번호: %s\n\n", 
                    bookInfo[0], bookInfo[1], bookInfo[2]));
                hasBorrowedBooks = true;
            }
        }
        
        return hasBorrowedBooks ? result.toString() : "";
    }

    // public boolean displayOnLoanBooks() {
    //     System.out.println("=== 대출중인 도서 목록 ===");
    //     boolean hasBorrowedBooks = false;
    
    //     for (Book book : library.getBookCollection()) {
    //         if (!book.isAvailable()) {
    //             book.display();
    //             hasBorrowedBooks = true;
    //         }
    //     }

    //     return hasBorrowedBooks;
    // }

    // 도서 대출
    public boolean borrowBook(int uniqueNumber, String name, String birthDate) {
        Book book = library.findBookByUniqueNumber(uniqueNumber);
        Borrower borrower = library.findBorrowerByNameAndBirthDate(name, birthDate);

        if (book != null && borrower != null && book.isAvailable() && borrower.isAvailable()) {
            Loan loanForHistory = new Loan(book, borrower); // 대출 기록용 객체 생성
            Loan loanForSystem = new Loan(book, borrower); // 시스템용 객체 생성
            library.addLoanToHistory(borrower, loanForHistory);

            book.setOnLoan(true);
            borrower.incrementBorrowedBooks();
            library.addLoan(loanForSystem);
            return true;
        }  else {
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
    public boolean displayLoanHistory(String name, String birthDate) {
        Borrower borrower = library.findBorrowerByNameAndBirthDate(name, birthDate);

        if (borrower == null) {
            System.out.println("해당 대출자를 찾을 수 없습니다.");
            return false;
        }

        ArrayList<Loan> loanHistory = library.getLoanHistory(borrower);

        if (loanHistory == null || loanHistory.isEmpty()) {
            System.out.println("대출 기록이 없습니다.");
            return false;
        }

        System.out.println("=== Loan History Collection ===");
        borrower.display();
        for (Loan loan : loanHistory) {
            loan.display();
        }
        return true;
    }

    
}
