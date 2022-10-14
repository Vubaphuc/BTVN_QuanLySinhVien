import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("ID 1", "name 1", "năm sinh 1", Gender.FEMALE, 7500000);
        Employee employee2 = new Employee("ID 2", "name 2", "năm sinh 2", Gender.MALE, 8000000);
        Employee employee3 = new Employee("ID 3", "name 3", "năm sinh 3", Gender.FEMALE, 7200000);
        Employee employee4 = new Employee("ID 4", "name 4", "năm sinh 4", Gender.MALE, 6500000);
        Employee employee5 = new Employee("ID 5", "name 5", "năm sinh 5", Gender.FEMALE, 9500000);
        employee1.setId("NV01");
        employee2.setId("NV02");
        employee3.setId("NV03");
        employee4.setId("NV04");
        employee5.setId("NV05");
        employee1.setName("Phùng Văn Tài");
        employee2.setName("Trần Trung Dũng");
        employee3.setName("Hoàng Thị Mai");
        employee4.setName("Vũ Hoàng Liệt Thiên");
        employee5.setName("Phùng Thị Trang");
        employee1.setBirthDay("20/11/1991");
        employee2.setBirthDay("20/10/1992");
        employee3.setBirthDay("15/06/1995");
        employee4.setBirthDay("21/03/1994");
        employee5.setBirthDay("12/12/1990");
        employee1.setGender(Gender.FEMALE);
        employee2.setGender(Gender.MALE);
        employee3.setGender(Gender.FEMALE);
        employee4.setGender(Gender.MALE);
        employee5.setGender(Gender.FEMALE);
        employee1.setLương(7500000);
        employee2.setLương(8000000);
        employee3.setLương(7200000);
        employee4.setLương(6500000);
        employee5.setLương(9500000);

        Employee employees[] = {employee1, employee2 ,employee3, employee4, employee5};

        Scanner sc = new Scanner(System.in);

        System.out.println("Menu.........");
        System.out.println("1. Tìm nhân viên theo id ( tìm chính xác)");
        System.out.println("2. Tìm nhân viên theo tên ( tìm theo từ khoá, ví dụ: Nguyễn Văn A -> nhập A hoặc Văn => đều tìm ra được)");
        System.out.println("3. Đếm số nhân viên nam, nữ");
        System.out.println("4. Liệt kê các nhân viên trên 30 tuổi");
        System.out.println("5. Nhập từ bàn phím tháng bất kỳ trong năm; kiểm tra xem trong tháng đó có những nhân viên nào có ngày sinh nhật");
        System.out.println("6. In ra top 3 người có lương tháng cao nhất");
        System.out.println("0. Thoát Chương trình");
        int menu = sc.nextInt();
        sc.nextLine();
        String keyWord;
        switch (menu) {
            case 1:
                System.out.println("Tìm nhân viên theo ID(Nhập chính xác): ");
                keyWord = sc.nextLine();
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].getId().equals(keyWord)) {
                        System.out.println(employees[i].toString());
                    }
                }
                break;
            case 2:
                System.out.println("ìm nhân viên theo tên: ");
                keyWord = sc.nextLine();
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].getName().contains(keyWord)) {
                        System.out.println(employees[i].toString());
                    }
                }
                break;
            case 3:
                int nam = 0;
                int nu = 0;
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].getGender() == Gender.MALE) {
                        nam++;
                    }
                    if (employees[i].getGender() == Gender.FEMALE) {
                        nu++;
                    }
                }
                System.out.println("Số nhân viên nam là: " + nam + " Số Nhân Viên Nữ là: " + nu);
                break;
            case 4:
                System.out.println("các nhân viên trên 30 tuổi là: ");

                for (int i = 0; i < employees.length; i++) {
                    String ngaySinh = employees[i].getBirthDay();
                    LocalDate tuoi = LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    int tuoi1 = LocalDate.now().getYear() - tuoi.getYear();
                    if (tuoi1 > 30) {
                        System.out.println(employees[i].toString());
                    }
                }
                break;
            case 5:
                System.out.println("Nhập tháng cần tìm kiếm: ");
                keyWord = sc.nextLine();
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].getBirthDay().equals(keyWord)) {
                        System.out.println(employees[i].toString());
                    }
                }

                break;
            case 6:
                System.out.println("3 người có lương cao nhất là: ");
                Employee temp = null;
                for (int i = 0; i < employees.length - 1; i++) {
                    for (int j = 0; j < employees.length - i - 1; j++) {
                        if (employees[j].getLương() < employees[j + 1].getLương()) {
                            temp = employees[j];
                            employees[j] = employees[j + 1];
                            employees[j + 1] = temp;
                        }
                    }
                }
                for (int i = 0; i < employees.length - 2; i++) {
                    System.out.println(employees[i].toString());
                }
                break;
            case 0:
                System.out.println("Exit");
                System.exit(0);
                break;
        }
    }
}