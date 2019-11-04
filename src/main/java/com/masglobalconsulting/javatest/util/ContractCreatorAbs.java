package com.masglobalconsulting.javatest.util;

import com.masglobalconsulting.javatest.vo.EmployeeDTO;

public abstract class ContractCreatorAbs {

    public abstract ContractInt createConcreteContract(EmployeeDTO employeeDTO);
}
