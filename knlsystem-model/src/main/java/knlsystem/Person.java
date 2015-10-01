/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knlsystem;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Formula;

/**
 *
 * @author julianr
 */
@Entity
@Table(name = "Per_Person_tb")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "per_id")
    private Integer perId;

    @Column(name = "per_first_name")
    private String firstName;

    @Column(name = "per_last_name")
    private String lastName;

    @Column(name = "per_middle_name")
    private String middleName;

    @Column(name = "per_type")
    private Character type;

    @Column(name = "per_email")
    private String email;

    @Column(name = "per_entry_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entryDate;

    @Column(name = "per_updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "per_active_flag")
    private boolean activeFlag;

    @Column(name = "per_gender")
    private String gender;

    @Column(name = "per_moodle_user_id")
    private int moodleUserId;

//    @JoinTable(name = "Ppn_Person_Phone_Number_tb", joinColumns = {
//        @JoinColumn(name = "per_id", referencedColumnName = "per_id")}, inverseJoinColumns = {
//        @JoinColumn(name = "phn_id", referencedColumnName = "phn_id")})
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<PhoneNumber> phoneNumbers;
//
//    @JoinTable(name = "Prg_Person_Group_tb", joinColumns = {
//        @JoinColumn(name = "per_id", referencedColumnName = "per_id")}, inverseJoinColumns = {
//        @JoinColumn(name = "grp_id", referencedColumnName = "grp_id")})
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<GroupSecurity> personGroups;
//
//    @JoinTable(name = "Pra_Person_Access_tb", joinColumns = {
//        @JoinColumn(name = "per_id", referencedColumnName = "per_id")}, inverseJoinColumns = {
//        @JoinColumn(name = "ifa_id", referencedColumnName = "ifa_id")})
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<InterfaceActionSecurity> personAccess;
//
//    @JoinTable(name = "Pre_Person_Restriction_tb", joinColumns = {
//        @JoinColumn(name = "per_id", referencedColumnName = "per_id")}, inverseJoinColumns = {
//        @JoinColumn(name = "ifa_id", referencedColumnName = "ifa_id")})
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<InterfaceActionSecurity> personRestrictions;
//
//    @JoinColumn(name = "per_id", referencedColumnName = "per_id_person")
//    @OneToMany(fetch = FetchType.LAZY)
//    private List<UnitAssignedPerson> unitsAssigned;
//
//    @Formula(value = "select usr.usr_id from Usr_User_tb usr where usr.usr_active_flag = 1 and usr.per_id_person = per_id")
//    private Integer activeUserId;
    public Person() {
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMoodleUserId() {
        return moodleUserId;
    }

    public void setMoodleUserId(int moodleUserId) {
        this.moodleUserId = moodleUserId;
    }

//    public List<PhoneNumber> getPhoneNumbers() {
//        return phoneNumbers;
//    }
//
//    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
//        this.phoneNumbers = phoneNumbers;
//    }
//
//    public List<GroupSecurity> getPersonGroups() {
//        return personGroups;
//    }
//
//    public void setPersonGroups(List<GroupSecurity> personGroups) {
//        this.personGroups = personGroups;
//    }
//
//    public List<InterfaceActionSecurity> getPersonAccess() {
//        return personAccess;
//    }
//
//    public void setPersonAccess(List<InterfaceActionSecurity> personAccess) {
//        this.personAccess = personAccess;
//    }
//
//    public List<InterfaceActionSecurity> getPersonRestrictions() {
//        return personRestrictions;
//    }
//
//    public void setPersonRestrictions(List<InterfaceActionSecurity> personRestrictions) {
//        this.personRestrictions = personRestrictions;
//    }
//
//    public List<UnitAssignedPerson> getUnitsAssigned() {
//        return unitsAssigned;
//    }
//
//    public void setUnitsAssigned(List<UnitAssignedPerson> unitsAssigned) {
//        this.unitsAssigned = unitsAssigned;
//    }
//
//    public Integer getActiveUserId() {
//        return activeUserId;
//    }
//
//    public void setActiveUserId(Integer activeUserId) {
//        this.activeUserId = activeUserId;
//    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.perId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.perId, other.perId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "perId=" + perId + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

}
