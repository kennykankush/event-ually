package nus.iss.event_ually.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Size(min = 3, message="Min 3 Characters")
    private String fullName;

    @Past(message="Must be past")
    private LocalDate birthday;

    @Email(message="type in an email please")
    private String email;

    @NotNull(message = "please type something")
    private Integer mobileNumber;

    private int tickets;

    private String registeredEvent;
    
    @Override
    public String toString() {
        return "User [fullName=" + fullName + ", birthday=" + birthday + ", email=" + email + ", mobileNumber="
                + mobileNumber + ", tickets=" + tickets + ", registeredEvent=" + registeredEvent + "]";
    }

    public String getRegisteredEvent() {
        return registeredEvent;
    }

    public void setRegisteredEvent(String registeredEvent) {
        this.registeredEvent = registeredEvent;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public int getTickets() {
        return tickets;
    }
    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

}
