package com.masglobalconsulting.javatest.repository;

import com.masglobalconsulting.javatest.vo.EmployeeDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMockedRepository {

    List<EmployeeDTO> employeeDTOS;

    public EmployeeMockedRepository() {
        init();
    }

    public void init() {
        this.employeeDTOS = new ArrayList<>();

        employeeDTOS.add(EmployeeDTO.builder()
                .contractType(EmployeeDTO.CONTRACT_TYPE.HOURLY).fullName("Juan Jose").id(1L).paymentRate(200).build());

        employeeDTOS.add(EmployeeDTO.builder()
                .contractType(EmployeeDTO.CONTRACT_TYPE.HOURLY).fullName("Ana Ma").id(2L).paymentRate(150).build());

        employeeDTOS.add(EmployeeDTO.builder()
                .contractType(EmployeeDTO.CONTRACT_TYPE.MONTHLY).fullName("Chelo Fer").id(3L).paymentRate(1300).build());

        employeeDTOS.add(EmployeeDTO.builder()
                .contractType(EmployeeDTO.CONTRACT_TYPE.MONTHLY).fullName("Lelo Lope").id(4L).paymentRate(1700).build());


    }


    public List<EmployeeDTO> getEmployeeList() {
        return employeeDTOS;
    }

    public EmployeeDTO findById(Long id) {
        List<EmployeeDTO> list = employeeDTOS.stream().filter(e -> e.getId()==(id)).collect(Collectors.toList());
        return !list.isEmpty() ? list.get(0) : null;
    }

}
