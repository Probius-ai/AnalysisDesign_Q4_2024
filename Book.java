package LibraryApplication;

class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int catalogueNumber;
    private Loan currentLoan;
    
    public Book(String title, String author, int catalogueNumber) { // 생성자
        this.title = title;
        this.author = author;
        this.catalogueNumber = catalogueNumber;
        this.currentLoan = null;
    }
    
    // Getters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getCatalogueNumber() {
        return catalogueNumber;
    }
    
    // 대출 상태 확인 메소드
    public boolean isOnLoan() {
        return currentLoan != null;
    }
    
    // 대출 정보 설정 메소드
    public void setCurrentLoan(Loan loan) {
        this.currentLoan = loan;
    }
    
    @Override
    public String toString() {
        return "책 제목: " + title + ", 저자: " + author + ", 카탈로그 번호: " + catalogueNumber;
    }
    
    @Override
    public int compareTo(Book other) {
        // TODO: 카탈로그 번호 기준 정렬 구현 예정
        return this.catalogueNumber - other.catalogueNumber;
    }
}
