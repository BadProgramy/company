package organizational.model;


import organizational.model.exception.DataFormatException;
import organizational.model.exception.FormatException;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Employee {
    private int id;
    private int idPost;
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
        }catch (DataFormatException ex){
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
