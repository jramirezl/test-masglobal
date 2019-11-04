package com.masglobalconsulting.javatest.controller;

import com.masglobalconsulting.javatest.service.EmployeesService;
import com.masglobalconsulting.javatest.vo.EmployeeDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employees-api")
public class ControllerEmployees {

    private EmployeesService employeesService;

    @Autowired
    public ControllerEmployees(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }


    @ApiOperation(
            value = "Retorna la lista de personas",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Restorna la lista de personas en JSON"),})
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<EmployeeDTO> findAll() {
        return employeesService.getEmployeeList();
    }



    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Restorna la una personas en JSON"),})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findById(@ApiParam(value = "ID of person to return", required = true) @PathVariable("id") String id) {
        EmployeeDTO employeeDTO = null;
        if (isValidLong(id)) {
            employeeDTO = employeesService.findById(Long.parseLong(id));
            if (employeeDTO != null) {
                return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se encontro id", HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(new EmployeeDTO(), HttpStatus.BAD_REQUEST);
    }

    boolean isValidLong(String longValue) {
        try {
            Long.parseLong(longValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}