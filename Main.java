import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryApplication libraryApp = new LibraryApplication();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 도서관 관리 시스템 ===");
            System.out.println("1. 대출자 등록");
            System.out.println("2. 도서 등록");
            System.out.println("3. 대출 가능한 도서 목록 보기");
            System.out.println("4. 대출중인 도서 목록 보기");
            System.out.println("5. 도서 대출");
            System.out.println("6. 도서 반납");
            System.out.println("7. 종료");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1: // 대출자 등록
                    System.out.print("대출자 이름: ");
                    String borrowerName = scanner.nextLine();
                    System.out.print("대출자 생년월일(yymmdd): ");
                    String birthDate = scanner.nextLine();

                    boolean registeredBorrower = libraryApp.registerBorrower(borrowerName, birthDate);
                    if (registeredBorrower) {
                        System.out.println("대출자가 성공적으로 등록되었습니다.");
                    } else {
                        System.out.println("이미 존재하는 대출자입니다.");
                    }
                    break;

                case 2: // 도서 등록
                    System.out.print("도서 제목: ");
                    String title = scanner.nextLine();
                    System.out.print("도서 저자: ");
                    String author = scanner.nextLine();
                    System.out.print("도서 고유번호: ");
                    int uniqueNumber = scanner.nextInt();

                    boolean registeredBook = libraryApp.registerBook(title, author, uniqueNumber);
                    if (registeredBook) {
                        System.out.println("도서가 성공적으로 등록되었습니다.");
                    } else {
                        System.out.println("이미 존재하는 도서입니다.");
                    }
                    break;

                case 3: // 대출 가능한 도서 목록
                    if (!libraryApp.displayLoanableBooks()) {
                        System.out.println("대출 가능한 도서가 없습니다.");
                    }
                    break;

                case 4: // 대출중인 도서 목록
                    if (!libraryApp.displayOnLoanBooks()) {
                        System.out.println("대출중인 도서가 없습니다.");
                    }
                    break;

                case 5: // 도서 대출
                    System.out.print("대출할 도서의 고유번호: ");
                    int borrowBookNumber = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 처리
                    System.out.print("대출자 이름: ");
                    String borrowName = scanner.nextLine();
                    System.out.print("대출자 생년월일(yymmdd): ");
                    String borrowBirthDate = scanner.nextLine();

                    boolean borrowed = libraryApp.borrowBook(borrowBookNumber, borrowName, borrowBirthDate);
                    if (borrowed) {
                        System.out.println("도서가 성공적으로 대출되었습니다.");
                    } else {
                        System.out.println("대출에 실패했습니다. 도서나 대출자를 확인하세요.");
                    }
                    break;

                case 6: // 도서 반납
                    System.out.print("반납할 도서의 고유번호: ");
                    int returnBookNumber = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 처리
                    System.out.print("대출자 이름: ");
                    String returnName = scanner.nextLine();
                    System.out.print("대출자 생년월일(yymmdd): ");
                    String returnBirthDate = scanner.nextLine();

                    boolean returned = libraryApp.returnBook(returnBookNumber, returnName, returnBirthDate);
                    if (returned) {
                        System.out.println("도서가 성공적으로 반납되었습니다.");
                    } else {
                        System.out.println("반납에 실패했습니다. 입력 정보를 확인하세요.");
                    }
                    break;

                case 7: // 종료
                    System.out.println("도서관 관리 시스템을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해 주세요.");
            }
        }
    }
}
