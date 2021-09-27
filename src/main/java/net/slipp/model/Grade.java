package net.slipp.model;

import javax.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private int gradeNum;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private User user;

    @ManyToOne
    @JoinColumn(name = "expert_num")
    private Expert expert;

    private int gradeScore;
    private String gradeContent;

    public int getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(int gradeNum) {
        this.gradeNum = gradeNum;
    }
}
