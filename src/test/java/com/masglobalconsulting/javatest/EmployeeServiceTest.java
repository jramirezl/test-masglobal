package com.masglobalconsulting.javatest;

import com.masglobalconsulting.javatest.repository.EmployeeMockedRepository;
import com.masglobalconsulting.javatest.service.EmployeesService;
import com.masglobalconsulting.javatest.util.ContractCreatorAbs;
import com.masglobalconsulting.javatest.util.FactoryMethodContract;
import com.masglobalconsulting.javatest.vo.EmployeeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private ContractCreatorAbs contractCreator;
    @Mock
    private EmployeeMockedRepository employeeMockedRepository ;

    private EmployeesService employeesService;

    @BeforeEach
    void initUseCase() {
        contractCreator = new FactoryMethodContract();
        employeesService = new EmployeesService(contractCreator, employeeMockedRepository);
    }

    @Test
    void calculateSalaryForTheGivenHourlyContract() {
        Long id = 1l;
        Double expectedVal =(double) 100 *120 * 12;

        EmployeeDTO employeeDTO = EmployeeDTO.builder().id(1l).contractType(EmployeeDTO.CONTRACT_TYPE.HOURLY)
                .paymentRate(100).fullName("Tets tets").build();

        Mockito.when(employeeMockedRepository.findById(1L))
                .thenReturn(employeeDTO);

        EmployeeDTO actualVal = employeesService.findById(1L);

        assertThat(actualVal.getSalary())
                .isEqualTo(expectedVal);
    }

    @Test
    void calculateSalaryForTheGivenMonthlyContract() {
        Long id = 1l;
        Double expectedVal =(double) 100 * 12;

        EmployeeDTO employeeDTO = EmployeeDTO.builder().id(1l).contractType(EmployeeDTO.CONTRACT_TYPE.MONTHLY)
                .paymentRate(100).fullName("Tests tests").build();

        Mockito.when(employeeMockedRepository.findById(1L))
                .thenReturn(employeeDTO);

        EmployeeDTO actualVal = employeesService.findById(1L);

        assertThat(actualVal.getSalary())
                .isEqualTo(expectedVal);
    }

    @Test
    void calculateSalaryForTheGivenListRetrievesAListAndCaluclatesSalary() {
        Long id = 1l;

        Double expectedValMonthly =(double) 100 * 12;
        Double expectedValHourly =(double) 200 * 12 *  120;


        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        EmployeeDTO employeeDTO1 = EmployeeDTO.builder().id(1l).contractType(EmployeeDTO.CONTRACT_TYPE.MONTHLY)
                .paymentRate(100).fullName("Tests tests").build();
        EmployeeDTO employeeDTO2 = EmployeeDTO.builder().id(2l).contractType(EmployeeDTO.CONTRACT_TYPE.HOURLY)
                .paymentRate(200).fullName("Tests2 tests2").build();

        employeeDTOS.add(employeeDTO1);
        employeeDTOS.add(employeeDTO2);

        Mockito.when(employeeMockedRepository.getEmployeeList())
                .thenReturn(employeeDTOS);

        List<EmployeeDTO> employeeDTOSActual  = employeesService.getEmployeeList();

        assertThat(employeeDTOSActual.size())
                .isEqualTo(2);
        assertThat(employeeDTOSActual.get(0).getId())
                .isEqualTo(1L);
        assertThat(employeeDTOSActual.get(1).getId())
                .isEqualTo(2L);

        assertThat(employeeDTOSActual.get(0).getSalary())
                .isEqualTo(expectedValMonthly);
        assertThat(employeeDTOSActual.get(1).getSalary())
                .isEqualTo(expectedValHourly);
    }
}
