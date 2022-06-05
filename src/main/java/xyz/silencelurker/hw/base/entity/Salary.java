package xyz.silencelurker.hw.base.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>
 * 薪水描述
 * </p>
 * 
 * @author Silence_Lurker
 */
@Entity
public class Salary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stuffId;
    private double basePay;
    private double subsidy;
    private double rewardSalary;
    private double check;
    private double insurance;
    private double accumulationFund;
    private double tax;
    private double other;

    public void setAccumulationFund(double accumulationFund) {
        this.accumulationFund = accumulationFund;
    }

    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    public void setCheck(double check) {
        this.check = check;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public void setRewardSalary(double rewardSalary) {
        this.rewardSalary = rewardSalary;
    }

    public void setStuffId(int stuffId) {
        this.stuffId = stuffId;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getAccumulationFund() {
        return accumulationFund;
    }

    public double getBasePay() {
        return basePay;
    }

    public double getCheck() {
        return check;
    }

    public double getInsurance() {
        return insurance;
    }

    public double getOther() {
        return other;
    }

    public double getRewardSalary() {
        return rewardSalary;
    }

    public int getStuffId() {
        return stuffId;
    }

    public double getSubsidy() {
        return subsidy;
    }

    /**
     * <p>
     * 当前是单纯的根据传入的值进行返回，后续将更改为按国内标准的换算方式进行计算。
     * </p>
     * 
     * 如果我的时间不够富裕了的话请忽略以上内容
     * 
     * @return double类型数据，
     */
    public double getTax() {
        // TODO:code a true tax countter
        return tax;
    }
}
