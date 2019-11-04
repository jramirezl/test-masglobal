package com.masglobalconsulting.javatest.util;

import com.masglobalconsulting.javatest.util.ContractInt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyContract implements ContractInt {
    private double monthlySalary;

    @Override
    public Double calculateSalary() {
        return monthlySalary * Constants.MONTHS_PER_YEAR;
    }
}
