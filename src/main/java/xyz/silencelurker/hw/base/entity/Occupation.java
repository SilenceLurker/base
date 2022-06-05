package xyz.silencelurker.hw.base.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * 职务描述
 * </p>
 * 
 * @author Silence_Lurker
 * 
 */
@Entity
@Table(name = "t_occupation")
public class Occupation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int occupationId;
    private String occupation;

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setOccupationId(int occupationId) {
        this.occupationId = occupationId;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getOccupationId() {
        return occupationId;
    }
}
