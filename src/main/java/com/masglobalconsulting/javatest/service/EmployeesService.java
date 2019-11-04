package com.masglobalconsulting.javatest.service;


import com.masglobalconsulting.javatest.repository.EmployeeMockedRepository;
import com.masglobalconsulting.javatest.util.ContractCreatorAbs;
import com.masglobalconsulting.javatest.vo.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {

    private ContractCreatorAbs contractCreator;
    private EmployeeMockedRepository employeeMockedRepository;

    public EmployeesService(ContractCreatorAbs contractCreator, EmployeeMockedRepository employeeMockedRepository) {
        this.contractCreator = contractCreator;
        this.employeeMockedRepository = employeeMockedRepository;
    }

    /**
     *  Method that retrieves all the employees and then get the contract specific for the contract
     *  with Big-O O(n) time, it will take n steps to calculate and assign  the proper Contract Salary
     *  calculator to each EmployeeDTO retrieved
     *
     * @return
     */
    public List<EmployeeDTO> getEmployeeList() {
        List<EmployeeDTO> list = employeeMockedRepository.getEmployeeList();
        list.stream().forEach(el -> el.setContract(contractCreator.createConcreteContract(el)));
        return list;
    }

    public EmployeeDTO findById(Long id) {
        EmployeeDTO employeeDTO = employeeMockedRepository.findById(id);
        if(employeeDTO != null){
            employeeDTO.setContract(contractCreator.createConcreteContract(employeeDTO));
        }
        return employeeDTO;
    }

}
