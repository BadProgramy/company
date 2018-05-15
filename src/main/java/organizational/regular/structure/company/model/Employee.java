package organizational.regular.structure.company.model;

import organizational.regular.structure.company.model.exception.DataFormatException;
import organizational.regular.structure.company.model.exception.FormatException;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Employee {
    private int id;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String floor;
    private LocalDate birthDate;
    private String contactNumber;
    private String email;
    private LocalDate reception;
    private LocalDate layoff;
    private String post;
    private double salary;
    private boolean head;
    private static final String VALIDATE_NAME = "Мухутдинов Айрат";
    private static final String VALIDATE_NUMBER_PHONE = "89123236578 || 8 912 3236578 || 8(912)3236578";
    private static final String VALIDATE_EMAIL = "example@yandex.ru";
    private static final String REGULAR_NAME = "[А-ЯЁ][а-яё]+\\\\s?|[А-ЯЁ][а-яё]+\\\\s?-+[А-ЯЁ][а-яё]+\\\\s?";
    private static final String REGULAR_NUMBER_PHONE = "^([0-9\\\\(\\\\)\\\\/\\\\+ \\\\-]*)$";
    private static final String REGULAR_EMAIL = "^([a-z0-9_-]+\\\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\\\.[a-z0-9_-]+)*\\\\.[a-z]{2,6}$";

    public Employee(String firstName, String secondName, String floor, LocalDate birthDate,
                    String contactNumber, String email, LocalDate reception, String post, double salary, boolean head) throws Exception {
        if (!validationName(firstName) || !validationName(secondName)) throw new FormatException(VALIDATE_NAME);
        if (!validationNumberPhone(contactNumber)) throw new FormatException(VALIDATE_NUMBER_PHONE);
        if (!validationEmail(email)) throw new FormatException(VALIDATE_EMAIL);
        if (reception.compareTo(birthDate)< 0) throw new DataFormatException("Дата приема на работу < даты рождения");
        if (layoff.compareTo(reception) < 0) throw new DataFormatException("Дата увольнения < даты приема");
        this.firstName = firstName;
        this.secondName = secondName;
        this.floor = floor;
        this.birthDate = birthDate;
        this.contactNumber = contactNumber;
        this.email = email;
        this.reception = reception;
        this.post = post;
        this.salary = salary;
        this.head = head;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getReception() {
        return reception;
    }

    public void setReception(LocalDate reception) {
        this.reception = reception;
    }

    public LocalDate getLayoff() {
        return layoff;
    }

    public void setLayoff(LocalDate layoff) {
        this.layoff = layoff;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isHead() {
        return head;
    }

    public void setHead(boolean head) {
        this.head = head;
    }

    private boolean validationName(String name){
        return Pattern.compile(REGULAR_NAME).matcher(name).matches();
    }

    private boolean validationNumberPhone(String contactNumber){
        return Pattern.compile(REGULAR_NUMBER_PHONE).matcher(contactNumber).matches();
    }

    private boolean validationEmail(String email){
        return Pattern.compile(REGULAR_EMAIL).matcher(email).matches();
    }
}
