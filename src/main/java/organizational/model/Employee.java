package organizational.model;


import organizational.model.exception.DataFormatException;
import organizational.model.exception.FormatException;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Employee {
    private int id;
    private int idPost;
    private int idDepartment;
    private String firstName;
    private String secondName;
    private String thirdName;
    private Character floor;
    private LocalDate birthDate;
    private String contactNumber;
    private String email;
    private LocalDate reception;
    private LocalDate layoff;
    private float salary;
    private boolean head;
    private static final String DEFAULT_DATE_SPLIT_CHAR = "-";
    private static final String VALIDATE_NAME = "Ф - Мухутдинов; И - Айрат; О - Анварович";
    private static final String VALIDATE_NUMBER_PHONE = "89123236578 || 8 912 3236578 || 8(912)3236578";
    private static final String VALIDATE_EMAIL = "example@yandex.ru";
    private static final String VALIDATE_DATE = "ГГГГ-ММ-ДД (2018-05-16)";
    private static final String REGULAR_NAME = "[А-ЯЁ][а-яё]+\\s?|[А-ЯЁ][а-яё]+\\s?-+[А-ЯЁ][а-яё]+\\s?";
    private static final String REGULAR_NUMBER_PHONE = "^([0-9\\(\\)\\/\\+ \\-]*)$";
    private static final String REGULAR_EMAIL = "^[a-zA-Z0-9_\\.\\-]+@([a-zA-Z0-9][a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,6}$";

    public Employee() {
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

    public void setFirstName(String firstName) throws FormatException {
        if (!validationName(firstName)) throw new FormatException(VALIDATE_NAME);
        else this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) throws FormatException {
        if (!validationName(secondName)) throw new FormatException(VALIDATE_NAME);
        else this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) throws FormatException {
        if (!validationName(thirdName)) throw new FormatException(VALIDATE_NAME);
        else this.thirdName = thirdName;
    }

    public Character getFloor() {
        return floor;
    }

    public void setFloor(Character floor) {
        this.floor = floor;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) throws DataFormatException {
        try{
        String[] birthDateSplit = birthDate.split(DEFAULT_DATE_SPLIT_CHAR);
        this.birthDate = LocalDate.of(Integer.parseInt((birthDateSplit[0])),
                Integer.parseInt(birthDateSplit[1]),Integer.parseInt(birthDateSplit[2]));
        } catch (Exception ex){
            throw new DataFormatException(VALIDATE_DATE);
        }
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) throws FormatException {
        if (!validationNumberPhone(contactNumber)) throw new FormatException(VALIDATE_NUMBER_PHONE);
        else this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws FormatException {
        if (!validationEmail(email)) throw new FormatException(VALIDATE_EMAIL);
        else this.email = email;
    }

    public LocalDate getReception() {
        return reception;
    }

    public void setReception(String reception) throws DataFormatException {
        try{
            String[] receptionDateSplit = reception.split(DEFAULT_DATE_SPLIT_CHAR);
            LocalDate date = LocalDate.of(Integer.parseInt((receptionDateSplit[0])),
                    Integer.parseInt(receptionDateSplit[1]), Integer.parseInt(receptionDateSplit[2]));
            if (date.compareTo(birthDate)< 0) throw new DataFormatException();
            else this.reception = date;
        }catch (DataFormatException ex){
            throw new DataFormatException("Дата приема на работу < даты рождения");
        }
        catch (Exception ex){
            throw new DataFormatException(VALIDATE_DATE);
        }
    }

    public LocalDate getLayoff() {
        return layoff;
    }

    public void setLayoff(String layoff) throws DataFormatException {
        try{
            String[] layoffDateSplit = layoff.split(DEFAULT_DATE_SPLIT_CHAR);
            LocalDate date = LocalDate.of(Integer.parseInt((layoffDateSplit[0])),
                    Integer.parseInt(layoffDateSplit[1]), Integer.parseInt(layoffDateSplit[2]));
            if (date.compareTo(reception) < 0) throw new DataFormatException();
            else this.layoff = date;
        } catch (DataFormatException ex){
            throw new DataFormatException("Дата увольнения < даты приема");
        }
        catch (Exception ex){
            throw new DataFormatException(VALIDATE_DATE);
        }
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isHead() {
        return head;
    }

    public void setHead(boolean head) {
        this.head = head;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public void updateEmployee(Employee employee){ // я устал и поэтому оставил так :(
        if (employee.getIdPost() != 0)
            idPost = employee.getIdPost();
        if (employee.getIdDepartment() != 0)
            idDepartment = employee.getIdDepartment();
        if (employee.getFirstName()!=null)
            firstName = employee.getFirstName();
        if (employee.getSecondName() != null)
            secondName = employee.getSecondName();
        if (employee.getThirdName() != null)
            thirdName = employee.getThirdName();
        if (employee.getFloor() != null)
            floor = employee.getFloor();
        if (employee.getBirthDate() != null)
            birthDate = employee.getBirthDate();
        if (employee.getContactNumber() != null)
            contactNumber = employee.getContactNumber();
        if (employee.getEmail() != null)
            email = employee.getEmail();
        if (employee.getReception() != null)
            reception = employee.getReception();
        if (employee.getLayoff() != null)
            layoff = employee.getLayoff();
        if (employee.getSalary() != 0)
            salary = employee.getSalary();
        if (employee.isHead() != head)
            head = employee.isHead();
    }

    /*public void layoffEmployee(LocalDate layoffDate) { //здесь не нужна проверка, она уже в set
        layoff = layoffDate;
        idDepartment = 0;//надо было, для уволенных сотрудников сделать отдельную таблицу, либо менять sql запросы
        //Но в тз небыло такого :)
        //idPost = 0;//лучше должность оставить
    }*/

    private boolean validationName(String name){
        return Pattern.compile(REGULAR_NAME).matcher(name).matches();
    }

    private boolean validationNumberPhone(String contactNumber){
        return Pattern.compile(REGULAR_NUMBER_PHONE).matcher(contactNumber).matches();
    }

    private boolean validationEmail(String email){
        return Pattern.compile(REGULAR_EMAIL).matcher(email).matches();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", idPost=" + idPost +
                ", idDepartment=" + idDepartment +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", floor=" + floor +
                ", birthDate=" + birthDate +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", reception=" + reception +
                ", layoff=" + layoff +
                ", salary=" + salary +
                ", head=" + head +
                '}';
    }
}
