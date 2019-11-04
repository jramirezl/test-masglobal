package com.masglobalconsulting.javatest.util;

import com.masglobalconsulting.javatest.vo.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public class FactoryMethodContract extends ContractCreatorAbs {

    public ContractInt createConcreteContract(EmployeeDTO employeeDTO){
        if(employeeDTO.getContractType()  ==  EmployeeDTO.CONTRACT_TYPE.HOURLY){
            return HourlyContract.builder().hourlySalary(employeeDTO.getPaymentRate()).build();
        }else{
            return MonthlyContract.builder().monthlySalary(employeeDTO.getPaymentRate()).build();
        }
    }

}
