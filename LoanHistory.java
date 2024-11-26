package LibraryApplication;

import java.util.ArrayList;
import java.util.List;

public class LoanHistory {
    private List<Loan> loanRecords;
    
    public LoanHistory() {
        loanRecords = new ArrayList<>();
    }
    
    public void addLoanRecord(Loan loan) {
        loanRecords.add(loan);
    }
    
    public List<Loan> getLoanRecords() {
        return loanRecords;
    }
    
    public List<Loan> getBorrowerHistory(Borrower borrower) {
        List<Loan> borrowerLoans = new ArrayList<>();
        for (Loan loan : loanRecords) {
            if (loan.getBorrower().equals(borrower)) {
                borrowerLoans.add(loan);
            }
        }
        return borrowerLoans;
    }
    
    public List<Loan> getBookHistory(Book book) {
        List<Loan> bookLoans = new ArrayList<>();
        for (Loan loan : loanRecords) {
            if (loan.getBook().equals(book)) {
                bookLoans.add(loan);
            }
        }
        return bookLoans;
    }
}
