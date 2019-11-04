package com.masglobalconsulting.javatest.vo;


import com.masglobalconsulting.javatest.util.ContractInt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    public enum CONTRACT_TYPE {
        HOURLY, MONTHLY
    }

    private CONTRACT_TYPE contractType;
    private ContractInt contract;
    private double paymentRate;
    private String fullName;
    private Long id;

    public double getSalary(){
        return contract.calculateSalary();
    }

}
